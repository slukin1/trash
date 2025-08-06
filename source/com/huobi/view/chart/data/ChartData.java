package com.huobi.view.chart.data;

import android.graphics.Typeface;
import android.util.Log;
import com.huobi.view.chart.components.YAxis;
import com.huobi.view.chart.formatter.ValueFormatter;
import com.huobi.view.chart.highlight.Highlight;
import com.huobi.view.chart.interfaces.datasets.IDataSet;
import java.util.ArrayList;
import java.util.List;

public abstract class ChartData<T extends IDataSet<? extends Entry>> {
    public List<T> mDataSets;
    public float mLeftAxisMax;
    public float mLeftAxisMin;
    public float mRightAxisMax;
    public float mRightAxisMin;
    public float mXMax;
    public float mXMin;
    public float mYMax;
    public float mYMin;

    public ChartData() {
        this.mYMax = -3.4028235E38f;
        this.mYMin = Float.MAX_VALUE;
        this.mXMax = -3.4028235E38f;
        this.mXMin = Float.MAX_VALUE;
        this.mLeftAxisMax = -3.4028235E38f;
        this.mLeftAxisMin = Float.MAX_VALUE;
        this.mRightAxisMax = -3.4028235E38f;
        this.mRightAxisMin = Float.MAX_VALUE;
        this.mDataSets = new ArrayList();
    }

    private List<T> arrayToList(T[] tArr) {
        ArrayList arrayList = new ArrayList();
        for (T add : tArr) {
            arrayList.add(add);
        }
        return arrayList;
    }

    public void addDataSet(T t11) {
        if (t11 != null) {
            calcMinMax(t11);
            this.mDataSets.add(t11);
        }
    }

    public void addEntry(Entry entry, int i11) {
        if (this.mDataSets.size() <= i11 || i11 < 0) {
            Log.e("addEntry", "Cannot add Entry because dataSetIndex too high or too low.");
            return;
        }
        IDataSet iDataSet = (IDataSet) this.mDataSets.get(i11);
        if (iDataSet.addEntry(entry)) {
            calcMinMax(entry, iDataSet.getAxisDependency());
        }
    }

    public void calcMinMax() {
        List<T> list = this.mDataSets;
        if (list != null) {
            this.mYMax = -3.4028235E38f;
            this.mYMin = Float.MAX_VALUE;
            this.mXMax = -3.4028235E38f;
            this.mXMin = Float.MAX_VALUE;
            for (T calcMinMax : list) {
                calcMinMax(calcMinMax);
            }
            this.mLeftAxisMax = -3.4028235E38f;
            this.mLeftAxisMin = Float.MAX_VALUE;
            this.mRightAxisMax = -3.4028235E38f;
            this.mRightAxisMin = Float.MAX_VALUE;
            IDataSet firstLeft = getFirstLeft(this.mDataSets);
            if (firstLeft != null) {
                this.mLeftAxisMax = firstLeft.getYMax();
                this.mLeftAxisMin = firstLeft.getYMin();
                for (T t11 : this.mDataSets) {
                    if (t11.getAxisDependency() == YAxis.AxisDependency.LEFT) {
                        if (t11.getYMin() < this.mLeftAxisMin) {
                            this.mLeftAxisMin = t11.getYMin();
                        }
                        if (t11.getYMax() > this.mLeftAxisMax) {
                            this.mLeftAxisMax = t11.getYMax();
                        }
                    }
                }
            }
            IDataSet firstRight = getFirstRight(this.mDataSets);
            if (firstRight != null) {
                this.mRightAxisMax = firstRight.getYMax();
                this.mRightAxisMin = firstRight.getYMin();
                for (T t12 : this.mDataSets) {
                    if (t12.getAxisDependency() == YAxis.AxisDependency.RIGHT) {
                        if (t12.getYMin() < this.mRightAxisMin) {
                            this.mRightAxisMin = t12.getYMin();
                        }
                        if (t12.getYMax() > this.mRightAxisMax) {
                            this.mRightAxisMax = t12.getYMax();
                        }
                    }
                }
            }
        }
    }

    public void calcMinMaxY(float f11, float f12) {
        for (T calcMinMaxY : this.mDataSets) {
            calcMinMaxY.calcMinMaxY(f11, f12);
        }
        calcMinMax();
    }

    public void clearValues() {
        List<T> list = this.mDataSets;
        if (list != null) {
            list.clear();
        }
        notifyDataChanged();
    }

    public boolean contains(T t11) {
        for (T equals : this.mDataSets) {
            if (equals.equals(t11)) {
                return true;
            }
        }
        return false;
    }

    public int[] getColors() {
        if (this.mDataSets == null) {
            return null;
        }
        int i11 = 0;
        for (int i12 = 0; i12 < this.mDataSets.size(); i12++) {
            i11 += ((IDataSet) this.mDataSets.get(i12)).getColors().size();
        }
        int[] iArr = new int[i11];
        int i13 = 0;
        for (int i14 = 0; i14 < this.mDataSets.size(); i14++) {
            for (Integer intValue : ((IDataSet) this.mDataSets.get(i14)).getColors()) {
                iArr[i13] = intValue.intValue();
                i13++;
            }
        }
        return iArr;
    }

    public T getDataSetByIndex(int i11) {
        List<T> list = this.mDataSets;
        if (list == null || i11 < 0 || i11 >= list.size()) {
            return null;
        }
        return (IDataSet) this.mDataSets.get(i11);
    }

    public T getDataSetByLabel(String str, boolean z11) {
        int dataSetIndexByLabel = getDataSetIndexByLabel(this.mDataSets, str, z11);
        if (dataSetIndexByLabel < 0 || dataSetIndexByLabel >= this.mDataSets.size()) {
            return null;
        }
        return (IDataSet) this.mDataSets.get(dataSetIndexByLabel);
    }

    public int getDataSetCount() {
        List<T> list = this.mDataSets;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public T getDataSetForEntry(Entry entry) {
        if (entry == null) {
            return null;
        }
        for (int i11 = 0; i11 < this.mDataSets.size(); i11++) {
            T t11 = (IDataSet) this.mDataSets.get(i11);
            for (int i12 = 0; i12 < t11.getEntryCount(); i12++) {
                if (entry.equalTo(t11.getEntryForXValue(entry.getX(), entry.getY()))) {
                    return t11;
                }
            }
        }
        return null;
    }

    public int getDataSetIndexByLabel(List<T> list, String str, boolean z11) {
        int i11 = 0;
        if (z11) {
            while (i11 < list.size()) {
                if (str.equalsIgnoreCase(((IDataSet) list.get(i11)).getLabel())) {
                    return i11;
                }
                i11++;
            }
            return -1;
        }
        while (i11 < list.size()) {
            if (str.equals(((IDataSet) list.get(i11)).getLabel())) {
                return i11;
            }
            i11++;
        }
        return -1;
    }

    public String[] getDataSetLabels() {
        String[] strArr = new String[this.mDataSets.size()];
        for (int i11 = 0; i11 < this.mDataSets.size(); i11++) {
            strArr[i11] = ((IDataSet) this.mDataSets.get(i11)).getLabel();
        }
        return strArr;
    }

    public List<T> getDataSets() {
        return this.mDataSets;
    }

    public int getEntryCount() {
        int i11 = 0;
        for (T entryCount : this.mDataSets) {
            i11 += entryCount.getEntryCount();
        }
        return i11;
    }

    public Entry getEntryForHighlight(Highlight highlight) {
        if (highlight.getDataSetIndex() >= this.mDataSets.size()) {
            return null;
        }
        return ((IDataSet) this.mDataSets.get(highlight.getDataSetIndex())).getEntryForXValue(highlight.getX(), highlight.getY());
    }

    public T getFirstLeft(List<T> list) {
        for (T t11 : list) {
            if (t11.getAxisDependency() == YAxis.AxisDependency.LEFT) {
                return t11;
            }
        }
        return null;
    }

    public T getFirstRight(List<T> list) {
        for (T t11 : list) {
            if (t11.getAxisDependency() == YAxis.AxisDependency.RIGHT) {
                return t11;
            }
        }
        return null;
    }

    public int getIndexOfDataSet(T t11) {
        return this.mDataSets.indexOf(t11);
    }

    public T getMaxEntryCountSet() {
        List<T> list = this.mDataSets;
        if (list == null || list.isEmpty()) {
            return null;
        }
        T t11 = (IDataSet) this.mDataSets.get(0);
        for (T t12 : this.mDataSets) {
            if (t12.getEntryCount() > t11.getEntryCount()) {
                t11 = t12;
            }
        }
        return t11;
    }

    public float getXMax() {
        return this.mXMax;
    }

    public float getXMin() {
        return this.mXMin;
    }

    public float getYMax() {
        return this.mYMax;
    }

    public float getYMin() {
        return this.mYMin;
    }

    public boolean isHighlightEnabled() {
        for (T isHighlightEnabled : this.mDataSets) {
            if (!isHighlightEnabled.isHighlightEnabled()) {
                return false;
            }
        }
        return true;
    }

    public void notifyDataChanged() {
        calcMinMax();
    }

    public boolean removeDataSet(T t11) {
        if (t11 == null) {
            return false;
        }
        boolean remove = this.mDataSets.remove(t11);
        if (remove) {
            calcMinMax();
        }
        return remove;
    }

    public boolean removeEntry(Entry entry, int i11) {
        IDataSet iDataSet;
        if (entry == null || i11 >= this.mDataSets.size() || (iDataSet = (IDataSet) this.mDataSets.get(i11)) == null) {
            return false;
        }
        boolean removeEntry = iDataSet.removeEntry(entry);
        if (removeEntry) {
            calcMinMax();
        }
        return removeEntry;
    }

    public void setDrawValues(boolean z11) {
        for (T drawValues : this.mDataSets) {
            drawValues.setDrawValues(z11);
        }
    }

    public void setHighlightEnabled(boolean z11) {
        for (T highlightEnabled : this.mDataSets) {
            highlightEnabled.setHighlightEnabled(z11);
        }
    }

    public void setValueFormatter(ValueFormatter valueFormatter) {
        if (valueFormatter != null) {
            for (T valueFormatter2 : this.mDataSets) {
                valueFormatter2.setValueFormatter(valueFormatter);
            }
        }
    }

    public void setValueTextColor(int i11) {
        for (T valueTextColor : this.mDataSets) {
            valueTextColor.setValueTextColor(i11);
        }
    }

    public void setValueTextColors(List<Integer> list) {
        for (T valueTextColors : this.mDataSets) {
            valueTextColors.setValueTextColors(list);
        }
    }

    public void setValueTextSize(float f11) {
        for (T valueTextSize : this.mDataSets) {
            valueTextSize.setValueTextSize(f11);
        }
    }

    public void setValueTypeface(Typeface typeface) {
        for (T valueTypeface : this.mDataSets) {
            valueTypeface.setValueTypeface(typeface);
        }
    }

    public float getYMax(YAxis.AxisDependency axisDependency) {
        if (axisDependency == YAxis.AxisDependency.LEFT) {
            float f11 = this.mLeftAxisMax;
            return f11 == -3.4028235E38f ? this.mRightAxisMax : f11;
        }
        float f12 = this.mRightAxisMax;
        return f12 == -3.4028235E38f ? this.mLeftAxisMax : f12;
    }

    public float getYMin(YAxis.AxisDependency axisDependency) {
        if (axisDependency == YAxis.AxisDependency.LEFT) {
            float f11 = this.mLeftAxisMin;
            return f11 == Float.MAX_VALUE ? this.mRightAxisMin : f11;
        }
        float f12 = this.mRightAxisMin;
        return f12 == Float.MAX_VALUE ? this.mLeftAxisMin : f12;
    }

    public boolean removeDataSet(int i11) {
        if (i11 >= this.mDataSets.size() || i11 < 0) {
            return false;
        }
        return removeDataSet((IDataSet) this.mDataSets.get(i11));
    }

    public boolean removeEntry(float f11, int i11) {
        Entry entryForXValue;
        if (i11 < this.mDataSets.size() && (entryForXValue = ((IDataSet) this.mDataSets.get(i11)).getEntryForXValue(f11, Float.NaN)) != null) {
            return removeEntry(entryForXValue, i11);
        }
        return false;
    }

    public ChartData(T... tArr) {
        this.mYMax = -3.4028235E38f;
        this.mYMin = Float.MAX_VALUE;
        this.mXMax = -3.4028235E38f;
        this.mXMin = Float.MAX_VALUE;
        this.mLeftAxisMax = -3.4028235E38f;
        this.mLeftAxisMin = Float.MAX_VALUE;
        this.mRightAxisMax = -3.4028235E38f;
        this.mRightAxisMin = Float.MAX_VALUE;
        this.mDataSets = arrayToList(tArr);
        notifyDataChanged();
    }

    public ChartData(List<T> list) {
        this.mYMax = -3.4028235E38f;
        this.mYMin = Float.MAX_VALUE;
        this.mXMax = -3.4028235E38f;
        this.mXMin = Float.MAX_VALUE;
        this.mLeftAxisMax = -3.4028235E38f;
        this.mLeftAxisMin = Float.MAX_VALUE;
        this.mRightAxisMax = -3.4028235E38f;
        this.mRightAxisMin = Float.MAX_VALUE;
        this.mDataSets = list;
        notifyDataChanged();
    }

    public void calcMinMax(Entry entry, YAxis.AxisDependency axisDependency) {
        if (this.mYMax < entry.getY()) {
            this.mYMax = entry.getY();
        }
        if (this.mYMin > entry.getY()) {
            this.mYMin = entry.getY();
        }
        if (this.mXMax < entry.getX()) {
            this.mXMax = entry.getX();
        }
        if (this.mXMin > entry.getX()) {
            this.mXMin = entry.getX();
        }
        if (axisDependency == YAxis.AxisDependency.LEFT) {
            if (this.mLeftAxisMax < entry.getY()) {
                this.mLeftAxisMax = entry.getY();
            }
            if (this.mLeftAxisMin > entry.getY()) {
                this.mLeftAxisMin = entry.getY();
                return;
            }
            return;
        }
        if (this.mRightAxisMax < entry.getY()) {
            this.mRightAxisMax = entry.getY();
        }
        if (this.mRightAxisMin > entry.getY()) {
            this.mRightAxisMin = entry.getY();
        }
    }

    public void calcMinMax(T t11) {
        if (this.mYMax < t11.getYMax()) {
            this.mYMax = t11.getYMax();
        }
        if (this.mYMin > t11.getYMin()) {
            this.mYMin = t11.getYMin();
        }
        if (this.mXMax < t11.getXMax()) {
            this.mXMax = t11.getXMax();
        }
        if (this.mXMin > t11.getXMin()) {
            this.mXMin = t11.getXMin();
        }
        if (t11.getAxisDependency() == YAxis.AxisDependency.LEFT) {
            if (this.mLeftAxisMax < t11.getYMax()) {
                this.mLeftAxisMax = t11.getYMax();
            }
            if (this.mLeftAxisMin > t11.getYMin()) {
                this.mLeftAxisMin = t11.getYMin();
                return;
            }
            return;
        }
        if (this.mRightAxisMax < t11.getYMax()) {
            this.mRightAxisMax = t11.getYMax();
        }
        if (this.mRightAxisMin > t11.getYMin()) {
            this.mRightAxisMin = t11.getYMin();
        }
    }
}
