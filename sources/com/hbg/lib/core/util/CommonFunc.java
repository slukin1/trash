package com.hbg.lib.core.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;

public class CommonFunc {
    public static void a(Context context, String str) {
        if (context != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }
}
