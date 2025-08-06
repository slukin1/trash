package kotlinx.serialization.json.internal;

import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.a;

public final class o0 {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: kotlinx.serialization.json.internal.a0} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: kotlinx.serialization.json.internal.x} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v9, resolved type: kotlinx.serialization.json.internal.c0} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: kotlinx.serialization.json.internal.a0} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: kotlinx.serialization.json.internal.a0} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: kotlinx.serialization.json.internal.a0} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> T a(kotlinx.serialization.json.a r8, kotlinx.serialization.json.g r9, kotlinx.serialization.a<? extends T> r10) {
        /*
            boolean r0 = r9 instanceof kotlinx.serialization.json.JsonObject
            if (r0 == 0) goto L_0x0014
            kotlinx.serialization.json.internal.a0 r0 = new kotlinx.serialization.json.internal.a0
            r3 = r9
            kotlinx.serialization.json.JsonObject r3 = (kotlinx.serialization.json.JsonObject) r3
            r4 = 0
            r5 = 0
            r6 = 12
            r7 = 0
            r1 = r0
            r2 = r8
            r1.<init>(r2, r3, r4, r5, r6, r7)
            goto L_0x0035
        L_0x0014:
            boolean r0 = r9 instanceof kotlinx.serialization.json.b
            if (r0 == 0) goto L_0x0020
            kotlinx.serialization.json.internal.c0 r0 = new kotlinx.serialization.json.internal.c0
            kotlinx.serialization.json.b r9 = (kotlinx.serialization.json.b) r9
            r0.<init>(r8, r9)
            goto L_0x0035
        L_0x0020:
            boolean r0 = r9 instanceof kotlinx.serialization.json.n
            if (r0 == 0) goto L_0x0026
            r0 = 1
            goto L_0x002c
        L_0x0026:
            kotlinx.serialization.json.JsonNull r0 = kotlinx.serialization.json.JsonNull.INSTANCE
            boolean r0 = kotlin.jvm.internal.x.b(r9, r0)
        L_0x002c:
            if (r0 == 0) goto L_0x003a
            kotlinx.serialization.json.internal.x r0 = new kotlinx.serialization.json.internal.x
            kotlinx.serialization.json.t r9 = (kotlinx.serialization.json.t) r9
            r0.<init>(r8, r9)
        L_0x0035:
            java.lang.Object r8 = r0.G(r10)
            return r8
        L_0x003a:
            kotlin.NoWhenBranchMatchedException r8 = new kotlin.NoWhenBranchMatchedException
            r8.<init>()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.json.internal.o0.a(kotlinx.serialization.json.a, kotlinx.serialization.json.g, kotlinx.serialization.a):java.lang.Object");
    }

    public static final <T> T b(a aVar, String str, JsonObject jsonObject, kotlinx.serialization.a<? extends T> aVar2) {
        return new a0(aVar, jsonObject, str, aVar2.getDescriptor()).G(aVar2);
    }
}
