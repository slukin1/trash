package org.apache.commons.io.filefilter;

import java.io.File;
import java.io.Serializable;
import t10.a;

public class HiddenFileFilter extends AbstractFileFilter implements Serializable {
    public static final a HIDDEN;
    public static final a VISIBLE;
    private static final long serialVersionUID = 8930842316112759062L;

    static {
        HiddenFileFilter hiddenFileFilter = new HiddenFileFilter();
        HIDDEN = hiddenFileFilter;
        VISIBLE = new NotFileFilter(hiddenFileFilter);
    }

    public boolean accept(File file) {
        return file.isHidden();
    }
}
