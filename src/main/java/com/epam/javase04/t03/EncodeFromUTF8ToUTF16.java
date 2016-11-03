package com.epam.javase04.t03;

import java.io.*;
import java.nio.charset.Charset;

public class EncodeFromUTF8ToUTF16 {
        static StringBuilder text = new StringBuilder();

    public static boolean readAndWrite(String from, String to){
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(from), Charset.forName("UTF-8")))){
            String nextLine;
            while((nextLine=bf.readLine())!=null){
                text.append(nextLine);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(to),Charset.forName("UTF-16")))){
            bw.write(text.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

}
