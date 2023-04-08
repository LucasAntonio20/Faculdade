package entities;

public class Node<Interger>{

    Interger value;
    private Node<Interger> neighbor;

    public Node(Interger value) {
        this.value = value;
        this.neighbor = null;
    }

    public Node(Interger value, Interger neighbor) {
        this.value = value;
        this.neighbor = new Node<>(neighbor);
    }

    public Interger getValue() {
        return value;
    }

    public void setValue(Interger value) {
        this.value = value;
    }

    public Node<Interger> getNeighbor() {
        return neighbor;
    }

    public void setNeighbor(Node<Interger> neighbor) {
        this.neighbor = neighbor;
    }

    public int compare(Node<Interger> other) {
        return Integer.compare((Integer) this.value, (Integer)  other.getValue());
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
