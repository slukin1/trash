package androidx.datastore.preferences.protobuf;

final class ManifestSchemaFactory implements u0 {

    /* renamed from: b  reason: collision with root package name */
    public static final e0 f9023b = new a();

    /* renamed from: a  reason: collision with root package name */
    public final e0 f9024a;

    public static class a implements e0 {
        public boolean isSupported(Class<?> cls) {
            return false;
        }

        public d0 messageInfoFor(Class<?> cls) {
            throw new IllegalStateException("This should never be called.");
        }
    }

    public static class b implements e0 {

        /* renamed from: a  reason: collision with root package name */
        public e0[] f9025a;

        public b(e0... e0VarArr) {
            this.f9025a = e0VarArr;
        }

        public boolean isSupported(Class<?> cls) {
            for (e0 isSupported : this.f9025a) {
                if (isSupported.isSupported(cls)) {
                    return true;
                }
            }
            return false;
        }

        public d0 messageInfoFor(Class<?> cls) {
            for (e0 e0Var : this.f9025a) {
                if (e0Var.isSupported(cls)) {
                    return e0Var.messageInfoFor(cls);
                }
            }
            throw new UnsupportedOperationException("No factory is available for message type: " + cls.getName());
        }
    }

    public ManifestSchemaFactory() {
        this(a());
    }

    public static e0 a() {
        return new b(s.a(), b());
    }

    public static e0 b() {
        try {
            return (e0) Class.forName("androidx.datastore.preferences.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (Exception unused) {
            return f9023b;
        }
    }

    public static boolean c(d0 d0Var) {
        return d0Var.getSyntax() == ProtoSyntax.PROTO2;
    }

    public static <T> t0<T> d(Class<T> cls, d0 d0Var) {
        if (GeneratedMessageLite.class.isAssignableFrom(cls)) {
            if (c(d0Var)) {
                return i0.K(cls, d0Var, m0.b(), x.b(), v0.M(), o.b(), c0.b());
            }
            return i0.K(cls, d0Var, m0.b(), x.b(), v0.M(), (m<?>) null, c0.b());
        } else if (c(d0Var)) {
            return i0.K(cls, d0Var, m0.a(), x.a(), v0.H(), o.a(), c0.a());
        } else {
            return i0.K(cls, d0Var, m0.a(), x.a(), v0.I(), (m<?>) null, c0.a());
        }
    }

    public <T> t0<T> createSchema(Class<T> cls) {
        v0.J(cls);
        d0 messageInfoFor = this.f9024a.messageInfoFor(cls);
        if (!messageInfoFor.isMessageSetWireFormat()) {
            return d(cls, messageInfoFor);
        }
        if (GeneratedMessageLite.class.isAssignableFrom(cls)) {
            return j0.f(v0.M(), o.b(), messageInfoFor.getDefaultInstance());
        }
        return j0.f(v0.H(), o.a(), messageInfoFor.getDefaultInstance());
    }

    public ManifestSchemaFactory(e0 e0Var) {
        this.f9024a = (e0) u.b(e0Var, "messageInfoFactory");
    }
}
