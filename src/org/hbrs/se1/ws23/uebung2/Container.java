package org.hbrs.se1.ws23.uebung2;

import java.util.ArrayList;

public class Container {

    private ArrayList<Member> memberListe;

    public Container() {
        this.memberListe = new ArrayList<Member>();
    }

    public void addMember(MemberClass tmp) throws ContainerException {

        try {
            for (int i = memberListe.size() - 1; i >= 0; i--) {
                if (tmp.getID() == memberListe.get(i).getID()) {
                    throw new ContainerException("Das Member-Object mit der ID " + tmp.getID() + " ist bereits vorhanden!");
                }
            }
            memberListe.add(tmp);

        } catch (ContainerException e) {
            System.out.println(e.getMessage());
        }

    }

    public String deleteMember(int id) {

        for (int i = memberListe.size() - 1; i >= 0; i--) {
            if (id == memberListe.get(i).getID()) {
                memberListe.remove(i);
                return "Gelöscht!";
            }
        }
        return "Das Mitglied mit der ID: " + id + "gibt es nicht!"; //Vermischung von Fehlerbehandlung und Anwendung
    }
    public void dump() {
        for (int i = memberListe.size() - 1; i >= 0; i--) {
            memberListe.get(i).toString();
        }
    }

    public int size() {
        //Ausgabe der Größe von der ArrayListe
        return memberListe.size();
    }
}
