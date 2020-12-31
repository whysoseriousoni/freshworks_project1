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
public class checkpass {

    A a = null;

    public checkpass() {
        this.a = A.yes;
        System.out.println(a);
    }

    void add2() {
//        a.add();
        System.out.println("called by "+this +A.a+" "+A.b);
        System.out.println("calling add2 from check pass by this class " + this);
        System.out.println(this);
    }

}
