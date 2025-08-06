package com.amazonaws.internal;

import com.amazonaws.AbortedException;
import com.amazonaws.logging.LogFactory;
import java.io.IOException;
import java.io.InputStream;

public abstract class SdkInputStream extends InputStream implements MetricAware {
    @Deprecated
    public final boolean a() {
        InputStream f11 = f();
        if (f11 instanceof MetricAware) {
            return ((MetricAware) f11).a();
        }
        return false;
    }

    public void b() throws IOException {
    }

    public final void e() {
        if (Thread.interrupted()) {
            try {
                b();
            } catch (IOException e11) {
                LogFactory.b(getClass()).d("FYI", e11);
            }
            throw new AbortedException();
        }
    }

    public abstract InputStream f();
}
