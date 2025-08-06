package com.huobi.woodpecker.kalle;

import android.text.TextUtils;
import com.huobi.woodpecker.kalle.i;
import com.huobi.woodpecker.kalle.util.IOUtils;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;

public class p extends BasicOutData<n> implements l {

    /* renamed from: b  reason: collision with root package name */
    public final i f21115b;

    /* renamed from: c  reason: collision with root package name */
    public final Charset f21116c;

    /* renamed from: d  reason: collision with root package name */
    public final String f21117d;

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public Charset f21118a;

        /* renamed from: b  reason: collision with root package name */
        public String f21119b;

        /* renamed from: c  reason: collision with root package name */
        public i.b f21120c;

        public p d() {
            return new p(this);
        }

        public b e(i iVar) {
            this.f21120c.b(iVar);
            return this;
        }

        public b() {
            this.f21120c = i.f();
        }
    }

    public static b b() {
        return new b();
    }

    public void a(OutputStream outputStream) throws IOException {
        IOUtils.k(outputStream, this.f21115b.toString(), this.f21116c);
    }

    public String contentType() {
        return this.f21117d;
    }

    public long length() {
        String iVar = this.f21115b.toString();
        if (TextUtils.isEmpty(iVar)) {
            return 0;
        }
        return (long) IOUtils.d(iVar, this.f21116c).length;
    }

    public String toString() {
        return this.f21115b.toString();
    }

    public p(b bVar) {
        this.f21115b = bVar.f21120c.e();
        this.f21116c = bVar.f21118a == null ? Kalle.b().b() : bVar.f21118a;
        this.f21117d = TextUtils.isEmpty(bVar.f21119b) ? "application/x-www-form-urlencoded" : bVar.f21119b;
    }
}
