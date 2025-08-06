package org.cybergarage.upnp;

import java.util.Vector;

public class ServiceList extends Vector {
    public static final String ELEM_NAME = "serviceList";

    public Service getService(int i11) {
        Object obj;
        try {
            obj = get(i11);
        } catch (Exception unused) {
            obj = null;
        }
        return (Service) obj;
    }
}
