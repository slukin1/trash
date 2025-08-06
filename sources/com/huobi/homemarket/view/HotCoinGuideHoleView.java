package com.huobi.homemarket.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.module.market.R$color;
import i6.d;
import kotlin.jvm.internal.r;

public final class HotCoinGuideHoleView extends View {

    /* renamed from: b  reason: collision with root package name */
    public final Path f73011b;

    /* renamed from: c  reason: collision with root package name */
    public float f73012c;

    /* renamed from: d  reason: collision with root package name */
    public float f73013d;

    /* renamed from: e  reason: collision with root package name */
    public float f73014e;

    /* renamed from: f  reason: collision with root package name */
    public float f73015f;

    /* renamed from: g  reason: collision with root package name */
    public float f73016g;

    /* renamed from: h  reason: collision with root package name */
    public float f73017h;

    /* renamed from: i  reason: collision with root package name */
    public int f73018i;

    /* renamed from: j  reason: collision with root package name */
    public final float f73019j;

    /* renamed from: k  reason: collision with root package name */
    public final Paint f73020k;

    public HotCoinGuideHoleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HotCoinGuideHoleView(Context context, AttributeSet attributeSet, int i11, int i12, r rVar) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    public final void a(double d11, double d12, double d13, double d14) {
        this.f73014e = PixelUtils.b((float) d11) - 0.5f;
        this.f73015f = PixelUtils.b((float) d12) - 0.5f;
        this.f73016g = PixelUtils.b((float) d13) - 0.5f;
        this.f73017h = PixelUtils.b((float) d14) - 0.5f;
        d.c("HotCoinGuideHoleView", "setHotPosition mHoleTop=" + this.f73014e + " mHoleLeft=" + this.f73015f + "  mHoleWidth=" + this.f73016g + " mHoleHeight=" + this.f73017h);
        invalidate();
    }

    public void onDraw(Canvas canvas) {
        canvas.save();
        this.f73011b.reset();
        this.f73011b.moveTo(this.f73015f, this.f73014e);
        Path path = this.f73011b;
        float f11 = this.f73015f;
        float f12 = this.f73014e;
        float f13 = this.f73019j;
        path.addRoundRect(f11, f12, this.f73016g + f11, f12 + this.f73017h, f13, f13, Path.Direction.CW);
        this.f73011b.lineTo(this.f73015f, this.f73014e);
        this.f73011b.lineTo(0.0f, 0.0f);
        this.f73011b.lineTo(0.0f, this.f73013d);
        this.f73011b.lineTo(this.f73012c, this.f73013d);
        this.f73011b.lineTo(this.f73012c, 0.0f);
        this.f73011b.lineTo(0.0f, 0.0f);
        this.f73011b.close();
        canvas.drawPath(this.f73011b, this.f73020k);
        canvas.restore();
    }

    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        this.f73012c = (float) i11;
        this.f73013d = (float) i12;
    }

    public HotCoinGuideHoleView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f73011b = new Path();
        this.f73014e = (float) PixelUtils.a(239.0f);
        this.f73015f = (float) PixelUtils.a(16.0f);
        this.f73016g = (float) PixelUtils.a(296.0f);
        this.f73017h = (float) PixelUtils.a(163.0f);
        this.f73018i = ContextCompat.getColor(context, R$color.KBasePopCoverColor);
        this.f73019j = (float) PixelUtils.a(8.0f);
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(this.f73018i);
        this.f73020k = paint;
    }
}
