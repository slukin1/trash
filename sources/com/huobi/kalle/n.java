package com.huobi.kalle;

import android.text.TextUtils;
import com.huobi.kalle.util.IOUtils;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;

public class n extends BasicOutData<n> implements l {

    /* renamed from: b  reason: collision with root package name */
    public final String f74754b;

    /* renamed from: c  reason: collision with root package name */
    public final Charset f74755c;

    /* renamed from: d  reason: collision with root package name */
    public final String f74756d;

    public n(String str, Charset charset, String str2) {
        this.f74754b = str;
        this.f74755c = charset;
        this.f74756d = str2;
    }

    public void a(OutputStream outputStream) throws IOException {
        IOUtils.k(outputStream, this.f74754b, this.f74755c);
    }

    public String contentType() {
        return this.f74756d;
    }

    public long length() {
        if (TextUtils.isEmpty(this.f74754b)) {
            return 0;
        }
        return (long) IOUtils.d(this.f74754b, this.f74755c).length;
    }

    public String toString() {
        return this.f74754b;
    }
}
