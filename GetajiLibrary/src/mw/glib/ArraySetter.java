package mw.glib;

/**
 * 配列に値をセットするクラスです。
 * 渡された配列に順次値を追加していきます。
 * 指定した位置からの一括追加なども可能です。
 *
 * @author Getaji
 */
public class ArraySetter<T> {

    private final T[] array;
    private int index = 0;

    /**
     * 対象の配列を渡して初期化します。配列はサイズを指定して生成したものを渡してください。
     *
     * @param array 対象の配列
     */
    public ArraySetter(T[] array) {
        this.array = array;
    }

    /**
     * 値を追加します。
     *
     * @param obj 追加する値
     * @return 自身のインスタンス
     */
    public ArraySetter<T> add(T obj) {
        array[index++] = obj;
        return this;
    }

    /**
     * 複数の値を追加します。
     *
     * @param objs 追加する複数の値
     * @return 自身のインスタンス
     */
    public ArraySetter<T> adds(T... objs) {
        for (T obj : objs)
            add(obj);
        return this;
    }

    /**
     * 指定した位置に値をセットします。
     *
     * @param index セットする位置
     * @param obj セットする値
     * @return 自身のインスタンス
     */
    public ArraySetter<T> set(int index, T obj) {
        if (Checker.isMinus(index) || array.length <= index) Thrower.throwAIOOBE();
        array[index] = obj;
        return this;
    }

    /**
     * 指定した位置から複数の値をセットします。
     *
     * @param index セットする位置
     * @param objs セットする複数の値
     * @return 自身のインスタンス
     */
    public ArraySetter<T> sets(int index, T[] objs) {
        Checker.requireNonNull(objs);
        Checker.requireIndexInTheRange(array, index);
        final int end = index - 1 + objs.length;
        Checker.requireIndexInTheRange(array, end);
        for (int i = index; i < index + objs.length; ++i) {
            array[i] = objs[i - index];
        }
        this.index = end;
        return this;
    }

    /**
     * 指定した量だけインデックスを戻します。
     *
     * @param value 戻す量
     * @return 自身のインスタンス
     */
    public ArraySetter<T> back(int value) {
        if (Checker.isMinus(value) || Checker.isMinus(index - value)) Thrower.throwAIOOBE();
        index -= value;
        return this;
    }

    /**
     * インデックスをセットします。
     *
     * @param index インデックス
     * @return 自身のインスタンス
     * @throws ArrayIndexOutOfBoundsException マイナスか配列の範囲外の場合にスロー
     */
    public ArraySetter<T> setIndex(int index)
            throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
        if (Checker.isMinus(index) || array.length <= index) Thrower.throwAIOOBE();
        this.index = index;
        return this;
    }

    /**
     * 現在のインデックスを返します。
     *
     * @return インデックス
     */
    public int getNowIndex() {
        return index;
    }

    /**
     * 配列が最後まで格納されたか返します。
     *
     * @return 配列の状態
     */
    public boolean isFully() {
        return index == array.length;
    }

    /**
     * 配列を取得します。
     *
     * @return 配列
     */
    public T[] get() {
        return array;
    }
}
