package sp;

import com.huobi.otc.ui.OtcImageActivity;

public final /* synthetic */ class b1 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OtcImageActivity f25997b;

    public /* synthetic */ b1(OtcImageActivity otcImageActivity) {
        this.f25997b = otcImageActivity;
    }

    public final void run() {
        this.f25997b.dismissProgressDialog();
    }
}
