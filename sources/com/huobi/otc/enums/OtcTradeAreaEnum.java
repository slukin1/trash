package com.huobi.otc.enums;

import com.tencent.qcloud.tuikit.tuichat.TUIChatConstants;

public enum OtcTradeAreaEnum {
    FAST_AREA("express", 1),
    FREE_AREA("p2p", 2),
    DEPOSIT_AREA("deposit", 3),
    P2P_TRAD_AREA("makerAd", 0),
    ORDER_AREA(TUIChatConstants.BUSINESS_ID_CUSTOM_ORDER, 1),
    AD_AREA("makerAd", 2),
    MINE("mine", 3);
    
    public int code;
    public String name;

    private OtcTradeAreaEnum(String str, int i11) {
        this.name = str;
        this.code = i11;
    }

    public static boolean checkIsLegal(OtcTradeAreaEnum otcTradeAreaEnum) {
        return (otcTradeAreaEnum == null || matchTradeArea(otcTradeAreaEnum.code) == null) ? false : true;
    }

    public static OtcTradeAreaEnum matchTradeArea(int i11) {
        OtcTradeAreaEnum otcTradeAreaEnum = FAST_AREA;
        if (i11 == otcTradeAreaEnum.code) {
            return otcTradeAreaEnum;
        }
        OtcTradeAreaEnum otcTradeAreaEnum2 = FREE_AREA;
        if (i11 == otcTradeAreaEnum2.code) {
            return otcTradeAreaEnum2;
        }
        OtcTradeAreaEnum otcTradeAreaEnum3 = DEPOSIT_AREA;
        if (i11 == otcTradeAreaEnum3.code) {
            return otcTradeAreaEnum3;
        }
        OtcTradeAreaEnum otcTradeAreaEnum4 = ORDER_AREA;
        if (i11 == otcTradeAreaEnum4.code) {
            return otcTradeAreaEnum4;
        }
        OtcTradeAreaEnum otcTradeAreaEnum5 = AD_AREA;
        if (i11 == otcTradeAreaEnum5.code) {
            return otcTradeAreaEnum5;
        }
        return null;
    }

    public int getCode() {
        return this.code;
    }

    public String getName() {
        return this.name;
    }

    public static boolean checkIsLegal(int i11) {
        return matchTradeArea(i11) != null;
    }

    public static boolean checkIsLegal(String str) {
        return matchTradeArea(str) != null;
    }

    public static OtcTradeAreaEnum matchTradeArea(String str) {
        OtcTradeAreaEnum otcTradeAreaEnum = FAST_AREA;
        if (otcTradeAreaEnum.name.equalsIgnoreCase(str)) {
            return otcTradeAreaEnum;
        }
        OtcTradeAreaEnum otcTradeAreaEnum2 = FREE_AREA;
        if (otcTradeAreaEnum2.name.equalsIgnoreCase(str)) {
            return otcTradeAreaEnum2;
        }
        OtcTradeAreaEnum otcTradeAreaEnum3 = DEPOSIT_AREA;
        if (otcTradeAreaEnum3.name.equalsIgnoreCase(str)) {
            return otcTradeAreaEnum3;
        }
        OtcTradeAreaEnum otcTradeAreaEnum4 = ORDER_AREA;
        if (otcTradeAreaEnum4.name.equalsIgnoreCase(str)) {
            return otcTradeAreaEnum4;
        }
        OtcTradeAreaEnum otcTradeAreaEnum5 = AD_AREA;
        if (otcTradeAreaEnum5.name.equalsIgnoreCase(str)) {
            return otcTradeAreaEnum5;
        }
        return null;
    }
}
