package wn;

import com.huobi.login.usercenter.data.source.bean.ThirdData;
import com.huobi.login.usercenter.data.source.bean.ThirdState;
import rx.functions.Action1;

public final /* synthetic */ class j0 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ k0 f61447b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ThirdData f61448c;

    public /* synthetic */ j0(k0 k0Var, ThirdData thirdData) {
        this.f61447b = k0Var;
        this.f61448c = thirdData;
    }

    public final void call(Object obj) {
        this.f61447b.q(this.f61448c, (ThirdState) obj);
    }
}
