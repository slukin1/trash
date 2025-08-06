package org.ejbca.cvc;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.SignatureException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class CardVerifiableCertificate extends Certificate {
    private CVCertificate cvc;

    public CardVerifiableCertificate(CVCertificate cVCertificate) {
        super("CVC");
        this.cvc = cVCertificate;
    }

    public CVCertificate getCVCertificate() {
        return this.cvc;
    }

    public byte[] getEncoded() throws CertificateEncodingException {
        try {
            return this.cvc.getDEREncoded();
        } catch (IOException e11) {
            throw new CertificateEncodingException(e11);
        }
    }

    public PublicKey getPublicKey() {
        try {
            return this.cvc.getCertificateBody().getPublicKey();
        } catch (NoSuchFieldException e11) {
            e11.printStackTrace();
            return null;
        }
    }

    public String toString() {
        return this.cvc.toString();
    }

    public void verify(PublicKey publicKey) throws CertificateException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException {
        verify(publicKey, BouncyCastleProvider.PROVIDER_NAME);
    }

    public void verify(PublicKey publicKey, String str) throws CertificateException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException {
        this.cvc.verify(publicKey, str);
    }
}
