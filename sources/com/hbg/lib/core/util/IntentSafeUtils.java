package com.hbg.lib.core.util;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;

public class IntentSafeUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final String f68669a = String.valueOf(System.currentTimeMillis());

    public static boolean a(Intent intent) {
        Uri data;
        if (!(intent == null || (data = intent.getData()) == null)) {
            String scheme = data.getScheme();
            if (TextUtils.isEmpty(scheme) || "holigeit".equals(scheme) || TextUtils.equals("huobicard", scheme) || TextUtils.equals("hbotc", scheme) || "scheme".equals(scheme) || f68669a.equals(intent.getStringExtra("extra_time_tag"))) {
                return true;
            }
            return false;
        }
        return true;
    }

    public static void b(Context context, String str) {
        if (context != null) {
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
        }
    }

    public static void c(Context context, String str) {
        try {
            PackageManager packageManager = context.getPackageManager();
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.putExtra("extra_time_tag", f68669a);
            if (!packageManager.queryIntentActivities(intent, 0).isEmpty()) {
                context.startActivity(intent);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }
}
