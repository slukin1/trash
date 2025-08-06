package com.sumsub.sns.internal.ml.facedetector.pipeline;

import android.graphics.Bitmap;
import com.sumsub.sns.internal.ml.core.pipeline.core.c;
import kotlin.jvm.internal.r;

public final class a extends c<Bitmap, com.sumsub.sns.internal.ml.core.buffer.a> {

    /* renamed from: a  reason: collision with root package name */
    public static final C0417a f35126a = new C0417a((r) null);

    /* renamed from: b  reason: collision with root package name */
    public static final float f35127b = 127.5f;

    /* renamed from: c  reason: collision with root package name */
    public static final float f35128c = 127.5f;

    /* renamed from: com.sumsub.sns.internal.ml.facedetector.pipeline.a$a  reason: collision with other inner class name */
    public static final class C0417a {
        public /* synthetic */ C0417a(r rVar) {
            this();
        }

        public C0417a() {
        }
    }

    /* renamed from: a */
    public com.sumsub.sns.internal.ml.core.buffer.a b(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i11 = width * height;
        int[] iArr = new int[i11];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        float[] fArr = new float[(i11 * 3)];
        int i12 = 0;
        int i13 = 0;
        while (i12 < i11) {
            int i14 = iArr[i12];
            int i15 = i13 + 1;
            fArr[i13] = (((float) ((i14 >> 16) & 255)) - 127.5f) / 127.5f;
            int i16 = i15 + 1;
            fArr[i15] = (((float) ((i14 >> 8) & 255)) - 127.5f) / 127.5f;
            fArr[i16] = (((float) (i14 & 255)) - 127.5f) / 127.5f;
            i12++;
            i13 = i16 + 1;
        }
        return new com.sumsub.sns.internal.ml.core.buffer.a(fArr, new int[]{height, width, 3});
    }
}
