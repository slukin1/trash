package x6;

import android.webkit.WebView;
import v6.w;

public class i {

    /* renamed from: a  reason: collision with root package name */
    public WebView f69085a;

    /* renamed from: b  reason: collision with root package name */
    public long f69086b;

    /* renamed from: c  reason: collision with root package name */
    public String f69087c;

    public i(WebView webView) {
        this.f69085a = webView;
    }

    public void a(int i11, String str) {
        d(this.f69087c, System.currentTimeMillis() - this.f69086b, i11, str);
    }

    public void b() {
        e(this.f69087c, System.currentTimeMillis() - this.f69086b);
    }

    public void c(String str) {
        this.f69086b = System.currentTimeMillis();
        this.f69087c = str;
    }

    public final void d(String str, long j11, int i11, String str2) {
        w.e().i(str, this.f69085a.getSettings().getUserAgentString(), j11, i11, str2);
    }

    public final void e(String str, long j11) {
        d(str, j11, 0, (String) null);
    }
}
