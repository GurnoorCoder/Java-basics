class MyThread extends Thread { 
    public void run() { 
        for (int i = 1; i <= 5; i++) { 
            System.out.println("From Thread class: " + i); 
            try { Thread.sleep(500); } catch (InterruptedException e) {} 
        } 
    } 
} 
 
class MyRunnable implements Runnable { 
    public void run() { 
        for (int i = 1; i <= 5; i++) { 
            System.out.println("From Runnable interface: " + i); 
            try { Thread.sleep(500); } catch (InterruptedException e) {} 
        } 
    } 
} 
 
public class ThreadExample { 
    public static void main(String[] args) { 
        MyThread t1 = new MyThread(); 
        Thread t2 = new Thread(new MyRunnable()); 
        t1.start(); 
        t2.start(); 
    } 
}
