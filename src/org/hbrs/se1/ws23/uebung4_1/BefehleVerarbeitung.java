package org.hbrs.se1.ws23.uebung4_1;

import java.util.List;
import java.util.Scanner;

public class BefehleVerarbeitung {
    public static void enterUserStorie(Scanner scanner) {
        int ID = 0;
        String Beschreibung = "";
        String Akzeptanzkriterium = "";
        int RM = 0;
        int RS = 0;
        int RR = 0;
        int RA = 0;
        String Projekt = "";

        System.out.println("Eingabe der ID: ");
        ID = scanner.nextInt();

        System.out.println("Eingabe der Beschreibung: ");
        while (Beschreibung.isEmpty()) {
            Beschreibung = scanner.nextLine();
        }

        while (Akzeptanzkriterium.isEmpty()) {
            System.out.println("Eingabe des Akzeptanzkriteriums: ");
            Akzeptanzkriterium = scanner.nextLine();
        }

        System.out.println("Eingabe des RM: ");
        RM = scanner.nextInt();
        if (RM > 5 || RM < 0) {
            System.out.println("RM kann nur zwischen 0 und 5 sein. Erneute Eingabe: ");
            RM = scanner.nextInt();
        }

        System.out.println("Eingabe des RS: ");
        RS = scanner.nextInt();
        if (RS > 5 || RS < 0) {
            System.out.println("RS kann nur zwischen 0 und 5 sein. Erneute Eingabe: ");
            RS = scanner.nextInt();
        }

        System.out.println("Eingabe des RR: ");
        RR = scanner.nextInt();
        if (RR > 5 || RR < 0) {
            System.out.println("RR kann nur zwischen 0 und 5 sein. Erneute Eingabe: ");
            RR = scanner.nextInt();
        }


        System.out.println("Eingabe des RA: ");
        RA = scanner.nextInt();
        if (RA < 0) {
            System.out.println("RA kann nur zwischen 0 und \u221E sein. Erneute Eingabe: ");
            RA = scanner.nextInt();
        }


        System.out.println("Eingabe des Projekts: ");
        while (Projekt.isEmpty()) {
            Projekt = scanner.nextLine();
        }

        double prio = ((double) (RM + RS) / (RA + RR));
        Container container = Container.getInstance();

        container.addUserStory(new UserStory(ID, Beschreibung, Akzeptanzkriterium, RM, RS, RR, RA, Projekt, prio));

        System.out.println("LOG: Erfolgreiche Abspeicherung der UserStory!");
    }

    public static void search(Scanner scanner, Container container) {

        //TODO In einer if Schleife, falls die Eingabe nicht gültig ist.
        System.out.println(">> Geben Sie an welche ID Sie suchen: ");
        int ID = scanner.nextInt();

        List<UserStory> liste = container.getCurrentList();
        for (UserStory p : liste) {
            if (p.getID() == ID)
                System.out.println(p);
        }
    }

    public static void help() {
        System.out.println("Es gibt folgende Befehle: enter, store, load, dump, search, exit, help");
    }
}
