package org.ejbca.cvc;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.cert.CRL;
import java.security.cert.CRLException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactorySpi;
import java.util.ArrayList;
import java.util.Collection;
import org.ejbca.cvc.exception.ConstructionException;
import org.ejbca.cvc.exception.ParseException;

public class JDKCVCertificateFactory extends CertificateFactorySpi {
    private byte[] readBytes(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[512];
        while (true) {
            int read = inputStream.read(bArr);
            if (read > 0) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                inputStream.close();
                byteArrayOutputStream.close();
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    public CRL engineGenerateCRL(InputStream inputStream) throws CRLException {
        throw new CRLException("CVC CertificateFactory can not create CRLs");
    }

    public Collection<CRL> engineGenerateCRLs(InputStream inputStream) throws CRLException {
        throw new CRLException("CVC CertificateFactory can not create CRLs");
    }

    public Certificate engineGenerateCertificate(InputStream inputStream) throws CertificateException {
        try {
            return new CardVerifiableCertificate(CertificateParser.parseCertificate(readBytes(inputStream)));
        } catch (IOException e11) {
            throw new CertificateException(e11.toString());
        } catch (ParseException e12) {
            throw new CertificateException(e12.toString());
        } catch (ConstructionException e13) {
            throw new CertificateException(e13.toString());
        }
    }

    public Collection<Certificate> engineGenerateCertificates(InputStream inputStream) throws CertificateException {
        Certificate engineGenerateCertificate = engineGenerateCertificate(inputStream);
        ArrayList arrayList = new ArrayList();
        arrayList.add(engineGenerateCertificate);
        return arrayList;
    }
}
