package com.huobi.index.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.hbg.module.libkt.custom.indicator.view.base.BaseIndicatorView;
import com.hbg.module.libkt.custom.indicator.view.option.IndicatorOptions;
import com.huobi.index.helper.AttrsController;
import kotlin.jvm.internal.r;
import qe.a;
import qe.e;

public final class HBIndicatorView extends BaseIndicatorView {

    /* renamed from: g  reason: collision with root package name */
    public e f73997g;

    public HBIndicatorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HBIndicatorView(Context context, AttributeSet attributeSet, int i11, int i12, r rVar) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    public void d() {
        this.f73997g = new e(getMIndicatorOptions());
        super.d();
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        p(canvas);
        this.f73997g.a(canvas);
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        super.onLayout(z11, i11, i12, i13, i14);
        this.f73997g.c(z11, i11, i12, i13, i14);
    }

    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        a.b d11 = this.f73997g.d(i11, i12);
        setMeasuredDimension(d11.b(), d11.a());
    }

    public final void p(Canvas canvas) {
        if (getMIndicatorOptions().g() == 1) {
            canvas.rotate(90.0f, ((float) getWidth()) / 2.0f, ((float) getWidth()) / 2.0f);
        } else if (getMIndicatorOptions().g() == 3) {
            canvas.rotate(180.0f, ((float) getWidth()) / 2.0f, ((float) getHeight()) / 2.0f);
        }
    }

    public void setIndicatorOptions(IndicatorOptions indicatorOptions) {
        super.setIndicatorOptions(indicatorOptions);
        this.f73997g.e(indicatorOptions);
    }

    public final void setOrientation(int i11) {
        getMIndicatorOptions().s(i11);
    }

    public HBIndicatorView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        AttrsController.a(context, attributeSet, getMIndicatorOptions());
        this.f73997g = new e(getMIndicatorOptions());
    }
}
