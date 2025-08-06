package com.hbg.lib.data.future.bean;

import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapAccountInfo;
import java.io.Serializable;

public class FeatureTradeTimeInfo implements Serializable {
    public static final int DEFAULT_SOURCE_CONTRACT = 4;
    public static final int DEFAULT_SOURCE_CONTRACT_TOGETHER = 5;
    public static final int DEFAULT_SOURCE_LINEAR_SWAP = 0;
    public static final int DEFAULT_SOURCE_LINEAR_SWAP_TOGETHER = 1;
    public static final int DEFAULT_SOURCE_SWAP = 2;
    public static final int DEFAULT_SOURCE_SWAP_TOGETHER = 3;
    public static final String DEFAULT_VALUE = "--";
    private double buyFirstPrice;
    private boolean isBuy;
    private double lastPriceNew;
    private String levelRate;
    private LinearSwapAccountInfo linearSwapAccountInfo;
    private FutureContractInfo linearSwapCurrencyInfo;
    private String longAvailableTitle = "--";
    private String longAvailableValue = "--";
    private String longConfirmText = "--";
    private int marginMode;
    private int positionType;
    private double sellFirstPrice;
    private String shortAvailableTitle = "--";
    private String shortAvailableValue = "--";
    private String shortConfirmText = "--";
    private int sourcePage;
    private String symbol = "--";
    private TradeType tradeType;

    public boolean canEqual(Object obj) {
        return obj instanceof FeatureTradeTimeInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FeatureTradeTimeInfo)) {
            return false;
        }
        FeatureTradeTimeInfo featureTradeTimeInfo = (FeatureTradeTimeInfo) obj;
        if (!featureTradeTimeInfo.canEqual(this) || getSourcePage() != featureTradeTimeInfo.getSourcePage()) {
            return false;
        }
        String longAvailableValue2 = getLongAvailableValue();
        String longAvailableValue3 = featureTradeTimeInfo.getLongAvailableValue();
        if (longAvailableValue2 != null ? !longAvailableValue2.equals(longAvailableValue3) : longAvailableValue3 != null) {
            return false;
        }
        String shortAvailableValue2 = getShortAvailableValue();
        String shortAvailableValue3 = featureTradeTimeInfo.getShortAvailableValue();
        if (shortAvailableValue2 != null ? !shortAvailableValue2.equals(shortAvailableValue3) : shortAvailableValue3 != null) {
            return false;
        }
        String longAvailableTitle2 = getLongAvailableTitle();
        String longAvailableTitle3 = featureTradeTimeInfo.getLongAvailableTitle();
        if (longAvailableTitle2 != null ? !longAvailableTitle2.equals(longAvailableTitle3) : longAvailableTitle3 != null) {
            return false;
        }
        String shortAvailableTitle2 = getShortAvailableTitle();
        String shortAvailableTitle3 = featureTradeTimeInfo.getShortAvailableTitle();
        if (shortAvailableTitle2 != null ? !shortAvailableTitle2.equals(shortAvailableTitle3) : shortAvailableTitle3 != null) {
            return false;
        }
        String shortConfirmText2 = getShortConfirmText();
        String shortConfirmText3 = featureTradeTimeInfo.getShortConfirmText();
        if (shortConfirmText2 != null ? !shortConfirmText2.equals(shortConfirmText3) : shortConfirmText3 != null) {
            return false;
        }
        String longConfirmText2 = getLongConfirmText();
        String longConfirmText3 = featureTradeTimeInfo.getLongConfirmText();
        if (longConfirmText2 != null ? !longConfirmText2.equals(longConfirmText3) : longConfirmText3 != null) {
            return false;
        }
        if (getPositionType() != featureTradeTimeInfo.getPositionType()) {
            return false;
        }
        TradeType tradeType2 = getTradeType();
        TradeType tradeType3 = featureTradeTimeInfo.getTradeType();
        if (tradeType2 != null ? !tradeType2.equals(tradeType3) : tradeType3 != null) {
            return false;
        }
        String symbol2 = getSymbol();
        String symbol3 = featureTradeTimeInfo.getSymbol();
        if (symbol2 != null ? !symbol2.equals(symbol3) : symbol3 != null) {
            return false;
        }
        FutureContractInfo linearSwapCurrencyInfo2 = getLinearSwapCurrencyInfo();
        FutureContractInfo linearSwapCurrencyInfo3 = featureTradeTimeInfo.getLinearSwapCurrencyInfo();
        if (linearSwapCurrencyInfo2 != null ? !linearSwapCurrencyInfo2.equals(linearSwapCurrencyInfo3) : linearSwapCurrencyInfo3 != null) {
            return false;
        }
        if (Double.compare(getBuyFirstPrice(), featureTradeTimeInfo.getBuyFirstPrice()) != 0 || Double.compare(getSellFirstPrice(), featureTradeTimeInfo.getSellFirstPrice()) != 0 || Double.compare(getLastPriceNew(), featureTradeTimeInfo.getLastPriceNew()) != 0 || isBuy() != featureTradeTimeInfo.isBuy() || getMarginMode() != featureTradeTimeInfo.getMarginMode()) {
            return false;
        }
        String levelRate2 = getLevelRate();
        String levelRate3 = featureTradeTimeInfo.getLevelRate();
        if (levelRate2 != null ? !levelRate2.equals(levelRate3) : levelRate3 != null) {
            return false;
        }
        LinearSwapAccountInfo linearSwapAccountInfo2 = getLinearSwapAccountInfo();
        LinearSwapAccountInfo linearSwapAccountInfo3 = featureTradeTimeInfo.getLinearSwapAccountInfo();
        return linearSwapAccountInfo2 != null ? linearSwapAccountInfo2.equals(linearSwapAccountInfo3) : linearSwapAccountInfo3 == null;
    }

    public double getBuyFirstPrice() {
        return this.buyFirstPrice;
    }

    public double getLastPriceNew() {
        return this.lastPriceNew;
    }

    public String getLevelRate() {
        return this.levelRate;
    }

    public LinearSwapAccountInfo getLinearSwapAccountInfo() {
        return this.linearSwapAccountInfo;
    }

    public FutureContractInfo getLinearSwapCurrencyInfo() {
        return this.linearSwapCurrencyInfo;
    }

    public String getLongAvailableTitle() {
        return this.longAvailableTitle;
    }

    public String getLongAvailableValue() {
        return this.longAvailableValue;
    }

    public String getLongConfirmText() {
        return this.longConfirmText;
    }

    public int getMarginMode() {
        return this.marginMode;
    }

    public int getPositionType() {
        return this.positionType;
    }

    public double getSellFirstPrice() {
        return this.sellFirstPrice;
    }

    public String getShortAvailableTitle() {
        return this.shortAvailableTitle;
    }

    public String getShortAvailableValue() {
        return this.shortAvailableValue;
    }

    public String getShortConfirmText() {
        return this.shortConfirmText;
    }

    public int getSourcePage() {
        return this.sourcePage;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public TradeType getTradeType() {
        return this.tradeType;
    }

    public int hashCode() {
        String longAvailableValue2 = getLongAvailableValue();
        int i11 = 43;
        int sourcePage2 = ((getSourcePage() + 59) * 59) + (longAvailableValue2 == null ? 43 : longAvailableValue2.hashCode());
        String shortAvailableValue2 = getShortAvailableValue();
        int hashCode = (sourcePage2 * 59) + (shortAvailableValue2 == null ? 43 : shortAvailableValue2.hashCode());
        String longAvailableTitle2 = getLongAvailableTitle();
        int hashCode2 = (hashCode * 59) + (longAvailableTitle2 == null ? 43 : longAvailableTitle2.hashCode());
        String shortAvailableTitle2 = getShortAvailableTitle();
        int hashCode3 = (hashCode2 * 59) + (shortAvailableTitle2 == null ? 43 : shortAvailableTitle2.hashCode());
        String shortConfirmText2 = getShortConfirmText();
        int hashCode4 = (hashCode3 * 59) + (shortConfirmText2 == null ? 43 : shortConfirmText2.hashCode());
        String longConfirmText2 = getLongConfirmText();
        int hashCode5 = (((hashCode4 * 59) + (longConfirmText2 == null ? 43 : longConfirmText2.hashCode())) * 59) + getPositionType();
        TradeType tradeType2 = getTradeType();
        int hashCode6 = (hashCode5 * 59) + (tradeType2 == null ? 43 : tradeType2.hashCode());
        String symbol2 = getSymbol();
        int hashCode7 = (hashCode6 * 59) + (symbol2 == null ? 43 : symbol2.hashCode());
        FutureContractInfo linearSwapCurrencyInfo2 = getLinearSwapCurrencyInfo();
        int i12 = hashCode7 * 59;
        int hashCode8 = linearSwapCurrencyInfo2 == null ? 43 : linearSwapCurrencyInfo2.hashCode();
        long doubleToLongBits = Double.doubleToLongBits(getBuyFirstPrice());
        int i13 = ((i12 + hashCode8) * 59) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
        long doubleToLongBits2 = Double.doubleToLongBits(getSellFirstPrice());
        int i14 = (i13 * 59) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
        long doubleToLongBits3 = Double.doubleToLongBits(getLastPriceNew());
        int marginMode2 = (((((i14 * 59) + ((int) (doubleToLongBits3 ^ (doubleToLongBits3 >>> 32)))) * 59) + (isBuy() ? 79 : 97)) * 59) + getMarginMode();
        String levelRate2 = getLevelRate();
        int hashCode9 = (marginMode2 * 59) + (levelRate2 == null ? 43 : levelRate2.hashCode());
        LinearSwapAccountInfo linearSwapAccountInfo2 = getLinearSwapAccountInfo();
        int i15 = hashCode9 * 59;
        if (linearSwapAccountInfo2 != null) {
            i11 = linearSwapAccountInfo2.hashCode();
        }
        return i15 + i11;
    }

    public boolean isBuy() {
        return this.isBuy;
    }

    public void setBuy(boolean z11) {
        this.isBuy = z11;
    }

    public void setBuyFirstPrice(double d11) {
        this.buyFirstPrice = d11;
    }

    public void setLastPriceNew(double d11) {
        this.lastPriceNew = d11;
    }

    public void setLevelRate(String str) {
        this.levelRate = str;
    }

    public void setLinearSwapAccountInfo(LinearSwapAccountInfo linearSwapAccountInfo2) {
        this.linearSwapAccountInfo = linearSwapAccountInfo2;
    }

    public void setLinearSwapCurrencyInfo(FutureContractInfo futureContractInfo) {
        this.linearSwapCurrencyInfo = futureContractInfo;
    }

    public void setLongAvailableTitle(String str) {
        this.longAvailableTitle = str;
    }

    public void setLongAvailableValue(String str) {
        this.longAvailableValue = str;
    }

    public void setLongConfirmText(String str) {
        this.longConfirmText = str;
    }

    public void setMarginMode(int i11) {
        this.marginMode = i11;
    }

    public void setPositionType(int i11) {
        this.positionType = i11;
    }

    public void setSellFirstPrice(double d11) {
        this.sellFirstPrice = d11;
    }

    public void setShortAvailableTitle(String str) {
        this.shortAvailableTitle = str;
    }

    public void setShortAvailableValue(String str) {
        this.shortAvailableValue = str;
    }

    public void setShortConfirmText(String str) {
        this.shortConfirmText = str;
    }

    public void setSourcePage(int i11) {
        this.sourcePage = i11;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public void setTradeType(TradeType tradeType2) {
        this.tradeType = tradeType2;
    }

    public String toString() {
        return "FeatureTradeTimeInfo(sourcePage=" + getSourcePage() + ", longAvailableValue=" + getLongAvailableValue() + ", shortAvailableValue=" + getShortAvailableValue() + ", longAvailableTitle=" + getLongAvailableTitle() + ", shortAvailableTitle=" + getShortAvailableTitle() + ", shortConfirmText=" + getShortConfirmText() + ", longConfirmText=" + getLongConfirmText() + ", positionType=" + getPositionType() + ", tradeType=" + getTradeType() + ", symbol=" + getSymbol() + ", linearSwapCurrencyInfo=" + getLinearSwapCurrencyInfo() + ", buyFirstPrice=" + getBuyFirstPrice() + ", sellFirstPrice=" + getSellFirstPrice() + ", lastPriceNew=" + getLastPriceNew() + ", isBuy=" + isBuy() + ", marginMode=" + getMarginMode() + ", levelRate=" + getLevelRate() + ", linearSwapAccountInfo=" + getLinearSwapAccountInfo() + ")";
    }
}
