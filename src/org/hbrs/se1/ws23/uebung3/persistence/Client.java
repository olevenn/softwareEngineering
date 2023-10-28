package org.hbrs.se1.ws23.uebung3.persistence;

public class Client {
    public static void main(String[] args) throws ContainerException {
        Container container = Container.getInstance();
        MemberClass member1 = new MemberClass(1);
        MemberClass member2 = new MemberClass(2);
        MemberClass member3 = new MemberClass(3);

        container.addMember(member1);
        container.addMember(member2);
        container.addMember(member3);

        MemberView.dump(container.memberListe);
    }
}

