package org.hbrs.se1.ws23.uebung4;

import org.hbrs.se1.ws23.uebung4.UserStorie;

import java.util.List;
import java.util.Scanner;

public class Terminal {
    Container container = Container.getInstance();
    public void startTerminal() {
        Scanner scanner = new Scanner(System.in);
        String ende = "exit";

        while (true) {
            System.out.println("Geben Sie ihr Codewort ein: ");
            String codeWort = scanner.next();

            if(codeWort.equals(ende))
                break;


            switch (codeWort){
                case "enter":
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

                    System.out.println("Eingabe des RS: ");
                    RS = scanner.nextInt();

                    System.out.println("Eingabe des RR: ");
                    RR = scanner.nextInt();

                    System.out.println("Eingabe des RA: ");
                    RA = scanner.nextInt();

                    System.out.println("Eingabe des Projekts: ");
                    while (Projekt.isEmpty()) {
                        Projekt = scanner.nextLine();
                    }

                    enter(ID, Beschreibung, Akzeptanzkriterium, RM, RS, RR, RA, Projekt);
                    break;
                case "search":
                    System.out.println("Eingabe der gesuchten ID: ");
                    int id = scanner.nextInt();
                    System.out.println(search(id));
                case "dump":
                    dump();

            }



        }


    }
    public void enter(int ID, String Beschreibung, String Akzeptanzkriterium, int RM, int RS, int RR, int RA, String Projekt) {
        //UserStorie tmp = new UserStorie(ID, Beschreibung, Akzeptanzkriterium, RM, RS, RR, RA, Projekt);
        container.addUserStorie(new UserStorie(ID, Beschreibung, Akzeptanzkriterium, RM, RS, RR, RA, Projekt));
        System.out.println("User eingefügt!");
    }

    public String search(int ID) {
        return "";
    }

    public void dump () {
        List<UserStorie> liste = container.getCurrentList();
        System.out.println("Ausgabe aller User-Stories: ");
        for (UserStorie p : liste) {
            System.out.println(p.toString());
        }
    }
}
