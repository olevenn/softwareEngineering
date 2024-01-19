package org.hbrs.se1.ws23.uebung9;

import org.hbrs.se1.ws23.uebung9.CoreDocument;

public class GraficDocument extends CoreDocument {
    private String url;

    private int size = 1200;

    public GraficDocument(String url) {
        this.url = url;
    }

    @Override
    public int size() {
        return size;
    }
}
