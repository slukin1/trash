package org.bouncycastle.math.ec.rfc8032;

import com.facebook.appevents.UserDataStore;
import com.google.common.base.Ascii;
import java.security.SecureRandom;
import java.util.Objects;
import net.sf.scuba.smartcards.ISO7816;
import org.bouncycastle.crypto.Xof;
import org.bouncycastle.crypto.digests.SHAKEDigest;
import org.bouncycastle.math.ec.rfc7748.X448;
import org.bouncycastle.math.ec.rfc7748.X448Field;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.util.Arrays;

public abstract class Ed448 {
    private static final int[] B_x = {118276190, 40534716, 9670182, 135141552, 85017403, 259173222, 68333082, 171784774, 174973732, 15824510, 73756743, 57518561, 94773951, 248652241, 107736333, 82941708};
    private static final int[] B_y = {36764180, 8885695, 130592152, 20104429, 163904957, 30304195, 121295871, 5901357, 125344798, 171541512, 175338348, 209069246, 3626697, 38307682, 24032956, 110359655};
    private static final int COORD_INTS = 14;
    private static final int C_d = -39081;
    private static final byte[] DOM4_PREFIX = {83, 105, 103, 69, 100, ISO7816.INS_DECREASE_STAMPED, ISO7816.INS_DECREASE_STAMPED, 56};
    private static final int[] L = {-1420278541, 595116690, -1916432555, 560775794, -1361693040, -1001465015, 2093622249, -1, -1, -1, -1, -1, -1, 1073741823};
    private static final int L4_0 = 43969588;
    private static final int L4_1 = 30366549;
    private static final int L4_2 = 163752818;
    private static final int L4_3 = 258169998;
    private static final int L4_4 = 96434764;
    private static final int L4_5 = 227822194;
    private static final int L4_6 = 149865618;
    private static final int L4_7 = 550336261;
    private static final int L_0 = 78101261;
    private static final int L_1 = 141809365;
    private static final int L_2 = 175155932;
    private static final int L_3 = 64542499;
    private static final int L_4 = 158326419;
    private static final int L_5 = 191173276;
    private static final int L_6 = 104575268;
    private static final int L_7 = 137584065;
    private static final long M26L = 67108863;
    private static final long M28L = 268435455;
    private static final long M32L = 4294967295L;
    private static final int[] P = {-1, -1, -1, -1, -1, -1, -1, -2, -1, -1, -1, -1, -1, -1};
    private static final int POINT_BYTES = 57;
    private static final int PRECOMP_BLOCKS = 5;
    private static final int PRECOMP_MASK = 15;
    private static final int PRECOMP_POINTS = 16;
    private static final int PRECOMP_RANGE = 450;
    private static final int PRECOMP_SPACING = 18;
    private static final int PRECOMP_TEETH = 5;
    public static final int PREHASH_SIZE = 64;
    public static final int PUBLIC_KEY_SIZE = 57;
    private static final int SCALAR_BYTES = 57;
    private static final int SCALAR_INTS = 14;
    public static final int SECRET_KEY_SIZE = 57;
    public static final int SIGNATURE_SIZE = 114;
    private static final int WNAF_WIDTH_BASE = 7;
    private static int[] precompBase = null;
    private static PointExt[] precompBaseTable = null;
    private static final Object precompLock = new Object();

    public static final class Algorithm {
        public static final int Ed448 = 0;
        public static final int Ed448ph = 1;
    }

    public static class F extends X448Field {
        private F() {
        }
    }

    public static class PointExt {

        /* renamed from: x  reason: collision with root package name */
        public int[] f59457x;

        /* renamed from: y  reason: collision with root package name */
        public int[] f59458y;

        /* renamed from: z  reason: collision with root package name */
        public int[] f59459z;

        private PointExt() {
            this.f59457x = X448Field.create();
            this.f59458y = X448Field.create();
            this.f59459z = X448Field.create();
        }
    }

    public static class PointPrecomp {

        /* renamed from: x  reason: collision with root package name */
        public int[] f59460x;

        /* renamed from: y  reason: collision with root package name */
        public int[] f59461y;

        private PointPrecomp() {
            this.f59460x = X448Field.create();
            this.f59461y = X448Field.create();
        }
    }

    private static byte[] calculateS(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        int[] iArr = new int[28];
        decodeScalar(bArr, 0, iArr);
        int[] iArr2 = new int[14];
        decodeScalar(bArr2, 0, iArr2);
        int[] iArr3 = new int[14];
        decodeScalar(bArr3, 0, iArr3);
        Nat.mulAddTo(14, iArr2, iArr3, iArr);
        byte[] bArr4 = new byte[114];
        for (int i11 = 0; i11 < 28; i11++) {
            encode32(iArr[i11], bArr4, i11 * 4);
        }
        return reduceScalar(bArr4);
    }

    private static boolean checkContextVar(byte[] bArr) {
        return bArr != null && bArr.length < 256;
    }

    private static int checkPoint(int[] iArr, int[] iArr2) {
        int[] create = X448Field.create();
        int[] create2 = X448Field.create();
        int[] create3 = X448Field.create();
        X448Field.sqr(iArr, create2);
        X448Field.sqr(iArr2, create3);
        X448Field.mul(create2, create3, create);
        X448Field.add(create2, create3, create2);
        X448Field.mul(create, 39081, create);
        X448Field.subOne(create);
        X448Field.add(create, create2, create);
        X448Field.normalize(create);
        return X448Field.isZero(create);
    }

    private static int checkPoint(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] create = X448Field.create();
        int[] create2 = X448Field.create();
        int[] create3 = X448Field.create();
        int[] create4 = X448Field.create();
        X448Field.sqr(iArr, create2);
        X448Field.sqr(iArr2, create3);
        X448Field.sqr(iArr3, create4);
        X448Field.mul(create2, create3, create);
        X448Field.add(create2, create3, create2);
        X448Field.mul(create2, create4, create2);
        X448Field.sqr(create4, create4);
        X448Field.mul(create, 39081, create);
        X448Field.sub(create, create4, create);
        X448Field.add(create, create2, create);
        X448Field.normalize(create);
        return X448Field.isZero(create);
    }

    private static boolean checkPointVar(byte[] bArr) {
        if ((bArr[56] & Ascii.DEL) != 0) {
            return false;
        }
        int[] iArr = new int[14];
        decode32(bArr, 0, iArr, 0, 14);
        return !Nat.gte(14, iArr, P);
    }

    private static boolean checkScalarVar(byte[] bArr, int[] iArr) {
        if (bArr[56] != 0) {
            return false;
        }
        decodeScalar(bArr, 0, iArr);
        return !Nat.gte(14, iArr, L);
    }

    private static byte[] copy(byte[] bArr, int i11, int i12) {
        byte[] bArr2 = new byte[i12];
        System.arraycopy(bArr, i11, bArr2, 0, i12);
        return bArr2;
    }

    public static Xof createPrehash() {
        return createXof();
    }

    private static Xof createXof() {
        return new SHAKEDigest(256);
    }

    private static int decode16(byte[] bArr, int i11) {
        return ((bArr[i11 + 1] & 255) << 8) | (bArr[i11] & 255);
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

    private static boolean decodePointVar(byte[] bArr, int i11, boolean z11, PointExt pointExt) {
        byte[] copy = copy(bArr, i11, 57);
        boolean z12 = false;
        if (!checkPointVar(copy)) {
            return false;
        }
        int i12 = (copy[56] & 128) >>> 7;
        copy[56] = (byte) (copy[56] & Ascii.DEL);
        X448Field.decode(copy, 0, pointExt.f59458y);
        int[] create = X448Field.create();
        int[] create2 = X448Field.create();
        X448Field.sqr(pointExt.f59458y, create);
        X448Field.mul(create, 39081, create2);
        X448Field.negate(create, create);
        X448Field.addOne(create);
        X448Field.addOne(create2);
        if (!X448Field.sqrtRatioVar(create, create2, pointExt.f59457x)) {
            return false;
        }
        X448Field.normalize(pointExt.f59457x);
        if (i12 == 1 && X448Field.isZeroVar(pointExt.f59457x)) {
            return false;
        }
        int[] iArr = pointExt.f59457x;
        if (i12 != (iArr[0] & 1)) {
            z12 = true;
        }
        if (z11 ^ z12) {
            X448Field.negate(iArr, iArr);
        }
        pointExtendXY(pointExt);
        return true;
    }

    private static void decodeScalar(byte[] bArr, int i11, int[] iArr) {
        decode32(bArr, i11, iArr, 0, 14);
    }

    private static void dom4(Xof xof, byte b11, byte[] bArr) {
        byte[] bArr2 = DOM4_PREFIX;
        int length = bArr2.length;
        int i11 = length + 2;
        int length2 = bArr.length + i11;
        byte[] bArr3 = new byte[length2];
        System.arraycopy(bArr2, 0, bArr3, 0, length);
        bArr3[length] = b11;
        bArr3[length + 1] = (byte) bArr.length;
        System.arraycopy(bArr, 0, bArr3, i11, bArr.length);
        xof.update(bArr3, 0, length2);
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

    private static int encodePoint(PointExt pointExt, byte[] bArr, int i11) {
        int[] create = X448Field.create();
        int[] create2 = X448Field.create();
        X448Field.inv(pointExt.f59459z, create2);
        X448Field.mul(pointExt.f59457x, create2, create);
        X448Field.mul(pointExt.f59458y, create2, create2);
        X448Field.normalize(create);
        X448Field.normalize(create2);
        int checkPoint = checkPoint(create, create2);
        X448Field.encode(create2, bArr, i11);
        bArr[(i11 + 57) - 1] = (byte) ((create[0] & 1) << 7);
        return checkPoint;
    }

    public static void generatePrivateKey(SecureRandom secureRandom, byte[] bArr) {
        secureRandom.nextBytes(bArr);
    }

    public static void generatePublicKey(byte[] bArr, int i11, byte[] bArr2, int i12) {
        Xof createXof = createXof();
        byte[] bArr3 = new byte[114];
        createXof.update(bArr, i11, 57);
        createXof.doFinal(bArr3, 0, 114);
        byte[] bArr4 = new byte[57];
        pruneScalar(bArr3, 0, bArr4);
        scalarMultBaseEncoded(bArr4, bArr2, i12);
    }

    private static int getWindow4(int[] iArr, int i11) {
        return (iArr[i11 >>> 3] >>> ((i11 & 7) << 2)) & 15;
    }

    private static byte[] getWnafVar(int[] iArr, int i11) {
        int i12;
        int[] iArr2 = new int[28];
        int i13 = 0;
        int i14 = 14;
        int i15 = 28;
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
        byte[] bArr = new byte[447];
        int i19 = 32 - i11;
        int i21 = 0;
        int i22 = 0;
        while (i13 < 28) {
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

    private static void implSign(Xof xof, byte[] bArr, byte[] bArr2, byte[] bArr3, int i11, byte[] bArr4, byte b11, byte[] bArr5, int i12, int i13, byte[] bArr6, int i14) {
        dom4(xof, b11, bArr4);
        xof.update(bArr, 57, 57);
        xof.update(bArr5, i12, i13);
        xof.doFinal(bArr, 0, bArr.length);
        byte[] reduceScalar = reduceScalar(bArr);
        byte[] bArr7 = new byte[57];
        scalarMultBaseEncoded(reduceScalar, bArr7, 0);
        dom4(xof, b11, bArr4);
        xof.update(bArr7, 0, 57);
        xof.update(bArr3, i11, 57);
        xof.update(bArr5, i12, i13);
        xof.doFinal(bArr, 0, bArr.length);
        byte[] calculateS = calculateS(reduceScalar, reduceScalar(bArr), bArr2);
        System.arraycopy(bArr7, 0, bArr6, i14, 57);
        System.arraycopy(calculateS, 0, bArr6, i14 + 57, 57);
    }

    private static void implSign(byte[] bArr, int i11, byte[] bArr2, byte b11, byte[] bArr3, int i12, int i13, byte[] bArr4, int i14) {
        if (checkContextVar(bArr2)) {
            Xof createXof = createXof();
            byte[] bArr5 = new byte[114];
            byte[] bArr6 = bArr;
            int i15 = i11;
            createXof.update(bArr, i11, 57);
            createXof.doFinal(bArr5, 0, 114);
            byte[] bArr7 = new byte[57];
            pruneScalar(bArr5, 0, bArr7);
            byte[] bArr8 = new byte[57];
            scalarMultBaseEncoded(bArr7, bArr8, 0);
            implSign(createXof, bArr5, bArr7, bArr8, 0, bArr2, b11, bArr3, i12, i13, bArr4, i14);
            return;
        }
        throw new IllegalArgumentException("ctx");
    }

    private static void implSign(byte[] bArr, int i11, byte[] bArr2, int i12, byte[] bArr3, byte b11, byte[] bArr4, int i13, int i14, byte[] bArr5, int i15) {
        if (checkContextVar(bArr3)) {
            Xof createXof = createXof();
            byte[] bArr6 = new byte[114];
            byte[] bArr7 = bArr;
            int i16 = i11;
            createXof.update(bArr, i11, 57);
            createXof.doFinal(bArr6, 0, 114);
            byte[] bArr8 = new byte[57];
            pruneScalar(bArr6, 0, bArr8);
            implSign(createXof, bArr6, bArr8, bArr2, i12, bArr3, b11, bArr4, i13, i14, bArr5, i15);
            return;
        }
        throw new IllegalArgumentException("ctx");
    }

    private static boolean implVerify(byte[] bArr, int i11, byte[] bArr2, int i12, byte[] bArr3, byte b11, byte[] bArr4, int i13, int i14) {
        byte[] bArr5 = bArr;
        int i15 = i11;
        byte[] bArr6 = bArr2;
        int i16 = i12;
        if (checkContextVar(bArr3)) {
            byte[] copy = copy(bArr, i15, 57);
            byte[] copy2 = copy(bArr, i15 + 57, 57);
            if (!checkPointVar(copy)) {
                return false;
            }
            int[] iArr = new int[14];
            if (!checkScalarVar(copy2, iArr)) {
                return false;
            }
            PointExt pointExt = new PointExt();
            if (!decodePointVar(bArr6, i16, true, pointExt)) {
                return false;
            }
            Xof createXof = createXof();
            byte[] bArr7 = new byte[114];
            dom4(createXof, b11, bArr3);
            createXof.update(copy, 0, 57);
            createXof.update(bArr6, i16, 57);
            createXof.update(bArr4, i13, i14);
            createXof.doFinal(bArr7, 0, 114);
            int[] iArr2 = new int[14];
            decodeScalar(reduceScalar(bArr7), 0, iArr2);
            PointExt pointExt2 = new PointExt();
            scalarMultStrausVar(iArr, iArr2, pointExt, pointExt2);
            byte[] bArr8 = new byte[57];
            return encodePoint(pointExt2, bArr8, 0) != 0 && Arrays.areEqual(bArr8, copy);
        }
        throw new IllegalArgumentException("ctx");
    }

    private static boolean isNeutralElementVar(int[] iArr, int[] iArr2, int[] iArr3) {
        return X448Field.isZeroVar(iArr) && X448Field.areEqualVar(iArr2, iArr3);
    }

    private static void pointAdd(PointExt pointExt, PointExt pointExt2) {
        int[] create = X448Field.create();
        int[] create2 = X448Field.create();
        int[] create3 = X448Field.create();
        int[] create4 = X448Field.create();
        int[] create5 = X448Field.create();
        int[] create6 = X448Field.create();
        int[] create7 = X448Field.create();
        int[] create8 = X448Field.create();
        X448Field.mul(pointExt.f59459z, pointExt2.f59459z, create);
        X448Field.sqr(create, create2);
        X448Field.mul(pointExt.f59457x, pointExt2.f59457x, create3);
        X448Field.mul(pointExt.f59458y, pointExt2.f59458y, create4);
        X448Field.mul(create3, create4, create5);
        X448Field.mul(create5, 39081, create5);
        X448Field.add(create2, create5, create6);
        X448Field.sub(create2, create5, create7);
        X448Field.add(pointExt.f59457x, pointExt.f59458y, create2);
        X448Field.add(pointExt2.f59457x, pointExt2.f59458y, create5);
        X448Field.mul(create2, create5, create8);
        X448Field.add(create4, create3, create2);
        X448Field.sub(create4, create3, create5);
        X448Field.carry(create2);
        X448Field.sub(create8, create2, create8);
        X448Field.mul(create8, create, create8);
        X448Field.mul(create5, create, create5);
        X448Field.mul(create6, create8, pointExt2.f59457x);
        X448Field.mul(create5, create7, pointExt2.f59458y);
        X448Field.mul(create6, create7, pointExt2.f59459z);
    }

    private static void pointAddPrecomp(PointPrecomp pointPrecomp, PointExt pointExt) {
        int[] create = X448Field.create();
        int[] create2 = X448Field.create();
        int[] create3 = X448Field.create();
        int[] create4 = X448Field.create();
        int[] create5 = X448Field.create();
        int[] create6 = X448Field.create();
        int[] create7 = X448Field.create();
        X448Field.sqr(pointExt.f59459z, create);
        X448Field.mul(pointPrecomp.f59460x, pointExt.f59457x, create2);
        X448Field.mul(pointPrecomp.f59461y, pointExt.f59458y, create3);
        X448Field.mul(create2, create3, create4);
        X448Field.mul(create4, 39081, create4);
        X448Field.add(create, create4, create5);
        X448Field.sub(create, create4, create6);
        X448Field.add(pointPrecomp.f59460x, pointPrecomp.f59461y, create);
        X448Field.add(pointExt.f59457x, pointExt.f59458y, create4);
        X448Field.mul(create, create4, create7);
        X448Field.add(create3, create2, create);
        X448Field.sub(create3, create2, create4);
        X448Field.carry(create);
        X448Field.sub(create7, create, create7);
        X448Field.mul(create7, pointExt.f59459z, create7);
        X448Field.mul(create4, pointExt.f59459z, create4);
        X448Field.mul(create5, create7, pointExt.f59457x);
        X448Field.mul(create4, create6, pointExt.f59458y);
        X448Field.mul(create5, create6, pointExt.f59459z);
    }

    private static void pointAddVar(boolean z11, PointExt pointExt, PointExt pointExt2) {
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        int[] iArr4;
        int[] create = X448Field.create();
        int[] create2 = X448Field.create();
        int[] create3 = X448Field.create();
        int[] create4 = X448Field.create();
        int[] create5 = X448Field.create();
        int[] create6 = X448Field.create();
        int[] create7 = X448Field.create();
        int[] create8 = X448Field.create();
        if (z11) {
            X448Field.sub(pointExt.f59458y, pointExt.f59457x, create8);
            iArr2 = create2;
            iArr3 = create5;
            iArr4 = create6;
            iArr = create7;
        } else {
            X448Field.add(pointExt.f59458y, pointExt.f59457x, create8);
            iArr3 = create2;
            iArr2 = create5;
            iArr = create6;
            iArr4 = create7;
        }
        X448Field.mul(pointExt.f59459z, pointExt2.f59459z, create);
        X448Field.sqr(create, create2);
        X448Field.mul(pointExt.f59457x, pointExt2.f59457x, create3);
        X448Field.mul(pointExt.f59458y, pointExt2.f59458y, create4);
        X448Field.mul(create3, create4, create5);
        X448Field.mul(create5, 39081, create5);
        X448Field.add(create2, create5, iArr);
        X448Field.sub(create2, create5, iArr4);
        X448Field.add(pointExt2.f59457x, pointExt2.f59458y, create5);
        X448Field.mul(create8, create5, create8);
        X448Field.add(create4, create3, iArr3);
        X448Field.sub(create4, create3, iArr2);
        X448Field.carry(iArr3);
        X448Field.sub(create8, create2, create8);
        X448Field.mul(create8, create, create8);
        X448Field.mul(create5, create, create5);
        X448Field.mul(create6, create8, pointExt2.f59457x);
        X448Field.mul(create5, create7, pointExt2.f59458y);
        X448Field.mul(create6, create7, pointExt2.f59459z);
    }

    private static PointExt pointCopy(PointExt pointExt) {
        PointExt pointExt2 = new PointExt();
        pointCopy(pointExt, pointExt2);
        return pointExt2;
    }

    private static void pointCopy(PointExt pointExt, PointExt pointExt2) {
        X448Field.copy(pointExt.f59457x, 0, pointExt2.f59457x, 0);
        X448Field.copy(pointExt.f59458y, 0, pointExt2.f59458y, 0);
        X448Field.copy(pointExt.f59459z, 0, pointExt2.f59459z, 0);
    }

    private static void pointDouble(PointExt pointExt) {
        int[] create = X448Field.create();
        int[] create2 = X448Field.create();
        int[] create3 = X448Field.create();
        int[] create4 = X448Field.create();
        int[] create5 = X448Field.create();
        int[] create6 = X448Field.create();
        X448Field.add(pointExt.f59457x, pointExt.f59458y, create);
        X448Field.sqr(create, create);
        X448Field.sqr(pointExt.f59457x, create2);
        X448Field.sqr(pointExt.f59458y, create3);
        X448Field.add(create2, create3, create4);
        X448Field.carry(create4);
        X448Field.sqr(pointExt.f59459z, create5);
        X448Field.add(create5, create5, create5);
        X448Field.carry(create5);
        X448Field.sub(create4, create5, create6);
        X448Field.sub(create, create4, create);
        X448Field.sub(create2, create3, create2);
        X448Field.mul(create, create6, pointExt.f59457x);
        X448Field.mul(create4, create2, pointExt.f59458y);
        X448Field.mul(create4, create6, pointExt.f59459z);
    }

    private static void pointExtendXY(PointExt pointExt) {
        X448Field.one(pointExt.f59459z);
    }

    private static void pointLookup(int i11, int i12, PointPrecomp pointPrecomp) {
        int i13 = i11 * 16 * 2 * 16;
        for (int i14 = 0; i14 < 16; i14++) {
            int i15 = ((i14 ^ i12) - 1) >> 31;
            X448Field.cmov(i15, precompBase, i13, pointPrecomp.f59460x, 0);
            int i16 = i13 + 16;
            X448Field.cmov(i15, precompBase, i16, pointPrecomp.f59461y, 0);
            i13 = i16 + 16;
        }
    }

    private static void pointLookup(int[] iArr, int i11, int[] iArr2, PointExt pointExt) {
        int window4 = getWindow4(iArr, i11);
        int i12 = (window4 >>> 3) ^ 1;
        int i13 = (window4 ^ (-i12)) & 7;
        int i14 = 0;
        for (int i15 = 0; i15 < 8; i15++) {
            int i16 = ((i15 ^ i13) - 1) >> 31;
            X448Field.cmov(i16, iArr2, i14, pointExt.f59457x, 0);
            int i17 = i14 + 16;
            X448Field.cmov(i16, iArr2, i17, pointExt.f59458y, 0);
            int i18 = i17 + 16;
            X448Field.cmov(i16, iArr2, i18, pointExt.f59459z, 0);
            i14 = i18 + 16;
        }
        X448Field.cnegate(i12, pointExt.f59457x);
    }

    private static void pointLookup15(int[] iArr, PointExt pointExt) {
        X448Field.copy(iArr, 336, pointExt.f59457x, 0);
        X448Field.copy(iArr, 352, pointExt.f59458y, 0);
        X448Field.copy(iArr, 368, pointExt.f59459z, 0);
    }

    private static int[] pointPrecompute(PointExt pointExt, int i11) {
        PointExt pointCopy = pointCopy(pointExt);
        PointExt pointCopy2 = pointCopy(pointCopy);
        pointDouble(pointCopy2);
        int[] createTable = X448Field.createTable(i11 * 3);
        int i12 = 0;
        int i13 = 0;
        while (true) {
            X448Field.copy(pointCopy.f59457x, 0, createTable, i12);
            int i14 = i12 + 16;
            X448Field.copy(pointCopy.f59458y, 0, createTable, i14);
            int i15 = i14 + 16;
            X448Field.copy(pointCopy.f59459z, 0, createTable, i15);
            i12 = i15 + 16;
            i13++;
            if (i13 == i11) {
                return createTable;
            }
            pointAdd(pointCopy2, pointCopy);
        }
    }

    private static PointExt[] pointPrecomputeVar(PointExt pointExt, int i11) {
        PointExt pointCopy = pointCopy(pointExt);
        pointDouble(pointCopy);
        PointExt[] pointExtArr = new PointExt[i11];
        pointExtArr[0] = pointCopy(pointExt);
        for (int i12 = 1; i12 < i11; i12++) {
            pointExtArr[i12] = pointCopy(pointExtArr[i12 - 1]);
            pointAddVar(false, pointCopy, pointExtArr[i12]);
        }
        return pointExtArr;
    }

    private static void pointSetNeutral(PointExt pointExt) {
        X448Field.zero(pointExt.f59457x);
        X448Field.one(pointExt.f59458y);
        X448Field.one(pointExt.f59459z);
    }

    public static void precompute() {
        synchronized (precompLock) {
            if (precompBase == null) {
                PointExt pointExt = new PointExt();
                X448Field.copy(B_x, 0, pointExt.f59457x, 0);
                X448Field.copy(B_y, 0, pointExt.f59458y, 0);
                pointExtendXY(pointExt);
                precompBaseTable = pointPrecomputeVar(pointExt, 32);
                precompBase = X448Field.createTable(160);
                int i11 = 0;
                for (int i12 = 0; i12 < 5; i12++) {
                    PointExt[] pointExtArr = new PointExt[5];
                    PointExt pointExt2 = new PointExt();
                    pointSetNeutral(pointExt2);
                    int i13 = 0;
                    while (true) {
                        if (i13 >= 5) {
                            break;
                        }
                        pointAddVar(true, pointExt, pointExt2);
                        pointDouble(pointExt);
                        pointExtArr[i13] = pointCopy(pointExt);
                        if (i12 + i13 != 8) {
                            for (int i14 = 1; i14 < 18; i14++) {
                                pointDouble(pointExt);
                            }
                        }
                        i13++;
                    }
                    PointExt[] pointExtArr2 = new PointExt[16];
                    pointExtArr2[0] = pointExt2;
                    int i15 = 1;
                    for (int i16 = 0; i16 < 4; i16++) {
                        int i17 = 1 << i16;
                        int i18 = 0;
                        while (i18 < i17) {
                            pointExtArr2[i15] = pointCopy(pointExtArr2[i15 - i17]);
                            pointAddVar(false, pointExtArr[i16], pointExtArr2[i15]);
                            i18++;
                            i15++;
                        }
                    }
                    int[] createTable = X448Field.createTable(16);
                    int[] create = X448Field.create();
                    X448Field.copy(pointExtArr2[0].f59459z, 0, create, 0);
                    X448Field.copy(create, 0, createTable, 0);
                    int i19 = 0;
                    while (true) {
                        i19++;
                        if (i19 >= 16) {
                            break;
                        }
                        X448Field.mul(create, pointExtArr2[i19].f59459z, create);
                        X448Field.copy(create, 0, createTable, i19 * 16);
                    }
                    X448Field.invVar(create, create);
                    int i21 = i19 - 1;
                    int[] create2 = X448Field.create();
                    while (i21 > 0) {
                        int i22 = i21 - 1;
                        X448Field.copy(createTable, i22 * 16, create2, 0);
                        X448Field.mul(create2, create, create2);
                        X448Field.copy(create2, 0, createTable, i21 * 16);
                        X448Field.mul(create, pointExtArr2[i21].f59459z, create);
                        i21 = i22;
                    }
                    X448Field.copy(create, 0, createTable, 0);
                    for (int i23 = 0; i23 < 16; i23++) {
                        PointExt pointExt3 = pointExtArr2[i23];
                        X448Field.copy(createTable, i23 * 16, pointExt3.f59459z, 0);
                        int[] iArr = pointExt3.f59457x;
                        X448Field.mul(iArr, pointExt3.f59459z, iArr);
                        int[] iArr2 = pointExt3.f59458y;
                        X448Field.mul(iArr2, pointExt3.f59459z, iArr2);
                        X448Field.copy(pointExt3.f59457x, 0, precompBase, i11);
                        int i24 = i11 + 16;
                        X448Field.copy(pointExt3.f59458y, 0, precompBase, i24);
                        i11 = i24 + 16;
                    }
                }
            }
        }
    }

    private static void pruneScalar(byte[] bArr, int i11, byte[] bArr2) {
        System.arraycopy(bArr, i11, bArr2, 0, 56);
        bArr2[0] = (byte) (bArr2[0] & 252);
        bArr2[55] = (byte) (bArr2[55] | 128);
        bArr2[56] = 0;
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
        long decode245 = ((long) (decode24(bArr2, 32) << 4)) & 4294967295L;
        long decode325 = ((long) decode32(bArr2, 35)) & 4294967295L;
        long decode246 = ((long) (decode24(bArr2, 39) << 4)) & 4294967295L;
        long decode326 = ((long) decode32(bArr2, 42)) & 4294967295L;
        long decode247 = ((long) (decode24(bArr2, 46) << 4)) & 4294967295L;
        long decode327 = ((long) decode32(bArr2, 49)) & 4294967295L;
        long decode248 = ((long) (decode24(bArr2, 53) << 4)) & 4294967295L;
        long decode249 = ((long) (decode24(bArr2, 74) << 4)) & 4294967295L;
        long decode328 = ((long) decode32(bArr2, 77)) & 4294967295L;
        long decode2410 = ((long) (decode24(bArr2, 81) << 4)) & 4294967295L;
        long decode329 = ((long) decode32(bArr2, 84)) & 4294967295L;
        long decode2411 = ((long) (decode24(bArr2, 88) << 4)) & 4294967295L;
        long decode3210 = ((long) decode32(bArr2, 91)) & 4294967295L;
        long decode2412 = ((long) (decode24(bArr2, 95) << 4)) & 4294967295L;
        long decode3211 = ((long) decode32(bArr2, 98)) & 4294967295L;
        long decode2413 = ((long) (decode24(bArr2, 102) << 4)) & 4294967295L;
        long decode3212 = ((long) decode32(bArr2, 105)) & 4294967295L;
        long decode2414 = ((long) (decode24(bArr2, 109) << 4)) & 4294967295L;
        long decode16 = ((long) decode16(bArr2, 112)) & 4294967295L;
        long j11 = decode2410 + (decode16 * 550336261);
        long j12 = decode2414 + (decode3212 >>> 28);
        long j13 = decode3212 & M28L;
        long decode3213 = (((long) decode32(bArr2, 56)) & 4294967295L) + (decode16 * 43969588) + (j12 * 30366549);
        long decode2415 = (((long) (decode24(bArr2, 60) << 4)) & 4294967295L) + (decode16 * 30366549) + (j12 * 163752818);
        long decode3214 = (((long) decode32(bArr2, 63)) & 4294967295L) + (decode16 * 163752818) + (j12 * 258169998);
        long decode2416 = (((long) (decode24(bArr2, 67) << 4)) & 4294967295L) + (decode16 * 258169998) + (j12 * 96434764);
        long j14 = decode328 + (decode16 * 149865618) + (j12 * 550336261);
        long j15 = decode2413 + (decode3211 >>> 28);
        long j16 = decode3211 & M28L;
        long decode3215 = (((long) decode32(bArr2, 70)) & 4294967295L) + (decode16 * 96434764) + (j12 * 227822194) + (j13 * 149865618) + (j15 * 550336261);
        long j17 = decode2412 + (decode3210 >>> 28);
        long j18 = decode3210 & M28L;
        long j19 = decode3214 + (j13 * 96434764) + (j15 * 227822194) + (j16 * 149865618) + (j17 * 550336261);
        long j21 = decode2415 + (j13 * 258169998) + (j15 * 96434764) + (j16 * 227822194) + (j17 * 149865618) + (j18 * 550336261);
        long j22 = decode2411 + (decode329 >>> 28);
        long j23 = decode329 & M28L;
        long j24 = decode249 + (decode16 * 227822194) + (j12 * 149865618) + (j13 * 550336261) + (decode3215 >>> 28);
        long j25 = decode3215 & M28L;
        long j26 = j14 + (j24 >>> 28);
        long j27 = j24 & M28L;
        long j28 = j11 + (j26 >>> 28);
        long j29 = j26 & M28L;
        long j30 = j23 + (j28 >>> 28);
        long j31 = j28 & M28L;
        long j32 = decode244 + (j31 * 43969588);
        long j33 = decode324 + (j30 * 43969588) + (j31 * 30366549);
        long j34 = decode245 + (j22 * 43969588) + (j30 * 30366549) + (j31 * 163752818);
        long j35 = decode325 + (j18 * 43969588) + (j22 * 30366549) + (j30 * 163752818) + (j31 * 258169998);
        long j36 = decode246 + (j17 * 43969588) + (j18 * 30366549) + (j22 * 163752818) + (j30 * 258169998) + (j31 * 96434764);
        long j37 = decode326 + (j16 * 43969588) + (j17 * 30366549) + (j18 * 163752818) + (j22 * 258169998) + (j30 * 96434764) + (j31 * 227822194);
        long j38 = decode327 + (j13 * 43969588) + (j15 * 30366549) + (j16 * 163752818) + (j17 * 258169998) + (j18 * 96434764) + (j22 * 227822194) + (j30 * 149865618) + (j31 * 550336261);
        long j39 = j19 + (j21 >>> 28);
        long j40 = j21 & M28L;
        long j41 = decode2416 + (j13 * 227822194) + (j15 * 149865618) + (j16 * 550336261) + (j39 >>> 28);
        long j42 = j39 & M28L;
        long j43 = j25 + (j41 >>> 28);
        long j44 = j41 & M28L;
        long j45 = j27 + (j43 >>> 28);
        long j46 = j43 & M28L;
        long j47 = decode322 + (j46 * 43969588);
        long j48 = decode243 + (j45 * 43969588) + (j46 * 30366549);
        long j49 = decode323 + (j29 * 43969588) + (j45 * 30366549) + (j46 * 163752818);
        long j50 = j32 + (j29 * 30366549) + (j45 * 163752818) + (j46 * 258169998);
        long j51 = j33 + (j29 * 163752818) + (j45 * 258169998) + (j46 * 96434764);
        long j52 = j34 + (j29 * 258169998) + (j45 * 96434764) + (j46 * 227822194);
        long j53 = j36 + (j29 * 227822194) + (j45 * 149865618) + (j46 * 550336261);
        long j54 = decode242 + (j44 * 43969588);
        long j55 = j47 + (j44 * 30366549);
        long j56 = j48 + (j44 * 163752818);
        long j57 = j49 + (j44 * 258169998);
        long j58 = j50 + (j44 * 96434764);
        long j59 = j51 + (j44 * 227822194);
        long j60 = j52 + (j44 * 149865618);
        long j61 = j35 + (j29 * 96434764) + (j45 * 227822194) + (j46 * 149865618) + (j44 * 550336261);
        long j62 = decode248 + (j12 * 43969588) + (j13 * 30366549) + (j15 * 163752818) + (j16 * 258169998) + (j17 * 96434764) + (j18 * 227822194) + (j22 * 149865618) + (j30 * 550336261) + (j38 >>> 28);
        long j63 = j38 & M28L;
        long j64 = decode3213 + (j13 * 163752818) + (j15 * 258169998) + (j16 * 96434764) + (j17 * 227822194) + (j18 * 149865618) + (j22 * 550336261) + (j62 >>> 28);
        long j65 = j62 & M28L;
        long j66 = j40 + (j64 >>> 28);
        long j67 = j64 & M28L;
        long j68 = j42 + (j66 >>> 28);
        long j69 = j66 & M28L;
        long j70 = decode32 + (j68 * 43969588);
        long j71 = j54 + (j68 * 30366549);
        long j72 = j55 + (j68 * 163752818);
        long j73 = j56 + (j68 * 258169998);
        long j74 = j57 + (j68 * 96434764);
        long j75 = j58 + (j68 * 227822194);
        long j76 = j60 + (j68 * 550336261);
        long j77 = j65 & M26L;
        long j78 = (j67 * 4) + (j65 >>> 26) + 1;
        long decode3216 = (((long) decode32(bArr2, 0)) & 4294967295L) + (78101261 * j78);
        long j79 = j70 + (30366549 * j69) + (175155932 * j78);
        long j80 = j71 + (163752818 * j69) + (64542499 * j78);
        long j81 = j72 + (258169998 * j69) + (158326419 * j78);
        long j82 = j73 + (96434764 * j69) + (191173276 * j78);
        long j83 = j75 + (149865618 * j69) + (j78 * 137584065);
        long j84 = decode24 + (43969588 * j69) + (141809365 * j78) + (decode3216 >>> 28);
        long j85 = decode3216 & M28L;
        long j86 = j79 + (j84 >>> 28);
        long j87 = j84 & M28L;
        long j88 = j80 + (j86 >>> 28);
        long j89 = j86 & M28L;
        long j90 = j81 + (j88 >>> 28);
        long j91 = j88 & M28L;
        long j92 = j82 + (j90 >>> 28);
        long j93 = j90 & M28L;
        long j94 = j74 + (227822194 * j69) + (104575268 * j78) + (j92 >>> 28);
        long j95 = j92 & M28L;
        long j96 = j83 + (j94 >>> 28);
        long j97 = j94 & M28L;
        long j98 = j59 + (j68 * 149865618) + (j69 * 550336261) + (j96 >>> 28);
        long j99 = j96 & M28L;
        long j100 = j76 + (j98 >>> 28);
        long j101 = j98 & M28L;
        long j102 = j61 + (j100 >>> 28);
        long j103 = j100 & M28L;
        long j104 = j53 + (j102 >>> 28);
        long j105 = j102 & M28L;
        long j106 = j37 + (j29 * 149865618) + (j45 * 550336261) + (j104 >>> 28);
        long j107 = j104 & M28L;
        long j108 = decode247 + (j15 * 43969588) + (j16 * 30366549) + (j17 * 163752818) + (j18 * 258169998) + (j22 * 96434764) + (j30 * 227822194) + (j31 * 149865618) + (j29 * 550336261) + (j106 >>> 28);
        long j109 = j106 & M28L;
        long j110 = j63 + (j108 >>> 28);
        long j111 = j108 & M28L;
        long j112 = j77 + (j110 >>> 28);
        long j113 = j110 & M28L;
        long j114 = j112 & M26L;
        long j115 = (j112 >>> 26) - 1;
        long j116 = j85 - (j115 & 78101261);
        long j117 = (j87 - (j115 & 141809365)) + (j116 >> 28);
        long j118 = j116 & M28L;
        long j119 = (j89 - (j115 & 175155932)) + (j117 >> 28);
        long j120 = j117 & M28L;
        long j121 = (j91 - (j115 & 64542499)) + (j119 >> 28);
        long j122 = j119 & M28L;
        long j123 = (j93 - (j115 & 158326419)) + (j121 >> 28);
        long j124 = j121 & M28L;
        long j125 = (j95 - (j115 & 191173276)) + (j123 >> 28);
        long j126 = j123 & M28L;
        long j127 = (j97 - (j115 & 104575268)) + (j125 >> 28);
        long j128 = j125 & M28L;
        long j129 = (j99 - (j115 & 137584065)) + (j127 >> 28);
        long j130 = j127 & M28L;
        long j131 = j101 + (j129 >> 28);
        long j132 = j129 & M28L;
        long j133 = j103 + (j131 >> 28);
        long j134 = j131 & M28L;
        long j135 = j105 + (j133 >> 28);
        long j136 = j133 & M28L;
        long j137 = j107 + (j135 >> 28);
        long j138 = j135 & M28L;
        long j139 = j109 + (j137 >> 28);
        long j140 = j137 & M28L;
        long j141 = j111 + (j139 >> 28);
        long j142 = j139 & M28L;
        long j143 = j113 + (j141 >> 28);
        long j144 = j141 & M28L;
        long j145 = j143 & M28L;
        byte[] bArr3 = new byte[57];
        encode56((j120 << 28) | j118, bArr3, 0);
        encode56((j124 << 28) | j122, bArr3, 7);
        encode56(j126 | (j128 << 28), bArr3, 14);
        encode56(j130 | (j132 << 28), bArr3, 21);
        encode56(j134 | (j136 << 28), bArr3, 28);
        encode56(j138 | (j140 << 28), bArr3, 35);
        encode56(j142 | (j144 << 28), bArr3, 42);
        encode56(((j114 + (j143 >> 28)) << 28) | j145, bArr3, 49);
        return bArr3;
    }

    private static void scalarMult(byte[] bArr, PointExt pointExt, PointExt pointExt2) {
        int[] iArr = new int[14];
        decodeScalar(bArr, 0, iArr);
        Nat.shiftDownBit(14, iArr, Nat.cadd(14, (~iArr[0]) & 1, iArr, L, iArr));
        int[] pointPrecompute = pointPrecompute(pointExt, 8);
        PointExt pointExt3 = new PointExt();
        pointLookup15(pointPrecompute, pointExt2);
        pointAdd(pointExt, pointExt2);
        int i11 = 111;
        while (true) {
            pointLookup(iArr, i11, pointPrecompute, pointExt3);
            pointAdd(pointExt3, pointExt2);
            i11--;
            if (i11 >= 0) {
                for (int i12 = 0; i12 < 4; i12++) {
                    pointDouble(pointExt2);
                }
            } else {
                return;
            }
        }
    }

    private static void scalarMultBase(byte[] bArr, PointExt pointExt) {
        precompute();
        int[] iArr = new int[15];
        decodeScalar(bArr, 0, iArr);
        iArr[14] = Nat.cadd(14, (~iArr[0]) & 1, iArr, L, iArr) + 4;
        Nat.shiftDownBit(15, iArr, 0);
        PointPrecomp pointPrecomp = new PointPrecomp();
        pointSetNeutral(pointExt);
        int i11 = 17;
        while (true) {
            int i12 = i11;
            for (int i13 = 0; i13 < 5; i13++) {
                int i14 = 0;
                for (int i15 = 0; i15 < 5; i15++) {
                    i14 = (i14 & (~(1 << i15))) ^ ((iArr[i12 >>> 5] >>> (i12 & 31)) << i15);
                    i12 += 18;
                }
                int i16 = (i14 >>> 4) & 1;
                pointLookup(i13, ((-i16) ^ i14) & 15, pointPrecomp);
                X448Field.cnegate(i16, pointPrecomp.f59460x);
                pointAddPrecomp(pointPrecomp, pointExt);
            }
            i11--;
            if (i11 >= 0) {
                pointDouble(pointExt);
            } else {
                return;
            }
        }
    }

    private static void scalarMultBaseEncoded(byte[] bArr, byte[] bArr2, int i11) {
        PointExt pointExt = new PointExt();
        scalarMultBase(bArr, pointExt);
        if (encodePoint(pointExt, bArr2, i11) == 0) {
            throw new IllegalStateException();
        }
    }

    public static void scalarMultBaseXY(X448.Friend friend, byte[] bArr, int i11, int[] iArr, int[] iArr2) {
        Objects.requireNonNull(friend, "This method is only for use by X448");
        byte[] bArr2 = new byte[57];
        pruneScalar(bArr, i11, bArr2);
        PointExt pointExt = new PointExt();
        scalarMultBase(bArr2, pointExt);
        if (checkPoint(pointExt.f59457x, pointExt.f59458y, pointExt.f59459z) != 0) {
            X448Field.copy(pointExt.f59457x, 0, iArr, 0);
            X448Field.copy(pointExt.f59458y, 0, iArr2, 0);
            return;
        }
        throw new IllegalStateException();
    }

    private static void scalarMultOrderVar(PointExt pointExt, PointExt pointExt2) {
        byte[] wnafVar = getWnafVar(L, 5);
        PointExt[] pointPrecomputeVar = pointPrecomputeVar(pointExt, 8);
        pointSetNeutral(pointExt2);
        int i11 = 446;
        while (true) {
            byte b11 = wnafVar[i11];
            if (b11 != 0) {
                int i12 = b11 >> Ascii.US;
                boolean z11 = true;
                int i13 = (b11 ^ i12) >>> 1;
                if (i12 == 0) {
                    z11 = false;
                }
                pointAddVar(z11, pointPrecomputeVar[i13], pointExt2);
            }
            i11--;
            if (i11 >= 0) {
                pointDouble(pointExt2);
            } else {
                return;
            }
        }
    }

    private static void scalarMultStrausVar(int[] iArr, int[] iArr2, PointExt pointExt, PointExt pointExt2) {
        precompute();
        byte[] wnafVar = getWnafVar(iArr, 7);
        byte[] wnafVar2 = getWnafVar(iArr2, 5);
        PointExt[] pointPrecomputeVar = pointPrecomputeVar(pointExt, 8);
        pointSetNeutral(pointExt2);
        int i11 = 446;
        while (true) {
            byte b11 = wnafVar[i11];
            boolean z11 = false;
            if (b11 != 0) {
                int i12 = b11 >> Ascii.US;
                pointAddVar(i12 != 0, precompBaseTable[(b11 ^ i12) >>> 1], pointExt2);
            }
            byte b12 = wnafVar2[i11];
            if (b12 != 0) {
                int i13 = b12 >> Ascii.US;
                int i14 = (b12 ^ i13) >>> 1;
                if (i13 != 0) {
                    z11 = true;
                }
                pointAddVar(z11, pointPrecomputeVar[i14], pointExt2);
            }
            i11--;
            if (i11 >= 0) {
                pointDouble(pointExt2);
            } else {
                return;
            }
        }
    }

    public static void sign(byte[] bArr, int i11, byte[] bArr2, int i12, byte[] bArr3, byte[] bArr4, int i13, int i14, byte[] bArr5, int i15) {
        implSign(bArr, i11, bArr2, i12, bArr3, (byte) 0, bArr4, i13, i14, bArr5, i15);
    }

    public static void sign(byte[] bArr, int i11, byte[] bArr2, byte[] bArr3, int i12, int i13, byte[] bArr4, int i14) {
        implSign(bArr, i11, bArr2, (byte) 0, bArr3, i12, i13, bArr4, i14);
    }

    public static void signPrehash(byte[] bArr, int i11, byte[] bArr2, int i12, byte[] bArr3, Xof xof, byte[] bArr4, int i13) {
        byte[] bArr5 = new byte[64];
        if (64 == xof.doFinal(bArr5, 0, 64)) {
            implSign(bArr, i11, bArr2, i12, bArr3, (byte) 1, bArr5, 0, 64, bArr4, i13);
            return;
        }
        throw new IllegalArgumentException(UserDataStore.PHONE);
    }

    public static void signPrehash(byte[] bArr, int i11, byte[] bArr2, int i12, byte[] bArr3, byte[] bArr4, int i13, byte[] bArr5, int i14) {
        implSign(bArr, i11, bArr2, i12, bArr3, (byte) 1, bArr4, i13, 64, bArr5, i14);
    }

    public static void signPrehash(byte[] bArr, int i11, byte[] bArr2, Xof xof, byte[] bArr3, int i12) {
        byte[] bArr4 = new byte[64];
        if (64 == xof.doFinal(bArr4, 0, 64)) {
            implSign(bArr, i11, bArr2, (byte) 1, bArr4, 0, 64, bArr3, i12);
            return;
        }
        throw new IllegalArgumentException(UserDataStore.PHONE);
    }

    public static void signPrehash(byte[] bArr, int i11, byte[] bArr2, byte[] bArr3, int i12, byte[] bArr4, int i13) {
        implSign(bArr, i11, bArr2, (byte) 1, bArr3, i12, 64, bArr4, i13);
    }

    public static boolean validatePublicKeyFull(byte[] bArr, int i11) {
        PointExt pointExt = new PointExt();
        if (!decodePointVar(bArr, i11, false, pointExt)) {
            return false;
        }
        X448Field.normalize(pointExt.f59457x);
        X448Field.normalize(pointExt.f59458y);
        X448Field.normalize(pointExt.f59459z);
        if (isNeutralElementVar(pointExt.f59457x, pointExt.f59458y, pointExt.f59459z)) {
            return false;
        }
        PointExt pointExt2 = new PointExt();
        scalarMultOrderVar(pointExt, pointExt2);
        X448Field.normalize(pointExt2.f59457x);
        X448Field.normalize(pointExt2.f59458y);
        X448Field.normalize(pointExt2.f59459z);
        return isNeutralElementVar(pointExt2.f59457x, pointExt2.f59458y, pointExt2.f59459z);
    }

    public static boolean validatePublicKeyPartial(byte[] bArr, int i11) {
        return decodePointVar(bArr, i11, false, new PointExt());
    }

    public static boolean verify(byte[] bArr, int i11, byte[] bArr2, int i12, byte[] bArr3, byte[] bArr4, int i13, int i14) {
        return implVerify(bArr, i11, bArr2, i12, bArr3, (byte) 0, bArr4, i13, i14);
    }

    public static boolean verifyPrehash(byte[] bArr, int i11, byte[] bArr2, int i12, byte[] bArr3, Xof xof) {
        byte[] bArr4 = new byte[64];
        if (64 == xof.doFinal(bArr4, 0, 64)) {
            return implVerify(bArr, i11, bArr2, i12, bArr3, (byte) 1, bArr4, 0, 64);
        }
        throw new IllegalArgumentException(UserDataStore.PHONE);
    }

    public static boolean verifyPrehash(byte[] bArr, int i11, byte[] bArr2, int i12, byte[] bArr3, byte[] bArr4, int i13) {
        return implVerify(bArr, i11, bArr2, i12, bArr3, (byte) 1, bArr4, i13, 64);
    }
}
