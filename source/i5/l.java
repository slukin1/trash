package i5;

import android.graphics.Canvas;
import android.graphics.Path;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.utils.ViewPortHandler;
import g5.h;

public abstract class l extends c {

    /* renamed from: h  reason: collision with root package name */
    public Path f66347h = new Path();

    public l(ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
    }

    public void k(Canvas canvas, float f11, float f12, h hVar) {
        this.f66318d.setColor(hVar.getHighLightColor());
        this.f66318d.setStrokeWidth(hVar.Q());
        this.f66318d.setPathEffect(hVar.X());
        if (hVar.k()) {
            this.f66347h.reset();
            this.f66347h.moveTo(f11, this.f66370a.j());
            this.f66347h.lineTo(f11, this.f66370a.f());
            canvas.drawPath(this.f66347h, this.f66318d);
        }
        if (hVar.a0()) {
            this.f66347h.reset();
            this.f66347h.moveTo(this.f66370a.h(), f12);
            this.f66347h.lineTo(this.f66370a.i(), f12);
            canvas.drawPath(this.f66347h, this.f66318d);
        }
    }
}
