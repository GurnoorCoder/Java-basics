class Person { 
    String name = "John"; 
 
    public void display() { 
        System.out.println("Person Name: " + name); 
    } 
} 
 
class Student extends Person { 
    String name = "Alice"; 
 
    public void display() { 
        super.display();  // calls parent method 
        System.out.println("Student Name: " + name); 
    } 
} 
 
public class InheritanceDemo { 
    public static void main(String[] args) { 
        Student s = new Student(); 
        s.display(); 
    } 
} 
