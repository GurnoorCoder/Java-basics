import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int feet=sc.nextInt();
        double meters=3.28*feet;
        System.out.println("The conversion from meter to feet is : "+meters+" feet");
    }
}
