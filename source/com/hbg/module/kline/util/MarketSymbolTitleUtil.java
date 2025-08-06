package com.hbg.module.kline.util;

import android.text.TextUtils;
import com.hbg.lib.common.BaseApplication;
import com.hbg.module.kline.R$string;
import com.xiaomi.mipush.sdk.Constants;

public final class MarketSymbolTitleUtil {
    public static String a(String str) {
        int i11;
        int i12;
        StringBuilder sb2 = new StringBuilder();
        if (str.contains(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
            String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            if (split == null) {
                i12 = 0;
            } else {
                i12 = split.length;
            }
            if (i12 >= 1) {
                sb2.append(split[0]);
            }
            if (i12 >= 2) {
                sb2.append(split[1]);
            }
            sb2.append(" ");
            if (i12 == 2) {
                sb2.append(BaseApplication.b().getResources().getString(R$string.n_market_contract_swap_trade_name));
            } else if (i12 >= 3) {
                String str2 = split[2];
                if (!TextUtils.isEmpty(str2)) {
                    if (str2.contains("CW")) {
                        sb2.append(BaseApplication.b().getResources().getString(R$string.contract_symbol_thisweek));
                    } else if (str2.contains("NW")) {
                        sb2.append(BaseApplication.b().getResources().getString(R$string.contract_symbol_nextweek));
                    } else if (str2.contains("CQ")) {
                        sb2.append(BaseApplication.b().getResources().getString(R$string.contract_symbol_quarter));
                    } else if (str2.contains("NQ")) {
                        sb2.append(BaseApplication.b().getResources().getString(R$string.n_contract_trade_next_quarter));
                    }
                }
            }
        } else if (str.contains("_")) {
            String[] split2 = str.split("_");
            if (split2 == null) {
                i11 = 0;
            } else {
                i11 = split2.length;
            }
            if (i11 >= 1) {
                sb2.append(split2[0]);
            }
            sb2.append("USD");
            sb2.append(" ");
            if (i11 == 1) {
                sb2.append(BaseApplication.b().getResources().getString(R$string.n_market_contract_swap_trade_name));
            } else if (i11 >= 2) {
                String str3 = split2[1];
                if (!TextUtils.isEmpty(str3)) {
                    if (str3.contains("CW")) {
                        sb2.append(BaseApplication.b().getResources().getString(R$string.contract_symbol_thisweek));
                    } else if (str3.contains("NW")) {
                        sb2.append(BaseApplication.b().getResources().getString(R$string.contract_symbol_nextweek));
                    } else if (str3.contains("CQ")) {
                        sb2.append(BaseApplication.b().getResources().getString(R$string.contract_symbol_quarter));
                    } else if (str3.contains("NQ")) {
                        sb2.append(BaseApplication.b().getResources().getString(R$string.n_contract_trade_next_quarter));
                    }
                }
            }
        }
        return sb2.toString();
    }

    public static String b(String str) {
        int i11;
        StringBuilder sb2 = new StringBuilder();
        String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        if (split == null) {
            i11 = 0;
        } else {
            i11 = split.length;
        }
        if (i11 >= 1) {
            sb2.append(split[0]);
        }
        if (i11 >= 2) {
            sb2.append(split[1]);
        }
        sb2.append(" ");
        if (i11 == 2) {
            sb2.append(BaseApplication.b().getResources().getString(R$string.n_market_contract_swap_trade_name));
        } else if (i11 >= 3) {
            String str2 = split[2];
            if (!TextUtils.isEmpty(str2)) {
                if (str2.contains("CW")) {
                    sb2.append(BaseApplication.b().getResources().getString(R$string.contract_symbol_thisweek));
                } else if (str2.contains("NW")) {
                    sb2.append(BaseApplication.b().getResources().getString(R$string.contract_symbol_nextweek));
                } else if (str2.contains("CQ")) {
                    sb2.append(BaseApplication.b().getResources().getString(R$string.contract_symbol_quarter));
                } else if (str2.contains("NQ")) {
                    sb2.append(BaseApplication.b().getResources().getString(R$string.n_contract_trade_next_quarter));
                }
            }
        }
        return sb2.toString();
    }
}
