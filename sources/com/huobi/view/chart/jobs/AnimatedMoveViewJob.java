package com.huobi.view.chart.jobs;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.view.View;
import com.huobi.view.chart.utils.ObjectPool;
import com.huobi.view.chart.utils.Transformer;
import com.huobi.view.chart.utils.ViewPortHandler;

@SuppressLint({"NewApi"})
public class AnimatedMoveViewJob extends AnimatedViewPortJob {
    private static ObjectPool<AnimatedMoveViewJob> pool;

    static {
        ObjectPool<AnimatedMoveViewJob> create = ObjectPool.create(4, new AnimatedMoveViewJob((ViewPortHandler) null, 0.0f, 0.0f, (Transformer) null, (View) null, 0.0f, 0.0f, 0));
        pool = create;
        create.setReplenishPercentage(0.5f);
    }

    public AnimatedMoveViewJob(ViewPortHandler viewPortHandler, float f11, float f12, Transformer transformer, View view, float f13, float f14, long j11) {
        super(viewPortHandler, f11, f12, transformer, view, f13, f14, j11);
    }

    public static AnimatedMoveViewJob getInstance(ViewPortHandler viewPortHandler, float f11, float f12, Transformer transformer, View view, float f13, float f14, long j11) {
        AnimatedMoveViewJob animatedMoveViewJob = pool.get();
        animatedMoveViewJob.mViewPortHandler = viewPortHandler;
        animatedMoveViewJob.xValue = f11;
        animatedMoveViewJob.yValue = f12;
        animatedMoveViewJob.mTrans = transformer;
        animatedMoveViewJob.view = view;
        animatedMoveViewJob.xOrigin = f13;
        animatedMoveViewJob.yOrigin = f14;
        animatedMoveViewJob.animator.setDuration(j11);
        return animatedMoveViewJob;
    }

    public static void recycleInstance(AnimatedMoveViewJob animatedMoveViewJob) {
        pool.recycle(animatedMoveViewJob);
    }

    public ObjectPool.Poolable instantiate() {
        return new AnimatedMoveViewJob((ViewPortHandler) null, 0.0f, 0.0f, (Transformer) null, (View) null, 0.0f, 0.0f, 0);
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float[] fArr = this.pts;
        float f11 = this.xOrigin;
        float f12 = this.phase;
        fArr[0] = f11 + ((this.xValue - f11) * f12);
        float f13 = this.yOrigin;
        fArr[1] = f13 + ((this.yValue - f13) * f12);
        this.mTrans.pointValuesToPixel(fArr);
        this.mViewPortHandler.centerViewPort(this.pts, this.view);
    }

    public void recycleSelf() {
        recycleInstance(this);
    }
}
