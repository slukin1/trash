package com.huawei.hms.push.utils;

import com.amazonaws.services.s3.model.InstructionFileId;
import com.huawei.hms.support.log.HMSLog;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;

public class DateUtil {
    private DateUtil() {
    }

    public static String parseMilliSecondToString(Long l11) {
        if (l11 == null) {
            return null;
        }
        try {
            return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").format(l11);
        } catch (Exception e11) {
            HMSLog.e("DateUtil", "parseMilliSecondToString Exception.", (Throwable) e11);
            return null;
        }
    }

    public static long parseUtcToMillisecond(String str) throws ParseException, StringIndexOutOfBoundsException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone(UtcDates.UTC));
        String substring = str.substring(0, str.indexOf(InstructionFileId.DOT));
        String substring2 = str.substring(str.indexOf(InstructionFileId.DOT));
        return simpleDateFormat.parse(substring + (substring2.substring(0, 4) + "Z")).getTime();
    }
}
