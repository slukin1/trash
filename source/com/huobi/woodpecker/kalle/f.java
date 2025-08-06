package com.huobi.woodpecker.kalle;

import android.text.TextUtils;
import com.huobi.woodpecker.kalle.BasicOutData;
import com.huobi.woodpecker.kalle.i;
import com.huobi.woodpecker.kalle.util.IOUtils;
import com.jumio.commons.log.LogUtils;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;

public class f extends BasicOutData<f> implements l {

    /* renamed from: b  reason: collision with root package name */
    public final Charset f21055b;

    /* renamed from: c  reason: collision with root package name */
    public final String f21056c;

    /* renamed from: d  reason: collision with root package name */
    public final i f21057d;

    /* renamed from: e  reason: collision with root package name */
    public String f21058e;

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public Charset f21059a;

        /* renamed from: b  reason: collision with root package name */
        public String f21060b;

        /* renamed from: c  reason: collision with root package name */
        public i.b f21061c;

        public f d() {
            return new f(this);
        }

        public b e(i iVar) {
            this.f21061c.b(iVar);
            return this;
        }

        public b() {
            this.f21061c = i.f();
        }
    }

    public static String b() {
        StringBuilder sb2 = new StringBuilder("-------FormBoundary");
        for (int i11 = 1; i11 < 12; i11++) {
            long currentTimeMillis = System.currentTimeMillis() + ((long) i11);
            long j11 = currentTimeMillis % 3;
            if (j11 == 0) {
                sb2.append(((char) ((int) currentTimeMillis)) % 9);
            } else if (j11 == 1) {
                sb2.append((char) ((int) ((currentTimeMillis % 26) + 65)));
            } else {
                sb2.append((char) ((int) ((currentTimeMillis % 26) + 97)));
            }
        }
        return sb2.toString();
    }

    public static b c() {
        return new b();
    }

    public void a(OutputStream outputStream) throws IOException {
        for (String next : this.f21057d.e()) {
            for (Object next2 : this.f21057d.c(next)) {
                if (next2 instanceof String) {
                    e(outputStream, next, (String) next2);
                } else if (next2 instanceof b) {
                    d(outputStream, next, (b) next2);
                }
                IOUtils.k(outputStream, LogUtils.NEW_LINE, this.f21055b);
            }
        }
        IOUtils.k(outputStream, "--" + this.f21058e + "--", this.f21055b);
    }

    public String contentType() {
        return this.f21056c + "; boundary=" + this.f21058e;
    }

    public final void d(OutputStream outputStream, String str, b bVar) throws IOException {
        IOUtils.k(outputStream, "--" + this.f21058e + LogUtils.NEW_LINE, this.f21055b);
        IOUtils.k(outputStream, "Content-Disposition: form-data; name=\"", this.f21055b);
        IOUtils.k(outputStream, str, this.f21055b);
        IOUtils.k(outputStream, "\"; filename=\"", this.f21055b);
        IOUtils.k(outputStream, bVar.name(), this.f21055b);
        IOUtils.k(outputStream, "\"\r\n", this.f21055b);
        IOUtils.k(outputStream, "Content-Type: " + bVar.contentType() + "\r\n\r\n", this.f21055b);
        if (outputStream instanceof BasicOutData.b) {
            ((BasicOutData.b) outputStream).b(bVar.length());
        } else {
            bVar.writeTo(outputStream);
        }
    }

    public final void e(OutputStream outputStream, String str, String str2) throws IOException {
        IOUtils.k(outputStream, "--" + this.f21058e + LogUtils.NEW_LINE, this.f21055b);
        IOUtils.k(outputStream, "Content-Disposition: form-data; name=\"", this.f21055b);
        IOUtils.k(outputStream, str, this.f21055b);
        IOUtils.k(outputStream, "\"\r\n\r\n", this.f21055b);
        IOUtils.k(outputStream, str2, this.f21055b);
    }

    public long length() {
        BasicOutData.b bVar = new BasicOutData.b();
        try {
            a(bVar);
        } catch (IOException unused) {
        }
        return bVar.a();
    }

    public f(b bVar) {
        this.f21055b = bVar.f21059a == null ? Kalle.b().b() : bVar.f21059a;
        this.f21056c = TextUtils.isEmpty(bVar.f21060b) ? "multipart/form-data" : bVar.f21060b;
        this.f21057d = bVar.f21061c.e();
        this.f21058e = b();
    }
}
