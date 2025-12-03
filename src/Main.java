public class Main {
    public static void main(String[] args) {

    
        Library library = new Library("Biblioteca Central");

      
        Book b1 = new Book("El señor de los anillos", "Tolkien", 1954, "ISBN001");
        Book b2 = new Book("Fundación", "Isaac Asimov", 1951, "ISBN002");
        Book b3 = new Book("Harry Potter", "J.K. Rowling", 1997, "ISBN003");
        Book b4 = new Book("El Hobbit", "Tolkien", 1937, "ISBN004");

        library.addBook(b1);
        library.addBook(b2);
        library.addBook(b3);
        library.addBook(b4);

        System.out.println("===== LIBROS INICIALES EN BIBLIOTECA =====");
        System.out.println(library.getBooks());

      
        Stack<Book> loanStack = new Stack<>();
        Queue<Book> incomingQueue = new Queue<>();

    
        System.out.println("===== REGISTRANDO PRESTAMOS =====");

        Book loaned = library.loanBook("ISBN003");
        if (loaned != null) loanStack.push(loaned);

        loaned = library.loanBook("ISBN001");
        if (loaned != null) loanStack.push(loaned);

        System.out.println("Pila de préstamos:");
        System.out.println(loanStack);

      
        System.out.println("===== COLA DE LIBROS NUEVOS =====");

        incomingQueue.enqueue(new Book("Neuromancer", "William Gibson", 1984, "ISBN100"));
        incomingQueue.enqueue(new Book("Dune", "Frank Herbert", 1965, "ISBN101"));
        incomingQueue.enqueue(new Book("Snow Crash", "Neal Stephenson", 1992, "ISBN102"));

        System.out.println("Libros en espera de catalogación:");
        System.out.println(incomingQueue);

        System.out.println("===== PROCESANDO INGRESOS =====");
        while (!incomingQueue.isEmpty()) {
            Book incoming = incomingQueue.dequeue();
            library.addBook(incoming);
            System.out.println("Catalogado y agregado: " + incoming);
        }

      
        System.out.println("===== DEVOLVIENDO LIBROS (STACK) =====");

        while (!loanStack.isEmpty()) {
            Book returned = loanStack.pop();
            library.returnBook(returned);
            System.out.println("Devuelto: " + returned);
        }

        System.out.println("===== PRUEBAS DE BUSQUEDA =====");

        System.out.println("Buscar ISBN002: " + library.findBookByIsbn("ISBN002"));
        System.out.println("Buscar título 'El': " + library.findBooksByTitle("El"));
        System.out.println("Buscar autor 'Tolkien': " + library.findBooksByAuthor("Tolkien"));

    
        System.out.println("===== ESTADISTICAS =====");
        System.out.println(library.getStatistics());

    
        System.out.println("===== ESTADO FINAL DE LA BIBLIOTECA =====");
        System.out.println(library);
    }
}
