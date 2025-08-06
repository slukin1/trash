package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.View;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.i;
import androidx.core.view.f;
import androidx.core.view.h0;
import h.c;

public class h {

    /* renamed from: a  reason: collision with root package name */
    public final Context f4168a;

    /* renamed from: b  reason: collision with root package name */
    public final e f4169b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f4170c;

    /* renamed from: d  reason: collision with root package name */
    public final int f4171d;

    /* renamed from: e  reason: collision with root package name */
    public final int f4172e;

    /* renamed from: f  reason: collision with root package name */
    public View f4173f;

    /* renamed from: g  reason: collision with root package name */
    public int f4174g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f4175h;

    /* renamed from: i  reason: collision with root package name */
    public i.a f4176i;

    /* renamed from: j  reason: collision with root package name */
    public c f4177j;

    /* renamed from: k  reason: collision with root package name */
    public PopupWindow.OnDismissListener f4178k;

    /* renamed from: l  reason: collision with root package name */
    public final PopupWindow.OnDismissListener f4179l;

    public class a implements PopupWindow.OnDismissListener {
        public a() {
        }

        public void onDismiss() {
            h.this.e();
        }
    }

    public static class b {
        public static void a(Display display, Point point) {
            display.getRealSize(point);
        }
    }

    public h(Context context, e eVar, View view, boolean z11, int i11) {
        this(context, eVar, view, z11, i11, 0);
    }

    /* JADX WARNING: type inference failed for: r0v7, types: [androidx.appcompat.view.menu.i, h.c] */
    /* JADX WARNING: type inference failed for: r7v1, types: [androidx.appcompat.view.menu.k] */
    /* JADX WARNING: type inference failed for: r1v13, types: [androidx.appcompat.view.menu.b] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final h.c a() {
        /*
            r14 = this;
            android.content.Context r0 = r14.f4168a
            java.lang.String r1 = "window"
            java.lang.Object r0 = r0.getSystemService(r1)
            android.view.WindowManager r0 = (android.view.WindowManager) r0
            android.view.Display r0 = r0.getDefaultDisplay()
            android.graphics.Point r1 = new android.graphics.Point
            r1.<init>()
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 17
            if (r2 < r3) goto L_0x001d
            androidx.appcompat.view.menu.h.b.a(r0, r1)
            goto L_0x0020
        L_0x001d:
            r0.getSize(r1)
        L_0x0020:
            int r0 = r1.x
            int r1 = r1.y
            int r0 = java.lang.Math.min(r0, r1)
            android.content.Context r1 = r14.f4168a
            android.content.res.Resources r1 = r1.getResources()
            int r2 = androidx.appcompat.R$dimen.abc_cascading_menus_min_smallest_width
            int r1 = r1.getDimensionPixelSize(r2)
            if (r0 < r1) goto L_0x0038
            r0 = 1
            goto L_0x0039
        L_0x0038:
            r0 = 0
        L_0x0039:
            if (r0 == 0) goto L_0x004c
            androidx.appcompat.view.menu.b r0 = new androidx.appcompat.view.menu.b
            android.content.Context r2 = r14.f4168a
            android.view.View r3 = r14.f4173f
            int r4 = r14.f4171d
            int r5 = r14.f4172e
            boolean r6 = r14.f4170c
            r1 = r0
            r1.<init>(r2, r3, r4, r5, r6)
            goto L_0x005e
        L_0x004c:
            androidx.appcompat.view.menu.k r0 = new androidx.appcompat.view.menu.k
            android.content.Context r8 = r14.f4168a
            androidx.appcompat.view.menu.e r9 = r14.f4169b
            android.view.View r10 = r14.f4173f
            int r11 = r14.f4171d
            int r12 = r14.f4172e
            boolean r13 = r14.f4170c
            r7 = r0
            r7.<init>(r8, r9, r10, r11, r12, r13)
        L_0x005e:
            androidx.appcompat.view.menu.e r1 = r14.f4169b
            r0.a(r1)
            android.widget.PopupWindow$OnDismissListener r1 = r14.f4179l
            r0.k(r1)
            android.view.View r1 = r14.f4173f
            r0.e(r1)
            androidx.appcompat.view.menu.i$a r1 = r14.f4176i
            r0.setCallback(r1)
            boolean r1 = r14.f4175h
            r0.g(r1)
            int r1 = r14.f4174g
            r0.i(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.h.a():h.c");
    }

    public void b() {
        if (d()) {
            this.f4177j.dismiss();
        }
    }

    public c c() {
        if (this.f4177j == null) {
            this.f4177j = a();
        }
        return this.f4177j;
    }

    public boolean d() {
        c cVar = this.f4177j;
        return cVar != null && cVar.isShowing();
    }

    public void e() {
        this.f4177j = null;
        PopupWindow.OnDismissListener onDismissListener = this.f4178k;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public void f(View view) {
        this.f4173f = view;
    }

    public void g(boolean z11) {
        this.f4175h = z11;
        c cVar = this.f4177j;
        if (cVar != null) {
            cVar.g(z11);
        }
    }

    public void h(int i11) {
        this.f4174g = i11;
    }

    public void i(PopupWindow.OnDismissListener onDismissListener) {
        this.f4178k = onDismissListener;
    }

    public void j(i.a aVar) {
        this.f4176i = aVar;
        c cVar = this.f4177j;
        if (cVar != null) {
            cVar.setCallback(aVar);
        }
    }

    public void k() {
        if (!m()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public final void l(int i11, int i12, boolean z11, boolean z12) {
        c c11 = c();
        c11.l(z12);
        if (z11) {
            if ((f.b(this.f4174g, h0.F(this.f4173f)) & 7) == 5) {
                i11 -= this.f4173f.getWidth();
            }
            c11.j(i11);
            c11.m(i12);
            int i13 = (int) ((this.f4168a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            c11.f(new Rect(i11 - i13, i12 - i13, i11 + i13, i12 + i13));
        }
        c11.show();
    }

    public boolean m() {
        if (d()) {
            return true;
        }
        if (this.f4173f == null) {
            return false;
        }
        l(0, 0, false, false);
        return true;
    }

    public boolean n(int i11, int i12) {
        if (d()) {
            return true;
        }
        if (this.f4173f == null) {
            return false;
        }
        l(i11, i12, true, true);
        return true;
    }

    public h(Context context, e eVar, View view, boolean z11, int i11, int i12) {
        this.f4174g = 8388611;
        this.f4179l = new a();
        this.f4168a = context;
        this.f4169b = eVar;
        this.f4173f = view;
        this.f4170c = z11;
        this.f4171d = i11;
        this.f4172e = i12;
    }
}
