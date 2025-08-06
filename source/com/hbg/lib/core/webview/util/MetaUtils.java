package com.hbg.lib.core.webview.util;

import android.webkit.WebView;
import java.net.URLDecoder;
import x6.e;

public class MetaUtils {

    public interface a {
        void a(String str);
    }

    public static /* synthetic */ void b(a aVar, String str) {
        if (aVar != null) {
            aVar.a(URLDecoder.decode(str.replace("\"", "")));
        }
    }

    public static void c(WebView webView, String str, a aVar) {
        webView.evaluateJavascript("(function() { var result = '';var metas = document.head.getElementsByTagName('meta');for (var i = 0, len = metas.length; i < len; i++) {    var meta = metas[i];    var name = meta.getAttribute('name');    var content = meta.getAttribute('content');    var key;    if(name == '" + str + "'){         result = content;         break;    }}return result; })();", new e(aVar));
    }
}
