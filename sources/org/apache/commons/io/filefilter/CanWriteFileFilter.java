package org.apache.commons.io.filefilter;

import java.io.File;
import java.io.Serializable;
import t10.a;

public class CanWriteFileFilter extends AbstractFileFilter implements Serializable {
    public static final a CANNOT_WRITE;
    public static final a CAN_WRITE;
    private static final long serialVersionUID = 5132005214688990379L;

    static {
        CanWriteFileFilter canWriteFileFilter = new CanWriteFileFilter();
        CAN_WRITE = canWriteFileFilter;
        CANNOT_WRITE = new NotFileFilter(canWriteFileFilter);
    }

    public boolean accept(File file) {
        return file.canWrite();
    }
}
