import java.util.ArrayList;

class Student {
    private String name;
    private int age;
    private String address;

    public Student(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        for(int i = 0; i < 10; i++) {
            System.out.println(i);
        }

        ArrayList<String> list=new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
    }
}
