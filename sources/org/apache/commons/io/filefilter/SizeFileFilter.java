package org.apache.commons.io.filefilter;

import java.io.File;
import java.io.Serializable;

public class SizeFileFilter extends AbstractFileFilter implements Serializable {
    private static final long serialVersionUID = 7388077430788600069L;
    private final boolean acceptLarger;
    private final long size;

    public SizeFileFilter(long j11) {
        this(j11, true);
    }

    public boolean accept(File file) {
        boolean z11 = file.length() < this.size;
        if (!this.acceptLarger) {
            return z11;
        }
        if (!z11) {
            return true;
        }
        return false;
    }

    public String toString() {
        String str = this.acceptLarger ? ">=" : "<";
        return super.toString() + "(" + str + this.size + ")";
    }

    public SizeFileFilter(long j11, boolean z11) {
        if (j11 >= 0) {
            this.size = j11;
            this.acceptLarger = z11;
            return;
        }
        throw new IllegalArgumentException("The size must be non-negative");
    }
}
