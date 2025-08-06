package com.tencent.android.tpns.mqtt.internal.wire;

import java.io.IOException;
import java.io.InputStream;

public class CountingInputStream extends InputStream {
    private int counter = 0;

    /* renamed from: in  reason: collision with root package name */
    private InputStream f40471in;

    public CountingInputStream(InputStream inputStream) {
        this.f40471in = inputStream;
    }

    public int getCounter() {
        return this.counter;
    }

    public int read() throws IOException {
        int read = this.f40471in.read();
        if (read != -1) {
            this.counter++;
        }
        return read;
    }

    public void resetCounter() {
        this.counter = 0;
    }
}
