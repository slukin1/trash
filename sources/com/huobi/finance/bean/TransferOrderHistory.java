package com.huobi.finance.bean;

import android.os.Build;
import com.google.gson.annotations.SerializedName;
import com.huobi.finance.viewhandler.TransferOrderViewHandler;
import com.huobi.supermargin.viewhandler.LoanNotPayOffViewHandler;
import java.io.Serializable;
import java.util.Objects;
import s9.a;

public class TransferOrderHistory implements Serializable, a {
    public static final String TYPE_APPLY_LOAN = "apply-loan";
    public static final String TYPE_AUTO_APPLY_LOAN = "auto-reply-loan";
    public static final String TYPE_AUTO_REPAY_INTEREST = "auto-reply-interest";
    public static final String TYPE_LOAN_REPAY_ALL = "apply-loan,repay-loan,repay-interest,auto-reply-loan,auto-reply-interest,auto-reply-from-spot";
    public static final String TYPE_LOAN_REPAY_FEES = "repay-interest,auto-reply-interest";
    public static final String TYPE_LOAN_REPAY_LOAN = "apply-loan";
    public static final String TYPE_LOAN_REPAY_REPAY = "repay-loan,auto-reply-loan,auto-reply-from-spot";
    public static final String TYPE_REPAY_INTEREST = "repay-interest";
    public static final String TYPE_REPAY_LOAN = "repay-loan";
    public static final String TYPE_SUPER_ALL = "loan-repay-record";
    public static final String TYPE_SUPER_SYSTEM_REPAY = "system-repay";
    public static final String TYPE_SUPER_USER_LOAN = "user-loan-payoff,user-loan-not-payoff";
    public static final String TYPE_SUPER_USER_LOAN_NOT_PAYOFF = "user-loan-not-payoff";
    public static final String TYPE_SUPER_USER_LOAN_PAYOFF = "user-loan-payoff";
    public static final String TYPE_SUPER_USER_REPAY = "user-repay";
    public static final String TYPE_TRANSFER_HISTORY_ALL = "margin-transfer-in,margin-transfer-out";
    public static final String TYPE_TRANSFER_HISTORY_FROM = "margin-transfer-in";
    public static final String TYPE_TRANSFER_HISTORY_TO = "margin-transfer-out";
    private String amount;
    @SerializedName("created-at")
    private long createdat;
    private String currency;
    @SerializedName("deduct-currency")
    private String deductCurrency;
    private String direction;
    @SerializedName("error-code")
    private String errorcode;
    @SerializedName("error-msg")
    private String errormsg;
    private String fees;
    private String historyType;

    /* renamed from: id  reason: collision with root package name */
    private long f45392id;
    @SerializedName("interest-amount")
    private String interestAmount;
    @SerializedName("interest-rate")
    private String interestRate;
    @SerializedName("loan-id")
    private long loanId;
    @SerializedName("payable-amount")
    private String payableAmount;
    @SerializedName("repay-id")
    private long repayId;
    private String state;
    private String symbol;
    @SerializedName("to-address")
    private String toaddress;
    @SerializedName("transaction-id")
    private int transactionid;
    @SerializedName("tx-hash")
    private String txhash;
    private String type;
    @SerializedName("updated-at")
    private long updatedat;

    public long distinctCode() {
        if (Build.VERSION.SDK_INT < 19) {
            return this.createdat;
        }
        return (long) Objects.hash(new Object[]{Long.valueOf(this.createdat), Long.valueOf(this.loanId), Long.valueOf(this.repayId), this.amount});
    }

    public String getAmount() {
        return this.amount;
    }

    public long getCreatedat() {
        return this.createdat;
    }

    public String getCurrency() {
        return this.currency;
    }

    public String getDeductCurrency() {
        return this.deductCurrency;
    }

    public String getDirection() {
        return this.direction;
    }

    public String getErrorcode() {
        return this.errorcode;
    }

    public String getErrormsg() {
        return this.errormsg;
    }

    public String getFees() {
        return this.fees;
    }

    public String getHistoryType() {
        return this.historyType;
    }

    public long getId() {
        return this.f45392id;
    }

    public String getInterestAmount() {
        return this.interestAmount;
    }

    public String getInterestRate() {
        return this.interestRate;
    }

    public long getLoanId() {
        return this.loanId;
    }

    public String getPayableAmount() {
        return this.payableAmount;
    }

    public long getRepayId() {
        return this.repayId;
    }

    public String getState() {
        return this.state;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public String getToaddress() {
        return this.toaddress;
    }

    public int getTransactionid() {
        return this.transactionid;
    }

    public String getTxhash() {
        return this.txhash;
    }

    public String getType() {
        return this.type;
    }

    public long getUpdatedat() {
        return this.updatedat;
    }

    public String getViewHandlerName() {
        if (TYPE_SUPER_USER_LOAN_NOT_PAYOFF.equals(this.historyType)) {
            return LoanNotPayOffViewHandler.class.getName();
        }
        return TransferOrderViewHandler.class.getName();
    }

    public void setAmount(String str) {
        this.amount = str;
    }

    public void setCreatedat(long j11) {
        this.createdat = j11;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public void setDeductCurrency(String str) {
        this.deductCurrency = str;
    }

    public void setDirection(String str) {
        this.direction = str;
    }

    public void setErrorcode(String str) {
        this.errorcode = str;
    }

    public void setErrormsg(String str) {
        this.errormsg = str;
    }

    public void setFees(String str) {
        this.fees = str;
    }

    public void setHistoryType(String str) {
        this.historyType = str;
    }

    public void setId(long j11) {
        this.f45392id = j11;
    }

    public void setInterestAmount(String str) {
        this.interestAmount = str;
    }

    public void setInterestRate(String str) {
        this.interestRate = str;
    }

    public void setLoanId(long j11) {
        this.loanId = j11;
    }

    public void setPayableAmount(String str) {
        this.payableAmount = str;
    }

    public void setRepayId(long j11) {
        this.repayId = j11;
    }

    public void setState(String str) {
        this.state = str;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public void setToaddress(String str) {
        this.toaddress = str;
    }

    public void setTransactionid(int i11) {
        this.transactionid = i11;
    }

    public void setTxhash(String str) {
        this.txhash = str;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setUpdatedat(long j11) {
        this.updatedat = j11;
    }
}
