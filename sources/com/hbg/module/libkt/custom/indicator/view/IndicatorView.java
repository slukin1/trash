package com.hbg.module.libkt.custom.indicator.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.hbg.module.libkt.custom.indicator.view.base.BaseIndicatorView;
import com.hbg.module.libkt.custom.indicator.view.option.IndicatorOptions;
import kotlin.jvm.internal.r;
import qe.a;
import qe.e;

public final class IndicatorView extends BaseIndicatorView {

    /* renamed from: g  reason: collision with root package name */
    public e f24839g;

    public IndicatorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ IndicatorView(Context context, AttributeSet attributeSet, int i11, int i12, r rVar) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    public void d() {
        this.f24839g = new e(getMIndicatorOptions());
        super.d();
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        e eVar = this.f24839g;
        if (eVar != null) {
            eVar.a(canvas);
        }
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        super.onLayout(z11, i11, i12, i13, i14);
        e eVar = this.f24839g;
        if (eVar != null) {
            eVar.c(z11, i11, i12, i13, i14);
        }
    }

    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        a.b d11 = this.f24839g.d(i11, i12);
        setMeasuredDimension(d11.b(), d11.a());
    }

    public void setIndicatorOptions(IndicatorOptions indicatorOptions) {
        super.setIndicatorOptions(indicatorOptions);
        e eVar = this.f24839g;
        if (eVar != null) {
            eVar.e(indicatorOptions);
        }
    }

    public IndicatorView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f24839g = new e(getMIndicatorOptions());
    }
}
