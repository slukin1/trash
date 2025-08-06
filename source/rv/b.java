package rv;

import com.huochat.community.base.BaseActivity;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BaseActivity f25916b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f25917c;

    public /* synthetic */ b(BaseActivity baseActivity, boolean z11) {
        this.f25916b = baseActivity;
        this.f25917c = z11;
    }

    public final void run() {
        BaseActivity.showProgressDialog$lambda$0(this.f25916b, this.f25917c);
    }
}
