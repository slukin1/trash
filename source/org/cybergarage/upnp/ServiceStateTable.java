package org.cybergarage.upnp;

import java.util.Vector;

public class ServiceStateTable extends Vector {
    public static final String ELEM_NAME = "serviceStateTable";

    public StateVariable getStateVariable(int i11) {
        return (StateVariable) get(i11);
    }
}
