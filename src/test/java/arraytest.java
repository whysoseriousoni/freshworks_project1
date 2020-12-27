
import com.google.gson.Gson;
import com.google.gson.*;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author WhysoseriousONI
 */
public class arraytest {

    public String json = "";
    Scanner ss = null;
    public JsonObject toretJsonObject = null;

    public void getData() {
        ss = new Scanner(System.in);
        toretJsonObject = new JsonObject();
        int type, c, cnt = 0;

        type = ss.nextInt();
        switch (type) {

            case 5: {

                int ip1 = 0;
                System.out.println("TYPE 5");
                System.out.println("ENTER STRING KEY");
                String key = ss.next();

                JsonArray global = new JsonArray();

                do {

                    System.out.println("TYPE 5 inside Array");
                    System.out.println("CHOOSE THE TYPE OF DATA TO ENTER ");
                    System.out.println("1 String ");
                    System.out.println("2 Integer ");
                    System.out.println("3 Float ");
                    System.out.println("4 Boolean ");
                    System.out.println("5 Array ");
                    System.out.println("-1 to exit ");
                    System.out.println("c");
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
                                System.out.println("ENTER -1 TO EXIT or ANY NUMBER TO CONINUE");
                                ip1 = ss.nextInt();
                                cnt++;

                            } while (ip1 != -1);
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

                                System.out.println("ENTER -1 TO EXIT or ANY NUMBER TO CONINUE");
                                ip1 = ss.nextInt();
                                cnt++;
                            } while (ip1 != -1);

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

                                System.out.println("ENTER -1 TO EXIT or ANY NUMBER TO CONINUE");
                                ip1 = ss.nextInt();
                                cnt++;
                            } while (ip1 != -1);
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

                                System.out.println("ENTER -1 TO EXIT or ANY NUMBER TO CONINUE");
                                ip1 = ss.nextInt();
                                cnt++;
                            } while (ip1 != -1);
//                            arr.add(temp);
                            global.add(temp);
                        }
                        case 5 -> {
                            JsonObject temp = new JsonObject();
//                            JsonArray tt = new JsonArray();
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
                                System.out.println("ENTER -1 TO EXIT or ANY NUMBER TO CONINUE");
                                ip1 = ss.nextInt();
                                temp.add(key1, arrt);
                                
                            } while (ip1 != -1);
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
        }

        Gson job = new GsonBuilder().setPrettyPrinting().create();
        System.out.println(job.toJson(toretJsonObject));
        System.out.println();

    }

    public static void main(String[] args) {
        arraytest test = new arraytest();
        test.getData();
    }
}
