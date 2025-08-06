package androidx.datastore.preferences;

import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import androidx.datastore.preferences.protobuf.MapFieldLite;
import androidx.datastore.preferences.protobuf.WireFormat;
import androidx.datastore.preferences.protobuf.g0;
import androidx.datastore.preferences.protobuf.n0;
import androidx.datastore.preferences.protobuf.z;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;

public final class c extends GeneratedMessageLite<c, a> implements g0 {
    /* access modifiers changed from: private */
    public static final c DEFAULT_INSTANCE;
    private static volatile n0<c> PARSER = null;
    public static final int PREFERENCES_FIELD_NUMBER = 1;
    private MapFieldLite<String, PreferencesProto$Value> preferences_ = MapFieldLite.emptyMapField();

    public static final class a extends GeneratedMessageLite.a<c, a> implements g0 {
        public /* synthetic */ a(b bVar) {
            this();
        }

        public a y(String str, PreferencesProto$Value preferencesProto$Value) {
            Objects.requireNonNull(str);
            Objects.requireNonNull(preferencesProto$Value);
            q();
            ((c) this.f9005c).E().put(str, preferencesProto$Value);
            return this;
        }

        public a() {
            super(c.DEFAULT_INSTANCE);
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public static final z<String, PreferencesProto$Value> f8962a = z.d(WireFormat.FieldType.STRING, "", WireFormat.FieldType.MESSAGE, PreferencesProto$Value.L());
    }

    static {
        c cVar = new c();
        DEFAULT_INSTANCE = cVar;
        GeneratedMessageLite.A(c.class, cVar);
    }

    public static a I() {
        return (a) DEFAULT_INSTANCE.l();
    }

    public static c J(InputStream inputStream) throws IOException {
        return (c) GeneratedMessageLite.y(DEFAULT_INSTANCE, inputStream);
    }

    public final Map<String, PreferencesProto$Value> E() {
        return G();
    }

    public Map<String, PreferencesProto$Value> F() {
        return Collections.unmodifiableMap(H());
    }

    public final MapFieldLite<String, PreferencesProto$Value> G() {
        if (!this.preferences_.isMutable()) {
            this.preferences_ = this.preferences_.mutableCopy();
        }
        return this.preferences_;
    }

    public final MapFieldLite<String, PreferencesProto$Value> H() {
        return this.preferences_;
    }

    public final Object o(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (b.f8961a[methodToInvoke.ordinal()]) {
            case 1:
                return new c();
            case 2:
                return new a((b) null);
            case 3:
                return GeneratedMessageLite.x(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u00012", new Object[]{"preferences_", b.f8962a});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                n0<c> n0Var = PARSER;
                if (n0Var == null) {
                    synchronized (c.class) {
                        n0Var = PARSER;
                        if (n0Var == null) {
                            n0Var = new GeneratedMessageLite.b<>(DEFAULT_INSTANCE);
                            PARSER = n0Var;
                        }
                    }
                }
                return n0Var;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }
}
