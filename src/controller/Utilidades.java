/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


/**
 *
 * @author alexa
 */
public class Utilidades {
    private final String path = "data"; 
    public void save(String text, String name_file) throws IOException{
        File carpeta = new File(path);
        if(!carpeta.exists()){
            carpeta.mkdirs();
        }
         File file = new File(path+File.separatorChar+name_file);
        if(!file.exists()){
            file.createNewFile();
        }
        FileWriter escribir = new FileWriter(file, true);
        escribir.write(text);
        escribir.close();
    }

   
    public List<String> readLines(String name_file) throws IOException {
        List<String> lines = new ArrayList<>();
        File file = new File(path + File.separatorChar + name_file);
        if (!file.exists()) {
            return lines;
        }

        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while ((line = br.readLine()) != null) {
            lines.add(line);
        }
        br.close();
        return lines;
    }
}

