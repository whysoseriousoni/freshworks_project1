/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.freshworks;

/**
 *
 * @author WhysoseriousONI
 */
import java.util.*;
import com.google.gson.*;
import com.google.gson.JsonParser.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
 
// takes input and returns JsonObject
public class GetValueToInsert {

    public String json = "";
    Scanner ss = null;
    public JsonObject toretJsonObject = null;
//    public JsonObject ret=null;

    public JsonObject WriteData() {
        int type, cnt = 0;
        
//        ret.add(tld, toretJsonObject);
        do {
            System.out.println("CHOOSE THE TYPE OF DATA TO ENTER ");
            System.out.println("1 String ");
            System.out.println("2 Integer ");
            System.out.println("3 Float ");
            System.out.println("4 Boolean ");
            System.out.println("5 Array ");
            System.out.println("6 JSON like input");
            System.out.println("-1 to exit ");
            type = ss.nextInt();

            switch (type) {
//            type = ss.nextInt();
                case 1: {
                    String ip = "0";
                    do {
                        System.out.println("TYPE 1");
                        System.out.println("ENTER STRING KEY");
                        String key = ss.next();
                        if (key.length() <= 0 || key.length() > 32) {
                            System.err.println("KEY LENGTH SHOULD BE BETWEEN 1 AND 32");
                            continue;
                        }
                        System.out.println("ENTER STRING VALUE");
                        String val = ss.next();
                        toretJsonObject.addProperty(key, val);
                        System.out.println("ENTER ANY NUMBER TO INSERT MORE DATA OR -1 TO EXIT ");
                        ip = ss.next();

                        cnt++;
                    } while (!ip.equals("-1"));
                    break;

                }
                case 2: {
                    String ip = "0";
                    do {
                        System.out.println("TYPE 2");
                        System.out.println("ENTER STRING KEY");
                        String key = ss.next();
                        if (key.length() <= 0 || key.length() > 32) {
                            System.err.println("KEY LENGTH SHOULD BE BETWEEN 1 AND 32");
                            continue;
                        }
                        System.out.println("ENTER Integer VALUE");
                        Integer val = ss.nextInt();

                        toretJsonObject.addProperty(key, val);

                        System.out.println("ENTER ANY NUMBER TO INSERT MORE DATA OR -1 TO EXIT ");
                        ip = ss.next();
                        cnt++;
                    } while (!ip.equals("-1"));
                    break;
                }
                case 3: {
                    String ip = "0";
                    do {

                        System.out.println("TYPE 3");
                        System.out.println("ENTER STRING KEY");
                        String key = ss.next();
                        if (key.length() <= 0 || key.length() > 32) {
                            System.err.println("KEY LENGTH SHOULD BE BETWEEN 1 AND 32");
                            continue;
                        }
                        System.out.println("ENTER Float VALUE");
                        Float val = ss.nextFloat();

                        toretJsonObject.addProperty(key, val);

                        System.out.println("ENTER ANY NUMBER TO INSERT MORE DATA OR -1 TO EXIT ");
                        ip = ss.next();
                        cnt++;
                    } while (!ip.equals("-1"));
                    break;
                }
                case 4: {

                    String ip = "0";
                    do {
                        System.out.println("TYPE 4");
                        System.out.println("ENTER STRING KEY");
                        String key = ss.next();
                        if (key.length() <= 0 || key.length() > 32) {
                            System.err.println("KEY LENGTH SHOULD BE BETWEEN 1 AND 32");
                            continue;
                        }
                        System.out.println("ENTER Boolean VALUE");
                        boolean val = ss.nextBoolean();

                        toretJsonObject.addProperty(key, val);

                        System.out.println("ENTER ANY NUMBER TO INSERT MORE DATA OR -1 TO EXIT ");
                        ip = ss.next();
                        cnt++;
                    } while (!ip.equals("-1"));
                    break;
                }
                case 5: {

                    String ip1;
                    System.out.println("TYPE 5");
                    System.out.println("ENTER STRING KEY");
                    String key = ss.next();
                    if (key.length() <= 0 || key.length() > 32) {
                        System.err.println("KEY LENGTH SHOULD BE BETWEEN 1 AND 32");
                        continue;
                    }

                    JsonArray global = new JsonArray();
                    int c;

                    do {

                        System.out.println("TYPE 5 inside Array");
                        System.out.println("CHOOSE THE TYPE OF DATA TO ENTER ");
                        System.out.println("1 String ");
                        System.out.println("2 Integer ");
                        System.out.println("3 Float ");
                        System.out.println("4 Boolean ");
                        System.out.println("5 Array ");
                        System.out.println("-1 to exit ");
                        System.out.println("inside case 5 array ");
                        c = ss.nextInt();

                        JsonArray arr = new JsonArray();

                        switch (c) {

                            case 1 -> {

                                JsonObject temp = new JsonObject();
                                do {
                                    System.out.println("TYPE 1 inside Array");
                                    System.out.println("ENTER STRING KEY");

                                    String key1 = ss.next();

                                    System.out.println("ENTER STRING VALUE");
                                    String val1 = ss.next();
                                    temp.addProperty(key1, val1);
                                    System.out.println("ENTER ANY NUMBER TO INSERT MORE DATA OR -1 TO EXIT ");
                                    ip1 = ss.next();
                                    cnt++;

                                } while (!ip1.equals("-1"));;
//                            arr.add(temp);
                                global.add(temp);

                            }
                            case 2 -> {

                                JsonObject temp = new JsonObject();
                                do {
                                    System.out.println("TYPE 2 inside Array");
                                    System.out.println("ENTER STRING KEY");
                                    String key1 = ss.next();
                                    System.out.println("ENTER Integer VALUE");
                                    Integer val1 = ss.nextInt();

                                    temp.addProperty(key1, val1);

                                    System.out.println("ENTER ANY NUMBER TO INSERT MORE DATA OR -1 TO EXIT ");
                                    ip1 = ss.next();
                                    cnt++;
                                } while (!ip1.equals("-1"));;

//                            arr.add(temp);
                                global.add(temp);
                            }
                            case 3 -> {

                                JsonObject temp = new JsonObject();
                                do {

                                    System.out.println("TYPE 3 inside Array");
                                    System.out.println("ENTER STRING KEY");
                                    String key1 = ss.next();
                                    System.out.println("ENTER Float VALUE");
                                    Float val1 = ss.nextFloat();

                                    temp.addProperty(key1, val1);

                                    System.out.println("ENTER ANY NUMBER TO INSERT MORE DATA OR -1 TO EXIT ");
                                    ip1 = ss.next();
                                    cnt++;
                                } while (!ip1.equals("-1"));;
//                            arr.add(temp);
                                global.add(temp);
                            }
                            case 4 -> {

                                JsonObject temp = new JsonObject();

                                do {
                                    System.out.println("TYPE 4 inside Array");
                                    System.out.println("ENTER STRING KEY");
                                    String key1 = ss.next();
                                    System.out.println("ENTER Boolean VALUE");
                                    boolean val1 = ss.nextBoolean();

                                    temp.addProperty(key1, val1);

                                    System.out.println("ENTER ANY NUMBER TO INSERT MORE DATA OR -1 TO EXIT ");
                                    ip1 = ss.next();
                                    cnt++;
                                } while (!ip1.equals("-1"));;
//                            arr.add(temp);
                                global.add(temp);
                            }
                            case 5 -> {
                                JsonObject temp = new JsonObject();
                                do {
                                    JsonArray arrt = new JsonArray();

                                    //array
                                    System.out.println("ENTER STRING KEY");
                                    String key1 = ss.next();
                                    System.out.println("ENTER Number of elements in array");
                                    Integer n = ss.nextInt();
                                    for (int i = 0; i < n; i++) {
                                        System.out.println("ENTER ARRAY DATA");
                                        arrt.add(ss.next());
                                    }
                                    cnt++;
                                    System.out.println("ENTER ANY NUMBER TO INSERT MORE DATA OR -1 TO EXIT ");
                                    ip1 = ss.next();
                                    temp.add(key1, arrt);

                                } while (!ip1.equals("-1"));;
                                global.add(temp);
                                cnt++;
                            }
                        }
//                    toretJsonObject.add(key, global);
//                    toretJsonObject.add(key, arr);
                    } while (c != -1);
//                    toretJsonObject.add(key, temp);
                    toretJsonObject.add(key, global);
                    break;
                }

                case 6: {
                    System.out.println("INPUT DATA HAS TO BE IN A SINGLE LINE WITH JSON STRUCTURE");
                    String str = "";
                    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                    try {
                        str += br.readLine();
                    } catch (Exception e) {
                        System.err.println("not json format please check the syntax");
                        break;
                    }

                    JsonParser jsonParser = new JsonParser();
                    toretJsonObject = (JsonObject) jsonParser.parse(str);
                    System.out.println("FORCIBLE EXIT");
                    type = -1;
                    break;
                }

                case -1: {
                    System.out.println("-1");
                    if (cnt == 0) {
                        toretJsonObject.addProperty("NULL", "NULL");
                        break;
                    }
                    break;
                }
                default: {
                    System.out.println("SHOULD CHOOSE BETWEEN THE OPTIONS SPECIFIED");
//                    break;
                }

            }
        } while (type != -1);
        
        return toretJsonObject;
    }

    public GetValueToInsert() {
        ss = new Scanner(System.in);
        toretJsonObject = new JsonObject();
    }

    public static void main(String[] args) {
        // testing
        GetValueToInsert gv = new GetValueToInsert();
        Gson job = new GsonBuilder().setPrettyPrinting().create();
        System.out.println(job.toJson(gv.WriteData()));

    }

}


/*

tld
1
sdfg
hdjfgs
-1
-1

*/
