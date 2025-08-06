package org.bouncycastle.crypto.agreement;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.generators.DHKeyPairGenerator;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.DHKeyGenerationParameters;
import org.bouncycastle.crypto.params.DHParameters;
import org.bouncycastle.crypto.params.DHPrivateKeyParameters;
import org.bouncycastle.crypto.params.DHPublicKeyParameters;
import org.bouncycastle.crypto.params.ParametersWithRandom;

public class DHAgreement {
    private static final BigInteger ONE = BigInteger.valueOf(1);
    private DHParameters dhParams;
    private DHPrivateKeyParameters key;
    private BigInteger privateValue;
    private SecureRandom random;

    public BigInteger calculateAgreement(DHPublicKeyParameters dHPublicKeyParameters, BigInteger bigInteger) {
        if (dHPublicKeyParameters.getParameters().equals(this.dhParams)) {
            BigInteger p11 = this.dhParams.getP();
            BigInteger y11 = dHPublicKeyParameters.getY();
            if (y11 != null) {
                BigInteger bigInteger2 = ONE;
                if (y11.compareTo(bigInteger2) > 0 && y11.compareTo(p11.subtract(bigInteger2)) < 0) {
                    BigInteger modPow = y11.modPow(this.privateValue, p11);
                    if (!modPow.equals(bigInteger2)) {
                        return bigInteger.modPow(this.key.getX(), p11).multiply(modPow).mod(p11);
                    }
                    throw new IllegalStateException("Shared key can't be 1");
                }
            }
            throw new IllegalArgumentException("Diffie-Hellman public key is weak");
        }
        throw new IllegalArgumentException("Diffie-Hellman public key has wrong parameters.");
    }

    public BigInteger calculateMessage() {
        DHKeyPairGenerator dHKeyPairGenerator = new DHKeyPairGenerator();
        dHKeyPairGenerator.init(new DHKeyGenerationParameters(this.random, this.dhParams));
        AsymmetricCipherKeyPair generateKeyPair = dHKeyPairGenerator.generateKeyPair();
        this.privateValue = ((DHPrivateKeyParameters) generateKeyPair.getPrivate()).getX();
        return ((DHPublicKeyParameters) generateKeyPair.getPublic()).getY();
    }

    public void init(CipherParameters cipherParameters) {
        if (cipherParameters instanceof ParametersWithRandom) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            this.random = parametersWithRandom.getRandom();
            cipherParameters = parametersWithRandom.getParameters();
        } else {
            this.random = CryptoServicesRegistrar.getSecureRandom();
        }
        AsymmetricKeyParameter asymmetricKeyParameter = (AsymmetricKeyParameter) cipherParameters;
        if (asymmetricKeyParameter instanceof DHPrivateKeyParameters) {
            DHPrivateKeyParameters dHPrivateKeyParameters = (DHPrivateKeyParameters) asymmetricKeyParameter;
            this.key = dHPrivateKeyParameters;
            this.dhParams = dHPrivateKeyParameters.getParameters();
            return;
        }
        throw new IllegalArgumentException("DHEngine expects DHPrivateKeyParameters");
    }
}
