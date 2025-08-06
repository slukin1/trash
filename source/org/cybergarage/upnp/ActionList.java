package org.cybergarage.upnp;

import f20.a;
import java.util.Vector;

public class ActionList extends Vector {
    public static final String ELEM_NAME = "actionList";

    public a getAction(int i11) {
        return (a) get(i11);
    }
}
