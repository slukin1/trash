package dx;

import android.animation.ValueAnimator;
import android.view.View;
import com.lauzy.freedom.lbehaviorlib.anim.AbsBehaviorAnim;

public class d extends AbsBehaviorAnim {

    /* renamed from: c  reason: collision with root package name */
    public View f28889c;

    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            d.this.f28889c.setY(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    public class b implements ValueAnimator.AnimatorUpdateListener {
        public b() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            d.this.f28889c.setY(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    public d(View view) {
        this.f28889c = view;
    }

    public void hide() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{this.f28889c.getY(), (float) (-this.f28889c.getHeight())});
        ofFloat.setDuration((long) c());
        ofFloat.setInterpolator(d());
        ofFloat.addUpdateListener(new b());
        ofFloat.start();
    }

    public void show() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{this.f28889c.getY(), 0.0f});
        ofFloat.setDuration((long) c());
        ofFloat.setInterpolator(d());
        ofFloat.addUpdateListener(new a());
        ofFloat.start();
    }
}
