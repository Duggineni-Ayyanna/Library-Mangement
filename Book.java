import java.util.ArrayList;
import java.util.Scanner;

class User{
    private String name;
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
}
class Library{
    static boolean issued;
    static boolean isIssued(){
       return issued = true;
    }

}
public class Book {
    private int id;
    private String bookName;
    private String author;
     Book(int id,String bookName,String author){
        this.id = id;
        this.bookName = bookName;
        this.author = author;
    }
    public int getId() {
        return id;
    }
    public String getBookName() {
        return bookName;
    }
    public String getAuthor() {
        return author;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", bookName=" + bookName + ", author=" + author + '}';
    }

    public static void main(String[] args) {
         boolean running = true;
         Scanner sc = new Scanner(System.in);
         ArrayList<Book> books = new ArrayList<>();
         System.out.println("Enter 1 if you are librarian || 2 if you are User");
         int selection = sc.nextInt();
         if(selection == 1){
             while(running){
                 System.out.println("Enter your choice 1.Add 2.Delete 3.Update 4.view 5.Exit ");
                 int choice = sc.nextInt();
                 if(choice == 1) {
                     System.out.println("Enter Book Name:");
                     String bookName = sc.next();
                     System.out.println("Enter Author:");
                     String author = sc.next();
                     System.out.println("Enter Book ID:");
                     int id = sc.nextInt();
                     books.add(new Book(id,bookName,author));
                     System.out.println("Successfully Added!");
                 }
                 else if(choice == 2) {
                     System.out.println("Enter Book Name:");
                     String bookName = sc.next();
                     for(Book book : books) {
                         String getBookName = book.getBookName();
                         if(getBookName.equals(bookName)) {
                             books.remove(book);
                             System.out.println("Successfully Deleted!");
                         }
                         else {
                             System.out.println("Book Not Found!");
                         }
                     }

                 }
                 else if(choice == 3) {
                     System.out.println("Enter Book Name:");
                     String bookName = sc.next();
                     for(Book book :books){
                         if(book.getBookName().equals(bookName)){
                             System.out.println("Enter new Book ID:");
                             int id = sc.nextInt();
                             book.setId(id);
                             System.out.println("Enter new Book Name:");
                             String bookName2 = sc.next();
                             book.setBookName(bookName2);
                             System.out.println("Enter new Book Author:");
                             String author2 = sc.next();
                             book.setAuthor(author2);
                             System.out.println("Updated book successfully!");
                         }
                     }
                 }
                 else if(choice == 4) {
                     System.out.println(books);
                 }
                 else if(choice == 5) {
                     running = false;
                     System.out.println("You choosed to exit!");
                 }
                 else {
                     System.out.println("Invalid choice!");
                 }
             }
         }
         else if(selection == 2){
            while (running){
                System.out.println("Enter 1 to Take and 2 to Return");
                int choice = sc.nextInt();
                if(choice == 1) {
                    System.out.println("Enter Book Name:");
                    String bookName = sc.next();
                    for (Book b : books ){
                        String bookName2 = b.getBookName();
                        if(bookName2.equals(bookName) && !Library.isIssued()){
                            System.out.println(b);
                            System.out.println("Successfully Issued!");

                        }
                        else {
                            System.out.println("Invalid Book Name! / Book not Available!");
                        }

                    }
                }
                else if(choice == 2) {
                    System.out.println("Enter Book Name:");
                    String bookName = sc.next();
                    for (Book b : books) {
                        String bookName2 = b.getBookName();
                        if (bookName2.equals(bookName) && Library.isIssued()) {
                            System.out.println(b + "id Returned successfully!");
                        } else {
                            System.out.println("Invalid Book Name! / Book is not issued");
                        }
                    }
                }
                else {
                    running = false;
                    System.out.println("Invalid choice!");

                }

             }

         }

    }
}
