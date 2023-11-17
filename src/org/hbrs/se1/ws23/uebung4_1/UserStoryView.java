package org.hbrs.se1.ws23.uebung4_1;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class UserStoryView {
    public static void dump(Container container) {
        List<UserStory> liste = container.getCurrentList();
        Collections.sort(liste);
        liste.forEach(tmp -> System.out.println(tmp.toString()));
    }
}
