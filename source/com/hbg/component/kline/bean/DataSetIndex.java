package com.hbg.component.kline.bean;

public class DataSetIndex {

    /* renamed from: a  reason: collision with root package name */
    public int f67180a;

    /* renamed from: b  reason: collision with root package name */
    public int f67181b;

    /* renamed from: c  reason: collision with root package name */
    public String f67182c;

    public DataSetIndex(int i11, int i12, String str) {
        this.f67180a = i11;
        this.f67181b = i12;
        this.f67182c = str;
    }

    public boolean a(Object obj) {
        return obj instanceof DataSetIndex;
    }

    public int b() {
        return this.f67181b;
    }

    public String c() {
        return this.f67182c;
    }

    public int d() {
        return this.f67180a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DataSetIndex)) {
            return false;
        }
        DataSetIndex dataSetIndex = (DataSetIndex) obj;
        if (!dataSetIndex.a(this) || d() != dataSetIndex.d() || b() != dataSetIndex.b()) {
            return false;
        }
        String c11 = c();
        String c12 = dataSetIndex.c();
        return c11 != null ? c11.equals(c12) : c12 == null;
    }

    public int hashCode() {
        int d11 = ((d() + 59) * 59) + b();
        String c11 = c();
        return (d11 * 59) + (c11 == null ? 43 : c11.hashCode());
    }

    public String toString() {
        return "DataSetIndex(params=" + d() + ", color=" + b() + ", name=" + c() + ")";
    }

    public DataSetIndex() {
    }
}
