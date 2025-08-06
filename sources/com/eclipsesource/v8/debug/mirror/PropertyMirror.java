package com.eclipsesource.v8.debug.mirror;

import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Object;

public class PropertyMirror extends Mirror {
    public PropertyMirror(V8Object v8Object) {
        super(v8Object);
    }

    public String getName() {
        return this.v8Object.executeStringFunction("name", (V8Array) null);
    }

    public Mirror getValue() {
        V8Object executeObjectFunction = this.v8Object.executeObjectFunction("value", (V8Array) null);
        try {
            return Mirror.createMirror(executeObjectFunction);
        } finally {
            executeObjectFunction.close();
        }
    }

    public boolean isProperty() {
        return true;
    }
}
