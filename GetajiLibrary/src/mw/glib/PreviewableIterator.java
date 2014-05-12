package mw.glib;

import java.util.Iterator;

/**
 * <p>前に戻って値を参照することのできる{@link Iterator}を表すインターフェースです。
 *
 * <p><h1>このインターフェースの標準実装クラス</h1>
 * <list>
 *     <li>{@link ArrayIterator}</li>
 * </list>
 *
 * @author Getaji
 */
public interface PreviewableIterator<T> extends Iterator<T> {

    /**
     * 前に値があるか返します。
     *
     * @return 前に値があるか
     */
    boolean hasPreview();

    /**
     * 前の値を返します。
     *
     * @return 前の値
     */
    T preview();
}
