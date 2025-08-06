package androidx.appcompat.graphics.drawable;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.StateSet;
import androidx.appcompat.graphics.drawable.DrawableContainerCompat;
import androidx.appcompat.graphics.drawable.StateListDrawableCompat;
import androidx.appcompat.resources.R$styleable;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import s0.i;

public class AnimatedStateListDrawableCompat extends StateListDrawableCompat implements u0.f {

    /* renamed from: u  reason: collision with root package name */
    public static final String f3953u = AnimatedStateListDrawableCompat.class.getSimpleName();

    /* renamed from: p  reason: collision with root package name */
    public c f3954p;

    /* renamed from: q  reason: collision with root package name */
    public g f3955q;

    /* renamed from: r  reason: collision with root package name */
    public int f3956r;

    /* renamed from: s  reason: collision with root package name */
    public int f3957s;

    /* renamed from: t  reason: collision with root package name */
    public boolean f3958t;

    public static class b extends g {

        /* renamed from: a  reason: collision with root package name */
        public final Animatable f3959a;

        public b(Animatable animatable) {
            super();
            this.f3959a = animatable;
        }

        public void c() {
            this.f3959a.start();
        }

        public void d() {
            this.f3959a.stop();
        }
    }

    public static class c extends StateListDrawableCompat.a {
        public LongSparseArray<Long> K;
        public SparseArrayCompat<Integer> L;

        public c(c cVar, AnimatedStateListDrawableCompat animatedStateListDrawableCompat, Resources resources) {
            super(cVar, animatedStateListDrawableCompat, resources);
            if (cVar != null) {
                this.K = cVar.K;
                this.L = cVar.L;
                return;
            }
            this.K = new LongSparseArray<>();
            this.L = new SparseArrayCompat<>();
        }

        public static long E(int i11, int i12) {
            return ((long) i12) | (((long) i11) << 32);
        }

        public int C(int[] iArr, Drawable drawable, int i11) {
            int A = super.A(iArr, drawable);
            this.L.m(A, Integer.valueOf(i11));
            return A;
        }

        public int D(int i11, int i12, Drawable drawable, boolean z11) {
            int a11 = super.a(drawable);
            long E = E(i11, i12);
            long j11 = z11 ? 8589934592L : 0;
            long j12 = (long) a11;
            this.K.b(E, Long.valueOf(j12 | j11));
            if (z11) {
                this.K.b(E(i12, i11), Long.valueOf(4294967296L | j12 | j11));
            }
            return a11;
        }

        public int F(int i11) {
            if (i11 < 0) {
                return 0;
            }
            return this.L.h(i11, 0).intValue();
        }

        public int G(int[] iArr) {
            int B = super.B(iArr);
            if (B >= 0) {
                return B;
            }
            return super.B(StateSet.WILD_CARD);
        }

        public int H(int i11, int i12) {
            return (int) this.K.h(E(i11, i12), -1L).longValue();
        }

        public boolean I(int i11, int i12) {
            return (this.K.h(E(i11, i12), -1L).longValue() & 4294967296L) != 0;
        }

        public boolean J(int i11, int i12) {
            return (this.K.h(E(i11, i12), -1L).longValue() & 8589934592L) != 0;
        }

        public Drawable newDrawable() {
            return new AnimatedStateListDrawableCompat(this, (Resources) null);
        }

        public void s() {
            this.K = this.K.clone();
            this.L = this.L.clone();
        }

        public Drawable newDrawable(Resources resources) {
            return new AnimatedStateListDrawableCompat(this, resources);
        }
    }

    public static class d extends g {

        /* renamed from: a  reason: collision with root package name */
        public final androidx.vectordrawable.graphics.drawable.b f3960a;

        public d(androidx.vectordrawable.graphics.drawable.b bVar) {
            super();
            this.f3960a = bVar;
        }

        public void c() {
            this.f3960a.start();
        }

        public void d() {
            this.f3960a.stop();
        }
    }

    public static class e extends g {

        /* renamed from: a  reason: collision with root package name */
        public final ObjectAnimator f3961a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f3962b;

        public e(AnimationDrawable animationDrawable, boolean z11, boolean z12) {
            super();
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            int i11 = z11 ? numberOfFrames - 1 : 0;
            int i12 = z11 ? 0 : numberOfFrames - 1;
            f fVar = new f(animationDrawable, z11);
            ObjectAnimator ofInt = ObjectAnimator.ofInt(animationDrawable, "currentIndex", new int[]{i11, i12});
            if (Build.VERSION.SDK_INT >= 18) {
                e.b.a(ofInt, true);
            }
            ofInt.setDuration((long) fVar.a());
            ofInt.setInterpolator(fVar);
            this.f3962b = z12;
            this.f3961a = ofInt;
        }

        public boolean a() {
            return this.f3962b;
        }

        public void b() {
            this.f3961a.reverse();
        }

        public void c() {
            this.f3961a.start();
        }

        public void d() {
            this.f3961a.cancel();
        }
    }

    public static class f implements TimeInterpolator {

        /* renamed from: a  reason: collision with root package name */
        public int[] f3963a;

        /* renamed from: b  reason: collision with root package name */
        public int f3964b;

        /* renamed from: c  reason: collision with root package name */
        public int f3965c;

        public f(AnimationDrawable animationDrawable, boolean z11) {
            b(animationDrawable, z11);
        }

        public int a() {
            return this.f3965c;
        }

        public int b(AnimationDrawable animationDrawable, boolean z11) {
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            this.f3964b = numberOfFrames;
            int[] iArr = this.f3963a;
            if (iArr == null || iArr.length < numberOfFrames) {
                this.f3963a = new int[numberOfFrames];
            }
            int[] iArr2 = this.f3963a;
            int i11 = 0;
            for (int i12 = 0; i12 < numberOfFrames; i12++) {
                int duration = animationDrawable.getDuration(z11 ? (numberOfFrames - i12) - 1 : i12);
                iArr2[i12] = duration;
                i11 += duration;
            }
            this.f3965c = i11;
            return i11;
        }

        public float getInterpolation(float f11) {
            int i11 = (int) ((f11 * ((float) this.f3965c)) + 0.5f);
            int i12 = this.f3964b;
            int[] iArr = this.f3963a;
            int i13 = 0;
            while (i13 < i12 && i11 >= iArr[i13]) {
                i11 -= iArr[i13];
                i13++;
            }
            return (((float) i13) / ((float) i12)) + (i13 < i12 ? ((float) i11) / ((float) this.f3965c) : 0.0f);
        }
    }

    public static abstract class g {
        public g() {
        }

        public boolean a() {
            return false;
        }

        public void b() {
        }

        public abstract void c();

        public abstract void d();
    }

    public AnimatedStateListDrawableCompat() {
        this((c) null, (Resources) null);
    }

    public static AnimatedStateListDrawableCompat m(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws IOException, XmlPullParserException {
        String name = xmlPullParser.getName();
        if (name.equals("animated-selector")) {
            AnimatedStateListDrawableCompat animatedStateListDrawableCompat = new AnimatedStateListDrawableCompat();
            animatedStateListDrawableCompat.n(context, resources, xmlPullParser, attributeSet, theme);
            return animatedStateListDrawableCompat;
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid animated-selector tag " + name);
    }

    public void h(DrawableContainerCompat.d dVar) {
        super.h(dVar);
        if (dVar instanceof c) {
            this.f3954p = (c) dVar;
        }
    }

    public boolean isStateful() {
        return true;
    }

    public void jumpToCurrentState() {
        super.jumpToCurrentState();
        g gVar = this.f3955q;
        if (gVar != null) {
            gVar.d();
            this.f3955q = null;
            g(this.f3956r);
            this.f3956r = -1;
            this.f3957s = -1;
        }
    }

    /* renamed from: l */
    public c j() {
        return new c(this.f3954p, this, (Resources) null);
    }

    public Drawable mutate() {
        if (!this.f3958t && super.mutate() == this) {
            this.f3954p.s();
            this.f3958t = true;
        }
        return this;
    }

    public void n(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        TypedArray k11 = i.k(resources, theme, attributeSet, R$styleable.AnimatedStateListDrawableCompat);
        setVisible(k11.getBoolean(R$styleable.AnimatedStateListDrawableCompat_android_visible, true), true);
        t(k11);
        i(resources);
        k11.recycle();
        o(context, resources, xmlPullParser, attributeSet, theme);
        p();
    }

    public final void o(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth() + 1;
        while (true) {
            int next = xmlPullParser.next();
            if (next != 1) {
                int depth2 = xmlPullParser.getDepth();
                if (depth2 < depth && next == 3) {
                    return;
                }
                if (next == 2 && depth2 <= depth) {
                    if (xmlPullParser.getName().equals("item")) {
                        q(context, resources, xmlPullParser, attributeSet, theme);
                    } else if (xmlPullParser.getName().equals("transition")) {
                        r(context, resources, xmlPullParser, attributeSet, theme);
                    }
                }
            } else {
                return;
            }
        }
    }

    public boolean onStateChange(int[] iArr) {
        int G = this.f3954p.G(iArr);
        boolean z11 = G != c() && (s(G) || g(G));
        Drawable current = getCurrent();
        return current != null ? z11 | current.setState(iArr) : z11;
    }

    public final void p() {
        onStateChange(getState());
    }

    public final int q(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        TypedArray k11 = i.k(resources, theme, attributeSet, R$styleable.AnimatedStateListDrawableItem);
        int resourceId = k11.getResourceId(R$styleable.AnimatedStateListDrawableItem_android_id, 0);
        int resourceId2 = k11.getResourceId(R$styleable.AnimatedStateListDrawableItem_android_drawable, -1);
        Drawable j11 = resourceId2 > 0 ? ResourceManagerInternal.h().j(context, resourceId2) : null;
        k11.recycle();
        int[] k12 = k(attributeSet);
        if (j11 == null) {
            do {
                next = xmlPullParser.next();
            } while (next == 4);
            if (next != 2) {
                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
            } else if (xmlPullParser.getName().equals("vector")) {
                j11 = VectorDrawableCompat.c(resources, xmlPullParser, attributeSet, theme);
            } else if (Build.VERSION.SDK_INT >= 21) {
                j11 = e.c.a(resources, xmlPullParser, attributeSet, theme);
            } else {
                j11 = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet);
            }
        }
        if (j11 != null) {
            return this.f3954p.C(k12, j11, resourceId);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
    }

    public final int r(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        TypedArray k11 = i.k(resources, theme, attributeSet, R$styleable.AnimatedStateListDrawableTransition);
        int resourceId = k11.getResourceId(R$styleable.AnimatedStateListDrawableTransition_android_fromId, -1);
        int resourceId2 = k11.getResourceId(R$styleable.AnimatedStateListDrawableTransition_android_toId, -1);
        int resourceId3 = k11.getResourceId(R$styleable.AnimatedStateListDrawableTransition_android_drawable, -1);
        Drawable j11 = resourceId3 > 0 ? ResourceManagerInternal.h().j(context, resourceId3) : null;
        boolean z11 = k11.getBoolean(R$styleable.AnimatedStateListDrawableTransition_android_reversible, false);
        k11.recycle();
        if (j11 == null) {
            do {
                next = xmlPullParser.next();
            } while (next == 4);
            if (next != 2) {
                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
            } else if (xmlPullParser.getName().equals("animated-vector")) {
                j11 = androidx.vectordrawable.graphics.drawable.b.c(context, resources, xmlPullParser, attributeSet, theme);
            } else if (Build.VERSION.SDK_INT >= 21) {
                j11 = e.c.a(resources, xmlPullParser, attributeSet, theme);
            } else {
                j11 = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet);
            }
        }
        if (j11 == null) {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
        } else if (resourceId != -1 && resourceId2 != -1) {
            return this.f3954p.D(resourceId, resourceId2, j11, z11);
        } else {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires 'fromId' & 'toId' attributes");
        }
    }

    public final boolean s(int i11) {
        int i12;
        int H;
        g gVar;
        g gVar2 = this.f3955q;
        if (gVar2 == null) {
            i12 = c();
        } else if (i11 == this.f3956r) {
            return true;
        } else {
            if (i11 != this.f3957s || !gVar2.a()) {
                i12 = this.f3956r;
                gVar2.d();
            } else {
                gVar2.b();
                this.f3956r = this.f3957s;
                this.f3957s = i11;
                return true;
            }
        }
        this.f3955q = null;
        this.f3957s = -1;
        this.f3956r = -1;
        c cVar = this.f3954p;
        int F = cVar.F(i12);
        int F2 = cVar.F(i11);
        if (F2 == 0 || F == 0 || (H = cVar.H(F, F2)) < 0) {
            return false;
        }
        boolean J = cVar.J(F, F2);
        g(H);
        Drawable current = getCurrent();
        if (current instanceof AnimationDrawable) {
            gVar = new e((AnimationDrawable) current, cVar.I(F, F2), J);
        } else if (current instanceof androidx.vectordrawable.graphics.drawable.b) {
            gVar = new d((androidx.vectordrawable.graphics.drawable.b) current);
        } else {
            if (current instanceof Animatable) {
                gVar = new b((Animatable) current);
            }
            return false;
        }
        gVar.c();
        this.f3955q = gVar;
        this.f3957s = i12;
        this.f3956r = i11;
        return true;
    }

    public boolean setVisible(boolean z11, boolean z12) {
        boolean visible = super.setVisible(z11, z12);
        g gVar = this.f3955q;
        if (gVar != null && (visible || z12)) {
            if (z11) {
                gVar.c();
            } else {
                jumpToCurrentState();
            }
        }
        return visible;
    }

    public final void t(TypedArray typedArray) {
        c cVar = this.f3954p;
        if (Build.VERSION.SDK_INT >= 21) {
            cVar.f3983d |= e.c.b(typedArray);
        }
        cVar.y(typedArray.getBoolean(R$styleable.AnimatedStateListDrawableCompat_android_variablePadding, cVar.f3988i));
        cVar.u(typedArray.getBoolean(R$styleable.AnimatedStateListDrawableCompat_android_constantSize, cVar.f3991l));
        cVar.v(typedArray.getInt(R$styleable.AnimatedStateListDrawableCompat_android_enterFadeDuration, cVar.A));
        cVar.w(typedArray.getInt(R$styleable.AnimatedStateListDrawableCompat_android_exitFadeDuration, cVar.B));
        setDither(typedArray.getBoolean(R$styleable.AnimatedStateListDrawableCompat_android_dither, cVar.f4003x));
    }

    public AnimatedStateListDrawableCompat(c cVar, Resources resources) {
        super((StateListDrawableCompat.a) null);
        this.f3956r = -1;
        this.f3957s = -1;
        h(new c(cVar, this, resources));
        onStateChange(getState());
        jumpToCurrentState();
    }
}
