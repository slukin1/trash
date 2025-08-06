package com.iproov.sdk.cameray;

import android.graphics.Bitmap;
import android.graphics.Color;
import com.iproov.sdk.core.Cbreak;
import com.iproov.sdk.core.Ccatch;
import com.iproov.sdk.p017implements.Cimport;
import com.iproov.sdk.p017implements.Creturn;
import com.iproov.sdk.p021new.Cfor;
import java.util.ArrayList;

/* renamed from: com.iproov.sdk.cameray.throw  reason: invalid class name */
public class Cthrow implements Cfor {

    /* renamed from: do  reason: not valid java name */
    private final int f136do;

    /* renamed from: for  reason: not valid java name */
    private final byte[] f137for;

    /* renamed from: if  reason: not valid java name */
    private final int f138if;

    /* renamed from: new  reason: not valid java name */
    private final long f139new = Creturn.f944do.m1034do();

    public Cthrow(int i11, int i12, byte[] bArr) {
        new ArrayList();
        this.f136do = i11;
        this.f138if = i12;
        this.f137for = bArr;
    }

    /* renamed from: do  reason: not valid java name */
    public byte[] m204do(int i11) {
        Cbreak.m310do(Ccatch.AND1);
        if (i11 == 19) {
            return m202if(this.f137for);
        }
        if (i11 == 21 || i11 == 2130706688) {
            return m201do(this.f137for);
        }
        throw new IllegalArgumentException("Unsupported codec format " + i11);
    }

    /* renamed from: for  reason: not valid java name */
    public Bitmap m205for(int i11) {
        int i12;
        int i13 = this.f136do;
        float f11 = ((float) i13) / 2.0f;
        int i14 = i13 * this.f138if;
        int[] iArr = new int[(i14 / (i11 * i11))];
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        while (true) {
            int i18 = this.f138if;
            if (i15 > i18 - i11) {
                return Bitmap.createBitmap(iArr, this.f136do / i11, i18 / i11, Bitmap.Config.ARGB_8888);
            }
            int i19 = 0;
            int i21 = i16;
            while (true) {
                i12 = this.f136do;
                if (i19 > i12 - i11) {
                    break;
                }
                int i22 = Cimport.m1013do((this.f137for[i21] & 255) - 16, 0, 255);
                byte[] bArr = this.f137for;
                int i23 = (((int) ((((float) ((int) (((float) i15) / 2.0f))) * f11) + (((float) i19) / 2.0f))) * 2) + i14;
                byte b11 = bArr[i23 + 1] & 255;
                byte b12 = bArr[i23] & 255;
                iArr[i17] = Color.rgb(Cimport.m1013do((((b12 * 1436) / 1024) + i22) - 179, 0, 255), Cimport.m1013do((((i22 - ((46549 * b11) / 131072)) + 44) - ((b12 * 93604) / 131072)) + 91, 0, 255), Cimport.m1013do((i22 + ((b11 * 1814) / 1024)) - 227, 0, 255));
                i21 += i11;
                i19 += i11;
                i17++;
            }
            i16 += i12 * i11;
            i15 += i11;
        }
    }

    /* renamed from: if  reason: not valid java name */
    public Bitmap m206if(int i11) {
        int i12;
        int[] iArr = new int[((this.f136do * this.f138if) / (i11 * i11))];
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        while (true) {
            int i16 = this.f138if;
            if (i13 > i16 - i11) {
                return Bitmap.createBitmap(iArr, this.f136do / i11, i16 / i11, Bitmap.Config.ARGB_8888);
            }
            int i17 = 0;
            int i18 = i14;
            while (true) {
                i12 = this.f136do;
                if (i17 > i12 - i11) {
                    break;
                }
                int i19 = Cimport.m1013do((this.f137for[i18] & 255) - 16, 0, 255);
                iArr[i15] = Color.rgb(i19, i19, i19);
                i18 += i11;
                i17 += i11;
                i15++;
            }
            i14 += i12 * i11;
            i13 += i11;
        }
    }

    /* renamed from: do  reason: not valid java name */
    public long m203do() {
        return this.f139new;
    }

    /* renamed from: do  reason: not valid java name */
    private static byte[] m201do(byte[] bArr) {
        int length = (int) (((double) bArr.length) / 1.5d);
        int i11 = length / 2;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        for (int i12 = length; i12 < length + i11; i12 += 2) {
            int i13 = i12 + 1;
            bArr2[i12] = bArr[i13];
            bArr2[i13] = bArr[i12];
        }
        return bArr2;
    }

    /* renamed from: if  reason: not valid java name */
    private static byte[] m202if(byte[] bArr) {
        int length = (int) (((double) bArr.length) / 1.5d);
        int i11 = length / 4;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        for (int i12 = 0; i12 < i11; i12++) {
            int i13 = (i12 * 2) + length;
            int i14 = length + i12;
            bArr2[i14 + i11] = bArr[i13];
            bArr2[i14] = bArr[i13 + 1];
        }
        return bArr2;
    }
}
