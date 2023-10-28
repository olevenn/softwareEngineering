package org.hbrs.se1.ws23.uebung3.test;

import org.hbrs.se1.ws23.uebung3.persistence.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ContainerTest {

    public Container container;
    public MemberClass member1;
    public MemberClass member2;
    public MemberClass member3;

    @BeforeEach
    void init() throws ContainerException {
        container = Container.getInstance();
        container.memberListe.clear();
        member1 = new MemberClass(0);
        member2 = new MemberClass(1);
        member3 = new MemberClass(2);
        container.addMember(member1);
        container.addMember(member2);
        container.addMember(member3);
    }

    @Test
    void loeschenMember() {
        assertEquals(3, container.size());
        container.deleteMember(0);
        assertEquals(2, container.size());
        container.deleteMember(1);
        assertEquals(1, container.size());
        container.deleteMember(2);
        assertEquals(0, container.size());
    }

    @Test
    void loeschenException() {
        container.deleteMember(0);
        container.deleteMember(1);
        container.deleteMember(2);

        assertEquals("Das Mitglied mit der ID: 2" + " gibt es nicht!", container.deleteMember(2));
    }

    @Test
    void speichern() throws PersistenceException, IOException, ContainerException {
        container.store();
    }

    @Test
    void laden() throws PersistenceException, IOException, ClassNotFoundException, ContainerException {
        container.load();
    }

}

