package com.eclipsesource.v8;

public class V8TypedArray extends V8Array {

    public static class V8ArrayData {
        /* access modifiers changed from: private */
        public V8ArrayBuffer buffer;
        /* access modifiers changed from: private */
        public int offset;
        /* access modifiers changed from: private */
        public int size;
        /* access modifiers changed from: private */
        public int type;

        public V8ArrayData(V8ArrayBuffer v8ArrayBuffer, int i11, int i12, int i13) {
            this.buffer = v8ArrayBuffer;
            this.offset = i11;
            this.size = i12;
            this.type = i13;
        }
    }

    public V8TypedArray(V8 v82, V8ArrayBuffer v8ArrayBuffer, int i11, int i12, int i13) {
        super(v82, new V8ArrayData(v8ArrayBuffer, i12, i13, i11));
    }

    private void checkArrayProperties(V8ArrayData v8ArrayData) {
        checkOffset(v8ArrayData);
        checkSize(v8ArrayData);
    }

    private void checkOffset(V8ArrayData v8ArrayData) {
        if (v8ArrayData.offset % getStructureSize(v8ArrayData.type) != 0) {
            throw new IllegalStateException("RangeError: Start offset of Int32Array must be a multiple of " + getStructureSize(v8ArrayData.type));
        }
    }

    private void checkSize(V8ArrayData v8ArrayData) {
        if (v8ArrayData.size < 0) {
            throw new IllegalStateException("RangeError: Invalid typed array length");
        } else if ((v8ArrayData.size * getStructureSize(v8ArrayData.type)) + v8ArrayData.offset > v8ArrayData.buffer.limit()) {
            throw new IllegalStateException("RangeError: Invalid typed array length");
        }
    }

    private long createTypedArray(long j11, V8ArrayData v8ArrayData) {
        int access$000 = v8ArrayData.type;
        if (access$000 == 1) {
            return this.f64941v8.initNewV8Int32Array(j11, v8ArrayData.buffer.objectHandle, v8ArrayData.offset, v8ArrayData.size);
        } else if (access$000 == 2) {
            return this.f64941v8.initNewV8Float64Array(j11, v8ArrayData.buffer.objectHandle, v8ArrayData.offset, v8ArrayData.size);
        } else if (access$000 != 9) {
            switch (access$000) {
                case 11:
                    return this.f64941v8.initNewV8UInt8Array(j11, v8ArrayData.buffer.objectHandle, v8ArrayData.offset, v8ArrayData.size);
                case 12:
                    return this.f64941v8.initNewV8UInt8ClampedArray(j11, v8ArrayData.buffer.objectHandle, v8ArrayData.offset, v8ArrayData.size);
                case 13:
                    return this.f64941v8.initNewV8Int16Array(j11, v8ArrayData.buffer.objectHandle, v8ArrayData.offset, v8ArrayData.size);
                case 14:
                    return this.f64941v8.initNewV8UInt16Array(j11, v8ArrayData.buffer.objectHandle, v8ArrayData.offset, v8ArrayData.size);
                case 15:
                    return this.f64941v8.initNewV8UInt32Array(j11, v8ArrayData.buffer.objectHandle, v8ArrayData.offset, v8ArrayData.size);
                case 16:
                    return this.f64941v8.initNewV8Float32Array(j11, v8ArrayData.buffer.objectHandle, v8ArrayData.offset, v8ArrayData.size);
                default:
                    throw new IllegalArgumentException("Cannot create a typed array of type " + V8Value.getStringRepresentation(v8ArrayData.type));
            }
        } else {
            return this.f64941v8.initNewV8Int8Array(j11, v8ArrayData.buffer.objectHandle, v8ArrayData.offset, v8ArrayData.size);
        }
    }

    public static int getStructureSize(int i11) {
        if (i11 == 1) {
            return 4;
        }
        if (i11 == 2) {
            return 8;
        }
        if (i11 != 9) {
            switch (i11) {
                case 11:
                case 12:
                    break;
                case 13:
                case 14:
                    return 2;
                case 15:
                case 16:
                    return 4;
                default:
                    throw new IllegalArgumentException("Cannot create a typed array of type " + V8Value.getStringRepresentation(i11));
            }
        }
        return 1;
    }

    public V8Value createTwin() {
        this.f64941v8.checkThread();
        checkReleased();
        return new V8TypedArray(this.f64941v8);
    }

    public Object get(int i11) {
        this.f64941v8.checkThread();
        checkReleased();
        int type = getType();
        if (type == 1) {
            return super.get(i11);
        }
        if (type == 2) {
            return super.get(i11);
        }
        if (type == 9) {
            return Byte.valueOf(((Number) super.get(i11)).byteValue());
        }
        switch (type) {
            case 11:
                return Short.valueOf((short) (((Number) super.get(i11)).shortValue() & 255));
            case 12:
                return Short.valueOf((short) (((Number) super.get(i11)).byteValue() & 255));
            case 13:
                return Short.valueOf(((Number) super.get(i11)).shortValue());
            case 14:
                return Integer.valueOf(((Integer) super.get(i11)).intValue() & 65535);
            case 15:
                return Long.valueOf(-1 & ((Number) super.get(i11)).longValue());
            case 16:
                return Float.valueOf(((Number) super.get(i11)).floatValue());
            default:
                return null;
        }
    }

    public V8ArrayBuffer getBuffer() {
        return (V8ArrayBuffer) get("buffer");
    }

    public void initialize(long j11, Object obj) {
        this.f64941v8.checkThread();
        if (obj == null) {
            super.initialize(j11, obj);
            return;
        }
        V8ArrayData v8ArrayData = (V8ArrayData) obj;
        checkArrayProperties(v8ArrayData);
        long createTypedArray = createTypedArray(j11, v8ArrayData);
        this.released = false;
        addObjectReference(createTypedArray);
    }

    private V8TypedArray(V8 v82) {
        super(v82);
    }
}
