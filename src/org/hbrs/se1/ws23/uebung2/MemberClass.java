package org.hbrs.se1.ws23.uebung2;

public class MemberClass implements Member {
    private Integer id;

    public MemberClass(Integer id) {
        this.id = id;
    }

    public Integer getID() {
        return this.id;
    }

    public String toString() {
        System.out.println("Member (ID = " + this.id+ ")");
        return "Member (ID = " + this.id+ ")";
    }
}
