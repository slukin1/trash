package org.bouncycastle.pqc.crypto.xmss;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.util.Integers;

public final class XMSSMTParameters {
    private static final Map<Integer, XMSSMTParameters> paramsLookupTable;
    private final int height;
    private final int layers;
    private final XMSSOid oid;
    private final XMSSParameters xmssParams;

    static {
        HashMap hashMap = new HashMap();
        Integer valueOf = Integers.valueOf(1);
        ASN1ObjectIdentifier aSN1ObjectIdentifier = NISTObjectIdentifiers.id_sha256;
        hashMap.put(valueOf, new XMSSMTParameters(20, 2, aSN1ObjectIdentifier));
        hashMap.put(Integers.valueOf(2), new XMSSMTParameters(20, 4, aSN1ObjectIdentifier));
        hashMap.put(Integers.valueOf(3), new XMSSMTParameters(40, 2, aSN1ObjectIdentifier));
        hashMap.put(Integers.valueOf(4), new XMSSMTParameters(40, 4, aSN1ObjectIdentifier));
        hashMap.put(Integers.valueOf(5), new XMSSMTParameters(40, 8, aSN1ObjectIdentifier));
        hashMap.put(Integers.valueOf(6), new XMSSMTParameters(60, 3, aSN1ObjectIdentifier));
        hashMap.put(Integers.valueOf(7), new XMSSMTParameters(60, 6, aSN1ObjectIdentifier));
        hashMap.put(Integers.valueOf(8), new XMSSMTParameters(60, 12, aSN1ObjectIdentifier));
        Integer valueOf2 = Integers.valueOf(9);
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = NISTObjectIdentifiers.id_sha512;
        hashMap.put(valueOf2, new XMSSMTParameters(20, 2, aSN1ObjectIdentifier2));
        hashMap.put(Integers.valueOf(10), new XMSSMTParameters(20, 4, aSN1ObjectIdentifier2));
        hashMap.put(Integers.valueOf(11), new XMSSMTParameters(40, 2, aSN1ObjectIdentifier2));
        hashMap.put(Integers.valueOf(12), new XMSSMTParameters(40, 4, aSN1ObjectIdentifier2));
        hashMap.put(Integers.valueOf(13), new XMSSMTParameters(40, 8, aSN1ObjectIdentifier2));
        hashMap.put(Integers.valueOf(14), new XMSSMTParameters(60, 3, aSN1ObjectIdentifier2));
        hashMap.put(Integers.valueOf(15), new XMSSMTParameters(60, 6, aSN1ObjectIdentifier2));
        hashMap.put(Integers.valueOf(16), new XMSSMTParameters(60, 12, aSN1ObjectIdentifier2));
        Integer valueOf3 = Integers.valueOf(17);
        ASN1ObjectIdentifier aSN1ObjectIdentifier3 = NISTObjectIdentifiers.id_shake128;
        hashMap.put(valueOf3, new XMSSMTParameters(20, 2, aSN1ObjectIdentifier3));
        hashMap.put(Integers.valueOf(18), new XMSSMTParameters(20, 4, aSN1ObjectIdentifier3));
        hashMap.put(Integers.valueOf(19), new XMSSMTParameters(40, 2, aSN1ObjectIdentifier3));
        hashMap.put(Integers.valueOf(20), new XMSSMTParameters(40, 4, aSN1ObjectIdentifier3));
        hashMap.put(Integers.valueOf(21), new XMSSMTParameters(40, 8, aSN1ObjectIdentifier3));
        hashMap.put(Integers.valueOf(22), new XMSSMTParameters(60, 3, aSN1ObjectIdentifier3));
        hashMap.put(Integers.valueOf(23), new XMSSMTParameters(60, 6, aSN1ObjectIdentifier3));
        hashMap.put(Integers.valueOf(24), new XMSSMTParameters(60, 12, aSN1ObjectIdentifier3));
        Integer valueOf4 = Integers.valueOf(25);
        ASN1ObjectIdentifier aSN1ObjectIdentifier4 = NISTObjectIdentifiers.id_shake256;
        hashMap.put(valueOf4, new XMSSMTParameters(20, 2, aSN1ObjectIdentifier4));
        hashMap.put(Integers.valueOf(26), new XMSSMTParameters(20, 4, aSN1ObjectIdentifier4));
        hashMap.put(Integers.valueOf(27), new XMSSMTParameters(40, 2, aSN1ObjectIdentifier4));
        hashMap.put(Integers.valueOf(28), new XMSSMTParameters(40, 4, aSN1ObjectIdentifier4));
        hashMap.put(Integers.valueOf(29), new XMSSMTParameters(40, 8, aSN1ObjectIdentifier4));
        hashMap.put(Integers.valueOf(30), new XMSSMTParameters(60, 3, aSN1ObjectIdentifier4));
        hashMap.put(Integers.valueOf(31), new XMSSMTParameters(60, 6, aSN1ObjectIdentifier4));
        hashMap.put(Integers.valueOf(32), new XMSSMTParameters(60, 12, aSN1ObjectIdentifier4));
        paramsLookupTable = Collections.unmodifiableMap(hashMap);
    }

    public XMSSMTParameters(int i11, int i12, ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        this.height = i11;
        this.layers = i12;
        this.xmssParams = new XMSSParameters(xmssTreeHeight(i11, i12), aSN1ObjectIdentifier);
        this.oid = DefaultXMSSMTOid.lookup(getTreeDigest(), getTreeDigestSize(), getWinternitzParameter(), getLen(), getHeight(), i12);
    }

    public XMSSMTParameters(int i11, int i12, Digest digest) {
        this(i11, i12, DigestUtil.getDigestOID(digest.getAlgorithmName()));
    }

    public static XMSSMTParameters lookupByOID(int i11) {
        return paramsLookupTable.get(Integers.valueOf(i11));
    }

    private static int xmssTreeHeight(int i11, int i12) throws IllegalArgumentException {
        if (i11 < 2) {
            throw new IllegalArgumentException("totalHeight must be > 1");
        } else if (i11 % i12 == 0) {
            int i13 = i11 / i12;
            if (i13 != 1) {
                return i13;
            }
            throw new IllegalArgumentException("height / layers must be greater than 1");
        } else {
            throw new IllegalArgumentException("layers must divide totalHeight without remainder");
        }
    }

    public int getHeight() {
        return this.height;
    }

    public int getLayers() {
        return this.layers;
    }

    public int getLen() {
        return this.xmssParams.getLen();
    }

    public XMSSOid getOid() {
        return this.oid;
    }

    public String getTreeDigest() {
        return this.xmssParams.getTreeDigest();
    }

    public ASN1ObjectIdentifier getTreeDigestOID() {
        return this.xmssParams.getTreeDigestOID();
    }

    public int getTreeDigestSize() {
        return this.xmssParams.getTreeDigestSize();
    }

    public WOTSPlus getWOTSPlus() {
        return this.xmssParams.getWOTSPlus();
    }

    public int getWinternitzParameter() {
        return this.xmssParams.getWinternitzParameter();
    }

    public XMSSParameters getXMSSParameters() {
        return this.xmssParams;
    }
}
