package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class ProfitAndLossData implements Serializable {
    private ProfitAndLoss profitAndLoss;

    public boolean canEqual(Object obj) {
        return obj instanceof ProfitAndLossData;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ProfitAndLossData)) {
            return false;
        }
        ProfitAndLossData profitAndLossData = (ProfitAndLossData) obj;
        if (!profitAndLossData.canEqual(this)) {
            return false;
        }
        ProfitAndLoss profitAndLoss2 = getProfitAndLoss();
        ProfitAndLoss profitAndLoss3 = profitAndLossData.getProfitAndLoss();
        return profitAndLoss2 != null ? profitAndLoss2.equals(profitAndLoss3) : profitAndLoss3 == null;
    }

    public ProfitAndLoss getProfitAndLoss() {
        return this.profitAndLoss;
    }

    public int hashCode() {
        ProfitAndLoss profitAndLoss2 = getProfitAndLoss();
        return 59 + (profitAndLoss2 == null ? 43 : profitAndLoss2.hashCode());
    }

    public void setProfitAndLoss(ProfitAndLoss profitAndLoss2) {
        this.profitAndLoss = profitAndLoss2;
    }

    public String toString() {
        return "ProfitAndLossData(profitAndLoss=" + getProfitAndLoss() + ")";
    }
}
