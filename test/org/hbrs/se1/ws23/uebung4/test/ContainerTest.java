package org.hbrs.se1.ws23.uebung4.test;


import org.hbrs.se1.ws23.uebung4_1.Container;
import org.hbrs.se1.ws23.uebung4_1.EingabeDialog;
import org.hbrs.se1.ws23.uebung4_1.UserStory;
import org.hbrs.se1.ws23.uebung4_1.persistence.PersistenceException;
import org.hbrs.se1.ws23.uebung4_1.persistence.PersistenceStrategyStream;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
public class ContainerTest {

    public Container container = null;


    @BeforeEach
    void init() throws PersistenceException, IOException {
        Container container = Container.getInstance();
        container.setPersistenceStrategie(new PersistenceStrategyStream());

        //wir stecken in einer Dauerschleife
        EingabeDialog start = new EingabeDialog();
        start.startEingabe();

    }

    @Test
    void addUser() {
        UserStory userStory1 = new UserStory(1,"Test","Test",1,1,1,1, "Projekt1", 1);
        UserStory userStory2 = new UserStory(2, "Test2", "Test2",2,2,2,2,"Projekt2", 2);

        container.addUserStory(userStory1);
        assertEquals(1, container.getCurrentList().size());
    }
}
