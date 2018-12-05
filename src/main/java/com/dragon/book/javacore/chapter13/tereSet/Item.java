package com.dragon.book.javacore.chapter13.tereSet;


/**
 * Created with IntelliJ IDEA.
 * User: dsy30
 * Date: 2018/3/17
 */
public class Item implements Comparable<Item> {

    private String description;

    private int partNumbers;

    public String getDescription() {
        return description;
    }

    public int getPartNumbers() {
        return partNumbers;
    }

    public Item(String description, int partNumbers) {
        this.description = description;
        this.partNumbers = partNumbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (partNumbers != item.partNumbers) return false;
        return description != null ? description.equals(item.description) : item.description == null;
    }

    @Override
    public int hashCode() {
        int result = description != null ? description.hashCode() : 0;
        result = 31 * result + partNumbers;
        return result;
    }

    @Override
    public String toString() {
        return "Item{" +
                "description='" + description + '\'' +
                ", partNumbers=" + partNumbers +
                '}';
    }

    @Override
    public int compareTo(Item o) {
        return Integer.compare(partNumbers, o.partNumbers);
    }
}
