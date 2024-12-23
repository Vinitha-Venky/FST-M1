package hello;

//Abstract class
abstract class Book {
 String title;

 // Abstract method
 abstract void setTitle(String s);
 
 // Concrete method
 String getTitle() {
     return title;
 }
}

//Class MyBook extends abstract class Book
class MyBook extends Book {
 // Implement the abstract method
 public void setTitle(String s) {
     title = s;
 }
}

//Main class to test the implementation
public class Activity5 {
 
 public static void main(String []args) {
     // Initialize title of the book
     String title = "Hover Car Racer";
     
     // Create object for MyBook
     Book newNovel = new MyBook();
     
     // Set title
     newNovel.setTitle(title);
     
     // Print result
     System.out.println("The title is: " + newNovel.getTitle());
 }
}