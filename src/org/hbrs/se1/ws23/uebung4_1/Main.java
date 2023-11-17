package org.hbrs.se1.ws23.uebung4_1;


import org.hbrs.se1.ws23.uebung4_1.persistence.*;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws PersistenceException, IOException {
        Container container = Container.getInstance();
        container.setPersistenceStrategie(new PersistenceStrategyStream());

        EingabeDialog start = new EingabeDialog();
        start.startEingabe();
    }

}
