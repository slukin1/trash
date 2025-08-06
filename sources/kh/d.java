package kh;

import com.hbg.lib.network.hbg.core.bean.PledgeBalance;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import i6.m;
import java.util.Comparator;

public final /* synthetic */ class d implements Comparator {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ d f56570b = new d();

    public final int compare(Object obj, Object obj2) {
        return Double.valueOf(m.h0(LegalCurrencyConfigUtil.B(((PledgeBalance.CurrencyBalance) obj2).getUsdtAmount()))).compareTo(Double.valueOf(m.h0(LegalCurrencyConfigUtil.B(((PledgeBalance.CurrencyBalance) obj).getUsdtAmount()))));
    }
}
