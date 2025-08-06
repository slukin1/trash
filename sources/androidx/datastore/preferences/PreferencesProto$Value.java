package androidx.datastore.preferences;

import androidx.datastore.preferences.d;
import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import androidx.datastore.preferences.protobuf.g0;
import androidx.datastore.preferences.protobuf.n0;
import java.util.Objects;

public final class PreferencesProto$Value extends GeneratedMessageLite<PreferencesProto$Value, a> implements g0 {
    public static final int BOOLEAN_FIELD_NUMBER = 1;
    /* access modifiers changed from: private */
    public static final PreferencesProto$Value DEFAULT_INSTANCE;
    public static final int DOUBLE_FIELD_NUMBER = 7;
    public static final int FLOAT_FIELD_NUMBER = 2;
    public static final int INTEGER_FIELD_NUMBER = 3;
    public static final int LONG_FIELD_NUMBER = 4;
    private static volatile n0<PreferencesProto$Value> PARSER = null;
    public static final int STRING_FIELD_NUMBER = 5;
    public static final int STRING_SET_FIELD_NUMBER = 6;
    private int bitField0_;
    private int valueCase_ = 0;
    private Object value_;

    public enum ValueCase {
        BOOLEAN(1),
        FLOAT(2),
        INTEGER(3),
        LONG(4),
        STRING(5),
        STRING_SET(6),
        DOUBLE(7),
        VALUE_NOT_SET(0);
        
        private final int value;

        private ValueCase(int i11) {
            this.value = i11;
        }

        public static ValueCase forNumber(int i11) {
            switch (i11) {
                case 0:
                    return VALUE_NOT_SET;
                case 1:
                    return BOOLEAN;
                case 2:
                    return FLOAT;
                case 3:
                    return INTEGER;
                case 4:
                    return LONG;
                case 5:
                    return STRING;
                case 6:
                    return STRING_SET;
                case 7:
                    return DOUBLE;
                default:
                    return null;
            }
        }

        public int getNumber() {
            return this.value;
        }

        @Deprecated
        public static ValueCase valueOf(int i11) {
            return forNumber(i11);
        }
    }

    public static final class a extends GeneratedMessageLite.a<PreferencesProto$Value, a> implements g0 {
        public /* synthetic */ a(b bVar) {
            this();
        }

        public a A(float f11) {
            q();
            ((PreferencesProto$Value) this.f9005c).W(f11);
            return this;
        }

        public a B(int i11) {
            q();
            ((PreferencesProto$Value) this.f9005c).X(i11);
            return this;
        }

        public a C(long j11) {
            q();
            ((PreferencesProto$Value) this.f9005c).Y(j11);
            return this;
        }

        public a D(String str) {
            q();
            ((PreferencesProto$Value) this.f9005c).Z(str);
            return this;
        }

        public a E(d.a aVar) {
            q();
            ((PreferencesProto$Value) this.f9005c).a0(aVar);
            return this;
        }

        public a y(boolean z11) {
            q();
            ((PreferencesProto$Value) this.f9005c).U(z11);
            return this;
        }

        public a z(double d11) {
            q();
            ((PreferencesProto$Value) this.f9005c).V(d11);
            return this;
        }

        public a() {
            super(PreferencesProto$Value.DEFAULT_INSTANCE);
        }
    }

    static {
        PreferencesProto$Value preferencesProto$Value = new PreferencesProto$Value();
        DEFAULT_INSTANCE = preferencesProto$Value;
        GeneratedMessageLite.A(PreferencesProto$Value.class, preferencesProto$Value);
    }

    public static PreferencesProto$Value L() {
        return DEFAULT_INSTANCE;
    }

    public static a T() {
        return (a) DEFAULT_INSTANCE.l();
    }

    public boolean K() {
        if (this.valueCase_ == 1) {
            return ((Boolean) this.value_).booleanValue();
        }
        return false;
    }

    public double M() {
        if (this.valueCase_ == 7) {
            return ((Double) this.value_).doubleValue();
        }
        return 0.0d;
    }

    public float N() {
        if (this.valueCase_ == 2) {
            return ((Float) this.value_).floatValue();
        }
        return 0.0f;
    }

    public int O() {
        if (this.valueCase_ == 3) {
            return ((Integer) this.value_).intValue();
        }
        return 0;
    }

    public long P() {
        if (this.valueCase_ == 4) {
            return ((Long) this.value_).longValue();
        }
        return 0;
    }

    public String Q() {
        return this.valueCase_ == 5 ? (String) this.value_ : "";
    }

    public d R() {
        if (this.valueCase_ == 6) {
            return (d) this.value_;
        }
        return d.G();
    }

    public ValueCase S() {
        return ValueCase.forNumber(this.valueCase_);
    }

    public final void U(boolean z11) {
        this.valueCase_ = 1;
        this.value_ = Boolean.valueOf(z11);
    }

    public final void V(double d11) {
        this.valueCase_ = 7;
        this.value_ = Double.valueOf(d11);
    }

    public final void W(float f11) {
        this.valueCase_ = 2;
        this.value_ = Float.valueOf(f11);
    }

    public final void X(int i11) {
        this.valueCase_ = 3;
        this.value_ = Integer.valueOf(i11);
    }

    public final void Y(long j11) {
        this.valueCase_ = 4;
        this.value_ = Long.valueOf(j11);
    }

    public final void Z(String str) {
        Objects.requireNonNull(str);
        this.valueCase_ = 5;
        this.value_ = str;
    }

    public final void a0(d.a aVar) {
        this.value_ = aVar.build();
        this.valueCase_ = 6;
    }

    public final Object o(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (b.f8961a[methodToInvoke.ordinal()]) {
            case 1:
                return new PreferencesProto$Value();
            case 2:
                return new a((b) null);
            case 3:
                return GeneratedMessageLite.x(DEFAULT_INSTANCE, "\u0001\u0007\u0001\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001:\u0000\u00024\u0000\u00037\u0000\u00045\u0000\u0005;\u0000\u0006<\u0000\u00073\u0000", new Object[]{"value_", "valueCase_", "bitField0_", d.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                n0<PreferencesProto$Value> n0Var = PARSER;
                if (n0Var == null) {
                    synchronized (PreferencesProto$Value.class) {
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
