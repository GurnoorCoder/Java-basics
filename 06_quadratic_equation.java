import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        
        System.out.print("Enter the value of a: ");
        double a=scanner.nextDouble();
        
        System.out.print("Enter the value of b: ");
        double b=scanner.nextDouble();
        
        System.out.print("Enter the value of c: ");
        double c=scanner.nextDouble();
        
        double discriminant=b*b-4*a*c;
        
        if(discriminant<0){
            System.out.println("There will be no real solutions");
        }
        else if(discriminant==0){
            double solution=-b/(2*a);
            System.out.println("There will be one real solution which is :"+solution);
        }
        else{
            double solution1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double solution2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.println("There will be two real solutions: "+solution1+" and "+solution2);
        }
        scanner.close();
    }
}
