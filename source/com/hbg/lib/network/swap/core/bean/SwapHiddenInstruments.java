package com.hbg.lib.network.swap.core.bean;

import java.io.Serializable;
import java.util.List;

public class SwapHiddenInstruments implements Serializable {
    public static final int ALL_HIDDEN = 1;
    private static final long serialVersionUID = -283783689736215208L;
    private int hiddenAll;
    private List<String> hiddenList;

    public boolean canEqual(Object obj) {
        return obj instanceof SwapHiddenInstruments;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SwapHiddenInstruments)) {
            return false;
        }
        SwapHiddenInstruments swapHiddenInstruments = (SwapHiddenInstruments) obj;
        if (!swapHiddenInstruments.canEqual(this)) {
            return false;
        }
        List<String> hiddenList2 = getHiddenList();
        List<String> hiddenList3 = swapHiddenInstruments.getHiddenList();
        if (hiddenList2 != null ? hiddenList2.equals(hiddenList3) : hiddenList3 == null) {
            return getHiddenAll() == swapHiddenInstruments.getHiddenAll();
        }
        return false;
    }

    public int getHiddenAll() {
        return this.hiddenAll;
    }

    public List<String> getHiddenList() {
        return this.hiddenList;
    }

    public int hashCode() {
        List<String> hiddenList2 = getHiddenList();
        return (((hiddenList2 == null ? 43 : hiddenList2.hashCode()) + 59) * 59) + getHiddenAll();
    }

    public void setHiddenAll(int i11) {
        this.hiddenAll = i11;
    }

    public void setHiddenList(List<String> list) {
        this.hiddenList = list;
    }

    public String toString() {
        return "SwapHiddenInstruments(hiddenList=" + getHiddenList() + ", hiddenAll=" + getHiddenAll() + ")";
    }
}
