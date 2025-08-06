package org.apache.commons.io.filefilter;

import java.io.File;
import t10.a;

public abstract class AbstractFileFilter implements a {
    public boolean accept(File file) {
        return accept(file.getParentFile(), file.getName());
    }

    public String toString() {
        return getClass().getSimpleName();
    }

    public boolean accept(File file, String str) {
        return accept(new File(file, str));
    }
}
