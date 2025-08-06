package xh;

import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import rx.functions.Func1;

public final /* synthetic */ class o implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ o f61616b = new o();

    public final Object call(Object obj) {
        return Boolean.valueOf(!"15".equals(((BalanceProfitLossData.AccountBalance) obj).getDistributionType()));
    }
}
