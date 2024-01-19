package org.hbrs.se1.ws23.uebung9;


import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class ComplexDocument extends ADocument{

    private List<Document> list = new ArrayList<>();

    public void addDocument(Document d) {
        list.add(d);
    }

    public void removeDocument(Document d) {
        int id = d.getID();
        for (Document doc : list) {
            if (doc.getID() == id) {
                list.remove(doc);
                System.out.printf("Document gelöscht mit der ID=" + doc.getID());
            }
        }
    }


    @Override
    public int size() throws UnsupportedEncodingException {
        int size = 0;
        for (Document doc : list) {
            size += doc.size();
        }
        return size;
    }
}
