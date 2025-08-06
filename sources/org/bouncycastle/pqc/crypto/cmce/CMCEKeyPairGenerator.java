package org.bouncycastle.pqc.crypto.cmce;

import java.security.SecureRandom;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.bouncycastle.crypto.KeyGenerationParameters;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;

public class CMCEKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    private CMCEKeyGenerationParameters cmceParams;

    /* renamed from: m  reason: collision with root package name */
    private int f59513m;

    /* renamed from: n  reason: collision with root package name */
    private int f59514n;
    private SecureRandom random;

    /* renamed from: t  reason: collision with root package name */
    private int f59515t;

    private AsymmetricCipherKeyPair genKeyPair() {
        CMCEEngine engine = this.cmceParams.getParameters().getEngine();
        byte[] bArr = new byte[engine.getPrivateKeySize()];
        byte[] bArr2 = new byte[engine.getPublicKeySize()];
        engine.kem_keypair(bArr2, bArr, this.random);
        return new AsymmetricCipherKeyPair((AsymmetricKeyParameter) new CMCEPublicKeyParameters(this.cmceParams.getParameters(), bArr2), (AsymmetricKeyParameter) new CMCEPrivateKeyParameters(this.cmceParams.getParameters(), bArr));
    }

    private void initialize(KeyGenerationParameters keyGenerationParameters) {
        this.cmceParams = (CMCEKeyGenerationParameters) keyGenerationParameters;
        this.random = keyGenerationParameters.getRandom();
        this.f59513m = this.cmceParams.getParameters().getM();
        this.f59514n = this.cmceParams.getParameters().getN();
        this.f59515t = this.cmceParams.getParameters().getT();
    }

    public AsymmetricCipherKeyPair generateKeyPair() {
        return genKeyPair();
    }

    public void init(KeyGenerationParameters keyGenerationParameters) {
        initialize(keyGenerationParameters);
    }
}
