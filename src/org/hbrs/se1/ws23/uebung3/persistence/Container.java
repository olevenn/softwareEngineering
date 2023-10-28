package org.hbrs.se1.ws23.uebung3.persistence;

import java.io.*;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Container implements Serializable{
    private static Container container = new Container();
    public ArrayList<Member> memberListe;

    private Container() {
        this.memberListe = new ArrayList<Member>();
    }

    public static Container getInstance() {
        return container;
    }

    public void addMember(MemberClass tmp) throws ContainerException {

        if(tmp == null) {
            throw new ContainerException("Das Objekt ist leer!");
        }
        for (int i = memberListe.size() - 1; i >= 0; i--) {
            if (tmp.getID() == memberListe.get(i).getID()) {
                throw new ContainerException("Das Member-Object mit der ID " + tmp.getID() + " ist bereits vorhanden!");
            }
        }
        memberListe.add(tmp);
    }

    public String deleteMember(int id) {
        for (int i = memberListe.size() - 1; i >= 0; i--) {
            if (id == memberListe.get(i).getID()) {
                memberListe.remove(i);
                return "Gelöscht!";
            }
        }
        return "Das Mitglied mit der ID: " + id + " gibt es nicht!"; //Vermischung von Fehlerbehandlung und Anwendung
    }

    public int size() {
        //Ausgabe der Größe von der ArrayListe
        return memberListe.size();
    }

    public ArrayList<Member> getCurrentList() {
        return memberListe;
    }

    public void store() throws PersistenceException, IOException {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File("Test.txt"));
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);

            for (Member tmp: memberListe) {
                outputStream.writeObject(tmp);
            }
            outputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {

        } finally {
            //MemberView.dump(memberListe);
        }
    }

    public void load() throws PersistenceException, IOException, ClassNotFoundException {

        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Julian\\IdeaProjects\\codesSE2023\\Test.txt");
        ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
        memberListe.clear();



        try {
            while (true) {
                Member tmp = (Member) inputStream.readObject();
                memberListe.add(tmp);
            }
        } catch (EOFException e) {
            //EOFException wird geworfen, wenn am Ende der Datei angelangt ist

        } finally {
            //MemberView.dump(memberListe);
        }
        fileInputStream.close();
        inputStream.close();
    }
}
