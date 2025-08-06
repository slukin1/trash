package g5;

import android.graphics.DashPathEffect;
import android.graphics.Typeface;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.utils.MPPointF;
import java.util.List;

public interface e<T extends Entry> {
    void I(d5.e eVar);

    T W(float f11, float f12, DataSet.Rounding rounding);

    int b(T t11);

    void calcMinMax();

    void calcMinMaxY(float f11, float f12);

    YAxis.AxisDependency getAxisDependency();

    int getColor();

    int getColor(int i11);

    List<Integer> getColors();

    List<T> getEntriesForXValue(float f11);

    int getEntryCount();

    T getEntryForIndex(int i11);

    T getEntryForXValue(float f11, float f12);

    Legend.LegendForm getForm();

    DashPathEffect getFormLineDashEffect();

    float getFormLineWidth();

    float getFormSize();

    MPPointF getIconsOffset();

    String getLabel();

    d5.e getValueFormatter();

    int getValueTextColor(int i11);

    float getValueTextSize();

    Typeface getValueTypeface();

    float getXMax();

    float getXMin();

    float getYMax();

    float getYMin();

    boolean isDrawIconsEnabled();

    boolean isDrawValuesEnabled();

    boolean isHighlightEnabled();

    boolean isVisible();

    boolean needsFormatter();

    void setDrawValues(boolean z11);

    void setValueTextSize(float f11);
}
