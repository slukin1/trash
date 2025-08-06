package com.engagelab.privates.common.utils;

import android.text.TextUtils;
import android.util.Base64;
import com.engagelab.privates.common.log.MTCommonLog;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.security.KeyFactory;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import net.sf.scuba.smartcards.ISO7816;
import net.sf.scuba.smartcards.ISOFileInfo;
import org.jmrtd.lds.CVCAFile;

public class RsaUitl {
    private static final String RSA_MODE = Guard.string(new byte[]{ISO7816.INS_REHABILITATE_CHV, CVCAFile.CAR_TAG, 113, 15, 87, 103, Framer.EXIT_FRAME_PREFIX, 116, Ascii.US, ISO7816.INS_MANAGE_CHANNEL, 82, 75, 69, 32, 96, 65, 125, 108, Ascii.DEL, Ascii.DEL, 87});
    private static final String RSA_PUBLIC_KEY_HEX_STRING = Guard.string(new byte[]{69, 80, 102, 71, 100, 72, 81, 92, 90, 95, 122, 80, 96, 96, 114, 126, 97, 72, 77, 84, 83, 97, 97, 93, 91, 97, 80, 71, 115, 88, CVCAFile.CAR_TAG, 84, 80, 124, 16, 107, ISOFileInfo.FCP_BYTE, 97, 103, 0, 77, 95, 123, 89, 40, 99, ISO7816.INS_MANAGE_CHANNEL, SignedBytes.MAX_POWER_OF_TWO, 90, 47, 89, 90, 20, 95, 94, 47, 75, 125, 116, Framer.EXIT_FRAME_PREFIX, 57, 82, 41, 65, ISO7816.INS_REHABILITATE_CHV, 125, 89, 93, 103, 70, 79, 119, 58, 84, 92, 104, 78, 90, 101, 100, 101, 0, 108, 67, 109, 99, 85, 4, Ascii.CAN, 67, ISOFileInfo.FCI_BYTE, 125, 80, 74, 70, 79, 113, 100, 83, 97, 78, 65, 123, 114, 122, 92, 76, 123, 56, 84, 122, 114, 65, 86, 71, 32, 118, 123, 109, 90, 73, 97, 84, 113, 97, 72, 53, 43});
    private static final String TAG = "RsaUitl";

    public static String deRsa(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            String decodeRsaPubKey = decodeRsaPubKey();
            MTCommonLog.d(TAG, "decodeRsaPubKey " + decodeRsaPubKey);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("RSA_MODE ");
            String str2 = RSA_MODE;
            sb2.append(str2);
            MTCommonLog.d(TAG, sb2.toString());
            return rsaDecryptString(str, decodeRsaPubKey(), str2);
        } catch (Throwable th2) {
            MTCommonLog.d(TAG, "deRsa " + th2.getMessage());
            return "";
        }
    }

    private static String decodeRsaPubKey() {
        try {
            return RSA_PUBLIC_KEY_HEX_STRING;
        } catch (Throwable th2) {
            MTCommonLog.d(TAG, "decodeRsaPubKey " + th2.getMessage());
            return "";
        }
    }

    private static RSAPublicKey loadRSAKey(String str) {
        try {
            return (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str, 2)));
        } catch (Throwable th2) {
            MTCommonLog.d(TAG, "rsa loadRSAKey e=" + th2);
            return null;
        }
    }

    private static synchronized byte[] rsaDecrypt(String str, RSAPublicKey rSAPublicKey, String str2) throws Exception {
        byte[] decode;
        synchronized (RsaUitl.class) {
            byte[] decode2 = Base64.decode(str, 2);
            Cipher instance = Cipher.getInstance(str2);
            instance.init(2, rSAPublicKey);
            decode = Base64.decode(instance.doFinal(decode2), 2);
        }
        return decode;
    }

    private static String rsaDecryptString(String str, String str2, String str3) throws Exception {
        return new String(Base64.encode(rsaDecrypt(str, loadRSAKey(str2), str3), 2), "UTF-8");
    }
}
