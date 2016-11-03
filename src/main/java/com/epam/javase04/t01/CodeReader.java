package com.epam.javase04.t01;

/*Задание 1. Работа с байтовыми потоками ввода-вывода

Прочитайте файл, содержащий код на языке Java. Определите, какие ключевые слова языка Java это код содержит.
Выведите эти слова и их количество в другой файл. Используйте только байтовые потоки ввода-вывода.*/

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class CodeReader {
    KeyWords k = new KeyWords();
    String fileName = "c:\\epam\\javase03\\src\\main\\java\\com\\epam\\unit3\\t02\\FAQ.java";
    String fileToWrite = "c:\\EPAM\\javase04\\src\\resources\\output.txt";

    //reading from file
    public StringBuilder readFile(){
        StringBuilder readFromFile = new StringBuilder();
        try(FileInputStream inFile = new FileInputStream(fileName)){
            int b = 0;
            while ((b = inFile.read())!=-1){
                readFromFile.append((char)b);
            }
        } catch (
                FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return readFromFile;
    }

    //create hashmap with counts of keywords in file
    public void searchForKeyWords(){
        String [] wordsFromFile = readFile().toString().split("\\s+");
        for (String s: wordsFromFile) {
            if(k.javaKW.containsKey(s)){
                Integer count = (Integer) k.javaKW.get(s);
                k.javaKW.put(s,++count);
            }
        }
    }

    //write in file
    public void writeFile(){
     try(FileOutputStream out = new FileOutputStream(fileToWrite,false)) {
         for(String s:k.keywords){
             if((Integer)k.javaKW.get(s)>0) {
                 out.write(s.getBytes());
                 out.write(" - ".getBytes());
                 out.write(k.javaKW.get(s).toString().getBytes());
                 out.write("; ".getBytes());
             }
        }
    } catch (IOException e) {
         e.printStackTrace();
     }
    }

//    public void show(){
//        for (String s: keywords) {
//            System.out.println(s);
//        }
//    }


}
