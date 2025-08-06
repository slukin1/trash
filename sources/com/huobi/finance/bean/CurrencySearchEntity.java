package com.huobi.finance.bean;

import java.io.Serializable;
import java.util.List;

public class CurrencySearchEntity implements Serializable {
    public static final int TYPE_DEPOSIT = 1;
    public static final int TYPE_TRANSFER = 3;
    public static final int TYPE_WITHDRAW = 2;
    private static final long serialVersionUID = -743560086676900383L;
    private boolean isAdvertModeFromOtc;
    private boolean isDeposit;
    private List<CurrencySearchItem> list;
    private int pageFrom;
    private String selectedCurrency;
    private boolean showDisableDeposit;
    private int type;

    public boolean canEqual(Object obj) {
        return obj instanceof CurrencySearchEntity;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CurrencySearchEntity)) {
            return false;
        }
        CurrencySearchEntity currencySearchEntity = (CurrencySearchEntity) obj;
        if (!currencySearchEntity.canEqual(this) || isDeposit() != currencySearchEntity.isDeposit() || isShowDisableDeposit() != currencySearchEntity.isShowDisableDeposit() || getType() != currencySearchEntity.getType()) {
            return false;
        }
        String selectedCurrency2 = getSelectedCurrency();
        String selectedCurrency3 = currencySearchEntity.getSelectedCurrency();
        if (selectedCurrency2 != null ? !selectedCurrency2.equals(selectedCurrency3) : selectedCurrency3 != null) {
            return false;
        }
        if (getPageFrom() != currencySearchEntity.getPageFrom()) {
            return false;
        }
        List<CurrencySearchItem> list2 = getList();
        List<CurrencySearchItem> list3 = currencySearchEntity.getList();
        if (list2 != null ? list2.equals(list3) : list3 == null) {
            return isAdvertModeFromOtc() == currencySearchEntity.isAdvertModeFromOtc();
        }
        return false;
    }

    public List<CurrencySearchItem> getList() {
        return this.list;
    }

    public int getPageFrom() {
        return this.pageFrom;
    }

    public String getSelectedCurrency() {
        return this.selectedCurrency;
    }

    public int getType() {
        return this.type;
    }

    public int hashCode() {
        int i11 = 79;
        int type2 = (((((isDeposit() ? 79 : 97) + 59) * 59) + (isShowDisableDeposit() ? 79 : 97)) * 59) + getType();
        String selectedCurrency2 = getSelectedCurrency();
        int i12 = 43;
        int hashCode = (((type2 * 59) + (selectedCurrency2 == null ? 43 : selectedCurrency2.hashCode())) * 59) + getPageFrom();
        List<CurrencySearchItem> list2 = getList();
        int i13 = hashCode * 59;
        if (list2 != null) {
            i12 = list2.hashCode();
        }
        int i14 = (i13 + i12) * 59;
        if (!isAdvertModeFromOtc()) {
            i11 = 97;
        }
        return i14 + i11;
    }

    public boolean isAdvertModeFromOtc() {
        return this.isAdvertModeFromOtc;
    }

    public boolean isDeposit() {
        return this.isDeposit;
    }

    public boolean isShowDisableDeposit() {
        return this.showDisableDeposit;
    }

    public void setAdvertModeFromOtc(boolean z11) {
        this.isAdvertModeFromOtc = z11;
    }

    public void setDeposit(boolean z11) {
        this.isDeposit = z11;
    }

    public void setList(List<CurrencySearchItem> list2) {
        this.list = list2;
    }

    public void setPageFrom(int i11) {
        this.pageFrom = i11;
    }

    public void setSelectedCurrency(String str) {
        this.selectedCurrency = str;
    }

    public void setShowDisableDeposit(boolean z11) {
        this.showDisableDeposit = z11;
    }

    public void setType(int i11) {
        this.type = i11;
    }

    public String toString() {
        return "CurrencySearchEntity(isDeposit=" + isDeposit() + ", showDisableDeposit=" + isShowDisableDeposit() + ", type=" + getType() + ", selectedCurrency=" + getSelectedCurrency() + ", pageFrom=" + getPageFrom() + ", list=" + getList() + ", isAdvertModeFromOtc=" + isAdvertModeFromOtc() + ")";
    }
}
