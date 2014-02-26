package mw.glib.gof;

/**
 * 訪問者を表す抽象クラス.<br />
 * GoFデザインパターンのVisitorパターンの実装.
 * @param <T> 受け入れ側の型
 */
public abstract class Visitor<T> {

    /**
     * 訪問を行う.
     * @param acceptor 受け入れクラスのインスタンス
     */
    public abstract void visit(T acceptor);
}
