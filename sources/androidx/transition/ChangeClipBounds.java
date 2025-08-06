package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.h0;

public class ChangeClipBounds extends Transition {

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f11751b = {"android:clipBounds:clip"};

    public class a extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f11752b;

        public a(View view) {
            this.f11752b = view;
        }

        public void onAnimationEnd(Animator animator) {
            h0.E0(this.f11752b, (Rect) null);
        }
    }

    public ChangeClipBounds() {
    }

    public void captureEndValues(TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    public void captureStartValues(TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    public final void captureValues(TransitionValues transitionValues) {
        View view = transitionValues.f11866b;
        if (view.getVisibility() != 8) {
            Rect x11 = h0.x(view);
            transitionValues.f11865a.put("android:clipBounds:clip", x11);
            if (x11 == null) {
                transitionValues.f11865a.put("android:clipBounds:bounds", new Rect(0, 0, view.getWidth(), view.getHeight()));
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: android.graphics.Rect} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: android.graphics.Rect} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.animation.Animator createAnimator(android.view.ViewGroup r8, androidx.transition.TransitionValues r9, androidx.transition.TransitionValues r10) {
        /*
            r7 = this;
            r8 = 0
            if (r9 == 0) goto L_0x007e
            if (r10 == 0) goto L_0x007e
            java.util.Map<java.lang.String, java.lang.Object> r0 = r9.f11865a
            java.lang.String r1 = "android:clipBounds:clip"
            boolean r0 = r0.containsKey(r1)
            if (r0 == 0) goto L_0x007e
            java.util.Map<java.lang.String, java.lang.Object> r0 = r10.f11865a
            boolean r0 = r0.containsKey(r1)
            if (r0 != 0) goto L_0x0018
            goto L_0x007e
        L_0x0018:
            java.util.Map<java.lang.String, java.lang.Object> r0 = r9.f11865a
            java.lang.Object r0 = r0.get(r1)
            android.graphics.Rect r0 = (android.graphics.Rect) r0
            java.util.Map<java.lang.String, java.lang.Object> r2 = r10.f11865a
            java.lang.Object r1 = r2.get(r1)
            android.graphics.Rect r1 = (android.graphics.Rect) r1
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L_0x002e
            r4 = r2
            goto L_0x002f
        L_0x002e:
            r4 = r3
        L_0x002f:
            if (r0 != 0) goto L_0x0034
            if (r1 != 0) goto L_0x0034
            return r8
        L_0x0034:
            java.lang.String r5 = "android:clipBounds:bounds"
            if (r0 != 0) goto L_0x0042
            java.util.Map<java.lang.String, java.lang.Object> r9 = r9.f11865a
            java.lang.Object r9 = r9.get(r5)
            r0 = r9
            android.graphics.Rect r0 = (android.graphics.Rect) r0
            goto L_0x004d
        L_0x0042:
            if (r1 != 0) goto L_0x004d
            java.util.Map<java.lang.String, java.lang.Object> r9 = r10.f11865a
            java.lang.Object r9 = r9.get(r5)
            r1 = r9
            android.graphics.Rect r1 = (android.graphics.Rect) r1
        L_0x004d:
            boolean r9 = r0.equals(r1)
            if (r9 == 0) goto L_0x0054
            return r8
        L_0x0054:
            android.view.View r8 = r10.f11866b
            androidx.core.view.h0.E0(r8, r0)
            v1.j r8 = new v1.j
            android.graphics.Rect r9 = new android.graphics.Rect
            r9.<init>()
            r8.<init>(r9)
            android.view.View r9 = r10.f11866b
            android.util.Property<android.view.View, android.graphics.Rect> r5 = v1.u.f16692c
            r6 = 2
            android.graphics.Rect[] r6 = new android.graphics.Rect[r6]
            r6[r3] = r0
            r6[r2] = r1
            android.animation.ObjectAnimator r8 = android.animation.ObjectAnimator.ofObject(r9, r5, r8, r6)
            if (r4 == 0) goto L_0x007e
            android.view.View r9 = r10.f11866b
            androidx.transition.ChangeClipBounds$a r10 = new androidx.transition.ChangeClipBounds$a
            r10.<init>(r9)
            r8.addListener(r10)
        L_0x007e:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.ChangeClipBounds.createAnimator(android.view.ViewGroup, androidx.transition.TransitionValues, androidx.transition.TransitionValues):android.animation.Animator");
    }

    public String[] getTransitionProperties() {
        return f11751b;
    }

    public ChangeClipBounds(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
