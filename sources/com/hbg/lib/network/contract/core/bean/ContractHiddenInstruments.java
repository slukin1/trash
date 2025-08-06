package com.hbg.lib.network.contract.core.bean;

import java.io.Serializable;
import java.util.List;

public class ContractHiddenInstruments implements Serializable {
    public static final int ALL_HIDDEN = 1;
    private static final long serialVersionUID = 5575932783610050812L;
    private int hiddenAll;
    private List<String> hiddenList;

    public boolean canEqual(Object obj) {
        return obj instanceof ContractHiddenInstruments;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ContractHiddenInstruments)) {
            return false;
        }
        ContractHiddenInstruments contractHiddenInstruments = (ContractHiddenInstruments) obj;
        if (!contractHiddenInstruments.canEqual(this)) {
            return false;
        }
        List<String> hiddenList2 = getHiddenList();
        List<String> hiddenList3 = contractHiddenInstruments.getHiddenList();
        if (hiddenList2 != null ? hiddenList2.equals(hiddenList3) : hiddenList3 == null) {
            return getHiddenAll() == contractHiddenInstruments.getHiddenAll();
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
        return "ContractHiddenInstruments(hiddenList=" + getHiddenList() + ", hiddenAll=" + getHiddenAll() + ")";
    }
}
