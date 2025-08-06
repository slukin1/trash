package com.twitter.sdk.android.tweetui;

import android.content.res.Resources;
import androidx.collection.SparseArrayCompat;
import com.hbg.lib.network.pro.core.util.Period;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

final class TweetDateUtils {
    public static final SimpleDateFormat DATE_TIME_RFC822 = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.ENGLISH);
    public static final long INVALID_DATE = -1;
    public static final DateFormatter RELATIVE_DATE_FORMAT = new DateFormatter();

    public static class DateFormatter {
        private Locale currentLocale;
        private final SparseArrayCompat<SimpleDateFormat> dateFormatArray = new SparseArrayCompat<>();

        private synchronized DateFormat getDateFormat(Resources resources, int i11) {
            SimpleDateFormat g11;
            Locale locale = this.currentLocale;
            if (locale == null || locale != resources.getConfiguration().locale) {
                this.currentLocale = resources.getConfiguration().locale;
                this.dateFormatArray.c();
            }
            g11 = this.dateFormatArray.g(i11);
            if (g11 == null) {
                g11 = new SimpleDateFormat(resources.getString(i11), Locale.getDefault());
                this.dateFormatArray.m(i11, g11);
            }
            return g11;
        }

        public synchronized String formatLongDateString(Resources resources, Date date) {
            return getDateFormat(resources, R.string.tw__relative_date_format_long).format(date);
        }

        public synchronized String formatShortDateString(Resources resources, Date date) {
            return getDateFormat(resources, R.string.tw__relative_date_format_short).format(date);
        }
    }

    private TweetDateUtils() {
    }

    public static long apiTimeToLong(String str) {
        if (str == null) {
            return -1;
        }
        try {
            return DATE_TIME_RFC822.parse(str).getTime();
        } catch (ParseException unused) {
            return -1;
        }
    }

    public static String dotPrefix(String str) {
        return "• " + str;
    }

    public static String getRelativeTimeString(Resources resources, long j11, long j12) {
        long j13 = j11 - j12;
        if (j13 < 0) {
            return RELATIVE_DATE_FORMAT.formatLongDateString(resources, new Date(j12));
        }
        if (j13 < 60000) {
            int i11 = (int) (j13 / 1000);
            return resources.getQuantityString(R.plurals.tw__time_secs, i11, new Object[]{Integer.valueOf(i11)});
        } else if (j13 < Period.MIN60_MILLS) {
            int i12 = (int) (j13 / 60000);
            return resources.getQuantityString(R.plurals.tw__time_mins, i12, new Object[]{Integer.valueOf(i12)});
        } else if (j13 < Period.DAY_MILLS) {
            int i13 = (int) (j13 / Period.MIN60_MILLS);
            return resources.getQuantityString(R.plurals.tw__time_hours, i13, new Object[]{Integer.valueOf(i13)});
        } else {
            Calendar instance = Calendar.getInstance();
            instance.setTimeInMillis(j11);
            Calendar instance2 = Calendar.getInstance();
            instance2.setTimeInMillis(j12);
            Date date = new Date(j12);
            if (instance.get(1) == instance2.get(1)) {
                return RELATIVE_DATE_FORMAT.formatShortDateString(resources, date);
            }
            return RELATIVE_DATE_FORMAT.formatLongDateString(resources, date);
        }
    }

    public static boolean isValidTimestamp(String str) {
        return apiTimeToLong(str) != -1;
    }
}
