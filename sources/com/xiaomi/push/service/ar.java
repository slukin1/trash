package com.xiaomi.push.service;

import com.huawei.hms.framework.common.ContainerUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.az;

public class ar {

    /* renamed from: a  reason: collision with root package name */
    private static int f52514a = 8;

    /* renamed from: a  reason: collision with other field name */
    private byte[] f3355a = new byte[256];

    /* renamed from: b  reason: collision with root package name */
    private int f52515b = 0;

    /* renamed from: c  reason: collision with root package name */
    private int f52516c = 0;

    /* renamed from: d  reason: collision with root package name */
    private int f52517d = -666;

    public static int a(byte b11) {
        return b11 >= 0 ? b11 : b11 + 256;
    }

    private void a(int i11, byte[] bArr, boolean z11) {
        int length = bArr.length;
        for (int i12 = 0; i12 < 256; i12++) {
            this.f3355a[i12] = (byte) i12;
        }
        this.f52516c = 0;
        this.f52515b = 0;
        while (true) {
            int i13 = this.f52515b;
            if (i13 >= i11) {
                break;
            }
            int a11 = ((this.f52516c + a(this.f3355a[i13])) + a(bArr[this.f52515b % length])) % 256;
            this.f52516c = a11;
            a(this.f3355a, this.f52515b, a11);
            this.f52515b++;
        }
        if (i11 != 256) {
            this.f52517d = ((this.f52516c + a(this.f3355a[i11])) + a(bArr[i11 % length])) % 256;
        }
        if (z11) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("S_");
            int i14 = i11 - 1;
            sb2.append(i14);
            sb2.append(":");
            for (int i15 = 0; i15 <= i11; i15++) {
                sb2.append(" ");
                sb2.append(a(this.f3355a[i15]));
            }
            sb2.append("   j_");
            sb2.append(i14);
            sb2.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb2.append(this.f52516c);
            sb2.append("   j_");
            sb2.append(i11);
            sb2.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb2.append(this.f52517d);
            sb2.append("   S_");
            sb2.append(i14);
            sb2.append("[j_");
            sb2.append(i14);
            sb2.append("]=");
            sb2.append(a(this.f3355a[this.f52516c]));
            sb2.append("   S_");
            sb2.append(i14);
            sb2.append("[j_");
            sb2.append(i11);
            sb2.append("]=");
            sb2.append(a(this.f3355a[this.f52517d]));
            if (this.f3355a[1] != 0) {
                sb2.append("   S[1]!=0");
            }
            b.a(sb2.toString());
        }
    }

    private void a(byte[] bArr) {
        a(256, bArr, false);
    }

    private void a() {
        this.f52516c = 0;
        this.f52515b = 0;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte m3000a() {
        int i11 = (this.f52515b + 1) % 256;
        this.f52515b = i11;
        int a11 = (this.f52516c + a(this.f3355a[i11])) % 256;
        this.f52516c = a11;
        a(this.f3355a, this.f52515b, a11);
        byte[] bArr = this.f3355a;
        return bArr[(a(bArr[this.f52515b]) + a(this.f3355a[this.f52516c])) % 256];
    }

    private static void a(byte[] bArr, int i11, int i12) {
        byte b11 = bArr[i11];
        bArr[i11] = bArr[i12];
        bArr[i12] = b11;
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr2.length];
        ar arVar = new ar();
        arVar.a(bArr);
        arVar.a();
        for (int i11 = 0; i11 < bArr2.length; i11++) {
            bArr3[i11] = (byte) (bArr2[i11] ^ arVar.a());
        }
        return bArr3;
    }

    public static byte[] a(byte[] bArr, byte[] bArr2, boolean z11, int i11, int i12) {
        byte[] bArr3;
        int i13;
        if (i11 < 0 || i11 > bArr2.length || i11 + i12 > bArr2.length) {
            throw new IllegalArgumentException("start = " + i11 + " len = " + i12);
        }
        if (!z11) {
            bArr3 = new byte[i12];
            i13 = 0;
        } else {
            bArr3 = bArr2;
            i13 = i11;
        }
        ar arVar = new ar();
        arVar.a(bArr);
        arVar.a();
        for (int i14 = 0; i14 < i12; i14++) {
            bArr3[i13 + i14] = (byte) (bArr2[i11 + i14] ^ arVar.a());
        }
        return bArr3;
    }

    public static byte[] a(byte[] bArr, String str) {
        return a(bArr, az.a(str));
    }

    public static byte[] a(String str, String str2) {
        byte[] a11 = az.a(str);
        byte[] bytes = str2.getBytes();
        byte[] bArr = new byte[(a11.length + 1 + bytes.length)];
        for (int i11 = 0; i11 < a11.length; i11++) {
            bArr[i11] = a11[i11];
        }
        bArr[a11.length] = 95;
        for (int i12 = 0; i12 < bytes.length; i12++) {
            bArr[a11.length + 1 + i12] = bytes[i12];
        }
        return bArr;
    }
}
