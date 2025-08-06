package com.iproov.sdk.network.model.proto;

import com.google.protobuf.Internal;

/* renamed from: com.iproov.sdk.network.model.proto.new  reason: invalid class name */
public enum Cnew implements Internal.EnumLite {
    DEBUG(0),
    LOG(1),
    WARN(2),
    ERROR(3),
    UNRECOGNIZED(-1);
    

    /* renamed from: do  reason: not valid java name */
    private final int f1036do;

    /* renamed from: com.iproov.sdk.network.model.proto.new$do  reason: invalid class name */
    public class Cdo implements Internal.EnumLiteMap<Cnew> {
        /* renamed from: do  reason: not valid java name */
        public Cnew findValueByNumber(int i11) {
            return Cnew.m1177do(i11);
        }
    }

    /* access modifiers changed from: public */
    static {
        new Cdo();
    }

    private Cnew(int i11) {
        this.f1036do = i11;
    }

    /* renamed from: do  reason: not valid java name */
    public static Cnew m1177do(int i11) {
        if (i11 == 0) {
            return DEBUG;
        }
        if (i11 == 1) {
            return LOG;
        }
        if (i11 == 2) {
            return WARN;
        }
        if (i11 != 3) {
            return null;
        }
        return ERROR;
    }

    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.f1036do;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
