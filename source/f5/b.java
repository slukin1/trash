package f5;

import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarLineScatterCandleBubbleData;
import k5.a;

public interface b extends e {
    a d(YAxis.AxisDependency axisDependency);

    boolean e(YAxis.AxisDependency axisDependency);

    BarLineScatterCandleBubbleData getData();

    float getHighestVisibleX();

    float getLowestVisibleX();
}
