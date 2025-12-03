public class Stack<T> {

    private Node<T> top;
    private int size;

    public Stack() {
        top = null;
        size = 0;
    }

    public void push(T data) {
        Node<T> nuevo = new Node<>(data);
        nuevo.next = top;
        top = nuevo;
        size++;
    }

    public T pop() {
        if (isEmpty()) throw new RuntimeException("Pila vacia");
        T data = top.data;
        top = top.next;
        size--;
        return data;
    }

    public T peek() {
        if (isEmpty()) throw new RuntimeException("Pila vacia");
        return top.data;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
