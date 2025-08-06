package com.hbg.lib.network.option.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class OptionFinancialRecord implements Serializable {
    private String amount;
    @SerializedName("contract_code")
    private String contractCode;
    @SerializedName("created_at")
    private long createdAt;
    private String currency;
    @SerializedName("exercise_price")
    private String exercisePrice;

    /* renamed from: id  reason: collision with root package name */
    private String f69258id;
    private String interest;
    private String money;
    @SerializedName("money_type")
    private int moneyType;
    @SerializedName("option_code")
    private String optionCode;
    private String symbol;

    public boolean canEqual(Object obj) {
        return obj instanceof OptionFinancialRecord;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OptionFinancialRecord)) {
            return false;
        }
        OptionFinancialRecord optionFinancialRecord = (OptionFinancialRecord) obj;
        if (!optionFinancialRecord.canEqual(this)) {
            return false;
        }
        String amount2 = getAmount();
        String amount3 = optionFinancialRecord.getAmount();
        if (amount2 != null ? !amount2.equals(amount3) : amount3 != null) {
            return false;
        }
        String contractCode2 = getContractCode();
        String contractCode3 = optionFinancialRecord.getContractCode();
        if (contractCode2 != null ? !contractCode2.equals(contractCode3) : contractCode3 != null) {
            return false;
        }
        if (getCreatedAt() != optionFinancialRecord.getCreatedAt()) {
            return false;
        }
        String currency2 = getCurrency();
        String currency3 = optionFinancialRecord.getCurrency();
        if (currency2 != null ? !currency2.equals(currency3) : currency3 != null) {
            return false;
        }
        String exercisePrice2 = getExercisePrice();
        String exercisePrice3 = optionFinancialRecord.getExercisePrice();
        if (exercisePrice2 != null ? !exercisePrice2.equals(exercisePrice3) : exercisePrice3 != null) {
            return false;
        }
        String id2 = getId();
        String id3 = optionFinancialRecord.getId();
        if (id2 != null ? !id2.equals(id3) : id3 != null) {
            return false;
        }
        String interest2 = getInterest();
        String interest3 = optionFinancialRecord.getInterest();
        if (interest2 != null ? !interest2.equals(interest3) : interest3 != null) {
            return false;
        }
        String money2 = getMoney();
        String money3 = optionFinancialRecord.getMoney();
        if (money2 != null ? !money2.equals(money3) : money3 != null) {
            return false;
        }
        if (getMoneyType() != optionFinancialRecord.getMoneyType()) {
            return false;
        }
        String optionCode2 = getOptionCode();
        String optionCode3 = optionFinancialRecord.getOptionCode();
        if (optionCode2 != null ? !optionCode2.equals(optionCode3) : optionCode3 != null) {
            return false;
        }
        String symbol2 = getSymbol();
        String symbol3 = optionFinancialRecord.getSymbol();
        return symbol2 != null ? symbol2.equals(symbol3) : symbol3 == null;
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

    public String getCurrency() {
        return this.currency;
    }

    public String getExercisePrice() {
        return this.exercisePrice;
    }

    public String getId() {
        return this.f69258id;
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

    public String getOptionCode() {
        return this.optionCode;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public int hashCode() {
        String amount2 = getAmount();
        int i11 = 43;
        int hashCode = amount2 == null ? 43 : amount2.hashCode();
        String contractCode2 = getContractCode();
        int hashCode2 = ((hashCode + 59) * 59) + (contractCode2 == null ? 43 : contractCode2.hashCode());
        long createdAt2 = getCreatedAt();
        int i12 = (hashCode2 * 59) + ((int) (createdAt2 ^ (createdAt2 >>> 32)));
        String currency2 = getCurrency();
        int hashCode3 = (i12 * 59) + (currency2 == null ? 43 : currency2.hashCode());
        String exercisePrice2 = getExercisePrice();
        int hashCode4 = (hashCode3 * 59) + (exercisePrice2 == null ? 43 : exercisePrice2.hashCode());
        String id2 = getId();
        int hashCode5 = (hashCode4 * 59) + (id2 == null ? 43 : id2.hashCode());
        String interest2 = getInterest();
        int hashCode6 = (hashCode5 * 59) + (interest2 == null ? 43 : interest2.hashCode());
        String money2 = getMoney();
        int hashCode7 = (((hashCode6 * 59) + (money2 == null ? 43 : money2.hashCode())) * 59) + getMoneyType();
        String optionCode2 = getOptionCode();
        int hashCode8 = (hashCode7 * 59) + (optionCode2 == null ? 43 : optionCode2.hashCode());
        String symbol2 = getSymbol();
        int i13 = hashCode8 * 59;
        if (symbol2 != null) {
            i11 = symbol2.hashCode();
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

    public void setCurrency(String str) {
        this.currency = str;
    }

    public void setExercisePrice(String str) {
        this.exercisePrice = str;
    }

    public void setId(String str) {
        this.f69258id = str;
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

    public void setOptionCode(String str) {
        this.optionCode = str;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public String toString() {
        return "OptionFinancialRecord(amount=" + getAmount() + ", contractCode=" + getContractCode() + ", createdAt=" + getCreatedAt() + ", currency=" + getCurrency() + ", exercisePrice=" + getExercisePrice() + ", id=" + getId() + ", interest=" + getInterest() + ", money=" + getMoney() + ", moneyType=" + getMoneyType() + ", optionCode=" + getOptionCode() + ", symbol=" + getSymbol() + ")";
    }
}
