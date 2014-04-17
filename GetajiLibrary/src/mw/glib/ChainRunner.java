package mw.glib;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * 関数を順番に、trueか例外が返らない限り連鎖的に実行し続けるクラスです。
 * 実行時にオブジェクトを渡すこともでき、渡し方は{@link ParamPassType}を利用します。
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
        NONE((funcList, objList) -> {
            for (Function<Object, Boolean> function : funcList) {
                if (function.apply(null)) {
                    return true;
                }
            }
            return false;
        }),

        /**
         * オブジェクトリストの最初のオブジェクトだけを使います。
         * 一度だけ実行します。
         */
        ONCE_FIRST((funcList, objList) -> {
            Object giveObj = objList.size() == 0 ? null: objList.get(0);
            for (Function<Object, Boolean> function : funcList) {
                if (function.apply(giveObj)) {
                    return true;
                }
            }
            return false;
        }),

        /**
         * オブジェクトリストの最後のオブジェクトだけを使います。
         * 一度だけ実行します。
         */
        ONCE_LAST((funcList, objList) -> {
            Object giveObj = objList.size() == 0 ? null: objList.get(objList.size() - 1);
            for (Function<Object, Boolean> function : funcList) {
                if (function.apply(giveObj)) {
                    return true;
                }
            }
            return false;
        }),

        /**
         * すべてのオブジェクトのぶん実行します。
         */
        SAME((funcList, objList) -> {
            for (Object object : objList) {
                for (Function<Object, Boolean> function : funcList) {
                    if (function.apply(object)) {
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
        EACH((funcList, objList) -> {
            for (int i = 0; i < funcList.size(); ++i) {
                Object giveObj = objList.size() < i ? objList.get(i) : null;
                if (funcList.get(i).apply(giveObj)) {
                    return true;
                }
            }
            return false;
        }),

        /**
         * 保持するオブジェクトの先頭からそれぞれひとつのメソッドに渡します。
         * 余ったオブジェクトは切り捨てられ、足りない場合はその時点で終了します。
         */
        EACH_CUT((funcList, objList) -> {
            for (int i = 0; i < objList.size(); ++i) {
                if (funcList.get(i).apply(objList.get(i))) {
                    return true;
                }
            }
            return false;
        }),
        ;

        private final BiFunction<List<Function<Object, Boolean>>,
                List<Object>, Boolean> runnerRunner;

        private ParamPassType(BiFunction<List<Function<Object, Boolean>>,
                List<Object>, Boolean> runnerRunner) {
            this.runnerRunner = runnerRunner;
        }

        public boolean run(ChainRunner runner) {
            try {
                return runnerRunner.apply(runner.functionList, runner.getObjectList());
            } catch (Exception e) {
                return false;
            }
        }
    }

    private final List<Function<Object, Boolean>> functionList = new LinkedList<>();
    private final List<Object> objectList = new LinkedList<>();
    private ParamPassType paramPassType = ParamPassType.NONE;

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
    public void addFunc(Function<Object, Boolean> function) {
        functionList.add(function);
    }

    /**
     * 複数の関数を追加します。
     *
     * @param functions 複数の関数のコレクション
     */
    public void addAllFunc(Collection<Function<Object, Boolean>> functions) {
        functionList.addAll(functions);
    }

    /**
     * 関数を指定した位置に追加します。
     *
     * @param function 関数
     * @param index 追加する位置
     */
    public void addFuncAt(Function<Object, Boolean> function, int index) {
        functionList.add(index, function);
    }

    /**
     * 複数の関数を指定した位置に追加します。
     *
     * @param functions 複数の関数のコレクション
     * @param index 追加する位置
     */
    public void addAllFuncAt(Collection<Function<Object, Boolean>> functions, int index) {
        functionList.addAll(index, functions);
    }

    /**
     * 関数に渡すオブジェクトを追加します。
     *
     * @param obj オブジェクト
     */
    public void addObject(Object obj) {
        objectList.add(obj);
    }

    /**
     * 関数に渡すオブジェクトを複数追加します。
     *
     * @param objects 複数のオブジェクトのコレクション
     */
    public void addAllObject(Collection<Object> objects) {
        objectList.addAll(objectList);
    }

    /**
     * 関数に渡すオブジェクトを指定した位置に追加します。
     *
     * @param obj オブジェクト
     * @param index 追加する位置
     */
    public void addObjectAt(Object obj, int index) {
        objectList.add(index, obj);
    }

    /**
     * 関数に渡すオブジェクトを複数、指定した位置に追加します。
     *
     * @param objects 複数のオブジェクトのコレクション
     * @param index 追加する位置
     */
    public void addAllObject(Collection<Object> objects, int index) {
        objectList.addAll(index, objectList);
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
    public void setParamPassType(ParamPassType paramPassType) {
        this.paramPassType = paramPassType;
    }
}
