package application;

import algorithms.HillClibing;
import entities.Node;

import java.util.Random;

public class Program {
    public static void main(String[] args) {

        // Hill Climb

        int[] values = new int[]{2, 5, 7, 20, 6};
        HillClibing hillClibing = new HillClibing(values);
        System.out.println("     Search Area");
        hillClibing.print();

    }
}
