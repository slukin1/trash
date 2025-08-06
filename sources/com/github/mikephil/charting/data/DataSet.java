package com.github.mikephil.charting.data;

import com.github.mikephil.charting.data.Entry;
import java.util.ArrayList;
import java.util.List;

public abstract class DataSet<T extends Entry> extends BaseDataSet<T> {

    /* renamed from: q  reason: collision with root package name */
    public List<T> f65488q = null;

    /* renamed from: r  reason: collision with root package name */
    public float f65489r = -3.4028235E38f;

    /* renamed from: s  reason: collision with root package name */
    public float f65490s = Float.MAX_VALUE;

    /* renamed from: t  reason: collision with root package name */
    public float f65491t = -3.4028235E38f;

    /* renamed from: u  reason: collision with root package name */
    public float f65492u = Float.MAX_VALUE;

    public enum Rounding {
        UP,
        DOWN,
        CLOSEST
    }

    public DataSet(List<T> list, String str) {
        super(str);
        this.f65488q = list;
        if (list == null) {
            this.f65488q = new ArrayList();
        }
        calcMinMax();
    }

    public T W(float f11, float f12, Rounding rounding) {
        int k02 = k0(f11, f12, rounding);
        if (k02 > -1) {
            return (Entry) this.f65488q.get(k02);
        }
        return null;
    }

    public int b(Entry entry) {
        return this.f65488q.indexOf(entry);
    }

    public void calcMinMax() {
        List<T> list = this.f65488q;
        if (list != null && !list.isEmpty()) {
            this.f65489r = -3.4028235E38f;
            this.f65490s = Float.MAX_VALUE;
            this.f65491t = -3.4028235E38f;
            this.f65492u = Float.MAX_VALUE;
            for (T h02 : this.f65488q) {
                h0(h02);
            }
        }
    }

    public void calcMinMaxY(float f11, float f12) {
        List<T> list = this.f65488q;
        if (list != null && !list.isEmpty()) {
            this.f65489r = -3.4028235E38f;
            this.f65490s = Float.MAX_VALUE;
            int k02 = k0(f12, Float.NaN, Rounding.UP);
            for (int k03 = k0(f11, Float.NaN, Rounding.DOWN); k03 <= k02; k03++) {
                j0((Entry) this.f65488q.get(k03));
            }
        }
    }

    public List<T> getEntriesForXValue(float f11) {
        ArrayList arrayList = new ArrayList();
        int size = this.f65488q.size() - 1;
        int i11 = 0;
        while (true) {
            if (i11 > size) {
                break;
            }
            int i12 = (size + i11) / 2;
            Entry entry = (Entry) this.f65488q.get(i12);
            if (f11 == entry.getX()) {
                while (i12 > 0 && ((Entry) this.f65488q.get(i12 - 1)).getX() == f11) {
                    i12--;
                }
                int size2 = this.f65488q.size();
                while (i12 < size2) {
                    Entry entry2 = (Entry) this.f65488q.get(i12);
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
        return this.f65488q.size();
    }

    public T getEntryForIndex(int i11) {
        return (Entry) this.f65488q.get(i11);
    }

    public T getEntryForXValue(float f11, float f12) {
        return W(f11, f12, Rounding.CLOSEST);
    }

    public float getXMax() {
        return this.f65491t;
    }

    public float getXMin() {
        return this.f65492u;
    }

    public float getYMax() {
        return this.f65489r;
    }

    public float getYMin() {
        return this.f65490s;
    }

    public void h0(T t11) {
        if (t11 != null) {
            i0(t11);
            j0(t11);
        }
    }

    public void i0(T t11) {
        if (t11.getX() < this.f65492u) {
            this.f65492u = t11.getX();
        }
        if (t11.getX() > this.f65491t) {
            this.f65491t = t11.getX();
        }
    }

    public void j0(T t11) {
        if (t11.getY() < this.f65490s) {
            this.f65490s = t11.getY();
        }
        if (t11.getY() > this.f65489r) {
            this.f65489r = t11.getY();
        }
    }

    public int k0(float f11, float f12, Rounding rounding) {
        int i11;
        Entry entry;
        List<T> list = this.f65488q;
        if (list == null || list.isEmpty()) {
            return -1;
        }
        int i12 = 0;
        int size = this.f65488q.size() - 1;
        while (i12 < size) {
            int i13 = (i12 + size) / 2;
            float x11 = ((Entry) this.f65488q.get(i13)).getX() - f11;
            int i14 = i13 + 1;
            float abs = Math.abs(x11);
            float abs2 = Math.abs(((Entry) this.f65488q.get(i14)).getX() - f11);
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
        float x12 = ((Entry) this.f65488q.get(size)).getX();
        if (rounding == Rounding.UP) {
            if (x12 < f11 && size < this.f65488q.size() - 1) {
                size++;
            }
        } else if (rounding == Rounding.DOWN && x12 > f11 && size > 0) {
            size--;
        }
        if (Float.isNaN(f12)) {
            return size;
        }
        while (size > 0 && ((Entry) this.f65488q.get(size - 1)).getX() == x12) {
            size--;
        }
        float y11 = ((Entry) this.f65488q.get(size)).getY();
        loop2:
        while (true) {
            i11 = size;
            do {
                size++;
                if (size >= this.f65488q.size()) {
                    break loop2;
                }
                entry = (Entry) this.f65488q.get(size);
                if (entry.getX() != x12) {
                    break loop2;
                }
            } while (Math.abs(entry.getY() - f12) >= Math.abs(y11 - f12));
            y11 = f12;
        }
        return i11;
    }

    public void l0(List<T> list) {
        this.f65488q = list;
        d0();
    }

    public String m0() {
        StringBuffer stringBuffer = new StringBuffer();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("DataSet, label: ");
        sb2.append(getLabel() == null ? "" : getLabel());
        sb2.append(", entries: ");
        sb2.append(this.f65488q.size());
        sb2.append("\n");
        stringBuffer.append(sb2.toString());
        return stringBuffer.toString();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(m0());
        for (int i11 = 0; i11 < this.f65488q.size(); i11++) {
            stringBuffer.append(((Entry) this.f65488q.get(i11)).toString() + " ");
        }
        return stringBuffer.toString();
    }
}
