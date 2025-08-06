package qp;

import com.huobi.otc.persenter.OtcChatPresenter;
import retrofit2.Response;
import rx.functions.Func1;

public final /* synthetic */ class e implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OtcChatPresenter.f f60075b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f60076c;

    public /* synthetic */ e(OtcChatPresenter.f fVar, boolean z11) {
        this.f60075b = fVar;
        this.f60076c = z11;
    }

    public final Object call(Object obj) {
        return this.f60075b.i(this.f60076c, (Response) obj);
    }
}
