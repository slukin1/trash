package com.eclipsesource.v8;

public class V8Function extends V8Object {
    public V8Function(V8 v82, JavaCallback javaCallback) {
        super(v82, javaCallback);
    }

    public Object call(V8Object v8Object, V8Array v8Array) {
        long j11;
        this.f64941v8.checkThread();
        checkReleased();
        this.f64941v8.checkRuntime(v8Object);
        this.f64941v8.checkRuntime(v8Array);
        if (v8Object == null) {
            v8Object = this.f64941v8;
        }
        if (v8Array == null) {
            j11 = 0;
        } else {
            j11 = v8Array.getHandle();
        }
        long j12 = j11;
        if (v8Object.isUndefined()) {
            v8Object = this.f64941v8;
        }
        V8 v82 = this.f64941v8;
        return v82.executeFunction(v82.getV8RuntimePtr(), v8Object.getHandle(), this.objectHandle, j12);
    }

    public V8Value createTwin() {
        return new V8Function(this.f64941v8);
    }

    public void initialize(long j11, Object obj) {
        if (obj == null) {
            super.initialize(j11, (Object) null);
            return;
        }
        long[] initNewV8Function = this.f64941v8.initNewV8Function(j11);
        this.f64941v8.createAndRegisterMethodDescriptor((JavaCallback) obj, initNewV8Function[1]);
        this.released = false;
        addObjectReference(initNewV8Function[0]);
    }

    public String toString() {
        return (this.released || this.f64941v8.isReleased()) ? "[Function released]" : super.toString();
    }

    public V8Function(V8 v82) {
        this(v82, (JavaCallback) null);
    }

    public V8Function twin() {
        return (V8Function) super.twin();
    }
}
