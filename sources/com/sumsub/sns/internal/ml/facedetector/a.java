package com.sumsub.sns.internal.ml.facedetector;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Size;
import com.sumsub.sns.internal.ml.core.a;
import com.sumsub.sns.internal.ml.core.b;
import com.sumsub.sns.internal.ml.core.pipeline.c;
import com.sumsub.sns.internal.ml.facedetector.models.d;
import com.sumsub.sns.internal.ml.facedetector.models.e;
import com.sumsub.sns.internal.ml.facedetector.models.f;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.r;
import kotlin.l;
import org.tensorflow.lite.InterpreterApi;

public final class a extends b<Bitmap, e> {

    /* renamed from: p  reason: collision with root package name */
    public static final C0415a f35068p = new C0415a((r) null);
    @Deprecated

    /* renamed from: q  reason: collision with root package name */
    public static final int f35069q = 128;
    @Deprecated

    /* renamed from: r  reason: collision with root package name */
    public static final int f35070r = 128;

    /* renamed from: h  reason: collision with root package name */
    public final d f35071h;

    /* renamed from: i  reason: collision with root package name */
    public float[][][] f35072i;

    /* renamed from: j  reason: collision with root package name */
    public float[][][] f35073j;

    /* renamed from: k  reason: collision with root package name */
    public List<com.sumsub.sns.internal.ml.facedetector.models.a> f35074k;

    /* renamed from: l  reason: collision with root package name */
    public f f35075l;

    /* renamed from: m  reason: collision with root package name */
    public com.sumsub.sns.internal.ml.facedetector.utils.b f35076m;

    /* renamed from: n  reason: collision with root package name */
    public final com.sumsub.sns.internal.ml.core.a f35077n;

    /* renamed from: o  reason: collision with root package name */
    public final String f35078o = "Face detector";

    /* renamed from: com.sumsub.sns.internal.ml.facedetector.a$a  reason: collision with other inner class name */
    public static final class C0415a {
        public /* synthetic */ C0415a(r rVar) {
            this();
        }

        public C0415a() {
        }
    }

    public a(Context context, d dVar) {
        super(b.f35079a);
        this.f35071h = dVar;
        this.f35077n = new a.C0407a(context, "face_detection_short_range.tflite", b.f35079a);
    }

    public com.sumsub.sns.internal.ml.core.a e() {
        return this.f35077n;
    }

    public Map<Integer, Object> g() {
        Pair[] pairArr = new Pair[2];
        float[][][] fArr = this.f35072i;
        float[][][] fArr2 = null;
        if (fArr == null) {
            fArr = null;
        }
        pairArr[0] = l.a(0, fArr);
        float[][][] fArr3 = this.f35073j;
        if (fArr3 != null) {
            fArr2 = fArr3;
        }
        pairArr[1] = l.a(1, fArr2);
        return MapsKt__MapsKt.l(pairArr);
    }

    public String h() {
        return this.f35078o;
    }

    public void a(InterpreterApi interpreterApi) {
        int[] shape = interpreterApi.getOutputTensor(0).shape();
        int i11 = shape[0];
        float[][][] fArr = new float[i11][][];
        for (int i12 = 0; i12 < i11; i12++) {
            int i13 = shape[1];
            float[][] fArr2 = new float[i13][];
            for (int i14 = 0; i14 < i13; i14++) {
                fArr2[i14] = new float[shape[2]];
            }
            fArr[i12] = fArr2;
        }
        this.f35072i = fArr;
        int[] shape2 = interpreterApi.getOutputTensor(1).shape();
        int i15 = shape2[0];
        float[][][] fArr3 = new float[i15][][];
        for (int i16 = 0; i16 < i15; i16++) {
            int i17 = shape2[1];
            float[][] fArr4 = new float[i17][];
            for (int i18 = 0; i18 < i17; i18++) {
                fArr4[i18] = new float[shape2[2]];
            }
            fArr3[i16] = fArr4;
        }
        this.f35073j = fArr3;
        this.f35074k = com.sumsub.sns.internal.ml.facedetector.utils.a.f35129a.a(com.sumsub.sns.internal.ml.facedetector.models.b.f35086o.a());
        this.f35075l = f.f35111o.a((double) this.f35071h.b(), this.f35071h.a());
        this.f35076m = new com.sumsub.sns.internal.ml.facedetector.utils.b();
    }

    public Object[] a(Bitmap bitmap) {
        int max = Math.max(bitmap.getWidth(), bitmap.getHeight());
        return new Object[]{((com.sumsub.sns.internal.ml.core.buffer.a) new com.sumsub.sns.internal.ml.core.pipeline.core.a(new com.sumsub.sns.internal.ml.core.pipeline.b(max, max)).a(new c(128, 128, false, false)).a(new com.sumsub.sns.internal.ml.facedetector.pipeline.a()).a(bitmap)).a()};
    }

    public e a(Bitmap bitmap, long j11) {
        com.sumsub.sns.internal.ml.facedetector.utils.b bVar = this.f35076m;
        com.sumsub.sns.internal.ml.facedetector.utils.b bVar2 = bVar == null ? null : bVar;
        Size size = new Size(bitmap.getWidth(), bitmap.getHeight());
        f fVar = this.f35075l;
        f fVar2 = fVar == null ? null : fVar;
        float[][][] fArr = this.f35073j;
        float[][][] fArr2 = fArr == null ? null : fArr;
        float[][][] fArr3 = this.f35072i;
        float[][][] fArr4 = fArr3 == null ? null : fArr3;
        List<com.sumsub.sns.internal.ml.facedetector.models.a> list = this.f35074k;
        return new e(bVar2.a(size, fVar2, fArr2, fArr4, list == null ? null : list), j11);
    }
}
