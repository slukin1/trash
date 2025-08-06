package org.bouncycastle.crypto.digests;

import org.bouncycastle.crypto.ExtendedDigest;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Longs;
import org.bouncycastle.util.Pack;

public class Blake2bDigest implements ExtendedDigest {
    private static final int BLOCK_LENGTH_BYTES = 128;
    private static int ROUNDS = 12;
    private static final long[] blake2b_IV = {7640891576956012808L, -4942790177534073029L, 4354685564936845355L, -6534734903238641935L, 5840696475078001361L, -7276294671716946913L, 2270897969802886507L, 6620516959819538809L};
    private static final byte[][] blake2b_sigma = {new byte[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}, new byte[]{14, 10, 4, 8, 9, 15, 13, 6, 1, 12, 0, 2, 11, 7, 5, 3}, new byte[]{11, 8, 12, 0, 5, 2, 15, 13, 10, 14, 3, 6, 7, 1, 9, 4}, new byte[]{7, 9, 3, 1, 13, 12, 11, 14, 2, 6, 5, 10, 4, 0, 15, 8}, new byte[]{9, 0, 5, 7, 2, 4, 10, 15, 14, 1, 11, 12, 6, 8, 3, 13}, new byte[]{2, 12, 6, 10, 0, 11, 8, 3, 4, 13, 7, 5, 15, 14, 1, 9}, new byte[]{12, 5, 1, 15, 14, 13, 4, 10, 0, 7, 6, 3, 9, 2, 8, 11}, new byte[]{13, 11, 7, 14, 12, 1, 3, 9, 5, 0, 15, 4, 8, 6, 2, 10}, new byte[]{6, 15, 14, 9, 11, 3, 0, 8, 12, 2, 13, 7, 1, 4, 10, 5}, new byte[]{10, 2, 8, 4, 7, 6, 1, 5, 15, 11, 9, 14, 3, 12, 13, 0}, new byte[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}, new byte[]{14, 10, 4, 8, 9, 15, 13, 6, 1, 12, 0, 2, 11, 7, 5, 3}};
    private byte[] buffer;
    private int bufferPos;
    private long[] chainValue;
    private int digestLength;

    /* renamed from: f0  reason: collision with root package name */
    private long f59124f0;
    private long[] internalState;
    private byte[] key;
    private int keyLength;
    private byte[] personalization;
    private byte[] salt;

    /* renamed from: t0  reason: collision with root package name */
    private long f59125t0;

    /* renamed from: t1  reason: collision with root package name */
    private long f59126t1;

    public Blake2bDigest() {
        this(512);
    }

    public Blake2bDigest(int i11) {
        this.digestLength = 64;
        this.keyLength = 0;
        this.salt = null;
        this.personalization = null;
        this.key = null;
        this.buffer = null;
        this.bufferPos = 0;
        this.internalState = new long[16];
        this.chainValue = null;
        this.f59125t0 = 0;
        this.f59126t1 = 0;
        this.f59124f0 = 0;
        if (i11 < 8 || i11 > 512 || i11 % 8 != 0) {
            throw new IllegalArgumentException("BLAKE2b digest bit length must be a multiple of 8 and not greater than 512");
        }
        this.buffer = new byte[128];
        this.keyLength = 0;
        this.digestLength = i11 / 8;
        init();
    }

    public Blake2bDigest(Blake2bDigest blake2bDigest) {
        this.digestLength = 64;
        this.keyLength = 0;
        this.salt = null;
        this.personalization = null;
        this.key = null;
        this.buffer = null;
        this.bufferPos = 0;
        this.internalState = new long[16];
        this.chainValue = null;
        this.f59125t0 = 0;
        this.f59126t1 = 0;
        this.f59124f0 = 0;
        this.bufferPos = blake2bDigest.bufferPos;
        this.buffer = Arrays.clone(blake2bDigest.buffer);
        this.keyLength = blake2bDigest.keyLength;
        this.key = Arrays.clone(blake2bDigest.key);
        this.digestLength = blake2bDigest.digestLength;
        this.chainValue = Arrays.clone(blake2bDigest.chainValue);
        this.personalization = Arrays.clone(blake2bDigest.personalization);
        this.salt = Arrays.clone(blake2bDigest.salt);
        this.f59125t0 = blake2bDigest.f59125t0;
        this.f59126t1 = blake2bDigest.f59126t1;
        this.f59124f0 = blake2bDigest.f59124f0;
    }

    public Blake2bDigest(byte[] bArr) {
        this.digestLength = 64;
        this.keyLength = 0;
        this.salt = null;
        this.personalization = null;
        this.key = null;
        this.buffer = null;
        this.bufferPos = 0;
        this.internalState = new long[16];
        this.chainValue = null;
        this.f59125t0 = 0;
        this.f59126t1 = 0;
        this.f59124f0 = 0;
        this.buffer = new byte[128];
        if (bArr != null) {
            byte[] bArr2 = new byte[bArr.length];
            this.key = bArr2;
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            if (bArr.length <= 64) {
                this.keyLength = bArr.length;
                System.arraycopy(bArr, 0, this.buffer, 0, bArr.length);
                this.bufferPos = 128;
            } else {
                throw new IllegalArgumentException("Keys > 64 are not supported");
            }
        }
        this.digestLength = 64;
        init();
    }

    public Blake2bDigest(byte[] bArr, int i11, byte[] bArr2, byte[] bArr3) {
        this.digestLength = 64;
        this.keyLength = 0;
        this.salt = null;
        this.personalization = null;
        this.key = null;
        this.buffer = null;
        this.bufferPos = 0;
        this.internalState = new long[16];
        this.chainValue = null;
        this.f59125t0 = 0;
        this.f59126t1 = 0;
        this.f59124f0 = 0;
        this.buffer = new byte[128];
        if (i11 < 1 || i11 > 64) {
            throw new IllegalArgumentException("Invalid digest length (required: 1 - 64)");
        }
        this.digestLength = i11;
        if (bArr2 != null) {
            if (bArr2.length == 16) {
                byte[] bArr4 = new byte[16];
                this.salt = bArr4;
                System.arraycopy(bArr2, 0, bArr4, 0, bArr2.length);
            } else {
                throw new IllegalArgumentException("salt length must be exactly 16 bytes");
            }
        }
        if (bArr3 != null) {
            if (bArr3.length == 16) {
                byte[] bArr5 = new byte[16];
                this.personalization = bArr5;
                System.arraycopy(bArr3, 0, bArr5, 0, bArr3.length);
            } else {
                throw new IllegalArgumentException("personalization length must be exactly 16 bytes");
            }
        }
        if (bArr != null) {
            byte[] bArr6 = new byte[bArr.length];
            this.key = bArr6;
            System.arraycopy(bArr, 0, bArr6, 0, bArr.length);
            if (bArr.length <= 64) {
                this.keyLength = bArr.length;
                System.arraycopy(bArr, 0, this.buffer, 0, bArr.length);
                this.bufferPos = 128;
            } else {
                throw new IllegalArgumentException("Keys > 64 are not supported");
            }
        }
        init();
    }

    private void G(long j11, long j12, int i11, int i12, int i13, int i14) {
        long[] jArr = this.internalState;
        jArr[i11] = jArr[i11] + jArr[i12] + j11;
        jArr[i14] = Longs.rotateRight(jArr[i14] ^ jArr[i11], 32);
        long[] jArr2 = this.internalState;
        jArr2[i13] = jArr2[i13] + jArr2[i14];
        jArr2[i12] = Longs.rotateRight(jArr2[i12] ^ jArr2[i13], 24);
        long[] jArr3 = this.internalState;
        jArr3[i11] = jArr3[i11] + jArr3[i12] + j12;
        jArr3[i14] = Longs.rotateRight(jArr3[i14] ^ jArr3[i11], 16);
        long[] jArr4 = this.internalState;
        jArr4[i13] = jArr4[i13] + jArr4[i14];
        jArr4[i12] = Longs.rotateRight(jArr4[i12] ^ jArr4[i13], 63);
    }

    private void compress(byte[] bArr, int i11) {
        initializeInternalState();
        long[] jArr = new long[16];
        int i12 = 0;
        for (int i13 = 0; i13 < 16; i13++) {
            jArr[i13] = Pack.littleEndianToLong(bArr, (i13 * 8) + i11);
        }
        for (int i14 = 0; i14 < ROUNDS; i14++) {
            byte[][] bArr2 = blake2b_sigma;
            G(jArr[bArr2[i14][0]], jArr[bArr2[i14][1]], 0, 4, 8, 12);
            G(jArr[bArr2[i14][2]], jArr[bArr2[i14][3]], 1, 5, 9, 13);
            G(jArr[bArr2[i14][4]], jArr[bArr2[i14][5]], 2, 6, 10, 14);
            G(jArr[bArr2[i14][6]], jArr[bArr2[i14][7]], 3, 7, 11, 15);
            G(jArr[bArr2[i14][8]], jArr[bArr2[i14][9]], 0, 5, 10, 15);
            G(jArr[bArr2[i14][10]], jArr[bArr2[i14][11]], 1, 6, 11, 12);
            G(jArr[bArr2[i14][12]], jArr[bArr2[i14][13]], 2, 7, 8, 13);
            G(jArr[bArr2[i14][14]], jArr[bArr2[i14][15]], 3, 4, 9, 14);
        }
        while (true) {
            long[] jArr2 = this.chainValue;
            if (i12 < jArr2.length) {
                long j11 = jArr2[i12];
                long[] jArr3 = this.internalState;
                jArr2[i12] = (j11 ^ jArr3[i12]) ^ jArr3[i12 + 8];
                i12++;
            } else {
                return;
            }
        }
    }

    private void init() {
        if (this.chainValue == null) {
            long[] jArr = new long[8];
            this.chainValue = jArr;
            long[] jArr2 = blake2b_IV;
            jArr[0] = jArr2[0] ^ ((long) ((this.digestLength | (this.keyLength << 8)) | 16842752));
            jArr[1] = jArr2[1];
            jArr[2] = jArr2[2];
            jArr[3] = jArr2[3];
            jArr[4] = jArr2[4];
            jArr[5] = jArr2[5];
            byte[] bArr = this.salt;
            if (bArr != null) {
                jArr[4] = jArr[4] ^ Pack.littleEndianToLong(bArr, 0);
                long[] jArr3 = this.chainValue;
                jArr3[5] = jArr3[5] ^ Pack.littleEndianToLong(this.salt, 8);
            }
            long[] jArr4 = this.chainValue;
            jArr4[6] = jArr2[6];
            jArr4[7] = jArr2[7];
            byte[] bArr2 = this.personalization;
            if (bArr2 != null) {
                jArr4[6] = Pack.littleEndianToLong(bArr2, 0) ^ jArr4[6];
                long[] jArr5 = this.chainValue;
                jArr5[7] = jArr5[7] ^ Pack.littleEndianToLong(this.personalization, 8);
            }
        }
    }

    private void initializeInternalState() {
        long[] jArr = this.chainValue;
        System.arraycopy(jArr, 0, this.internalState, 0, jArr.length);
        long[] jArr2 = blake2b_IV;
        System.arraycopy(jArr2, 0, this.internalState, this.chainValue.length, 4);
        long[] jArr3 = this.internalState;
        jArr3[12] = this.f59125t0 ^ jArr2[4];
        jArr3[13] = this.f59126t1 ^ jArr2[5];
        jArr3[14] = this.f59124f0 ^ jArr2[6];
        jArr3[15] = jArr2[7];
    }

    public void clearKey() {
        byte[] bArr = this.key;
        if (bArr != null) {
            Arrays.fill(bArr, (byte) 0);
            Arrays.fill(this.buffer, (byte) 0);
        }
    }

    public void clearSalt() {
        byte[] bArr = this.salt;
        if (bArr != null) {
            Arrays.fill(bArr, (byte) 0);
        }
    }

    public int doFinal(byte[] bArr, int i11) {
        long[] jArr;
        int i12;
        this.f59124f0 = -1;
        long j11 = this.f59125t0;
        int i13 = this.bufferPos;
        long j12 = j11 + ((long) i13);
        this.f59125t0 = j12;
        if (i13 > 0 && j12 == 0) {
            this.f59126t1++;
        }
        compress(this.buffer, 0);
        Arrays.fill(this.buffer, (byte) 0);
        Arrays.fill(this.internalState, 0);
        int i14 = 0;
        while (true) {
            jArr = this.chainValue;
            if (i14 >= jArr.length || (i12 = i14 * 8) >= this.digestLength) {
                Arrays.fill(jArr, 0);
                reset();
            } else {
                byte[] longToLittleEndian = Pack.longToLittleEndian(jArr[i14]);
                int i15 = this.digestLength;
                if (i12 < i15 - 8) {
                    System.arraycopy(longToLittleEndian, 0, bArr, i12 + i11, 8);
                } else {
                    System.arraycopy(longToLittleEndian, 0, bArr, i11 + i12, i15 - i12);
                }
                i14++;
            }
        }
        Arrays.fill(jArr, 0);
        reset();
        return this.digestLength;
    }

    public String getAlgorithmName() {
        return "BLAKE2b";
    }

    public int getByteLength() {
        return 128;
    }

    public int getDigestSize() {
        return this.digestLength;
    }

    public void reset() {
        this.bufferPos = 0;
        this.f59124f0 = 0;
        this.f59125t0 = 0;
        this.f59126t1 = 0;
        this.chainValue = null;
        Arrays.fill(this.buffer, (byte) 0);
        byte[] bArr = this.key;
        if (bArr != null) {
            System.arraycopy(bArr, 0, this.buffer, 0, bArr.length);
            this.bufferPos = 128;
        }
        init();
    }

    public void update(byte b11) {
        int i11 = this.bufferPos;
        if (128 - i11 == 0) {
            long j11 = this.f59125t0 + 128;
            this.f59125t0 = j11;
            if (j11 == 0) {
                this.f59126t1++;
            }
            compress(this.buffer, 0);
            Arrays.fill(this.buffer, (byte) 0);
            this.buffer[0] = b11;
            this.bufferPos = 1;
            return;
        }
        this.buffer[i11] = b11;
        this.bufferPos = i11 + 1;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0046  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void update(byte[] r12, int r13, int r14) {
        /*
            r11 = this;
            if (r12 == 0) goto L_0x0061
            if (r14 != 0) goto L_0x0005
            goto L_0x0061
        L_0x0005:
            int r0 = r11.bufferPos
            r1 = 1
            r3 = 0
            r5 = 128(0x80, double:6.32E-322)
            r7 = 0
            if (r0 == 0) goto L_0x003f
            int r8 = 128 - r0
            if (r8 >= r14) goto L_0x0034
            byte[] r9 = r11.buffer
            java.lang.System.arraycopy(r12, r13, r9, r0, r8)
            long r9 = r11.f59125t0
            long r9 = r9 + r5
            r11.f59125t0 = r9
            int r0 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r0 != 0) goto L_0x0027
            long r9 = r11.f59126t1
            long r9 = r9 + r1
            r11.f59126t1 = r9
        L_0x0027:
            byte[] r0 = r11.buffer
            r11.compress(r0, r7)
            r11.bufferPos = r7
            byte[] r0 = r11.buffer
            org.bouncycastle.util.Arrays.fill((byte[]) r0, (byte) r7)
            goto L_0x0040
        L_0x0034:
            byte[] r1 = r11.buffer
            java.lang.System.arraycopy(r12, r13, r1, r0, r14)
        L_0x0039:
            int r12 = r11.bufferPos
            int r12 = r12 + r14
            r11.bufferPos = r12
            return
        L_0x003f:
            r8 = r7
        L_0x0040:
            int r14 = r14 + r13
            int r0 = r14 + -128
            int r13 = r13 + r8
        L_0x0044:
            if (r13 >= r0) goto L_0x005a
            long r8 = r11.f59125t0
            long r8 = r8 + r5
            r11.f59125t0 = r8
            int r8 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r8 != 0) goto L_0x0054
            long r8 = r11.f59126t1
            long r8 = r8 + r1
            r11.f59126t1 = r8
        L_0x0054:
            r11.compress(r12, r13)
            int r13 = r13 + 128
            goto L_0x0044
        L_0x005a:
            byte[] r0 = r11.buffer
            int r14 = r14 - r13
            java.lang.System.arraycopy(r12, r13, r0, r7, r14)
            goto L_0x0039
        L_0x0061:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.crypto.digests.Blake2bDigest.update(byte[], int, int):void");
    }
}
