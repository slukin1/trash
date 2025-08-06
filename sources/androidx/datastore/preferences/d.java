package androidx.datastore.preferences;

import androidx.datastore.preferences.protobuf.AbstractMessageLite;
import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import androidx.datastore.preferences.protobuf.g0;
import androidx.datastore.preferences.protobuf.n0;
import androidx.datastore.preferences.protobuf.u;
import java.util.List;

public final class d extends GeneratedMessageLite<d, a> implements g0 {
    /* access modifiers changed from: private */
    public static final d DEFAULT_INSTANCE;
    private static volatile n0<d> PARSER = null;
    public static final int STRINGS_FIELD_NUMBER = 1;
    private u.i<String> strings_ = GeneratedMessageLite.p();

    public static final class a extends GeneratedMessageLite.a<d, a> implements g0 {
        public /* synthetic */ a(b bVar) {
            this();
        }

        public a y(Iterable<String> iterable) {
            q();
            ((d) this.f9005c).E(iterable);
            return this;
        }

        public a() {
            super(d.DEFAULT_INSTANCE);
        }
    }

    static {
        d dVar = new d();
        DEFAULT_INSTANCE = dVar;
        GeneratedMessageLite.A(d.class, dVar);
    }

    public static d G() {
        return DEFAULT_INSTANCE;
    }

    public static a I() {
        return (a) DEFAULT_INSTANCE.l();
    }

    public final void E(Iterable<String> iterable) {
        F();
        AbstractMessageLite.c(iterable, this.strings_);
    }

    public final void F() {
        if (!this.strings_.isModifiable()) {
            this.strings_ = GeneratedMessageLite.v(this.strings_);
        }
    }

    public List<String> H() {
        return this.strings_;
    }

    public final Object o(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (b.f8961a[methodToInvoke.ordinal()]) {
            case 1:
                return new d();
            case 2:
                return new a((b) null);
            case 3:
                return GeneratedMessageLite.x(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001a", new Object[]{"strings_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                n0<d> n0Var = PARSER;
                if (n0Var == null) {
                    synchronized (d.class) {
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
