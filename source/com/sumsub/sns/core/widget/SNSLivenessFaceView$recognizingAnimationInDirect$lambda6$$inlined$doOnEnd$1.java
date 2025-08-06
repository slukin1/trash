package com.sumsub.sns.core.widget;

import android.animation.Animator;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"androidx/core/animation/AnimatorKt$addListener$listener$1", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animator", "", "onAnimationRepeat", "onAnimationEnd", "onAnimationCancel", "onAnimationStart", "core-ktx_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.sumsub.sns.core.widget.SNSLivenessFaceView$recognizingAnimationInDirect$lambda-6$$inlined$doOnEnd$1  reason: invalid class name */
public final class SNSLivenessFaceView$recognizingAnimationInDirect$lambda6$$inlined$doOnEnd$1 implements Animator.AnimatorListener {
    public final /* synthetic */ SNSLivenessFaceView this$0;

    public SNSLivenessFaceView$recognizingAnimationInDirect$lambda6$$inlined$doOnEnd$1(SNSLivenessFaceView sNSLivenessFaceView) {
        this.this$0 = sNSLivenessFaceView;
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
        if (!this.this$0.isAnalyzing()) {
            this.this$0.recognizingAnimationDirect.start();
        }
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
    }
}
