package com.hbg.lib.network.hbg.core.util;

import java.util.ArrayList;
import java.util.List;

public enum MgtConfigNumber {
    KLINE_REQ(1),
    INCREASE_BLACK_LIST(3),
    DEPOSIT_WITHDRAW(4),
    NEW_MERCHANT_PROFILE(11),
    OTC_QUICK_HOME(12),
    OTC_MY_ADVERTS(14),
    DYNAMIC_LANGS(41),
    LOGIN_KEEP_TIME(44),
    MARGIN_TOGETHER(45),
    SHAR_MGT_CONFIG(46),
    QUICK_TRADE(47),
    KLINE_QUICK_TRADE(49),
    LIVE_ANCHOR_CENTER(51),
    JA_KO(52),
    MARKET_ITEM_EXPAND_KLINE(54),
    NEW_BANNER_PERCENTAGE(56),
    MARKET_SQUARE_PERCENT(57),
    MARKET_ITEM_EXPAND_KLINE_NEW(58),
    ACCOUNT_RED_DOT(59),
    DYNAMIC_POST(60),
    ASSET_NEW_VERSION_OPEN(61),
    ASSET_CACHE_OPEN(62),
    NEW_USER_GIFT_BAG(63),
    SPLASH_AD_CONFIG(65),
    MARGIN_COUPON(66),
    CHRISTMAS_OPEN(67),
    MARKET_PUSH_STATUS(68),
    MARGIN_POP_STATUS(69),
    RISK_STATUS(70),
    MARGIN_COURSE_STATUS(71),
    GA_DOWNLOAD_LINK_URL(72),
    CONTRACT_ZERO_SUBSCRIPT_SWITCH(73),
    ALL_SWITCH(100),
    H5_CACHE_CONFIG(102),
    EARN_H5_CONFIG(105),
    NETWORK_CONFIG(111),
    CONTRACT_SHARE(999),
    ZERO_SWAP(997),
    REVIEW_SWAP(76);
    
    public int number;

    private MgtConfigNumber(int i11) {
        this.number = i11;
    }

    public static List<MgtConfigNumber> getList() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(KLINE_REQ);
        arrayList.add(INCREASE_BLACK_LIST);
        arrayList.add(DEPOSIT_WITHDRAW);
        arrayList.add(NEW_MERCHANT_PROFILE);
        arrayList.add(OTC_QUICK_HOME);
        arrayList.add(OTC_MY_ADVERTS);
        arrayList.add(MARGIN_TOGETHER);
        arrayList.add(SHAR_MGT_CONFIG);
        arrayList.add(H5_CACHE_CONFIG);
        arrayList.add(EARN_H5_CONFIG);
        arrayList.add(QUICK_TRADE);
        arrayList.add(KLINE_QUICK_TRADE);
        arrayList.add(MARKET_SQUARE_PERCENT);
        arrayList.add(MARKET_ITEM_EXPAND_KLINE_NEW);
        arrayList.add(ALL_SWITCH);
        arrayList.add(MARGIN_POP_STATUS);
        arrayList.add(MARGIN_COURSE_STATUS);
        arrayList.add(ZERO_SWAP);
        arrayList.add(REVIEW_SWAP);
        return arrayList;
    }
}
