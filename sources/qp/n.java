package qp;

import com.huobi.otc.persenter.OtcLiteChatPresenter;
import retrofit2.Response;
import rx.functions.Func1;

public final /* synthetic */ class n implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OtcLiteChatPresenter f60091b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f60092c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ boolean f60093d;

    public /* synthetic */ n(OtcLiteChatPresenter otcLiteChatPresenter, boolean z11, boolean z12) {
        this.f60091b = otcLiteChatPresenter;
        this.f60092c = z11;
        this.f60093d = z12;
    }

    public final Object call(Object obj) {
        return this.f60091b.j1(this.f60092c, this.f60093d, (Response) obj);
    }
}
