class ThisDemo {
    int num = 3;

    public void set() {
        num++;
    }

    public void get() {
        System.out.println(num);
    }
}

public class Main {
    public static void main(String[] args) {
        ThisDemo ob1 = new ThisDemo();
        ThisDemo ob2 = new ThisDemo();
        ThisDemo ob3 = new ThisDemo();

        ob1.set();
        ob1.set();
        ob2.set();
        ob3.set();
        ob3.set();
        ob3.set();

        ob1.get(); // 5
        ob2.get(); // 4
        ob3.get(); // 6
    }
}
