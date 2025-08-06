package xh;

import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import rx.functions.Func1;

public final /* synthetic */ class p implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ p f61617b = new p();

    public final Object call(Object obj) {
        return Boolean.valueOf(!BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_POOL.equals(((BalanceProfitLossData.AccountBalance) obj).getDistributionType()));
    }
}
