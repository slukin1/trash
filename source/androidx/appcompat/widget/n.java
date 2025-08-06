package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.LocaleList;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import androidx.appcompat.R$styleable;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.h0;
import androidx.core.view.inputmethod.EditorInfoCompat;
import java.lang.ref.WeakReference;
import java.util.Locale;

public class n {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f4631a;

    /* renamed from: b  reason: collision with root package name */
    public TintInfo f4632b;

    /* renamed from: c  reason: collision with root package name */
    public TintInfo f4633c;

    /* renamed from: d  reason: collision with root package name */
    public TintInfo f4634d;

    /* renamed from: e  reason: collision with root package name */
    public TintInfo f4635e;

    /* renamed from: f  reason: collision with root package name */
    public TintInfo f4636f;

    /* renamed from: g  reason: collision with root package name */
    public TintInfo f4637g;

    /* renamed from: h  reason: collision with root package name */
    public TintInfo f4638h;

    /* renamed from: i  reason: collision with root package name */
    public final o f4639i;

    /* renamed from: j  reason: collision with root package name */
    public int f4640j = 0;

    /* renamed from: k  reason: collision with root package name */
    public int f4641k = -1;

    /* renamed from: l  reason: collision with root package name */
    public Typeface f4642l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f4643m;

    public class a extends ResourcesCompat.FontCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f4644a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f4645b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ WeakReference f4646c;

        public a(int i11, int i12, WeakReference weakReference) {
            this.f4644a = i11;
            this.f4645b = i12;
            this.f4646c = weakReference;
        }

        public void onFontRetrievalFailed(int i11) {
        }

        public void onFontRetrieved(Typeface typeface) {
            int i11;
            if (Build.VERSION.SDK_INT >= 28 && (i11 = this.f4644a) != -1) {
                typeface = g.a(typeface, i11, (this.f4645b & 2) != 0);
            }
            n.this.n(this.f4646c, typeface);
        }
    }

    public class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TextView f4648b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Typeface f4649c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f4650d;

        public b(TextView textView, Typeface typeface, int i11) {
            this.f4648b = textView;
            this.f4649c = typeface;
            this.f4650d = i11;
        }

        public void run() {
            this.f4648b.setTypeface(this.f4649c, this.f4650d);
        }
    }

    public static class c {
        public static Drawable[] a(TextView textView) {
            return textView.getCompoundDrawablesRelative();
        }

        public static void b(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        }

        public static void c(TextView textView, Locale locale) {
            textView.setTextLocale(locale);
        }
    }

    public static class d {
        public static Locale a(String str) {
            return Locale.forLanguageTag(str);
        }
    }

    public static class e {
        public static LocaleList a(String str) {
            return LocaleList.forLanguageTags(str);
        }

        public static void b(TextView textView, LocaleList localeList) {
            textView.setTextLocales(localeList);
        }
    }

    public static class f {
        public static int a(TextView textView) {
            return textView.getAutoSizeStepGranularity();
        }

        public static void b(TextView textView, int i11, int i12, int i13, int i14) {
            textView.setAutoSizeTextTypeUniformWithConfiguration(i11, i12, i13, i14);
        }

        public static void c(TextView textView, int[] iArr, int i11) {
            textView.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i11);
        }

        public static boolean d(TextView textView, String str) {
            return textView.setFontVariationSettings(str);
        }
    }

    public static class g {
        public static Typeface a(Typeface typeface, int i11, boolean z11) {
            return Typeface.create(typeface, i11, z11);
        }
    }

    public n(TextView textView) {
        this.f4631a = textView;
        this.f4639i = new o(textView);
    }

    public static TintInfo d(Context context, AppCompatDrawableManager appCompatDrawableManager, int i11) {
        ColorStateList f11 = appCompatDrawableManager.f(context, i11);
        if (f11 == null) {
            return null;
        }
        TintInfo tintInfo = new TintInfo();
        tintInfo.f4523d = true;
        tintInfo.f4520a = f11;
        return tintInfo;
    }

    public void A(int i11, float f11) {
        if (!o0.f4669b && !l()) {
            B(i11, f11);
        }
    }

    public final void B(int i11, float f11) {
        this.f4639i.w(i11, f11);
    }

    public final void C(Context context, d0 d0Var) {
        String o11;
        this.f4640j = d0Var.k(R$styleable.TextAppearance_android_textStyle, this.f4640j);
        int i11 = Build.VERSION.SDK_INT;
        boolean z11 = false;
        if (i11 >= 28) {
            int k11 = d0Var.k(R$styleable.TextAppearance_android_textFontWeight, -1);
            this.f4641k = k11;
            if (k11 != -1) {
                this.f4640j = (this.f4640j & 2) | 0;
            }
        }
        int i12 = R$styleable.TextAppearance_android_fontFamily;
        if (d0Var.s(i12) || d0Var.s(R$styleable.TextAppearance_fontFamily)) {
            this.f4642l = null;
            int i13 = R$styleable.TextAppearance_fontFamily;
            if (d0Var.s(i13)) {
                i12 = i13;
            }
            int i14 = this.f4641k;
            int i15 = this.f4640j;
            if (!context.isRestricted()) {
                try {
                    Typeface j11 = d0Var.j(i12, this.f4640j, new a(i14, i15, new WeakReference(this.f4631a)));
                    if (j11 != null) {
                        if (i11 < 28 || this.f4641k == -1) {
                            this.f4642l = j11;
                        } else {
                            this.f4642l = g.a(Typeface.create(j11, 0), this.f4641k, (this.f4640j & 2) != 0);
                        }
                    }
                    this.f4643m = this.f4642l == null;
                } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
                }
            }
            if (this.f4642l == null && (o11 = d0Var.o(i12)) != null) {
                if (Build.VERSION.SDK_INT < 28 || this.f4641k == -1) {
                    this.f4642l = Typeface.create(o11, this.f4640j);
                    return;
                }
                Typeface create = Typeface.create(o11, 0);
                int i16 = this.f4641k;
                if ((this.f4640j & 2) != 0) {
                    z11 = true;
                }
                this.f4642l = g.a(create, i16, z11);
                return;
            }
            return;
        }
        int i17 = R$styleable.TextAppearance_android_typeface;
        if (d0Var.s(i17)) {
            this.f4643m = false;
            int k12 = d0Var.k(i17, 1);
            if (k12 == 1) {
                this.f4642l = Typeface.SANS_SERIF;
            } else if (k12 == 2) {
                this.f4642l = Typeface.SERIF;
            } else if (k12 == 3) {
                this.f4642l = Typeface.MONOSPACE;
            }
        }
    }

    public final void a(Drawable drawable, TintInfo tintInfo) {
        if (drawable != null && tintInfo != null) {
            AppCompatDrawableManager.i(drawable, tintInfo, this.f4631a.getDrawableState());
        }
    }

    public void b() {
        if (!(this.f4632b == null && this.f4633c == null && this.f4634d == null && this.f4635e == null)) {
            Drawable[] compoundDrawables = this.f4631a.getCompoundDrawables();
            a(compoundDrawables[0], this.f4632b);
            a(compoundDrawables[1], this.f4633c);
            a(compoundDrawables[2], this.f4634d);
            a(compoundDrawables[3], this.f4635e);
        }
        if (Build.VERSION.SDK_INT < 17) {
            return;
        }
        if (this.f4636f != null || this.f4637g != null) {
            Drawable[] a11 = c.a(this.f4631a);
            a(a11[0], this.f4636f);
            a(a11[2], this.f4637g);
        }
    }

    public void c() {
        this.f4639i.b();
    }

    public int e() {
        return this.f4639i.h();
    }

    public int f() {
        return this.f4639i.i();
    }

    public int g() {
        return this.f4639i.j();
    }

    public int[] h() {
        return this.f4639i.k();
    }

    public int i() {
        return this.f4639i.l();
    }

    public ColorStateList j() {
        TintInfo tintInfo = this.f4638h;
        if (tintInfo != null) {
            return tintInfo.f4520a;
        }
        return null;
    }

    public PorterDuff.Mode k() {
        TintInfo tintInfo = this.f4638h;
        if (tintInfo != null) {
            return tintInfo.f4521b;
        }
        return null;
    }

    public boolean l() {
        return this.f4639i.q();
    }

    /* JADX WARNING: Removed duplicated region for block: B:104:0x01e2  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x01e9  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0229  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0266  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x026c  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0275  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x027b  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x0284  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x028a  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x0293  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x0299  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x02a2  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x02a8  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x02b1  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x02b7  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x02cb  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x02dc  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x02ec  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x0304  */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x030b  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x0312  */
    /* JADX WARNING: Removed duplicated region for block: B:161:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0104  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0146  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0172  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x017a  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x018d  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x01b0  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x01b7  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x01be  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x01ce  */
    @android.annotation.SuppressLint({"NewApi"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m(android.util.AttributeSet r24, int r25) {
        /*
            r23 = this;
            r7 = r23
            r8 = r24
            r9 = r25
            android.widget.TextView r0 = r7.f4631a
            android.content.Context r10 = r0.getContext()
            androidx.appcompat.widget.AppCompatDrawableManager r11 = androidx.appcompat.widget.AppCompatDrawableManager.b()
            int[] r2 = androidx.appcompat.R$styleable.AppCompatTextHelper
            r12 = 0
            androidx.appcompat.widget.d0 r13 = androidx.appcompat.widget.d0.v(r10, r8, r2, r9, r12)
            android.widget.TextView r0 = r7.f4631a
            android.content.Context r1 = r0.getContext()
            android.content.res.TypedArray r4 = r13.r()
            r6 = 0
            r3 = r24
            r5 = r25
            androidx.core.view.h0.v0(r0, r1, r2, r3, r4, r5, r6)
            int r0 = androidx.appcompat.R$styleable.AppCompatTextHelper_android_textAppearance
            r14 = -1
            int r0 = r13.n(r0, r14)
            int r1 = androidx.appcompat.R$styleable.AppCompatTextHelper_android_drawableLeft
            boolean r2 = r13.s(r1)
            if (r2 == 0) goto L_0x0042
            int r1 = r13.n(r1, r12)
            androidx.appcompat.widget.TintInfo r1 = d(r10, r11, r1)
            r7.f4632b = r1
        L_0x0042:
            int r1 = androidx.appcompat.R$styleable.AppCompatTextHelper_android_drawableTop
            boolean r2 = r13.s(r1)
            if (r2 == 0) goto L_0x0054
            int r1 = r13.n(r1, r12)
            androidx.appcompat.widget.TintInfo r1 = d(r10, r11, r1)
            r7.f4633c = r1
        L_0x0054:
            int r1 = androidx.appcompat.R$styleable.AppCompatTextHelper_android_drawableRight
            boolean r2 = r13.s(r1)
            if (r2 == 0) goto L_0x0066
            int r1 = r13.n(r1, r12)
            androidx.appcompat.widget.TintInfo r1 = d(r10, r11, r1)
            r7.f4634d = r1
        L_0x0066:
            int r1 = androidx.appcompat.R$styleable.AppCompatTextHelper_android_drawableBottom
            boolean r2 = r13.s(r1)
            if (r2 == 0) goto L_0x0078
            int r1 = r13.n(r1, r12)
            androidx.appcompat.widget.TintInfo r1 = d(r10, r11, r1)
            r7.f4635e = r1
        L_0x0078:
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 17
            if (r1 < r2) goto L_0x00a2
            int r2 = androidx.appcompat.R$styleable.AppCompatTextHelper_android_drawableStart
            boolean r3 = r13.s(r2)
            if (r3 == 0) goto L_0x0090
            int r2 = r13.n(r2, r12)
            androidx.appcompat.widget.TintInfo r2 = d(r10, r11, r2)
            r7.f4636f = r2
        L_0x0090:
            int r2 = androidx.appcompat.R$styleable.AppCompatTextHelper_android_drawableEnd
            boolean r3 = r13.s(r2)
            if (r3 == 0) goto L_0x00a2
            int r2 = r13.n(r2, r12)
            androidx.appcompat.widget.TintInfo r2 = d(r10, r11, r2)
            r7.f4637g = r2
        L_0x00a2:
            r13.w()
            android.widget.TextView r2 = r7.f4631a
            android.text.method.TransformationMethod r2 = r2.getTransformationMethod()
            boolean r2 = r2 instanceof android.text.method.PasswordTransformationMethod
            r3 = 26
            r5 = 23
            if (r0 == r14) goto L_0x011e
            int[] r6 = androidx.appcompat.R$styleable.TextAppearance
            androidx.appcompat.widget.d0 r0 = androidx.appcompat.widget.d0.t(r10, r0, r6)
            if (r2 != 0) goto L_0x00c9
            int r6 = androidx.appcompat.R$styleable.TextAppearance_textAllCaps
            boolean r15 = r0.s(r6)
            if (r15 == 0) goto L_0x00c9
            boolean r6 = r0.a(r6, r12)
            r15 = 1
            goto L_0x00cb
        L_0x00c9:
            r6 = r12
            r15 = r6
        L_0x00cb:
            r7.C(r10, r0)
            if (r1 >= r5) goto L_0x00f9
            int r4 = androidx.appcompat.R$styleable.TextAppearance_android_textColor
            boolean r17 = r0.s(r4)
            if (r17 == 0) goto L_0x00dd
            android.content.res.ColorStateList r4 = r0.c(r4)
            goto L_0x00de
        L_0x00dd:
            r4 = 0
        L_0x00de:
            int r13 = androidx.appcompat.R$styleable.TextAppearance_android_textColorHint
            boolean r18 = r0.s(r13)
            if (r18 == 0) goto L_0x00eb
            android.content.res.ColorStateList r13 = r0.c(r13)
            goto L_0x00ec
        L_0x00eb:
            r13 = 0
        L_0x00ec:
            int r14 = androidx.appcompat.R$styleable.TextAppearance_android_textColorLink
            boolean r19 = r0.s(r14)
            if (r19 == 0) goto L_0x00fb
            android.content.res.ColorStateList r14 = r0.c(r14)
            goto L_0x00fc
        L_0x00f9:
            r4 = 0
            r13 = 0
        L_0x00fb:
            r14 = 0
        L_0x00fc:
            int r5 = androidx.appcompat.R$styleable.TextAppearance_textLocale
            boolean r20 = r0.s(r5)
            if (r20 == 0) goto L_0x0109
            java.lang.String r5 = r0.o(r5)
            goto L_0x010a
        L_0x0109:
            r5 = 0
        L_0x010a:
            if (r1 < r3) goto L_0x0119
            int r3 = androidx.appcompat.R$styleable.TextAppearance_fontVariationSettings
            boolean r21 = r0.s(r3)
            if (r21 == 0) goto L_0x0119
            java.lang.String r3 = r0.o(r3)
            goto L_0x011a
        L_0x0119:
            r3 = 0
        L_0x011a:
            r0.w()
            goto L_0x0125
        L_0x011e:
            r6 = r12
            r15 = r6
            r3 = 0
            r4 = 0
            r5 = 0
            r13 = 0
            r14 = 0
        L_0x0125:
            int[] r0 = androidx.appcompat.R$styleable.TextAppearance
            androidx.appcompat.widget.d0 r0 = androidx.appcompat.widget.d0.v(r10, r8, r0, r9, r12)
            if (r2 != 0) goto L_0x0140
            int r12 = androidx.appcompat.R$styleable.TextAppearance_textAllCaps
            boolean r22 = r0.s(r12)
            if (r22 == 0) goto L_0x0140
            r22 = r3
            r3 = 0
            boolean r6 = r0.a(r12, r3)
            r3 = 23
            r15 = 1
            goto L_0x0144
        L_0x0140:
            r22 = r3
            r3 = 23
        L_0x0144:
            if (r1 >= r3) goto L_0x016a
            int r3 = androidx.appcompat.R$styleable.TextAppearance_android_textColor
            boolean r12 = r0.s(r3)
            if (r12 == 0) goto L_0x0152
            android.content.res.ColorStateList r4 = r0.c(r3)
        L_0x0152:
            int r3 = androidx.appcompat.R$styleable.TextAppearance_android_textColorHint
            boolean r12 = r0.s(r3)
            if (r12 == 0) goto L_0x015e
            android.content.res.ColorStateList r13 = r0.c(r3)
        L_0x015e:
            int r3 = androidx.appcompat.R$styleable.TextAppearance_android_textColorLink
            boolean r12 = r0.s(r3)
            if (r12 == 0) goto L_0x016a
            android.content.res.ColorStateList r14 = r0.c(r3)
        L_0x016a:
            int r3 = androidx.appcompat.R$styleable.TextAppearance_textLocale
            boolean r12 = r0.s(r3)
            if (r12 == 0) goto L_0x0176
            java.lang.String r5 = r0.o(r3)
        L_0x0176:
            r3 = 26
            if (r1 < r3) goto L_0x0187
            int r3 = androidx.appcompat.R$styleable.TextAppearance_fontVariationSettings
            boolean r12 = r0.s(r3)
            if (r12 == 0) goto L_0x0187
            java.lang.String r3 = r0.o(r3)
            goto L_0x0189
        L_0x0187:
            r3 = r22
        L_0x0189:
            r12 = 28
            if (r1 < r12) goto L_0x01a6
            int r12 = androidx.appcompat.R$styleable.TextAppearance_android_textSize
            boolean r16 = r0.s(r12)
            if (r16 == 0) goto L_0x01a6
            r16 = r11
            r11 = -1
            int r12 = r0.f(r12, r11)
            if (r12 != 0) goto L_0x01a8
            android.widget.TextView r11 = r7.f4631a
            r12 = 0
            r8 = 0
            r11.setTextSize(r8, r12)
            goto L_0x01a8
        L_0x01a6:
            r16 = r11
        L_0x01a8:
            r7.C(r10, r0)
            r0.w()
            if (r4 == 0) goto L_0x01b5
            android.widget.TextView r0 = r7.f4631a
            r0.setTextColor(r4)
        L_0x01b5:
            if (r13 == 0) goto L_0x01bc
            android.widget.TextView r0 = r7.f4631a
            r0.setHintTextColor(r13)
        L_0x01bc:
            if (r14 == 0) goto L_0x01c3
            android.widget.TextView r0 = r7.f4631a
            r0.setLinkTextColor(r14)
        L_0x01c3:
            if (r2 != 0) goto L_0x01ca
            if (r15 == 0) goto L_0x01ca
            r7.s(r6)
        L_0x01ca:
            android.graphics.Typeface r0 = r7.f4642l
            if (r0 == 0) goto L_0x01e0
            int r2 = r7.f4641k
            r4 = -1
            if (r2 != r4) goto L_0x01db
            android.widget.TextView r2 = r7.f4631a
            int r4 = r7.f4640j
            r2.setTypeface(r0, r4)
            goto L_0x01e0
        L_0x01db:
            android.widget.TextView r2 = r7.f4631a
            r2.setTypeface(r0)
        L_0x01e0:
            if (r3 == 0) goto L_0x01e7
            android.widget.TextView r0 = r7.f4631a
            androidx.appcompat.widget.n.f.d(r0, r3)
        L_0x01e7:
            if (r5 == 0) goto L_0x020d
            r0 = 24
            if (r1 < r0) goto L_0x01f7
            android.widget.TextView r0 = r7.f4631a
            android.os.LocaleList r1 = androidx.appcompat.widget.n.e.a(r5)
            androidx.appcompat.widget.n.e.b(r0, r1)
            goto L_0x020d
        L_0x01f7:
            r0 = 21
            if (r1 < r0) goto L_0x020d
            java.lang.String r0 = ","
            java.lang.String[] r0 = r5.split(r0)
            r1 = 0
            r0 = r0[r1]
            android.widget.TextView r1 = r7.f4631a
            java.util.Locale r0 = androidx.appcompat.widget.n.d.a(r0)
            androidx.appcompat.widget.n.c.c(r1, r0)
        L_0x020d:
            androidx.appcompat.widget.o r0 = r7.f4639i
            r1 = r24
            r0.r(r1, r9)
            boolean r0 = androidx.appcompat.widget.o0.f4669b
            if (r0 == 0) goto L_0x0255
            androidx.appcompat.widget.o r0 = r7.f4639i
            int r0 = r0.l()
            if (r0 == 0) goto L_0x0255
            androidx.appcompat.widget.o r0 = r7.f4639i
            int[] r0 = r0.k()
            int r2 = r0.length
            if (r2 <= 0) goto L_0x0255
            android.widget.TextView r2 = r7.f4631a
            int r2 = androidx.appcompat.widget.n.f.a(r2)
            float r2 = (float) r2
            r3 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 == 0) goto L_0x024f
            android.widget.TextView r0 = r7.f4631a
            androidx.appcompat.widget.o r2 = r7.f4639i
            int r2 = r2.i()
            androidx.appcompat.widget.o r3 = r7.f4639i
            int r3 = r3.h()
            androidx.appcompat.widget.o r4 = r7.f4639i
            int r4 = r4.j()
            r5 = 0
            androidx.appcompat.widget.n.f.b(r0, r2, r3, r4, r5)
            goto L_0x0255
        L_0x024f:
            r5 = 0
            android.widget.TextView r2 = r7.f4631a
            androidx.appcompat.widget.n.f.c(r2, r0, r5)
        L_0x0255:
            int[] r0 = androidx.appcompat.R$styleable.AppCompatTextView
            androidx.appcompat.widget.d0 r8 = androidx.appcompat.widget.d0.u(r10, r1, r0)
            int r0 = androidx.appcompat.R$styleable.AppCompatTextView_drawableLeftCompat
            r1 = -1
            int r0 = r8.n(r0, r1)
            r2 = r16
            if (r0 == r1) goto L_0x026c
            android.graphics.drawable.Drawable r0 = r2.c(r10, r0)
            r3 = r0
            goto L_0x026d
        L_0x026c:
            r3 = 0
        L_0x026d:
            int r0 = androidx.appcompat.R$styleable.AppCompatTextView_drawableTopCompat
            int r0 = r8.n(r0, r1)
            if (r0 == r1) goto L_0x027b
            android.graphics.drawable.Drawable r0 = r2.c(r10, r0)
            r4 = r0
            goto L_0x027c
        L_0x027b:
            r4 = 0
        L_0x027c:
            int r0 = androidx.appcompat.R$styleable.AppCompatTextView_drawableRightCompat
            int r0 = r8.n(r0, r1)
            if (r0 == r1) goto L_0x028a
            android.graphics.drawable.Drawable r0 = r2.c(r10, r0)
            r5 = r0
            goto L_0x028b
        L_0x028a:
            r5 = 0
        L_0x028b:
            int r0 = androidx.appcompat.R$styleable.AppCompatTextView_drawableBottomCompat
            int r0 = r8.n(r0, r1)
            if (r0 == r1) goto L_0x0299
            android.graphics.drawable.Drawable r0 = r2.c(r10, r0)
            r6 = r0
            goto L_0x029a
        L_0x0299:
            r6 = 0
        L_0x029a:
            int r0 = androidx.appcompat.R$styleable.AppCompatTextView_drawableStartCompat
            int r0 = r8.n(r0, r1)
            if (r0 == r1) goto L_0x02a8
            android.graphics.drawable.Drawable r0 = r2.c(r10, r0)
            r9 = r0
            goto L_0x02a9
        L_0x02a8:
            r9 = 0
        L_0x02a9:
            int r0 = androidx.appcompat.R$styleable.AppCompatTextView_drawableEndCompat
            int r0 = r8.n(r0, r1)
            if (r0 == r1) goto L_0x02b7
            android.graphics.drawable.Drawable r0 = r2.c(r10, r0)
            r10 = r0
            goto L_0x02b8
        L_0x02b7:
            r10 = 0
        L_0x02b8:
            r0 = r23
            r1 = r3
            r2 = r4
            r3 = r5
            r4 = r6
            r5 = r9
            r6 = r10
            r0.y(r1, r2, r3, r4, r5, r6)
            int r0 = androidx.appcompat.R$styleable.AppCompatTextView_drawableTint
            boolean r1 = r8.s(r0)
            if (r1 == 0) goto L_0x02d4
            android.content.res.ColorStateList r0 = r8.c(r0)
            android.widget.TextView r1 = r7.f4631a
            androidx.core.widget.l.l(r1, r0)
        L_0x02d4:
            int r0 = androidx.appcompat.R$styleable.AppCompatTextView_drawableTintMode
            boolean r1 = r8.s(r0)
            if (r1 == 0) goto L_0x02ec
            r1 = -1
            int r0 = r8.k(r0, r1)
            r2 = 0
            android.graphics.PorterDuff$Mode r0 = androidx.appcompat.widget.r.e(r0, r2)
            android.widget.TextView r2 = r7.f4631a
            androidx.core.widget.l.m(r2, r0)
            goto L_0x02ed
        L_0x02ec:
            r1 = -1
        L_0x02ed:
            int r0 = androidx.appcompat.R$styleable.AppCompatTextView_firstBaselineToTopHeight
            int r0 = r8.f(r0, r1)
            int r2 = androidx.appcompat.R$styleable.AppCompatTextView_lastBaselineToBottomHeight
            int r2 = r8.f(r2, r1)
            int r3 = androidx.appcompat.R$styleable.AppCompatTextView_lineHeight
            int r3 = r8.f(r3, r1)
            r8.w()
            if (r0 == r1) goto L_0x0309
            android.widget.TextView r4 = r7.f4631a
            androidx.core.widget.l.o(r4, r0)
        L_0x0309:
            if (r2 == r1) goto L_0x0310
            android.widget.TextView r0 = r7.f4631a
            androidx.core.widget.l.p(r0, r2)
        L_0x0310:
            if (r3 == r1) goto L_0x0317
            android.widget.TextView r0 = r7.f4631a
            androidx.core.widget.l.q(r0, r3)
        L_0x0317:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.n.m(android.util.AttributeSet, int):void");
    }

    public void n(WeakReference<TextView> weakReference, Typeface typeface) {
        if (this.f4643m) {
            this.f4642l = typeface;
            TextView textView = (TextView) weakReference.get();
            if (textView == null) {
                return;
            }
            if (h0.Z(textView)) {
                textView.post(new b(textView, typeface, this.f4640j));
            } else {
                textView.setTypeface(typeface, this.f4640j);
            }
        }
    }

    public void o(boolean z11, int i11, int i12, int i13, int i14) {
        if (!o0.f4669b) {
            c();
        }
    }

    public void p() {
        b();
    }

    public void q(Context context, int i11) {
        String o11;
        ColorStateList c11;
        ColorStateList c12;
        ColorStateList c13;
        d0 t11 = d0.t(context, i11, R$styleable.TextAppearance);
        int i12 = R$styleable.TextAppearance_textAllCaps;
        if (t11.s(i12)) {
            s(t11.a(i12, false));
        }
        int i13 = Build.VERSION.SDK_INT;
        if (i13 < 23) {
            int i14 = R$styleable.TextAppearance_android_textColor;
            if (t11.s(i14) && (c13 = t11.c(i14)) != null) {
                this.f4631a.setTextColor(c13);
            }
            int i15 = R$styleable.TextAppearance_android_textColorLink;
            if (t11.s(i15) && (c12 = t11.c(i15)) != null) {
                this.f4631a.setLinkTextColor(c12);
            }
            int i16 = R$styleable.TextAppearance_android_textColorHint;
            if (t11.s(i16) && (c11 = t11.c(i16)) != null) {
                this.f4631a.setHintTextColor(c11);
            }
        }
        int i17 = R$styleable.TextAppearance_android_textSize;
        if (t11.s(i17) && t11.f(i17, -1) == 0) {
            this.f4631a.setTextSize(0, 0.0f);
        }
        C(context, t11);
        if (i13 >= 26) {
            int i18 = R$styleable.TextAppearance_fontVariationSettings;
            if (t11.s(i18) && (o11 = t11.o(i18)) != null) {
                f.d(this.f4631a, o11);
            }
        }
        t11.w();
        Typeface typeface = this.f4642l;
        if (typeface != null) {
            this.f4631a.setTypeface(typeface, this.f4640j);
        }
    }

    public void r(TextView textView, InputConnection inputConnection, EditorInfo editorInfo) {
        if (Build.VERSION.SDK_INT < 30 && inputConnection != null) {
            EditorInfoCompat.f(editorInfo, textView.getText());
        }
    }

    public void s(boolean z11) {
        this.f4631a.setAllCaps(z11);
    }

    public void t(int i11, int i12, int i13, int i14) throws IllegalArgumentException {
        this.f4639i.s(i11, i12, i13, i14);
    }

    public void u(int[] iArr, int i11) throws IllegalArgumentException {
        this.f4639i.t(iArr, i11);
    }

    public void v(int i11) {
        this.f4639i.u(i11);
    }

    public void w(ColorStateList colorStateList) {
        if (this.f4638h == null) {
            this.f4638h = new TintInfo();
        }
        TintInfo tintInfo = this.f4638h;
        tintInfo.f4520a = colorStateList;
        tintInfo.f4523d = colorStateList != null;
        z();
    }

    public void x(PorterDuff.Mode mode) {
        if (this.f4638h == null) {
            this.f4638h = new TintInfo();
        }
        TintInfo tintInfo = this.f4638h;
        tintInfo.f4521b = mode;
        tintInfo.f4522c = mode != null;
        z();
    }

    public final void y(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4, Drawable drawable5, Drawable drawable6) {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 17 && (drawable5 != null || drawable6 != null)) {
            Drawable[] a11 = c.a(this.f4631a);
            TextView textView = this.f4631a;
            if (drawable5 == null) {
                drawable5 = a11[0];
            }
            if (drawable2 == null) {
                drawable2 = a11[1];
            }
            if (drawable6 == null) {
                drawable6 = a11[2];
            }
            if (drawable4 == null) {
                drawable4 = a11[3];
            }
            c.b(textView, drawable5, drawable2, drawable6, drawable4);
        } else if (drawable != null || drawable2 != null || drawable3 != null || drawable4 != null) {
            if (i11 >= 17) {
                Drawable[] a12 = c.a(this.f4631a);
                if (!(a12[0] == null && a12[2] == null)) {
                    TextView textView2 = this.f4631a;
                    Drawable drawable7 = a12[0];
                    if (drawable2 == null) {
                        drawable2 = a12[1];
                    }
                    Drawable drawable8 = a12[2];
                    if (drawable4 == null) {
                        drawable4 = a12[3];
                    }
                    c.b(textView2, drawable7, drawable2, drawable8, drawable4);
                    return;
                }
            }
            Drawable[] compoundDrawables = this.f4631a.getCompoundDrawables();
            TextView textView3 = this.f4631a;
            if (drawable == null) {
                drawable = compoundDrawables[0];
            }
            if (drawable2 == null) {
                drawable2 = compoundDrawables[1];
            }
            if (drawable3 == null) {
                drawable3 = compoundDrawables[2];
            }
            if (drawable4 == null) {
                drawable4 = compoundDrawables[3];
            }
            textView3.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        }
    }

    public final void z() {
        TintInfo tintInfo = this.f4638h;
        this.f4632b = tintInfo;
        this.f4633c = tintInfo;
        this.f4634d = tintInfo;
        this.f4635e = tintInfo;
        this.f4636f = tintInfo;
        this.f4637g = tintInfo;
    }
}
