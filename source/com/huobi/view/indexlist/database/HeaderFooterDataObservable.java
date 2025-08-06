package com.huobi.view.indexlist.database;

import android.database.Observable;

public class HeaderFooterDataObservable extends Observable<HeaderFooterDataObserver> {
    public void notifyAdd(boolean z11, Object obj, Object obj2) {
        synchronized (this.mObservers) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((HeaderFooterDataObserver) this.mObservers.get(size)).onAdd(z11, obj, obj2);
            }
        }
    }

    public void notifyChanged() {
        synchronized (this.mObservers) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((HeaderFooterDataObserver) this.mObservers.get(size)).onChanged();
            }
        }
    }

    public void notifyRemove(boolean z11, Object obj) {
        synchronized (this.mObservers) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((HeaderFooterDataObserver) this.mObservers.get(size)).onRemove(z11, obj);
            }
        }
    }
}
