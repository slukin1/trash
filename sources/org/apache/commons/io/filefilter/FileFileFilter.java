package org.apache.commons.io.filefilter;

import java.io.File;
import java.io.Serializable;
import t10.a;

public class FileFileFilter extends AbstractFileFilter implements Serializable {
    public static final a FILE = new FileFileFilter();
    private static final long serialVersionUID = 5345244090827540862L;

    public boolean accept(File file) {
        return file.isFile();
    }
}
