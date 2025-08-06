package com.sumsub.sns.internal.ml.core.pipeline;

import android.graphics.Bitmap;
import com.sumsub.sns.internal.ml.core.pipeline.core.c;

public final class a extends c<Bitmap, C0412a> {

    /* renamed from: com.sumsub.sns.internal.ml.core.pipeline.a$a  reason: collision with other inner class name */
    public static final class C0412a {

        /* renamed from: a  reason: collision with root package name */
        public final int f35028a;

        /* renamed from: b  reason: collision with root package name */
        public final int f35029b;

        /* renamed from: c  reason: collision with root package name */
        public final int[] f35030c;

        public C0412a(int i11, int i12, int[] iArr) {
            this.f35028a = i11;
            this.f35029b = i12;
            this.f35030c = iArr;
        }

        public final int a() {
            return this.f35029b;
        }

        public final int[] b() {
            return this.f35030c;
        }

        public final int c() {
            return this.f35028a;
        }
    }

    /* renamed from: a */
    public C0412a b(Bitmap bitmap) {
        int[] iArr = new int[(bitmap.getWidth() * bitmap.getHeight())];
        bitmap.getPixels(iArr, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
        return new C0412a(bitmap.getWidth(), bitmap.getHeight(), iArr);
    }
}
