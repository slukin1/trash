package com.hbg.lib.network.hbg.core.bean;

import android.text.TextUtils;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.NonNull;

public class CurrencyFromCCFinanceRecordInfo implements Serializable, Cloneable {
    public static final int TYPE_DEPOSIT = 1;
    public static final int TYPE_TRANSFER = 3;
    public static final int TYPE_WITHDRAW = 2;
    private static final long serialVersionUID = -1817698282201638982L;
    private BigDecimal amount;
    private String bank;
    private String channel;
    private String createdAt;
    private String currency;
    private String direction;
    private BigDecimal fee;

    /* renamed from: id  reason: collision with root package name */
    private long f70233id;
    private String orderCode;
    private String paymentMethodCode;
    private String paymentMethodName;
    private String state;
    private int type;

    public boolean canEqual(Object obj) {
        return obj instanceof CurrencyFromCCFinanceRecordInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CurrencyFromCCFinanceRecordInfo)) {
            return false;
        }
        CurrencyFromCCFinanceRecordInfo currencyFromCCFinanceRecordInfo = (CurrencyFromCCFinanceRecordInfo) obj;
        if (!currencyFromCCFinanceRecordInfo.canEqual(this) || getId() != currencyFromCCFinanceRecordInfo.getId()) {
            return false;
        }
        String orderCode2 = getOrderCode();
        String orderCode3 = currencyFromCCFinanceRecordInfo.getOrderCode();
        if (orderCode2 != null ? !orderCode2.equals(orderCode3) : orderCode3 != null) {
            return false;
        }
        String createdAt2 = getCreatedAt();
        String createdAt3 = currencyFromCCFinanceRecordInfo.getCreatedAt();
        if (createdAt2 != null ? !createdAt2.equals(createdAt3) : createdAt3 != null) {
            return false;
        }
        String currency2 = getCurrency();
        String currency3 = currencyFromCCFinanceRecordInfo.getCurrency();
        if (currency2 != null ? !currency2.equals(currency3) : currency3 != null) {
            return false;
        }
        BigDecimal amount2 = getAmount();
        BigDecimal amount3 = currencyFromCCFinanceRecordInfo.getAmount();
        if (amount2 != null ? !amount2.equals(amount3) : amount3 != null) {
            return false;
        }
        if (getType() != currencyFromCCFinanceRecordInfo.getType()) {
            return false;
        }
        String direction2 = getDirection();
        String direction3 = currencyFromCCFinanceRecordInfo.getDirection();
        if (direction2 != null ? !direction2.equals(direction3) : direction3 != null) {
            return false;
        }
        String state2 = getState();
        String state3 = currencyFromCCFinanceRecordInfo.getState();
        if (state2 != null ? !state2.equals(state3) : state3 != null) {
            return false;
        }
        BigDecimal fee2 = getFee();
        BigDecimal fee3 = currencyFromCCFinanceRecordInfo.getFee();
        if (fee2 != null ? !fee2.equals(fee3) : fee3 != null) {
            return false;
        }
        String paymentMethodCode2 = getPaymentMethodCode();
        String paymentMethodCode3 = currencyFromCCFinanceRecordInfo.getPaymentMethodCode();
        if (paymentMethodCode2 != null ? !paymentMethodCode2.equals(paymentMethodCode3) : paymentMethodCode3 != null) {
            return false;
        }
        String paymentMethodName2 = getPaymentMethodName();
        String paymentMethodName3 = currencyFromCCFinanceRecordInfo.getPaymentMethodName();
        if (paymentMethodName2 != null ? !paymentMethodName2.equals(paymentMethodName3) : paymentMethodName3 != null) {
            return false;
        }
        String channel2 = getChannel();
        String channel3 = currencyFromCCFinanceRecordInfo.getChannel();
        if (channel2 != null ? !channel2.equals(channel3) : channel3 != null) {
            return false;
        }
        String bank2 = getBank();
        String bank3 = currencyFromCCFinanceRecordInfo.getBank();
        return bank2 != null ? bank2.equals(bank3) : bank3 == null;
    }

    public BigDecimal getAmount() {
        return this.amount;
    }

    public String getBank() {
        return this.bank;
    }

    public String getChannel() {
        return this.channel;
    }

    public long getCreateAtLong() {
        try {
            return Long.parseLong(this.createdAt);
        } catch (Throwable unused) {
            return 0;
        }
    }

    public String getCreatedAt() {
        return this.createdAt;
    }

    public String getCurrency() {
        return this.currency;
    }

    public String getDirection() {
        return this.direction;
    }

    public BigDecimal getFee() {
        return this.fee;
    }

    public long getId() {
        return this.f70233id;
    }

    public String getOrderCode() {
        return this.orderCode;
    }

    public String getPaymentMethodCode() {
        return this.paymentMethodCode;
    }

    public String getPaymentMethodName() {
        return this.paymentMethodName;
    }

    public String getState() {
        return this.state;
    }

    public int getStateInt() {
        int i11 = this.type;
        if (i11 != 1 && i11 != 2) {
            return 0;
        }
        try {
            return Integer.parseInt(this.state);
        } catch (Exception unused) {
            return 0;
        }
    }

    public int getType() {
        return this.type;
    }

    public int hashCode() {
        long id2 = getId();
        String orderCode2 = getOrderCode();
        int i11 = 43;
        int hashCode = ((((int) (id2 ^ (id2 >>> 32))) + 59) * 59) + (orderCode2 == null ? 43 : orderCode2.hashCode());
        String createdAt2 = getCreatedAt();
        int hashCode2 = (hashCode * 59) + (createdAt2 == null ? 43 : createdAt2.hashCode());
        String currency2 = getCurrency();
        int hashCode3 = (hashCode2 * 59) + (currency2 == null ? 43 : currency2.hashCode());
        BigDecimal amount2 = getAmount();
        int hashCode4 = (((hashCode3 * 59) + (amount2 == null ? 43 : amount2.hashCode())) * 59) + getType();
        String direction2 = getDirection();
        int hashCode5 = (hashCode4 * 59) + (direction2 == null ? 43 : direction2.hashCode());
        String state2 = getState();
        int hashCode6 = (hashCode5 * 59) + (state2 == null ? 43 : state2.hashCode());
        BigDecimal fee2 = getFee();
        int hashCode7 = (hashCode6 * 59) + (fee2 == null ? 43 : fee2.hashCode());
        String paymentMethodCode2 = getPaymentMethodCode();
        int hashCode8 = (hashCode7 * 59) + (paymentMethodCode2 == null ? 43 : paymentMethodCode2.hashCode());
        String paymentMethodName2 = getPaymentMethodName();
        int hashCode9 = (hashCode8 * 59) + (paymentMethodName2 == null ? 43 : paymentMethodName2.hashCode());
        String channel2 = getChannel();
        int hashCode10 = (hashCode9 * 59) + (channel2 == null ? 43 : channel2.hashCode());
        String bank2 = getBank();
        int i12 = hashCode10 * 59;
        if (bank2 != null) {
            i11 = bank2.hashCode();
        }
        return i12 + i11;
    }

    public boolean isTransferIn() {
        return TextUtils.equals(this.direction, "in");
    }

    public void setAmount(BigDecimal bigDecimal) {
        this.amount = bigDecimal;
    }

    public void setBank(String str) {
        this.bank = str;
    }

    public void setChannel(String str) {
        this.channel = str;
    }

    public void setCreatedAt(String str) {
        this.createdAt = str;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public void setDirection(String str) {
        this.direction = str;
    }

    public void setFee(BigDecimal bigDecimal) {
        this.fee = bigDecimal;
    }

    public void setId(long j11) {
        this.f70233id = j11;
    }

    public void setOrderCode(String str) {
        this.orderCode = str;
    }

    public void setPaymentMethodCode(String str) {
        this.paymentMethodCode = str;
    }

    public void setPaymentMethodName(String str) {
        this.paymentMethodName = str;
    }

    public void setState(String str) {
        this.state = str;
    }

    public void setType(int i11) {
        this.type = i11;
    }

    public String toString() {
        return "CurrencyFromCCFinanceRecordInfo(id=" + getId() + ", orderCode=" + getOrderCode() + ", createdAt=" + getCreatedAt() + ", currency=" + getCurrency() + ", amount=" + getAmount() + ", type=" + getType() + ", direction=" + getDirection() + ", state=" + getState() + ", fee=" + getFee() + ", paymentMethodCode=" + getPaymentMethodCode() + ", paymentMethodName=" + getPaymentMethodName() + ", channel=" + getChannel() + ", bank=" + getBank() + ")";
    }

    @NonNull
    public CurrencyFromCCFinanceRecordInfo clone() {
        CurrencyFromCCFinanceRecordInfo currencyFromCCFinanceRecordInfo = new CurrencyFromCCFinanceRecordInfo();
        currencyFromCCFinanceRecordInfo.f70233id = this.f70233id;
        currencyFromCCFinanceRecordInfo.orderCode = this.orderCode;
        currencyFromCCFinanceRecordInfo.createdAt = this.createdAt;
        currencyFromCCFinanceRecordInfo.currency = this.currency;
        currencyFromCCFinanceRecordInfo.amount = this.amount;
        currencyFromCCFinanceRecordInfo.type = this.type;
        currencyFromCCFinanceRecordInfo.direction = this.direction;
        currencyFromCCFinanceRecordInfo.state = this.state;
        currencyFromCCFinanceRecordInfo.fee = this.fee;
        currencyFromCCFinanceRecordInfo.paymentMethodCode = this.paymentMethodCode;
        currencyFromCCFinanceRecordInfo.paymentMethodName = this.paymentMethodName;
        currencyFromCCFinanceRecordInfo.channel = this.channel;
        currencyFromCCFinanceRecordInfo.bank = this.bank;
        return currencyFromCCFinanceRecordInfo;
    }
}
