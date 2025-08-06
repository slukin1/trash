package org.cybergarage.upnp;

import f20.b;
import java.util.Iterator;
import java.util.Vector;

public class AllowedValueList extends Vector {
    public static final String ELEM_NAME = "allowedValueList";

    public AllowedValueList() {
    }

    public b getAllowedValue(int i11) {
        return (b) get(i11);
    }

    public boolean isAllowed(String str) {
        Iterator it2 = iterator();
        while (it2.hasNext()) {
            if (((b) it2.next()).b().equals(str)) {
                return true;
            }
        }
        return false;
    }

    public AllowedValueList(String[] strArr) {
        for (String bVar : strArr) {
            add(new b(bVar));
        }
    }
}
