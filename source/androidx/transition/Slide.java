package androidx.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.core.view.h0;
import org.xmlpull.v1.XmlPullParser;
import v1.l;

public class Slide extends Visibility {

    /* renamed from: d  reason: collision with root package name */
    public static final TimeInterpolator f11830d = new DecelerateInterpolator();

    /* renamed from: e  reason: collision with root package name */
    public static final TimeInterpolator f11831e = new AccelerateInterpolator();

    /* renamed from: f  reason: collision with root package name */
    public static final g f11832f = new a();

    /* renamed from: g  reason: collision with root package name */
    public static final g f11833g = new b();

    /* renamed from: h  reason: collision with root package name */
    public static final g f11834h = new c();

    /* renamed from: i  reason: collision with root package name */
    public static final g f11835i = new d();

    /* renamed from: j  reason: collision with root package name */
    public static final g f11836j = new e();

    /* renamed from: k  reason: collision with root package name */
    public static final g f11837k = new f();

    /* renamed from: b  reason: collision with root package name */
    public g f11838b = f11837k;

    /* renamed from: c  reason: collision with root package name */
    public int f11839c = 80;

    public static class a extends h {
        public a() {
            super((a) null);
        }

        public float b(ViewGroup viewGroup, View view) {
            return view.getTranslationX() - ((float) viewGroup.getWidth());
        }
    }

    public static class b extends h {
        public b() {
            super((a) null);
        }

        public float b(ViewGroup viewGroup, View view) {
            boolean z11 = true;
            if (h0.F(viewGroup) != 1) {
                z11 = false;
            }
            if (z11) {
                return view.getTranslationX() + ((float) viewGroup.getWidth());
            }
            return view.getTranslationX() - ((float) viewGroup.getWidth());
        }
    }

    public static class c extends i {
        public c() {
            super((a) null);
        }

        public float a(ViewGroup viewGroup, View view) {
            return view.getTranslationY() - ((float) viewGroup.getHeight());
        }
    }

    public static class d extends h {
        public d() {
            super((a) null);
        }

        public float b(ViewGroup viewGroup, View view) {
            return view.getTranslationX() + ((float) viewGroup.getWidth());
        }
    }

    public static class e extends h {
        public e() {
            super((a) null);
        }

        public float b(ViewGroup viewGroup, View view) {
            boolean z11 = true;
            if (h0.F(viewGroup) != 1) {
                z11 = false;
            }
            if (z11) {
                return view.getTranslationX() - ((float) viewGroup.getWidth());
            }
            return view.getTranslationX() + ((float) viewGroup.getWidth());
        }
    }

    public static class f extends i {
        public f() {
            super((a) null);
        }

        public float a(ViewGroup viewGroup, View view) {
            return view.getTranslationY() + ((float) viewGroup.getHeight());
        }
    }

    public interface g {
        float a(ViewGroup viewGroup, View view);

        float b(ViewGroup viewGroup, View view);
    }

    public static abstract class h implements g {
        public h() {
        }

        public float a(ViewGroup viewGroup, View view) {
            return view.getTranslationY();
        }

        public /* synthetic */ h(a aVar) {
            this();
        }
    }

    public static abstract class i implements g {
        public i() {
        }

        public float b(ViewGroup viewGroup, View view) {
            return view.getTranslationX();
        }

        public /* synthetic */ i(a aVar) {
            this();
        }
    }

    public Slide() {
        b(80);
    }

    public void b(int i11) {
        if (i11 == 3) {
            this.f11838b = f11832f;
        } else if (i11 == 5) {
            this.f11838b = f11835i;
        } else if (i11 == 48) {
            this.f11838b = f11834h;
        } else if (i11 == 80) {
            this.f11838b = f11837k;
        } else if (i11 == 8388611) {
            this.f11838b = f11833g;
        } else if (i11 == 8388613) {
            this.f11838b = f11836j;
        } else {
            throw new IllegalArgumentException("Invalid slide direction");
        }
        this.f11839c = i11;
        SidePropagation sidePropagation = new SidePropagation();
        sidePropagation.j(i11);
        setPropagation(sidePropagation);
    }

    public void captureEndValues(TransitionValues transitionValues) {
        super.captureEndValues(transitionValues);
        captureValues(transitionValues);
    }

    public void captureStartValues(TransitionValues transitionValues) {
        super.captureStartValues(transitionValues);
        captureValues(transitionValues);
    }

    public final void captureValues(TransitionValues transitionValues) {
        int[] iArr = new int[2];
        transitionValues.f11866b.getLocationOnScreen(iArr);
        transitionValues.f11865a.put("android:slide:screenPosition", iArr);
    }

    public Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues2 == null) {
            return null;
        }
        int[] iArr = (int[]) transitionValues2.f11865a.get("android:slide:screenPosition");
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        return d.a(view, transitionValues2, iArr[0], iArr[1], this.f11838b.b(viewGroup, view), this.f11838b.a(viewGroup, view), translationX, translationY, f11830d, this);
    }

    public Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues == null) {
            return null;
        }
        int[] iArr = (int[]) transitionValues.f11865a.get("android:slide:screenPosition");
        return d.a(view, transitionValues, iArr[0], iArr[1], view.getTranslationX(), view.getTranslationY(), this.f11838b.b(viewGroup, view), this.f11838b.a(viewGroup, view), f11831e, this);
    }

    public Slide(int i11) {
        b(i11);
    }

    @SuppressLint({"RestrictedApi"})
    public Slide(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.f16669h);
        int g11 = s0.i.g(obtainStyledAttributes, (XmlPullParser) attributeSet, "slideEdge", 0, 80);
        obtainStyledAttributes.recycle();
        b(g11);
    }
}
