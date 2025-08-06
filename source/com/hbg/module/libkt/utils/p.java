package com.hbg.module.libkt.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import java.lang.reflect.Method;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

public final class p {

    /* renamed from: h  reason: collision with root package name */
    public static final a f24913h = new a((r) null);

    /* renamed from: a  reason: collision with root package name */
    public String f24914a;

    /* renamed from: b  reason: collision with root package name */
    public b f24915b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f24916c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f24917d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f24918e;

    /* renamed from: f  reason: collision with root package name */
    public View f24919f;

    /* renamed from: g  reason: collision with root package name */
    public View f24920g;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }
    }

    public final class b {

        /* renamed from: a  reason: collision with root package name */
        public final String f24921a = "status_bar_height";

        /* renamed from: b  reason: collision with root package name */
        public final String f24922b = "navigation_bar_height";

        /* renamed from: c  reason: collision with root package name */
        public final String f24923c = "navigation_bar_height_landscape";

        /* renamed from: d  reason: collision with root package name */
        public final String f24924d = "navigation_bar_width";

        /* renamed from: e  reason: collision with root package name */
        public final String f24925e = "config_showNavigationBar";

        /* renamed from: f  reason: collision with root package name */
        public final boolean f24926f;

        /* renamed from: g  reason: collision with root package name */
        public final boolean f24927g;

        /* renamed from: h  reason: collision with root package name */
        public final int f24928h;

        /* renamed from: i  reason: collision with root package name */
        public final int f24929i;

        /* renamed from: j  reason: collision with root package name */
        public final boolean f24930j;

        /* renamed from: k  reason: collision with root package name */
        public final int f24931k;

        /* renamed from: l  reason: collision with root package name */
        public final int f24932l;

        /* renamed from: m  reason: collision with root package name */
        public final boolean f24933m;

        /* renamed from: n  reason: collision with root package name */
        public final float f24934n;

        public b(FragmentActivity fragmentActivity, boolean z11, boolean z12) {
            Resources resources = fragmentActivity.getResources();
            boolean z13 = false;
            this.f24933m = resources.getConfiguration().orientation == 1;
            this.f24934n = g(fragmentActivity);
            this.f24928h = b(resources, "status_bar_height");
            this.f24929i = a(fragmentActivity);
            int d11 = d(fragmentActivity);
            this.f24931k = d11;
            this.f24932l = f(fragmentActivity);
            this.f24930j = d11 > 0 ? true : z13;
            this.f24926f = z11;
            this.f24927g = z12;
        }

        public final int a(Context context) {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(16843499, typedValue, true);
            return TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics());
        }

        public final int b(Resources resources, String str) {
            int identifier = resources.getIdentifier(str, "dimen", "android");
            if (identifier > 0) {
                return resources.getDimensionPixelSize(identifier);
            }
            return 0;
        }

        public final int c() {
            return this.f24931k;
        }

        public final int d(Context context) {
            String str;
            Resources resources = context.getResources();
            if (!i(context)) {
                return 0;
            }
            if (this.f24933m) {
                str = this.f24922b;
            } else {
                str = this.f24923c;
            }
            return b(resources, str);
        }

        public final int e() {
            return this.f24932l;
        }

        public final int f(Context context) {
            Resources resources = context.getResources();
            if (i(context)) {
                return b(resources, this.f24924d);
            }
            return 0;
        }

        public final float g(FragmentActivity fragmentActivity) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            fragmentActivity.getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
            float f11 = displayMetrics.density;
            return Math.min(((float) displayMetrics.widthPixels) / f11, ((float) displayMetrics.heightPixels) / f11);
        }

        public final int h() {
            return this.f24928h;
        }

        public final boolean i(Context context) {
            Resources resources = context.getResources();
            int identifier = resources.getIdentifier(this.f24925e, "bool", "android");
            if (identifier != 0) {
                boolean z11 = resources.getBoolean(identifier);
                if (!x.b("1", p.this.f24914a)) {
                    if (x.b("0", p.this.f24914a)) {
                        return true;
                    }
                    return z11;
                }
            } else if (!ViewConfiguration.get(context).hasPermanentMenuKey()) {
                return true;
            }
            return false;
        }

        public final boolean j() {
            return this.f24930j;
        }

        public final boolean k() {
            return this.f24934n >= 600.0f || this.f24933m;
        }
    }

    /* JADX INFO: finally extract failed */
    @SuppressLint({"ResourceType"})
    public p(FragmentActivity fragmentActivity) {
        Window window = fragmentActivity.getWindow();
        ViewGroup viewGroup = (ViewGroup) window.getDecorView();
        String str = null;
        try {
            Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", new Class[]{String.class});
            declaredMethod.setAccessible(true);
            str = (String) declaredMethod.invoke((Object) null, new Object[]{"qemu.hw.mainkeys"});
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        this.f24914a = str;
        TypedArray obtainStyledAttributes = fragmentActivity.obtainStyledAttributes(new int[]{16843759, 16843760});
        try {
            this.f24916c = obtainStyledAttributes.getBoolean(0, false);
            this.f24917d = obtainStyledAttributes.getBoolean(1, false);
            obtainStyledAttributes.recycle();
            int i11 = window.getAttributes().flags;
            if ((67108864 & i11) != 0) {
                this.f24916c = true;
            }
            if ((i11 & 134217728) != 0) {
                this.f24917d = true;
            }
            b bVar = new b(fragmentActivity, this.f24916c, this.f24917d);
            this.f24915b = bVar;
            if (!bVar.j()) {
                this.f24917d = false;
            }
            if (this.f24916c) {
                e(fragmentActivity, viewGroup);
            }
            if (this.f24917d) {
                d(fragmentActivity, viewGroup);
            }
        } catch (Throwable th3) {
            obtainStyledAttributes.recycle();
            throw th3;
        }
    }

    public final void b(int i11) {
        View view;
        if (this.f24916c && (view = this.f24919f) != null) {
            view.setBackgroundColor(i11);
        }
    }

    public final void c(boolean z11) {
        View view;
        this.f24918e = z11;
        if (this.f24916c && (view = this.f24919f) != null) {
            view.setVisibility(z11 ? 0 : 8);
        }
    }

    public final void d(Context context, ViewGroup viewGroup) {
        FrameLayout.LayoutParams layoutParams;
        this.f24920g = new View(context);
        if (this.f24915b.k()) {
            layoutParams = new FrameLayout.LayoutParams(-1, this.f24915b.c());
            layoutParams.gravity = 80;
        } else {
            layoutParams = new FrameLayout.LayoutParams(this.f24915b.e(), -1);
            layoutParams.gravity = 8388613;
        }
        View view = this.f24920g;
        if (view != null) {
            view.setLayoutParams(layoutParams);
        }
        View view2 = this.f24920g;
        if (view2 != null) {
            view2.setBackgroundColor(-1728053248);
        }
        View view3 = this.f24920g;
        if (view3 != null) {
            view3.setVisibility(8);
        }
        viewGroup.addView(this.f24920g);
    }

    public final void e(Context context, ViewGroup viewGroup) {
        this.f24919f = new View(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, this.f24915b.h());
        layoutParams.gravity = 48;
        if (this.f24917d && !this.f24915b.k()) {
            layoutParams.rightMargin = this.f24915b.e();
        }
        View view = this.f24919f;
        if (view != null) {
            view.setLayoutParams(layoutParams);
        }
        View view2 = this.f24919f;
        if (view2 != null) {
            view2.setBackgroundColor(-1728053248);
        }
        View view3 = this.f24919f;
        if (view3 != null) {
            view3.setVisibility(8);
        }
        viewGroup.addView(this.f24919f);
    }
}
