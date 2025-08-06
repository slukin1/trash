package com.opensource.svgaplayer;

import com.opensource.svgaplayer.SVGAParser;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 1, 15})
public final class SVGAParser$decodeFromSVGAFileCacheKey$1 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SVGAParser f28524b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f28525c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f28526d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ SVGAParser.c f28527e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ SVGAParser.d f28528f;

    public SVGAParser$decodeFromSVGAFileCacheKey$1(SVGAParser sVGAParser, String str, String str2, SVGAParser.c cVar, SVGAParser.d dVar) {
        this.f28524b = sVGAParser;
        this.f28525c = str;
        this.f28526d = str2;
        this.f28527e = cVar;
        this.f28528f = dVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00bb, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        kotlin.io.b.a(r4, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00bf, code lost:
        throw r5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r11 = this;
            java.lang.String r0 = " from svga cachel file to entity end ================"
            java.lang.String r1 = "================ decode "
            java.lang.String r2 = "SVGAParser"
            ay.b r3 = ay.b.f26389a     // Catch:{ Exception -> 0x00c2 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00c2 }
            r4.<init>()     // Catch:{ Exception -> 0x00c2 }
            r4.append(r1)     // Catch:{ Exception -> 0x00c2 }
            java.lang.String r5 = r11.f28525c     // Catch:{ Exception -> 0x00c2 }
            r4.append(r5)     // Catch:{ Exception -> 0x00c2 }
            java.lang.String r5 = " from svga cachel file to entity ================"
            r4.append(r5)     // Catch:{ Exception -> 0x00c2 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x00c2 }
            r3.e(r2, r4)     // Catch:{ Exception -> 0x00c2 }
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ Exception -> 0x00c2 }
            com.opensource.svgaplayer.SVGACache r5 = com.opensource.svgaplayer.SVGACache.f28468c     // Catch:{ Exception -> 0x00c2 }
            java.lang.String r6 = r11.f28526d     // Catch:{ Exception -> 0x00c2 }
            java.io.File r5 = r5.e(r6)     // Catch:{ Exception -> 0x00c2 }
            r4.<init>(r5)     // Catch:{ Exception -> 0x00c2 }
            r5 = 0
            com.opensource.svgaplayer.SVGAParser r6 = r11.f28524b     // Catch:{ all -> 0x00b9 }
            byte[] r6 = r6.y(r4)     // Catch:{ all -> 0x00b9 }
            if (r6 == 0) goto L_0x009e
            com.opensource.svgaplayer.SVGAParser r7 = r11.f28524b     // Catch:{ all -> 0x00b9 }
            boolean r7 = r7.x(r6)     // Catch:{ all -> 0x00b9 }
            if (r7 == 0) goto L_0x004b
            com.opensource.svgaplayer.SVGAParser r6 = r11.f28524b     // Catch:{ all -> 0x00b9 }
            java.lang.String r7 = r11.f28526d     // Catch:{ all -> 0x00b9 }
            com.opensource.svgaplayer.SVGAParser$c r8 = r11.f28527e     // Catch:{ all -> 0x00b9 }
            java.lang.String r9 = r11.f28525c     // Catch:{ all -> 0x00b9 }
            r6.o(r7, r8, r9)     // Catch:{ all -> 0x00b9 }
            goto L_0x00ae
        L_0x004b:
            java.lang.String r7 = "inflate start"
            r3.e(r2, r7)     // Catch:{ all -> 0x00b9 }
            com.opensource.svgaplayer.SVGAParser r7 = r11.f28524b     // Catch:{ all -> 0x00b9 }
            byte[] r6 = r7.u(r6)     // Catch:{ all -> 0x00b9 }
            if (r6 == 0) goto L_0x008d
            java.lang.String r7 = "inflate complete"
            r3.e(r2, r7)     // Catch:{ all -> 0x00b9 }
            com.opensource.svgaplayer.SVGAVideoEntity r7 = new com.opensource.svgaplayer.SVGAVideoEntity     // Catch:{ all -> 0x00b9 }
            com.squareup.wire.ProtoAdapter<com.opensource.svgaplayer.proto.MovieEntity> r8 = com.opensource.svgaplayer.proto.MovieEntity.ADAPTER     // Catch:{ all -> 0x00b9 }
            java.lang.Object r6 = r8.f(r6)     // Catch:{ all -> 0x00b9 }
            com.opensource.svgaplayer.proto.MovieEntity r6 = (com.opensource.svgaplayer.proto.MovieEntity) r6     // Catch:{ all -> 0x00b9 }
            java.io.File r8 = new java.io.File     // Catch:{ all -> 0x00b9 }
            java.lang.String r9 = r11.f28526d     // Catch:{ all -> 0x00b9 }
            r8.<init>(r9)     // Catch:{ all -> 0x00b9 }
            com.opensource.svgaplayer.SVGAParser r9 = r11.f28524b     // Catch:{ all -> 0x00b9 }
            int r9 = r9.f28505b     // Catch:{ all -> 0x00b9 }
            com.opensource.svgaplayer.SVGAParser r10 = r11.f28524b     // Catch:{ all -> 0x00b9 }
            int r10 = r10.f28506c     // Catch:{ all -> 0x00b9 }
            r7.<init>((com.opensource.svgaplayer.proto.MovieEntity) r6, (java.io.File) r8, (int) r9, (int) r10)     // Catch:{ all -> 0x00b9 }
            java.lang.String r6 = "SVGAVideoEntity prepare start"
            r3.e(r2, r6)     // Catch:{ all -> 0x00b9 }
            com.opensource.svgaplayer.SVGAParser$decodeFromSVGAFileCacheKey$1$$special$$inlined$use$lambda$1 r6 = new com.opensource.svgaplayer.SVGAParser$decodeFromSVGAFileCacheKey$1$$special$$inlined$use$lambda$1     // Catch:{ all -> 0x00b9 }
            r6.<init>(r7, r11)     // Catch:{ all -> 0x00b9 }
            com.opensource.svgaplayer.SVGAParser$d r8 = r11.f28528f     // Catch:{ all -> 0x00b9 }
            r7.u(r6, r8)     // Catch:{ all -> 0x00b9 }
            goto L_0x00ae
        L_0x008d:
            com.opensource.svgaplayer.SVGAParser r6 = r11.f28524b     // Catch:{ all -> 0x00b9 }
            java.lang.Exception r7 = new java.lang.Exception     // Catch:{ all -> 0x00b9 }
            java.lang.String r8 = "inflate(bytes) cause exception"
            r7.<init>(r8)     // Catch:{ all -> 0x00b9 }
            com.opensource.svgaplayer.SVGAParser$c r8 = r11.f28527e     // Catch:{ all -> 0x00b9 }
            java.lang.String r9 = r11.f28525c     // Catch:{ all -> 0x00b9 }
            r6.w(r7, r8, r9)     // Catch:{ all -> 0x00b9 }
            goto L_0x00ae
        L_0x009e:
            com.opensource.svgaplayer.SVGAParser r6 = r11.f28524b     // Catch:{ all -> 0x00b9 }
            java.lang.Exception r7 = new java.lang.Exception     // Catch:{ all -> 0x00b9 }
            java.lang.String r8 = "readAsBytes(inputStream) cause exception"
            r7.<init>(r8)     // Catch:{ all -> 0x00b9 }
            com.opensource.svgaplayer.SVGAParser$c r8 = r11.f28527e     // Catch:{ all -> 0x00b9 }
            java.lang.String r9 = r11.f28525c     // Catch:{ all -> 0x00b9 }
            r6.w(r7, r8, r9)     // Catch:{ all -> 0x00b9 }
        L_0x00ae:
            kotlin.Unit r6 = kotlin.Unit.f56620a     // Catch:{ all -> 0x00b9 }
            kotlin.io.b.a(r4, r5)     // Catch:{ Exception -> 0x00c2 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            goto L_0x00d3
        L_0x00b9:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x00bb }
        L_0x00bb:
            r5 = move-exception
            kotlin.io.b.a(r4, r3)     // Catch:{ Exception -> 0x00c2 }
            throw r5     // Catch:{ Exception -> 0x00c2 }
        L_0x00c0:
            r3 = move-exception
            goto L_0x00e6
        L_0x00c2:
            r3 = move-exception
            com.opensource.svgaplayer.SVGAParser r4 = r11.f28524b     // Catch:{ all -> 0x00c0 }
            com.opensource.svgaplayer.SVGAParser$c r5 = r11.f28527e     // Catch:{ all -> 0x00c0 }
            java.lang.String r6 = r11.f28525c     // Catch:{ all -> 0x00c0 }
            r4.w(r3, r5, r6)     // Catch:{ all -> 0x00c0 }
            ay.b r3 = ay.b.f26389a
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
        L_0x00d3:
            r4.append(r1)
            java.lang.String r1 = r11.f28525c
            r4.append(r1)
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            r3.e(r2, r0)
            return
        L_0x00e6:
            ay.b r4 = ay.b.f26389a
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r1)
            java.lang.String r1 = r11.f28525c
            r5.append(r1)
            r5.append(r0)
            java.lang.String r0 = r5.toString()
            r4.e(r2, r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opensource.svgaplayer.SVGAParser$decodeFromSVGAFileCacheKey$1.run():void");
    }
}
