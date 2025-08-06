package com.huobi.tradenew.guide;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import android.view.View;
import com.hbg.lib.core.util.NightHelper;

public class TradeVerticalSpotUserGuideMaskView extends View {

    /* renamed from: b  reason: collision with root package name */
    public Paint f82820b = new Paint();

    /* renamed from: c  reason: collision with root package name */
    public int f82821c;

    /* renamed from: d  reason: collision with root package name */
    public Rect f82822d;

    /* renamed from: e  reason: collision with root package name */
    public PorterDuffXfermode f82823e = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);

    public TradeVerticalSpotUserGuideMaskView(Context context) {
        super(context);
        a();
    }

    public final void a() {
        setClickable(true);
        if (!NightHelper.e().g()) {
            this.f82821c = -2145641442;
        } else {
            this.f82821c = -872415232;
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int saveLayer = canvas.saveLayer(0.0f, 0.0f, (float) getWidth(), (float) getHeight(), (Paint) null, 31);
        canvas.drawColor(this.f82821c);
        if (this.f82822d != null) {
            this.f82820b.setXfermode(this.f82823e);
            this.f82820b.setColor(0);
            canvas.drawRect(this.f82822d, this.f82820b);
            this.f82820b.setXfermode((Xfermode) null);
        }
        canvas.restoreToCount(saveLayer);
    }

    public void setRect(Rect rect) {
        this.f82822d = rect;
        invalidate();
    }

    public TradeVerticalSpotUserGuideMaskView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public TradeVerticalSpotUserGuideMaskView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        a();
    }
}
