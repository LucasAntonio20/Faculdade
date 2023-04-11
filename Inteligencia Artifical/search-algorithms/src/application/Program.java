package application;

import algorithms.HillClibing;
import entities.Node;

import java.util.Random;

public class Program {
    public static void main(String[] args) {

        // Hill Climb

        HillClibing hillClibing = new HillClibing();
        hillClibing.run();
        System.out.println("     Search Area");
        hillClibing.print();
    }
}
