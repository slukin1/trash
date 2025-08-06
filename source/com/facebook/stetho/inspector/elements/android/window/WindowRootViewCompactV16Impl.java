package com.facebook.stetho.inspector.elements.android.window;

import android.content.Context;
import android.view.View;
import android.view.WindowManager;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class WindowRootViewCompactV16Impl extends WindowRootViewCompat {
    private Context mContext;

    public WindowRootViewCompactV16Impl(Context context) {
        this.mContext = context;
    }

    private static Object getOuter(Object obj) {
        try {
            Field declaredField = obj.getClass().getDeclaredField("mWindowManager");
            declaredField.setAccessible(true);
            Object obj2 = declaredField.get(obj);
            declaredField.setAccessible(false);
            return obj2;
        } catch (NoSuchFieldException e11) {
            throw new RuntimeException(e11);
        } catch (IllegalAccessException e12) {
            throw new RuntimeException(e12);
        }
    }

    private static List<View> getWindowViews(Object obj) {
        try {
            Field declaredField = obj.getClass().getDeclaredField("mViews");
            declaredField.setAccessible(true);
            return Collections.unmodifiableList(Arrays.asList((View[]) declaredField.get(obj)));
        } catch (NoSuchFieldException e11) {
            throw new RuntimeException(e11);
        } catch (IllegalAccessException e12) {
            throw new RuntimeException(e12);
        }
    }

    public List<View> getRootViews() {
        return getWindowViews(getOuter((WindowManager) this.mContext.getSystemService("window")));
    }
}
