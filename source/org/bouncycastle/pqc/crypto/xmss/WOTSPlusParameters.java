package org.bouncycastle.pqc.crypto.xmss;

import java.util.Objects;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.crypto.Digest;

final class WOTSPlusParameters {
    private final int digestSize;
    private final int len;
    private final int len1;
    private final int len2;
    private final XMSSOid oid;
    private final ASN1ObjectIdentifier treeDigest;
    private final int winternitzParameter = 16;

    public WOTSPlusParameters(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        Objects.requireNonNull(aSN1ObjectIdentifier, "treeDigest == null");
        this.treeDigest = aSN1ObjectIdentifier;
        Digest digest = DigestUtil.getDigest(aSN1ObjectIdentifier);
        int digestSize2 = XMSSUtil.getDigestSize(digest);
        this.digestSize = digestSize2;
        int ceil = (int) Math.ceil(((double) (digestSize2 * 8)) / ((double) XMSSUtil.log2(16)));
        this.len1 = ceil;
        int floor = ((int) Math.floor((double) (XMSSUtil.log2((16 - 1) * ceil) / XMSSUtil.log2(16)))) + 1;
        this.len2 = floor;
        int i11 = ceil + floor;
        this.len = i11;
        WOTSPlusOid lookup = WOTSPlusOid.lookup(digest.getAlgorithmName(), digestSize2, 16, i11);
        this.oid = lookup;
        if (lookup == null) {
            throw new IllegalArgumentException("cannot find OID for digest algorithm: " + digest.getAlgorithmName());
        }
    }

    public int getLen() {
        return this.len;
    }

    public int getLen1() {
        return this.len1;
    }

    public int getLen2() {
        return this.len2;
    }

    public XMSSOid getOid() {
        return this.oid;
    }

    public ASN1ObjectIdentifier getTreeDigest() {
        return this.treeDigest;
    }

    public int getTreeDigestSize() {
        return this.digestSize;
    }

    public int getWinternitzParameter() {
        return this.winternitzParameter;
    }
}
