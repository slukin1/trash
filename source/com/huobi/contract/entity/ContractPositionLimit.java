package com.huobi.contract.entity;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;

public class ContractPositionLimit implements Serializable {
    @SerializedName("adjust_status")
    private int adjustStatus;
    @SerializedName("adjustable_list")
    private ArrayList<ContractItemLimit> adjustableList;
    @SerializedName("adjusted_list")
    private ArrayList<ContractItemLimit> adjustedList;
    @SerializedName("asset_deposit")
    private String assetDeposit;

    public static class ContractItemLimit implements Serializable {
        @SerializedName("data")
        public ArrayList<ContractLeverageItem> data;
        @SerializedName("product_id")
        public String product_id;
    }

    public static class ContractLeverageItem implements Serializable {
        @SerializedName("adjustment_multiple")
        public String adjustment_multiple;
        @SerializedName("leverage_range")
        public String leverage_range;
    }

    public boolean canEqual(Object obj) {
        return obj instanceof ContractPositionLimit;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ContractPositionLimit)) {
            return false;
        }
        ContractPositionLimit contractPositionLimit = (ContractPositionLimit) obj;
        if (!contractPositionLimit.canEqual(this)) {
            return false;
        }
        String assetDeposit2 = getAssetDeposit();
        String assetDeposit3 = contractPositionLimit.getAssetDeposit();
        if (assetDeposit2 != null ? !assetDeposit2.equals(assetDeposit3) : assetDeposit3 != null) {
            return false;
        }
        if (getAdjustStatus() != contractPositionLimit.getAdjustStatus()) {
            return false;
        }
        ArrayList<ContractItemLimit> adjustedList2 = getAdjustedList();
        ArrayList<ContractItemLimit> adjustedList3 = contractPositionLimit.getAdjustedList();
        if (adjustedList2 != null ? !adjustedList2.equals(adjustedList3) : adjustedList3 != null) {
            return false;
        }
        ArrayList<ContractItemLimit> adjustableList2 = getAdjustableList();
        ArrayList<ContractItemLimit> adjustableList3 = contractPositionLimit.getAdjustableList();
        return adjustableList2 != null ? adjustableList2.equals(adjustableList3) : adjustableList3 == null;
    }

    public int getAdjustStatus() {
        return this.adjustStatus;
    }

    public ArrayList<ContractItemLimit> getAdjustableList() {
        return this.adjustableList;
    }

    public ArrayList<ContractItemLimit> getAdjustedList() {
        return this.adjustedList;
    }

    public String getAssetDeposit() {
        return this.assetDeposit;
    }

    public int hashCode() {
        String assetDeposit2 = getAssetDeposit();
        int i11 = 43;
        int hashCode = (((assetDeposit2 == null ? 43 : assetDeposit2.hashCode()) + 59) * 59) + getAdjustStatus();
        ArrayList<ContractItemLimit> adjustedList2 = getAdjustedList();
        int hashCode2 = (hashCode * 59) + (adjustedList2 == null ? 43 : adjustedList2.hashCode());
        ArrayList<ContractItemLimit> adjustableList2 = getAdjustableList();
        int i12 = hashCode2 * 59;
        if (adjustableList2 != null) {
            i11 = adjustableList2.hashCode();
        }
        return i12 + i11;
    }

    public void setAdjustStatus(int i11) {
        this.adjustStatus = i11;
    }

    public void setAdjustableList(ArrayList<ContractItemLimit> arrayList) {
        this.adjustableList = arrayList;
    }

    public void setAdjustedList(ArrayList<ContractItemLimit> arrayList) {
        this.adjustedList = arrayList;
    }

    public void setAssetDeposit(String str) {
        this.assetDeposit = str;
    }

    public String toString() {
        return "ContractPositionLimit(assetDeposit=" + getAssetDeposit() + ", adjustStatus=" + getAdjustStatus() + ", adjustedList=" + getAdjustedList() + ", adjustableList=" + getAdjustableList() + ")";
    }
}
