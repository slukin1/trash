package com.facebook.internal;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.webkit.WebView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sumsub.sns.internal.ml.autocapture.a;
import org.json.JSONException;
import org.json.JSONObject;

public class FacebookWebFallbackDialog extends WebDialog {
    private static final int OS_BACK_BUTTON_RESPONSE_TIMEOUT_MILLISECONDS = 1500;
    private static final String TAG = FacebookWebFallbackDialog.class.getName();
    private boolean waitingForDialogToClose;

    private FacebookWebFallbackDialog(Context context, String str, String str2) {
        super(context, str);
        setExpectedRedirectUrl(str2);
    }

    public static FacebookWebFallbackDialog newInstance(Context context, String str, String str2) {
        WebDialog.initDefaultTheme(context);
        return new FacebookWebFallbackDialog(context, str, str2);
    }

    public void cancel() {
        WebView webView = getWebView();
        if (!isPageFinished() || isListenerCalled() || webView == null || !webView.isShown()) {
            super.cancel();
        } else if (!this.waitingForDialogToClose) {
            this.waitingForDialogToClose = true;
            String str = "javascript:" + "(function() {  var event = document.createEvent('Event');  event.initEvent('fbPlatformDialogMustClose',true,true);  document.dispatchEvent(event);})();";
            webView.loadUrl(str);
            SensorsDataAutoTrackHelper.loadUrl2(webView, str);
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                public void run() {
                    FacebookWebFallbackDialog.super.cancel();
                }
            }, a.f34923p);
        }
    }

    public Bundle parseResponseUri(String str) {
        Bundle parseUrlQueryString = Utility.parseUrlQueryString(Uri.parse(str).getQuery());
        String string = parseUrlQueryString.getString(ServerProtocol.FALLBACK_DIALOG_PARAM_BRIDGE_ARGS);
        parseUrlQueryString.remove(ServerProtocol.FALLBACK_DIALOG_PARAM_BRIDGE_ARGS);
        if (!Utility.isNullOrEmpty(string)) {
            try {
                parseUrlQueryString.putBundle(NativeProtocol.EXTRA_PROTOCOL_BRIDGE_ARGS, BundleJSONConverter.convertToBundle(new JSONObject(string)));
            } catch (JSONException e11) {
                Utility.logd(TAG, "Unable to parse bridge_args JSON", e11);
            }
        }
        String string2 = parseUrlQueryString.getString(ServerProtocol.FALLBACK_DIALOG_PARAM_METHOD_RESULTS);
        parseUrlQueryString.remove(ServerProtocol.FALLBACK_DIALOG_PARAM_METHOD_RESULTS);
        if (!Utility.isNullOrEmpty(string2)) {
            if (Utility.isNullOrEmpty(string2)) {
                string2 = "{}";
            }
            try {
                parseUrlQueryString.putBundle(NativeProtocol.EXTRA_PROTOCOL_METHOD_RESULTS, BundleJSONConverter.convertToBundle(new JSONObject(string2)));
            } catch (JSONException e12) {
                Utility.logd(TAG, "Unable to parse bridge_args JSON", e12);
            }
        }
        parseUrlQueryString.remove("version");
        parseUrlQueryString.putInt(NativeProtocol.EXTRA_PROTOCOL_VERSION, NativeProtocol.getLatestKnownVersion());
        return parseUrlQueryString;
    }
}
