package androidx.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

public class Explode extends Visibility {

    /* renamed from: c  reason: collision with root package name */
    public static final TimeInterpolator f11790c = new DecelerateInterpolator();

    /* renamed from: d  reason: collision with root package name */
    public static final TimeInterpolator f11791d = new AccelerateInterpolator();

    /* renamed from: b  reason: collision with root package name */
    public int[] f11792b = new int[2];

    public Explode() {
        setPropagation(new CircularPropagation());
    }

    public static float b(float f11, float f12) {
        return (float) Math.sqrt((double) ((f11 * f11) + (f12 * f12)));
    }

    public static float c(View view, int i11, int i12) {
        return b((float) Math.max(i11, view.getWidth() - i11), (float) Math.max(i12, view.getHeight() - i12));
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
        View view = transitionValues.f11866b;
        view.getLocationOnScreen(this.f11792b);
        int[] iArr = this.f11792b;
        int i11 = iArr[0];
        int i12 = iArr[1];
        transitionValues.f11865a.put("android:explode:screenBounds", new Rect(i11, i12, view.getWidth() + i11, view.getHeight() + i12));
    }

    public final void d(View view, Rect rect, int[] iArr) {
        int i11;
        int i12;
        View view2 = view;
        view2.getLocationOnScreen(this.f11792b);
        int[] iArr2 = this.f11792b;
        int i13 = iArr2[0];
        int i14 = iArr2[1];
        Rect epicenter = getEpicenter();
        if (epicenter == null) {
            i12 = (view.getWidth() / 2) + i13 + Math.round(view.getTranslationX());
            i11 = (view.getHeight() / 2) + i14 + Math.round(view.getTranslationY());
        } else {
            int centerX = epicenter.centerX();
            i11 = epicenter.centerY();
            i12 = centerX;
        }
        float centerX2 = (float) (rect.centerX() - i12);
        float centerY = (float) (rect.centerY() - i11);
        if (centerX2 == 0.0f && centerY == 0.0f) {
            centerX2 = ((float) (Math.random() * 2.0d)) - 1.0f;
            centerY = ((float) (Math.random() * 2.0d)) - 1.0f;
        }
        float b11 = b(centerX2, centerY);
        float c11 = c(view2, i12 - i13, i11 - i14);
        iArr[0] = Math.round((centerX2 / b11) * c11);
        iArr[1] = Math.round(c11 * (centerY / b11));
    }

    public Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues2 == null) {
            return null;
        }
        Rect rect = (Rect) transitionValues2.f11865a.get("android:explode:screenBounds");
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        d(viewGroup, rect, this.f11792b);
        int[] iArr = this.f11792b;
        return d.a(view, transitionValues2, rect.left, rect.top, translationX + ((float) iArr[0]), translationY + ((float) iArr[1]), translationX, translationY, f11790c, this);
    }

    public Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        float f11;
        float f12;
        if (transitionValues == null) {
            return null;
        }
        Rect rect = (Rect) transitionValues.f11865a.get("android:explode:screenBounds");
        int i11 = rect.left;
        int i12 = rect.top;
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        int[] iArr = (int[]) transitionValues.f11866b.getTag(R$id.transition_position);
        if (iArr != null) {
            f12 = ((float) (iArr[0] - rect.left)) + translationX;
            f11 = ((float) (iArr[1] - rect.top)) + translationY;
            rect.offsetTo(iArr[0], iArr[1]);
        } else {
            f12 = translationX;
            f11 = translationY;
        }
        d(viewGroup, rect, this.f11792b);
        int[] iArr2 = this.f11792b;
        return d.a(view, transitionValues, i11, i12, translationX, translationY, f12 + ((float) iArr2[0]), f11 + ((float) iArr2[1]), f11791d, this);
    }

    public Explode(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setPropagation(new CircularPropagation());
    }
}
