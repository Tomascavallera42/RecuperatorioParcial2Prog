public class Book {
    private String title;
    private String author;
    private int year;
    private String isbn;

    private boolean available;
    private int timesLoaned;

    public Book(String title, String author, int year, String isbn) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.isbn = isbn;
        this.available = true;
        this.timesLoaned = 0;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getYear() { return year; }
    public String getIsbn() { return isbn; }

    public boolean isAvailable() { return available; }

    public int getTimesLoaned() { return timesLoaned; }

    public void setAvailable(boolean available) { this.available = available; }
    public void setTimesLoaned(int timesLoaned) { this.timesLoaned = timesLoaned; }

 
    public boolean lend() {
        if (available) {
            available = false;
            timesLoaned++;
            return true;
        }
        return false;
    }

    public void returnBook() {
        available = true;
    }

    @Override
    public String toString() {
        return title + " (" + author + ", " + year + ") - ISBN: " + isbn +
                " - Disponible: " + available + " - Prestado " + timesLoaned + " veces";
    }
}
