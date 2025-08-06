package org.bouncycastle.math.ec.rfc8032;

import com.facebook.appevents.UserDataStore;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.tencent.thumbplayer.tcmedia.core.player.ITPNativePlayerMessageCallback;
import java.security.SecureRandom;
import java.util.Objects;
import net.sf.scuba.smartcards.ISOFileInfo;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.SHA512Digest;
import org.bouncycastle.math.ec.rfc7748.X25519;
import org.bouncycastle.math.ec.rfc7748.X25519Field;
import org.bouncycastle.math.raw.Interleave;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.math.raw.Nat256;
import org.bouncycastle.util.Arrays;

public abstract class Ed25519 {
    private static final int[] B_x = {52811034, 25909283, 8072341, 50637101, 13785486, 30858332, 20483199, 20966410, 43936626, 4379245};
    private static final int[] B_y = {40265304, 26843545, 6710886, 53687091, 13421772, 40265318, 26843545, 6710886, 53687091, 13421772};
    private static final int COORD_INTS = 8;
    private static final int[] C_d = {56195235, 47411844, 25868126, 40503822, 57364, 58321048, 30416477, 31930572, 57760639, 10749657};
    private static final int[] C_d2 = {45281625, 27714825, 18181821, 13898781, 114729, 49533232, 60832955, 30306712, 48412415, 4722099};
    private static final int[] C_d4 = {23454386, 55429651, 2809210, 27797563, 229458, 31957600, 54557047, 27058993, 29715967, 9444199};
    private static final byte[] DOM2_PREFIX = {83, 105, 103, 69, 100, 50, 53, 53, Framer.STDOUT_FRAME_PREFIX, 57, 32, 110, ISOFileInfo.FCI_BYTE, 32, 69, 100, 50, 53, 53, Framer.STDOUT_FRAME_PREFIX, 57, 32, 99, ISOFileInfo.FCI_BYTE, 108, 108, 105, 115, 105, ISOFileInfo.FCI_BYTE, 110, 115};
    private static final int[] L = {1559614445, 1477600026, -1560830762, 350157278, 0, 0, 0, 268435456};
    private static final int L0 = -50998291;
    private static final int L1 = 19280294;
    private static final int L2 = 127719000;
    private static final int L3 = -6428113;
    private static final int L4 = 5343;
    private static final long M08L = 255;
    private static final long M28L = 268435455;
    private static final long M32L = 4294967295L;
    private static final int[] P = {-19, -1, -1, -1, -1, -1, -1, Integer.MAX_VALUE};
    private static final int POINT_BYTES = 32;
    private static final int PRECOMP_BLOCKS = 8;
    private static final int PRECOMP_MASK = 7;
    private static final int PRECOMP_POINTS = 8;
    private static final int PRECOMP_SPACING = 8;
    private static final int PRECOMP_TEETH = 4;
    public static final int PREHASH_SIZE = 64;
    public static final int PUBLIC_KEY_SIZE = 32;
    private static final int SCALAR_BYTES = 32;
    private static final int SCALAR_INTS = 8;
    public static final int SECRET_KEY_SIZE = 32;
    public static final int SIGNATURE_SIZE = 64;
    private static final int WNAF_WIDTH_BASE = 7;
    private static int[] precompBase = null;
    private static PointExt[] precompBaseTable = null;
    private static final Object precompLock = new Object();

    public static final class Algorithm {
        public static final int Ed25519 = 0;
        public static final int Ed25519ctx = 1;
        public static final int Ed25519ph = 2;
    }

    public static class F extends X25519Field {
        private F() {
        }
    }

    public static class PointAccum {

        /* renamed from: u  reason: collision with root package name */
        public int[] f59446u;

        /* renamed from: v  reason: collision with root package name */
        public int[] f59447v;

        /* renamed from: x  reason: collision with root package name */
        public int[] f59448x;

        /* renamed from: y  reason: collision with root package name */
        public int[] f59449y;

        /* renamed from: z  reason: collision with root package name */
        public int[] f59450z;

        private PointAccum() {
            this.f59448x = X25519Field.create();
            this.f59449y = X25519Field.create();
            this.f59450z = X25519Field.create();
            this.f59446u = X25519Field.create();
            this.f59447v = X25519Field.create();
        }
    }

    public static class PointAffine {

        /* renamed from: x  reason: collision with root package name */
        public int[] f59451x;

        /* renamed from: y  reason: collision with root package name */
        public int[] f59452y;

        private PointAffine() {
            this.f59451x = X25519Field.create();
            this.f59452y = X25519Field.create();
        }
    }

    public static class PointExt {

        /* renamed from: t  reason: collision with root package name */
        public int[] f59453t;

        /* renamed from: x  reason: collision with root package name */
        public int[] f59454x;

        /* renamed from: y  reason: collision with root package name */
        public int[] f59455y;

        /* renamed from: z  reason: collision with root package name */
        public int[] f59456z;

        private PointExt() {
            this.f59454x = X25519Field.create();
            this.f59455y = X25519Field.create();
            this.f59456z = X25519Field.create();
            this.f59453t = X25519Field.create();
        }
    }

    public static class PointPrecomp {
        public int[] xyd;
        public int[] ymx_h;
        public int[] ypx_h;

        private PointPrecomp() {
            this.ypx_h = X25519Field.create();
            this.ymx_h = X25519Field.create();
            this.xyd = X25519Field.create();
        }
    }

    private static byte[] calculateS(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        int[] iArr = new int[16];
        decodeScalar(bArr, 0, iArr);
        int[] iArr2 = new int[8];
        decodeScalar(bArr2, 0, iArr2);
        int[] iArr3 = new int[8];
        decodeScalar(bArr3, 0, iArr3);
        Nat256.mulAddTo(iArr2, iArr3, iArr);
        byte[] bArr4 = new byte[64];
        for (int i11 = 0; i11 < 16; i11++) {
            encode32(iArr[i11], bArr4, i11 * 4);
        }
        return reduceScalar(bArr4);
    }

    private static boolean checkContextVar(byte[] bArr, byte b11) {
        return (bArr == null && b11 == 0) || (bArr != null && bArr.length < 256);
    }

    private static int checkPoint(int[] iArr, int[] iArr2) {
        int[] create = X25519Field.create();
        int[] create2 = X25519Field.create();
        int[] create3 = X25519Field.create();
        X25519Field.sqr(iArr, create2);
        X25519Field.sqr(iArr2, create3);
        X25519Field.mul(create2, create3, create);
        X25519Field.sub(create3, create2, create3);
        X25519Field.mul(create, C_d, create);
        X25519Field.addOne(create);
        X25519Field.sub(create, create3, create);
        X25519Field.normalize(create);
        return X25519Field.isZero(create);
    }

    private static int checkPoint(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] create = X25519Field.create();
        int[] create2 = X25519Field.create();
        int[] create3 = X25519Field.create();
        int[] create4 = X25519Field.create();
        X25519Field.sqr(iArr, create2);
        X25519Field.sqr(iArr2, create3);
        X25519Field.sqr(iArr3, create4);
        X25519Field.mul(create2, create3, create);
        X25519Field.sub(create3, create2, create3);
        X25519Field.mul(create3, create4, create3);
        X25519Field.sqr(create4, create4);
        X25519Field.mul(create, C_d, create);
        X25519Field.add(create, create4, create);
        X25519Field.sub(create, create3, create);
        X25519Field.normalize(create);
        return X25519Field.isZero(create);
    }

    private static boolean checkPointVar(byte[] bArr) {
        int[] iArr = new int[8];
        decode32(bArr, 0, iArr, 0, 8);
        iArr[7] = iArr[7] & Integer.MAX_VALUE;
        return !Nat256.gte(iArr, P);
    }

    private static boolean checkScalarVar(byte[] bArr, int[] iArr) {
        decodeScalar(bArr, 0, iArr);
        return !Nat256.gte(iArr, L);
    }

    private static byte[] copy(byte[] bArr, int i11, int i12) {
        byte[] bArr2 = new byte[i12];
        System.arraycopy(bArr, i11, bArr2, 0, i12);
        return bArr2;
    }

    private static Digest createDigest() {
        return new SHA512Digest();
    }

    public static Digest createPrehash() {
        return createDigest();
    }

    private static int decode24(byte[] bArr, int i11) {
        int i12 = i11 + 1;
        return ((bArr[i12 + 1] & 255) << 16) | (bArr[i11] & 255) | ((bArr[i12] & 255) << 8);
    }

    private static int decode32(byte[] bArr, int i11) {
        int i12 = i11 + 1;
        int i13 = i12 + 1;
        return (bArr[i13 + 1] << Ascii.CAN) | (bArr[i11] & 255) | ((bArr[i12] & 255) << 8) | ((bArr[i13] & 255) << 16);
    }

    private static void decode32(byte[] bArr, int i11, int[] iArr, int i12, int i13) {
        for (int i14 = 0; i14 < i13; i14++) {
            iArr[i12 + i14] = decode32(bArr, (i14 * 4) + i11);
        }
    }

    private static boolean decodePointVar(byte[] bArr, int i11, boolean z11, PointAffine pointAffine) {
        byte[] copy = copy(bArr, i11, 32);
        boolean z12 = false;
        if (!checkPointVar(copy)) {
            return false;
        }
        int i12 = (copy[31] & 128) >>> 7;
        copy[31] = (byte) (copy[31] & Ascii.DEL);
        X25519Field.decode(copy, 0, pointAffine.f59452y);
        int[] create = X25519Field.create();
        int[] create2 = X25519Field.create();
        X25519Field.sqr(pointAffine.f59452y, create);
        X25519Field.mul(C_d, create, create2);
        X25519Field.subOne(create);
        X25519Field.addOne(create2);
        if (!X25519Field.sqrtRatioVar(create, create2, pointAffine.f59451x)) {
            return false;
        }
        X25519Field.normalize(pointAffine.f59451x);
        if (i12 == 1 && X25519Field.isZeroVar(pointAffine.f59451x)) {
            return false;
        }
        int[] iArr = pointAffine.f59451x;
        if (i12 != (iArr[0] & 1)) {
            z12 = true;
        }
        if (z11 ^ z12) {
            X25519Field.negate(iArr, iArr);
        }
        return true;
    }

    private static void decodeScalar(byte[] bArr, int i11, int[] iArr) {
        decode32(bArr, i11, iArr, 0, 8);
    }

    private static void dom2(Digest digest, byte b11, byte[] bArr) {
        if (bArr != null) {
            byte[] bArr2 = DOM2_PREFIX;
            int length = bArr2.length;
            int i11 = length + 2;
            int length2 = bArr.length + i11;
            byte[] bArr3 = new byte[length2];
            System.arraycopy(bArr2, 0, bArr3, 0, length);
            bArr3[length] = b11;
            bArr3[length + 1] = (byte) bArr.length;
            System.arraycopy(bArr, 0, bArr3, i11, bArr.length);
            digest.update(bArr3, 0, length2);
        }
    }

    private static void encode24(int i11, byte[] bArr, int i12) {
        bArr[i12] = (byte) i11;
        int i13 = i12 + 1;
        bArr[i13] = (byte) (i11 >>> 8);
        bArr[i13 + 1] = (byte) (i11 >>> 16);
    }

    private static void encode32(int i11, byte[] bArr, int i12) {
        bArr[i12] = (byte) i11;
        int i13 = i12 + 1;
        bArr[i13] = (byte) (i11 >>> 8);
        int i14 = i13 + 1;
        bArr[i14] = (byte) (i11 >>> 16);
        bArr[i14 + 1] = (byte) (i11 >>> 24);
    }

    private static void encode56(long j11, byte[] bArr, int i11) {
        encode32((int) j11, bArr, i11);
        encode24((int) (j11 >>> 32), bArr, i11 + 4);
    }

    private static int encodePoint(PointAccum pointAccum, byte[] bArr, int i11) {
        int[] create = X25519Field.create();
        int[] create2 = X25519Field.create();
        X25519Field.inv(pointAccum.f59450z, create2);
        X25519Field.mul(pointAccum.f59448x, create2, create);
        X25519Field.mul(pointAccum.f59449y, create2, create2);
        X25519Field.normalize(create);
        X25519Field.normalize(create2);
        int checkPoint = checkPoint(create, create2);
        X25519Field.encode(create2, bArr, i11);
        int i12 = (i11 + 32) - 1;
        bArr[i12] = (byte) (((create[0] & 1) << 7) | bArr[i12]);
        return checkPoint;
    }

    public static void generatePrivateKey(SecureRandom secureRandom, byte[] bArr) {
        secureRandom.nextBytes(bArr);
    }

    public static void generatePublicKey(byte[] bArr, int i11, byte[] bArr2, int i12) {
        Digest createDigest = createDigest();
        byte[] bArr3 = new byte[createDigest.getDigestSize()];
        createDigest.update(bArr, i11, 32);
        createDigest.doFinal(bArr3, 0);
        byte[] bArr4 = new byte[32];
        pruneScalar(bArr3, 0, bArr4);
        scalarMultBaseEncoded(bArr4, bArr2, i12);
    }

    private static int getWindow4(int[] iArr, int i11) {
        return (iArr[i11 >>> 3] >>> ((i11 & 7) << 2)) & 15;
    }

    private static byte[] getWnafVar(int[] iArr, int i11) {
        int i12;
        int[] iArr2 = new int[16];
        int i13 = 0;
        int i14 = 8;
        int i15 = 16;
        int i16 = 0;
        while (true) {
            i14--;
            if (i14 < 0) {
                break;
            }
            int i17 = iArr[i14];
            int i18 = i15 - 1;
            iArr2[i18] = (i16 << 16) | (i17 >>> 16);
            i15 = i18 - 1;
            iArr2[i15] = i17;
            i16 = i17;
        }
        byte[] bArr = new byte[ITPNativePlayerMessageCallback.INFO_LONG1_DRM_FATAL_ERROR];
        int i19 = 32 - i11;
        int i21 = 0;
        int i22 = 0;
        while (i13 < 16) {
            int i23 = iArr2[i13];
            while (i12 < 16) {
                int i24 = i23 >>> i12;
                if ((i24 & 1) == i22) {
                    i12++;
                } else {
                    int i25 = (i24 | 1) << i19;
                    bArr[(i13 << 4) + i12] = (byte) (i25 >> i19);
                    i12 += i11;
                    i22 = i25 >>> 31;
                }
            }
            i13++;
            i21 = i12 - 16;
        }
        return bArr;
    }

    private static void implSign(Digest digest, byte[] bArr, byte[] bArr2, byte[] bArr3, int i11, byte[] bArr4, byte b11, byte[] bArr5, int i12, int i13, byte[] bArr6, int i14) {
        dom2(digest, b11, bArr4);
        digest.update(bArr, 32, 32);
        digest.update(bArr5, i12, i13);
        digest.doFinal(bArr, 0);
        byte[] reduceScalar = reduceScalar(bArr);
        byte[] bArr7 = new byte[32];
        scalarMultBaseEncoded(reduceScalar, bArr7, 0);
        dom2(digest, b11, bArr4);
        digest.update(bArr7, 0, 32);
        digest.update(bArr3, i11, 32);
        digest.update(bArr5, i12, i13);
        digest.doFinal(bArr, 0);
        byte[] calculateS = calculateS(reduceScalar, reduceScalar(bArr), bArr2);
        System.arraycopy(bArr7, 0, bArr6, i14, 32);
        System.arraycopy(calculateS, 0, bArr6, i14 + 32, 32);
    }

    private static void implSign(byte[] bArr, int i11, byte[] bArr2, byte b11, byte[] bArr3, int i12, int i13, byte[] bArr4, int i14) {
        if (checkContextVar(bArr2, b11)) {
            Digest createDigest = createDigest();
            byte[] bArr5 = new byte[createDigest.getDigestSize()];
            byte[] bArr6 = bArr;
            int i15 = i11;
            createDigest.update(bArr, i11, 32);
            createDigest.doFinal(bArr5, 0);
            byte[] bArr7 = new byte[32];
            pruneScalar(bArr5, 0, bArr7);
            byte[] bArr8 = new byte[32];
            scalarMultBaseEncoded(bArr7, bArr8, 0);
            implSign(createDigest, bArr5, bArr7, bArr8, 0, bArr2, b11, bArr3, i12, i13, bArr4, i14);
            return;
        }
        throw new IllegalArgumentException("ctx");
    }

    private static void implSign(byte[] bArr, int i11, byte[] bArr2, int i12, byte[] bArr3, byte b11, byte[] bArr4, int i13, int i14, byte[] bArr5, int i15) {
        if (checkContextVar(bArr3, b11)) {
            Digest createDigest = createDigest();
            byte[] bArr6 = new byte[createDigest.getDigestSize()];
            byte[] bArr7 = bArr;
            int i16 = i11;
            createDigest.update(bArr, i11, 32);
            createDigest.doFinal(bArr6, 0);
            byte[] bArr8 = new byte[32];
            pruneScalar(bArr6, 0, bArr8);
            implSign(createDigest, bArr6, bArr8, bArr2, i12, bArr3, b11, bArr4, i13, i14, bArr5, i15);
            return;
        }
        throw new IllegalArgumentException("ctx");
    }

    private static boolean implVerify(byte[] bArr, int i11, byte[] bArr2, int i12, byte[] bArr3, byte b11, byte[] bArr4, int i13, int i14) {
        byte[] bArr5 = bArr;
        int i15 = i11;
        byte[] bArr6 = bArr2;
        int i16 = i12;
        if (checkContextVar(bArr3, b11)) {
            byte[] copy = copy(bArr, i11, 32);
            byte[] copy2 = copy(bArr, i15 + 32, 32);
            if (!checkPointVar(copy)) {
                return false;
            }
            int[] iArr = new int[8];
            if (!checkScalarVar(copy2, iArr)) {
                return false;
            }
            PointAffine pointAffine = new PointAffine();
            if (!decodePointVar(bArr6, i16, true, pointAffine)) {
                return false;
            }
            Digest createDigest = createDigest();
            byte[] bArr7 = new byte[createDigest.getDigestSize()];
            dom2(createDigest, b11, bArr3);
            createDigest.update(copy, 0, 32);
            createDigest.update(bArr6, i16, 32);
            createDigest.update(bArr4, i13, i14);
            createDigest.doFinal(bArr7, 0);
            int[] iArr2 = new int[8];
            decodeScalar(reduceScalar(bArr7), 0, iArr2);
            PointAccum pointAccum = new PointAccum();
            scalarMultStrausVar(iArr, iArr2, pointAffine, pointAccum);
            byte[] bArr8 = new byte[32];
            return encodePoint(pointAccum, bArr8, 0) != 0 && Arrays.areEqual(bArr8, copy);
        }
        throw new IllegalArgumentException("ctx");
    }

    private static boolean isNeutralElementVar(int[] iArr, int[] iArr2) {
        return X25519Field.isZeroVar(iArr) && X25519Field.isOneVar(iArr2);
    }

    private static boolean isNeutralElementVar(int[] iArr, int[] iArr2, int[] iArr3) {
        return X25519Field.isZeroVar(iArr) && X25519Field.areEqualVar(iArr2, iArr3);
    }

    private static void pointAdd(PointExt pointExt, PointAccum pointAccum) {
        int[] create = X25519Field.create();
        int[] create2 = X25519Field.create();
        int[] create3 = X25519Field.create();
        int[] create4 = X25519Field.create();
        int[] iArr = pointAccum.f59446u;
        int[] create5 = X25519Field.create();
        int[] create6 = X25519Field.create();
        int[] iArr2 = pointAccum.f59447v;
        X25519Field.apm(pointAccum.f59449y, pointAccum.f59448x, create2, create);
        X25519Field.apm(pointExt.f59455y, pointExt.f59454x, create4, create3);
        X25519Field.mul(create, create3, create);
        X25519Field.mul(create2, create4, create2);
        X25519Field.mul(pointAccum.f59446u, pointAccum.f59447v, create3);
        X25519Field.mul(create3, pointExt.f59453t, create3);
        X25519Field.mul(create3, C_d2, create3);
        X25519Field.mul(pointAccum.f59450z, pointExt.f59456z, create4);
        X25519Field.add(create4, create4, create4);
        X25519Field.apm(create2, create, iArr2, iArr);
        X25519Field.apm(create4, create3, create6, create5);
        X25519Field.carry(create6);
        X25519Field.mul(iArr, create5, pointAccum.f59448x);
        X25519Field.mul(create6, iArr2, pointAccum.f59449y);
        X25519Field.mul(create5, create6, pointAccum.f59450z);
    }

    private static void pointAdd(PointExt pointExt, PointExt pointExt2) {
        int[] create = X25519Field.create();
        int[] create2 = X25519Field.create();
        int[] create3 = X25519Field.create();
        int[] create4 = X25519Field.create();
        int[] create5 = X25519Field.create();
        int[] create6 = X25519Field.create();
        int[] create7 = X25519Field.create();
        int[] create8 = X25519Field.create();
        X25519Field.apm(pointExt.f59455y, pointExt.f59454x, create2, create);
        X25519Field.apm(pointExt2.f59455y, pointExt2.f59454x, create4, create3);
        X25519Field.mul(create, create3, create);
        X25519Field.mul(create2, create4, create2);
        X25519Field.mul(pointExt.f59453t, pointExt2.f59453t, create3);
        X25519Field.mul(create3, C_d2, create3);
        X25519Field.mul(pointExt.f59456z, pointExt2.f59456z, create4);
        X25519Field.add(create4, create4, create4);
        X25519Field.apm(create2, create, create8, create5);
        X25519Field.apm(create4, create3, create7, create6);
        X25519Field.carry(create7);
        X25519Field.mul(create5, create6, pointExt2.f59454x);
        X25519Field.mul(create7, create8, pointExt2.f59455y);
        X25519Field.mul(create6, create7, pointExt2.f59456z);
        X25519Field.mul(create5, create8, pointExt2.f59453t);
    }

    private static void pointAddPrecomp(PointPrecomp pointPrecomp, PointAccum pointAccum) {
        int[] create = X25519Field.create();
        int[] create2 = X25519Field.create();
        int[] create3 = X25519Field.create();
        int[] iArr = pointAccum.f59446u;
        int[] create4 = X25519Field.create();
        int[] create5 = X25519Field.create();
        int[] iArr2 = pointAccum.f59447v;
        X25519Field.apm(pointAccum.f59449y, pointAccum.f59448x, create2, create);
        X25519Field.mul(create, pointPrecomp.ymx_h, create);
        X25519Field.mul(create2, pointPrecomp.ypx_h, create2);
        X25519Field.mul(pointAccum.f59446u, pointAccum.f59447v, create3);
        X25519Field.mul(create3, pointPrecomp.xyd, create3);
        X25519Field.apm(create2, create, iArr2, iArr);
        X25519Field.apm(pointAccum.f59450z, create3, create5, create4);
        X25519Field.carry(create5);
        X25519Field.mul(iArr, create4, pointAccum.f59448x);
        X25519Field.mul(create5, iArr2, pointAccum.f59449y);
        X25519Field.mul(create4, create5, pointAccum.f59450z);
    }

    private static void pointAddVar(boolean z11, PointExt pointExt, PointAccum pointAccum) {
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        int[] iArr4;
        int[] create = X25519Field.create();
        int[] create2 = X25519Field.create();
        int[] create3 = X25519Field.create();
        int[] create4 = X25519Field.create();
        int[] iArr5 = pointAccum.f59446u;
        int[] create5 = X25519Field.create();
        int[] create6 = X25519Field.create();
        int[] iArr6 = pointAccum.f59447v;
        if (z11) {
            iArr = create3;
            iArr4 = create4;
            iArr3 = create5;
            iArr2 = create6;
        } else {
            iArr4 = create3;
            iArr = create4;
            iArr2 = create5;
            iArr3 = create6;
        }
        X25519Field.apm(pointAccum.f59449y, pointAccum.f59448x, create2, create);
        X25519Field.apm(pointExt.f59455y, pointExt.f59454x, iArr, iArr4);
        X25519Field.mul(create, create3, create);
        X25519Field.mul(create2, create4, create2);
        X25519Field.mul(pointAccum.f59446u, pointAccum.f59447v, create3);
        X25519Field.mul(create3, pointExt.f59453t, create3);
        X25519Field.mul(create3, C_d2, create3);
        X25519Field.mul(pointAccum.f59450z, pointExt.f59456z, create4);
        X25519Field.add(create4, create4, create4);
        X25519Field.apm(create2, create, iArr6, iArr5);
        X25519Field.apm(create4, create3, iArr3, iArr2);
        X25519Field.carry(iArr3);
        X25519Field.mul(iArr5, create5, pointAccum.f59448x);
        X25519Field.mul(create6, iArr6, pointAccum.f59449y);
        X25519Field.mul(create5, create6, pointAccum.f59450z);
    }

    private static void pointAddVar(boolean z11, PointExt pointExt, PointExt pointExt2, PointExt pointExt3) {
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        int[] iArr4;
        PointExt pointExt4 = pointExt;
        PointExt pointExt5 = pointExt2;
        PointExt pointExt6 = pointExt3;
        int[] create = X25519Field.create();
        int[] create2 = X25519Field.create();
        int[] create3 = X25519Field.create();
        int[] create4 = X25519Field.create();
        int[] create5 = X25519Field.create();
        int[] create6 = X25519Field.create();
        int[] create7 = X25519Field.create();
        int[] create8 = X25519Field.create();
        if (z11) {
            iArr4 = create3;
            iArr3 = create4;
            iArr2 = create6;
            iArr = create7;
        } else {
            iArr3 = create3;
            iArr4 = create4;
            iArr = create6;
            iArr2 = create7;
        }
        X25519Field.apm(pointExt4.f59455y, pointExt4.f59454x, create2, create);
        X25519Field.apm(pointExt5.f59455y, pointExt5.f59454x, iArr4, iArr3);
        X25519Field.mul(create, create3, create);
        X25519Field.mul(create2, create4, create2);
        X25519Field.mul(pointExt4.f59453t, pointExt5.f59453t, create3);
        X25519Field.mul(create3, C_d2, create3);
        X25519Field.mul(pointExt4.f59456z, pointExt5.f59456z, create4);
        X25519Field.add(create4, create4, create4);
        X25519Field.apm(create2, create, create8, create5);
        X25519Field.apm(create4, create3, iArr2, iArr);
        X25519Field.carry(iArr2);
        X25519Field.mul(create5, create6, pointExt6.f59454x);
        int[] iArr5 = create7;
        X25519Field.mul(iArr5, create8, pointExt6.f59455y);
        X25519Field.mul(create6, iArr5, pointExt6.f59456z);
        X25519Field.mul(create5, create8, pointExt6.f59453t);
    }

    private static PointExt pointCopy(PointAccum pointAccum) {
        PointExt pointExt = new PointExt();
        X25519Field.copy(pointAccum.f59448x, 0, pointExt.f59454x, 0);
        X25519Field.copy(pointAccum.f59449y, 0, pointExt.f59455y, 0);
        X25519Field.copy(pointAccum.f59450z, 0, pointExt.f59456z, 0);
        X25519Field.mul(pointAccum.f59446u, pointAccum.f59447v, pointExt.f59453t);
        return pointExt;
    }

    private static PointExt pointCopy(PointAffine pointAffine) {
        PointExt pointExt = new PointExt();
        X25519Field.copy(pointAffine.f59451x, 0, pointExt.f59454x, 0);
        X25519Field.copy(pointAffine.f59452y, 0, pointExt.f59455y, 0);
        pointExtendXY(pointExt);
        return pointExt;
    }

    private static PointExt pointCopy(PointExt pointExt) {
        PointExt pointExt2 = new PointExt();
        pointCopy(pointExt, pointExt2);
        return pointExt2;
    }

    private static void pointCopy(PointExt pointExt, PointExt pointExt2) {
        X25519Field.copy(pointExt.f59454x, 0, pointExt2.f59454x, 0);
        X25519Field.copy(pointExt.f59455y, 0, pointExt2.f59455y, 0);
        X25519Field.copy(pointExt.f59456z, 0, pointExt2.f59456z, 0);
        X25519Field.copy(pointExt.f59453t, 0, pointExt2.f59453t, 0);
    }

    private static void pointDouble(PointAccum pointAccum) {
        int[] create = X25519Field.create();
        int[] create2 = X25519Field.create();
        int[] create3 = X25519Field.create();
        int[] iArr = pointAccum.f59446u;
        int[] create4 = X25519Field.create();
        int[] create5 = X25519Field.create();
        int[] iArr2 = pointAccum.f59447v;
        X25519Field.sqr(pointAccum.f59448x, create);
        X25519Field.sqr(pointAccum.f59449y, create2);
        X25519Field.sqr(pointAccum.f59450z, create3);
        X25519Field.add(create3, create3, create3);
        X25519Field.apm(create, create2, iArr2, create5);
        X25519Field.add(pointAccum.f59448x, pointAccum.f59449y, iArr);
        X25519Field.sqr(iArr, iArr);
        X25519Field.sub(iArr2, iArr, iArr);
        X25519Field.add(create3, create5, create4);
        X25519Field.carry(create4);
        X25519Field.mul(iArr, create4, pointAccum.f59448x);
        X25519Field.mul(create5, iArr2, pointAccum.f59449y);
        X25519Field.mul(create4, create5, pointAccum.f59450z);
    }

    private static void pointExtendXY(PointAccum pointAccum) {
        X25519Field.one(pointAccum.f59450z);
        X25519Field.copy(pointAccum.f59448x, 0, pointAccum.f59446u, 0);
        X25519Field.copy(pointAccum.f59449y, 0, pointAccum.f59447v, 0);
    }

    private static void pointExtendXY(PointExt pointExt) {
        X25519Field.one(pointExt.f59456z);
        X25519Field.mul(pointExt.f59454x, pointExt.f59455y, pointExt.f59453t);
    }

    private static void pointLookup(int i11, int i12, PointPrecomp pointPrecomp) {
        int i13 = i11 * 8 * 3 * 10;
        for (int i14 = 0; i14 < 8; i14++) {
            int i15 = ((i14 ^ i12) - 1) >> 31;
            X25519Field.cmov(i15, precompBase, i13, pointPrecomp.ypx_h, 0);
            int i16 = i13 + 10;
            X25519Field.cmov(i15, precompBase, i16, pointPrecomp.ymx_h, 0);
            int i17 = i16 + 10;
            X25519Field.cmov(i15, precompBase, i17, pointPrecomp.xyd, 0);
            i13 = i17 + 10;
        }
    }

    private static void pointLookup(int[] iArr, int i11, int[] iArr2, PointExt pointExt) {
        int window4 = getWindow4(iArr, i11);
        int i12 = (window4 >>> 3) ^ 1;
        int i13 = (window4 ^ (-i12)) & 7;
        int i14 = 0;
        for (int i15 = 0; i15 < 8; i15++) {
            int i16 = ((i15 ^ i13) - 1) >> 31;
            X25519Field.cmov(i16, iArr2, i14, pointExt.f59454x, 0);
            int i17 = i14 + 10;
            X25519Field.cmov(i16, iArr2, i17, pointExt.f59455y, 0);
            int i18 = i17 + 10;
            X25519Field.cmov(i16, iArr2, i18, pointExt.f59456z, 0);
            int i19 = i18 + 10;
            X25519Field.cmov(i16, iArr2, i19, pointExt.f59453t, 0);
            i14 = i19 + 10;
        }
        X25519Field.cnegate(i12, pointExt.f59454x);
        X25519Field.cnegate(i12, pointExt.f59453t);
    }

    private static int[] pointPrecompute(PointAffine pointAffine, int i11) {
        PointExt pointCopy = pointCopy(pointAffine);
        PointExt pointCopy2 = pointCopy(pointCopy);
        pointAdd(pointCopy, pointCopy2);
        int[] createTable = X25519Field.createTable(i11 * 4);
        int i12 = 0;
        int i13 = 0;
        while (true) {
            X25519Field.copy(pointCopy.f59454x, 0, createTable, i12);
            int i14 = i12 + 10;
            X25519Field.copy(pointCopy.f59455y, 0, createTable, i14);
            int i15 = i14 + 10;
            X25519Field.copy(pointCopy.f59456z, 0, createTable, i15);
            int i16 = i15 + 10;
            X25519Field.copy(pointCopy.f59453t, 0, createTable, i16);
            i12 = i16 + 10;
            i13++;
            if (i13 == i11) {
                return createTable;
            }
            pointAdd(pointCopy2, pointCopy);
        }
    }

    private static PointExt[] pointPrecomputeVar(PointExt pointExt, int i11) {
        PointExt pointExt2 = new PointExt();
        pointAddVar(false, pointExt, pointExt, pointExt2);
        PointExt[] pointExtArr = new PointExt[i11];
        pointExtArr[0] = pointCopy(pointExt);
        for (int i12 = 1; i12 < i11; i12++) {
            PointExt pointExt3 = pointExtArr[i12 - 1];
            PointExt pointExt4 = new PointExt();
            pointExtArr[i12] = pointExt4;
            pointAddVar(false, pointExt3, pointExt2, pointExt4);
        }
        return pointExtArr;
    }

    private static void pointSetNeutral(PointAccum pointAccum) {
        X25519Field.zero(pointAccum.f59448x);
        X25519Field.one(pointAccum.f59449y);
        X25519Field.one(pointAccum.f59450z);
        X25519Field.zero(pointAccum.f59446u);
        X25519Field.one(pointAccum.f59447v);
    }

    private static void pointSetNeutral(PointExt pointExt) {
        X25519Field.zero(pointExt.f59454x);
        X25519Field.one(pointExt.f59455y);
        X25519Field.one(pointExt.f59456z);
        X25519Field.zero(pointExt.f59453t);
    }

    public static void precompute() {
        int i11;
        synchronized (precompLock) {
            if (precompBase == null) {
                PointExt pointExt = new PointExt();
                int[] iArr = B_x;
                X25519Field.copy(iArr, 0, pointExt.f59454x, 0);
                int[] iArr2 = B_y;
                X25519Field.copy(iArr2, 0, pointExt.f59455y, 0);
                pointExtendXY(pointExt);
                precompBaseTable = pointPrecomputeVar(pointExt, 32);
                PointAccum pointAccum = new PointAccum();
                X25519Field.copy(iArr, 0, pointAccum.f59448x, 0);
                X25519Field.copy(iArr2, 0, pointAccum.f59449y, 0);
                pointExtendXY(pointAccum);
                precompBase = X25519Field.createTable(192);
                int i12 = 0;
                for (int i13 = 0; i13 < 8; i13++) {
                    PointExt[] pointExtArr = new PointExt[4];
                    PointExt pointExt2 = new PointExt();
                    pointSetNeutral(pointExt2);
                    int i14 = 0;
                    while (true) {
                        i11 = 1;
                        if (i14 >= 4) {
                            break;
                        }
                        pointAddVar(true, pointExt2, pointCopy(pointAccum), pointExt2);
                        pointDouble(pointAccum);
                        pointExtArr[i14] = pointCopy(pointAccum);
                        if (i13 + i14 != 10) {
                            while (i11 < 8) {
                                pointDouble(pointAccum);
                                i11++;
                            }
                        }
                        i14++;
                    }
                    PointExt[] pointExtArr2 = new PointExt[8];
                    pointExtArr2[0] = pointExt2;
                    int i15 = 0;
                    int i16 = 1;
                    while (i15 < 3) {
                        int i17 = i11 << i15;
                        int i18 = 0;
                        while (i18 < i17) {
                            PointExt pointExt3 = pointExtArr2[i16 - i17];
                            PointExt pointExt4 = pointExtArr[i15];
                            PointExt pointExt5 = new PointExt();
                            pointExtArr2[i16] = pointExt5;
                            pointAddVar(false, pointExt3, pointExt4, pointExt5);
                            i18++;
                            i16++;
                        }
                        i15++;
                        i11 = 1;
                    }
                    int[] createTable = X25519Field.createTable(8);
                    int[] create = X25519Field.create();
                    X25519Field.copy(pointExtArr2[0].f59456z, 0, create, 0);
                    X25519Field.copy(create, 0, createTable, 0);
                    int i19 = 0;
                    while (true) {
                        i19++;
                        if (i19 >= 8) {
                            break;
                        }
                        X25519Field.mul(create, pointExtArr2[i19].f59456z, create);
                        X25519Field.copy(create, 0, createTable, i19 * 10);
                    }
                    X25519Field.add(create, create, create);
                    X25519Field.invVar(create, create);
                    int i21 = i19 - 1;
                    int[] create2 = X25519Field.create();
                    while (i21 > 0) {
                        int i22 = i21 - 1;
                        X25519Field.copy(createTable, i22 * 10, create2, 0);
                        X25519Field.mul(create2, create, create2);
                        X25519Field.copy(create2, 0, createTable, i21 * 10);
                        X25519Field.mul(create, pointExtArr2[i21].f59456z, create);
                        i21 = i22;
                    }
                    X25519Field.copy(create, 0, createTable, 0);
                    for (int i23 = 0; i23 < 8; i23++) {
                        PointExt pointExt6 = pointExtArr2[i23];
                        int[] create3 = X25519Field.create();
                        int[] create4 = X25519Field.create();
                        X25519Field.copy(createTable, i23 * 10, create4, 0);
                        X25519Field.mul(pointExt6.f59454x, create4, create3);
                        X25519Field.mul(pointExt6.f59455y, create4, create4);
                        PointPrecomp pointPrecomp = new PointPrecomp();
                        X25519Field.apm(create4, create3, pointPrecomp.ypx_h, pointPrecomp.ymx_h);
                        X25519Field.mul(create3, create4, pointPrecomp.xyd);
                        int[] iArr3 = pointPrecomp.xyd;
                        X25519Field.mul(iArr3, C_d4, iArr3);
                        X25519Field.normalize(pointPrecomp.ypx_h);
                        X25519Field.normalize(pointPrecomp.ymx_h);
                        X25519Field.copy(pointPrecomp.ypx_h, 0, precompBase, i12);
                        int i24 = i12 + 10;
                        X25519Field.copy(pointPrecomp.ymx_h, 0, precompBase, i24);
                        int i25 = i24 + 10;
                        X25519Field.copy(pointPrecomp.xyd, 0, precompBase, i25);
                        i12 = i25 + 10;
                    }
                }
            }
        }
    }

    private static void pruneScalar(byte[] bArr, int i11, byte[] bArr2) {
        System.arraycopy(bArr, i11, bArr2, 0, 32);
        bArr2[0] = (byte) (bArr2[0] & 248);
        bArr2[31] = (byte) (bArr2[31] & Ascii.DEL);
        bArr2[31] = (byte) (bArr2[31] | SignedBytes.MAX_POWER_OF_TWO);
    }

    private static byte[] reduceScalar(byte[] bArr) {
        byte[] bArr2 = bArr;
        long decode24 = ((long) (decode24(bArr2, 4) << 4)) & 4294967295L;
        long decode32 = ((long) decode32(bArr2, 7)) & 4294967295L;
        long decode242 = ((long) (decode24(bArr2, 11) << 4)) & 4294967295L;
        long decode322 = ((long) decode32(bArr2, 14)) & 4294967295L;
        long decode243 = ((long) (decode24(bArr2, 18) << 4)) & 4294967295L;
        long decode323 = ((long) decode32(bArr2, 21)) & 4294967295L;
        long decode244 = ((long) (decode24(bArr2, 25) << 4)) & 4294967295L;
        long decode324 = ((long) decode32(bArr2, 28)) & 4294967295L;
        long decode325 = ((long) decode32(bArr2, 49)) & 4294967295L;
        long decode245 = ((long) (decode24(bArr2, 53) << 4)) & 4294967295L;
        long decode326 = ((long) decode32(bArr2, 56)) & 4294967295L;
        long decode246 = ((long) (decode24(bArr2, 60) << 4)) & 4294967295L;
        long j11 = ((long) bArr2[63]) & 255;
        long decode247 = (((long) (decode24(bArr2, 46) << 4)) & 4294967295L) - (j11 * 5343);
        long j12 = decode246 + (decode326 >> 28);
        long j13 = decode326 & M28L;
        long j14 = decode324 - (j12 * -50998291);
        long decode248 = ((((long) (decode24(bArr2, 32) << 4)) & 4294967295L) - (j11 * -50998291)) - (j12 * 19280294);
        long decode327 = ((((long) decode32(bArr2, 35)) & 4294967295L) - (j11 * 19280294)) - (j12 * 127719000);
        long decode328 = ((((long) decode32(bArr2, 42)) & 4294967295L) - (j11 * -6428113)) - (j12 * 5343);
        long j15 = decode244 - (j13 * -50998291);
        long decode249 = (((((long) (decode24(bArr2, 39) << 4)) & 4294967295L) - (j11 * 127719000)) - (j12 * -6428113)) - (j13 * 5343);
        long j16 = decode245 + (decode325 >> 28);
        long j17 = decode325 & M28L;
        long j18 = (decode327 - (j13 * -6428113)) - (j16 * 5343);
        long j19 = ((decode248 - (j13 * 127719000)) - (j16 * -6428113)) - (j17 * 5343);
        long j21 = decode247 + (decode328 >> 28);
        long j22 = (decode328 & M28L) + (decode249 >> 28);
        long j23 = decode242 - (j22 * -50998291);
        long j24 = (decode322 - (j21 * -50998291)) - (j22 * 19280294);
        long j25 = ((decode243 - (j17 * -50998291)) - (j21 * 19280294)) - (j22 * 127719000);
        long j26 = (((j15 - (j16 * 19280294)) - (j17 * 127719000)) - (j21 * -6428113)) - (j22 * 5343);
        long j27 = (decode249 & M28L) + (j18 >> 28);
        long j28 = j18 & M28L;
        long j29 = decode32 - (j27 * -50998291);
        long j30 = j23 - (j27 * 19280294);
        long j31 = j24 - (j27 * 127719000);
        long j32 = ((((decode323 - (j16 * -50998291)) - (j17 * 19280294)) - (j21 * 127719000)) - (j22 * -6428113)) - (j27 * 5343);
        long j33 = j28 + (j19 >> 28);
        long j34 = j19 & M28L;
        long j35 = j29 - (j33 * 19280294);
        long j36 = j30 - (j33 * 127719000);
        long j37 = j31 - (j33 * -6428113);
        long j38 = (j25 - (j27 * -6428113)) - (j33 * 5343);
        long j39 = ((((j14 - (j13 * 19280294)) - (j16 * 127719000)) - (j17 * -6428113)) - (j21 * 5343)) + (j26 >> 28);
        long j40 = j26 & M28L;
        long j41 = j39 & M28L;
        long j42 = j41 >>> 27;
        long j43 = j34 + (j39 >> 28) + j42;
        long decode329 = (((long) decode32(bArr2, 0)) & 4294967295L) - (j43 * -50998291);
        long j44 = ((decode24 - (j33 * -50998291)) - (j43 * 19280294)) + (decode329 >> 28);
        long j45 = decode329 & M28L;
        long j46 = (j35 - (j43 * 127719000)) + (j44 >> 28);
        long j47 = j44 & M28L;
        long j48 = (j36 - (j43 * -6428113)) + (j46 >> 28);
        long j49 = j46 & M28L;
        long j50 = (j37 - (j43 * 5343)) + (j48 >> 28);
        long j51 = j48 & M28L;
        long j52 = j38 + (j50 >> 28);
        long j53 = j50 & M28L;
        long j54 = j32 + (j52 >> 28);
        long j55 = j52 & M28L;
        long j56 = j40 + (j54 >> 28);
        long j57 = j54 & M28L;
        long j58 = j41 + (j56 >> 28);
        long j59 = j56 & M28L;
        long j60 = j58 >> 28;
        long j61 = j58 & M28L;
        long j62 = j60 - j42;
        long j63 = j45 + (j62 & -50998291);
        long j64 = j47 + (j62 & 19280294) + (j63 >> 28);
        long j65 = j63 & M28L;
        long j66 = j49 + (j62 & 127719000) + (j64 >> 28);
        long j67 = j64 & M28L;
        long j68 = j51 + (j62 & -6428113) + (j66 >> 28);
        long j69 = j66 & M28L;
        long j70 = j53 + (j62 & 5343) + (j68 >> 28);
        long j71 = j68 & M28L;
        long j72 = j55 + (j70 >> 28);
        long j73 = j70 & M28L;
        long j74 = j57 + (j72 >> 28);
        long j75 = j72 & M28L;
        long j76 = j59 + (j74 >> 28);
        long j77 = j74 & M28L;
        long j78 = j76 & M28L;
        byte[] bArr3 = new byte[32];
        encode56(j65 | (j67 << 28), bArr3, 0);
        encode56((j71 << 28) | j69, bArr3, 7);
        encode56(j73 | (j75 << 28), bArr3, 14);
        encode56(j77 | (j78 << 28), bArr3, 21);
        encode32((int) (j61 + (j76 >> 28)), bArr3, 28);
        return bArr3;
    }

    private static void scalarMult(byte[] bArr, PointAffine pointAffine, PointAccum pointAccum) {
        int[] iArr = new int[8];
        decodeScalar(bArr, 0, iArr);
        Nat.cadd(8, (~iArr[0]) & 1, iArr, L, iArr);
        Nat.shiftDownBit(8, iArr, 1);
        int[] pointPrecompute = pointPrecompute(pointAffine, 8);
        PointExt pointExt = new PointExt();
        pointSetNeutral(pointAccum);
        int i11 = 63;
        while (true) {
            pointLookup(iArr, i11, pointPrecompute, pointExt);
            pointAdd(pointExt, pointAccum);
            i11--;
            if (i11 >= 0) {
                for (int i12 = 0; i12 < 4; i12++) {
                    pointDouble(pointAccum);
                }
            } else {
                return;
            }
        }
    }

    private static void scalarMultBase(byte[] bArr, PointAccum pointAccum) {
        precompute();
        int[] iArr = new int[8];
        decodeScalar(bArr, 0, iArr);
        Nat.cadd(8, (~iArr[0]) & 1, iArr, L, iArr);
        Nat.shiftDownBit(8, iArr, 1);
        for (int i11 = 0; i11 < 8; i11++) {
            iArr[i11] = Interleave.shuffle2(iArr[i11]);
        }
        PointPrecomp pointPrecomp = new PointPrecomp();
        pointSetNeutral(pointAccum);
        int i12 = 28;
        while (true) {
            for (int i13 = 0; i13 < 8; i13++) {
                int i14 = iArr[i13] >>> i12;
                int i15 = (i14 >>> 3) & 1;
                pointLookup(i13, (i14 ^ (-i15)) & 7, pointPrecomp);
                X25519Field.cswap(i15, pointPrecomp.ypx_h, pointPrecomp.ymx_h);
                X25519Field.cnegate(i15, pointPrecomp.xyd);
                pointAddPrecomp(pointPrecomp, pointAccum);
            }
            i12 -= 4;
            if (i12 >= 0) {
                pointDouble(pointAccum);
            } else {
                return;
            }
        }
    }

    private static void scalarMultBaseEncoded(byte[] bArr, byte[] bArr2, int i11) {
        PointAccum pointAccum = new PointAccum();
        scalarMultBase(bArr, pointAccum);
        if (encodePoint(pointAccum, bArr2, i11) == 0) {
            throw new IllegalStateException();
        }
    }

    public static void scalarMultBaseYZ(X25519.Friend friend, byte[] bArr, int i11, int[] iArr, int[] iArr2) {
        Objects.requireNonNull(friend, "This method is only for use by X25519");
        byte[] bArr2 = new byte[32];
        pruneScalar(bArr, i11, bArr2);
        PointAccum pointAccum = new PointAccum();
        scalarMultBase(bArr2, pointAccum);
        if (checkPoint(pointAccum.f59448x, pointAccum.f59449y, pointAccum.f59450z) != 0) {
            X25519Field.copy(pointAccum.f59449y, 0, iArr, 0);
            X25519Field.copy(pointAccum.f59450z, 0, iArr2, 0);
            return;
        }
        throw new IllegalStateException();
    }

    private static void scalarMultOrderVar(PointAffine pointAffine, PointAccum pointAccum) {
        byte[] wnafVar = getWnafVar(L, 5);
        PointExt[] pointPrecomputeVar = pointPrecomputeVar(pointCopy(pointAffine), 8);
        pointSetNeutral(pointAccum);
        int i11 = 252;
        while (true) {
            byte b11 = wnafVar[i11];
            if (b11 != 0) {
                int i12 = b11 >> Ascii.US;
                boolean z11 = true;
                int i13 = (b11 ^ i12) >>> 1;
                if (i12 == 0) {
                    z11 = false;
                }
                pointAddVar(z11, pointPrecomputeVar[i13], pointAccum);
            }
            i11--;
            if (i11 >= 0) {
                pointDouble(pointAccum);
            } else {
                return;
            }
        }
    }

    private static void scalarMultStrausVar(int[] iArr, int[] iArr2, PointAffine pointAffine, PointAccum pointAccum) {
        precompute();
        byte[] wnafVar = getWnafVar(iArr, 7);
        byte[] wnafVar2 = getWnafVar(iArr2, 5);
        PointExt[] pointPrecomputeVar = pointPrecomputeVar(pointCopy(pointAffine), 8);
        pointSetNeutral(pointAccum);
        int i11 = 252;
        while (true) {
            byte b11 = wnafVar[i11];
            boolean z11 = false;
            if (b11 != 0) {
                int i12 = b11 >> Ascii.US;
                pointAddVar(i12 != 0, precompBaseTable[(b11 ^ i12) >>> 1], pointAccum);
            }
            byte b12 = wnafVar2[i11];
            if (b12 != 0) {
                int i13 = b12 >> Ascii.US;
                int i14 = (b12 ^ i13) >>> 1;
                if (i13 != 0) {
                    z11 = true;
                }
                pointAddVar(z11, pointPrecomputeVar[i14], pointAccum);
            }
            i11--;
            if (i11 >= 0) {
                pointDouble(pointAccum);
            } else {
                return;
            }
        }
    }

    public static void sign(byte[] bArr, int i11, byte[] bArr2, int i12, int i13, byte[] bArr3, int i14) {
        implSign(bArr, i11, (byte[]) null, (byte) 0, bArr2, i12, i13, bArr3, i14);
    }

    public static void sign(byte[] bArr, int i11, byte[] bArr2, int i12, byte[] bArr3, int i13, int i14, byte[] bArr4, int i15) {
        implSign(bArr, i11, bArr2, i12, (byte[]) null, (byte) 0, bArr3, i13, i14, bArr4, i15);
    }

    public static void sign(byte[] bArr, int i11, byte[] bArr2, int i12, byte[] bArr3, byte[] bArr4, int i13, int i14, byte[] bArr5, int i15) {
        implSign(bArr, i11, bArr2, i12, bArr3, (byte) 0, bArr4, i13, i14, bArr5, i15);
    }

    public static void sign(byte[] bArr, int i11, byte[] bArr2, byte[] bArr3, int i12, int i13, byte[] bArr4, int i14) {
        implSign(bArr, i11, bArr2, (byte) 0, bArr3, i12, i13, bArr4, i14);
    }

    public static void signPrehash(byte[] bArr, int i11, byte[] bArr2, int i12, byte[] bArr3, Digest digest, byte[] bArr4, int i13) {
        byte[] bArr5 = new byte[64];
        if (64 == digest.doFinal(bArr5, 0)) {
            implSign(bArr, i11, bArr2, i12, bArr3, (byte) 1, bArr5, 0, 64, bArr4, i13);
            return;
        }
        throw new IllegalArgumentException(UserDataStore.PHONE);
    }

    public static void signPrehash(byte[] bArr, int i11, byte[] bArr2, int i12, byte[] bArr3, byte[] bArr4, int i13, byte[] bArr5, int i14) {
        implSign(bArr, i11, bArr2, i12, bArr3, (byte) 1, bArr4, i13, 64, bArr5, i14);
    }

    public static void signPrehash(byte[] bArr, int i11, byte[] bArr2, Digest digest, byte[] bArr3, int i12) {
        byte[] bArr4 = new byte[64];
        if (64 == digest.doFinal(bArr4, 0)) {
            implSign(bArr, i11, bArr2, (byte) 1, bArr4, 0, 64, bArr3, i12);
            return;
        }
        throw new IllegalArgumentException(UserDataStore.PHONE);
    }

    public static void signPrehash(byte[] bArr, int i11, byte[] bArr2, byte[] bArr3, int i12, byte[] bArr4, int i13) {
        implSign(bArr, i11, bArr2, (byte) 1, bArr3, i12, 64, bArr4, i13);
    }

    public static boolean validatePublicKeyFull(byte[] bArr, int i11) {
        PointAffine pointAffine = new PointAffine();
        if (!decodePointVar(bArr, i11, false, pointAffine)) {
            return false;
        }
        X25519Field.normalize(pointAffine.f59451x);
        X25519Field.normalize(pointAffine.f59452y);
        if (isNeutralElementVar(pointAffine.f59451x, pointAffine.f59452y)) {
            return false;
        }
        PointAccum pointAccum = new PointAccum();
        scalarMultOrderVar(pointAffine, pointAccum);
        X25519Field.normalize(pointAccum.f59448x);
        X25519Field.normalize(pointAccum.f59449y);
        X25519Field.normalize(pointAccum.f59450z);
        return isNeutralElementVar(pointAccum.f59448x, pointAccum.f59449y, pointAccum.f59450z);
    }

    public static boolean validatePublicKeyPartial(byte[] bArr, int i11) {
        return decodePointVar(bArr, i11, false, new PointAffine());
    }

    public static boolean verify(byte[] bArr, int i11, byte[] bArr2, int i12, byte[] bArr3, int i13, int i14) {
        return implVerify(bArr, i11, bArr2, i12, (byte[]) null, (byte) 0, bArr3, i13, i14);
    }

    public static boolean verify(byte[] bArr, int i11, byte[] bArr2, int i12, byte[] bArr3, byte[] bArr4, int i13, int i14) {
        return implVerify(bArr, i11, bArr2, i12, bArr3, (byte) 0, bArr4, i13, i14);
    }

    public static boolean verifyPrehash(byte[] bArr, int i11, byte[] bArr2, int i12, byte[] bArr3, Digest digest) {
        byte[] bArr4 = new byte[64];
        if (64 == digest.doFinal(bArr4, 0)) {
            return implVerify(bArr, i11, bArr2, i12, bArr3, (byte) 1, bArr4, 0, 64);
        }
        throw new IllegalArgumentException(UserDataStore.PHONE);
    }

    public static boolean verifyPrehash(byte[] bArr, int i11, byte[] bArr2, int i12, byte[] bArr3, byte[] bArr4, int i13) {
        return implVerify(bArr, i11, bArr2, i12, bArr3, (byte) 1, bArr4, i13, 64);
    }
}
