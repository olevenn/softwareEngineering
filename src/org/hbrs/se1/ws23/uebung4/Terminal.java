package org.hbrs.se1.ws23.uebung4;


import org.hbrs.se1.ws23.uebung4.UserStorie;
import org.hbrs.se1.ws23.uebung4.persistence.PersistenceException;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class Terminal implements Serializable {
    Container container = Container.getInstance();

    public void startTerminal() throws PersistenceException, IOException {
        Scanner scanner = new Scanner(System.in);
        String ende = "exit";

        while (true) {
            System.out.println("Geben Sie ihr Codewort ein: ");
            String codeWort = scanner.next();

            if (codeWort.equals(ende))
                break;


            switch (codeWort) {
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
                    if(RM > 5 || RM < 0) {
                        System.out.println("RM kann nur zwischen 0 und 5 sein. Erneute Eingabe: ");
                        RM = scanner.nextInt();
                    }

                    System.out.println("Eingabe des RS: ");
                    RS = scanner.nextInt();
                    if(RS > 5 || RS < 0) {
                        System.out.println("RS kann nur zwischen 0 und 5 sein. Erneute Eingabe: ");
                        RS = scanner.nextInt();
                    }

                    System.out.println("Eingabe des RR: ");
                    RR = scanner.nextInt();
                    if(RR > 5 || RR < 0) {
                        System.out.println("RR kann nur zwischen 0 und 5 sein. Erneute Eingabe: ");
                        RR = scanner.nextInt();
                    }


                    System.out.println("Eingabe des RA: ");
                    RA = scanner.nextInt();
                    if(RA < 0) {
                        System.out.println("RA kann nur zwischen 0 und \u221E sein. Erneute Eingabe: ");
                        RA = scanner.nextInt();
                    }



                    System.out.println("Eingabe des Projekts: ");
                    while (Projekt.isEmpty()) {
                        Projekt = scanner.nextLine();
                    }

                    double prio = ((double) (RM + RS) / (RA + RR));

                    enter(ID, Beschreibung, Akzeptanzkriterium, RM, RS, RR, RA, Projekt, prio);
                    break;
                case "search":
                    System.out.println("Eingabe der gesuchten ID: ");
                    int id = scanner.nextInt();
                    search(id);
                    break;
                case "dump":
                    dump();
                    break;
                case "store":
                    container.store();
                    break;
                case "load":
                    //container.load();
                    load();
                    System.out.println("LOG: Es wurden erfolgreich " + container.getCurrentList().size() + " UserStories geladen!");
                    break;
                case "help":
                    help();
                    break;
                default:
                    help();
            }


        }


    }

    public void enter(int ID, String Beschreibung, String Akzeptanzkriterium, int RM, int RS, int RR, int RA, String Projekt, double prio) {
        //UserStorie tmp = new UserStorie(ID, Beschreibung, Akzeptanzkriterium, RM, RS, RR, RA, Projekt);
        container.addUserStorie(new UserStorie(ID, Beschreibung, Akzeptanzkriterium, RM, RS, RR, RA, Projekt, prio));
        System.out.println("LOG: User eingefügt!");
    }

    public void search(int ID) {
        List<UserStorie> liste = container.getCurrentList();
        for (UserStorie p : liste) {
            if (p.getID() == ID)
                System.out.println(p);
        }
    }

    public void dump() {
        List<UserStorie> liste = container.getCurrentList();
        //liste.sort() nach UserStorie id
        System.out.println("LOG: Ausgabe aller User-Stories: ");
        /*for (UserStorie p : liste) {
            System.out.println(p.toString());
        }
        */
        liste.forEach(tmp -> System.out.println(tmp.toString()));
        //TODO Ausgabe sortiert ausgeben serializable implementieren
    }

    public void load() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Julian\\IdeaProjects\\codesSE2023\\test.txt");
        ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);

        try {
            while (true) {
                UserStorie tmp = (UserStorie) inputStream.readObject();
                container.getCurrentList().add(tmp);
            }
        } catch (EOFException | ClassNotFoundException e) {
            //EOFException wird geworfen, wenn am Ende der Datei angelangt ist

        }
        fileInputStream.close();
        inputStream.close();
    }

    public void help() {
        System.out.println("Es gibt folgende Befehle: enter, store, load, dump, search, exit, help");
    }
}
