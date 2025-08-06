package org.bouncycastle.jcajce.provider.asymmetric.x509;

import java.security.cert.CRLException;
import org.bouncycastle.asn1.x509.CertificateList;
import org.bouncycastle.jcajce.util.JcaJceHelper;

class X509CRLInternal extends X509CRLImpl {
    private final byte[] encoding;
    private final CRLException exception;

    public X509CRLInternal(JcaJceHelper jcaJceHelper, CertificateList certificateList, String str, byte[] bArr, boolean z11, byte[] bArr2, CRLException cRLException) {
        super(jcaJceHelper, certificateList, str, bArr, z11);
        this.encoding = bArr2;
        this.exception = cRLException;
    }

    public byte[] getEncoded() throws CRLException {
        CRLException cRLException = this.exception;
        if (cRLException == null) {
            byte[] bArr = this.encoding;
            if (bArr != null) {
                return bArr;
            }
            throw new CRLException();
        }
        throw cRLException;
    }
}
