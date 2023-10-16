package org.hbrs.se1.ws23.uebung1.test;

import org.hbrs.se1.ws23.uebung1.control.GermanTranslator;
import org.hbrs.se1.ws23.uebung1.view.Client;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GermanTranslatorTest {

    @Test
    void aPositiveTest() {
        GermanTranslator translator = new GermanTranslator();
        String value = translator.translateNumber(1);
        assertEquals(value, "eins"); //Äquivalenzklasse: 1 <= x >= 10
    }

    @Test
    void aNegativTest() {
        Client client = new Client();
        String value = client.translateNumber(11);
        assertEquals(value, "elf"); //Äquivalenzklasse x >= 10
    }

    @Test
    void bNegativTest() {
        Client client = new Client();
        String value = client.translateNumber(-1);
        assertEquals(value, "minus eins"); //Äquivalenzklasse x <= -1
    }

    @Test
    void cNegativTest() {
        Client client = new Client();
        String value = client.translateNumber(0);
        assertEquals(value, "null"); //Spezialfall
    }
}