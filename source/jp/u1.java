package jp;

import com.hbg.lib.network.otc.core.bean.UserVO;
import com.huobi.otc.helper.a;
import rx.functions.Action1;

public final /* synthetic */ class u1 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a f56065b;

    public /* synthetic */ u1(a aVar) {
        this.f56065b = aVar;
    }

    public final void call(Object obj) {
        this.f56065b.E((UserVO) obj);
    }
}
