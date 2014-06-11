package mw.glib;

import java.util.Map;

/**
 * 値のスイッチ（切り替え）を行うクラスです。
 * 値の初期値は<tt>null</tt>で、最初に追加された値が自動でセットされます。
 *
 * @author Getaji
 */
public class Switcher<K, V> {
    private final Map<K, V> values = Maps.newHashMap();
    private V currentValue = null;

    /**
     * 値を追加します。
     *
     * @param key キー
     * @param value 値
     * @return 自身のインスタンス
     */
    public Switcher<K, V> add(K key, V value) {
        Checker.requireAndNonNull(key, value);
        if (values.isEmpty())
            currentValue = value;
        values.put(key, value);
        return this;
    }

    /**
     * 値を切り替えます。
     * @param key キー
     */
    public void switching(K key) {
        Checker.requireNonNull(key);
        if (SyntaxSugar.not(values.containsKey(key))) {
            Thrower.throwIllegalAugmentException();
        }
        currentValue = values.get(key);
    }

    /**
     * 値を取得します。
     *
     * @return 値
     */
    public V get() {
        return currentValue;
    }
}
