package org.bouncycastle.jcajce.provider.asymmetric.dsa;

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.DSAParameterSpec;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.crypto.generators.DSAParametersGenerator;
import org.bouncycastle.crypto.params.DSAParameterGenerationParameters;
import org.bouncycastle.crypto.params.DSAParameters;
import org.bouncycastle.jcajce.provider.asymmetric.util.BaseAlgorithmParameterGeneratorSpi;
import org.bouncycastle.jcajce.provider.asymmetric.util.PrimeCertaintyCalculator;

public class AlgorithmParameterGeneratorSpi extends BaseAlgorithmParameterGeneratorSpi {
    public DSAParameterGenerationParameters params;
    public SecureRandom random;
    public int strength = 2048;

    public AlgorithmParameters engineGenerateParameters() {
        DSAParametersGenerator dSAParametersGenerator = this.strength <= 1024 ? new DSAParametersGenerator() : new DSAParametersGenerator(new SHA256Digest());
        if (this.random == null) {
            this.random = CryptoServicesRegistrar.getSecureRandom();
        }
        int defaultCertainty = PrimeCertaintyCalculator.getDefaultCertainty(this.strength);
        int i11 = this.strength;
        if (i11 == 1024) {
            DSAParameterGenerationParameters dSAParameterGenerationParameters = new DSAParameterGenerationParameters(1024, 160, defaultCertainty, this.random);
            this.params = dSAParameterGenerationParameters;
            dSAParametersGenerator.init(dSAParameterGenerationParameters);
        } else if (i11 > 1024) {
            DSAParameterGenerationParameters dSAParameterGenerationParameters2 = new DSAParameterGenerationParameters(i11, 256, defaultCertainty, this.random);
            this.params = dSAParameterGenerationParameters2;
            dSAParametersGenerator.init(dSAParameterGenerationParameters2);
        } else {
            dSAParametersGenerator.init(i11, defaultCertainty, this.random);
        }
        DSAParameters generateParameters = dSAParametersGenerator.generateParameters();
        try {
            AlgorithmParameters createParametersInstance = createParametersInstance("DSA");
            createParametersInstance.init(new DSAParameterSpec(generateParameters.getP(), generateParameters.getQ(), generateParameters.getG()));
            return createParametersInstance;
        } catch (Exception e11) {
            throw new RuntimeException(e11.getMessage());
        }
    }

    public void engineInit(int i11, SecureRandom secureRandom) {
        if (i11 < 512 || i11 > 3072) {
            throw new InvalidParameterException("strength must be from 512 - 3072");
        } else if (i11 <= 1024 && i11 % 64 != 0) {
            throw new InvalidParameterException("strength must be a multiple of 64 below 1024 bits.");
        } else if (i11 <= 1024 || i11 % 1024 == 0) {
            this.strength = i11;
            this.random = secureRandom;
        } else {
            throw new InvalidParameterException("strength must be a multiple of 1024 above 1024 bits.");
        }
    }

    public void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        throw new InvalidAlgorithmParameterException("No supported AlgorithmParameterSpec for DSA parameter generation.");
    }
}
