package org.bouncycastle.x509;

import java.io.IOException;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.SignatureException;
import java.security.cert.CRLException;
import java.security.cert.X509CRL;
import java.security.cert.X509CRLEntry;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1GeneralizedTime;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.CertificateList;
import org.bouncycastle.asn1.x509.Extensions;
import org.bouncycastle.asn1.x509.TBSCertList;
import org.bouncycastle.asn1.x509.Time;
import org.bouncycastle.asn1.x509.V2TBSCertListGenerator;
import org.bouncycastle.asn1.x509.X509Extensions;
import org.bouncycastle.asn1.x509.X509ExtensionsGenerator;
import org.bouncycastle.asn1.x509.X509Name;
import org.bouncycastle.jcajce.util.BCJcaJceHelper;
import org.bouncycastle.jcajce.util.JcaJceHelper;
import org.bouncycastle.jce.X509Principal;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.jce.provider.X509CRLObject;

public class X509V2CRLGenerator {
    private final JcaJceHelper bcHelper = new BCJcaJceHelper();
    private X509ExtensionsGenerator extGenerator = new X509ExtensionsGenerator();
    private AlgorithmIdentifier sigAlgId;
    private ASN1ObjectIdentifier sigOID;
    private String signatureAlgorithm;
    private V2TBSCertListGenerator tbsGen = new V2TBSCertListGenerator();

    public static class ExtCRLException extends CRLException {
        public Throwable cause;

        public ExtCRLException(String str, Throwable th2) {
            super(str);
            this.cause = th2;
        }

        public Throwable getCause() {
            return this.cause;
        }
    }

    private TBSCertList generateCertList() {
        if (!this.extGenerator.isEmpty()) {
            this.tbsGen.setExtensions(this.extGenerator.generate());
        }
        return this.tbsGen.generateTBSCertList();
    }

    private X509CRL generateJcaObject(TBSCertList tBSCertList, byte[] bArr) throws CRLException {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(tBSCertList);
        aSN1EncodableVector.add(this.sigAlgId);
        aSN1EncodableVector.add(new DERBitString(bArr));
        return new X509CRLObject(CertificateList.getInstance(new DERSequence(aSN1EncodableVector)));
    }

    public void addCRL(X509CRL x509crl) throws CRLException {
        Set<? extends X509CRLEntry> revokedCertificates = x509crl.getRevokedCertificates();
        if (revokedCertificates != null) {
            for (X509CRLEntry encoded : revokedCertificates) {
                try {
                    this.tbsGen.addCRLEntry(ASN1Sequence.getInstance(new ASN1InputStream(encoded.getEncoded()).readObject()));
                } catch (IOException e11) {
                    throw new CRLException("exception processing encoding of CRL: " + e11.toString());
                }
            }
        }
    }

    public void addCRLEntry(BigInteger bigInteger, Date date, int i11) {
        this.tbsGen.addCRLEntry(new ASN1Integer(bigInteger), new Time(date), i11);
    }

    public void addCRLEntry(BigInteger bigInteger, Date date, int i11, Date date2) {
        this.tbsGen.addCRLEntry(new ASN1Integer(bigInteger), new Time(date), i11, new ASN1GeneralizedTime(date2));
    }

    public void addCRLEntry(BigInteger bigInteger, Date date, X509Extensions x509Extensions) {
        this.tbsGen.addCRLEntry(new ASN1Integer(bigInteger), new Time(date), Extensions.getInstance(x509Extensions));
    }

    public void addExtension(String str, boolean z11, ASN1Encodable aSN1Encodable) {
        addExtension(new ASN1ObjectIdentifier(str), z11, aSN1Encodable);
    }

    public void addExtension(String str, boolean z11, byte[] bArr) {
        addExtension(new ASN1ObjectIdentifier(str), z11, bArr);
    }

    public void addExtension(ASN1ObjectIdentifier aSN1ObjectIdentifier, boolean z11, ASN1Encodable aSN1Encodable) {
        this.extGenerator.addExtension(new ASN1ObjectIdentifier(aSN1ObjectIdentifier.getId()), z11, aSN1Encodable);
    }

    public void addExtension(ASN1ObjectIdentifier aSN1ObjectIdentifier, boolean z11, byte[] bArr) {
        this.extGenerator.addExtension(new ASN1ObjectIdentifier(aSN1ObjectIdentifier.getId()), z11, bArr);
    }

    public X509CRL generate(PrivateKey privateKey) throws CRLException, IllegalStateException, NoSuchAlgorithmException, SignatureException, InvalidKeyException {
        return generate(privateKey, (SecureRandom) null);
    }

    public X509CRL generate(PrivateKey privateKey, String str) throws CRLException, IllegalStateException, NoSuchProviderException, NoSuchAlgorithmException, SignatureException, InvalidKeyException {
        return generate(privateKey, str, (SecureRandom) null);
    }

    public X509CRL generate(PrivateKey privateKey, String str, SecureRandom secureRandom) throws CRLException, IllegalStateException, NoSuchProviderException, NoSuchAlgorithmException, SignatureException, InvalidKeyException {
        TBSCertList generateCertList = generateCertList();
        try {
            return generateJcaObject(generateCertList, X509Util.calculateSignature(this.sigOID, this.signatureAlgorithm, str, privateKey, secureRandom, generateCertList));
        } catch (IOException e11) {
            throw new ExtCRLException("cannot generate CRL encoding", e11);
        }
    }

    public X509CRL generate(PrivateKey privateKey, SecureRandom secureRandom) throws CRLException, IllegalStateException, NoSuchAlgorithmException, SignatureException, InvalidKeyException {
        TBSCertList generateCertList = generateCertList();
        try {
            return generateJcaObject(generateCertList, X509Util.calculateSignature(this.sigOID, this.signatureAlgorithm, privateKey, secureRandom, generateCertList));
        } catch (IOException e11) {
            throw new ExtCRLException("cannot generate CRL encoding", e11);
        }
    }

    public X509CRL generateX509CRL(PrivateKey privateKey) throws SecurityException, SignatureException, InvalidKeyException {
        try {
            return generateX509CRL(privateKey, BouncyCastleProvider.PROVIDER_NAME, (SecureRandom) null);
        } catch (NoSuchProviderException unused) {
            throw new SecurityException("BC provider not installed!");
        }
    }

    public X509CRL generateX509CRL(PrivateKey privateKey, String str) throws NoSuchProviderException, SecurityException, SignatureException, InvalidKeyException {
        return generateX509CRL(privateKey, str, (SecureRandom) null);
    }

    public X509CRL generateX509CRL(PrivateKey privateKey, String str, SecureRandom secureRandom) throws NoSuchProviderException, SecurityException, SignatureException, InvalidKeyException {
        try {
            return generate(privateKey, str, secureRandom);
        } catch (NoSuchProviderException e11) {
            throw e11;
        } catch (SignatureException e12) {
            throw e12;
        } catch (InvalidKeyException e13) {
            throw e13;
        } catch (GeneralSecurityException e14) {
            throw new SecurityException("exception: " + e14);
        }
    }

    public X509CRL generateX509CRL(PrivateKey privateKey, SecureRandom secureRandom) throws SecurityException, SignatureException, InvalidKeyException {
        try {
            return generateX509CRL(privateKey, BouncyCastleProvider.PROVIDER_NAME, secureRandom);
        } catch (NoSuchProviderException unused) {
            throw new SecurityException("BC provider not installed!");
        }
    }

    public Iterator getSignatureAlgNames() {
        return X509Util.getAlgNames();
    }

    public void reset() {
        this.tbsGen = new V2TBSCertListGenerator();
        this.extGenerator.reset();
    }

    public void setIssuerDN(X500Principal x500Principal) {
        try {
            this.tbsGen.setIssuer((X509Name) new X509Principal(x500Principal.getEncoded()));
        } catch (IOException e11) {
            throw new IllegalArgumentException("can't process principal: " + e11);
        }
    }

    public void setIssuerDN(X509Name x509Name) {
        this.tbsGen.setIssuer(x509Name);
    }

    public void setNextUpdate(Date date) {
        this.tbsGen.setNextUpdate(new Time(date));
    }

    public void setSignatureAlgorithm(String str) {
        this.signatureAlgorithm = str;
        try {
            ASN1ObjectIdentifier algorithmOID = X509Util.getAlgorithmOID(str);
            this.sigOID = algorithmOID;
            AlgorithmIdentifier sigAlgID = X509Util.getSigAlgID(algorithmOID, str);
            this.sigAlgId = sigAlgID;
            this.tbsGen.setSignature(sigAlgID);
        } catch (Exception unused) {
            throw new IllegalArgumentException("Unknown signature type requested");
        }
    }

    public void setThisUpdate(Date date) {
        this.tbsGen.setThisUpdate(new Time(date));
    }
}
