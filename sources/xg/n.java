package xg;

import com.huobi.activity.AppConfigActivity;
import com.huobi.login.usercenter.data.source.bean.KvStore;
import rx.functions.Action1;

public final /* synthetic */ class n implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AppConfigActivity.c f61571b;

    public /* synthetic */ n(AppConfigActivity.c cVar) {
        this.f61571b = cVar;
    }

    public final void call(Object obj) {
        this.f61571b.i((KvStore) obj);
    }
}
