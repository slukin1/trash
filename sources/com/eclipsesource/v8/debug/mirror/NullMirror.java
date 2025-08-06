package com.eclipsesource.v8.debug.mirror;

import com.eclipsesource.v8.V8Object;
import com.iproov.sdk.bridge.OptionsBridge;

public class NullMirror extends ValueMirror {
    public NullMirror(V8Object v8Object) {
        super(v8Object);
    }

    public boolean isNull() {
        return true;
    }

    public String toString() {
        return OptionsBridge.NULL_VALUE;
    }
}
