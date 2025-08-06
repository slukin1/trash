package org.jmrtd.lds;

import java.io.IOException;
import java.io.InputStream;

public abstract class DataGroup extends AbstractTaggedLDSFile {
    private static final long serialVersionUID = -4761360877353069639L;

    public DataGroup(int i11) {
        super(i11);
    }

    public String toString() {
        return "DataGroup [" + Integer.toHexString(getTag()) + " (" + getLength() + ")]";
    }

    public DataGroup(int i11, InputStream inputStream) throws IOException {
        super(i11, inputStream);
    }
}
