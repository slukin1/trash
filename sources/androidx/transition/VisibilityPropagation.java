package androidx.transition;

import android.view.View;

public abstract class VisibilityPropagation extends TransitionPropagation {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f11891a = {"android:visibilityPropagation:visibility", "android:visibilityPropagation:center"};

    public static int d(TransitionValues transitionValues, int i11) {
        int[] iArr;
        if (transitionValues == null || (iArr = (int[]) transitionValues.f11865a.get("android:visibilityPropagation:center")) == null) {
            return -1;
        }
        return iArr[i11];
    }

    public void a(TransitionValues transitionValues) {
        View view = transitionValues.f11866b;
        Integer num = (Integer) transitionValues.f11865a.get(Visibility.PROPNAME_VISIBILITY);
        if (num == null) {
            num = Integer.valueOf(view.getVisibility());
        }
        transitionValues.f11865a.put("android:visibilityPropagation:visibility", num);
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        iArr[0] = iArr[0] + Math.round(view.getTranslationX());
        iArr[0] = iArr[0] + (view.getWidth() / 2);
        iArr[1] = iArr[1] + Math.round(view.getTranslationY());
        iArr[1] = iArr[1] + (view.getHeight() / 2);
        transitionValues.f11865a.put("android:visibilityPropagation:center", iArr);
    }

    public String[] b() {
        return f11891a;
    }

    public int e(TransitionValues transitionValues) {
        Integer num;
        if (transitionValues == null || (num = (Integer) transitionValues.f11865a.get("android:visibilityPropagation:visibility")) == null) {
            return 8;
        }
        return num.intValue();
    }

    public int f(TransitionValues transitionValues) {
        return d(transitionValues, 0);
    }

    public int g(TransitionValues transitionValues) {
        return d(transitionValues, 1);
    }
}
