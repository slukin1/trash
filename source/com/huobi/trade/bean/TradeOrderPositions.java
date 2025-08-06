package com.huobi.trade.bean;

import androidx.annotation.Keep;
import com.huobi.trade.handler.TradeOrderPositionsHandler;
import java.io.Serializable;
import s9.a;

@Keep
public class TradeOrderPositions implements Serializable, a {
    public long accountId;
    public double assetUsdt;
    public BaseAccount baseAccount;
    public double liabilityUsdt;
    public String liquidationPrice;
    public QuoteAccount quoteAccount;
    public double riskRatio;
    public String symbolCode;
    public String symbolDisplayName;
    public String symbolName;
    public double toLiquidationPrice;

    @Keep
    public static class BaseAccount implements Serializable {
        private double asset;
        private String currencyCode;
        private String currencyDisplayName;
        private String currencyName;
        private double liability;
        private double position;
        private double positionValue;

        public boolean canEqual(Object obj) {
            return obj instanceof BaseAccount;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof BaseAccount)) {
                return false;
            }
            BaseAccount baseAccount = (BaseAccount) obj;
            if (!baseAccount.canEqual(this)) {
                return false;
            }
            String currencyName2 = getCurrencyName();
            String currencyName3 = baseAccount.getCurrencyName();
            if (currencyName2 != null ? !currencyName2.equals(currencyName3) : currencyName3 != null) {
                return false;
            }
            String currencyDisplayName2 = getCurrencyDisplayName();
            String currencyDisplayName3 = baseAccount.getCurrencyDisplayName();
            if (currencyDisplayName2 != null ? !currencyDisplayName2.equals(currencyDisplayName3) : currencyDisplayName3 != null) {
                return false;
            }
            String currencyCode2 = getCurrencyCode();
            String currencyCode3 = baseAccount.getCurrencyCode();
            if (currencyCode2 != null ? currencyCode2.equals(currencyCode3) : currencyCode3 == null) {
                return Double.compare(getAsset(), baseAccount.getAsset()) == 0 && Double.compare(getLiability(), baseAccount.getLiability()) == 0 && Double.compare(getPosition(), baseAccount.getPosition()) == 0 && Double.compare(getPositionValue(), baseAccount.getPositionValue()) == 0;
            }
            return false;
        }

        public double getAsset() {
            return this.asset;
        }

        public String getCurrencyCode() {
            return this.currencyCode;
        }

        public String getCurrencyDisplayName() {
            return this.currencyDisplayName;
        }

        public String getCurrencyName() {
            return this.currencyName;
        }

        public double getLiability() {
            return this.liability;
        }

        public double getPosition() {
            return this.position;
        }

        public double getPositionValue() {
            return this.positionValue;
        }

        public int hashCode() {
            String currencyName2 = getCurrencyName();
            int i11 = 43;
            int hashCode = currencyName2 == null ? 43 : currencyName2.hashCode();
            String currencyDisplayName2 = getCurrencyDisplayName();
            int hashCode2 = ((hashCode + 59) * 59) + (currencyDisplayName2 == null ? 43 : currencyDisplayName2.hashCode());
            String currencyCode2 = getCurrencyCode();
            int i12 = hashCode2 * 59;
            if (currencyCode2 != null) {
                i11 = currencyCode2.hashCode();
            }
            long doubleToLongBits = Double.doubleToLongBits(getAsset());
            int i13 = ((i12 + i11) * 59) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
            long doubleToLongBits2 = Double.doubleToLongBits(getLiability());
            int i14 = (i13 * 59) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
            long doubleToLongBits3 = Double.doubleToLongBits(getPosition());
            int i15 = (i14 * 59) + ((int) (doubleToLongBits3 ^ (doubleToLongBits3 >>> 32)));
            long doubleToLongBits4 = Double.doubleToLongBits(getPositionValue());
            return (i15 * 59) + ((int) ((doubleToLongBits4 >>> 32) ^ doubleToLongBits4));
        }

        public void setAsset(double d11) {
            this.asset = d11;
        }

        public void setCurrencyCode(String str) {
            this.currencyCode = str;
        }

        public void setCurrencyDisplayName(String str) {
            this.currencyDisplayName = str;
        }

        public void setCurrencyName(String str) {
            this.currencyName = str;
        }

        public void setLiability(double d11) {
            this.liability = d11;
        }

        public void setPosition(double d11) {
            this.position = d11;
        }

        public void setPositionValue(double d11) {
            this.positionValue = d11;
        }

        public String toString() {
            return "TradeOrderPositions.BaseAccount(currencyName=" + getCurrencyName() + ", currencyDisplayName=" + getCurrencyDisplayName() + ", currencyCode=" + getCurrencyCode() + ", asset=" + getAsset() + ", liability=" + getLiability() + ", position=" + getPosition() + ", positionValue=" + getPositionValue() + ")";
        }
    }

    @Keep
    public static class QuoteAccount implements Serializable {
        private double asset;
        private String currencyCode;
        private String currencyDisplayName;
        private String currencyName;
        private double liability;
        private double position;
        private double positionValue;

        public boolean canEqual(Object obj) {
            return obj instanceof QuoteAccount;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof QuoteAccount)) {
                return false;
            }
            QuoteAccount quoteAccount = (QuoteAccount) obj;
            if (!quoteAccount.canEqual(this)) {
                return false;
            }
            String currencyName2 = getCurrencyName();
            String currencyName3 = quoteAccount.getCurrencyName();
            if (currencyName2 != null ? !currencyName2.equals(currencyName3) : currencyName3 != null) {
                return false;
            }
            String currencyDisplayName2 = getCurrencyDisplayName();
            String currencyDisplayName3 = quoteAccount.getCurrencyDisplayName();
            if (currencyDisplayName2 != null ? !currencyDisplayName2.equals(currencyDisplayName3) : currencyDisplayName3 != null) {
                return false;
            }
            String currencyCode2 = getCurrencyCode();
            String currencyCode3 = quoteAccount.getCurrencyCode();
            if (currencyCode2 != null ? currencyCode2.equals(currencyCode3) : currencyCode3 == null) {
                return Double.compare(getAsset(), quoteAccount.getAsset()) == 0 && Double.compare(getLiability(), quoteAccount.getLiability()) == 0 && Double.compare(getPosition(), quoteAccount.getPosition()) == 0 && Double.compare(getPositionValue(), quoteAccount.getPositionValue()) == 0;
            }
            return false;
        }

        public double getAsset() {
            return this.asset;
        }

        public String getCurrencyCode() {
            return this.currencyCode;
        }

        public String getCurrencyDisplayName() {
            return this.currencyDisplayName;
        }

        public String getCurrencyName() {
            return this.currencyName;
        }

        public double getLiability() {
            return this.liability;
        }

        public double getPosition() {
            return this.position;
        }

        public double getPositionValue() {
            return this.positionValue;
        }

        public int hashCode() {
            String currencyName2 = getCurrencyName();
            int i11 = 43;
            int hashCode = currencyName2 == null ? 43 : currencyName2.hashCode();
            String currencyDisplayName2 = getCurrencyDisplayName();
            int hashCode2 = ((hashCode + 59) * 59) + (currencyDisplayName2 == null ? 43 : currencyDisplayName2.hashCode());
            String currencyCode2 = getCurrencyCode();
            int i12 = hashCode2 * 59;
            if (currencyCode2 != null) {
                i11 = currencyCode2.hashCode();
            }
            long doubleToLongBits = Double.doubleToLongBits(getAsset());
            int i13 = ((i12 + i11) * 59) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
            long doubleToLongBits2 = Double.doubleToLongBits(getLiability());
            int i14 = (i13 * 59) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
            long doubleToLongBits3 = Double.doubleToLongBits(getPosition());
            int i15 = (i14 * 59) + ((int) (doubleToLongBits3 ^ (doubleToLongBits3 >>> 32)));
            long doubleToLongBits4 = Double.doubleToLongBits(getPositionValue());
            return (i15 * 59) + ((int) ((doubleToLongBits4 >>> 32) ^ doubleToLongBits4));
        }

        public void setAsset(double d11) {
            this.asset = d11;
        }

        public void setCurrencyCode(String str) {
            this.currencyCode = str;
        }

        public void setCurrencyDisplayName(String str) {
            this.currencyDisplayName = str;
        }

        public void setCurrencyName(String str) {
            this.currencyName = str;
        }

        public void setLiability(double d11) {
            this.liability = d11;
        }

        public void setPosition(double d11) {
            this.position = d11;
        }

        public void setPositionValue(double d11) {
            this.positionValue = d11;
        }

        public String toString() {
            return "TradeOrderPositions.QuoteAccount(currencyName=" + getCurrencyName() + ", currencyDisplayName=" + getCurrencyDisplayName() + ", currencyCode=" + getCurrencyCode() + ", asset=" + getAsset() + ", liability=" + getLiability() + ", position=" + getPosition() + ", positionValue=" + getPositionValue() + ")";
        }
    }

    public boolean canEqual(Object obj) {
        return obj instanceof TradeOrderPositions;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TradeOrderPositions)) {
            return false;
        }
        TradeOrderPositions tradeOrderPositions = (TradeOrderPositions) obj;
        if (!tradeOrderPositions.canEqual(this) || getAccountId() != tradeOrderPositions.getAccountId()) {
            return false;
        }
        String symbolDisplayName2 = getSymbolDisplayName();
        String symbolDisplayName3 = tradeOrderPositions.getSymbolDisplayName();
        if (symbolDisplayName2 != null ? !symbolDisplayName2.equals(symbolDisplayName3) : symbolDisplayName3 != null) {
            return false;
        }
        String symbolCode2 = getSymbolCode();
        String symbolCode3 = tradeOrderPositions.getSymbolCode();
        if (symbolCode2 != null ? !symbolCode2.equals(symbolCode3) : symbolCode3 != null) {
            return false;
        }
        String symbolName2 = getSymbolName();
        String symbolName3 = tradeOrderPositions.getSymbolName();
        if (symbolName2 != null ? !symbolName2.equals(symbolName3) : symbolName3 != null) {
            return false;
        }
        String liquidationPrice2 = getLiquidationPrice();
        String liquidationPrice3 = tradeOrderPositions.getLiquidationPrice();
        if (liquidationPrice2 != null ? !liquidationPrice2.equals(liquidationPrice3) : liquidationPrice3 != null) {
            return false;
        }
        if (Double.compare(getToLiquidationPrice(), tradeOrderPositions.getToLiquidationPrice()) != 0 || Double.compare(getRiskRatio(), tradeOrderPositions.getRiskRatio()) != 0 || Double.compare(getAssetUsdt(), tradeOrderPositions.getAssetUsdt()) != 0 || Double.compare(getLiabilityUsdt(), tradeOrderPositions.getLiabilityUsdt()) != 0) {
            return false;
        }
        BaseAccount baseAccount2 = getBaseAccount();
        BaseAccount baseAccount3 = tradeOrderPositions.getBaseAccount();
        if (baseAccount2 != null ? !baseAccount2.equals(baseAccount3) : baseAccount3 != null) {
            return false;
        }
        QuoteAccount quoteAccount2 = getQuoteAccount();
        QuoteAccount quoteAccount3 = tradeOrderPositions.getQuoteAccount();
        return quoteAccount2 != null ? quoteAccount2.equals(quoteAccount3) : quoteAccount3 == null;
    }

    public long getAccountId() {
        return this.accountId;
    }

    public double getAssetUsdt() {
        return this.assetUsdt;
    }

    public BaseAccount getBaseAccount() {
        return this.baseAccount;
    }

    public double getLiabilityUsdt() {
        return this.liabilityUsdt;
    }

    public String getLiquidationPrice() {
        return this.liquidationPrice;
    }

    public QuoteAccount getQuoteAccount() {
        return this.quoteAccount;
    }

    public double getRiskRatio() {
        return this.riskRatio;
    }

    public String getSymbolCode() {
        return this.symbolCode;
    }

    public String getSymbolDisplayName() {
        return this.symbolDisplayName;
    }

    public String getSymbolName() {
        return this.symbolName;
    }

    public double getToLiquidationPrice() {
        return this.toLiquidationPrice;
    }

    public String getViewHandlerName() {
        return TradeOrderPositionsHandler.class.getName();
    }

    public int hashCode() {
        long accountId2 = getAccountId();
        String symbolDisplayName2 = getSymbolDisplayName();
        int i11 = 43;
        int hashCode = ((((int) (accountId2 ^ (accountId2 >>> 32))) + 59) * 59) + (symbolDisplayName2 == null ? 43 : symbolDisplayName2.hashCode());
        String symbolCode2 = getSymbolCode();
        int hashCode2 = (hashCode * 59) + (symbolCode2 == null ? 43 : symbolCode2.hashCode());
        String symbolName2 = getSymbolName();
        int hashCode3 = (hashCode2 * 59) + (symbolName2 == null ? 43 : symbolName2.hashCode());
        String liquidationPrice2 = getLiquidationPrice();
        int i12 = hashCode3 * 59;
        int hashCode4 = liquidationPrice2 == null ? 43 : liquidationPrice2.hashCode();
        long doubleToLongBits = Double.doubleToLongBits(getToLiquidationPrice());
        long doubleToLongBits2 = Double.doubleToLongBits(getRiskRatio());
        long doubleToLongBits3 = Double.doubleToLongBits(getAssetUsdt());
        long doubleToLongBits4 = Double.doubleToLongBits(getLiabilityUsdt());
        BaseAccount baseAccount2 = getBaseAccount();
        int hashCode5 = ((((((((((i12 + hashCode4) * 59) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 59) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 59) + ((int) (doubleToLongBits3 ^ (doubleToLongBits3 >>> 32)))) * 59) + ((int) ((doubleToLongBits4 >>> 32) ^ doubleToLongBits4))) * 59) + (baseAccount2 == null ? 43 : baseAccount2.hashCode());
        QuoteAccount quoteAccount2 = getQuoteAccount();
        int i13 = hashCode5 * 59;
        if (quoteAccount2 != null) {
            i11 = quoteAccount2.hashCode();
        }
        return i13 + i11;
    }

    public void setAccountId(long j11) {
        this.accountId = j11;
    }

    public void setAssetUsdt(double d11) {
        this.assetUsdt = d11;
    }

    public void setBaseAccount(BaseAccount baseAccount2) {
        this.baseAccount = baseAccount2;
    }

    public void setLiabilityUsdt(double d11) {
        this.liabilityUsdt = d11;
    }

    public void setLiquidationPrice(String str) {
        this.liquidationPrice = str;
    }

    public void setQuoteAccount(QuoteAccount quoteAccount2) {
        this.quoteAccount = quoteAccount2;
    }

    public void setRiskRatio(double d11) {
        this.riskRatio = d11;
    }

    public void setSymbolCode(String str) {
        this.symbolCode = str;
    }

    public void setSymbolDisplayName(String str) {
        this.symbolDisplayName = str;
    }

    public void setSymbolName(String str) {
        this.symbolName = str;
    }

    public void setToLiquidationPrice(double d11) {
        this.toLiquidationPrice = d11;
    }

    public String toString() {
        return "TradeOrderPositions{accountId=" + this.accountId + ", symbolDisplayName='" + this.symbolDisplayName + '\'' + ", symbolCode='" + this.symbolCode + '\'' + ", symbolName='" + this.symbolName + '\'' + ", liquidationPrice=" + this.liquidationPrice + ", toLiquidationPrice=" + this.toLiquidationPrice + ", riskRatio=" + this.riskRatio + ", assetUsdt=" + this.assetUsdt + ", liabilityUsdt=" + this.liabilityUsdt + ", baseAccount=" + this.baseAccount + ", quoteAccount=" + this.quoteAccount + '}';
    }
}
