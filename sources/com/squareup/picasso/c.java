package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.net.NetworkInfo;
import android.os.Build;
import com.squareup.picasso.NetworkRequestHandler;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestHandler;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import okio.BufferedSource;
import okio.Okio;
import okio.Source;

public class c implements Runnable {

    /* renamed from: u  reason: collision with root package name */
    public static final Object f30003u = new Object();

    /* renamed from: v  reason: collision with root package name */
    public static final ThreadLocal<StringBuilder> f30004v = new a();

    /* renamed from: w  reason: collision with root package name */
    public static final AtomicInteger f30005w = new AtomicInteger();

    /* renamed from: x  reason: collision with root package name */
    public static final RequestHandler f30006x = new b();

    /* renamed from: b  reason: collision with root package name */
    public final int f30007b = f30005w.incrementAndGet();

    /* renamed from: c  reason: collision with root package name */
    public final Picasso f30008c;

    /* renamed from: d  reason: collision with root package name */
    public final h f30009d;

    /* renamed from: e  reason: collision with root package name */
    public final d f30010e;

    /* renamed from: f  reason: collision with root package name */
    public final t f30011f;

    /* renamed from: g  reason: collision with root package name */
    public final String f30012g;

    /* renamed from: h  reason: collision with root package name */
    public final q f30013h;

    /* renamed from: i  reason: collision with root package name */
    public final int f30014i;

    /* renamed from: j  reason: collision with root package name */
    public int f30015j;

    /* renamed from: k  reason: collision with root package name */
    public final RequestHandler f30016k;

    /* renamed from: l  reason: collision with root package name */
    public a f30017l;

    /* renamed from: m  reason: collision with root package name */
    public List<a> f30018m;

    /* renamed from: n  reason: collision with root package name */
    public Bitmap f30019n;

    /* renamed from: o  reason: collision with root package name */
    public Future<?> f30020o;

    /* renamed from: p  reason: collision with root package name */
    public Picasso.LoadedFrom f30021p;

    /* renamed from: q  reason: collision with root package name */
    public Exception f30022q;

    /* renamed from: r  reason: collision with root package name */
    public int f30023r;

    /* renamed from: s  reason: collision with root package name */
    public int f30024s;

    /* renamed from: t  reason: collision with root package name */
    public Picasso.Priority f30025t;

    public static class a extends ThreadLocal<StringBuilder> {
        /* renamed from: a */
        public StringBuilder initialValue() {
            return new StringBuilder("Picasso-");
        }
    }

    public static class b extends RequestHandler {
        public boolean c(q qVar) {
            return true;
        }

        public RequestHandler.a f(q qVar, int i11) throws IOException {
            throw new IllegalStateException("Unrecognized type of request: " + qVar);
        }
    }

    /* renamed from: com.squareup.picasso.c$c  reason: collision with other inner class name */
    public static class C0265c implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ x f30026b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ RuntimeException f30027c;

        public C0265c(x xVar, RuntimeException runtimeException) {
            this.f30026b = xVar;
            this.f30027c = runtimeException;
        }

        public void run() {
            throw new RuntimeException("Transformation " + this.f30026b.key() + " crashed with exception.", this.f30027c);
        }
    }

    public static class d implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ StringBuilder f30028b;

        public d(StringBuilder sb2) {
            this.f30028b = sb2;
        }

        public void run() {
            throw new NullPointerException(this.f30028b.toString());
        }
    }

    public static class e implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ x f30029b;

        public e(x xVar) {
            this.f30029b = xVar;
        }

        public void run() {
            throw new IllegalStateException("Transformation " + this.f30029b.key() + " returned input Bitmap but recycled it.");
        }
    }

    public static class f implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ x f30030b;

        public f(x xVar) {
            this.f30030b = xVar;
        }

        public void run() {
            throw new IllegalStateException("Transformation " + this.f30030b.key() + " mutated input Bitmap but failed to recycle the original.");
        }
    }

    public c(Picasso picasso, h hVar, d dVar, t tVar, a aVar, RequestHandler requestHandler) {
        this.f30008c = picasso;
        this.f30009d = hVar;
        this.f30010e = dVar;
        this.f30011f = tVar;
        this.f30017l = aVar;
        this.f30012g = aVar.d();
        this.f30013h = aVar.i();
        this.f30025t = aVar.h();
        this.f30014i = aVar.e();
        this.f30015j = aVar.f();
        this.f30016k = requestHandler;
        this.f30024s = requestHandler.e();
    }

    public static Bitmap a(List<x> list, Bitmap bitmap) {
        int size = list.size();
        int i11 = 0;
        while (i11 < size) {
            x xVar = list.get(i11);
            try {
                Bitmap transform = xVar.transform(bitmap);
                if (transform == null) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Transformation ");
                    sb2.append(xVar.key());
                    sb2.append(" returned null after ");
                    sb2.append(i11);
                    sb2.append(" previous transformation(s).\n\nTransformation list:\n");
                    for (x key : list) {
                        sb2.append(key.key());
                        sb2.append(10);
                    }
                    Picasso.f29949p.post(new d(sb2));
                    return null;
                } else if (transform == bitmap && bitmap.isRecycled()) {
                    Picasso.f29949p.post(new e(xVar));
                    return null;
                } else if (transform == bitmap || bitmap.isRecycled()) {
                    i11++;
                    bitmap = transform;
                } else {
                    Picasso.f29949p.post(new f(xVar));
                    return null;
                }
            } catch (RuntimeException e11) {
                Picasso.f29949p.post(new C0265c(xVar, e11));
                return null;
            }
        }
        return bitmap;
    }

    public static Bitmap e(Source source, q qVar) throws IOException {
        BufferedSource buffer = Okio.buffer(source);
        boolean r11 = y.r(buffer);
        boolean z11 = qVar.f30099r && Build.VERSION.SDK_INT < 21;
        BitmapFactory.Options d11 = RequestHandler.d(qVar);
        boolean g11 = RequestHandler.g(d11);
        if (r11 || z11) {
            byte[] readByteArray = buffer.readByteArray();
            if (g11) {
                BitmapFactory.decodeByteArray(readByteArray, 0, readByteArray.length, d11);
                RequestHandler.b(qVar.f30089h, qVar.f30090i, d11, qVar);
            }
            return BitmapFactory.decodeByteArray(readByteArray, 0, readByteArray.length, d11);
        }
        InputStream inputStream = buffer.inputStream();
        if (g11) {
            m mVar = new m(inputStream);
            mVar.a(false);
            long e11 = mVar.e(1024);
            BitmapFactory.decodeStream(mVar, (Rect) null, d11);
            RequestHandler.b(qVar.f30089h, qVar.f30090i, d11, qVar);
            mVar.b(e11);
            mVar.a(true);
            inputStream = mVar;
        }
        Bitmap decodeStream = BitmapFactory.decodeStream(inputStream, (Rect) null, d11);
        if (decodeStream != null) {
            return decodeStream;
        }
        throw new IOException("Failed to decode stream.");
    }

    public static c g(Picasso picasso, h hVar, d dVar, t tVar, a aVar) {
        q i11 = aVar.i();
        List<RequestHandler> i12 = picasso.i();
        int size = i12.size();
        for (int i13 = 0; i13 < size; i13++) {
            RequestHandler requestHandler = i12.get(i13);
            if (requestHandler.c(i11)) {
                return new c(picasso, hVar, dVar, tVar, aVar, requestHandler);
            }
        }
        return new c(picasso, hVar, dVar, tVar, aVar, f30006x);
    }

    public static int l(int i11) {
        switch (i11) {
            case 3:
            case 4:
                return 180;
            case 5:
            case 6:
                return 90;
            case 7:
            case 8:
                return 270;
            default:
                return 0;
        }
    }

    public static int m(int i11) {
        return (i11 == 2 || i11 == 7 || i11 == 4 || i11 == 5) ? -1 : 1;
    }

    public static boolean v(boolean z11, int i11, int i12, int i13, int i14) {
        return !z11 || (i13 != 0 && i11 > i13) || (i14 != 0 && i12 > i14);
    }

    /* JADX WARNING: Removed duplicated region for block: B:87:0x024b  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x024f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap y(com.squareup.picasso.q r26, android.graphics.Bitmap r27, int r28) {
        /*
            r0 = r26
            int r1 = r27.getWidth()
            int r2 = r27.getHeight()
            boolean r3 = r0.f30094m
            android.graphics.Matrix r9 = new android.graphics.Matrix
            r9.<init>()
            boolean r4 = r26.e()
            if (r4 != 0) goto L_0x001f
            if (r28 == 0) goto L_0x001a
            goto L_0x001f
        L_0x001a:
            r3 = r1
            r5 = r2
            r0 = r9
            goto L_0x023b
        L_0x001f:
            int r4 = r0.f30089h
            int r6 = r0.f30090i
            float r7 = r0.f30095n
            r8 = 0
            int r8 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1))
            if (r8 == 0) goto L_0x0130
            double r10 = (double) r7
            double r12 = java.lang.Math.toRadians(r10)
            double r12 = java.lang.Math.cos(r12)
            double r10 = java.lang.Math.toRadians(r10)
            double r10 = java.lang.Math.sin(r10)
            boolean r4 = r0.f30098q
            if (r4 == 0) goto L_0x00c9
            float r4 = r0.f30096o
            float r6 = r0.f30097p
            r9.setRotate(r7, r4, r6)
            float r4 = r0.f30096o
            double r6 = (double) r4
            r14 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r14 = r14 - r12
            double r6 = r6 * r14
            float r8 = r0.f30097p
            r16 = r2
            r17 = r3
            double r2 = (double) r8
            double r2 = r2 * r10
            double r6 = r6 + r2
            double r2 = (double) r8
            double r2 = r2 * r14
            double r14 = (double) r4
            double r14 = r14 * r10
            double r2 = r2 - r14
            int r4 = r0.f30089h
            double r14 = (double) r4
            double r14 = r14 * r12
            double r14 = r14 + r6
            r18 = r6
            double r5 = (double) r4
            double r5 = r5 * r10
            double r5 = r5 + r2
            r20 = r9
            double r8 = (double) r4
            double r8 = r8 * r12
            double r7 = r18 + r8
            int r9 = r0.f30090i
            r22 = r1
            double r0 = (double) r9
            double r0 = r0 * r10
            double r7 = r7 - r0
            double r0 = (double) r4
            double r0 = r0 * r10
            double r0 = r0 + r2
            r23 = r5
            double r4 = (double) r9
            double r4 = r4 * r12
            double r0 = r0 + r4
            double r4 = (double) r9
            double r4 = r4 * r10
            double r4 = r18 - r4
            double r9 = (double) r9
            double r9 = r9 * r12
            double r9 = r9 + r2
            r11 = r18
            r18 = r9
            double r9 = java.lang.Math.max(r11, r14)
            double r9 = java.lang.Math.max(r7, r9)
            double r9 = java.lang.Math.max(r4, r9)
            double r11 = java.lang.Math.min(r11, r14)
            double r6 = java.lang.Math.min(r7, r11)
            double r4 = java.lang.Math.min(r4, r6)
            r6 = r23
            double r11 = java.lang.Math.max(r2, r6)
            double r11 = java.lang.Math.max(r0, r11)
            r13 = r18
            double r11 = java.lang.Math.max(r13, r11)
            double r2 = java.lang.Math.min(r2, r6)
            double r0 = java.lang.Math.min(r0, r2)
            double r0 = java.lang.Math.min(r13, r0)
            double r9 = r9 - r4
            double r2 = java.lang.Math.floor(r9)
            int r4 = (int) r2
            double r11 = r11 - r0
            double r0 = java.lang.Math.floor(r11)
            int r6 = (int) r0
            r0 = r20
            goto L_0x0137
        L_0x00c9:
            r22 = r1
            r16 = r2
            r17 = r3
            r0 = r9
            r0.setRotate(r7)
            r1 = r26
            int r2 = r1.f30089h
            double r3 = (double) r2
            double r3 = r3 * r12
            double r5 = (double) r2
            double r5 = r5 * r10
            double r7 = (double) r2
            double r7 = r7 * r12
            int r9 = r1.f30090i
            double r14 = (double) r9
            double r14 = r14 * r10
            double r7 = r7 - r14
            double r14 = (double) r2
            double r14 = r14 * r10
            double r1 = (double) r9
            double r1 = r1 * r12
            double r14 = r14 + r1
            double r1 = (double) r9
            double r1 = r1 * r10
            double r1 = -r1
            double r9 = (double) r9
            double r9 = r9 * r12
            r11 = 0
            r18 = r9
            double r9 = java.lang.Math.max(r11, r3)
            double r9 = java.lang.Math.max(r7, r9)
            double r9 = java.lang.Math.max(r1, r9)
            double r3 = java.lang.Math.min(r11, r3)
            double r3 = java.lang.Math.min(r7, r3)
            double r1 = java.lang.Math.min(r1, r3)
            double r3 = java.lang.Math.max(r11, r5)
            double r3 = java.lang.Math.max(r14, r3)
            r7 = r18
            double r3 = java.lang.Math.max(r7, r3)
            double r5 = java.lang.Math.min(r11, r5)
            double r5 = java.lang.Math.min(r14, r5)
            double r5 = java.lang.Math.min(r7, r5)
            double r9 = r9 - r1
            double r1 = java.lang.Math.floor(r9)
            int r1 = (int) r1
            double r3 = r3 - r5
            double r2 = java.lang.Math.floor(r3)
            int r6 = (int) r2
            r4 = r1
            goto L_0x0137
        L_0x0130:
            r22 = r1
            r16 = r2
            r17 = r3
            r0 = r9
        L_0x0137:
            if (r28 == 0) goto L_0x015d
            int r1 = l(r28)
            int r2 = m(r28)
            if (r1 == 0) goto L_0x0154
            float r3 = (float) r1
            r0.preRotate(r3)
            r3 = 90
            if (r1 == r3) goto L_0x014f
            r3 = 270(0x10e, float:3.78E-43)
            if (r1 != r3) goto L_0x0154
        L_0x014f:
            r25 = r6
            r6 = r4
            r4 = r25
        L_0x0154:
            r1 = 1
            if (r2 == r1) goto L_0x015d
            float r1 = (float) r2
            r2 = 1065353216(0x3f800000, float:1.0)
            r0.postScale(r1, r2)
        L_0x015d:
            r1 = r26
            boolean r2 = r1.f30091j
            if (r2 == 0) goto L_0x01f0
            if (r4 == 0) goto L_0x016d
            float r2 = (float) r4
            r3 = r22
            float r5 = (float) r3
            float r2 = r2 / r5
            r5 = r16
            goto L_0x0174
        L_0x016d:
            r3 = r22
            float r2 = (float) r6
            r5 = r16
            float r7 = (float) r5
            float r2 = r2 / r7
        L_0x0174:
            if (r6 == 0) goto L_0x0179
            float r7 = (float) r6
            float r8 = (float) r5
            goto L_0x017b
        L_0x0179:
            float r7 = (float) r4
            float r8 = (float) r3
        L_0x017b:
            float r7 = r7 / r8
            int r8 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r8 <= 0) goto L_0x01aa
            float r8 = (float) r5
            float r7 = r7 / r2
            float r8 = r8 * r7
            double r7 = (double) r8
            double r7 = java.lang.Math.ceil(r7)
            int r7 = (int) r7
            int r1 = r1.f30092k
            r8 = r1 & 48
            r9 = 48
            if (r8 != r9) goto L_0x0193
            r1 = 0
            goto L_0x019f
        L_0x0193:
            r8 = 80
            r1 = r1 & r8
            if (r1 != r8) goto L_0x019b
            int r1 = r5 - r7
            goto L_0x019f
        L_0x019b:
            int r1 = r5 - r7
            int r1 = r1 / 2
        L_0x019f:
            float r8 = (float) r6
            float r9 = (float) r7
            float r8 = r8 / r9
            r9 = r7
            r10 = r17
            r21 = 0
            r7 = r1
            r1 = r3
            goto L_0x01e1
        L_0x01aa:
            int r8 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r8 >= 0) goto L_0x01d8
            float r8 = (float) r3
            float r2 = r2 / r7
            float r8 = r8 * r2
            double r8 = (double) r8
            double r8 = java.lang.Math.ceil(r8)
            int r2 = (int) r8
            int r1 = r1.f30092k
            r8 = r1 & 3
            r9 = 3
            if (r8 != r9) goto L_0x01c0
            r1 = 0
            goto L_0x01cb
        L_0x01c0:
            r8 = 5
            r1 = r1 & r8
            if (r1 != r8) goto L_0x01c7
            int r1 = r3 - r2
            goto L_0x01cb
        L_0x01c7:
            int r1 = r3 - r2
            int r1 = r1 / 2
        L_0x01cb:
            float r8 = (float) r4
            float r9 = (float) r2
            float r8 = r8 / r9
            r21 = r1
            r1 = r2
            r9 = r5
            r2 = r8
            r10 = r17
            r8 = r7
            r7 = 0
            goto L_0x01e1
        L_0x01d8:
            r1 = r3
            r9 = r5
            r2 = r7
            r8 = r2
            r10 = r17
            r7 = 0
            r21 = 0
        L_0x01e1:
            boolean r3 = v(r10, r3, r5, r4, r6)
            if (r3 == 0) goto L_0x01ea
            r0.preScale(r2, r8)
        L_0x01ea:
            r6 = r7
            r8 = r9
            r5 = r21
            r7 = r1
            goto L_0x023f
        L_0x01f0:
            r5 = r16
            r10 = r17
            r3 = r22
            boolean r1 = r1.f30093l
            if (r1 == 0) goto L_0x021a
            if (r4 == 0) goto L_0x01ff
            float r1 = (float) r4
            float r2 = (float) r3
            goto L_0x0201
        L_0x01ff:
            float r1 = (float) r6
            float r2 = (float) r5
        L_0x0201:
            float r1 = r1 / r2
            if (r6 == 0) goto L_0x0207
            float r2 = (float) r6
            float r7 = (float) r5
            goto L_0x0209
        L_0x0207:
            float r2 = (float) r4
            float r7 = (float) r3
        L_0x0209:
            float r2 = r2 / r7
            int r7 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r7 >= 0) goto L_0x020f
            goto L_0x0210
        L_0x020f:
            r1 = r2
        L_0x0210:
            boolean r2 = v(r10, r3, r5, r4, r6)
            if (r2 == 0) goto L_0x023b
            r0.preScale(r1, r1)
            goto L_0x023b
        L_0x021a:
            if (r4 != 0) goto L_0x021e
            if (r6 == 0) goto L_0x023b
        L_0x021e:
            if (r4 != r3) goto L_0x0222
            if (r6 == r5) goto L_0x023b
        L_0x0222:
            if (r4 == 0) goto L_0x0227
            float r1 = (float) r4
            float r2 = (float) r3
            goto L_0x0229
        L_0x0227:
            float r1 = (float) r6
            float r2 = (float) r5
        L_0x0229:
            float r1 = r1 / r2
            if (r6 == 0) goto L_0x022f
            float r2 = (float) r6
            float r7 = (float) r5
            goto L_0x0231
        L_0x022f:
            float r2 = (float) r4
            float r7 = (float) r3
        L_0x0231:
            float r2 = r2 / r7
            boolean r4 = v(r10, r3, r5, r4, r6)
            if (r4 == 0) goto L_0x023b
            r0.preScale(r1, r2)
        L_0x023b:
            r7 = r3
            r8 = r5
            r5 = 0
            r6 = 0
        L_0x023f:
            r10 = 1
            r4 = r27
            r9 = r0
            android.graphics.Bitmap r0 = android.graphics.Bitmap.createBitmap(r4, r5, r6, r7, r8, r9, r10)
            r1 = r27
            if (r0 == r1) goto L_0x024f
            r27.recycle()
            goto L_0x0250
        L_0x024f:
            r0 = r1
        L_0x0250:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.picasso.c.y(com.squareup.picasso.q, android.graphics.Bitmap, int):android.graphics.Bitmap");
    }

    public static void z(q qVar) {
        String a11 = qVar.a();
        StringBuilder sb2 = f30004v.get();
        sb2.ensureCapacity(a11.length() + 8);
        sb2.replace(8, sb2.length(), a11);
        Thread.currentThread().setName(sb2.toString());
    }

    public void b(a aVar) {
        boolean z11 = this.f30008c.f29964n;
        q qVar = aVar.f29987b;
        if (this.f30017l == null) {
            this.f30017l = aVar;
            if (z11) {
                List<a> list = this.f30018m;
                if (list == null || list.isEmpty()) {
                    y.t("Hunter", "joined", qVar.d(), "to empty hunter");
                } else {
                    y.t("Hunter", "joined", qVar.d(), y.k(this, "to "));
                }
            }
        } else {
            if (this.f30018m == null) {
                this.f30018m = new ArrayList(3);
            }
            this.f30018m.add(aVar);
            if (z11) {
                y.t("Hunter", "joined", qVar.d(), y.k(this, "to "));
            }
            Picasso.Priority h11 = aVar.h();
            if (h11.ordinal() > this.f30025t.ordinal()) {
                this.f30025t = h11;
            }
        }
    }

    public boolean c() {
        Future<?> future;
        if (this.f30017l != null) {
            return false;
        }
        List<a> list = this.f30018m;
        if ((list == null || list.isEmpty()) && (future = this.f30020o) != null && future.cancel(false)) {
            return true;
        }
        return false;
    }

    public final Picasso.Priority d() {
        Picasso.Priority priority = Picasso.Priority.LOW;
        List<a> list = this.f30018m;
        boolean z11 = true;
        boolean z12 = list != null && !list.isEmpty();
        a aVar = this.f30017l;
        if (aVar == null && !z12) {
            z11 = false;
        }
        if (!z11) {
            return priority;
        }
        if (aVar != null) {
            priority = aVar.h();
        }
        if (z12) {
            int size = this.f30018m.size();
            for (int i11 = 0; i11 < size; i11++) {
                Picasso.Priority h11 = this.f30018m.get(i11).h();
                if (h11.ordinal() > priority.ordinal()) {
                    priority = h11;
                }
            }
        }
        return priority;
    }

    public void f(a aVar) {
        boolean z11;
        if (this.f30017l == aVar) {
            this.f30017l = null;
            z11 = true;
        } else {
            List<a> list = this.f30018m;
            z11 = list != null ? list.remove(aVar) : false;
        }
        if (z11 && aVar.h() == this.f30025t) {
            this.f30025t = d();
        }
        if (this.f30008c.f29964n) {
            y.t("Hunter", "removed", aVar.f29987b.d(), y.k(this, "from "));
        }
    }

    public a h() {
        return this.f30017l;
    }

    public List<a> i() {
        return this.f30018m;
    }

    public q j() {
        return this.f30013h;
    }

    public Exception k() {
        return this.f30022q;
    }

    public String n() {
        return this.f30012g;
    }

    public Picasso.LoadedFrom o() {
        return this.f30021p;
    }

    public int p() {
        return this.f30014i;
    }

    public Picasso q() {
        return this.f30008c;
    }

    public Picasso.Priority r() {
        return this.f30025t;
    }

    public void run() {
        try {
            z(this.f30013h);
            if (this.f30008c.f29964n) {
                y.s("Hunter", "executing", y.j(this));
            }
            Bitmap t11 = t();
            this.f30019n = t11;
            if (t11 == null) {
                this.f30009d.e(this);
            } else {
                this.f30009d.d(this);
            }
        } catch (NetworkRequestHandler.ResponseException e11) {
            if (!NetworkPolicy.isOfflineOnly(e11.networkPolicy) || e11.code != 504) {
                this.f30022q = e11;
            }
            this.f30009d.e(this);
        } catch (IOException e12) {
            this.f30022q = e12;
            this.f30009d.g(this);
        } catch (OutOfMemoryError e13) {
            StringWriter stringWriter = new StringWriter();
            this.f30011f.a().a(new PrintWriter(stringWriter));
            this.f30022q = new RuntimeException(stringWriter.toString(), e13);
            this.f30009d.e(this);
        } catch (Exception e14) {
            this.f30022q = e14;
            this.f30009d.e(this);
        } catch (Throwable th2) {
            Thread.currentThread().setName("Picasso-Idle");
            throw th2;
        }
        Thread.currentThread().setName("Picasso-Idle");
    }

    public Bitmap s() {
        return this.f30019n;
    }

    public Bitmap t() throws IOException {
        Bitmap bitmap;
        if (MemoryPolicy.shouldReadFromMemoryCache(this.f30014i)) {
            bitmap = this.f30010e.get(this.f30012g);
            if (bitmap != null) {
                this.f30011f.d();
                this.f30021p = Picasso.LoadedFrom.MEMORY;
                if (this.f30008c.f29964n) {
                    y.t("Hunter", "decoded", this.f30013h.d(), "from cache");
                }
                return bitmap;
            }
        } else {
            bitmap = null;
        }
        int i11 = this.f30024s == 0 ? NetworkPolicy.OFFLINE.index : this.f30015j;
        this.f30015j = i11;
        RequestHandler.a f11 = this.f30016k.f(this.f30013h, i11);
        if (f11 != null) {
            this.f30021p = f11.c();
            this.f30023r = f11.b();
            bitmap = f11.a();
            if (bitmap == null) {
                Source d11 = f11.d();
                try {
                    bitmap = e(d11, this.f30013h);
                } finally {
                    try {
                        d11.close();
                    } catch (IOException unused) {
                    }
                }
            }
        }
        if (bitmap != null) {
            if (this.f30008c.f29964n) {
                y.s("Hunter", "decoded", this.f30013h.d());
            }
            this.f30011f.b(bitmap);
            if (this.f30013h.f() || this.f30023r != 0) {
                synchronized (f30003u) {
                    if (this.f30013h.e() || this.f30023r != 0) {
                        bitmap = y(this.f30013h, bitmap, this.f30023r);
                        if (this.f30008c.f29964n) {
                            y.s("Hunter", "transformed", this.f30013h.d());
                        }
                    }
                    if (this.f30013h.b()) {
                        bitmap = a(this.f30013h.f30088g, bitmap);
                        if (this.f30008c.f29964n) {
                            y.t("Hunter", "transformed", this.f30013h.d(), "from custom transformations");
                        }
                    }
                }
                if (bitmap != null) {
                    this.f30011f.c(bitmap);
                }
            }
        }
        return bitmap;
    }

    public boolean u() {
        Future<?> future = this.f30020o;
        return future != null && future.isCancelled();
    }

    public boolean w(boolean z11, NetworkInfo networkInfo) {
        int i11 = this.f30024s;
        if (!(i11 > 0)) {
            return false;
        }
        this.f30024s = i11 - 1;
        return this.f30016k.h(z11, networkInfo);
    }

    public boolean x() {
        return this.f30016k.i();
    }
}
