package org.bouncycastle.pqc.crypto.sphincsplus;

import java.util.LinkedList;
import org.bouncycastle.util.Arrays;

class Fors {
    public SPHINCSPlusEngine engine;

    public Fors(SPHINCSPlusEngine sPHINCSPlusEngine) {
        this.engine = sPHINCSPlusEngine;
    }

    public static int[] message_to_idxs(byte[] bArr, int i11, int i12) {
        int[] iArr = new int[i11];
        int i13 = 0;
        for (int i14 = 0; i14 < i11; i14++) {
            iArr[i14] = 0;
            for (int i15 = 0; i15 < i12; i15++) {
                iArr[i14] = iArr[i14] ^ (((bArr[i13 >> 3] >> (i13 & 7)) & 1) << i15);
                i13++;
            }
        }
        return iArr;
    }

    public byte[] pkFromSig(SIG_FORS[] sig_forsArr, byte[] bArr, byte[] bArr2, ADRS adrs) {
        byte[] bArr3 = bArr2;
        ADRS adrs2 = adrs;
        int i11 = 2;
        byte[][] bArr4 = new byte[2][];
        SPHINCSPlusEngine sPHINCSPlusEngine = this.engine;
        int i12 = sPHINCSPlusEngine.K;
        byte[][] bArr5 = new byte[i12][];
        int i13 = sPHINCSPlusEngine.T;
        int[] message_to_idxs = message_to_idxs(bArr, i12, sPHINCSPlusEngine.A);
        int i14 = 0;
        while (i14 < this.engine.K) {
            int i15 = message_to_idxs[i14];
            byte[] sk2 = sig_forsArr[i14].getSK();
            adrs2.setTreeHeight(0);
            int i16 = (i14 * i13) + i15;
            adrs2.setTreeIndex(i16);
            bArr4[0] = this.engine.F(bArr3, adrs2, sk2);
            byte[][] authPath = sig_forsArr[i14].getAuthPath();
            adrs2.setTreeIndex(i16);
            int i17 = 0;
            while (i17 < this.engine.A) {
                int i18 = i17 + 1;
                adrs2.setTreeHeight(i18);
                if ((i15 / (1 << i17)) % i11 == 0) {
                    adrs2.setTreeIndex(adrs.getTreeIndex() / i11);
                    bArr4[1] = this.engine.H(bArr3, adrs2, bArr4[0], authPath[i17]);
                } else {
                    adrs2.setTreeIndex((adrs.getTreeIndex() - 1) / 2);
                    bArr4[1] = this.engine.H(bArr3, adrs2, authPath[i17], bArr4[0]);
                }
                bArr4[0] = bArr4[1];
                i17 = i18;
                i11 = 2;
            }
            bArr5[i14] = bArr4[0];
            i14++;
            i11 = 2;
        }
        ADRS adrs3 = new ADRS(adrs2);
        adrs3.setType(4);
        adrs3.setKeyPairAddress(adrs.getKeyPairAddress());
        return this.engine.T_l(bArr3, adrs3, Arrays.concatenate(bArr5));
    }

    public SIG_FORS[] sign(byte[] bArr, byte[] bArr2, byte[] bArr3, ADRS adrs) {
        Fors fors = this;
        ADRS adrs2 = adrs;
        SPHINCSPlusEngine sPHINCSPlusEngine = fors.engine;
        int[] message_to_idxs = message_to_idxs(bArr, sPHINCSPlusEngine.K, sPHINCSPlusEngine.A);
        SPHINCSPlusEngine sPHINCSPlusEngine2 = fors.engine;
        SIG_FORS[] sig_forsArr = new SIG_FORS[sPHINCSPlusEngine2.K];
        int i11 = sPHINCSPlusEngine2.T;
        int i12 = 0;
        int i13 = 0;
        while (i13 < fors.engine.K) {
            int i14 = message_to_idxs[i13];
            adrs2.setTreeHeight(i12);
            int i15 = i13 * i11;
            adrs2.setTreeIndex(i15 + i14);
            byte[] PRF = fors.engine.PRF(bArr3, bArr2, adrs2);
            byte[][] bArr4 = new byte[fors.engine.A][];
            int i16 = i12;
            while (i16 < fors.engine.A) {
                int i17 = 1 << i16;
                int i18 = i16;
                byte[][] bArr5 = bArr4;
                bArr5[i18] = treehash(bArr2, i15 + (((i14 / i17) ^ 1) * i17), i18, bArr3, adrs);
                i16 = i18 + 1;
                byte[] bArr6 = bArr3;
                PRF = PRF;
                bArr4 = bArr5;
                fors = this;
            }
            sig_forsArr[i13] = new SIG_FORS(PRF, bArr4);
            i13++;
            i12 = 0;
            fors = this;
        }
        return sig_forsArr;
    }

    public byte[] treehash(byte[] bArr, int i11, int i12, byte[] bArr2, ADRS adrs) {
        ADRS adrs2 = new ADRS(adrs);
        LinkedList linkedList = new LinkedList();
        int i13 = 1 << i12;
        if (i11 % i13 != 0) {
            return null;
        }
        for (int i14 = 0; i14 < i13; i14++) {
            adrs2.setTreeHeight(0);
            int i15 = i11 + i14;
            adrs2.setTreeIndex(i15);
            byte[] F = this.engine.F(bArr2, adrs2, this.engine.PRF(bArr2, bArr, adrs2));
            adrs2.setTreeHeight(1);
            adrs2.setTreeIndex(i15);
            while (!linkedList.isEmpty() && ((NodeEntry) linkedList.get(0)).nodeHeight == adrs2.getTreeHeight()) {
                adrs2.setTreeIndex((adrs2.getTreeIndex() - 1) / 2);
                F = this.engine.H(bArr2, adrs2, ((NodeEntry) linkedList.remove(0)).nodeValue, F);
                adrs2.setTreeHeight(adrs2.getTreeHeight() + 1);
            }
            linkedList.add(0, new NodeEntry(F, adrs2.getTreeHeight()));
        }
        return ((NodeEntry) linkedList.get(0)).nodeValue;
    }
}
