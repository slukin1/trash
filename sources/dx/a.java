package dx;

import android.animation.ValueAnimator;
import android.view.View;
import com.lauzy.freedom.lbehaviorlib.anim.AbsBehaviorAnim;

public class a extends AbsBehaviorAnim {

    /* renamed from: c  reason: collision with root package name */
    public View f28877c;

    /* renamed from: d  reason: collision with root package name */
    public float f28878d;

    /* renamed from: dx.a$a  reason: collision with other inner class name */
    public class C0248a implements ValueAnimator.AnimatorUpdateListener {
        public C0248a() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            a.this.f28877c.setY(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    public class b implements ValueAnimator.AnimatorUpdateListener {
        public b() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            a.this.f28877c.setY(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    public a(View view) {
        this.f28877c = view;
        this.f28878d = view.getY();
    }

    public void hide() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{this.f28877c.getY(), this.f28878d + ((float) this.f28877c.getHeight())});
        ofFloat.setDuration((long) c());
        ofFloat.setInterpolator(d());
        ofFloat.addUpdateListener(new b());
        ofFloat.start();
    }

    public void show() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{this.f28877c.getY(), this.f28878d});
        ofFloat.setDuration((long) c());
        ofFloat.setInterpolator(d());
        ofFloat.addUpdateListener(new C0248a());
        ofFloat.start();
    }
}
