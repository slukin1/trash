package com.sumsub.sns.internal.ml.badphotos.pipeline;

import android.content.Context;
import com.sumsub.sns.internal.ml.core.pipeline.a;
import com.sumsub.sns.internal.ml.core.pipeline.core.c;

public final class a extends c<a.C0412a, com.sumsub.sns.internal.ml.core.buffer.a> {

    /* renamed from: a  reason: collision with root package name */
    public final Context f34979a;

    public a(Context context) {
        this.f34979a = context;
    }

    public final Context a() {
        return this.f34979a;
    }

    /* renamed from: a */
    public com.sumsub.sns.internal.ml.core.buffer.a b(a.C0412a aVar) {
        int c11 = aVar.c();
        int a11 = aVar.a();
        int[] b11 = aVar.b();
        float[] fArr = new float[(c11 * a11 * 3)];
        int length = b11.length;
        int i11 = 0;
        int i12 = 0;
        while (i11 < length) {
            fArr[i12] = ((float) ((b11[i11] >> 16) & 255)) / 255.0f;
            i11++;
            i12++;
        }
        int length2 = b11.length;
        int i13 = 0;
        while (i13 < length2) {
            fArr[i12] = ((float) ((b11[i13] >> 8) & 255)) / 255.0f;
            i13++;
            i12++;
        }
        int length3 = b11.length;
        int i14 = 0;
        while (i14 < length3) {
            fArr[i12] = ((float) (b11[i14] & 255)) / 255.0f;
            i14++;
            i12++;
        }
        return new com.sumsub.sns.internal.ml.core.buffer.a(fArr, new int[]{1, 3, a11, c11});
    }
}
