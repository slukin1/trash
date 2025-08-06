package bn;

import com.hbg.lib.data.future.bean.FutureUserInfo;
import com.hbg.lib.network.newkyc.bean.UnifyKycInfo;
import com.hbg.lib.network.newkyc.bean.UserKycInfoNew;
import com.huobi.linearswap.presenter.LinearSwapTradeBasePresenter;
import rx.functions.Func3;

public final /* synthetic */ class f0 implements Func3 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ f0 f12823b = new f0();

    public final Object call(Object obj, Object obj2, Object obj3) {
        return LinearSwapTradeBasePresenter.S2((FutureUserInfo) obj, (UserKycInfoNew) obj2, (UnifyKycInfo) obj3);
    }
}
