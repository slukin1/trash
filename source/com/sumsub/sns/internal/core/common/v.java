package com.sumsub.sns.internal.core.common;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import androidx.camera.core.ImageProxy;
import com.sumsub.sns.internal.core.common.s;
import com.sumsub.sns.internal.log.LoggerType;
import com.sumsub.sns.internal.log.b;
import d10.p;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.Lambda;

public final class v {

    /* renamed from: a  reason: collision with root package name */
    public static final String f32288a = "ImageExtensions";

    public static final class a extends Lambda implements d10.a<Bitmap> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ImageProxy f32289a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ p<Integer, Integer, Bitmap> f32290b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(ImageProxy imageProxy, p<? super Integer, ? super Integer, Bitmap> pVar) {
            super(0);
            this.f32289a = imageProxy;
            this.f32290b = pVar;
        }

        /* renamed from: a */
        public final Bitmap invoke() {
            int rowStride = this.f32289a.getPlanes()[0].getRowStride() / 4;
            try {
                Bitmap invoke = this.f32290b.invoke(Integer.valueOf(rowStride), Integer.valueOf(this.f32289a.getHeight()));
                ByteBuffer buffer = this.f32289a.getPlanes()[0].getBuffer();
                buffer.rewind();
                invoke.copyPixelsFromBuffer(buffer);
                return v.b(invoke, this.f32289a.getImageInfo().getRotationDegrees(), false);
            } catch (Throwable th2) {
                com.sumsub.sns.internal.log.a aVar = com.sumsub.sns.internal.log.a.f34862a;
                b.b(aVar, v.f32288a, "Failed to copyPixelsFromBuffer. Reported width: " + this.f32289a.getWidth() + ", real width: " + rowStride, (Throwable) null, 4, (Object) null);
                throw th2;
            }
        }
    }

    public static final Bitmap a(ImageProxy imageProxy, p<? super Integer, ? super Integer, Bitmap> pVar) {
        a aVar = new a(imageProxy, pVar);
        try {
            return (Bitmap) aVar.invoke();
        } catch (OutOfMemoryError unused) {
            b.b(com.sumsub.sns.internal.log.a.f34862a, f32288a, "Caught OutOfMemoryError while converting ImageProxy to Bitmap", (Throwable) null, 4, (Object) null);
            s.a.f32281a.a();
            return (Bitmap) aVar.invoke();
        }
    }

    public static /* synthetic */ Bitmap b(Bitmap bitmap, int i11, boolean z11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            z11 = true;
        }
        return b(bitmap, i11, z11);
    }

    public static final Bitmap b(Bitmap bitmap, int i11, boolean z11) {
        Bitmap bitmap2;
        if (i11 == 90) {
            bitmap2 = a(bitmap, 6, z11);
        } else if (i11 == 180) {
            bitmap2 = a(bitmap, 3, z11);
        } else if (i11 != 270) {
            bitmap2 = bitmap.copy(Bitmap.Config.ARGB_8888, bitmap.isMutable());
            if (z11) {
                bitmap.recycle();
            }
        } else {
            bitmap2 = a(bitmap, 8, z11);
        }
        if (bitmap2 != bitmap) {
            return bitmap2;
        }
        com.sumsub.sns.internal.log.a.f34862a.a(LoggerType.KIBANA).w(f32288a, "creating an image copy. Rotated image is same as original", new Exception("creating an image copy. Rotated image is same as original"));
        return bitmap2.copy(Bitmap.Config.ARGB_8888, bitmap.isMutable());
    }

    public static /* synthetic */ Bitmap a(Bitmap bitmap, int i11, boolean z11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            z11 = true;
        }
        return a(bitmap, i11, z11);
    }

    public static final Bitmap a(Bitmap bitmap, int i11, boolean z11) {
        Matrix matrix = new Matrix();
        switch (i11) {
            case 2:
                matrix.setScale(-1.0f, 1.0f);
                break;
            case 3:
                matrix.setRotate(180.0f);
                break;
            case 4:
                matrix.setRotate(180.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 5:
                matrix.setRotate(90.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 6:
                matrix.setRotate(90.0f);
                break;
            case 7:
                matrix.setRotate(-90.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 8:
                matrix.setRotate(-90.0f);
                break;
        }
        try {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            if (z11) {
                bitmap.recycle();
            }
            return createBitmap;
        } catch (Exception e11) {
            com.sumsub.sns.internal.log.a.f34862a.e(f32288a, "Rotate bitmap", e11);
            return bitmap;
        }
    }

    public static final Matrix a(Matrix matrix, int i11, int i12, int i13, int i14, int i15, boolean z11) {
        matrix.reset();
        if (i15 != 0) {
            if (i15 % 90 != 0) {
                com.sumsub.sns.internal.log.a aVar = com.sumsub.sns.internal.log.a.f34862a;
                com.sumsub.log.logger.a.e(aVar, "getTransformationMatrix", "Rotation of " + i15 + " % 90 != 0", (Throwable) null, 4, (Object) null);
            }
            matrix.postTranslate(((float) (-i11)) / 2.0f, ((float) (-i12)) / 2.0f);
            matrix.postRotate((float) i15);
        }
        boolean z12 = (Math.abs(i15) + 90) % 180 == 0;
        int i16 = z12 ? i12 : i11;
        if (!z12) {
            i11 = i12;
        }
        if (!(i16 == i13 && i11 == i14)) {
            float f11 = (float) i13;
            float f12 = (float) i16;
            float f13 = f11 / f12;
            float f14 = ((float) i14) / ((float) i11);
            if (z11) {
                float max = Math.max(f13, f14);
                matrix.postScale(max, max);
                float f15 = f12 * max;
                if (f15 > f11) {
                    matrix.postTranslate(((f15 - f11) / 2.0f) * -1.0f, 0.0f);
                }
            } else {
                matrix.postScale(f13, f14);
            }
        }
        if (i15 != 0) {
            matrix.postTranslate(((float) i13) / 2.0f, ((float) i14) / 2.0f);
        }
        return matrix;
    }
}
