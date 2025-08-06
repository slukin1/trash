package com.eclipsesource.v8;

import java.lang.reflect.Method;

public class V8Object extends V8Value {

    public static class Undefined extends V8Object {
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

        public boolean equals(Object obj) {
            return (obj instanceof V8Object) && ((V8Object) obj).isUndefined();
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

        public Undefined twin() {
            return (Undefined) V8Object.super.twin();
        }

        public V8Object add(String str, String str2) {
            throw new UnsupportedOperationException();
        }

        public V8Object add(String str, V8Value v8Value) {
            throw new UnsupportedOperationException();
        }
    }

    public V8Object(V8 v82) {
        this(v82, (Object) null);
    }

    private void checkKey(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
    }

    public V8Object add(String str, int i11) {
        this.f64941v8.checkThread();
        checkReleased();
        V8 v82 = this.f64941v8;
        v82.add(v82.getV8RuntimePtr(), this.objectHandle, str, i11);
        return this;
    }

    public V8Object addNull(String str) {
        this.f64941v8.checkThread();
        checkReleased();
        V8 v82 = this.f64941v8;
        v82.addNull(v82.getV8RuntimePtr(), this.objectHandle, str);
        return this;
    }

    public V8Object addUndefined(String str) {
        this.f64941v8.checkThread();
        checkReleased();
        V8 v82 = this.f64941v8;
        v82.addUndefined(v82.getV8RuntimePtr(), this.objectHandle, str);
        return this;
    }

    public boolean contains(String str) {
        this.f64941v8.checkThread();
        checkReleased();
        checkKey(str);
        V8 v82 = this.f64941v8;
        return v82.contains(v82.getV8RuntimePtr(), this.objectHandle, str);
    }

    public V8Value createTwin() {
        return new V8Object(this.f64941v8);
    }

    public V8Array executeArrayFunction(String str, V8Array v8Array) {
        long j11;
        this.f64941v8.checkThread();
        checkReleased();
        this.f64941v8.checkRuntime(v8Array);
        if (v8Array == null) {
            j11 = 0;
        } else {
            j11 = v8Array.getHandle();
        }
        V8 v82 = this.f64941v8;
        Object executeFunction = v82.executeFunction(v82.getV8RuntimePtr(), 5, this.objectHandle, str, j11);
        if (executeFunction instanceof V8Array) {
            return (V8Array) executeFunction;
        }
        throw new V8ResultUndefined();
    }

    public boolean executeBooleanFunction(String str, V8Array v8Array) {
        long j11;
        this.f64941v8.checkThread();
        checkReleased();
        this.f64941v8.checkRuntime(v8Array);
        if (v8Array == null) {
            j11 = 0;
        } else {
            j11 = v8Array.getHandle();
        }
        V8 v82 = this.f64941v8;
        return v82.executeBooleanFunction(v82.getV8RuntimePtr(), getHandle(), str, j11);
    }

    public double executeDoubleFunction(String str, V8Array v8Array) {
        long j11;
        this.f64941v8.checkThread();
        checkReleased();
        this.f64941v8.checkRuntime(v8Array);
        if (v8Array == null) {
            j11 = 0;
        } else {
            j11 = v8Array.getHandle();
        }
        V8 v82 = this.f64941v8;
        return v82.executeDoubleFunction(v82.getV8RuntimePtr(), getHandle(), str, j11);
    }

    public Object executeFunction(String str, V8Array v8Array) {
        long j11;
        this.f64941v8.checkThread();
        checkReleased();
        this.f64941v8.checkRuntime(v8Array);
        if (v8Array == null) {
            j11 = 0;
        } else {
            j11 = v8Array.getHandle();
        }
        V8 v82 = this.f64941v8;
        return v82.executeFunction(v82.getV8RuntimePtr(), 0, this.objectHandle, str, j11);
    }

    public int executeIntegerFunction(String str, V8Array v8Array) {
        long j11;
        this.f64941v8.checkThread();
        checkReleased();
        this.f64941v8.checkRuntime(v8Array);
        if (v8Array == null) {
            j11 = 0;
        } else {
            j11 = v8Array.getHandle();
        }
        V8 v82 = this.f64941v8;
        return v82.executeIntegerFunction(v82.getV8RuntimePtr(), getHandle(), str, j11);
    }

    public Object executeJSFunction(String str) {
        return executeFunction(str, (V8Array) null);
    }

    public V8Object executeObjectFunction(String str, V8Array v8Array) {
        long j11;
        this.f64941v8.checkThread();
        checkReleased();
        this.f64941v8.checkRuntime(v8Array);
        if (v8Array == null) {
            j11 = 0;
        } else {
            j11 = v8Array.getHandle();
        }
        V8 v82 = this.f64941v8;
        Object executeFunction = v82.executeFunction(v82.getV8RuntimePtr(), 6, this.objectHandle, str, j11);
        if (executeFunction instanceof V8Object) {
            return (V8Object) executeFunction;
        }
        throw new V8ResultUndefined();
    }

    public String executeStringFunction(String str, V8Array v8Array) {
        long j11;
        this.f64941v8.checkThread();
        checkReleased();
        this.f64941v8.checkRuntime(v8Array);
        if (v8Array == null) {
            j11 = 0;
        } else {
            j11 = v8Array.getHandle();
        }
        V8 v82 = this.f64941v8;
        return v82.executeStringFunction(v82.getV8RuntimePtr(), getHandle(), str, j11);
    }

    public void executeVoidFunction(String str, V8Array v8Array) {
        long j11;
        this.f64941v8.checkThread();
        checkReleased();
        this.f64941v8.checkRuntime(v8Array);
        if (v8Array == null) {
            j11 = 0;
        } else {
            j11 = v8Array.getHandle();
        }
        V8 v82 = this.f64941v8;
        v82.executeVoidFunction(v82.getV8RuntimePtr(), this.objectHandle, str, j11);
    }

    public Object get(String str) {
        this.f64941v8.checkThread();
        checkReleased();
        checkKey(str);
        V8 v82 = this.f64941v8;
        return v82.get(v82.getV8RuntimePtr(), 6, this.objectHandle, str);
    }

    public V8Array getArray(String str) {
        this.f64941v8.checkThread();
        checkReleased();
        checkKey(str);
        V8 v82 = this.f64941v8;
        Object obj = v82.get(v82.getV8RuntimePtr(), 5, this.objectHandle, str);
        if (obj == null || (obj instanceof V8Array)) {
            return (V8Array) obj;
        }
        throw new V8ResultUndefined();
    }

    public boolean getBoolean(String str) {
        this.f64941v8.checkThread();
        checkReleased();
        checkKey(str);
        V8 v82 = this.f64941v8;
        return v82.getBoolean(v82.getV8RuntimePtr(), this.objectHandle, str);
    }

    public double getDouble(String str) {
        this.f64941v8.checkThread();
        checkReleased();
        checkKey(str);
        V8 v82 = this.f64941v8;
        return v82.getDouble(v82.getV8RuntimePtr(), this.objectHandle, str);
    }

    public int getInteger(String str) {
        this.f64941v8.checkThread();
        checkReleased();
        checkKey(str);
        V8 v82 = this.f64941v8;
        return v82.getInteger(v82.getV8RuntimePtr(), this.objectHandle, str);
    }

    public String[] getKeys() {
        this.f64941v8.checkThread();
        checkReleased();
        V8 v82 = this.f64941v8;
        return v82.getKeys(v82.getV8RuntimePtr(), this.objectHandle);
    }

    public V8Object getObject(String str) {
        this.f64941v8.checkThread();
        checkReleased();
        checkKey(str);
        V8 v82 = this.f64941v8;
        Object obj = v82.get(v82.getV8RuntimePtr(), 6, this.objectHandle, str);
        if (obj == null || (obj instanceof V8Object)) {
            return (V8Object) obj;
        }
        throw new V8ResultUndefined();
    }

    public String getString(String str) {
        this.f64941v8.checkThread();
        checkReleased();
        checkKey(str);
        V8 v82 = this.f64941v8;
        return v82.getString(v82.getV8RuntimePtr(), this.objectHandle, str);
    }

    public int getType(String str) {
        this.f64941v8.checkThread();
        checkReleased();
        checkKey(str);
        V8 v82 = this.f64941v8;
        return v82.getType(v82.getV8RuntimePtr(), this.objectHandle, str);
    }

    public V8Object registerJavaMethod(JavaCallback javaCallback, String str) {
        this.f64941v8.checkThread();
        checkReleased();
        this.f64941v8.registerCallback(javaCallback, getHandle(), str);
        return this;
    }

    public V8Object setPrototype(V8Object v8Object) {
        this.f64941v8.checkThread();
        checkReleased();
        V8 v82 = this.f64941v8;
        v82.setPrototype(v82.getV8RuntimePtr(), this.objectHandle, v8Object.getHandle());
        return this;
    }

    public String toString() {
        if (isReleased() || this.f64941v8.isReleased()) {
            return "[Object released]";
        }
        this.f64941v8.checkThread();
        V8 v82 = this.f64941v8;
        return v82.toString(v82.getV8RuntimePtr(), getHandle());
    }

    public V8Object(V8 v82, Object obj) {
        super(v82);
        if (v82 != null) {
            this.f64941v8.checkThread();
            initialize(this.f64941v8.getV8RuntimePtr(), obj);
        }
    }

    public Object executeJSFunction(String str, Object... objArr) {
        if (objArr == null) {
            return executeFunction(str, (V8Array) null);
        }
        V8Array v8Array = new V8Array(this.f64941v8.getRuntime());
        try {
            for (V8Value v8Value : objArr) {
                if (v8Value == null) {
                    v8Array.pushNull();
                } else if (v8Value instanceof V8Value) {
                    v8Array.push(v8Value);
                } else if (v8Value instanceof Integer) {
                    v8Array.push((Object) v8Value);
                } else if (v8Value instanceof Double) {
                    v8Array.push((Object) v8Value);
                } else if (v8Value instanceof Long) {
                    v8Array.push(((Long) v8Value).doubleValue());
                } else if (v8Value instanceof Float) {
                    v8Array.push((double) ((Float) v8Value).floatValue());
                } else if (v8Value instanceof Boolean) {
                    v8Array.push((Object) v8Value);
                } else if (v8Value instanceof String) {
                    v8Array.push((String) v8Value);
                } else {
                    throw new IllegalArgumentException("Unsupported Object of type: " + v8Value.getClass());
                }
            }
            return executeFunction(str, v8Array);
        } finally {
            v8Array.close();
        }
    }

    public V8Object twin() {
        return (V8Object) super.twin();
    }

    public V8Object add(String str, boolean z11) {
        this.f64941v8.checkThread();
        checkReleased();
        V8 v82 = this.f64941v8;
        v82.add(v82.getV8RuntimePtr(), this.objectHandle, str, z11);
        return this;
    }

    public V8Object registerJavaMethod(JavaVoidCallback javaVoidCallback, String str) {
        this.f64941v8.checkThread();
        checkReleased();
        this.f64941v8.registerVoidCallback(javaVoidCallback, getHandle(), str);
        return this;
    }

    public V8Object() {
    }

    public V8Object add(String str, double d11) {
        this.f64941v8.checkThread();
        checkReleased();
        V8 v82 = this.f64941v8;
        v82.add(v82.getV8RuntimePtr(), this.objectHandle, str, d11);
        return this;
    }

    public V8Object registerJavaMethod(Object obj, String str, String str2, Class<?>[] clsArr) {
        return registerJavaMethod(obj, str, str2, clsArr, false);
    }

    public V8Object registerJavaMethod(Object obj, String str, String str2, Class<?>[] clsArr, boolean z11) {
        this.f64941v8.checkThread();
        checkReleased();
        try {
            Method method = obj.getClass().getMethod(str, clsArr);
            method.setAccessible(true);
            this.f64941v8.registerCallback(obj, method, getHandle(), str2, z11);
            return this;
        } catch (NoSuchMethodException e11) {
            throw new IllegalStateException(e11);
        } catch (SecurityException e12) {
            throw new IllegalStateException(e12);
        }
    }

    public V8Object add(String str, String str2) {
        this.f64941v8.checkThread();
        checkReleased();
        if (str2 == null) {
            V8 v82 = this.f64941v8;
            v82.addNull(v82.getV8RuntimePtr(), this.objectHandle, str);
        } else if (str2.equals(V8.getUndefined())) {
            V8 v83 = this.f64941v8;
            v83.addUndefined(v83.getV8RuntimePtr(), this.objectHandle, str);
        } else {
            V8 v84 = this.f64941v8;
            v84.add(v84.getV8RuntimePtr(), this.objectHandle, str, str2);
        }
        return this;
    }

    public V8Object add(String str, V8Value v8Value) {
        V8Value v8Value2 = v8Value;
        this.f64941v8.checkThread();
        checkReleased();
        this.f64941v8.checkRuntime(v8Value2);
        if (v8Value2 == null) {
            V8 v82 = this.f64941v8;
            v82.addNull(v82.getV8RuntimePtr(), this.objectHandle, str);
        } else if (v8Value2.equals(V8.getUndefined())) {
            V8 v83 = this.f64941v8;
            v83.addUndefined(v83.getV8RuntimePtr(), this.objectHandle, str);
        } else {
            V8 v84 = this.f64941v8;
            v84.addObject(v84.getV8RuntimePtr(), this.objectHandle, str, v8Value.getHandle());
        }
        return this;
    }
}
