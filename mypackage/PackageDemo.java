package mypackage;
import mypackage.MyClass;
public class PackageDemo {
    public static void main(String[] args) {
        MyClass obj=new MyClass();
        System.out.println("Value from package: "+obj.x);
    }
}
