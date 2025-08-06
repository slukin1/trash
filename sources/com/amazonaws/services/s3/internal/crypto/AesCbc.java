package com.amazonaws.services.s3.internal.crypto;

import com.sumsub.sns.internal.core.common.k;
import com.sumsub.sns.prooface.network.b;

@Deprecated
class AesCbc extends ContentCryptoScheme {
    public int a() {
        return 16;
    }

    public String b() {
        return k.f32093a;
    }

    public int c() {
        return 16;
    }

    public String d() {
        return b.f40261d;
    }

    public int e() {
        return 256;
    }
}
