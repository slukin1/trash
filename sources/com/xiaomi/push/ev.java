package com.xiaomi.push;

import android.os.Build;
import com.adjust.sdk.Constants;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.dq;
import com.xiaomi.push.service.ar;
import com.xiaomi.push.service.ax;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Locale;
import java.util.TimeZone;
import java.util.zip.Adler32;

public class ev {

    /* renamed from: a  reason: collision with root package name */
    private int f51753a;

    /* renamed from: a  reason: collision with other field name */
    private ez f2819a;

    /* renamed from: a  reason: collision with other field name */
    private OutputStream f2820a;

    /* renamed from: a  reason: collision with other field name */
    public ByteBuffer f2821a = ByteBuffer.allocate(2048);

    /* renamed from: a  reason: collision with other field name */
    private Adler32 f2822a = new Adler32();

    /* renamed from: a  reason: collision with other field name */
    private byte[] f2823a;

    /* renamed from: b  reason: collision with root package name */
    private int f51754b;

    /* renamed from: b  reason: collision with other field name */
    private ByteBuffer f2824b = ByteBuffer.allocate(4);

    public ev(OutputStream outputStream, ez ezVar) {
        this.f2820a = new BufferedOutputStream(outputStream);
        this.f2819a = ezVar;
        TimeZone timeZone = TimeZone.getDefault();
        this.f51753a = timeZone.getRawOffset() / Constants.ONE_HOUR;
        this.f51754b = timeZone.useDaylightTime() ? 1 : 0;
    }

    public int a(es esVar) {
        int c11 = esVar.c();
        if (c11 > 32768) {
            b.a("Blob size=" + c11 + " should be less than " + 32768 + " Drop blob chid=" + esVar.a() + " id=" + esVar.e());
            return 0;
        }
        this.f2821a.clear();
        int i11 = c11 + 8 + 4;
        if (i11 > this.f2821a.capacity() || this.f2821a.capacity() > 4096) {
            this.f2821a = ByteBuffer.allocate(i11);
        }
        this.f2821a.putShort(-15618);
        this.f2821a.putShort(5);
        this.f2821a.putInt(c11);
        int position = this.f2821a.position();
        this.f2821a = esVar.a(this.f2821a);
        if (!"CONN".equals(esVar.a())) {
            if (this.f2823a == null) {
                this.f2823a = this.f2819a.a();
            }
            ar.a(this.f2823a, this.f2821a.array(), true, position, c11);
        }
        this.f2822a.reset();
        this.f2822a.update(this.f2821a.array(), 0, this.f2821a.position());
        this.f2824b.putInt(0, (int) this.f2822a.getValue());
        this.f2820a.write(this.f2821a.array(), 0, this.f2821a.position());
        this.f2820a.write(this.f2824b.array(), 0, 4);
        this.f2820a.flush();
        int position2 = this.f2821a.position() + 4;
        b.c("[Slim] Wrote {cmd=" + esVar.a() + ";chid=" + esVar.a() + ";len=" + position2 + "}");
        return position2;
    }

    public void b() {
        es esVar = new es();
        esVar.a("CLOSE", (String) null);
        a(esVar);
        this.f2820a.close();
    }

    public void a() {
        dq.e eVar = new dq.e();
        eVar.a(106);
        eVar.a(k.a());
        eVar.b(s.a());
        eVar.c(ax.a());
        eVar.b(48);
        eVar.d(this.f2819a.b());
        eVar.e(this.f2819a.a());
        eVar.f(Locale.getDefault().toString());
        int i11 = Build.VERSION.SDK_INT;
        eVar.c(i11);
        eVar.d(g.a(this.f2819a.a(), "com.xiaomi.xmsf"));
        byte[] a11 = this.f2819a.a().a();
        if (a11 != null) {
            eVar.a(dq.b.a(a11));
        }
        es esVar = new es();
        esVar.a(0);
        esVar.a("CONN", (String) null);
        esVar.a(0, "xiaomi.com", (String) null);
        esVar.a(eVar.a(), (String) null);
        a(esVar);
        b.a("[slim] open conn: andver=" + i11 + " sdk=" + 48 + " tz=" + this.f51753a + ":" + this.f51754b + " Model=" + k.a() + " os=" + j.e());
    }
}
