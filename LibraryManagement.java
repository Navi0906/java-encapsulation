// Interface
interface Reservable {
    void reserveItem(String borrower);
    boolean checkAvailability();
}

// Abstract class
abstract class LibraryItem {
    private String itemId;
    private String title;
    private String author;
    private boolean isReserved = false;
    private String borrower;

    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    public void getItemDetails() {
        System.out.println("ID: " + itemId + ", Title: " + title + ", Author: " + author);
    }

    // Encapsulated data (borrower's details)
    protected void setBorrower(String borrower) {
        this.borrower = borrower;
        this.isReserved = true;
    }

    protected String getBorrower() {
        return borrower;
    }

    // Abstract method
    public abstract int getLoanDuration();
}

// Book subclass
class Book extends LibraryItem implements Reservable {
    public Book(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    public int getLoanDuration() {
        return 14;
    }

    public void reserveItem(String borrower) {
        setBorrower(borrower);
        System.out.println("Book reserved for " + borrower);
    }

    public boolean checkAvailability() {
        return getBorrower() == null;
    }
}

// Magazine subclass
class Magazine extends LibraryItem implements Reservable {
    public Magazine(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    public int getLoanDuration() {
        return 7;
    }

    public void reserveItem(String borrower) {
        setBorrower(borrower);
        System.out.println("Magazine reserved for " + borrower);
    }

    public boolean checkAvailability() {
        return getBorrower() == null;
    }
}

// DVD subclass
class DVD extends LibraryItem implements Reservable {
    public DVD(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    public int getLoanDuration() {
        return 3;
    }

    public void reserveItem(String borrower) {
        setBorrower(borrower);
        System.out.println("DVD reserved for " + borrower);
    }

    public boolean checkAvailability() {
        return getBorrower() == null;
    }
}


public class LibraryManagement {
    public static void main(String[] args) {
        LibraryItem[] items = {
                new Book("B001", "Java Basics", "John Doe"),
                new Magazine("M001", "Tech Monthly", "Jane Smith"),
                new DVD("D001", "Inception", "Christopher Nolan")
        };

        for (LibraryItem item : items) {
            item.getItemDetails();
            System.out.println("Loan Duration: " + item.getLoanDuration() + " days");

            Reservable reservable = (Reservable) item;
            System.out.println("Available: " + reservable.checkAvailability());
            reservable.reserveItem("User1");
            System.out.println("Available after reservation: " + reservable.checkAvailability());
            System.out.println("-----------------------------");
        }
    }
}
