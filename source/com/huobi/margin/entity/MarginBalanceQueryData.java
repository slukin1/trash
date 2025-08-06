package com.huobi.margin.entity;

import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import com.huobi.account.entity.SubaccountQueryData;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class MarginBalanceQueryData implements Serializable {
    public static final String STATE_FL_END = "fl-end";
    public static final String STATE_FL_MGT = "fl-mgt";
    public static final String STATE_FL_NEGATIVE_ACCOUNT = "fl-negative";
    public static final String STATE_FL_SYS = "fl-sys";
    public static final String STATE_WORKING = "working";
    public static final String TYPE_FROZEN = "frozen";
    public static final String TYPE_INTEREST = "interest";
    public static final String TYPE_LOAN = "loan";
    public static final String TYPE_LOAN_AVAILABLE = "loan-available";
    public static final String TYPE_TRADE = "trade";
    private static final long serialVersionUID = 5437794193421523472L;
    @SerializedName("fl-price")
    private String flPrice;

    /* renamed from: id  reason: collision with root package name */
    private int f77938id;
    private List<SubaccountQueryData> list;
    @SerializedName("risk-rate")
    private String riskRate;
    @SerializedName("risk-state")
    private String riskState;
    private String state;
    private String symbol;
    private String type;

    public static BigDecimal bigDecimal(String str) {
        if (TextUtils.isEmpty(str)) {
            return BigDecimal.ZERO;
        }
        try {
            return new BigDecimal(str);
        } catch (Exception unused) {
            return BigDecimal.ZERO;
        }
    }

    public BigDecimal getAvailableLoan(String str) {
        BigDecimal bigDecimal = BigDecimal.ZERO;
        List<SubaccountQueryData> list2 = this.list;
        if (list2 != null) {
            for (SubaccountQueryData next : list2) {
                if ("loan-available".equals(next.getType()) && next.getCurrency().equals(str)) {
                    bigDecimal = bigDecimal(next.getBalance());
                }
            }
        }
        return bigDecimal;
    }

    public String getFlPrice() {
        return this.flPrice;
    }

    public int getId() {
        return this.f77938id;
    }

    public List<SubaccountQueryData> getList() {
        return this.list;
    }

    public BigDecimal getLoanAndInterest(String str) {
        BigDecimal bigDecimal = BigDecimal.ZERO;
        List<SubaccountQueryData> list2 = this.list;
        if (list2 != null) {
            for (SubaccountQueryData next : list2) {
                if (next.getCurrency().equals(str) && ("interest".equals(next.getType()) || "loan".equals(next.getType()))) {
                    bigDecimal = bigDecimal.add(bigDecimal(next.getBalance()).abs());
                }
            }
        }
        return bigDecimal;
    }

    public String getRiskRate() {
        return this.riskRate;
    }

    public String getRiskState() {
        return this.riskState;
    }

    public String getState() {
        return this.state;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public String getType() {
        return this.type;
    }

    public boolean isAssetAvailable() {
        BigDecimal bigDecimal = BigDecimal.ZERO;
        List<SubaccountQueryData> list2 = this.list;
        if (list2 != null) {
            for (SubaccountQueryData next : list2) {
                if ("trade".equals(next.getType()) || "frozen".equals(next.getType())) {
                    bigDecimal = bigDecimal.add(bigDecimal(next.getBalance()));
                }
            }
        }
        return bigDecimal.compareTo(BigDecimal.ZERO) != 0;
    }

    public boolean isLiquidation() {
        return "0".equals(this.riskState);
    }

    public boolean isLoan() {
        List<SubaccountQueryData> list2 = this.list;
        if (list2 == null) {
            return false;
        }
        for (SubaccountQueryData next : list2) {
            if ("loan".equals(next.getType()) && BigDecimal.ZERO.compareTo(new BigDecimal(next.getBalance())) != 0) {
                return true;
            }
        }
        return false;
    }

    public boolean isNegativeAccount() {
        return "-1".equals(this.riskState);
    }

    public void setFlPrice(String str) {
        this.flPrice = str;
    }

    public void setId(int i11) {
        this.f77938id = i11;
    }

    public void setList(List<SubaccountQueryData> list2) {
        this.list = list2;
    }

    public void setRiskRate(String str) {
        this.riskRate = str;
    }

    public void setRiskState(String str) {
        this.riskState = str;
    }

    public void setState(String str) {
        this.state = str;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public void setType(String str) {
        this.type = str;
    }
}
