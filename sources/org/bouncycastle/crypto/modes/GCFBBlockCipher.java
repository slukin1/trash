package org.bouncycastle.crypto.modes;

import com.google.common.base.Ascii;
import net.sf.scuba.smartcards.ISO7816;
import net.sf.scuba.smartcards.ISOFileInfo;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.StreamBlockCipher;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.crypto.params.ParametersWithSBox;

public class GCFBBlockCipher extends StreamBlockCipher {
    private static final byte[] C = {105, 0, 114, ISO7816.INS_MSE, 100, -55, 4, 35, ISOFileInfo.ENV_TEMP_EF, 58, -37, -106, 70, -23, ISO7816.INS_PSO, -60, Ascii.CAN, -2, -84, -108, 0, -19, 7, 18, ISO7816.INS_GET_RESPONSE, -122, ISO7816.INS_UPDATE_RECORD, ISO7816.INS_ENVELOPE, -17, 76, -87, 43};
    private final CFBBlockCipher cfbEngine;
    private long counter = 0;
    private boolean forEncryption;
    private KeyParameter key;

    public GCFBBlockCipher(BlockCipher blockCipher) {
        super(blockCipher);
        this.cfbEngine = new CFBBlockCipher(blockCipher, blockCipher.getBlockSize() * 8);
    }

    public byte calculateByte(byte b11) {
        long j11 = this.counter;
        if (j11 > 0 && j11 % 1024 == 0) {
            BlockCipher underlyingCipher = this.cfbEngine.getUnderlyingCipher();
            underlyingCipher.init(false, this.key);
            byte[] bArr = new byte[32];
            byte[] bArr2 = C;
            underlyingCipher.processBlock(bArr2, 0, bArr, 0);
            underlyingCipher.processBlock(bArr2, 8, bArr, 8);
            underlyingCipher.processBlock(bArr2, 16, bArr, 16);
            underlyingCipher.processBlock(bArr2, 24, bArr, 24);
            KeyParameter keyParameter = new KeyParameter(bArr);
            this.key = keyParameter;
            underlyingCipher.init(true, keyParameter);
            byte[] currentIV = this.cfbEngine.getCurrentIV();
            underlyingCipher.processBlock(currentIV, 0, currentIV, 0);
            this.cfbEngine.init(this.forEncryption, new ParametersWithIV(this.key, currentIV));
        }
        this.counter++;
        return this.cfbEngine.calculateByte(b11);
    }

    public String getAlgorithmName() {
        String algorithmName = this.cfbEngine.getAlgorithmName();
        return algorithmName.substring(0, algorithmName.indexOf(47)) + "/G" + algorithmName.substring(algorithmName.indexOf(47) + 1);
    }

    public int getBlockSize() {
        return this.cfbEngine.getBlockSize();
    }

    public void init(boolean z11, CipherParameters cipherParameters) throws IllegalArgumentException {
        this.counter = 0;
        this.cfbEngine.init(z11, cipherParameters);
        this.forEncryption = z11;
        if (cipherParameters instanceof ParametersWithIV) {
            cipherParameters = ((ParametersWithIV) cipherParameters).getParameters();
        }
        if (cipherParameters instanceof ParametersWithRandom) {
            cipherParameters = ((ParametersWithRandom) cipherParameters).getParameters();
        }
        if (cipherParameters instanceof ParametersWithSBox) {
            cipherParameters = ((ParametersWithSBox) cipherParameters).getParameters();
        }
        this.key = (KeyParameter) cipherParameters;
    }

    public int processBlock(byte[] bArr, int i11, byte[] bArr2, int i12) throws DataLengthException, IllegalStateException {
        processBytes(bArr, i11, this.cfbEngine.getBlockSize(), bArr2, i12);
        return this.cfbEngine.getBlockSize();
    }

    public void reset() {
        this.counter = 0;
        this.cfbEngine.reset();
    }
}
