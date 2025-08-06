package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.u;

public enum Field$Cardinality implements u.c {
    CARDINALITY_UNKNOWN(0),
    CARDINALITY_OPTIONAL(1),
    CARDINALITY_REQUIRED(2),
    CARDINALITY_REPEATED(3),
    UNRECOGNIZED(-1);
    
    public static final int CARDINALITY_OPTIONAL_VALUE = 1;
    public static final int CARDINALITY_REPEATED_VALUE = 3;
    public static final int CARDINALITY_REQUIRED_VALUE = 2;
    public static final int CARDINALITY_UNKNOWN_VALUE = 0;
    private static final u.d<Field$Cardinality> internalValueMap = null;
    private final int value;

    public static class a implements u.d<Field$Cardinality> {
        /* renamed from: a */
        public Field$Cardinality findValueByNumber(int i11) {
            return Field$Cardinality.forNumber(i11);
        }
    }

    public static final class b implements u.e {

        /* renamed from: a  reason: collision with root package name */
        public static final u.e f8999a = null;

        static {
            f8999a = new b();
        }

        public boolean isInRange(int i11) {
            return Field$Cardinality.forNumber(i11) != null;
        }
    }

    /* access modifiers changed from: public */
    static {
        internalValueMap = new a();
    }

    private Field$Cardinality(int i11) {
        this.value = i11;
    }

    public static Field$Cardinality forNumber(int i11) {
        if (i11 == 0) {
            return CARDINALITY_UNKNOWN;
        }
        if (i11 == 1) {
            return CARDINALITY_OPTIONAL;
        }
        if (i11 == 2) {
            return CARDINALITY_REQUIRED;
        }
        if (i11 != 3) {
            return null;
        }
        return CARDINALITY_REPEATED;
    }

    public static u.d<Field$Cardinality> internalGetValueMap() {
        return internalValueMap;
    }

    public static u.e internalGetVerifier() {
        return b.f8999a;
    }

    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.value;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    @Deprecated
    public static Field$Cardinality valueOf(int i11) {
        return forNumber(i11);
    }
}
