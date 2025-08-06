package androidx.core.view;

import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.inputmethod.InputMethodManager;
import java.util.concurrent.atomic.AtomicBoolean;

public final class c0 {

    /* renamed from: a  reason: collision with root package name */
    public final c f8583a;

    public static class a extends c {

        /* renamed from: a  reason: collision with root package name */
        public final View f8584a;

        public a(View view) {
            this.f8584a = view;
        }

        public void a() {
            View view = this.f8584a;
            if (view != null) {
                ((InputMethodManager) view.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.f8584a.getWindowToken(), 0);
            }
        }

        public void b() {
            View view = this.f8584a;
            if (view != null) {
                if (view.isInEditMode() || view.onCheckIsTextEditor()) {
                    view.requestFocus();
                } else {
                    view = view.getRootView().findFocus();
                }
                if (view == null) {
                    view = this.f8584a.getRootView().findViewById(16908290);
                }
                if (view != null && view.hasWindowFocus()) {
                    view.post(new b0(view));
                }
            }
        }
    }

    public static class b extends a {

        /* renamed from: b  reason: collision with root package name */
        public View f8585b;

        /* renamed from: c  reason: collision with root package name */
        public WindowInsetsController f8586c;

        public b(View view) {
            super(view);
            this.f8585b = view;
        }

        public static /* synthetic */ void f(AtomicBoolean atomicBoolean, WindowInsetsController windowInsetsController, int i11) {
            atomicBoolean.set((i11 & 8) != 0);
        }

        public void a() {
            View view;
            WindowInsetsController windowInsetsController = this.f8586c;
            if (windowInsetsController == null) {
                View view2 = this.f8585b;
                windowInsetsController = view2 != null ? view2.getWindowInsetsController() : null;
            }
            if (windowInsetsController != null) {
                AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                d0 d0Var = new d0(atomicBoolean);
                windowInsetsController.addOnControllableInsetsChangedListener(d0Var);
                if (!atomicBoolean.get() && (view = this.f8585b) != null) {
                    ((InputMethodManager) view.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.f8585b.getWindowToken(), 0);
                }
                windowInsetsController.removeOnControllableInsetsChangedListener(d0Var);
                windowInsetsController.hide(WindowInsets.Type.ime());
                return;
            }
            super.a();
        }

        public void b() {
            View view = this.f8585b;
            if (view != null && Build.VERSION.SDK_INT < 33) {
                ((InputMethodManager) view.getContext().getSystemService("input_method")).isActive();
            }
            WindowInsetsController windowInsetsController = null;
            WindowInsetsController windowInsetsController2 = this.f8586c;
            if (windowInsetsController2 != null) {
                windowInsetsController = windowInsetsController2;
            } else {
                View view2 = this.f8585b;
                if (view2 != null) {
                    windowInsetsController = view2.getWindowInsetsController();
                }
            }
            if (windowInsetsController != null) {
                windowInsetsController.show(WindowInsets.Type.ime());
            } else {
                super.b();
            }
        }
    }

    public static class c {
        public void a() {
        }

        public void b() {
        }
    }

    public c0(View view) {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 30) {
            this.f8583a = new b(view);
        } else if (i11 >= 20) {
            this.f8583a = new a(view);
        } else {
            this.f8583a = new c();
        }
    }

    public void a() {
        this.f8583a.a();
    }

    public void b() {
        this.f8583a.b();
    }
}
