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
import com.google.gson.Gson;
import com.google.gson.*;
import java.io.*;

import java.nio.file.Path;
import java.nio.file.Paths;
import com.mycompany.freshworks.GetValueToInsert;

import java.util.*;

class jsonStructure {

    private String lapid;
}

class Key_time {

    String key;
    long time;
    String id;

    public Key_time(String key, long time, String id) {
        this.key = key;
        this.time = time;
        this.id = id;
    }
}

public class FileStorageReader {

    Calendar cal = null;

    Scanner ss = null;
    ArrayList<Key_time> kt = null;
    ArrayList<String> keys = null;
    JsonObject main = null;
    Gson gson = null;
    String LAPID = null;
    String CUSTOM_PATH = null;

    Path path = Paths.get("");
    String cwd = path.toAbsolutePath().toString();// directory to freshworks
    final String DEFAULT_PATH = cwd + "\\src\\main\\java\\FileSystem";

    public FileStorageReader(String path, String lapID) {
        CUSTOM_PATH = path;

        LAPID = lapID;
        ss = new Scanner(System.in);
        gson = new GsonBuilder().setPrettyPrinting().create();
        cal = Calendar.getInstance();
        main = parse();
        kt = new ArrayList<>();
        keys = new ArrayList<>(main.keySet());
        setKeyData();

    }

    public FileStorageReader(String lapID) {
        CUSTOM_PATH = DEFAULT_PATH;
        LAPID = lapID;
        gson = new GsonBuilder().setPrettyPrinting().create();
        ss = new Scanner(System.in);
        cal = Calendar.getInstance();

        main = parse();
        kt = new ArrayList<>();
        keys = new ArrayList<>(main.keySet());
        setKeyData();

    }

    public void setKeyData() {
        for (int i = 0; i < keys.size(); i++) {
            String k = keys.get(i);
            String arr[] = k.split("---");
            kt.add(new Key_time(arr[0], Long.parseLong(arr[1]), k));

        }
    }

    public String KeyLengthException() {
        return "key length should be between 1 TO 32 ";
    }

    public JsonObject parse() {
        try (FileReader reader = new FileReader(DEFAULT_PATH + "\\" + "temp.json")) {
            JsonParser json = new JsonParser();
            main = (JsonObject) json.parse(reader);
            return main;
        } catch (Exception e) {
            return null;
        }
    }

    public void printAllDataInStore() {
        for (int i = 0; i < keys.size(); i++) {
            System.out.println(gson.toJson(main.get(kt.get(i).id)));
        }
    }

    public String returnJSONValue(String key) {
        if (key.length() > 32 || key.length() < 0) {
            return KeyLengthException();
        }

        Key_time loc = null;
        boolean found = false;
        for (int i = 0; i < keys.size(); i++) {

            if (kt.get(i).id.equals(key)) {
                found = true;
                loc = kt.get(i);
            }
        }
        if (found) {
            System.out.println("KEY FOUND IN DATA STORE");
            System.out.println(gson.toJson(main.get(loc.id)));
        }

        return "KEY DOESN'T EXIST";
    }

    public void WriteToJson() {
//        System.out.println(DEFAULT_PATH + "\\" + CUSTOM_PATH);
        try (FileReader reader = new FileReader(DEFAULT_PATH + "\\" + "temp.json")) {

            // write 
            System.out.println("ENTER KEY");
            String tld = ss.next();
            if (tld.length() <= 0 || tld.length() > 32) {
                System.err.println("KEY LENGTH SHOULD BE BETWEEN 1 AND 32");
                do {
                    tld = ss.next();
                } while (tld.length() <= 32 && tld.length() > 0);
            }
            System.out.println("ENTER TIME FOR KEY TO LIVE or negative number for no time limit :");

            long time = ss.nextLong();
            tld += "---" + Long.toString((time * 1000) + cal.getTimeInMillis());
            JsonObject tojson = new JsonObject();
            GetValueToInsert response = new GetValueToInsert();
            JsonObject enter = response.WriteData();
            tojson.add(tld, enter);// key+value newly created
            System.out.println(gson.toJson(tojson));

        } catch (Exception e) {
            System.out.println(e);
            System.err.println("NO SUCH FILE EXISTS");
        }

    }

    public static void main(String[] args) {
        // testing
        FileStorageReader fsr = new FileStorageReader("lap-id");
//        System.out.println(fsr.returnJSONValue("asdfsdf---1"));
//        System.out.println(fsr.returnJSONValue("key---10"));
//        fsr.WriteToJson();
        fsr.printAllDataInStore();
    }
}


/*

asd

0
1
adff
fdgh
-1
-1

 */
