package com.facebook.stetho.inspector.elements.android.window;

import android.view.View;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.List;

class WindowRootViewCompactV19Impl extends WindowRootViewCompat {
    private List<View> mRootViews;

    public WindowRootViewCompactV19Impl() {
        try {
            Class<?> cls = Class.forName("android.view.WindowManagerGlobal");
            Object invoke = cls.getDeclaredMethod("getInstance", new Class[0]).invoke(cls, new Object[0]);
            Field declaredField = cls.getDeclaredField("mViews");
            declaredField.setAccessible(true);
            this.mRootViews = (List) declaredField.get(invoke);
            declaredField.setAccessible(false);
        } catch (ClassNotFoundException e11) {
            throw new RuntimeException(e11);
        } catch (NoSuchMethodException e12) {
            throw new RuntimeException(e12);
        } catch (IllegalAccessException e13) {
            throw new RuntimeException(e13);
        } catch (InvocationTargetException e14) {
            throw new RuntimeException(e14);
        } catch (NoSuchFieldException e15) {
            throw new RuntimeException(e15);
        }
    }

    public List<View> getRootViews() {
        return Collections.unmodifiableList(this.mRootViews);
    }
}
