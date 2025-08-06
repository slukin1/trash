package kotlinx.coroutines.internal;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final c0 f57303a = new c0("CLOSED");

    public static final <N extends e<N>> N b(N n11) {
        while (true) {
            N a11 = n11.f();
            if (a11 == f57303a) {
                return n11;
            }
            N n12 = (e) a11;
            if (n12 != null) {
                n11 = n12;
            } else if (n11.j()) {
                return n11;
            }
        }
    }

    /* JADX WARNING: type inference failed for: r7v0, types: [d10.p<? super java.lang.Long, ? super S, ? extends S>, d10.p] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <S extends kotlinx.coroutines.internal.z<S>> java.lang.Object c(S r4, long r5, d10.p<? super java.lang.Long, ? super S, ? extends S> r7) {
        /*
        L_0x0000:
            long r0 = r4.f57353d
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r0 < 0) goto L_0x0012
            boolean r0 = r4.h()
            if (r0 == 0) goto L_0x000d
            goto L_0x0012
        L_0x000d:
            java.lang.Object r4 = kotlinx.coroutines.internal.a0.a(r4)
            return r4
        L_0x0012:
            java.lang.Object r0 = r4.f()
            kotlinx.coroutines.internal.c0 r1 = f57303a
            if (r0 != r1) goto L_0x0023
            kotlinx.coroutines.internal.c0 r4 = f57303a
            java.lang.Object r4 = kotlinx.coroutines.internal.a0.a(r4)
            return r4
        L_0x0023:
            kotlinx.coroutines.internal.e r0 = (kotlinx.coroutines.internal.e) r0
            kotlinx.coroutines.internal.z r0 = (kotlinx.coroutines.internal.z) r0
            if (r0 == 0) goto L_0x002b
        L_0x0029:
            r4 = r0
            goto L_0x0000
        L_0x002b:
            long r0 = r4.f57353d
            r2 = 1
            long r0 = r0 + r2
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            java.lang.Object r0 = r7.invoke(r0, r4)
            kotlinx.coroutines.internal.z r0 = (kotlinx.coroutines.internal.z) r0
            boolean r1 = r4.l(r0)
            if (r1 == 0) goto L_0x0000
            boolean r1 = r4.h()
            if (r1 == 0) goto L_0x0029
            r4.k()
            goto L_0x0029
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.d.c(kotlinx.coroutines.internal.z, long, d10.p):java.lang.Object");
    }
}
