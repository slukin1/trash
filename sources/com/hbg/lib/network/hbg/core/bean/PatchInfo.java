package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class PatchInfo implements Serializable {
    public static final int PATCH_STATE_NO_ONLINE = 0;
    public static final int PATCH_STATE_OFF_ONLINE = 2;
    public static final int PATCH_STATE_ONLINE = 1;
    public static final int PATCH_STATE_ROLL_BACK = 3;
    private static final long serialVersionUID = -2030292605271193830L;
    private String patchVersion;
    private String path;
    private int state;

    public boolean canEqual(Object obj) {
        return obj instanceof PatchInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PatchInfo)) {
            return false;
        }
        PatchInfo patchInfo = (PatchInfo) obj;
        if (!patchInfo.canEqual(this)) {
            return false;
        }
        String path2 = getPath();
        String path3 = patchInfo.getPath();
        if (path2 != null ? !path2.equals(path3) : path3 != null) {
            return false;
        }
        if (getState() != patchInfo.getState()) {
            return false;
        }
        String patchVersion2 = getPatchVersion();
        String patchVersion3 = patchInfo.getPatchVersion();
        return patchVersion2 != null ? patchVersion2.equals(patchVersion3) : patchVersion3 == null;
    }

    public String getPatchVersion() {
        return this.patchVersion;
    }

    public String getPath() {
        return this.path;
    }

    public int getState() {
        return this.state;
    }

    public int hashCode() {
        String path2 = getPath();
        int i11 = 43;
        int hashCode = (((path2 == null ? 43 : path2.hashCode()) + 59) * 59) + getState();
        String patchVersion2 = getPatchVersion();
        int i12 = hashCode * 59;
        if (patchVersion2 != null) {
            i11 = patchVersion2.hashCode();
        }
        return i12 + i11;
    }

    public void setPatchVersion(String str) {
        this.patchVersion = str;
    }

    public void setPath(String str) {
        this.path = str;
    }

    public void setState(int i11) {
        this.state = i11;
    }

    public String toString() {
        return "PatchInfo{path='" + this.path + '\'' + ", state=" + this.state + ", patchVersion='" + this.patchVersion + '\'' + '}';
    }
}
