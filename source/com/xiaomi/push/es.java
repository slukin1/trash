package com.xiaomi.push;

import android.text.TextUtils;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.TIMMentionEditText;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.dq;
import com.xiaomi.push.service.aj;
import com.xiaomi.push.service.ar;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

public class es {

    /* renamed from: a  reason: collision with root package name */
    private static long f51748a = 0;

    /* renamed from: a  reason: collision with other field name */
    private static final byte[] f2806a = new byte[0];

    /* renamed from: b  reason: collision with root package name */
    private static String f51749b = (fy.a(5) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);

    /* renamed from: a  reason: collision with other field name */
    public int f2807a;

    /* renamed from: a  reason: collision with other field name */
    private dq.a f2808a;

    /* renamed from: a  reason: collision with other field name */
    public String f2809a;

    /* renamed from: a  reason: collision with other field name */
    private short f2810a;

    /* renamed from: b  reason: collision with other field name */
    private final long f2811b;

    /* renamed from: b  reason: collision with other field name */
    private byte[] f2812b;

    public es() {
        this.f2810a = 2;
        this.f2812b = f2806a;
        this.f2809a = null;
        this.f2811b = System.currentTimeMillis();
        this.f2808a = new dq.a();
        this.f2807a = 1;
    }

    public static synchronized String d() {
        String sb2;
        synchronized (es.class) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(f51749b);
            long j11 = f51748a;
            f51748a = 1 + j11;
            sb3.append(Long.toString(j11));
            sb2 = sb3.toString();
        }
        return sb2;
    }

    /* renamed from: a  reason: collision with other method in class */
    public long m2650a() {
        return this.f2811b;
    }

    /* renamed from: b  reason: collision with other method in class */
    public String m2658b() {
        return this.f2808a.d();
    }

    /* renamed from: c  reason: collision with other method in class */
    public String m2661c() {
        return this.f2808a.f();
    }

    public String e() {
        String e11 = this.f2808a.e();
        if ("ID_NOT_AVAILABLE".equals(e11)) {
            return null;
        }
        if (this.f2808a.g()) {
            return e11;
        }
        String d11 = d();
        this.f2808a.e(d11);
        return d11;
    }

    public String f() {
        return this.f2809a;
    }

    public String g() {
        if (!this.f2808a.b()) {
            return null;
        }
        return Long.toString(this.f2808a.a()) + TIMMentionEditText.TIM_MENTION_TAG + this.f2808a.a() + "/" + this.f2808a.b();
    }

    public String toString() {
        return "Blob [chid=" + a() + "; Id=" + aj.a(e()) + "; cmd=" + a() + "; type=" + a() + "; from=" + g() + " ]";
    }

    public void a(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            this.f2808a.c(str);
            this.f2808a.a();
            if (!TextUtils.isEmpty(str2)) {
                this.f2808a.d(str2);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("command should not be empty");
    }

    public int b() {
        return this.f2808a.f();
    }

    public void c(long j11) {
        this.f2808a.c(j11);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m2659b() {
        return this.f2808a.l();
    }

    /* renamed from: c  reason: collision with other method in class */
    public long m2660c() {
        return this.f2808a.a();
    }

    public void b(long j11) {
        this.f2808a.b(j11);
    }

    public void c(String str) {
        if (!TextUtils.isEmpty(str)) {
            int indexOf = str.indexOf(TIMMentionEditText.TIM_MENTION_TAG);
            try {
                long parseLong = Long.parseLong(str.substring(0, indexOf));
                int indexOf2 = str.indexOf("/", indexOf);
                String substring = str.substring(indexOf + 1, indexOf2);
                String substring2 = str.substring(indexOf2 + 1);
                this.f2808a.a(parseLong);
                this.f2808a.a(substring);
                this.f2808a.b(substring2);
            } catch (Exception e11) {
                b.a("Blob parse user err " + e11.getMessage());
            }
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public long m2657b() {
        return this.f2808a.b();
    }

    public void b(String str) {
        this.f2809a = str;
    }

    public es(dq.a aVar, short s11, byte[] bArr) {
        this.f2810a = 2;
        this.f2812b = f2806a;
        this.f2809a = null;
        this.f2811b = System.currentTimeMillis();
        this.f2808a = aVar;
        this.f2810a = s11;
        this.f2812b = bArr;
        this.f2807a = 2;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m2651a() {
        return this.f2808a.c();
    }

    public void a(int i11) {
        this.f2808a.a(i11);
    }

    public int a() {
        return this.f2808a.c();
    }

    public void a(String str) {
        this.f2808a.e(str);
    }

    public void a(long j11) {
        this.f2808a.a(j11);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m2654a() {
        return this.f2808a.j();
    }

    public void a(long j11, String str, String str2) {
        if (j11 != 0) {
            this.f2808a.a(j11);
        }
        if (!TextUtils.isEmpty(str)) {
            this.f2808a.a(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            this.f2808a.b(str2);
        }
    }

    public int c() {
        return this.f2808a.b() + 8 + this.f2812b.length;
    }

    public void a(byte[] bArr, String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f2808a.c(1);
            this.f2812b = ar.a(ar.a(str, e()), bArr);
            return;
        }
        this.f2808a.c(0);
        this.f2812b = bArr;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m2655a() {
        return et.a(this, this.f2812b);
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m2656a(String str) {
        if (this.f2808a.e() == 1) {
            return et.a(this, ar.a(ar.a(str, e()), this.f2812b));
        }
        if (this.f2808a.e() == 0) {
            return et.a(this, this.f2812b);
        }
        b.a("unknow cipher = " + this.f2808a.e());
        return et.a(this, this.f2812b);
    }

    @Deprecated
    public static es a(fp fpVar, String str) {
        int i11;
        es esVar = new es();
        try {
            i11 = Integer.parseInt(fpVar.k());
        } catch (Exception e11) {
            b.a("Blob parse chid err " + e11.getMessage());
            i11 = 1;
        }
        esVar.a(i11);
        esVar.a(fpVar.j());
        esVar.c(fpVar.m());
        esVar.b(fpVar.n());
        esVar.a("XMLMSG", (String) null);
        try {
            esVar.a(fpVar.a().getBytes("utf8"), str);
            if (TextUtils.isEmpty(str)) {
                esVar.a(3);
            } else {
                esVar.a(2);
                esVar.a("SECMSG", (String) null);
            }
        } catch (UnsupportedEncodingException e12) {
            b.a("Blob setPayload err： " + e12.getMessage());
        }
        return esVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public ByteBuffer m2652a(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            byteBuffer = ByteBuffer.allocate(c());
        }
        byteBuffer.putShort(this.f2810a);
        byteBuffer.putShort((short) this.f2808a.a());
        byteBuffer.putInt(this.f2812b.length);
        int position = byteBuffer.position();
        this.f2808a.a(byteBuffer.array(), byteBuffer.arrayOffset() + position, this.f2808a.a());
        byteBuffer.position(position + this.f2808a.a());
        byteBuffer.put(this.f2812b);
        return byteBuffer;
    }

    public static es a(ByteBuffer byteBuffer) {
        try {
            ByteBuffer slice = byteBuffer.slice();
            short s11 = slice.getShort(0);
            short s12 = slice.getShort(2);
            int i11 = slice.getInt(4);
            dq.a aVar = new dq.a();
            aVar.a(slice.array(), slice.arrayOffset() + 8, (int) s12);
            byte[] bArr = new byte[i11];
            slice.position(s12 + 8);
            slice.get(bArr, 0, i11);
            return new es(aVar, s11, bArr);
        } catch (Exception e11) {
            b.a("read Blob err :" + e11.getMessage());
            throw new IOException("Malformed Input");
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public short m2653a() {
        return this.f2810a;
    }

    public void a(short s11) {
        this.f2810a = s11;
    }
}
