package com.jumio.commons.obfuscate;

import java.util.Random;
import kotlin.text.b;

public final class StringDeobfuscator {
    public static final StringDeobfuscator INSTANCE = new StringDeobfuscator();

    public static final String deobfuscate(byte[] bArr, long j11) {
        byte[] bArr2 = new byte[bArr.length];
        new Random(j11).nextBytes(bArr2);
        int length = bArr.length;
        int i11 = 0;
        int i12 = 0;
        while (i11 < length) {
            bArr2[i12] = (byte) (bArr[i11] ^ bArr2[i12]);
            i11++;
            i12++;
        }
        return new String(bArr2, b.f56908b);
    }
}
