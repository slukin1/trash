package com.hbg.module.libkt.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.fragment.app.FragmentActivity;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class o {

    /* renamed from: a  reason: collision with root package name */
    public static final o f24912a = new o();

    public final int a(Context context, String str) {
        return context.getResources().getDimensionPixelSize(context.getResources().getIdentifier(str, "dimen", "android"));
    }

    public final int b(Activity activity) {
        return a(activity, "status_bar_height");
    }

    public final void c(Activity activity, View view, boolean z11) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (z11) {
            layoutParams.height = 0;
        } else {
            layoutParams.height = b(activity);
        }
        view.setLayoutParams(layoutParams);
    }

    public final void d(Activity activity, View view) {
        int paddingStart = view.getPaddingStart();
        int paddingEnd = view.getPaddingEnd();
        int paddingBottom = view.getPaddingBottom();
        int b11 = b(activity);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height += b11;
        view.setLayoutParams(layoutParams);
        view.setPaddingRelative(paddingStart, b11, paddingEnd, paddingBottom);
    }

    public final boolean e(Activity activity, boolean z11) {
        if (Build.VERSION.SDK_INT < 23) {
            return false;
        }
        View decorView = activity.getWindow().getDecorView();
        int systemUiVisibility = decorView.getSystemUiVisibility();
        int i11 = z11 ? systemUiVisibility | 8192 : systemUiVisibility & -8193;
        if (decorView.getSystemUiVisibility() == i11) {
            return true;
        }
        decorView.setSystemUiVisibility(i11);
        return true;
    }

    public final boolean f(Activity activity, boolean z11) {
        try {
            Window window = activity.getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            Field declaredField = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
            Field declaredField2 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
            declaredField.setAccessible(true);
            declaredField2.setAccessible(true);
            int i11 = declaredField.getInt((Object) null);
            int i12 = declaredField2.getInt(attributes);
            declaredField2.setInt(attributes, z11 ? i12 | i11 : (~i11) & i12);
            window.setAttributes(attributes);
            return true;
        } catch (Exception e11) {
            e11.printStackTrace();
            return false;
        }
    }

    public final boolean g(Activity activity, boolean z11) {
        try {
            Window window = activity.getWindow();
            Class<?> cls = activity.getWindow().getClass();
            Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
            int i11 = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
            Class cls3 = Integer.TYPE;
            Method declaredMethod = cls.getDeclaredMethod("setExtraFlags", new Class[]{cls3, cls3});
            declaredMethod.setAccessible(true);
            if (z11) {
                declaredMethod.invoke(window, new Object[]{Integer.valueOf(i11), Integer.valueOf(i11)});
                return true;
            }
            declaredMethod.invoke(window, new Object[]{0, Integer.valueOf(i11)});
            return true;
        } catch (Exception e11) {
            e11.printStackTrace();
            return false;
        }
    }

    public final void h(Activity activity, boolean z11) {
        View childAt;
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(16908290);
        if (viewGroup.getChildCount() > 0 && (childAt = viewGroup.getChildAt(0)) != null) {
            childAt.setFitsSystemWindows(z11);
        }
    }

    public final void i(FragmentActivity fragmentActivity, int i11) {
        if (Build.VERSION.SDK_INT >= 21) {
            fragmentActivity.getWindow().setStatusBarColor(i11);
            return;
        }
        l(fragmentActivity);
        p pVar = new p(fragmentActivity);
        pVar.c(true);
        pVar.b(i11);
    }

    public final boolean j(Activity activity, boolean z11) {
        if (Build.VERSION.SDK_INT >= 23) {
            k(activity, 3, z11);
        } else if (n.d()) {
            k(activity, 0, z11);
        } else if (!n.c()) {
            return false;
        } else {
            k(activity, 1, z11);
        }
        return true;
    }

    public final boolean k(Activity activity, int i11, boolean z11) {
        if (i11 == 0) {
            return g(activity, z11);
        }
        if (i11 == 1) {
            return f(activity, z11);
        }
        if (i11 != 3) {
            return e(activity, z11);
        }
        return e(activity, z11);
    }

    public final void l(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = activity.getWindow();
            window.getDecorView().setSystemUiVisibility(1280);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(0);
            return;
        }
        Window window2 = activity.getWindow();
        WindowManager.LayoutParams attributes = window2.getAttributes();
        attributes.flags = 67108864 | attributes.flags;
        window2.setAttributes(attributes);
    }
}
