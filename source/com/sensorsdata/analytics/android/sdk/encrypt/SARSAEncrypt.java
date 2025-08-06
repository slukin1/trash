package com.sensorsdata.analytics.android.sdk.encrypt;

import com.sensorsdata.analytics.android.sdk.SALog;
import com.sumsub.sns.prooface.network.b;
import java.security.NoSuchAlgorithmException;

class SARSAEncrypt implements SAEncryptListener {
    public byte[] aesKey;
    public String mEncryptKey;

    public String asymmetricEncryptType() {
        return "RSA";
    }

    public String encryptEvent(byte[] bArr) {
        return EncryptUtils.symmetricEncrypt(this.aesKey, bArr, SymmetricEncryptMode.AES);
    }

    public String encryptSymmetricKeyWithPublicKey(String str) {
        if (this.mEncryptKey == null) {
            try {
                byte[] generateSymmetricKey = EncryptUtils.generateSymmetricKey(SymmetricEncryptMode.AES);
                this.aesKey = generateSymmetricKey;
                this.mEncryptKey = EncryptUtils.encryptAESKey(str, generateSymmetricKey, "RSA");
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
