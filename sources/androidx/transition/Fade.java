package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.h0;
import s0.i;
import v1.l;
import v1.u;

public class Fade extends Visibility {

    public class a extends TransitionListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f11793b;

        public a(View view) {
            this.f11793b = view;
        }

        public void onTransitionEnd(Transition transition) {
            u.h(this.f11793b, 1.0f);
            u.a(this.f11793b);
            transition.removeListener(this);
        }
    }

    public static class b extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        public final View f11795b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f11796c = false;

        public b(View view) {
            this.f11795b = view;
        }

        public void onAnimationEnd(Animator animator) {
            u.h(this.f11795b, 1.0f);
            if (this.f11796c) {
                this.f11795b.setLayerType(0, (Paint) null);
            }
        }

        public void onAnimationStart(Animator animator) {
            if (h0.W(this.f11795b) && this.f11795b.getLayerType() == 0) {
                this.f11796c = true;
                this.f11795b.setLayerType(2, (Paint) null);
            }
        }
    }

    public Fade(int i11) {
        setMode(i11);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r1 = (java.lang.Float) r1.f11865a.get("android:fade:transitionAlpha");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static float c(androidx.transition.TransitionValues r1, float r2) {
        /*
            if (r1 == 0) goto L_0x0012
            java.util.Map<java.lang.String, java.lang.Object> r1 = r1.f11865a
            java.lang.String r0 = "android:fade:transitionAlpha"
            java.lang.Object r1 = r1.get(r0)
            java.lang.Float r1 = (java.lang.Float) r1
            if (r1 == 0) goto L_0x0012
            float r2 = r1.floatValue()
        L_0x0012:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.Fade.c(androidx.transition.TransitionValues, float):float");
    }

    public final Animator b(View view, float f11, float f12) {
        if (f11 == f12) {
            return null;
        }
        u.h(view, f11);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, u.f16691b, new float[]{f12});
        ofFloat.addListener(new b(view));
        addListener(new a(view));
        return ofFloat;
    }

    public void captureStartValues(TransitionValues transitionValues) {
        super.captureStartValues(transitionValues);
        transitionValues.f11865a.put("android:fade:transitionAlpha", Float.valueOf(u.c(transitionValues.f11866b)));
    }

    public Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        float f11 = 0.0f;
        float c11 = c(transitionValues, 0.0f);
        if (c11 != 1.0f) {
            f11 = c11;
        }
        return b(view, f11, 1.0f);
    }

    public Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        u.e(view);
        return b(view, c(transitionValues, 1.0f), 0.0f);
    }

    public Fade() {
    }

    @SuppressLint({"RestrictedApi"})
    public Fade(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.f16667f);
        setMode(i.g(obtainStyledAttributes, (XmlResourceParser) attributeSet, "fadingMode", 0, getMode()));
        obtainStyledAttributes.recycle();
    }
}
