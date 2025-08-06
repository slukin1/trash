package com.huawei.hms.common.data;

public interface DataBufferObserver {
    void onDataChanged();

    void onDataRangeChanged(int i11, int i12);

    void onDataRangeInserted(int i11, int i12);

    void onDataRangeMoved(int i11, int i12, int i13);

    void onDataRangeRemoved(int i11, int i12);
}
