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

class keyval {

    private String key;
    Object val;
}

public class FileStorageReader {
    Scanner ss=null;

    String LAPID = null;
    String CUSTOM_PATH = null;

    Path path = Paths.get("");
    String cwd = path.toAbsolutePath().toString();// directory to freshworks
    final String DEFAULT_PATH = cwd + "\\src\\main\\java\\FileSystem";

    public FileStorageReader(String path, String lapID) {
        CUSTOM_PATH = path;
        LAPID = lapID;
    }

    public String KeyLengthException() {
        return "key length should be between 1 TO 32 ";
    }

    public FileStorageReader(String lapID) {
        CUSTOM_PATH = DEFAULT_PATH;
        LAPID = lapID;
    }

    public String returnJSONValue(String key) {
        if (key.length() > 32 || key.length() < 0) {
            return KeyLengthException();
        }

//        System.out.println(cwd+DEFAULT_PATH);
//        System.out.println(DEFAULT_PATH+"\\temp.json");
        System.out.println(DEFAULT_PATH + "\\" + CUSTOM_PATH);
        try (FileReader reader = new FileReader(DEFAULT_PATH + "\\" + "temp.json")) {

            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            JsonParser json = new JsonParser();
            JsonElement je = (JsonElement) json.parse(reader);

            // write 
            ss=new Scanner(System.in);
            System.out.println("ENTER KEY");
            String tld = ss.next();
            if (tld.length() <= 0 || tld.length() > 32) {
                System.err.println("KEY LENGTH SHOULD BE BETWEEN 1 AND 32");
                do {
                    tld = ss.next();
                } while (tld.length() <= 32 && tld.length() > 0);
            }
            GetValueToInsert response = new GetValueToInsert();
//            JsonObject obj=response.WriteData();
            System.out.println("FILE FOUND");

        } catch (Exception e) {
            System.err.println("NO SUCH FILE EXISTS");
        }

        return "";
    }

    public void WriteToJson()
    {
//        System.out.println(DEFAULT_PATH + "\\" + CUSTOM_PATH);
        try (FileReader reader = new FileReader(DEFAULT_PATH + "\\" + "temp.json")) {

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            JsonParser json = new JsonParser();
            JsonObject je = (JsonObject) json.parse(reader);
            System.out.println(gson.toJson(je));
            // write 
            ss=new Scanner(System.in);
            System.out.println("ENTER KEY");
            String tld = ss.next();
            if (tld.length() <= 0 || tld.length() > 32) {
                System.err.println("KEY LENGTH SHOULD BE BETWEEN 1 AND 32");
                do {
                    tld = ss.next();
                } while (tld.length() <= 32 && tld.length() > 0);
            }
            System.out.println("ENTER TIME FOR KEY TO LIVE or negative number for no time limit :");
            int time=ss.nextInt();
            tld+="-|-"+Integer.toString(time);
            JsonObject tojson=new JsonObject();
            GetValueToInsert response = new GetValueToInsert();
            JsonObject enter=response.WriteData();
            tojson.add(tld, enter);// key+value newly created
            
//            JsonObject asd=new JsonObject();
//            asd.add("lap-id", je);
//            asd.add(tld,enter);
//            System.out.println("adding later "+gson.toJson(asd));
            
            
            System.out.println(gson.toJson(tojson));
            System.out.println("FILE FOUND");

        } catch (Exception e) {
            System.out.println(e);
            System.err.println("NO SUCH FILE EXISTS");
        }
        
    }
    
    public static void main(String[] args) {
        // testing
        FileStorageReader fsr = new FileStorageReader("lap-id");
//        System.out.println(fsr.returnJSONValue("key-TTL(time)"));
        fsr.WriteToJson();
    }
}
