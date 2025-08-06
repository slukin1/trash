package com.huobi.view.chart.jobs;

import android.view.View;
import com.huobi.view.chart.utils.ObjectPool;
import com.huobi.view.chart.utils.Transformer;
import com.huobi.view.chart.utils.ViewPortHandler;

public class MoveViewJob extends ViewPortJob {
    private static ObjectPool<MoveViewJob> pool;

    static {
        ObjectPool<MoveViewJob> create = ObjectPool.create(2, new MoveViewJob((ViewPortHandler) null, 0.0f, 0.0f, (Transformer) null, (View) null));
        pool = create;
        create.setReplenishPercentage(0.5f);
    }

    public MoveViewJob(ViewPortHandler viewPortHandler, float f11, float f12, Transformer transformer, View view) {
        super(viewPortHandler, f11, f12, transformer, view);
    }

    public static MoveViewJob getInstance(ViewPortHandler viewPortHandler, float f11, float f12, Transformer transformer, View view) {
        MoveViewJob moveViewJob = pool.get();
        moveViewJob.mViewPortHandler = viewPortHandler;
        moveViewJob.xValue = f11;
        moveViewJob.yValue = f12;
        moveViewJob.mTrans = transformer;
        moveViewJob.view = view;
        return moveViewJob;
    }

    public static void recycleInstance(MoveViewJob moveViewJob) {
        pool.recycle(moveViewJob);
    }

    public ObjectPool.Poolable instantiate() {
        return new MoveViewJob(this.mViewPortHandler, this.xValue, this.yValue, this.mTrans, this.view);
    }

    public void run() {
        float[] fArr = this.pts;
        fArr[0] = this.xValue;
        fArr[1] = this.yValue;
        this.mTrans.pointValuesToPixel(fArr);
        this.mViewPortHandler.centerViewPort(this.pts, this.view);
        recycleInstance(this);
    }
}
