package com.xiaomi.push;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class ew {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f51755a = {80, 85, 83, 72};

    /* renamed from: a  reason: collision with other field name */
    private byte f2825a;

    /* renamed from: a  reason: collision with other field name */
    private int f2826a;

    /* renamed from: a  reason: collision with other field name */
    private short f2827a;

    /* renamed from: b  reason: collision with root package name */
    private byte[] f51756b;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final c f51757a = new c();

        /* renamed from: a  reason: collision with other field name */
        public static final d f2828a = new d();

        public static byte[] a(byte[] bArr) {
            return a(bArr, f2828a);
        }

        public static byte[] a(byte[] bArr, b bVar) {
            if (!ew.a(bArr)) {
                return bArr;
            }
            ew a11 = ew.a(bArr);
            if (ew.a(a11) == 0 || ew.a(a11) != bVar.a()) {
                return ew.a(a11);
            }
            return bVar.a(ew.a(a11), ew.a(a11));
        }
    }

    public interface b {
        byte a();

        byte[] a(byte[] bArr, int i11);
    }

    public static final class c {
    }

    public static final class d implements b {
        public byte a() {
            return 2;
        }

        /* JADX WARNING: Removed duplicated region for block: B:15:0x001c A[SYNTHETIC, Splitter:B:15:0x001c] */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x0022 A[SYNTHETIC, Splitter:B:21:0x0022] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public byte[] a(byte[] r4, int r5) {
            /*
                r3 = this;
                r0 = 0
                java.util.zip.GZIPInputStream r1 = new java.util.zip.GZIPInputStream     // Catch:{ IOException -> 0x0020, all -> 0x0019 }
                java.io.ByteArrayInputStream r2 = new java.io.ByteArrayInputStream     // Catch:{ IOException -> 0x0020, all -> 0x0019 }
                r2.<init>(r4)     // Catch:{ IOException -> 0x0020, all -> 0x0019 }
                r1.<init>(r2, r5)     // Catch:{ IOException -> 0x0020, all -> 0x0019 }
                byte[] r5 = new byte[r5]     // Catch:{ IOException -> 0x0017, all -> 0x0014 }
                r1.read(r5)     // Catch:{ IOException -> 0x0017, all -> 0x0014 }
                r1.close()     // Catch:{ IOException -> 0x0013 }
            L_0x0013:
                return r5
            L_0x0014:
                r4 = move-exception
                r0 = r1
                goto L_0x001a
            L_0x0017:
                r0 = r1
                goto L_0x0020
            L_0x0019:
                r4 = move-exception
            L_0x001a:
                if (r0 == 0) goto L_0x001f
                r0.close()     // Catch:{ IOException -> 0x001f }
            L_0x001f:
                throw r4
            L_0x0020:
                if (r0 == 0) goto L_0x0025
                r0.close()     // Catch:{ IOException -> 0x0025 }
            L_0x0025:
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.ew.d.a(byte[], int):byte[]");
        }
    }

    public ew(byte b11, int i11, byte[] bArr) {
        this(1, b11, i11, bArr);
    }

    public ew(short s11, byte b11, int i11, byte[] bArr) {
        this.f2827a = 1;
        this.f2827a = s11;
        this.f2825a = b11;
        this.f2826a = i11;
        this.f51756b = bArr;
    }

    public static ew a(byte b11, int i11, byte[] bArr) {
        return new ew(b11, i11, bArr);
    }

    public static ew a(short s11, byte b11, int i11, byte[] bArr) {
        return new ew(s11, b11, i11, bArr);
    }

    public static ew a(byte[] bArr) {
        if (!a(bArr)) {
            return a((byte) 0, bArr.length, bArr);
        }
        ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN);
        order.getInt();
        short s11 = order.getShort();
        byte b11 = order.get();
        int i11 = order.getInt();
        byte[] bArr2 = new byte[order.getInt()];
        order.get(bArr2);
        return a(s11, b11, i11, bArr2);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m2664a(byte[] bArr) {
        byte[] bArr2 = f51755a;
        return a(bArr2, bArr, bArr2.length);
    }

    public static boolean a(byte[] bArr, byte[] bArr2, int i11) {
        if (bArr.length < i11 || bArr2.length < i11) {
            return false;
        }
        for (int i12 = 0; i12 < i11; i12++) {
            if (bArr[i12] != bArr2[i12]) {
                return false;
            }
        }
        return true;
    }
}
