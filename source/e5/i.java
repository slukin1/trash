package e5;

import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import g5.e;
import java.util.List;

public class i extends h<RadarChart> {
    public i(RadarChart radarChart) {
        super(radarChart);
    }

    public d a(int i11, float f11, float f12) {
        List<d> b11 = b(i11);
        float x11 = ((RadarChart) this.f66237a).x(f11, f12) / ((RadarChart) this.f66237a).getFactor();
        d dVar = null;
        float f13 = Float.MAX_VALUE;
        for (int i12 = 0; i12 < b11.size(); i12++) {
            d dVar2 = b11.get(i12);
            float abs = Math.abs(dVar2.j() - x11);
            if (abs < f13) {
                dVar = dVar2;
                f13 = abs;
            }
        }
        return dVar;
    }

    public List<d> b(int i11) {
        int i12 = i11;
        this.f66238b.clear();
        float a11 = ((RadarChart) this.f66237a).getAnimator().a();
        float b11 = ((RadarChart) this.f66237a).getAnimator().b();
        float sliceAngle = ((RadarChart) this.f66237a).getSliceAngle();
        float factor = ((RadarChart) this.f66237a).getFactor();
        MPPointF c11 = MPPointF.c(0.0f, 0.0f);
        int i13 = 0;
        while (i13 < ((RadarData) ((RadarChart) this.f66237a).getData()).f()) {
            e e11 = ((RadarData) ((RadarChart) this.f66237a).getData()).e(i13);
            Entry entryForIndex = e11.getEntryForIndex(i12);
            float f11 = (float) i12;
            Utils.r(((RadarChart) this.f66237a).getCenterOffsets(), (entryForIndex.getY() - ((RadarChart) this.f66237a).getYChartMin()) * factor * b11, (sliceAngle * f11 * a11) + ((RadarChart) this.f66237a).getRotationAngle(), c11);
            List<d> list = this.f66238b;
            d dVar = r8;
            d dVar2 = new d(f11, entryForIndex.getY(), c11.f65546c, c11.f65547d, i13, e11.getAxisDependency());
            list.add(dVar);
            i13++;
            i12 = i11;
        }
        return this.f66238b;
    }
}
