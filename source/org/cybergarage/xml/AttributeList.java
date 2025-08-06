package org.cybergarage.xml;

import java.util.Vector;

public class AttributeList extends Vector {
    public Attribute getAttribute(int i11) {
        return (Attribute) get(i11);
    }

    public Attribute getAttribute(String str) {
        if (str == null) {
            return null;
        }
        int size = size();
        for (int i11 = 0; i11 < size; i11++) {
            Attribute attribute = getAttribute(i11);
            if (str.compareTo(attribute.a()) == 0) {
                return attribute;
            }
        }
        return null;
    }
}
