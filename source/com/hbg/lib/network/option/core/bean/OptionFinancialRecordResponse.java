package com.hbg.lib.network.option.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class OptionFinancialRecordResponse implements Serializable {
    @SerializedName("current_page")
    private int currentPage;
    @SerializedName("account_action")
    private List<OptionFinancialRecord> financialRecord;
    @SerializedName("total_page")
    private int totalPage;
    @SerializedName("total_size")
    private int totalSize;

    public boolean canEqual(Object obj) {
        return obj instanceof OptionFinancialRecordResponse;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OptionFinancialRecordResponse)) {
            return false;
        }
        OptionFinancialRecordResponse optionFinancialRecordResponse = (OptionFinancialRecordResponse) obj;
        if (!optionFinancialRecordResponse.canEqual(this)) {
            return false;
        }
        List<OptionFinancialRecord> financialRecord2 = getFinancialRecord();
        List<OptionFinancialRecord> financialRecord3 = optionFinancialRecordResponse.getFinancialRecord();
        if (financialRecord2 != null ? financialRecord2.equals(financialRecord3) : financialRecord3 == null) {
            return getTotalPage() == optionFinancialRecordResponse.getTotalPage() && getCurrentPage() == optionFinancialRecordResponse.getCurrentPage() && getTotalSize() == optionFinancialRecordResponse.getTotalSize();
        }
        return false;
    }

    public int getCurrentPage() {
        return this.currentPage;
    }

    public List<OptionFinancialRecord> getFinancialRecord() {
        return this.financialRecord;
    }

    public int getTotalPage() {
        return this.totalPage;
    }

    public int getTotalSize() {
        return this.totalSize;
    }

    public int hashCode() {
        List<OptionFinancialRecord> financialRecord2 = getFinancialRecord();
        return (((((((financialRecord2 == null ? 43 : financialRecord2.hashCode()) + 59) * 59) + getTotalPage()) * 59) + getCurrentPage()) * 59) + getTotalSize();
    }

    public void setCurrentPage(int i11) {
        this.currentPage = i11;
    }

    public void setFinancialRecord(List<OptionFinancialRecord> list) {
        this.financialRecord = list;
    }

    public void setTotalPage(int i11) {
        this.totalPage = i11;
    }

    public void setTotalSize(int i11) {
        this.totalSize = i11;
    }

    public String toString() {
        return "OptionFinancialRecordResponse(financialRecord=" + getFinancialRecord() + ", totalPage=" + getTotalPage() + ", currentPage=" + getCurrentPage() + ", totalSize=" + getTotalSize() + ")";
    }
}
