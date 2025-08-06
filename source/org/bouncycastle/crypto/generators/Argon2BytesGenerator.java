package org.bouncycastle.crypto.generators;

import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.Blake2bDigest;
import org.bouncycastle.crypto.params.Argon2Parameters;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Longs;
import org.bouncycastle.util.Pack;

public class Argon2BytesGenerator {
    private static final int ARGON2_ADDRESSES_IN_BLOCK = 128;
    private static final int ARGON2_BLOCK_SIZE = 1024;
    private static final int ARGON2_PREHASH_DIGEST_LENGTH = 64;
    private static final int ARGON2_PREHASH_SEED_LENGTH = 72;
    private static final int ARGON2_QWORDS_IN_BLOCK = 128;
    private static final int ARGON2_SYNC_POINTS = 4;
    private static final long M32L = 4294967295L;
    private static final int MAX_PARALLELISM = 16777216;
    private static final int MIN_ITERATIONS = 1;
    private static final int MIN_OUTLEN = 4;
    private static final int MIN_PARALLELISM = 1;
    private static final byte[] ZERO_BYTES = new byte[4];
    private int laneLength;
    private Block[] memory;
    private Argon2Parameters parameters;
    private int segmentLength;

    public static class Block {
        private static final int SIZE = 128;
        /* access modifiers changed from: private */

        /* renamed from: v  reason: collision with root package name */
        public final long[] f59191v;

        private Block() {
            this.f59191v = new long[128];
        }

        /* access modifiers changed from: private */
        public void copyBlock(Block block) {
            System.arraycopy(block.f59191v, 0, this.f59191v, 0, 128);
        }

        /* access modifiers changed from: private */
        public void xor(Block block, Block block2) {
            long[] jArr = this.f59191v;
            long[] jArr2 = block.f59191v;
            long[] jArr3 = block2.f59191v;
            for (int i11 = 0; i11 < 128; i11++) {
                jArr[i11] = jArr2[i11] ^ jArr3[i11];
            }
        }

        /* access modifiers changed from: private */
        public void xorWith(Block block) {
            long[] jArr = this.f59191v;
            long[] jArr2 = block.f59191v;
            for (int i11 = 0; i11 < 128; i11++) {
                jArr[i11] = jArr[i11] ^ jArr2[i11];
            }
        }

        /* access modifiers changed from: private */
        public void xorWith(Block block, Block block2) {
            long[] jArr = this.f59191v;
            long[] jArr2 = block.f59191v;
            long[] jArr3 = block2.f59191v;
            for (int i11 = 0; i11 < 128; i11++) {
                jArr[i11] = jArr[i11] ^ (jArr2[i11] ^ jArr3[i11]);
            }
        }

        public Block clear() {
            Arrays.fill(this.f59191v, 0);
            return this;
        }

        public void fromBytes(byte[] bArr) {
            if (bArr.length >= 1024) {
                Pack.littleEndianToLong(bArr, 0, this.f59191v);
                return;
            }
            throw new IllegalArgumentException("input shorter than blocksize");
        }

        public void toBytes(byte[] bArr) {
            if (bArr.length >= 1024) {
                Pack.longToLittleEndian(this.f59191v, bArr, 0);
                return;
            }
            throw new IllegalArgumentException("output shorter than blocksize");
        }
    }

    public static class FillBlock {
        public Block R;
        public Block Z;
        public Block addressBlock;
        public Block inputBlock;

        private FillBlock() {
            this.R = new Block();
            this.Z = new Block();
            this.addressBlock = new Block();
            this.inputBlock = new Block();
        }

        private void applyBlake() {
            for (int i11 = 0; i11 < 8; i11++) {
                int i12 = i11 * 16;
                Argon2BytesGenerator.roundFunction(this.Z, i12, i12 + 1, i12 + 2, i12 + 3, i12 + 4, i12 + 5, i12 + 6, i12 + 7, i12 + 8, i12 + 9, i12 + 10, i12 + 11, i12 + 12, i12 + 13, i12 + 14, i12 + 15);
            }
            for (int i13 = 0; i13 < 8; i13++) {
                int i14 = i13 * 2;
                Argon2BytesGenerator.roundFunction(this.Z, i14, i14 + 1, i14 + 16, i14 + 17, i14 + 32, i14 + 33, i14 + 48, i14 + 49, i14 + 64, i14 + 65, i14 + 80, i14 + 81, i14 + 96, i14 + 97, i14 + 112, i14 + 113);
            }
        }

        /* access modifiers changed from: private */
        public void fillBlock(Block block, Block block2) {
            this.Z.copyBlock(block);
            applyBlake();
            block2.xor(block, this.Z);
        }

        /* access modifiers changed from: private */
        public void fillBlock(Block block, Block block2, Block block3) {
            this.R.xor(block, block2);
            this.Z.copyBlock(this.R);
            applyBlake();
            block3.xor(this.R, this.Z);
        }

        /* access modifiers changed from: private */
        public void fillBlockWithXor(Block block, Block block2, Block block3) {
            this.R.xor(block, block2);
            this.Z.copyBlock(this.R);
            applyBlake();
            block3.xorWith(this.R, this.Z);
        }
    }

    public static class Position {
        public int lane;
        public int pass;
        public int slice;
    }

    private static void F(long[] jArr, int i11, int i12, int i13, int i14) {
        quarterRound(jArr, i11, i12, i14, 32);
        quarterRound(jArr, i13, i14, i12, 24);
        quarterRound(jArr, i11, i12, i14, 16);
        quarterRound(jArr, i13, i14, i12, 63);
    }

    private static void addByteString(byte[] bArr, Digest digest, byte[] bArr2) {
        if (bArr2 == null) {
            digest.update(ZERO_BYTES, 0, 4);
            return;
        }
        Pack.intToLittleEndian(bArr2.length, bArr, 0);
        digest.update(bArr, 0, 4);
        digest.update(bArr2, 0, bArr2.length);
    }

    private void digest(byte[] bArr, byte[] bArr2, int i11, int i12) {
        Block block = this.memory[this.laneLength - 1];
        for (int i13 = 1; i13 < this.parameters.getLanes(); i13++) {
            int i14 = this.laneLength;
            block.xorWith(this.memory[(i13 * i14) + (i14 - 1)]);
        }
        block.toBytes(bArr);
        hash(bArr, bArr2, i11, i12);
    }

    private void doInit(Argon2Parameters argon2Parameters) {
        int memory2 = argon2Parameters.getMemory();
        if (memory2 < argon2Parameters.getLanes() * 8) {
            memory2 = argon2Parameters.getLanes() * 8;
        }
        int lanes = memory2 / (argon2Parameters.getLanes() * 4);
        this.segmentLength = lanes;
        this.laneLength = lanes * 4;
        initMemory(lanes * argon2Parameters.getLanes() * 4);
    }

    private void fillFirstBlocks(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[72];
        System.arraycopy(bArr2, 0, bArr3, 0, 64);
        bArr3[64] = 1;
        for (int i11 = 0; i11 < this.parameters.getLanes(); i11++) {
            Pack.intToLittleEndian(i11, bArr2, 68);
            Pack.intToLittleEndian(i11, bArr3, 68);
            hash(bArr2, bArr, 0, 1024);
            this.memory[(this.laneLength * i11) + 0].fromBytes(bArr);
            hash(bArr3, bArr, 0, 1024);
            this.memory[(this.laneLength * i11) + 1].fromBytes(bArr);
        }
    }

    private void fillMemoryBlocks() {
        FillBlock fillBlock = new FillBlock();
        Position position = new Position();
        for (int i11 = 0; i11 < this.parameters.getIterations(); i11++) {
            position.pass = i11;
            for (int i12 = 0; i12 < 4; i12++) {
                position.slice = i12;
                for (int i13 = 0; i13 < this.parameters.getLanes(); i13++) {
                    position.lane = i13;
                    fillSegment(fillBlock, position);
                }
            }
        }
    }

    private void fillSegment(FillBlock fillBlock, Position position) {
        Block block;
        Block block2;
        FillBlock fillBlock2 = fillBlock;
        Position position2 = position;
        boolean isDataIndependentAddressing = isDataIndependentAddressing(position2);
        int startingIndex = getStartingIndex(position);
        int i11 = (position2.lane * this.laneLength) + (position2.slice * this.segmentLength) + startingIndex;
        int prevOffset = getPrevOffset(i11);
        if (isDataIndependentAddressing) {
            Block clear = fillBlock2.addressBlock.clear();
            Block clear2 = fillBlock2.inputBlock.clear();
            initAddressBlocks(fillBlock2, position2, clear2, clear);
            block2 = clear;
            block = clear2;
        } else {
            block2 = null;
            block = null;
        }
        boolean isWithXor = isWithXor(position2);
        int i12 = startingIndex;
        int i13 = i11;
        int i14 = prevOffset;
        while (i12 < this.segmentLength) {
            long pseudoRandom = getPseudoRandom(fillBlock, i12, block2, block, i14, isDataIndependentAddressing);
            int refLane = getRefLane(position2, pseudoRandom);
            int refColumn = getRefColumn(position, i12, pseudoRandom, refLane == position2.lane);
            Block[] blockArr = this.memory;
            Block block3 = blockArr[i14];
            Block block4 = blockArr[(this.laneLength * refLane) + refColumn];
            Block block5 = blockArr[i13];
            if (isWithXor) {
                fillBlock2.fillBlockWithXor(block3, block4, block5);
            } else {
                fillBlock2.fillBlock(block3, block4, block5);
            }
            i12++;
            i14 = i13;
            i13++;
        }
    }

    private int getPrevOffset(int i11) {
        int i12 = this.laneLength;
        return i11 % i12 == 0 ? (i11 + i12) - 1 : i11 - 1;
    }

    private long getPseudoRandom(FillBlock fillBlock, int i11, Block block, Block block2, int i12, boolean z11) {
        if (!z11) {
            return this.memory[i12].f59191v[0];
        }
        int i13 = i11 % 128;
        if (i13 == 0) {
            nextAddresses(fillBlock, block2, block);
        }
        return block.f59191v[i13];
    }

    private int getRefColumn(Position position, int i11, long j11, boolean z11) {
        int i12;
        int i13;
        int i14 = position.pass;
        int i15 = -1;
        int i16 = 0;
        int i17 = position.slice;
        if (i14 != 0) {
            int i18 = this.segmentLength;
            int i19 = this.laneLength;
            int i21 = ((i17 + 1) * i18) % i19;
            int i22 = i19 - i18;
            if (z11) {
                i13 = (i22 + i11) - 1;
            } else {
                if (i11 != 0) {
                    i15 = 0;
                }
                i13 = i22 + i15;
            }
            i16 = i21;
            i12 = i13;
        } else if (z11) {
            i12 = ((i17 * this.segmentLength) + i11) - 1;
        } else {
            int i23 = i17 * this.segmentLength;
            if (i11 != 0) {
                i15 = 0;
            }
            i12 = i23 + i15;
        }
        long j12 = j11 & 4294967295L;
        return ((int) (((long) i16) + (((long) (i12 - 1)) - ((((long) i12) * ((j12 * j12) >>> 32)) >>> 32)))) % this.laneLength;
    }

    private int getRefLane(Position position, long j11) {
        int lanes = (int) ((j11 >>> 32) % ((long) this.parameters.getLanes()));
        return (position.pass == 0 && position.slice == 0) ? position.lane : lanes;
    }

    private static int getStartingIndex(Position position) {
        return (position.pass == 0 && position.slice == 0) ? 2 : 0;
    }

    private void hash(byte[] bArr, byte[] bArr2, int i11, int i12) {
        byte[] bArr3 = new byte[4];
        Pack.intToLittleEndian(i12, bArr3, 0);
        if (i12 <= 64) {
            Blake2bDigest blake2bDigest = new Blake2bDigest(i12 * 8);
            blake2bDigest.update(bArr3, 0, 4);
            blake2bDigest.update(bArr, 0, bArr.length);
            blake2bDigest.doFinal(bArr2, i11);
            return;
        }
        Blake2bDigest blake2bDigest2 = new Blake2bDigest(512);
        byte[] bArr4 = new byte[64];
        blake2bDigest2.update(bArr3, 0, 4);
        blake2bDigest2.update(bArr, 0, bArr.length);
        blake2bDigest2.doFinal(bArr4, 0);
        System.arraycopy(bArr4, 0, bArr2, i11, 32);
        int i13 = i11 + 32;
        int i14 = 2;
        int i15 = ((i12 + 31) / 32) - 2;
        while (i14 <= i15) {
            blake2bDigest2.update(bArr4, 0, 64);
            blake2bDigest2.doFinal(bArr4, 0);
            System.arraycopy(bArr4, 0, bArr2, i13, 32);
            i14++;
            i13 += 32;
        }
        Blake2bDigest blake2bDigest3 = new Blake2bDigest((i12 - (i15 * 32)) * 8);
        blake2bDigest3.update(bArr4, 0, 64);
        blake2bDigest3.doFinal(bArr2, i13);
    }

    private void initAddressBlocks(FillBlock fillBlock, Position position, Block block, Block block2) {
        block.f59191v[0] = intToLong(position.pass);
        block.f59191v[1] = intToLong(position.lane);
        block.f59191v[2] = intToLong(position.slice);
        block.f59191v[3] = intToLong(this.memory.length);
        block.f59191v[4] = intToLong(this.parameters.getIterations());
        block.f59191v[5] = intToLong(this.parameters.getType());
        if (position.pass == 0 && position.slice == 0) {
            nextAddresses(fillBlock, block, block2);
        }
    }

    private void initMemory(int i11) {
        this.memory = new Block[i11];
        int i12 = 0;
        while (true) {
            Block[] blockArr = this.memory;
            if (i12 < blockArr.length) {
                blockArr[i12] = new Block();
                i12++;
            } else {
                return;
            }
        }
    }

    private void initialize(byte[] bArr, byte[] bArr2, int i11) {
        Blake2bDigest blake2bDigest = new Blake2bDigest(512);
        Pack.intToLittleEndian(new int[]{this.parameters.getLanes(), i11, this.parameters.getMemory(), this.parameters.getIterations(), this.parameters.getVersion(), this.parameters.getType()}, bArr, 0);
        blake2bDigest.update(bArr, 0, 24);
        addByteString(bArr, blake2bDigest, bArr2);
        addByteString(bArr, blake2bDigest, this.parameters.getSalt());
        addByteString(bArr, blake2bDigest, this.parameters.getSecret());
        addByteString(bArr, blake2bDigest, this.parameters.getAdditional());
        byte[] bArr3 = new byte[72];
        blake2bDigest.doFinal(bArr3, 0);
        fillFirstBlocks(bArr, bArr3);
    }

    private long intToLong(int i11) {
        return ((long) i11) & 4294967295L;
    }

    private boolean isDataIndependentAddressing(Position position) {
        if (this.parameters.getType() != 1) {
            return this.parameters.getType() == 2 && position.pass == 0 && position.slice < 2;
        }
        return true;
    }

    private boolean isWithXor(Position position) {
        return (position.pass == 0 || this.parameters.getVersion() == 16) ? false : true;
    }

    private void nextAddresses(FillBlock fillBlock, Block block, Block block2) {
        long[] access$400 = block.f59191v;
        access$400[6] = access$400[6] + 1;
        fillBlock.fillBlock(block, block2);
        fillBlock.fillBlock(block2, block2);
    }

    private static void quarterRound(long[] jArr, int i11, int i12, int i13, int i14) {
        long j11 = jArr[i11];
        long j12 = jArr[i12];
        long j13 = j11 + j12 + ((j11 & 4294967295L) * 2 * (4294967295L & j12));
        long rotateRight = Longs.rotateRight(jArr[i13] ^ j13, i14);
        jArr[i11] = j13;
        jArr[i13] = rotateRight;
    }

    private void reset() {
        if (this.memory != null) {
            int i11 = 0;
            while (true) {
                Block[] blockArr = this.memory;
                if (i11 < blockArr.length) {
                    Block block = blockArr[i11];
                    if (block != null) {
                        block.clear();
                    }
                    i11++;
                } else {
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static void roundFunction(Block block, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i21, int i22, int i23, int i24, int i25, int i26, int i27) {
        int i28 = i11;
        int i29 = i12;
        int i30 = i13;
        int i31 = i14;
        int i32 = i16;
        int i33 = i17;
        int i34 = i18;
        int i35 = i19;
        int i36 = i21;
        int i37 = i22;
        int i38 = i23;
        int i39 = i24;
        int i40 = i25;
        int i41 = i26;
        int i42 = i27;
        long[] access$400 = block.f59191v;
        F(access$400, i28, i15, i35, i39);
        F(access$400, i29, i32, i36, i40);
        F(access$400, i30, i33, i37, i41);
        long[] jArr = access$400;
        int i43 = i14;
        F(jArr, i43, i34, i38, i42);
        F(jArr, i28, i32, i37, i42);
        F(jArr, i29, i33, i38, i39);
        F(jArr, i30, i34, i35, i40);
        F(jArr, i43, i15, i36, i41);
    }

    public int generateBytes(byte[] bArr, byte[] bArr2) {
        return generateBytes(bArr, bArr2, 0, bArr2.length);
    }

    public int generateBytes(byte[] bArr, byte[] bArr2, int i11, int i12) {
        if (i12 >= 4) {
            byte[] bArr3 = new byte[1024];
            initialize(bArr3, bArr, i12);
            fillMemoryBlocks();
            digest(bArr3, bArr2, i11, i12);
            reset();
            return i12;
        }
        throw new IllegalStateException("output length less than 4");
    }

    public int generateBytes(char[] cArr, byte[] bArr) {
        return generateBytes(this.parameters.getCharToByteConverter().convert(cArr), bArr);
    }

    public int generateBytes(char[] cArr, byte[] bArr, int i11, int i12) {
        return generateBytes(this.parameters.getCharToByteConverter().convert(cArr), bArr, i11, i12);
    }

    public void init(Argon2Parameters argon2Parameters) {
        this.parameters = argon2Parameters;
        if (argon2Parameters.getLanes() < 1) {
            throw new IllegalStateException("lanes must be greater than 1");
        } else if (argon2Parameters.getLanes() > 16777216) {
            throw new IllegalStateException("lanes must be less than 16777216");
        } else if (argon2Parameters.getMemory() < argon2Parameters.getLanes() * 2) {
            throw new IllegalStateException("memory is less than: " + (argon2Parameters.getLanes() * 2) + " expected " + (argon2Parameters.getLanes() * 2));
        } else if (argon2Parameters.getIterations() >= 1) {
            doInit(argon2Parameters);
        } else {
            throw new IllegalStateException("iterations is less than: 1");
        }
    }
}
