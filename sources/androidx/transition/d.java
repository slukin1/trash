package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.view.View;
import androidx.transition.Transition;

public class d {

    public static class a extends AnimatorListenerAdapter implements Transition.f {

        /* renamed from: b  reason: collision with root package name */
        public final View f11898b;

        /* renamed from: c  reason: collision with root package name */
        public final View f11899c;

        /* renamed from: d  reason: collision with root package name */
        public final int f11900d;

        /* renamed from: e  reason: collision with root package name */
        public final int f11901e;

        /* renamed from: f  reason: collision with root package name */
        public int[] f11902f;

        /* renamed from: g  reason: collision with root package name */
        public float f11903g;

        /* renamed from: h  reason: collision with root package name */
        public float f11904h;

        /* renamed from: i  reason: collision with root package name */
        public final float f11905i;

        /* renamed from: j  reason: collision with root package name */
        public final float f11906j;

        public a(View view, View view2, int i11, int i12, float f11, float f12) {
            this.f11899c = view;
            this.f11898b = view2;
            this.f11900d = i11 - Math.round(view.getTranslationX());
            this.f11901e = i12 - Math.round(view.getTranslationY());
            this.f11905i = f11;
            this.f11906j = f12;
            int i13 = R$id.transition_position;
            int[] iArr = (int[]) view2.getTag(i13);
            this.f11902f = iArr;
            if (iArr != null) {
                view2.setTag(i13, (Object) null);
            }
        }

        public void onAnimationCancel(Animator animator) {
            if (this.f11902f == null) {
                this.f11902f = new int[2];
            }
            this.f11902f[0] = Math.round(((float) this.f11900d) + this.f11899c.getTranslationX());
            this.f11902f[1] = Math.round(((float) this.f11901e) + this.f11899c.getTranslationY());
            this.f11898b.setTag(R$id.transition_position, this.f11902f);
        }

        public void onAnimationPause(Animator animator) {
            this.f11903g = this.f11899c.getTranslationX();
            this.f11904h = this.f11899c.getTranslationY();
            this.f11899c.setTranslationX(this.f11905i);
            this.f11899c.setTranslationY(this.f11906j);
        }

        public void onAnimationResume(Animator animator) {
            this.f11899c.setTranslationX(this.f11903g);
            this.f11899c.setTranslationY(this.f11904h);
        }

        public void onTransitionCancel(Transition transition) {
        }

        public void onTransitionEnd(Transition transition) {
            this.f11899c.setTranslationX(this.f11905i);
            this.f11899c.setTranslationY(this.f11906j);
            transition.removeListener(this);
        }

        public void onTransitionPause(Transition transition) {
        }

        public void onTransitionResume(Transition transition) {
        }

        public void onTransitionStart(Transition transition) {
        }
    }

    public static Animator a(View view, TransitionValues transitionValues, int i11, int i12, float f11, float f12, float f13, float f14, TimeInterpolator timeInterpolator, Transition transition) {
        float f15;
        float f16;
        View view2 = view;
        TransitionValues transitionValues2 = transitionValues;
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        int[] iArr = (int[]) transitionValues2.f11866b.getTag(R$id.transition_position);
        if (iArr != null) {
            f15 = ((float) (iArr[0] - i11)) + translationX;
            f16 = ((float) (iArr[1] - i12)) + translationY;
        } else {
            f15 = f11;
            f16 = f12;
        }
        int round = i11 + Math.round(f15 - translationX);
        int round2 = i12 + Math.round(f16 - translationY);
        view.setTranslationX(f15);
        view.setTranslationY(f16);
        if (f15 == f13 && f16 == f14) {
            return null;
        }
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.TRANSLATION_X, new float[]{f15, f13}), PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, new float[]{f16, f14})});
        a aVar = new a(view, transitionValues2.f11866b, round, round2, translationX, translationY);
        transition.addListener(aVar);
        ofPropertyValuesHolder.addListener(aVar);
        a.a(ofPropertyValuesHolder, aVar);
        ofPropertyValuesHolder.setInterpolator(timeInterpolator);
        return ofPropertyValuesHolder;
    }
}
