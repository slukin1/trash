package androidx.datastore.preferences.protobuf;

public class LazyFieldLite {

    /* renamed from: e  reason: collision with root package name */
    public static final l f9015e = l.b();

    /* renamed from: a  reason: collision with root package name */
    public ByteString f9016a;

    /* renamed from: b  reason: collision with root package name */
    public l f9017b;

    /* renamed from: c  reason: collision with root package name */
    public volatile f0 f9018c;

    /* renamed from: d  reason: collision with root package name */
    public volatile ByteString f9019d;

    /* JADX WARNING: Can't wrap try/catch for region: R(2:14|15) */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        r3.f9018c = r4;
        r3.f9019d = androidx.datastore.preferences.protobuf.ByteString.EMPTY;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x002c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(androidx.datastore.preferences.protobuf.f0 r4) {
        /*
            r3 = this;
            androidx.datastore.preferences.protobuf.f0 r0 = r3.f9018c
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            monitor-enter(r3)
            androidx.datastore.preferences.protobuf.f0 r0 = r3.f9018c     // Catch:{ all -> 0x0034 }
            if (r0 == 0) goto L_0x000c
            monitor-exit(r3)     // Catch:{ all -> 0x0034 }
            return
        L_0x000c:
            androidx.datastore.preferences.protobuf.ByteString r0 = r3.f9016a     // Catch:{ InvalidProtocolBufferException -> 0x002c }
            if (r0 == 0) goto L_0x0025
            androidx.datastore.preferences.protobuf.n0 r0 = r4.getParserForType()     // Catch:{ InvalidProtocolBufferException -> 0x002c }
            androidx.datastore.preferences.protobuf.ByteString r1 = r3.f9016a     // Catch:{ InvalidProtocolBufferException -> 0x002c }
            androidx.datastore.preferences.protobuf.l r2 = r3.f9017b     // Catch:{ InvalidProtocolBufferException -> 0x002c }
            java.lang.Object r0 = r0.b(r1, r2)     // Catch:{ InvalidProtocolBufferException -> 0x002c }
            androidx.datastore.preferences.protobuf.f0 r0 = (androidx.datastore.preferences.protobuf.f0) r0     // Catch:{ InvalidProtocolBufferException -> 0x002c }
            r3.f9018c = r0     // Catch:{ InvalidProtocolBufferException -> 0x002c }
            androidx.datastore.preferences.protobuf.ByteString r0 = r3.f9016a     // Catch:{ InvalidProtocolBufferException -> 0x002c }
            r3.f9019d = r0     // Catch:{ InvalidProtocolBufferException -> 0x002c }
            goto L_0x0032
        L_0x0025:
            r3.f9018c = r4     // Catch:{ InvalidProtocolBufferException -> 0x002c }
            androidx.datastore.preferences.protobuf.ByteString r0 = androidx.datastore.preferences.protobuf.ByteString.EMPTY     // Catch:{ InvalidProtocolBufferException -> 0x002c }
            r3.f9019d = r0     // Catch:{ InvalidProtocolBufferException -> 0x002c }
            goto L_0x0032
        L_0x002c:
            r3.f9018c = r4     // Catch:{ all -> 0x0034 }
            androidx.datastore.preferences.protobuf.ByteString r4 = androidx.datastore.preferences.protobuf.ByteString.EMPTY     // Catch:{ all -> 0x0034 }
            r3.f9019d = r4     // Catch:{ all -> 0x0034 }
        L_0x0032:
            monitor-exit(r3)     // Catch:{ all -> 0x0034 }
            return
        L_0x0034:
            r4 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0034 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.LazyFieldLite.a(androidx.datastore.preferences.protobuf.f0):void");
    }

    public int b() {
        if (this.f9019d != null) {
            return this.f9019d.size();
        }
        ByteString byteString = this.f9016a;
        if (byteString != null) {
            return byteString.size();
        }
        if (this.f9018c != null) {
            return this.f9018c.getSerializedSize();
        }
        return 0;
    }

    public f0 c(f0 f0Var) {
        a(f0Var);
        return this.f9018c;
    }

    public f0 d(f0 f0Var) {
        f0 f0Var2 = this.f9018c;
        this.f9016a = null;
        this.f9019d = null;
        this.f9018c = f0Var;
        return f0Var2;
    }

    public ByteString e() {
        if (this.f9019d != null) {
            return this.f9019d;
        }
        ByteString byteString = this.f9016a;
        if (byteString != null) {
            return byteString;
        }
        synchronized (this) {
            if (this.f9019d != null) {
                ByteString byteString2 = this.f9019d;
                return byteString2;
            }
            if (this.f9018c == null) {
                this.f9019d = ByteString.EMPTY;
            } else {
                this.f9019d = this.f9018c.toByteString();
            }
            ByteString byteString3 = this.f9019d;
            return byteString3;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LazyFieldLite)) {
            return false;
        }
        LazyFieldLite lazyFieldLite = (LazyFieldLite) obj;
        f0 f0Var = this.f9018c;
        f0 f0Var2 = lazyFieldLite.f9018c;
        if (f0Var == null && f0Var2 == null) {
            return e().equals(lazyFieldLite.e());
        }
        if (f0Var != null && f0Var2 != null) {
            return f0Var.equals(f0Var2);
        }
        if (f0Var != null) {
            return f0Var.equals(lazyFieldLite.c(f0Var.getDefaultInstanceForType()));
        }
        return c(f0Var2.getDefaultInstanceForType()).equals(f0Var2);
    }

    public int hashCode() {
        return 1;
    }
}
