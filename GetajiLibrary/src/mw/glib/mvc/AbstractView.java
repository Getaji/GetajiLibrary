package mw.glib.mvc;

import mw.glib.Checker;

/**
 * <p><tt>MVC</tt>パターンの<tt>View</tt>を表す抽象クラスです。
 *
 * <p><tt>View</tt>は<tt>Controller</tt>から操作・<tt>Model</tt>からイベントを受け付け、
 * <tt>Model</tt>に操作・<tt>Controller</tt>にイベントを送信します。
 *
 * <p><tt>Model</tt>は{@link mw.glib.mvc.AbstractModel}、
 * <tt>Controller</tt>は{@link mw.glib.mvc.AbstractController}を実装するよう設計されるべきです。
 *
 * <p><tt>View</tt>は<tt>Model</tt>と<tt>Controller</tt>を保持します。
 *
 * <p>このクラスはMW MVC Frameworkに属します。
 *
 * @since build003
 * @author Getaji
 */
public abstract class AbstractView {

    private AbstractModel model;

    private AbstractController controller;

    /**
     * Modelを返します。
     *
     * @return model
     */
    public AbstractModel getModel() {
        return model;
    }

    /**
     * Modelをセットします。
     *
     * @param model model
     */
    public void setModel(AbstractModel model) {
        Checker.requireNonNull(model);

        this.model = model;
    }

    /**
     * Controllerを返します。
     *
     * @return controller
     */
    public AbstractController getController() {
        return controller;
    }

    /**
     * Controllerをセットします。
     *
     * @param controller controller
     */
    public void setController(AbstractController controller) {
        Checker.requireNonNull(controller);

        this.controller = controller;
    }
}
