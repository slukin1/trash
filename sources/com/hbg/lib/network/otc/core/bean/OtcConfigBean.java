package com.hbg.lib.network.otc.core.bean;

import com.google.gson.annotations.SerializedName;
import com.hbg.lib.network.otc.core.bean.OtcConfigItem;
import com.hbg.lib.network.otc.core.bean.OtcMarketCoinInfo;
import java.io.Serializable;
import java.util.List;

public class OtcConfigBean implements Serializable {
    @SerializedName("coin")
    private List<OtcMarketCoinInfo.CoinInfo> coinInfoList;
    @SerializedName("country")
    public List<OtcConfigItem.CountryBean> countryBeans;
    @SerializedName("currency")
    public List<OtcConfigItem.CurrencyBean> currencyBeans;
    public long version;

    public boolean canEqual(Object obj) {
        return obj instanceof OtcConfigBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OtcConfigBean)) {
            return false;
        }
        OtcConfigBean otcConfigBean = (OtcConfigBean) obj;
        if (!otcConfigBean.canEqual(this) || getVersion() != otcConfigBean.getVersion()) {
            return false;
        }
        List<OtcConfigItem.CountryBean> countryBeans2 = getCountryBeans();
        List<OtcConfigItem.CountryBean> countryBeans3 = otcConfigBean.getCountryBeans();
        if (countryBeans2 != null ? !countryBeans2.equals(countryBeans3) : countryBeans3 != null) {
            return false;
        }
        List<OtcConfigItem.CurrencyBean> currencyBeans2 = getCurrencyBeans();
        List<OtcConfigItem.CurrencyBean> currencyBeans3 = otcConfigBean.getCurrencyBeans();
        if (currencyBeans2 != null ? !currencyBeans2.equals(currencyBeans3) : currencyBeans3 != null) {
            return false;
        }
        List<OtcMarketCoinInfo.CoinInfo> coinInfoList2 = getCoinInfoList();
        List<OtcMarketCoinInfo.CoinInfo> coinInfoList3 = otcConfigBean.getCoinInfoList();
        return coinInfoList2 != null ? coinInfoList2.equals(coinInfoList3) : coinInfoList3 == null;
    }

    public List<OtcMarketCoinInfo.CoinInfo> getCoinInfoList() {
        return this.coinInfoList;
    }

    public List<OtcConfigItem.CountryBean> getCountryBeans() {
        return this.countryBeans;
    }

    public List<OtcConfigItem.CurrencyBean> getCurrencyBeans() {
        return this.currencyBeans;
    }

    public long getVersion() {
        return this.version;
    }

    public int hashCode() {
        long version2 = getVersion();
        List<OtcConfigItem.CountryBean> countryBeans2 = getCountryBeans();
        int i11 = 43;
        int hashCode = ((((int) (version2 ^ (version2 >>> 32))) + 59) * 59) + (countryBeans2 == null ? 43 : countryBeans2.hashCode());
        List<OtcConfigItem.CurrencyBean> currencyBeans2 = getCurrencyBeans();
        int hashCode2 = (hashCode * 59) + (currencyBeans2 == null ? 43 : currencyBeans2.hashCode());
        List<OtcMarketCoinInfo.CoinInfo> coinInfoList2 = getCoinInfoList();
        int i12 = hashCode2 * 59;
        if (coinInfoList2 != null) {
            i11 = coinInfoList2.hashCode();
        }
        return i12 + i11;
    }

    public void setCoinInfoList(List<OtcMarketCoinInfo.CoinInfo> list) {
        this.coinInfoList = list;
    }

    public void setCountryBeans(List<OtcConfigItem.CountryBean> list) {
        this.countryBeans = list;
    }

    public void setCurrencyBeans(List<OtcConfigItem.CurrencyBean> list) {
        this.currencyBeans = list;
    }

    public void setVersion(long j11) {
        this.version = j11;
    }

    public String toString() {
        return "OtcConfigBean(version=" + getVersion() + ", countryBeans=" + getCountryBeans() + ", currencyBeans=" + getCurrencyBeans() + ", coinInfoList=" + getCoinInfoList() + ")";
    }
}
