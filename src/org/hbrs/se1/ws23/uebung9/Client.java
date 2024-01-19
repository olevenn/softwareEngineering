package org.hbrs.se1.ws23.uebung9;

import java.io.UnsupportedEncodingException;

public class Client {
    public static void main(String[] args) throws UnsupportedEncodingException {
        TextDocument text8 = new TextDocument("Text", TextDocument.Encoding.UTF8);
        TextDocument text16 = new TextDocument("Text", TextDocument.Encoding.UTF16);
        TextDocument text32 = new TextDocument("Text", TextDocument.Encoding.UTF32);


        System.out.println(text8.size());
        System.out.println(text16.size());
        System.out.println(text32.size());
    }
}
