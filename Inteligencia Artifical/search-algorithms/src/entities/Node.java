package entities;

public class Node<Type> {

    private Node<Type> previous;
    private Node<Type> next;
    private Type content;

    public Node(Type content) {
        this.content = content;
    }

    public Node<Type> getPrevious() {
        return previous;
    }

    public void setPrevious(Node<Type> previous) {
        this.previous = previous;
    }

    public Node<Type> getNext() {
        return next;
    }

    public void setNext(Node<Type> next) {
        this.next = next;
    }

    public Type getContent() {
        return content;
    }

    public void setContent(Type content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "["+ content + ']';
    }
}