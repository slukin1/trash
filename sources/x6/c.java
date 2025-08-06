package x6;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.JavascriptInterface;
import com.hbg.lib.core.util.DokitJsActionHelper;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.lib.core.webview.bean.JsMessage;
import i6.k;
import v6.u;

public class c {

    /* renamed from: a  reason: collision with root package name */
    public u f69080a;

    public c(u uVar) {
        this.f69080a = uVar;
    }

    public final void a(JsMessage jsMessage, u uVar) {
        if (!b.c(jsMessage, uVar)) {
            b(jsMessage, uVar);
        }
    }

    public boolean b(JsMessage jsMessage, u uVar) {
        return false;
    }

    @JavascriptInterface
    public void postMessage(String str) {
        Log.d("JsCallBack", "HBWebViewPool, postMessage, msg:" + str);
        Activity activity = this.f69080a.getActivity();
        if (activity != null && (activity instanceof HBBaseWebActivity)) {
            String str2 = "" + ((HBBaseWebActivity) activity).mUrl;
            if (!TextUtils.isEmpty(str2) && str2.contains("hb_unsafe=1")) {
                Log.d("JsCallBack", "非huobi内部产品不能与app进行js通信!!!-->reveiced message-->" + str + "       " + str2);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("非huobi内部产品不能与app进行js通信!!! url=");
                sb2.append(str2);
                k.e(sb2.toString());
                return;
            }
        }
        DokitJsActionHelper.a(str);
        a(b.h(str), this.f69080a);
    }

    @JavascriptInterface
    public void ready() {
        Log.d("JsCallBack", "JS is ready for call");
    }
}
