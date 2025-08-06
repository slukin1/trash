package com.huobi.finance.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class ContractRecordWrapper implements Serializable {
    private List<ContractRecordItem> account_action;
    @SerializedName("current_page")
    private int currentPage;
    @SerializedName("total_page")
    private int totalPage;
    @SerializedName("total_size")
    private int totalSize;

    public boolean canEqual(Object obj) {
        return obj instanceof ContractRecordWrapper;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ContractRecordWrapper)) {
            return false;
        }
        ContractRecordWrapper contractRecordWrapper = (ContractRecordWrapper) obj;
        if (!contractRecordWrapper.canEqual(this)) {
            return false;
        }
        List<ContractRecordItem> account_action2 = getAccount_action();
        List<ContractRecordItem> account_action3 = contractRecordWrapper.getAccount_action();
        if (account_action2 != null ? account_action2.equals(account_action3) : account_action3 == null) {
            return getTotalPage() == contractRecordWrapper.getTotalPage() && getCurrentPage() == contractRecordWrapper.getCurrentPage() && getTotalSize() == contractRecordWrapper.getTotalSize();
        }
        return false;
    }

    public List<ContractRecordItem> getAccount_action() {
        return this.account_action;
    }

    public int getCurrentPage() {
        return this.currentPage;
    }

    public int getTotalPage() {
        return this.totalPage;
    }

    public int getTotalSize() {
        return this.totalSize;
    }

    public int hashCode() {
        List<ContractRecordItem> account_action2 = getAccount_action();
        return (((((((account_action2 == null ? 43 : account_action2.hashCode()) + 59) * 59) + getTotalPage()) * 59) + getCurrentPage()) * 59) + getTotalSize();
    }

    public void setAccount_action(List<ContractRecordItem> list) {
        this.account_action = list;
    }

    public void setCurrentPage(int i11) {
        this.currentPage = i11;
    }

    public void setTotalPage(int i11) {
        this.totalPage = i11;
    }

    public void setTotalSize(int i11) {
        this.totalSize = i11;
    }

    public String toString() {
        return "ContractRecordWrapper(account_action=" + getAccount_action() + ", totalPage=" + getTotalPage() + ", currentPage=" + getCurrentPage() + ", totalSize=" + getTotalSize() + ")";
    }
}
