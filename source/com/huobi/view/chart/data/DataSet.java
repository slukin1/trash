package com.huobi.view.chart.data;

import com.huobi.view.chart.data.Entry;
import java.util.ArrayList;
import java.util.List;

public abstract class DataSet<T extends Entry> extends BaseDataSet<T> {
    public List<T> mValues = null;
    public float mXMax = -3.4028235E38f;
    public float mXMin = Float.MAX_VALUE;
    public float mYMax = -3.4028235E38f;
    public float mYMin = Float.MAX_VALUE;

    public enum Rounding {
        UP,
        DOWN,
        CLOSEST
    }

    public DataSet(List<T> list, String str) {
        super(str);
        this.mValues = list;
        if (list == null) {
            this.mValues = new ArrayList();
        }
        calcMinMax();
    }

    public boolean addEntry(T t11) {
        if (t11 == null) {
            return false;
        }
        List values = getValues();
        if (values == null) {
            values = new ArrayList();
        }
        calcMinMax(t11);
        return values.add(t11);
    }

    public void addEntryOrdered(T t11) {
        if (t11 != null) {
            if (this.mValues == null) {
                this.mValues = new ArrayList();
            }
            calcMinMax(t11);
            if (this.mValues.size() > 0) {
                List<T> list = this.mValues;
                if (((Entry) list.get(list.size() - 1)).getX() > t11.getX()) {
                    this.mValues.add(getEntryIndex(t11.getX(), t11.getY(), Rounding.UP), t11);
                    return;
                }
            }
            this.mValues.add(t11);
        }
    }

    public void calcMinMax() {
        List<T> list = this.mValues;
        if (list != null && !list.isEmpty()) {
            this.mYMax = -3.4028235E38f;
            this.mYMin = Float.MAX_VALUE;
            this.mXMax = -3.4028235E38f;
            this.mXMin = Float.MAX_VALUE;
            for (T calcMinMax : this.mValues) {
                calcMinMax(calcMinMax);
            }
        }
    }

    public void calcMinMaxX(T t11) {
        if (t11.getX() < this.mXMin) {
            this.mXMin = t11.getX();
        }
        if (t11.getX() > this.mXMax) {
            this.mXMax = t11.getX();
        }
    }

    public void calcMinMaxY(float f11, float f12) {
        List<T> list = this.mValues;
        if (list != null && !list.isEmpty()) {
            this.mYMax = -3.4028235E38f;
            this.mYMin = Float.MAX_VALUE;
            int entryIndex = getEntryIndex(f12, Float.NaN, Rounding.UP);
            for (int entryIndex2 = getEntryIndex(f11, Float.NaN, Rounding.DOWN); entryIndex2 <= entryIndex; entryIndex2++) {
                calcMinMaxY((Entry) this.mValues.get(entryIndex2));
            }
        }
    }

    public void clear() {
        this.mValues.clear();
        notifyDataSetChanged();
    }

    public abstract DataSet<T> copy();

    public void copy(DataSet dataSet) {
        super.copy(dataSet);
    }

    public List<T> getEntriesForXValue(float f11) {
        ArrayList arrayList = new ArrayList();
        int size = this.mValues.size() - 1;
        int i11 = 0;
        while (true) {
            if (i11 > size) {
                break;
            }
            int i12 = (size + i11) / 2;
            Entry entry = (Entry) this.mValues.get(i12);
            if (f11 == entry.getX()) {
                while (i12 > 0 && ((Entry) this.mValues.get(i12 - 1)).getX() == f11) {
                    i12--;
                }
                int size2 = this.mValues.size();
                while (i12 < size2) {
                    Entry entry2 = (Entry) this.mValues.get(i12);
                    if (entry2.getX() != f11) {
                        break;
                    }
                    arrayList.add(entry2);
                    i12++;
                }
            } else if (f11 > entry.getX()) {
                i11 = i12 + 1;
            } else {
                size = i12 - 1;
            }
        }
        return arrayList;
    }

    public int getEntryCount() {
        return this.mValues.size();
    }

    public T getEntryForIndex(int i11) {
        return (Entry) this.mValues.get(i11);
    }

    public T getEntryForXValue(float f11, float f12, Rounding rounding) {
        int entryIndex = getEntryIndex(f11, f12, rounding);
        if (entryIndex > -1) {
            return (Entry) this.mValues.get(entryIndex);
        }
        return null;
    }

    public int getEntryIndex(Entry entry) {
        return this.mValues.indexOf(entry);
    }

    public List<T> getValues() {
        return this.mValues;
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

    public boolean removeEntry(T t11) {
        List<T> list;
        if (t11 == null || (list = this.mValues) == null) {
            return false;
        }
        boolean remove = list.remove(t11);
        if (remove) {
            calcMinMax();
        }
        return remove;
    }

    public void setValues(List<T> list) {
        this.mValues = list;
        notifyDataSetChanged();
    }

    public String toSimpleString() {
        StringBuffer stringBuffer = new StringBuffer();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("DataSet, label: ");
        sb2.append(getLabel() == null ? "" : getLabel());
        sb2.append(", entries: ");
        sb2.append(this.mValues.size());
        sb2.append("\n");
        stringBuffer.append(sb2.toString());
        return stringBuffer.toString();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(toSimpleString());
        for (int i11 = 0; i11 < this.mValues.size(); i11++) {
            stringBuffer.append(((Entry) this.mValues.get(i11)).toString() + " ");
        }
        return stringBuffer.toString();
    }

    public int getEntryIndex(float f11, float f12, Rounding rounding) {
        int i11;
        Entry entry;
        List<T> list = this.mValues;
        if (list == null || list.isEmpty()) {
            return -1;
        }
        int i12 = 0;
        int size = this.mValues.size() - 1;
        while (i12 < size) {
            int i13 = (i12 + size) / 2;
            float x11 = ((Entry) this.mValues.get(i13)).getX() - f11;
            int i14 = i13 + 1;
            float abs = Math.abs(x11);
            float abs2 = Math.abs(((Entry) this.mValues.get(i14)).getX() - f11);
            if (abs2 >= abs) {
                if (abs >= abs2) {
                    double d11 = (double) x11;
                    if (d11 < 0.0d) {
                        if (d11 >= 0.0d) {
                        }
                    }
                }
                size = i13;
            }
            i12 = i14;
        }
        if (size == -1) {
            return size;
        }
        float x12 = ((Entry) this.mValues.get(size)).getX();
        if (rounding == Rounding.UP) {
            if (x12 < f11 && size < this.mValues.size() - 1) {
                size++;
            }
        } else if (rounding == Rounding.DOWN && x12 > f11 && size > 0) {
            size--;
        }
        if (Float.isNaN(f12)) {
            return size;
        }
        while (size > 0 && ((Entry) this.mValues.get(size - 1)).getX() == x12) {
            size--;
        }
        float y11 = ((Entry) this.mValues.get(size)).getY();
        loop2:
        while (true) {
            i11 = size;
            do {
                size++;
                if (size >= this.mValues.size()) {
                    break loop2;
                }
                entry = (Entry) this.mValues.get(size);
                if (entry.getX() != x12) {
                    break loop2;
                }
            } while (Math.abs(entry.getY() - f12) >= Math.abs(y11 - f12));
            y11 = f12;
        }
        return i11;
    }

    public T getEntryForXValue(float f11, float f12) {
        return getEntryForXValue(f11, f12, Rounding.CLOSEST);
    }

    public void calcMinMaxY(T t11) {
        if (t11.getY() < this.mYMin) {
            this.mYMin = t11.getY();
        }
        if (t11.getY() > this.mYMax) {
            this.mYMax = t11.getY();
        }
    }

    public void calcMinMax(T t11) {
        if (t11 != null) {
            calcMinMaxX(t11);
            calcMinMaxY(t11);
        }
    }
}
