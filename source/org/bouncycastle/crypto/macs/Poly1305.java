package org.bouncycastle.crypto.macs;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.util.Pack;

public class Poly1305 implements Mac {
    private static final int BLOCK_SIZE = 16;
    private final BlockCipher cipher;
    private final byte[] currentBlock;
    private int currentBlockOffset;

    /* renamed from: h0  reason: collision with root package name */
    private int f59204h0;

    /* renamed from: h1  reason: collision with root package name */
    private int f59205h1;

    /* renamed from: h2  reason: collision with root package name */
    private int f59206h2;

    /* renamed from: h3  reason: collision with root package name */
    private int f59207h3;

    /* renamed from: h4  reason: collision with root package name */
    private int f59208h4;

    /* renamed from: k0  reason: collision with root package name */
    private int f59209k0;

    /* renamed from: k1  reason: collision with root package name */
    private int f59210k1;

    /* renamed from: k2  reason: collision with root package name */
    private int f59211k2;

    /* renamed from: k3  reason: collision with root package name */
    private int f59212k3;

    /* renamed from: r0  reason: collision with root package name */
    private int f59213r0;

    /* renamed from: r1  reason: collision with root package name */
    private int f59214r1;

    /* renamed from: r2  reason: collision with root package name */
    private int f59215r2;

    /* renamed from: r3  reason: collision with root package name */
    private int f59216r3;

    /* renamed from: r4  reason: collision with root package name */
    private int f59217r4;

    /* renamed from: s1  reason: collision with root package name */
    private int f59218s1;

    /* renamed from: s2  reason: collision with root package name */
    private int f59219s2;

    /* renamed from: s3  reason: collision with root package name */
    private int f59220s3;

    /* renamed from: s4  reason: collision with root package name */
    private int f59221s4;
    private final byte[] singleByte;

    public Poly1305() {
        this.singleByte = new byte[1];
        this.currentBlock = new byte[16];
        this.currentBlockOffset = 0;
        this.cipher = null;
    }

    public Poly1305(BlockCipher blockCipher) {
        this.singleByte = new byte[1];
        this.currentBlock = new byte[16];
        this.currentBlockOffset = 0;
        if (blockCipher.getBlockSize() == 16) {
            this.cipher = blockCipher;
            return;
        }
        throw new IllegalArgumentException("Poly1305 requires a 128 bit block cipher.");
    }

    private static final long mul32x32_64(int i11, int i12) {
        return (((long) i11) & 4294967295L) * ((long) i12);
    }

    private void processBlock() {
        int i11 = this.currentBlockOffset;
        if (i11 < 16) {
            this.currentBlock[i11] = 1;
            for (int i12 = i11 + 1; i12 < 16; i12++) {
                this.currentBlock[i12] = 0;
            }
        }
        long littleEndianToInt = ((long) Pack.littleEndianToInt(this.currentBlock, 0)) & 4294967295L;
        long littleEndianToInt2 = ((long) Pack.littleEndianToInt(this.currentBlock, 4)) & 4294967295L;
        long littleEndianToInt3 = ((long) Pack.littleEndianToInt(this.currentBlock, 8)) & 4294967295L;
        long littleEndianToInt4 = 4294967295L & ((long) Pack.littleEndianToInt(this.currentBlock, 12));
        int i13 = (int) (((long) this.f59204h0) + (littleEndianToInt & 67108863));
        this.f59204h0 = i13;
        this.f59205h1 = (int) (((long) this.f59205h1) + ((((littleEndianToInt2 << 32) | littleEndianToInt) >>> 26) & 67108863));
        this.f59206h2 = (int) (((long) this.f59206h2) + (((littleEndianToInt2 | (littleEndianToInt3 << 32)) >>> 20) & 67108863));
        this.f59207h3 = (int) (((long) this.f59207h3) + ((((littleEndianToInt4 << 32) | littleEndianToInt3) >>> 14) & 67108863));
        int i14 = (int) (((long) this.f59208h4) + (littleEndianToInt4 >>> 8));
        this.f59208h4 = i14;
        if (this.currentBlockOffset == 16) {
            this.f59208h4 = i14 + 16777216;
        }
        long mul32x32_64 = mul32x32_64(i13, this.f59213r0) + mul32x32_64(this.f59205h1, this.f59221s4) + mul32x32_64(this.f59206h2, this.f59220s3) + mul32x32_64(this.f59207h3, this.f59219s2) + mul32x32_64(this.f59208h4, this.f59218s1);
        long mul32x32_642 = mul32x32_64(this.f59204h0, this.f59214r1) + mul32x32_64(this.f59205h1, this.f59213r0) + mul32x32_64(this.f59206h2, this.f59221s4) + mul32x32_64(this.f59207h3, this.f59220s3) + mul32x32_64(this.f59208h4, this.f59219s2);
        long mul32x32_643 = mul32x32_64(this.f59204h0, this.f59215r2) + mul32x32_64(this.f59205h1, this.f59214r1) + mul32x32_64(this.f59206h2, this.f59213r0) + mul32x32_64(this.f59207h3, this.f59221s4) + mul32x32_64(this.f59208h4, this.f59220s3);
        long mul32x32_644 = mul32x32_64(this.f59204h0, this.f59216r3) + mul32x32_64(this.f59205h1, this.f59215r2) + mul32x32_64(this.f59206h2, this.f59214r1) + mul32x32_64(this.f59207h3, this.f59213r0) + mul32x32_64(this.f59208h4, this.f59221s4);
        long mul32x32_645 = mul32x32_64(this.f59204h0, this.f59217r4) + mul32x32_64(this.f59205h1, this.f59216r3) + mul32x32_64(this.f59206h2, this.f59215r2) + mul32x32_64(this.f59207h3, this.f59214r1) + mul32x32_64(this.f59208h4, this.f59213r0);
        int i15 = ((int) mul32x32_64) & 67108863;
        this.f59204h0 = i15;
        long j11 = mul32x32_642 + (mul32x32_64 >>> 26);
        int i16 = ((int) j11) & 67108863;
        this.f59205h1 = i16;
        long j12 = mul32x32_643 + (j11 >>> 26);
        this.f59206h2 = ((int) j12) & 67108863;
        long j13 = mul32x32_644 + (j12 >>> 26);
        this.f59207h3 = ((int) j13) & 67108863;
        long j14 = mul32x32_645 + (j13 >>> 26);
        this.f59208h4 = ((int) j14) & 67108863;
        int i17 = i15 + (((int) (j14 >>> 26)) * 5);
        this.f59204h0 = i17;
        this.f59205h1 = i16 + (i17 >>> 26);
        this.f59204h0 = i17 & 67108863;
    }

    private void setKey(byte[] bArr, byte[] bArr2) {
        if (bArr.length == 32) {
            int i11 = 16;
            if (this.cipher == null || (bArr2 != null && bArr2.length == 16)) {
                int littleEndianToInt = Pack.littleEndianToInt(bArr, 0);
                int littleEndianToInt2 = Pack.littleEndianToInt(bArr, 4);
                int littleEndianToInt3 = Pack.littleEndianToInt(bArr, 8);
                int littleEndianToInt4 = Pack.littleEndianToInt(bArr, 12);
                this.f59213r0 = 67108863 & littleEndianToInt;
                int i12 = ((littleEndianToInt >>> 26) | (littleEndianToInt2 << 6)) & 67108611;
                this.f59214r1 = i12;
                int i13 = ((littleEndianToInt2 >>> 20) | (littleEndianToInt3 << 12)) & 67092735;
                this.f59215r2 = i13;
                int i14 = ((littleEndianToInt3 >>> 14) | (littleEndianToInt4 << 18)) & 66076671;
                this.f59216r3 = i14;
                int i15 = (littleEndianToInt4 >>> 8) & 1048575;
                this.f59217r4 = i15;
                this.f59218s1 = i12 * 5;
                this.f59219s2 = i13 * 5;
                this.f59220s3 = i14 * 5;
                this.f59221s4 = i15 * 5;
                BlockCipher blockCipher = this.cipher;
                if (blockCipher != null) {
                    byte[] bArr3 = new byte[16];
                    blockCipher.init(true, new KeyParameter(bArr, 16, 16));
                    this.cipher.processBlock(bArr2, 0, bArr3, 0);
                    i11 = 0;
                    bArr = bArr3;
                }
                this.f59209k0 = Pack.littleEndianToInt(bArr, i11 + 0);
                this.f59210k1 = Pack.littleEndianToInt(bArr, i11 + 4);
                this.f59211k2 = Pack.littleEndianToInt(bArr, i11 + 8);
                this.f59212k3 = Pack.littleEndianToInt(bArr, i11 + 12);
                return;
            }
            throw new IllegalArgumentException("Poly1305 requires a 128 bit IV.");
        }
        throw new IllegalArgumentException("Poly1305 key must be 256 bits.");
    }

    public int doFinal(byte[] bArr, int i11) throws DataLengthException, IllegalStateException {
        if (i11 + 16 <= bArr.length) {
            if (this.currentBlockOffset > 0) {
                processBlock();
            }
            int i12 = this.f59205h1;
            int i13 = this.f59204h0;
            int i14 = i12 + (i13 >>> 26);
            this.f59205h1 = i14;
            int i15 = i13 & 67108863;
            this.f59204h0 = i15;
            int i16 = this.f59206h2 + (i14 >>> 26);
            this.f59206h2 = i16;
            int i17 = i14 & 67108863;
            this.f59205h1 = i17;
            int i18 = this.f59207h3 + (i16 >>> 26);
            this.f59207h3 = i18;
            int i19 = i16 & 67108863;
            this.f59206h2 = i19;
            int i21 = this.f59208h4 + (i18 >>> 26);
            this.f59208h4 = i21;
            int i22 = i18 & 67108863;
            this.f59207h3 = i22;
            int i23 = i15 + ((i21 >>> 26) * 5);
            this.f59204h0 = i23;
            int i24 = i21 & 67108863;
            this.f59208h4 = i24;
            int i25 = i17 + (i23 >>> 26);
            this.f59205h1 = i25;
            int i26 = i23 & 67108863;
            this.f59204h0 = i26;
            int i27 = i26 + 5;
            int i28 = (i27 >>> 26) + i25;
            int i29 = (i28 >>> 26) + i19;
            int i30 = (i29 >>> 26) + i22;
            int i31 = 67108863 & i30;
            int i32 = ((i30 >>> 26) + i24) - 67108864;
            int i33 = (i32 >>> 31) - 1;
            int i34 = ~i33;
            int i35 = (i26 & i34) | (i27 & 67108863 & i33);
            this.f59204h0 = i35;
            int i36 = (i25 & i34) | (i28 & 67108863 & i33);
            this.f59205h1 = i36;
            int i37 = (i19 & i34) | (i29 & 67108863 & i33);
            this.f59206h2 = i37;
            int i38 = (i31 & i33) | (i22 & i34);
            this.f59207h3 = i38;
            int i39 = (i24 & i34) | (i32 & i33);
            this.f59208h4 = i39;
            long j11 = (((long) (i35 | (i36 << 26))) & 4294967295L) + (((long) this.f59209k0) & 4294967295L);
            long j12 = (((long) ((i36 >>> 6) | (i37 << 20))) & 4294967295L) + (((long) this.f59210k1) & 4294967295L);
            long j13 = (((long) ((i37 >>> 12) | (i38 << 14))) & 4294967295L) + (((long) this.f59211k2) & 4294967295L);
            Pack.intToLittleEndian((int) j11, bArr, i11);
            long j14 = j12 + (j11 >>> 32);
            Pack.intToLittleEndian((int) j14, bArr, i11 + 4);
            long j15 = j13 + (j14 >>> 32);
            Pack.intToLittleEndian((int) j15, bArr, i11 + 8);
            Pack.intToLittleEndian((int) ((((long) ((i38 >>> 18) | (i39 << 8))) & 4294967295L) + (4294967295L & ((long) this.f59212k3)) + (j15 >>> 32)), bArr, i11 + 12);
            reset();
            return 16;
        }
        throw new OutputLengthException("Output buffer is too short.");
    }

    public String getAlgorithmName() {
        if (this.cipher == null) {
            return "Poly1305";
        }
        return "Poly1305-" + this.cipher.getAlgorithmName();
    }

    public int getMacSize() {
        return 16;
    }

    public void init(CipherParameters cipherParameters) throws IllegalArgumentException {
        byte[] bArr;
        if (this.cipher == null) {
            bArr = null;
        } else if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            bArr = parametersWithIV.getIV();
            cipherParameters = parametersWithIV.getParameters();
        } else {
            throw new IllegalArgumentException("Poly1305 requires an IV when used with a block cipher.");
        }
        if (cipherParameters instanceof KeyParameter) {
            setKey(((KeyParameter) cipherParameters).getKey(), bArr);
            reset();
            return;
        }
        throw new IllegalArgumentException("Poly1305 requires a key.");
    }

    public void reset() {
        this.currentBlockOffset = 0;
        this.f59208h4 = 0;
        this.f59207h3 = 0;
        this.f59206h2 = 0;
        this.f59205h1 = 0;
        this.f59204h0 = 0;
    }

    public void update(byte b11) throws IllegalStateException {
        byte[] bArr = this.singleByte;
        bArr[0] = b11;
        update(bArr, 0, 1);
    }

    public void update(byte[] bArr, int i11, int i12) throws DataLengthException, IllegalStateException {
        int i13 = 0;
        while (i12 > i13) {
            if (this.currentBlockOffset == 16) {
                processBlock();
                this.currentBlockOffset = 0;
            }
            int min = Math.min(i12 - i13, 16 - this.currentBlockOffset);
            System.arraycopy(bArr, i13 + i11, this.currentBlock, this.currentBlockOffset, min);
            i13 += min;
            this.currentBlockOffset += min;
        }
    }
}
