package com.dragon.book.javacore.chapter14.tereSet;

import java.util.Comparator;
import java.util.HashMap;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created with IntelliJ IDEA.
 * User: dsy30
 * Date: 2018/3/17
 */
public class TreeSetTest {
    public static void main(String[] args) {
        SortedSet<Item> itemSortedSet = new TreeSet<>();
        itemSortedSet.add(new Item("abc", 1234));
        itemSortedSet.add(new Item("edf", 4544));
        itemSortedSet.add(new Item("xyz", 3421));

        HashMap<String, Object> map = new HashMap<>();
        map.put("1", null);

        System.out.println(itemSortedSet);

        SortedSet<Item> items = new TreeSet<>(new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return o1.getDescription().compareTo(o2.getDescription());
            }
        });
        items.add(new Item("xyz", 3421));
        items.add(new Item("edf", 4544));
        items.add(new Item("abc", 1234));

        System.out.println(items);
    }
}
