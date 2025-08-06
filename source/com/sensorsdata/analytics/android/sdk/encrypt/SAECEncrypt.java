package com.sensorsdata.analytics.android.sdk.encrypt;

import com.sensorsdata.analytics.android.sdk.SALog;
import com.sumsub.sns.prooface.network.b;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Security;

class SAECEncrypt implements SAEncryptListener {
    public byte[] aesKey;
    public String mEncryptKey;

    static {
        try {
            Security.addProvider((Provider) Class.forName("org.spongycastle.jce.provider.BouncyCastleProvider").newInstance());
        } catch (Exception e11) {
            SALog.i("SA.SAECEncrypt", e11.toString());
        }
    }

    public String asymmetricEncryptType() {
        return "EC";
    }

    public String encryptEvent(byte[] bArr) {
        return EncryptUtils.symmetricEncrypt(this.aesKey, bArr, SymmetricEncryptMode.AES);
    }

    public String encryptSymmetricKeyWithPublicKey(String str) {
        if (this.mEncryptKey == null) {
            try {
                byte[] generateSymmetricKey = EncryptUtils.generateSymmetricKey(SymmetricEncryptMode.AES);
                this.aesKey = generateSymmetricKey;
                this.mEncryptKey = EncryptUtils.encryptAESKey(str, generateSymmetricKey, "EC");
            } catch (NoSuchAlgorithmException e11) {
                SALog.printStackTrace(e11);
                return null;
            }
        }
        return this.mEncryptKey;
    }

    public String symmetricEncryptType() {
        return b.f40261d;
    }
}
