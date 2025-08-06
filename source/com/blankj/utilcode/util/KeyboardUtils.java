package com.blankj.utilcode.util;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import java.lang.reflect.Field;
import java.util.Objects;

public final class KeyboardUtils {

    /* renamed from: a  reason: collision with root package name */
    public static int f63305a;

    public static class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Window f63306b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int[] f63307c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ View f63308d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f63309e;

        public a(Window window, int[] iArr, View view, int i11) {
            this.f63306b = window;
            this.f63307c = iArr;
            this.f63308d = view;
            this.f63309e = i11;
        }

        public void onGlobalLayout() {
            int b11 = KeyboardUtils.g(this.f63306b);
            if (this.f63307c[0] != b11) {
                View view = this.f63308d;
                view.setPadding(view.getPaddingLeft(), this.f63308d.getPaddingTop(), this.f63308d.getPaddingRight(), this.f63309e + KeyboardUtils.h(this.f63306b));
                this.f63307c[0] = b11;
            }
        }
    }

    public static void c(Activity activity) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        d(activity.getWindow());
    }

    public static void d(Window window) {
        Objects.requireNonNull(window, "Argument 'window' of type Window (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        window.setSoftInputMode(window.getAttributes().softInputMode & -17);
        FrameLayout frameLayout = (FrameLayout) window.findViewById(16908290);
        View childAt = frameLayout.getChildAt(0);
        int paddingBottom = childAt.getPaddingBottom();
        frameLayout.getViewTreeObserver().addOnGlobalLayoutListener(new a(window, new int[]{g(window)}, childAt, paddingBottom));
    }

    public static void e(Activity activity) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        f(activity.getWindow());
    }

    public static void f(Window window) {
        Objects.requireNonNull(window, "Argument 'window' of type Window (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        InputMethodManager inputMethodManager = (InputMethodManager) Utils.a().getSystemService("input_method");
        if (inputMethodManager != null) {
            String[] strArr = {"mLastSrvView", "mCurRootView", "mServedView", "mNextServedView"};
            for (int i11 = 0; i11 < 4; i11++) {
                try {
                    Field declaredField = InputMethodManager.class.getDeclaredField(strArr[i11]);
                    if (!declaredField.isAccessible()) {
                        declaredField.setAccessible(true);
                    }
                    Object obj = declaredField.get(inputMethodManager);
                    if (obj instanceof View) {
                        if (((View) obj).getRootView() == window.getDecorView().getRootView()) {
                            declaredField.set(inputMethodManager, (Object) null);
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static int g(Window window) {
        View findViewById = window.findViewById(16908290);
        if (findViewById == null) {
            return 0;
        }
        Rect rect = new Rect();
        findViewById.getWindowVisibleDisplayFrame(rect);
        Log.d("KeyboardUtils", "getContentViewInvisibleHeight: " + (findViewById.getBottom() - rect.bottom));
        int abs = Math.abs(findViewById.getBottom() - rect.bottom);
        if (abs <= a0.r() + a0.o()) {
            return 0;
        }
        return abs;
    }

    public static int h(Window window) {
        Objects.requireNonNull(window, "Argument 'window' of type Window (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        View decorView = window.getDecorView();
        Rect rect = new Rect();
        decorView.getWindowVisibleDisplayFrame(rect);
        Log.d("KeyboardUtils", "getDecorViewInvisibleHeight: " + (decorView.getBottom() - rect.bottom));
        int abs = Math.abs(decorView.getBottom() - rect.bottom);
        if (abs > a0.o() + a0.r()) {
            return abs - f63305a;
        }
        f63305a = abs;
        return 0;
    }

    public static void i(Activity activity) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        k(activity.getWindow());
    }

    public static void j(View view) {
        Objects.requireNonNull(view, "Argument 'view' of type View (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        InputMethodManager inputMethodManager = (InputMethodManager) Utils.a().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public static void k(Window window) {
        Objects.requireNonNull(window, "Argument 'window' of type Window (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        View currentFocus = window.getCurrentFocus();
        if (currentFocus == null) {
            View decorView = window.getDecorView();
            View findViewWithTag = decorView.findViewWithTag("keyboardTagView");
            if (findViewWithTag == null) {
                findViewWithTag = new EditText(window.getContext());
                findViewWithTag.setTag("keyboardTagView");
                ((ViewGroup) decorView).addView(findViewWithTag, 0, 0);
            }
            currentFocus = findViewWithTag;
            currentFocus.requestFocus();
        }
        j(currentFocus);
    }

    public static boolean l(Activity activity) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return h(activity.getWindow()) > 0;
    }

    public static void m(View view) {
        Objects.requireNonNull(view, "Argument 'view' of type View (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        n(view, 0);
    }

    public static void n(View view, int i11) {
        Objects.requireNonNull(view, "Argument 'view' of type View (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        InputMethodManager inputMethodManager = (InputMethodManager) Utils.a().getSystemService("input_method");
        if (inputMethodManager != null) {
            view.setFocusable(true);
            view.setFocusableInTouchMode(true);
            view.requestFocus();
            inputMethodManager.showSoftInput(view, i11, new ResultReceiver(new Handler()) {
                public void onReceiveResult(int i11, Bundle bundle) {
                    if (i11 == 1 || i11 == 3) {
                        KeyboardUtils.o();
                    }
                }
            });
            inputMethodManager.toggleSoftInput(2, 1);
        }
    }

    public static void o() {
        InputMethodManager inputMethodManager = (InputMethodManager) Utils.a().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.toggleSoftInput(0, 0);
        }
    }
}
