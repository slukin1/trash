package com.eclipsesource.v8;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class V8ArrayBuffer extends V8Value {
    public ByteBuffer byteBuffer;

    public V8ArrayBuffer(V8 v82, int i11) {
        super(v82);
        initialize(v82.getV8RuntimePtr(), Integer.valueOf(i11));
        ByteBuffer createV8ArrayBufferBackingStore = v82.createV8ArrayBufferBackingStore(v82.getV8RuntimePtr(), this.objectHandle, i11);
        this.byteBuffer = createV8ArrayBufferBackingStore;
        createV8ArrayBufferBackingStore.order(ByteOrder.nativeOrder());
    }

    public final byte[] array() {
        this.f64941v8.checkThread();
        checkReleased();
        return this.byteBuffer.array();
    }

    public final int arrayOffset() {
        this.f64941v8.checkThread();
        checkReleased();
        return this.byteBuffer.arrayOffset();
    }

    public final int capacity() {
        this.f64941v8.checkThread();
        checkReleased();
        return this.byteBuffer.capacity();
    }

    public final V8ArrayBuffer clear() {
        this.f64941v8.checkThread();
        checkReleased();
        this.byteBuffer.clear();
        return this;
    }

    public V8ArrayBuffer compact() {
        this.f64941v8.checkThread();
        checkReleased();
        this.byteBuffer.compact();
        return this;
    }

    public V8Value createTwin() {
        return new V8ArrayBuffer(this.f64941v8, this.byteBuffer);
    }

    public int doubleLimit() {
        this.f64941v8.checkThread();
        checkReleased();
        return this.byteBuffer.asDoubleBuffer().limit();
    }

    public final V8ArrayBuffer flip() {
        this.f64941v8.checkThread();
        checkReleased();
        this.byteBuffer.flip();
        return this;
    }

    public int floatLimit() {
        this.f64941v8.checkThread();
        checkReleased();
        return this.byteBuffer.asFloatBuffer().limit();
    }

    public byte get() {
        this.f64941v8.checkThread();
        checkReleased();
        return this.byteBuffer.get();
    }

    public char getChar() {
        this.f64941v8.checkThread();
        checkReleased();
        return this.byteBuffer.getChar();
    }

    public double getDouble() {
        this.f64941v8.checkThread();
        checkReleased();
        return this.byteBuffer.getDouble();
    }

    public float getFloat() {
        this.f64941v8.checkThread();
        checkReleased();
        return this.byteBuffer.getFloat();
    }

    public int getInt() {
        this.f64941v8.checkThread();
        checkReleased();
        return this.byteBuffer.getInt();
    }

    public long getLong() {
        this.f64941v8.checkThread();
        checkReleased();
        return this.byteBuffer.getLong();
    }

    public short getShort() {
        this.f64941v8.checkThread();
        checkReleased();
        return this.byteBuffer.getShort();
    }

    public final boolean hasArray() {
        this.f64941v8.checkThread();
        checkReleased();
        return this.byteBuffer.hasArray();
    }

    public final boolean hasRemaining() {
        this.f64941v8.checkThread();
        checkReleased();
        return this.byteBuffer.hasRemaining();
    }

    public void initialize(long j11, Object obj) {
        this.f64941v8.checkThread();
        if (obj instanceof ByteBuffer) {
            ByteBuffer byteBuffer2 = (ByteBuffer) obj;
            int limit = byteBuffer2.limit();
            V8 v82 = this.f64941v8;
            this.objectHandle = v82.initNewV8ArrayBuffer(v82.getV8RuntimePtr(), byteBuffer2, limit);
        } else {
            int intValue = ((Integer) obj).intValue();
            V8 v83 = this.f64941v8;
            this.objectHandle = v83.initNewV8ArrayBuffer(v83.getV8RuntimePtr(), intValue);
        }
        this.released = false;
        addObjectReference(this.objectHandle);
    }

    public int intLimit() {
        this.f64941v8.checkThread();
        checkReleased();
        return this.byteBuffer.asIntBuffer().limit();
    }

    public boolean isDirect() {
        this.f64941v8.checkThread();
        checkReleased();
        return this.byteBuffer.isDirect();
    }

    public boolean isReadOnly() {
        this.f64941v8.checkThread();
        checkReleased();
        return this.byteBuffer.isReadOnly();
    }

    public int limit() {
        this.f64941v8.checkThread();
        checkReleased();
        return this.byteBuffer.limit();
    }

    public final V8ArrayBuffer mark() {
        this.f64941v8.checkThread();
        checkReleased();
        this.byteBuffer.mark();
        return this;
    }

    public final ByteOrder order() {
        this.f64941v8.checkThread();
        checkReleased();
        return this.byteBuffer.order();
    }

    public final int position() {
        this.f64941v8.checkThread();
        checkReleased();
        return this.byteBuffer.position();
    }

    public V8ArrayBuffer put(byte b11) {
        this.f64941v8.checkThread();
        checkReleased();
        this.byteBuffer.put(b11);
        return this;
    }

    public V8ArrayBuffer putChar(char c11) {
        this.f64941v8.checkThread();
        checkReleased();
        this.byteBuffer.putChar(c11);
        return this;
    }

    public V8ArrayBuffer putDouble(double d11) {
        this.f64941v8.checkThread();
        checkReleased();
        this.byteBuffer.putDouble(d11);
        return this;
    }

    public V8ArrayBuffer putFloat(float f11) {
        this.f64941v8.checkThread();
        checkReleased();
        this.byteBuffer.putFloat(f11);
        return this;
    }

    public V8ArrayBuffer putInt(int i11) {
        this.f64941v8.checkThread();
        checkReleased();
        this.byteBuffer.putInt(i11);
        return this;
    }

    public V8ArrayBuffer putLong(long j11) {
        this.f64941v8.checkThread();
        checkReleased();
        this.byteBuffer.putLong(j11);
        return this;
    }

    public V8ArrayBuffer putShort(short s11) {
        this.f64941v8.checkThread();
        checkReleased();
        this.byteBuffer.putShort(s11);
        return this;
    }

    public final int remaining() {
        this.f64941v8.checkThread();
        checkReleased();
        return this.byteBuffer.remaining();
    }

    public final V8ArrayBuffer reset() {
        this.f64941v8.checkThread();
        checkReleased();
        this.byteBuffer.reset();
        return this;
    }

    public final V8ArrayBuffer rewind() {
        this.f64941v8.checkThread();
        checkReleased();
        this.byteBuffer.rewind();
        return this;
    }

    public int shortLimit() {
        this.f64941v8.checkThread();
        checkReleased();
        return this.byteBuffer.asShortBuffer().limit();
    }

    public V8ArrayBuffer twin() {
        this.f64941v8.checkThread();
        checkReleased();
        return (V8ArrayBuffer) super.twin();
    }

    public byte get(int i11) {
        this.f64941v8.checkThread();
        checkReleased();
        return this.byteBuffer.get(i11);
    }

    public char getChar(int i11) {
        this.f64941v8.checkThread();
        checkReleased();
        return this.byteBuffer.getChar(i11);
    }

    public double getDouble(int i11) {
        this.f64941v8.checkThread();
        checkReleased();
        return this.byteBuffer.getDouble(i11);
    }

    public float getFloat(int i11) {
        this.f64941v8.checkThread();
        checkReleased();
        return this.byteBuffer.getFloat(i11);
    }

    public int getInt(int i11) {
        this.f64941v8.checkThread();
        checkReleased();
        return this.byteBuffer.getInt(i11);
    }

    public long getLong(int i11) {
        this.f64941v8.checkThread();
        checkReleased();
        return this.byteBuffer.getLong(i11);
    }

    public short getShort(int i11) {
        this.f64941v8.checkThread();
        checkReleased();
        return this.byteBuffer.getShort(i11);
    }

    public final V8ArrayBuffer limit(int i11) {
        this.f64941v8.checkThread();
        checkReleased();
        this.byteBuffer.limit(i11);
        return this;
    }

    public final V8ArrayBuffer order(ByteOrder byteOrder) {
        this.f64941v8.checkThread();
        checkReleased();
        this.byteBuffer.order(byteOrder);
        return this;
    }

    public final V8ArrayBuffer position(int i11) {
        this.f64941v8.checkThread();
        checkReleased();
        this.byteBuffer.position(i11);
        return this;
    }

    public V8ArrayBuffer put(int i11, byte b11) {
        this.f64941v8.checkThread();
        checkReleased();
        this.byteBuffer.put(i11, b11);
        return this;
    }

    public V8ArrayBuffer putChar(int i11, char c11) {
        this.f64941v8.checkThread();
        checkReleased();
        this.byteBuffer.putChar(i11, c11);
        return this;
    }

    public V8ArrayBuffer putDouble(int i11, double d11) {
        this.f64941v8.checkThread();
        checkReleased();
        this.byteBuffer.putDouble(i11, d11);
        return this;
    }

    public V8ArrayBuffer putFloat(int i11, float f11) {
        this.f64941v8.checkThread();
        checkReleased();
        this.byteBuffer.putFloat(i11, f11);
        return this;
    }

    public V8ArrayBuffer putInt(int i11, int i12) {
        this.f64941v8.checkThread();
        checkReleased();
        this.byteBuffer.asIntBuffer().put(i11, i12);
        return this;
    }

    public V8ArrayBuffer putLong(int i11, long j11) {
        this.f64941v8.checkThread();
        checkReleased();
        this.byteBuffer.putLong(i11, j11);
        return this;
    }

    public V8ArrayBuffer putShort(int i11, short s11) {
        this.f64941v8.checkThread();
        checkReleased();
        this.byteBuffer.putShort(i11, s11);
        return this;
    }

    public V8ArrayBuffer(V8 v82, ByteBuffer byteBuffer2) {
        super(v82);
        byteBuffer2 = byteBuffer2 == null ? ByteBuffer.allocateDirect(0) : byteBuffer2;
        if (byteBuffer2.isDirect()) {
            initialize(v82.getV8RuntimePtr(), byteBuffer2);
            this.byteBuffer = byteBuffer2;
            byteBuffer2.order(ByteOrder.nativeOrder());
            return;
        }
        throw new IllegalArgumentException("ByteBuffer must be a allocated as a direct ByteBuffer");
    }

    public V8ArrayBuffer get(byte[] bArr, int i11, int i12) {
        this.f64941v8.checkThread();
        checkReleased();
        this.byteBuffer.get(bArr, i11, i12);
        return this;
    }

    public V8ArrayBuffer put(ByteBuffer byteBuffer2) {
        this.f64941v8.checkThread();
        checkReleased();
        this.byteBuffer.put(byteBuffer2);
        return this;
    }

    public V8ArrayBuffer get(byte[] bArr) {
        this.f64941v8.checkThread();
        checkReleased();
        this.byteBuffer.get(bArr);
        return this;
    }

    public V8ArrayBuffer put(byte[] bArr, int i11, int i12) {
        this.f64941v8.checkThread();
        checkReleased();
        this.byteBuffer.put(bArr, i11, i12);
        return this;
    }

    public final V8ArrayBuffer put(byte[] bArr) {
        this.f64941v8.checkThread();
        checkReleased();
        this.byteBuffer.put(bArr);
        return this;
    }
}
