package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzkg extends IOException {
    public zzkg() {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.");
    }

    public zzkg(String str, Throwable th2) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.: ".concat(String.valueOf(str)), th2);
    }

    public zzkg(Throwable th2) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.", th2);
    }
}
