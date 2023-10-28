package org.hbrs.se1.ws23.uebung3.persistence;

import java.io.Serializable;

public class MemberClass implements Member, Serializable {
    private Integer id;

    public MemberClass(Integer id) {
        this.id = id;
    }

    public Integer getID() {
        return this.id;
    }

    public String toString() {
        return "Member (ID = " + this.id+ ")";
    }
}
