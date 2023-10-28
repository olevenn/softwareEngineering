package org.hbrs.se1.ws23.uebung2.test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.hbrs.se1.ws23.uebung2.*;

public class ContainerTest {

    private Container memberListe;
    private MemberClass member1;
    private MemberClass member2;
    private MemberClass member3;

    @BeforeEach
    void init() throws ContainerException {
        memberListe = new Container();
        member1 = new MemberClass(1);
        member2 = new MemberClass(2);
        member3 = new MemberClass(3);
        memberListe.addMember(member1);
        memberListe.addMember(member2);
        memberListe.addMember(member3);
    }

    @Test
    void testAddMemberExcep() {
        assertThrows(ContainerException.class, () -> memberListe.addMember(member1));
        //Null Test muss ich noch einfügen und als Exception auffangen
    }
    @Test
    void deleteMemberTest(){
        //löschen von Mitglieder funktioniert
        assertEquals(memberListe.size(), 3);
        assertEquals("Gelöscht!", memberListe.deleteMember(1));
        assertEquals(memberListe.size(), 2);
        assertEquals("Gelöscht!", memberListe.deleteMember(2));
        assertEquals(memberListe.size(), 1);
        assertEquals("Gelöscht!", memberListe.deleteMember(3));
        assertEquals(memberListe.size(), 0);
    }

    @Test
    void deleteMemberFehlerMeldung() {
        //schauen ob die Fehlermeldung klappt
        assertEquals("Das Mitglied mit der ID: 4 gibt es nicht!", memberListe.deleteMember(4));
    }

    @Test
    void dumpTest() {
        memberListe.dump();
        assertEquals("Member (ID = 1)", member1.toString());
        assertEquals("Member (ID = 2)", member2.toString());
        assertEquals("Member (ID = 3)", member3.toString());
    }

    @Test
    void sizeTest() throws ContainerException {
        //testen ob die Methode size() im Container klappt
        assertEquals(memberListe.size(), 3);
    }

}
