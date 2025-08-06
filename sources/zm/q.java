package zm;

import com.hbg.lib.network.linear.swap.core.bean.AccountBalanceInfoV5;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapLeverRate;
import com.huobi.linearswap.ordertutorial.ui.OrderTutorialStep2Fragment;
import rx.functions.Func2;

public final /* synthetic */ class q implements Func2 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OrderTutorialStep2Fragment f63095b;

    public /* synthetic */ q(OrderTutorialStep2Fragment orderTutorialStep2Fragment) {
        this.f63095b = orderTutorialStep2Fragment;
    }

    public final Object call(Object obj, Object obj2) {
        return this.f63095b.ji((AccountBalanceInfoV5) obj, (LinearSwapLeverRate) obj2);
    }
}
