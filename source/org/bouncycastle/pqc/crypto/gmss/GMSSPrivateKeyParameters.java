package org.bouncycastle.pqc.crypto.gmss;

import com.xiaomi.mipush.sdk.Constants;
import java.util.Vector;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.pqc.crypto.gmss.util.GMSSRandom;
import org.bouncycastle.pqc.crypto.gmss.util.WinternitzOTSignature;
import org.bouncycastle.util.Arrays;

public class GMSSPrivateKeyParameters extends GMSSKeyParameters {
    private int[] K;
    private byte[][][] currentAuthPaths;
    private Vector[][] currentRetain;
    private byte[][] currentRootSig;
    private byte[][] currentSeeds;
    private Vector[] currentStack;
    private Treehash[][] currentTreehash;
    private GMSSDigestProvider digestProvider;
    private GMSSParameters gmssPS;
    private GMSSRandom gmssRandom;
    private int[] heightOfTrees;
    private int[] index;
    private byte[][][] keep;
    private int mdLength;
    private Digest messDigestTrees;
    private int[] minTreehash;
    private byte[][][] nextAuthPaths;
    private GMSSLeaf[] nextNextLeaf;
    private GMSSRootCalc[] nextNextRoot;
    private byte[][] nextNextSeeds;
    private Vector[][] nextRetain;
    private byte[][] nextRoot;
    private GMSSRootSig[] nextRootSig;
    private Vector[] nextStack;
    private Treehash[][] nextTreehash;
    private int numLayer;
    private int[] numLeafs;
    private int[] otsIndex;
    private GMSSLeaf[] upperLeaf;
    private GMSSLeaf[] upperTreehashLeaf;
    private boolean used;

    private GMSSPrivateKeyParameters(GMSSPrivateKeyParameters gMSSPrivateKeyParameters) {
        super(true, gMSSPrivateKeyParameters.getParameters());
        this.used = false;
        this.index = Arrays.clone(gMSSPrivateKeyParameters.index);
        this.currentSeeds = Arrays.clone(gMSSPrivateKeyParameters.currentSeeds);
        this.nextNextSeeds = Arrays.clone(gMSSPrivateKeyParameters.nextNextSeeds);
        this.currentAuthPaths = Arrays.clone(gMSSPrivateKeyParameters.currentAuthPaths);
        this.nextAuthPaths = Arrays.clone(gMSSPrivateKeyParameters.nextAuthPaths);
        this.currentTreehash = gMSSPrivateKeyParameters.currentTreehash;
        this.nextTreehash = gMSSPrivateKeyParameters.nextTreehash;
        this.currentStack = gMSSPrivateKeyParameters.currentStack;
        this.nextStack = gMSSPrivateKeyParameters.nextStack;
        this.currentRetain = gMSSPrivateKeyParameters.currentRetain;
        this.nextRetain = gMSSPrivateKeyParameters.nextRetain;
        this.keep = Arrays.clone(gMSSPrivateKeyParameters.keep);
        this.nextNextLeaf = gMSSPrivateKeyParameters.nextNextLeaf;
        this.upperLeaf = gMSSPrivateKeyParameters.upperLeaf;
        this.upperTreehashLeaf = gMSSPrivateKeyParameters.upperTreehashLeaf;
        this.minTreehash = gMSSPrivateKeyParameters.minTreehash;
        this.gmssPS = gMSSPrivateKeyParameters.gmssPS;
        this.nextRoot = Arrays.clone(gMSSPrivateKeyParameters.nextRoot);
        this.nextNextRoot = gMSSPrivateKeyParameters.nextNextRoot;
        this.currentRootSig = gMSSPrivateKeyParameters.currentRootSig;
        this.nextRootSig = gMSSPrivateKeyParameters.nextRootSig;
        this.digestProvider = gMSSPrivateKeyParameters.digestProvider;
        this.heightOfTrees = gMSSPrivateKeyParameters.heightOfTrees;
        this.otsIndex = gMSSPrivateKeyParameters.otsIndex;
        this.K = gMSSPrivateKeyParameters.K;
        this.numLayer = gMSSPrivateKeyParameters.numLayer;
        this.messDigestTrees = gMSSPrivateKeyParameters.messDigestTrees;
        this.mdLength = gMSSPrivateKeyParameters.mdLength;
        this.gmssRandom = gMSSPrivateKeyParameters.gmssRandom;
        this.numLeafs = gMSSPrivateKeyParameters.numLeafs;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public GMSSPrivateKeyParameters(int[] r17, byte[][] r18, byte[][] r19, byte[][][] r20, byte[][][] r21, byte[][][] r22, org.bouncycastle.pqc.crypto.gmss.Treehash[][] r23, org.bouncycastle.pqc.crypto.gmss.Treehash[][] r24, java.util.Vector[] r25, java.util.Vector[] r26, java.util.Vector[][] r27, java.util.Vector[][] r28, org.bouncycastle.pqc.crypto.gmss.GMSSLeaf[] r29, org.bouncycastle.pqc.crypto.gmss.GMSSLeaf[] r30, org.bouncycastle.pqc.crypto.gmss.GMSSLeaf[] r31, int[] r32, byte[][] r33, org.bouncycastle.pqc.crypto.gmss.GMSSRootCalc[] r34, byte[][] r35, org.bouncycastle.pqc.crypto.gmss.GMSSRootSig[] r36, org.bouncycastle.pqc.crypto.gmss.GMSSParameters r37, org.bouncycastle.pqc.crypto.gmss.GMSSDigestProvider r38) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = r18
            r3 = r22
            r4 = r25
            r5 = r26
            r6 = r29
            r7 = r30
            r8 = r31
            r9 = r32
            r10 = r33
            r11 = r34
            r12 = r36
            r13 = r37
            r14 = 1
            r0.<init>(r14, r13)
            r15 = 0
            r0.used = r15
            org.bouncycastle.crypto.Digest r14 = r38.get()
            r0.messDigestTrees = r14
            int r14 = r14.getDigestSize()
            r0.mdLength = r14
            r0.gmssPS = r13
            int[] r14 = r37.getWinternitzParameter()
            r0.otsIndex = r14
            int[] r14 = r37.getK()
            r0.K = r14
            int[] r13 = r37.getHeightOfTrees()
            r0.heightOfTrees = r13
            org.bouncycastle.pqc.crypto.gmss.GMSSParameters r13 = r0.gmssPS
            int r13 = r13.getNumOfLayers()
            r0.numLayer = r13
            if (r1 != 0) goto L_0x005d
            int[] r1 = new int[r13]
            r0.index = r1
            r1 = r15
        L_0x0052:
            int r13 = r0.numLayer
            if (r1 >= r13) goto L_0x005f
            int[] r13 = r0.index
            r13[r1] = r15
            int r1 = r1 + 1
            goto L_0x0052
        L_0x005d:
            r0.index = r1
        L_0x005f:
            r0.currentSeeds = r2
            r1 = r19
            r0.nextNextSeeds = r1
            byte[][][] r1 = org.bouncycastle.util.Arrays.clone((byte[][][]) r20)
            r0.currentAuthPaths = r1
            r1 = r21
            r0.nextAuthPaths = r1
            r1 = 2
            if (r3 != 0) goto L_0x00a6
            int r3 = r0.numLayer
            byte[][][] r3 = new byte[r3][][]
            r0.keep = r3
            r3 = r15
        L_0x0079:
            int r13 = r0.numLayer
            if (r3 >= r13) goto L_0x00a8
            byte[][][] r13 = r0.keep
            int[] r14 = r0.heightOfTrees
            r14 = r14[r3]
            int r14 = r14 / r1
            double r1 = (double) r14
            double r1 = java.lang.Math.floor(r1)
            int r1 = (int) r1
            int r2 = r0.mdLength
            r14 = 2
            int[] r12 = new int[r14]
            r14 = 1
            r12[r14] = r2
            r12[r15] = r1
            java.lang.Class<byte> r1 = byte.class
            java.lang.Object r1 = java.lang.reflect.Array.newInstance(r1, r12)
            byte[][] r1 = (byte[][]) r1
            r13[r3] = r1
            int r3 = r3 + 1
            r2 = r18
            r12 = r36
            r1 = 2
            goto L_0x0079
        L_0x00a6:
            r0.keep = r3
        L_0x00a8:
            if (r4 != 0) goto L_0x00c1
            int r1 = r0.numLayer
            java.util.Vector[] r1 = new java.util.Vector[r1]
            r0.currentStack = r1
            r1 = r15
        L_0x00b1:
            int r2 = r0.numLayer
            if (r1 >= r2) goto L_0x00c3
            java.util.Vector[] r2 = r0.currentStack
            java.util.Vector r3 = new java.util.Vector
            r3.<init>()
            r2[r1] = r3
            int r1 = r1 + 1
            goto L_0x00b1
        L_0x00c1:
            r0.currentStack = r4
        L_0x00c3:
            if (r5 != 0) goto L_0x00e0
            int r1 = r0.numLayer
            r2 = 1
            int r1 = r1 - r2
            java.util.Vector[] r1 = new java.util.Vector[r1]
            r0.nextStack = r1
            r1 = r15
        L_0x00ce:
            int r3 = r0.numLayer
            int r3 = r3 - r2
            if (r1 >= r3) goto L_0x00e2
            java.util.Vector[] r2 = r0.nextStack
            java.util.Vector r3 = new java.util.Vector
            r3.<init>()
            r2[r1] = r3
            int r1 = r1 + 1
            r2 = 1
            goto L_0x00ce
        L_0x00e0:
            r0.nextStack = r5
        L_0x00e2:
            r1 = r23
            r0.currentTreehash = r1
            r1 = r24
            r0.nextTreehash = r1
            r1 = r27
            r0.currentRetain = r1
            r1 = r28
            r0.nextRetain = r1
            r0.nextRoot = r10
            r1 = r38
            r0.digestProvider = r1
            if (r11 != 0) goto L_0x0120
            int r2 = r0.numLayer
            r3 = 1
            int r2 = r2 - r3
            org.bouncycastle.pqc.crypto.gmss.GMSSRootCalc[] r2 = new org.bouncycastle.pqc.crypto.gmss.GMSSRootCalc[r2]
            r0.nextNextRoot = r2
            r2 = r15
        L_0x0103:
            int r4 = r0.numLayer
            int r4 = r4 - r3
            if (r2 >= r4) goto L_0x0122
            org.bouncycastle.pqc.crypto.gmss.GMSSRootCalc[] r3 = r0.nextNextRoot
            org.bouncycastle.pqc.crypto.gmss.GMSSRootCalc r4 = new org.bouncycastle.pqc.crypto.gmss.GMSSRootCalc
            int[] r5 = r0.heightOfTrees
            int r11 = r2 + 1
            r5 = r5[r11]
            int[] r12 = r0.K
            r12 = r12[r11]
            org.bouncycastle.pqc.crypto.gmss.GMSSDigestProvider r13 = r0.digestProvider
            r4.<init>(r5, r12, r13)
            r3[r2] = r4
            r2 = r11
            r3 = 1
            goto L_0x0103
        L_0x0120:
            r0.nextNextRoot = r11
        L_0x0122:
            r2 = r35
            r0.currentRootSig = r2
            int r2 = r0.numLayer
            int[] r2 = new int[r2]
            r0.numLeafs = r2
            r2 = r15
        L_0x012d:
            int r3 = r0.numLayer
            if (r2 >= r3) goto L_0x013f
            int[] r3 = r0.numLeafs
            int[] r4 = r0.heightOfTrees
            r4 = r4[r2]
            r5 = 1
            int r4 = r5 << r4
            r3[r2] = r4
            int r2 = r2 + 1
            goto L_0x012d
        L_0x013f:
            r5 = 1
            org.bouncycastle.pqc.crypto.gmss.util.GMSSRandom r2 = new org.bouncycastle.pqc.crypto.gmss.util.GMSSRandom
            org.bouncycastle.crypto.Digest r3 = r0.messDigestTrees
            r2.<init>(r3)
            r0.gmssRandom = r2
            int r2 = r0.numLayer
            if (r2 <= r5) goto L_0x017d
            if (r6 != 0) goto L_0x017a
            r3 = 2
            int r2 = r2 - r3
            org.bouncycastle.pqc.crypto.gmss.GMSSLeaf[] r2 = new org.bouncycastle.pqc.crypto.gmss.GMSSLeaf[r2]
            r0.nextNextLeaf = r2
            r2 = r15
        L_0x0156:
            int r4 = r0.numLayer
            int r4 = r4 - r3
            if (r2 >= r4) goto L_0x0181
            org.bouncycastle.pqc.crypto.gmss.GMSSLeaf[] r4 = r0.nextNextLeaf
            org.bouncycastle.pqc.crypto.gmss.GMSSLeaf r5 = new org.bouncycastle.pqc.crypto.gmss.GMSSLeaf
            org.bouncycastle.crypto.Digest r6 = r38.get()
            int[] r11 = r0.otsIndex
            int r12 = r2 + 1
            r11 = r11[r12]
            int[] r13 = r0.numLeafs
            int r14 = r2 + 2
            r13 = r13[r14]
            byte[][] r14 = r0.nextNextSeeds
            r14 = r14[r2]
            r5.<init>(r6, r11, r13, r14)
            r4[r2] = r5
            r2 = r12
            goto L_0x0156
        L_0x017a:
            r0.nextNextLeaf = r6
            goto L_0x0181
        L_0x017d:
            org.bouncycastle.pqc.crypto.gmss.GMSSLeaf[] r2 = new org.bouncycastle.pqc.crypto.gmss.GMSSLeaf[r15]
            r0.nextNextLeaf = r2
        L_0x0181:
            if (r7 != 0) goto L_0x01af
            int r2 = r0.numLayer
            r3 = 1
            int r2 = r2 - r3
            org.bouncycastle.pqc.crypto.gmss.GMSSLeaf[] r2 = new org.bouncycastle.pqc.crypto.gmss.GMSSLeaf[r2]
            r0.upperLeaf = r2
            r2 = r15
        L_0x018c:
            int r4 = r0.numLayer
            int r4 = r4 - r3
            if (r2 >= r4) goto L_0x01b1
            org.bouncycastle.pqc.crypto.gmss.GMSSLeaf[] r3 = r0.upperLeaf
            org.bouncycastle.pqc.crypto.gmss.GMSSLeaf r4 = new org.bouncycastle.pqc.crypto.gmss.GMSSLeaf
            org.bouncycastle.crypto.Digest r5 = r38.get()
            int[] r6 = r0.otsIndex
            r6 = r6[r2]
            int[] r7 = r0.numLeafs
            int r11 = r2 + 1
            r7 = r7[r11]
            byte[][] r12 = r0.currentSeeds
            r12 = r12[r2]
            r4.<init>(r5, r6, r7, r12)
            r3[r2] = r4
            r2 = r11
            r3 = 1
            goto L_0x018c
        L_0x01af:
            r0.upperLeaf = r7
        L_0x01b1:
            if (r8 != 0) goto L_0x01db
            int r2 = r0.numLayer
            r3 = 1
            int r2 = r2 - r3
            org.bouncycastle.pqc.crypto.gmss.GMSSLeaf[] r2 = new org.bouncycastle.pqc.crypto.gmss.GMSSLeaf[r2]
            r0.upperTreehashLeaf = r2
            r2 = r15
        L_0x01bc:
            int r4 = r0.numLayer
            int r4 = r4 - r3
            if (r2 >= r4) goto L_0x01dd
            org.bouncycastle.pqc.crypto.gmss.GMSSLeaf[] r3 = r0.upperTreehashLeaf
            org.bouncycastle.pqc.crypto.gmss.GMSSLeaf r4 = new org.bouncycastle.pqc.crypto.gmss.GMSSLeaf
            org.bouncycastle.crypto.Digest r5 = r38.get()
            int[] r6 = r0.otsIndex
            r6 = r6[r2]
            int[] r7 = r0.numLeafs
            int r8 = r2 + 1
            r7 = r7[r8]
            r4.<init>((org.bouncycastle.crypto.Digest) r5, (int) r6, (int) r7)
            r3[r2] = r4
            r2 = r8
            r3 = 1
            goto L_0x01bc
        L_0x01db:
            r0.upperTreehashLeaf = r8
        L_0x01dd:
            if (r9 != 0) goto L_0x01f6
            int r2 = r0.numLayer
            r3 = 1
            int r2 = r2 - r3
            int[] r2 = new int[r2]
            r0.minTreehash = r2
            r2 = r15
        L_0x01e8:
            int r4 = r0.numLayer
            int r4 = r4 - r3
            if (r2 >= r4) goto L_0x01f8
            int[] r3 = r0.minTreehash
            r4 = -1
            r3[r2] = r4
            int r2 = r2 + 1
            r3 = 1
            goto L_0x01e8
        L_0x01f6:
            r0.minTreehash = r9
        L_0x01f8:
            int r2 = r0.mdLength
            byte[] r3 = new byte[r2]
            byte[] r2 = new byte[r2]
            r2 = r36
            if (r2 != 0) goto L_0x0244
            int r2 = r0.numLayer
            r4 = 1
            int r2 = r2 - r4
            org.bouncycastle.pqc.crypto.gmss.GMSSRootSig[] r2 = new org.bouncycastle.pqc.crypto.gmss.GMSSRootSig[r2]
            r0.nextRootSig = r2
            r2 = r15
        L_0x020b:
            int r5 = r0.numLayer
            int r5 = r5 - r4
            if (r2 >= r5) goto L_0x0246
            r5 = r18[r2]
            int r6 = r0.mdLength
            java.lang.System.arraycopy(r5, r15, r3, r15, r6)
            org.bouncycastle.pqc.crypto.gmss.util.GMSSRandom r5 = r0.gmssRandom
            r5.nextSeed(r3)
            org.bouncycastle.pqc.crypto.gmss.util.GMSSRandom r5 = r0.gmssRandom
            byte[] r5 = r5.nextSeed(r3)
            org.bouncycastle.pqc.crypto.gmss.GMSSRootSig[] r6 = r0.nextRootSig
            org.bouncycastle.pqc.crypto.gmss.GMSSRootSig r7 = new org.bouncycastle.pqc.crypto.gmss.GMSSRootSig
            org.bouncycastle.crypto.Digest r8 = r38.get()
            int[] r9 = r0.otsIndex
            r9 = r9[r2]
            int[] r11 = r0.heightOfTrees
            int r12 = r2 + 1
            r11 = r11[r12]
            r7.<init>((org.bouncycastle.crypto.Digest) r8, (int) r9, (int) r11)
            r6[r2] = r7
            org.bouncycastle.pqc.crypto.gmss.GMSSRootSig[] r6 = r0.nextRootSig
            r6 = r6[r2]
            r2 = r10[r2]
            r6.initSign(r5, r2)
            r2 = r12
            goto L_0x020b
        L_0x0244:
            r0.nextRootSig = r2
        L_0x0246:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.pqc.crypto.gmss.GMSSPrivateKeyParameters.<init>(int[], byte[][], byte[][], byte[][][], byte[][][], byte[][][], org.bouncycastle.pqc.crypto.gmss.Treehash[][], org.bouncycastle.pqc.crypto.gmss.Treehash[][], java.util.Vector[], java.util.Vector[], java.util.Vector[][], java.util.Vector[][], org.bouncycastle.pqc.crypto.gmss.GMSSLeaf[], org.bouncycastle.pqc.crypto.gmss.GMSSLeaf[], org.bouncycastle.pqc.crypto.gmss.GMSSLeaf[], int[], byte[][], org.bouncycastle.pqc.crypto.gmss.GMSSRootCalc[], byte[][], org.bouncycastle.pqc.crypto.gmss.GMSSRootSig[], org.bouncycastle.pqc.crypto.gmss.GMSSParameters, org.bouncycastle.pqc.crypto.gmss.GMSSDigestProvider):void");
    }

    public GMSSPrivateKeyParameters(byte[][] bArr, byte[][] bArr2, byte[][][] bArr3, byte[][][] bArr4, Treehash[][] treehashArr, Treehash[][] treehashArr2, Vector[] vectorArr, Vector[] vectorArr2, Vector[][] vectorArr3, Vector[][] vectorArr4, byte[][] bArr5, byte[][] bArr6, GMSSParameters gMSSParameters, GMSSDigestProvider gMSSDigestProvider) {
        this((int[]) null, bArr, bArr2, bArr3, bArr4, (byte[][][]) null, treehashArr, treehashArr2, vectorArr, vectorArr2, vectorArr3, vectorArr4, (GMSSLeaf[]) null, (GMSSLeaf[]) null, (GMSSLeaf[]) null, (int[]) null, bArr5, (GMSSRootCalc[]) null, bArr6, (GMSSRootSig[]) null, gMSSParameters, gMSSDigestProvider);
    }

    private void computeAuthPaths(int i11) {
        int i12;
        byte[] bArr;
        int i13 = this.index[i11];
        int i14 = this.heightOfTrees[i11];
        int i15 = this.K[i11];
        int i16 = 0;
        while (true) {
            i12 = i14 - i15;
            if (i16 >= i12) {
                break;
            }
            this.currentTreehash[i11][i16].updateNextSeed(this.gmssRandom);
            i16++;
        }
        int heightOfPhi = heightOfPhi(i13);
        byte[] bArr2 = new byte[this.mdLength];
        byte[] nextSeed = this.gmssRandom.nextSeed(this.currentSeeds[i11]);
        int i17 = (i13 >>> (heightOfPhi + 1)) & 1;
        int i18 = this.mdLength;
        byte[] bArr3 = new byte[i18];
        int i19 = i14 - 1;
        if (heightOfPhi < i19 && i17 == 0) {
            System.arraycopy(this.currentAuthPaths[i11][heightOfPhi], 0, bArr3, 0, i18);
        }
        int i21 = this.mdLength;
        byte[] bArr4 = new byte[i21];
        if (heightOfPhi == 0) {
            if (i11 == this.numLayer - 1) {
                bArr = new WinternitzOTSignature(nextSeed, this.digestProvider.get(), this.otsIndex[i11]).getPublicKey();
            } else {
                byte[] bArr5 = new byte[i21];
                System.arraycopy(this.currentSeeds[i11], 0, bArr5, 0, i21);
                this.gmssRandom.nextSeed(bArr5);
                byte[] leaf = this.upperLeaf[i11].getLeaf();
                this.upperLeaf[i11].initLeafCalc(bArr5);
                bArr = leaf;
            }
            System.arraycopy(bArr, 0, this.currentAuthPaths[i11][0], 0, this.mdLength);
        } else {
            int i22 = i21 << 1;
            byte[] bArr6 = new byte[i22];
            int i23 = heightOfPhi - 1;
            System.arraycopy(this.currentAuthPaths[i11][i23], 0, bArr6, 0, i21);
            byte[] bArr7 = this.keep[i11][(int) Math.floor((double) (i23 / 2))];
            int i24 = this.mdLength;
            System.arraycopy(bArr7, 0, bArr6, i24, i24);
            this.messDigestTrees.update(bArr6, 0, i22);
            this.currentAuthPaths[i11][heightOfPhi] = new byte[this.messDigestTrees.getDigestSize()];
            this.messDigestTrees.doFinal(this.currentAuthPaths[i11][heightOfPhi], 0);
            for (int i25 = 0; i25 < heightOfPhi; i25++) {
                if (i25 < i12) {
                    if (this.currentTreehash[i11][i25].wasFinished()) {
                        System.arraycopy(this.currentTreehash[i11][i25].getFirstNode(), 0, this.currentAuthPaths[i11][i25], 0, this.mdLength);
                        this.currentTreehash[i11][i25].destroy();
                    } else {
                        System.err.println("Treehash (" + i11 + Constants.ACCEPT_TIME_SEPARATOR_SP + i25 + ") not finished when needed in AuthPathComputation");
                    }
                }
                if (i25 < i19 && i25 >= i12) {
                    int i26 = i25 - i12;
                    if (this.currentRetain[i11][i26].size() > 0) {
                        System.arraycopy(this.currentRetain[i11][i26].lastElement(), 0, this.currentAuthPaths[i11][i25], 0, this.mdLength);
                        Vector[][] vectorArr = this.currentRetain;
                        vectorArr[i11][i26].removeElementAt(vectorArr[i11][i26].size() - 1);
                    }
                }
                if (i25 < i12 && ((1 << i25) * 3) + i13 < this.numLeafs[i11]) {
                    this.currentTreehash[i11][i25].initialize();
                }
            }
        }
        if (heightOfPhi < i19 && i17 == 0) {
            System.arraycopy(bArr3, 0, this.keep[i11][(int) Math.floor((double) (heightOfPhi / 2))], 0, this.mdLength);
        }
        if (i11 == this.numLayer - 1) {
            for (int i27 = 1; i27 <= i12 / 2; i27++) {
                int minTreehashIndex = getMinTreehashIndex(i11);
                if (minTreehashIndex >= 0) {
                    try {
                        byte[] bArr8 = new byte[this.mdLength];
                        System.arraycopy(this.currentTreehash[i11][minTreehashIndex].getSeedActive(), 0, bArr8, 0, this.mdLength);
                        this.currentTreehash[i11][minTreehashIndex].update(this.gmssRandom, new WinternitzOTSignature(this.gmssRandom.nextSeed(bArr8), this.digestProvider.get(), this.otsIndex[i11]).getPublicKey());
                    } catch (Exception e11) {
                        System.out.println(e11);
                    }
                }
            }
            return;
        }
        this.minTreehash[i11] = getMinTreehashIndex(i11);
    }

    private int getMinTreehashIndex(int i11) {
        int i12 = -1;
        for (int i13 = 0; i13 < this.heightOfTrees[i11] - this.K[i11]; i13++) {
            if (this.currentTreehash[i11][i13].wasInitialized() && !this.currentTreehash[i11][i13].wasFinished() && (i12 == -1 || this.currentTreehash[i11][i13].getLowestNodeHeight() < this.currentTreehash[i11][i12].getLowestNodeHeight())) {
                i12 = i13;
            }
        }
        return i12;
    }

    private int heightOfPhi(int i11) {
        if (i11 == 0) {
            return -1;
        }
        int i12 = 0;
        int i13 = 1;
        while (i11 % i13 == 0) {
            i13 *= 2;
            i12++;
        }
        return i12 - 1;
    }

    private void nextKey(int i11) {
        int i12 = this.numLayer;
        if (i11 == i12 - 1) {
            int[] iArr = this.index;
            iArr[i11] = iArr[i11] + 1;
        }
        if (this.index[i11] != this.numLeafs[i11]) {
            updateKey(i11);
        } else if (i12 != 1) {
            nextTree(i11);
            this.index[i11] = 0;
        }
    }

    private void nextTree(int i11) {
        if (i11 > 0) {
            int[] iArr = this.index;
            int i12 = i11 - 1;
            iArr[i12] = iArr[i12] + 1;
            int i13 = i11;
            boolean z11 = true;
            do {
                i13--;
                if (this.index[i13] < this.numLeafs[i13]) {
                    z11 = false;
                }
                if (!z11) {
                    break;
                }
            } while (i13 > 0);
            if (!z11) {
                this.gmssRandom.nextSeed(this.currentSeeds[i11]);
                this.nextRootSig[i12].updateSign();
                if (i11 > 1) {
                    GMSSLeaf[] gMSSLeafArr = this.nextNextLeaf;
                    int i14 = i12 - 1;
                    gMSSLeafArr[i14] = gMSSLeafArr[i14].nextLeaf();
                }
                GMSSLeaf[] gMSSLeafArr2 = this.upperLeaf;
                gMSSLeafArr2[i12] = gMSSLeafArr2[i12].nextLeaf();
                if (this.minTreehash[i12] >= 0) {
                    GMSSLeaf[] gMSSLeafArr3 = this.upperTreehashLeaf;
                    gMSSLeafArr3[i12] = gMSSLeafArr3[i12].nextLeaf();
                    try {
                        this.currentTreehash[i12][this.minTreehash[i12]].update(this.gmssRandom, this.upperTreehashLeaf[i12].getLeaf());
                        this.currentTreehash[i12][this.minTreehash[i12]].wasFinished();
                    } catch (Exception e11) {
                        System.out.println(e11);
                    }
                }
                updateNextNextAuthRoot(i11);
                this.currentRootSig[i12] = this.nextRootSig[i12].getSig();
                for (int i15 = 0; i15 < this.heightOfTrees[i11] - this.K[i11]; i15++) {
                    Treehash[] treehashArr = this.currentTreehash[i11];
                    Treehash[][] treehashArr2 = this.nextTreehash;
                    treehashArr[i15] = treehashArr2[i12][i15];
                    treehashArr2[i12][i15] = this.nextNextRoot[i12].getTreehash()[i15];
                }
                for (int i16 = 0; i16 < this.heightOfTrees[i11]; i16++) {
                    System.arraycopy(this.nextAuthPaths[i12][i16], 0, this.currentAuthPaths[i11][i16], 0, this.mdLength);
                    System.arraycopy(this.nextNextRoot[i12].getAuthPath()[i16], 0, this.nextAuthPaths[i12][i16], 0, this.mdLength);
                }
                for (int i17 = 0; i17 < this.K[i11] - 1; i17++) {
                    Vector[] vectorArr = this.currentRetain[i11];
                    Vector[][] vectorArr2 = this.nextRetain;
                    vectorArr[i17] = vectorArr2[i12][i17];
                    vectorArr2[i12][i17] = this.nextNextRoot[i12].getRetain()[i17];
                }
                Vector[] vectorArr3 = this.currentStack;
                Vector[] vectorArr4 = this.nextStack;
                vectorArr3[i11] = vectorArr4[i12];
                vectorArr4[i12] = this.nextNextRoot[i12].getStack();
                this.nextRoot[i12] = this.nextNextRoot[i12].getRoot();
                int i18 = this.mdLength;
                byte[] bArr = new byte[i18];
                byte[] bArr2 = new byte[i18];
                System.arraycopy(this.currentSeeds[i12], 0, bArr2, 0, i18);
                this.gmssRandom.nextSeed(bArr2);
                this.gmssRandom.nextSeed(bArr2);
                this.nextRootSig[i12].initSign(this.gmssRandom.nextSeed(bArr2), this.nextRoot[i12]);
                nextKey(i12);
            }
        }
    }

    private void updateKey(int i11) {
        computeAuthPaths(i11);
        if (i11 > 0) {
            if (i11 > 1) {
                GMSSLeaf[] gMSSLeafArr = this.nextNextLeaf;
                int i12 = (i11 - 1) - 1;
                gMSSLeafArr[i12] = gMSSLeafArr[i12].nextLeaf();
            }
            GMSSLeaf[] gMSSLeafArr2 = this.upperLeaf;
            int i13 = i11 - 1;
            gMSSLeafArr2[i13] = gMSSLeafArr2[i13].nextLeaf();
            int floor = (int) Math.floor(((double) (getNumLeafs(i11) * 2)) / ((double) (this.heightOfTrees[i13] - this.K[i13])));
            int[] iArr = this.index;
            if (iArr[i11] % floor == 1) {
                if (iArr[i11] > 1 && this.minTreehash[i13] >= 0) {
                    try {
                        this.currentTreehash[i13][this.minTreehash[i13]].update(this.gmssRandom, this.upperTreehashLeaf[i13].getLeaf());
                        this.currentTreehash[i13][this.minTreehash[i13]].wasFinished();
                    } catch (Exception e11) {
                        System.out.println(e11);
                    }
                }
                this.minTreehash[i13] = getMinTreehashIndex(i13);
                int[] iArr2 = this.minTreehash;
                if (iArr2[i13] >= 0) {
                    this.upperTreehashLeaf[i13] = new GMSSLeaf(this.digestProvider.get(), this.otsIndex[i13], floor, this.currentTreehash[i13][iArr2[i13]].getSeedActive());
                    GMSSLeaf[] gMSSLeafArr3 = this.upperTreehashLeaf;
                    gMSSLeafArr3[i13] = gMSSLeafArr3[i13].nextLeaf();
                }
            } else if (this.minTreehash[i13] >= 0) {
                GMSSLeaf[] gMSSLeafArr4 = this.upperTreehashLeaf;
                gMSSLeafArr4[i13] = gMSSLeafArr4[i13].nextLeaf();
            }
            this.nextRootSig[i13].updateSign();
            if (this.index[i11] == 1) {
                this.nextNextRoot[i13].initialize(new Vector());
            }
            updateNextNextAuthRoot(i11);
        }
    }

    private void updateNextNextAuthRoot(int i11) {
        byte[] bArr = new byte[this.mdLength];
        int i12 = i11 - 1;
        byte[] nextSeed = this.gmssRandom.nextSeed(this.nextNextSeeds[i12]);
        if (i11 == this.numLayer - 1) {
            this.nextNextRoot[i12].update(this.nextNextSeeds[i12], new WinternitzOTSignature(nextSeed, this.digestProvider.get(), this.otsIndex[i11]).getPublicKey());
            return;
        }
        this.nextNextRoot[i12].update(this.nextNextSeeds[i12], this.nextNextLeaf[i12].getLeaf());
        this.nextNextLeaf[i12].initLeafCalc(this.nextNextSeeds[i12]);
    }

    public byte[][][] getCurrentAuthPaths() {
        return Arrays.clone(this.currentAuthPaths);
    }

    public byte[][] getCurrentSeeds() {
        return Arrays.clone(this.currentSeeds);
    }

    public int getIndex(int i11) {
        return this.index[i11];
    }

    public int[] getIndex() {
        return this.index;
    }

    public GMSSDigestProvider getName() {
        return this.digestProvider;
    }

    public int getNumLeafs(int i11) {
        return this.numLeafs[i11];
    }

    public byte[] getSubtreeRootSig(int i11) {
        return this.currentRootSig[i11];
    }

    public boolean isUsed() {
        return this.used;
    }

    public void markUsed() {
        this.used = true;
    }

    public GMSSPrivateKeyParameters nextKey() {
        GMSSPrivateKeyParameters gMSSPrivateKeyParameters = new GMSSPrivateKeyParameters(this);
        gMSSPrivateKeyParameters.nextKey(this.gmssPS.getNumOfLayers() - 1);
        return gMSSPrivateKeyParameters;
    }
}
