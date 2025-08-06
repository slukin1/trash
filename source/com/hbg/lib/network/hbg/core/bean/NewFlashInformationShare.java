package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class NewFlashInformationShare implements Serializable {
    private static final long serialVersionUID = -2171375508930487104L;
    private int shared;

    public boolean canEqual(Object obj) {
        return obj instanceof NewFlashInformationShare;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof NewFlashInformationShare)) {
            return false;
        }
        NewFlashInformationShare newFlashInformationShare = (NewFlashInformationShare) obj;
        return newFlashInformationShare.canEqual(this) && getShared() == newFlashInformationShare.getShared();
    }

    public int getShared() {
        return this.shared;
    }

    public int hashCode() {
        return 59 + getShared();
    }

    public void setShared(int i11) {
        this.shared = i11;
    }

    public String toString() {
        return "NewFlashInformationShare(shared=" + getShared() + ")";
    }
}
