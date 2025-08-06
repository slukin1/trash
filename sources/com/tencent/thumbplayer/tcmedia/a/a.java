package com.tencent.thumbplayer.tcmedia.a;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.tencent.thumbplayer.tcmedia.core.common.TPVideoFrame;
import java.nio.ByteBuffer;

public class a {
    public static Bitmap a(TPVideoFrame tPVideoFrame) {
        int i11;
        int i12;
        byte[][] bArr = tPVideoFrame.data;
        if (bArr.length <= 0 || (i11 = tPVideoFrame.height) == 0 || (i12 = tPVideoFrame.width) == 0) {
            return null;
        }
        return a(bArr[0], i12, i11, tPVideoFrame.rotation);
    }

    private static Bitmap a(byte[] bArr, int i11, int i12, int i13) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        Bitmap createBitmap = Bitmap.createBitmap(i11, i12, Bitmap.Config.RGB_565);
        createBitmap.copyPixelsFromBuffer(wrap);
        if (i13 == 0) {
            return createBitmap;
        }
        Matrix matrix = new Matrix();
        matrix.postRotate((float) i13);
        return Bitmap.createBitmap(createBitmap, 0, 0, createBitmap.getWidth(), createBitmap.getHeight(), matrix, true);
    }

    public static Bitmap[] b(TPVideoFrame tPVideoFrame) {
        byte[][] bArr = tPVideoFrame.data;
        if (bArr.length <= 0 || tPVideoFrame.height == 0 || tPVideoFrame.width == 0) {
            return null;
        }
        Bitmap[] bitmapArr = new Bitmap[bArr.length];
        int i11 = 0;
        while (true) {
            byte[][] bArr2 = tPVideoFrame.data;
            if (i11 >= bArr2.length) {
                return bitmapArr;
            }
            bitmapArr[i11] = a(bArr2[i11], tPVideoFrame.width, tPVideoFrame.height, tPVideoFrame.rotation);
            i11++;
        }
    }
}
