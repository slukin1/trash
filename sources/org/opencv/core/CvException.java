package org.opencv.core;

import a.a;

public class CvException extends RuntimeException {
    private static final long serialVersionUID = 1;

    public CvException(String str) {
        super(str);
    }

    public String toString() {
        StringBuilder c11 = a.c("CvException [");
        c11.append(super.toString());
        c11.append("]");
        return c11.toString();
    }
}
