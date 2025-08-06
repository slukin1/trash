package fr;

import com.hbg.lib.data.symbol.TradeType;
import com.huobi.search.bean.NewSearchItem;
import java.util.Locale;
import java.util.Map;

public final class d {
    public static int a(String str, String str2, String str3, String str4, String str5) {
        if (str3.equalsIgnoreCase("/")) {
            return str.compareTo(str2);
        }
        if (str4.equalsIgnoreCase(str3) && str5.equalsIgnoreCase(str3)) {
            return str.compareTo(str2);
        }
        if (str4.equalsIgnoreCase(str3) && !str5.equalsIgnoreCase(str3)) {
            return -1;
        }
        if (!str4.equalsIgnoreCase(str3) && str5.equalsIgnoreCase(str3)) {
            return 1;
        }
        if (str4.startsWith(str3) && str5.startsWith(str3)) {
            return 0;
        }
        if (str4.startsWith(str3) && !str5.startsWith(str3)) {
            return -1;
        }
        if (!str4.startsWith(str3) && str5.startsWith(str3)) {
            return 1;
        }
        int max = Math.max((str4.length() - str3.length()) + 1, 0);
        int max2 = Math.max((str5.length() - str3.length()) + 1, 0);
        if (max >= str4.length()) {
            max = 0;
        }
        String substring = str4.substring(0, max);
        if (max2 >= str5.length()) {
            max2 = 0;
        }
        String substring2 = str5.substring(0, max2);
        if (substring.contains(str3) && substring2.contains(str3)) {
            return 0;
        }
        if (substring.contains(str3) && !substring2.contains(str3)) {
            return -1;
        }
        if (!substring.contains(str3) && substring2.contains(str3)) {
            return 1;
        }
        if (str4.endsWith(str3) && str5.endsWith(str3)) {
            return 0;
        }
        if (str4.endsWith(str3) && !str5.endsWith(str3)) {
            return -1;
        }
        if (str4.endsWith(str3) || !str5.endsWith(str3)) {
            return -2;
        }
        return 1;
    }

    public static int b(String str, String str2, String str3, String str4, String str5, Map<String, Integer> map) {
        boolean z11 = map != null && !str4.isEmpty() && !str5.isEmpty();
        if (str.equalsIgnoreCase(str3) && str2.equalsIgnoreCase(str3)) {
            if (z11) {
                e(str4, str5, map);
            }
            return 0;
        } else if (str.equalsIgnoreCase(str3) && !str2.equalsIgnoreCase(str3)) {
            return -1;
        } else {
            if (!str.equalsIgnoreCase(str3) && str2.equalsIgnoreCase(str3)) {
                return 1;
            }
            if ((str.startsWith(str3) && str2.startsWith(str3)) || (str3.contains("/") && str3.startsWith(str) && str3.startsWith(str2))) {
                if (z11) {
                    e(str4, str5, map);
                }
                return 0;
            } else if ((str.startsWith(str3) && !str2.startsWith(str3)) || (str3.contains("/") && str3.startsWith(str) && !str3.startsWith(str2))) {
                return -1;
            } else {
                if ((!str.startsWith(str3) && str2.startsWith(str3)) || (str3.contains("/") && !str3.startsWith(str) && str3.startsWith(str2))) {
                    return 1;
                }
                int max = Math.max((str.length() - str3.length()) + 1, 0);
                int max2 = Math.max((str2.length() - str3.length()) + 1, 0);
                if (max >= str.length()) {
                    max = 0;
                }
                String substring = str.substring(0, max);
                if (max2 >= str2.length()) {
                    max2 = 0;
                }
                String substring2 = str2.substring(0, max2);
                if (!substring.contains(str3) || !substring2.contains(str3)) {
                    if (substring.contains(str3) && !substring2.contains(str3)) {
                        return -1;
                    }
                    if (!substring.contains(str3) && substring2.contains(str3)) {
                        return 1;
                    }
                } else if (z11) {
                    return e(str4, str5, map);
                }
                if (!str.endsWith(str3) || !str2.endsWith(str3)) {
                    if (str.endsWith(str3) && !str2.endsWith(str3)) {
                        return -1;
                    }
                    if (str.endsWith(str3) || !str2.endsWith(str3)) {
                        return -2;
                    }
                    return 1;
                } else if (z11) {
                    return e(str4, str5, map);
                } else {
                    return -2;
                }
            }
        }
    }

    public static int c(NewSearchItem newSearchItem, NewSearchItem newSearchItem2, String str, Map<String, Integer> map) {
        String str2 = "";
        String upperCase = !newSearchItem.getSymbol().isEmpty() ? newSearchItem.getSymbol().toUpperCase(Locale.ROOT) : str2;
        if (!newSearchItem2.getSymbol().isEmpty()) {
            str2 = newSearchItem2.getSymbol().toUpperCase(Locale.ROOT);
        }
        if (str.contains(" ") || str.contains("/")) {
            upperCase = newSearchItem.getSymbolName();
            str2 = newSearchItem2.getSymbolName();
        }
        if (newSearchItem.getTradeType() == TradeType.CONTRACT || newSearchItem.getTradeType() == TradeType.LINEAR_SWAP || newSearchItem.getTradeType() == TradeType.SWAP) {
            if (upperCase.equalsIgnoreCase(str) && str2.equalsIgnoreCase(str)) {
                return d(newSearchItem, newSearchItem2, map);
            }
            if (upperCase.equalsIgnoreCase(str) && !str2.equalsIgnoreCase(str)) {
                return -1;
            }
            if (!upperCase.equalsIgnoreCase(str) && str2.equalsIgnoreCase(str)) {
                return 1;
            }
            if (upperCase.startsWith(str) && str2.startsWith(str)) {
                return d(newSearchItem, newSearchItem2, map);
            }
            if (upperCase.startsWith(str) && !str2.startsWith(str)) {
                return -1;
            }
            if (!upperCase.startsWith(str) && str2.startsWith(str)) {
                return 1;
            }
            int max = Math.max((upperCase.length() - str.length()) + 1, 0);
            int max2 = Math.max((str2.length() - str.length()) + 1, 0);
            if (max >= upperCase.length()) {
                max = 0;
            }
            String substring = upperCase.substring(0, max);
            if (max2 >= str2.length()) {
                max2 = 0;
            }
            String substring2 = str2.substring(0, max2);
            if (substring.contains(str) && substring2.contains(str)) {
                return d(newSearchItem, newSearchItem2, map);
            }
            if (substring.contains(str) && !substring2.contains(str)) {
                return -1;
            }
            if (!substring.contains(str) && substring2.contains(str)) {
                return 1;
            }
            if (upperCase.endsWith(str) && str2.endsWith(str)) {
                return d(newSearchItem, newSearchItem2, map);
            }
            if (upperCase.endsWith(str) && !str2.endsWith(str)) {
                return -1;
            }
            if (upperCase.endsWith(str) || !str2.endsWith(str)) {
                return 0;
            }
            return 1;
        }
        return 0;
    }

    public static int d(NewSearchItem newSearchItem, NewSearchItem newSearchItem2, Map<String, Integer> map) {
        TradeType tradeType = TradeType.LINEAR_SWAP;
        if (tradeType == newSearchItem.getTradeType() && tradeType == newSearchItem2.getTradeType()) {
            return 0;
        }
        if (tradeType == newSearchItem.getTradeType() && TradeType.CONTRACT == newSearchItem2.getTradeType()) {
            return -1;
        }
        if (tradeType == newSearchItem.getTradeType() && TradeType.SWAP == newSearchItem2.getTradeType()) {
            return -1;
        }
        TradeType tradeType2 = TradeType.CONTRACT;
        if (tradeType2 == newSearchItem.getTradeType() && tradeType == newSearchItem2.getTradeType()) {
            return 1;
        }
        if (tradeType2 == newSearchItem.getTradeType() && TradeType.SWAP == newSearchItem2.getTradeType()) {
            return -1;
        }
        TradeType tradeType3 = TradeType.SWAP;
        if (tradeType3 == newSearchItem.getTradeType() && tradeType == newSearchItem2.getTradeType()) {
            return 1;
        }
        if (tradeType3 == newSearchItem.getTradeType() && tradeType2 == newSearchItem2.getTradeType()) {
            return 1;
        }
        if (tradeType2 != newSearchItem.getTradeType() || tradeType2 != newSearchItem2.getTradeType()) {
            return 0;
        }
        String str = "";
        String substring = !newSearchItem.getContractShortType().isEmpty() ? newSearchItem.getContractShortType().substring(newSearchItem.getContractShortType().length() - 3) : str;
        if (!newSearchItem2.getContractShortType().isEmpty()) {
            str = newSearchItem2.getContractShortType().substring(newSearchItem2.getContractShortType().length() - 3);
        }
        return e(substring, str, map);
    }

    public static int e(String str, String str2, Map<String, Integer> map) {
        if (map == null) {
            return 0;
        }
        int intValue = map.containsKey(str) ? map.get(str).intValue() : -2;
        int intValue2 = map.containsKey(str2) ? map.get(str2).intValue() : -2;
        if (-2 == intValue || -2 == intValue2) {
            if (-2 != intValue) {
                return -1;
            }
            if (-2 != intValue2) {
                return 1;
            }
            int compareTo = str.compareTo(str2);
            if (compareTo < 0) {
                return -1;
            }
            if (compareTo > 0) {
                return 1;
            }
        } else if (intValue < intValue2) {
            return -1;
        } else {
            if (intValue > intValue2) {
                return 1;
            }
        }
        return 0;
    }
}
