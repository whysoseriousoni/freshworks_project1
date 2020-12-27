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

class jsonStructure{
    private String lapid;
    
    
}
class keyval{
    private String key;
    Object val;
}

public class FileStorageReader {

    String LAPID = null;
    String CUSTOM_PATH = null;
    
    Path path=Paths.get("");
    String cwd=path.toAbsolutePath().toString();// directory to freshworks
    final String DEFAULT_PATH = cwd+"\\src\\main\\java\\FileSystem";
    
    public FileStorageReader(String path, String lapID) {
        CUSTOM_PATH = path;
        LAPID = lapID;
    }
    
    public String KeyLengthException()
    {
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
System.out.println(DEFAULT_PATH+"\\temp.json");
        try(FileReader reader=new FileReader(DEFAULT_PATH+"\\"+CUSTOM_PATH))
        {
            
            Gson job=new GsonBuilder().setPrettyPrinting().create();
            
            JsonParser json=new JsonParser();
            JsonElement je=(JsonElement)json.parse(reader);
            System.out.println("FILE FOUND");
            

        }catch(Exception e){
            System.err.println("NO SUCH FILE EXISTS");
        }
        
        return "";
    }

    public static void main(String[] args) {
        // testing
        FileStorageReader fsr=new FileStorageReader("lap-id");
        System.out.println(fsr.returnJSONValue("key-TTL(time)"));
    }
}
