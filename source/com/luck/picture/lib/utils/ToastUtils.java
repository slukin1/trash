package com.luck.picture.lib.utils;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import com.luck.picture.lib.app.PictureAppMaster;
import com.luck.picture.lib.thread.PictureThreadUtils;

public class ToastUtils {
    private static final long TIME = 1000;
    private static long lastClickTime;
    /* access modifiers changed from: private */
    public static String mLastText;

    public static boolean isFastDoubleClick() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - lastClickTime < 1000) {
            return true;
        }
        lastClickTime = currentTimeMillis;
        return false;
    }

    public static void showToast(final Context context, final String str) {
        if (!isFastDoubleClick() || !TextUtils.equals(str, mLastText)) {
            Context appContext = PictureAppMaster.getInstance().getAppContext();
            if (appContext == null) {
                appContext = context.getApplicationContext();
            }
            if (PictureThreadUtils.isInUiThread()) {
                Toast.makeText(appContext, str, 0).show();
                mLastText = str;
                return;
            }
            PictureThreadUtils.runOnUiThread(new Runnable() {
                public void run() {
                    Context appContext = PictureAppMaster.getInstance().getAppContext();
                    if (appContext == null) {
                        appContext = context.getApplicationContext();
                    }
                    Toast.makeText(appContext, str, 0).show();
                    String unused = ToastUtils.mLastText = str;
                }
            });
        }
    }
}
