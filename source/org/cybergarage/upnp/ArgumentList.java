package org.cybergarage.upnp;

import java.util.Vector;

public class ArgumentList extends Vector {
    public static final String ELEM_NAME = "argumentList";

    public Argument getArgument(int i11) {
        return (Argument) get(i11);
    }

    public void set(ArgumentList argumentList) {
        int size = argumentList.size();
        for (int i11 = 0; i11 < size; i11++) {
            Argument argument = argumentList.getArgument(i11);
            Argument argument2 = getArgument(argument.d());
            if (argument2 != null) {
                argument2.j(argument.e());
            }
        }
    }

    public void setReqArgs(ArgumentList argumentList) {
        int size = size();
        for (int i11 = 0; i11 < size; i11++) {
            Argument argument = getArgument(i11);
            if (argument.g()) {
                String d11 = argument.d();
                Argument argument2 = argumentList.getArgument(d11);
                if (argument2 != null) {
                    argument.j(argument2.e());
                } else {
                    throw new IllegalArgumentException("Argument \"" + d11 + "\" missing.");
                }
            }
        }
    }

    public void setResArgs(ArgumentList argumentList) {
        int size = size();
        for (int i11 = 0; i11 < size; i11++) {
            Argument argument = getArgument(i11);
            if (argument.h()) {
                String d11 = argument.d();
                Argument argument2 = argumentList.getArgument(d11);
                if (argument2 != null) {
                    argument.j(argument2.e());
                } else {
                    throw new IllegalArgumentException("Argument \"" + d11 + "\" missing.");
                }
            }
        }
    }

    public Argument getArgument(String str) {
        int size = size();
        for (int i11 = 0; i11 < size; i11++) {
            Argument argument = getArgument(i11);
            String d11 = argument.d();
            if (d11 != null && d11.equals(str)) {
                return argument;
            }
        }
        return null;
    }
}
