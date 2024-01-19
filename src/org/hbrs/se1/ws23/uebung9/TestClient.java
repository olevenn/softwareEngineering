package org.hbrs.se1.ws23.uebung9;

import java.io.UnsupportedEncodingException;

public class TestClient {
    public static void main(String[] args) throws UnsupportedEncodingException {

        ComplexDocument doc0 = new ComplexDocument();
        TextDocument doc2 = new TextDocument("Die Klausur im Fach SE findet bald statt!", TextDocument.Encoding.UTF8);
        doc0.addDocument(doc2);

        ComplexDocument doc3 = new ComplexDocument();
        TextDocument doc5 = new TextDocument("Software Engineering 1 ist eine Vorlesung in den Studiengaengen BIS und BCS", TextDocument.Encoding.UTF32);
        GraficDocument doc4 = new GraficDocument("localhost:8080");

        doc3.addDocument(doc5);
        doc3.addDocument(doc4);

        doc0.addDocument(doc3);

        System.out.println(doc0.size());
    }
}
