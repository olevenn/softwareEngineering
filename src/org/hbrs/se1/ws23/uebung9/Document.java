package org.hbrs.se1.ws23.uebung9;

import java.io.UnsupportedEncodingException;

public interface Document {
    int size() throws UnsupportedEncodingException;

    int getID();

    void setID(int id);
}
