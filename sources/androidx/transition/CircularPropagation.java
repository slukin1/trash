package androidx.transition;

import android.graphics.Rect;
import android.view.ViewGroup;

public class CircularPropagation extends VisibilityPropagation {

    /* renamed from: b  reason: collision with root package name */
    public float f11789b = 3.0f;

    public static float h(float f11, float f12, float f13, float f14) {
        float f15 = f13 - f11;
        float f16 = f14 - f12;
        return (float) Math.sqrt((double) ((f15 * f15) + (f16 * f16)));
    }

    public long c(ViewGroup viewGroup, Transition transition, TransitionValues transitionValues, TransitionValues transitionValues2) {
        int i11;
        int i12;
        int i13;
        if (transitionValues == null && transitionValues2 == null) {
            return 0;
        }
        if (transitionValues2 == null || e(transitionValues) == 0) {
            i11 = -1;
        } else {
            transitionValues = transitionValues2;
            i11 = 1;
        }
        int f11 = f(transitionValues);
        int g11 = g(transitionValues);
        Rect epicenter = transition.getEpicenter();
        if (epicenter != null) {
            i13 = epicenter.centerX();
            i12 = epicenter.centerY();
        } else {
            int[] iArr = new int[2];
            viewGroup.getLocationOnScreen(iArr);
            int round = Math.round(((float) (iArr[0] + (viewGroup.getWidth() / 2))) + viewGroup.getTranslationX());
            i12 = Math.round(((float) (iArr[1] + (viewGroup.getHeight() / 2))) + viewGroup.getTranslationY());
            i13 = round;
        }
        float h11 = h((float) f11, (float) g11, (float) i13, (float) i12) / h(0.0f, 0.0f, (float) viewGroup.getWidth(), (float) viewGroup.getHeight());
        long duration = transition.getDuration();
        if (duration < 0) {
            duration = 300;
        }
        return (long) Math.round((((float) (duration * ((long) i11))) / this.f11789b) * h11);
    }
}
