package com.hbg.lib.apng.loader;

import a6.b;
import java.io.IOException;
import java.nio.ByteBuffer;
import y5.a;

public abstract class ByteBufferLoader implements b {
    public a a() throws IOException {
        return new z5.b(b());
    }

    public abstract ByteBuffer b();
}
