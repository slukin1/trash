package org.jmrtd.lds;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AbstractListInfo<R extends Serializable> extends AbstractLDSInfo {
    private static final Logger LOGGER = Logger.getLogger("org.jmrtd");
    private static final long serialVersionUID = 2970076896364365191L;
    private List<R> subRecords;

    public void add(R r11) {
        if (this.subRecords == null) {
            this.subRecords = new ArrayList();
        }
        this.subRecords.add(r11);
    }

    public void addAll(List<R> list) {
        if (this.subRecords == null) {
            this.subRecords = new ArrayList();
        }
        this.subRecords.addAll(list);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractListInfo)) {
            return false;
        }
        try {
            List subRecords2 = getSubRecords();
            List subRecords3 = ((AbstractListInfo) obj).getSubRecords();
            int size = subRecords2.size();
            if (size != subRecords3.size()) {
                return false;
            }
            for (int i11 = 0; i11 < size; i11++) {
                Serializable serializable = (Serializable) subRecords2.get(i11);
                Serializable serializable2 = (Serializable) subRecords3.get(i11);
                if (serializable == null) {
                    if (serializable2 != null) {
                        return false;
                    }
                } else if (!serializable.equals(serializable2)) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException e11) {
            LOGGER.log(Level.WARNING, "Wrong class", e11);
            return false;
        }
    }

    public List<R> getSubRecords() {
        if (this.subRecords == null) {
            this.subRecords = new ArrayList();
        }
        return new ArrayList(this.subRecords);
    }

    public int hashCode() {
        int i11 = 1234567891;
        for (Serializable serializable : getSubRecords()) {
            if (serializable == null) {
                i11 = (i11 * 3) + 5;
            } else {
                i11 = ((i11 + serializable.hashCode()) * 5) + 7;
            }
        }
        return (i11 * 7) + 11;
    }

    public abstract void readObject(InputStream inputStream) throws IOException;

    public void remove(int i11) {
        if (this.subRecords == null) {
            this.subRecords = new ArrayList();
        }
        this.subRecords.remove(i11);
    }

    public abstract void writeObject(OutputStream outputStream) throws IOException;
}
