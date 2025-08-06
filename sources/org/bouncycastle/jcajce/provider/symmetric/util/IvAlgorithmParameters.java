package org.bouncycastle.jcajce.provider.symmetric.util;

import java.io.IOException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import javax.crypto.spec.IvParameterSpec;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.util.Arrays;

public class IvAlgorithmParameters extends BaseAlgorithmParameters {

    /* renamed from: iv  reason: collision with root package name */
    private byte[] f59347iv;

    public byte[] engineGetEncoded() throws IOException {
        return engineGetEncoded("ASN.1");
    }

    public byte[] engineGetEncoded(String str) throws IOException {
        if (isASN1FormatString(str)) {
            return new DEROctetString(engineGetEncoded("RAW")).getEncoded();
        }
        if (str.equals("RAW")) {
            return Arrays.clone(this.f59347iv);
        }
        return null;
    }

    public void engineInit(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidParameterSpecException {
        if (algorithmParameterSpec instanceof IvParameterSpec) {
            this.f59347iv = ((IvParameterSpec) algorithmParameterSpec).getIV();
            return;
        }
        throw new InvalidParameterSpecException("IvParameterSpec required to initialise a IV parameters algorithm parameters object");
    }

    public void engineInit(byte[] bArr) throws IOException {
        if (bArr.length % 8 != 0 && bArr[0] == 4 && bArr[1] == bArr.length - 2) {
            bArr = ((ASN1OctetString) ASN1Primitive.fromByteArray(bArr)).getOctets();
        }
        this.f59347iv = Arrays.clone(bArr);
    }

    public void engineInit(byte[] bArr, String str) throws IOException {
        if (isASN1FormatString(str)) {
            try {
                engineInit(((ASN1OctetString) ASN1Primitive.fromByteArray(bArr)).getOctets());
            } catch (Exception e11) {
                throw new IOException("Exception decoding: " + e11);
            }
        } else if (str.equals("RAW")) {
            engineInit(bArr);
        } else {
            throw new IOException("Unknown parameters format in IV parameters object");
        }
    }

    public String engineToString() {
        return "IV Parameters";
    }

    public AlgorithmParameterSpec localEngineGetParameterSpec(Class cls) throws InvalidParameterSpecException {
        if (cls == IvParameterSpec.class || cls == AlgorithmParameterSpec.class) {
            return new IvParameterSpec(this.f59347iv);
        }
        throw new InvalidParameterSpecException("unknown parameter spec passed to IV parameters object.");
    }
}
