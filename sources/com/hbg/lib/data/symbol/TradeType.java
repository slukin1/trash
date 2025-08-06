package com.hbg.lib.data.symbol;

import android.text.TextUtils;
import com.hbg.lib.common.utils.StringUtils;
import com.xiaomi.mipush.sdk.Constants;

public enum TradeType {
    OTC_OPTIONS,
    SAVINGS,
    MINE,
    MARGIN,
    SUPERMARGIN,
    HADAX,
    PRO,
    GRID,
    POINT,
    INDEX,
    CONTRACT,
    SWAP,
    OPTION,
    LINEAR_SWAP,
    LINEAR_SWAP_V5,
    OTC,
    C2C,
    C2C_LEND,
    CONTRACT_INDEX,
    LINEAR_SWAP_INDEX,
    COPY_TRADING;

    public static TradeType getTradeTypeBySymbol(String str) {
        int i11;
        TradeType tradeType = PRO;
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            if (split == null) {
                i11 = 0;
            } else {
                i11 = split.length;
            }
            if (str.contains("-Index")) {
                for (int i12 = 0; i12 < i11; i12++) {
                    if ("USD".equals(split[i12])) {
                        return CONTRACT_INDEX;
                    }
                }
                return LINEAR_SWAP_INDEX;
            } else if (str.contains("_")) {
                return CONTRACT;
            } else {
                if (str.contains(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
                    if (i11 == 2 && "USD".equals(split[1])) {
                        return SWAP;
                    }
                    if (i11 == 2 || i11 == 3) {
                        return LINEAR_SWAP;
                    }
                    if (i11 > 3) {
                        return OPTION;
                    }
                }
            }
        }
        return tradeType;
    }

    public static boolean isC2C(TradeType tradeType) {
        return C2C == tradeType;
    }

    public static boolean isContract(TradeType tradeType) {
        return CONTRACT == tradeType;
    }

    public static boolean isContractIndex(TradeType tradeType) {
        return CONTRACT_INDEX == tradeType;
    }

    public static boolean isIndex(TradeType tradeType) {
        return INDEX == tradeType;
    }

    public static boolean isLinearSwap(TradeType tradeType) {
        return LINEAR_SWAP == tradeType;
    }

    public static boolean isLinearSwapIndex(TradeType tradeType) {
        return LINEAR_SWAP_INDEX == tradeType;
    }

    public static boolean isMargin(String str) {
        return isMargin(valueOf(str));
    }

    public static boolean isOption(TradeType tradeType) {
        return OPTION == tradeType;
    }

    public static boolean isPro(TradeType tradeType) {
        return PRO == tradeType;
    }

    public static boolean isSwap(TradeType tradeType) {
        return SWAP == tradeType;
    }

    public static TradeType parse(String str) {
        TradeType tradeType = MARGIN;
        if (tradeType.toString().equalsIgnoreCase(str)) {
            return tradeType;
        }
        TradeType tradeType2 = SUPERMARGIN;
        if (tradeType2.toString().equalsIgnoreCase(str)) {
            return tradeType2;
        }
        TradeType tradeType3 = PRO;
        if (tradeType3.toString().equalsIgnoreCase(str)) {
            return tradeType3;
        }
        TradeType tradeType4 = GRID;
        if (tradeType4.toString().equalsIgnoreCase(str)) {
            return tradeType4;
        }
        TradeType tradeType5 = POINT;
        if (tradeType5.toString().equalsIgnoreCase(str)) {
            return tradeType5;
        }
        TradeType tradeType6 = INDEX;
        if (tradeType6.toString().equalsIgnoreCase(str)) {
            return tradeType6;
        }
        TradeType tradeType7 = CONTRACT;
        if (tradeType7.toString().equalsIgnoreCase(str)) {
            return tradeType7;
        }
        TradeType tradeType8 = OTC;
        if (tradeType8.toString().equalsIgnoreCase(str)) {
            return tradeType8;
        }
        TradeType tradeType9 = C2C;
        if (tradeType9.toString().equalsIgnoreCase(str)) {
            return tradeType9;
        }
        TradeType tradeType10 = C2C_LEND;
        if (tradeType10.toString().equalsIgnoreCase(str)) {
            return tradeType10;
        }
        TradeType tradeType11 = SWAP;
        if (tradeType11.toString().equalsIgnoreCase(str)) {
            return tradeType11;
        }
        TradeType tradeType12 = OPTION;
        if (tradeType12.toString().equalsIgnoreCase(str)) {
            return tradeType12;
        }
        TradeType tradeType13 = LINEAR_SWAP;
        if (tradeType13.toString().equalsIgnoreCase(str)) {
            return tradeType13;
        }
        TradeType tradeType14 = CONTRACT_INDEX;
        if (tradeType14.toString().equalsIgnoreCase(str)) {
            return tradeType14;
        }
        TradeType tradeType15 = LINEAR_SWAP_INDEX;
        return tradeType15.toString().equalsIgnoreCase(str) ? tradeType15 : tradeType3;
    }

    public String toString() {
        return super.toString();
    }

    public static boolean isC2C(String str) {
        return isC2C(valueOf(str));
    }

    public static boolean isContract(String str) {
        if (!StringUtils.p(str)) {
            return isContract(valueOf(str));
        }
        return false;
    }

    public static boolean isContractIndex(String str) {
        return isContractIndex(valueOf(str));
    }

    public static boolean isIndex(String str) {
        return isIndex(valueOf(str));
    }

    public static boolean isLinearSwap(String str) {
        return isLinearSwap(valueOf(str));
    }

    public static boolean isLinearSwapIndex(String str) {
        return isLinearSwapIndex(valueOf(str));
    }

    public static boolean isMargin(TradeType tradeType) {
        return MARGIN == tradeType;
    }

    public static boolean isOption(String str) {
        if (!StringUtils.p(str)) {
            return isOption(valueOf(str));
        }
        return false;
    }

    public static boolean isPro(String str) {
        return isPro(valueOf(str));
    }

    public static boolean isSwap(String str) {
        return isSwap(valueOf(str));
    }
}
