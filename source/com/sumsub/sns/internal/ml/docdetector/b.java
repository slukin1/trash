package com.sumsub.sns.internal.ml.docdetector;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.RectF;
import android.util.Size;
import com.luck.picture.lib.config.PictureMimeType;
import com.sumsub.sns.internal.ml.autocapture.a;
import com.sumsub.sns.internal.ml.core.a;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;
import kotlin.i;
import kotlin.jvm.internal.Lambda;
import okhttp3.OkHttpClient;

public final class b extends com.sumsub.sns.internal.ml.core.b<Bitmap, a> {

    /* renamed from: h  reason: collision with root package name */
    public final Context f35047h;

    /* renamed from: i  reason: collision with root package name */
    public final a.C0405a f35048i;

    /* renamed from: j  reason: collision with root package name */
    public int[] f35049j = new int[0];

    /* renamed from: k  reason: collision with root package name */
    public ByteBuffer f35050k = ByteBuffer.allocateDirect(0);

    /* renamed from: l  reason: collision with root package name */
    public ByteBuffer f35051l = ByteBuffer.allocateDirect(0);

    /* renamed from: m  reason: collision with root package name */
    public final i f35052m = LazyKt__LazyJVMKt.a(new c(this));

    /* renamed from: n  reason: collision with root package name */
    public int f35053n;

    /* renamed from: o  reason: collision with root package name */
    public final com.sumsub.sns.internal.ml.core.a f35054o;

    /* renamed from: p  reason: collision with root package name */
    public final String f35055p = "Doc bounds detector";

    public static final class a<T> implements Comparator {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f35056a;

        public a(int i11) {
            this.f35056a = i11;
        }

        public final int compare(T t11, T t12) {
            return ComparisonsKt__ComparisonsKt.a(Float.valueOf(((float[]) t12)[this.f35056a]), Float.valueOf(((float[]) t11)[this.f35056a]));
        }
    }

    @d(c = "com.sumsub.sns.internal.ml.docdetector.DocDetector", f = "DocDetector.kt", l = {151}, m = "detect")
    /* renamed from: com.sumsub.sns.internal.ml.docdetector.b$b  reason: collision with other inner class name */
    public static final class C0414b extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public long f35057a;

        /* renamed from: b  reason: collision with root package name */
        public Object f35058b;

        /* renamed from: c  reason: collision with root package name */
        public /* synthetic */ Object f35059c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ b f35060d;

        /* renamed from: e  reason: collision with root package name */
        public int f35061e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0414b(b bVar, kotlin.coroutines.c<? super C0414b> cVar) {
            super(cVar);
            this.f35060d = bVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f35059c = obj;
            this.f35061e |= Integer.MIN_VALUE;
            return this.f35060d.a((Bitmap) null, false, this);
        }
    }

    public static final class c extends Lambda implements d10.a<float[][][]> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f35062a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(b bVar) {
            super(0);
            this.f35062a = bVar;
        }

        /* renamed from: a */
        public final float[][][] invoke() {
            float[][][] fArr = new float[1][][];
            int a11 = this.f35062a.f35053n;
            float[][] fArr2 = new float[a11][];
            for (int i11 = 0; i11 < a11; i11++) {
                fArr2[i11] = new float[5];
            }
            fArr[0] = fArr2;
            return fArr;
        }
    }

    public b(Context context, OkHttpClient okHttpClient, String str, a.C0405a aVar) {
        super(c.f35066d);
        this.f35047h = context;
        this.f35048i = aVar;
        this.f35054o = new a.b(context, okHttpClient, str, aVar.a(), c.f35066d);
        this.f35049j = new int[(l().getWidth() * l().getHeight())];
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(l().getWidth() * 1 * l().getHeight() * 3 * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        this.f35050k = allocateDirect;
        int j11 = aVar.j();
        this.f35053n = j11;
        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(j11 * 5 * 4);
        allocateDirect2.order(ByteOrder.nativeOrder());
        this.f35051l = allocateDirect2;
    }

    public static /* synthetic */ void m() {
    }

    public final float a(float f11, float f12, float f13, float f14) {
        float f15 = f12 / 2.0f;
        float f16 = f11 - f15;
        float f17 = f14 / 2.0f;
        float f18 = f13 - f17;
        if (f16 <= f18) {
            f16 = f18;
        }
        float f19 = f11 + f15;
        float f21 = f13 + f17;
        if (f19 >= f21) {
            f19 = f21;
        }
        return f19 - f16;
    }

    public final void b(Bitmap bitmap) {
        File externalFilesDir = this.f35047h.getExternalFilesDir((String) null);
        if (externalFilesDir != null) {
            File file = new File(externalFilesDir, "scaled_frame_" + System.currentTimeMillis() + PictureMimeType.JPG);
            com.sumsub.sns.internal.log.a aVar = com.sumsub.sns.internal.log.a.f34862a;
            com.sumsub.log.logger.a.d(aVar, c.f35066d, "saving to " + file.getAbsolutePath(), (Throwable) null, 4, (Object) null);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            boolean compress = bitmap.compress(Bitmap.CompressFormat.JPEG, 90, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            if (compress) {
                com.sumsub.log.logger.a.d(aVar, c.f35066d, "saved!", (Throwable) null, 4, (Object) null);
            }
        }
    }

    public final float c(RectF rectF, RectF rectF2) {
        return (((rectF.right - rectF.left) * (rectF.bottom - rectF.top)) + ((rectF2.right - rectF2.left) * (rectF2.bottom - rectF2.top))) - a(rectF, rectF2);
    }

    public com.sumsub.sns.internal.ml.core.a e() {
        return this.f35054o;
    }

    public Map<Integer, Object> g() {
        HashMap hashMap = new HashMap();
        this.f35051l.rewind();
        hashMap.put(0, this.f35051l);
        return hashMap;
    }

    public String h() {
        return this.f35055p;
    }

    public final Size l() {
        return this.f35048i.i();
    }

    public final float[][][] n() {
        return (float[][][]) this.f35052m.getValue();
    }

    public Object[] a(Bitmap bitmap) {
        bitmap.getPixels(this.f35049j, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
        this.f35050k.rewind();
        int height = l().getHeight();
        for (int i11 = 0; i11 < height; i11++) {
            int width = l().getWidth();
            for (int i12 = 0; i12 < width; i12++) {
                int i13 = this.f35049j[(l().getWidth() * i11) + i12];
                this.f35050k.putFloat((((float) ((i13 >> 16) & 255)) - 0.0f) / 255.0f);
                this.f35050k.putFloat((((float) ((i13 >> 8) & 255)) - 0.0f) / 255.0f);
                this.f35050k.putFloat((((float) (i13 & 255)) - 0.0f) / 255.0f);
            }
        }
        return new Object[]{this.f35050k};
    }

    public final float b(RectF rectF, RectF rectF2) {
        return a(rectF, rectF2) / c(rectF, rectF2);
    }

    public a a(Bitmap bitmap, long j11) {
        this.f35051l.rewind();
        for (int i11 = 0; i11 < 5; i11++) {
            int i12 = this.f35053n;
            for (int i13 = 0; i13 < i12; i13++) {
                n()[0][i13][i11] = this.f35051l.getFloat();
            }
            int i14 = this.f35053n;
            for (int i15 = 0; i15 < i14; i15++) {
                if (i11 < 4) {
                    if (i11 % 2 == 0) {
                        float[] fArr = n()[0][i15];
                        fArr[i11] = fArr[i11] * ((float) l().getWidth());
                    } else {
                        float[] fArr2 = n()[0][i15];
                        fArr2[i11] = fArr2[i11] * ((float) l().getHeight());
                    }
                }
            }
        }
        float[][] fArr3 = n()[0];
        ArrayList arrayList = new ArrayList();
        int length = fArr3.length;
        int i16 = 0;
        while (true) {
            boolean z11 = true;
            if (i16 >= length) {
                break;
            }
            float[] fArr4 = fArr3[i16];
            if (fArr4[4] <= this.f35048i.c()) {
                z11 = false;
            }
            if (z11) {
                arrayList.add(fArr4);
            }
            i16++;
        }
        List z02 = CollectionsKt___CollectionsKt.z0(arrayList, new a(4));
        if (z02.isEmpty()) {
            return null;
        }
        float[] fArr5 = (float[]) CollectionsKt___CollectionsKt.a0(z02);
        return new a((int) fArr5[0], (int) fArr5[1], (int) fArr5[2], (int) fArr5[3], fArr5[4], j11, -1);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0090 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(android.graphics.Bitmap r13, boolean r14, kotlin.coroutines.c<? super com.sumsub.sns.internal.ml.docdetector.a> r15) {
        /*
            r12 = this;
            boolean r0 = r15 instanceof com.sumsub.sns.internal.ml.docdetector.b.C0414b
            if (r0 == 0) goto L_0x0013
            r0 = r15
            com.sumsub.sns.internal.ml.docdetector.b$b r0 = (com.sumsub.sns.internal.ml.docdetector.b.C0414b) r0
            int r1 = r0.f35061e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f35061e = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.ml.docdetector.b$b r0 = new com.sumsub.sns.internal.ml.docdetector.b$b
            r0.<init>(r12, r15)
        L_0x0018:
            java.lang.Object r15 = r0.f35059c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f35061e
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            long r13 = r0.f35057a
            java.lang.Object r0 = r0.f35058b
            android.graphics.Bitmap r0 = (android.graphics.Bitmap) r0
            kotlin.k.b(r15)
            goto L_0x0067
        L_0x002f:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L_0x0037:
            kotlin.k.b(r15)
            long r4 = java.lang.System.currentTimeMillis()
            android.util.Size r15 = r12.l()
            int r15 = r15.getWidth()
            android.util.Size r2 = r12.l()
            int r2 = r2.getHeight()
            r6 = 0
            android.graphics.Bitmap r13 = android.graphics.Bitmap.createScaledBitmap(r13, r15, r2, r6)
            if (r14 == 0) goto L_0x0058
            r12.b(r13)
        L_0x0058:
            r0.f35058b = r13
            r0.f35057a = r4
            r0.f35061e = r3
            java.lang.Object r15 = r12.a(r13, r0)
            if (r15 != r1) goto L_0x0065
            return r1
        L_0x0065:
            r0 = r13
            r13 = r4
        L_0x0067:
            com.sumsub.sns.internal.ml.core.e$a r15 = (com.sumsub.sns.internal.ml.core.e.a) r15
            r0.recycle()
            boolean r0 = r15 instanceof com.sumsub.sns.internal.ml.core.e.a.d
            if (r0 == 0) goto L_0x0090
            com.sumsub.sns.internal.ml.core.e$a$d r15 = (com.sumsub.sns.internal.ml.core.e.a.d) r15
            java.lang.Object r15 = r15.c()
            r0 = r15
            com.sumsub.sns.internal.ml.docdetector.a r0 = (com.sumsub.sns.internal.ml.docdetector.a) r0
            if (r0 == 0) goto L_0x0090
            long r1 = java.lang.System.currentTimeMillis()
            long r8 = r1 - r13
            r1 = 0
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r10 = 63
            r11 = 0
            com.sumsub.sns.internal.ml.docdetector.a r13 = com.sumsub.sns.internal.ml.docdetector.a.a(r0, r1, r2, r3, r4, r5, r6, r8, r10, r11)
            goto L_0x0091
        L_0x0090:
            r13 = 0
        L_0x0091:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.ml.docdetector.b.a(android.graphics.Bitmap, boolean, kotlin.coroutines.c):java.lang.Object");
    }

    public static /* synthetic */ Object a(b bVar, Bitmap bitmap, boolean z11, kotlin.coroutines.c cVar, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        return bVar.a(bitmap, z11, cVar);
    }

    public final float a(RectF rectF, RectF rectF2) {
        float f11 = rectF.left;
        float f12 = rectF.right;
        float f13 = f12 - f11;
        float f14 = rectF2.left;
        float f15 = rectF2.right;
        float a11 = a((f11 + f12) / 2.0f, f13, (f14 + f15) / 2.0f, f15 - f14);
        float f16 = rectF.top;
        float f17 = rectF.bottom;
        float f18 = f17 - f16;
        float f19 = rectF2.top;
        float f21 = rectF2.bottom;
        float a12 = a((f16 + f17) / 2.0f, f18, (f19 + f21) / 2.0f, f21 - f19);
        if (a11 < 0.0f || a12 < 0.0f) {
            return 0.0f;
        }
        return a11 * a12;
    }
}
