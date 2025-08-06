package org.apache.commons.io.filefilter;

import java.io.File;
import java.io.Serializable;
import t10.a;

public class CanReadFileFilter extends AbstractFileFilter implements Serializable {
    public static final a CANNOT_READ;
    public static final a CAN_READ;
    public static final a READ_ONLY;
    private static final long serialVersionUID = 3179904805251622989L;

    static {
        CanReadFileFilter canReadFileFilter = new CanReadFileFilter();
        CAN_READ = canReadFileFilter;
        CANNOT_READ = new NotFileFilter(canReadFileFilter);
        READ_ONLY = new AndFileFilter(canReadFileFilter, CanWriteFileFilter.CANNOT_WRITE);
    }

    public boolean accept(File file) {
        return file.canRead();
    }
}
