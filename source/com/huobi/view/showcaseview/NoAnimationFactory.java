package com.huobi.view.showcaseview;

import android.graphics.Point;
import android.view.View;
import com.huobi.view.showcaseview.AnimationFactory;

class NoAnimationFactory implements AnimationFactory {
    public void animateTargetToPoint(ShowcaseView showcaseView, Point point) {
        showcaseView.setShowcasePosition(point.x, point.y);
    }

    public void fadeInView(View view, long j11, AnimationFactory.AnimationStartListener animationStartListener) {
        animationStartListener.onAnimationStart();
    }

    public void fadeOutView(View view, long j11, AnimationFactory.AnimationEndListener animationEndListener) {
        animationEndListener.onAnimationEnd();
    }
}
