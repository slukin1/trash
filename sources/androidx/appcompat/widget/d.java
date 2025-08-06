package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.widget.CheckedTextView;
import androidx.core.widget.c;
import u0.a;

public class d {

    /* renamed from: a  reason: collision with root package name */
    public final CheckedTextView f4549a;

    /* renamed from: b  reason: collision with root package name */
    public ColorStateList f4550b = null;

    /* renamed from: c  reason: collision with root package name */
    public PorterDuff.Mode f4551c = null;

    /* renamed from: d  reason: collision with root package name */
    public boolean f4552d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f4553e = false;

    /* renamed from: f  reason: collision with root package name */
    public boolean f4554f;

    public d(CheckedTextView checkedTextView) {
        this.f4549a = checkedTextView;
    }

    public void a() {
        Drawable a11 = c.a(this.f4549a);
        if (a11 == null) {
            return;
        }
        if (this.f4552d || this.f4553e) {
            Drawable mutate = a.r(a11).mutate();
            if (this.f4552d) {
                a.o(mutate, this.f4550b);
            }
            if (this.f4553e) {
                a.p(mutate, this.f4551c);
            }
            if (mutate.isStateful()) {
                mutate.setState(this.f4549a.getDrawableState());
            }
            this.f4549a.setCheckMarkDrawable(mutate);
        }
    }

    public ColorStateList b() {
        return this.f4550b;
    }

    public PorterDuff.Mode c() {
        return this.f4551c;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003d A[SYNTHETIC, Splitter:B:12:0x003d] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0060 A[Catch:{ all -> 0x0084 }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0071 A[Catch:{ all -> 0x0084 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void d(android.util.AttributeSet r10, int r11) {
        /*
            r9 = this;
            android.widget.CheckedTextView r0 = r9.f4549a
            android.content.Context r0 = r0.getContext()
            int[] r3 = androidx.appcompat.R$styleable.CheckedTextView
            r8 = 0
            androidx.appcompat.widget.d0 r0 = androidx.appcompat.widget.d0.v(r0, r10, r3, r11, r8)
            android.widget.CheckedTextView r1 = r9.f4549a
            android.content.Context r2 = r1.getContext()
            android.content.res.TypedArray r5 = r0.r()
            r7 = 0
            r4 = r10
            r6 = r11
            androidx.core.view.h0.v0(r1, r2, r3, r4, r5, r6, r7)
            int r10 = androidx.appcompat.R$styleable.CheckedTextView_checkMarkCompat     // Catch:{ all -> 0x0084 }
            boolean r11 = r0.s(r10)     // Catch:{ all -> 0x0084 }
            if (r11 == 0) goto L_0x003a
            int r10 = r0.n(r10, r8)     // Catch:{ all -> 0x0084 }
            if (r10 == 0) goto L_0x003a
            android.widget.CheckedTextView r11 = r9.f4549a     // Catch:{ NotFoundException -> 0x003a }
            android.content.Context r1 = r11.getContext()     // Catch:{ NotFoundException -> 0x003a }
            android.graphics.drawable.Drawable r10 = c.a.b(r1, r10)     // Catch:{ NotFoundException -> 0x003a }
            r11.setCheckMarkDrawable(r10)     // Catch:{ NotFoundException -> 0x003a }
            r10 = 1
            goto L_0x003b
        L_0x003a:
            r10 = r8
        L_0x003b:
            if (r10 != 0) goto L_0x0058
            int r10 = androidx.appcompat.R$styleable.CheckedTextView_android_checkMark     // Catch:{ all -> 0x0084 }
            boolean r11 = r0.s(r10)     // Catch:{ all -> 0x0084 }
            if (r11 == 0) goto L_0x0058
            int r10 = r0.n(r10, r8)     // Catch:{ all -> 0x0084 }
            if (r10 == 0) goto L_0x0058
            android.widget.CheckedTextView r11 = r9.f4549a     // Catch:{ all -> 0x0084 }
            android.content.Context r1 = r11.getContext()     // Catch:{ all -> 0x0084 }
            android.graphics.drawable.Drawable r10 = c.a.b(r1, r10)     // Catch:{ all -> 0x0084 }
            r11.setCheckMarkDrawable(r10)     // Catch:{ all -> 0x0084 }
        L_0x0058:
            int r10 = androidx.appcompat.R$styleable.CheckedTextView_checkMarkTint     // Catch:{ all -> 0x0084 }
            boolean r11 = r0.s(r10)     // Catch:{ all -> 0x0084 }
            if (r11 == 0) goto L_0x0069
            android.widget.CheckedTextView r11 = r9.f4549a     // Catch:{ all -> 0x0084 }
            android.content.res.ColorStateList r10 = r0.c(r10)     // Catch:{ all -> 0x0084 }
            androidx.core.widget.c.b(r11, r10)     // Catch:{ all -> 0x0084 }
        L_0x0069:
            int r10 = androidx.appcompat.R$styleable.CheckedTextView_checkMarkTintMode     // Catch:{ all -> 0x0084 }
            boolean r11 = r0.s(r10)     // Catch:{ all -> 0x0084 }
            if (r11 == 0) goto L_0x0080
            android.widget.CheckedTextView r11 = r9.f4549a     // Catch:{ all -> 0x0084 }
            r1 = -1
            int r10 = r0.k(r10, r1)     // Catch:{ all -> 0x0084 }
            r1 = 0
            android.graphics.PorterDuff$Mode r10 = androidx.appcompat.widget.r.e(r10, r1)     // Catch:{ all -> 0x0084 }
            androidx.core.widget.c.c(r11, r10)     // Catch:{ all -> 0x0084 }
        L_0x0080:
            r0.w()
            return
        L_0x0084:
            r10 = move-exception
            r0.w()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.d.d(android.util.AttributeSet, int):void");
    }

    public void e() {
        if (this.f4554f) {
            this.f4554f = false;
            return;
        }
        this.f4554f = true;
        a();
    }

    public void f(ColorStateList colorStateList) {
        this.f4550b = colorStateList;
        this.f4552d = true;
        a();
    }

    public void g(PorterDuff.Mode mode) {
        this.f4551c = mode;
        this.f4553e = true;
        a();
    }
}
