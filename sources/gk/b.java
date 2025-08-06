package gk;

import android.animation.ValueAnimator;
import com.huobi.edgeengine.widget.view.LightingAnimationView;

public final /* synthetic */ class b implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LightingAnimationView f54824b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ float f54825c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ float f54826d;

    public /* synthetic */ b(LightingAnimationView lightingAnimationView, float f11, float f12) {
        this.f54824b = lightingAnimationView;
        this.f54825c = f11;
        this.f54826d = f12;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f54824b.b(this.f54825c, this.f54826d, valueAnimator);
    }
}
