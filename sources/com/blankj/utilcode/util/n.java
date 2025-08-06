package com.blankj.utilcode.util;

import android.content.Intent;
import android.net.Uri;

public final class n {
    public static Intent a(Intent intent, boolean z11) {
        return z11 ? intent.addFlags(268435456) : intent;
    }

    public static Intent b(String str, boolean z11) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.parse("package:" + str));
        return a(intent, z11);
    }

    public static boolean c(Intent intent) {
        return Utils.a().getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }
}
