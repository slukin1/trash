package com.tencent.qcloud.tuikit.tuicallengine.impl.base;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class LiveData<T> {
    private static final Object DEFAULT_OBJECT = new Object();
    private volatile Object mData;
    private List<Observer<? super T>> mObservers;

    public LiveData(T t11) {
        this.mObservers = new ArrayList();
        this.mData = t11;
    }

    private void dispatchingValue() {
        for (int i11 = 0; i11 < this.mObservers.size(); i11++) {
            this.mObservers.get(i11).onChanged(this.mData);
        }
    }

    public void add(Object obj) {
        if (this.mData == null) {
            return;
        }
        if (this.mData instanceof List) {
            ((List) this.mData).add(obj);
            dispatchingValue();
        } else if (this.mData instanceof Set) {
            ((Set) this.mData).add(obj);
            dispatchingValue();
        }
    }

    public void addAll(Collection collection) {
        if (this.mData == null) {
            return;
        }
        if (this.mData instanceof List) {
            ((List) this.mData).addAll(collection);
            dispatchingValue();
        } else if (this.mData instanceof Set) {
            ((Set) this.mData).addAll(collection);
            dispatchingValue();
        }
    }

    public T get() {
        T t11 = this.mData;
        if (t11 != DEFAULT_OBJECT) {
            return t11;
        }
        return null;
    }

    public void observe(Observer<? super T> observer) {
        if (observer != null && !this.mObservers.contains(observer)) {
            this.mObservers.add(observer);
        }
    }

    public void remove(Object obj) {
        if (this.mData == null) {
            return;
        }
        if (this.mData instanceof List) {
            ((List) this.mData).remove(obj);
            dispatchingValue();
        } else if (this.mData instanceof Set) {
            ((Set) this.mData).remove(obj);
            dispatchingValue();
        }
    }

    public void removeAll() {
        this.mObservers.clear();
    }

    public void removeObserver(Observer<? super T> observer) {
        this.mObservers.remove(observer);
    }

    public void set(T t11) {
        this.mData = t11;
        dispatchingValue();
    }

    public LiveData() {
        this.mObservers = new ArrayList();
        this.mData = DEFAULT_OBJECT;
    }
}
