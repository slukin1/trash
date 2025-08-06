package com.huobi.finance.bean;

import com.google.gson.annotations.SerializedName;
import com.huobi.finance.viewhandler.LoanOrderViewHandler;
import i6.m;
import java.io.Serializable;
import s9.a;

public class LoanOrderItem implements Serializable, a {
    public static final String ACCRUAL = "accrual";
    public static final String ALL = "accrual,created,cleared,invalid,failed";
    public static final String CLEARED = "cleared";
    public static final String CREATED = "created";
    public static final String FAILED = "failed";
    public static final String INVALID = "invalid";
    private static final long serialVersionUID = -1817698282201638982L;
    @SerializedName("account-id")
    private String accountID;
    @SerializedName("accrued-at")
    private long accruedTime;
    @SerializedName("created-at")
    private long createdTime;
    private String currency;
    @SerializedName("day-interest-rate")
    private String dailyInterestRate;
    @SerializedName("deduct-rate")
    private String deductRate;

    /* renamed from: id  reason: collision with root package name */
    private long f45374id;
    @SerializedName("interest-amount")
    private String interestAmount;
    @SerializedName("interest-balance")
    private String interestBalance;
    @SerializedName("interest-rate")
    private String interestRate;
    @SerializedName("loan-amount")
    private String loanAmount;
    @SerializedName("loan-balance")
    private String loanBalance;
    private String state;
    private String symbol;
    @SerializedName("user-id")
    private String userID;

    public String getAccountID() {
        return this.accountID;
    }

    public long getAccruedTime() {
        return this.accruedTime;
    }

    public long getCreatedTime() {
        return this.createdTime;
    }

    public String getCurrency() {
        return this.currency;
    }

    public String getDailyInterestRate() {
        return this.dailyInterestRate;
    }

    public String getDeductRate() {
        return this.deductRate;
    }

    public long getId() {
        return this.f45374id;
    }

    public String getInterestAmount() {
        return this.interestAmount;
    }

    public String getInterestBalance() {
        return this.interestBalance;
    }

    public String getInterestRate() {
        return this.interestRate;
    }

    public String getLoanAmount() {
        return this.loanAmount;
    }

    public String getLoanBalance() {
        return this.loanBalance;
    }

    public String getReductedRatePercent() {
        return m.Q(m.a(this.dailyInterestRate).multiply(m.a(this.deductRate)).toPlainString(), 4, 0);
    }

    public String getState() {
        return this.state;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public String getUserID() {
        return this.userID;
    }

    public String getViewHandlerName() {
        return LoanOrderViewHandler.class.getName();
    }

    public void setAccountID(String str) {
        this.accountID = str;
    }

    public void setAccruedTime(long j11) {
        this.accruedTime = j11;
    }

    public void setCreatedTime(long j11) {
        this.createdTime = j11;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public void setDailyInterestRate(String str) {
        this.dailyInterestRate = str;
    }

    public void setDeductRate(String str) {
        this.deductRate = str;
    }

    public void setId(long j11) {
        this.f45374id = j11;
    }

    public void setInterestAmount(String str) {
        this.interestAmount = str;
    }

    public void setInterestBalance(String str) {
        this.interestBalance = str;
    }

    public void setInterestRate(String str) {
        this.interestRate = str;
    }

    public void setLoanAmount(String str) {
        this.loanAmount = str;
    }

    public void setLoanBalance(String str) {
        this.loanBalance = str;
    }

    public void setState(String str) {
        this.state = str;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public void setUserID(String str) {
        this.userID = str;
    }
}
