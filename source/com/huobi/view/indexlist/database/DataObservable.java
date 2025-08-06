package com.huobi.view.indexlist.database;

import android.database.Observable;

public class DataObservable extends Observable<DataObserver> {
    public void notifyChanged() {
        synchronized (this.mObservers) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((DataObserver) this.mObservers.get(size)).onChanged();
            }
        }
    }

    public void notifyInited() {
        synchronized (this.mObservers) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((DataObserver) this.mObservers.get(size)).onInited();
            }
        }
    }

    public void notifySetListener(int i11) {
        synchronized (this.mObservers) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((DataObserver) this.mObservers.get(size)).onSetListener(i11);
            }
        }
    }
}
