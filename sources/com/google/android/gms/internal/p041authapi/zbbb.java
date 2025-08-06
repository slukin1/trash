package com.google.android.gms.internal.p041authapi;

import android.util.Base64;
import java.util.Random;

/* renamed from: com.google.android.gms.internal.auth-api.zbbb  reason: invalid package */
public final class zbbb {
    private static final Random zba = new Random();

    public static String zba() {
        byte[] bArr = new byte[16];
        zba.nextBytes(bArr);
        return Base64.encodeToString(bArr, 11);
    }
}
