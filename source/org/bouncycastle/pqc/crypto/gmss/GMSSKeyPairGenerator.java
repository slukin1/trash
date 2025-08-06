package org.bouncycastle.pqc.crypto.gmss;

import java.lang.reflect.Array;
import java.security.SecureRandom;
import java.util.Vector;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.KeyGenerationParameters;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.pqc.crypto.gmss.util.GMSSRandom;
import org.bouncycastle.pqc.crypto.gmss.util.WinternitzOTSVerify;
import org.bouncycastle.pqc.crypto.gmss.util.WinternitzOTSignature;

public class GMSSKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    public static final String OID = "1.3.6.1.4.1.8301.3.1.3.3";
    private int[] K;
    private byte[][] currentRootSigs;
    private byte[][] currentSeeds;
    private GMSSDigestProvider digestProvider;
    private GMSSParameters gmssPS;
    private GMSSKeyGenerationParameters gmssParams;
    private GMSSRandom gmssRandom;
    private int[] heightOfTrees;
    private boolean initialized = false;
    private int mdLength;
    private Digest messDigestTree;
    private byte[][] nextNextSeeds;
    private int numLayer;
    private int[] otsIndex;

    public GMSSKeyPairGenerator(GMSSDigestProvider gMSSDigestProvider) {
        this.digestProvider = gMSSDigestProvider;
        Digest digest = gMSSDigestProvider.get();
        this.messDigestTree = digest;
        this.mdLength = digest.getDigestSize();
        this.gmssRandom = new GMSSRandom(this.messDigestTree);
    }

    private AsymmetricCipherKeyPair genKeyPair() {
        int i11;
        int i12;
        Class<byte> cls = byte.class;
        if (!this.initialized) {
            initializeDefault();
        }
        int i13 = this.numLayer;
        byte[][][] bArr = new byte[i13][][];
        byte[][][] bArr2 = new byte[(i13 - 1)][][];
        Treehash[][] treehashArr = new Treehash[i13][];
        Treehash[][] treehashArr2 = new Treehash[(i13 - 1)][];
        Vector[] vectorArr = new Vector[i13];
        Vector[] vectorArr2 = new Vector[(i13 - 1)];
        Vector[][] vectorArr3 = new Vector[i13][];
        int i14 = 1;
        Vector[][] vectorArr4 = new Vector[(i13 - 1)][];
        int i15 = 0;
        while (true) {
            i11 = this.numLayer;
            if (i15 >= i11) {
                break;
            }
            int i16 = this.heightOfTrees[i15];
            Vector[][] vectorArr5 = vectorArr4;
            int[] iArr = new int[2];
            iArr[1] = this.mdLength;
            iArr[0] = i16;
            bArr[i15] = (byte[][]) Array.newInstance(cls, iArr);
            int[] iArr2 = this.heightOfTrees;
            treehashArr[i15] = new Treehash[(iArr2[i15] - this.K[i15])];
            if (i15 > 0) {
                int i17 = i15 - 1;
                int i18 = iArr2[i15];
                int[] iArr3 = new int[2];
                iArr3[1] = this.mdLength;
                iArr3[0] = i18;
                bArr2[i17] = (byte[][]) Array.newInstance(cls, iArr3);
                treehashArr2[i17] = new Treehash[(this.heightOfTrees[i15] - this.K[i15])];
            }
            vectorArr[i15] = new Vector();
            if (i15 > 0) {
                vectorArr2[i15 - 1] = new Vector();
            }
            i15++;
            vectorArr4 = vectorArr5;
        }
        Vector[][] vectorArr6 = vectorArr4;
        int[] iArr4 = new int[2];
        iArr4[1] = this.mdLength;
        iArr4[0] = i11;
        byte[][] bArr3 = (byte[][]) Array.newInstance(cls, iArr4);
        int[] iArr5 = new int[2];
        iArr5[1] = this.mdLength;
        iArr5[0] = this.numLayer - 1;
        int i19 = this.numLayer;
        byte[][] bArr4 = (byte[][]) Array.newInstance(cls, iArr5);
        int[] iArr6 = new int[2];
        iArr6[1] = this.mdLength;
        iArr6[0] = i19;
        byte[][] bArr5 = (byte[][]) Array.newInstance(cls, iArr6);
        int i21 = 0;
        while (true) {
            i12 = this.numLayer;
            if (i21 >= i12) {
                break;
            }
            System.arraycopy(this.currentSeeds[i21], 0, bArr5[i21], 0, this.mdLength);
            i21++;
            i14 = 1;
        }
        Treehash[][] treehashArr3 = treehashArr2;
        int[] iArr7 = new int[2];
        iArr7[i14] = this.mdLength;
        iArr7[0] = i12 - i14;
        this.currentRootSigs = (byte[][]) Array.newInstance(cls, iArr7);
        int i22 = this.numLayer - i14;
        while (i22 >= 0) {
            GMSSRootCalc generateCurrentAuthpathAndRoot = i22 == this.numLayer - i14 ? generateCurrentAuthpathAndRoot((byte[]) null, vectorArr[i22], bArr5[i22], i22) : generateCurrentAuthpathAndRoot(bArr3[i22 + 1], vectorArr[i22], bArr5[i22], i22);
            for (int i23 = 0; i23 < this.heightOfTrees[i22]; i23++) {
                System.arraycopy(generateCurrentAuthpathAndRoot.getAuthPath()[i23], 0, bArr[i22][i23], 0, this.mdLength);
            }
            vectorArr3[i22] = generateCurrentAuthpathAndRoot.getRetain();
            treehashArr[i22] = generateCurrentAuthpathAndRoot.getTreehash();
            System.arraycopy(generateCurrentAuthpathAndRoot.getRoot(), 0, bArr3[i22], 0, this.mdLength);
            i22--;
            i14 = 1;
        }
        int i24 = this.numLayer - 2;
        while (i24 >= 0) {
            int i25 = i24 + 1;
            GMSSRootCalc generateNextAuthpathAndRoot = generateNextAuthpathAndRoot(vectorArr2[i24], bArr5[i25], i25);
            int i26 = 0;
            while (i26 < this.heightOfTrees[i25]) {
                System.arraycopy(generateNextAuthpathAndRoot.getAuthPath()[i26], 0, bArr2[i24][i26], 0, this.mdLength);
                i26++;
                vectorArr3 = vectorArr3;
            }
            vectorArr6[i24] = generateNextAuthpathAndRoot.getRetain();
            treehashArr3[i24] = generateNextAuthpathAndRoot.getTreehash();
            System.arraycopy(generateNextAuthpathAndRoot.getRoot(), 0, bArr4[i24], 0, this.mdLength);
            System.arraycopy(bArr5[i25], 0, this.nextNextSeeds[i24], 0, this.mdLength);
            i24--;
            vectorArr3 = vectorArr3;
        }
        Vector[][] vectorArr7 = vectorArr3;
        return new AsymmetricCipherKeyPair((AsymmetricKeyParameter) new GMSSPublicKeyParameters(bArr3[0], this.gmssPS), (AsymmetricKeyParameter) new GMSSPrivateKeyParameters(this.currentSeeds, this.nextNextSeeds, bArr, bArr2, treehashArr, treehashArr3, vectorArr, vectorArr2, vectorArr3, vectorArr6, bArr4, this.currentRootSigs, this.gmssPS, this.digestProvider));
    }

    private GMSSRootCalc generateCurrentAuthpathAndRoot(byte[] bArr, Vector vector, byte[] bArr2, int i11) {
        byte[] bArr3;
        int i12 = this.mdLength;
        byte[] bArr4 = new byte[i12];
        byte[] bArr5 = new byte[i12];
        byte[] nextSeed = this.gmssRandom.nextSeed(bArr2);
        GMSSRootCalc gMSSRootCalc = new GMSSRootCalc(this.heightOfTrees[i11], this.K[i11], this.digestProvider);
        gMSSRootCalc.initialize(vector);
        if (i11 == this.numLayer - 1) {
            bArr3 = new WinternitzOTSignature(nextSeed, this.digestProvider.get(), this.otsIndex[i11]).getPublicKey();
        } else {
            this.currentRootSigs[i11] = new WinternitzOTSignature(nextSeed, this.digestProvider.get(), this.otsIndex[i11]).getSignature(bArr);
            bArr3 = new WinternitzOTSVerify(this.digestProvider.get(), this.otsIndex[i11]).Verify(bArr, this.currentRootSigs[i11]);
        }
        gMSSRootCalc.update(bArr3);
        int i13 = 3;
        int i14 = 0;
        int i15 = 1;
        while (true) {
            int[] iArr = this.heightOfTrees;
            if (i15 >= (1 << iArr[i11])) {
                break;
            }
            if (i15 == i13 && i14 < iArr[i11] - this.K[i11]) {
                gMSSRootCalc.initializeTreehashSeed(bArr2, i14);
                i13 *= 2;
                i14++;
            }
            gMSSRootCalc.update(new WinternitzOTSignature(this.gmssRandom.nextSeed(bArr2), this.digestProvider.get(), this.otsIndex[i11]).getPublicKey());
            i15++;
        }
        if (gMSSRootCalc.wasFinished()) {
            return gMSSRootCalc;
        }
        System.err.println("Baum noch nicht fertig konstruiert!!!");
        return null;
    }

    private GMSSRootCalc generateNextAuthpathAndRoot(Vector vector, byte[] bArr, int i11) {
        byte[] bArr2 = new byte[this.numLayer];
        GMSSRootCalc gMSSRootCalc = new GMSSRootCalc(this.heightOfTrees[i11], this.K[i11], this.digestProvider);
        gMSSRootCalc.initialize(vector);
        int i12 = 0;
        int i13 = 3;
        int i14 = 0;
        while (true) {
            int[] iArr = this.heightOfTrees;
            if (i12 >= (1 << iArr[i11])) {
                break;
            }
            if (i12 == i13 && i14 < iArr[i11] - this.K[i11]) {
                gMSSRootCalc.initializeTreehashSeed(bArr, i14);
                i13 *= 2;
                i14++;
            }
            gMSSRootCalc.update(new WinternitzOTSignature(this.gmssRandom.nextSeed(bArr), this.digestProvider.get(), this.otsIndex[i11]).getPublicKey());
            i12++;
        }
        if (gMSSRootCalc.wasFinished()) {
            return gMSSRootCalc;
        }
        System.err.println("N�chster Baum noch nicht fertig konstruiert!!!");
        return null;
    }

    private void initializeDefault() {
        initialize(new GMSSKeyGenerationParameters((SecureRandom) null, new GMSSParameters(4, new int[]{10, 10, 10, 10}, new int[]{3, 3, 3, 3}, new int[]{2, 2, 2, 2})));
    }

    public AsymmetricCipherKeyPair generateKeyPair() {
        return genKeyPair();
    }

    public void init(KeyGenerationParameters keyGenerationParameters) {
        initialize(keyGenerationParameters);
    }

    public void initialize(int i11, SecureRandom secureRandom) {
        GMSSKeyGenerationParameters gMSSKeyGenerationParameters;
        if (i11 <= 10) {
            gMSSKeyGenerationParameters = new GMSSKeyGenerationParameters(secureRandom, new GMSSParameters(1, new int[]{10}, new int[]{3}, new int[]{2}));
        } else {
            gMSSKeyGenerationParameters = i11 <= 20 ? new GMSSKeyGenerationParameters(secureRandom, new GMSSParameters(2, new int[]{10, 10}, new int[]{5, 4}, new int[]{2, 2})) : new GMSSKeyGenerationParameters(secureRandom, new GMSSParameters(4, new int[]{10, 10, 10, 10}, new int[]{9, 9, 9, 3}, new int[]{2, 2, 2, 2}));
        }
        initialize(gMSSKeyGenerationParameters);
    }

    public void initialize(KeyGenerationParameters keyGenerationParameters) {
        Class<byte> cls = byte.class;
        GMSSKeyGenerationParameters gMSSKeyGenerationParameters = (GMSSKeyGenerationParameters) keyGenerationParameters;
        this.gmssParams = gMSSKeyGenerationParameters;
        GMSSParameters gMSSParameters = new GMSSParameters(gMSSKeyGenerationParameters.getParameters().getNumOfLayers(), this.gmssParams.getParameters().getHeightOfTrees(), this.gmssParams.getParameters().getWinternitzParameter(), this.gmssParams.getParameters().getK());
        this.gmssPS = gMSSParameters;
        this.numLayer = gMSSParameters.getNumOfLayers();
        this.heightOfTrees = this.gmssPS.getHeightOfTrees();
        this.otsIndex = this.gmssPS.getWinternitzParameter();
        this.K = this.gmssPS.getK();
        int i11 = this.numLayer;
        int[] iArr = new int[2];
        iArr[1] = this.mdLength;
        iArr[0] = i11;
        this.currentSeeds = (byte[][]) Array.newInstance(cls, iArr);
        int[] iArr2 = new int[2];
        iArr2[1] = this.mdLength;
        iArr2[0] = this.numLayer - 1;
        this.nextNextSeeds = (byte[][]) Array.newInstance(cls, iArr2);
        SecureRandom random = keyGenerationParameters.getRandom();
        for (int i12 = 0; i12 < this.numLayer; i12++) {
            random.nextBytes(this.currentSeeds[i12]);
            this.gmssRandom.nextSeed(this.currentSeeds[i12]);
        }
        this.initialized = true;
    }
}
