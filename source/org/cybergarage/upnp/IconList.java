package org.cybergarage.upnp;

import f20.c;
import java.util.Vector;

public class IconList extends Vector {
    public static final String ELEM_NAME = "iconList";

    public c getIcon(int i11) {
        return (c) get(i11);
    }
}
