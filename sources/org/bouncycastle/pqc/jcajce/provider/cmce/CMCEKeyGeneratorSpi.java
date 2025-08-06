package org.bouncycastle.pqc.jcajce.provider.cmce;

import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.KeyGeneratorSpi;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.security.auth.DestroyFailedException;
import org.bouncycastle.crypto.SecretWithEncapsulation;
import org.bouncycastle.jcajce.SecretKeyWithEncapsulation;
import org.bouncycastle.jcajce.spec.KEMExtractSpec;
import org.bouncycastle.jcajce.spec.KEMGenerateSpec;
import org.bouncycastle.pqc.crypto.cmce.CMCEKEMExtractor;
import org.bouncycastle.pqc.crypto.cmce.CMCEKEMGenerator;
import org.bouncycastle.util.Arrays;

public class CMCEKeyGeneratorSpi extends KeyGeneratorSpi {
    private KEMExtractSpec extSpec;
    private KEMGenerateSpec genSpec;
    private SecureRandom random;

    public SecretKey engineGenerateKey() {
        KEMGenerateSpec kEMGenerateSpec = this.genSpec;
        if (kEMGenerateSpec != null) {
            SecretWithEncapsulation generateEncapsulated = new CMCEKEMGenerator(this.random).generateEncapsulated(((BCCMCEPublicKey) kEMGenerateSpec.getPublicKey()).getKeyParams());
            SecretKeyWithEncapsulation secretKeyWithEncapsulation = new SecretKeyWithEncapsulation(new SecretKeySpec(generateEncapsulated.getSecret(), this.genSpec.getKeyAlgorithmName()), generateEncapsulated.getEncapsulation());
            try {
                generateEncapsulated.destroy();
                return secretKeyWithEncapsulation;
            } catch (DestroyFailedException unused) {
                throw new IllegalStateException("key cleanup failed");
            }
        } else {
            CMCEKEMExtractor cMCEKEMExtractor = new CMCEKEMExtractor(((BCCMCEPrivateKey) this.extSpec.getPrivateKey()).getKeyParams());
            byte[] encapsulation = this.extSpec.getEncapsulation();
            byte[] extractSecret = cMCEKEMExtractor.extractSecret(encapsulation);
            SecretKeyWithEncapsulation secretKeyWithEncapsulation2 = new SecretKeyWithEncapsulation(new SecretKeySpec(extractSecret, this.extSpec.getKeyAlgorithmName()), encapsulation);
            Arrays.clear(extractSecret);
            return secretKeyWithEncapsulation2;
        }
    }

    public void engineInit(int i11, SecureRandom secureRandom) {
        throw new UnsupportedOperationException("Operation not supported");
    }

    public void engineInit(SecureRandom secureRandom) {
        throw new UnsupportedOperationException("Operation not supported");
    }

    public void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        this.random = secureRandom;
        if (algorithmParameterSpec instanceof KEMGenerateSpec) {
            this.genSpec = (KEMGenerateSpec) algorithmParameterSpec;
            this.extSpec = null;
        } else if (algorithmParameterSpec instanceof KEMExtractSpec) {
            this.genSpec = null;
            this.extSpec = (KEMExtractSpec) algorithmParameterSpec;
        } else {
            throw new InvalidAlgorithmParameterException("unknown spec");
        }
    }
}
