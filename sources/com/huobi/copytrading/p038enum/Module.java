package com.huobi.copytrading.p038enum;

import com.tencent.qcloud.tuikit.tuichat.TUIChatConstants;

/* renamed from: com.huobi.copytrading.enum.Module  reason: invalid package */
public enum Module {
    ORDER(TUIChatConstants.BUSINESS_ID_CUSTOM_ORDER, "order_list.xml"),
    HISTORY_ORDER("historyOrder", "history_order_list.xml"),
    TRADE_PANEL("tradePanel", "copytrading_handicap.xml"),
    TRADE_TITLE("tradeTitle", "trade_title.xml"),
    TRADE_LEVER_POP("", "trad_adjust_lev.xml"),
    TRADE_ORDER_CONFIRM_POP("", "trade_order_confirm.xml"),
    TRADE_LIST("traderListData", "trader_list.xml"),
    COPY_SETTING("copySetting", "copySetting.xml"),
    ME_TOP("meTopPage", "meTopPage.xml"),
    HOME_PAGE("homePage", "homePage.xml"),
    HOME_SORT_POP("sortPop", "trader_list_sort_header.xml"),
    TRADER_INFO("traderInfo", "traderInfo.xml"),
    TRADING_BOT_TRADE_TOP_ASSET("tradeTopAsset", "trade_top_asset.xml"),
    TRADING_BOT_TRADE_CREATE_BOT("tradeCreateBot", "trade_create_bot.xml"),
    TRADING_BOT_TRADE_FILTER("tradeFilter", "trade_filter.xml"),
    TRADING_BOT_TRADE_LIST("tradeList", "trade_list.xml"),
    TRADING_BOT_CONTRACT_TAB("", "contract_grid_tab.xml"),
    TRADING_BOT_CONTRACT_LIST("contractRecommendList", "contract_recommend_list.xml"),
    TRADING_BOT_CONTRACT_TOP_SYMBOL("contractTopSymbol", "contract_top_symbol.xml"),
    TRADING_BOT_CONTRACT_TOP_AD_BANNER("contractAdBanner", "contractAdBanner.xml"),
    TRADING_BOT_CONTRACT_EDIT_PAGE("contractEditPage", "contract_edit_page.xml"),
    TRADING_BOT_CONTRACT_BOTTOM_VIEW("contractEditPage", "contract_edit_bottom_view.xml"),
    TRADING_BOT_DETAIL_HEADER("botDetailHeader", "bot_detail_header.xml"),
    TRADING_BOT_DETAIL_TAB("", "bot_detail_tab.xml"),
    TRADING_BOT_DETAIL_BOTTOM_VIEW("", "bot_detail_bottom_view.xml"),
    TRADING_BOT_HANDLE_COMPLETION("botHandleCompletionPage", "bot_handle_completion_page.xml");
    
    private final String moduleName;
    private final String xml;

    private Module(String str, String str2) {
        this.moduleName = str;
        this.xml = str2;
    }

    public final String getModuleName() {
        return this.moduleName;
    }

    public final String getXml() {
        return this.xml;
    }
}
