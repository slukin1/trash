package dx;

import android.animation.ValueAnimator;
import android.view.View;
import com.lauzy.freedom.lbehaviorlib.anim.AbsBehaviorAnim;

public class c extends AbsBehaviorAnim {

    /* renamed from: c  reason: collision with root package name */
    public float f28884c;

    /* renamed from: d  reason: collision with root package name */
    public View f28885d;

    /* renamed from: e  reason: collision with root package name */
    public float f28886e;

    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            c.this.f28885d.setY(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    public class b implements ValueAnimator.AnimatorUpdateListener {
        public b() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            c.this.f28885d.setY(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    public c(View view, View view2) {
        this.f28885d = view2;
        if (view != null && view2 != null) {
            this.f28884c = ((float) view.getHeight()) - view2.getY();
            this.f28886e = view2.getY();
        }
    }

    public void hide() {
        float f11 = this.f28886e;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{f11, f11 + this.f28884c});
        ofFloat.setDuration((long) c());
        ofFloat.setInterpolator(d());
        ofFloat.addUpdateListener(new b());
        ofFloat.start();
    }

    public void show() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{this.f28885d.getY(), this.f28886e});
        ofFloat.setDuration((long) c());
        ofFloat.setInterpolator(d());
        ofFloat.addUpdateListener(new a());
        ofFloat.start();
    }
}
