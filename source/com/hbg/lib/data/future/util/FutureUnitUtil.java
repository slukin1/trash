package com.hbg.lib.data.future.util;

import a7.e;
import com.hbg.lib.data.symbol.TradeType;
import i6.m;
import java.math.BigDecimal;

public class FutureUnitUtil {
    public static String a(String str, String str2, String str3, TradeType tradeType) {
        BigDecimal bigDecimal;
        boolean E = e.E(tradeType);
        if (tradeType == TradeType.CONTRACT || tradeType == TradeType.SWAP) {
            if (!E) {
                return str;
            }
            BigDecimal multiply = m.a(str).multiply(m.a(str3));
            BigDecimal a11 = m.a(str2);
            if (a11.compareTo(BigDecimal.ZERO) == 0) {
                bigDecimal = BigDecimal.ZERO;
            } else {
                bigDecimal = multiply.divide(a11, 32, 1);
            }
            return bigDecimal.toPlainString();
        } else if (tradeType == TradeType.OPTION) {
            if (E) {
                return m.a(str).multiply(m.a(str3)).setScale(32, 1).toPlainString();
            }
            return str;
        } else if (tradeType != TradeType.LINEAR_SWAP) {
            return "";
        } else {
            if (E) {
                return m.a(str).multiply(m.a(str3)).setScale(32, 1).toPlainString();
            }
            if (e.G(tradeType)) {
                return m.a(str).multiply(m.a(str2)).setScale(32, 1).toPlainString();
            }
            return str;
        }
    }

    public static String b(String str, String str2, String str3, TradeType tradeType, int i11) {
        BigDecimal bigDecimal;
        boolean E = e.E(tradeType);
        if (tradeType == TradeType.CONTRACT || tradeType == TradeType.SWAP) {
            if (!E) {
                return str;
            }
            BigDecimal multiply = m.a(str).multiply(m.a(str3));
            BigDecimal a11 = m.a(str2);
            if (a11.compareTo(BigDecimal.ZERO) == 0) {
                bigDecimal = BigDecimal.ZERO;
            } else {
                bigDecimal = multiply.divide(a11, 32, 1);
            }
            return bigDecimal.toPlainString();
        } else if (tradeType == TradeType.OPTION) {
            if (E) {
                return m.a(str).multiply(m.a(str3)).setScale(32, 1).toPlainString();
            }
            return str;
        } else if (tradeType != TradeType.LINEAR_SWAP) {
            return "";
        } else {
            if (E) {
                return m.a(str).multiply(m.a(str3)).setScale(i11, 1).toPlainString();
            }
            if (e.G(tradeType)) {
                return m.a(str).multiply(m.a(str2).multiply(m.a(str3))).setScale(i11, 1).toPlainString();
            }
            return m.a(str).setScale(i11, 1).toPlainString();
        }
    }

    public static String c(String str, String str2, String str3, TradeType tradeType, boolean z11) {
        BigDecimal bigDecimal;
        if (tradeType == TradeType.CONTRACT || tradeType == TradeType.SWAP) {
            if (!z11) {
                return str;
            }
            BigDecimal multiply = m.a(str).multiply(m.a(str3));
            BigDecimal a11 = m.a(str2);
            if (a11.compareTo(BigDecimal.ZERO) == 0) {
                bigDecimal = BigDecimal.ZERO;
            } else {
                bigDecimal = multiply.divide(a11, 32, 1);
            }
            return bigDecimal.toPlainString();
        } else if (tradeType != TradeType.LINEAR_SWAP) {
            return "";
        } else {
            if (z11) {
                return m.a(str).multiply(m.a(str3)).setScale(32, 1).toPlainString();
            }
            if (e.G(tradeType)) {
                return m.a(str).multiply(m.a(str2)).setScale(32, 1).toPlainString();
            }
            return str;
        }
    }

    public static String d(String str, String str2, String str3, TradeType tradeType) {
        BigDecimal bigDecimal;
        if (tradeType == TradeType.CONTRACT || tradeType == TradeType.SWAP) {
            BigDecimal multiply = m.a(str).multiply(m.a(str3));
            BigDecimal a11 = m.a(str2);
            if (a11.compareTo(BigDecimal.ZERO) == 0) {
                bigDecimal = BigDecimal.ZERO;
            } else {
                bigDecimal = multiply.divide(a11, 32, 1);
            }
            return bigDecimal.toPlainString();
        } else if (tradeType != TradeType.LINEAR_SWAP) {
            return m.a(str).multiply(m.a(str3)).setScale(32, 1).toPlainString();
        } else {
            if (e.G(tradeType)) {
                return m.a(str).multiply(m.a(str2).multiply(m.a(str3))).setScale(32, 1).toPlainString();
            }
            return m.a(str).multiply(m.a(str3)).setScale(32, 1).toPlainString();
        }
    }

    public static String e(String str, String str2, String str3, TradeType tradeType, int i11) {
        if (tradeType == TradeType.OPTION) {
            return m.a(str).divide(m.a(str3), 32, 1).toPlainString();
        }
        if (tradeType != TradeType.LINEAR_SWAP) {
            return m.a(str).multiply(m.a(str2)).divide(m.a(str3), 32, 1).toPlainString();
        }
        if (e.G(tradeType)) {
            return m.a(str2).compareTo(BigDecimal.ZERO) != 0 ? m.a(str).divide(m.a(str3).multiply(m.a(str2)), i11, 1).toPlainString() : "";
        }
        return m.a(str).divide(m.a(str3), 32, 1).toPlainString();
    }

    public static String f(boolean z11, boolean z12, String str, String str2, String str3, int i11) {
        if (z11) {
            return m.a(str).multiply(m.a(str2)).setScale(i11, 1).toPlainString();
        }
        if (z12) {
            return m.a(str).multiply(m.a(str2).multiply(m.a(str3))).setScale(i11, 1).toPlainString();
        }
        return m.a(str).setScale(i11, 1).toPlainString();
    }
}
