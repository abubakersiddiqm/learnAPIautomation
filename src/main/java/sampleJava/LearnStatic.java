package sampleJava;

public class LearnStatic {
    //static varible
    static int a = 10;

    //Static method
    static void nameperson() {
        System.out.println("flora");
        a = 12;
        System.out.println("static method " + a);

    }

    //Static block
    static String name;

    static {
        name = "vijay";
    }

    public static void main(String[] args) {
        System.out.println(a);
        nameperson();
        a = 11;
        System.out.println("inside main method " + a);
        System.out.println("inside main 2 " + a);
        System.out.println("staticblock " + name);

    }
}
