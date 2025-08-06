package xk;

import com.huobi.contract.entity.LinearSwapBalanceItem;
import com.huobi.finance.model.subaccount.LinearSwapDataProvider;
import java.util.Comparator;

public final /* synthetic */ class e implements Comparator {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ e f61629b = new e();

    public final int compare(Object obj, Object obj2) {
        return LinearSwapDataProvider.t((LinearSwapBalanceItem) obj, (LinearSwapBalanceItem) obj2);
    }
}
