package com.alibaba.fastjson;

import com.alibaba.fastjson.serializer.SerializeWriter;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;

public class d implements Closeable, Flushable {

    /* renamed from: b  reason: collision with root package name */
    public SerializeWriter f14173b;

    public void close() throws IOException {
        this.f14173b.close();
    }

    public void flush() throws IOException {
        this.f14173b.flush();
    }
}
