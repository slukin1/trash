package com.iproov.sdk.network.model.proto;

import com.google.protobuf.Internal;

/* renamed from: com.iproov.sdk.network.model.proto.import  reason: invalid class name */
public enum Cimport implements Internal.EnumLite {
    NONE(0),
    UNRECOGNIZED(-1);
    

    /* renamed from: do  reason: not valid java name */
    private final int f1029do;

    /* renamed from: com.iproov.sdk.network.model.proto.import$do  reason: invalid class name */
    public class Cdo implements Internal.EnumLiteMap<Cimport> {
        /* renamed from: do  reason: not valid java name */
        public Cimport findValueByNumber(int i11) {
            return Cimport.m1175do(i11);
        }
    }

    /* access modifiers changed from: public */
    static {
        new Cdo();
    }

    private Cimport(int i11) {
        this.f1029do = i11;
    }

    /* renamed from: do  reason: not valid java name */
    public static Cimport m1175do(int i11) {
        if (i11 != 0) {
            return null;
        }
        return NONE;
    }

    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.f1029do;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
