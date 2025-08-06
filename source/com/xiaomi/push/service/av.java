package com.xiaomi.push.service;

import android.text.TextUtils;
import android.util.Base64;
import com.google.common.base.Ascii;
import com.xiaomi.channel.commonutils.logger.b;
import java.io.ByteArrayOutputStream;
import java.security.KeyFactory;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import net.sf.scuba.smartcards.ISO7816;
import net.sf.scuba.smartcards.ISOFileInfo;
import org.jmrtd.lds.CVCAFile;

public class av {

    /* renamed from: a  reason: collision with root package name */
    private static RSAPublicKey f52528a;

    /* renamed from: a  reason: collision with other field name */
    private static final byte[] f3358a;

    static {
        byte[] bArr = {ISO7816.INS_DECREASE, ISOFileInfo.DATA_BYTES2, -97, ISO7816.INS_DECREASE, 13, 6, 9, ISO7816.INS_PSO, -122, 72, -122, -9, 13, 1, 1, 1, 5, 0, 3, ISOFileInfo.DATA_BYTES2, ISOFileInfo.ENV_TEMP_EF, 0, ISO7816.INS_DECREASE, ISOFileInfo.DATA_BYTES2, -119, 2, ISOFileInfo.DATA_BYTES2, ISOFileInfo.DATA_BYTES2, 0, -109, ISO7816.INS_PUT_DATA, ISOFileInfo.CHANNEL_SECURITY, Ascii.SUB, -72, 78, 16, 70, -90, 113, ISO7816.INS_APPEND_RECORD, ISO7816.INS_CHANGE_CHV, 85, -3, -43, 123, 61, -98, 4, -16, 67, 19, -90, -73, -5, -89, ISO7816.INS_CHANGE_CHV, ISO7816.INS_UNBLOCK_CHV, -27, 59, ISOFileInfo.PROP_INFO, 72, -73, ISO7816.INS_WRITE_BINARY, Framer.STDOUT_FRAME_PREFIX, 13, 16, 50, -27, -82, 18, ISO7816.INS_DELETE_FILE, 84, 0, -41, 16, 69, -39, 7, 82, 56, 79, -37, 40, 85, 107, ISOFileInfo.FCP_BYTE, Framer.ENTER_FRAME_PREFIX, 123, -34, -49, ISOFileInfo.FCI_BYTE, -11, Framer.STDOUT_FRAME_PREFIX, 28, 117, ISO7816.INS_READ_RECORD_STAMPED, 114, -122, -29, -84, 82, 22, -122, ISO7816.INS_PSO, ISO7816.INS_LOAD_KEY_FILE, ISO7816.INS_READ_BINARY2, 18, ISOFileInfo.SECURITY_ATTR_COMPACT, ISO7816.INS_UPDATE_BINARY, 101, -70, ISO7816.INS_UNBLOCK_CHV, 11, 62, -49, -3, -22, -2, CVCAFile.CAR_TAG, 90, ISOFileInfo.SECURITY_ATTR_COMPACT, -75, -99, ISO7816.INS_MSE, 121, 69, 10, -81, -57, 89, -23, ISO7816.INS_UPDATE_RECORD, -60, -81, 67, ISOFileInfo.CHANNEL_SECURITY, 10, 79, 100, 29, 47, -24, 110, -66, -7, 87, 16, ISOFileInfo.FILE_IDENTIFIER, ISOFileInfo.A5, -43, -103, 67, -20, 41, 117, -37, -11, 2, 3, 1, 0, 1};
        f3358a = bArr;
        try {
            f52528a = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(bArr));
        } catch (Throwable unused) {
            b.d("rsa key pair init failure!!!");
        }
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            instance.init(1, f52528a);
            return Base64.encodeToString(a(instance, 1, str.getBytes("UTF-8"), f52528a.getModulus().bitLength()), 2);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static byte[] a(Cipher cipher, int i11, byte[] bArr, int i12) {
        int i13;
        byte[] bArr2;
        if (cipher == null || bArr == null) {
            return null;
        }
        if (i11 == 2) {
            i13 = i12 / 8;
        } else {
            i13 = (i12 / 8) - 11;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int i14 = 0;
            int i15 = 0;
            while (bArr.length > i14) {
                if (bArr.length - i14 > i13) {
                    bArr2 = cipher.doFinal(bArr, i14, i13);
                } else {
                    bArr2 = cipher.doFinal(bArr, i14, bArr.length - i14);
                }
                byteArrayOutputStream.write(bArr2, 0, bArr2.length);
                i15++;
                i14 = i15 * i13;
            }
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e11) {
            throw new RuntimeException(e11);
        }
    }
}
