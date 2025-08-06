package pk;

import androidx.lifecycle.z;
import com.hbg.lib.network.hbg.core.bean.ActivityZeroAvailablePositionBean;
import com.huobi.feature.ui.FutureTradeFragment;

public final /* synthetic */ class s implements z {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FutureTradeFragment f53137b;

    public /* synthetic */ s(FutureTradeFragment futureTradeFragment) {
        this.f53137b = futureTradeFragment;
    }

    public final void onChanged(Object obj) {
        this.f53137b.ai((ActivityZeroAvailablePositionBean) obj);
    }
}
