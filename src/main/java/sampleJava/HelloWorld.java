package sampleJava;

public class HelloWorld {

   public HelloWorld(){
       System.out.println("Flora");
    }

    public HelloWorld(String names){
        System.out.println(names);
    }
    public void person(){
       System.out.println("Vijay");
    }

    public static void main(String[] args) {
        HelloWorld hello=new HelloWorld("abu");
        HelloWorld hello1=new HelloWorld();
        hello.person();
        hello1.person();
    }
}
