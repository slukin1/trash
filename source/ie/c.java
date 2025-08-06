package ie;

import com.hbg.module.libkt.base.ui.BaseActivity;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BaseActivity f55068b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f55069c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ boolean f55070d;

    public /* synthetic */ c(BaseActivity baseActivity, boolean z11, boolean z12) {
        this.f55068b = baseActivity;
        this.f55069c = z11;
        this.f55070d = z12;
    }

    public final void run() {
        BaseActivity.wh(this.f55068b, this.f55069c, this.f55070d);
    }
}
