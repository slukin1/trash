package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;
import java.util.List;

public class CopyTradingAccountTransferRecord implements Serializable {
    private int currentPage;
    public List<FinancialRecord> recordList;
    private int totalPage;
    private int totalSize;

    public static class FinancialRecord implements Serializable {
        private String amount;
        private String currency;
        private int status;
        private long time;
        private int type;

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
            if (!financialRecord.canEqual(this) || getTime() != financialRecord.getTime()) {
                return false;
            }
            String currency2 = getCurrency();
            String currency3 = financialRecord.getCurrency();
            if (currency2 != null ? !currency2.equals(currency3) : currency3 != null) {
                return false;
            }
            if (getType() != financialRecord.getType()) {
                return false;
            }
            String amount2 = getAmount();
            String amount3 = financialRecord.getAmount();
            if (amount2 != null ? amount2.equals(amount3) : amount3 == null) {
                return getStatus() == financialRecord.getStatus();
            }
            return false;
        }

        public String getAmount() {
            return this.amount;
        }

        public String getCurrency() {
            return this.currency;
        }

        public int getStatus() {
            return this.status;
        }

        public long getTime() {
            return this.time;
        }

        public int getType() {
            return this.type;
        }

        public int hashCode() {
            long time2 = getTime();
            String currency2 = getCurrency();
            int i11 = 43;
            int hashCode = ((((((int) (time2 ^ (time2 >>> 32))) + 59) * 59) + (currency2 == null ? 43 : currency2.hashCode())) * 59) + getType();
            String amount2 = getAmount();
            int i12 = hashCode * 59;
            if (amount2 != null) {
                i11 = amount2.hashCode();
            }
            return ((i12 + i11) * 59) + getStatus();
        }

        public void setAmount(String str) {
            this.amount = str;
        }

        public void setCurrency(String str) {
            this.currency = str;
        }

        public void setStatus(int i11) {
            this.status = i11;
        }

        public void setTime(long j11) {
            this.time = j11;
        }

        public void setType(int i11) {
            this.type = i11;
        }

        public String toString() {
            return "CopyTradingAccountTransferRecord.FinancialRecord(time=" + getTime() + ", currency=" + getCurrency() + ", type=" + getType() + ", amount=" + getAmount() + ", status=" + getStatus() + ")";
        }
    }

    public boolean canEqual(Object obj) {
        return obj instanceof CopyTradingAccountTransferRecord;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CopyTradingAccountTransferRecord)) {
            return false;
        }
        CopyTradingAccountTransferRecord copyTradingAccountTransferRecord = (CopyTradingAccountTransferRecord) obj;
        if (!copyTradingAccountTransferRecord.canEqual(this) || getTotalPage() != copyTradingAccountTransferRecord.getTotalPage() || getCurrentPage() != copyTradingAccountTransferRecord.getCurrentPage() || getTotalSize() != copyTradingAccountTransferRecord.getTotalSize()) {
            return false;
        }
        List<FinancialRecord> recordList2 = getRecordList();
        List<FinancialRecord> recordList3 = copyTradingAccountTransferRecord.getRecordList();
        return recordList2 != null ? recordList2.equals(recordList3) : recordList3 == null;
    }

    public int getCurrentPage() {
        return this.currentPage;
    }

    public List<FinancialRecord> getRecordList() {
        return this.recordList;
    }

    public int getTotalPage() {
        return this.totalPage;
    }

    public int getTotalSize() {
        return this.totalSize;
    }

    public int hashCode() {
        int totalPage2 = ((((getTotalPage() + 59) * 59) + getCurrentPage()) * 59) + getTotalSize();
        List<FinancialRecord> recordList2 = getRecordList();
        return (totalPage2 * 59) + (recordList2 == null ? 43 : recordList2.hashCode());
    }

    public void setCurrentPage(int i11) {
        this.currentPage = i11;
    }

    public void setRecordList(List<FinancialRecord> list) {
        this.recordList = list;
    }

    public void setTotalPage(int i11) {
        this.totalPage = i11;
    }

    public void setTotalSize(int i11) {
        this.totalSize = i11;
    }

    public String toString() {
        return "CopyTradingAccountTransferRecord(totalPage=" + getTotalPage() + ", currentPage=" + getCurrentPage() + ", totalSize=" + getTotalSize() + ", recordList=" + getRecordList() + ")";
    }
}
