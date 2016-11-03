package com.epam.javase04.t01;

import com.epam.javase04.t02.SymbolCodeReader;
import org.junit.Test;

public class CodeReaderTest {

    @Test
    public void byteTest() {
        CodeReader codeReader = new CodeReader();
        codeReader.readFile();
        codeReader.searchForKeyWords();
        codeReader.writeFile();  //не пишет в файл побайтово :(
    }

}
