package algorithms;

import entities.Node;

public class HillClibing{

    public Integer maxGlobal(Node<Integer> first) {
        print(first);
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
        return first.getValue();
    }

    private void print(Node<Integer> first) {
        Node<Integer> actual = first;
        while (actual != null){
            System.out.print(actual.getValue()+" ");
            actual = actual.getNeighbor();
        }
        System.out.println();
    }

}
