package com.iproov.sdk.p017implements;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.iproov.sdk.logging.IPLog;

/* renamed from: com.iproov.sdk.implements.super  reason: invalid class name and invalid package */
public class Csuper {

    /* renamed from: do  reason: not valid java name */
    private static final String f946do = "super";

    /* renamed from: do  reason: not valid java name */
    public static Typeface m1038do(Context context, String str) {
        try {
            return Typeface.createFromAsset(context.getAssets(), str);
        } catch (RuntimeException unused) {
            String str2 = f946do;
            IPLog.w(str2, "Font asset not found " + str);
            throw new RuntimeException("Font asset not found " + str);
        }
    }

    /* renamed from: do  reason: not valid java name */
    public static Typeface m1037do(Context context, int i11) {
        try {
            return ResourcesCompat.h(context, i11);
        } catch (RuntimeException unused) {
            IPLog.w(f946do, "Font resource not found");
            throw new RuntimeException("Font resource not found");
        }
    }

    /* renamed from: do  reason: not valid java name */
    public static void m1039do(TextView textView, Typeface typeface) {
        if (textView != null) {
            textView.setTypeface(typeface);
            textView.setPaintFlags(textView.getPaintFlags() | 128);
        }
    }
}
