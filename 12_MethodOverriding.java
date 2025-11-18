class Parent {
    void print() {
        System.out.println("parent class");
    }
}

class Subclass1 extends Parent {
    void print() {
        System.out.println("subclass1");
    }
}

class Subclass2 extends Parent {
    void print() {
        System.out.println("subclass2");
    }
}

public class Student {
    public static void main(String[] args) {
        Parent a;
        a = new Subclass1();
        a.print();

        a = new Subclass2();
        a.print();
    }
}
