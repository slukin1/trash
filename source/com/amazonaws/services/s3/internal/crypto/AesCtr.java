package com.amazonaws.services.s3.internal.crypto;

@Deprecated
class AesCtr extends ContentCryptoScheme {
    public int a() {
        return ContentCryptoScheme.f15195b.a();
    }

    public String b() {
        return "AES/CTR/NoPadding";
    }

    public int c() {
        return 16;
    }

    public String d() {
        return ContentCryptoScheme.f15195b.d();
    }

    public int e() {
        return ContentCryptoScheme.f15195b.e();
    }
}
