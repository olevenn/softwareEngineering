package org.hbrs.se1.ws23.uebung4_1;

import java.io.Serializable;

public class UserStory implements Serializable, Comparable<UserStory> {
    public int ID;
    public String Beschreibung;
    public String Akzeptanzkriterium;
    public int RM;
    public int RS;
    public int RR;
    public int RA;

    public double Prio;
    public String Projekt;

    public UserStory (int ID, String Beschreibung ,String Akzeptankritierium, int RM, int RS, int RR, int RA, String Projekt, double prio) {
        this.ID = ID;
        this.Beschreibung = Beschreibung;
        this.Akzeptanzkriterium = Akzeptankritierium;
        this.RM = RM;
        this.RS = RS;
        this.RR = RR;
        this.RA = RA;
        this.Projekt = Projekt;
        this.Prio = prio;
    }

    public int getID () {
        return this.ID;
    }

    @Override
    public String toString() {
        //"\n RM: " + RM + "\n RS: " + RS + "\n RR: " + RR + "\n RA: " + RA +
        return ("UserStorie ->" +
                "\n>>> ID: " + ID +
                "\n>>> Beschreibung: " + Beschreibung +
                "\n>>> Akzeptanzkriterium: " + Akzeptanzkriterium +
                "\n>>> Projekt: " + Projekt +
                "\n>>> Prio: " + Prio +
                "\n\n\n");
    }

    @Override
    public int compareTo(UserStory o) {
        return Integer.compare(this.ID, o.ID);
    }
}
