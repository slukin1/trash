package androidx.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class ChangeScroll extends Transition {

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f11758b = {"android:changeScroll:x", "android:changeScroll:y"};

    public ChangeScroll() {
    }

    public void captureEndValues(TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    public void captureStartValues(TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    public final void captureValues(TransitionValues transitionValues) {
        transitionValues.f11865a.put("android:changeScroll:x", Integer.valueOf(transitionValues.f11866b.getScrollX()));
        transitionValues.f11865a.put("android:changeScroll:y", Integer.valueOf(transitionValues.f11866b.getScrollY()));
    }

    public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        ObjectAnimator objectAnimator;
        ObjectAnimator objectAnimator2 = null;
        if (transitionValues == null || transitionValues2 == null) {
            return null;
        }
        View view = transitionValues2.f11866b;
        int intValue = ((Integer) transitionValues.f11865a.get("android:changeScroll:x")).intValue();
        int intValue2 = ((Integer) transitionValues2.f11865a.get("android:changeScroll:x")).intValue();
        int intValue3 = ((Integer) transitionValues.f11865a.get("android:changeScroll:y")).intValue();
        int intValue4 = ((Integer) transitionValues2.f11865a.get("android:changeScroll:y")).intValue();
        if (intValue != intValue2) {
            view.setScrollX(intValue);
            objectAnimator = ObjectAnimator.ofInt(view, "scrollX", new int[]{intValue, intValue2});
        } else {
            objectAnimator = null;
        }
        if (intValue3 != intValue4) {
            view.setScrollY(intValue3);
            objectAnimator2 = ObjectAnimator.ofInt(view, "scrollY", new int[]{intValue3, intValue4});
        }
        return c.c(objectAnimator, objectAnimator2);
    }

    public String[] getTransitionProperties() {
        return f11758b;
    }

    public ChangeScroll(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
