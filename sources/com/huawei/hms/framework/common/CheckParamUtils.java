package com.huawei.hms.framework.common;

import com.amazonaws.services.s3.model.InstructionFileId;
import java.util.Objects;
import java.util.regex.Pattern;

public class CheckParamUtils {
    private static final String IPV6_REGEX = "(^((([0-9A-Fa-f]{1,4}:){7}(([0-9A-Fa-f]{1,4}){1}|:))|(([0-9A-Fa-f]{1,4}:){6}((:[0-9A-Fa-f]{1,4}){1}|((22[0-3]|2[0-1][0-9]|[0-1][0-9][0-9]|([0-9]){1,2})([.](25[0-5]|2[0-4][0-9]|[0-1][0-9][0-9]|([0-9]){1,2})){3})|:))|(([0-9A-Fa-f]{1,4}:){5}((:[0-9A-Fa-f]{1,4}){1,2}|:((22[0-3]|2[0-1][0-9]|[0-1][0-9][0-9]|([0-9]){1,2})([.](25[0-5]|2[0-4][0-9]|[0-1][0-9][0-9]|([0-9]){1,2})){3})|:))|(([0-9A-Fa-f]{1,4}:){4}((:[0-9A-Fa-f]{1,4}){1,3}|:((22[0-3]|2[0-1][0-9]|[0-1][0-9][0-9]|([0-9]){1,2})([.](25[0-5]|2[0-4][0-9]|[0-1][0-9][0-9]|([0-9]){1,2})){3})|:))|(([0-9A-Fa-f]{1,4}:){3}((:[0-9A-Fa-f]{1,4}){1,4}|:((22[0-3]|2[0-1][0-9]|[0-1][0-9][0-9]|([0-9]){1,2})([.](25[0-5]|2[0-4][0-9]|[0-1][0-9][0-9]|([0-9]){1,2})){3})|:))|(([0-9A-Fa-f]{1,4}:){2}((:[0-9A-Fa-f]{1,4}){1,5}|:((22[0-3]|2[0-1][0-9]|[0-1][0-9][0-9]|([0-9]){1,2})([.](25[0-5]|2[0-4][0-9]|[0-1][0-9][0-9]|([0-9]){1,2})){3})|:))|(([0-9A-Fa-f]{1,4}:){1}((:[0-9A-Fa-f]{1,4}){1,6}|:((22[0-3]|2[0-1][0-9]|[0-1][0-9][0-9]|([0-9]){1,2})([.](25[0-5]|2[0-4][0-9]|[0-1][0-9][0-9]|([0-9]){1,2})){3})|:))|(:((:[0-9A-Fa-f]{1,4}){1,7}|(:[fF]{4}){0,1}:((22[0-3]|2[0-1][0-9]|[0-1][0-9][0-9]|([0-9]){1,2})([.](25[0-5]|2[0-4][0-9]|[0-1][0-9][0-9]|([0-9]){1,2})){3})|:)))$)";
    private static final String TAG = "CheckParamUtils";
    private static Pattern ipv6Pattern = Pattern.compile(IPV6_REGEX);

    public static <T> T checkNotNull(T t11, String str) {
        Objects.requireNonNull(t11, str);
        return t11;
    }

    public static int checkNumParam(int i11, int i12, int i13, int i14, String str) {
        if (i11 > i13 || i11 < i12) {
            return i14;
        }
        Logger.d(TAG, str);
        return i11;
    }

    public static void checkOffsetAndCount(long j11, long j12, long j13) {
        if ((j12 | j13) < 0 || j12 > j11 || j11 - j12 < j13) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static boolean isIpV4(String str) {
        if (str == null || str.isEmpty() || str.length() > 15 || !str.replace(InstructionFileId.DOT, "").matches("[0-9]+")) {
            return false;
        }
        String[] split = str.split("\\.");
        if (split.length != 4) {
            return false;
        }
        for (String str2 : split) {
            if (str2.length() > 4 || Integer.parseInt(str2) > 255) {
                return false;
            }
        }
        return true;
    }

    public static boolean isIpV6(String str) {
        if (str == null || str.isEmpty() || str.length() < 2 || str.length() > 39) {
            return false;
        }
        return ipv6Pattern.matcher(str).matches();
    }

    public static long checkNumParam(long j11, long j12, long j13, long j14, String str) {
        if (j11 > j13 || j11 < j12) {
            return j14;
        }
        Logger.d(TAG, str);
        return j11;
    }
}
