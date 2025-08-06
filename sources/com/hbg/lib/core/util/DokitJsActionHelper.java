package com.hbg.lib.core.util;

import android.webkit.WebView;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.core.webview.bean.JsMessage;

public class DokitJsActionHelper {

    /* renamed from: a  reason: collision with root package name */
    public static a f68666a;

    /* renamed from: b  reason: collision with root package name */
    public static b f68667b;

    public interface a {
        void a(JsMessage jsMessage, String str);

        void b(String str);
    }

    public interface b {
        void a(FragmentActivity fragmentActivity, WebView webView);
    }

    public static void a(String str) {
        a aVar = f68666a;
        if (aVar != null) {
            aVar.b(str);
        }
    }

    public static void b(JsMessage jsMessage, String str) {
        a aVar = f68666a;
        if (aVar != null) {
            aVar.a(jsMessage, str);
        }
    }

    public static void c(FragmentActivity fragmentActivity, WebView webView) {
        b bVar = f68667b;
        if (bVar != null) {
            bVar.a(fragmentActivity, webView);
        }
    }
}
