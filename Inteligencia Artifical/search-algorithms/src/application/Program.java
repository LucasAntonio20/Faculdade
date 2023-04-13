package application;

import algorithms.HillClimbing;
import algorithms.SimulatedAnnealing;

import java.util.Random;

public class Program {
    public static void main(String[] args) {

        // Hill Climb
        int[] values = new int[]{5, 5, 7, 10, 18, 7, 7, 10, 1, 5, 11, 15, 22};
        HillClimbing hillClimbing = new HillClimbing(values);
        System.out.println("     Search Area");
        hillClimbing.print();
        System.out.println("Max Global: "+ hillClimbing.maxGlobal());
        SimulatedAnnealing simulatedAnnealing = new SimulatedAnnealing(values);
        System.out.println("Max Global: "+ simulatedAnnealing.maxGlobal());

    }
}
