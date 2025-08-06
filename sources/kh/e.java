package kh;

import com.hbg.lib.network.hbg.core.bean.PledgeBalance;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import i6.m;
import java.util.Comparator;

public final /* synthetic */ class e implements Comparator {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ e f56571b = new e();

    public final int compare(Object obj, Object obj2) {
        return Double.valueOf(m.h0(LegalCurrencyConfigUtil.B(((PledgeBalance.CurrencyBalance) obj2).getUsdtAmount()))).compareTo(Double.valueOf(m.h0(LegalCurrencyConfigUtil.B(((PledgeBalance.CurrencyBalance) obj).getUsdtAmount()))));
    }
}
