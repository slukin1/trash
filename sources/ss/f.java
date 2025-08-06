package ss;

import com.hbg.lib.network.newkyc.bean.UnifyKycInfo;
import com.hbg.lib.network.newkyc.bean.UserKycInfoNew;
import com.hbg.lib.network.swap.core.bean.SwapUserInfo;
import com.huobi.swap.presenter.SwapTradeBasePresenter;
import rx.functions.Func3;

public final /* synthetic */ class f implements Func3 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ f f26155b = new f();

    public final Object call(Object obj, Object obj2, Object obj3) {
        return SwapTradeBasePresenter.U1((SwapUserInfo.UserBean) obj, (UserKycInfoNew) obj2, (UnifyKycInfo) obj3);
    }
}
