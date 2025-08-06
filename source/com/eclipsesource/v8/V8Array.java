package com.eclipsesource.v8;

public class V8Array extends V8Object {

    public static class Undefined extends V8Array {
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

        public int executeIntegerFunction(String str, V8Array v8Array) {
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

        public Object get(int i11) {
            throw new UnsupportedOperationException();
        }

        public V8Array getArray(String str) {
            throw new UnsupportedOperationException();
        }

        public boolean getBoolean(String str) {
            throw new UnsupportedOperationException();
        }

        public boolean[] getBooleans(int i11, int i12) {
            throw new UnsupportedOperationException();
        }

        public byte getByte(int i11) {
            throw new UnsupportedOperationException();
        }

        public byte[] getBytes(int i11, int i12) {
            throw new UnsupportedOperationException();
        }

        public double getDouble(String str) {
            throw new UnsupportedOperationException();
        }

        public double[] getDoubles(int i11, int i12) {
            throw new UnsupportedOperationException();
        }

        public int getInteger(String str) {
            throw new UnsupportedOperationException();
        }

        public int[] getIntegers(int i11, int i12) {
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

        public String[] getStrings(int i11, int i12) {
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

        public int length() {
            throw new UnsupportedOperationException();
        }

        public V8Array push(boolean z11) {
            throw new UnsupportedOperationException();
        }

        public V8Array pushUndefined() {
            throw new UnsupportedOperationException();
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

        public V8Array getArray(int i11) {
            throw new UnsupportedOperationException();
        }

        public boolean getBoolean(int i11) {
            throw new UnsupportedOperationException();
        }

        public int getBooleans(int i11, int i12, boolean[] zArr) {
            throw new UnsupportedOperationException();
        }

        public int getBytes(int i11, int i12, byte[] bArr) {
            throw new UnsupportedOperationException();
        }

        public double getDouble(int i11) {
            throw new UnsupportedOperationException();
        }

        public int getDoubles(int i11, int i12, double[] dArr) {
            throw new UnsupportedOperationException();
        }

        public int getInteger(int i11) {
            throw new UnsupportedOperationException();
        }

        public int getIntegers(int i11, int i12, int[] iArr) {
            throw new UnsupportedOperationException();
        }

        public V8Object getObject(int i11) {
            throw new UnsupportedOperationException();
        }

        public String getString(int i11) {
            throw new UnsupportedOperationException();
        }

        public int getStrings(int i11, int i12, String[] strArr) {
            throw new UnsupportedOperationException();
        }

        public int getType() {
            throw new UnsupportedOperationException();
        }

        public V8Array push(double d11) {
            throw new UnsupportedOperationException();
        }

        public V8Object registerJavaMethod(JavaVoidCallback javaVoidCallback, String str) {
            throw new UnsupportedOperationException();
        }

        public V8Object add(String str, int i11) {
            throw new UnsupportedOperationException();
        }

        public int getType(int i11) {
            throw new UnsupportedOperationException();
        }

        public V8Array push(int i11) {
            throw new UnsupportedOperationException();
        }

        public V8Object registerJavaMethod(Object obj, String str, String str2, Class<?>[] clsArr, boolean z11) {
            throw new UnsupportedOperationException();
        }

        public V8Object add(String str, String str2) {
            throw new UnsupportedOperationException();
        }

        public int getType(int i11, int i12) {
            throw new UnsupportedOperationException();
        }

        public V8Array push(String str) {
            throw new UnsupportedOperationException();
        }

        public Undefined twin() {
            return (Undefined) V8Array.super.twin();
        }

        public V8Object add(String str, V8Value v8Value) {
            throw new UnsupportedOperationException();
        }

        public V8Array push(V8Value v8Value) {
            throw new UnsupportedOperationException();
        }
    }

    public V8Array() {
    }

    public V8Value createTwin() {
        return new V8Array(this.f64941v8);
    }

    public Object get(int i11) {
        this.f64941v8.checkThread();
        checkReleased();
        V8 v82 = this.f64941v8;
        return v82.arrayGet(v82.getV8RuntimePtr(), 6, this.objectHandle, i11);
    }

    public V8Array getArray(int i11) {
        this.f64941v8.checkThread();
        checkReleased();
        V8 v82 = this.f64941v8;
        Object arrayGet = v82.arrayGet(v82.getV8RuntimePtr(), 5, this.objectHandle, i11);
        if (arrayGet == null || (arrayGet instanceof V8Array)) {
            return (V8Array) arrayGet;
        }
        throw new V8ResultUndefined();
    }

    public boolean getBoolean(int i11) {
        this.f64941v8.checkThread();
        checkReleased();
        V8 v82 = this.f64941v8;
        return v82.arrayGetBoolean(v82.getV8RuntimePtr(), getHandle(), i11);
    }

    public boolean[] getBooleans(int i11, int i12) {
        this.f64941v8.checkThread();
        checkReleased();
        V8 v82 = this.f64941v8;
        return v82.arrayGetBooleans(v82.getV8RuntimePtr(), getHandle(), i11, i12);
    }

    public byte getByte(int i11) {
        this.f64941v8.checkThread();
        checkReleased();
        V8 v82 = this.f64941v8;
        return v82.arrayGetByte(v82.getV8RuntimePtr(), getHandle(), i11);
    }

    public byte[] getBytes(int i11, int i12) {
        this.f64941v8.checkThread();
        checkReleased();
        V8 v82 = this.f64941v8;
        return v82.arrayGetBytes(v82.getV8RuntimePtr(), getHandle(), i11, i12);
    }

    public double getDouble(int i11) {
        this.f64941v8.checkThread();
        checkReleased();
        V8 v82 = this.f64941v8;
        return v82.arrayGetDouble(v82.getV8RuntimePtr(), getHandle(), i11);
    }

    public double[] getDoubles(int i11, int i12) {
        this.f64941v8.checkThread();
        checkReleased();
        V8 v82 = this.f64941v8;
        return v82.arrayGetDoubles(v82.getV8RuntimePtr(), getHandle(), i11, i12);
    }

    public int getInteger(int i11) {
        this.f64941v8.checkThread();
        checkReleased();
        V8 v82 = this.f64941v8;
        return v82.arrayGetInteger(v82.getV8RuntimePtr(), getHandle(), i11);
    }

    public int[] getIntegers(int i11, int i12) {
        this.f64941v8.checkThread();
        checkReleased();
        V8 v82 = this.f64941v8;
        return v82.arrayGetIntegers(v82.getV8RuntimePtr(), getHandle(), i11, i12);
    }

    public V8Object getObject(int i11) {
        this.f64941v8.checkThread();
        checkReleased();
        V8 v82 = this.f64941v8;
        Object arrayGet = v82.arrayGet(v82.getV8RuntimePtr(), 6, this.objectHandle, i11);
        if (arrayGet == null || (arrayGet instanceof V8Object)) {
            return (V8Object) arrayGet;
        }
        throw new V8ResultUndefined();
    }

    public String getString(int i11) {
        this.f64941v8.checkThread();
        checkReleased();
        V8 v82 = this.f64941v8;
        return v82.arrayGetString(v82.getV8RuntimePtr(), getHandle(), i11);
    }

    public String[] getStrings(int i11, int i12) {
        this.f64941v8.checkThread();
        checkReleased();
        V8 v82 = this.f64941v8;
        return v82.arrayGetStrings(v82.getV8RuntimePtr(), getHandle(), i11, i12);
    }

    public int getType(int i11) {
        this.f64941v8.checkThread();
        checkReleased();
        V8 v82 = this.f64941v8;
        return v82.getType(v82.getV8RuntimePtr(), getHandle(), i11);
    }

    public void initialize(long j11, Object obj) {
        long initNewV8Array = this.f64941v8.initNewV8Array(j11);
        this.released = false;
        addObjectReference(initNewV8Array);
    }

    public int length() {
        this.f64941v8.checkThread();
        checkReleased();
        V8 v82 = this.f64941v8;
        return v82.arrayGetSize(v82.getV8RuntimePtr(), getHandle());
    }

    public V8Array push(int i11) {
        this.f64941v8.checkThread();
        checkReleased();
        V8 v82 = this.f64941v8;
        v82.addArrayIntItem(v82.getV8RuntimePtr(), getHandle(), i11);
        return this;
    }

    public V8Array pushNull() {
        this.f64941v8.checkThread();
        checkReleased();
        V8 v82 = this.f64941v8;
        v82.addArrayNullItem(v82.getV8RuntimePtr(), getHandle());
        return this;
    }

    public V8Array pushUndefined() {
        this.f64941v8.checkThread();
        checkReleased();
        V8 v82 = this.f64941v8;
        v82.addArrayUndefinedItem(v82.getV8RuntimePtr(), getHandle());
        return this;
    }

    public String toString() {
        return (this.released || this.f64941v8.isReleased()) ? "[Array released]" : super.toString();
    }

    public V8Array(V8 v82) {
        super(v82);
        v82.checkThread();
    }

    public V8Array twin() {
        return (V8Array) super.twin();
    }

    public V8Array(V8 v82, Object obj) {
        super(v82, obj);
    }

    public int getBooleans(int i11, int i12, boolean[] zArr) {
        this.f64941v8.checkThread();
        checkReleased();
        if (i12 <= zArr.length) {
            V8 v82 = this.f64941v8;
            return v82.arrayGetBooleans(v82.getV8RuntimePtr(), getHandle(), i11, i12, zArr);
        }
        throw new IndexOutOfBoundsException();
    }

    public int getBytes(int i11, int i12, byte[] bArr) {
        this.f64941v8.checkThread();
        checkReleased();
        if (i12 <= bArr.length) {
            V8 v82 = this.f64941v8;
            return v82.arrayGetBytes(v82.getV8RuntimePtr(), getHandle(), i11, i12, bArr);
        }
        throw new IndexOutOfBoundsException();
    }

    public int getDoubles(int i11, int i12, double[] dArr) {
        this.f64941v8.checkThread();
        checkReleased();
        if (i12 <= dArr.length) {
            V8 v82 = this.f64941v8;
            return v82.arrayGetDoubles(v82.getV8RuntimePtr(), getHandle(), i11, i12, dArr);
        }
        throw new IndexOutOfBoundsException();
    }

    public int getIntegers(int i11, int i12, int[] iArr) {
        this.f64941v8.checkThread();
        checkReleased();
        if (i12 <= iArr.length) {
            V8 v82 = this.f64941v8;
            return v82.arrayGetIntegers(v82.getV8RuntimePtr(), getHandle(), i11, i12, iArr);
        }
        throw new IndexOutOfBoundsException();
    }

    public int getStrings(int i11, int i12, String[] strArr) {
        this.f64941v8.checkThread();
        checkReleased();
        if (i12 <= strArr.length) {
            V8 v82 = this.f64941v8;
            return v82.arrayGetStrings(v82.getV8RuntimePtr(), getHandle(), i11, i12, strArr);
        }
        throw new IndexOutOfBoundsException();
    }

    public int getType() {
        this.f64941v8.checkThread();
        checkReleased();
        V8 v82 = this.f64941v8;
        return v82.getArrayType(v82.getV8RuntimePtr(), getHandle());
    }

    public V8Array push(boolean z11) {
        this.f64941v8.checkThread();
        checkReleased();
        V8 v82 = this.f64941v8;
        v82.addArrayBooleanItem(v82.getV8RuntimePtr(), getHandle(), z11);
        return this;
    }

    public int getType(int i11, int i12) {
        this.f64941v8.checkThread();
        checkReleased();
        V8 v82 = this.f64941v8;
        return v82.getType(v82.getV8RuntimePtr(), getHandle(), i11, i12);
    }

    public V8Array push(double d11) {
        this.f64941v8.checkThread();
        checkReleased();
        V8 v82 = this.f64941v8;
        v82.addArrayDoubleItem(v82.getV8RuntimePtr(), getHandle(), d11);
        return this;
    }

    public V8Array push(String str) {
        this.f64941v8.checkThread();
        checkReleased();
        if (str == null) {
            V8 v82 = this.f64941v8;
            v82.addArrayNullItem(v82.getV8RuntimePtr(), getHandle());
        } else if (str.equals(V8.getUndefined())) {
            V8 v83 = this.f64941v8;
            v83.addArrayUndefinedItem(v83.getV8RuntimePtr(), getHandle());
        } else {
            V8 v84 = this.f64941v8;
            v84.addArrayStringItem(v84.getV8RuntimePtr(), getHandle(), str);
        }
        return this;
    }

    public V8Array push(V8Value v8Value) {
        this.f64941v8.checkThread();
        checkReleased();
        this.f64941v8.checkRuntime(v8Value);
        if (v8Value == null) {
            V8 v82 = this.f64941v8;
            v82.addArrayNullItem(v82.getV8RuntimePtr(), getHandle());
        } else if (v8Value.equals(V8.getUndefined())) {
            V8 v83 = this.f64941v8;
            v83.addArrayUndefinedItem(v83.getV8RuntimePtr(), getHandle());
        } else {
            V8 v84 = this.f64941v8;
            v84.addArrayObjectItem(v84.getV8RuntimePtr(), getHandle(), v8Value.getHandle());
        }
        return this;
    }

    public V8Array push(Object obj) {
        this.f64941v8.checkThread();
        checkReleased();
        if (obj instanceof V8Value) {
            this.f64941v8.checkRuntime((V8Value) obj);
        }
        if (obj == null) {
            V8 v82 = this.f64941v8;
            v82.addArrayNullItem(v82.getV8RuntimePtr(), getHandle());
        } else if (obj.equals(V8.getUndefined())) {
            V8 v83 = this.f64941v8;
            v83.addArrayUndefinedItem(v83.getV8RuntimePtr(), getHandle());
        } else if (obj instanceof Double) {
            V8 v84 = this.f64941v8;
            v84.addArrayDoubleItem(v84.getV8RuntimePtr(), getHandle(), ((Double) obj).doubleValue());
        } else if (obj instanceof Integer) {
            V8 v85 = this.f64941v8;
            v85.addArrayIntItem(v85.getV8RuntimePtr(), getHandle(), ((Integer) obj).intValue());
        } else if (obj instanceof Float) {
            V8 v86 = this.f64941v8;
            v86.addArrayDoubleItem(v86.getV8RuntimePtr(), getHandle(), ((Float) obj).doubleValue());
        } else if (obj instanceof Number) {
            V8 v87 = this.f64941v8;
            v87.addArrayDoubleItem(v87.getV8RuntimePtr(), getHandle(), ((Number) obj).doubleValue());
        } else if (obj instanceof Boolean) {
            V8 v88 = this.f64941v8;
            v88.addArrayBooleanItem(v88.getV8RuntimePtr(), getHandle(), ((Boolean) obj).booleanValue());
        } else if (obj instanceof String) {
            V8 v89 = this.f64941v8;
            v89.addArrayStringItem(v89.getV8RuntimePtr(), getHandle(), (String) obj);
        } else if (obj instanceof V8Value) {
            V8 v810 = this.f64941v8;
            v810.addArrayObjectItem(v810.getV8RuntimePtr(), getHandle(), ((V8Value) obj).getHandle());
        } else {
            throw new IllegalArgumentException();
        }
        return this;
    }
}
