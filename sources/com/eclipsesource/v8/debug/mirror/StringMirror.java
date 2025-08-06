package com.eclipsesource.v8.debug.mirror;

import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Object;

public class StringMirror extends ValueMirror {
    public StringMirror(V8Object v8Object) {
        super(v8Object);
    }

    public boolean isString() {
        return true;
    }

    public String toString() {
        return this.v8Object.executeStringFunction("toText", (V8Array) null);
    }
}
