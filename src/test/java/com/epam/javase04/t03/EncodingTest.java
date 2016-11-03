package com.epam.javase04.t03;

import org.junit.Test;

public class EncodingTest {
    @Test
    public void encode(){
        String filenameFrom = "c:\\EPAM\\javase04\\src\\resources\\hello_utf8.txt";
        String filenameTo = "c:\\EPAM\\javase04\\src\\resources\\hello_utf16.txt";

        EncodeFromUTF8ToUTF16.readAndWrite(filenameFrom,filenameTo);
    }
}
