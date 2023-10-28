package org.hbrs.se1.ws23.uebung3.persistence;

import java.util.ArrayList;

public class MemberView {
    public static void dump(ArrayList<Member> liste) {
        for (Member tmp:liste) {
            MemberClass test = (MemberClass) tmp;

            System.out.println(test.toString());
        }
    }
}
