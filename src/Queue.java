public class Queue<T> {

    private Node<T> front;
    private Node<T> rear;
    private int size;

    public Queue() {
        front = rear = null;
        size = 0;
    }

    public void enqueue(T data) {
        Node<T> nuevo = new Node<>(data);

        if (rear == null) {
            front = rear = nuevo;
        } else {
            rear.next = nuevo;
            rear = nuevo;
        }

        size++;
    }

    public T dequeue() {
        if (isEmpty()) throw new RuntimeException("Cola vacia");

        T data = front.data;
        front = front.next;

        if (front == null) rear = null;

        size--;
        return data;
    }

    public T peek() {
        if (isEmpty()) throw new RuntimeException("Cola vacia");
        return front.data;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}