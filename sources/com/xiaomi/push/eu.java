package com.xiaomi.push;

import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.dq;
import com.xiaomi.push.service.am;
import com.xiaomi.push.service.ar;
import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.zip.Adler32;

class eu {

    /* renamed from: a  reason: collision with root package name */
    private ex f51751a;

    /* renamed from: a  reason: collision with other field name */
    private ez f2813a;

    /* renamed from: a  reason: collision with other field name */
    private InputStream f2814a;

    /* renamed from: a  reason: collision with other field name */
    private ByteBuffer f2815a = ByteBuffer.allocate(2048);

    /* renamed from: a  reason: collision with other field name */
    private Adler32 f2816a = new Adler32();

    /* renamed from: a  reason: collision with other field name */
    private volatile boolean f2817a;

    /* renamed from: a  reason: collision with other field name */
    private byte[] f2818a;

    /* renamed from: b  reason: collision with root package name */
    private ByteBuffer f51752b = ByteBuffer.allocate(4);

    public eu(InputStream inputStream, ez ezVar) {
        this.f2814a = new BufferedInputStream(inputStream);
        this.f2813a = ezVar;
        this.f51751a = new ex();
    }

    private void c() {
        boolean z11 = false;
        this.f2817a = false;
        es a11 = a();
        if ("CONN".equals(a11.a())) {
            dq.f a12 = dq.f.a(a11.a());
            if (a12.a()) {
                this.f2813a.a(a12.a());
                z11 = true;
            }
            if (a12.c()) {
                dq.b a13 = a12.a();
                es esVar = new es();
                esVar.a(GmsRpc.CMD_SYNC, "CONF");
                esVar.a(a13.a(), (String) null);
                this.f2813a.a(esVar);
            }
            b.a("[Slim] CONN: host = " + a12.b());
        }
        if (z11) {
            this.f2818a = this.f2813a.a();
            while (!this.f2817a) {
                es a14 = a();
                long currentTimeMillis = System.currentTimeMillis();
                this.f2813a.c();
                short a15 = a14.a();
                if (a15 == 1) {
                    this.f2813a.a(a14);
                } else if (a15 != 2) {
                    if (a15 != 3) {
                        b.a("[Slim] unknow blob type " + a14.a());
                    } else {
                        try {
                            this.f2813a.b(this.f51751a.a(a14.a(), this.f2813a));
                        } catch (Exception e11) {
                            b.a("[Slim] Parse packet from Blob chid=" + a14.a() + "; Id=" + a14.e() + " failure:" + e11.getMessage());
                        }
                    }
                } else if (!"SECMSG".equals(a14.a()) || (!(a14.a() == 2 || a14.a() == 3) || !TextUtils.isEmpty(a14.b()))) {
                    this.f2813a.a(a14);
                } else {
                    try {
                        fp a16 = this.f51751a.a(a14.a(am.a().a(Integer.valueOf(a14.a()).toString(), a14.g()).f52471h), this.f2813a);
                        a16.f2874a = currentTimeMillis;
                        this.f2813a.b(a16);
                    } catch (Exception e12) {
                        b.a("[Slim] Parse packet from Blob chid=" + a14.a() + "; Id=" + a14.e() + " failure:" + e12.getMessage());
                    }
                }
            }
            return;
        }
        b.a("[Slim] Invalid CONN");
        throw new IOException("Invalid Connection");
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m2663a() {
        try {
            c();
        } catch (IOException e11) {
            if (!this.f2817a) {
                throw e11;
            }
        }
    }

    public void b() {
        this.f2817a = true;
    }

    private ByteBuffer a() {
        this.f2815a.clear();
        a(this.f2815a, 8);
        short s11 = this.f2815a.getShort(0);
        short s12 = this.f2815a.getShort(2);
        if (s11 == -15618 && s12 == 5) {
            int i11 = this.f2815a.getInt(4);
            int position = this.f2815a.position();
            if (i11 <= 32768) {
                if (i11 + 4 > this.f2815a.remaining()) {
                    ByteBuffer allocate = ByteBuffer.allocate(i11 + 2048);
                    allocate.put(this.f2815a.array(), 0, this.f2815a.arrayOffset() + this.f2815a.position());
                    this.f2815a = allocate;
                } else if (this.f2815a.capacity() > 4096 && i11 < 2048) {
                    ByteBuffer allocate2 = ByteBuffer.allocate(2048);
                    allocate2.put(this.f2815a.array(), 0, this.f2815a.arrayOffset() + this.f2815a.position());
                    this.f2815a = allocate2;
                }
                a(this.f2815a, i11);
                this.f51752b.clear();
                a(this.f51752b, 4);
                this.f51752b.position(0);
                int i12 = this.f51752b.getInt();
                this.f2816a.reset();
                this.f2816a.update(this.f2815a.array(), 0, this.f2815a.position());
                if (i12 == ((int) this.f2816a.getValue())) {
                    byte[] bArr = this.f2818a;
                    if (bArr != null) {
                        ar.a(bArr, this.f2815a.array(), true, position, i11);
                    }
                    return this.f2815a;
                }
                b.a("CRC = " + ((int) this.f2816a.getValue()) + " and " + i12);
                throw new IOException("Corrupted Blob bad CRC");
            }
            throw new IOException("Blob size too large");
        }
        throw new IOException("Malformed Input");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0073  */
    /* renamed from: a  reason: collision with other method in class */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.xiaomi.push.es m2662a() {
        /*
            r6 = this;
            r0 = 0
            java.nio.ByteBuffer r1 = r6.a()     // Catch:{ IOException -> 0x0055 }
            int r2 = r1.position()     // Catch:{ IOException -> 0x0055 }
            r1.flip()     // Catch:{ IOException -> 0x0053 }
            r3 = 8
            r1.position(r3)     // Catch:{ IOException -> 0x0053 }
            if (r2 != r3) goto L_0x0019
            com.xiaomi.push.ey r1 = new com.xiaomi.push.ey     // Catch:{ IOException -> 0x0053 }
            r1.<init>()     // Catch:{ IOException -> 0x0053 }
            goto L_0x0021
        L_0x0019:
            java.nio.ByteBuffer r1 = r1.slice()     // Catch:{ IOException -> 0x0053 }
            com.xiaomi.push.es r1 = com.xiaomi.push.es.a((java.nio.ByteBuffer) r1)     // Catch:{ IOException -> 0x0053 }
        L_0x0021:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0053 }
            r3.<init>()     // Catch:{ IOException -> 0x0053 }
            java.lang.String r4 = "[Slim] Read {cmd="
            r3.append(r4)     // Catch:{ IOException -> 0x0053 }
            java.lang.String r4 = r1.a()     // Catch:{ IOException -> 0x0053 }
            r3.append(r4)     // Catch:{ IOException -> 0x0053 }
            java.lang.String r4 = ";chid="
            r3.append(r4)     // Catch:{ IOException -> 0x0053 }
            int r4 = r1.a()     // Catch:{ IOException -> 0x0053 }
            r3.append(r4)     // Catch:{ IOException -> 0x0053 }
            java.lang.String r4 = ";len="
            r3.append(r4)     // Catch:{ IOException -> 0x0053 }
            r3.append(r2)     // Catch:{ IOException -> 0x0053 }
            java.lang.String r4 = "}"
            r3.append(r4)     // Catch:{ IOException -> 0x0053 }
            java.lang.String r3 = r3.toString()     // Catch:{ IOException -> 0x0053 }
            com.xiaomi.channel.commonutils.logger.b.c(r3)     // Catch:{ IOException -> 0x0053 }
            return r1
        L_0x0053:
            r1 = move-exception
            goto L_0x0057
        L_0x0055:
            r1 = move-exception
            r2 = r0
        L_0x0057:
            if (r2 != 0) goto L_0x005f
            java.nio.ByteBuffer r2 = r6.f2815a
            int r2 = r2.position()
        L_0x005f:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "[Slim] read Blob ["
            r3.append(r4)
            java.nio.ByteBuffer r4 = r6.f2815a
            byte[] r4 = r4.array()
            r5 = 128(0x80, float:1.794E-43)
            if (r2 <= r5) goto L_0x0074
            r2 = r5
        L_0x0074:
            java.lang.String r0 = com.xiaomi.push.ac.a(r4, r0, r2)
            r3.append(r0)
            java.lang.String r0 = "] Err:"
            r3.append(r0)
            java.lang.String r0 = r1.getMessage()
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.String) r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.eu.m2662a():com.xiaomi.push.es");
    }

    private void a(ByteBuffer byteBuffer, int i11) {
        int position = byteBuffer.position();
        do {
            int read = this.f2814a.read(byteBuffer.array(), position, i11);
            if (read != -1) {
                i11 -= read;
                position += read;
            } else {
                throw new EOFException();
            }
        } while (i11 > 0);
        byteBuffer.position(position);
    }
}
