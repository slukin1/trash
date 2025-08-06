package org.apache.commons.io.filefilter;

import java.io.File;
import java.io.Serializable;
import t10.a;

public class DirectoryFileFilter extends AbstractFileFilter implements Serializable {
    public static final a DIRECTORY;
    public static final a INSTANCE;
    private static final long serialVersionUID = -5148237843784525732L;

    static {
        DirectoryFileFilter directoryFileFilter = new DirectoryFileFilter();
        DIRECTORY = directoryFileFilter;
        INSTANCE = directoryFileFilter;
    }

    public boolean accept(File file) {
        return file.isDirectory();
    }
}
