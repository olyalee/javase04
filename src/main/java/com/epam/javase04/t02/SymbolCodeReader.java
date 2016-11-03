package com.epam.javase04.t02;

import com.epam.javase04.t01.KeyWords;

import java.io.*;

public class SymbolCodeReader {
    KeyWords k = new KeyWords();
    String fileName = "c:\\epam\\javase03\\src\\main\\java\\com\\epam\\unit3\\t02\\FAQ.java";

    //read from file
    public String readFromFile(){
        StringBuilder result = new StringBuilder();
        try(BufferedReader bf = new BufferedReader(new FileReader(fileName))){
            String s;
            while((s = bf.readLine())!=null){
                result.append(s);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    //create hashmap with counts of keywords in file
    public void searchForKeyWords(){
        String [] wordsFromFile = readFromFile().split("\\s+");
        for (String s: wordsFromFile) {
            if(k.javaKW.containsKey(s)){
                Integer count = (Integer) k.javaKW.get(s);
                k.javaKW.put(s,++count);
            }
        }
    }

    //write to file
    public void writeToFile(){
        try(FileWriter writer = new FileWriter("c:\\EPAM\\javase04\\src\\resources\\output.txt",false)){
            for(String s:k.keywords){
                if((Integer)k.javaKW.get(s)>0){
                    writer.write(s);
                    writer.write(" - ");
                    writer.write(k.javaKW.get(s).toString());
                    writer.write("; ");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
