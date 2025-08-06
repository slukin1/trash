package com.bumptech.glide;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.widget.ImageView;
import c4.g;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestCoordinator;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.SingleRequest;
import com.bumptech.glide.request.b;
import com.bumptech.glide.request.e;
import f4.d;
import f4.h;
import f4.i;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

public class c<TranscodeType> extends BaseRequestOptions<c<TranscodeType>> {
    public static final RequestOptions P = ((RequestOptions) ((RequestOptions) ((RequestOptions) new RequestOptions().h(DiskCacheStrategy.f63711c)).c0(Priority.LOW)).k0(true));
    public final Context B;
    public final d C;
    public final Class<TranscodeType> D;
    public final a E;
    public final b F;
    public TransitionOptions<?, ? super TranscodeType> G;
    public Object H;
    public List<e<TranscodeType>> I;
    public c<TranscodeType> J;
    public c<TranscodeType> K;
    public Float L;
    public boolean M = true;
    public boolean N;
    public boolean O;

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f63617a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f63618b;

        /* JADX WARNING: Can't wrap try/catch for region: R(27:0|(2:1|2)|3|(2:5|6)|7|9|10|11|(2:13|14)|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|34) */
        /* JADX WARNING: Can't wrap try/catch for region: R(29:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|34) */
        /* JADX WARNING: Can't wrap try/catch for region: R(30:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|34) */
        /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0044 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x004e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0058 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0062 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x006d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0083 */
        static {
            /*
                com.bumptech.glide.Priority[] r0 = com.bumptech.glide.Priority.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f63618b = r0
                r1 = 1
                com.bumptech.glide.Priority r2 = com.bumptech.glide.Priority.LOW     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f63618b     // Catch:{ NoSuchFieldError -> 0x001d }
                com.bumptech.glide.Priority r3 = com.bumptech.glide.Priority.NORMAL     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f63618b     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.bumptech.glide.Priority r4 = com.bumptech.glide.Priority.HIGH     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = f63618b     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.bumptech.glide.Priority r5 = com.bumptech.glide.Priority.IMMEDIATE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                android.widget.ImageView$ScaleType[] r4 = android.widget.ImageView.ScaleType.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                f63617a = r4
                android.widget.ImageView$ScaleType r5 = android.widget.ImageView.ScaleType.CENTER_CROP     // Catch:{ NoSuchFieldError -> 0x0044 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0044 }
                r4[r5] = r1     // Catch:{ NoSuchFieldError -> 0x0044 }
            L_0x0044:
                int[] r1 = f63617a     // Catch:{ NoSuchFieldError -> 0x004e }
                android.widget.ImageView$ScaleType r4 = android.widget.ImageView.ScaleType.CENTER_INSIDE     // Catch:{ NoSuchFieldError -> 0x004e }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r1[r4] = r0     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                int[] r0 = f63617a     // Catch:{ NoSuchFieldError -> 0x0058 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_CENTER     // Catch:{ NoSuchFieldError -> 0x0058 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0058 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0058 }
            L_0x0058:
                int[] r0 = f63617a     // Catch:{ NoSuchFieldError -> 0x0062 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_START     // Catch:{ NoSuchFieldError -> 0x0062 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0062 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0062 }
            L_0x0062:
                int[] r0 = f63617a     // Catch:{ NoSuchFieldError -> 0x006d }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_END     // Catch:{ NoSuchFieldError -> 0x006d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006d }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006d }
            L_0x006d:
                int[] r0 = f63617a     // Catch:{ NoSuchFieldError -> 0x0078 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_XY     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f63617a     // Catch:{ NoSuchFieldError -> 0x0083 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.CENTER     // Catch:{ NoSuchFieldError -> 0x0083 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0083 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0083 }
            L_0x0083:
                int[] r0 = f63617a     // Catch:{ NoSuchFieldError -> 0x008f }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.MATRIX     // Catch:{ NoSuchFieldError -> 0x008f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x008f }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x008f }
            L_0x008f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.c.a.<clinit>():void");
        }
    }

    @SuppressLint({"CheckResult"})
    public c(a aVar, d dVar, Class<TranscodeType> cls, Context context) {
        this.E = aVar;
        this.C = dVar;
        this.D = cls;
        this.B = context;
        this.G = dVar.k(cls);
        this.F = aVar.j();
        z0(dVar.i());
        b(dVar.j());
    }

    public <Y extends g<TranscodeType>> Y A0(Y y11) {
        return C0(y11, (e) null, d.b());
    }

    public final <Y extends g<TranscodeType>> Y B0(Y y11, e<TranscodeType> eVar, BaseRequestOptions<?> baseRequestOptions, Executor executor) {
        h.d(y11);
        if (this.N) {
            com.bumptech.glide.request.c t02 = t0(y11, eVar, baseRequestOptions, executor);
            com.bumptech.glide.request.c request = y11.getRequest();
            if (!t02.f(request) || F0(baseRequestOptions, request)) {
                this.C.g(y11);
                y11.setRequest(t02);
                this.C.x(y11, t02);
                return y11;
            }
            if (!((com.bumptech.glide.request.c) h.d(request)).isRunning()) {
                request.h();
            }
            return y11;
        }
        throw new IllegalArgumentException("You must call #load() before calling #into()");
    }

    public <Y extends g<TranscodeType>> Y C0(Y y11, e<TranscodeType> eVar, Executor executor) {
        return B0(y11, eVar, this, executor);
    }

    public c4.h<ImageView, TranscodeType> D0(ImageView imageView) {
        BaseRequestOptions baseRequestOptions;
        i.b();
        h.d(imageView);
        if (!Q() && O() && imageView.getScaleType() != null) {
            switch (a.f63617a[imageView.getScaleType().ordinal()]) {
                case 1:
                    baseRequestOptions = clone().T();
                    break;
                case 2:
                    baseRequestOptions = clone().U();
                    break;
                case 3:
                case 4:
                case 5:
                    baseRequestOptions = clone().V();
                    break;
                case 6:
                    baseRequestOptions = clone().U();
                    break;
            }
        }
        baseRequestOptions = this;
        return (c4.h) B0(this.F.a(imageView, this.D), (e) null, baseRequestOptions, d.b());
    }

    @Deprecated
    public b<TranscodeType> E0(int i11, int i12) {
        return S0(i11, i12);
    }

    public final boolean F0(BaseRequestOptions<?> baseRequestOptions, com.bumptech.glide.request.c cVar) {
        return !baseRequestOptions.J() && cVar.isComplete();
    }

    public c<TranscodeType> G0(e<TranscodeType> eVar) {
        this.I = null;
        return r0(eVar);
    }

    public c<TranscodeType> H0(Bitmap bitmap) {
        return N0(bitmap).b(RequestOptions.t0(DiskCacheStrategy.f63710b));
    }

    public c<TranscodeType> I0(Uri uri) {
        return N0(uri);
    }

    public c<TranscodeType> J0(File file) {
        return N0(file);
    }

    public c<TranscodeType> K0(Integer num) {
        return N0(num).b(RequestOptions.u0(e4.a.a(this.B)));
    }

    public c<TranscodeType> L0(Object obj) {
        return N0(obj);
    }

    public c<TranscodeType> M0(String str) {
        return N0(str);
    }

    public final c<TranscodeType> N0(Object obj) {
        this.H = obj;
        this.N = true;
        return this;
    }

    public final com.bumptech.glide.request.c O0(Object obj, g<TranscodeType> gVar, e<TranscodeType> eVar, BaseRequestOptions<?> baseRequestOptions, RequestCoordinator requestCoordinator, TransitionOptions<?, ? super TranscodeType> transitionOptions, Priority priority, int i11, int i12, Executor executor) {
        Context context = this.B;
        b bVar = this.F;
        return SingleRequest.w(context, bVar, obj, this.H, this.D, baseRequestOptions, i11, i12, priority, gVar, eVar, this.I, requestCoordinator, bVar.f(), transitionOptions.c(), executor);
    }

    public g<TranscodeType> P0() {
        return Q0(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    public g<TranscodeType> Q0(int i11, int i12) {
        return A0(c4.e.b(this.C, i11, i12));
    }

    public b<TranscodeType> R0() {
        return S0(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    public b<TranscodeType> S0(int i11, int i12) {
        com.bumptech.glide.request.d dVar = new com.bumptech.glide.request.d(i11, i12);
        return (b) C0(dVar, dVar, d.a());
    }

    public c<TranscodeType> T0(c<TranscodeType> cVar) {
        this.J = cVar;
        return this;
    }

    public c<TranscodeType> r0(e<TranscodeType> eVar) {
        if (eVar != null) {
            if (this.I == null) {
                this.I = new ArrayList();
            }
            this.I.add(eVar);
        }
        return this;
    }

    /* renamed from: s0 */
    public c<TranscodeType> b(BaseRequestOptions<?> baseRequestOptions) {
        h.d(baseRequestOptions);
        return (c) super.b(baseRequestOptions);
    }

    public final com.bumptech.glide.request.c t0(g<TranscodeType> gVar, e<TranscodeType> eVar, BaseRequestOptions<?> baseRequestOptions, Executor executor) {
        return u0(new Object(), gVar, eVar, (RequestCoordinator) null, this.G, baseRequestOptions.B(), baseRequestOptions.y(), baseRequestOptions.x(), baseRequestOptions, executor);
    }

    public final com.bumptech.glide.request.c u0(Object obj, g<TranscodeType> gVar, e<TranscodeType> eVar, RequestCoordinator requestCoordinator, TransitionOptions<?, ? super TranscodeType> transitionOptions, Priority priority, int i11, int i12, BaseRequestOptions<?> baseRequestOptions, Executor executor) {
        com.bumptech.glide.request.a aVar;
        com.bumptech.glide.request.a aVar2;
        if (this.K != null) {
            aVar2 = new com.bumptech.glide.request.a(obj, requestCoordinator);
            aVar = aVar2;
        } else {
            Object obj2 = obj;
            aVar = null;
            aVar2 = requestCoordinator;
        }
        com.bumptech.glide.request.c v02 = v0(obj, gVar, eVar, aVar2, transitionOptions, priority, i11, i12, baseRequestOptions, executor);
        if (aVar == null) {
            return v02;
        }
        int y11 = this.K.y();
        int x11 = this.K.x();
        if (i.t(i11, i12) && !this.K.R()) {
            y11 = baseRequestOptions.y();
            x11 = baseRequestOptions.x();
        }
        c<TranscodeType> cVar = this.K;
        com.bumptech.glide.request.a aVar3 = aVar;
        aVar3.n(v02, cVar.u0(obj, gVar, eVar, aVar3, cVar.G, cVar.B(), y11, x11, this.K, executor));
        return aVar3;
    }

    /* JADX WARNING: type inference failed for: r27v0, types: [com.bumptech.glide.request.BaseRequestOptions<?>, com.bumptech.glide.request.BaseRequestOptions] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.bumptech.glide.request.c v0(java.lang.Object r19, c4.g<TranscodeType> r20, com.bumptech.glide.request.e<TranscodeType> r21, com.bumptech.glide.request.RequestCoordinator r22, com.bumptech.glide.TransitionOptions<?, ? super TranscodeType> r23, com.bumptech.glide.Priority r24, int r25, int r26, com.bumptech.glide.request.BaseRequestOptions<?> r27, java.util.concurrent.Executor r28) {
        /*
            r18 = this;
            r11 = r18
            r12 = r19
            r5 = r22
            r13 = r24
            com.bumptech.glide.c<TranscodeType> r0 = r11.J
            if (r0 == 0) goto L_0x0094
            boolean r1 = r11.O
            if (r1 != 0) goto L_0x008c
            com.bumptech.glide.TransitionOptions<?, ? super TranscodeType> r1 = r0.G
            boolean r2 = r0.M
            if (r2 == 0) goto L_0x0019
            r14 = r23
            goto L_0x001a
        L_0x0019:
            r14 = r1
        L_0x001a:
            boolean r0 = r0.K()
            if (r0 == 0) goto L_0x0027
            com.bumptech.glide.c<TranscodeType> r0 = r11.J
            com.bumptech.glide.Priority r0 = r0.B()
            goto L_0x002b
        L_0x0027:
            com.bumptech.glide.Priority r0 = r11.y0(r13)
        L_0x002b:
            r15 = r0
            com.bumptech.glide.c<TranscodeType> r0 = r11.J
            int r0 = r0.y()
            com.bumptech.glide.c<TranscodeType> r1 = r11.J
            int r1 = r1.x()
            boolean r2 = f4.i.t(r25, r26)
            if (r2 == 0) goto L_0x004e
            com.bumptech.glide.c<TranscodeType> r2 = r11.J
            boolean r2 = r2.R()
            if (r2 != 0) goto L_0x004e
            int r0 = r27.y()
            int r1 = r27.x()
        L_0x004e:
            r16 = r0
            r17 = r1
            com.bumptech.glide.request.g r10 = new com.bumptech.glide.request.g
            r10.<init>(r12, r5)
            r0 = r18
            r1 = r19
            r2 = r20
            r3 = r21
            r4 = r27
            r5 = r10
            r6 = r23
            r7 = r24
            r8 = r25
            r9 = r26
            r13 = r10
            r10 = r28
            com.bumptech.glide.request.c r10 = r0.O0(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r0 = 1
            r11.O = r0
            com.bumptech.glide.c<TranscodeType> r9 = r11.J
            r0 = r9
            r4 = r13
            r5 = r14
            r6 = r15
            r7 = r16
            r8 = r17
            r12 = r10
            r10 = r28
            com.bumptech.glide.request.c r0 = r0.u0(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r1 = 0
            r11.O = r1
            r13.m(r12, r0)
            return r13
        L_0x008c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()"
            r0.<init>(r1)
            throw r0
        L_0x0094:
            java.lang.Float r0 = r11.L
            if (r0 == 0) goto L_0x00d4
            com.bumptech.glide.request.g r14 = new com.bumptech.glide.request.g
            r14.<init>(r12, r5)
            r0 = r18
            r1 = r19
            r2 = r20
            r3 = r21
            r4 = r27
            r5 = r14
            r6 = r23
            r7 = r24
            r8 = r25
            r9 = r26
            r10 = r28
            com.bumptech.glide.request.c r15 = r0.O0(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            com.bumptech.glide.request.BaseRequestOptions r0 = r27.clone()
            java.lang.Float r1 = r11.L
            float r1 = r1.floatValue()
            com.bumptech.glide.request.BaseRequestOptions r4 = r0.j0(r1)
            com.bumptech.glide.Priority r7 = r11.y0(r13)
            r0 = r18
            r1 = r19
            com.bumptech.glide.request.c r0 = r0.O0(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r14.m(r15, r0)
            return r14
        L_0x00d4:
            r0 = r18
            r1 = r19
            r2 = r20
            r3 = r21
            r4 = r27
            r5 = r22
            r6 = r23
            r7 = r24
            r8 = r25
            r9 = r26
            r10 = r28
            com.bumptech.glide.request.c r0 = r0.O0(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.c.v0(java.lang.Object, c4.g, com.bumptech.glide.request.e, com.bumptech.glide.request.RequestCoordinator, com.bumptech.glide.TransitionOptions, com.bumptech.glide.Priority, int, int, com.bumptech.glide.request.BaseRequestOptions, java.util.concurrent.Executor):com.bumptech.glide.request.c");
    }

    /* renamed from: w0 */
    public c<TranscodeType> f() {
        c<TranscodeType> cVar = (c) super.clone();
        cVar.G = cVar.G.clone();
        return cVar;
    }

    public c<TranscodeType> x0(c<TranscodeType> cVar) {
        this.K = cVar;
        return this;
    }

    public final Priority y0(Priority priority) {
        int i11 = a.f63618b[priority.ordinal()];
        if (i11 == 1) {
            return Priority.NORMAL;
        }
        if (i11 == 2) {
            return Priority.HIGH;
        }
        if (i11 == 3 || i11 == 4) {
            return Priority.IMMEDIATE;
        }
        throw new IllegalArgumentException("unknown priority: " + B());
    }

    @SuppressLint({"CheckResult"})
    public final void z0(List<e<Object>> list) {
        for (e<Object> r02 : list) {
            r0(r02);
        }
    }
}
