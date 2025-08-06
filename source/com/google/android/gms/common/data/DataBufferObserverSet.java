package com.google.android.gms.common.data;

import com.google.android.gms.common.data.DataBufferObserver;
import java.util.HashSet;
import java.util.Iterator;

public final class DataBufferObserverSet implements DataBufferObserver, DataBufferObserver.Observable {
    private HashSet<DataBufferObserver> zaa = new HashSet<>();

    public void addObserver(DataBufferObserver dataBufferObserver) {
        this.zaa.add(dataBufferObserver);
    }

    public void clear() {
        this.zaa.clear();
    }

    public boolean hasObservers() {
        return !this.zaa.isEmpty();
    }

    public void onDataChanged() {
        Iterator<DataBufferObserver> it2 = this.zaa.iterator();
        while (it2.hasNext()) {
            it2.next().onDataChanged();
        }
    }

    public void onDataRangeChanged(int i11, int i12) {
        Iterator<DataBufferObserver> it2 = this.zaa.iterator();
        while (it2.hasNext()) {
            it2.next().onDataRangeChanged(i11, i12);
        }
    }

    public void onDataRangeInserted(int i11, int i12) {
        Iterator<DataBufferObserver> it2 = this.zaa.iterator();
        while (it2.hasNext()) {
            it2.next().onDataRangeInserted(i11, i12);
        }
    }

    public void onDataRangeMoved(int i11, int i12, int i13) {
        Iterator<DataBufferObserver> it2 = this.zaa.iterator();
        while (it2.hasNext()) {
            it2.next().onDataRangeMoved(i11, i12, i13);
        }
    }

    public void onDataRangeRemoved(int i11, int i12) {
        Iterator<DataBufferObserver> it2 = this.zaa.iterator();
        while (it2.hasNext()) {
            it2.next().onDataRangeRemoved(i11, i12);
        }
    }

    public void removeObserver(DataBufferObserver dataBufferObserver) {
        this.zaa.remove(dataBufferObserver);
    }
}
