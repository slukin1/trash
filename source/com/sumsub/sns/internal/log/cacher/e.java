package com.sumsub.sns.internal.log.cacher;

import d10.p;
import java.io.File;
import kotlin.Unit;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.internal.r;
import kotlinx.coroutines.g;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.v0;

public final class e<T> implements b, c<T> {

    /* renamed from: d  reason: collision with root package name */
    public static final a f34879d = new a((r) null);

    /* renamed from: e  reason: collision with root package name */
    public static final String f34880e = "SinkWrapper";

    /* renamed from: a  reason: collision with root package name */
    public final a<T> f34881a;

    /* renamed from: b  reason: collision with root package name */
    public File f34882b;

    /* renamed from: c  reason: collision with root package name */
    public String f34883c = "";

    public static final class a {
        public /* synthetic */ a(r rVar) {
            this();
        }

        public a() {
        }
    }

    @d(c = "com.sumsub.sns.internal.log.cacher.SinkWrapper$processDir$2", f = "SinkCache.kt", l = {69}, m = "invokeSuspend")
    public static final class b extends SuspendLambda implements p<h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public Object f34884a;

        /* renamed from: b  reason: collision with root package name */
        public Object f34885b;

        /* renamed from: c  reason: collision with root package name */
        public Object f34886c;

        /* renamed from: d  reason: collision with root package name */
        public Object f34887d;

        /* renamed from: e  reason: collision with root package name */
        public Object f34888e;

        /* renamed from: f  reason: collision with root package name */
        public int f34889f;

        /* renamed from: g  reason: collision with root package name */
        public int f34890g;

        /* renamed from: h  reason: collision with root package name */
        public int f34891h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e<T> f34892i;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(e<T> eVar, kotlin.coroutines.c<? super b> cVar) {
            super(2, cVar);
            this.f34892i = eVar;
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((b) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new b(this.f34892i, cVar);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v33, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v15, resolved type: java.io.File} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v34, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v13, resolved type: java.io.File[]} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v35, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v10, resolved type: com.sumsub.sns.internal.log.cacher.e<T>} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v37, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v13, resolved type: kotlin.jvm.internal.Ref$IntRef} */
        /* JADX WARNING: type inference failed for: r3v0 */
        /* JADX WARNING: type inference failed for: r3v3 */
        /* JADX WARNING: type inference failed for: r3v8, types: [kotlin.jvm.internal.r, java.util.Random] */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:34|35|36|37|39|40|(1:42)|43) */
        /* JADX WARNING: Code restructure failed: missing block: B:59:0x021b, code lost:
            r0 = e;
         */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x010b A[SYNTHETIC, Splitter:B:34:0x010b] */
        /* JADX WARNING: Removed duplicated region for block: B:53:0x0199 A[SYNTHETIC, Splitter:B:53:0x0199] */
        /* JADX WARNING: Removed duplicated region for block: B:55:0x01d3 A[Catch:{ Exception -> 0x020f }] */
        /* JADX WARNING: Removed duplicated region for block: B:63:0x0254 A[Catch:{ all -> 0x02d1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:64:0x0256 A[Catch:{ all -> 0x02d1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:66:0x0259 A[Catch:{ all -> 0x02d1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:67:0x025a A[Catch:{ all -> 0x02d1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:69:0x025d A[Catch:{ all -> 0x02d1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:72:0x027d A[Catch:{ all -> 0x02d1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:75:0x0282 A[Catch:{ all -> 0x02d1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:80:0x02ac  */
        /* JADX WARNING: Removed duplicated region for block: B:88:0x02d9  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r29) {
            /*
                r28 = this;
                r1 = r28
                java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                int r0 = r1.f34891h
                r3 = 0
                r5 = 1
                java.lang.String r6 = "SinkWrapper"
                if (r0 == 0) goto L_0x0043
                if (r0 != r5) goto L_0x003b
                int r7 = r1.f34890g
                int r8 = r1.f34889f
                java.lang.Object r0 = r1.f34888e
                r9 = r0
                java.io.File r9 = (java.io.File) r9
                java.lang.Object r0 = r1.f34887d
                r10 = r0
                java.io.File[] r10 = (java.io.File[]) r10
                java.lang.Object r0 = r1.f34886c
                r11 = r0
                com.sumsub.sns.internal.log.cacher.e r11 = (com.sumsub.sns.internal.log.cacher.e) r11
                java.lang.Object r0 = r1.f34885b
                r12 = r0
                java.io.File r12 = (java.io.File) r12
                java.lang.Object r0 = r1.f34884a
                r13 = r0
                kotlin.jvm.internal.Ref$IntRef r13 = (kotlin.jvm.internal.Ref$IntRef) r13
                kotlin.k.b(r29)     // Catch:{ Exception -> 0x0036 }
                r0 = r29
                r3 = r12
                r12 = r1
                goto L_0x018f
            L_0x0036:
                r0 = move-exception
                r3 = r12
                r12 = r1
                goto L_0x0210
            L_0x003b:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r0.<init>(r2)
                throw r0
            L_0x0043:
                kotlin.k.b(r29)
                kotlin.jvm.internal.Ref$IntRef r13 = new kotlin.jvm.internal.Ref$IntRef
                r13.<init>()
                com.sumsub.sns.internal.log.cacher.e<T> r0 = r1.f34892i     // Catch:{ all -> 0x02d3 }
                java.io.File r0 = r0.f34882b     // Catch:{ all -> 0x02d3 }
                if (r0 == 0) goto L_0x0283
                com.sumsub.sns.internal.log.cacher.e<T> r7 = r1.f34892i     // Catch:{ all -> 0x02d3 }
                boolean r8 = r0.isDirectory()     // Catch:{ all -> 0x02d3 }
                if (r8 != 0) goto L_0x00bc
                com.sumsub.sns.internal.log.a r2 = com.sumsub.sns.internal.log.a.f34862a     // Catch:{ all -> 0x02d3 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x02d3 }
                r3.<init>()     // Catch:{ all -> 0x02d3 }
                r3.append(r6)     // Catch:{ all -> 0x02d3 }
                java.lang.String r4 = r7.a()     // Catch:{ all -> 0x02d3 }
                r3.append(r4)     // Catch:{ all -> 0x02d3 }
                java.lang.String r15 = r3.toString()     // Catch:{ all -> 0x02d3 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x02d3 }
                r3.<init>()     // Catch:{ all -> 0x02d3 }
                java.lang.String r4 = "Cache directory "
                r3.append(r4)     // Catch:{ all -> 0x02d3 }
                java.lang.String r0 = r0.getAbsolutePath()     // Catch:{ all -> 0x02d3 }
                r3.append(r0)     // Catch:{ all -> 0x02d3 }
                java.lang.String r0 = " is not a directory"
                r3.append(r0)     // Catch:{ all -> 0x02d3 }
                java.lang.String r16 = r3.toString()     // Catch:{ all -> 0x02d3 }
                r17 = 0
                r18 = 4
                r19 = 0
                r14 = r2
                com.sumsub.log.logger.a.b(r14, r15, r16, r17, r18, r19)     // Catch:{ all -> 0x02d3 }
                kotlin.Unit r0 = kotlin.Unit.f56620a     // Catch:{ all -> 0x02d3 }
                int r3 = r13.element
                if (r3 <= 0) goto L_0x00bb
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                r3.append(r6)
                com.sumsub.sns.internal.log.cacher.e<T> r4 = r1.f34892i
                java.lang.String r4 = r4.a()
                r3.append(r4)
                java.lang.String r15 = r3.toString()
                r17 = 0
                r18 = 4
                r19 = 0
                java.lang.String r16 = "Done processing cache"
                r14 = r2
                com.sumsub.log.logger.a.c(r14, r15, r16, r17, r18, r19)
            L_0x00bb:
                return r0
            L_0x00bc:
                java.io.File[] r8 = r0.listFiles()     // Catch:{ all -> 0x02d3 }
                if (r8 == 0) goto L_0x00c4
                int r9 = r8.length     // Catch:{ all -> 0x02d3 }
                goto L_0x00c5
            L_0x00c4:
                r9 = 0
            L_0x00c5:
                r13.element = r9     // Catch:{ all -> 0x02d3 }
                if (r9 <= 0) goto L_0x00ff
                com.sumsub.sns.internal.log.a r14 = com.sumsub.sns.internal.log.a.f34862a     // Catch:{ all -> 0x02d3 }
                java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x02d3 }
                r9.<init>()     // Catch:{ all -> 0x02d3 }
                r9.append(r6)     // Catch:{ all -> 0x02d3 }
                java.lang.String r10 = r7.a()     // Catch:{ all -> 0x02d3 }
                r9.append(r10)     // Catch:{ all -> 0x02d3 }
                java.lang.String r15 = r9.toString()     // Catch:{ all -> 0x02d3 }
                java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x02d3 }
                r9.<init>()     // Catch:{ all -> 0x02d3 }
                java.lang.String r10 = "Processing cache ("
                r9.append(r10)     // Catch:{ all -> 0x02d3 }
                int r10 = r13.element     // Catch:{ all -> 0x02d3 }
                r9.append(r10)     // Catch:{ all -> 0x02d3 }
                java.lang.String r10 = " files) ... "
                r9.append(r10)     // Catch:{ all -> 0x02d3 }
                java.lang.String r16 = r9.toString()     // Catch:{ all -> 0x02d3 }
                r17 = 0
                r18 = 4
                r19 = 0
                com.sumsub.log.logger.a.c(r14, r15, r16, r17, r18, r19)     // Catch:{ all -> 0x02d3 }
            L_0x00ff:
                if (r8 == 0) goto L_0x027f
                int r9 = r8.length     // Catch:{ all -> 0x02d3 }
                r12 = r1
                r10 = r9
                r11 = 0
                r9 = r8
                r8 = r7
                r7 = r2
                r2 = r0
            L_0x0109:
                if (r11 >= r10) goto L_0x027d
                r14 = r9[r11]     // Catch:{ all -> 0x02d1 }
                com.sumsub.sns.internal.log.utils.a r0 = new com.sumsub.sns.internal.log.utils.a     // Catch:{ Exception -> 0x021b }
                r15 = 2
                r0.<init>(r14, r3, r15, r3)     // Catch:{ Exception -> 0x021b }
                byte[] r0 = r0.b()     // Catch:{ Exception -> 0x021b }
                if (r0 != 0) goto L_0x0165
                com.sumsub.sns.internal.log.a r0 = com.sumsub.sns.internal.log.a.f34862a     // Catch:{ Exception -> 0x021b }
                java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x021b }
                r15.<init>()     // Catch:{ Exception -> 0x021b }
                r15.append(r6)     // Catch:{ Exception -> 0x021b }
                java.lang.String r3 = r8.a()     // Catch:{ Exception -> 0x021b }
                r15.append(r3)     // Catch:{ Exception -> 0x021b }
                java.lang.String r16 = r15.toString()     // Catch:{ Exception -> 0x021b }
                java.lang.String r17 = "Can't restore cache value"
                r18 = 0
                r19 = 4
                r20 = 0
                r15 = r0
                com.sumsub.sns.internal.log.b.c(r15, r16, r17, r18, r19, r20)     // Catch:{ Exception -> 0x021b }
                r14.delete()     // Catch:{ Exception -> 0x021b }
                kotlin.Unit r2 = kotlin.Unit.f56620a     // Catch:{ Exception -> 0x021b }
                int r3 = r13.element
                if (r3 <= 0) goto L_0x0164
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                r3.append(r6)
                com.sumsub.sns.internal.log.cacher.e<T> r4 = r12.f34892i
                java.lang.String r4 = r4.a()
                r3.append(r4)
                java.lang.String r16 = r3.toString()
                r18 = 0
                r19 = 4
                r20 = 0
                java.lang.String r17 = "Done processing cache"
                r15 = r0
                com.sumsub.log.logger.a.c(r15, r16, r17, r18, r19, r20)
            L_0x0164:
                return r2
            L_0x0165:
                com.sumsub.sns.internal.log.cacher.a r3 = r8.f34881a     // Catch:{ Exception -> 0x021b }
                java.io.ByteArrayInputStream r15 = new java.io.ByteArrayInputStream     // Catch:{ Exception -> 0x021b }
                r15.<init>(r0)     // Catch:{ Exception -> 0x021b }
                r12.f34884a = r13     // Catch:{ Exception -> 0x021b }
                r12.f34885b = r2     // Catch:{ Exception -> 0x021b }
                r12.f34886c = r8     // Catch:{ Exception -> 0x021b }
                r12.f34887d = r9     // Catch:{ Exception -> 0x021b }
                r12.f34888e = r14     // Catch:{ Exception -> 0x021b }
                r12.f34889f = r11     // Catch:{ Exception -> 0x021b }
                r12.f34890g = r10     // Catch:{ Exception -> 0x021b }
                r12.f34891h = r5     // Catch:{ Exception -> 0x021b }
                java.lang.Object r0 = r3.a(r15, r12)     // Catch:{ Exception -> 0x021b }
                if (r0 != r7) goto L_0x0185
                return r7
            L_0x0185:
                r3 = r2
                r2 = r7
                r7 = r10
                r10 = r9
                r9 = r14
                r27 = r11
                r11 = r8
                r8 = r27
            L_0x018f:
                java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ Exception -> 0x020f }
                boolean r0 = r0.booleanValue()     // Catch:{ Exception -> 0x020f }
                java.lang.String r14 = "File "
                if (r0 == 0) goto L_0x01d3
                com.sumsub.sns.internal.log.a r15 = com.sumsub.sns.internal.log.a.f34862a     // Catch:{ Exception -> 0x020f }
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x020f }
                r0.<init>()     // Catch:{ Exception -> 0x020f }
                r0.append(r6)     // Catch:{ Exception -> 0x020f }
                java.lang.String r4 = r11.a()     // Catch:{ Exception -> 0x020f }
                r0.append(r4)     // Catch:{ Exception -> 0x020f }
                java.lang.String r16 = r0.toString()     // Catch:{ Exception -> 0x020f }
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x020f }
                r0.<init>()     // Catch:{ Exception -> 0x020f }
                r0.append(r14)     // Catch:{ Exception -> 0x020f }
                java.lang.String r4 = r9.getName()     // Catch:{ Exception -> 0x020f }
                r0.append(r4)     // Catch:{ Exception -> 0x020f }
                java.lang.String r4 = " is processed. Deleting..."
                r0.append(r4)     // Catch:{ Exception -> 0x020f }
                java.lang.String r17 = r0.toString()     // Catch:{ Exception -> 0x020f }
                r18 = 0
                r19 = 4
                r20 = 0
                com.sumsub.log.logger.a.c(r15, r16, r17, r18, r19, r20)     // Catch:{ Exception -> 0x020f }
                r9.delete()     // Catch:{ Exception -> 0x020f }
                goto L_0x0209
            L_0x01d3:
                com.sumsub.sns.internal.log.a r21 = com.sumsub.sns.internal.log.a.f34862a     // Catch:{ Exception -> 0x020f }
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x020f }
                r0.<init>()     // Catch:{ Exception -> 0x020f }
                r0.append(r6)     // Catch:{ Exception -> 0x020f }
                java.lang.String r4 = r11.a()     // Catch:{ Exception -> 0x020f }
                r0.append(r4)     // Catch:{ Exception -> 0x020f }
                java.lang.String r22 = r0.toString()     // Catch:{ Exception -> 0x020f }
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x020f }
                r0.<init>()     // Catch:{ Exception -> 0x020f }
                r0.append(r14)     // Catch:{ Exception -> 0x020f }
                java.lang.String r4 = r9.getName()     // Catch:{ Exception -> 0x020f }
                r0.append(r4)     // Catch:{ Exception -> 0x020f }
                java.lang.String r4 = " is not sent. Keep it."
                r0.append(r4)     // Catch:{ Exception -> 0x020f }
                java.lang.String r23 = r0.toString()     // Catch:{ Exception -> 0x020f }
                r24 = 0
                r25 = 4
                r26 = 0
                com.sumsub.log.logger.a.c(r21, r22, r23, r24, r25, r26)     // Catch:{ Exception -> 0x020f }
            L_0x0209:
                r9 = r10
                r10 = r7
                r7 = r2
                r2 = r3
                goto L_0x0276
            L_0x020f:
                r0 = move-exception
            L_0x0210:
                r14 = r9
                r9 = r10
                r10 = r7
                r7 = r2
                r2 = r3
                r27 = r11
                r11 = r8
                r8 = r27
                goto L_0x021c
            L_0x021b:
                r0 = move-exception
            L_0x021c:
                r14.delete()     // Catch:{ all -> 0x02d1 }
                com.sumsub.sns.internal.log.a r15 = com.sumsub.sns.internal.log.a.f34862a     // Catch:{ all -> 0x02d1 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x02d1 }
                r3.<init>()     // Catch:{ all -> 0x02d1 }
                r3.append(r6)     // Catch:{ all -> 0x02d1 }
                java.lang.String r4 = r8.a()     // Catch:{ all -> 0x02d1 }
                r3.append(r4)     // Catch:{ all -> 0x02d1 }
                java.lang.String r16 = r3.toString()     // Catch:{ all -> 0x02d1 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x02d1 }
                r3.<init>()     // Catch:{ all -> 0x02d1 }
                java.lang.String r4 = "Exception while processing "
                r3.append(r4)     // Catch:{ all -> 0x02d1 }
                java.lang.String r4 = r14.getName()     // Catch:{ all -> 0x02d1 }
                r3.append(r4)     // Catch:{ all -> 0x02d1 }
                java.lang.String r4 = ": "
                r3.append(r4)     // Catch:{ all -> 0x02d1 }
                java.lang.String r4 = android.util.Log.getStackTraceString(r0)     // Catch:{ all -> 0x02d1 }
                int r14 = r4.length()     // Catch:{ all -> 0x02d1 }
                if (r14 <= 0) goto L_0x0256
                r14 = r5
                goto L_0x0257
            L_0x0256:
                r14 = 0
            L_0x0257:
                if (r14 == 0) goto L_0x025a
                goto L_0x025b
            L_0x025a:
                r4 = 0
            L_0x025b:
                if (r4 != 0) goto L_0x0261
                java.lang.String r4 = r0.toString()     // Catch:{ all -> 0x02d1 }
            L_0x0261:
                r3.append(r4)     // Catch:{ all -> 0x02d1 }
                java.lang.String r17 = r3.toString()     // Catch:{ all -> 0x02d1 }
                r18 = 0
                r19 = 4
                r20 = 0
                com.sumsub.sns.internal.log.b.b(r15, r16, r17, r18, r19, r20)     // Catch:{ all -> 0x02d1 }
                r27 = r11
                r11 = r8
                r8 = r27
            L_0x0276:
                int r0 = r8 + 1
                r8 = r11
                r3 = 0
                r11 = r0
                goto L_0x0109
            L_0x027d:
                r0 = r2
                goto L_0x0280
            L_0x027f:
                r12 = r1
            L_0x0280:
                if (r0 != 0) goto L_0x02a8
                goto L_0x0284
            L_0x0283:
                r12 = r1
            L_0x0284:
                com.sumsub.sns.internal.log.a r14 = com.sumsub.sns.internal.log.a.f34862a     // Catch:{ all -> 0x02d1 }
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x02d1 }
                r0.<init>()     // Catch:{ all -> 0x02d1 }
                r0.append(r6)     // Catch:{ all -> 0x02d1 }
                com.sumsub.sns.internal.log.cacher.e<T> r2 = r12.f34892i     // Catch:{ all -> 0x02d1 }
                java.lang.String r2 = r2.a()     // Catch:{ all -> 0x02d1 }
                r0.append(r2)     // Catch:{ all -> 0x02d1 }
                java.lang.String r15 = r0.toString()     // Catch:{ all -> 0x02d1 }
                java.lang.String r16 = "Cache directory is null"
                r17 = 0
                r18 = 4
                r19 = 0
                com.sumsub.log.logger.a.b(r14, r15, r16, r17, r18, r19)     // Catch:{ all -> 0x02d1 }
                kotlin.Unit r0 = kotlin.Unit.f56620a     // Catch:{ all -> 0x02d1 }
            L_0x02a8:
                int r0 = r13.element
                if (r0 <= 0) goto L_0x02ce
                com.sumsub.sns.internal.log.a r13 = com.sumsub.sns.internal.log.a.f34862a
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                r0.append(r6)
                com.sumsub.sns.internal.log.cacher.e<T> r2 = r12.f34892i
                java.lang.String r2 = r2.a()
                r0.append(r2)
                java.lang.String r14 = r0.toString()
                r16 = 0
                r17 = 4
                r18 = 0
                java.lang.String r15 = "Done processing cache"
                com.sumsub.log.logger.a.c(r13, r14, r15, r16, r17, r18)
            L_0x02ce:
                kotlin.Unit r0 = kotlin.Unit.f56620a
                return r0
            L_0x02d1:
                r0 = move-exception
                goto L_0x02d5
            L_0x02d3:
                r0 = move-exception
                r12 = r1
            L_0x02d5:
                int r2 = r13.element
                if (r2 <= 0) goto L_0x02fb
                com.sumsub.sns.internal.log.a r13 = com.sumsub.sns.internal.log.a.f34862a
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                r2.append(r6)
                com.sumsub.sns.internal.log.cacher.e<T> r3 = r12.f34892i
                java.lang.String r3 = r3.a()
                r2.append(r3)
                java.lang.String r14 = r2.toString()
                r16 = 0
                r17 = 4
                r18 = 0
                java.lang.String r15 = "Done processing cache"
                com.sumsub.log.logger.a.c(r13, r14, r15, r16, r17, r18)
            L_0x02fb:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.log.cacher.e.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @d(c = "com.sumsub.sns.internal.log.cacher.SinkWrapper", f = "SinkCache.kt", l = {91, 95}, m = "send")
    public static final class c extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f34893a;

        /* renamed from: b  reason: collision with root package name */
        public Object f34894b;

        /* renamed from: c  reason: collision with root package name */
        public Object f34895c;

        /* renamed from: d  reason: collision with root package name */
        public Object f34896d;

        /* renamed from: e  reason: collision with root package name */
        public /* synthetic */ Object f34897e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e<T> f34898f;

        /* renamed from: g  reason: collision with root package name */
        public int f34899g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(e<T> eVar, kotlin.coroutines.c<? super c> cVar) {
            super(cVar);
            this.f34898f = eVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f34897e = obj;
            this.f34899g |= Integer.MIN_VALUE;
            return this.f34898f.send(null, this);
        }
    }

    public e(a<T> aVar, File file) {
        this.f34881a = aVar;
        String valueOf = String.valueOf(aVar.getClass().getName().hashCode());
        try {
            File file2 = new File(file, valueOf);
            file2.mkdirs();
            this.f34882b = file2;
        } catch (Exception e11) {
            com.sumsub.sns.internal.log.a.f34862a.e(f34880e + this.f34883c, "Can't open cache directory " + valueOf, e11);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v23, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX WARNING: type inference failed for: r0v8, types: [java.io.OutputStream, java.io.ByteArrayOutputStream] */
    /* JADX WARNING: type inference failed for: r0v15 */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0101, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0102, code lost:
        r5 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
        kotlin.io.b.a(r4, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0106, code lost:
        throw r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0107, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0108, code lost:
        r5 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x010a, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x010b, code lost:
        r5 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x010d, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x010e, code lost:
        r5 = r3;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:35:0x00de, B:42:0x0100] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00e7 A[Catch:{ all -> 0x0101, FileNotFoundException -> 0x010d, IOException -> 0x010a, Exception -> 0x0107 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object send(T r19, kotlin.coroutines.c<? super java.lang.Boolean> r20) {
        /*
            r18 = this;
            r1 = r18
            r0 = r19
            r2 = r20
            boolean r3 = r2 instanceof com.sumsub.sns.internal.log.cacher.e.c
            if (r3 == 0) goto L_0x0019
            r3 = r2
            com.sumsub.sns.internal.log.cacher.e$c r3 = (com.sumsub.sns.internal.log.cacher.e.c) r3
            int r4 = r3.f34899g
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r4 & r5
            if (r6 == 0) goto L_0x0019
            int r4 = r4 - r5
            r3.f34899g = r4
            goto L_0x001e
        L_0x0019:
            com.sumsub.sns.internal.log.cacher.e$c r3 = new com.sumsub.sns.internal.log.cacher.e$c
            r3.<init>(r1, r2)
        L_0x001e:
            java.lang.Object r2 = r3.f34897e
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r5 = r3.f34899g
            r6 = 0
            java.lang.String r7 = "Can't cache value"
            r8 = 2
            r9 = 1
            java.lang.String r10 = "SinkWrapper"
            if (r5 == 0) goto L_0x005c
            if (r5 == r9) goto L_0x0052
            if (r5 != r8) goto L_0x004a
            java.lang.Object r0 = r3.f34896d
            java.io.ByteArrayOutputStream r0 = (java.io.ByteArrayOutputStream) r0
            java.lang.Object r4 = r3.f34895c
            java.io.Closeable r4 = (java.io.Closeable) r4
            java.lang.Object r5 = r3.f34894b
            java.lang.Object r3 = r3.f34893a
            com.sumsub.sns.internal.log.cacher.e r3 = (com.sumsub.sns.internal.log.cacher.e) r3
            kotlin.k.b(r2)     // Catch:{ all -> 0x0046 }
            goto L_0x00d6
        L_0x0046:
            r0 = move-exception
        L_0x0047:
            r2 = r0
            goto L_0x0100
        L_0x004a:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0052:
            java.lang.Object r0 = r3.f34894b
            java.lang.Object r5 = r3.f34893a
            com.sumsub.sns.internal.log.cacher.e r5 = (com.sumsub.sns.internal.log.cacher.e) r5
            kotlin.k.b(r2)
            goto L_0x0096
        L_0x005c:
            kotlin.k.b(r2)
            com.sumsub.sns.internal.log.a r2 = com.sumsub.sns.internal.log.a.f34862a
            com.sumsub.sns.internal.log.LoggerType[] r5 = new com.sumsub.sns.internal.log.LoggerType[r9]
            com.sumsub.sns.internal.log.LoggerType r11 = com.sumsub.sns.internal.log.LoggerType.LOG_CAT
            r5[r6] = r11
            com.sumsub.log.logger.Logger r12 = r2.a((com.sumsub.sns.internal.log.LoggerType[]) r5)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r10)
            java.lang.String r5 = r1.f34883c
            r2.append(r5)
            java.lang.String r13 = r2.toString()
            r15 = 0
            r16 = 4
            r17 = 0
            java.lang.String r14 = "sending ..."
            com.sumsub.log.logger.a.d(r12, r13, r14, r15, r16, r17)
            com.sumsub.sns.internal.log.cacher.a<T> r2 = r1.f34881a
            r3.f34893a = r1
            r3.f34894b = r0
            r3.f34899g = r9
            java.lang.Object r2 = r2.send(r0, r3)
            if (r2 != r4) goto L_0x0095
            return r4
        L_0x0095:
            r5 = r1
        L_0x0096:
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 != 0) goto L_0x0157
            com.sumsub.sns.internal.log.a r11 = com.sumsub.sns.internal.log.a.f34862a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r10)
            java.lang.String r12 = r5.f34883c
            r2.append(r12)
            java.lang.String r12 = r2.toString()
            r14 = 0
            r15 = 4
            r16 = 0
            java.lang.String r13 = "Wrapped sink couldn't send value - caching"
            com.sumsub.log.logger.a.c(r11, r12, r13, r14, r15, r16)
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch:{ FileNotFoundException -> 0x0140, IOException -> 0x0128, Exception -> 0x0110 }
            r2.<init>()     // Catch:{ FileNotFoundException -> 0x0140, IOException -> 0x0128, Exception -> 0x0110 }
            com.sumsub.sns.internal.log.cacher.a<T> r11 = r5.f34881a     // Catch:{ all -> 0x00fb }
            r3.f34893a = r5     // Catch:{ all -> 0x00fb }
            r3.f34894b = r0     // Catch:{ all -> 0x00fb }
            r3.f34895c = r2     // Catch:{ all -> 0x00fb }
            r3.f34896d = r2     // Catch:{ all -> 0x00fb }
            r3.f34899g = r8     // Catch:{ all -> 0x00fb }
            java.lang.Object r3 = r11.a(r0, r2, r3)     // Catch:{ all -> 0x00fb }
            if (r3 != r4) goto L_0x00d2
            return r4
        L_0x00d2:
            r4 = r2
            r3 = r5
            r5 = r0
            r0 = r4
        L_0x00d6:
            r0.flush()     // Catch:{ all -> 0x0046 }
            byte[] r0 = r0.toByteArray()     // Catch:{ all -> 0x0046 }
            r2 = 0
            kotlin.io.b.a(r4, r2)     // Catch:{ FileNotFoundException -> 0x010d, IOException -> 0x010a, Exception -> 0x0107 }
            java.io.File r4 = new java.io.File     // Catch:{ FileNotFoundException -> 0x010d, IOException -> 0x010a, Exception -> 0x0107 }
            java.io.File r11 = r3.f34882b     // Catch:{ FileNotFoundException -> 0x010d, IOException -> 0x010a, Exception -> 0x0107 }
            if (r5 == 0) goto L_0x00eb
            int r6 = r5.hashCode()     // Catch:{ FileNotFoundException -> 0x010d, IOException -> 0x010a, Exception -> 0x0107 }
        L_0x00eb:
            java.lang.String r5 = java.lang.String.valueOf(r6)     // Catch:{ FileNotFoundException -> 0x010d, IOException -> 0x010a, Exception -> 0x0107 }
            r4.<init>(r11, r5)     // Catch:{ FileNotFoundException -> 0x010d, IOException -> 0x010a, Exception -> 0x0107 }
            com.sumsub.sns.internal.log.utils.a r5 = new com.sumsub.sns.internal.log.utils.a     // Catch:{ FileNotFoundException -> 0x010d, IOException -> 0x010a, Exception -> 0x0107 }
            r5.<init>(r4, r2, r8, r2)     // Catch:{ FileNotFoundException -> 0x010d, IOException -> 0x010a, Exception -> 0x0107 }
            r5.a((byte[]) r0)     // Catch:{ FileNotFoundException -> 0x010d, IOException -> 0x010a, Exception -> 0x0107 }
            goto L_0x0157
        L_0x00fb:
            r0 = move-exception
            r4 = r2
            r3 = r5
            goto L_0x0047
        L_0x0100:
            throw r2     // Catch:{ all -> 0x0101 }
        L_0x0101:
            r0 = move-exception
            r5 = r0
            kotlin.io.b.a(r4, r2)     // Catch:{ FileNotFoundException -> 0x010d, IOException -> 0x010a, Exception -> 0x0107 }
            throw r5     // Catch:{ FileNotFoundException -> 0x010d, IOException -> 0x010a, Exception -> 0x0107 }
        L_0x0107:
            r0 = move-exception
            r5 = r3
            goto L_0x0111
        L_0x010a:
            r0 = move-exception
            r5 = r3
            goto L_0x0129
        L_0x010d:
            r0 = move-exception
            r5 = r3
            goto L_0x0141
        L_0x0110:
            r0 = move-exception
        L_0x0111:
            com.sumsub.sns.internal.log.a r2 = com.sumsub.sns.internal.log.a.f34862a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r10)
            java.lang.String r4 = r5.f34883c
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r2.e(r3, r7, r0)
            goto L_0x0157
        L_0x0128:
            r0 = move-exception
        L_0x0129:
            com.sumsub.sns.internal.log.a r2 = com.sumsub.sns.internal.log.a.f34862a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r10)
            java.lang.String r4 = r5.f34883c
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            com.sumsub.sns.internal.log.b.b(r2, r3, r7, r0)
            goto L_0x0157
        L_0x0140:
            r0 = move-exception
        L_0x0141:
            com.sumsub.sns.internal.log.a r2 = com.sumsub.sns.internal.log.a.f34862a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r10)
            java.lang.String r4 = r5.f34883c
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            com.sumsub.sns.internal.log.b.b(r2, r3, r7, r0)
        L_0x0157:
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.a.a(r9)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.log.cacher.e.send(java.lang.Object, kotlin.coroutines.c):java.lang.Object");
    }

    public final String a() {
        return this.f34883c;
    }

    public final void a(String str) {
        this.f34883c = str;
    }

    public Object a(kotlin.coroutines.c<? super Unit> cVar) {
        Object g11 = g.g(v0.b(), new b(this, (kotlin.coroutines.c<? super b>) null), cVar);
        return g11 == IntrinsicsKt__IntrinsicsKt.d() ? g11 : Unit.f56620a;
    }
}
