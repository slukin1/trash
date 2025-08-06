package cn.sharesdk.framework;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.HttpAuthHandler;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import cn.sharesdk.framework.utils.SSDKLog;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;

public class h extends WebViewClient {
    public static final int ERROR_AUTHENTICATION = -4;
    public static final int ERROR_BAD_URL = -12;
    public static final int ERROR_CONNECT = -6;
    public static final int ERROR_FAILED_SSL_HANDSHAKE = -11;
    public static final int ERROR_FILE = -13;
    public static final int ERROR_FILE_NOT_FOUND = -14;
    public static final int ERROR_HOST_LOOKUP = -2;
    public static final int ERROR_IO = -7;
    public static final int ERROR_PROXY_AUTHENTICATION = -5;
    public static final int ERROR_REDIRECT_LOOP = -9;
    public static final int ERROR_TIMEOUT = -8;
    public static final int ERROR_TOO_MANY_REQUESTS = -15;
    public static final int ERROR_UNKNOWN = -1;
    public static final int ERROR_UNSUPPORTED_AUTH_SCHEME = -3;
    public static final int ERROR_UNSUPPORTED_SCHEME = -10;

    public void doUpdateVisitedHistory(WebView webView, String str, boolean z11) {
    }

    public void onFormResubmission(WebView webView, Message message, Message message2) {
        message.sendToTarget();
    }

    public void onLoadResource(WebView webView, String str) {
    }

    public void onPageFinished(WebView webView, String str) {
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
    }

    public void onReceivedError(WebView webView, int i11, String str, String str2) {
    }

    public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
        httpAuthHandler.cancel();
    }

    public void onReceivedSslError(WebView webView, final SslErrorHandler sslErrorHandler, SslError sslError) {
        String str;
        String str2;
        String str3;
        String[] strArr;
        if (webView.getContext() instanceof Activity) {
            Activity activity = (Activity) webView.getContext();
            if ("zh".equals(cn.sharesdk.framework.utils.h.a())) {
                strArr = new String[]{String.valueOf(new char[]{19981, 21463, 20449, 20219, 30340, 35777, 20070, 12290, 20320, 35201, 32487, 32493, 21527, 65311}), String.valueOf(new char[]{35777, 20070, 24050, 36807, 26399, 12290, 20320, 35201, 32487, 32493, 21527, 65311}), String.valueOf(new char[]{35777, 20070, 'I', 'D', 19981, 21305, 37197, 12290, 20320, 35201, 32487, 32493, 21527, 65311}), String.valueOf(new char[]{35777, 20070, 23578, 26410, 29983, 25928, 12290, 20320, 35201, 32487, 32493, 21527, 65311}), String.valueOf(new char[]{35777, 20070, 38169, 35823, 12290, 20320, 35201, 32487, 32493, 21527, 65311})};
                str3 = String.valueOf(new char[]{35777, 20070, 38169, 35823});
                str2 = String.valueOf(new char[]{32487, 32493});
                str = String.valueOf(new char[]{20572, 27490});
            } else {
                strArr = new String[]{"Certificate is untrusted. Do you want to continue anyway?", "Certificate has expired. Do you want to continue anyway?", "Certificate ID is mismatched. Do you want to continue anyway?", "Certificate is not yet valid. Do you want to continue anyway?", "Certificate error. Do you want to continue anyway?"};
                str3 = "SSL Certificate Error";
                str2 = "Yes";
                str = "No";
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(activity);
            builder.setTitle(str3);
            int primaryError = sslError.getPrimaryError();
            if (primaryError == 0) {
                builder.setMessage(strArr[3]);
            } else if (primaryError == 1) {
                builder.setMessage(strArr[1]);
            } else if (primaryError == 2) {
                builder.setMessage(strArr[2]);
            } else if (primaryError != 3) {
                builder.setMessage(strArr[4]);
            } else {
                builder.setMessage(strArr[0]);
            }
            builder.setCancelable(false);
            builder.setPositiveButton(str2, new DialogInterface.OnClickListener() {
                @SensorsDataInstrumented
                public void onClick(DialogInterface dialogInterface, int i11) {
                    dialogInterface.dismiss();
                    try {
                        sslErrorHandler.proceed();
                    } catch (Throwable th2) {
                        SSDKLog.b().b(th2);
                    }
                    SensorsDataAutoTrackHelper.trackDialog(dialogInterface, i11);
                }
            });
            builder.setNegativeButton(str, new DialogInterface.OnClickListener() {
                @SensorsDataInstrumented
                public void onClick(DialogInterface dialogInterface, int i11) {
                    dialogInterface.dismiss();
                    sslErrorHandler.cancel();
                    SensorsDataAutoTrackHelper.trackDialog(dialogInterface, i11);
                }
            });
            try {
                builder.create().show();
            } catch (Throwable th2) {
                SSDKLog.b().b(th2);
            }
        } else {
            sslErrorHandler.cancel();
        }
    }

    public void onScaleChanged(WebView webView, float f11, float f12) {
    }

    public void onTooManyRedirects(WebView webView, Message message, Message message2) {
        message.sendToTarget();
    }

    public void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
    }

    public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        return false;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return false;
    }
}
