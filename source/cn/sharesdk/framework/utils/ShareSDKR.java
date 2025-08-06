package cn.sharesdk.framework.utils;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;

public class ShareSDKR {
    public static int getAnimRes(Context context, String str) {
        return getResId(context, "anim", str);
    }

    public static int getBitmapRes(Context context, String str) {
        return getResId(context, "drawable", str);
    }

    public static int getColorRes(Context context, String str) {
        return getResId(context, "color", str);
    }

    public static int getIdRes(Context context, String str) {
        return getResId(context, "id", str);
    }

    public static int getLayoutRes(Context context, String str) {
        return getResId(context, TtmlNode.TAG_LAYOUT, str);
    }

    public static int getPluralsRes(Context context, String str) {
        return getResId(context, "plurals", str);
    }

    public static int getRawRes(Context context, String str) {
        return getResId(context, "raw", str);
    }

    public static int getResId(Context context, String str, String str2) {
        int i11 = 0;
        if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String packageName = context.getPackageName();
            if (TextUtils.isEmpty(packageName)) {
                return 0;
            }
            i11 = context.getResources().getIdentifier(str2, str, packageName);
            if (i11 <= 0) {
                i11 = context.getResources().getIdentifier(str2.toLowerCase(), str, packageName);
            }
            if (i11 <= 0) {
                Resources resources = context.getResources();
                i11 = resources.getIdentifier("ssdk_" + str2, str, packageName);
                if (i11 <= 0) {
                    Resources resources2 = context.getResources();
                    i11 = resources2.getIdentifier("ssdk_" + str2.toLowerCase(), str, packageName);
                }
            }
            if (i11 <= 0) {
                Resources resources3 = context.getResources();
                i11 = resources3.getIdentifier("ssdk_oks_" + str2, str, packageName);
                if (i11 <= 0) {
                    Resources resources4 = context.getResources();
                    i11 = resources4.getIdentifier("ssdk_oks_" + str2.toLowerCase(), str, packageName);
                }
            }
            if (i11 <= 0) {
                SSDKLog b11 = SSDKLog.b();
                b11.a("failed to parse " + str + " resource \"" + str2 + "\"");
            }
        }
        return i11;
    }

    public static int getStringArrayRes(Context context, String str) {
        return getResId(context, "array", str);
    }

    public static int getStringRes(Context context, String str) {
        return getResId(context, "string", str);
    }

    public static int getStyleRes(Context context, String str) {
        return getResId(context, "style", str);
    }
}
