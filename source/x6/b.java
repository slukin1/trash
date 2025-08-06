package x6;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hbg.lib.core.GlobalAppConfig;
import com.hbg.lib.core.util.DokitJsActionHelper;
import com.hbg.lib.core.webview.bean.JsMessage;
import com.huobi.webview2.action.JsBusinessActionHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import i6.d;
import i6.k;
import java.lang.reflect.Method;
import v6.u;
import v6.w;

public class b {
    public static boolean b(String str) {
        return TextUtils.isEmpty(str);
    }

    public static boolean c(JsMessage jsMessage, u uVar) {
        Object[] objArr;
        d.b("HBWebViewPool, JsActionHelper-->dispatchAction-->" + jsMessage.toString());
        Log.d("JsActionHelper", "HBWebViewPool-->dispatchAction-->" + jsMessage.toString());
        Method d11 = w.e().d(jsMessage.getAction());
        if (d11 != null) {
            Class<u>[] parameterTypes = d11.getParameterTypes();
            if (parameterTypes == null || parameterTypes.length <= 0) {
                objArr = null;
            } else {
                objArr = new Object[parameterTypes.length];
                for (int i11 = 0; i11 < parameterTypes.length; i11++) {
                    Class<u> cls = parameterTypes[i11];
                    if (cls == JsMessage.class) {
                        objArr[i11] = jsMessage;
                    } else if (cls == u.class) {
                        objArr[i11] = uVar;
                    }
                }
            }
            d.b("HBWebViewPool, JsActionHelper-->dispatchAction method-->" + d11 + ", params:" + objArr.toString());
            Log.d("JsActionHelper", "HBWebViewPool-->dispatchAction method-->" + d11 + ", params:" + objArr.toString());
            try {
                d11.invoke((Object) null, objArr);
            } catch (Exception e11) {
                if (GlobalAppConfig.e()) {
                    e11.printStackTrace();
                }
            }
        }
        if (d11 != null) {
            return true;
        }
        return false;
    }

    public static void d(JsMessage jsMessage, u uVar) {
        e(jsMessage, uVar, false);
    }

    public static void e(JsMessage jsMessage, u uVar, boolean z11) {
        String str;
        if (z11) {
            str = g(jsMessage);
        } else {
            str = f(jsMessage);
        }
        d.b("HBWebViewPool, JsActionHelper-->dispatchWebViewFunction-->jsString:" + str);
        if (uVar.getWebView() != null) {
            k.o(JsBusinessActionHelper.LOG_TAG, "dispatchWebViewFunction " + str);
            DokitJsActionHelper.b(jsMessage, str);
            uVar.getWebView().post(new a(uVar, str));
        }
    }

    public static String f(JsMessage jsMessage) {
        String json = new Gson().toJson((Object) jsMessage);
        return "javascript:huobiWeb.postMessage(" + json + ")";
    }

    public static String g(JsMessage jsMessage) {
        String json = new GsonBuilder().disableHtmlEscaping().create().toJson((Object) jsMessage);
        return "javascript:huobiWeb.postMessage(" + json + ")";
    }

    public static JsMessage h(String str) {
        d.j("JsActionHelper", "HBWebViewPool, handleMessage msg = " + str);
        Log.i("JsActionHelper", "HBWebViewPool, handleMessage msg = " + str);
        try {
            JsMessage jsMessage = (JsMessage) new Gson().fromJson(str, JsMessage.class);
            if (b(jsMessage.getAction())) {
                return null;
            }
            return jsMessage;
        } catch (Exception e11) {
            e11.printStackTrace();
            return null;
        }
    }

    public static /* synthetic */ void i(u uVar, String str) {
        WebView webView = uVar.getWebView();
        webView.loadUrl(str);
        SensorsDataAutoTrackHelper.loadUrl2(webView, str);
    }
}
