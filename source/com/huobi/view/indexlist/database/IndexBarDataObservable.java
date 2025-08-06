package com.huobi.view.indexlist.database;

import android.database.Observable;

public class IndexBarDataObservable extends Observable<IndexBarDataObserver> {
    public void notifyChanged() {
        synchronized (this.mObservers) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((IndexBarDataObserver) this.mObservers.get(size)).onChanged();
            }
        }
    }
}
