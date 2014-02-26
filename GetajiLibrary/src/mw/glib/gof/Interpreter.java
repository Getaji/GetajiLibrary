package mw.glib.gof;

/**
 * 解釈者を表す抽象クラス.<br />
 * GoFデザインパターンのInterpreterパターンの実装.
 * @param <T> 処理するデータの型
 */
public abstract class Interpreter<T> {

    /**
     * 受け取ったデータを解釈する.
     * @param data 処理するデータ
     * @return 処理したデータ
     */
    public abstract T execute(T data);
}
