package org.cybergarage.upnp.event;

import java.util.Vector;

public class PropertyList extends Vector {
    public static final String ELEM_NAME = "PropertyList";

    public Property getProperty(int i11) {
        return (Property) get(i11);
    }
}
