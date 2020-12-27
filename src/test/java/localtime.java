/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author WhysoseriousONI
 */
import java.time.*;
import java.util.Calendar;
public class localtime {
    public static void main(String[] args) {
        Calendar date=Calendar.getInstance();
        long t=date.getTimeInMillis();
        System.out.println(t);
//        1609090768511

    }
}
