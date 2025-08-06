package com.iproov.sdk.network.model.proto;

import com.google.protobuf.Internal;

/* renamed from: com.iproov.sdk.network.model.proto.while  reason: invalid class name */
public enum Cwhile implements Internal.EnumLite {
    ACK(0),
    CLIENT_LOG(1),
    CLIENT_METADATA(2),
    CLIENT_START(3),
    CLIENT_LUX(4),
    CLIENT_TELEMETRY(5),
    CLIENT_VIDEO(6),
    CLIENT_ABORT(7),
    EDGE_VIDEO(8),
    EDGE_PROGRESS_UPDATE(9),
    EDGE_RESULT(10),
    EDGE_ABORT(11),
    CORE_PROGRESS_UPDATE(12),
    CORE_RESULT(13),
    UNRECOGNIZED(-1);
    

    /* renamed from: do  reason: not valid java name */
    private final int f1057do;

    /* renamed from: com.iproov.sdk.network.model.proto.while$do  reason: invalid class name */
    public class Cdo implements Internal.EnumLiteMap<Cwhile> {
        /* renamed from: do  reason: not valid java name */
        public Cwhile findValueByNumber(int i11) {
            return Cwhile.m1179do(i11);
        }
    }

    /* access modifiers changed from: public */
    static {
        new Cdo();
    }

    private Cwhile(int i11) {
        this.f1057do = i11;
    }

    /* renamed from: do  reason: not valid java name */
    public static Cwhile m1179do(int i11) {
        switch (i11) {
            case 0:
                return ACK;
            case 1:
                return CLIENT_LOG;
            case 2:
                return CLIENT_METADATA;
            case 3:
                return CLIENT_START;
            case 4:
                return CLIENT_LUX;
            case 5:
                return CLIENT_TELEMETRY;
            case 6:
                return CLIENT_VIDEO;
            case 7:
                return CLIENT_ABORT;
            case 8:
                return EDGE_VIDEO;
            case 9:
                return EDGE_PROGRESS_UPDATE;
            case 10:
                return EDGE_RESULT;
            case 11:
                return EDGE_ABORT;
            case 12:
                return CORE_PROGRESS_UPDATE;
            case 13:
                return CORE_RESULT;
            default:
                return null;
        }
    }

    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.f1057do;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
