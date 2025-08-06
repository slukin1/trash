package com.squareup.wire;

import java.io.IOException;
import java.net.ProtocolException;

public enum FieldEncoding {
    VARINT(0),
    FIXED64(1),
    LENGTH_DELIMITED(2),
    FIXED32(5);
    
    public final int value;

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f30168a = null;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.squareup.wire.FieldEncoding[] r0 = com.squareup.wire.FieldEncoding.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f30168a = r0
                com.squareup.wire.FieldEncoding r1 = com.squareup.wire.FieldEncoding.VARINT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f30168a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.squareup.wire.FieldEncoding r1 = com.squareup.wire.FieldEncoding.FIXED32     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f30168a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.squareup.wire.FieldEncoding r1 = com.squareup.wire.FieldEncoding.FIXED64     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f30168a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.squareup.wire.FieldEncoding r1 = com.squareup.wire.FieldEncoding.LENGTH_DELIMITED     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.squareup.wire.FieldEncoding.a.<clinit>():void");
        }
    }

    private FieldEncoding(int i11) {
        this.value = i11;
    }

    public static FieldEncoding get(int i11) throws IOException {
        if (i11 == 0) {
            return VARINT;
        }
        if (i11 == 1) {
            return FIXED64;
        }
        if (i11 == 2) {
            return LENGTH_DELIMITED;
        }
        if (i11 == 5) {
            return FIXED32;
        }
        throw new ProtocolException("Unexpected FieldEncoding: " + i11);
    }

    public ProtoAdapter<?> rawProtoAdapter() {
        int i11 = a.f30168a[ordinal()];
        if (i11 == 1) {
            return ProtoAdapter.f30179k;
        }
        if (i11 == 2) {
            return ProtoAdapter.f30176h;
        }
        if (i11 == 3) {
            return ProtoAdapter.f30181m;
        }
        if (i11 == 4) {
            return ProtoAdapter.f30186r;
        }
        throw new AssertionError();
    }
}
