package org.bouncycastle.pqc.crypto.sphincsplus;

import java.security.SecureRandom;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.bouncycastle.crypto.KeyGenerationParameters;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;

public class SPHINCSPlusKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    private SPHINCSPlusParameters parameters;
    private SecureRandom random;

    private byte[] sec_rand(int i11) {
        byte[] bArr = new byte[i11];
        this.random.nextBytes(bArr);
        return bArr;
    }

    public AsymmetricCipherKeyPair generateKeyPair() {
        SPHINCSPlusEngine engine = this.parameters.getEngine();
        SK sk2 = new SK(sec_rand(engine.N), sec_rand(engine.N));
        byte[] sec_rand = sec_rand(engine.N);
        PK pk2 = new PK(sec_rand, new HT(engine, sk2.seed, sec_rand).htPubKey);
        return new AsymmetricCipherKeyPair((AsymmetricKeyParameter) new SPHINCSPlusPublicKeyParameters(this.parameters, pk2), (AsymmetricKeyParameter) new SPHINCSPlusPrivateKeyParameters(this.parameters, sk2, pk2));
    }

    public void init(KeyGenerationParameters keyGenerationParameters) {
        this.random = keyGenerationParameters.getRandom();
        this.parameters = ((SPHINCSPlusKeyGenerationParameters) keyGenerationParameters).getParameters();
    }
}
