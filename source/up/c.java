package up;

import android.webkit.JavascriptInterface;
import com.hbg.lib.core.webview.bean.JsMessage;
import com.huobi.otc.widget.OtcActiveView;
import i6.d;
import v6.u;
import x6.b;

public class c {

    /* renamed from: c  reason: collision with root package name */
    public static final String f84907c = (c.class.getSimpleName() + " hbactive");

    /* renamed from: a  reason: collision with root package name */
    public u f84908a;

    /* renamed from: b  reason: collision with root package name */
    public OtcActiveView.c f84909b;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            if (c.this.f84909b != null) {
                c.this.f84909b.onClose((String) null);
            }
        }
    }

    public c(u uVar, OtcActiveView.c cVar) {
        this.f84908a = uVar;
        this.f84909b = cVar;
    }

    public void b(JsMessage jsMessage) {
        d.b(f84907c + " jsMessage:" + jsMessage);
        u uVar = this.f84908a;
        if (uVar != null && uVar.getWebView() != null) {
            this.f84908a.getWebView().post(new a());
        }
    }

    @JavascriptInterface
    public void postMessage(String str) {
        d.b(f84907c + " h5回调了该方法  data:" + str);
        JsMessage h11 = b.h(str);
        if (h11 != null) {
            if ("20010006".equals(h11.getAction())) {
                b(h11);
            } else {
                b.c(h11, this.f84908a);
            }
        }
    }
}
