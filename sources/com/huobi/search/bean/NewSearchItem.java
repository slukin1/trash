package com.huobi.search.bean;

import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.data.symbol.TradeType;
import com.huobi.search.viewhandler.SearchRecommendItemHandler;
import d7.a1;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import s9.a;

public class NewSearchItem implements Serializable, a {
    public static final String RECOMMEND_BUY = "hotbuy";
    public static final String RECOMMEND_CURRENCY = "hotcurrency";
    public static final String RECOMMEND_SEARCH = "hotsearch";
    private String baseCoin;
    private Double close;
    private String contractCode;
    private String contractShortType;
    private String contractType;
    private Double increase;
    private boolean isCollection;
    private String leverageRatio;
    private String quoteCoin;
    private String recommendType;
    private String state;
    private String symbol;
    private String symbolName;
    private long tradeOpenAt;
    private TradeType tradeType;
    private int weight;

    public NewSearchItem(TradeType tradeType2, String str, String str2, String str3, String str4, Double d11, Double d12, String str5, boolean z11) {
        this.tradeType = tradeType2;
        this.symbol = str;
        this.contractCode = str2;
        this.baseCoin = str3;
        this.quoteCoin = str4;
        this.close = d11;
        this.increase = d12;
        this.symbolName = str5;
        this.isCollection = z11;
    }

    public static NewSearchItem clone(NewSearchItem newSearchItem) {
        NewSearchItem newSearchItem2 = new NewSearchItem(newSearchItem.getTradeType(), newSearchItem.getSymbol(), newSearchItem.getContractCode(), newSearchItem.getBaseCoin(), newSearchItem.getQuoteCoin(), newSearchItem.getClose(), newSearchItem.getIncrease(), newSearchItem.getSymbolName(), newSearchItem.isCollection());
        if (!newSearchItem2.getSymbol().isEmpty()) {
            newSearchItem2.setSymbol(newSearchItem2.getSymbol());
        }
        if (!newSearchItem2.getSymbolName().isEmpty()) {
            newSearchItem2.setSymbolName(newSearchItem2.getSymbolName().toUpperCase(Locale.ROOT));
        }
        if (!newSearchItem2.getBaseCoin().isEmpty()) {
            newSearchItem2.setBaseCoin(newSearchItem2.getBaseCoin().toUpperCase(Locale.ROOT));
        }
        if (!newSearchItem2.getQuoteCoin().isEmpty()) {
            newSearchItem2.setQuoteCoin(newSearchItem2.getQuoteCoin().toUpperCase(Locale.ROOT));
        }
        newSearchItem2.setCollection(newSearchItem.isCollection());
        newSearchItem2.setWeight(newSearchItem.getWeight());
        newSearchItem2.setContractShortType(newSearchItem.getContractShortType());
        newSearchItem2.setLeverageRatio(newSearchItem.getLeverageRatio());
        newSearchItem2.setState(newSearchItem.state);
        newSearchItem2.setTradeOpenAt(newSearchItem.getTradeOpenAt());
        newSearchItem2.setContractType(newSearchItem.getContractType());
        return newSearchItem2;
    }

    public static List<NewSearchItem> cloneAll(List<NewSearchItem> list, List<NewSearchItem> list2) {
        if (list2 == null) {
            list2 = new LinkedList<>();
        }
        for (int i11 = 0; i11 < list.size(); i11++) {
            list2.add(clone(list.get(i11)));
        }
        return list2;
    }

    public NewSearchItem createNewWithWeight(int i11) {
        NewSearchItem newSearchItem = new NewSearchItem(this.tradeType, this.symbol, this.contractCode, this.baseCoin, this.quoteCoin, this.close, this.increase, this.symbolName, this.isCollection);
        newSearchItem.setWeight(i11);
        return newSearchItem;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof NewSearchItem)) {
            return false;
        }
        NewSearchItem newSearchItem = (NewSearchItem) obj;
        TradeType tradeType2 = TradeType.PRO;
        String str = "";
        if (tradeType2 == getTradeType() && tradeType2 == newSearchItem.getTradeType()) {
            String symbol2 = getSymbol();
            if (!newSearchItem.getSymbol().isEmpty()) {
                str = newSearchItem.getSymbol();
            }
            return symbol2.equalsIgnoreCase(str);
        } else if (tradeType2 != getTradeType()) {
            String contractCode2 = getContractCode();
            if (!newSearchItem.getContractCode().isEmpty()) {
                str = newSearchItem.getContractCode();
            }
            return contractCode2.equalsIgnoreCase(str);
        } else if (hashCode() == newSearchItem.hashCode()) {
            return true;
        } else {
            return false;
        }
    }

    public String getBaseCoin() {
        return this.baseCoin;
    }

    public Double getClose() {
        return this.close;
    }

    public String getContractCode() {
        return this.contractCode;
    }

    public String getContractShortType() {
        return this.contractShortType;
    }

    public String getContractType() {
        return this.contractType;
    }

    public Double getIncrease() {
        return this.increase;
    }

    public String getLeverageRatio() {
        return this.leverageRatio;
    }

    public String getQuoteCoin() {
        return this.quoteCoin;
    }

    public String getRecommendType() {
        return this.recommendType;
    }

    public String getState() {
        return this.state;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public String getSymbolName() {
        return this.symbolName;
    }

    public long getTradeOpenAt() {
        return this.tradeOpenAt;
    }

    public TradeType getTradeType() {
        return this.tradeType;
    }

    public String getViewHandlerName() {
        return SearchRecommendItemHandler.class.getName();
    }

    public int getWeight() {
        return this.weight;
    }

    public int hashCode() {
        TradeType tradeType2 = TradeType.PRO;
        if (tradeType2 == getTradeType()) {
            if (!getSymbol().isEmpty()) {
                return getSymbol().hashCode();
            }
            return hashCode();
        } else if (tradeType2 == getTradeType()) {
            return hashCode();
        } else {
            if (!getContractCode().isEmpty()) {
                return getContractCode().hashCode();
            }
            return hashCode();
        }
    }

    public boolean isCollection() {
        return this.isCollection;
    }

    public void setBaseCoin(String str) {
        this.baseCoin = str;
    }

    public void setClose(Double d11) {
        this.close = d11;
    }

    public void setCollection(boolean z11) {
        this.isCollection = z11;
    }

    public void setContractCode(String str) {
        this.contractCode = str;
    }

    public void setContractShortType(String str) {
        this.contractShortType = str;
    }

    public void setContractType(String str) {
        this.contractType = str;
    }

    public void setIncrease(Double d11) {
        this.increase = d11;
    }

    public void setLeverageRatio(String str) {
        this.leverageRatio = str;
    }

    public void setQuoteCoin(String str) {
        this.quoteCoin = str;
    }

    public void setRecommendType(String str) {
        this.recommendType = str;
    }

    public void setState(String str) {
        this.state = str;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public void setSymbolName(String str) {
        this.symbolName = str;
    }

    public void setTradeOpenAt(long j11) {
        this.tradeOpenAt = j11;
    }

    public void setTradeType(TradeType tradeType2) {
        this.tradeType = tradeType2;
    }

    public void setWeight(int i11) {
        this.weight = i11;
    }

    public String toString() {
        return "NewSearchItem(weight=" + getWeight() + ", tradeType=" + getTradeType() + ", symbol=" + getSymbol() + ", contractCode=" + getContractCode() + ", baseCoin=" + getBaseCoin() + ", quoteCoin=" + getQuoteCoin() + ", close=" + getClose() + ", increase=" + getIncrease() + ", symbolName=" + getSymbolName() + ", isCollection=" + isCollection() + ", leverageRatio=" + getLeverageRatio() + ", contractShortType=" + getContractShortType() + ", recommendType=" + getRecommendType() + ", state=" + getState() + ", tradeOpenAt=" + getTradeOpenAt() + ", contractType=" + getContractType() + ")";
    }

    public static List<NewSearchItem> cloneAll(List<NewSearchItem> list, List<NewSearchItem> list2, String str) {
        if (list2 == null) {
            list2 = new LinkedList<>();
        }
        boolean isTurkeyLanguage = AppLanguageHelper.getInstance().isTurkeyLanguage();
        for (int i11 = 0; i11 < list.size(); i11++) {
            String symbol2 = list.get(i11).getSymbol().isEmpty() ? "" : list.get(i11).getSymbol();
            if (!isTurkeyLanguage || list.get(i11).getTradeType() != TradeType.PRO || symbol2.isEmpty() || !a1.v().p0(symbol2)) {
                if (str.isEmpty()) {
                    list2.add(clone(list.get(i11)));
                } else {
                    NewSearchItem clone = clone(list.get(i11));
                    clone.setRecommendType(str);
                    list2.add(clone);
                }
            }
        }
        return list2;
    }
}
