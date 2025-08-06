package qp;

import android.net.Uri;
import com.huobi.otc.persenter.OtcChatPresenter;
import rx.functions.Func1;

public final /* synthetic */ class d implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OtcChatPresenter.f f60073b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Uri f60074c;

    public /* synthetic */ d(OtcChatPresenter.f fVar, Uri uri) {
        this.f60073b = fVar;
        this.f60074c = uri;
    }

    public final Object call(Object obj) {
        return this.f60073b.g(this.f60074c, (Integer) obj);
    }
}
