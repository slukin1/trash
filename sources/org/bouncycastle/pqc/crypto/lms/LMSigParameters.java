package org.bouncycastle.pqc.crypto.lms;

import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;

public class LMSigParameters {
    public static final LMSigParameters lms_sha256_n32_h10;
    public static final LMSigParameters lms_sha256_n32_h15;
    public static final LMSigParameters lms_sha256_n32_h20;
    public static final LMSigParameters lms_sha256_n32_h25;
    public static final LMSigParameters lms_sha256_n32_h5;
    private static Map<Object, LMSigParameters> paramBuilders = new HashMap<Object, LMSigParameters>() {
        {
            LMSigParameters lMSigParameters = LMSigParameters.lms_sha256_n32_h5;
            put(Integer.valueOf(lMSigParameters.type), lMSigParameters);
            LMSigParameters lMSigParameters2 = LMSigParameters.lms_sha256_n32_h10;
            put(Integer.valueOf(lMSigParameters2.type), lMSigParameters2);
            LMSigParameters lMSigParameters3 = LMSigParameters.lms_sha256_n32_h15;
            put(Integer.valueOf(lMSigParameters3.type), lMSigParameters3);
            LMSigParameters lMSigParameters4 = LMSigParameters.lms_sha256_n32_h20;
            put(Integer.valueOf(lMSigParameters4.type), lMSigParameters4);
            LMSigParameters lMSigParameters5 = LMSigParameters.lms_sha256_n32_h25;
            put(Integer.valueOf(lMSigParameters5.type), lMSigParameters5);
        }
    };
    private final ASN1ObjectIdentifier digestOid;

    /* renamed from: h  reason: collision with root package name */
    private final int f59547h;

    /* renamed from: m  reason: collision with root package name */
    private final int f59548m;
    /* access modifiers changed from: private */
    public final int type;

    static {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = NISTObjectIdentifiers.id_sha256;
        lms_sha256_n32_h5 = new LMSigParameters(5, 32, 5, aSN1ObjectIdentifier);
        lms_sha256_n32_h10 = new LMSigParameters(6, 32, 10, aSN1ObjectIdentifier);
        lms_sha256_n32_h15 = new LMSigParameters(7, 32, 15, aSN1ObjectIdentifier);
        lms_sha256_n32_h20 = new LMSigParameters(8, 32, 20, aSN1ObjectIdentifier);
        lms_sha256_n32_h25 = new LMSigParameters(9, 32, 25, aSN1ObjectIdentifier);
    }

    public LMSigParameters(int i11, int i12, int i13, ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        this.type = i11;
        this.f59548m = i12;
        this.f59547h = i13;
        this.digestOid = aSN1ObjectIdentifier;
    }

    public static LMSigParameters getParametersForType(int i11) {
        return paramBuilders.get(Integer.valueOf(i11));
    }

    public ASN1ObjectIdentifier getDigestOID() {
        return this.digestOid;
    }

    public int getH() {
        return this.f59547h;
    }

    public int getM() {
        return this.f59548m;
    }

    public int getType() {
        return this.type;
    }
}
