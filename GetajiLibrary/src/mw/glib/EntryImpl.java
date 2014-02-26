package mw.glib;

import java.util.Map;

/**
 * {@link Map.Entry}の実装クラスです.<br />
 * 最低限の変数とメソッドを保持します.
 * @param <K> キー(不変)
 * @param <V> 値(可変)
 */
public class EntryImpl<K, V> implements Map.Entry<K, V> {

    /**
     * キー.<br />
     * この変数は初期化後変更できない.
     */
    private final K key;

    /**
     * 値.<br />
     * この変数は何度でも変更できる.
     */
    private V value;

    /**
     * インスタンスを生成します.
     * @param key キー これ以降は変更できない
     * @param value 値
     */
    public EntryImpl(K key, V value) {
        this.key = key;
        this.value = value;
    }

    /**
     * キーを返します.
     * @return キー
     */
    @Override
    public K getKey() {
        return key;
    }

    /**
     * 値を返します.
     * @return 値
     */
    @Override
    public V getValue() {
        return value;
    }

    /**
     * 値をセットします
     * @param value 値
     * @return セット後の値
     */
    @Override
    public V setValue(V value) {
        return this.value = value;
    }
}
