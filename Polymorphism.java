public class Calculator {
    public int sum(int a,int b){
        return a+b;
    }
    public int sum(int a,int b,int c){
        return a+b+c;
    }
    public double sum(double a,double b){
        return a+b;
    }
    public int sum(int[] numbers){
        int sum=0;
        for(int number:numbers){
            sum+=number;
        }
        return sum;
    }
    public static void main(String[] args){
        Calculator calculator = new Calculator();
        int sum1 = calculator.sum(5,7);
        System.out.println("Sum of two integers: " + sum1);

        int sum2 = calculator.sum(5,7,9);
        System.out.println("Sum of three integers: " + sum2);

        double sum3 = calculator.sum(5.5,7.7);
        System.out.println("Sum of two floating point numbers: " + sum3);

        int[] numbers = {1,2,3,4,5};
        int sum4 = calculator.sum(numbers);
        System.out.println("Sum of an array of integers " + sum4);
    }
}
