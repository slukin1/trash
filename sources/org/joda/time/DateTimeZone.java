package org.joda.time;

import com.xiaomi.mipush.sdk.Constants;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;
import org.joda.convert.FromString;
import org.joda.convert.ToString;
import org.joda.time.chrono.BaseChronology;
import org.joda.time.field.e;
import org.joda.time.format.DateTimeFormatterBuilder;
import org.joda.time.format.h;
import org.joda.time.tz.DefaultNameProvider;
import org.joda.time.tz.FixedDateTimeZone;
import org.joda.time.tz.a;
import org.joda.time.tz.b;

public abstract class DateTimeZone implements Serializable {
    private static final int MAX_MILLIS = 86399999;
    public static final DateTimeZone UTC = UTCDateTimeZone.INSTANCE;
    private static final AtomicReference<DateTimeZone> cDefault = new AtomicReference<>();
    private static final AtomicReference<a> cNameProvider = new AtomicReference<>();
    private static final AtomicReference<b> cProvider = new AtomicReference<>();
    private static final long serialVersionUID = 5546345482340108586L;
    private final String iID;

    public static final class LazyInit {

        /* renamed from: a  reason: collision with root package name */
        public static final Map<String, String> f23028a = b();

        /* renamed from: b  reason: collision with root package name */
        public static final org.joda.time.format.b f23029b = a();

        public static org.joda.time.format.b a() {
            return new DateTimeFormatterBuilder().M((String) null, true, 2, 4).e0().u(new BaseChronology() {
                private static final long serialVersionUID = -3128740902654445468L;

                public DateTimeZone getZone() {
                    return null;
                }

                public String toString() {
                    return getClass().getName();
                }

                public Chronology withUTC() {
                    return this;
                }

                public Chronology withZone(DateTimeZone dateTimeZone) {
                    return this;
                }
            });
        }

        public static Map<String, String> b() {
            HashMap hashMap = new HashMap();
            hashMap.put("GMT", UtcDates.UTC);
            hashMap.put("WET", "WET");
            hashMap.put("CET", "CET");
            hashMap.put("MET", "CET");
            hashMap.put("ECT", "CET");
            hashMap.put("EET", "EET");
            hashMap.put("MIT", "Pacific/Apia");
            hashMap.put("HST", "Pacific/Honolulu");
            hashMap.put("AST", "America/Anchorage");
            hashMap.put("PST", "America/Los_Angeles");
            hashMap.put("MST", "America/Denver");
            hashMap.put("PNT", "America/Phoenix");
            hashMap.put("CST", "America/Chicago");
            hashMap.put("EST", "America/New_York");
            hashMap.put("IET", "America/Indiana/Indianapolis");
            hashMap.put("PRT", "America/Puerto_Rico");
            hashMap.put("CNT", "America/St_Johns");
            hashMap.put("AGT", "America/Argentina/Buenos_Aires");
            hashMap.put("BET", "America/Sao_Paulo");
            hashMap.put("ART", "Africa/Cairo");
            hashMap.put("CAT", "Africa/Harare");
            hashMap.put("EAT", "Africa/Addis_Ababa");
            hashMap.put("NET", "Asia/Yerevan");
            hashMap.put("PLT", "Asia/Karachi");
            hashMap.put("IST", "Asia/Kolkata");
            hashMap.put("BST", "Asia/Dhaka");
            hashMap.put("VST", "Asia/Ho_Chi_Minh");
            hashMap.put("CTT", "Asia/Shanghai");
            hashMap.put("JST", "Asia/Tokyo");
            hashMap.put("ACT", "Australia/Darwin");
            hashMap.put("AET", "Australia/Sydney");
            hashMap.put("SST", "Pacific/Guadalcanal");
            hashMap.put("NST", "Pacific/Auckland");
            return Collections.unmodifiableMap(hashMap);
        }
    }

    public static final class Stub implements Serializable {
        private static final long serialVersionUID = -6471952376487863581L;
        private transient String iID;

        public Stub(String str) {
            this.iID = str;
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException {
            this.iID = objectInputStream.readUTF();
        }

        private Object readResolve() throws ObjectStreamException {
            return DateTimeZone.forID(this.iID);
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.writeUTF(this.iID);
        }
    }

    public DateTimeZone(String str) {
        if (str != null) {
            this.iID = str;
            return;
        }
        throw new IllegalArgumentException("Id must not be null");
    }

    private static DateTimeZone fixedOffsetZone(String str, int i11) {
        if (i11 == 0) {
            return UTC;
        }
        return new FixedDateTimeZone(str, (String) null, i11, i11);
    }

    @FromString
    public static DateTimeZone forID(String str) {
        if (str == null) {
            return getDefault();
        }
        if (str.equals(UtcDates.UTC)) {
            return UTC;
        }
        DateTimeZone a11 = getProvider().a(str);
        if (a11 != null) {
            return a11;
        }
        if (str.startsWith("+") || str.startsWith(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
            int parseOffset = parseOffset(str);
            if (((long) parseOffset) == 0) {
                return UTC;
            }
            return fixedOffsetZone(printOffset(parseOffset), parseOffset);
        }
        throw new IllegalArgumentException("The datetime zone id '" + str + "' is not recognised");
    }

    public static DateTimeZone forOffsetHours(int i11) throws IllegalArgumentException {
        return forOffsetHoursMinutes(i11, 0);
    }

    public static DateTimeZone forOffsetHoursMinutes(int i11, int i12) throws IllegalArgumentException {
        int i13;
        if (i11 == 0 && i12 == 0) {
            return UTC;
        }
        if (i11 < -23 || i11 > 23) {
            throw new IllegalArgumentException("Hours out of range: " + i11);
        } else if (i12 < -59 || i12 > 59) {
            throw new IllegalArgumentException("Minutes out of range: " + i12);
        } else if (i11 <= 0 || i12 >= 0) {
            int i14 = i11 * 60;
            if (i14 < 0) {
                try {
                    i13 = i14 - Math.abs(i12);
                } catch (ArithmeticException unused) {
                    throw new IllegalArgumentException("Offset is too large");
                }
            } else {
                i13 = i14 + i12;
            }
            return forOffsetMillis(e.g(i13, 60000));
        } else {
            throw new IllegalArgumentException("Positive hours must not have negative minutes: " + i12);
        }
    }

    public static DateTimeZone forOffsetMillis(int i11) {
        if (i11 >= -86399999 && i11 <= MAX_MILLIS) {
            return fixedOffsetZone(printOffset(i11), i11);
        }
        throw new IllegalArgumentException("Millis out of range: " + i11);
    }

    public static DateTimeZone forTimeZone(TimeZone timeZone) {
        if (timeZone == null) {
            return getDefault();
        }
        String id2 = timeZone.getID();
        if (id2 == null) {
            throw new IllegalArgumentException("The TimeZone id must not be null");
        } else if (id2.equals(UtcDates.UTC)) {
            return UTC;
        } else {
            DateTimeZone dateTimeZone = null;
            String convertedId = getConvertedId(id2);
            b provider = getProvider();
            if (convertedId != null) {
                dateTimeZone = provider.a(convertedId);
            }
            if (dateTimeZone == null) {
                dateTimeZone = provider.a(id2);
            }
            if (dateTimeZone != null) {
                return dateTimeZone;
            }
            if (convertedId != null || (!id2.startsWith("GMT+") && !id2.startsWith("GMT-"))) {
                throw new IllegalArgumentException("The datetime zone id '" + id2 + "' is not recognised");
            }
            int parseOffset = parseOffset(id2.substring(3));
            if (((long) parseOffset) == 0) {
                return UTC;
            }
            return fixedOffsetZone(printOffset(parseOffset), parseOffset);
        }
    }

    public static Set<String> getAvailableIDs() {
        return getProvider().b();
    }

    private static String getConvertedId(String str) {
        return LazyInit.f23028a.get(str);
    }

    public static DateTimeZone getDefault() {
        DateTimeZone dateTimeZone = cDefault.get();
        if (dateTimeZone != null) {
            return dateTimeZone;
        }
        try {
            String property = System.getProperty("user.timezone");
            if (property != null) {
                dateTimeZone = forID(property);
            }
        } catch (RuntimeException unused) {
        }
        if (dateTimeZone == null) {
            try {
                dateTimeZone = forTimeZone(TimeZone.getDefault());
            } catch (IllegalArgumentException unused2) {
            }
        }
        if (dateTimeZone == null) {
            dateTimeZone = UTC;
        }
        AtomicReference<DateTimeZone> atomicReference = cDefault;
        return !atomicReference.compareAndSet((Object) null, dateTimeZone) ? atomicReference.get() : dateTimeZone;
    }

    private static a getDefaultNameProvider() {
        a aVar = null;
        try {
            String property = System.getProperty("org.joda.time.DateTimeZone.NameProvider");
            if (property != null) {
                aVar = (a) Class.forName(property).newInstance();
            }
        } catch (Exception e11) {
            throw new RuntimeException(e11);
        } catch (SecurityException unused) {
        }
        return aVar == null ? new DefaultNameProvider() : aVar;
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x003c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static org.joda.time.tz.b getDefaultProvider() {
        /*
            java.lang.String r0 = "org.joda.time.DateTimeZone.Provider"
            java.lang.String r0 = java.lang.System.getProperty(r0)     // Catch:{ SecurityException -> 0x001e }
            if (r0 == 0) goto L_0x001e
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ Exception -> 0x0017 }
            java.lang.Object r0 = r0.newInstance()     // Catch:{ Exception -> 0x0017 }
            org.joda.time.tz.b r0 = (org.joda.time.tz.b) r0     // Catch:{ Exception -> 0x0017 }
            org.joda.time.tz.b r0 = validateProvider(r0)     // Catch:{ Exception -> 0x0017 }
            return r0
        L_0x0017:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException     // Catch:{ SecurityException -> 0x001e }
            r1.<init>(r0)     // Catch:{ SecurityException -> 0x001e }
            throw r1     // Catch:{ SecurityException -> 0x001e }
        L_0x001e:
            java.lang.String r0 = "org.joda.time.DateTimeZone.Folder"
            java.lang.String r0 = java.lang.System.getProperty(r0)     // Catch:{ SecurityException -> 0x003c }
            if (r0 == 0) goto L_0x003c
            org.joda.time.tz.c r1 = new org.joda.time.tz.c     // Catch:{ Exception -> 0x0035 }
            java.io.File r2 = new java.io.File     // Catch:{ Exception -> 0x0035 }
            r2.<init>(r0)     // Catch:{ Exception -> 0x0035 }
            r1.<init>((java.io.File) r2)     // Catch:{ Exception -> 0x0035 }
            org.joda.time.tz.b r0 = validateProvider(r1)     // Catch:{ Exception -> 0x0035 }
            return r0
        L_0x0035:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException     // Catch:{ SecurityException -> 0x003c }
            r1.<init>(r0)     // Catch:{ SecurityException -> 0x003c }
            throw r1     // Catch:{ SecurityException -> 0x003c }
        L_0x003c:
            org.joda.time.tz.c r0 = new org.joda.time.tz.c     // Catch:{ Exception -> 0x0048 }
            java.lang.String r1 = "org/joda/time/tz/data"
            r0.<init>((java.lang.String) r1)     // Catch:{ Exception -> 0x0048 }
            org.joda.time.tz.b r0 = validateProvider(r0)     // Catch:{ Exception -> 0x0048 }
            return r0
        L_0x0048:
            r0 = move-exception
            r0.printStackTrace()
            org.joda.time.tz.UTCProvider r0 = new org.joda.time.tz.UTCProvider
            r0.<init>()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.joda.time.DateTimeZone.getDefaultProvider():org.joda.time.tz.b");
    }

    public static a getNameProvider() {
        AtomicReference<a> atomicReference = cNameProvider;
        a aVar = atomicReference.get();
        if (aVar != null) {
            return aVar;
        }
        a defaultNameProvider = getDefaultNameProvider();
        return !atomicReference.compareAndSet((Object) null, defaultNameProvider) ? atomicReference.get() : defaultNameProvider;
    }

    public static b getProvider() {
        AtomicReference<b> atomicReference = cProvider;
        b bVar = atomicReference.get();
        if (bVar != null) {
            return bVar;
        }
        b defaultProvider = getDefaultProvider();
        return !atomicReference.compareAndSet((Object) null, defaultProvider) ? atomicReference.get() : defaultProvider;
    }

    private static int parseOffset(String str) {
        return -((int) LazyInit.f23029b.j(str));
    }

    private static String printOffset(int i11) {
        StringBuffer stringBuffer = new StringBuffer();
        if (i11 >= 0) {
            stringBuffer.append('+');
        } else {
            stringBuffer.append('-');
            i11 = -i11;
        }
        int i12 = i11 / com.adjust.sdk.Constants.ONE_HOUR;
        h.b(stringBuffer, i12, 2);
        int i13 = i11 - (i12 * com.adjust.sdk.Constants.ONE_HOUR);
        int i14 = i13 / 60000;
        stringBuffer.append(':');
        h.b(stringBuffer, i14, 2);
        int i15 = i13 - (i14 * 60000);
        if (i15 == 0) {
            return stringBuffer.toString();
        }
        int i16 = i15 / 1000;
        stringBuffer.append(':');
        h.b(stringBuffer, i16, 2);
        int i17 = i15 - (i16 * 1000);
        if (i17 == 0) {
            return stringBuffer.toString();
        }
        stringBuffer.append('.');
        h.b(stringBuffer, i17, 3);
        return stringBuffer.toString();
    }

    public static void setDefault(DateTimeZone dateTimeZone) throws SecurityException {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(new JodaTimePermission("DateTimeZone.setDefault"));
        }
        if (dateTimeZone != null) {
            cDefault.set(dateTimeZone);
            return;
        }
        throw new IllegalArgumentException("The datetime zone must not be null");
    }

    public static void setNameProvider(a aVar) throws SecurityException {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(new JodaTimePermission("DateTimeZone.setNameProvider"));
        }
        if (aVar == null) {
            aVar = getDefaultNameProvider();
        }
        cNameProvider.set(aVar);
    }

    public static void setProvider(b bVar) throws SecurityException {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(new JodaTimePermission("DateTimeZone.setProvider"));
        }
        if (bVar == null) {
            bVar = getDefaultProvider();
        } else {
            validateProvider(bVar);
        }
        cProvider.set(bVar);
    }

    private static b validateProvider(b bVar) {
        Set<String> b11 = bVar.b();
        if (b11 == null || b11.size() == 0) {
            throw new IllegalArgumentException("The provider doesn't have any available ids");
        } else if (!b11.contains(UtcDates.UTC)) {
            throw new IllegalArgumentException("The provider doesn't support UTC");
        } else if (UTC.equals(bVar.a(UtcDates.UTC))) {
            return bVar;
        } else {
            throw new IllegalArgumentException("Invalid UTC zone provided");
        }
    }

    public long adjustOffset(long j11, boolean z11) {
        long j12 = j11 - 10800000;
        long offset = (long) getOffset(j12);
        long offset2 = (long) getOffset(10800000 + j11);
        if (offset <= offset2) {
            return j11;
        }
        long j13 = offset - offset2;
        long nextTransition = nextTransition(j12);
        long j14 = nextTransition - j13;
        long j15 = nextTransition + j13;
        if (j11 < j14 || j11 >= j15) {
            return j11;
        }
        return j11 - j14 >= j13 ? z11 ? j11 : j11 - j13 : z11 ? j11 + j13 : j11;
    }

    public long convertLocalToUTC(long j11, boolean z11, long j12) {
        int offset = getOffset(j12);
        long j13 = j11 - ((long) offset);
        if (getOffset(j13) == offset) {
            return j13;
        }
        return convertLocalToUTC(j11, z11);
    }

    public long convertUTCToLocal(long j11) {
        long offset = (long) getOffset(j11);
        long j12 = j11 + offset;
        if ((j11 ^ j12) >= 0 || (j11 ^ offset) < 0) {
            return j12;
        }
        throw new ArithmeticException("Adding time zone offset caused overflow");
    }

    public abstract boolean equals(Object obj);

    @ToString
    public final String getID() {
        return this.iID;
    }

    public long getMillisKeepLocal(DateTimeZone dateTimeZone, long j11) {
        if (dateTimeZone == null) {
            dateTimeZone = getDefault();
        }
        DateTimeZone dateTimeZone2 = dateTimeZone;
        if (dateTimeZone2 == this) {
            return j11;
        }
        return dateTimeZone2.convertLocalToUTC(convertUTCToLocal(j11), false, j11);
    }

    public final String getName(long j11) {
        return getName(j11, (Locale) null);
    }

    public abstract String getNameKey(long j11);

    public abstract int getOffset(long j11);

    public final int getOffset(f fVar) {
        if (fVar == null) {
            return getOffset(a.b());
        }
        return getOffset(fVar.getMillis());
    }

    public int getOffsetFromLocal(long j11) {
        int offset = getOffset(j11);
        long j12 = j11 - ((long) offset);
        int offset2 = getOffset(j12);
        if (offset != offset2) {
            if (offset - offset2 < 0) {
                long nextTransition = nextTransition(j12);
                long j13 = Long.MAX_VALUE;
                if (nextTransition == j12) {
                    nextTransition = Long.MAX_VALUE;
                }
                long j14 = j11 - ((long) offset2);
                long nextTransition2 = nextTransition(j14);
                if (nextTransition2 != j14) {
                    j13 = nextTransition2;
                }
                if (nextTransition != j13) {
                    return offset;
                }
            }
        } else if (offset >= 0) {
            long previousTransition = previousTransition(j12);
            if (previousTransition < j12) {
                int offset3 = getOffset(previousTransition);
                if (j12 - previousTransition <= ((long) (offset3 - offset))) {
                    return offset3;
                }
            }
        }
        return offset2;
    }

    public final String getShortName(long j11) {
        return getShortName(j11, (Locale) null);
    }

    public abstract int getStandardOffset(long j11);

    public int hashCode() {
        return getID().hashCode() + 57;
    }

    public abstract boolean isFixed();

    public boolean isLocalDateTimeGap(LocalDateTime localDateTime) {
        if (isFixed()) {
            return false;
        }
        try {
            localDateTime.toDateTime(this);
            return false;
        } catch (IllegalInstantException unused) {
            return true;
        }
    }

    public boolean isStandardOffset(long j11) {
        return getOffset(j11) == getStandardOffset(j11);
    }

    public abstract long nextTransition(long j11);

    public abstract long previousTransition(long j11);

    public String toString() {
        return getID();
    }

    public TimeZone toTimeZone() {
        return TimeZone.getTimeZone(this.iID);
    }

    public Object writeReplace() throws ObjectStreamException {
        return new Stub(this.iID);
    }

    public String getName(long j11, Locale locale) {
        String str;
        if (locale == null) {
            locale = Locale.getDefault();
        }
        String nameKey = getNameKey(j11);
        if (nameKey == null) {
            return this.iID;
        }
        a nameProvider = getNameProvider();
        if (nameProvider instanceof DefaultNameProvider) {
            str = ((DefaultNameProvider) nameProvider).d(locale, this.iID, nameKey, isStandardOffset(j11));
        } else {
            str = nameProvider.b(locale, this.iID, nameKey);
        }
        if (str != null) {
            return str;
        }
        return printOffset(getOffset(j11));
    }

    public String getShortName(long j11, Locale locale) {
        String str;
        if (locale == null) {
            locale = Locale.getDefault();
        }
        String nameKey = getNameKey(j11);
        if (nameKey == null) {
            return this.iID;
        }
        a nameProvider = getNameProvider();
        if (nameProvider instanceof DefaultNameProvider) {
            str = ((DefaultNameProvider) nameProvider).g(locale, this.iID, nameKey, isStandardOffset(j11));
        } else {
            str = nameProvider.a(locale, this.iID, nameKey);
        }
        if (str != null) {
            return str;
        }
        return printOffset(getOffset(j11));
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0057 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long convertLocalToUTC(long r11, boolean r13) {
        /*
            r10 = this;
            int r0 = r10.getOffset((long) r11)
            long r1 = (long) r0
            long r1 = r11 - r1
            int r3 = r10.getOffset((long) r1)
            if (r0 == r3) goto L_0x003d
            if (r13 != 0) goto L_0x0011
            if (r0 >= 0) goto L_0x003d
        L_0x0011:
            long r4 = r10.nextTransition(r1)
            int r1 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            r6 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            if (r1 != 0) goto L_0x001f
            r4 = r6
        L_0x001f:
            long r1 = (long) r3
            long r1 = r11 - r1
            long r8 = r10.nextTransition(r1)
            int r1 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
            if (r1 != 0) goto L_0x002b
            goto L_0x002c
        L_0x002b:
            r6 = r8
        L_0x002c:
            int r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r1 == 0) goto L_0x003d
            if (r13 != 0) goto L_0x0033
            goto L_0x003e
        L_0x0033:
            org.joda.time.IllegalInstantException r13 = new org.joda.time.IllegalInstantException
            java.lang.String r0 = r10.getID()
            r13.<init>(r11, r0)
            throw r13
        L_0x003d:
            r0 = r3
        L_0x003e:
            long r0 = (long) r0
            long r2 = r11 - r0
            long r4 = r11 ^ r2
            r6 = 0
            int r13 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r13 >= 0) goto L_0x0057
            long r11 = r11 ^ r0
            int r11 = (r11 > r6 ? 1 : (r11 == r6 ? 0 : -1))
            if (r11 < 0) goto L_0x004f
            goto L_0x0057
        L_0x004f:
            java.lang.ArithmeticException r11 = new java.lang.ArithmeticException
            java.lang.String r12 = "Subtracting time zone offset caused overflow"
            r11.<init>(r12)
            throw r11
        L_0x0057:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.joda.time.DateTimeZone.convertLocalToUTC(long, boolean):long");
    }
}
