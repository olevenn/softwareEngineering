package org.hbrs.se1.ws23.uebung4_1;

import org.hbrs.se1.ws23.uebung4_1.persistence.PersistenceException;

import java.io.Serializable;
import java.util.Scanner;
import java.io.*;

public class EingabeDialog implements Serializable {

    Container container = Container.getInstance();

    public void startEingabe() throws PersistenceException, IOException {
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.print("> ");
            String codeWort = scanner.next();

            //Abbruch des Programmes
            if(codeWort.equals("exit"))
                break;

            //Unterschiedlichen Eingaben abfangen
            switch (codeWort) {
                case "enter":
                    BefehleVerarbeitung.enterUserStorie(scanner);
                    break;
                case "search":
                    BefehleVerarbeitung.search(scanner, container);
                    break;
                case "dump":
                    //dump();
                    break;
                case "store":
                    container.store();
                    break;
                case "load":
                    //container.load();
                    load();
                    break;
                case "help":
                    BefehleVerarbeitung.help();
                    break;
                default:
                    BefehleVerarbeitung.help();
            }
        }
    }
    public void load() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Julian\\IdeaProjects\\codesSE2023\\test.txt");
        ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);

        try {
            while (true) {
                UserStory tmp = (UserStory) inputStream.readObject();
                container.getCurrentList().add(tmp);
                System.out.println("Es wurde ein Objekt geladen.");
            }
        } catch (EOFException | ClassNotFoundException e) {
            //EOFException wird geworfen, wenn am Ende der Datei angelangt ist

        }
        fileInputStream.close();
        inputStream.close();
    }
}
