package org.bouncycastle.pqc.crypto.lms;

import java.io.IOException;
import java.util.Arrays;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.util.Encodable;

class LMOtsPublicKey implements Encodable {
    private final byte[] I;
    private final byte[] K;
    private final LMOtsParameters parameter;

    /* renamed from: q  reason: collision with root package name */
    private final int f59542q;

    public LMOtsPublicKey(LMOtsParameters lMOtsParameters, byte[] bArr, int i11, byte[] bArr2) {
        this.parameter = lMOtsParameters;
        this.I = bArr;
        this.f59542q = i11;
        this.K = bArr2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x004e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.bouncycastle.pqc.crypto.lms.LMOtsPublicKey getInstance(java.lang.Object r4) throws java.lang.Exception {
        /*
            boolean r0 = r4 instanceof org.bouncycastle.pqc.crypto.lms.LMOtsPublicKey
            if (r0 == 0) goto L_0x0007
            org.bouncycastle.pqc.crypto.lms.LMOtsPublicKey r4 = (org.bouncycastle.pqc.crypto.lms.LMOtsPublicKey) r4
            return r4
        L_0x0007:
            boolean r0 = r4 instanceof java.io.DataInputStream
            if (r0 == 0) goto L_0x002f
            java.io.DataInputStream r4 = (java.io.DataInputStream) r4
            int r0 = r4.readInt()
            org.bouncycastle.pqc.crypto.lms.LMOtsParameters r0 = org.bouncycastle.pqc.crypto.lms.LMOtsParameters.getParametersForType(r0)
            r1 = 16
            byte[] r1 = new byte[r1]
            r4.readFully(r1)
            int r2 = r4.readInt()
            int r3 = r0.getN()
            byte[] r3 = new byte[r3]
            r4.readFully(r3)
            org.bouncycastle.pqc.crypto.lms.LMOtsPublicKey r4 = new org.bouncycastle.pqc.crypto.lms.LMOtsPublicKey
            r4.<init>(r0, r1, r2, r3)
            return r4
        L_0x002f:
            boolean r0 = r4 instanceof byte[]
            if (r0 == 0) goto L_0x0052
            r0 = 0
            java.io.DataInputStream r1 = new java.io.DataInputStream     // Catch:{ all -> 0x004b }
            java.io.ByteArrayInputStream r2 = new java.io.ByteArrayInputStream     // Catch:{ all -> 0x004b }
            byte[] r4 = (byte[]) r4     // Catch:{ all -> 0x004b }
            r2.<init>(r4)     // Catch:{ all -> 0x004b }
            r1.<init>(r2)     // Catch:{ all -> 0x004b }
            org.bouncycastle.pqc.crypto.lms.LMOtsPublicKey r4 = getInstance(r1)     // Catch:{ all -> 0x0048 }
            r1.close()
            return r4
        L_0x0048:
            r4 = move-exception
            r0 = r1
            goto L_0x004c
        L_0x004b:
            r4 = move-exception
        L_0x004c:
            if (r0 == 0) goto L_0x0051
            r0.close()
        L_0x0051:
            throw r4
        L_0x0052:
            boolean r0 = r4 instanceof java.io.InputStream
            if (r0 == 0) goto L_0x0061
            java.io.InputStream r4 = (java.io.InputStream) r4
            byte[] r4 = org.bouncycastle.util.io.Streams.readAll(r4)
            org.bouncycastle.pqc.crypto.lms.LMOtsPublicKey r4 = getInstance(r4)
            return r4
        L_0x0061:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "cannot parse "
            r1.append(r2)
            r1.append(r4)
            java.lang.String r4 = r1.toString()
            r0.<init>(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.pqc.crypto.lms.LMOtsPublicKey.getInstance(java.lang.Object):org.bouncycastle.pqc.crypto.lms.LMOtsPublicKey");
    }

    public LMSContext createOtsContext(LMOtsSignature lMOtsSignature) {
        Digest digest = DigestUtil.getDigest(this.parameter.getDigestOID());
        LmsUtils.byteArray(this.I, digest);
        LmsUtils.u32str(this.f59542q, digest);
        LmsUtils.u16str(LM_OTS.D_MESG, digest);
        LmsUtils.byteArray(lMOtsSignature.getC(), digest);
        return new LMSContext(this, lMOtsSignature, digest);
    }

    public LMSContext createOtsContext(LMSSignature lMSSignature) {
        Digest digest = DigestUtil.getDigest(this.parameter.getDigestOID());
        LmsUtils.byteArray(this.I, digest);
        LmsUtils.u32str(this.f59542q, digest);
        LmsUtils.u16str(LM_OTS.D_MESG, digest);
        LmsUtils.byteArray(lMSSignature.getOtsSignature().getC(), digest);
        return new LMSContext(this, lMSSignature, digest);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        LMOtsPublicKey lMOtsPublicKey = (LMOtsPublicKey) obj;
        if (this.f59542q != lMOtsPublicKey.f59542q) {
            return false;
        }
        LMOtsParameters lMOtsParameters = this.parameter;
        if (lMOtsParameters == null ? lMOtsPublicKey.parameter != null : !lMOtsParameters.equals(lMOtsPublicKey.parameter)) {
            return false;
        }
        if (!Arrays.equals(this.I, lMOtsPublicKey.I)) {
            return false;
        }
        return Arrays.equals(this.K, lMOtsPublicKey.K);
    }

    public byte[] getEncoded() throws IOException {
        return Composer.compose().u32str(this.parameter.getType()).bytes(this.I).u32str(this.f59542q).bytes(this.K).build();
    }

    public byte[] getI() {
        return this.I;
    }

    public byte[] getK() {
        return this.K;
    }

    public LMOtsParameters getParameter() {
        return this.parameter;
    }

    public int getQ() {
        return this.f59542q;
    }

    public int hashCode() {
        LMOtsParameters lMOtsParameters = this.parameter;
        return ((((((lMOtsParameters != null ? lMOtsParameters.hashCode() : 0) * 31) + Arrays.hashCode(this.I)) * 31) + this.f59542q) * 31) + Arrays.hashCode(this.K);
    }
}
