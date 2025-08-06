package zendesk.classic.messaging.ui;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;

public class d0 {

    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: b  reason: collision with root package name */
        public final int f62782b;

        /* renamed from: c  reason: collision with root package name */
        public final int f62783c;

        /* renamed from: d  reason: collision with root package name */
        public final int f62784d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f62785e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ValueAnimator f62786f;

        public a(View view, ValueAnimator valueAnimator) {
            this.f62785e = view;
            this.f62786f = valueAnimator;
            this.f62782b = view.getPaddingLeft();
            this.f62783c = view.getPaddingRight();
            this.f62784d = view.getPaddingBottom();
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f62785e.setPadding(this.f62782b, ((Integer) this.f62786f.getAnimatedValue()).intValue(), this.f62783c, this.f62784d);
        }
    }

    public class b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ViewGroup.MarginLayoutParams f62787b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ View f62788c;

        public b(ViewGroup.MarginLayoutParams marginLayoutParams, View view) {
            this.f62787b = marginLayoutParams;
            this.f62788c = view;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f62787b.topMargin = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            this.f62788c.requestLayout();
        }
    }

    public static ValueAnimator a(View view, int i11, int i12, long j11) {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{i11, i12});
        ofInt.addUpdateListener(new b((ViewGroup.MarginLayoutParams) view.getLayoutParams(), view));
        ofInt.setDuration(j11);
        return ofInt;
    }

    public static ValueAnimator b(View view, int i11, int i12, long j11) {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{i11, i12});
        ofInt.addUpdateListener(new a(view, ofInt));
        ofInt.setDuration(j11);
        return ofInt;
    }
}
