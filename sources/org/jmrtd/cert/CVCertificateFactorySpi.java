package org.jmrtd.cert;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.cert.CRL;
import java.security.cert.CRLException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactorySpi;
import java.util.Collection;
import net.sf.scuba.tlv.TLVInputStream;
import net.sf.scuba.tlv.TLVOutputStream;
import org.ejbca.cvc.CertificateParser;
import org.ejbca.cvc.exception.ConstructionException;
import org.ejbca.cvc.exception.ParseException;

public class CVCertificateFactorySpi extends CertificateFactorySpi {
    private static final int CV_CERTIFICATE_TAG = 32545;

    public CRL engineGenerateCRL(InputStream inputStream) throws CRLException {
        return null;
    }

    public Collection<? extends CRL> engineGenerateCRLs(InputStream inputStream) throws CRLException {
        return null;
    }

    public Certificate engineGenerateCertificate(InputStream inputStream) throws CertificateException {
        try {
            TLVInputStream tLVInputStream = new TLVInputStream(inputStream);
            int readTag = tLVInputStream.readTag();
            if (readTag == CV_CERTIFICATE_TAG) {
                tLVInputStream.readLength();
                byte[] readValue = tLVInputStream.readValue();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                TLVOutputStream tLVOutputStream = new TLVOutputStream(byteArrayOutputStream);
                tLVOutputStream.writeTag(CV_CERTIFICATE_TAG);
                tLVOutputStream.writeValue(readValue);
                tLVOutputStream.close();
                return new CardVerifiableCertificate(CertificateParser.parseCertificate(byteArrayOutputStream.toByteArray()));
            }
            throw new CertificateException("Expected CV_CERTIFICATE_TAG, found " + Integer.toHexString(readTag));
        } catch (IOException e11) {
            throw new CertificateException(e11);
        } catch (ConstructionException e12) {
            throw new CertificateException(e12);
        } catch (ParseException e13) {
            throw new CertificateException(e13);
        }
    }

    public Collection<? extends Certificate> engineGenerateCertificates(InputStream inputStream) throws CertificateException {
        return null;
    }
}
