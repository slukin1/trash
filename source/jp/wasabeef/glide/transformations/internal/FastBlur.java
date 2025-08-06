package jp.wasabeef.glide.transformations.internal;

import android.graphics.Bitmap;
import com.huobi.view.roundimg.RoundedDrawable;
import java.lang.reflect.Array;

public class FastBlur {
    public static Bitmap a(Bitmap bitmap, int i11, boolean z11) {
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
        int[] iArr6 = new int[Math.max(width, height)];
        int i17 = (i16 + 1) >> 1;
        int i18 = i17 * i17;
        int i19 = i18 * 256;
        int[] iArr7 = new int[i19];
        for (int i21 = 0; i21 < i19; i21++) {
            iArr7[i21] = i21 / i18;
        }
        int[] iArr8 = new int[2];
        iArr8[1] = 3;
        iArr8[0] = i16;
        int[][] iArr9 = (int[][]) Array.newInstance(int.class, iArr8);
        int i22 = i12 + 1;
        int i23 = 0;
        int i24 = 0;
        int i25 = 0;
        while (i23 < height) {
            Bitmap bitmap3 = bitmap2;
            int i26 = height;
            int i27 = 0;
            int i28 = 0;
            int i29 = 0;
            int i30 = 0;
            int i31 = 0;
            int i32 = 0;
            int i33 = 0;
            int i34 = 0;
            int i35 = -i12;
            int i36 = 0;
            while (i35 <= i12) {
                int i37 = i15;
                int[] iArr10 = iArr6;
                int i38 = iArr2[i24 + Math.min(i14, Math.max(i35, 0))];
                int[] iArr11 = iArr9[i35 + i12];
                iArr11[0] = (i38 & 16711680) >> 16;
                iArr11[1] = (i38 & 65280) >> 8;
                iArr11[2] = i38 & 255;
                int abs = i22 - Math.abs(i35);
                i36 += iArr11[0] * abs;
                i27 += iArr11[1] * abs;
                i28 += iArr11[2] * abs;
                if (i35 > 0) {
                    i32 += iArr11[0];
                    i33 += iArr11[1];
                    i34 += iArr11[2];
                } else {
                    i29 += iArr11[0];
                    i30 += iArr11[1];
                    i31 += iArr11[2];
                }
                i35++;
                i15 = i37;
                iArr6 = iArr10;
            }
            int i39 = i15;
            int[] iArr12 = iArr6;
            int i40 = i12;
            int i41 = i36;
            int i42 = 0;
            while (i42 < width) {
                iArr3[i24] = iArr7[i41];
                iArr4[i24] = iArr7[i27];
                iArr5[i24] = iArr7[i28];
                int i43 = i41 - i29;
                int i44 = i27 - i30;
                int i45 = i28 - i31;
                int[] iArr13 = iArr9[((i40 - i12) + i16) % i16];
                int i46 = i29 - iArr13[0];
                int i47 = i30 - iArr13[1];
                int i48 = i31 - iArr13[2];
                if (i23 == 0) {
                    iArr = iArr7;
                    iArr12[i42] = Math.min(i42 + i12 + 1, i14);
                } else {
                    iArr = iArr7;
                }
                int i49 = iArr2[i25 + iArr12[i42]];
                iArr13[0] = (i49 & 16711680) >> 16;
                iArr13[1] = (i49 & 65280) >> 8;
                iArr13[2] = i49 & 255;
                int i50 = i32 + iArr13[0];
                int i51 = i33 + iArr13[1];
                int i52 = i34 + iArr13[2];
                i41 = i43 + i50;
                i27 = i44 + i51;
                i28 = i45 + i52;
                i40 = (i40 + 1) % i16;
                int[] iArr14 = iArr9[i40 % i16];
                i29 = i46 + iArr14[0];
                i30 = i47 + iArr14[1];
                i31 = i48 + iArr14[2];
                i32 = i50 - iArr14[0];
                i33 = i51 - iArr14[1];
                i34 = i52 - iArr14[2];
                i24++;
                i42++;
                iArr7 = iArr;
            }
            int[] iArr15 = iArr7;
            i25 += width;
            i23++;
            bitmap2 = bitmap3;
            height = i26;
            i15 = i39;
            iArr6 = iArr12;
        }
        Bitmap bitmap4 = bitmap2;
        int i53 = i15;
        int[] iArr16 = iArr6;
        int i54 = height;
        int[] iArr17 = iArr7;
        int i55 = 0;
        while (i55 < width) {
            int i56 = -i12;
            int i57 = i16;
            int[] iArr18 = iArr2;
            int i58 = 0;
            int i59 = 0;
            int i60 = 0;
            int i61 = 0;
            int i62 = 0;
            int i63 = 0;
            int i64 = 0;
            int i65 = i56;
            int i66 = i56 * width;
            int i67 = 0;
            int i68 = 0;
            while (i65 <= i12) {
                int i69 = width;
                int max = Math.max(0, i66) + i55;
                int[] iArr19 = iArr9[i65 + i12];
                iArr19[0] = iArr3[max];
                iArr19[1] = iArr4[max];
                iArr19[2] = iArr5[max];
                int abs2 = i22 - Math.abs(i65);
                i67 += iArr3[max] * abs2;
                i68 += iArr4[max] * abs2;
                i58 += iArr5[max] * abs2;
                if (i65 > 0) {
                    i62 += iArr19[0];
                    i63 += iArr19[1];
                    i64 += iArr19[2];
                } else {
                    i59 += iArr19[0];
                    i60 += iArr19[1];
                    i61 += iArr19[2];
                }
                int i70 = i53;
                if (i65 < i70) {
                    i66 += i69;
                }
                i65++;
                i53 = i70;
                width = i69;
            }
            int i71 = width;
            int i72 = i53;
            int i73 = i12;
            int i74 = i55;
            int i75 = i68;
            int i76 = i54;
            int i77 = i67;
            int i78 = 0;
            while (i78 < i76) {
                iArr18[i74] = (iArr18[i74] & RoundedDrawable.DEFAULT_BORDER_COLOR) | (iArr17[i77] << 16) | (iArr17[i75] << 8) | iArr17[i58];
                int i79 = i77 - i59;
                int i80 = i75 - i60;
                int i81 = i58 - i61;
                int[] iArr20 = iArr9[((i73 - i12) + i57) % i57];
                int i82 = i59 - iArr20[0];
                int i83 = i60 - iArr20[1];
                int i84 = i61 - iArr20[2];
                if (i55 == 0) {
                    iArr16[i78] = Math.min(i78 + i22, i72) * i71;
                }
                int i85 = iArr16[i78] + i55;
                iArr20[0] = iArr3[i85];
                iArr20[1] = iArr4[i85];
                iArr20[2] = iArr5[i85];
                int i86 = i62 + iArr20[0];
                int i87 = i63 + iArr20[1];
                int i88 = i64 + iArr20[2];
                i77 = i79 + i86;
                i75 = i80 + i87;
                i58 = i81 + i88;
                i73 = (i73 + 1) % i57;
                int[] iArr21 = iArr9[i73];
                i59 = i82 + iArr21[0];
                i60 = i83 + iArr21[1];
                i61 = i84 + iArr21[2];
                i62 = i86 - iArr21[0];
                i63 = i87 - iArr21[1];
                i64 = i88 - iArr21[2];
                i74 += i71;
                i78++;
                i12 = i11;
            }
            i55++;
            i12 = i11;
            i53 = i72;
            i54 = i76;
            i16 = i57;
            iArr2 = iArr18;
            width = i71;
        }
        int i89 = width;
        bitmap4.setPixels(iArr2, 0, i89, 0, 0, i89, i54);
        return bitmap4;
    }
}
