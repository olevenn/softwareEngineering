package org.hbrs.se1.ws23.uebung4;

import org.hbrs.se1.ws23.uebung4.persistence.PersistenceException;
import org.hbrs.se1.ws23.uebung4.persistence.PersistenceStrategyStream;

public class Main {
    public static void main(String[] args) throws PersistenceException {
        Container container = Container.getInstance();

        container.setPersistenceStrategie(new PersistenceStrategyStream());

        Terminal terminal = new Terminal();
        terminal.startTerminal();
    }

}
