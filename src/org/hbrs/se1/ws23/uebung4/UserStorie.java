package org.hbrs.se1.ws23.uebung4;

import java.io.Serializable;

public class UserStorie implements Serializable {
    public int ID;
    public String Beschreibung;
    public String Akzeptanzkriterium;
    public int RM;
    public int RS;
    public int RR;
    public int RA;
    public String Projekt;

    public UserStorie (int ID, String Beschreibung ,String Akzeptankritierium, int RM, int RS, int RR, int RA, String Projekt) {
        this.ID = ID;
        this.Beschreibung = Beschreibung;
        this.Akzeptanzkriterium = Akzeptankritierium;
        this.RM = RM;
        this.RS = RS;
        this.RR = RR;
        this.RA = RA;
        this.Projekt = Projekt;
    }

    public int getID () {
        return this.ID;
    }

    @Override
    public String toString() {
        return ("Eingaben:\n ID: " + ID + "\n Beschreibung: " + Beschreibung+ "\n Akzeptanzkriterium: " + Akzeptanzkriterium+ "\n RM: " + RM + "\n RS: " + RS + "\n RR: " + RR + "\n RA: " + RA + "\n Projekt: " + Projekt + "\n\n\n");
    }


}
