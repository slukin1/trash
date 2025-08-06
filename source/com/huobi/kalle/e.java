package com.huobi.kalle;

import android.text.TextUtils;
import com.huobi.kalle.BasicOutData;
import com.huobi.kalle.i;
import com.huobi.kalle.util.IOUtils;
import com.jumio.commons.log.LogUtils;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;

public class e extends BasicOutData<e> implements l {

    /* renamed from: b  reason: collision with root package name */
    public final Charset f74697b;

    /* renamed from: c  reason: collision with root package name */
    public final String f74698c;

    /* renamed from: d  reason: collision with root package name */
    public final i f74699d;

    /* renamed from: e  reason: collision with root package name */
    public String f74700e;

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public Charset f74701a;

        /* renamed from: b  reason: collision with root package name */
        public String f74702b;

        /* renamed from: c  reason: collision with root package name */
        public i.b f74703c;

        public e d() {
            return new e(this);
        }

        public b e(i iVar) {
            this.f74703c.b(iVar);
            return this;
        }

        public b() {
            this.f74703c = i.f();
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
        for (String next : this.f74699d.e()) {
            for (Object next2 : this.f74699d.c(next)) {
                if (next2 instanceof String) {
                    e(outputStream, next, (String) next2);
                } else if (next2 instanceof a) {
                    d(outputStream, next, (a) next2);
                }
                IOUtils.k(outputStream, LogUtils.NEW_LINE, this.f74697b);
            }
        }
        IOUtils.k(outputStream, "--" + this.f74700e + "--", this.f74697b);
    }

    public String contentType() {
        return this.f74698c + "; boundary=" + this.f74700e;
    }

    public final void d(OutputStream outputStream, String str, a aVar) throws IOException {
        IOUtils.k(outputStream, "--" + this.f74700e + LogUtils.NEW_LINE, this.f74697b);
        IOUtils.k(outputStream, "Content-Disposition: form-data; name=\"", this.f74697b);
        IOUtils.k(outputStream, str, this.f74697b);
        IOUtils.k(outputStream, "\"; filename=\"", this.f74697b);
        IOUtils.k(outputStream, aVar.name(), this.f74697b);
        IOUtils.k(outputStream, "\"\r\n", this.f74697b);
        IOUtils.k(outputStream, "Content-Type: " + aVar.contentType() + "\r\n\r\n", this.f74697b);
        if (outputStream instanceof BasicOutData.b) {
            ((BasicOutData.b) outputStream).b(aVar.length());
        } else {
            aVar.writeTo(outputStream);
        }
    }

    public final void e(OutputStream outputStream, String str, String str2) throws IOException {
        IOUtils.k(outputStream, "--" + this.f74700e + LogUtils.NEW_LINE, this.f74697b);
        IOUtils.k(outputStream, "Content-Disposition: form-data; name=\"", this.f74697b);
        IOUtils.k(outputStream, str, this.f74697b);
        IOUtils.k(outputStream, "\"\r\n\r\n", this.f74697b);
        IOUtils.k(outputStream, str2, this.f74697b);
    }

    public long length() {
        BasicOutData.b bVar = new BasicOutData.b();
        try {
            a(bVar);
        } catch (IOException unused) {
        }
        return bVar.a();
    }

    public e(b bVar) {
        this.f74697b = bVar.f74701a == null ? Kalle.a().b() : bVar.f74701a;
        this.f74698c = TextUtils.isEmpty(bVar.f74702b) ? "multipart/form-data" : bVar.f74702b;
        this.f74699d = bVar.f74703c.e();
        this.f74700e = b();
    }
}
