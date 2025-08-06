package com.hbg.lib.network.otc.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class LiteReOtcConfigBean implements Serializable {
    @SerializedName("coin")
    private List<LiteCoinInfo> LiteCoinInfoList;
    private boolean blueshield;
    @SerializedName("currency")
    public List<LiteCurrencyBean> listCurrencyBeans;

    public static class LiteCoinInfo implements Serializable {
        private String appLogo;
        private String coinCode;
        private int coinId;
        private String coinType;
        private int confirmations;
        private String fullName;
        private boolean isLiteCoinBuy;
        private boolean isLiteCoinSell;
        private boolean isLiteCurrencyBuy;
        private boolean isLiteCurrencySell;
        private boolean isLiteShow;
        private boolean isRecharge;
        private boolean isRemote;
        private boolean isShow;
        private boolean isShowAssetDetail;
        private boolean isTrade;
        private boolean isTransfer;
        private String liteLogo;
        private Double minRecharge;
        private String name;
        private String shortName;
        private String showPrecision;
        private String tradePrecision;
        private String webLogo;

        public boolean canEqual(Object obj) {
            return obj instanceof LiteCoinInfo;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof LiteCoinInfo)) {
                return false;
            }
            LiteCoinInfo liteCoinInfo = (LiteCoinInfo) obj;
            if (!liteCoinInfo.canEqual(this) || getCoinId() != liteCoinInfo.getCoinId()) {
                return false;
            }
            String coinCode2 = getCoinCode();
            String coinCode3 = liteCoinInfo.getCoinCode();
            if (coinCode2 != null ? !coinCode2.equals(coinCode3) : coinCode3 != null) {
                return false;
            }
            String shortName2 = getShortName();
            String shortName3 = liteCoinInfo.getShortName();
            if (shortName2 != null ? !shortName2.equals(shortName3) : shortName3 != null) {
                return false;
            }
            String name2 = getName();
            String name3 = liteCoinInfo.getName();
            if (name2 != null ? !name2.equals(name3) : name3 != null) {
                return false;
            }
            if (isTransfer() != liteCoinInfo.isTransfer() || isRecharge() != liteCoinInfo.isRecharge() || isTrade() != liteCoinInfo.isTrade()) {
                return false;
            }
            String appLogo2 = getAppLogo();
            String appLogo3 = liteCoinInfo.getAppLogo();
            if (appLogo2 != null ? !appLogo2.equals(appLogo3) : appLogo3 != null) {
                return false;
            }
            String webLogo2 = getWebLogo();
            String webLogo3 = liteCoinInfo.getWebLogo();
            if (webLogo2 != null ? !webLogo2.equals(webLogo3) : webLogo3 != null) {
                return false;
            }
            if (getConfirmations() != liteCoinInfo.getConfirmations()) {
                return false;
            }
            Double minRecharge2 = getMinRecharge();
            Double minRecharge3 = liteCoinInfo.getMinRecharge();
            if (minRecharge2 != null ? !minRecharge2.equals(minRecharge3) : minRecharge3 != null) {
                return false;
            }
            if (isRemote() != liteCoinInfo.isRemote() || isShow() != liteCoinInfo.isShow() || isLiteShow() != liteCoinInfo.isLiteShow()) {
                return false;
            }
            String liteLogo2 = getLiteLogo();
            String liteLogo3 = liteCoinInfo.getLiteLogo();
            if (liteLogo2 != null ? !liteLogo2.equals(liteLogo3) : liteLogo3 != null) {
                return false;
            }
            if (isLiteCurrencySell() != liteCoinInfo.isLiteCurrencySell() || isLiteCurrencyBuy() != liteCoinInfo.isLiteCurrencyBuy() || isLiteCoinSell() != liteCoinInfo.isLiteCoinSell() || isLiteCoinBuy() != liteCoinInfo.isLiteCoinBuy()) {
                return false;
            }
            String tradePrecision2 = getTradePrecision();
            String tradePrecision3 = liteCoinInfo.getTradePrecision();
            if (tradePrecision2 != null ? !tradePrecision2.equals(tradePrecision3) : tradePrecision3 != null) {
                return false;
            }
            String showPrecision2 = getShowPrecision();
            String showPrecision3 = liteCoinInfo.getShowPrecision();
            if (showPrecision2 != null ? !showPrecision2.equals(showPrecision3) : showPrecision3 != null) {
                return false;
            }
            String fullName2 = getFullName();
            String fullName3 = liteCoinInfo.getFullName();
            if (fullName2 != null ? !fullName2.equals(fullName3) : fullName3 != null) {
                return false;
            }
            String coinType2 = getCoinType();
            String coinType3 = liteCoinInfo.getCoinType();
            if (coinType2 != null ? coinType2.equals(coinType3) : coinType3 == null) {
                return isShowAssetDetail() == liteCoinInfo.isShowAssetDetail();
            }
            return false;
        }

        public String getAppLogo() {
            return this.appLogo;
        }

        public String getCoinCode() {
            return this.coinCode;
        }

        public int getCoinId() {
            return this.coinId;
        }

        public String getCoinType() {
            return this.coinType;
        }

        public int getConfirmations() {
            return this.confirmations;
        }

        public String getFullName() {
            return this.fullName;
        }

        public String getLiteLogo() {
            return this.liteLogo;
        }

        public Double getMinRecharge() {
            return this.minRecharge;
        }

        public String getName() {
            return this.name;
        }

        public String getShortName() {
            return this.shortName;
        }

        public String getShowPrecision() {
            return this.showPrecision;
        }

        public String getTradePrecision() {
            return this.tradePrecision;
        }

        public String getWebLogo() {
            return this.webLogo;
        }

        public int hashCode() {
            String coinCode2 = getCoinCode();
            int i11 = 43;
            int coinId2 = ((getCoinId() + 59) * 59) + (coinCode2 == null ? 43 : coinCode2.hashCode());
            String shortName2 = getShortName();
            int hashCode = (coinId2 * 59) + (shortName2 == null ? 43 : shortName2.hashCode());
            String name2 = getName();
            int i12 = 79;
            int hashCode2 = (((((((hashCode * 59) + (name2 == null ? 43 : name2.hashCode())) * 59) + (isTransfer() ? 79 : 97)) * 59) + (isRecharge() ? 79 : 97)) * 59) + (isTrade() ? 79 : 97);
            String appLogo2 = getAppLogo();
            int hashCode3 = (hashCode2 * 59) + (appLogo2 == null ? 43 : appLogo2.hashCode());
            String webLogo2 = getWebLogo();
            int hashCode4 = (((hashCode3 * 59) + (webLogo2 == null ? 43 : webLogo2.hashCode())) * 59) + getConfirmations();
            Double minRecharge2 = getMinRecharge();
            int hashCode5 = (((((((hashCode4 * 59) + (minRecharge2 == null ? 43 : minRecharge2.hashCode())) * 59) + (isRemote() ? 79 : 97)) * 59) + (isShow() ? 79 : 97)) * 59) + (isLiteShow() ? 79 : 97);
            String liteLogo2 = getLiteLogo();
            int hashCode6 = (((((((((hashCode5 * 59) + (liteLogo2 == null ? 43 : liteLogo2.hashCode())) * 59) + (isLiteCurrencySell() ? 79 : 97)) * 59) + (isLiteCurrencyBuy() ? 79 : 97)) * 59) + (isLiteCoinSell() ? 79 : 97)) * 59) + (isLiteCoinBuy() ? 79 : 97);
            String tradePrecision2 = getTradePrecision();
            int hashCode7 = (hashCode6 * 59) + (tradePrecision2 == null ? 43 : tradePrecision2.hashCode());
            String showPrecision2 = getShowPrecision();
            int hashCode8 = (hashCode7 * 59) + (showPrecision2 == null ? 43 : showPrecision2.hashCode());
            String fullName2 = getFullName();
            int hashCode9 = (hashCode8 * 59) + (fullName2 == null ? 43 : fullName2.hashCode());
            String coinType2 = getCoinType();
            int i13 = hashCode9 * 59;
            if (coinType2 != null) {
                i11 = coinType2.hashCode();
            }
            int i14 = (i13 + i11) * 59;
            if (!isShowAssetDetail()) {
                i12 = 97;
            }
            return i14 + i12;
        }

        public boolean isLiteCoinBuy() {
            return this.isLiteCoinBuy;
        }

        public boolean isLiteCoinSell() {
            return this.isLiteCoinSell;
        }

        public boolean isLiteCurrencyBuy() {
            return this.isLiteCurrencyBuy;
        }

        public boolean isLiteCurrencySell() {
            return this.isLiteCurrencySell;
        }

        public boolean isLiteShow() {
            return this.isLiteShow;
        }

        public boolean isRecharge() {
            return this.isRecharge;
        }

        public boolean isRemote() {
            return this.isRemote;
        }

        public boolean isShow() {
            return this.isShow;
        }

        public boolean isShowAssetDetail() {
            return this.isShowAssetDetail;
        }

        public boolean isTrade() {
            return this.isTrade;
        }

        public boolean isTransfer() {
            return this.isTransfer;
        }

        public void setAppLogo(String str) {
            this.appLogo = str;
        }

        public void setCoinCode(String str) {
            this.coinCode = str;
        }

        public void setCoinId(int i11) {
            this.coinId = i11;
        }

        public void setCoinType(String str) {
            this.coinType = str;
        }

        public void setConfirmations(int i11) {
            this.confirmations = i11;
        }

        public void setFullName(String str) {
            this.fullName = str;
        }

        public void setLiteCoinBuy(boolean z11) {
            this.isLiteCoinBuy = z11;
        }

        public void setLiteCoinSell(boolean z11) {
            this.isLiteCoinSell = z11;
        }

        public void setLiteCurrencyBuy(boolean z11) {
            this.isLiteCurrencyBuy = z11;
        }

        public void setLiteCurrencySell(boolean z11) {
            this.isLiteCurrencySell = z11;
        }

        public void setLiteLogo(String str) {
            this.liteLogo = str;
        }

        public void setLiteShow(boolean z11) {
            this.isLiteShow = z11;
        }

        public void setMinRecharge(Double d11) {
            this.minRecharge = d11;
        }

        public void setName(String str) {
            this.name = str;
        }

        public void setRecharge(boolean z11) {
            this.isRecharge = z11;
        }

        public void setRemote(boolean z11) {
            this.isRemote = z11;
        }

        public void setShortName(String str) {
            this.shortName = str;
        }

        public void setShow(boolean z11) {
            this.isShow = z11;
        }

        public void setShowAssetDetail(boolean z11) {
            this.isShowAssetDetail = z11;
        }

        public void setShowPrecision(String str) {
            this.showPrecision = str;
        }

        public void setTrade(boolean z11) {
            this.isTrade = z11;
        }

        public void setTradePrecision(String str) {
            this.tradePrecision = str;
        }

        public void setTransfer(boolean z11) {
            this.isTransfer = z11;
        }

        public void setWebLogo(String str) {
            this.webLogo = str;
        }

        public String toString() {
            return "LiteReOtcConfigBean.LiteCoinInfo(coinId=" + getCoinId() + ", coinCode=" + getCoinCode() + ", shortName=" + getShortName() + ", name=" + getName() + ", isTransfer=" + isTransfer() + ", isRecharge=" + isRecharge() + ", isTrade=" + isTrade() + ", appLogo=" + getAppLogo() + ", webLogo=" + getWebLogo() + ", confirmations=" + getConfirmations() + ", minRecharge=" + getMinRecharge() + ", isRemote=" + isRemote() + ", isShow=" + isShow() + ", isLiteShow=" + isLiteShow() + ", liteLogo=" + getLiteLogo() + ", isLiteCurrencySell=" + isLiteCurrencySell() + ", isLiteCurrencyBuy=" + isLiteCurrencyBuy() + ", isLiteCoinSell=" + isLiteCoinSell() + ", isLiteCoinBuy=" + isLiteCoinBuy() + ", tradePrecision=" + getTradePrecision() + ", showPrecision=" + getShowPrecision() + ", fullName=" + getFullName() + ", coinType=" + getCoinType() + ", isShowAssetDetail=" + isShowAssetDetail() + ")";
        }
    }

    public static class LiteCurrencyBean implements Serializable {
        private int currencyId;
        private String name;
        private String nameShort;
        private boolean purchaseBuyFlag;
        private boolean purchaseSellFlag;
        private String symbol;

        public boolean canEqual(Object obj) {
            return obj instanceof LiteCurrencyBean;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof LiteCurrencyBean)) {
                return false;
            }
            LiteCurrencyBean liteCurrencyBean = (LiteCurrencyBean) obj;
            if (!liteCurrencyBean.canEqual(this) || getCurrencyId() != liteCurrencyBean.getCurrencyId()) {
                return false;
            }
            String name2 = getName();
            String name3 = liteCurrencyBean.getName();
            if (name2 != null ? !name2.equals(name3) : name3 != null) {
                return false;
            }
            String nameShort2 = getNameShort();
            String nameShort3 = liteCurrencyBean.getNameShort();
            if (nameShort2 != null ? !nameShort2.equals(nameShort3) : nameShort3 != null) {
                return false;
            }
            String symbol2 = getSymbol();
            String symbol3 = liteCurrencyBean.getSymbol();
            if (symbol2 != null ? symbol2.equals(symbol3) : symbol3 == null) {
                return isPurchaseSellFlag() == liteCurrencyBean.isPurchaseSellFlag() && isPurchaseBuyFlag() == liteCurrencyBean.isPurchaseBuyFlag();
            }
            return false;
        }

        public int getCurrencyId() {
            return this.currencyId;
        }

        public String getName() {
            return this.name;
        }

        public String getNameShort() {
            return this.nameShort;
        }

        public String getSymbol() {
            return this.symbol;
        }

        public int hashCode() {
            String name2 = getName();
            int i11 = 43;
            int currencyId2 = ((getCurrencyId() + 59) * 59) + (name2 == null ? 43 : name2.hashCode());
            String nameShort2 = getNameShort();
            int hashCode = (currencyId2 * 59) + (nameShort2 == null ? 43 : nameShort2.hashCode());
            String symbol2 = getSymbol();
            int i12 = hashCode * 59;
            if (symbol2 != null) {
                i11 = symbol2.hashCode();
            }
            int i13 = (i12 + i11) * 59;
            int i14 = 79;
            int i15 = (i13 + (isPurchaseSellFlag() ? 79 : 97)) * 59;
            if (!isPurchaseBuyFlag()) {
                i14 = 97;
            }
            return i15 + i14;
        }

        public boolean isPurchaseBuyFlag() {
            return this.purchaseBuyFlag;
        }

        public boolean isPurchaseSellFlag() {
            return this.purchaseSellFlag;
        }

        public void setCurrencyId(int i11) {
            this.currencyId = i11;
        }

        public void setName(String str) {
            this.name = str;
        }

        public void setNameShort(String str) {
            this.nameShort = str;
        }

        public void setPurchaseBuyFlag(boolean z11) {
            this.purchaseBuyFlag = z11;
        }

        public void setPurchaseSellFlag(boolean z11) {
            this.purchaseSellFlag = z11;
        }

        public void setSymbol(String str) {
            this.symbol = str;
        }

        public String toString() {
            return "LiteReOtcConfigBean.LiteCurrencyBean(currencyId=" + getCurrencyId() + ", name=" + getName() + ", nameShort=" + getNameShort() + ", symbol=" + getSymbol() + ", purchaseSellFlag=" + isPurchaseSellFlag() + ", purchaseBuyFlag=" + isPurchaseBuyFlag() + ")";
        }
    }

    public boolean canEqual(Object obj) {
        return obj instanceof LiteReOtcConfigBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LiteReOtcConfigBean)) {
            return false;
        }
        LiteReOtcConfigBean liteReOtcConfigBean = (LiteReOtcConfigBean) obj;
        if (!liteReOtcConfigBean.canEqual(this)) {
            return false;
        }
        List<LiteCurrencyBean> listCurrencyBeans2 = getListCurrencyBeans();
        List<LiteCurrencyBean> listCurrencyBeans3 = liteReOtcConfigBean.getListCurrencyBeans();
        if (listCurrencyBeans2 != null ? !listCurrencyBeans2.equals(listCurrencyBeans3) : listCurrencyBeans3 != null) {
            return false;
        }
        List<LiteCoinInfo> liteCoinInfoList = getLiteCoinInfoList();
        List<LiteCoinInfo> liteCoinInfoList2 = liteReOtcConfigBean.getLiteCoinInfoList();
        if (liteCoinInfoList != null ? liteCoinInfoList.equals(liteCoinInfoList2) : liteCoinInfoList2 == null) {
            return isBlueshield() == liteReOtcConfigBean.isBlueshield();
        }
        return false;
    }

    public List<LiteCurrencyBean> getListCurrencyBeans() {
        return this.listCurrencyBeans;
    }

    public List<LiteCoinInfo> getLiteCoinInfoList() {
        return this.LiteCoinInfoList;
    }

    public int hashCode() {
        List<LiteCurrencyBean> listCurrencyBeans2 = getListCurrencyBeans();
        int i11 = 43;
        int hashCode = listCurrencyBeans2 == null ? 43 : listCurrencyBeans2.hashCode();
        List<LiteCoinInfo> liteCoinInfoList = getLiteCoinInfoList();
        int i12 = (hashCode + 59) * 59;
        if (liteCoinInfoList != null) {
            i11 = liteCoinInfoList.hashCode();
        }
        return ((i12 + i11) * 59) + (isBlueshield() ? 79 : 97);
    }

    public boolean isBlueshield() {
        return this.blueshield;
    }

    public void setBlueshield(boolean z11) {
        this.blueshield = z11;
    }

    public void setListCurrencyBeans(List<LiteCurrencyBean> list) {
        this.listCurrencyBeans = list;
    }

    public void setLiteCoinInfoList(List<LiteCoinInfo> list) {
        this.LiteCoinInfoList = list;
    }

    public String toString() {
        return "LiteReOtcConfigBean(listCurrencyBeans=" + getListCurrencyBeans() + ", LiteCoinInfoList=" + getLiteCoinInfoList() + ", blueshield=" + isBlueshield() + ")";
    }
}
