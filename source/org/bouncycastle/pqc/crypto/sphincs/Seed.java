package org.bouncycastle.pqc.crypto.sphincs;

import org.bouncycastle.crypto.engines.ChaChaEngine;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.pqc.crypto.sphincs.Tree;
import org.bouncycastle.util.Pack;

class Seed {
    public static void get_seed(HashFunctions hashFunctions, byte[] bArr, int i11, byte[] bArr2, Tree.leafaddr leafaddr) {
        byte[] bArr3 = new byte[40];
        for (int i12 = 0; i12 < 32; i12++) {
            bArr3[i12] = bArr2[i12];
        }
        Pack.longToLittleEndian((leafaddr.subleaf << 59) | ((long) leafaddr.level) | (leafaddr.subtree << 4), bArr3, 32);
        hashFunctions.varlen_hash(bArr, i11, bArr3, 40);
    }

    public static void prg(byte[] bArr, int i11, long j11, byte[] bArr2, int i12) {
        ChaChaEngine chaChaEngine = new ChaChaEngine(12);
        chaChaEngine.init(true, new ParametersWithIV(new KeyParameter(bArr2, i12, 32), new byte[8]));
        chaChaEngine.processBytes(bArr, i11, (int) j11, bArr, i11);
    }
}
