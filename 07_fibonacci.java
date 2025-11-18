import java.util.Scanner; 
 
public class Fibonacci { 
    public static int fibRecursive(int n) { 
        if (n <= 1) return n; 
        return fibRecursive(n - 1) + fibRecursive(n - 2); 
    } 
 
    public static void fibNonRecursive(int n) { 
        int a = 0, b = 1; 
        System.out.print("Fibonacci (non-recursive): " + a + " " + b + " "); 
        for (int i = 2; i < n; i++) { 
            int c = a + b; 
            System.out.print(c + " "); 
            a = b; b = c; 
        } 
    } 
 
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in); 
        System.out.print("Enter number of terms: "); 
        int n = sc.nextInt(); 
 
        System.out.print("Fibonacci (recursive): "); 
        for (int i = 0; i < n; i++) { 
            System.out.print(fibRecursive(i) + " "); 
        } 
        System.out.println(); 
        fibNonRecursive(n); 
    } 
}
