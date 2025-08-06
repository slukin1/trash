package com.hbg.lib.network.linear.swap.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class LinearSwapFinancialRecord implements Serializable {
    @SerializedName("current_page")
    private int currentPage;
    @SerializedName("total_page")
    private int totalPage;
    @SerializedName("total_size")
    private int totalSize;
    @SerializedName("transfer_record")
    public List<FinancialRecord> transferRecordList;

    public static class FinancialRecord implements Serializable {
        private String asset;
        @SerializedName("created_at")
        private long createdAt;
        @SerializedName("from_margin_account")
        private String fromMarginAccount;

        /* renamed from: id  reason: collision with root package name */
        private long f70341id;
        private String money;
        @SerializedName("money_type")
        private String moneyType;
        private String symbol;
        @SerializedName("to_margin_account")
        private String toMarginAccount;

        public boolean canEqual(Object obj) {
            return obj instanceof FinancialRecord;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof FinancialRecord)) {
                return false;
            }
            FinancialRecord financialRecord = (FinancialRecord) obj;
            if (!financialRecord.canEqual(this) || getId() != financialRecord.getId()) {
                return false;
            }
            String symbol2 = getSymbol();
            String symbol3 = financialRecord.getSymbol();
            if (symbol2 != null ? !symbol2.equals(symbol3) : symbol3 != null) {
                return false;
            }
            String money2 = getMoney();
            String money3 = financialRecord.getMoney();
            if (money2 != null ? !money2.equals(money3) : money3 != null) {
                return false;
            }
            String moneyType2 = getMoneyType();
            String moneyType3 = financialRecord.getMoneyType();
            if (moneyType2 != null ? !moneyType2.equals(moneyType3) : moneyType3 != null) {
                return false;
            }
            String asset2 = getAsset();
            String asset3 = financialRecord.getAsset();
            if (asset2 != null ? !asset2.equals(asset3) : asset3 != null) {
                return false;
            }
            if (getCreatedAt() != financialRecord.getCreatedAt()) {
                return false;
            }
            String toMarginAccount2 = getToMarginAccount();
            String toMarginAccount3 = financialRecord.getToMarginAccount();
            if (toMarginAccount2 != null ? !toMarginAccount2.equals(toMarginAccount3) : toMarginAccount3 != null) {
                return false;
            }
            String fromMarginAccount2 = getFromMarginAccount();
            String fromMarginAccount3 = financialRecord.getFromMarginAccount();
            return fromMarginAccount2 != null ? fromMarginAccount2.equals(fromMarginAccount3) : fromMarginAccount3 == null;
        }

        public String getAsset() {
            return this.asset;
        }

        public long getCreatedAt() {
            return this.createdAt;
        }

        public String getFromMarginAccount() {
            return this.fromMarginAccount;
        }

        public long getId() {
            return this.f70341id;
        }

        public String getMoney() {
            return this.money;
        }

        public String getMoneyType() {
            return this.moneyType;
        }

        public String getSymbol() {
            return this.symbol;
        }

        public String getToMarginAccount() {
            return this.toMarginAccount;
        }

        public int hashCode() {
            long id2 = getId();
            String symbol2 = getSymbol();
            int i11 = 43;
            int hashCode = ((((int) (id2 ^ (id2 >>> 32))) + 59) * 59) + (symbol2 == null ? 43 : symbol2.hashCode());
            String money2 = getMoney();
            int hashCode2 = (hashCode * 59) + (money2 == null ? 43 : money2.hashCode());
            String moneyType2 = getMoneyType();
            int hashCode3 = (hashCode2 * 59) + (moneyType2 == null ? 43 : moneyType2.hashCode());
            String asset2 = getAsset();
            int i12 = hashCode3 * 59;
            int hashCode4 = asset2 == null ? 43 : asset2.hashCode();
            long createdAt2 = getCreatedAt();
            String toMarginAccount2 = getToMarginAccount();
            int hashCode5 = ((((i12 + hashCode4) * 59) + ((int) ((createdAt2 >>> 32) ^ createdAt2))) * 59) + (toMarginAccount2 == null ? 43 : toMarginAccount2.hashCode());
            String fromMarginAccount2 = getFromMarginAccount();
            int i13 = hashCode5 * 59;
            if (fromMarginAccount2 != null) {
                i11 = fromMarginAccount2.hashCode();
            }
            return i13 + i11;
        }

        public void setAsset(String str) {
            this.asset = str;
        }

        public void setCreatedAt(long j11) {
            this.createdAt = j11;
        }

        public void setFromMarginAccount(String str) {
            this.fromMarginAccount = str;
        }

        public void setId(long j11) {
            this.f70341id = j11;
        }

        public void setMoney(String str) {
            this.money = str;
        }

        public void setMoneyType(String str) {
            this.moneyType = str;
        }

        public void setSymbol(String str) {
            this.symbol = str;
        }

        public void setToMarginAccount(String str) {
            this.toMarginAccount = str;
        }

        public String toString() {
            return "LinearSwapFinancialRecord.FinancialRecord(id=" + getId() + ", symbol=" + getSymbol() + ", money=" + getMoney() + ", moneyType=" + getMoneyType() + ", asset=" + getAsset() + ", createdAt=" + getCreatedAt() + ", toMarginAccount=" + getToMarginAccount() + ", fromMarginAccount=" + getFromMarginAccount() + ")";
        }
    }

    public boolean canEqual(Object obj) {
        return obj instanceof LinearSwapFinancialRecord;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LinearSwapFinancialRecord)) {
            return false;
        }
        LinearSwapFinancialRecord linearSwapFinancialRecord = (LinearSwapFinancialRecord) obj;
        if (!linearSwapFinancialRecord.canEqual(this) || getTotalPage() != linearSwapFinancialRecord.getTotalPage() || getCurrentPage() != linearSwapFinancialRecord.getCurrentPage() || getTotalSize() != linearSwapFinancialRecord.getTotalSize()) {
            return false;
        }
        List<FinancialRecord> transferRecordList2 = getTransferRecordList();
        List<FinancialRecord> transferRecordList3 = linearSwapFinancialRecord.getTransferRecordList();
        return transferRecordList2 != null ? transferRecordList2.equals(transferRecordList3) : transferRecordList3 == null;
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

    public List<FinancialRecord> getTransferRecordList() {
        return this.transferRecordList;
    }

    public int hashCode() {
        int totalPage2 = ((((getTotalPage() + 59) * 59) + getCurrentPage()) * 59) + getTotalSize();
        List<FinancialRecord> transferRecordList2 = getTransferRecordList();
        return (totalPage2 * 59) + (transferRecordList2 == null ? 43 : transferRecordList2.hashCode());
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

    public void setTransferRecordList(List<FinancialRecord> list) {
        this.transferRecordList = list;
    }

    public String toString() {
        return "LinearSwapFinancialRecord(totalPage=" + getTotalPage() + ", currentPage=" + getCurrentPage() + ", totalSize=" + getTotalSize() + ", transferRecordList=" + getTransferRecordList() + ")";
    }
}
