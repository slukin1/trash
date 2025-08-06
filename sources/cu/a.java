package cu;

import com.huobi.uiKit.window.floatkeeper.core.FloatingContainerView;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FloatingContainerView f53485b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f53486c;

    public /* synthetic */ a(FloatingContainerView floatingContainerView, boolean z11) {
        this.f53485b = floatingContainerView;
        this.f53486c = z11;
    }

    public final void run() {
        FloatingContainerView.l(this.f53485b, this.f53486c);
    }
}
