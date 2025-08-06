package ie;

import com.hbg.module.libkt.base.ui.BaseFragment;

public final /* synthetic */ class f implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BaseFragment f55074b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f55075c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ boolean f55076d;

    public /* synthetic */ f(BaseFragment baseFragment, boolean z11, boolean z12) {
        this.f55074b = baseFragment;
        this.f55075c = z11;
        this.f55076d = z12;
    }

    public final void run() {
        BaseFragment.Qh(this.f55074b, this.f55075c, this.f55076d);
    }
}
