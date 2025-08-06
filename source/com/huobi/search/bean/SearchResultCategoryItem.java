package com.huobi.search.bean;

import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.data.symbol.TradeType;
import com.huobi.search.viewhandler.SearchResultItemHandler;
import d7.a1;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public class SearchResultCategoryItem extends NewSearchItem {
    private String mResultType;

    public SearchResultCategoryItem(TradeType tradeType, String str, String str2, String str3, String str4, Double d11, Double d12, String str5, boolean z11) {
        super(tradeType, str, str2, str3, str4, d11, d12, str5, z11);
    }

    public static SearchResultCategoryItem clone(NewSearchItem newSearchItem) {
        SearchResultCategoryItem searchResultCategoryItem = new SearchResultCategoryItem(newSearchItem.getTradeType(), newSearchItem.getSymbol(), newSearchItem.getContractCode(), newSearchItem.getBaseCoin(), newSearchItem.getQuoteCoin(), newSearchItem.getClose(), newSearchItem.getIncrease(), newSearchItem.getSymbolName(), newSearchItem.isCollection());
        if (!searchResultCategoryItem.getSymbol().isEmpty()) {
            searchResultCategoryItem.setSymbol(searchResultCategoryItem.getSymbol());
        }
        if (!searchResultCategoryItem.getSymbolName().isEmpty()) {
            searchResultCategoryItem.setSymbolName(searchResultCategoryItem.getSymbolName().toUpperCase(Locale.ROOT));
        }
        if (!searchResultCategoryItem.getBaseCoin().isEmpty()) {
            searchResultCategoryItem.setBaseCoin(searchResultCategoryItem.getBaseCoin().toUpperCase(Locale.ROOT));
        }
        if (!searchResultCategoryItem.getQuoteCoin().isEmpty()) {
            searchResultCategoryItem.setQuoteCoin(searchResultCategoryItem.getQuoteCoin().toUpperCase(Locale.ROOT));
        }
        searchResultCategoryItem.setCollection(newSearchItem.isCollection());
        searchResultCategoryItem.setWeight(newSearchItem.getWeight());
        searchResultCategoryItem.setContractShortType(newSearchItem.getContractShortType());
        searchResultCategoryItem.setLeverageRatio(newSearchItem.getLeverageRatio());
        searchResultCategoryItem.setState(newSearchItem.getState());
        searchResultCategoryItem.setTradeOpenAt(newSearchItem.getTradeOpenAt());
        searchResultCategoryItem.setContractType(newSearchItem.getContractType());
        return searchResultCategoryItem;
    }

    public static List<SearchResultCategoryItem> cloneAll(List<? extends NewSearchItem> list) {
        boolean isTurkeyLanguage = AppLanguageHelper.getInstance().isTurkeyLanguage();
        LinkedList linkedList = new LinkedList();
        for (int i11 = 0; i11 < list.size(); i11++) {
            String symbol = ((NewSearchItem) list.get(i11)).getSymbol().isEmpty() ? "" : ((NewSearchItem) list.get(i11)).getSymbol();
            if (!isTurkeyLanguage || ((NewSearchItem) list.get(i11)).getTradeType() != TradeType.PRO || symbol.isEmpty() || !a1.v().p0(symbol)) {
                linkedList.add(clone((NewSearchItem) list.get(i11)));
            }
        }
        return linkedList;
    }

    public String getResultType() {
        return this.mResultType;
    }

    public String getViewHandlerName() {
        return SearchResultItemHandler.class.getName();
    }

    public void setResultType(String str) {
        this.mResultType = str;
    }
}
