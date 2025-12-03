public class Library {

    private String name;
    private LinkedList<Book> books;
    private Queue<Book> acquisitionQueue;

    public Library(String name) {
        this.name = name;
        this.books = new LinkedList<>();
        this.acquisitionQueue = new Queue<>();
    }

    public String getName() {
        return name;
    }

    public LinkedList<Book> getBooks() {
        return books;
    }

    public void setName(String name) {
        this.name = name;
    }


    public boolean addBook(Book book) {
        if (book == null) return false;
        books.add(book);
        return true;
    }

    public boolean removeBook(Book book) {
        if (book == null) return false;
        return books.remove(book);
    }


 
    public Book findBookByIsbn(String isbn) {
        for (int i = 0; i < books.size(); i++) {
            Book b = books.get(i);
            if (b.getIsbn().equalsIgnoreCase(isbn)) {
                return b;
            }
        }
        return null;
    }

    public LinkedList<Book> findBooksByTitle(String title) {
        LinkedList<Book> result = new LinkedList<>();
        for (int i = 0; i < books.size(); i++) {
            Book b = books.get(i);
            if (b.getTitle().toLowerCase().contains(title.toLowerCase())) {
                result.add(b);
            }
        }
        return result;
    }

    public LinkedList<Book> findBooksByAuthor(String authorName) {
        LinkedList<Book> result = new LinkedList<>();
        for (int i = 0; i < books.size(); i++) {
            Book b = books.get(i);
            if (b.getAuthor().equalsIgnoreCase(authorName)) {
                result.add(b);
            }
        }
        return result;
    }


    public Book loanBook(String isbn) {
        Book b = findBookByIsbn(isbn);
        if (b != null) {
            if (b.lend()) {
                return b;
            }
        }
        return null;
    }


    public boolean returnBook(Book book) {
        if (book != null && !book.isAvailable()) {
            book.returnBook();
            return true;
        }
        return false;
    }

    public LinkedList<Book> getAvailableBooks() {
        LinkedList<Book> result = new LinkedList<>();
        for (int i = 0; i < books.size(); i++) {
            Book b = books.get(i);
            if (b.isAvailable()) {
                result.add(b);
            }
        }
        return result;
    }

    public LinkedList<Book> getLoanedBooks() {
        LinkedList<Book> result = new LinkedList<>();
        for (int i = 0; i < books.size(); i++) {
            Book b = books.get(i);
            if (!b.isAvailable()) {
                result.add(b);
            }
        }
        return result;
    }

  
    public void enqueueNewBook(Book book) {
        acquisitionQueue.enqueue(book);
    }

    public Book peekNextNewBook() {
        return acquisitionQueue.peek();
    }

    public Book processNextNewBook() {
        Book book = acquisitionQueue.dequeue();
        if (book != null) {
            addBook(book);
        }
        return book;
    }

 
    public String getStatistics() {
        int total = books.size();
        int available = getAvailableBooks().size();
        int loaned = getLoanedBooks().size();

        return "Estadísticas:\n" +
                "- Total libros: " + total + "\n" +
                "- Disponibles: " + available + "\n" +
                "- Prestados: " + loaned + "\n";
    }

    @Override
    public String toString() {
        return "Biblioteca: " + name + "\nLibros registrados: " + books.size();
    }
}
