package org.bouncycastle.jcajce.provider.asymmetric.ec;

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.SignatureException;
import java.security.SignatureSpi;
import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.crypto.params.ParametersWithID;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.crypto.signers.SM2Signer;
import org.bouncycastle.jcajce.provider.asymmetric.util.ECUtil;
import org.bouncycastle.jcajce.spec.SM2ParameterSpec;
import org.bouncycastle.jcajce.util.BCJcaJceHelper;
import org.bouncycastle.jcajce.util.JcaJceHelper;

public class GMSignatureSpi extends SignatureSpi {
    private AlgorithmParameters engineParams;
    private final JcaJceHelper helper = new BCJcaJceHelper();
    private SM2ParameterSpec paramSpec;
    private final SM2Signer signer;

    public static class sha256WithSM2 extends GMSignatureSpi {
        public sha256WithSM2() {
            super(new SM2Signer((Digest) new SHA256Digest()));
        }
    }

    public static class sm3WithSM2 extends GMSignatureSpi {
        public sm3WithSM2() {
            super(new SM2Signer());
        }
    }

    public GMSignatureSpi(SM2Signer sM2Signer) {
        this.signer = sM2Signer;
    }

    public Object engineGetParameter(String str) {
        throw new UnsupportedOperationException("engineGetParameter unsupported");
    }

    public AlgorithmParameters engineGetParameters() {
        if (this.engineParams == null && this.paramSpec != null) {
            try {
                AlgorithmParameters createAlgorithmParameters = this.helper.createAlgorithmParameters("PSS");
                this.engineParams = createAlgorithmParameters;
                createAlgorithmParameters.init(this.paramSpec);
            } catch (Exception e11) {
                throw new RuntimeException(e11.toString());
            }
        }
        return this.engineParams;
    }

    public void engineInitSign(PrivateKey privateKey) throws InvalidKeyException {
        CipherParameters generatePrivateKeyParameter = ECUtil.generatePrivateKeyParameter(privateKey);
        SecureRandom secureRandom = this.appRandom;
        if (secureRandom != null) {
            generatePrivateKeyParameter = new ParametersWithRandom(generatePrivateKeyParameter, secureRandom);
        }
        SM2ParameterSpec sM2ParameterSpec = this.paramSpec;
        if (sM2ParameterSpec != null) {
            this.signer.init(true, new ParametersWithID(generatePrivateKeyParameter, sM2ParameterSpec.getID()));
        } else {
            this.signer.init(true, generatePrivateKeyParameter);
        }
    }

    public void engineInitVerify(PublicKey publicKey) throws InvalidKeyException {
        CipherParameters generatePublicKeyParameter = ECUtils.generatePublicKeyParameter(publicKey);
        SM2ParameterSpec sM2ParameterSpec = this.paramSpec;
        if (sM2ParameterSpec != null) {
            generatePublicKeyParameter = new ParametersWithID(generatePublicKeyParameter, sM2ParameterSpec.getID());
        }
        this.signer.init(false, generatePublicKeyParameter);
    }

    public void engineSetParameter(String str, Object obj) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    public void engineSetParameter(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidAlgorithmParameterException {
        if (algorithmParameterSpec instanceof SM2ParameterSpec) {
            this.paramSpec = (SM2ParameterSpec) algorithmParameterSpec;
            return;
        }
        throw new InvalidAlgorithmParameterException("only SM2ParameterSpec supported");
    }

    public byte[] engineSign() throws SignatureException {
        try {
            return this.signer.generateSignature();
        } catch (CryptoException e11) {
            throw new SignatureException("unable to create signature: " + e11.getMessage());
        }
    }

    public void engineUpdate(byte b11) throws SignatureException {
        this.signer.update(b11);
    }

    public void engineUpdate(byte[] bArr, int i11, int i12) throws SignatureException {
        this.signer.update(bArr, i11, i12);
    }

    public boolean engineVerify(byte[] bArr) throws SignatureException {
        return this.signer.verifySignature(bArr);
    }
}
