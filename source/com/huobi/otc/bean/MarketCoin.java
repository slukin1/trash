package com.huobi.otc.bean;

import com.google.gson.annotations.SerializedName;
import com.huobi.otc.handler.OtcCoinHandler;
import java.io.Serializable;
import java.util.List;
import s9.a;

public class MarketCoin implements Serializable {
    @SerializedName("coin")
    private List<Coin> coinList;

    public class Coin implements Serializable, a {
        private static final String COIN_TYPE_FIAT = "1";
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
        private String minRecharge;
        private String name;
        private boolean selected;
        private String shortName;
        private int showPrecision;
        private int tradePrecision;
        private String webLogo;

        public Coin() {
        }

        public boolean canEqual(Object obj) {
            return obj instanceof Coin;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Coin)) {
                return false;
            }
            Coin coin = (Coin) obj;
            if (!coin.canEqual(this) || isSelected() != coin.isSelected() || getCoinId() != coin.getCoinId()) {
                return false;
            }
            String coinCode2 = getCoinCode();
            String coinCode3 = coin.getCoinCode();
            if (coinCode2 != null ? !coinCode2.equals(coinCode3) : coinCode3 != null) {
                return false;
            }
            String shortName2 = getShortName();
            String shortName3 = coin.getShortName();
            if (shortName2 != null ? !shortName2.equals(shortName3) : shortName3 != null) {
                return false;
            }
            String name2 = getName();
            String name3 = coin.getName();
            if (name2 != null ? !name2.equals(name3) : name3 != null) {
                return false;
            }
            if (isTransfer() != coin.isTransfer() || isRecharge() != coin.isRecharge() || isTrade() != coin.isTrade()) {
                return false;
            }
            String appLogo2 = getAppLogo();
            String appLogo3 = coin.getAppLogo();
            if (appLogo2 != null ? !appLogo2.equals(appLogo3) : appLogo3 != null) {
                return false;
            }
            String webLogo2 = getWebLogo();
            String webLogo3 = coin.getWebLogo();
            if (webLogo2 != null ? !webLogo2.equals(webLogo3) : webLogo3 != null) {
                return false;
            }
            if (getConfirmations() != coin.getConfirmations()) {
                return false;
            }
            String minRecharge2 = getMinRecharge();
            String minRecharge3 = coin.getMinRecharge();
            if (minRecharge2 != null ? !minRecharge2.equals(minRecharge3) : minRecharge3 != null) {
                return false;
            }
            if (isRemote() != coin.isRemote() || isShow() != coin.isShow() || isLiteShow() != coin.isLiteShow() || isLiteCurrencySell() != coin.isLiteCurrencySell() || isLiteCurrencyBuy() != coin.isLiteCurrencyBuy() || isLiteCoinSell() != coin.isLiteCoinSell() || isLiteCoinBuy() != coin.isLiteCoinBuy()) {
                return false;
            }
            String liteLogo2 = getLiteLogo();
            String liteLogo3 = coin.getLiteLogo();
            if (liteLogo2 != null ? !liteLogo2.equals(liteLogo3) : liteLogo3 != null) {
                return false;
            }
            if (getTradePrecision() != coin.getTradePrecision() || getShowPrecision() != coin.getShowPrecision()) {
                return false;
            }
            String fullName2 = getFullName();
            String fullName3 = coin.getFullName();
            if (fullName2 != null ? !fullName2.equals(fullName3) : fullName3 != null) {
                return false;
            }
            String coinType2 = getCoinType();
            String coinType3 = coin.getCoinType();
            if (coinType2 != null ? coinType2.equals(coinType3) : coinType3 == null) {
                return isShowAssetDetail() == coin.isShowAssetDetail();
            }
            return false;
        }

        public String getAppLogo() {
            return this.appLogo;
        }

        public String getCoinCode() {
            String str = this.coinCode;
            return str == null ? this.shortName : str;
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

        public int getCurrencyStatus() {
            int i11 = !isRecharge() ? 4 : 0;
            if (!isTrade()) {
                i11 |= 1;
            }
            return !isTransfer() ? i11 | 2 : i11;
        }

        public String getFullName() {
            return this.fullName;
        }

        public String getLiteLogo() {
            return this.liteLogo;
        }

        public String getMinRecharge() {
            return this.minRecharge;
        }

        public String getName() {
            return this.name;
        }

        public String getShortName() {
            return this.shortName;
        }

        public int getShowPrecision() {
            return this.showPrecision;
        }

        public int getTradePrecision() {
            return this.tradePrecision;
        }

        public String getViewHandlerName() {
            return OtcCoinHandler.class.getName();
        }

        public String getWebLogo() {
            return this.webLogo;
        }

        public int hashCode() {
            int i11 = 79;
            int coinId2 = (((isSelected() ? 79 : 97) + 59) * 59) + getCoinId();
            String coinCode2 = getCoinCode();
            int i12 = 43;
            int hashCode = (coinId2 * 59) + (coinCode2 == null ? 43 : coinCode2.hashCode());
            String shortName2 = getShortName();
            int hashCode2 = (hashCode * 59) + (shortName2 == null ? 43 : shortName2.hashCode());
            String name2 = getName();
            int hashCode3 = (((((((hashCode2 * 59) + (name2 == null ? 43 : name2.hashCode())) * 59) + (isTransfer() ? 79 : 97)) * 59) + (isRecharge() ? 79 : 97)) * 59) + (isTrade() ? 79 : 97);
            String appLogo2 = getAppLogo();
            int hashCode4 = (hashCode3 * 59) + (appLogo2 == null ? 43 : appLogo2.hashCode());
            String webLogo2 = getWebLogo();
            int hashCode5 = (((hashCode4 * 59) + (webLogo2 == null ? 43 : webLogo2.hashCode())) * 59) + getConfirmations();
            String minRecharge2 = getMinRecharge();
            int hashCode6 = (((((((((((((((hashCode5 * 59) + (minRecharge2 == null ? 43 : minRecharge2.hashCode())) * 59) + (isRemote() ? 79 : 97)) * 59) + (isShow() ? 79 : 97)) * 59) + (isLiteShow() ? 79 : 97)) * 59) + (isLiteCurrencySell() ? 79 : 97)) * 59) + (isLiteCurrencyBuy() ? 79 : 97)) * 59) + (isLiteCoinSell() ? 79 : 97)) * 59) + (isLiteCoinBuy() ? 79 : 97);
            String liteLogo2 = getLiteLogo();
            int hashCode7 = (((((hashCode6 * 59) + (liteLogo2 == null ? 43 : liteLogo2.hashCode())) * 59) + getTradePrecision()) * 59) + getShowPrecision();
            String fullName2 = getFullName();
            int hashCode8 = (hashCode7 * 59) + (fullName2 == null ? 43 : fullName2.hashCode());
            String coinType2 = getCoinType();
            int i13 = hashCode8 * 59;
            if (coinType2 != null) {
                i12 = coinType2.hashCode();
            }
            int i14 = (i13 + i12) * 59;
            if (!isShowAssetDetail()) {
                i11 = 97;
            }
            return i14 + i11;
        }

        public boolean isFiatCoin() {
            return "1".equals(this.coinType);
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

        public boolean isSelected() {
            return this.selected;
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

        public void setMinRecharge(String str) {
            this.minRecharge = str;
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

        public void setSelected(boolean z11) {
            this.selected = z11;
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

        public void setShowPrecision(int i11) {
            this.showPrecision = i11;
        }

        public void setTrade(boolean z11) {
            this.isTrade = z11;
        }

        public void setTradePrecision(int i11) {
            this.tradePrecision = i11;
        }

        public void setTransfer(boolean z11) {
            this.isTransfer = z11;
        }

        public void setWebLogo(String str) {
            this.webLogo = str;
        }

        public String toString() {
            return "MarketCoin.Coin(selected=" + isSelected() + ", coinId=" + getCoinId() + ", coinCode=" + getCoinCode() + ", shortName=" + getShortName() + ", name=" + getName() + ", isTransfer=" + isTransfer() + ", isRecharge=" + isRecharge() + ", isTrade=" + isTrade() + ", appLogo=" + getAppLogo() + ", webLogo=" + getWebLogo() + ", confirmations=" + getConfirmations() + ", minRecharge=" + getMinRecharge() + ", isRemote=" + isRemote() + ", isShow=" + isShow() + ", isLiteShow=" + isLiteShow() + ", isLiteCurrencySell=" + isLiteCurrencySell() + ", isLiteCurrencyBuy=" + isLiteCurrencyBuy() + ", isLiteCoinSell=" + isLiteCoinSell() + ", isLiteCoinBuy=" + isLiteCoinBuy() + ", liteLogo=" + getLiteLogo() + ", tradePrecision=" + getTradePrecision() + ", showPrecision=" + getShowPrecision() + ", fullName=" + getFullName() + ", coinType=" + getCoinType() + ", isShowAssetDetail=" + isShowAssetDetail() + ")";
        }
    }

    public boolean canEqual(Object obj) {
        return obj instanceof MarketCoin;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MarketCoin)) {
            return false;
        }
        MarketCoin marketCoin = (MarketCoin) obj;
        if (!marketCoin.canEqual(this)) {
            return false;
        }
        List<Coin> coinList2 = getCoinList();
        List<Coin> coinList3 = marketCoin.getCoinList();
        return coinList2 != null ? coinList2.equals(coinList3) : coinList3 == null;
    }

    public List<Coin> getCoinList() {
        return this.coinList;
    }

    public int hashCode() {
        List<Coin> coinList2 = getCoinList();
        return 59 + (coinList2 == null ? 43 : coinList2.hashCode());
    }

    public void setCoinList(List<Coin> list) {
        this.coinList = list;
    }

    public String toString() {
        return "MarketCoin(coinList=" + getCoinList() + ")";
    }
}
