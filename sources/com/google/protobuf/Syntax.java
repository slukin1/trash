package com.google.protobuf;

import com.google.protobuf.Internal;

public enum Syntax implements Internal.EnumLite {
    SYNTAX_PROTO2(0),
    SYNTAX_PROTO3(1),
    UNRECOGNIZED(-1);
    
    public static final int SYNTAX_PROTO2_VALUE = 0;
    public static final int SYNTAX_PROTO3_VALUE = 1;
    private static final Internal.EnumLiteMap<Syntax> internalValueMap = null;
    private final int value;

    public static final class SyntaxVerifier implements Internal.EnumVerifier {
        public static final Internal.EnumVerifier INSTANCE = null;

        static {
            INSTANCE = new SyntaxVerifier();
        }

        private SyntaxVerifier() {
        }

        public boolean isInRange(int i11) {
            return Syntax.forNumber(i11) != null;
        }
    }

    /* access modifiers changed from: public */
    static {
        internalValueMap = new Internal.EnumLiteMap<Syntax>() {
            public Syntax findValueByNumber(int i11) {
                return Syntax.forNumber(i11);
            }
        };
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

    public static Internal.EnumLiteMap<Syntax> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return SyntaxVerifier.INSTANCE;
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
