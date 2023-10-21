package org.hbrs.se1.ws23.uebung2;

public class MemberClass implements Member {
    private int id;

    public MemberClass(int id) {
        this.id = id;
    }

    public Integer getID() {
        return this.id;
    }

    public String toString() {
        return "Member (ID = " + this.id+ ")";
    }
}
