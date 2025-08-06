package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.WireFormat;
import java.io.IOException;
import java.util.List;

public final class h implements s0 {

    /* renamed from: a  reason: collision with root package name */
    public final g f9143a;

    /* renamed from: b  reason: collision with root package name */
    public int f9144b;

    /* renamed from: c  reason: collision with root package name */
    public int f9145c;

    /* renamed from: d  reason: collision with root package name */
    public int f9146d = 0;

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f9147a;

        /* JADX WARNING: Can't wrap try/catch for region: R(36:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00a8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00c0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                androidx.datastore.preferences.protobuf.WireFormat$FieldType[] r0 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f9147a = r0
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.BOOL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f9147a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.BYTES     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f9147a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.DOUBLE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f9147a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.ENUM     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f9147a     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.FIXED32     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f9147a     // Catch:{ NoSuchFieldError -> 0x0049 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.FIXED64     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f9147a     // Catch:{ NoSuchFieldError -> 0x0054 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.FLOAT     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f9147a     // Catch:{ NoSuchFieldError -> 0x0060 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.INT32     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f9147a     // Catch:{ NoSuchFieldError -> 0x006c }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.INT64     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = f9147a     // Catch:{ NoSuchFieldError -> 0x0078 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.MESSAGE     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f9147a     // Catch:{ NoSuchFieldError -> 0x0084 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SFIXED32     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = f9147a     // Catch:{ NoSuchFieldError -> 0x0090 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SFIXED64     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = f9147a     // Catch:{ NoSuchFieldError -> 0x009c }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SINT32     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = f9147a     // Catch:{ NoSuchFieldError -> 0x00a8 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SINT64     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = f9147a     // Catch:{ NoSuchFieldError -> 0x00b4 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.STRING     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r0 = f9147a     // Catch:{ NoSuchFieldError -> 0x00c0 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.UINT32     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                int[] r0 = f9147a     // Catch:{ NoSuchFieldError -> 0x00cc }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.UINT64     // Catch:{ NoSuchFieldError -> 0x00cc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cc }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00cc }
            L_0x00cc:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.h.a.<clinit>():void");
        }
    }

    public h(g gVar) {
        g gVar2 = (g) u.b(gVar, "input");
        this.f9143a = gVar2;
        gVar2.f9113d = this;
    }

    public static h h(g gVar) {
        h hVar = gVar.f9113d;
        if (hVar != null) {
            return hVar;
        }
        return new h(gVar);
    }

    public <T> T a(t0<T> t0Var, l lVar) throws IOException {
        n(3);
        return j(t0Var, lVar);
    }

    public <T> T b(Class<T> cls, l lVar) throws IOException {
        n(2);
        return k(p0.a().d(cls), lVar);
    }

    public <T> T c(t0<T> t0Var, l lVar) throws IOException {
        n(2);
        return k(t0Var, lVar);
    }

    public <T> void d(List<T> list, t0<T> t0Var, l lVar) throws IOException {
        int C;
        if (WireFormat.b(this.f9144b) == 2) {
            int i11 = this.f9144b;
            do {
                list.add(k(t0Var, lVar));
                if (!this.f9143a.e() && this.f9146d == 0) {
                    C = this.f9143a.C();
                } else {
                    return;
                }
            } while (C == i11);
            this.f9146d = C;
            return;
        }
        throw InvalidProtocolBufferException.invalidWireType();
    }

    public <T> T e(Class<T> cls, l lVar) throws IOException {
        n(3);
        return j(p0.a().d(cls), lVar);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0053, code lost:
        if (skipField() != false) goto L_0x0055;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005b, code lost:
        throw new androidx.datastore.preferences.protobuf.InvalidProtocolBufferException("Unable to parse map entry.");
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x004f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <K, V> void f(java.util.Map<K, V> r8, androidx.datastore.preferences.protobuf.z.a<K, V> r9, androidx.datastore.preferences.protobuf.l r10) throws java.io.IOException {
        /*
            r7 = this;
            r0 = 2
            r7.n(r0)
            androidx.datastore.preferences.protobuf.g r1 = r7.f9143a
            int r1 = r1.D()
            androidx.datastore.preferences.protobuf.g r2 = r7.f9143a
            int r1 = r2.m(r1)
            K r2 = r9.f9257b
            V r3 = r9.f9259d
        L_0x0014:
            int r4 = r7.getFieldNumber()     // Catch:{ all -> 0x0065 }
            r5 = 2147483647(0x7fffffff, float:NaN)
            if (r4 == r5) goto L_0x005c
            androidx.datastore.preferences.protobuf.g r5 = r7.f9143a     // Catch:{ all -> 0x0065 }
            boolean r5 = r5.e()     // Catch:{ all -> 0x0065 }
            if (r5 == 0) goto L_0x0026
            goto L_0x005c
        L_0x0026:
            r5 = 1
            java.lang.String r6 = "Unable to parse map entry."
            if (r4 == r5) goto L_0x0047
            if (r4 == r0) goto L_0x003a
            boolean r4 = r7.skipField()     // Catch:{ InvalidWireTypeException -> 0x004f }
            if (r4 == 0) goto L_0x0034
            goto L_0x0014
        L_0x0034:
            androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r4 = new androidx.datastore.preferences.protobuf.InvalidProtocolBufferException     // Catch:{ InvalidWireTypeException -> 0x004f }
            r4.<init>((java.lang.String) r6)     // Catch:{ InvalidWireTypeException -> 0x004f }
            throw r4     // Catch:{ InvalidWireTypeException -> 0x004f }
        L_0x003a:
            androidx.datastore.preferences.protobuf.WireFormat$FieldType r4 = r9.f9258c     // Catch:{ InvalidWireTypeException -> 0x004f }
            V r5 = r9.f9259d     // Catch:{ InvalidWireTypeException -> 0x004f }
            java.lang.Class r5 = r5.getClass()     // Catch:{ InvalidWireTypeException -> 0x004f }
            java.lang.Object r3 = r7.i(r4, r5, r10)     // Catch:{ InvalidWireTypeException -> 0x004f }
            goto L_0x0014
        L_0x0047:
            androidx.datastore.preferences.protobuf.WireFormat$FieldType r4 = r9.f9256a     // Catch:{ InvalidWireTypeException -> 0x004f }
            r5 = 0
            java.lang.Object r2 = r7.i(r4, r5, r5)     // Catch:{ InvalidWireTypeException -> 0x004f }
            goto L_0x0014
        L_0x004f:
            boolean r4 = r7.skipField()     // Catch:{ all -> 0x0065 }
            if (r4 == 0) goto L_0x0056
            goto L_0x0014
        L_0x0056:
            androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r8 = new androidx.datastore.preferences.protobuf.InvalidProtocolBufferException     // Catch:{ all -> 0x0065 }
            r8.<init>((java.lang.String) r6)     // Catch:{ all -> 0x0065 }
            throw r8     // Catch:{ all -> 0x0065 }
        L_0x005c:
            r8.put(r2, r3)     // Catch:{ all -> 0x0065 }
            androidx.datastore.preferences.protobuf.g r8 = r7.f9143a
            r8.l(r1)
            return
        L_0x0065:
            r8 = move-exception
            androidx.datastore.preferences.protobuf.g r9 = r7.f9143a
            r9.l(r1)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.h.f(java.util.Map, androidx.datastore.preferences.protobuf.z$a, androidx.datastore.preferences.protobuf.l):void");
    }

    public <T> void g(List<T> list, t0<T> t0Var, l lVar) throws IOException {
        int C;
        if (WireFormat.b(this.f9144b) == 3) {
            int i11 = this.f9144b;
            do {
                list.add(j(t0Var, lVar));
                if (!this.f9143a.e() && this.f9146d == 0) {
                    C = this.f9143a.C();
                } else {
                    return;
                }
            } while (C == i11);
            this.f9146d = C;
            return;
        }
        throw InvalidProtocolBufferException.invalidWireType();
    }

    public int getFieldNumber() throws IOException {
        int i11 = this.f9146d;
        if (i11 != 0) {
            this.f9144b = i11;
            this.f9146d = 0;
        } else {
            this.f9144b = this.f9143a.C();
        }
        int i12 = this.f9144b;
        if (i12 == 0 || i12 == this.f9145c) {
            return Integer.MAX_VALUE;
        }
        return WireFormat.a(i12);
    }

    public int getTag() {
        return this.f9144b;
    }

    public final Object i(WireFormat.FieldType fieldType, Class<?> cls, l lVar) throws IOException {
        switch (a.f9147a[fieldType.ordinal()]) {
            case 1:
                return Boolean.valueOf(readBool());
            case 2:
                return readBytes();
            case 3:
                return Double.valueOf(readDouble());
            case 4:
                return Integer.valueOf(readEnum());
            case 5:
                return Integer.valueOf(readFixed32());
            case 6:
                return Long.valueOf(readFixed64());
            case 7:
                return Float.valueOf(readFloat());
            case 8:
                return Integer.valueOf(readInt32());
            case 9:
                return Long.valueOf(readInt64());
            case 10:
                return b(cls, lVar);
            case 11:
                return Integer.valueOf(readSFixed32());
            case 12:
                return Long.valueOf(readSFixed64());
            case 13:
                return Integer.valueOf(readSInt32());
            case 14:
                return Long.valueOf(readSInt64());
            case 15:
                return readStringRequireUtf8();
            case 16:
                return Integer.valueOf(readUInt32());
            case 17:
                return Long.valueOf(readUInt64());
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    public final <T> T j(t0<T> t0Var, l lVar) throws IOException {
        int i11 = this.f9145c;
        this.f9145c = WireFormat.c(WireFormat.a(this.f9144b), 4);
        try {
            T newInstance = t0Var.newInstance();
            t0Var.b(newInstance, this, lVar);
            t0Var.makeImmutable(newInstance);
            if (this.f9144b == this.f9145c) {
                return newInstance;
            }
            throw InvalidProtocolBufferException.parseFailure();
        } finally {
            this.f9145c = i11;
        }
    }

    public final <T> T k(t0<T> t0Var, l lVar) throws IOException {
        int D = this.f9143a.D();
        g gVar = this.f9143a;
        if (gVar.f9110a < gVar.f9111b) {
            int m11 = gVar.m(D);
            T newInstance = t0Var.newInstance();
            this.f9143a.f9110a++;
            t0Var.b(newInstance, this, lVar);
            t0Var.makeImmutable(newInstance);
            this.f9143a.a(0);
            g gVar2 = this.f9143a;
            gVar2.f9110a--;
            gVar2.l(m11);
            return newInstance;
        }
        throw InvalidProtocolBufferException.recursionLimitExceeded();
    }

    public void l(List<String> list, boolean z11) throws IOException {
        int C;
        int C2;
        if (WireFormat.b(this.f9144b) != 2) {
            throw InvalidProtocolBufferException.invalidWireType();
        } else if (!(list instanceof w) || z11) {
            do {
                list.add(z11 ? readStringRequireUtf8() : readString());
                if (!this.f9143a.e()) {
                    C = this.f9143a.C();
                } else {
                    return;
                }
            } while (C == this.f9144b);
            this.f9146d = C;
        } else {
            w wVar = (w) list;
            do {
                wVar.f(readBytes());
                if (!this.f9143a.e()) {
                    C2 = this.f9143a.C();
                } else {
                    return;
                }
            } while (C2 == this.f9144b);
            this.f9146d = C2;
        }
    }

    public final void m(int i11) throws IOException {
        if (this.f9143a.d() != i11) {
            throw InvalidProtocolBufferException.truncatedMessage();
        }
    }

    public final void n(int i11) throws IOException {
        if (WireFormat.b(this.f9144b) != i11) {
            throw InvalidProtocolBufferException.invalidWireType();
        }
    }

    public final void o(int i11) throws IOException {
        if ((i11 & 3) != 0) {
            throw InvalidProtocolBufferException.parseFailure();
        }
    }

    public final void p(int i11) throws IOException {
        if ((i11 & 7) != 0) {
            throw InvalidProtocolBufferException.parseFailure();
        }
    }

    public boolean readBool() throws IOException {
        n(0);
        return this.f9143a.n();
    }

    public void readBoolList(List<Boolean> list) throws IOException {
        int C;
        int C2;
        if (list instanceof e) {
            e eVar = (e) list;
            int b11 = WireFormat.b(this.f9144b);
            if (b11 == 0) {
                do {
                    eVar.addBoolean(this.f9143a.n());
                    if (!this.f9143a.e()) {
                        C2 = this.f9143a.C();
                    } else {
                        return;
                    }
                } while (C2 == this.f9144b);
                this.f9146d = C2;
            } else if (b11 == 2) {
                int d11 = this.f9143a.d() + this.f9143a.D();
                do {
                    eVar.addBoolean(this.f9143a.n());
                } while (this.f9143a.d() < d11);
                m(d11);
            } else {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        } else {
            int b12 = WireFormat.b(this.f9144b);
            if (b12 == 0) {
                do {
                    list.add(Boolean.valueOf(this.f9143a.n()));
                    if (!this.f9143a.e()) {
                        C = this.f9143a.C();
                    } else {
                        return;
                    }
                } while (C == this.f9144b);
                this.f9146d = C;
            } else if (b12 == 2) {
                int d12 = this.f9143a.d() + this.f9143a.D();
                do {
                    list.add(Boolean.valueOf(this.f9143a.n()));
                } while (this.f9143a.d() < d12);
                m(d12);
            } else {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        }
    }

    public ByteString readBytes() throws IOException {
        n(2);
        return this.f9143a.o();
    }

    public void readBytesList(List<ByteString> list) throws IOException {
        int C;
        if (WireFormat.b(this.f9144b) == 2) {
            do {
                list.add(readBytes());
                if (!this.f9143a.e()) {
                    C = this.f9143a.C();
                } else {
                    return;
                }
            } while (C == this.f9144b);
            this.f9146d = C;
            return;
        }
        throw InvalidProtocolBufferException.invalidWireType();
    }

    public double readDouble() throws IOException {
        n(1);
        return this.f9143a.p();
    }

    public void readDoubleList(List<Double> list) throws IOException {
        int C;
        int C2;
        if (list instanceof j) {
            j jVar = (j) list;
            int b11 = WireFormat.b(this.f9144b);
            if (b11 == 1) {
                do {
                    jVar.addDouble(this.f9143a.p());
                    if (!this.f9143a.e()) {
                        C2 = this.f9143a.C();
                    } else {
                        return;
                    }
                } while (C2 == this.f9144b);
                this.f9146d = C2;
            } else if (b11 == 2) {
                int D = this.f9143a.D();
                p(D);
                int d11 = this.f9143a.d() + D;
                do {
                    jVar.addDouble(this.f9143a.p());
                } while (this.f9143a.d() < d11);
            } else {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        } else {
            int b12 = WireFormat.b(this.f9144b);
            if (b12 == 1) {
                do {
                    list.add(Double.valueOf(this.f9143a.p()));
                    if (!this.f9143a.e()) {
                        C = this.f9143a.C();
                    } else {
                        return;
                    }
                } while (C == this.f9144b);
                this.f9146d = C;
            } else if (b12 == 2) {
                int D2 = this.f9143a.D();
                p(D2);
                int d12 = this.f9143a.d() + D2;
                do {
                    list.add(Double.valueOf(this.f9143a.p()));
                } while (this.f9143a.d() < d12);
            } else {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        }
    }

    public int readEnum() throws IOException {
        n(0);
        return this.f9143a.q();
    }

    public void readEnumList(List<Integer> list) throws IOException {
        int C;
        int C2;
        if (list instanceof t) {
            t tVar = (t) list;
            int b11 = WireFormat.b(this.f9144b);
            if (b11 == 0) {
                do {
                    tVar.addInt(this.f9143a.q());
                    if (!this.f9143a.e()) {
                        C2 = this.f9143a.C();
                    } else {
                        return;
                    }
                } while (C2 == this.f9144b);
                this.f9146d = C2;
            } else if (b11 == 2) {
                int d11 = this.f9143a.d() + this.f9143a.D();
                do {
                    tVar.addInt(this.f9143a.q());
                } while (this.f9143a.d() < d11);
                m(d11);
            } else {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        } else {
            int b12 = WireFormat.b(this.f9144b);
            if (b12 == 0) {
                do {
                    list.add(Integer.valueOf(this.f9143a.q()));
                    if (!this.f9143a.e()) {
                        C = this.f9143a.C();
                    } else {
                        return;
                    }
                } while (C == this.f9144b);
                this.f9146d = C;
            } else if (b12 == 2) {
                int d12 = this.f9143a.d() + this.f9143a.D();
                do {
                    list.add(Integer.valueOf(this.f9143a.q()));
                } while (this.f9143a.d() < d12);
                m(d12);
            } else {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        }
    }

    public int readFixed32() throws IOException {
        n(5);
        return this.f9143a.r();
    }

    public void readFixed32List(List<Integer> list) throws IOException {
        int C;
        int C2;
        if (list instanceof t) {
            t tVar = (t) list;
            int b11 = WireFormat.b(this.f9144b);
            if (b11 == 2) {
                int D = this.f9143a.D();
                o(D);
                int d11 = this.f9143a.d() + D;
                do {
                    tVar.addInt(this.f9143a.r());
                } while (this.f9143a.d() < d11);
            } else if (b11 == 5) {
                do {
                    tVar.addInt(this.f9143a.r());
                    if (!this.f9143a.e()) {
                        C2 = this.f9143a.C();
                    } else {
                        return;
                    }
                } while (C2 == this.f9144b);
                this.f9146d = C2;
            } else {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        } else {
            int b12 = WireFormat.b(this.f9144b);
            if (b12 == 2) {
                int D2 = this.f9143a.D();
                o(D2);
                int d12 = this.f9143a.d() + D2;
                do {
                    list.add(Integer.valueOf(this.f9143a.r()));
                } while (this.f9143a.d() < d12);
            } else if (b12 == 5) {
                do {
                    list.add(Integer.valueOf(this.f9143a.r()));
                    if (!this.f9143a.e()) {
                        C = this.f9143a.C();
                    } else {
                        return;
                    }
                } while (C == this.f9144b);
                this.f9146d = C;
            } else {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        }
    }

    public long readFixed64() throws IOException {
        n(1);
        return this.f9143a.s();
    }

    public void readFixed64List(List<Long> list) throws IOException {
        int C;
        int C2;
        if (list instanceof y) {
            y yVar = (y) list;
            int b11 = WireFormat.b(this.f9144b);
            if (b11 == 1) {
                do {
                    yVar.addLong(this.f9143a.s());
                    if (!this.f9143a.e()) {
                        C2 = this.f9143a.C();
                    } else {
                        return;
                    }
                } while (C2 == this.f9144b);
                this.f9146d = C2;
            } else if (b11 == 2) {
                int D = this.f9143a.D();
                p(D);
                int d11 = this.f9143a.d() + D;
                do {
                    yVar.addLong(this.f9143a.s());
                } while (this.f9143a.d() < d11);
            } else {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        } else {
            int b12 = WireFormat.b(this.f9144b);
            if (b12 == 1) {
                do {
                    list.add(Long.valueOf(this.f9143a.s()));
                    if (!this.f9143a.e()) {
                        C = this.f9143a.C();
                    } else {
                        return;
                    }
                } while (C == this.f9144b);
                this.f9146d = C;
            } else if (b12 == 2) {
                int D2 = this.f9143a.D();
                p(D2);
                int d12 = this.f9143a.d() + D2;
                do {
                    list.add(Long.valueOf(this.f9143a.s()));
                } while (this.f9143a.d() < d12);
            } else {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        }
    }

    public float readFloat() throws IOException {
        n(5);
        return this.f9143a.t();
    }

    public void readFloatList(List<Float> list) throws IOException {
        int C;
        int C2;
        if (list instanceof r) {
            r rVar = (r) list;
            int b11 = WireFormat.b(this.f9144b);
            if (b11 == 2) {
                int D = this.f9143a.D();
                o(D);
                int d11 = this.f9143a.d() + D;
                do {
                    rVar.addFloat(this.f9143a.t());
                } while (this.f9143a.d() < d11);
            } else if (b11 == 5) {
                do {
                    rVar.addFloat(this.f9143a.t());
                    if (!this.f9143a.e()) {
                        C2 = this.f9143a.C();
                    } else {
                        return;
                    }
                } while (C2 == this.f9144b);
                this.f9146d = C2;
            } else {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        } else {
            int b12 = WireFormat.b(this.f9144b);
            if (b12 == 2) {
                int D2 = this.f9143a.D();
                o(D2);
                int d12 = this.f9143a.d() + D2;
                do {
                    list.add(Float.valueOf(this.f9143a.t()));
                } while (this.f9143a.d() < d12);
            } else if (b12 == 5) {
                do {
                    list.add(Float.valueOf(this.f9143a.t()));
                    if (!this.f9143a.e()) {
                        C = this.f9143a.C();
                    } else {
                        return;
                    }
                } while (C == this.f9144b);
                this.f9146d = C;
            } else {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        }
    }

    public int readInt32() throws IOException {
        n(0);
        return this.f9143a.u();
    }

    public void readInt32List(List<Integer> list) throws IOException {
        int C;
        int C2;
        if (list instanceof t) {
            t tVar = (t) list;
            int b11 = WireFormat.b(this.f9144b);
            if (b11 == 0) {
                do {
                    tVar.addInt(this.f9143a.u());
                    if (!this.f9143a.e()) {
                        C2 = this.f9143a.C();
                    } else {
                        return;
                    }
                } while (C2 == this.f9144b);
                this.f9146d = C2;
            } else if (b11 == 2) {
                int d11 = this.f9143a.d() + this.f9143a.D();
                do {
                    tVar.addInt(this.f9143a.u());
                } while (this.f9143a.d() < d11);
                m(d11);
            } else {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        } else {
            int b12 = WireFormat.b(this.f9144b);
            if (b12 == 0) {
                do {
                    list.add(Integer.valueOf(this.f9143a.u()));
                    if (!this.f9143a.e()) {
                        C = this.f9143a.C();
                    } else {
                        return;
                    }
                } while (C == this.f9144b);
                this.f9146d = C;
            } else if (b12 == 2) {
                int d12 = this.f9143a.d() + this.f9143a.D();
                do {
                    list.add(Integer.valueOf(this.f9143a.u()));
                } while (this.f9143a.d() < d12);
                m(d12);
            } else {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        }
    }

    public long readInt64() throws IOException {
        n(0);
        return this.f9143a.v();
    }

    public void readInt64List(List<Long> list) throws IOException {
        int C;
        int C2;
        if (list instanceof y) {
            y yVar = (y) list;
            int b11 = WireFormat.b(this.f9144b);
            if (b11 == 0) {
                do {
                    yVar.addLong(this.f9143a.v());
                    if (!this.f9143a.e()) {
                        C2 = this.f9143a.C();
                    } else {
                        return;
                    }
                } while (C2 == this.f9144b);
                this.f9146d = C2;
            } else if (b11 == 2) {
                int d11 = this.f9143a.d() + this.f9143a.D();
                do {
                    yVar.addLong(this.f9143a.v());
                } while (this.f9143a.d() < d11);
                m(d11);
            } else {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        } else {
            int b12 = WireFormat.b(this.f9144b);
            if (b12 == 0) {
                do {
                    list.add(Long.valueOf(this.f9143a.v()));
                    if (!this.f9143a.e()) {
                        C = this.f9143a.C();
                    } else {
                        return;
                    }
                } while (C == this.f9144b);
                this.f9146d = C;
            } else if (b12 == 2) {
                int d12 = this.f9143a.d() + this.f9143a.D();
                do {
                    list.add(Long.valueOf(this.f9143a.v()));
                } while (this.f9143a.d() < d12);
                m(d12);
            } else {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        }
    }

    public int readSFixed32() throws IOException {
        n(5);
        return this.f9143a.w();
    }

    public void readSFixed32List(List<Integer> list) throws IOException {
        int C;
        int C2;
        if (list instanceof t) {
            t tVar = (t) list;
            int b11 = WireFormat.b(this.f9144b);
            if (b11 == 2) {
                int D = this.f9143a.D();
                o(D);
                int d11 = this.f9143a.d() + D;
                do {
                    tVar.addInt(this.f9143a.w());
                } while (this.f9143a.d() < d11);
            } else if (b11 == 5) {
                do {
                    tVar.addInt(this.f9143a.w());
                    if (!this.f9143a.e()) {
                        C2 = this.f9143a.C();
                    } else {
                        return;
                    }
                } while (C2 == this.f9144b);
                this.f9146d = C2;
            } else {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        } else {
            int b12 = WireFormat.b(this.f9144b);
            if (b12 == 2) {
                int D2 = this.f9143a.D();
                o(D2);
                int d12 = this.f9143a.d() + D2;
                do {
                    list.add(Integer.valueOf(this.f9143a.w()));
                } while (this.f9143a.d() < d12);
            } else if (b12 == 5) {
                do {
                    list.add(Integer.valueOf(this.f9143a.w()));
                    if (!this.f9143a.e()) {
                        C = this.f9143a.C();
                    } else {
                        return;
                    }
                } while (C == this.f9144b);
                this.f9146d = C;
            } else {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        }
    }

    public long readSFixed64() throws IOException {
        n(1);
        return this.f9143a.x();
    }

    public void readSFixed64List(List<Long> list) throws IOException {
        int C;
        int C2;
        if (list instanceof y) {
            y yVar = (y) list;
            int b11 = WireFormat.b(this.f9144b);
            if (b11 == 1) {
                do {
                    yVar.addLong(this.f9143a.x());
                    if (!this.f9143a.e()) {
                        C2 = this.f9143a.C();
                    } else {
                        return;
                    }
                } while (C2 == this.f9144b);
                this.f9146d = C2;
            } else if (b11 == 2) {
                int D = this.f9143a.D();
                p(D);
                int d11 = this.f9143a.d() + D;
                do {
                    yVar.addLong(this.f9143a.x());
                } while (this.f9143a.d() < d11);
            } else {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        } else {
            int b12 = WireFormat.b(this.f9144b);
            if (b12 == 1) {
                do {
                    list.add(Long.valueOf(this.f9143a.x()));
                    if (!this.f9143a.e()) {
                        C = this.f9143a.C();
                    } else {
                        return;
                    }
                } while (C == this.f9144b);
                this.f9146d = C;
            } else if (b12 == 2) {
                int D2 = this.f9143a.D();
                p(D2);
                int d12 = this.f9143a.d() + D2;
                do {
                    list.add(Long.valueOf(this.f9143a.x()));
                } while (this.f9143a.d() < d12);
            } else {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        }
    }

    public int readSInt32() throws IOException {
        n(0);
        return this.f9143a.y();
    }

    public void readSInt32List(List<Integer> list) throws IOException {
        int C;
        int C2;
        if (list instanceof t) {
            t tVar = (t) list;
            int b11 = WireFormat.b(this.f9144b);
            if (b11 == 0) {
                do {
                    tVar.addInt(this.f9143a.y());
                    if (!this.f9143a.e()) {
                        C2 = this.f9143a.C();
                    } else {
                        return;
                    }
                } while (C2 == this.f9144b);
                this.f9146d = C2;
            } else if (b11 == 2) {
                int d11 = this.f9143a.d() + this.f9143a.D();
                do {
                    tVar.addInt(this.f9143a.y());
                } while (this.f9143a.d() < d11);
                m(d11);
            } else {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        } else {
            int b12 = WireFormat.b(this.f9144b);
            if (b12 == 0) {
                do {
                    list.add(Integer.valueOf(this.f9143a.y()));
                    if (!this.f9143a.e()) {
                        C = this.f9143a.C();
                    } else {
                        return;
                    }
                } while (C == this.f9144b);
                this.f9146d = C;
            } else if (b12 == 2) {
                int d12 = this.f9143a.d() + this.f9143a.D();
                do {
                    list.add(Integer.valueOf(this.f9143a.y()));
                } while (this.f9143a.d() < d12);
                m(d12);
            } else {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        }
    }

    public long readSInt64() throws IOException {
        n(0);
        return this.f9143a.z();
    }

    public void readSInt64List(List<Long> list) throws IOException {
        int C;
        int C2;
        if (list instanceof y) {
            y yVar = (y) list;
            int b11 = WireFormat.b(this.f9144b);
            if (b11 == 0) {
                do {
                    yVar.addLong(this.f9143a.z());
                    if (!this.f9143a.e()) {
                        C2 = this.f9143a.C();
                    } else {
                        return;
                    }
                } while (C2 == this.f9144b);
                this.f9146d = C2;
            } else if (b11 == 2) {
                int d11 = this.f9143a.d() + this.f9143a.D();
                do {
                    yVar.addLong(this.f9143a.z());
                } while (this.f9143a.d() < d11);
                m(d11);
            } else {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        } else {
            int b12 = WireFormat.b(this.f9144b);
            if (b12 == 0) {
                do {
                    list.add(Long.valueOf(this.f9143a.z()));
                    if (!this.f9143a.e()) {
                        C = this.f9143a.C();
                    } else {
                        return;
                    }
                } while (C == this.f9144b);
                this.f9146d = C;
            } else if (b12 == 2) {
                int d12 = this.f9143a.d() + this.f9143a.D();
                do {
                    list.add(Long.valueOf(this.f9143a.z()));
                } while (this.f9143a.d() < d12);
                m(d12);
            } else {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        }
    }

    public String readString() throws IOException {
        n(2);
        return this.f9143a.A();
    }

    public void readStringList(List<String> list) throws IOException {
        l(list, false);
    }

    public void readStringListRequireUtf8(List<String> list) throws IOException {
        l(list, true);
    }

    public String readStringRequireUtf8() throws IOException {
        n(2);
        return this.f9143a.B();
    }

    public int readUInt32() throws IOException {
        n(0);
        return this.f9143a.D();
    }

    public void readUInt32List(List<Integer> list) throws IOException {
        int C;
        int C2;
        if (list instanceof t) {
            t tVar = (t) list;
            int b11 = WireFormat.b(this.f9144b);
            if (b11 == 0) {
                do {
                    tVar.addInt(this.f9143a.D());
                    if (!this.f9143a.e()) {
                        C2 = this.f9143a.C();
                    } else {
                        return;
                    }
                } while (C2 == this.f9144b);
                this.f9146d = C2;
            } else if (b11 == 2) {
                int d11 = this.f9143a.d() + this.f9143a.D();
                do {
                    tVar.addInt(this.f9143a.D());
                } while (this.f9143a.d() < d11);
                m(d11);
            } else {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        } else {
            int b12 = WireFormat.b(this.f9144b);
            if (b12 == 0) {
                do {
                    list.add(Integer.valueOf(this.f9143a.D()));
                    if (!this.f9143a.e()) {
                        C = this.f9143a.C();
                    } else {
                        return;
                    }
                } while (C == this.f9144b);
                this.f9146d = C;
            } else if (b12 == 2) {
                int d12 = this.f9143a.d() + this.f9143a.D();
                do {
                    list.add(Integer.valueOf(this.f9143a.D()));
                } while (this.f9143a.d() < d12);
                m(d12);
            } else {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        }
    }

    public long readUInt64() throws IOException {
        n(0);
        return this.f9143a.E();
    }

    public void readUInt64List(List<Long> list) throws IOException {
        int C;
        int C2;
        if (list instanceof y) {
            y yVar = (y) list;
            int b11 = WireFormat.b(this.f9144b);
            if (b11 == 0) {
                do {
                    yVar.addLong(this.f9143a.E());
                    if (!this.f9143a.e()) {
                        C2 = this.f9143a.C();
                    } else {
                        return;
                    }
                } while (C2 == this.f9144b);
                this.f9146d = C2;
            } else if (b11 == 2) {
                int d11 = this.f9143a.d() + this.f9143a.D();
                do {
                    yVar.addLong(this.f9143a.E());
                } while (this.f9143a.d() < d11);
                m(d11);
            } else {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        } else {
            int b12 = WireFormat.b(this.f9144b);
            if (b12 == 0) {
                do {
                    list.add(Long.valueOf(this.f9143a.E()));
                    if (!this.f9143a.e()) {
                        C = this.f9143a.C();
                    } else {
                        return;
                    }
                } while (C == this.f9144b);
                this.f9146d = C;
            } else if (b12 == 2) {
                int d12 = this.f9143a.d() + this.f9143a.D();
                do {
                    list.add(Long.valueOf(this.f9143a.E()));
                } while (this.f9143a.d() < d12);
                m(d12);
            } else {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        }
    }

    public boolean skipField() throws IOException {
        int i11;
        if (this.f9143a.e() || (i11 = this.f9144b) == this.f9145c) {
            return false;
        }
        return this.f9143a.F(i11);
    }
}
