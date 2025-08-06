package n20;

public class e {

    /* renamed from: a  reason: collision with root package name */
    public final c[] f22977a;

    /* renamed from: b  reason: collision with root package name */
    public a[] f22978b = new a[16];

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final Class<?> f22979a;

        /* renamed from: b  reason: collision with root package name */
        public final c f22980b;

        public a(Class<?> cls, c cVar) {
            this.f22979a = cls;
            this.f22980b = cVar;
        }
    }

    public e(c[] cVarArr) {
        this.f22977a = cVarArr;
    }

    public static c c(e eVar, Class<?> cls) {
        String str;
        c[] cVarArr = eVar.f22977a;
        int length = cVarArr.length;
        int i11 = length;
        while (true) {
            length--;
            if (length >= 0) {
                c cVar = cVarArr[length];
                Class<?> e11 = cVar.e();
                if (e11 == cls) {
                    return cVar;
                }
                if (e11 == null || (cls != null && !e11.isAssignableFrom(cls))) {
                    eVar = eVar.a(length, (c[]) null);
                    cVarArr = eVar.f22977a;
                    i11 = cVarArr.length;
                }
            } else if (cls == null || i11 == 0) {
                return null;
            } else {
                if (i11 == 1) {
                    return cVarArr[0];
                }
                int i12 = i11;
                while (true) {
                    i11--;
                    if (i11 < 0) {
                        break;
                    }
                    Class<?> e12 = cVarArr[i11].e();
                    int i13 = i12;
                    while (true) {
                        i12--;
                        if (i12 < 0) {
                            break;
                        } else if (i12 != i11 && cVarArr[i12].e().isAssignableFrom(e12)) {
                            eVar = eVar.a(i12, (c[]) null);
                            cVarArr = eVar.f22977a;
                            i13 = cVarArr.length;
                            i11 = i13 - 1;
                        }
                    }
                    i12 = i13;
                }
                if (i12 == 1) {
                    return cVarArr[0];
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Unable to find best converter for type \"");
                sb2.append(cls.getName());
                sb2.append("\" from remaining set: ");
                for (int i14 = 0; i14 < i12; i14++) {
                    c cVar2 = cVarArr[i14];
                    Class<?> e13 = cVar2.e();
                    sb2.append(cVar2.getClass().getName());
                    sb2.append('[');
                    if (e13 == null) {
                        str = null;
                    } else {
                        str = e13.getName();
                    }
                    sb2.append(str);
                    sb2.append("], ");
                }
                throw new IllegalStateException(sb2.toString());
            }
        }
    }

    public e a(int i11, c[] cVarArr) {
        c[] cVarArr2 = this.f22977a;
        int length = cVarArr2.length;
        if (i11 < length) {
            if (cVarArr != null) {
                cVarArr[0] = cVarArr2[i11];
            }
            c[] cVarArr3 = new c[(length - 1)];
            int i12 = 0;
            for (int i13 = 0; i13 < length; i13++) {
                if (i13 != i11) {
                    cVarArr3[i12] = cVarArr2[i13];
                    i12++;
                }
            }
            return new e(cVarArr3);
        }
        throw new IndexOutOfBoundsException();
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x005c A[EDGE_INSN: B:39:0x005c->B:29:0x005c ?: BREAK  , SYNTHETIC] */
    public n20.c b(java.lang.Class<?> r10) throws java.lang.IllegalStateException {
        /*
            r9 = this;
            n20.e$a[] r0 = r9.f22978b
            int r1 = r0.length
            r2 = 0
            if (r10 != 0) goto L_0x0007
            goto L_0x001d
        L_0x0007:
            int r3 = r10.hashCode()
            int r4 = r1 + -1
            r3 = r3 & r4
        L_0x000e:
            r4 = r0[r3]
            if (r4 == 0) goto L_0x001f
            java.lang.Class<?> r5 = r4.f22979a
            if (r5 != r10) goto L_0x0019
            n20.c r10 = r4.f22980b
            return r10
        L_0x0019:
            int r3 = r3 + 1
            if (r3 < r1) goto L_0x000e
        L_0x001d:
            r3 = r2
            goto L_0x000e
        L_0x001f:
            n20.c r4 = c(r9, r10)
            n20.e$a r5 = new n20.e$a
            r5.<init>(r10, r4)
            java.lang.Object r10 = r0.clone()
            n20.e$a[] r10 = (n20.e.a[]) r10
            r10[r3] = r5
            r0 = r2
        L_0x0031:
            if (r0 >= r1) goto L_0x003d
            r3 = r10[r0]
            if (r3 != 0) goto L_0x003a
            r9.f22978b = r10
            return r4
        L_0x003a:
            int r0 = r0 + 1
            goto L_0x0031
        L_0x003d:
            int r0 = r1 << 1
            n20.e$a[] r3 = new n20.e.a[r0]
            r5 = r2
        L_0x0042:
            if (r5 >= r1) goto L_0x0061
            r6 = r10[r5]
            java.lang.Class<?> r7 = r6.f22979a
            if (r7 != 0) goto L_0x004b
            goto L_0x005a
        L_0x004b:
            int r7 = r7.hashCode()
            int r8 = r0 + -1
            r7 = r7 & r8
        L_0x0052:
            r8 = r3[r7]
            if (r8 == 0) goto L_0x005c
            int r7 = r7 + 1
            if (r7 < r0) goto L_0x0052
        L_0x005a:
            r7 = r2
            goto L_0x0052
        L_0x005c:
            r3[r7] = r6
            int r5 = r5 + 1
            goto L_0x0042
        L_0x0061:
            r9.f22978b = r3
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: n20.e.b(java.lang.Class):n20.c");
    }

    public int d() {
        return this.f22977a.length;
    }
}
