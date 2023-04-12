package algorithms;

import entities.DoublyLinkedList;
import entities.Node;

import java.util.Arrays;
import java.util.Random;

public class HillClimbing {

    DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
    private static int[] values;

    public HillClimbing() {
        generateRandomValues();
        addOnList();
    }

    public HillClimbing(int[] values) {
        HillClimbing.values = values;
        addOnList();
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
        return maxGlobal(0);
    }

    public Integer maxGlobal(int start) {
        Node<Integer> actual = list.getNode(start);
        Node<Integer> maxGlobal = actual;
        for (int i = 0; i < list.size(); i++) {
            Node<Integer> next = actual.getNext();
            Node<Integer> previous = actual.getPrevious();
            if (previous == null) previous = new Node<>(-20);
            if (next == null) next = new Node<>(-20);
            if (next.getContent() < actual.getContent() && previous.getContent() < actual.getContent()) {
                return maxGlobal.getContent();
            }
            if (next.getContent() >= actual.getContent() ) {
                maxGlobal = next;
                actual = next;
            } else {
                maxGlobal = previous;
                actual = previous;
            }
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
