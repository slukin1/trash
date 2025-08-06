package vp;

import com.huobi.otc.widget.CouponCountDown;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CouponCountDown f61127b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f61128c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f61129d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ int f61130e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ int f61131f;

    public /* synthetic */ b(CouponCountDown couponCountDown, int i11, int i12, int i13, int i14) {
        this.f61127b = couponCountDown;
        this.f61128c = i11;
        this.f61129d = i12;
        this.f61130e = i13;
        this.f61131f = i14;
    }

    public final void run() {
        this.f61127b.d(this.f61128c, this.f61129d, this.f61130e, this.f61131f);
    }
}
