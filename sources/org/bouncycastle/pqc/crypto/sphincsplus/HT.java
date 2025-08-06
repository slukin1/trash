package org.bouncycastle.pqc.crypto.sphincsplus;

import java.util.LinkedList;
import org.bouncycastle.util.Arrays;

class HT {
    public SPHINCSPlusEngine engine;
    public final byte[] htPubKey;
    private final byte[] pkSeed;
    private final byte[] skSeed;
    public WotsPlus wots;

    public HT(SPHINCSPlusEngine sPHINCSPlusEngine, byte[] bArr, byte[] bArr2) {
        this.skSeed = bArr;
        this.pkSeed = bArr2;
        this.engine = sPHINCSPlusEngine;
        this.wots = new WotsPlus(sPHINCSPlusEngine);
        ADRS adrs = new ADRS();
        adrs.setLayerAddress(sPHINCSPlusEngine.D - 1);
        adrs.setTreeAddress(0);
        if (bArr != null) {
            this.htPubKey = xmss_PKgen(bArr, bArr2, adrs);
        } else {
            this.htPubKey = null;
        }
    }

    public byte[] sign(byte[] bArr, long j11, int i11) {
        long j12 = j11;
        ADRS adrs = new ADRS();
        adrs.setLayerAddress(0);
        adrs.setTreeAddress(j12);
        ADRS adrs2 = adrs;
        SIG_XMSS xmss_sign = xmss_sign(bArr, this.skSeed, i11, this.pkSeed, adrs2);
        int i12 = this.engine.D;
        SIG_XMSS[] sig_xmssArr = new SIG_XMSS[i12];
        sig_xmssArr[0] = xmss_sign;
        adrs.setLayerAddress(0);
        adrs.setTreeAddress(j12);
        byte[] xmss_pkFromSig = xmss_pkFromSig(i11, xmss_sign, bArr, this.pkSeed, adrs2);
        int i13 = 1;
        while (true) {
            SPHINCSPlusEngine sPHINCSPlusEngine = this.engine;
            if (i13 >= sPHINCSPlusEngine.D) {
                break;
            }
            int i14 = sPHINCSPlusEngine.H_PRIME;
            int i15 = (int) (((long) ((1 << i14) - 1)) & j12);
            j12 >>>= i14;
            adrs.setLayerAddress(i13);
            adrs.setTreeAddress(j12);
            int i16 = i15;
            SIG_XMSS xmss_sign2 = xmss_sign(xmss_pkFromSig, this.skSeed, i15, this.pkSeed, adrs);
            sig_xmssArr[i13] = xmss_sign2;
            if (i13 < this.engine.D - 1) {
                xmss_pkFromSig = xmss_pkFromSig(i16, xmss_sign2, xmss_pkFromSig, this.pkSeed, adrs);
            }
            i13++;
        }
        byte[][] bArr2 = new byte[i12][];
        for (int i17 = 0; i17 != i12; i17++) {
            bArr2[i17] = Arrays.concatenate(sig_xmssArr[i17].sig, Arrays.concatenate(sig_xmssArr[i17].auth));
        }
        return Arrays.concatenate(bArr2);
    }

    public byte[] treehash(byte[] bArr, int i11, int i12, byte[] bArr2, ADRS adrs) {
        ADRS adrs2 = new ADRS(adrs);
        LinkedList linkedList = new LinkedList();
        int i13 = 1 << i12;
        if (i11 % i13 != 0) {
            return null;
        }
        for (int i14 = 0; i14 < i13; i14++) {
            adrs2.setType(0);
            int i15 = i11 + i14;
            adrs2.setKeyPairAddress(i15);
            byte[] pkGen = this.wots.pkGen(bArr, bArr2, adrs2);
            adrs2.setType(2);
            adrs2.setTreeHeight(1);
            adrs2.setTreeIndex(i15);
            while (!linkedList.isEmpty() && ((NodeEntry) linkedList.get(0)).nodeHeight == adrs2.getTreeHeight()) {
                adrs2.setTreeIndex((adrs2.getTreeIndex() - 1) / 2);
                pkGen = this.engine.H(bArr2, adrs2, ((NodeEntry) linkedList.remove(0)).nodeValue, pkGen);
                adrs2.setTreeHeight(adrs2.getTreeHeight() + 1);
            }
            linkedList.add(0, new NodeEntry(pkGen, adrs2.getTreeHeight()));
        }
        return ((NodeEntry) linkedList.get(0)).nodeValue;
    }

    public boolean verify(byte[] bArr, SIG_XMSS[] sig_xmssArr, byte[] bArr2, long j11, int i11, byte[] bArr3) {
        ADRS adrs = new ADRS();
        SIG_XMSS sig_xmss = sig_xmssArr[0];
        adrs.setLayerAddress(0);
        adrs.setTreeAddress(j11);
        byte[] xmss_pkFromSig = xmss_pkFromSig(i11, sig_xmss, bArr, bArr2, adrs);
        int i12 = 1;
        while (true) {
            SPHINCSPlusEngine sPHINCSPlusEngine = this.engine;
            if (i12 >= sPHINCSPlusEngine.D) {
                return Arrays.areEqual(bArr3, xmss_pkFromSig);
            }
            int i13 = sPHINCSPlusEngine.H_PRIME;
            j11 >>>= i13;
            SIG_XMSS sig_xmss2 = sig_xmssArr[i12];
            adrs.setLayerAddress(i12);
            adrs.setTreeAddress(j11);
            xmss_pkFromSig = xmss_pkFromSig((int) (((long) ((1 << i13) - 1)) & j11), sig_xmss2, xmss_pkFromSig, bArr2, adrs);
            i12++;
        }
    }

    public byte[] xmss_PKgen(byte[] bArr, byte[] bArr2, ADRS adrs) {
        return treehash(bArr, 0, this.engine.H_PRIME, bArr2, adrs);
    }

    public byte[] xmss_pkFromSig(int i11, SIG_XMSS sig_xmss, byte[] bArr, byte[] bArr2, ADRS adrs) {
        ADRS adrs2 = new ADRS(adrs);
        int i12 = 0;
        adrs2.setType(0);
        adrs2.setKeyPairAddress(i11);
        byte[] wOTSSig = sig_xmss.getWOTSSig();
        byte[][] xmssauth = sig_xmss.getXMSSAUTH();
        byte[] pkFromSig = this.wots.pkFromSig(wOTSSig, bArr, bArr2, adrs2);
        adrs2.setType(2);
        adrs2.setTreeIndex(i11);
        while (i12 < this.engine.H_PRIME) {
            int i13 = i12 + 1;
            adrs2.setTreeHeight(i13);
            if ((i11 / (1 << i12)) % 2 == 0) {
                adrs2.setTreeIndex(adrs2.getTreeIndex() / 2);
                pkFromSig = this.engine.H(bArr2, adrs2, pkFromSig, xmssauth[i12]);
            } else {
                adrs2.setTreeIndex((adrs2.getTreeIndex() - 1) / 2);
                pkFromSig = this.engine.H(bArr2, adrs2, xmssauth[i12], pkFromSig);
            }
            i12 = i13;
        }
        return pkFromSig;
    }

    public SIG_XMSS xmss_sign(byte[] bArr, byte[] bArr2, int i11, byte[] bArr3, ADRS adrs) {
        byte[][] bArr4 = new byte[this.engine.H_PRIME][];
        for (int i12 = 0; i12 < this.engine.H_PRIME; i12++) {
            int i13 = 1 << i12;
            bArr4[i12] = treehash(bArr2, (1 ^ (i11 / i13)) * i13, i12, bArr3, adrs);
        }
        ADRS adrs2 = new ADRS(adrs);
        adrs2.setType(0);
        adrs2.setKeyPairAddress(i11);
        return new SIG_XMSS(this.wots.sign(bArr, bArr2, bArr3, adrs2), bArr4);
    }
}
