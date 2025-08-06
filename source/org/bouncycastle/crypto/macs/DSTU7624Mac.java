package org.bouncycastle.crypto.macs;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.engines.DSTU7624Engine;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.util.Arrays;

public class DSTU7624Mac implements Mac {
    private static final int BITS_IN_BYTE = 8;
    private int blockSize;
    private byte[] buf;
    private int bufOff;

    /* renamed from: c  reason: collision with root package name */
    private byte[] f59203c;
    private byte[] cTemp;
    private DSTU7624Engine engine;
    private boolean initCalled = false;
    private byte[] kDelta;
    private int macSize;

    public DSTU7624Mac(int i11, int i12) {
        this.engine = new DSTU7624Engine(i11);
        int i13 = i11 / 8;
        this.blockSize = i13;
        this.macSize = i12 / 8;
        this.f59203c = new byte[i13];
        this.kDelta = new byte[i13];
        this.cTemp = new byte[i13];
        this.buf = new byte[i13];
    }

    private void processBlock(byte[] bArr, int i11) {
        xor(this.f59203c, 0, bArr, i11, this.cTemp);
        this.engine.processBlock(this.cTemp, 0, this.f59203c, 0);
    }

    private void xor(byte[] bArr, int i11, byte[] bArr2, int i12, byte[] bArr3) {
        int length = bArr.length - i11;
        int i13 = this.blockSize;
        if (length < i13 || bArr2.length - i12 < i13 || bArr3.length < i13) {
            throw new IllegalArgumentException("some of input buffers too short");
        }
        for (int i14 = 0; i14 < this.blockSize; i14++) {
            bArr3[i14] = (byte) (bArr[i14 + i11] ^ bArr2[i14 + i12]);
        }
    }

    public int doFinal(byte[] bArr, int i11) throws DataLengthException, IllegalStateException {
        int i12 = this.bufOff;
        byte[] bArr2 = this.buf;
        if (i12 % bArr2.length == 0) {
            xor(this.f59203c, 0, bArr2, 0, this.cTemp);
            xor(this.cTemp, 0, this.kDelta, 0, this.f59203c);
            DSTU7624Engine dSTU7624Engine = this.engine;
            byte[] bArr3 = this.f59203c;
            dSTU7624Engine.processBlock(bArr3, 0, bArr3, 0);
            int i13 = this.macSize;
            if (i13 + i11 <= bArr.length) {
                System.arraycopy(this.f59203c, 0, bArr, i11, i13);
                reset();
                return this.macSize;
            }
            throw new OutputLengthException("output buffer too short");
        }
        throw new DataLengthException("input must be a multiple of blocksize");
    }

    public String getAlgorithmName() {
        return "DSTU7624Mac";
    }

    public int getMacSize() {
        return this.macSize;
    }

    public void init(CipherParameters cipherParameters) throws IllegalArgumentException {
        if (cipherParameters instanceof KeyParameter) {
            this.engine.init(true, cipherParameters);
            this.initCalled = true;
            reset();
            return;
        }
        throw new IllegalArgumentException("Invalid parameter passed to DSTU7624Mac");
    }

    public void reset() {
        Arrays.fill(this.f59203c, (byte) 0);
        Arrays.fill(this.cTemp, (byte) 0);
        Arrays.fill(this.kDelta, (byte) 0);
        Arrays.fill(this.buf, (byte) 0);
        this.engine.reset();
        if (this.initCalled) {
            DSTU7624Engine dSTU7624Engine = this.engine;
            byte[] bArr = this.kDelta;
            dSTU7624Engine.processBlock(bArr, 0, bArr, 0);
        }
        this.bufOff = 0;
    }

    public void update(byte b11) {
        int i11 = this.bufOff;
        byte[] bArr = this.buf;
        if (i11 == bArr.length) {
            processBlock(bArr, 0);
            this.bufOff = 0;
        }
        byte[] bArr2 = this.buf;
        int i12 = this.bufOff;
        this.bufOff = i12 + 1;
        bArr2[i12] = b11;
    }

    public void update(byte[] bArr, int i11, int i12) {
        if (i12 >= 0) {
            int blockSize2 = this.engine.getBlockSize();
            int i13 = this.bufOff;
            int i14 = blockSize2 - i13;
            if (i12 > i14) {
                System.arraycopy(bArr, i11, this.buf, i13, i14);
                processBlock(this.buf, 0);
                this.bufOff = 0;
                i12 -= i14;
                i11 += i14;
                while (i12 > blockSize2) {
                    processBlock(bArr, i11);
                    i12 -= blockSize2;
                    i11 += blockSize2;
                }
            }
            System.arraycopy(bArr, i11, this.buf, this.bufOff, i12);
            this.bufOff += i12;
            return;
        }
        throw new IllegalArgumentException("can't have a negative input length!");
    }
}
