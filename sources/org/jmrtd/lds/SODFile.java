package org.jmrtd.lds;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.SignatureException;
import java.security.cert.X509Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.security.auth.x500.X500Principal;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Encoding;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.cms.ContentInfo;
import org.bouncycastle.asn1.cms.IssuerAndSerialNumber;
import org.bouncycastle.asn1.cms.SignedData;
import org.bouncycastle.asn1.icao.DataGroupHash;
import org.bouncycastle.asn1.icao.LDSSecurityObject;
import org.bouncycastle.asn1.icao.LDSVersionInfo;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class SODFile extends AbstractTaggedLDSFile {
    private static final String ICAO_LDS_SOD_ALT_OID = "1.3.27.1.1.1";
    private static final String ICAO_LDS_SOD_OID = "2.23.136.1.1.1";
    private static final Logger LOGGER = Logger.getLogger("org.jmrtd");
    private static final String SDU_LDS_SOD_OID = "1.2.528.1.1006.1.20.1";
    private static final long serialVersionUID = -1081347374739311111L;
    private transient SignedData signedData;

    public SODFile(String str, String str2, Map<Integer, byte[]> map, PrivateKey privateKey, X509Certificate x509Certificate) throws GeneralSecurityException {
        this(str, str2, map, privateKey, x509Certificate, (String) null);
    }

    private static LDSSecurityObject getLDSSecurityObject(SignedData signedData2) {
        ASN1InputStream aSN1InputStream;
        try {
            ContentInfo encapContentInfo = signedData2.getEncapContentInfo();
            String id2 = encapContentInfo.getContentType().getId();
            ASN1OctetString aSN1OctetString = (ASN1OctetString) encapContentInfo.getContent();
            if (!ICAO_LDS_SOD_OID.equals(id2) && !SDU_LDS_SOD_OID.equals(id2) && !ICAO_LDS_SOD_ALT_OID.equals(id2)) {
                Logger logger = LOGGER;
                logger.warning("SignedData does not appear to contain an LDS SOd. (content type is " + id2 + ", was expecting " + ICAO_LDS_SOD_OID + ")");
            }
            aSN1InputStream = new ASN1InputStream((InputStream) new ByteArrayInputStream(aSN1OctetString.getOctets()));
            ASN1Primitive readObject = aSN1InputStream.readObject();
            if (readObject instanceof ASN1Sequence) {
                LDSSecurityObject instance = LDSSecurityObject.getInstance(readObject);
                if (aSN1InputStream.readObject() != null) {
                    LOGGER.warning("Ignoring extra object found after LDSSecurityObject...");
                }
                aSN1InputStream.close();
                return instance;
            }
            throw new IllegalStateException("Expected ASN1Sequence, found " + readObject.getClass().getSimpleName());
        } catch (IOException e11) {
            throw new IllegalStateException("Could not read security object in signedData", e11);
        } catch (Throwable th2) {
            aSN1InputStream.close();
            throw th2;
        }
    }

    private static ContentInfo toContentInfo(String str, String str2, Map<Integer, byte[]> map, String str3, String str4) throws NoSuchAlgorithmException, IOException {
        LDSSecurityObject lDSSecurityObject;
        DataGroupHash[] dataGroupHashArr = new DataGroupHash[map.size()];
        int i11 = 0;
        for (Map.Entry<Integer, byte[]> key : map.entrySet()) {
            int intValue = ((Integer) key.getKey()).intValue();
            dataGroupHashArr[i11] = new DataGroupHash(intValue, new DEROctetString(map.get(Integer.valueOf(intValue))));
            i11++;
        }
        AlgorithmIdentifier algorithmIdentifier = new AlgorithmIdentifier(new ASN1ObjectIdentifier(SignedDataUtil.lookupOIDByMnemonic(str2)));
        if (str3 == null) {
            lDSSecurityObject = new LDSSecurityObject(algorithmIdentifier, dataGroupHashArr);
        } else {
            lDSSecurityObject = new LDSSecurityObject(algorithmIdentifier, dataGroupHashArr, new LDSVersionInfo(str3, str4));
        }
        return new ContentInfo(new ASN1ObjectIdentifier(str), new DEROctetString((ASN1Encodable) lDSSecurityObject));
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!obj.getClass().equals(getClass())) {
            return false;
        }
        return Arrays.equals(getEncoded(), ((SODFile) obj).getEncoded());
    }

    public Map<Integer, byte[]> getDataGroupHashes() {
        DataGroupHash[] datagroupHash = getLDSSecurityObject(this.signedData).getDatagroupHash();
        TreeMap treeMap = new TreeMap();
        for (DataGroupHash dataGroupHash : datagroupHash) {
            treeMap.put(Integer.valueOf(dataGroupHash.getDataGroupNumber()), dataGroupHash.getDataGroupHashValue().getOctets());
        }
        return treeMap;
    }

    public String getDigestAlgorithm() {
        return getDigestAlgorithm(getLDSSecurityObject(this.signedData));
    }

    public String getDigestEncryptionAlgorithm() {
        return SignedDataUtil.getDigestEncryptionAlgorithm(this.signedData);
    }

    public AlgorithmParameterSpec getDigestEncryptionAlgorithmParams() {
        return SignedDataUtil.getDigestEncryptionAlgorithmParams(this.signedData);
    }

    public X509Certificate getDocSigningCertificate() {
        List<X509Certificate> docSigningCertificates = getDocSigningCertificates();
        if (docSigningCertificates == null || docSigningCertificates.isEmpty()) {
            return null;
        }
        return docSigningCertificates.get(docSigningCertificates.size() - 1);
    }

    public List<X509Certificate> getDocSigningCertificates() {
        return SignedDataUtil.getCertificates(this.signedData);
    }

    public byte[] getEContent() throws SignatureException {
        return SignedDataUtil.getEContent(this.signedData);
    }

    public byte[] getEncryptedDigest() {
        return SignedDataUtil.getEncryptedDigest(this.signedData);
    }

    public X500Principal getIssuerX500Principal() {
        X500Name name;
        try {
            IssuerAndSerialNumber issuerAndSerialNumber = SignedDataUtil.getIssuerAndSerialNumber(this.signedData);
            if (issuerAndSerialNumber == null || (name = issuerAndSerialNumber.getName()) == null) {
                return null;
            }
            return new X500Principal(name.getEncoded(ASN1Encoding.DER));
        } catch (IOException e11) {
            LOGGER.log(Level.WARNING, "Could not get issuer", e11);
            return null;
        }
    }

    public String getLDSVersion() {
        LDSVersionInfo versionInfo = getLDSSecurityObject(this.signedData).getVersionInfo();
        if (versionInfo == null) {
            return null;
        }
        return versionInfo.getLdsVersion();
    }

    public BigInteger getSerialNumber() {
        IssuerAndSerialNumber issuerAndSerialNumber = SignedDataUtil.getIssuerAndSerialNumber(this.signedData);
        if (issuerAndSerialNumber == null) {
            return null;
        }
        return issuerAndSerialNumber.getSerialNumber().getValue();
    }

    public String getSignerInfoDigestAlgorithm() {
        return SignedDataUtil.getSignerInfoDigestAlgorithm(this.signedData);
    }

    public byte[] getSubjectKeyIdentifier() {
        return SignedDataUtil.getSubjectKeyIdentifier(this.signedData);
    }

    public String getUnicodeVersion() {
        LDSVersionInfo versionInfo = getLDSSecurityObject(this.signedData).getVersionInfo();
        if (versionInfo == null) {
            return null;
        }
        return versionInfo.getUnicodeVersion();
    }

    public int hashCode() {
        return (Arrays.hashCode(getEncoded()) * 11) + 111;
    }

    public void readContent(InputStream inputStream) throws IOException {
        this.signedData = SignedDataUtil.readSignedData(inputStream);
    }

    public String toString() {
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("SODFile ");
            for (X509Certificate issuerX500Principal : getDocSigningCertificates()) {
                sb2.append(issuerX500Principal.getIssuerX500Principal().getName());
                sb2.append(", ");
            }
            return sb2.toString();
        } catch (Exception e11) {
            LOGGER.log(Level.WARNING, "Unexpected exception", e11);
            return "SODFile";
        }
    }

    public void writeContent(OutputStream outputStream) throws IOException {
        SignedDataUtil.writeData(this.signedData, outputStream);
    }

    public SODFile(String str, String str2, AlgorithmParameterSpec algorithmParameterSpec, Map<Integer, byte[]> map, PrivateKey privateKey, X509Certificate x509Certificate) throws GeneralSecurityException {
        this(str, str2, algorithmParameterSpec, map, privateKey, x509Certificate, (String) null);
    }

    private static String getDigestAlgorithm(LDSSecurityObject lDSSecurityObject) {
        try {
            return SignedDataUtil.lookupMnemonicByOID(lDSSecurityObject.getDigestAlgorithmIdentifier().getAlgorithm().getId());
        } catch (NoSuchAlgorithmException e11) {
            LOGGER.log(Level.WARNING, "Exception", e11);
            return null;
        }
    }

    public SODFile(String str, String str2, Map<Integer, byte[]> map, PrivateKey privateKey, X509Certificate x509Certificate, String str3) throws GeneralSecurityException {
        this(str, str2, map, privateKey, x509Certificate, str3, (String) null, (String) null);
    }

    public SODFile(String str, String str2, AlgorithmParameterSpec algorithmParameterSpec, Map<Integer, byte[]> map, PrivateKey privateKey, X509Certificate x509Certificate, String str3) throws GeneralSecurityException {
        this(str, str2, algorithmParameterSpec, map, privateKey, x509Certificate, str3, (String) null, (String) null);
    }

    public SODFile(String str, String str2, Map<Integer, byte[]> map, PrivateKey privateKey, X509Certificate x509Certificate, String str3, String str4, String str5) throws GeneralSecurityException {
        super(119);
        try {
            ContentInfo contentInfo = toContentInfo(ICAO_LDS_SOD_OID, str, map, str4, str5);
            this.signedData = SignedDataUtil.createSignedData(str, str2, ICAO_LDS_SOD_OID, contentInfo, SignedDataUtil.signData(str, str2, ICAO_LDS_SOD_OID, contentInfo, privateKey, str3), x509Certificate);
        } catch (IOException e11) {
            throw new IllegalArgumentException("Error creating signedData", e11);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SODFile(String str, String str2, AlgorithmParameterSpec algorithmParameterSpec, Map<Integer, byte[]> map, PrivateKey privateKey, X509Certificate x509Certificate, String str3, String str4, String str5) throws GeneralSecurityException {
        super(119);
        String str6 = str;
        Map<Integer, byte[]> map2 = map;
        try {
            ContentInfo contentInfo = toContentInfo(ICAO_LDS_SOD_OID, str, map, str4, str5);
            this.signedData = SignedDataUtil.createSignedData(str, str2, algorithmParameterSpec, ICAO_LDS_SOD_OID, contentInfo, SignedDataUtil.signData(str, str2, algorithmParameterSpec, ICAO_LDS_SOD_OID, contentInfo, privateKey, str3), x509Certificate);
        } catch (IOException e11) {
            throw new IllegalArgumentException("Error creating signedData", e11);
        }
    }

    public SODFile(String str, String str2, Map<Integer, byte[]> map, byte[] bArr, X509Certificate x509Certificate) throws GeneralSecurityException {
        super(119);
        if (map != null) {
            try {
                this.signedData = SignedDataUtil.createSignedData(str, str2, ICAO_LDS_SOD_OID, toContentInfo(ICAO_LDS_SOD_OID, str, map, (String) null, (String) null), bArr, x509Certificate);
            } catch (IOException e11) {
                throw new IllegalArgumentException("Error creating signedData", e11);
            }
        } else {
            throw new IllegalArgumentException("Cannot construct security object from null datagroup hashes");
        }
    }

    public SODFile(String str, String str2, AlgorithmParameterSpec algorithmParameterSpec, Map<Integer, byte[]> map, byte[] bArr, X509Certificate x509Certificate) throws GeneralSecurityException {
        super(119);
        if (map != null) {
            try {
                this.signedData = SignedDataUtil.createSignedData(str, str2, algorithmParameterSpec, ICAO_LDS_SOD_OID, toContentInfo(ICAO_LDS_SOD_OID, str, map, (String) null, (String) null), bArr, x509Certificate);
            } catch (IOException e11) {
                throw new IllegalArgumentException("Error creating signedData", e11);
            }
        } else {
            throw new IllegalArgumentException("Cannot construct security object from null datagroup hashes");
        }
    }

    public SODFile(InputStream inputStream) throws IOException {
        super(119, inputStream);
        SignedDataUtil.getSignerInfo(this.signedData);
    }
}
