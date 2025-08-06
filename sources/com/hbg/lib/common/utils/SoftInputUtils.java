package com.hbg.lib.common.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ScrollView;
import i6.d;
import i6.o;
import i6.p;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SoftInputUtils {

    public interface a {
        void a(boolean z11, int i11);
    }

    public static void c(Activity activity, a aVar) {
        View decorView = activity.getWindow().getDecorView();
        decorView.getViewTreeObserver().addOnGlobalLayoutListener(new o(decorView, aVar));
    }

    public static void d(Activity activity, ScrollView scrollView) {
        e(activity, scrollView, 70);
    }

    public static void e(Activity activity, ScrollView scrollView, int i11) {
        c(activity, new p(scrollView, i11));
    }

    public static void f(Activity activity) {
        if (activity != null) {
            ((InputMethodManager) activity.getSystemService("input_method")).hideSoftInputFromWindow(activity.getWindow().getDecorView().getWindowToken(), 0);
        }
    }

    public static void g(Activity activity, View view) {
        if (activity != null) {
            ((InputMethodManager) activity.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public static boolean h(Activity activity) {
        if (activity != null) {
            return ((InputMethodManager) activity.getSystemService("input_method")).isActive();
        }
        return false;
    }

    public static boolean i(Activity activity, View view) {
        if (activity != null) {
            return ((InputMethodManager) activity.getSystemService("input_method")).isActive(view);
        }
        return false;
    }

    public static /* synthetic */ void j(View view, a aVar) {
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        int i11 = rect.bottom - rect.top;
        int height = view.getHeight();
        aVar.a(((double) i11) / ((double) height) < 0.8d, height - i11);
    }

    public static /* synthetic */ void k(ScrollView scrollView, int i11, boolean z11, int i12) {
        if (z11) {
            scrollView.smoothScrollTo(0, PixelUtils.a((float) i11));
        } else {
            scrollView.scrollTo(0, 0);
        }
    }

    public static boolean l(EditText editText, Context context) {
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
        boolean z11 = inputMethodManager.isActive() && inputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(), 0);
        int i11 = Build.VERSION.SDK_INT;
        String str = null;
        if (i11 >= 16) {
            str = "setShowSoftInputOnFocus";
        } else if (i11 >= 14) {
            str = "setSoftInputShownOnFocus";
        }
        if (str == null) {
            editText.setInputType(0);
        } else {
            try {
                Method method = EditText.class.getMethod(str, new Class[]{Boolean.TYPE});
                method.setAccessible(true);
                method.invoke(editText, new Object[]{Boolean.FALSE});
            } catch (NoSuchMethodException e11) {
                editText.setInputType(0);
                d.g(e11);
            } catch (IllegalAccessException e12) {
                d.g(e12);
            } catch (IllegalArgumentException e13) {
                d.g(e13);
            } catch (InvocationTargetException e14) {
                d.g(e14);
            }
        }
        return z11;
    }

    public static void m(Activity activity, View view) {
        if (activity != null && view != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
            if (view.requestFocus()) {
                inputMethodManager.showSoftInput(view, 1);
            }
        }
    }
}
