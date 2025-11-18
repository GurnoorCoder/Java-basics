public class tryexcept {
    public static void main(String[] args) {
        try{
            int[] arr=new int[5];
            arr[10]=50/0;
        }catch(ArithmeticException e){
            System.out.println("Arithmetic Error: "+e.getMessage());
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Array index error: "+e.getMessage());
        }catch(Exception e){
            System.out.println("Generic Error:"+e.getMessage());
        }
    }
}
