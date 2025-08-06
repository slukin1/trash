package com.blankj.utilcode.util;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static List<Field> f63538a;

    public static class a implements Runnable {
        public void run() {
            b.g();
        }
    }

    public static void b(Resources resources, float f11) {
        Objects.requireNonNull(resources, "Argument 'resources' of type Resources (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        resources.getDisplayMetrics().xdpi = f11;
        Utils.a().getResources().getDisplayMetrics().xdpi = f11;
        d(resources, f11);
    }

    public static void c(Resources resources, float f11) {
        for (Field field : f63538a) {
            try {
                DisplayMetrics displayMetrics = (DisplayMetrics) field.get(resources);
                if (displayMetrics != null) {
                    displayMetrics.xdpi = f11;
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    public static void d(Resources resources, float f11) {
        if (f63538a == null) {
            f63538a = new ArrayList();
            Class cls = resources.getClass();
            Field[] declaredFields = cls.getDeclaredFields();
            while (declaredFields != null && declaredFields.length > 0) {
                for (Field field : declaredFields) {
                    if (field.getType().isAssignableFrom(DisplayMetrics.class)) {
                        field.setAccessible(true);
                        DisplayMetrics e11 = e(resources, field);
                        if (e11 != null) {
                            f63538a.add(field);
                            e11.xdpi = f11;
                        }
                    }
                }
                cls = cls.getSuperclass();
                if (cls != null) {
                    declaredFields = cls.getDeclaredFields();
                } else {
                    return;
                }
            }
            return;
        }
        c(resources, f11);
    }

    public static DisplayMetrics e(Resources resources, Field field) {
        try {
            return (DisplayMetrics) field.get(resources);
        } catch (Exception unused) {
            return null;
        }
    }

    public static Runnable f() {
        return new a();
    }

    public static void g() {
        b(Resources.getSystem(), Resources.getSystem().getDisplayMetrics().xdpi);
    }
}
