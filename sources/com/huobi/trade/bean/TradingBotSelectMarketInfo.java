package com.huobi.trade.bean;

import com.huobi.trade.handler.TradingBotSelectMarketItemHandler;
import java.io.Serializable;

public class TradingBotSelectMarketInfo implements Serializable, s9.a {
    public String callBackStr;
    private String currency;
    private boolean currentSelected;
    public String displayName;
    private boolean isAllMarket;
    private boolean isContract;
    private String letter;
    private a selectSymbolCallback;
    public String symbol;
    private int weight;

    public interface a {
        void Zf(TradingBotSelectMarketInfo tradingBotSelectMarketInfo);
    }

    public boolean canEqual(Object obj) {
        return obj instanceof TradingBotSelectMarketInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TradingBotSelectMarketInfo)) {
            return false;
        }
        TradingBotSelectMarketInfo tradingBotSelectMarketInfo = (TradingBotSelectMarketInfo) obj;
        if (!tradingBotSelectMarketInfo.canEqual(this) || isAllMarket() != tradingBotSelectMarketInfo.isAllMarket()) {
            return false;
        }
        String currency2 = getCurrency();
        String currency3 = tradingBotSelectMarketInfo.getCurrency();
        if (currency2 != null ? !currency2.equals(currency3) : currency3 != null) {
            return false;
        }
        String symbol2 = getSymbol();
        String symbol3 = tradingBotSelectMarketInfo.getSymbol();
        if (symbol2 != null ? !symbol2.equals(symbol3) : symbol3 != null) {
            return false;
        }
        String displayName2 = getDisplayName();
        String displayName3 = tradingBotSelectMarketInfo.getDisplayName();
        if (displayName2 != null ? !displayName2.equals(displayName3) : displayName3 != null) {
            return false;
        }
        String callBackStr2 = getCallBackStr();
        String callBackStr3 = tradingBotSelectMarketInfo.getCallBackStr();
        if (callBackStr2 != null ? !callBackStr2.equals(callBackStr3) : callBackStr3 != null) {
            return false;
        }
        String letter2 = getLetter();
        String letter3 = tradingBotSelectMarketInfo.getLetter();
        if (letter2 != null ? !letter2.equals(letter3) : letter3 != null) {
            return false;
        }
        if (getWeight() != tradingBotSelectMarketInfo.getWeight() || isCurrentSelected() != tradingBotSelectMarketInfo.isCurrentSelected() || isContract() != tradingBotSelectMarketInfo.isContract()) {
            return false;
        }
        a selectSymbolCallback2 = getSelectSymbolCallback();
        a selectSymbolCallback3 = tradingBotSelectMarketInfo.getSelectSymbolCallback();
        return selectSymbolCallback2 != null ? selectSymbolCallback2.equals(selectSymbolCallback3) : selectSymbolCallback3 == null;
    }

    public String getCallBackStr() {
        return this.callBackStr;
    }

    public String getCurrency() {
        return this.currency;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public String getLetter() {
        return this.letter;
    }

    public a getSelectSymbolCallback() {
        return this.selectSymbolCallback;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public String getViewHandlerName() {
        return TradingBotSelectMarketItemHandler.class.getName();
    }

    public int getWeight() {
        return this.weight;
    }

    public int hashCode() {
        int i11 = 79;
        int i12 = isAllMarket() ? 79 : 97;
        String currency2 = getCurrency();
        int i13 = 43;
        int hashCode = ((i12 + 59) * 59) + (currency2 == null ? 43 : currency2.hashCode());
        String symbol2 = getSymbol();
        int hashCode2 = (hashCode * 59) + (symbol2 == null ? 43 : symbol2.hashCode());
        String displayName2 = getDisplayName();
        int hashCode3 = (hashCode2 * 59) + (displayName2 == null ? 43 : displayName2.hashCode());
        String callBackStr2 = getCallBackStr();
        int hashCode4 = (hashCode3 * 59) + (callBackStr2 == null ? 43 : callBackStr2.hashCode());
        String letter2 = getLetter();
        int hashCode5 = ((((((hashCode4 * 59) + (letter2 == null ? 43 : letter2.hashCode())) * 59) + getWeight()) * 59) + (isCurrentSelected() ? 79 : 97)) * 59;
        if (!isContract()) {
            i11 = 97;
        }
        int i14 = hashCode5 + i11;
        a selectSymbolCallback2 = getSelectSymbolCallback();
        int i15 = i14 * 59;
        if (selectSymbolCallback2 != null) {
            i13 = selectSymbolCallback2.hashCode();
        }
        return i15 + i13;
    }

    public boolean isAllMarket() {
        return this.isAllMarket;
    }

    public boolean isContract() {
        return this.isContract;
    }

    public boolean isCurrentSelected() {
        return this.currentSelected;
    }

    public void setAllMarket(boolean z11) {
        this.isAllMarket = z11;
    }

    public TradingBotSelectMarketInfo setCallBackStr(String str) {
        this.callBackStr = str;
        return this;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public void setCurrentSelected(boolean z11) {
        this.currentSelected = z11;
    }

    public void setDisplayName(String str) {
        this.displayName = str;
    }

    public TradingBotSelectMarketInfo setIsContract(boolean z11) {
        this.isContract = z11;
        return this;
    }

    public void setLetter(String str) {
        this.letter = str;
    }

    public void setSelectSymbolCallback(a aVar) {
        this.selectSymbolCallback = aVar;
    }

    public TradingBotSelectMarketInfo setSymbol(String str) {
        this.symbol = str;
        return this;
    }

    public TradingBotSelectMarketInfo setTradingBotSelectMarketInfo(boolean z11, String str, String str2, String str3, boolean z12, a aVar) {
        this.isAllMarket = z11;
        this.currency = str;
        this.displayName = str2;
        this.letter = str3;
        this.currentSelected = z12;
        this.selectSymbolCallback = aVar;
        return this;
    }

    public void setWeight(int i11) {
        this.weight = i11;
    }

    public String toString() {
        return "TradingBotSelectMarketInfo(isAllMarket=" + isAllMarket() + ", currency=" + getCurrency() + ", symbol=" + getSymbol() + ", displayName=" + getDisplayName() + ", callBackStr=" + getCallBackStr() + ", letter=" + getLetter() + ", weight=" + getWeight() + ", currentSelected=" + isCurrentSelected() + ", isContract=" + isContract() + ", selectSymbolCallback=" + getSelectSymbolCallback() + ")";
    }
}
