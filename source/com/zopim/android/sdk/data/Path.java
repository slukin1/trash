package com.zopim.android.sdk.data;

import com.iproov.sdk.bridge.OptionsBridge;
import com.zendesk.logger.Logger;
import com.zopim.android.sdk.api.ObservableTrigger;
import java.util.Observable;

public abstract class Path<T> extends Observable implements ObservableTrigger {
    public static final boolean DEBUG = false;
    private static final String LOG_TAG = "Path";
    public T data;

    public void broadcast(T t11) {
        if (countObservers() > 0) {
            setChanged();
            super.notifyObservers(t11);
        }
    }

    public abstract void clear();

    public void finalize() throws Throwable {
        super.finalize();
    }

    public abstract T getData();

    public boolean isClearRequired(String str) {
        return str == null || str.equals(OptionsBridge.NULL_VALUE);
    }

    @Deprecated
    public final void notifyObservers(Object obj) {
        try {
            broadcast(obj);
        } catch (ClassCastException e11) {
            Logger.k(LOG_TAG, "Parametrized object should be of specified type T. Will not notify observers.", e11, new Object[0]);
        }
    }

    public void trigger() {
        broadcast();
    }

    public abstract void update(String str);

    public void broadcast() {
        broadcast(getData());
    }
}
