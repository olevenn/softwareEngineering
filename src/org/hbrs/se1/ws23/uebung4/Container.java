package org.hbrs.se1.ws23.uebung4;

import org.hbrs.se1.ws23.uebung4.persistence.*;

import java.util.ArrayList;
import java.util.List;

public class Container {

    private List<UserStorie> liste = null;

    private static Container instance = null;

    private PersistenceStrategy strategy = null;

    private boolean connectionOpen = false;

    public static synchronized Container getInstance() {
        if (instance == null) {
            instance = new Container();
            System.out.println("Objekt vom Typ Container wurde instanziiert!");
        }
        return instance;
    }

    private Container() {
        System.out.println("Container ist instanziiert (Konstruktor)!");
        this.liste = new ArrayList<UserStorie>();
    }

    public List getCurrentList() {
        return  this.liste;
    }

    public void addUserStorie (UserStorie r) {
        if(contains(r)==true) {
            System.out.println("Duplikat: " + r.toString());
        }
        liste.add(r);
    }

    private boolean contains(UserStorie r) {
        Integer ID = r.getID();
        for ( UserStorie rec : liste) {
            if (rec.getID() == ID) {
                return true;
            }
        }
        return false;
    }
    public int size() {
        return liste.size();
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
    private void openConnection() throws PersistenceException {
        try {
            this.strategy.openConnection();
            connectionOpen = true;
        } catch( UnsupportedOperationException e ) {
            throw new PersistenceException(
                    PersistenceException.ExceptionType.ImplementationNotAvailable ,
                    "Not implemented!" );
        }
    }

    private void closeConnection() throws PersistenceException {
        try {
            this.strategy.closeConnection();
            connectionOpen = false;
        } catch( UnsupportedOperationException e ) {
            throw new PersistenceException( PersistenceException.ExceptionType.ImplementationNotAvailable , "Not implemented!" );
        }
    }

    public void store() throws PersistenceException {
        if (this.strategy == null)
            throw new PersistenceException( PersistenceException.
                    ExceptionType.NoStrategyIsSet,
                    "Strategy not initialized");

        if (connectionOpen == false) {
            this.openConnection();
            connectionOpen = true;
        }
        this.strategy.save( this.liste  );
    }

    public void load() throws PersistenceException {
        if (this.strategy == null)
            throw new PersistenceException( PersistenceException.ExceptionType.NoStrategyIsSet,
                    "Strategy not initialized");

        if (connectionOpen == false) {
            this.openConnection();
            connectionOpen = true;
        }
        List<UserStorie> liste = this.strategy.load();
        this.liste = liste; // MayBe merge
    }
}
