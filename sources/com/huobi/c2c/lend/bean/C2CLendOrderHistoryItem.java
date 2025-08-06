package com.huobi.c2c.lend.bean;

import com.hbg.lib.network.hbg.core.bean.C2CLoanOrderBean;
import com.hbg.lib.widgets.CommonSwitchButton;
import com.huobi.c2c.lend.viewhandler.C2CLendOrderHistoryItemHandler;
import java.io.Serializable;

public class C2CLendOrderHistoryItem implements s9.a, Serializable {
    private C2CLoanOrderBean c2CLoanOrderBean;
    private transient a callback;
    private String currency;
    private String displayActualIncome;
    private String displayAmount;
    private String displayDate;
    private String displayFilledAmount;
    private String displayInterestRate;
    private String displayReturnedAmount;
    private String displayTerm;

    /* renamed from: id  reason: collision with root package name */
    private long f42906id;
    private String state;

    public interface a {
        void f(C2CLoanOrderBean c2CLoanOrderBean, CommonSwitchButton commonSwitchButton);
    }

    public C2CLendOrderHistoryItem(C2CLoanOrderBean c2CLoanOrderBean2, a aVar) {
        this.c2CLoanOrderBean = c2CLoanOrderBean2;
        this.callback = aVar;
    }

    public boolean canEqual(Object obj) {
        return obj instanceof C2CLendOrderHistoryItem;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C2CLendOrderHistoryItem)) {
            return false;
        }
        C2CLendOrderHistoryItem c2CLendOrderHistoryItem = (C2CLendOrderHistoryItem) obj;
        if (!c2CLendOrderHistoryItem.canEqual(this)) {
            return false;
        }
        C2CLoanOrderBean c2CLoanOrderBean2 = getC2CLoanOrderBean();
        C2CLoanOrderBean c2CLoanOrderBean3 = c2CLendOrderHistoryItem.getC2CLoanOrderBean();
        if (c2CLoanOrderBean2 != null ? !c2CLoanOrderBean2.equals(c2CLoanOrderBean3) : c2CLoanOrderBean3 != null) {
            return false;
        }
        if (getId() != c2CLendOrderHistoryItem.getId()) {
            return false;
        }
        String currency2 = getCurrency();
        String currency3 = c2CLendOrderHistoryItem.getCurrency();
        if (currency2 != null ? !currency2.equals(currency3) : currency3 != null) {
            return false;
        }
        String state2 = getState();
        String state3 = c2CLendOrderHistoryItem.getState();
        if (state2 != null ? !state2.equals(state3) : state3 != null) {
            return false;
        }
        String displayAmount2 = getDisplayAmount();
        String displayAmount3 = c2CLendOrderHistoryItem.getDisplayAmount();
        if (displayAmount2 != null ? !displayAmount2.equals(displayAmount3) : displayAmount3 != null) {
            return false;
        }
        String displayTerm2 = getDisplayTerm();
        String displayTerm3 = c2CLendOrderHistoryItem.getDisplayTerm();
        if (displayTerm2 != null ? !displayTerm2.equals(displayTerm3) : displayTerm3 != null) {
            return false;
        }
        String displayFilledAmount2 = getDisplayFilledAmount();
        String displayFilledAmount3 = c2CLendOrderHistoryItem.getDisplayFilledAmount();
        if (displayFilledAmount2 != null ? !displayFilledAmount2.equals(displayFilledAmount3) : displayFilledAmount3 != null) {
            return false;
        }
        String displayInterestRate2 = getDisplayInterestRate();
        String displayInterestRate3 = c2CLendOrderHistoryItem.getDisplayInterestRate();
        if (displayInterestRate2 != null ? !displayInterestRate2.equals(displayInterestRate3) : displayInterestRate3 != null) {
            return false;
        }
        String displayActualIncome2 = getDisplayActualIncome();
        String displayActualIncome3 = c2CLendOrderHistoryItem.getDisplayActualIncome();
        if (displayActualIncome2 != null ? !displayActualIncome2.equals(displayActualIncome3) : displayActualIncome3 != null) {
            return false;
        }
        String displayDate2 = getDisplayDate();
        String displayDate3 = c2CLendOrderHistoryItem.getDisplayDate();
        if (displayDate2 != null ? !displayDate2.equals(displayDate3) : displayDate3 != null) {
            return false;
        }
        String displayReturnedAmount2 = getDisplayReturnedAmount();
        String displayReturnedAmount3 = c2CLendOrderHistoryItem.getDisplayReturnedAmount();
        return displayReturnedAmount2 != null ? displayReturnedAmount2.equals(displayReturnedAmount3) : displayReturnedAmount3 == null;
    }

    public C2CLoanOrderBean getC2CLoanOrderBean() {
        return this.c2CLoanOrderBean;
    }

    public a getCallback() {
        return this.callback;
    }

    public String getCurrency() {
        return this.currency;
    }

    public String getDisplayActualIncome() {
        return this.displayActualIncome;
    }

    public String getDisplayAmount() {
        return this.displayAmount;
    }

    public String getDisplayDate() {
        return this.displayDate;
    }

    public String getDisplayFilledAmount() {
        return this.displayFilledAmount;
    }

    public String getDisplayInterestRate() {
        return this.displayInterestRate;
    }

    public String getDisplayReturnedAmount() {
        return this.displayReturnedAmount;
    }

    public String getDisplayTerm() {
        return this.displayTerm;
    }

    public long getId() {
        return this.f42906id;
    }

    public String getState() {
        return this.state;
    }

    public String getViewHandlerName() {
        return C2CLendOrderHistoryItemHandler.class.getName();
    }

    public int hashCode() {
        C2CLoanOrderBean c2CLoanOrderBean2 = getC2CLoanOrderBean();
        int i11 = 43;
        int hashCode = c2CLoanOrderBean2 == null ? 43 : c2CLoanOrderBean2.hashCode();
        long id2 = getId();
        int i12 = ((hashCode + 59) * 59) + ((int) (id2 ^ (id2 >>> 32)));
        String currency2 = getCurrency();
        int hashCode2 = (i12 * 59) + (currency2 == null ? 43 : currency2.hashCode());
        String state2 = getState();
        int hashCode3 = (hashCode2 * 59) + (state2 == null ? 43 : state2.hashCode());
        String displayAmount2 = getDisplayAmount();
        int hashCode4 = (hashCode3 * 59) + (displayAmount2 == null ? 43 : displayAmount2.hashCode());
        String displayTerm2 = getDisplayTerm();
        int hashCode5 = (hashCode4 * 59) + (displayTerm2 == null ? 43 : displayTerm2.hashCode());
        String displayFilledAmount2 = getDisplayFilledAmount();
        int hashCode6 = (hashCode5 * 59) + (displayFilledAmount2 == null ? 43 : displayFilledAmount2.hashCode());
        String displayInterestRate2 = getDisplayInterestRate();
        int hashCode7 = (hashCode6 * 59) + (displayInterestRate2 == null ? 43 : displayInterestRate2.hashCode());
        String displayActualIncome2 = getDisplayActualIncome();
        int hashCode8 = (hashCode7 * 59) + (displayActualIncome2 == null ? 43 : displayActualIncome2.hashCode());
        String displayDate2 = getDisplayDate();
        int hashCode9 = (hashCode8 * 59) + (displayDate2 == null ? 43 : displayDate2.hashCode());
        String displayReturnedAmount2 = getDisplayReturnedAmount();
        int i13 = hashCode9 * 59;
        if (displayReturnedAmount2 != null) {
            i11 = displayReturnedAmount2.hashCode();
        }
        return i13 + i11;
    }

    public void setC2CLoanOrderBean(C2CLoanOrderBean c2CLoanOrderBean2) {
        this.c2CLoanOrderBean = c2CLoanOrderBean2;
    }

    public void setCallback(a aVar) {
        this.callback = aVar;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public void setDisplayActualIncome(String str) {
        this.displayActualIncome = str;
    }

    public void setDisplayAmount(String str) {
        this.displayAmount = str;
    }

    public void setDisplayDate(String str) {
        this.displayDate = str;
    }

    public void setDisplayFilledAmount(String str) {
        this.displayFilledAmount = str;
    }

    public void setDisplayInterestRate(String str) {
        this.displayInterestRate = str;
    }

    public void setDisplayReturnedAmount(String str) {
        this.displayReturnedAmount = str;
    }

    public void setDisplayTerm(String str) {
        this.displayTerm = str;
    }

    public void setId(long j11) {
        this.f42906id = j11;
    }

    public void setState(String str) {
        this.state = str;
    }

    public String toString() {
        return "C2CLendOrderHistoryItem(c2CLoanOrderBean=" + getC2CLoanOrderBean() + ", id=" + getId() + ", currency=" + getCurrency() + ", state=" + getState() + ", displayAmount=" + getDisplayAmount() + ", displayTerm=" + getDisplayTerm() + ", displayFilledAmount=" + getDisplayFilledAmount() + ", displayInterestRate=" + getDisplayInterestRate() + ", displayActualIncome=" + getDisplayActualIncome() + ", displayDate=" + getDisplayDate() + ", displayReturnedAmount=" + getDisplayReturnedAmount() + ", callback=" + getCallback() + ")";
    }
}
