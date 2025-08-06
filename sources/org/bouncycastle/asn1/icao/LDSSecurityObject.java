package org.bouncycastle.asn1.icao;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class LDSSecurityObject extends ASN1Object implements ICAOObjectIdentifiers {
    public static final int ub_DataGroups = 16;
    private DataGroupHash[] datagroupHash;
    private AlgorithmIdentifier digestAlgorithmIdentifier;
    private ASN1Integer version;
    private LDSVersionInfo versionInfo;

    private LDSSecurityObject(ASN1Sequence aSN1Sequence) {
        this.version = new ASN1Integer(0);
        if (aSN1Sequence == null || aSN1Sequence.size() == 0) {
            throw new IllegalArgumentException("null or empty sequence passed.");
        }
        Enumeration objects = aSN1Sequence.getObjects();
        this.version = ASN1Integer.getInstance(objects.nextElement());
        this.digestAlgorithmIdentifier = AlgorithmIdentifier.getInstance(objects.nextElement());
        ASN1Sequence instance = ASN1Sequence.getInstance(objects.nextElement());
        if (this.version.hasValue(1)) {
            this.versionInfo = LDSVersionInfo.getInstance(objects.nextElement());
        }
        checkDatagroupHashSeqSize(instance.size());
        this.datagroupHash = new DataGroupHash[instance.size()];
        for (int i11 = 0; i11 < instance.size(); i11++) {
            this.datagroupHash[i11] = DataGroupHash.getInstance(instance.getObjectAt(i11));
        }
    }

    public LDSSecurityObject(AlgorithmIdentifier algorithmIdentifier, DataGroupHash[] dataGroupHashArr) {
        this.version = new ASN1Integer(0);
        this.version = new ASN1Integer(0);
        this.digestAlgorithmIdentifier = algorithmIdentifier;
        this.datagroupHash = copy(dataGroupHashArr);
        checkDatagroupHashSeqSize(dataGroupHashArr.length);
    }

    public LDSSecurityObject(AlgorithmIdentifier algorithmIdentifier, DataGroupHash[] dataGroupHashArr, LDSVersionInfo lDSVersionInfo) {
        this.version = new ASN1Integer(0);
        this.version = new ASN1Integer(1);
        this.digestAlgorithmIdentifier = algorithmIdentifier;
        this.datagroupHash = copy(dataGroupHashArr);
        this.versionInfo = lDSVersionInfo;
        checkDatagroupHashSeqSize(dataGroupHashArr.length);
    }

    private void checkDatagroupHashSeqSize(int i11) {
        if (i11 < 2 || i11 > 16) {
            throw new IllegalArgumentException("wrong size in DataGroupHashValues : not in (2..16)");
        }
    }

    private DataGroupHash[] copy(DataGroupHash[] dataGroupHashArr) {
        int length = dataGroupHashArr.length;
        DataGroupHash[] dataGroupHashArr2 = new DataGroupHash[length];
        System.arraycopy(dataGroupHashArr, 0, dataGroupHashArr2, 0, length);
        return dataGroupHashArr2;
    }

    public static LDSSecurityObject getInstance(Object obj) {
        if (obj instanceof LDSSecurityObject) {
            return (LDSSecurityObject) obj;
        }
        if (obj != null) {
            return new LDSSecurityObject(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public DataGroupHash[] getDatagroupHash() {
        return copy(this.datagroupHash);
    }

    public AlgorithmIdentifier getDigestAlgorithmIdentifier() {
        return this.digestAlgorithmIdentifier;
    }

    public int getVersion() {
        return this.version.intValueExact();
    }

    public LDSVersionInfo getVersionInfo() {
        return this.versionInfo;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(4);
        aSN1EncodableVector.add(this.version);
        aSN1EncodableVector.add(this.digestAlgorithmIdentifier);
        aSN1EncodableVector.add(new DERSequence((ASN1Encodable[]) this.datagroupHash));
        LDSVersionInfo lDSVersionInfo = this.versionInfo;
        if (lDSVersionInfo != null) {
            aSN1EncodableVector.add(lDSVersionInfo);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
