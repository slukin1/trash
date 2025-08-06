package com.hbg.lib.apng.io;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import y5.b;

public class ByteBufferWriter implements b {

    /* renamed from: a  reason: collision with root package name */
    public ByteBuffer f66214a;

    public ByteBufferWriter() {
        d(10240);
    }

    public int a() {
        return this.f66214a.position();
    }

    public void b(byte b11) {
        this.f66214a.put(b11);
    }

    public void c(byte[] bArr) {
        this.f66214a.put(bArr);
    }

    public void close() {
    }

    public void d(int i11) {
        ByteBuffer byteBuffer = this.f66214a;
        if (byteBuffer == null || i11 > byteBuffer.capacity()) {
            ByteBuffer allocate = ByteBuffer.allocate(i11);
            this.f66214a = allocate;
            allocate.order(ByteOrder.LITTLE_ENDIAN);
        }
        this.f66214a.clear();
    }

    public void e(int i11) {
        this.f66214a.position(i11 + a());
    }

    public byte[] f() {
        return this.f66214a.array();
    }
}
