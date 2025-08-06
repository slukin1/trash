package com.huobi.account.entity;

import android.text.TextUtils;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

public class BalanceQueryData implements Serializable {
    public static final String STATE_LOCK = "lock";
    public static final String STATE_WORKING = "working";
    public static final String TYPE_ADVANCE = "advance";
    public static final String TYPE_BANK = "bank";
    public static final String TYPE_CREDIT = "credit";
    public static final String TYPE_FROZEN = "frozen";
    public static final String TYPE_INTEREST = "interest";
    public static final String TYPE_LOAN = "loan";
    public static final String TYPE_LOAN_AVAILABLE = "loan-available";
    public static final String TYPE_LOCK = "lock";
    public static final String TYPE_TRADE = "trade";
    private static final String ZERO_VALUE = "0";
    private static final long serialVersionUID = 6361154256339381705L;

    /* renamed from: id  reason: collision with root package name */
    private long f40978id;
    private List<SubaccountQueryData> list;
    private String state;
    private String type;

    public static boolean isNetAsset(String str) {
        return "loan".equals(str) || "interest".equals(str) || "trade".equals(str) || "frozen".equals(str);
    }

    public String getAvailable(String str, String str2, String str3) {
        String str4;
        if (str != null && getList() != null && !getList().isEmpty()) {
            Iterator<SubaccountQueryData> it2 = getList().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                SubaccountQueryData next = it2.next();
                if (next.getCurrency().equals(str) && next.getType().equals(str2)) {
                    str4 = next.getAvailable();
                    break;
                }
            }
        }
        str4 = null;
        return str4 == null ? str3 : str4;
    }

    public String getAvailableBalance(String str) {
        String balance = getBalance(str, "trade");
        String balance2 = getBalance(str, TYPE_CREDIT);
        if (!TextUtils.isEmpty(balance) && !TextUtils.isEmpty(balance2)) {
            balance = new BigDecimal(balance).subtract(new BigDecimal(balance2)).toPlainString();
        }
        return TextUtils.isEmpty(balance) ? "0" : balance;
    }

    public String getBalance(String str, String str2) {
        return getBalance(str, str2, "0");
    }

    public long getId() {
        return this.f40978id;
    }

    public List<SubaccountQueryData> getList() {
        return this.list;
    }

    public String getState() {
        return this.state;
    }

    public String getType() {
        return this.type;
    }

    public boolean isWorking() {
        return "working".equals(this.state);
    }

    public void setId(int i11) {
        this.f40978id = (long) i11;
    }

    public void setList(List<SubaccountQueryData> list2) {
        this.list = list2;
    }

    public void setState(String str) {
        this.state = str;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String getBalance(String str, String str2, String str3) {
        String str4;
        if (str != null && getList() != null && !getList().isEmpty()) {
            Iterator<SubaccountQueryData> it2 = getList().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                SubaccountQueryData next = it2.next();
                if (next.getCurrency().equals(str) && next.getType().equals(str2)) {
                    str4 = next.getBalance();
                    break;
                }
            }
        }
        str4 = null;
        return str4 == null ? str3 : str4;
    }
}
