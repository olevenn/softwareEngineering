package org.hbrs.se1.ws23.uebung9;


import java.io.UnsupportedEncodingException;

public class TextDocument extends CoreDocument {
    private String inhalt;
    private Encoding encoding;

    enum Encoding {
        UTF8,
        UTF16,
        UTF32
    }

    public TextDocument(String inhalt, Encoding utf) {
        this.inhalt = inhalt;
        this.encoding = utf;
    }

    @Override
    public int size() throws UnsupportedEncodingException {
        switch (encoding) {
            case UTF8:
                final byte[] utf8Bytes = inhalt.getBytes("UTF-8");
                return utf8Bytes.length;
            case UTF16:
                final byte[] utf16Bytes = inhalt.getBytes("UTF-16");
                return utf16Bytes.length;
            case UTF32:
                final byte[] utf32Bytes = inhalt.getBytes("UTF-32");
                return utf32Bytes.length;
            default:
                return 0;
        }
    }
}
