package com.hbg.lib.network.otc.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class OtcMarketCoinInfo implements Serializable {
    private static final long serialVersionUID = 6501224643993807812L;
    @SerializedName("coin")
    private List<CoinInfo> coinInfoList;

    public class CoinInfo implements Serializable {
        private static final String COIN_TYPE_FIAT = "1";
        private static final long serialVersionUID = 22937273925637015L;
        private String coinCode;
        private int coinId;
        private String fullName;
        private boolean isTrade;
        private String shortName;

        public CoinInfo() {
        }

        public boolean canEqual(Object obj) {
            return obj instanceof CoinInfo;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof CoinInfo)) {
                return false;
            }
            CoinInfo coinInfo = (CoinInfo) obj;
            if (!coinInfo.canEqual(this) || getCoinId() != coinInfo.getCoinId()) {
                return false;
            }
            String coinCode2 = getCoinCode();
            String coinCode3 = coinInfo.getCoinCode();
            if (coinCode2 != null ? !coinCode2.equals(coinCode3) : coinCode3 != null) {
                return false;
            }
            String shortName2 = getShortName();
            String shortName3 = coinInfo.getShortName();
            if (shortName2 != null ? !shortName2.equals(shortName3) : shortName3 != null) {
                return false;
            }
            if (isTrade() != coinInfo.isTrade()) {
                return false;
            }
            String fullName2 = getFullName();
            String fullName3 = coinInfo.getFullName();
            return fullName2 != null ? fullName2.equals(fullName3) : fullName3 == null;
        }

        public String getCoinCode() {
            String str = this.coinCode;
            return str == null ? this.shortName : str;
        }

        public int getCoinId() {
            return this.coinId;
        }

        public String getFullName() {
            return this.fullName;
        }

        public String getShortName() {
            return this.shortName;
        }

        public int hashCode() {
            String coinCode2 = getCoinCode();
            int i11 = 43;
            int coinId2 = ((getCoinId() + 59) * 59) + (coinCode2 == null ? 43 : coinCode2.hashCode());
            String shortName2 = getShortName();
            int hashCode = (((coinId2 * 59) + (shortName2 == null ? 43 : shortName2.hashCode())) * 59) + (isTrade() ? 79 : 97);
            String fullName2 = getFullName();
            int i12 = hashCode * 59;
            if (fullName2 != null) {
                i11 = fullName2.hashCode();
            }
            return i12 + i11;
        }

        public boolean isTrade() {
            return this.isTrade;
        }

        public void setCoinCode(String str) {
            this.coinCode = str;
        }

        public void setCoinId(int i11) {
            this.coinId = i11;
        }

        public void setFullName(String str) {
            this.fullName = str;
        }

        public void setShortName(String str) {
            this.shortName = str;
        }

        public void setTrade(boolean z11) {
            this.isTrade = z11;
        }

        public String toString() {
            return "OtcMarketCoinInfo.CoinInfo(coinId=" + getCoinId() + ", coinCode=" + getCoinCode() + ", shortName=" + getShortName() + ", isTrade=" + isTrade() + ", fullName=" + getFullName() + ")";
        }
    }

    public boolean canEqual(Object obj) {
        return obj instanceof OtcMarketCoinInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OtcMarketCoinInfo)) {
            return false;
        }
        OtcMarketCoinInfo otcMarketCoinInfo = (OtcMarketCoinInfo) obj;
        if (!otcMarketCoinInfo.canEqual(this)) {
            return false;
        }
        List<CoinInfo> coinInfoList2 = getCoinInfoList();
        List<CoinInfo> coinInfoList3 = otcMarketCoinInfo.getCoinInfoList();
        return coinInfoList2 != null ? coinInfoList2.equals(coinInfoList3) : coinInfoList3 == null;
    }

    public List<CoinInfo> getCoinInfoList() {
        return this.coinInfoList;
    }

    public int hashCode() {
        List<CoinInfo> coinInfoList2 = getCoinInfoList();
        return 59 + (coinInfoList2 == null ? 43 : coinInfoList2.hashCode());
    }

    public void setCoinInfoList(List<CoinInfo> list) {
        this.coinInfoList = list;
    }

    public String toString() {
        return "OtcMarketCoinInfo(coinInfoList=" + getCoinInfoList() + ")";
    }
}
