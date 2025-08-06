package com.tencent.android.tpush.encrypt;

import com.huobi.finance.bean.LoanOrderItem;
import com.tencent.android.tpush.common.j;
import com.tencent.android.tpush.service.channel.security.TpnsSecurity;

public class Rijndael {
    public static String decrypt(String str) {
        try {
            if (j.b(str)) {
                return "";
            }
            String oiSymmetryDecrypt2 = TpnsSecurity.oiSymmetryDecrypt2(str);
            for (int i11 = 0; i11 < 3; i11++) {
                if (!LoanOrderItem.FAILED.equals(oiSymmetryDecrypt2)) {
                    return oiSymmetryDecrypt2;
                }
                oiSymmetryDecrypt2 = TpnsSecurity.oiSymmetryDecrypt2(str);
            }
            return "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String encrypt(String str) {
        try {
            if (j.b(str)) {
                return "";
            }
            String oiSymmetryEncrypt2 = TpnsSecurity.oiSymmetryEncrypt2(str);
            for (int i11 = 0; i11 < 3; i11++) {
                if (!LoanOrderItem.FAILED.equals(oiSymmetryEncrypt2)) {
                    return oiSymmetryEncrypt2;
                }
                oiSymmetryEncrypt2 = TpnsSecurity.oiSymmetryEncrypt2(str);
            }
            return "";
        } catch (Throwable unused) {
            return "";
        }
    }
}
