package com.hbg.module.market.widget.bean;

import android.view.View;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.module.market.widget.viewhandler.MarketWidgetSymbolItemHandler;
import java.io.Serializable;

public class MarketWidgetSymbolItem implements s9.a, Serializable {
    public static final int RESULT_TYPE_CONTRACT = 1;
    public static final int RESULT_TYPE_CONTRACT_INDEX = 5;
    public static final int RESULT_TYPE_LINEAR_SWAP = 4;
    public static final int RESULT_TYPE_LINEAR_SWAP_INDEX = 6;
    public static final int RESULT_TYPE_OPTION = 3;
    public static final int RESULT_TYPE_PRO = 0;
    public static final int RESULT_TYPE_SWAP = 2;
    public static final int STATUS_BACK = 1;
    public static final int STATUS_OUT = 0;
    public static final int STATUS_SLIDE_BACK = 2;
    public static final int STATUS_SLIDE_OUT = 3;
    private a callback;
    private int delBtnStatus;
    private ItemTouchHelper itemTouchHelp;
    private MarketWidgetInfo marketWidgetInfo;
    private String symbol;
    private TradeType tradeType;

    public interface a {
        void a(MarketWidgetSymbolItem marketWidgetSymbolItem);

        void b(boolean z11);

        void c();

        void d(View view, View view2, MarketWidgetSymbolItem marketWidgetSymbolItem);

        void e(MarketWidgetSymbolItem marketWidgetSymbolItem);

        boolean f();
    }

    public a getCallback() {
        return this.callback;
    }

    public int getDelBtnStatus() {
        return this.delBtnStatus;
    }

    public ItemTouchHelper getItemTouchHelp() {
        return this.itemTouchHelp;
    }

    public MarketWidgetInfo getMarketWidgetInfo() {
        return this.marketWidgetInfo;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public TradeType getTradeType() {
        return this.tradeType;
    }

    public String getViewHandlerName() {
        return MarketWidgetSymbolItemHandler.class.getName();
    }

    public void setCallback(a aVar) {
        this.callback = aVar;
    }

    public void setDelBtnStatus(int i11) {
        this.delBtnStatus = i11;
    }

    public void setItemTouchHelp(ItemTouchHelper itemTouchHelper) {
        this.itemTouchHelp = itemTouchHelper;
    }

    public void setMarketWidgetInfo(MarketWidgetInfo marketWidgetInfo2) {
        this.marketWidgetInfo = marketWidgetInfo2;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public void setTradeType(TradeType tradeType2) {
        this.tradeType = tradeType2;
    }
}
