package org.apache.commons.io.output;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class ByteArrayOutputStream extends OutputStream {

    /* renamed from: h  reason: collision with root package name */
    public static final byte[] f58955h = new byte[0];

    /* renamed from: b  reason: collision with root package name */
    public final List<byte[]> f58956b;

    /* renamed from: c  reason: collision with root package name */
    public int f58957c;

    /* renamed from: d  reason: collision with root package name */
    public int f58958d;

    /* renamed from: e  reason: collision with root package name */
    public byte[] f58959e;

    /* renamed from: f  reason: collision with root package name */
    public int f58960f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f58961g;

    public ByteArrayOutputStream() {
        this(1024);
    }

    public final void a(int i11) {
        if (this.f58957c < this.f58956b.size() - 1) {
            this.f58958d += this.f58959e.length;
            int i12 = this.f58957c + 1;
            this.f58957c = i12;
            this.f58959e = this.f58956b.get(i12);
            return;
        }
        byte[] bArr = this.f58959e;
        if (bArr == null) {
            this.f58958d = 0;
        } else {
            i11 = Math.max(bArr.length << 1, i11 - this.f58958d);
            this.f58958d += this.f58959e.length;
        }
        this.f58957c++;
        byte[] bArr2 = new byte[i11];
        this.f58959e = bArr2;
        this.f58956b.add(bArr2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002c, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized byte[] b() {
        /*
            r7 = this;
            monitor-enter(r7)
            int r0 = r7.f58960f     // Catch:{ all -> 0x002d }
            if (r0 != 0) goto L_0x0009
            byte[] r0 = f58955h     // Catch:{ all -> 0x002d }
            monitor-exit(r7)
            return r0
        L_0x0009:
            byte[] r1 = new byte[r0]     // Catch:{ all -> 0x002d }
            java.util.List<byte[]> r2 = r7.f58956b     // Catch:{ all -> 0x002d }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x002d }
            r3 = 0
            r4 = r3
        L_0x0013:
            boolean r5 = r2.hasNext()     // Catch:{ all -> 0x002d }
            if (r5 == 0) goto L_0x002b
            java.lang.Object r5 = r2.next()     // Catch:{ all -> 0x002d }
            byte[] r5 = (byte[]) r5     // Catch:{ all -> 0x002d }
            int r6 = r5.length     // Catch:{ all -> 0x002d }
            int r6 = java.lang.Math.min(r6, r0)     // Catch:{ all -> 0x002d }
            java.lang.System.arraycopy(r5, r3, r1, r4, r6)     // Catch:{ all -> 0x002d }
            int r4 = r4 + r6
            int r0 = r0 - r6
            if (r0 != 0) goto L_0x0013
        L_0x002b:
            monitor-exit(r7)
            return r1
        L_0x002d:
            r0 = move-exception
            monitor-exit(r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.io.output.ByteArrayOutputStream.b():byte[]");
    }

    public void close() throws IOException {
    }

    @Deprecated
    public String toString() {
        return new String(b(), Charset.defaultCharset());
    }

    public void write(byte[] bArr, int i11, int i12) {
        int i13;
        if (i11 < 0 || i11 > bArr.length || i12 < 0 || (i13 = i11 + i12) > bArr.length || i13 < 0) {
            throw new IndexOutOfBoundsException();
        } else if (i12 != 0) {
            synchronized (this) {
                int i14 = this.f58960f;
                int i15 = i14 + i12;
                int i16 = i14 - this.f58958d;
                while (i12 > 0) {
                    int min = Math.min(i12, this.f58959e.length - i16);
                    System.arraycopy(bArr, i13 - i12, this.f58959e, i16, min);
                    i12 -= min;
                    if (i12 > 0) {
                        a(i15);
                        i16 = 0;
                    }
                }
                this.f58960f = i15;
            }
        }
    }

    public ByteArrayOutputStream(int i11) {
        this.f58956b = new ArrayList();
        this.f58961g = true;
        if (i11 >= 0) {
            synchronized (this) {
                a(i11);
            }
            return;
        }
        throw new IllegalArgumentException("Negative initial size: " + i11);
    }

    public synchronized void write(int i11) {
        int i12 = this.f58960f;
        int i13 = i12 - this.f58958d;
        if (i13 == this.f58959e.length) {
            a(i12 + 1);
            i13 = 0;
        }
        this.f58959e[i13] = (byte) i11;
        this.f58960f++;
    }
}
