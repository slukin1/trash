package com.iproov.sdk.cameray;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.media.Image;
import com.iproov.sdk.cameray.Cimport;
import com.iproov.sdk.core.Cbreak;
import com.iproov.sdk.core.Ccatch;
import com.iproov.sdk.p017implements.Cimport;
import com.iproov.sdk.p017implements.Creturn;
import com.iproov.sdk.p021new.Cfor;
import java.util.ArrayList;

/* renamed from: com.iproov.sdk.cameray.while  reason: invalid class name */
public class Cwhile implements Cfor {

    /* renamed from: case  reason: not valid java name */
    private final long f145case;

    /* renamed from: do  reason: not valid java name */
    private final int f146do;

    /* renamed from: for  reason: not valid java name */
    private final byte[] f147for;

    /* renamed from: if  reason: not valid java name */
    private final int f148if;

    /* renamed from: new  reason: not valid java name */
    private final byte[] f149new;

    /* renamed from: try  reason: not valid java name */
    private final byte[] f150try;

    public Cwhile(Image image) {
        this((Cimport) new Cnative(image));
    }

    /* renamed from: do  reason: not valid java name */
    public byte[] m224do(int i11) {
        Cbreak.m310do(Ccatch.AND1);
        if (i11 == 19) {
            return m222if();
        }
        if (i11 == 21 || i11 == 2130706688) {
            return m221for();
        }
        throw new IllegalArgumentException("Unsupported codec format " + i11);
    }

    /* renamed from: for  reason: not valid java name */
    public Bitmap m225for(int i11) {
        int i12;
        float f11 = ((float) this.f146do) / 2.0f;
        int[] iArr = new int[(this.f147for.length / (i11 * i11))];
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        while (true) {
            int i16 = this.f148if;
            if (i13 > i16 - i11) {
                return Bitmap.createBitmap(iArr, this.f146do / i11, i16 / i11, Bitmap.Config.ARGB_8888);
            }
            int i17 = 0;
            int i18 = i14;
            while (true) {
                i12 = this.f146do;
                if (i17 > i12 - i11) {
                    break;
                }
                int i19 = (int) ((((float) ((int) (((float) i13) / 2.0f))) * f11) + (((float) i17) / 2.0f));
                int i21 = Cimport.m1013do((this.f147for[i18] & 255) - 16, 0, 255);
                byte b11 = this.f149new[i19] & 255;
                byte b12 = this.f150try[i19] & 255;
                iArr[i15] = Color.rgb(Cimport.m1013do((((b12 * 1436) / 1024) + i21) - 179, 0, 255), Cimport.m1013do((((i21 - ((46549 * b11) / 131072)) + 44) - ((b12 * 93604) / 131072)) + 91, 0, 255), Cimport.m1013do((i21 + ((b11 * 1814) / 1024)) - 227, 0, 255));
                i18 += i11;
                i17 += i11;
                i15++;
            }
            i14 += i12 * i11;
            i13 += i11;
        }
    }

    /* renamed from: if  reason: not valid java name */
    public Bitmap m226if(int i11) {
        int i12;
        int[] iArr = new int[(this.f147for.length / (i11 * i11))];
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        while (true) {
            int i16 = this.f148if;
            if (i13 > i16 - i11) {
                return Bitmap.createBitmap(iArr, this.f146do / i11, i16 / i11, Bitmap.Config.ARGB_8888);
            }
            int i17 = 0;
            int i18 = i14;
            while (true) {
                i12 = this.f146do;
                if (i17 > i12 - i11) {
                    break;
                }
                int i19 = Cimport.m1013do((this.f147for[i18] & 255) - 16, 0, 255);
                iArr[i15] = Color.rgb(i19, i19, i19);
                i18 += i11;
                i17 += i11;
                i15++;
            }
            i14 += i12 * i11;
            i13 += i11;
        }
    }

    public Cwhile(Cimport importR) {
        new ArrayList();
        int i11 = importR.m179do();
        this.f146do = i11;
        int i12 = importR.m182if();
        this.f148if = i12;
        int i13 = i12 * i11;
        this.f147for = new byte[i13];
        int i14 = 0;
        for (int i15 = 0; i15 < this.f148if; i15++) {
            Cimport.Cdo doVar = Cimport.Cdo.Y;
            importR.m181do(doVar, i15 * importR.m183if(doVar), this.f147for, i14, this.f146do);
            i14 += this.f146do;
        }
        Cimport.Cdo doVar2 = Cimport.Cdo.U;
        int i16 = importR.m180do(doVar2);
        int i17 = importR.m183if(doVar2);
        int i18 = i13 / 4;
        this.f149new = new byte[i18];
        this.f150try = new byte[i18];
        int i19 = this.f146do / 2;
        int i21 = this.f148if / 2;
        int i22 = 0;
        int i23 = 0;
        for (int i24 = 0; i24 < i21; i24++) {
            for (int i25 = 0; i25 < i19; i25++) {
                this.f149new[i22] = importR.m178do(Cimport.Cdo.U, i23);
                this.f150try[i22] = importR.m178do(Cimport.Cdo.V, i23);
                i22++;
                i23 += i16;
            }
            i23 += i17 - (i19 * i16);
        }
        this.f145case = Creturn.f944do.m1034do();
    }

    /* renamed from: do  reason: not valid java name */
    public long m223do() {
        return this.f145case;
    }

    /* renamed from: if  reason: not valid java name */
    private byte[] m222if() {
        int i11 = this.f146do * this.f148if;
        byte[] bArr = new byte[((int) (((float) i11) * 1.5f))];
        byte[] bArr2 = this.f147for;
        System.arraycopy(bArr2, 0, bArr, 0, bArr2.length);
        byte[] bArr3 = this.f149new;
        System.arraycopy(bArr3, 0, bArr, i11, bArr3.length);
        byte[] bArr4 = this.f150try;
        System.arraycopy(bArr4, 0, bArr, i11 + this.f149new.length, bArr4.length);
        return bArr;
    }

    /* renamed from: for  reason: not valid java name */
    private byte[] m221for() {
        int i11 = this.f146do * this.f148if;
        byte[] bArr = new byte[((int) (((float) i11) * 1.5f))];
        byte[] bArr2 = this.f147for;
        int i12 = 0;
        System.arraycopy(bArr2, 0, bArr, 0, bArr2.length);
        while (true) {
            byte[] bArr3 = this.f149new;
            if (i12 >= bArr3.length) {
                return bArr;
            }
            int i13 = i11 + 1;
            bArr[i11] = bArr3[i12];
            i11 = i13 + 1;
            bArr[i13] = this.f150try[i12];
            i12++;
        }
    }
}
