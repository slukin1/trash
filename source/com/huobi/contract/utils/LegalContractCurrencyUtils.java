package com.huobi.contract.utils;

import android.text.TextUtils;
import com.hbg.lib.network.pro.socket.bean.SymbolPrice;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.index.bean.RealTimePrice;
import java.math.BigDecimal;

public class LegalContractCurrencyUtils {
    public static String a(SymbolPrice symbolPrice) {
        BigDecimal bigDecimal;
        BigDecimal bigDecimal2 = BigDecimal.ZERO;
        Double close = symbolPrice.getClose();
        if (close != null) {
            bigDecimal2 = new BigDecimal(close.doubleValue());
        }
        String v11 = LegalCurrencyConfigUtil.v();
        if (TextUtils.isEmpty(v11)) {
            bigDecimal = BigDecimal.ONE;
        } else {
            bigDecimal = new BigDecimal(v11);
        }
        return LegalCurrencyConfigUtil.L(bigDecimal2.multiply(bigDecimal));
    }

    public static String b(RealTimePrice realTimePrice) {
        BigDecimal bigDecimal;
        BigDecimal bigDecimal2 = BigDecimal.ZERO;
        Double valueOf = Double.valueOf(realTimePrice.j());
        if (valueOf != null) {
            bigDecimal2 = new BigDecimal(valueOf.doubleValue());
        }
        String v11 = LegalCurrencyConfigUtil.v();
        if (TextUtils.isEmpty(v11)) {
            bigDecimal = BigDecimal.ONE;
        } else {
            bigDecimal = new BigDecimal(v11);
        }
        return LegalCurrencyConfigUtil.L(bigDecimal2.multiply(bigDecimal));
    }
}
