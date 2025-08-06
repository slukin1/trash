package rv;

import com.huochat.community.base.BaseActivity;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BaseActivity f25915b;

    public /* synthetic */ a(BaseActivity baseActivity) {
        this.f25915b = baseActivity;
    }

    public final void run() {
        BaseActivity.dismissProgressDialog$lambda$1(this.f25915b);
    }
}
