package org.hbrs.se1.ws23.uebung4_1;


import org.hbrs.se1.ws23.uebung4_1.persistence.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Container {

    private List<UserStory> liste = null;

    private static Container container = new Container();

    private PersistenceStrategy strategy = null;

    private boolean connectionOpen = false;

    public static synchronized Container getInstance() {
        return container;
    }

    private Container() {
        System.out.println("LOG: Container ist instanziiert (Konstruktor)!");
        this.liste = new ArrayList<UserStory>(); //warum kann man dort keine List erstellen ???
        System.out.println("Eine Liste wurde erstellt mit der jetztigen Groesse: " + liste.size() + "   Hash: " + liste.hashCode());
    }

    public List getCurrentList() {
        return this.liste;
    }

    public void addUserStory(UserStory r) {
        if (contains(r) == true) {
            System.out.println("Duplikat: " + r.toString());
        }
        liste.add(r);
    }

    private boolean contains(UserStory r) {
        Integer ID = r.getID();
        for (UserStory rec : liste) {
            if (rec.getID() == ID) {
                return true;
            }
        }
        return false;
    }


    //JETZT KOMMT ALLES FÜR SAVE UND LOAD

    private void openConnection() throws PersistenceException {
        try {
            this.strategy.openConnection();
            connectionOpen = true;
        } catch (UnsupportedOperationException | PersistenceException e) {
            throw new PersistenceException(
                    PersistenceException.ExceptionType.ImplementationNotAvailable,
                    "Not implemented!");
        }
    }

    private void closeConnection() throws PersistenceException {
        try {
            this.strategy.closeConnection();
            connectionOpen = false;
        } catch (UnsupportedOperationException e) {
            throw new PersistenceException(PersistenceException.ExceptionType.ImplementationNotAvailable, "Not implemented!");
        }
    }

    public void setPersistenceStrategie(PersistenceStrategy persistenceStrategy) {
        if (connectionOpen == true) {
            try {
                this.closeConnection();
            } catch (PersistenceException e) {
                // ToDo here: delegate to client (next year maybe ;-))
                e.printStackTrace();
            }
        }
        this.strategy = persistenceStrategy;
    }

    public void store() throws PersistenceException {
        if (this.strategy == null)
            throw new PersistenceException(PersistenceException.
                    ExceptionType.NoStrategyIsSet,
                    "Strategy not initialized");

        if (connectionOpen == false) {
            this.openConnection();
            connectionOpen = true;
        }
        this.strategy.save(this.liste);
    }

    public void load() throws PersistenceException, IOException {
        if (this.strategy == null)
            throw new PersistenceException(PersistenceException.ExceptionType.NoStrategyIsSet,
                    "Strategy not initialized");

        if (connectionOpen == false) {
            this.openConnection();
            connectionOpen = true;
        }
        strategy.loadd();
        //this.liste = liste; // MayBe merge
    }


}
