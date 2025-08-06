package org.ejbca.cvc;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.ejbca.cvc.exception.ConstructionException;
import org.ejbca.cvc.util.BCECUtil;

public class CVCAuthenticatedRequest extends AbstractSequence implements Signable {
    private static CVCTagEnum[] allowedFields = {CVCTagEnum.CV_CERTIFICATE, CVCTagEnum.CA_REFERENCE, CVCTagEnum.SIGNATURE};
    private static final long serialVersionUID = 1;

    public CVCAuthenticatedRequest() {
        super(CVCTagEnum.REQ_AUTHENTICATION);
    }

    public CVCTagEnum[] getAllowedFields() {
        return allowedFields;
    }

    public CAReferenceField getAuthorityReference() throws NoSuchFieldException {
        return (CAReferenceField) getSubfield(CVCTagEnum.CA_REFERENCE);
    }

    public CVCertificate getRequest() throws NoSuchFieldException {
        return (CVCertificate) getSubfield(CVCTagEnum.CV_CERTIFICATE);
    }

    public byte[] getSignature() throws NoSuchFieldException {
        return ((ByteField) getSubfield(CVCTagEnum.SIGNATURE)).getData();
    }

    public byte[] getTBS() throws ConstructionException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            getRequest().encode(dataOutputStream);
            getAuthorityReference().encode(dataOutputStream);
            dataOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (NoSuchFieldException e11) {
            throw new ConstructionException((Throwable) e11);
        } catch (IOException e12) {
            throw new ConstructionException((Throwable) e12);
        }
    }

    public void setSignature(byte[] bArr) throws ConstructionException {
        addSubfield(new ByteField(CVCTagEnum.SIGNATURE, bArr));
    }

    public String toString() {
        return getAsText("", true);
    }

    public void verify(PublicKey publicKey) throws CertificateException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException {
        String str;
        try {
            if (publicKey instanceof CVCPublicKey) {
                str = AlgorithmUtil.getAlgorithmName(((CVCPublicKey) publicKey).getObjectIdentifier());
            } else {
                str = AlgorithmUtil.getAlgorithmName(getRequest().getCertificateBody().getPublicKey().getObjectIdentifier());
            }
            Signature instance = Signature.getInstance(str, BouncyCastleProvider.PROVIDER_NAME);
            instance.initVerify(publicKey);
            instance.update(getTBS());
            if (!instance.verify(BCECUtil.convertCVCSigToX962(str, getSignature()))) {
                throw new SignatureException("Signature verification failed!");
            }
        } catch (NoSuchFieldException e11) {
            throw new CertificateException("CV-Certificate is corrupt", e11);
        } catch (ConstructionException e12) {
            throw new CertificateException("CV-Certificate is corrupt", e12);
        }
    }

    public CVCAuthenticatedRequest(CVCertificate cVCertificate, CAReferenceField cAReferenceField) throws ConstructionException {
        this();
        addSubfield(cVCertificate);
        addSubfield(cAReferenceField);
    }
}
