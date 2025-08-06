package com.hbg.module.huobi.im.utils;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.hbg.lib.core.webview.HBBaseWebActivity;

public class ImJumpUtils {
    public static void a(Activity activity, String str) {
        if (!TextUtils.isEmpty(str)) {
            Intent intent = new Intent();
            intent.putExtra("url", str);
            intent.setClass(activity, HBBaseWebActivity.class);
            activity.startActivity(intent);
        }
    }

    public static void b(Activity activity, String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }
}
