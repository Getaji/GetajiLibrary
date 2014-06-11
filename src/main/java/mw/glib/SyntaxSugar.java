package mw.glib;

/**
 * 構文を見やすくするための糖衣構文クラスです。
 *
 * @author Getaji
 */
public class SyntaxSugar {

    public static final boolean YES = true;

    public static final boolean NO = false;

    @FunctionalInterface
    public static interface NotReturnFunction {
        public void apply();
    }

    /**
     * 真偽値を反転させます。否定を意味します。
     *
     * @param is 真偽値
     * @return 反転させた真偽値
     */
    public static boolean not(boolean is) {
        return !is;
    }

    /**
     * 渡された真偽値がfalseの際に、渡された引数戻り値なしFunctionを実行します。
     * ifの逆です。
     *
     * @param bool 真偽地
     * @param function falseの際に実行する関数
     */
    public static void unless(boolean bool, NotReturnFunction function) {
        if (!bool)
            function.apply();
    }
}
