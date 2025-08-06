package qp;

import com.huobi.otc.persenter.OtcLiteChatPresenter;
import rx.functions.Func1;

public final /* synthetic */ class m implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OtcLiteChatPresenter f60086b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f60087c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ boolean f60088d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f60089e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ boolean f60090f;

    public /* synthetic */ m(OtcLiteChatPresenter otcLiteChatPresenter, String str, boolean z11, String str2, boolean z12) {
        this.f60086b = otcLiteChatPresenter;
        this.f60087c = str;
        this.f60088d = z11;
        this.f60089e = str2;
        this.f60090f = z12;
    }

    public final Object call(Object obj) {
        return this.f60086b.g1(this.f60087c, this.f60088d, this.f60089e, this.f60090f, (Integer) obj);
    }
}
