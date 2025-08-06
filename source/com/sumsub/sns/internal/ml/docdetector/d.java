package com.sumsub.sns.internal.ml.docdetector;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Environment;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import kotlin.text.b;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final d f35067a = new d();

    public final MappedByteBuffer a(AssetManager assetManager, String str) throws IOException {
        AssetFileDescriptor openFd = assetManager.openFd(str);
        return new FileInputStream(openFd.getFileDescriptor()).getChannel().map(FileChannel.MapMode.READ_ONLY, openFd.getStartOffset(), openFd.getDeclaredLength());
    }

    public final void a(float[] fArr) {
        float f11 = Float.NEGATIVE_INFINITY;
        for (float max : fArr) {
            f11 = Math.max(f11, max);
        }
        float f12 = 0.0f;
        int length = fArr.length;
        for (int i11 = 0; i11 < length; i11++) {
            float exp = (float) Math.exp((double) (fArr[i11] - f11));
            fArr[i11] = exp;
            f12 += exp;
        }
        int length2 = fArr.length;
        for (int i12 = 0; i12 < length2; i12++) {
            fArr[i12] = fArr[i12] / f12;
        }
    }

    public final float a(float f11) {
        return (float) (1.0d / (Math.exp(-((double) f11)) + 1.0d));
    }

    public final Matrix a(int i11, int i12, int i13, int i14, int i15, boolean z11) {
        Matrix matrix = new Matrix();
        if (i15 != 0) {
            matrix.postTranslate(((float) (-i11)) / 2.0f, ((float) (-i12)) / 2.0f);
            matrix.postRotate((float) i15);
        }
        boolean z12 = (Math.abs(i15) + 90) % 180 == 0;
        int i16 = z12 ? i12 : i11;
        if (!z12) {
            i11 = i12;
        }
        if (!(i16 == i13 && i11 == i14)) {
            float f11 = ((float) i13) / ((float) i16);
            float f12 = ((float) i14) / ((float) i11);
            if (z11) {
                float max = Math.max(f11, f12);
                matrix.postScale(max, max);
            } else {
                matrix.postScale(f11, f12);
            }
        }
        if (i15 != 0) {
            matrix.postTranslate(((float) i13) / 2.0f, ((float) i14) / 2.0f);
        }
        return matrix;
    }

    public final Bitmap a(Bitmap bitmap, int i11) {
        int height = bitmap.getHeight();
        int width = bitmap.getWidth();
        Bitmap createBitmap = Bitmap.createBitmap(i11, i11, Bitmap.Config.ARGB_8888);
        Matrix a11 = a(width, height, i11, i11, 0, false);
        a11.invert(new Matrix());
        new Canvas(createBitmap).drawBitmap(bitmap, a11, (Paint) null);
        return createBitmap;
    }

    public final void a(String str, Context context) {
        FileOutputStream fileOutputStream;
        try {
            String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
            fileOutputStream = new FileOutputStream(new File(absolutePath + File.separator + "myFile.txt"));
            fileOutputStream.write(str.getBytes(b.f56908b));
            fileOutputStream.close();
        } catch (IOException e11) {
            Log.e("Exception", "File write failed: " + e11);
        } catch (Throwable th2) {
            fileOutputStream.close();
            throw th2;
        }
    }
}
