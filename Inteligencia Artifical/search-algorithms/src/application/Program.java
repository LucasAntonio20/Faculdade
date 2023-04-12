package application;

import algorithms.HillClimbing;

public class Program {
    public static void main(String[] args) {

        // Hill Climb

        //int[] values = new int[]{2, 5, 27, 22, 20, 32, 18, 20, 6};
        HillClimbing hillClimbing = new HillClimbing();
        System.out.println("     Search Area");
        hillClimbing.print();
        System.out.println(hillClimbing.maxGlobal());

    }
}
