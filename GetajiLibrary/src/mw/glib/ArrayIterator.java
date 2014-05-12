package mw.glib;

import static mw.glib.SyntaxSugar.not;

/**
 * {@link java.util.Iterator}による配列のイテレートを行うクラスです。
 *
 * @author Getaji
 */
public class ArrayIterator<T> implements PreviewableIterator<T> {

    private final T[] array;

    private int index = 0;

    public ArrayIterator(T[] array) {
        Checker.requireNonNull(array);
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        return not(Checker.isIndexOutOfBounds(array, index));
    }

    @Override
    public T next() {
        return array[index++];
    }

    @Override
    public boolean hasPreview() {
        return not(Checker.isIndexOutOfBounds(array, index - 1));
    }

    @Override
    public T preview() {
        return array[--index];
    }
}
