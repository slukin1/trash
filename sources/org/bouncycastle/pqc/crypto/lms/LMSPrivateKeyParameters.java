package org.bouncycastle.pqc.crypto.lms;

import java.io.IOException;
import java.util.Map;
import java.util.WeakHashMap;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.pqc.crypto.ExhaustedPrivateKeyException;
import org.bouncycastle.util.Arrays;

public class LMSPrivateKeyParameters extends LMSKeyParameters implements LMSContextBasedSigner {
    private static CacheKey T1;
    private static CacheKey[] internedKeys;
    private final byte[] I;
    private final byte[] masterSecret;
    private final int maxCacheR;
    private final int maxQ;
    private final LMOtsParameters otsParameters;
    private final LMSigParameters parameters;
    private LMSPublicKeyParameters publicKey;

    /* renamed from: q  reason: collision with root package name */
    private int f59544q;
    private final Map<CacheKey, byte[]> tCache;
    private final Digest tDigest;

    public static class CacheKey {
        /* access modifiers changed from: private */
        public final int index;

        public CacheKey(int i11) {
            this.index = i11;
        }

        public boolean equals(Object obj) {
            return (obj instanceof CacheKey) && ((CacheKey) obj).index == this.index;
        }

        public int hashCode() {
            return this.index;
        }
    }

    static {
        CacheKey cacheKey = new CacheKey(1);
        T1 = cacheKey;
        CacheKey[] cacheKeyArr = new CacheKey[129];
        internedKeys = cacheKeyArr;
        cacheKeyArr[1] = cacheKey;
        int i11 = 2;
        while (true) {
            CacheKey[] cacheKeyArr2 = internedKeys;
            if (i11 < cacheKeyArr2.length) {
                cacheKeyArr2[i11] = new CacheKey(i11);
                i11++;
            } else {
                return;
            }
        }
    }

    private LMSPrivateKeyParameters(LMSPrivateKeyParameters lMSPrivateKeyParameters, int i11, int i12) {
        super(true);
        LMSigParameters lMSigParameters = lMSPrivateKeyParameters.parameters;
        this.parameters = lMSigParameters;
        this.otsParameters = lMSPrivateKeyParameters.otsParameters;
        this.f59544q = i11;
        this.I = lMSPrivateKeyParameters.I;
        this.maxQ = i12;
        this.masterSecret = lMSPrivateKeyParameters.masterSecret;
        this.maxCacheR = 1 << lMSigParameters.getH();
        this.tCache = lMSPrivateKeyParameters.tCache;
        this.tDigest = DigestUtil.getDigest(lMSigParameters.getDigestOID());
        this.publicKey = lMSPrivateKeyParameters.publicKey;
    }

    public LMSPrivateKeyParameters(LMSigParameters lMSigParameters, LMOtsParameters lMOtsParameters, int i11, byte[] bArr, int i12, byte[] bArr2) {
        super(true);
        this.parameters = lMSigParameters;
        this.otsParameters = lMOtsParameters;
        this.f59544q = i11;
        this.I = Arrays.clone(bArr);
        this.maxQ = i12;
        this.masterSecret = Arrays.clone(bArr2);
        this.maxCacheR = 1 << (lMSigParameters.getH() + 1);
        this.tCache = new WeakHashMap();
        this.tDigest = DigestUtil.getDigest(lMSigParameters.getDigestOID());
    }

    private byte[] calcT(int i11) {
        int h11 = 1 << getSigParameters().getH();
        if (i11 >= h11) {
            LmsUtils.byteArray(getI(), this.tDigest);
            LmsUtils.u32str(i11, this.tDigest);
            LmsUtils.u16str(LMS.D_LEAF, this.tDigest);
            LmsUtils.byteArray(LM_OTS.lms_ots_generatePublicKey(getOtsParameters(), getI(), i11 - h11, getMasterSecret()), this.tDigest);
            byte[] bArr = new byte[this.tDigest.getDigestSize()];
            this.tDigest.doFinal(bArr, 0);
            return bArr;
        }
        int i12 = i11 * 2;
        byte[] findT = findT(i12);
        byte[] findT2 = findT(i12 + 1);
        LmsUtils.byteArray(getI(), this.tDigest);
        LmsUtils.u32str(i11, this.tDigest);
        LmsUtils.u16str(LMS.D_INTR, this.tDigest);
        LmsUtils.byteArray(findT, this.tDigest);
        LmsUtils.byteArray(findT2, this.tDigest);
        byte[] bArr2 = new byte[this.tDigest.getDigestSize()];
        this.tDigest.doFinal(bArr2, 0);
        return bArr2;
    }

    private byte[] findT(CacheKey cacheKey) {
        synchronized (this.tCache) {
            byte[] bArr = this.tCache.get(cacheKey);
            if (bArr != null) {
                return bArr;
            }
            byte[] calcT = calcT(cacheKey.index);
            this.tCache.put(cacheKey, calcT);
            return calcT;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0094  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.bouncycastle.pqc.crypto.lms.LMSPrivateKeyParameters getInstance(java.lang.Object r8) throws java.io.IOException {
        /*
            boolean r0 = r8 instanceof org.bouncycastle.pqc.crypto.lms.LMSPrivateKeyParameters
            if (r0 == 0) goto L_0x0007
            org.bouncycastle.pqc.crypto.lms.LMSPrivateKeyParameters r8 = (org.bouncycastle.pqc.crypto.lms.LMSPrivateKeyParameters) r8
            return r8
        L_0x0007:
            boolean r0 = r8 instanceof java.io.DataInputStream
            if (r0 == 0) goto L_0x0075
            java.io.DataInputStream r8 = (java.io.DataInputStream) r8
            int r0 = r8.readInt()
            if (r0 != 0) goto L_0x006d
            int r0 = r8.readInt()
            org.bouncycastle.pqc.crypto.lms.LMSigParameters r2 = org.bouncycastle.pqc.crypto.lms.LMSigParameters.getParametersForType(r0)
            int r0 = r8.readInt()
            org.bouncycastle.pqc.crypto.lms.LMOtsParameters r3 = org.bouncycastle.pqc.crypto.lms.LMOtsParameters.getParametersForType(r0)
            r0 = 16
            byte[] r5 = new byte[r0]
            r8.readFully(r5)
            int r4 = r8.readInt()
            int r6 = r8.readInt()
            int r0 = r8.readInt()
            if (r0 < 0) goto L_0x0065
            int r1 = r8.available()
            if (r0 > r1) goto L_0x004a
            byte[] r7 = new byte[r0]
            r8.readFully(r7)
            org.bouncycastle.pqc.crypto.lms.LMSPrivateKeyParameters r8 = new org.bouncycastle.pqc.crypto.lms.LMSPrivateKeyParameters
            r1 = r8
            r1.<init>(r2, r3, r4, r5, r6, r7)
            return r8
        L_0x004a:
            java.io.IOException r0 = new java.io.IOException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "secret length exceeded "
            r1.append(r2)
            int r8 = r8.available()
            r1.append(r8)
            java.lang.String r8 = r1.toString()
            r0.<init>(r8)
            throw r0
        L_0x0065:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "secret length less than zero"
            r8.<init>(r0)
            throw r8
        L_0x006d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "expected version 0 lms private key"
            r8.<init>(r0)
            throw r8
        L_0x0075:
            boolean r0 = r8 instanceof byte[]
            if (r0 == 0) goto L_0x0098
            r0 = 0
            java.io.DataInputStream r1 = new java.io.DataInputStream     // Catch:{ all -> 0x0091 }
            java.io.ByteArrayInputStream r2 = new java.io.ByteArrayInputStream     // Catch:{ all -> 0x0091 }
            byte[] r8 = (byte[]) r8     // Catch:{ all -> 0x0091 }
            r2.<init>(r8)     // Catch:{ all -> 0x0091 }
            r1.<init>(r2)     // Catch:{ all -> 0x0091 }
            org.bouncycastle.pqc.crypto.lms.LMSPrivateKeyParameters r8 = getInstance(r1)     // Catch:{ all -> 0x008e }
            r1.close()
            return r8
        L_0x008e:
            r8 = move-exception
            r0 = r1
            goto L_0x0092
        L_0x0091:
            r8 = move-exception
        L_0x0092:
            if (r0 == 0) goto L_0x0097
            r0.close()
        L_0x0097:
            throw r8
        L_0x0098:
            boolean r0 = r8 instanceof java.io.InputStream
            if (r0 == 0) goto L_0x00a7
            java.io.InputStream r8 = (java.io.InputStream) r8
            byte[] r8 = org.bouncycastle.util.io.Streams.readAll(r8)
            org.bouncycastle.pqc.crypto.lms.LMSPrivateKeyParameters r8 = getInstance(r8)
            return r8
        L_0x00a7:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "cannot parse "
            r1.append(r2)
            r1.append(r8)
            java.lang.String r8 = r1.toString()
            r0.<init>(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.pqc.crypto.lms.LMSPrivateKeyParameters.getInstance(java.lang.Object):org.bouncycastle.pqc.crypto.lms.LMSPrivateKeyParameters");
    }

    public static LMSPrivateKeyParameters getInstance(byte[] bArr, byte[] bArr2) throws IOException {
        LMSPrivateKeyParameters instance = getInstance(bArr);
        instance.publicKey = LMSPublicKeyParameters.getInstance(bArr2);
        return instance;
    }

    public boolean equals(Object obj) {
        LMSPublicKeyParameters lMSPublicKeyParameters;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        LMSPrivateKeyParameters lMSPrivateKeyParameters = (LMSPrivateKeyParameters) obj;
        if (this.f59544q != lMSPrivateKeyParameters.f59544q || this.maxQ != lMSPrivateKeyParameters.maxQ || !Arrays.areEqual(this.I, lMSPrivateKeyParameters.I)) {
            return false;
        }
        LMSigParameters lMSigParameters = this.parameters;
        if (lMSigParameters == null ? lMSPrivateKeyParameters.parameters != null : !lMSigParameters.equals(lMSPrivateKeyParameters.parameters)) {
            return false;
        }
        LMOtsParameters lMOtsParameters = this.otsParameters;
        if (lMOtsParameters == null ? lMSPrivateKeyParameters.otsParameters != null : !lMOtsParameters.equals(lMSPrivateKeyParameters.otsParameters)) {
            return false;
        }
        if (!Arrays.areEqual(this.masterSecret, lMSPrivateKeyParameters.masterSecret)) {
            return false;
        }
        LMSPublicKeyParameters lMSPublicKeyParameters2 = this.publicKey;
        if (lMSPublicKeyParameters2 == null || (lMSPublicKeyParameters = lMSPrivateKeyParameters.publicKey) == null) {
            return true;
        }
        return lMSPublicKeyParameters2.equals(lMSPublicKeyParameters);
    }

    public LMSPrivateKeyParameters extractKeyShard(int i11) {
        LMSPrivateKeyParameters lMSPrivateKeyParameters;
        synchronized (this) {
            int i12 = this.f59544q;
            if (i12 + i11 < this.maxQ) {
                lMSPrivateKeyParameters = new LMSPrivateKeyParameters(this, i12, i12 + i11);
                this.f59544q += i11;
            } else {
                throw new IllegalArgumentException("usageCount exceeds usages remaining");
            }
        }
        return lMSPrivateKeyParameters;
    }

    public byte[] findT(int i11) {
        if (i11 >= this.maxCacheR) {
            return calcT(i11);
        }
        CacheKey[] cacheKeyArr = internedKeys;
        return findT(i11 < cacheKeyArr.length ? cacheKeyArr[i11] : new CacheKey(i11));
    }

    public LMSContext generateLMSContext() {
        int h11 = getSigParameters().getH();
        int index = getIndex();
        LMOtsPrivateKey nextOtsPrivateKey = getNextOtsPrivateKey();
        int i11 = (1 << h11) + index;
        byte[][] bArr = new byte[h11][];
        for (int i12 = 0; i12 < h11; i12++) {
            bArr[i12] = findT((i11 / (1 << i12)) ^ 1);
        }
        return nextOtsPrivateKey.getSignatureContext(getSigParameters(), bArr);
    }

    public byte[] generateSignature(LMSContext lMSContext) {
        try {
            return LMS.generateSign(lMSContext).getEncoded();
        } catch (IOException e11) {
            throw new IllegalStateException("unable to encode signature: " + e11.getMessage(), e11);
        }
    }

    public LMOtsPrivateKey getCurrentOTSKey() {
        LMOtsPrivateKey lMOtsPrivateKey;
        synchronized (this) {
            int i11 = this.f59544q;
            if (i11 < this.maxQ) {
                lMOtsPrivateKey = new LMOtsPrivateKey(this.otsParameters, this.I, i11, this.masterSecret);
            } else {
                throw new ExhaustedPrivateKeyException("ots private keys expired");
            }
        }
        return lMOtsPrivateKey;
    }

    public byte[] getEncoded() throws IOException {
        return Composer.compose().u32str(0).u32str(this.parameters.getType()).u32str(this.otsParameters.getType()).bytes(this.I).u32str(this.f59544q).u32str(this.maxQ).u32str(this.masterSecret.length).bytes(this.masterSecret).build();
    }

    public byte[] getI() {
        return Arrays.clone(this.I);
    }

    public synchronized int getIndex() {
        return this.f59544q;
    }

    public byte[] getMasterSecret() {
        return Arrays.clone(this.masterSecret);
    }

    public LMOtsPrivateKey getNextOtsPrivateKey() {
        LMOtsPrivateKey lMOtsPrivateKey;
        synchronized (this) {
            int i11 = this.f59544q;
            if (i11 < this.maxQ) {
                lMOtsPrivateKey = new LMOtsPrivateKey(this.otsParameters, this.I, i11, this.masterSecret);
                incIndex();
            } else {
                throw new ExhaustedPrivateKeyException("ots private key exhausted");
            }
        }
        return lMOtsPrivateKey;
    }

    public LMOtsParameters getOtsParameters() {
        return this.otsParameters;
    }

    public LMSPublicKeyParameters getPublicKey() {
        LMSPublicKeyParameters lMSPublicKeyParameters;
        synchronized (this) {
            if (this.publicKey == null) {
                this.publicKey = new LMSPublicKeyParameters(this.parameters, this.otsParameters, findT(T1), this.I);
            }
            lMSPublicKeyParameters = this.publicKey;
        }
        return lMSPublicKeyParameters;
    }

    public LMSigParameters getSigParameters() {
        return this.parameters;
    }

    public long getUsagesRemaining() {
        return (long) (this.maxQ - this.f59544q);
    }

    public int hashCode() {
        int hashCode = ((this.f59544q * 31) + Arrays.hashCode(this.I)) * 31;
        LMSigParameters lMSigParameters = this.parameters;
        int i11 = 0;
        int hashCode2 = (hashCode + (lMSigParameters != null ? lMSigParameters.hashCode() : 0)) * 31;
        LMOtsParameters lMOtsParameters = this.otsParameters;
        int hashCode3 = (((((hashCode2 + (lMOtsParameters != null ? lMOtsParameters.hashCode() : 0)) * 31) + this.maxQ) * 31) + Arrays.hashCode(this.masterSecret)) * 31;
        LMSPublicKeyParameters lMSPublicKeyParameters = this.publicKey;
        if (lMSPublicKeyParameters != null) {
            i11 = lMSPublicKeyParameters.hashCode();
        }
        return hashCode3 + i11;
    }

    public synchronized void incIndex() {
        this.f59544q++;
    }
}
