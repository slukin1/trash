package com.huawei.secure.android.common.ssl.util;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;

public abstract class d {
    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
                e.d("IOUtil", "closeSecure IOException");
            }
        }
    }

    public static void b(InputStream inputStream) {
        a(inputStream);
    }

    public static void c(OutputStream outputStream) {
        a(outputStream);
    }

    public static void d(Reader reader) {
        a(reader);
    }
}
