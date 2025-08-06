package com.huobi.finance.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class ContractRecordItem implements Serializable {
    public static final int ORG_RECORD_FEE_FLAT_MAKER = 8;
    public static final int ORG_RECORD_FEE_FLAT_TAKER = 7;
    public static final int ORG_RECORD_FEE_OPEN_MAKER = 6;
    public static final int ORG_RECORD_FEE_OPEN_TAKER = 5;
    public static final int ORG_RECORD_FEE_SETTLE = 11;
    public static final int ORG_RECORD_FEE_TO_MANAGE = 23;
    public static final int ORG_RECORD_FLAT = 20;
    public static final int ORG_RECORD_FLAT_LOW = 4;
    public static final int ORG_RECORD_FLAT_MORE = 3;
    public static final int ORG_RECORD_FORCE_FLAT_LOW = 13;
    public static final int ORG_RECORD_FORCE_FLAT_MORE = 12;
    public static final int ORG_RECORD_FROM_FORCE = 25;
    public static final int ORG_RECORD_IN = 14;
    public static final int ORG_RECORD_INJECT_FORCE = 24;
    public static final int ORG_RECORD_LOAN_TO_MANAGE = 21;
    public static final int ORG_RECORD_MANAGE_TO_LOAN = 22;
    public static final int ORG_RECORD_OPEN_LOW = 2;
    public static final int ORG_RECORD_OPEN_MORE = 1;
    public static final int ORG_RECORD_OUT = 15;
    public static final int ORG_RECORD_PUNISH = 27;
    public static final int ORG_RECORD_RETURN = 29;
    public static final int ORG_RECORD_REWARD_ACT = 28;
    public static final int ORG_RECORD_SETTLE_FLAT_LOW = 10;
    public static final int ORG_RECORD_SETTLE_FLAT_MORE = 9;
    public static final int ORG_RECORD_SETTLE_FLAT_PASS_AVG = 19;
    public static final int ORG_RECORD_SETTLE_FLAT_PROFIT_REA = 18;
    public static final int ORG_RECORD_SETTLE_FLAT_PROFIT_UNREA_LOW = 17;
    public static final int ORG_RECORD_SETTLE_FLAT_PROFIT_UNREA_MORE = 16;
    public static final int ORG_RECORD_TRANSFER_FROM_PARENT_ACCOUNT = 37;
    public static final int ORG_RECORD_TRANSFER_FROM_SUB_ACCOUNT = 35;
    public static final int ORG_RECORD_TRANSFER_TO_PARENT_ACCOUNT = 36;
    public static final int ORG_RECORD_TRANSFER_TO_SUB_ACCOUNT = 34;
    public static final int ORG_RECORD_USER_GAIN = 26;
    public static final int RECORD_FEE = 7;
    public static final int RECORD_FLAT = 2;
    public static final int RECORD_FORCE_FLAT = 3;
    public static final int RECORD_IN = 6;
    public static final int RECORD_OPEN = 1;
    public static final int RECORD_OUT = 5;
    public static final int RECORD_REWARD = 8;
    public static final int RECORD_SETTLE = 4;
    public static final int RECORD_SYS = 9;
    private static final long serialVersionUID = -7680531614198279091L;
    private String amount;
    @SerializedName("contract_code")
    private String contractCode;
    @SerializedName("created_at")
    private long createdAt;

    /* renamed from: id  reason: collision with root package name */
    private String f45342id;
    private String interest;
    private String money;
    @SerializedName("money_type")
    private int moneyType;
    private String symbol;

    public boolean canEqual(Object obj) {
        return obj instanceof ContractRecordItem;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ContractRecordItem)) {
            return false;
        }
        ContractRecordItem contractRecordItem = (ContractRecordItem) obj;
        if (!contractRecordItem.canEqual(this)) {
            return false;
        }
        String contractCode2 = getContractCode();
        String contractCode3 = contractRecordItem.getContractCode();
        if (contractCode2 != null ? !contractCode2.equals(contractCode3) : contractCode3 != null) {
            return false;
        }
        if (getCreatedAt() != contractRecordItem.getCreatedAt()) {
            return false;
        }
        String symbol2 = getSymbol();
        String symbol3 = contractRecordItem.getSymbol();
        if (symbol2 != null ? !symbol2.equals(symbol3) : symbol3 != null) {
            return false;
        }
        if (getMoneyType() != contractRecordItem.getMoneyType()) {
            return false;
        }
        String amount2 = getAmount();
        String amount3 = contractRecordItem.getAmount();
        if (amount2 != null ? !amount2.equals(amount3) : amount3 != null) {
            return false;
        }
        String money2 = getMoney();
        String money3 = contractRecordItem.getMoney();
        if (money2 != null ? !money2.equals(money3) : money3 != null) {
            return false;
        }
        String interest2 = getInterest();
        String interest3 = contractRecordItem.getInterest();
        if (interest2 != null ? !interest2.equals(interest3) : interest3 != null) {
            return false;
        }
        String id2 = getId();
        String id3 = contractRecordItem.getId();
        return id2 != null ? id2.equals(id3) : id3 == null;
    }

    public String getAmount() {
        return this.amount;
    }

    public String getContractCode() {
        return this.contractCode;
    }

    public long getCreatedAt() {
        return this.createdAt;
    }

    public String getId() {
        return this.f45342id;
    }

    public String getInterest() {
        return this.interest;
    }

    public String getMoney() {
        return this.money;
    }

    public int getMoneyType() {
        return this.moneyType;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public int hashCode() {
        String contractCode2 = getContractCode();
        int i11 = 43;
        int hashCode = contractCode2 == null ? 43 : contractCode2.hashCode();
        long createdAt2 = getCreatedAt();
        int i12 = ((hashCode + 59) * 59) + ((int) (createdAt2 ^ (createdAt2 >>> 32)));
        String symbol2 = getSymbol();
        int hashCode2 = (((i12 * 59) + (symbol2 == null ? 43 : symbol2.hashCode())) * 59) + getMoneyType();
        String amount2 = getAmount();
        int hashCode3 = (hashCode2 * 59) + (amount2 == null ? 43 : amount2.hashCode());
        String money2 = getMoney();
        int hashCode4 = (hashCode3 * 59) + (money2 == null ? 43 : money2.hashCode());
        String interest2 = getInterest();
        int hashCode5 = (hashCode4 * 59) + (interest2 == null ? 43 : interest2.hashCode());
        String id2 = getId();
        int i13 = hashCode5 * 59;
        if (id2 != null) {
            i11 = id2.hashCode();
        }
        return i13 + i11;
    }

    public void setAmount(String str) {
        this.amount = str;
    }

    public void setContractCode(String str) {
        this.contractCode = str;
    }

    public void setCreatedAt(long j11) {
        this.createdAt = j11;
    }

    public void setId(String str) {
        this.f45342id = str;
    }

    public void setInterest(String str) {
        this.interest = str;
    }

    public void setMoney(String str) {
        this.money = str;
    }

    public void setMoneyType(int i11) {
        this.moneyType = i11;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public String toString() {
        return "ContractRecordItem(contractCode=" + getContractCode() + ", createdAt=" + getCreatedAt() + ", symbol=" + getSymbol() + ", moneyType=" + getMoneyType() + ", amount=" + getAmount() + ", money=" + getMoney() + ", interest=" + getInterest() + ", id=" + getId() + ")";
    }
}
