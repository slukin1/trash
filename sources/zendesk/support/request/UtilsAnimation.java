package zendesk.support.request;

import android.animation.ValueAnimator;
import android.view.View;
import android.widget.FrameLayout;

class UtilsAnimation {
    private UtilsAnimation() {
    }

    public static ValueAnimator bottomPaddingAnimator(View view, int i11, int i12, int i13) {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{i11, i12});
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(view, ofInt) {
            public final int paddingLeft;
            public final int paddingRight;
            public final int paddingTop;
            public final /* synthetic */ ValueAnimator val$valueAnimator;
            public final /* synthetic */ View val$view;

            {
                this.val$view = r1;
                this.val$valueAnimator = r2;
                this.paddingLeft = r1.getPaddingLeft();
                this.paddingRight = r1.getPaddingRight();
                this.paddingTop = r1.getPaddingTop();
            }

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.val$view.setPadding(this.paddingLeft, this.paddingTop, this.paddingRight, ((Integer) this.val$valueAnimator.getAnimatedValue()).intValue());
            }
        });
        ofInt.setDuration((long) i13);
        return ofInt;
    }

    public static ValueAnimator minHeightAnimator(final View view, int i11, int i12, int i13) {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{i11, i12});
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                view.setMinimumHeight(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        ofInt.setDuration((long) i13);
        return ofInt;
    }

    public static ValueAnimator sideMarginsAnimator(final View view, int i11, int i12, int i13) {
        final FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{i11, i12});
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                layoutParams.leftMargin = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                layoutParams.rightMargin = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                view.requestLayout();
            }
        });
        ofInt.setDuration((long) i13);
        return ofInt;
    }

    public static ValueAnimator topPaddingAnimator(View view, int i11, int i12, int i13) {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{i11, i12});
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(view, ofInt) {
            public final int paddingBottom;
            public final int paddingLeft;
            public final int paddingRight;
            public final /* synthetic */ ValueAnimator val$valueAnimator;
            public final /* synthetic */ View val$view;

            {
                this.val$view = r1;
                this.val$valueAnimator = r2;
                this.paddingLeft = r1.getPaddingLeft();
                this.paddingRight = r1.getPaddingRight();
                this.paddingBottom = r1.getPaddingBottom();
            }

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.val$view.setPadding(this.paddingLeft, ((Integer) this.val$valueAnimator.getAnimatedValue()).intValue(), this.paddingRight, this.paddingBottom);
            }
        });
        ofInt.setDuration((long) i13);
        return ofInt;
    }
}
