package tg;

import android.content.Context;
import com.hbg.lib.network.newkyc.bean.UserKycInfoNew;
import com.huobi.account.helper.UserLoginHelper;
import kn.a;
import rx.functions.Action0;
import rx.functions.Action1;

public final /* synthetic */ class i implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UserLoginHelper f29318b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Context f29319c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ a f29320d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Action0 f29321e;

    public /* synthetic */ i(UserLoginHelper userLoginHelper, Context context, a aVar, Action0 action0) {
        this.f29318b = userLoginHelper;
        this.f29319c = context;
        this.f29320d = aVar;
        this.f29321e = action0;
    }

    public final void call(Object obj) {
        this.f29318b.m(this.f29319c, this.f29320d, this.f29321e, (UserKycInfoNew) obj);
    }
}
