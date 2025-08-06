package com.iproov.sdk;

import android.content.Context;
import android.util.Base64;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import androidx.annotation.Keep;
import com.facebook.internal.AnalyticsEvents;
import com.huobi.finance.bean.VirtualAddressInfo;
import com.iproov.sdk.IProov;
import com.iproov.sdk.IProovCallbackLauncher;
import com.iproov.sdk.bridge.OptionsBridge;
import com.iproov.sdk.core.Cfor;
import com.iproov.sdk.core.exception.IProovException;
import com.iproov.sdk.logging.IPLog;
import com.iproov.sdk.p017implements.Cimport;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@Keep
public class NativeBridge {
    private static final String JAVASCRIPT_INTERFACE_NAME = "iProovNativeBridge";
    /* access modifiers changed from: private */
    public static final String TAG = "NativeBridge";
    private IProovCallbackLauncher iProovCallbackLauncher = new IProovCallbackLauncher(new Cfor(Cfor.Cdo.NATIVE_BRIDGE));
    private IProovCallbackLauncher.Listener listener;

    /* renamed from: com.iproov.sdk.NativeBridge$do  reason: invalid class name */
    public class Cdo implements IProovCallbackLauncher.Listener {

        /* renamed from: do  reason: not valid java name */
        public final /* synthetic */ WebView f10do;

        public Cdo(NativeBridge nativeBridge, WebView webView) {
            this.f10do = webView;
        }

        public void onCancelled(IProov.Canceller canceller) {
            NativeBridge.evaluateJavascript(this.f10do, new com.iproov.sdk.p014for.Cif(AnalyticsEvents.PARAMETER_SHARE_OUTCOME_CANCELLED, (Map<String, Object>) null));
        }

        public void onConnected() {
            NativeBridge.evaluateJavascript(this.f10do, new com.iproov.sdk.p014for.Cif("connected", (Map<String, Object>) null));
        }

        public void onConnecting() {
            NativeBridge.evaluateJavascript(this.f10do, new com.iproov.sdk.p014for.Cif("connecting", (Map<String, Object>) null));
        }

        public void onError(IProovException iProovException) {
            NativeBridge.evaluateJavascript(this.f10do, new com.iproov.sdk.p014for.Cif("error", Collections.singletonMap("error", iProovException.getLocalizedMessage())));
        }

        public void onFailure(IProov.FailureResult failureResult) {
            HashMap hashMap = new HashMap();
            hashMap.put("feedbackCode", failureResult.getReason().getFeedbackCode());
            NativeBridge.evaluateJavascript(this.f10do, new com.iproov.sdk.p014for.Cif(LoginLogger.EVENT_EXTRAS_FAILURE, hashMap));
        }

        public void onProcessing(double d11, String str) {
            HashMap hashMap = new HashMap();
            hashMap.put("progress", Double.valueOf(d11));
            hashMap.put("message", str);
            NativeBridge.evaluateJavascript(this.f10do, new com.iproov.sdk.p014for.Cif(VirtualAddressInfo.LEVEL_PROCESSING, hashMap));
        }

        public void onSuccess(IProov.SuccessResult successResult) {
            NativeBridge.evaluateJavascript(this.f10do, new com.iproov.sdk.p014for.Cif("success", (Map<String, Object>) null));
        }
    }

    /* renamed from: com.iproov.sdk.NativeBridge$if  reason: invalid class name */
    public static class Cif {

        /* renamed from: do  reason: not valid java name */
        private final IProovCallbackLauncher f11do;

        /* renamed from: for  reason: not valid java name */
        private final WebView f12for;

        /* renamed from: if  reason: not valid java name */
        private final Context f13if;

        /* renamed from: new  reason: not valid java name */
        private final boolean f14new;

        public /* synthetic */ Cif(IProovCallbackLauncher iProovCallbackLauncher, WebView webView, boolean z11, Cdo doVar) {
            this(iProovCallbackLauncher, webView, z11);
        }

        @JavascriptInterface
        public boolean launch(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String str2 = com.iproov.sdk.utils.Cif.m2277if(jSONObject, "token");
                String str3 = com.iproov.sdk.utils.Cif.m2277if(jSONObject, "streaming_url");
                JSONObject optJSONObject = jSONObject.optJSONObject("options");
                if (Cimport.m1018do(str2)) {
                    IPLog.e(NativeBridge.TAG, "Token not specified");
                    NativeBridge.evaluateJavascript(this.f12for, new com.iproov.sdk.p014for.Cif("error", Collections.singletonMap("error", "Token not specified")));
                    return false;
                } else if (Cimport.m1018do(str3)) {
                    IPLog.e(NativeBridge.TAG, "Streaming URL not specified");
                    NativeBridge.evaluateJavascript(this.f12for, new com.iproov.sdk.p014for.Cif("error", Collections.singletonMap("error", "Streaming URL not specified")));
                    return false;
                } else {
                    try {
                        IProovCallbackLauncher iProovCallbackLauncher = this.f11do;
                        Context context = this.f13if;
                        iProovCallbackLauncher.launchSession(context, str3, str2, Cdo.m557do(OptionsBridge.fromJson(context, optJSONObject), this.f13if));
                        return true;
                    } catch (IProovException e11) {
                        e11.printStackTrace();
                        IPLog.w(NativeBridge.TAG, "Failed to launch via native bridge");
                        return false;
                    }
                }
            } catch (JSONException unused) {
                IPLog.e(NativeBridge.TAG, "Failed to parse JSON launch configuration");
                NativeBridge.evaluateJavascript(this.f12for, new com.iproov.sdk.p014for.Cif("error", Collections.singletonMap("error", "Failed to parse JSON launch configuration")));
                return false;
            }
        }

        @JavascriptInterface
        public String publicKey() {
            if (this.f14new) {
                IPLog.w(NativeBridge.TAG, "Failed to get public key because cryptography is not enabled");
                return null;
            }
            try {
                return this.f11do.getKeyPair(this.f13if).getPublicKey().getPem();
            } catch (IProovException e11) {
                e11.printStackTrace();
                IPLog.w(NativeBridge.TAG, "Error signing data");
                return null;
            }
        }

        @JavascriptInterface
        public String sign(String str) {
            if (this.f14new) {
                IPLog.w(NativeBridge.TAG, "Failed to sign data because cryptography is not enabled");
                return null;
            } else if (str == null) {
                IPLog.w(NativeBridge.TAG, "Error signing data, input can not be null");
                return null;
            } else {
                try {
                    return Cimport.m1016do(this.f11do.getKeyPair(this.f13if).sign(Base64.decode(str, 2)));
                } catch (IProovException e11) {
                    e11.printStackTrace();
                    String access$200 = NativeBridge.TAG;
                    IPLog.w(access$200, "Error signing data: " + e11.getMessage());
                    return null;
                }
            }
        }

        private Cif(IProovCallbackLauncher iProovCallbackLauncher, WebView webView, boolean z11) {
            this.f11do = iProovCallbackLauncher;
            this.f13if = webView.getContext().getApplicationContext();
            this.f12for = webView;
            this.f14new = z11;
        }
    }

    /* access modifiers changed from: private */
    public static void evaluateJavascript(WebView webView, com.iproov.sdk.p014for.Cdo doVar) {
        doVar.m687do();
        Cimport.m1017do((Runnable) new a(webView, doVar));
    }

    private IProovCallbackLauncher.Listener webViewBridgeListener(WebView webView) {
        return new Cdo(this, webView);
    }

    public void install(WebView webView, boolean z11) {
        if (webView == null) {
            IPLog.e(TAG, "Cannot install into a null webView");
            return;
        }
        if (!webView.getSettings().getJavaScriptEnabled()) {
            IPLog.e(TAG, "Native Bridge requires WebView Javascript execution to be enabled");
        }
        IProovCallbackLauncher.Listener webViewBridgeListener = webViewBridgeListener(webView);
        this.listener = webViewBridgeListener;
        this.iProovCallbackLauncher.setListener(webViewBridgeListener);
        webView.addJavascriptInterface(new Cif(this.iProovCallbackLauncher, webView, z11, (Cdo) null), JAVASCRIPT_INTERFACE_NAME);
    }

    public void uninstall(WebView webView) {
        if (webView != null) {
            webView.removeJavascriptInterface(JAVASCRIPT_INTERFACE_NAME);
        }
        IProovCallbackLauncher.Listener listener2 = this.listener;
        if (listener2 != null) {
            this.iProovCallbackLauncher.setListener(listener2);
            this.listener = null;
        }
    }
}
