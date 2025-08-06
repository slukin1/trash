package i5;

import android.graphics.Canvas;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import g5.j;
import k5.a;

public class s extends q {

    /* renamed from: p  reason: collision with root package name */
    public RadarChart f66383p;

    public s(ViewPortHandler viewPortHandler, XAxis xAxis, RadarChart radarChart) {
        super(viewPortHandler, xAxis, (a) null);
        this.f66383p = radarChart;
    }

    public void i(Canvas canvas) {
        if (this.f66373h.f() && this.f66373h.A()) {
            float O = this.f66373h.O();
            MPPointF c11 = MPPointF.c(0.5f, 0.25f);
            this.f66288e.setTypeface(this.f66373h.c());
            this.f66288e.setTextSize(this.f66373h.b());
            this.f66288e.setColor(this.f66373h.a());
            float sliceAngle = this.f66383p.getSliceAngle();
            float factor = this.f66383p.getFactor();
            MPPointF centerOffsets = this.f66383p.getCenterOffsets();
            MPPointF c12 = MPPointF.c(0.0f, 0.0f);
            for (int i11 = 0; i11 < ((j) ((RadarData) this.f66383p.getData()).l()).getEntryCount(); i11++) {
                float f11 = (float) i11;
                String a11 = this.f66373h.w().a(f11, this.f66373h);
                Utils.r(centerOffsets, (this.f66383p.getYRange() * factor) + (((float) this.f66373h.K) / 2.0f), ((f11 * sliceAngle) + this.f66383p.getRotationAngle()) % 360.0f, c12);
                f(canvas, a11, c12.f65546c, c12.f65547d - (((float) this.f66373h.L) / 2.0f), c11, O);
            }
            MPPointF.f(centerOffsets);
            MPPointF.f(c12);
            MPPointF.f(c11);
        }
    }

    public void n(Canvas canvas) {
    }
}
