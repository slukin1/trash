package org.bouncycastle.pqc.jcajce.provider.newhope;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.ShortBufferException;
import org.bouncycastle.crypto.DerivationFunction;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.jcajce.provider.asymmetric.util.BaseAgreementSpi;
import org.bouncycastle.pqc.crypto.ExchangePair;
import org.bouncycastle.pqc.crypto.newhope.NHAgreement;
import org.bouncycastle.pqc.crypto.newhope.NHExchangePairGenerator;
import org.bouncycastle.pqc.crypto.newhope.NHPublicKeyParameters;
import org.bouncycastle.util.Arrays;

public class KeyAgreementSpi extends BaseAgreementSpi {
    private NHAgreement agreement;
    private NHExchangePairGenerator exchangePairGenerator;
    private BCNHPublicKey otherPartyKey;
    private byte[] shared;

    public KeyAgreementSpi() {
        super("NH", (DerivationFunction) null);
    }

    public byte[] doCalcSecret() {
        return engineGenerateSecret();
    }

    public void doInitFromKey(Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        throw new InvalidAlgorithmParameterException("NewHope does not require parameters");
    }

    public Key engineDoPhase(Key key, boolean z11) throws InvalidKeyException, IllegalStateException {
        if (z11) {
            BCNHPublicKey bCNHPublicKey = (BCNHPublicKey) key;
            this.otherPartyKey = bCNHPublicKey;
            NHExchangePairGenerator nHExchangePairGenerator = this.exchangePairGenerator;
            if (nHExchangePairGenerator != null) {
                ExchangePair generateExchange = nHExchangePairGenerator.generateExchange((AsymmetricKeyParameter) bCNHPublicKey.getKeyParams());
                this.shared = generateExchange.getSharedValue();
                return new BCNHPublicKey((NHPublicKeyParameters) generateExchange.getPublicKey());
            }
            this.shared = this.agreement.calculateAgreement(bCNHPublicKey.getKeyParams());
            return null;
        }
        throw new IllegalStateException("NewHope can only be between two parties.");
    }

    public int engineGenerateSecret(byte[] bArr, int i11) throws IllegalStateException, ShortBufferException {
        byte[] bArr2 = this.shared;
        System.arraycopy(bArr2, 0, bArr, i11, bArr2.length);
        Arrays.fill(this.shared, (byte) 0);
        return this.shared.length;
    }

    public byte[] engineGenerateSecret() throws IllegalStateException {
        byte[] clone = Arrays.clone(this.shared);
        Arrays.fill(this.shared, (byte) 0);
        return clone;
    }

    public void engineInit(Key key, SecureRandom secureRandom) throws InvalidKeyException {
        if (key != null) {
            NHAgreement nHAgreement = new NHAgreement();
            this.agreement = nHAgreement;
            nHAgreement.init(((BCNHPrivateKey) key).getKeyParams());
            return;
        }
        this.exchangePairGenerator = new NHExchangePairGenerator(secureRandom);
    }
}
