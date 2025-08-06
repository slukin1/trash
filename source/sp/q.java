package sp;

import com.huobi.otc.ui.HBSupportFormWebActivity;

public final /* synthetic */ class q implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HBSupportFormWebActivity f26072b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f26073c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f26074d;

    public /* synthetic */ q(HBSupportFormWebActivity hBSupportFormWebActivity, String str, String str2) {
        this.f26072b = hBSupportFormWebActivity;
        this.f26073c = str;
        this.f26074d = str2;
    }

    public final void run() {
        this.f26072b.zh(this.f26073c, this.f26074d);
    }
}
