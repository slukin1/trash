package u6;

import com.hbg.lib.core.ui.BaseActivity;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BaseActivity f60532b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f60533c;

    public /* synthetic */ d(BaseActivity baseActivity, boolean z11) {
        this.f60532b = baseActivity;
        this.f60533c = z11;
    }

    public final void run() {
        this.f60532b.lambda$showProgressDialog$1(this.f60533c);
    }
}
