package org.bouncycastle.crypto.engines;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.MaxBytesExceededException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.SkippingStreamCipher;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.util.Integers;
import org.bouncycastle.util.Pack;
import org.bouncycastle.util.Strings;

public class Salsa20Engine implements SkippingStreamCipher {
    public static final int DEFAULT_ROUNDS = 20;
    private static final int STATE_SIZE = 16;
    private static final int[] TAU_SIGMA = Pack.littleEndianToInt(Strings.toByteArray("expand 16-byte kexpand 32-byte k"), 0, 8);
    public static final byte[] sigma = Strings.toByteArray("expand 32-byte k");
    public static final byte[] tau = Strings.toByteArray("expand 16-byte k");
    private int cW0;
    private int cW1;
    private int cW2;
    public int[] engineState;
    private int index;
    private boolean initialised;
    private byte[] keyStream;
    public int rounds;

    /* renamed from: x  reason: collision with root package name */
    public int[] f59185x;

    public Salsa20Engine() {
        this(20);
    }

    public Salsa20Engine(int i11) {
        this.index = 0;
        this.engineState = new int[16];
        this.f59185x = new int[16];
        this.keyStream = new byte[64];
        this.initialised = false;
        if (i11 <= 0 || (i11 & 1) != 0) {
            throw new IllegalArgumentException("'rounds' must be a positive, even number");
        }
        this.rounds = i11;
    }

    private boolean limitExceeded() {
        int i11 = this.cW0 + 1;
        this.cW0 = i11;
        if (i11 == 0) {
            int i12 = this.cW1 + 1;
            this.cW1 = i12;
            if (i12 == 0) {
                int i13 = this.cW2 + 1;
                this.cW2 = i13;
                return (i13 & 32) != 0;
            }
        }
        return false;
    }

    private boolean limitExceeded(int i11) {
        int i12 = this.cW0 + i11;
        this.cW0 = i12;
        if (i12 >= i11 || i12 < 0) {
            return false;
        }
        int i13 = this.cW1 + 1;
        this.cW1 = i13;
        if (i13 != 0) {
            return false;
        }
        int i14 = this.cW2 + 1;
        this.cW2 = i14;
        return (i14 & 32) != 0;
    }

    private void resetLimitCounter() {
        this.cW0 = 0;
        this.cW1 = 0;
        this.cW2 = 0;
    }

    public static void salsaCore(int i11, int[] iArr, int[] iArr2) {
        int[] iArr3 = iArr;
        int[] iArr4 = iArr2;
        if (iArr3.length != 16) {
            throw new IllegalArgumentException();
        } else if (iArr4.length != 16) {
            throw new IllegalArgumentException();
        } else if (i11 % 2 == 0) {
            boolean z11 = false;
            int i12 = iArr3[0];
            int i13 = iArr3[1];
            int i14 = iArr3[2];
            int i15 = iArr3[3];
            int i16 = iArr3[4];
            int i17 = iArr3[5];
            int i18 = iArr3[6];
            int i19 = 7;
            int i21 = iArr3[7];
            int i22 = iArr3[8];
            int i23 = 9;
            int i24 = iArr3[9];
            int i25 = iArr3[10];
            int i26 = iArr3[11];
            int i27 = iArr3[12];
            int i28 = 13;
            int i29 = iArr3[13];
            int i30 = iArr3[14];
            int i31 = iArr3[15];
            int i32 = i30;
            int i33 = i29;
            int i34 = i27;
            int i35 = i26;
            int i36 = i25;
            int i37 = i24;
            int i38 = i22;
            int i39 = i21;
            int i40 = i18;
            int i41 = i17;
            int i42 = i16;
            int i43 = i15;
            int i44 = i14;
            int i45 = i13;
            int i46 = i12;
            int i47 = i11;
            while (i47 > 0) {
                int rotateLeft = Integers.rotateLeft(i46 + i34, i19) ^ i42;
                int rotateLeft2 = i38 ^ Integers.rotateLeft(rotateLeft + i46, i23);
                int rotateLeft3 = i34 ^ Integers.rotateLeft(rotateLeft2 + rotateLeft, i28);
                int rotateLeft4 = Integers.rotateLeft(rotateLeft3 + rotateLeft2, 18) ^ i46;
                int rotateLeft5 = i37 ^ Integers.rotateLeft(i41 + i45, i19);
                int rotateLeft6 = i33 ^ Integers.rotateLeft(rotateLeft5 + i41, i23);
                int rotateLeft7 = i45 ^ Integers.rotateLeft(rotateLeft6 + rotateLeft5, i28);
                int rotateLeft8 = Integers.rotateLeft(rotateLeft7 + rotateLeft6, 18) ^ i41;
                int rotateLeft9 = i32 ^ Integers.rotateLeft(i36 + i40, 7);
                int rotateLeft10 = i44 ^ Integers.rotateLeft(rotateLeft9 + i36, 9);
                int rotateLeft11 = i40 ^ Integers.rotateLeft(rotateLeft10 + rotateLeft9, 13);
                int rotateLeft12 = i36 ^ Integers.rotateLeft(rotateLeft11 + rotateLeft10, 18);
                int rotateLeft13 = i43 ^ Integers.rotateLeft(i31 + i35, 7);
                int rotateLeft14 = i39 ^ Integers.rotateLeft(rotateLeft13 + i31, 9);
                int i48 = i47;
                int rotateLeft15 = i35 ^ Integers.rotateLeft(rotateLeft14 + rotateLeft13, 13);
                int i49 = rotateLeft6;
                int rotateLeft16 = i31 ^ Integers.rotateLeft(rotateLeft15 + rotateLeft14, 18);
                int i50 = rotateLeft3;
                i45 = rotateLeft7 ^ Integers.rotateLeft(rotateLeft4 + rotateLeft13, 7);
                i44 = rotateLeft10 ^ Integers.rotateLeft(i45 + rotateLeft4, 9);
                int rotateLeft17 = rotateLeft13 ^ Integers.rotateLeft(i44 + i45, 13);
                int rotateLeft18 = rotateLeft4 ^ Integers.rotateLeft(rotateLeft17 + i44, 18);
                i40 = rotateLeft11 ^ Integers.rotateLeft(rotateLeft8 + rotateLeft, 7);
                i39 = rotateLeft14 ^ Integers.rotateLeft(i40 + rotateLeft8, 9);
                int rotateLeft19 = Integers.rotateLeft(i39 + i40, 13) ^ rotateLeft;
                i41 = rotateLeft8 ^ Integers.rotateLeft(rotateLeft19 + i39, 18);
                i35 = rotateLeft15 ^ Integers.rotateLeft(rotateLeft12 + rotateLeft5, 7);
                int rotateLeft20 = Integers.rotateLeft(i35 + rotateLeft12, 9) ^ rotateLeft2;
                i37 = rotateLeft5 ^ Integers.rotateLeft(rotateLeft20 + i35, 13);
                i36 = rotateLeft12 ^ Integers.rotateLeft(i37 + rotateLeft20, 18);
                i34 = i50 ^ Integers.rotateLeft(rotateLeft16 + rotateLeft9, 7);
                i33 = i49 ^ Integers.rotateLeft(i34 + rotateLeft16, 9);
                i32 = rotateLeft9 ^ Integers.rotateLeft(i33 + i34, 13);
                i31 = rotateLeft16 ^ Integers.rotateLeft(i32 + i33, 18);
                i43 = rotateLeft17;
                i38 = rotateLeft20;
                i46 = rotateLeft18;
                i42 = rotateLeft19;
                z11 = false;
                i28 = 13;
                i23 = 9;
                i19 = 7;
                int[] iArr5 = iArr;
                i47 = i48 - 2;
                int[] iArr6 = iArr2;
            }
            char c11 = z11;
            iArr2[c11] = i46 + iArr[c11];
            iArr2[1] = i45 + iArr[1];
            iArr2[2] = i44 + iArr[2];
            iArr2[3] = i43 + iArr[3];
            iArr2[4] = i42 + iArr[4];
            iArr2[5] = i41 + iArr[5];
            iArr2[6] = i40 + iArr[6];
            iArr2[7] = i39 + iArr[7];
            iArr2[8] = i38 + iArr[8];
            iArr2[9] = i37 + iArr[9];
            iArr2[10] = i36 + iArr[10];
            iArr2[11] = i35 + iArr[11];
            iArr2[12] = i34 + iArr[12];
            iArr2[13] = i33 + iArr[13];
            iArr2[14] = i32 + iArr[14];
            iArr2[15] = i31 + iArr[15];
        } else {
            throw new IllegalArgumentException("Number of rounds must be even");
        }
    }

    public void advanceCounter() {
        int[] iArr = this.engineState;
        int i11 = iArr[8] + 1;
        iArr[8] = i11;
        if (i11 == 0) {
            iArr[9] = iArr[9] + 1;
        }
    }

    public void advanceCounter(long j11) {
        int i11 = (int) (j11 >>> 32);
        int i12 = (int) j11;
        if (i11 > 0) {
            int[] iArr = this.engineState;
            iArr[9] = iArr[9] + i11;
        }
        int[] iArr2 = this.engineState;
        int i13 = iArr2[8];
        iArr2[8] = iArr2[8] + i12;
        if (i13 != 0 && iArr2[8] < i13) {
            iArr2[9] = iArr2[9] + 1;
        }
    }

    public void generateKeyStream(byte[] bArr) {
        salsaCore(this.rounds, this.engineState, this.f59185x);
        Pack.intToLittleEndian(this.f59185x, bArr, 0);
    }

    public String getAlgorithmName() {
        if (this.rounds == 20) {
            return "Salsa20";
        }
        return "Salsa20" + "/" + this.rounds;
    }

    public long getCounter() {
        int[] iArr = this.engineState;
        return (((long) iArr[9]) << 32) | (((long) iArr[8]) & 4294967295L);
    }

    public int getNonceSize() {
        return 8;
    }

    public long getPosition() {
        return (getCounter() * 64) + ((long) this.index);
    }

    public void init(boolean z11, CipherParameters cipherParameters) {
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            byte[] iv2 = parametersWithIV.getIV();
            if (iv2 == null || iv2.length != getNonceSize()) {
                throw new IllegalArgumentException(getAlgorithmName() + " requires exactly " + getNonceSize() + " bytes of IV");
            }
            CipherParameters parameters = parametersWithIV.getParameters();
            if (parameters == null) {
                if (this.initialised) {
                    setKey((byte[]) null, iv2);
                } else {
                    throw new IllegalStateException(getAlgorithmName() + " KeyParameter can not be null for first initialisation");
                }
            } else if (parameters instanceof KeyParameter) {
                setKey(((KeyParameter) parameters).getKey(), iv2);
            } else {
                throw new IllegalArgumentException(getAlgorithmName() + " Init parameters must contain a KeyParameter (or null for re-init)");
            }
            reset();
            this.initialised = true;
            return;
        }
        throw new IllegalArgumentException(getAlgorithmName() + " Init parameters must include an IV");
    }

    public void packTauOrSigma(int i11, int[] iArr, int i12) {
        int i13 = (i11 - 16) / 4;
        int[] iArr2 = TAU_SIGMA;
        iArr[i12] = iArr2[i13];
        iArr[i12 + 1] = iArr2[i13 + 1];
        iArr[i12 + 2] = iArr2[i13 + 2];
        iArr[i12 + 3] = iArr2[i13 + 3];
    }

    public int processBytes(byte[] bArr, int i11, int i12, byte[] bArr2, int i13) {
        if (!this.initialised) {
            throw new IllegalStateException(getAlgorithmName() + " not initialised");
        } else if (i11 + i12 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i13 + i12 > bArr2.length) {
            throw new OutputLengthException("output buffer too short");
        } else if (!limitExceeded(i12)) {
            for (int i14 = 0; i14 < i12; i14++) {
                byte[] bArr3 = this.keyStream;
                int i15 = this.index;
                bArr2[i14 + i13] = (byte) (bArr3[i15] ^ bArr[i14 + i11]);
                int i16 = (i15 + 1) & 63;
                this.index = i16;
                if (i16 == 0) {
                    advanceCounter();
                    generateKeyStream(this.keyStream);
                }
            }
            return i12;
        } else {
            throw new MaxBytesExceededException("2^70 byte limit per IV would be exceeded; Change IV");
        }
    }

    public void reset() {
        this.index = 0;
        resetLimitCounter();
        resetCounter();
        generateKeyStream(this.keyStream);
    }

    public void resetCounter() {
        int[] iArr = this.engineState;
        iArr[9] = 0;
        iArr[8] = 0;
    }

    public void retreatCounter() {
        int[] iArr = this.engineState;
        if (iArr[8] == 0 && iArr[9] == 0) {
            throw new IllegalStateException("attempt to reduce counter past zero.");
        }
        int i11 = iArr[8] - 1;
        iArr[8] = i11;
        if (i11 == -1) {
            iArr[9] = iArr[9] - 1;
        }
    }

    public void retreatCounter(long j11) {
        int i11 = (int) (j11 >>> 32);
        int i12 = (int) j11;
        if (i11 != 0) {
            int[] iArr = this.engineState;
            if ((((long) iArr[9]) & 4294967295L) >= (((long) i11) & 4294967295L)) {
                iArr[9] = iArr[9] - i11;
            } else {
                throw new IllegalStateException("attempt to reduce counter past zero.");
            }
        }
        int[] iArr2 = this.engineState;
        if ((((long) iArr2[8]) & 4294967295L) >= (4294967295L & ((long) i12))) {
            iArr2[8] = iArr2[8] - i12;
        } else if (iArr2[9] != 0) {
            iArr2[9] = iArr2[9] - 1;
            iArr2[8] = iArr2[8] - i12;
        } else {
            throw new IllegalStateException("attempt to reduce counter past zero.");
        }
    }

    public byte returnByte(byte b11) {
        if (!limitExceeded()) {
            byte[] bArr = this.keyStream;
            int i11 = this.index;
            byte b12 = (byte) (b11 ^ bArr[i11]);
            int i12 = (i11 + 1) & 63;
            this.index = i12;
            if (i12 == 0) {
                advanceCounter();
                generateKeyStream(this.keyStream);
            }
            return b12;
        }
        throw new MaxBytesExceededException("2^70 byte limit per IV; Change IV");
    }

    public long seekTo(long j11) {
        reset();
        return skip(j11);
    }

    public void setKey(byte[] bArr, byte[] bArr2) {
        if (bArr != null) {
            if (bArr.length == 16 || bArr.length == 32) {
                int length = (bArr.length - 16) / 4;
                int[] iArr = this.engineState;
                int[] iArr2 = TAU_SIGMA;
                iArr[0] = iArr2[length];
                iArr[5] = iArr2[length + 1];
                iArr[10] = iArr2[length + 2];
                iArr[15] = iArr2[length + 3];
                Pack.littleEndianToInt(bArr, 0, iArr, 1, 4);
                Pack.littleEndianToInt(bArr, bArr.length - 16, this.engineState, 11, 4);
            } else {
                throw new IllegalArgumentException(getAlgorithmName() + " requires 128 bit or 256 bit key");
            }
        }
        Pack.littleEndianToInt(bArr2, 0, this.engineState, 6, 2);
    }

    public long skip(long j11) {
        long j12;
        if (j11 >= 0) {
            if (j11 >= 64) {
                long j13 = j11 / 64;
                advanceCounter(j13);
                j12 = j11 - (j13 * 64);
            } else {
                j12 = j11;
            }
            int i11 = this.index;
            int i12 = (((int) j12) + i11) & 63;
            this.index = i12;
            if (i12 < i11) {
                advanceCounter();
            }
        } else {
            long j14 = -j11;
            if (j14 >= 64) {
                long j15 = j14 / 64;
                retreatCounter(j15);
                j14 -= j15 * 64;
            }
            for (long j16 = 0; j16 < j14; j16++) {
                if (this.index == 0) {
                    retreatCounter();
                }
                this.index = (this.index - 1) & 63;
            }
        }
        generateKeyStream(this.keyStream);
        return j11;
    }
}
