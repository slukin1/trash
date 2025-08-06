package com.eclipsesource.v8.debug;

import com.eclipsesource.v8.Releasable;
import com.eclipsesource.v8.V8Object;

public class EventData implements Releasable {
    public V8Object v8Object;

    public EventData(V8Object v8Object2) {
        this.v8Object = v8Object2.twin();
    }

    public void close() {
        if (!this.v8Object.isReleased()) {
            this.v8Object.close();
        }
    }

    @Deprecated
    public void release() {
        close();
    }
}
