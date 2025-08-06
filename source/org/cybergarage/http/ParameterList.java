package org.cybergarage.http;

import java.util.Vector;

public class ParameterList extends Vector {
    public Parameter at(int i11) {
        return (Parameter) get(i11);
    }

    public Parameter getParameter(int i11) {
        return (Parameter) get(i11);
    }

    public String getValue(String str) {
        Parameter parameter = getParameter(str);
        if (parameter == null) {
            return "";
        }
        return parameter.b();
    }

    public Parameter getParameter(String str) {
        if (str == null) {
            return null;
        }
        int size = size();
        for (int i11 = 0; i11 < size; i11++) {
            Parameter at2 = at(i11);
            if (str.compareTo(at2.a()) == 0) {
                return at2;
            }
        }
        return null;
    }
}
