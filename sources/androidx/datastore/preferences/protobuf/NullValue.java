package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.u;

public enum NullValue implements u.c {
    NULL_VALUE(0),
    UNRECOGNIZED(-1);
    
    public static final int NULL_VALUE_VALUE = 0;
    private static final u.d<NullValue> internalValueMap = null;
    private final int value;

    public static class a implements u.d<NullValue> {
        /* renamed from: a */
        public NullValue findValueByNumber(int i11) {
            return NullValue.forNumber(i11);
        }
    }

    public static final class b implements u.e {

        /* renamed from: a  reason: collision with root package name */
        public static final u.e f9028a = null;

        static {
            f9028a = new b();
        }

        public boolean isInRange(int i11) {
            return NullValue.forNumber(i11) != null;
        }
    }

    /* access modifiers changed from: public */
    static {
        internalValueMap = new a();
    }

    private NullValue(int i11) {
        this.value = i11;
    }

    public static NullValue forNumber(int i11) {
        if (i11 != 0) {
            return null;
        }
        return NULL_VALUE;
    }

    public static u.d<NullValue> internalGetValueMap() {
        return internalValueMap;
    }

    public static u.e internalGetVerifier() {
        return b.f9028a;
    }

    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.value;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    @Deprecated
    public static NullValue valueOf(int i11) {
        return forNumber(i11);
    }
}
