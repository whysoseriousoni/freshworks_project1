/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classPass;

/**
 *
 * @author WhysoseriousONI
 */
class A {

    public static int a;
    public static String b;
    public static A yes = null;

    A(int a, String b) {
        this.a = a;
        this.b = b;
    }

    public static A getIn(int o, String s) {
        if (yes == null) {
            yes = new A(o, s);
            a=o;
            b=s;
        }
        return yes;
    }
//    checkpass cp = new checkpass();

    void add() {
        System.out.println("cp.add2() ");
//        System.out.println("CP.this"); cp.add2();
        System.out.println("A+B class called by " + this + a + b);
    }

}

public class classPass {

    public static void main(String[] args) {
        A a = A.getIn(1, " asdfslkjghlksdjfk jsdd");
//        A b = new A(2, "2");
//        a.add();
        checkpass cp = new checkpass();
        cp.add2();
    }
}
