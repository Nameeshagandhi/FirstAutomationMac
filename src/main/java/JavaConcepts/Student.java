package JavaConcepts;

public class Student {
    int id;
    String name;
    int age;

    Student(int i, String n) {
        id = i;
        name = n;
    }
    Student(int i,String n,int a){
        id=i;
        name=n;
        age=a;
    }
    void display(){
        System.out.println(id+" "+name+" "+age);
    }
    public static void main(String args[]) {
        Student student = new Student(1,"Nameesha");
        student.display();

        Student s1 = new Student(111,"Karan",23);
        Student s2 = new Student(222,"Aryan",25);
        s1.display();
        s2.display();

    }
}

