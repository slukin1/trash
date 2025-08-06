package okio;

final /* synthetic */ class Okio__OkioKt {
    public static final Sink blackhole() {
        return new BlackholeSink();
    }

    public static final BufferedSource buffer(Source source) {
        return new RealBufferedSource(source);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x002a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T extends java.io.Closeable, R> R use(T r3, d10.l<? super T, ? extends R> r4) {
        /*
            r0 = 0
            r1 = 1
            java.lang.Object r4 = r4.invoke(r3)     // Catch:{ all -> 0x0014 }
            kotlin.jvm.internal.InlineMarker.b(r1)
            if (r3 == 0) goto L_0x0010
            r3.close()     // Catch:{ all -> 0x000f }
            goto L_0x0010
        L_0x000f:
            r0 = move-exception
        L_0x0010:
            kotlin.jvm.internal.InlineMarker.a(r1)
            goto L_0x0028
        L_0x0014:
            r4 = move-exception
            kotlin.jvm.internal.InlineMarker.b(r1)
            if (r3 == 0) goto L_0x0022
            r3.close()     // Catch:{ all -> 0x001e }
            goto L_0x0022
        L_0x001e:
            r3 = move-exception
            kotlin.ExceptionsKt__ExceptionsKt.a(r4, r3)
        L_0x0022:
            kotlin.jvm.internal.InlineMarker.a(r1)
            r2 = r0
            r0 = r4
            r4 = r2
        L_0x0028:
            if (r0 != 0) goto L_0x002b
            return r4
        L_0x002b:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Okio__OkioKt.use(java.io.Closeable, d10.l):java.lang.Object");
    }

    public static final BufferedSink buffer(Sink sink) {
        return new RealBufferedSink(sink);
    }
}
