package u6;

import com.hbg.lib.core.ui.BaseActivity;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BaseActivity f60530b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f60531c;

    public /* synthetic */ c(BaseActivity baseActivity, String str) {
        this.f60530b = baseActivity;
        this.f60531c = str;
    }

    public final void run() {
        this.f60530b.lambda$showOldProgressDialog$0(this.f60531c);
    }
}
