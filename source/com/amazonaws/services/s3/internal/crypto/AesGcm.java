package com.amazonaws.services.s3.internal.crypto;

import com.sumsub.sns.prooface.network.b;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

@Deprecated
class AesGcm extends ContentCryptoScheme {
    public int a() {
        return 16;
    }

    public String b() {
        return b.f40262e;
    }

    public int c() {
        return 12;
    }

    public String d() {
        return b.f40261d;
    }

    public int e() {
        return 256;
    }

    public String f() {
        return BouncyCastleProvider.PROVIDER_NAME;
    }

    public int g() {
        return 128;
    }
}
