package mw.glib;

import java.util.Map;

/**
 * {@link Map.Entry}の実装クラスです.<br />
 * 最低限の変数とメソッドを保持します.
 * @param <K> キー(不変)
 * @param <V> 値(可変)
 */
public class EntryImpl<K, V> implements Map.Entry<K, V> {

    private final K key;

    private V value;

    public EntryImpl(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

    @Override
    public V setValue(V value) {
        return this.value = value;
    }
}
