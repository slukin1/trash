package com.hbg.lib.apng.io;

import java.nio.ByteOrder;

public class APNGWriter extends ByteBufferWriter {
    public void d(int i11) {
        super.d(i11);
        this.f66214a.order(ByteOrder.BIG_ENDIAN);
    }

    public void g(int i11) {
        b((byte) (i11 & 255));
        b((byte) ((i11 >> 8) & 255));
        b((byte) ((i11 >> 16) & 255));
        b((byte) ((i11 >> 24) & 255));
    }

    public void h(int i11) {
        b((byte) ((i11 >> 24) & 255));
        b((byte) ((i11 >> 16) & 255));
        b((byte) ((i11 >> 8) & 255));
        b((byte) (i11 & 255));
    }
}
