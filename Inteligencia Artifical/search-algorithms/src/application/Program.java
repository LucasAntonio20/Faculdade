package application;

import algorithms.HillClibing;
import entities.Node;

import java.util.LinkedList;
import java.util.Random;

public class Program {
    public static void main(String[] args) {

        Node<Integer> first = new Node<>(0);
        Node<Integer> actual = first;

        for (int i = 1; i < 10; i++) {
            int next = new Random().nextInt(i * 20 + 6);
            actual.setNeighbor(new Node<>(next));
            actual = actual.getNeighbor();
        }

        System.out.println("Global maximum = " + new HillClibing().maxGlobal(first));
    }
}
