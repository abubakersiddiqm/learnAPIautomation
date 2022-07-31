package sampleJava;

public class LearnVariable {

    /*/
    Global var,local var ,static var
     */
int a=12;
static double x=45.3;
public void method1(){
System.out.println(x);
}

    public static void main(String[] args) {
        int a=10;
        String name="flora";
        System.out.println("local var : " +a);
        LearnVariable v=new LearnVariable();
        System.out.println("global var " +v.a);
        v.method1();
        System.out.println(x);
    }

}
