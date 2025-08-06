package org.bouncycastle.crypto.params;

import org.bouncycastle.crypto.DerivationParameters;

public class KDFParameters implements DerivationParameters {

    /* renamed from: iv  reason: collision with root package name */
    public byte[] f59298iv;
    public byte[] shared;

    public KDFParameters(byte[] bArr, byte[] bArr2) {
        this.shared = bArr;
        this.f59298iv = bArr2;
    }

    public byte[] getIV() {
        return this.f59298iv;
    }

    public byte[] getSharedSecret() {
        return this.shared;
    }
}
