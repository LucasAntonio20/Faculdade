package algorithms;

import entities.DoublyLinkedList;
import entities.Node;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class HillClibing{

    DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
    private static int[] values;

    public HillClibing() {
        generateRandomValues();
        addOnList();
    }

    public HillClibing(int[] values) {
        HillClibing.values = values;
        addOnList();
    }

    public Integer getFirst() {
        return list.get(0);
    }

    private void generateRandomValues() {
        values = new int[15];
        for (int i = 0; i < values.length; i++) {
            int n = new Random().nextInt((i+2) * 6);
            if (n > 10) n = n / 3;
            values[i] = n;
        }
    }

    private void addOnList(){
        for (int value : values) {
            list.add(value);
        }
    }

    public Integer maxGlobal() {
        Node<Integer> actual = list.getNode(0);
        Node<Integer> maxGlobal = actual;
        for (int i = 0; i < list.size(); i++) {
            if (maxGlobal.getNext() == null) return maxGlobal.getContent();
            Node<Integer> neighbor = actual.getNext();
            if (neighbor.getContent() < actual.getContent()) {
                return maxGlobal.getContent();
            } else {
                maxGlobal = neighbor;
            }
            actual = neighbor;
        }
        return list.get(0);
    }

    public void print() {
        int maxValue = getMaxValue();

        for (int i = maxValue; i > 0; i--) {
            System.out.print("+ ");
            for (int value : values) {
                if (value >= i) {
                    System.out.print("|  ");
                } else {
                    System.out.print("   ");
                }
            }
            System.out.println("+");
        }
        for (int value : values) {
            if (value + "".length() < 10) System.out.print("  " + value);
            else System.out.print(" " + value);
        }
        System.out.println();
    }


    private static int getMaxValue() {
        if (Arrays.equals(values, new int[]{})) return 0;
        int maxValue = values[0];
        for (int i = 1; i < values.length; i++) {
            if (values[i] > maxValue) {
                maxValue = values[i];
            }
        }
        return maxValue;
    }
}
