package com.hbg.lib.core.util;

import android.text.TextUtils;
import com.hbg.lib.common.utils.SP;
import com.hbg.lib.common.utils.crypt.MD5Utils;
import com.hbg.lib.data.symbol.TradeType;

public class CoinStringUtil {

    /* renamed from: a  reason: collision with root package name */
    public static int f68665a = 1;

    public static int a(TradeType tradeType, int i11) {
        if (f68665a == 2) {
            String j11 = SP.j("copyTrading", MD5Utils.a("LINEAR_SWAP"), "");
            if (TextUtils.isEmpty(j11) || j11.equalsIgnoreCase("\"symbol\"")) {
                return 1;
            }
            return 2;
        }
        return SP.e("sp_key_contract_unit_type_" + tradeType.toString(), i11);
    }

    public static boolean b(int i11) {
        return i11 == 1;
    }

    public static boolean c(TradeType tradeType) {
        if (tradeType != TradeType.LINEAR_SWAP) {
            int a11 = a(tradeType, 0);
            if (a11 == 1 || a11 == 3) {
                return true;
            }
            return false;
        } else if (a(tradeType, 2) == 1) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean d(TradeType tradeType) {
        if (tradeType == TradeType.LINEAR_SWAP) {
            int a11 = a(tradeType, 2);
            if (a11 == 2 || a11 == 0 || a11 == 3) {
                return true;
            }
            return false;
        } else if (a(tradeType, 0) == 2) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean e(TradeType tradeType) {
        return a(tradeType, 2) == 3;
    }

    public static void f(int i11, TradeType tradeType) {
        SP.q("sp_key_contract_unit_type_" + tradeType.toString(), i11);
    }
}
