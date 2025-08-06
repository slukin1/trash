package e5;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import g5.i;

public class g extends h<PieChart> {
    public g(PieChart pieChart) {
        super(pieChart);
    }

    public d a(int i11, float f11, float f12) {
        i v11 = ((PieData) ((PieChart) this.f66237a).getData()).v();
        return new d((float) i11, v11.getEntryForIndex(i11).getY(), f11, f12, 0, v11.getAxisDependency());
    }
}
