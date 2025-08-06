package ic;

import com.hbg.module.community.widgets.rich.RichWebView;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RichWebView f55043b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f55044c;

    public /* synthetic */ c(RichWebView richWebView, String str) {
        this.f55043b = richWebView;
        this.f55044c = str;
    }

    public final void run() {
        RichWebView.k(this.f55043b, this.f55044c);
    }
}
