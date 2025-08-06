package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class C2CLoanOrderBean implements Serializable {
    public static final String LOAN_ORDER_STATE_PARTIAL_FILLED = "partial-filled";
    public static final String LOAN_ORDER_STATE_PREPARE = "prepare";
    public static final String LOAN_ORDER_STATE_SUBMITTED = "submitted";
    private String actualIncome;
    private String amount;
    private long createdAt;
    private String currency;
    private String expectIncome;
    private String filledAmount;

    /* renamed from: id  reason: collision with root package name */
    private long f70228id;
    private String interestRate;
    private int renewState;
    private String returnedAmount;
    private String state;
    private long term;
    private String unfilledAmount;

    public boolean canEqual(Object obj) {
        return obj instanceof C2CLoanOrderBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C2CLoanOrderBean)) {
            return false;
        }
        C2CLoanOrderBean c2CLoanOrderBean = (C2CLoanOrderBean) obj;
        if (!c2CLoanOrderBean.canEqual(this) || getId() != c2CLoanOrderBean.getId() || getCreatedAt() != c2CLoanOrderBean.getCreatedAt()) {
            return false;
        }
        String currency2 = getCurrency();
        String currency3 = c2CLoanOrderBean.getCurrency();
        if (currency2 != null ? !currency2.equals(currency3) : currency3 != null) {
            return false;
        }
        String amount2 = getAmount();
        String amount3 = c2CLoanOrderBean.getAmount();
        if (amount2 != null ? !amount2.equals(amount3) : amount3 != null) {
            return false;
        }
        String interestRate2 = getInterestRate();
        String interestRate3 = c2CLoanOrderBean.getInterestRate();
        if (interestRate2 != null ? !interestRate2.equals(interestRate3) : interestRate3 != null) {
            return false;
        }
        String expectIncome2 = getExpectIncome();
        String expectIncome3 = c2CLoanOrderBean.getExpectIncome();
        if (expectIncome2 != null ? !expectIncome2.equals(expectIncome3) : expectIncome3 != null) {
            return false;
        }
        if (getTerm() != c2CLoanOrderBean.getTerm()) {
            return false;
        }
        String filledAmount2 = getFilledAmount();
        String filledAmount3 = c2CLoanOrderBean.getFilledAmount();
        if (filledAmount2 != null ? !filledAmount2.equals(filledAmount3) : filledAmount3 != null) {
            return false;
        }
        String returnedAmount2 = getReturnedAmount();
        String returnedAmount3 = c2CLoanOrderBean.getReturnedAmount();
        if (returnedAmount2 != null ? !returnedAmount2.equals(returnedAmount3) : returnedAmount3 != null) {
            return false;
        }
        String unfilledAmount2 = getUnfilledAmount();
        String unfilledAmount3 = c2CLoanOrderBean.getUnfilledAmount();
        if (unfilledAmount2 != null ? !unfilledAmount2.equals(unfilledAmount3) : unfilledAmount3 != null) {
            return false;
        }
        String state2 = getState();
        String state3 = c2CLoanOrderBean.getState();
        if (state2 != null ? !state2.equals(state3) : state3 != null) {
            return false;
        }
        if (getRenewState() != c2CLoanOrderBean.getRenewState()) {
            return false;
        }
        String actualIncome2 = getActualIncome();
        String actualIncome3 = c2CLoanOrderBean.getActualIncome();
        return actualIncome2 != null ? actualIncome2.equals(actualIncome3) : actualIncome3 == null;
    }

    public String getActualIncome() {
        return this.actualIncome;
    }

    public String getAmount() {
        return this.amount;
    }

    public long getCreatedAt() {
        return this.createdAt;
    }

    public String getCurrency() {
        return this.currency;
    }

    public String getExpectIncome() {
        return this.expectIncome;
    }

    public String getFilledAmount() {
        return this.filledAmount;
    }

    public long getId() {
        return this.f70228id;
    }

    public String getInterestRate() {
        return this.interestRate;
    }

    public int getRenewState() {
        return this.renewState;
    }

    public String getReturnedAmount() {
        return this.returnedAmount;
    }

    public String getState() {
        return this.state;
    }

    public long getTerm() {
        return this.term;
    }

    public String getUnfilledAmount() {
        return this.unfilledAmount;
    }

    public int hashCode() {
        long id2 = getId();
        long createdAt2 = getCreatedAt();
        int i11 = ((((int) (id2 ^ (id2 >>> 32))) + 59) * 59) + ((int) (createdAt2 ^ (createdAt2 >>> 32)));
        String currency2 = getCurrency();
        int i12 = 43;
        int hashCode = (i11 * 59) + (currency2 == null ? 43 : currency2.hashCode());
        String amount2 = getAmount();
        int hashCode2 = (hashCode * 59) + (amount2 == null ? 43 : amount2.hashCode());
        String interestRate2 = getInterestRate();
        int hashCode3 = (hashCode2 * 59) + (interestRate2 == null ? 43 : interestRate2.hashCode());
        String expectIncome2 = getExpectIncome();
        int i13 = hashCode3 * 59;
        int hashCode4 = expectIncome2 == null ? 43 : expectIncome2.hashCode();
        long term2 = getTerm();
        String filledAmount2 = getFilledAmount();
        int hashCode5 = ((((i13 + hashCode4) * 59) + ((int) ((term2 >>> 32) ^ term2))) * 59) + (filledAmount2 == null ? 43 : filledAmount2.hashCode());
        String returnedAmount2 = getReturnedAmount();
        int hashCode6 = (hashCode5 * 59) + (returnedAmount2 == null ? 43 : returnedAmount2.hashCode());
        String unfilledAmount2 = getUnfilledAmount();
        int hashCode7 = (hashCode6 * 59) + (unfilledAmount2 == null ? 43 : unfilledAmount2.hashCode());
        String state2 = getState();
        int hashCode8 = (((hashCode7 * 59) + (state2 == null ? 43 : state2.hashCode())) * 59) + getRenewState();
        String actualIncome2 = getActualIncome();
        int i14 = hashCode8 * 59;
        if (actualIncome2 != null) {
            i12 = actualIncome2.hashCode();
        }
        return i14 + i12;
    }

    public boolean isRenewOpen() {
        return this.renewState == 1;
    }

    public void setActualIncome(String str) {
        this.actualIncome = str;
    }

    public void setAmount(String str) {
        this.amount = str;
    }

    public void setCreatedAt(long j11) {
        this.createdAt = j11;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public void setExpectIncome(String str) {
        this.expectIncome = str;
    }

    public void setFilledAmount(String str) {
        this.filledAmount = str;
    }

    public void setId(long j11) {
        this.f70228id = j11;
    }

    public void setInterestRate(String str) {
        this.interestRate = str;
    }

    public void setRenewState(int i11) {
        this.renewState = i11;
    }

    public void setReturnedAmount(String str) {
        this.returnedAmount = str;
    }

    public void setState(String str) {
        this.state = str;
    }

    public void setTerm(long j11) {
        this.term = j11;
    }

    public void setUnfilledAmount(String str) {
        this.unfilledAmount = str;
    }

    public String toString() {
        return "C2CLoanOrderBean(id=" + getId() + ", createdAt=" + getCreatedAt() + ", currency=" + getCurrency() + ", amount=" + getAmount() + ", interestRate=" + getInterestRate() + ", expectIncome=" + getExpectIncome() + ", term=" + getTerm() + ", filledAmount=" + getFilledAmount() + ", returnedAmount=" + getReturnedAmount() + ", unfilledAmount=" + getUnfilledAmount() + ", state=" + getState() + ", renewState=" + getRenewState() + ", actualIncome=" + getActualIncome() + ")";
    }
}
