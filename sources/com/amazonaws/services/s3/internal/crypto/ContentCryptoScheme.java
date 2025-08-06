package com.amazonaws.services.s3.internal.crypto;

@Deprecated
abstract class ContentCryptoScheme {

    /* renamed from: a  reason: collision with root package name */
    public static final ContentCryptoScheme f15194a = new AesCbc();

    /* renamed from: b  reason: collision with root package name */
    public static final ContentCryptoScheme f15195b = new AesGcm();

    /* renamed from: c  reason: collision with root package name */
    public static final ContentCryptoScheme f15196c = new AesCtr();

    public abstract int a();

    public abstract String b();

    public abstract int c();

    public abstract String d();

    public abstract int e();

    public String f() {
        return null;
    }

    public int g() {
        return 0;
    }

    public String toString() {
        return "cipherAlgo=" + b() + ", blockSizeInBytes=" + a() + ", ivLengthInBytes=" + c() + ", keyGenAlgo=" + d() + ", keyLengthInBits=" + e() + ", specificProvider=" + f() + ", tagLengthInBits=" + g();
    }
}
