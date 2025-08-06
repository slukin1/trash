package d7;

import com.hbg.lib.data.symbol.ProCurrenciesUtil;
import com.hbg.lib.network.pro.core.bean.CurrencyBean;
import rx.functions.Func2;

public final /* synthetic */ class o0 implements Func2 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ o0 f53524b = new o0();

    public final Object call(Object obj, Object obj2) {
        return Integer.valueOf(ProCurrenciesUtil.a((CurrencyBean) obj, (CurrencyBean) obj2));
    }
}
