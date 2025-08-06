package jp;

import com.huobi.login.usercenter.data.source.bean.UserSecurityInfoData;
import com.huobi.otc.helper.a;
import rx.functions.Action1;

public final /* synthetic */ class k1 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a f56034b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f56035c;

    public /* synthetic */ k1(a aVar, int i11) {
        this.f56034b = aVar;
        this.f56035c = i11;
    }

    public final void call(Object obj) {
        this.f56034b.x(this.f56035c, (UserSecurityInfoData) obj);
    }
}
