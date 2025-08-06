package com.hbg.lib.apng.loader;

import a6.b;
import java.io.IOException;
import java.io.InputStream;
import y5.a;
import z5.e;

public abstract class StreamLoader implements b {
    public final synchronized a a() throws IOException {
        return new e(b());
    }

    public abstract InputStream b() throws IOException;
}
