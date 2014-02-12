package mw.glib;

/**
 * Created with IntelliJ IDEA.
 * User: user9
 * Date: 14/02/12
 * Time: 9:59
 * To change this template use File | Settings | File Templates.
 */
public class LocalizeException extends RuntimeException {

    private final String message;

    LocalizeException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return super.getMessage() + message;
    }
}
