package org.hbrs.se1.ws23.uebung4_1.persistence;

import org.hbrs.se1.ws23.uebung4_1.Container;
import org.hbrs.se1.ws23.uebung4_1.UserStory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PersistenceStrategyStream<E> implements PersistenceStrategy<E> {

    // URL der Datei, in der die Objekte gespeichert werden
    private String LOCATION = "test.txt";

    private ObjectOutputStream oos = null;
    private FileOutputStream fos = null;

    private FileInputStream fis = null;
    private ObjectInputStream ois = null;

    // Used only for testing purposes, if the location should be changed
    // Example: Location is a directory
    public void setLOCATION(String LOCATION) {
        this.LOCATION = LOCATION;
    }

    @Override
    /**
     * Used only for openining a connection for storing objects
     * Exception occurs in some SDKs, when both are created
     * Workaround: open the Streams in the load method
     */
    public void openConnection() throws PersistenceException {
        try {
            fos = new FileOutputStream( LOCATION );
            fis = new FileInputStream( LOCATION );
        } catch (FileNotFoundException e) {
            throw new PersistenceException( PersistenceException.ExceptionType.ConnectionNotAvailable
            , "Error in opening the connection, File could not be found");
        }
        try {
            oos = new ObjectOutputStream( fos );
            ois = new ObjectInputStream(  fis  );
        } catch (IOException e) {
            throw new PersistenceException( PersistenceException.ExceptionType.ConnectionNotAvailable
                    , "Error in opening the connection, problems with the stream");
        }
    }

    @Override
    public void closeConnection() throws PersistenceException {
        try {
            // Closing the outputstreams for storing
            if (oos != null) oos.close();
            if (fos != null) fos.close();

            // Closing the inputstreams for loading
            if (ois != null) ois.close();
            if (fis != null) fis.close();
        } catch( IOException e ) {
            // Lazy solution: catching the exception of any closing activity ;-)
            throw new PersistenceException(PersistenceException.ExceptionType.ClosingFailure , "error while closing connections");
        }
    }

    @Override
    /**
     * Method for saving a list of Member-objects to a disk (HDD)
     */
    public void save(List<E> list) throws PersistenceException {
        // Write the objects to stream
        try {
            System.out.println("LOG: Es wurden " + list.size() + " Member-Objekte wurden erfolgreich gespeichert!");
            for (E tmp : list) {
                System.out.println("Ein Objekt wurde eingelesen!!!");
                oos.writeObject(tmp);
            }

        }
        catch (IOException e) {
            // Koennte man ausgeben für interne Debugs: e.printStackTrace();
            // Chain of Responsibility: Hochtragen der Exception in Richtung Ausgabe (UI)
            // Uebergabe in ein lesbares Format fuer den Benutzer
            //System.out.println( "LOG: Es wurden " +  list.size() + " Member-Objekte wurden erfolgreich gespeichert!");
            e.printStackTrace();
            throw new PersistenceException( PersistenceException.ExceptionType.SaveFailure , "Fehler beim Speichern der Datei!");
        }
    }

    @Override
    /**
     * Method for loading a list of Member-objects from a disk (HDD)
     * Some coding examples comes for free :-)
     */
    public List<E> load() throws PersistenceException {
        // Load the objects from stream
        List<E> list = new ArrayList<E>();

        try {
            // Create Streams here instead using "this.openConnection();"
            // Workaround!
            while (true) {
                System.out.println("Vor dem Einlesen der Objekte.");
                UserStory tmp = (UserStory) ois.readObject();
                System.out.println("Nach dem einlesen der Objekte.");
                System.out.println("Es wurde dieses Objekt geladen: " + tmp);
                list.add((E) tmp);
            }

        }
        catch (EOFException | FileNotFoundException e) {
            // Sup-Optimal, da Exeception in Form eines unlesbaren Stake-Traces ausgegeben wird
            e.printStackTrace();
            return list;
            //throw new PersistenceException( PersistenceException.ExceptionType.LoadFailure , "Fehler beim Laden der Datei!");
        }
        catch (ClassNotFoundException e) {
            // Chain of Responsbility erfuellt, durch Throw der Exceotion kann UI
            // benachrichtigt werden!
            throw new PersistenceException( PersistenceException.ExceptionType.LoadFailure , "Fehler beim Laden der Datei! Class not found!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void loadd() throws IOException, PersistenceException {

        try {
            while (true) {
                UserStory tmp = (UserStory) ois.readObject();
                System.out.println(tmp);
                Container.getInstance().getCurrentList().add(tmp);
            }
        } catch (EOFException | ClassNotFoundException e) {
            //EOFException wird geworfen, wenn am Ende der Datei angelangt ist
            System.out.println("EINE FEHLERMELDUNG BEI LOAD!");
        }
        closeConnection();
    }
}
