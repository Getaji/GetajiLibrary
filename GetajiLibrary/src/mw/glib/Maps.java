package mw.glib;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;

/**
 * javadoc here.
 *
 * @author Getaji
 */
public class Maps {

    /**
     * 空の{@link HashMap}を生成して返します。
     *
     * @param <K> キーの型
     * @param <V> 値の型
     * @return 空のHashMap
     */
    public static <K, V> HashMap<K, V> newHashMap() {
        return new HashMap<>();
    }

    /**
     * 空の{@link LinkedHashMap}を生成して返します。
     *
     * @param <K> キーの型
     * @param <V> 値の型
     * @return 空のLinkedHashMap
     */
    public static <K, V> LinkedHashMap<K, V> newLinkedHashMap() {
        return new LinkedHashMap<>();
    }

    /**
     * 指定した配列に入ったアイテムを格納した{@link HashMap}を生成して返します。
     *
     * @param keys 格納するアイテムのキーの配列
     * @param values 格納するアイテムの値の配列
     * @param <K> キーの型
     * @param <V> キーの型
     * @return 中身の入ったHashMap
     */
    public static <K, V> HashMap<K, V> newHashMapWithItems(K[] keys, V[] values) {
        Checker.requireAndNonNull(keys, values);
        HashMap<K, V> map = newHashMap();
        for (int i = 0; i < keys.length; ++i) {
            map.put(keys[i], values[i]);
        }
        return map;
    }

    /**
     * 指定した配列に入ったアイテムを格納した{@link LinkedHashMap}を生成して返します。
     *
     * @param keys 格納するアイテムのキーの配列
     * @param values 格納するアイテムの値の配列
     * @param <K> キーの型
     * @param <V> 値の型
     * @return 中身の入ったLinkedHashMap
     */
    public static <K, V> LinkedHashMap<K, V> newLinkedHashMapWithItems(K[] keys, V[] values) {
        Checker.requireAndNonNull(keys, values);
        LinkedHashMap<K, V> map = newLinkedHashMap();
        for (int i = 0; i < keys.length; ++i) {
            map.put(keys[i], values[i]);
        }
        return map;
    }

    /**
     * Mapに入っているアイテムをインデックスと一緒にひとつずつ、受け取った関数に渡します。
     * キーと値は別々に渡されます。
     *
     * @param map 回すMap
     * @param action 処理する関数
     * @param <K> キーの型
     * @param <V> 値の型
     */
    public static <K, V> void forEachWithIndex(Map<K, V> map, TriConsumer<Integer, K, V> action) {
        Checker.requireAndNonNull(map, action);
        Iterator<Map.Entry<K, V>> iterator = map.entrySet().iterator();
        Map.Entry<K, V> entry;
        for (int i = 0; i < map.size(); ++i) {
            entry = iterator.next();
            action.accept(i, entry.getKey(), entry.getValue());
        }
    }

    /**
     * Mapに入っているアイテムをインデックスと一緒にひとつずつ、受け取った関数に渡します。
     * キーと値は{@link Map.Entry}で渡されます。
     *
     * @param map 回すMap
     * @param action 処理する関数
     * @param <K> キーの型
     * @param <V> 値の型
     */
    public static <K, V> void forEachWithIndex(Map<K, V> map,
                                               BiConsumer<Integer, Map.Entry<K, V>> action) {
        Checker.requireAndNonNull(map, action);
        Iterator<Map.Entry<K, V>> iterator = map.entrySet().iterator();
        for (int i = 0; i < map.size(); ++i) {
            action.accept(i, iterator.next());
        }
    }

    /**
     * 文字列を{@link Map}に変換します。
     * 例えば、"name=tom,age=10"という文字列、keySplitterに"="、entrySplitterに"="を指定すると、
     * Mapには"name":"tom", "age":"10"という文字列のペアが格納されます。
     *
     * @param str 分割する文字列
     * @param keySplitter キーと値の分割文字 正規表現
     * @param entrySplitter ペア(Entry)の分割文字 正規表現
     * @return 結果
     */
    public static Map<String, String> stringToMap(String str, String keySplitter, String entrySplitter) {
        final String[] entries = str.split(entrySplitter);
        final Map<String, String> map = new HashMap<>();
        for (String entry : entries) {
            String[] kv = entry.split(keySplitter, 2);
            map.put(kv[0], kv[1]);
        }
        return map;
    }
}
