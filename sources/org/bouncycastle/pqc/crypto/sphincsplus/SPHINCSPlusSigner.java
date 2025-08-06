package org.bouncycastle.pqc.crypto.sphincsplus;

import java.security.SecureRandom;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.pqc.crypto.MessageSigner;
import org.bouncycastle.util.Arrays;

public class SPHINCSPlusSigner implements MessageSigner {
    private SPHINCSPlusPrivateKeyParameters privKey;
    private SPHINCSPlusPublicKeyParameters pubKey;
    private SecureRandom random;

    public byte[] generateSignature(byte[] bArr) {
        SPHINCSPlusEngine engine = this.privKey.getParameters().getEngine();
        int i11 = engine.N;
        byte[] bArr2 = new byte[i11];
        SecureRandom secureRandom = this.random;
        int i12 = 0;
        if (secureRandom != null) {
            secureRandom.nextBytes(bArr2);
        } else {
            System.arraycopy(this.privKey.f59610pk.seed, 0, bArr2, 0, i11);
        }
        Fors fors = new Fors(engine);
        byte[] PRF_msg = engine.PRF_msg(this.privKey.f59611sk.prf, bArr2, bArr);
        PK pk2 = this.privKey.f59610pk;
        IndexedDigest H_msg = engine.H_msg(PRF_msg, pk2.seed, pk2.root, bArr);
        byte[] bArr3 = H_msg.digest;
        long j11 = H_msg.idx_tree;
        int i13 = H_msg.idx_leaf;
        ADRS adrs = new ADRS();
        adrs.setType(3);
        adrs.setTreeAddress(j11);
        adrs.setKeyPairAddress(i13);
        SPHINCSPlusPrivateKeyParameters sPHINCSPlusPrivateKeyParameters = this.privKey;
        SIG_FORS[] sign = fors.sign(bArr3, sPHINCSPlusPrivateKeyParameters.f59611sk.seed, sPHINCSPlusPrivateKeyParameters.f59610pk.seed, adrs);
        byte[] pkFromSig = fors.pkFromSig(sign, bArr3, this.privKey.f59610pk.seed, adrs);
        new ADRS().setType(2);
        byte[] sign2 = new HT(engine, this.privKey.getSeed(), this.privKey.getPublicSeed()).sign(pkFromSig, j11, i13);
        int length = sign.length + 2;
        byte[][] bArr4 = new byte[length][];
        bArr4[0] = PRF_msg;
        while (i12 != sign.length) {
            int i14 = i12 + 1;
            bArr4[i14] = Arrays.concatenate(sign[i12].f59609sk, Arrays.concatenate(sign[i12].authPath));
            i12 = i14;
        }
        bArr4[length - 1] = sign2;
        return Arrays.concatenate(bArr4);
    }

    public void init(boolean z11, CipherParameters cipherParameters) {
        if (!z11) {
            this.pubKey = (SPHINCSPlusPublicKeyParameters) cipherParameters;
        } else if (cipherParameters instanceof ParametersWithRandom) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            this.privKey = (SPHINCSPlusPrivateKeyParameters) parametersWithRandom.getParameters();
            this.random = parametersWithRandom.getRandom();
        } else {
            this.privKey = (SPHINCSPlusPrivateKeyParameters) cipherParameters;
        }
    }

    public boolean verifySignature(byte[] bArr, byte[] bArr2) {
        SPHINCSPlusEngine engine = this.pubKey.getParameters().getEngine();
        ADRS adrs = new ADRS();
        SIG sig = new SIG(engine.N, engine.K, engine.A, engine.D, engine.H_PRIME, engine.WOTS_LEN, bArr2);
        byte[] r11 = sig.getR();
        SIG_FORS[] sig_fors = sig.getSIG_FORS();
        SIG_XMSS[] sig_ht = sig.getSIG_HT();
        IndexedDigest H_msg = engine.H_msg(r11, this.pubKey.getSeed(), this.pubKey.getRoot(), bArr);
        byte[] bArr3 = H_msg.digest;
        long j11 = H_msg.idx_tree;
        int i11 = H_msg.idx_leaf;
        adrs.setLayerAddress(0);
        adrs.setTreeAddress(j11);
        adrs.setType(3);
        adrs.setKeyPairAddress(i11);
        byte[] pkFromSig = new Fors(engine).pkFromSig(sig_fors, bArr3, this.pubKey.getSeed(), adrs);
        adrs.setType(2);
        return new HT(engine, (byte[]) null, this.pubKey.getSeed()).verify(pkFromSig, sig_ht, this.pubKey.getSeed(), j11, i11, this.pubKey.getRoot());
    }
}
