package com.engagelab.privates.common.utils;

import android.text.TextUtils;
import android.util.Log;
import com.google.common.base.Ascii;
import java.util.Arrays;
import net.sf.scuba.smartcards.ISO7816;

public class Guard {
    public static byte[] guard(byte[] bArr) {
        try {
            byte[] bArr2 = {32, Ascii.EM, 8, 22, 17, ISO7816.INS_DECREASE};
            byte[] bArr3 = new byte[bArr.length];
            for (int i11 = 0; i11 < bArr.length; i11++) {
                bArr3[i11] = (byte) (bArr[i11] ^ bArr2[(bArr.length + i11) % 6]);
            }
            return bArr3;
        } catch (Throwable unused) {
            return new byte[0];
        }
    }

    public static String string(byte[] bArr) {
        return new String(guard(bArr));
    }

    public static void test(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                byte[] guard = guard(str.getBytes());
                Log.e("xxx", "guard=" + Arrays.toString(guard));
                byte[] guard2 = guard(guard);
                Log.e("xxx", "reverse=" + new String(guard2));
            } catch (Throwable th2) {
                Log.e("xxx", "e:" + th2);
            }
        }
    }
}
