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
//import java.util.concurrent.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import com.mycompany.freshworks.GetValueToInsert;

import java.util.*;

class Key_time {

    String key;
    long time;
    String id;

    public Key_time(String key, long time, String id) {
        this.key = key;
        this.time = time;
        this.id = id;
    }

    public Key_time(String superKey) {
        String arr[] = superKey.split("---");
        this.key = arr[0];
        this.time = Long.parseLong(arr[1]);
        this.id = superKey;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;

        }
        if (!(obj instanceof Key_time)) {
            return false;
        }

        Key_time o = (Key_time) obj;
        return o.key.equals(this.key);
    }

    @Override
    public int hashCode() {
        return new String(key).hashCode() * 31;
    }

    @Override
    public String toString() {
        return this.key + "---" + this.time + "\n";
    }
}

public class FileStorageReader {

    Calendar cal = null;

    Scanner ss = null;
    ArrayList<String> keys = null;
    HashMap<Key_time, JsonObject> hashmap = null;
//    ConcurrentHashMap<Key_time, JsonObject> hashmap = null;

    JsonObject main = null;
    Key_time loc = null;

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
        hashmap = new HashMap<>();
//        hashmap = new ConcurrentHashMap<>();
        main = parse();
        keys = new ArrayList<>(main.keySet());
        setKeyData();

    }

    public FileStorageReader(String lapID) {
        CUSTOM_PATH = DEFAULT_PATH;
        LAPID = lapID;
        gson = new GsonBuilder().setPrettyPrinting().create();
        ss = new Scanner(System.in);
        cal = Calendar.getInstance();
        hashmap = new HashMap<>();

        main = parse();
        keys = new ArrayList<>(main.keySet());
        setKeyData();

    }

    public Key_time find(String key, long time) {
        Key_time ret = null;
        for (int i = 0; i < keys.size(); i++) {
            Key_time temp = new Key_time(keys.get(i).split("---")[0], Long.parseLong(keys.get(i).split("---")[1]), keys.get(i));
            if (temp.key.equals(key)) {
                System.out.println(key + " " + temp.key);
                if (temp.time >= time || temp.time == 0) {
                    ret = new Key_time(key, temp.time, temp.id);
                    return ret;
                } else if (temp.time < time) {
                    System.out.println("KEY EXPIRED");
                    ret = new Key_time(key, temp.time, temp.id);
                    System.out.println(ret);
                    System.out.println("delete called");
                    deleteKeyValue(ret);
                    System.out.println("null called due to time expiry");
                    return null;
                }
            }

        }
        System.out.println("null called due to no element");
        return null;
    }

    public void setKeyData() {
        for (int i = 0; i < keys.size(); i++) {
            String k = keys.get(i);
            String arr[] = k.split("---");
            hashmap.put(new Key_time(arr[0], Long.parseLong(arr[1]), k), (JsonObject) main.get(keys.get(i)));
//            kt.add(new Key_time(arr[0], Long.parseLong(arr[1]), k));

        }

    }

    public String KeyLengthException() {
        return "key length should be between 1 TO 32 ";
    }

    public JsonObject parse() {
        try (FileReader reader = new FileReader(CUSTOM_PATH + "\\" + "temp.json")) {
            JsonParser json = new JsonParser();
            main = (JsonObject) json.parse(reader);
            return main;
        } catch (Exception e) {
            System.out.println("null called due to cant parse the file");
            System.out.println(e);
            return null;
        }
    }

    public void printAllDataInStore() {

        for (int i = 0; i < keys.size(); i++) {
            Key_time temp = new Key_time(keys.get(i).split("---")[0], Long.parseLong(keys.get(i).split("---")[1]), keys.get(i));
            System.out.println(gson.toJson(hashmap.get(temp)));
        }
    }

    public String returnJSONValue(String key, long time) {
        if (key.length() > 32 || key.length() < 0) {
            return KeyLengthException();
        }
//        System.out.println(hashmap);
        boolean found = false, expired = false;

        JsonObject value = new JsonObject();

        loc = find(key, time);
        System.out.println(loc);
        System.out.println(gson.toJson(hashmap.get(loc)));
//        String id = key + "---" + Long.toString(time);// with this find the key

//        if (hashmap.containsKey(temp)) {
//            System.out.println("dafdsafdsf " + hashmap.equals(temp));
//            found = true;
////            value = hashmap.get();
//        }
//        for (int i = 0; i < keys.size(); i++) {
//        Key_time temp = new Key_time(key.split("---")[0], Long.parseLong(key.split("---")[1]), keys.get(i));
//        if (temp.) {
//            if (kt.get(i).key.equals(key) && kt.get(i).time >= time) {
//                found = true;
//                loc = kt.get(i);
//            } else if (kt.get(i).key.equals(key) && kt.get(i).time < time && kt.get(i).time != 0) {
//                expired = true;
//                loc = kt.get(i);
////                deleteKeyValue(loc.key, 0 ,i);
////            }
//           }
//        }
        if (found) {
            System.out.println("KEY FOUND IN DATA STORE");
//            System.out.println(gson.toJson(main.get(loc.id)));
        }
        if (expired) {
            System.out.println("KEY VALUE HAS EXPIRED");
        }

//        return "KEY DOESN'T EXIST";
        return "works good";
    }

    public boolean deleteKeyValue(String key) {
        Key_time del = find(key, 0);
        System.out.println("loc " + loc);
        if (del != null) {
//            System.out.println("string key not null");
//            System.out.println(gson.toJson(hashmap.get(loc)));
//            System.out.println("remove by string key ");
            System.out.println(gson.toJson(main.remove(del.id)));
            hashmap.remove(del);
            keys.remove(del.id);
            try (FileWriter file = new FileWriter(CUSTOM_PATH + "\\" + "temp2.json")) {
                gson.toJson(main, file);
            } catch (Exception e) {
                System.out.println(e);
            }
            return true;
        }
        return false;
    }

    public boolean deleteKeyValue(Key_time key) {
        System.out.println("remove by key_time");
        System.out.println(gson.toJson(main.remove(key.id)));
        hashmap.remove(key);
        keys.remove(key.id);
        try (FileWriter file = new FileWriter(CUSTOM_PATH + "\\" + "temp2.json")) {
            gson.toJson(main, file);
        } catch (Exception e) {
            System.out.println(e);
        }
        return true;

//            System.out.println(hashmap.remove(key));
//            System.out.println(gson.toJson(main));
//        main.remove(key.id);
//            System.out.println("asdjkghjkadfsy inol;asd;lk");
//            System.out.println(gson.toJson(main));
        //printAllDataInStore();
//            System.out.println(gson.toJson(hashmap.get(key)));
//            keys.remove(key);
//            System.out.println("sdfnsdlk " + kt.equals(temp));
    }

//            System.out.println(gson.toJson(main.remove(id)));
//            System.out.println("sdfnsdlk " + kt.remove(index));
//        return false;
    public void WriteToJson() {
//        System.out.println(CUSTOM_PATH + "\\" + CUSTOM_PATH);
        try (FileReader reader = new FileReader(CUSTOM_PATH + "\\" + "temp.json")) {

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
            if (time <= 0) {
                time = 0;
                tld += "---0";

            } else {
                tld += "---" + Long.toString((time * 1000) + cal.getTimeInMillis());
            }

            JsonObject tojson = new JsonObject();
            GetValueToInsert response = new GetValueToInsert();
            JsonObject enter = response.WriteData();// user needs to enter data in CLI
            main.add(tld, enter);// key+value newly created

            hashmap.put(new Key_time(tld), enter);
            keys.add(tld);
            System.out.println(gson.toJson(main));
            try (FileWriter file = new FileWriter(CUSTOM_PATH + "\\" + "temp2.json")) {
                gson.toJson(main, file);
                System.out.println("UPDATED JSON FILE ");
            } catch (Exception e) {
                System.out.println("file handle exception during writing" + e);
            }

        } catch (Exception e) {
            System.out.println(e);
            System.err.println("NO SUCH FILE EXISTS");
        }

    }

    public static void main(String[] args) {
        // testing
        FileStorageReader fsr = new FileStorageReader("lap-id");
        Calendar cal = Calendar.getInstance();
//        System.out.println(fsr.returnJSONValue("key1", cal.getTimeInMillis()));
//        fsr.printAllDataInStore();
//        System.out.println("DELTE 1");
//        fsr.deleteKeyValue("key2");
//        System.out.println("DELTE 2");
//        fsr.deleteKeyValue("key3");
//        System.out.println("final asdlkhlkdf print");
//        fsr.printAllDataInStore();
//        System.out.println(cal.getTimeInMillis());
//        System.out.println(fsr.returnJSONValue("asdfsdf", cal.getTimeInMillis()));
//        System.out.println(fsr.returnJSONValue("key---1609100985702"));
        fsr.WriteToJson();

//        fsr.printAllDataInStore();
//        fsr.deleteKeyValue("key1", 0,1);
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
