package algorithms;

import entities.Node;

import java.util.Random;

public class HillClibing{

    private Node<Integer> first;
    private static int[] values;

    public HillClibing() {
        generateRandomValues();
    }

    public HillClibing(int[] values) {
        this.values = values;
    }

    private void generateRandomValues() {
        this.values = new int[15];
        for (int i = 0; i < values.length; i++) {
            int n = new Random().nextInt((i+2) * 6);
            if (n > 10) n = n / 3;
            values[i] = n;
        }
    }

    public void run() {
        this.first= new Node<>(values[0]);
        Node<Integer> actual = first;

        for (int i = 1; i < values.length; i++) {
            actual.setNeighbor(new Node<>(values[i]));
            actual = actual.getNeighbor();
        }
    }

    public Integer maxGlobal(Node<Integer> first) {
        Node<Integer> actual = first;
        Node<Integer> maxGlobal = first;
        while (actual.getNeighbor() != null) {
            Node<Integer> neighbor = actual.getNeighbor();
            if (neighbor.compare(actual) < 0) {
                return maxGlobal.getValue();
            } else {
                maxGlobal = neighbor;
            }
            actual = neighbor;
        }
        if (maxGlobal.getNeighbor() == null) return maxGlobal.getValue();
        return first.getValue();
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
        int maxValue = values[0];
        for (int i = 1; i < values.length; i++) {
            if (values[i] > maxValue) {
                maxValue = values[i];
            }
        }
        return maxValue;
    }
}
