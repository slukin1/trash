package com.huobi.finance.bean;

import com.hbg.lib.network.hbg.core.bean.MiningItem;
import java.util.List;

public class MiningDataTotal extends BaseAssetTotal {
    private List<MiningItem> activeList;
    private List<MiningItem> fixedList;
    private String profitAmount;
    private String profitAmountLegal;

    public boolean canEqual(Object obj) {
        return obj instanceof MiningDataTotal;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MiningDataTotal)) {
            return false;
        }
        MiningDataTotal miningDataTotal = (MiningDataTotal) obj;
        if (!miningDataTotal.canEqual(this) || !super.equals(obj)) {
            return false;
        }
        String profitAmount2 = getProfitAmount();
        String profitAmount3 = miningDataTotal.getProfitAmount();
        if (profitAmount2 != null ? !profitAmount2.equals(profitAmount3) : profitAmount3 != null) {
            return false;
        }
        String profitAmountLegal2 = getProfitAmountLegal();
        String profitAmountLegal3 = miningDataTotal.getProfitAmountLegal();
        if (profitAmountLegal2 != null ? !profitAmountLegal2.equals(profitAmountLegal3) : profitAmountLegal3 != null) {
            return false;
        }
        List<MiningItem> activeList2 = getActiveList();
        List<MiningItem> activeList3 = miningDataTotal.getActiveList();
        if (activeList2 != null ? !activeList2.equals(activeList3) : activeList3 != null) {
            return false;
        }
        List<MiningItem> fixedList2 = getFixedList();
        List<MiningItem> fixedList3 = miningDataTotal.getFixedList();
        return fixedList2 != null ? fixedList2.equals(fixedList3) : fixedList3 == null;
    }

    public List<MiningItem> getActiveList() {
        return this.activeList;
    }

    public List<MiningItem> getFixedList() {
        return this.fixedList;
    }

    public String getProfitAmount() {
        return this.profitAmount;
    }

    public String getProfitAmountLegal() {
        return this.profitAmountLegal;
    }

    public int hashCode() {
        int hashCode = super.hashCode();
        String profitAmount2 = getProfitAmount();
        int i11 = 43;
        int hashCode2 = (hashCode * 59) + (profitAmount2 == null ? 43 : profitAmount2.hashCode());
        String profitAmountLegal2 = getProfitAmountLegal();
        int hashCode3 = (hashCode2 * 59) + (profitAmountLegal2 == null ? 43 : profitAmountLegal2.hashCode());
        List<MiningItem> activeList2 = getActiveList();
        int hashCode4 = (hashCode3 * 59) + (activeList2 == null ? 43 : activeList2.hashCode());
        List<MiningItem> fixedList2 = getFixedList();
        int i12 = hashCode4 * 59;
        if (fixedList2 != null) {
            i11 = fixedList2.hashCode();
        }
        return i12 + i11;
    }

    public boolean isAvailable() {
        return (this.profitAmount == null && this.activeList == null && this.fixedList == null) ? false : true;
    }

    public void setActiveList(List<MiningItem> list) {
        this.activeList = list;
    }

    public void setFixedList(List<MiningItem> list) {
        this.fixedList = list;
    }

    public void setProfitAmount(String str) {
        this.profitAmount = str;
    }

    public void setProfitAmountLegal(String str) {
        this.profitAmountLegal = str;
    }

    public String toString() {
        return "MiningDataTotal(profitAmount=" + getProfitAmount() + ", profitAmountLegal=" + getProfitAmountLegal() + ", activeList=" + getActiveList() + ", fixedList=" + getFixedList() + ")";
    }
}
