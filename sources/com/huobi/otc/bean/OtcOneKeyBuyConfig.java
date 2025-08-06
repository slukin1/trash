package com.huobi.otc.bean;

import java.io.Serializable;
import java.util.List;
import s9.a;

public class OtcOneKeyBuyConfig implements Serializable, a {
    private int coinId;
    private List<Integer> coinList;
    private String coinName;
    private List<Integer> currencyList;
    private String maxAmount;
    private float maxPriceRate;
    private String minAmount;
    private float minQuantityAmount;
    private List<Integer> payList;
    private boolean showEmptyPic;

    public boolean canEqual(Object obj) {
        return obj instanceof OtcOneKeyBuyConfig;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OtcOneKeyBuyConfig)) {
            return false;
        }
        OtcOneKeyBuyConfig otcOneKeyBuyConfig = (OtcOneKeyBuyConfig) obj;
        if (!otcOneKeyBuyConfig.canEqual(this) || Float.compare(getMaxPriceRate(), otcOneKeyBuyConfig.getMaxPriceRate()) != 0) {
            return false;
        }
        String minAmount2 = getMinAmount();
        String minAmount3 = otcOneKeyBuyConfig.getMinAmount();
        if (minAmount2 != null ? !minAmount2.equals(minAmount3) : minAmount3 != null) {
            return false;
        }
        if (Float.compare(getMinQuantityAmount(), otcOneKeyBuyConfig.getMinQuantityAmount()) != 0) {
            return false;
        }
        String maxAmount2 = getMaxAmount();
        String maxAmount3 = otcOneKeyBuyConfig.getMaxAmount();
        if (maxAmount2 != null ? !maxAmount2.equals(maxAmount3) : maxAmount3 != null) {
            return false;
        }
        String coinName2 = getCoinName();
        String coinName3 = otcOneKeyBuyConfig.getCoinName();
        if (coinName2 != null ? !coinName2.equals(coinName3) : coinName3 != null) {
            return false;
        }
        if (getCoinId() != otcOneKeyBuyConfig.getCoinId()) {
            return false;
        }
        List<Integer> coinList2 = getCoinList();
        List<Integer> coinList3 = otcOneKeyBuyConfig.getCoinList();
        if (coinList2 != null ? !coinList2.equals(coinList3) : coinList3 != null) {
            return false;
        }
        List<Integer> currencyList2 = getCurrencyList();
        List<Integer> currencyList3 = otcOneKeyBuyConfig.getCurrencyList();
        if (currencyList2 != null ? !currencyList2.equals(currencyList3) : currencyList3 != null) {
            return false;
        }
        List<Integer> payList2 = getPayList();
        List<Integer> payList3 = otcOneKeyBuyConfig.getPayList();
        if (payList2 != null ? payList2.equals(payList3) : payList3 == null) {
            return isShowEmptyPic() == otcOneKeyBuyConfig.isShowEmptyPic();
        }
        return false;
    }

    public int getCoinId() {
        return this.coinId;
    }

    public List<Integer> getCoinList() {
        return this.coinList;
    }

    public String getCoinName() {
        return this.coinName;
    }

    public List<Integer> getCurrencyList() {
        return this.currencyList;
    }

    public String getMaxAmount() {
        return this.maxAmount;
    }

    public float getMaxPriceRate() {
        return this.maxPriceRate;
    }

    public String getMinAmount() {
        return this.minAmount;
    }

    public float getMinQuantityAmount() {
        return this.minQuantityAmount;
    }

    public List<Integer> getPayList() {
        return this.payList;
    }

    public String getViewHandlerName() {
        return null;
    }

    public int hashCode() {
        String minAmount2 = getMinAmount();
        int i11 = 43;
        int floatToIntBits = ((((Float.floatToIntBits(getMaxPriceRate()) + 59) * 59) + (minAmount2 == null ? 43 : minAmount2.hashCode())) * 59) + Float.floatToIntBits(getMinQuantityAmount());
        String maxAmount2 = getMaxAmount();
        int hashCode = (floatToIntBits * 59) + (maxAmount2 == null ? 43 : maxAmount2.hashCode());
        String coinName2 = getCoinName();
        int hashCode2 = (((hashCode * 59) + (coinName2 == null ? 43 : coinName2.hashCode())) * 59) + getCoinId();
        List<Integer> coinList2 = getCoinList();
        int hashCode3 = (hashCode2 * 59) + (coinList2 == null ? 43 : coinList2.hashCode());
        List<Integer> currencyList2 = getCurrencyList();
        int hashCode4 = (hashCode3 * 59) + (currencyList2 == null ? 43 : currencyList2.hashCode());
        List<Integer> payList2 = getPayList();
        int i12 = hashCode4 * 59;
        if (payList2 != null) {
            i11 = payList2.hashCode();
        }
        return ((i12 + i11) * 59) + (isShowEmptyPic() ? 79 : 97);
    }

    public boolean isShowEmptyPic() {
        return this.showEmptyPic;
    }

    public void setCoinId(int i11) {
        this.coinId = i11;
    }

    public void setCoinList(List<Integer> list) {
        this.coinList = list;
    }

    public void setCoinName(String str) {
        this.coinName = str;
    }

    public void setCurrencyList(List<Integer> list) {
        this.currencyList = list;
    }

    public void setMaxAmount(String str) {
        this.maxAmount = str;
    }

    public void setMaxPriceRate(float f11) {
        this.maxPriceRate = f11;
    }

    public void setMinAmount(String str) {
        this.minAmount = str;
    }

    public void setMinQuantityAmount(float f11) {
        this.minQuantityAmount = f11;
    }

    public void setPayList(List<Integer> list) {
        this.payList = list;
    }

    public void setShowEmptyPic(boolean z11) {
        this.showEmptyPic = z11;
    }

    public String toString() {
        return "OtcOneKeyBuyConfig(maxPriceRate=" + getMaxPriceRate() + ", minAmount=" + getMinAmount() + ", minQuantityAmount=" + getMinQuantityAmount() + ", maxAmount=" + getMaxAmount() + ", coinName=" + getCoinName() + ", coinId=" + getCoinId() + ", coinList=" + getCoinList() + ", currencyList=" + getCurrencyList() + ", payList=" + getPayList() + ", showEmptyPic=" + isShowEmptyPic() + ")";
    }
}
