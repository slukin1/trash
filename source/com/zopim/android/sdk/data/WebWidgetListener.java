package com.zopim.android.sdk.data;

import android.annotation.TargetApi;
import android.os.Build;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.zendesk.logger.Logger;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;

public class WebWidgetListener extends WebViewClient {
    private static final boolean DEBUG = false;
    private static final String DELIMITER = "z://";
    private static final String ENCODING = "utf-8";
    private static final String LOG_TAG = "WebWidgetListener";
    private static final Executor SERIAL_EXECUTOR = new SerialExecutor(Executors.newCachedThreadPool());

    @TargetApi(11)
    private void executePathUpdate(final String str) {
        try {
            if (Build.VERSION.SDK_INT >= 11) {
                new PathUpdaterTask().executeOnExecutor(SERIAL_EXECUTOR, new String[]{str});
                return;
            }
            try {
                SERIAL_EXECUTOR.execute(new Runnable() {
                    public void run() {
                        new PathUpdater().updatePath(str);
                    }
                });
            } catch (RejectedExecutionException e11) {
                Logger.k(LOG_TAG, "Could not execute path update", e11, new Object[0]);
            }
        } catch (IllegalStateException e12) {
            Logger.l(LOG_TAG, "Could not execute path update due to a state error", new Object[0]);
            e12.printStackTrace();
        }
    }

    @JavascriptInterface
    public void msg(String str) {
        executePathUpdate(str);
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (str == null || !str.contains(DELIMITER)) {
            Logger.b(LOG_TAG, "Not interested in handling URL loading", new Object[0]);
            return true;
        }
        try {
            String substring = str.substring(str.indexOf(DELIMITER) + 4);
            try {
                substring = URLDecoder.decode(substring, ENCODING);
            } catch (UnsupportedEncodingException e11) {
                Logger.d(LOG_TAG, "Error encoding " + substring, new Object[0]);
                e11.printStackTrace();
            }
            executePathUpdate(substring);
            return true;
        } catch (IndexOutOfBoundsException e12) {
            Logger.l(LOG_TAG, "Error parsing url. " + e12.getMessage(), new Object[0]);
            return true;
        }
    }
}
