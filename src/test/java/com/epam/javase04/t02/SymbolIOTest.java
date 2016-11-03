package com.epam.javase04.t02;

import com.epam.javase04.t01.CodeReader;
import org.junit.Test;

/**
 * Created by Olya Lee on 03.11.2016.
 */
public class SymbolIOTest {

        @Test
        public void symbolTest() {
            SymbolCodeReader scr = new SymbolCodeReader();
            scr.searchForKeyWords();
            scr.writeToFile();
        }
}
