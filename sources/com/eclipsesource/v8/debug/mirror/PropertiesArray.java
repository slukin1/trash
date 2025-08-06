package com.eclipsesource.v8.debug.mirror;

import com.eclipsesource.v8.Releasable;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Object;

public class PropertiesArray implements Releasable {
    private V8Array v8Array;

    public PropertiesArray(V8Array v8Array2) {
        this.v8Array = v8Array2.twin();
    }

    public void close() {
        if (!this.v8Array.isReleased()) {
            this.v8Array.close();
        }
    }

    public PropertyMirror getProperty(int i11) {
        V8Object object = this.v8Array.getObject(i11);
        try {
            return new PropertyMirror(object);
        } finally {
            object.close();
        }
    }

    public int length() {
        return this.v8Array.length();
    }

    @Deprecated
    public void release() {
        close();
    }
}
