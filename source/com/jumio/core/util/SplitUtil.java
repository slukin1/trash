package com.jumio.core.util;

import android.content.Context;
import com.jumio.commons.log.Log;

public final class SplitUtil {
    public static final SplitUtil INSTANCE = new SplitUtil();

    public final boolean getHasSplitCompat() {
        return ReflectionUtil.hasClass("com.google.android.play.core.splitcompat.SplitCompat");
    }

    public final void installSplitContext(Context context) {
        try {
            if (getHasSplitCompat()) {
                Class<?> cls = Class.forName("com.google.android.play.core.splitcompat.SplitCompat");
                ReflectionUtil.invokeMethodWithArgs(cls, "install", new Class[]{Context.class}, (Object) null, context);
                ReflectionUtil.invokeMethodWithArgs(cls, "installActivity", new Class[]{Context.class}, (Object) null, context);
            }
        } catch (Exception e11) {
            Log.printStackTrace(e11);
        }
    }

    public final void loadLibrary(Context context, String str) {
        try {
            if (getHasSplitCompat()) {
                ReflectionUtil.invokeMethodWithArgs(Class.forName("com.google.android.play.core.splitinstall.SplitInstallHelper"), "loadLibrary", new Class[]{Context.class, String.class}, (Object) null, context, str);
            }
        } catch (Exception e11) {
            Log.printStackTrace(e11);
        }
    }
}
