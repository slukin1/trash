package com.huobi.otc.dialog;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Region;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.hbg.module.otc.R$dimen;

public class OtcRedEnvelopeDialogImgBgLayout extends ConstraintLayout {

    /* renamed from: b  reason: collision with root package name */
    public final Path f78316b;

    public OtcRedEnvelopeDialogImgBgLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void dispatchDraw(Canvas canvas) {
        float dimensionPixelOffset = (float) getResources().getDimensionPixelOffset(R$dimen.dimen_84);
        Resources resources = getResources();
        int i11 = R$dimen.dimen_10;
        float dimensionPixelOffset2 = (float) resources.getDimensionPixelOffset(i11);
        float dimensionPixelOffset3 = (float) getResources().getDimensionPixelOffset(i11);
        this.f78316b.addCircle(0.0f, ((float) getHeight()) - dimensionPixelOffset, dimensionPixelOffset2, Path.Direction.CCW);
        this.f78316b.addCircle((float) getWidth(), ((float) getHeight()) - dimensionPixelOffset, dimensionPixelOffset2, Path.Direction.CCW);
        float width = ((float) getWidth()) * 0.0625f;
        float width2 = (((float) getWidth()) * 0.031f) + (width / 2.0f);
        for (int i12 = 0; i12 < 8; i12++) {
            this.f78316b.addCircle(width2, (float) getHeight(), dimensionPixelOffset3, Path.Direction.CCW);
            width2 += width * 2.0f;
        }
        canvas.clipPath(this.f78316b, Region.Op.DIFFERENCE);
        super.dispatchDraw(canvas);
    }

    public final void h(Context context) {
    }

    public OtcRedEnvelopeDialogImgBgLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f78316b = new Path();
        h(context);
    }
}
