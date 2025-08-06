package org.apache.commons.io.filefilter;

import java.io.File;
import java.io.Serializable;
import t10.a;

public class TrueFileFilter implements a, Serializable {
    public static final a INSTANCE;
    public static final a TRUE;
    private static final long serialVersionUID = 8782512160909720199L;

    static {
        TrueFileFilter trueFileFilter = new TrueFileFilter();
        TRUE = trueFileFilter;
        INSTANCE = trueFileFilter;
    }

    public boolean accept(File file) {
        return true;
    }

    public boolean accept(File file, String str) {
        return true;
    }
}
