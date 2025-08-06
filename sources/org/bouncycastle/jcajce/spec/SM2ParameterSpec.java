package org.bouncycastle.jcajce.spec;

import java.security.spec.AlgorithmParameterSpec;
import java.util.Objects;
import org.bouncycastle.util.Arrays;

public class SM2ParameterSpec implements AlgorithmParameterSpec {

    /* renamed from: id  reason: collision with root package name */
    private byte[] f59353id;

    public SM2ParameterSpec(byte[] bArr) {
        Objects.requireNonNull(bArr, "id string cannot be null");
        this.f59353id = Arrays.clone(bArr);
    }

    public byte[] getID() {
        return Arrays.clone(this.f59353id);
    }
}
