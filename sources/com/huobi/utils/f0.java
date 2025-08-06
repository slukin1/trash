package com.huobi.utils;

import android.text.TextUtils;
import android.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class f0 {
    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new String(Base64.decode(str, 2), "UTF-8");
        } catch (Exception e11) {
            Logger.getLogger(f0.class.getName()).log(Level.SEVERE, (String) null, e11);
            return null;
        }
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return Base64.encodeToString(str.getBytes("UTF-8"), 2);
        } catch (Exception e11) {
            Logger.getLogger(f0.class.getName()).log(Level.SEVERE, (String) null, e11);
            return null;
        }
    }
}
