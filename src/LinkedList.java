public class LinkedList<T> {

    private Node<T> head;
    private int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    public void add(T data) {
        Node<T> nuevo = new Node<>(data);

        if (head == null) {
            head = nuevo;
        } else {
            Node<T> aux = head;
            while (aux.next != null) {
                aux = aux.next;
            }
            aux.next = nuevo;
        }
        size++;
    }

    public T get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Indice fuera de rango");

        Node<T> aux = head;
        for (int i = 0; i < index; i++) {
            aux = aux.next;
        }
        return aux.data;
    }

    public boolean contains(T data) {
        Node<T> aux = head;
        while (aux != null) {
            if (aux.data.equals(data)) return true;
            aux = aux.next;
        }
        return false;
    }

    public boolean remove(T data) {
        if (head == null) return false;

        if (head.data.equals(data)) {
            head = head.next;
            size--;
            return true;
        }

        Node<T> aux = head;
        while (aux.next != null) {
            if (aux.next.data.equals(data)) {
                aux.next = aux.next.next;
                size--;
                return true;
            }
            aux = aux.next;
        }

        return false;
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void print() {
        Node<T> aux = head;
        while (aux != null) {
            System.out.println(aux.data);
            aux = aux.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        Node<T> aux = head;

        while (aux != null) {
            sb.append(aux.data);
            if (aux.next != null) sb.append(", ");
            aux = aux.next;
        }

        sb.append("]");
        return sb.toString();
    }
}
