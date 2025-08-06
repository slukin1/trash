package com.appsflyer.internal;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

public abstract class bt extends Observable {
    public e AFInAppEventParameterName = e.NOT_STARTED;
    private long AFInAppEventType;
    public final Map<String, Object> AFKeystoreWrapper = new HashMap();
    public final String valueOf;
    public final Runnable values;

    public enum e {
        NOT_STARTED,
        STARTED,
        FINISHED
    }

    public bt(String str, Runnable runnable) {
        this.values = runnable;
        this.valueOf = str;
    }

    public final void AFInAppEventParameterName() {
        this.AFInAppEventType = System.currentTimeMillis();
        this.AFInAppEventParameterName = e.STARTED;
        addObserver(new Observer() {
            public final void update(Observable observable, Object obj) {
                bt.this.values.run();
            }
        });
    }

    public abstract void AFInAppEventParameterName(Context context);

    public final void AFKeystoreWrapper() {
        this.AFKeystoreWrapper.put("source", this.valueOf);
        this.AFKeystoreWrapper.putAll(new bu());
        this.AFKeystoreWrapper.put("latency", Long.valueOf(System.currentTimeMillis() - this.AFInAppEventType));
        this.AFInAppEventParameterName = e.FINISHED;
        setChanged();
        notifyObservers();
    }
}
