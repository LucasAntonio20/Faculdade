package entities;

public class DoublyLinkedList<Type> {

    private Node<Type> head;
    private Node<Type> tail;

    private int listSize;

    public DoublyLinkedList() {
        head = null;
        tail = null;
        listSize = 0;
    }

    public void add(Type content){
        Node<Type> newNode = new Node<Type>(content);
        newNode.setNext(null);
        newNode.setPrevious(tail);
        if (head == null) head = newNode;
        if (tail != null) tail.setNext(newNode);
        tail = newNode;
        listSize++;
    }

    public void add(Type content, int index){
        Node<Type> auxNode = getNode(index);
        Node<Type> newNode = new Node<Type>(content);
        newNode.setNext(auxNode);
        if (newNode.getNext() != null) {
            newNode.setPrevious(auxNode.getPrevious());
            newNode.getNext().setPrevious(newNode);
        }else{
            newNode.setPrevious(tail);
            tail = newNode;
        }

        if (index == 0){
            head = newNode;
        }else{
            newNode.getPrevious().setNext(newNode);
        }
        listSize++;
    }

    public void remove(int index){
        if (size() == 0) throw new RuntimeException("Empty list");
        if (index == 0){
            head = head.getNext();
            if (head != null){
                head.setPrevious(null);
            }
        }else{
            Node<Type> auxNode = getNode(index);
            auxNode.getPrevious().setNext(auxNode.getNext());
            if (auxNode != tail){
                auxNode.getNext().setPrevious(auxNode.getPrevious());
            }else{
                tail = auxNode;
            }
        }
        listSize--;
    }

    public Type get(int index){
        return this.getNode(index).getContent();
    }

    public Node<Type> getNode(int index){
        Node<Type> auxNode = head;
        for (int i = 0; (i < index) && (auxNode != null); i++){
            auxNode = auxNode.getNext();
        }
        return auxNode;
    }

    public int size(){
        return listSize;
    }

    @Override
    public String toString() {
        String str = "";
        Node<Type> auxNode = head;
        for (int i = 0; i < size(); i++) {
            str += "["+ auxNode.getContent() +"]-->";
            auxNode = auxNode.getNext();
        }
        str += "null";
        return str;
    }
}