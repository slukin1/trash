package com.jumio.core.extraction;

import com.jumio.analytics.MetaInfo;

public final class DefaultExtractionUpdate<T> implements ExtractionUpdateInterface<T> {

    /* renamed from: a  reason: collision with root package name */
    public Integer f39143a;

    /* renamed from: b  reason: collision with root package name */
    public T f39144b;

    /* renamed from: c  reason: collision with root package name */
    public MetaInfo f39145c;

    public T getData() {
        return this.f39144b;
    }

    public MetaInfo getMetaInfo() {
        return this.f39145c;
    }

    public Integer getState() {
        return this.f39143a;
    }

    public void setData(T t11) {
        this.f39144b = t11;
    }

    public void setMetaInfo(MetaInfo metaInfo) {
        this.f39145c = metaInfo;
    }

    public void setState(Integer num) {
        this.f39143a = num;
    }

    public String toString() {
        Integer state = getState();
        Object data = getData();
        MetaInfo metaInfo = getMetaInfo();
        return "DefaultExtractionUpdate(state=" + state + ", data=" + data + ", metaInfo=" + metaInfo + ")";
    }
}
