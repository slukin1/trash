package com.huobi.utils;

import com.hbg.lib.common.utils.StringUtils;

@Deprecated
public class StringUtilsTodo {
    public static int a(String str) {
        int i11 = 0;
        if (str == null) {
            return 0;
        }
        try {
            if (str.length() < 8) {
                return 0;
            }
            if (StringUtils.t("^[0-9]+$", str)) {
                return 0;
            }
            if (str.length() >= 8) {
                i11 = 3;
            }
            if (str.length() >= 10) {
                i11++;
            }
            if (StringUtils.t("[0-9]+", str)) {
                i11++;
            }
            if (StringUtils.t("[A-Z]+", str)) {
                i11++;
            }
            if (StringUtils.t("[a-z]+", str)) {
                i11++;
            }
            if (StringUtils.t("[!@#$%^&*?_~-£(,)]+", str)) {
                return i11 + 1;
            }
            return i11;
        } catch (Exception e11) {
            e11.printStackTrace();
            return 0;
        }
    }
}
