package com.alibaba.sdk.android.tbrest.utils;

import com.huawei.hms.framework.common.ContainerUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Map;

public class StringUtils {
    public static String a(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        boolean z11 = true;
        StringBuffer stringBuffer = new StringBuffer();
        for (String next : map.keySet()) {
            String str = map.get(next);
            if (!(str == null || next == null)) {
                if (z11) {
                    if (!"--invalid--".equals(str)) {
                        stringBuffer.append(next + ContainerUtils.KEY_VALUE_DELIMITER + str);
                    } else {
                        stringBuffer.append(next);
                    }
                    z11 = false;
                } else if (!"--invalid--".equals(str)) {
                    stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    stringBuffer.append(next + ContainerUtils.KEY_VALUE_DELIMITER + str);
                } else {
                    stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    stringBuffer.append(next);
                }
            }
        }
        return stringBuffer.toString();
    }

    public static String b(Object obj) {
        if (obj == null) {
            return "";
        }
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof Integer) {
            return "" + ((Integer) obj).intValue();
        } else if (obj instanceof Long) {
            return "" + ((Long) obj).longValue();
        } else if (obj instanceof Double) {
            return "" + ((Double) obj).doubleValue();
        } else if (obj instanceof Float) {
            return "" + ((Float) obj).floatValue();
        } else if (obj instanceof Short) {
            return "" + ((Short) obj).shortValue();
        } else if (obj instanceof Byte) {
            return "" + ((Byte) obj).byteValue();
        } else if (obj instanceof Boolean) {
            return ((Boolean) obj).toString();
        } else {
            if (obj instanceof Character) {
                return ((Character) obj).toString();
            }
            return obj.toString();
        }
    }

    public static boolean c(CharSequence charSequence) {
        int length;
        if (!(charSequence == null || (length = charSequence.length()) == 0)) {
            for (int i11 = 0; i11 < length; i11++) {
                if (!Character.isWhitespace(charSequence.charAt(i11))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean d(String str) {
        return str == null || str.length() <= 0;
    }

    public static boolean e(CharSequence charSequence) {
        return !c(charSequence);
    }
}
