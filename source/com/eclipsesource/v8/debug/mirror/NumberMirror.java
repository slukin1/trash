package com.eclipsesource.v8.debug.mirror;

import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Object;

public class NumberMirror extends ValueMirror {
    public NumberMirror(V8Object v8Object) {
        super(v8Object);
    }

    public boolean isNumber() {
        return true;
    }

    public String toString() {
        return this.v8Object.executeStringFunction("toText", (V8Array) null);
    }
}
