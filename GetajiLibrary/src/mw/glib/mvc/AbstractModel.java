package mw.glib.mvc;

import mw.glib.Checker;

/**
 * <p><tt>MVC</tt>パターンの<tt>Model</tt>を表す抽象クラスです.
 *
 * <p><tt>Model</tt>は<tt>Controller</tt>と<tt>View</tt>から取得,操作を受け付け,
 * <tt>View</tt>にイベントを送信します.
 * <tt>Controller</tt>は{@link mw.glib.mvc.AbstractController},
 * <tt>View</tt>は{@link mw.glib.mvc.AbstractView}を実装するよう設計されるべきです.
 *
 * <p><tt>Model</tt>は<tt>View</tt>のみを保持します.
 *
 * <p>このクラスはMW MVC Frameworkに属します。
 *
 * @since build003
 * @author Getaji
 */
public abstract class AbstractModel {

    private AbstractView view;

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
