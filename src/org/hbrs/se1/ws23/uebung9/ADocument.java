package org.hbrs.se1.ws23.uebung9;

public abstract class ADocument implements Document {
    private int id;

    @Override
    public int getID() {
        return id;
    }

    @Override
    public void setID(int id) {
        this.id = id;
    }
}
