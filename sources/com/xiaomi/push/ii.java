package com.xiaomi.push;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ii extends il {

    /* renamed from: a  reason: collision with root package name */
    public InputStream f52365a = null;

    /* renamed from: a  reason: collision with other field name */
    public OutputStream f3249a = null;

    public ii() {
    }

    public int a(byte[] bArr, int i11, int i12) {
        InputStream inputStream = this.f52365a;
        if (inputStream != null) {
            try {
                int read = inputStream.read(bArr, i11, i12);
                if (read >= 0) {
                    return read;
                }
                throw new im(4);
            } catch (IOException e11) {
                throw new im(0, (Throwable) e11);
            }
        } else {
            throw new im(1, "Cannot read from null inputStream");
        }
    }

    public ii(OutputStream outputStream) {
        this.f3249a = outputStream;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m2901a(byte[] bArr, int i11, int i12) {
        OutputStream outputStream = this.f3249a;
        if (outputStream != null) {
            try {
                outputStream.write(bArr, i11, i12);
            } catch (IOException e11) {
                throw new im(0, (Throwable) e11);
            }
        } else {
            throw new im(1, "Cannot write to null outputStream");
        }
    }
}
