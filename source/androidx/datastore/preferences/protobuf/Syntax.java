package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.u;

public enum Syntax implements u.c {
    SYNTAX_PROTO2(0),
    SYNTAX_PROTO3(1),
    UNRECOGNIZED(-1);
    
    public static final int SYNTAX_PROTO2_VALUE = 0;
    public static final int SYNTAX_PROTO3_VALUE = 1;
    private static final u.d<Syntax> internalValueMap = null;
    private final int value;

    public static class a implements u.d<Syntax> {
        /* renamed from: a */
        public Syntax findValueByNumber(int i11) {
            return Syntax.forNumber(i11);
        }
    }

    public static final class b implements u.e {

        /* renamed from: a  reason: collision with root package name */
        public static final u.e f9049a = null;

        static {
            f9049a = new b();
        }

        public boolean isInRange(int i11) {
            return Syntax.forNumber(i11) != null;
        }
    }

    /* access modifiers changed from: public */
    static {
        internalValueMap = new a();
    }

    private Syntax(int i11) {
        this.value = i11;
    }

    public static Syntax forNumber(int i11) {
        if (i11 == 0) {
            return SYNTAX_PROTO2;
        }
        if (i11 != 1) {
            return null;
        }
        return SYNTAX_PROTO3;
    }

    public static u.d<Syntax> internalGetValueMap() {
        return internalValueMap;
    }

    public static u.e internalGetVerifier() {
        return b.f9049a;
    }

    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.value;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    @Deprecated
    public static Syntax valueOf(int i11) {
        return forNumber(i11);
    }
}
