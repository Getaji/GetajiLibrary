package mw.glib.gof;

/**
 * 調停者を表す抽象クラス.<br />
 * GoFデザインパターンのMediatorパターンの実装.
 * @param <T> 処理するオブジェクトの型
 */
public abstract class Mediator<T> {

    /**
     * 調停を行う.
     * @param value 対象のオブジェクト
     */
    public abstract void interaction(T value);
}
