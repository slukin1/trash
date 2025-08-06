package com.tencent.liteav.videoconsumer.a;

import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videoconsumer.decoder.c;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private boolean f22376a = false;

    /* renamed from: com.tencent.liteav.videoconsumer.a.a$a  reason: collision with other inner class name */
    public interface C0175a {
        boolean a(int i11, int i12, int i13, int i14);
    }

    public static byte[] a(byte[] bArr) {
        byte[] bArr2 = new byte[((bArr.length * 3) / 2)];
        int i11 = 0;
        int i12 = 0;
        while (i11 < bArr.length) {
            if (i11 < bArr.length - 2 && bArr[i11] == 0) {
                int i13 = i11 + 1;
                if (bArr[i13] == 0) {
                    int i14 = i11 + 2;
                    if (bArr[i14] <= 3) {
                        int i15 = i12 + 1;
                        bArr2[i12] = bArr[i11];
                        int i16 = i15 + 1;
                        bArr2[i15] = bArr[i13];
                        i12 = i16 + 1;
                        bArr2[i16] = 3;
                        i11 = i14;
                    }
                }
            }
            bArr2[i12] = bArr[i11];
            i11++;
            i12++;
        }
        if (i12 == bArr.length) {
            return bArr;
        }
        byte[] bArr3 = new byte[i12];
        System.arraycopy(bArr2, 0, bArr3, 0, i12);
        return bArr3;
    }

    public final byte[] a(InputStream inputStream, C0175a aVar) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        c cVar = new c(inputStream, byteArrayOutputStream);
        cVar.b(8);
        int a11 = (int) cVar.a();
        cVar.b(8);
        cVar.a();
        cVar.d();
        boolean z11 = false;
        if (a11 == 100 || a11 == 110 || a11 == 122 || a11 == 144) {
            if (cVar.c() == 3) {
                cVar.b(1);
            }
            cVar.d();
            cVar.d();
            cVar.b(1);
            if (cVar.a(true)) {
                for (int i11 = 0; i11 < 8; i11++) {
                    if (cVar.a(true)) {
                        if (i11 < 6) {
                            cVar.c(16);
                        } else {
                            cVar.c(64);
                        }
                    }
                }
            }
        }
        cVar.d();
        int c11 = cVar.c();
        if (c11 == 0) {
            cVar.d();
        } else if (c11 == 1) {
            cVar.b(1);
            cVar.d();
            cVar.d();
            int c12 = cVar.c();
            for (int i12 = 0; i12 < c12; i12++) {
                cVar.d();
            }
        }
        cVar.c();
        cVar.b(1);
        cVar.d();
        cVar.d();
        if (!cVar.a(true)) {
            cVar.b(1);
        }
        cVar.b(1);
        if (cVar.a(true) && !aVar.a(cVar.c(), cVar.c(), cVar.c(), cVar.c())) {
            return null;
        }
        if (cVar.a(false)) {
            cVar.b(true);
            if (cVar.a(true) && ((int) cVar.a()) == 255) {
                cVar.b(16);
                cVar.b(16);
            }
            if (cVar.a(true)) {
                cVar.b(1);
            }
            if (cVar.a(true)) {
                cVar.b(3);
                cVar.b(1);
                if (cVar.a(true)) {
                    cVar.b(8);
                    cVar.b(8);
                    cVar.b(8);
                }
            }
            if (cVar.a(true)) {
                cVar.d();
                cVar.d();
            }
            if (cVar.a(true)) {
                cVar.b(32);
                cVar.b(32);
                cVar.b(1);
            }
            boolean a12 = cVar.a(true);
            if (a12) {
                a(cVar);
            }
            boolean a13 = cVar.a(true);
            if (a13) {
                a(cVar);
            }
            if (a12 || a13) {
                cVar.b(1);
            }
            cVar.b(1);
            if (cVar.a(false)) {
                cVar.b(true);
                cVar.a(true);
                cVar.d();
                cVar.d();
                cVar.d();
                cVar.d();
                cVar.d();
                if (!this.f22376a) {
                    LiteavLog.w("H264SPSModifier", "decode: do not add max_dec_frame_buffering when it is ".concat(String.valueOf(cVar.b())));
                    this.f22376a = true;
                }
            } else {
                cVar.b(true);
                cVar.b(true);
                cVar.d(0);
                cVar.d(0);
                cVar.d(10);
                cVar.d(10);
                cVar.d(0);
                cVar.d(1);
                if (!this.f22376a) {
                    LiteavLog.w("H264SPSModifier", "decode: add max_dec_frame_buffering 1 when it is no exist");
                    this.f22376a = true;
                }
                z11 = true;
            }
            if (!z11) {
                return null;
            }
        } else {
            cVar.b(true);
            cVar.b(false);
            cVar.b(false);
            cVar.b(false);
            cVar.b(false);
            cVar.b(false);
            cVar.b(false);
            cVar.b(false);
            cVar.b(false);
            cVar.b(true);
            cVar.b(true);
            cVar.d(0);
            cVar.d(0);
            cVar.d(10);
            cVar.d(10);
            cVar.d(0);
            cVar.d(1);
            if (!this.f22376a) {
                LiteavLog.w("H264SPSModifier", "decode: add max_dec_frame_buffering 1 when vui is no exist");
                this.f22376a = true;
            }
        }
        cVar.e();
        return byteArrayOutputStream.toByteArray();
    }

    private static void a(c cVar) throws IOException {
        int c11 = cVar.c();
        cVar.a(4);
        cVar.a(4);
        for (int i11 = 0; i11 <= c11; i11++) {
            cVar.d();
            cVar.d();
            cVar.a(1);
        }
        cVar.a(5);
        cVar.a(5);
        cVar.a(5);
        cVar.a(5);
    }
}
