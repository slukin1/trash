package org.bouncycastle.jcajce.provider.asymmetric.util;

import java.math.BigInteger;
import java.security.SignatureException;
import java.security.SignatureSpi;
import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x509.X509ObjectIdentifiers;
import org.bouncycastle.crypto.DSAExt;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.signers.DSAEncoding;

public abstract class DSABase extends SignatureSpi implements PKCSObjectIdentifiers, X509ObjectIdentifiers {
    public Digest digest;
    public DSAEncoding encoding;
    public DSAExt signer;

    public DSABase(Digest digest2, DSAExt dSAExt, DSAEncoding dSAEncoding) {
        this.digest = digest2;
        this.signer = dSAExt;
        this.encoding = dSAEncoding;
    }

    public Object engineGetParameter(String str) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    public void engineSetParameter(String str, Object obj) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    public void engineSetParameter(AlgorithmParameterSpec algorithmParameterSpec) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    public byte[] engineSign() throws SignatureException {
        byte[] bArr = new byte[this.digest.getDigestSize()];
        this.digest.doFinal(bArr, 0);
        try {
            BigInteger[] generateSignature = this.signer.generateSignature(bArr);
            return this.encoding.encode(this.signer.getOrder(), generateSignature[0], generateSignature[1]);
        } catch (Exception e11) {
            throw new SignatureException(e11.toString());
        }
    }

    public void engineUpdate(byte b11) throws SignatureException {
        this.digest.update(b11);
    }

    public void engineUpdate(byte[] bArr, int i11, int i12) throws SignatureException {
        this.digest.update(bArr, i11, i12);
    }

    public boolean engineVerify(byte[] bArr) throws SignatureException {
        byte[] bArr2 = new byte[this.digest.getDigestSize()];
        this.digest.doFinal(bArr2, 0);
        try {
            BigInteger[] decode = this.encoding.decode(this.signer.getOrder(), bArr);
            return this.signer.verifySignature(bArr2, decode[0], decode[1]);
        } catch (Exception unused) {
            throw new SignatureException("error decoding signature bytes.");
        }
    }
}
