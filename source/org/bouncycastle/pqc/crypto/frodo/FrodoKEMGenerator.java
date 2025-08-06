package org.bouncycastle.pqc.crypto.frodo;

import java.security.SecureRandom;
import org.bouncycastle.crypto.EncapsulatedSecretGenerator;
import org.bouncycastle.crypto.SecretWithEncapsulation;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.pqc.crypto.util.SecretWithEncapsulationImpl;

public class FrodoKEMGenerator implements EncapsulatedSecretGenerator {

    /* renamed from: sr  reason: collision with root package name */
    private final SecureRandom f59521sr;

    public FrodoKEMGenerator(SecureRandom secureRandom) {
        this.f59521sr = secureRandom;
    }

    public SecretWithEncapsulation generateEncapsulated(AsymmetricKeyParameter asymmetricKeyParameter) {
        FrodoPublicKeyParameters frodoPublicKeyParameters = (FrodoPublicKeyParameters) asymmetricKeyParameter;
        FrodoEngine engine = frodoPublicKeyParameters.getParameters().getEngine();
        byte[] bArr = new byte[engine.getCipherTextSize()];
        byte[] bArr2 = new byte[engine.getSessionKeySize()];
        engine.kem_enc(bArr, bArr2, frodoPublicKeyParameters.getPublicKey(), this.f59521sr);
        return new SecretWithEncapsulationImpl(bArr2, bArr);
    }
}
