package ie;

import com.hbg.module.libkt.base.ui.BaseFragment;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BaseFragment f55072b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f55073c;

    public /* synthetic */ e(BaseFragment baseFragment, boolean z11) {
        this.f55072b = baseFragment;
        this.f55073c = z11;
    }

    public final void run() {
        BaseFragment.Ph(this.f55072b, this.f55073c);
    }
}
