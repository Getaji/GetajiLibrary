package mw.glib;

/**
 * {@link LocalizeManager}, {@link Location}クラスの操作が不正だった場合にスローされる例外です.
 */
public class LocalizeException extends RuntimeException {

    /**
     * メッセージ.
     */
    private final String message;

    /**
     * メッセージを設定してインスタンスを生成します.
     * @param message エラーの内容を表すメッセージ
     */
    LocalizeException(String message) {
        this.message = message;
    }

    /**
     * エラーの内容を表すメッセージを返します.
     * @return メッセージ
     */
    @Override
    public String getMessage() {
        return message;
    }
}
