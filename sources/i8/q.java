package i8;

import com.hbg.lib.network.linear.swap.core.bean.LinearSwapUserInfo;
import com.huobi.contract.entity.ContractUserInfoActive;
import rx.functions.Func1;

public final /* synthetic */ class q implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LinearSwapUserInfo f55029b;

    public /* synthetic */ q(LinearSwapUserInfo linearSwapUserInfo) {
        this.f55029b = linearSwapUserInfo;
    }

    public final Object call(Object obj) {
        return s.i(this.f55029b, (ContractUserInfoActive) obj);
    }
}
