package mw.glib;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.function.BiConsumer;

/**
 * {@link java.util.List}の実装クラスを生成・操作するユーティリティクラスです。
 *
 * @author Getaji
 */
public class Lists {

    /**
     * 空の{@link ArrayList}を生成して返します。
     *
     * @param <E> 型
     * @return 空のArrayList
     */
    public static <E> ArrayList<E> newArrayList() {
        return new ArrayList<>();
    }

    /**
     * 指定した初期サイズの{@link ArrayList}を生成して返します。
     *
     * @param <E> 型
     * @return 空のArrayList
     */
    public static <E> ArrayList<E> newArrayList(int initialCapacity) {
        return new ArrayList<>(initialCapacity);
    }

    /**
     * 空の{@link LinkedList}を生成して返します。
     *
     * @param <E> 型
     * @return 空のLinkedList
     */
    public static <E> LinkedList<E> newLinkedList() {
        return new LinkedList<>();
    }

    /**
     * 指定した数だけnullを格納した{@link ArrayList}を生成して返します。
     *
     * @param size 格納する数
     * @param <E> 型
     * @return 中身の入ったArrayList
     */
    public static <E> ArrayList<E> newArrayListWithItems(int size) {
        ArrayList<E> list = newArrayList(size);
        for (int i = 0; i < size; ++i)
            list.add(null);
        return list;
    }

    /**
     * 指定した数だけ指定したアイテムを格納した{@link ArrayList}を生成して返します。
     *
     * @param size 格納する数
     * @param item 格納するアイテム
     * @param <E> 型
     * @return 中身の入ったArrayList
     */
    public static <E> ArrayList<E> newArrayListWithItems(int size, E item) {
        ArrayList<E> list = newArrayList(size);
        for (int i = 0; i < size; ++i)
            list.add(item);
        return list;
    }

    /**
     * 指定した配列に入ったアイテムを格納した{@link ArrayList}を生成して返します。
     *
     * @param items 格納するアイテムの配列
     * @param <E> 型
     * @return 中身の入ったArrayList
     */
    public static <E> ArrayList<E> newArrayListWithItems(E[] items) {
        ArrayList<E> list = newArrayList();
        Collections.addAll(list, items);
        return list;
    }

    /**
     * 指定した数だけnullを格納した{@link LinkedList}を生成して返します。
     *
     * @param size 格納する数
     * @param <E> 型
     * @return 中身の入ったLinkedList
     */
    public static <E> LinkedList<E> newLinkedListWithItems(int size) {
        LinkedList<E> list = newLinkedList();
        for (int i = 0; i < size; ++i)
            list.add(null);
        return list;
    }

    /**
     * 指定した数だけ指定したアイテムを格納した{@link LinkedList}を生成して返します。
     *
     * @param size 格納する数
     * @param item 格納するアイテム
     * @param <E> 型
     * @return 中身の入ったLinkedList
     */
    public static <E> LinkedList<E> newLinkedListWithItems(int size, E item) {
        LinkedList<E> list = newLinkedList();
        for (int i = 0; i < size; ++i)
            list.add(item);
        return list;
    }

    /**
     * 指定した配列に入ったアイテムを格納した{@link LinkedList}を生成して返します。
     *
     * @param items 格納するアイテムの配列
     * @param <E> 型
     * @return 中身の入ったLinkedList
     */
    public static <E> LinkedList<E> newLinkedListWithItems(E[] items) {
        LinkedList<E> list = newLinkedList();
        Collections.addAll(list, items);
        return list;
    }

    /**
     * Listに入っているアイテムをインデックスと一緒にひとつずつ、受け取った関数に渡します。
     *
     * @param list 回すList
     * @param action 処理する関数
     * @param <E> 型
     */
    public static <E> void forEachWithIndex(List<E> list, BiConsumer<Integer, E> action) {
        Checker.requireAndNonNull(list, action);
        for (int i = 0; i < list.size(); ++i) {
            action.accept(i, list.get(i));
        }
    }

    /**
     * Listに入っているアイテムをインデックスと一緒にひとつずつ、受け取った関数に渡します。
     *
     * @param list 回すList
     * @param action 処理する関数
     * @param <E> 型
     */
    public static <E> void forEachReverce(List<E> list, BiConsumer<Integer, E> action) {
        Checker.requireAndNonNull(list, action);
        for (int i = 0; i < list.size(); ++i) {
            action.accept(i, list.get(i));
        }
    }
}
