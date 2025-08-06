package zendesk.core;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

class BlipsFormatHelper {
    public static final String BLIPS_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
    private static final String UTC_TIMEZONE = "UTC";
    private static final String VERSION_NAME_FORMAT = "%s:%s";

    public static String nowAsString(Date date) {
        Date date2 = date == null ? new Date() : new Date(date.getTime());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return simpleDateFormat.format(date2);
    }
}
