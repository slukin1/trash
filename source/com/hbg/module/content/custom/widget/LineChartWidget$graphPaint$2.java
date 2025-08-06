package com.hbg.module.content.custom.widget;

import android.graphics.Paint;
import d10.a;
import kotlin.jvm.internal.Lambda;

public final class LineChartWidget$graphPaint$2 extends Lambda implements a<Paint> {
    public final /* synthetic */ LineChartWidget this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LineChartWidget$graphPaint$2(LineChartWidget lineChartWidget) {
        super(0);
        this.this$0 = lineChartWidget;
    }

    public final Paint invoke() {
        Paint paint = new Paint(1);
        paint.setStrokeWidth(this.this$0.f18181h);
        paint.setStrokeCap(Paint.Cap.ROUND);
        return paint;
    }
}
