package e5;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.charts.PieRadarChartBase;
import java.util.ArrayList;
import java.util.List;

public abstract class h<T extends PieRadarChartBase> implements f {

    /* renamed from: a  reason: collision with root package name */
    public T f66237a;

    /* renamed from: b  reason: collision with root package name */
    public List<d> f66238b = new ArrayList();

    public h(T t11) {
        this.f66237a = t11;
    }

    public abstract d a(int i11, float f11, float f12);

    public d getHighlight(float f11, float f12) {
        if (this.f66237a.x(f11, f12) > this.f66237a.getRadius()) {
            return null;
        }
        float y11 = this.f66237a.y(f11, f12);
        T t11 = this.f66237a;
        if (t11 instanceof PieChart) {
            y11 /= t11.getAnimator().b();
        }
        int z11 = this.f66237a.z(y11);
        if (z11 < 0 || z11 >= this.f66237a.getData().l().getEntryCount()) {
            return null;
        }
        return a(z11, f11, f12);
    }
}
