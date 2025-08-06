package com.huawei.hms.framework.common;

import android.annotation.SuppressLint;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;

public class SecurityRandomHelper {
    @SuppressLint({"StaticFieldLeak"})
    public static volatile SecurityRandomHelper instance;

    private SecurityRandomHelper() {
    }

    public static SecurityRandomHelper getInstance() {
        if (instance == null) {
            synchronized (SecurityRandomHelper.class) {
                if (instance == null) {
                    EncryptUtil.e(true);
                    instance = new SecurityRandomHelper();
                }
            }
        }
        return instance;
    }

    public byte[] generateSecureRandom(int i11) {
        return EncryptUtil.c(i11);
    }

    public String generateSecureRandomStr(int i11) {
        return EncryptUtil.d(i11);
    }
}
