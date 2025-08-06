package com.huobi.kalle;

import android.text.TextUtils;
import com.huobi.kalle.i;
import com.huobi.kalle.util.IOUtils;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;

public class o extends BasicOutData<n> implements l {

    /* renamed from: b  reason: collision with root package name */
    public final i f74757b;

    /* renamed from: c  reason: collision with root package name */
    public final Charset f74758c;

    /* renamed from: d  reason: collision with root package name */
    public final String f74759d;

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public Charset f74760a;

        /* renamed from: b  reason: collision with root package name */
        public String f74761b;

        /* renamed from: c  reason: collision with root package name */
        public i.b f74762c;

        public o d() {
            return new o(this);
        }

        public b e(i iVar) {
            this.f74762c.b(iVar);
            return this;
        }

        public b() {
            this.f74762c = i.f();
        }
    }

    public static b b() {
        return new b();
    }

    public void a(OutputStream outputStream) throws IOException {
        IOUtils.k(outputStream, this.f74757b.toString(), this.f74758c);
    }

    public String contentType() {
        return this.f74759d;
    }

    public long length() {
        String iVar = this.f74757b.toString();
        if (TextUtils.isEmpty(iVar)) {
            return 0;
        }
        return (long) IOUtils.d(iVar, this.f74758c).length;
    }

    public String toString() {
        return this.f74757b.toString();
    }

    public o(b bVar) {
        this.f74757b = bVar.f74762c.e();
        this.f74758c = bVar.f74760a == null ? Kalle.a().b() : bVar.f74760a;
        this.f74759d = TextUtils.isEmpty(bVar.f74761b) ? "application/x-www-form-urlencoded" : bVar.f74761b;
    }
}
