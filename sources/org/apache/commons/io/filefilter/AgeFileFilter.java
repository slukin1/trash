package org.apache.commons.io.filefilter;

import java.io.File;
import java.io.Serializable;
import java.util.Date;
import org.apache.commons.io.FileUtils;

public class AgeFileFilter extends AbstractFileFilter implements Serializable {
    private static final long serialVersionUID = -2132740084016138541L;
    private final boolean acceptOlder;
    private final long cutoff;

    public AgeFileFilter(long j11) {
        this(j11, true);
    }

    public boolean accept(File file) {
        boolean b11 = FileUtils.b(file, this.cutoff);
        if (this.acceptOlder) {
            return !b11;
        }
        return b11;
    }

    public String toString() {
        String str = this.acceptOlder ? "<=" : ">";
        return super.toString() + "(" + str + this.cutoff + ")";
    }

    public AgeFileFilter(long j11, boolean z11) {
        this.acceptOlder = z11;
        this.cutoff = j11;
    }

    public AgeFileFilter(Date date) {
        this(date, true);
    }

    public AgeFileFilter(Date date, boolean z11) {
        this(date.getTime(), z11);
    }

    public AgeFileFilter(File file) {
        this(file, true);
    }

    public AgeFileFilter(File file, boolean z11) {
        this(file.lastModified(), z11);
    }
}
