package org.bouncycastle.pqc.crypto.lms;

import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;

public class LMOtsParameters {
    public static final int reserved = 0;
    public static final LMOtsParameters sha256_n32_w1;
    public static final LMOtsParameters sha256_n32_w2;
    public static final LMOtsParameters sha256_n32_w4;
    public static final LMOtsParameters sha256_n32_w8;
    private static final Map<Object, LMOtsParameters> suppliers = new HashMap<Object, LMOtsParameters>() {
        {
            LMOtsParameters lMOtsParameters = LMOtsParameters.sha256_n32_w1;
            put(Integer.valueOf(lMOtsParameters.type), lMOtsParameters);
            LMOtsParameters lMOtsParameters2 = LMOtsParameters.sha256_n32_w2;
            put(Integer.valueOf(lMOtsParameters2.type), lMOtsParameters2);
            LMOtsParameters lMOtsParameters3 = LMOtsParameters.sha256_n32_w4;
            put(Integer.valueOf(lMOtsParameters3.type), lMOtsParameters3);
            LMOtsParameters lMOtsParameters4 = LMOtsParameters.sha256_n32_w8;
            put(Integer.valueOf(lMOtsParameters4.type), lMOtsParameters4);
        }
    };
    private final ASN1ObjectIdentifier digestOID;

    /* renamed from: ls  reason: collision with root package name */
    private final int f59537ls;

    /* renamed from: n  reason: collision with root package name */
    private final int f59538n;

    /* renamed from: p  reason: collision with root package name */
    private final int f59539p;
    private final int sigLen;
    /* access modifiers changed from: private */
    public final int type;

    /* renamed from: w  reason: collision with root package name */
    private final int f59540w;

    static {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = NISTObjectIdentifiers.id_sha256;
        sha256_n32_w1 = new LMOtsParameters(1, 32, 1, 265, 7, 8516, aSN1ObjectIdentifier);
        sha256_n32_w2 = new LMOtsParameters(2, 32, 2, 133, 6, 4292, aSN1ObjectIdentifier);
        sha256_n32_w4 = new LMOtsParameters(3, 32, 4, 67, 4, 2180, aSN1ObjectIdentifier);
        sha256_n32_w8 = new LMOtsParameters(4, 32, 8, 34, 0, 1124, aSN1ObjectIdentifier);
    }

    public LMOtsParameters(int i11, int i12, int i13, int i14, int i15, int i16, ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        this.type = i11;
        this.f59538n = i12;
        this.f59540w = i13;
        this.f59539p = i14;
        this.f59537ls = i15;
        this.sigLen = i16;
        this.digestOID = aSN1ObjectIdentifier;
    }

    public static LMOtsParameters getParametersForType(int i11) {
        return suppliers.get(Integer.valueOf(i11));
    }

    public ASN1ObjectIdentifier getDigestOID() {
        return this.digestOID;
    }

    public int getLs() {
        return this.f59537ls;
    }

    public int getN() {
        return this.f59538n;
    }

    public int getP() {
        return this.f59539p;
    }

    public int getSigLen() {
        return this.sigLen;
    }

    public int getType() {
        return this.type;
    }

    public int getW() {
        return this.f59540w;
    }
}
