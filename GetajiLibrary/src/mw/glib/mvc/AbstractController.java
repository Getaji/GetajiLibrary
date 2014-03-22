package mw.glib.mvc;

import mw.glib.Checker;

/**
 * <p><tt>MVC</tt>パターンの<tt>Controller</tt>を表す抽象クラスです.
 *
 * <p><tt>Controller</tt>は<tt>View</tt>からイベントを受け付け,
 * <tt>Model</tt>と<tt>View</tt>を取得,操作します.
 * <tt>Model</tt>は{@link mw.glib.mvc.AbstractModel},
 * <tt>View</tt>は{@link mw.glib.mvc.AbstractView}を実装するよう設計されるべきです.
 *
 * <p><tt>Controller</tt>は<tt>Model</tt>と<tt>View</tt>を保持します.
 *
 * <p>このクラスはMW MVC Frameworkに属します。
 *
 * @since build003
 * @author Getaji
 */
public abstract class AbstractController {

    public AbstractModel model;

    public AbstractView view;

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
     * Viewを返します。
     *
     * @return view
     */
    public AbstractView getView() {
        return view;
    }

    /**
     * Viewをセットします。
     * 
     * @param view view
     */
    public void setView(AbstractView view) {
        Checker.requireNonNull(view);

        this.view = view;
    }
}
