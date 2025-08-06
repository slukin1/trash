package com.huawei.hms.utils;

import com.google.android.exoplayer2.audio.AacUtil;
import com.huawei.hms.framework.common.ExceptionCode;
import com.iproov.sdk.bridge.OptionsBridge;
import java.util.regex.Pattern;

public class StringUtil {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f38627a = Pattern.compile("(^([0-9]{1,2}\\.){2}[0-9]{1,2}$)|(^([0-9]{1,2}\\.){3}[0-9]{1,3}$)");

    private StringUtil() {
    }

    public static String addByteForNum(String str, int i11, char c11) {
        if (str == null) {
            str = "";
        }
        int length = str.length();
        if (length == i11) {
            return str;
        }
        if (length > i11) {
            return str.substring(length - i11);
        }
        StringBuffer stringBuffer = new StringBuffer();
        while (length < i11) {
            stringBuffer.append(c11);
            length++;
        }
        stringBuffer.append(str);
        return stringBuffer.toString();
    }

    public static boolean checkVersion(String str) {
        return f38627a.matcher(str).find();
    }

    public static int convertVersion2Integer(String str) {
        if (!checkVersion(str)) {
            return 0;
        }
        String[] split = str.split("\\.");
        if (split.length < 3) {
            return 0;
        }
        int parseInt = (Integer.parseInt(split[0]) * ExceptionCode.CRASH_EXCEPTION) + (Integer.parseInt(split[1]) * AacUtil.AAC_LC_MAX_RATE_BYTES_PER_SECOND) + (Integer.parseInt(split[2]) * 1000);
        return split.length == 4 ? parseInt + Integer.parseInt(split[3]) : parseInt;
    }

    public static String objDesc(Object obj) {
        if (obj == null) {
            return OptionsBridge.NULL_VALUE;
        }
        return obj.getClass().getName() + '@' + Integer.toHexString(obj.hashCode());
    }
}
