package m9;

import com.hbg.lib.network.swap.core.bean.SwapUserInfo;
import com.huobi.contract.entity.ContractUserInfoActive;
import rx.functions.Func1;

public final /* synthetic */ class w implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SwapUserInfo.UserBean f58140b;

    public /* synthetic */ w(SwapUserInfo.UserBean userBean) {
        this.f58140b = userBean;
    }

    public final Object call(Object obj) {
        return z.l(this.f58140b, (ContractUserInfoActive) obj);
    }
}
