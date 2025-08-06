package com.huawei.hms.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.huawei.hms.support.log.HMSLog;

public abstract class ResourceLoaderUtil {

    /* renamed from: a  reason: collision with root package name */
    private static Context f38625a;

    /* renamed from: b  reason: collision with root package name */
    private static String f38626b;

    public static int getAnimId(String str) {
        Context context = f38625a;
        if (context == null) {
            return 0;
        }
        return context.getResources().getIdentifier(str, "anim", f38626b);
    }

    public static int getColorId(String str) {
        Context context = f38625a;
        if (context == null) {
            return 0;
        }
        return context.getResources().getIdentifier(str, "color", f38626b);
    }

    public static int getDimenId(String str) {
        Context context = f38625a;
        if (context == null) {
            return 0;
        }
        return context.getResources().getIdentifier(str, "dimen", f38626b);
    }

    public static Drawable getDrawable(String str) {
        Context context = f38625a;
        if (context == null) {
            return null;
        }
        return context.getResources().getDrawable(getDrawableId(str));
    }

    public static int getDrawableId(String str) {
        Context context = f38625a;
        if (context == null) {
            return 0;
        }
        return context.getResources().getIdentifier(str, "drawable", f38626b);
    }

    public static int getIdId(String str) {
        Context context = f38625a;
        if (context == null) {
            return 0;
        }
        return context.getResources().getIdentifier(str, "id", f38626b);
    }

    public static int getLayoutId(String str) {
        Context context = f38625a;
        if (context == null) {
            return 0;
        }
        return context.getResources().getIdentifier(str, TtmlNode.TAG_LAYOUT, f38626b);
    }

    public static String getString(String str) {
        Context context = f38625a;
        if (context == null) {
            return "";
        }
        return context.getResources().getString(getStringId(str));
    }

    public static int getStringId(String str) {
        Context context = f38625a;
        if (context == null) {
            return 0;
        }
        return context.getResources().getIdentifier(str, "string", f38626b);
    }

    public static int getStyleId(String str) {
        Context context = f38625a;
        if (context == null) {
            return 0;
        }
        return context.getResources().getIdentifier(str, "style", f38626b);
    }

    public static Context getmContext() {
        return f38625a;
    }

    public static void setmContext(Context context) {
        f38625a = context;
        if (context != null) {
            f38626b = context.getPackageName();
            return;
        }
        f38626b = null;
        HMSLog.e("ResourceLoaderUtil", "context is null");
    }

    public static String getString(String str, Object... objArr) {
        Context context = f38625a;
        if (context == null) {
            return "";
        }
        return context.getResources().getString(getStringId(str), objArr);
    }
}
