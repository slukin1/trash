package com.sumsub.sns.internal.core.common;

import android.graphics.Bitmap;
import com.huobi.view.roundimg.RoundedDrawable;

public final class p {

    /* renamed from: a  reason: collision with root package name */
    public static final p f32247a = new p();

    public final Bitmap a(Bitmap bitmap, int i11, boolean z11) {
        Bitmap bitmap2;
        int[] iArr;
        int i12 = i11;
        if (z11) {
            bitmap2 = bitmap;
        } else {
            bitmap2 = bitmap.copy(bitmap.getConfig(), true);
        }
        if (i12 < 1) {
            return null;
        }
        int width = bitmap2.getWidth();
        int height = bitmap2.getHeight();
        int i13 = width * height;
        int[] iArr2 = new int[i13];
        bitmap2.getPixels(iArr2, 0, width, 0, 0, width, height);
        int i14 = width - 1;
        int i15 = height - 1;
        int i16 = i12 + i12 + 1;
        int[] iArr3 = new int[i13];
        int[] iArr4 = new int[i13];
        int[] iArr5 = new int[i13];
        int[] iArr6 = new int[RangesKt___RangesKt.d(width, height)];
        int i17 = (i16 + 1) >> 1;
        int i18 = i17 * i17;
        int i19 = i18 * 256;
        int[] iArr7 = new int[i19];
        for (int i21 = 0; i21 < i19; i21++) {
            iArr7[i21] = i21 / i18;
        }
        int[][] iArr8 = new int[i16][];
        for (int i22 = 0; i22 < i16; i22++) {
            iArr8[i22] = new int[3];
        }
        int i23 = i12 + 1;
        int i24 = 0;
        int i25 = 0;
        int i26 = 0;
        while (i24 < height) {
            Bitmap bitmap3 = bitmap2;
            int i27 = height;
            int i28 = 0;
            int i29 = 0;
            int i30 = 0;
            int i31 = 0;
            int i32 = 0;
            int i33 = 0;
            int i34 = 0;
            int i35 = 0;
            int i36 = -i12;
            int i37 = 0;
            while (i36 <= i12) {
                int i38 = i15;
                int[] iArr9 = iArr6;
                int i39 = iArr2[i25 + RangesKt___RangesKt.g(i14, RangesKt___RangesKt.d(i36, 0))];
                int[] iArr10 = iArr8[i36 + i12];
                iArr10[0] = (i39 & 16711680) >> 16;
                iArr10[1] = (i39 & 65280) >> 8;
                iArr10[2] = i39 & 255;
                int abs = i23 - Math.abs(i36);
                int i40 = iArr10[0];
                i29 += i40 * abs;
                int i41 = iArr10[1];
                i28 += i41 * abs;
                int i42 = iArr10[2];
                i37 += abs * i42;
                if (i36 > 0) {
                    i33 += i40;
                    i34 += i41;
                    i35 += i42;
                } else {
                    i32 += i40;
                    i31 += i41;
                    i30 += i42;
                }
                i36++;
                i15 = i38;
                iArr6 = iArr9;
            }
            int i43 = i15;
            int[] iArr11 = iArr6;
            int i44 = i12;
            int i45 = i37;
            int i46 = 0;
            while (i46 < width) {
                iArr3[i25] = iArr7[i29];
                iArr4[i25] = iArr7[i28];
                iArr5[i25] = iArr7[i45];
                int i47 = i29 - i32;
                int i48 = i28 - i31;
                int i49 = i45 - i30;
                int[] iArr12 = iArr8[((i44 - i12) + i16) % i16];
                int i50 = i32 - iArr12[0];
                int i51 = i31 - iArr12[1];
                int i52 = i30 - iArr12[2];
                if (i24 == 0) {
                    iArr = iArr7;
                    iArr11[i46] = RangesKt___RangesKt.g(i46 + i12 + 1, i14);
                } else {
                    iArr = iArr7;
                }
                int i53 = iArr2[i26 + iArr11[i46]];
                int i54 = (i53 & 16711680) >> 16;
                iArr12[0] = i54;
                int i55 = (i53 & 65280) >> 8;
                iArr12[1] = i55;
                int i56 = i53 & 255;
                iArr12[2] = i56;
                int i57 = i33 + i54;
                int i58 = i34 + i55;
                int i59 = i35 + i56;
                i29 = i47 + i57;
                i28 = i48 + i58;
                i45 = i49 + i59;
                i44 = (i44 + 1) % i16;
                int[] iArr13 = iArr8[i44 % i16];
                int i60 = iArr13[0];
                i32 = i50 + i60;
                int i61 = iArr13[1];
                i31 = i51 + i61;
                int i62 = iArr13[2];
                i30 = i52 + i62;
                i33 = i57 - i60;
                i34 = i58 - i61;
                i35 = i59 - i62;
                i25++;
                i46++;
                iArr7 = iArr;
            }
            int[] iArr14 = iArr7;
            i26 += width;
            i24++;
            bitmap2 = bitmap3;
            height = i27;
            i15 = i43;
            iArr6 = iArr11;
        }
        Bitmap bitmap4 = bitmap2;
        int i63 = i15;
        int[] iArr15 = iArr6;
        int i64 = height;
        int[] iArr16 = iArr7;
        int i65 = 0;
        while (i65 < width) {
            int i66 = -i12;
            int i67 = i16;
            int[] iArr17 = iArr2;
            int i68 = 0;
            int i69 = 0;
            int i70 = 0;
            int i71 = 0;
            int i72 = 0;
            int i73 = 0;
            int i74 = 0;
            int i75 = i66;
            int i76 = i66 * width;
            int i77 = 0;
            int i78 = 0;
            while (i75 <= i12) {
                int i79 = width;
                int d11 = RangesKt___RangesKt.d(0, i76) + i65;
                int[] iArr18 = iArr8[i75 + i12];
                iArr18[0] = iArr3[d11];
                iArr18[1] = iArr4[d11];
                iArr18[2] = iArr5[d11];
                int abs2 = i23 - Math.abs(i75);
                i68 += iArr3[d11] * abs2;
                i78 += iArr4[d11] * abs2;
                i77 += iArr5[d11] * abs2;
                if (i75 > 0) {
                    i72 += iArr18[0];
                    i73 += iArr18[1];
                    i74 += iArr18[2];
                } else {
                    i71 += iArr18[0];
                    i70 += iArr18[1];
                    i69 += iArr18[2];
                }
                int i80 = i63;
                if (i75 < i80) {
                    i76 += i79;
                }
                i75++;
                i63 = i80;
                width = i79;
            }
            int i81 = width;
            int i82 = i63;
            int i83 = i12;
            int i84 = i65;
            int i85 = i64;
            int i86 = 0;
            while (i86 < i85) {
                iArr17[i84] = (iArr17[i84] & RoundedDrawable.DEFAULT_BORDER_COLOR) | (iArr16[i68] << 16) | (iArr16[i78] << 8) | iArr16[i77];
                int i87 = i68 - i71;
                int i88 = i78 - i70;
                int i89 = i77 - i69;
                int[] iArr19 = iArr8[((i83 - i12) + i67) % i67];
                int i90 = i71 - iArr19[0];
                int i91 = i70 - iArr19[1];
                int i92 = i69 - iArr19[2];
                if (i65 == 0) {
                    iArr15[i86] = RangesKt___RangesKt.g(i86 + i23, i82) * i81;
                }
                int i93 = iArr15[i86] + i65;
                int i94 = iArr3[i93];
                iArr19[0] = i94;
                int i95 = iArr4[i93];
                iArr19[1] = i95;
                int i96 = iArr5[i93];
                iArr19[2] = i96;
                int i97 = i72 + i94;
                int i98 = i73 + i95;
                int i99 = i74 + i96;
                i68 = i87 + i97;
                i78 = i88 + i98;
                i77 = i89 + i99;
                i83 = (i83 + 1) % i67;
                int[] iArr20 = iArr8[i83];
                int i100 = iArr20[0];
                i71 = i90 + i100;
                int i101 = iArr20[1];
                i70 = i91 + i101;
                int i102 = iArr20[2];
                i69 = i92 + i102;
                i72 = i97 - i100;
                i73 = i98 - i101;
                i74 = i99 - i102;
                i84 += i81;
                i86++;
                i12 = i11;
            }
            i65++;
            i12 = i11;
            i63 = i82;
            i64 = i85;
            i16 = i67;
            iArr2 = iArr17;
            width = i81;
        }
        int i103 = width;
        bitmap4.setPixels(iArr2, 0, i103, 0, 0, i103, i64);
        return bitmap4;
    }
}
