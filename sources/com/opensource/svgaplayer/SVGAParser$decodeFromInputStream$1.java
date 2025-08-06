package com.opensource.svgaplayer;

import ay.b;
import com.opensource.svgaplayer.SVGAParser;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.Unit;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 1, 15})
public final class SVGAParser$decodeFromInputStream$1 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SVGAParser f28515b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ InputStream f28516c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f28517d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ SVGAParser.c f28518e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ String f28519f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SVGAParser.d f28520g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f28521h;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "run", "com/opensource/svgaplayer/SVGAParser$decodeFromInputStream$1$1$2"}, k = 3, mv = {1, 1, 15})
    public static final class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ byte[] f28522b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SVGAParser$decodeFromInputStream$1 f28523c;

        public a(byte[] bArr, SVGAParser$decodeFromInputStream$1 sVGAParser$decodeFromInputStream$1) {
            this.f28522b = bArr;
            this.f28523c = sVGAParser$decodeFromInputStream$1;
        }

        public final void run() {
            File e11 = SVGACache.f28468c.e(this.f28523c.f28517d);
            try {
                File file = e11.exists() ^ true ? e11 : null;
                if (file != null) {
                    file.createNewFile();
                }
                new FileOutputStream(e11).write(this.f28522b);
                Unit unit = Unit.f56620a;
            } catch (Exception e12) {
                b.f26389a.c("SVGAParser", "create cache file fail.", e12);
                e11.delete();
            }
        }
    }

    public SVGAParser$decodeFromInputStream$1(SVGAParser sVGAParser, InputStream inputStream, String str, SVGAParser.c cVar, String str2, SVGAParser.d dVar, boolean z11) {
        this.f28515b = sVGAParser;
        this.f28516c = inputStream;
        this.f28517d = str;
        this.f28518e = cVar;
        this.f28519f = str2;
        this.f28520g = dVar;
        this.f28521h = z11;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x006f, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        kotlin.io.b.a(r2, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0073, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x011b, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x011d, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
        r6.f28515b.w(r0, r6.f28518e, r6.f28519f);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0129, code lost:
        if (r6.f28521h != false) goto L_0x012b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x012b, code lost:
        r6.f28516c.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0130, code lost:
        r0 = ay.b.f26389a;
        r1 = "SVGAParser";
        r2 = new java.lang.StringBuilder();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0152, code lost:
        if (r6.f28521h != false) goto L_0x0154;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0154, code lost:
        r6.f28516c.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0159, code lost:
        r1 = ay.b.f26389a;
        r1.e("SVGAParser", "================ decode " + r6.f28519f + " from input stream end ================");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0178, code lost:
        throw r0;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r6 = this;
            com.opensource.svgaplayer.SVGAParser r0 = r6.f28515b     // Catch:{ Exception -> 0x011d }
            java.io.InputStream r1 = r6.f28516c     // Catch:{ Exception -> 0x011d }
            byte[] r0 = r0.y(r1)     // Catch:{ Exception -> 0x011d }
            if (r0 == 0) goto L_0x00f8
            com.opensource.svgaplayer.SVGAParser r1 = r6.f28515b     // Catch:{ Exception -> 0x011d }
            boolean r1 = r1.x(r0)     // Catch:{ Exception -> 0x011d }
            if (r1 == 0) goto L_0x0087
            ay.b r1 = ay.b.f26389a     // Catch:{ Exception -> 0x011d }
            java.lang.String r2 = "SVGAParser"
            java.lang.String r3 = "decode from zip file"
            r1.e(r2, r3)     // Catch:{ Exception -> 0x011d }
            com.opensource.svgaplayer.SVGACache r2 = com.opensource.svgaplayer.SVGACache.f28468c     // Catch:{ Exception -> 0x011d }
            java.lang.String r3 = r6.f28517d     // Catch:{ Exception -> 0x011d }
            java.io.File r3 = r2.b(r3)     // Catch:{ Exception -> 0x011d }
            boolean r3 = r3.exists()     // Catch:{ Exception -> 0x011d }
            if (r3 == 0) goto L_0x002f
            boolean r3 = com.opensource.svgaplayer.f.f28603b     // Catch:{ Exception -> 0x011d }
            if (r3 == 0) goto L_0x0077
        L_0x002f:
            int r3 = com.opensource.svgaplayer.f.f28602a     // Catch:{ Exception -> 0x011d }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ Exception -> 0x011d }
            monitor-enter(r3)     // Catch:{ Exception -> 0x011d }
            java.lang.String r4 = r6.f28517d     // Catch:{ all -> 0x0084 }
            java.io.File r2 = r2.b(r4)     // Catch:{ all -> 0x0084 }
            boolean r2 = r2.exists()     // Catch:{ all -> 0x0084 }
            if (r2 != 0) goto L_0x0074
            r2 = 1
            com.opensource.svgaplayer.f.f28603b = r2     // Catch:{ all -> 0x0084 }
            java.lang.String r2 = "SVGAParser"
            java.lang.String r4 = "no cached, prepare to unzip"
            r1.e(r2, r4)     // Catch:{ all -> 0x0084 }
            java.io.ByteArrayInputStream r2 = new java.io.ByteArrayInputStream     // Catch:{ all -> 0x0084 }
            r2.<init>(r0)     // Catch:{ all -> 0x0084 }
            r0 = 0
            com.opensource.svgaplayer.SVGAParser r4 = r6.f28515b     // Catch:{ all -> 0x006d }
            java.lang.String r5 = r6.f28517d     // Catch:{ all -> 0x006d }
            r4.z(r2, r5)     // Catch:{ all -> 0x006d }
            r4 = 0
            com.opensource.svgaplayer.f.f28603b = r4     // Catch:{ all -> 0x006d }
            java.lang.String r4 = "SVGAParser"
            java.lang.String r5 = "unzip success"
            r1.e(r4, r5)     // Catch:{ all -> 0x006d }
            kotlin.Unit r1 = kotlin.Unit.f56620a     // Catch:{ all -> 0x006d }
            kotlin.io.b.a(r2, r0)     // Catch:{ all -> 0x0084 }
            goto L_0x0074
        L_0x006d:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x006f }
        L_0x006f:
            r1 = move-exception
            kotlin.io.b.a(r2, r0)     // Catch:{ all -> 0x0084 }
            throw r1     // Catch:{ all -> 0x0084 }
        L_0x0074:
            kotlin.Unit r0 = kotlin.Unit.f56620a     // Catch:{ all -> 0x0084 }
            monitor-exit(r3)     // Catch:{ Exception -> 0x011d }
        L_0x0077:
            com.opensource.svgaplayer.SVGAParser r0 = r6.f28515b     // Catch:{ Exception -> 0x011d }
            java.lang.String r1 = r6.f28517d     // Catch:{ Exception -> 0x011d }
            com.opensource.svgaplayer.SVGAParser$c r2 = r6.f28518e     // Catch:{ Exception -> 0x011d }
            java.lang.String r3 = r6.f28519f     // Catch:{ Exception -> 0x011d }
            r0.o(r1, r2, r3)     // Catch:{ Exception -> 0x011d }
            goto L_0x0108
        L_0x0084:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ Exception -> 0x011d }
            throw r0     // Catch:{ Exception -> 0x011d }
        L_0x0087:
            com.opensource.svgaplayer.SVGACache r1 = com.opensource.svgaplayer.SVGACache.f28468c     // Catch:{ Exception -> 0x011d }
            boolean r1 = r1.i()     // Catch:{ Exception -> 0x011d }
            if (r1 != 0) goto L_0x009d
            com.opensource.svgaplayer.SVGAParser$b r1 = com.opensource.svgaplayer.SVGAParser.f28503h     // Catch:{ Exception -> 0x011d }
            java.util.concurrent.ExecutorService r1 = r1.a()     // Catch:{ Exception -> 0x011d }
            com.opensource.svgaplayer.SVGAParser$decodeFromInputStream$1$a r2 = new com.opensource.svgaplayer.SVGAParser$decodeFromInputStream$1$a     // Catch:{ Exception -> 0x011d }
            r2.<init>(r0, r6)     // Catch:{ Exception -> 0x011d }
            r1.execute(r2)     // Catch:{ Exception -> 0x011d }
        L_0x009d:
            ay.b r1 = ay.b.f26389a     // Catch:{ Exception -> 0x011d }
            java.lang.String r2 = "SVGAParser"
            java.lang.String r3 = "inflate start"
            r1.e(r2, r3)     // Catch:{ Exception -> 0x011d }
            com.opensource.svgaplayer.SVGAParser r2 = r6.f28515b     // Catch:{ Exception -> 0x011d }
            byte[] r0 = r2.u(r0)     // Catch:{ Exception -> 0x011d }
            if (r0 == 0) goto L_0x00e7
            java.lang.String r2 = "SVGAParser"
            java.lang.String r3 = "inflate complete"
            r1.e(r2, r3)     // Catch:{ Exception -> 0x011d }
            com.opensource.svgaplayer.SVGAVideoEntity r2 = new com.opensource.svgaplayer.SVGAVideoEntity     // Catch:{ Exception -> 0x011d }
            com.squareup.wire.ProtoAdapter<com.opensource.svgaplayer.proto.MovieEntity> r3 = com.opensource.svgaplayer.proto.MovieEntity.ADAPTER     // Catch:{ Exception -> 0x011d }
            java.lang.Object r0 = r3.f(r0)     // Catch:{ Exception -> 0x011d }
            com.opensource.svgaplayer.proto.MovieEntity r0 = (com.opensource.svgaplayer.proto.MovieEntity) r0     // Catch:{ Exception -> 0x011d }
            java.io.File r3 = new java.io.File     // Catch:{ Exception -> 0x011d }
            java.lang.String r4 = r6.f28517d     // Catch:{ Exception -> 0x011d }
            r3.<init>(r4)     // Catch:{ Exception -> 0x011d }
            com.opensource.svgaplayer.SVGAParser r4 = r6.f28515b     // Catch:{ Exception -> 0x011d }
            int r4 = r4.f28505b     // Catch:{ Exception -> 0x011d }
            com.opensource.svgaplayer.SVGAParser r5 = r6.f28515b     // Catch:{ Exception -> 0x011d }
            int r5 = r5.f28506c     // Catch:{ Exception -> 0x011d }
            r2.<init>((com.opensource.svgaplayer.proto.MovieEntity) r0, (java.io.File) r3, (int) r4, (int) r5)     // Catch:{ Exception -> 0x011d }
            java.lang.String r0 = "SVGAParser"
            java.lang.String r3 = "SVGAVideoEntity prepare start"
            r1.e(r0, r3)     // Catch:{ Exception -> 0x011d }
            com.opensource.svgaplayer.SVGAParser$decodeFromInputStream$1$$special$$inlined$let$lambda$3 r0 = new com.opensource.svgaplayer.SVGAParser$decodeFromInputStream$1$$special$$inlined$let$lambda$3     // Catch:{ Exception -> 0x011d }
            r0.<init>(r2, r6)     // Catch:{ Exception -> 0x011d }
            com.opensource.svgaplayer.SVGAParser$d r1 = r6.f28520g     // Catch:{ Exception -> 0x011d }
            r2.u(r0, r1)     // Catch:{ Exception -> 0x011d }
            goto L_0x0108
        L_0x00e7:
            com.opensource.svgaplayer.SVGAParser r0 = r6.f28515b     // Catch:{ Exception -> 0x011d }
            java.lang.Exception r1 = new java.lang.Exception     // Catch:{ Exception -> 0x011d }
            java.lang.String r2 = "inflate(bytes) cause exception"
            r1.<init>(r2)     // Catch:{ Exception -> 0x011d }
            com.opensource.svgaplayer.SVGAParser$c r2 = r6.f28518e     // Catch:{ Exception -> 0x011d }
            java.lang.String r3 = r6.f28519f     // Catch:{ Exception -> 0x011d }
            r0.w(r1, r2, r3)     // Catch:{ Exception -> 0x011d }
            goto L_0x0108
        L_0x00f8:
            com.opensource.svgaplayer.SVGAParser r0 = r6.f28515b     // Catch:{ Exception -> 0x011d }
            java.lang.Exception r1 = new java.lang.Exception     // Catch:{ Exception -> 0x011d }
            java.lang.String r2 = "readAsBytes(inputStream) cause exception"
            r1.<init>(r2)     // Catch:{ Exception -> 0x011d }
            com.opensource.svgaplayer.SVGAParser$c r2 = r6.f28518e     // Catch:{ Exception -> 0x011d }
            java.lang.String r3 = r6.f28519f     // Catch:{ Exception -> 0x011d }
            r0.w(r1, r2, r3)     // Catch:{ Exception -> 0x011d }
        L_0x0108:
            boolean r0 = r6.f28521h
            if (r0 == 0) goto L_0x0111
            java.io.InputStream r0 = r6.f28516c
            r0.close()
        L_0x0111:
            ay.b r0 = ay.b.f26389a
            java.lang.String r1 = "SVGAParser"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            goto L_0x0139
        L_0x011b:
            r0 = move-exception
            goto L_0x0150
        L_0x011d:
            r0 = move-exception
            com.opensource.svgaplayer.SVGAParser r1 = r6.f28515b     // Catch:{ all -> 0x011b }
            com.opensource.svgaplayer.SVGAParser$c r2 = r6.f28518e     // Catch:{ all -> 0x011b }
            java.lang.String r3 = r6.f28519f     // Catch:{ all -> 0x011b }
            r1.w(r0, r2, r3)     // Catch:{ all -> 0x011b }
            boolean r0 = r6.f28521h
            if (r0 == 0) goto L_0x0130
            java.io.InputStream r0 = r6.f28516c
            r0.close()
        L_0x0130:
            ay.b r0 = ay.b.f26389a
            java.lang.String r1 = "SVGAParser"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
        L_0x0139:
            java.lang.String r3 = "================ decode "
            r2.append(r3)
            java.lang.String r3 = r6.f28519f
            r2.append(r3)
            java.lang.String r3 = " from input stream end ================"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0.e(r1, r2)
            return
        L_0x0150:
            boolean r1 = r6.f28521h
            if (r1 == 0) goto L_0x0159
            java.io.InputStream r1 = r6.f28516c
            r1.close()
        L_0x0159:
            ay.b r1 = ay.b.f26389a
            java.lang.String r2 = "SVGAParser"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "================ decode "
            r3.append(r4)
            java.lang.String r4 = r6.f28519f
            r3.append(r4)
            java.lang.String r4 = " from input stream end ================"
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r1.e(r2, r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opensource.svgaplayer.SVGAParser$decodeFromInputStream$1.run():void");
    }
}
