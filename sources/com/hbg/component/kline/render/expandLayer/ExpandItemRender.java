package com.hbg.component.kline.render.expandLayer;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.hbg.component.kline.render.CandleStickRender;
import java.util.LinkedHashSet;
import u5.a;
import u5.e;
import u5.h;
import v5.j;

public class ExpandItemRender extends CandleStickRender {
    public void R() {
        float f11;
        if (this.f67217c0.f68331z.width() == 0.0f) {
            int i11 = this.f67202g;
            f11 = ((float) i11) - (((float) (i11 / 5)) * 0.75f);
        } else {
            f11 = this.f67217c0.f68331z.width();
        }
        float i12 = f11 / ((float) i1());
        this.f67285x0 = i12;
        this.f67282w0 = i12;
        this.X1 = i12;
        this.f67288y0 = f11 / ((float) A2());
        this.f67291z0 = f11 / ((float) B2());
    }

    public void a(Canvas canvas) {
        this.f67211a0.y(canvas);
        if (B3()) {
            this.f67229g0.y(canvas);
            this.f67220d0.y(canvas);
        }
    }

    public j a0() {
        return new a(this, this.f67200e);
    }

    public boolean b(MotionEvent motionEvent) {
        return false;
    }

    public j b0() {
        return new e(this, this.f67200e);
    }

    public j c0() {
        return new h(this, this.f67200e);
    }

    public int h() {
        return (int) this.f67217c0.f68331z.width();
    }

    public int i() {
        return (int) this.f67217c0.f68331z.width();
    }

    public void j(View view, Context context, AttributeSet attributeSet, int i11) {
        super.j(view, context, attributeSet, i11);
        A4(0);
        G4("VOL");
        H4((LinkedHashSet<String>) null);
        z4(CandleStickRender.KLineType.EXPAND_TIME_LINE);
    }

    public void w3() {
    }
}
