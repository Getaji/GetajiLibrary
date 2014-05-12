package mw.glib;

/**
 * 構文を見やすくするための糖衣構文クラスです。
 *
 * @author Getaji
 */
public class SyntaxSugar {

    /**
     * 真偽値を反転させます。否定を意味します。
     *
     * @param is 真偽値
     * @return 反転させた真偽値
     */
    public static boolean not(boolean is) {
        return !is;
    }
}
