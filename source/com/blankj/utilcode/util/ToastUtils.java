package com.blankj.utilcode.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.view.h0;
import com.blankj.utilcode.R$id;
import com.blankj.utilcode.R$layout;
import com.blankj.utilcode.util.Utils;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.Objects;
import p0.m;

public final class ToastUtils {

    /* renamed from: l  reason: collision with root package name */
    public static final ToastUtils f63492l = n();

    /* renamed from: m  reason: collision with root package name */
    public static WeakReference<e> f63493m;

    /* renamed from: a  reason: collision with root package name */
    public String f63494a;

    /* renamed from: b  reason: collision with root package name */
    public int f63495b = -1;

    /* renamed from: c  reason: collision with root package name */
    public int f63496c = -1;

    /* renamed from: d  reason: collision with root package name */
    public int f63497d = -1;

    /* renamed from: e  reason: collision with root package name */
    public int f63498e = -16777217;

    /* renamed from: f  reason: collision with root package name */
    public int f63499f = -1;

    /* renamed from: g  reason: collision with root package name */
    public int f63500g = -16777217;

    /* renamed from: h  reason: collision with root package name */
    public int f63501h = -1;

    /* renamed from: i  reason: collision with root package name */
    public boolean f63502i = false;

    /* renamed from: j  reason: collision with root package name */
    public Drawable[] f63503j = new Drawable[4];

    /* renamed from: k  reason: collision with root package name */
    public boolean f63504k = false;

    public static final class UtilsMaxWidthRelativeLayout extends RelativeLayout {

        /* renamed from: b  reason: collision with root package name */
        public static final int f63505b = a0.d(80.0f);

        public UtilsMaxWidthRelativeLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public void onMeasure(int i11, int i12) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(a0.h() - f63505b, Integer.MIN_VALUE), i12);
        }

        public UtilsMaxWidthRelativeLayout(Context context, AttributeSet attributeSet, int i11) {
            super(context, attributeSet, i11);
        }
    }

    public static class a implements Runnable {
        public void run() {
            if (ToastUtils.f63493m != null) {
                e eVar = (e) ToastUtils.f63493m.get();
                if (eVar != null) {
                    eVar.cancel();
                }
                WeakReference unused = ToastUtils.f63493m = null;
            }
        }
    }

    public static class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ToastUtils f63506b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ View f63507c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CharSequence f63508d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f63509e;

        public b(ToastUtils toastUtils, View view, CharSequence charSequence, int i11) {
            this.f63506b = toastUtils;
            this.f63507c = view;
            this.f63508d = charSequence;
            this.f63509e = i11;
        }

        public void run() {
            ToastUtils.l();
            e c11 = ToastUtils.o(this.f63506b);
            WeakReference unused = ToastUtils.f63493m = new WeakReference(c11);
            View view = this.f63507c;
            if (view != null) {
                c11.a(view);
            } else {
                c11.c(this.f63508d);
            }
            c11.b(this.f63509e);
        }
    }

    public static abstract class c implements e {

        /* renamed from: a  reason: collision with root package name */
        public Toast f63510a = new Toast(Utils.a());

        /* renamed from: b  reason: collision with root package name */
        public ToastUtils f63511b;

        /* renamed from: c  reason: collision with root package name */
        public View f63512c;

        public c(ToastUtils toastUtils) {
            this.f63511b = toastUtils;
            if (toastUtils.f63495b != -1 || this.f63511b.f63496c != -1 || this.f63511b.f63497d != -1) {
                this.f63510a.setGravity(this.f63511b.f63495b, this.f63511b.f63496c, this.f63511b.f63497d);
            }
        }

        public void a(View view) {
            this.f63512c = view;
            this.f63510a.setView(view);
        }

        public void c(CharSequence charSequence) {
            View i11 = this.f63511b.u(charSequence);
            if (i11 != null) {
                a(i11);
                e();
                return;
            }
            View view = this.f63510a.getView();
            this.f63512c = view;
            if (view == null || view.findViewById(16908299) == null) {
                a(a0.E(R$layout.utils_toast_view));
            }
            TextView textView = (TextView) this.f63512c.findViewById(16908299);
            textView.setText(charSequence);
            if (this.f63511b.f63500g != -16777217) {
                textView.setTextColor(this.f63511b.f63500g);
            }
            if (this.f63511b.f63501h != -1) {
                textView.setTextSize((float) this.f63511b.f63501h);
            }
            f(textView);
            e();
        }

        public void cancel() {
            Toast toast = this.f63510a;
            if (toast != null) {
                toast.cancel();
            }
            this.f63510a = null;
            this.f63512c = null;
        }

        public View d(int i11) {
            Bitmap L = a0.L(this.f63512c);
            ImageView imageView = new ImageView(Utils.a());
            imageView.setTag("TAG_TOAST" + i11);
            imageView.setImageBitmap(L);
            return imageView;
        }

        public final void e() {
            if (a0.A()) {
                a(d(-1));
            }
        }

        public final void f(TextView textView) {
            if (this.f63511b.f63499f != -1) {
                this.f63512c.setBackgroundResource(this.f63511b.f63499f);
                textView.setBackgroundColor(0);
            } else if (this.f63511b.f63498e != -16777217) {
                Drawable background = this.f63512c.getBackground();
                Drawable background2 = textView.getBackground();
                if (background != null && background2 != null) {
                    background.mutate().setColorFilter(new PorterDuffColorFilter(this.f63511b.f63498e, PorterDuff.Mode.SRC_IN));
                    textView.setBackgroundColor(0);
                } else if (background != null) {
                    background.mutate().setColorFilter(new PorterDuffColorFilter(this.f63511b.f63498e, PorterDuff.Mode.SRC_IN));
                } else if (background2 != null) {
                    background2.mutate().setColorFilter(new PorterDuffColorFilter(this.f63511b.f63498e, PorterDuff.Mode.SRC_IN));
                } else {
                    this.f63512c.setBackgroundColor(this.f63511b.f63498e);
                }
            }
        }
    }

    public static final class d extends c {

        /* renamed from: f  reason: collision with root package name */
        public static int f63513f;

        /* renamed from: d  reason: collision with root package name */
        public Utils.ActivityLifecycleCallbacks f63514d;

        /* renamed from: e  reason: collision with root package name */
        public e f63515e;

        public class a implements Runnable {
            public a() {
            }

            public void run() {
                d.this.cancel();
            }
        }

        public class b extends Utils.ActivityLifecycleCallbacks {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ int f63517a;

            public b(int i11) {
                this.f63517a = i11;
            }

            public void a(Activity activity) {
                Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
                if (d.this.i()) {
                    d.this.l(activity, this.f63517a, false);
                }
            }
        }

        public d(ToastUtils toastUtils) {
            super(toastUtils);
        }

        public void b(int i11) {
            if (this.f63510a != null) {
                if (!a0.w()) {
                    this.f63515e = k(i11);
                    return;
                }
                boolean z11 = false;
                for (Activity next : a0.g()) {
                    if (a0.v(next)) {
                        if (!z11) {
                            this.f63515e = m(next, i11);
                            z11 = true;
                        } else {
                            l(next, f63513f, true);
                        }
                    }
                }
                if (z11) {
                    j();
                    a0.J(new a(), i11 == 0 ? 2000 : 3500);
                    f63513f++;
                    return;
                }
                this.f63515e = k(i11);
            }
        }

        public void cancel() {
            Window window;
            if (i()) {
                n();
                for (Activity next : a0.g()) {
                    if (a0.v(next) && (window = next.getWindow()) != null) {
                        ViewGroup viewGroup = (ViewGroup) window.getDecorView();
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("TAG_TOAST");
                        sb2.append(f63513f - 1);
                        View findViewWithTag = viewGroup.findViewWithTag(sb2.toString());
                        if (findViewWithTag != null) {
                            try {
                                viewGroup.removeView(findViewWithTag);
                            } catch (Exception unused) {
                            }
                        }
                    }
                }
            }
            e eVar = this.f63515e;
            if (eVar != null) {
                eVar.cancel();
                this.f63515e = null;
            }
            super.cancel();
        }

        public final boolean i() {
            return this.f63514d != null;
        }

        public final void j() {
            b bVar = new b(f63513f);
            this.f63514d = bVar;
            a0.a(bVar);
        }

        public final e k(int i11) {
            f fVar = new f(this.f63511b);
            fVar.f63510a = this.f63510a;
            fVar.b(i11);
            return fVar;
        }

        public final void l(Activity activity, int i11, boolean z11) {
            Window window = activity.getWindow();
            if (window != null) {
                ViewGroup viewGroup = (ViewGroup) window.getDecorView();
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = this.f63510a.getGravity();
                layoutParams.bottomMargin = this.f63510a.getYOffset() + a0.o();
                layoutParams.topMargin = this.f63510a.getYOffset() + a0.r();
                layoutParams.leftMargin = this.f63510a.getXOffset();
                View d11 = d(i11);
                if (z11) {
                    d11.setAlpha(0.0f);
                    d11.animate().alpha(1.0f).setDuration(200).start();
                }
                viewGroup.addView(d11, layoutParams);
            }
        }

        public final e m(Activity activity, int i11) {
            g gVar = new g(this.f63511b, activity.getWindowManager(), 99);
            gVar.f63512c = d(-1);
            gVar.f63510a = this.f63510a;
            gVar.b(i11);
            return gVar;
        }

        public final void n() {
            a0.H(this.f63514d);
            this.f63514d = null;
        }
    }

    public interface e {
        void a(View view);

        void b(int i11);

        void c(CharSequence charSequence);

        void cancel();
    }

    public static final class f extends c {

        public static class a extends Handler {

            /* renamed from: a  reason: collision with root package name */
            public Handler f63519a;

            public a(Handler handler) {
                this.f63519a = handler;
            }

            public void dispatchMessage(Message message) {
                Objects.requireNonNull(message, "Argument 'msg' of type Message (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
                try {
                    this.f63519a.dispatchMessage(message);
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
            }

            public void handleMessage(Message message) {
                Objects.requireNonNull(message, "Argument 'msg' of type Message (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
                this.f63519a.handleMessage(message);
            }
        }

        public f(ToastUtils toastUtils) {
            super(toastUtils);
            if (Build.VERSION.SDK_INT == 25) {
                try {
                    Field declaredField = Toast.class.getDeclaredField("mTN");
                    declaredField.setAccessible(true);
                    Object obj = declaredField.get(this.f63510a);
                    Field declaredField2 = declaredField.getType().getDeclaredField("mHandler");
                    declaredField2.setAccessible(true);
                    declaredField2.set(obj, new a((Handler) declaredField2.get(obj)));
                } catch (Exception unused) {
                }
            }
        }

        public void b(int i11) {
            Toast toast = this.f63510a;
            if (toast != null) {
                toast.setDuration(i11);
                this.f63510a.show();
            }
        }
    }

    public static void l() {
        a0.I(new a());
    }

    public static CharSequence m(CharSequence charSequence) {
        if (charSequence == null) {
            return "toast null";
        }
        return charSequence.length() == 0 ? "toast nothing" : charSequence;
    }

    public static ToastUtils n() {
        return new ToastUtils();
    }

    public static e o(ToastUtils toastUtils) {
        if (!toastUtils.f63504k && m.d(Utils.a()).a()) {
            if (Build.VERSION.SDK_INT < 23) {
                return new f(toastUtils);
            }
            if (!a0.y()) {
                return new f(toastUtils);
            }
        }
        int i11 = Build.VERSION.SDK_INT;
        if (i11 < 25) {
            return new g(toastUtils, 2005);
        }
        if (!a0.y()) {
            return new d(toastUtils);
        }
        if (i11 >= 26) {
            return new g(toastUtils, 2038);
        }
        return new g(toastUtils, 2002);
    }

    public static void p(View view, CharSequence charSequence, int i11, ToastUtils toastUtils) {
        Objects.requireNonNull(toastUtils, "Argument 'utils' of type ToastUtils (#3 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        a0.I(new b(toastUtils, view, charSequence, i11));
    }

    public static void q(CharSequence charSequence, int i11, ToastUtils toastUtils) {
        p((View) null, m(charSequence), i11, toastUtils);
    }

    public static void r(int i11) {
        q(a0.s(i11), 1, f63492l);
    }

    public static void s(CharSequence charSequence) {
        q(charSequence, 1, f63492l);
    }

    public static void t(CharSequence charSequence) {
        q(charSequence, 0, f63492l);
    }

    public final View u(CharSequence charSequence) {
        if (!"dark".equals(this.f63494a) && !"light".equals(this.f63494a)) {
            Drawable[] drawableArr = this.f63503j;
            if (drawableArr[0] == null && drawableArr[1] == null && drawableArr[2] == null && drawableArr[3] == null) {
                return null;
            }
        }
        View E = a0.E(R$layout.utils_toast_view);
        TextView textView = (TextView) E.findViewById(16908299);
        if ("dark".equals(this.f63494a)) {
            ((GradientDrawable) E.getBackground().mutate()).setColor(Color.parseColor("#BB000000"));
            textView.setTextColor(-1);
        }
        textView.setText(charSequence);
        if (this.f63503j[0] != null) {
            View findViewById = E.findViewById(R$id.utvLeftIconView);
            h0.B0(findViewById, this.f63503j[0]);
            findViewById.setVisibility(0);
        }
        if (this.f63503j[1] != null) {
            View findViewById2 = E.findViewById(R$id.utvTopIconView);
            h0.B0(findViewById2, this.f63503j[1]);
            findViewById2.setVisibility(0);
        }
        if (this.f63503j[2] != null) {
            View findViewById3 = E.findViewById(R$id.utvRightIconView);
            h0.B0(findViewById3, this.f63503j[2]);
            findViewById3.setVisibility(0);
        }
        if (this.f63503j[3] != null) {
            View findViewById4 = E.findViewById(R$id.utvBottomIconView);
            h0.B0(findViewById4, this.f63503j[3]);
            findViewById4.setVisibility(0);
        }
        return E;
    }

    public static final class g extends c {

        /* renamed from: d  reason: collision with root package name */
        public WindowManager f63520d;

        /* renamed from: e  reason: collision with root package name */
        public WindowManager.LayoutParams f63521e;

        public class a implements Runnable {
            public a() {
            }

            public void run() {
                g.this.cancel();
            }
        }

        public g(ToastUtils toastUtils, int i11) {
            super(toastUtils);
            this.f63521e = new WindowManager.LayoutParams();
            this.f63520d = (WindowManager) Utils.a().getSystemService("window");
            this.f63521e.type = i11;
        }

        public void b(int i11) {
            if (this.f63510a != null) {
                WindowManager.LayoutParams layoutParams = this.f63521e;
                layoutParams.height = -2;
                layoutParams.width = -2;
                layoutParams.format = -3;
                layoutParams.windowAnimations = 16973828;
                layoutParams.setTitle("ToastWithoutNotification");
                WindowManager.LayoutParams layoutParams2 = this.f63521e;
                layoutParams2.flags = 152;
                layoutParams2.packageName = Utils.a().getPackageName();
                this.f63521e.gravity = this.f63510a.getGravity();
                WindowManager.LayoutParams layoutParams3 = this.f63521e;
                int i12 = layoutParams3.gravity;
                if ((i12 & 7) == 7) {
                    layoutParams3.horizontalWeight = 1.0f;
                }
                if ((i12 & 112) == 112) {
                    layoutParams3.verticalWeight = 1.0f;
                }
                layoutParams3.x = this.f63510a.getXOffset();
                this.f63521e.y = this.f63510a.getYOffset();
                this.f63521e.horizontalMargin = this.f63510a.getHorizontalMargin();
                this.f63521e.verticalMargin = this.f63510a.getVerticalMargin();
                try {
                    WindowManager windowManager = this.f63520d;
                    if (windowManager != null) {
                        windowManager.addView(this.f63512c, this.f63521e);
                    }
                } catch (Exception unused) {
                }
                a0.J(new a(), i11 == 0 ? 2000 : 3500);
            }
        }

        public void cancel() {
            try {
                WindowManager windowManager = this.f63520d;
                if (windowManager != null) {
                    windowManager.removeViewImmediate(this.f63512c);
                    this.f63520d = null;
                }
            } catch (Exception unused) {
            }
            super.cancel();
        }

        public g(ToastUtils toastUtils, WindowManager windowManager, int i11) {
            super(toastUtils);
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            this.f63521e = layoutParams;
            this.f63520d = windowManager;
            layoutParams.type = i11;
        }
    }
}
