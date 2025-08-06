package com.huobi.woodpecker.kalle;

import android.text.TextUtils;
import com.huobi.woodpecker.kalle.util.IOUtils;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;

public class n extends BasicOutData<n> implements l {

    /* renamed from: b  reason: collision with root package name */
    public final String f21112b;

    /* renamed from: c  reason: collision with root package name */
    public final Charset f21113c;

    /* renamed from: d  reason: collision with root package name */
    public final String f21114d;

    public n(String str, Charset charset, String str2) {
        this.f21112b = str;
        this.f21113c = charset;
        this.f21114d = str2;
    }

    public void a(OutputStream outputStream) throws IOException {
        IOUtils.k(outputStream, this.f21112b, this.f21113c);
    }

    public String contentType() {
        return this.f21114d;
    }

    public long length() {
        if (TextUtils.isEmpty(this.f21112b)) {
            return 0;
        }
        return (long) IOUtils.d(this.f21112b, this.f21113c).length;
    }

    public String toString() {
        return this.f21112b;
    }
}
