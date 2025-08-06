package org.bouncycastle.pqc.crypto.lms;

import java.io.IOException;

public class HSSPublicKeyParameters extends LMSKeyParameters implements LMSContextBasedVerifier {

    /* renamed from: l  reason: collision with root package name */
    private final int f59536l;
    private final LMSPublicKeyParameters lmsPublicKey;

    public HSSPublicKeyParameters(int i11, LMSPublicKeyParameters lMSPublicKeyParameters) {
        super(false);
        this.f59536l = i11;
        this.lmsPublicKey = lMSPublicKeyParameters;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x003b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.bouncycastle.pqc.crypto.lms.HSSPublicKeyParameters getInstance(java.lang.Object r3) throws java.io.IOException {
        /*
            boolean r0 = r3 instanceof org.bouncycastle.pqc.crypto.lms.HSSPublicKeyParameters
            if (r0 == 0) goto L_0x0007
            org.bouncycastle.pqc.crypto.lms.HSSPublicKeyParameters r3 = (org.bouncycastle.pqc.crypto.lms.HSSPublicKeyParameters) r3
            return r3
        L_0x0007:
            boolean r0 = r3 instanceof java.io.DataInputStream
            if (r0 == 0) goto L_0x001c
            r0 = r3
            java.io.DataInputStream r0 = (java.io.DataInputStream) r0
            int r0 = r0.readInt()
            org.bouncycastle.pqc.crypto.lms.LMSPublicKeyParameters r3 = org.bouncycastle.pqc.crypto.lms.LMSPublicKeyParameters.getInstance(r3)
            org.bouncycastle.pqc.crypto.lms.HSSPublicKeyParameters r1 = new org.bouncycastle.pqc.crypto.lms.HSSPublicKeyParameters
            r1.<init>(r0, r3)
            return r1
        L_0x001c:
            boolean r0 = r3 instanceof byte[]
            if (r0 == 0) goto L_0x003f
            r0 = 0
            java.io.DataInputStream r1 = new java.io.DataInputStream     // Catch:{ all -> 0x0038 }
            java.io.ByteArrayInputStream r2 = new java.io.ByteArrayInputStream     // Catch:{ all -> 0x0038 }
            byte[] r3 = (byte[]) r3     // Catch:{ all -> 0x0038 }
            r2.<init>(r3)     // Catch:{ all -> 0x0038 }
            r1.<init>(r2)     // Catch:{ all -> 0x0038 }
            org.bouncycastle.pqc.crypto.lms.HSSPublicKeyParameters r3 = getInstance(r1)     // Catch:{ all -> 0x0035 }
            r1.close()
            return r3
        L_0x0035:
            r3 = move-exception
            r0 = r1
            goto L_0x0039
        L_0x0038:
            r3 = move-exception
        L_0x0039:
            if (r0 == 0) goto L_0x003e
            r0.close()
        L_0x003e:
            throw r3
        L_0x003f:
            boolean r0 = r3 instanceof java.io.InputStream
            if (r0 == 0) goto L_0x004e
            java.io.InputStream r3 = (java.io.InputStream) r3
            byte[] r3 = org.bouncycastle.util.io.Streams.readAll(r3)
            org.bouncycastle.pqc.crypto.lms.HSSPublicKeyParameters r3 = getInstance(r3)
            return r3
        L_0x004e:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "cannot parse "
            r1.append(r2)
            r1.append(r3)
            java.lang.String r3 = r1.toString()
            r0.<init>(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.pqc.crypto.lms.HSSPublicKeyParameters.getInstance(java.lang.Object):org.bouncycastle.pqc.crypto.lms.HSSPublicKeyParameters");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        HSSPublicKeyParameters hSSPublicKeyParameters = (HSSPublicKeyParameters) obj;
        if (this.f59536l != hSSPublicKeyParameters.f59536l) {
            return false;
        }
        return this.lmsPublicKey.equals(hSSPublicKeyParameters.lmsPublicKey);
    }

    public LMSContext generateLMSContext(byte[] bArr) {
        try {
            HSSSignature instance = HSSSignature.getInstance(bArr, getL());
            LMSSignedPubKey[] signedPubKey = instance.getSignedPubKey();
            return signedPubKey[signedPubKey.length - 1].getPublicKey().generateOtsContext(instance.getSignature()).withSignedPublicKeys(signedPubKey);
        } catch (IOException e11) {
            throw new IllegalStateException("cannot parse signature: " + e11.getMessage());
        }
    }

    public byte[] getEncoded() throws IOException {
        return Composer.compose().u32str(this.f59536l).bytes(this.lmsPublicKey.getEncoded()).build();
    }

    public int getL() {
        return this.f59536l;
    }

    public LMSPublicKeyParameters getLMSPublicKey() {
        return this.lmsPublicKey;
    }

    public int hashCode() {
        return (this.f59536l * 31) + this.lmsPublicKey.hashCode();
    }

    public boolean verify(LMSContext lMSContext) {
        LMSSignedPubKey[] signedPubKeys = lMSContext.getSignedPubKeys();
        if (signedPubKeys.length != getL() - 1) {
            return false;
        }
        LMSPublicKeyParameters lMSPublicKey = getLMSPublicKey();
        boolean z11 = false;
        for (int i11 = 0; i11 < signedPubKeys.length; i11++) {
            if (!LMS.verifySignature(lMSPublicKey, signedPubKeys[i11].getSignature(), signedPubKeys[i11].getPublicKey().toByteArray())) {
                z11 = true;
            }
            lMSPublicKey = signedPubKeys[i11].getPublicKey();
        }
        return lMSPublicKey.verify(lMSContext) & (!z11);
    }
}
