package com.huobi.edgeengine.node.trace;

import com.eclipsesource.v8.JavaCallback;
import com.eclipsesource.v8.JavaVoidCallback;
import com.eclipsesource.v8.V8;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Object;
import com.eclipsesource.v8.V8ResultUndefined;
import com.eclipsesource.v8.V8Value;

public class Undefined extends V8Object {
    public V8Object add(String str, boolean z11) {
        throw new UnsupportedOperationException();
    }

    public V8Object addUndefined(String str) {
        throw new UnsupportedOperationException();
    }

    public void close() {
    }

    public boolean contains(String str) {
        throw new UnsupportedOperationException();
    }

    /* renamed from: e */
    public Undefined twin() {
        return this;
    }

    public boolean equals(Object obj) {
        return ((obj instanceof V8Object) && ((V8Object) obj).isUndefined()) || ((obj instanceof V8Array) && ((V8Array) obj).isUndefined()) || (obj instanceof Undefined);
    }

    public V8Array executeArrayFunction(String str, V8Array v8Array) {
        throw new UnsupportedOperationException();
    }

    public boolean executeBooleanFunction(String str, V8Array v8Array) {
        throw new UnsupportedOperationException();
    }

    public double executeDoubleFunction(String str, V8Array v8Array) {
        throw new UnsupportedOperationException();
    }

    public Object executeFunction(String str, V8Array v8Array) {
        throw new UnsupportedOperationException();
    }

    public int executeIntegerFunction(String str, V8Array v8Array) {
        throw new UnsupportedOperationException();
    }

    public Object executeJSFunction(String str, Object... objArr) {
        throw new UnsupportedOperationException();
    }

    public V8Object executeObjectFunction(String str, V8Array v8Array) {
        throw new UnsupportedOperationException();
    }

    public String executeStringFunction(String str, V8Array v8Array) {
        throw new UnsupportedOperationException();
    }

    public void executeVoidFunction(String str, V8Array v8Array) {
        throw new UnsupportedOperationException();
    }

    public V8Array getArray(String str) {
        throw new UnsupportedOperationException();
    }

    public boolean getBoolean(String str) {
        throw new UnsupportedOperationException();
    }

    public double getDouble(String str) {
        throw new UnsupportedOperationException();
    }

    public int getInteger(String str) {
        throw new UnsupportedOperationException();
    }

    public String[] getKeys() {
        throw new UnsupportedOperationException();
    }

    public V8Object getObject(String str) throws V8ResultUndefined {
        throw new UnsupportedOperationException();
    }

    public V8 getRuntime() {
        throw new UnsupportedOperationException();
    }

    public String getString(String str) throws V8ResultUndefined {
        throw new UnsupportedOperationException();
    }

    public int getType(String str) throws V8ResultUndefined {
        throw new UnsupportedOperationException();
    }

    public int hashCode() {
        return 919;
    }

    public boolean isReleased() {
        return false;
    }

    public boolean isUndefined() {
        return true;
    }

    public V8Object registerJavaMethod(JavaCallback javaCallback, String str) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public void release() {
    }

    public V8Object setPrototype(V8Object v8Object) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return "undefined";
    }

    public V8Object add(String str, double d11) {
        throw new UnsupportedOperationException();
    }

    public V8Object registerJavaMethod(JavaVoidCallback javaVoidCallback, String str) {
        throw new UnsupportedOperationException();
    }

    public V8Object add(String str, int i11) {
        throw new UnsupportedOperationException();
    }

    public V8Object registerJavaMethod(Object obj, String str, String str2, Class<?>[] clsArr, boolean z11) {
        throw new UnsupportedOperationException();
    }

    public V8Object add(String str, String str2) {
        throw new UnsupportedOperationException();
    }

    public V8Object add(String str, V8Value v8Value) {
        throw new UnsupportedOperationException();
    }
}
