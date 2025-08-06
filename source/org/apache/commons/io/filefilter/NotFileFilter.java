package org.apache.commons.io.filefilter;

import java.io.File;
import java.io.Serializable;
import t10.a;

public class NotFileFilter extends AbstractFileFilter implements Serializable {
    private static final long serialVersionUID = 6131563330944994230L;
    private final a filter;

    public NotFileFilter(a aVar) {
        if (aVar != null) {
            this.filter = aVar;
            return;
        }
        throw new IllegalArgumentException("The filter must not be null");
    }

    public boolean accept(File file) {
        return !this.filter.accept(file);
    }

    public String toString() {
        return super.toString() + "(" + this.filter.toString() + ")";
    }

    public boolean accept(File file, String str) {
        return !this.filter.accept(file, str);
    }
}
