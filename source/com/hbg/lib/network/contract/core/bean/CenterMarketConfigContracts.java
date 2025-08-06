package com.hbg.lib.network.contract.core.bean;

import java.io.Serializable;

public class CenterMarketConfigContracts implements Serializable {
    private static final long serialVersionUID = 8517765260729813482L;
    private CenterMarketConfigContractsInfo system;

    public boolean canEqual(Object obj) {
        return obj instanceof CenterMarketConfigContracts;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CenterMarketConfigContracts)) {
            return false;
        }
        CenterMarketConfigContracts centerMarketConfigContracts = (CenterMarketConfigContracts) obj;
        if (!centerMarketConfigContracts.canEqual(this)) {
            return false;
        }
        CenterMarketConfigContractsInfo system2 = getSystem();
        CenterMarketConfigContractsInfo system3 = centerMarketConfigContracts.getSystem();
        return system2 != null ? system2.equals(system3) : system3 == null;
    }

    public CenterMarketConfigContractsInfo getSystem() {
        return this.system;
    }

    public int hashCode() {
        CenterMarketConfigContractsInfo system2 = getSystem();
        return 59 + (system2 == null ? 43 : system2.hashCode());
    }

    public void setSystem(CenterMarketConfigContractsInfo centerMarketConfigContractsInfo) {
        this.system = centerMarketConfigContractsInfo;
    }

    public String toString() {
        return "CenterMarketConfigContracts(system=" + getSystem() + ")";
    }
}
