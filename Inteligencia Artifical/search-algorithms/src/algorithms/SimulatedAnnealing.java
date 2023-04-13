package algorithms;

import entities.DoublyLinkedList;
import entities.Node;

import java.util.Arrays;
import java.util.Random;

public class SimulatedAnnealing {

    DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
    private static int[] values;
    private double P = 50;

    public SimulatedAnnealing() {
        generateRandomValues();
        addOnList();
    }

    public SimulatedAnnealing(int[] values) {
        SimulatedAnnealing.values = values;
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

            if (new Random().nextInt(2) == 0) {
                if (mustGo()) {
                    maxGlobal = next;
                    actual = next;
                }
            }else {
                if (mustGo()) {
                    maxGlobal = previous;
                    actual = previous;
                }
            }
            if ((next.getContent() < actual.getContent() && previous.getContent() < actual.getContent()) || P == 0) {
                return maxGlobal.getContent();
            }
        }
        return list.get(0);
    }

    private boolean mustGo() {
        for (int i = 0; i < P; i++) {
            if (new Random().nextInt(2) == 1) {
                P -= 10;
                return true;
            }
        }
        P -= 10;
        return false;
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
