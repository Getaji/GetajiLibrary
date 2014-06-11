package mw.glib;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * 関数を順番に、falseか例外が返る限り連鎖的に実行し続けるクラスです。
 * 実行時にオブジェクトを渡すこともでき、渡し方は{@link ParamPassType}を利用します。
 * また、関数の実行前と実行後にそれぞれセットされたイベントリスナを呼び出します。
 *
 * @author Getaji
 */
public class ChainRunner {

    /**
     * メソッドへのパラメータオブジェクトの渡し方を指定するための列挙クラスです。
     */
    public static enum ParamPassType {

        /**
         * オブジェクトを渡しません。すべてnullを渡します。
         * 一度だけ実行します。
         */
        NONE((funcList, objList, runner) -> {
            for (Function<Object, Boolean> function : funcList) {
                if (process(function, null, runner)) {
                    return true;
                }
            }
            return false;
        }),

        /**
         * オブジェクトリストの最初のオブジェクトだけを使います。
         * 一度だけ実行します。
         */
        ONCE_FIRST((funcList, objList, runner) -> {
            Object giveObj = objList.size() == 0 ? null: objList.get(0);
            for (Function<Object, Boolean> function : funcList) {
                if (process(function, giveObj, runner)) {
                    return true;
                }
            }
            return false;
        }),

        /**
         * オブジェクトリストの最後のオブジェクトだけを使います。
         * 一度だけ実行します。
         */
        ONCE_LAST((funcList, objList, runner) -> {
            Object giveObj = objList.size() == 0 ? null: objList.get(objList.size() - 1);
            for (Function<Object, Boolean> function : funcList) {
                if (process(function, giveObj, runner)) {
                    return true;
                }
            }
            return false;
        }),

        /**
         * すべてのオブジェクトのぶん実行します。
         */
        SAME((funcList, objList, runner) -> {
            for (Object object : objList) {
                for (Function<Object, Boolean> function : funcList) {
                    if (process(function, object, runner)) {
                        return true;
                    }
                }
            }
            return false;
        }),

        /**
         * 保持するオブジェクトの先頭からそれぞれひとつのメソッドに渡します。
         * 余ったオブジェクトは切り捨てられ、足りない場合はnullが渡されます。
         */
        EACH((funcList, objList, runner) -> {
            for (int i = 0; i < funcList.size(); ++i) {
                Object giveObj = objList.size() <= i ? null : objList.get(i);
                if (process(funcList.get(i), giveObj, runner)) {
                    return true;
                }
            }
            return false;
        }),

        /**
         * 保持するオブジェクトの先頭からそれぞれひとつのメソッドに渡します。
         * オブジェクトの分実行され、足りない場合はその時点でfalseを返し終了します。
         */
        EACH_CUT((funcList, objList, runner) -> {
            for (int i = 0; i < objList.size(); ++i) {
                if (funcList.size() - 1 < i) return false;
                if (process(funcList.get(i), objList.get(i), runner)) {
                    return true;
                }
            }
            return false;
        }),

        /**
         * オブジェクトのリストをそのまま引数として渡します。
         * 一度だけ実行します。
         */
        DIRECT((funcList, objList, runner) -> {
            for (Function<Object, Boolean> function : funcList) {
                if (process(function, funcList, runner)) {
                    return true;
                }
            }
            return false;
        }),
        ;

        /**
         * ChainRunnerを実行する関数を管理
         */
        private final TriFunction<List<Function<Object, Boolean>>,
                List<Object>, ChainRunner, Boolean> runnerRunner;

        private ParamPassType(TriFunction<List<Function<Object, Boolean>>,
                List<Object>, ChainRunner, Boolean> runnerRunner) {
            this.runnerRunner = runnerRunner;
        }

        /**
         * 関数を実行します。例外が発生した場合はfalseを返します。
         *
         * @param function 実行する関数
         * @param param 渡すオブジェクト
         * @return 結果
         */
        private static boolean process(Function<Object, Boolean> function, Object param, ChainRunner runner) {
            boolean result;
            runner.onBeforeRunning(function, param);
            try {
                result = function.apply(param);
            } catch (Exception e) {
                result = false;
            }
            runner.onAfterRunning(function, param);
            return result;
        }

        /**
         * ChainRunnerを受け取って実行します。
         *
         * @param runner ChainRunner
         * @return 結果
         */
        public boolean run(ChainRunner runner) {
            return runnerRunner.apply(runner.functionList, runner.getObjectList(), runner);
        }
    }

    private final List<Function<Object, Boolean>> functionList = new LinkedList<>();
    private final List<Object> objectList = new LinkedList<>();
    private ParamPassType paramPassType = ParamPassType.NONE;
    private final List<BiConsumer<Function<Object, Boolean>, Object>> beforeRunningObservers = new LinkedList<>();
    private final List<BiConsumer<Function<Object, Boolean>, Object>> afterRunningObservers = new LinkedList<>();

    /**
     * ChainRunnerを生成します。
     * {@link ParamPassType}は{@link ParamPassType#NONE}が使われます。
     */
    public ChainRunner() {
        //
    }

    /**
     * {@link ParamPassType}を指定してChainRunnerを生成します。
     *
     * @param paramPassType オブジェクトを渡す方法
     */
    public ChainRunner(ParamPassType paramPassType) {
        this.paramPassType = paramPassType;
    }

    /**
     * 関数を追加します。
     *
     * @param function 関数
     */
    public ChainRunner addFunc(Function<Object, Boolean> function) {
        functionList.add(function);
        return this;
    }

    /**
     * 複数の関数を追加します。
     *
     * @param functions 複数の関数のコレクション
     */
    public ChainRunner addAllFunc(Collection<Function<Object, Boolean>> functions) {
        functionList.addAll(functions);
        return this;
    }

    /**
     * 関数を指定した位置に追加します。
     *
     * @param function 関数
     * @param index 追加する位置
     */
    public ChainRunner addFuncAt(Function<Object, Boolean> function, int index) {
        functionList.add(index, function);
        return this;
    }

    /**
     * 複数の関数を指定した位置に追加します。
     *
     * @param functions 複数の関数のコレクション
     * @param index 追加する位置
     */
    public ChainRunner addAllFuncAt(Collection<Function<Object, Boolean>> functions, int index) {
        functionList.addAll(index, functions);
        return this;
    }

    /**
     * 関数に渡すオブジェクトを追加します。
     *
     * @param obj オブジェクト
     */
    public ChainRunner addObject(Object obj) {
        objectList.add(obj);
        return this;
    }

    /**
     * 関数に渡すオブジェクトを複数追加します。
     *
     * @param objects 複数のオブジェクトのコレクション
     */
    public ChainRunner addAllObject(Collection<Object> objects) {
        objectList.addAll(objectList);
        return this;
    }

    /**
     * 関数に渡すオブジェクトを指定した位置に追加します。
     *
     * @param obj オブジェクト
     * @param index 追加する位置
     */
    public ChainRunner addObjectAt(Object obj, int index) {
        objectList.add(index, obj);
        return this;
    }

    /**
     * 関数に渡すオブジェクトを複数、指定した位置に追加します。
     *
     * @param objects 複数のオブジェクトのコレクション
     * @param index 追加する位置
     */
    public ChainRunner addAllObject(Collection<Object> objects, int index) {
        objectList.addAll(index, objectList);
        return this;
    }

    /**
     * 関数の連鎖実行を開始します。
     * 関数へのオブジェクトの渡し方については指定された{@link ParamPassType}によります。
     *
     * @return 途中で関数がtrueを返した場合はtrueを返す
     */
    public boolean run() {
        return paramPassType.run(this);
    }

    /**
     * 関数のリストを返します。
     *
     * @return 関数のリスト
     */
    public List<Function<Object, Boolean>> getFunctionList() {
        return functionList;
    }

    /**
     * 関数に渡すオブジェクトのリストを返します。
     *
     * @return 関数に渡すオブジェクトのリスト
     */
    public List<Object> getObjectList() {
        return objectList;
    }

    /**
     * 関数へのオブジェクトの渡し方を取得します。
     *
     * @return オブジェクトの渡し方
     */
    public ParamPassType getParamPassType() {
        return paramPassType;
    }

    /**
     * 関数へのオブジェクトの渡し方を設定します。
     *
     * @param paramPassType オブジェクトの渡し方
     */
    public ChainRunner setParamPassType(ParamPassType paramPassType) {
        this.paramPassType = paramPassType;
        return this;
    }

    /**
     * 関数の実行前に呼び出されるObserverのリストを返します。
     *
     * @return 実行前Observerのリスト
     */
    public List<BiConsumer<Function<Object, Boolean>, Object>>
    getBeforeRunningObservers() {
        return beforeRunningObservers;
    }

    /**
     * 関数の実行前に呼び出されるObserverを追加します。
     *
     * @param observer 実行前Observer
     * @return 自身のインスタンス
     */
    public ChainRunner addBeforeRunningObserver(
            BiConsumer<Function<Object, Boolean>, Object> observer) {
        beforeRunningObservers.add(observer);
        return this;
    }

    /**
     * 指定した実行前Observerを削除します。
     *
     * @param observer 実行前Observer
     * @return 自身のインスタンス
     */
    public ChainRunner removeBeforeRunningObserver(
            BiConsumer<Function<Object, Boolean>, Object> observer) {
        beforeRunningObservers.remove(observer);
        return this;
    }

    /**
     * すべての実行前Observerを削除します。
     *
     * @return 自身のインスタンス
     */
    public ChainRunner removeAllBeforeRunningObserver() {
        beforeRunningObservers.clear();
        return this;
    }

    /**
     * 関数の実行後に呼び出されるObserverのリストを返します。
     *
     * @return 実行後Observerのリスト
     */
    public List<BiConsumer<Function<Object, Boolean>, Object>>
    getAfterRunningObservers() {
        return afterRunningObservers;
    }

    /**
     * 関数の実行後に呼び出されるObserverを追加します。
     *
     * @param observer 実行後Observer
     * @return 自身のインスタンス
     */
    public ChainRunner addAfterRunningObserver(
            BiConsumer<Function<Object, Boolean>, Object> observer) {
        afterRunningObservers.add(observer);
        return this;
    }

    /**
     * 指定した実行後Observerを削除します。
     *
     * @param observer 実行後Observer
     * @return 自身のインスタンス
     */
    public ChainRunner removeAfterRunningObserver(
            BiConsumer<Function<Object, Boolean>, Object> observer) {
        afterRunningObservers.remove(observer);
        return this;
    }

    /**
     * すべての実行後Observerを削除します。
     *
     * @return 自身のインスタンス
     */
    public ChainRunner removeAllAfterRunningObserver() {
        afterRunningObservers.clear();
        return this;
    }

    /**
     * 関数の実行前に呼び出されるObserverをコールします。
     *
     * @param function 実行する関数
     * @param param 関数に渡されるパラメータ
     * @return 自身のインスタンス
     */
    public ChainRunner onBeforeRunning(Function<Object, Boolean> function, Object param) {
        for (BiConsumer<Function<Object, Boolean>, Object> consumer : beforeRunningObservers) {
            consumer.accept(function, param);
        }
        return this;
    }

    /**
     * 関数の実行後に呼び出されるObserverをコールします。
     *
     * @param function 実行された関数
     * @param param 関数に渡されたパラメータ
     * @return 自身のインスタンス
     */
    public ChainRunner onAfterRunning(Function<Object, Boolean> function, Object param) {
        for (BiConsumer<Function<Object, Boolean>, Object> consumer : afterRunningObservers) {
            consumer.accept(function, param);
        }
        return this;
    }
}
