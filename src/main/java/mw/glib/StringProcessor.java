package mw.glib;

import java.util.List;
import java.util.Map;

/**
 * 文字列を操作するクラスです。
 *
 * @since build004
 * @author Getaji
 */
public class StringProcessor {

    private StringProcessor() {}

    /**
     * 配列の要素をcharacterで区切って結合し、文字列として返します。
     *
     * @param character 区切り文字
     * @param list 対象配列
     * @return 結合結果
     */
    public static String join(String character, Object... list) {
        Checker.requireNonNull(character);
        Checker.requireAndNonNull(list);

        if (list.length <= 0) {
            return "";
        } else {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < list.length - 1; ++i) {
                builder.append(list[i]);
                builder.append(character);
            }
            builder.append(list[list.length - 1]);
            return builder.toString();
        }
    }

    /**
     * {@link List}の要素をcharacterで区切って結合し、文字列として返します。
     *
     * @param character 区切り文字
     * @param list 対象リスト
     * @return 結合結果
     */
    public static String join(String character, List<?> list) {
        Checker.requireNonNull(character);
        Checker.requireAndNonNull(list);

        if (list.size() <= 0) {
            return "";
        } else {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < list.size() - 1; ++i) {
                builder.append(list.get(i));
                builder.append(character);
            }
            builder.append(list.get(list.size() - 1));
            return builder.toString();
        }
    }

    /**
     * {@link Map}のキーと値をkeySplitter、それをentrySplitterで区切って結合し、文字列として返します。
     * 例えば、"name":"tom", "age":16という2つのEntryが入ったMapと、
     * keySplitterに"=", entrySplitterに", "を指定すると、
     * "name=tom, age=16"という文字列を返します。
     *
     * @param map 対象Map
     * @param keySplitter キーと値の区切り文字
     * @param entrySplitter Entryの区切り文字
     * @return 結合結果
     */
    public static String join(Map<String, Object> map, String keySplitter, String entrySplitter) {
        Checker.requireNonNull(map);
        Checker.requireAndNonEmpty(keySplitter, entrySplitter);
        String[] entries = new String[map.size()];
        Maps.forEachWithIndex(map, (index, str, obj) -> {
            entries[index] = str + keySplitter + obj;
        });
        return join(entrySplitter, entries);
    }
}

