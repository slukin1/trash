package org.joda.time.format;

import com.adjust.sdk.Constants;
import com.tencent.qcloud.tuicore.TUIThemeManager;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import okhttp3.internal.connection.RealConnection;
import okio.Utf8;
import org.joda.time.Chronology;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DateTimeZone;
import org.joda.time.MutableDateTime;
import org.joda.time.field.MillisDurationField;

public class DateTimeFormatterBuilder {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<Object> f23130a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public Object f23131b;

    public enum TimeZoneId implements m, k {
        INSTANCE;
        
        public static final Set<String> ALL_IDS = null;
        public static final int MAX_LENGTH = 0;

        /* access modifiers changed from: public */
        static {
            int i11;
            Set<String> availableIDs = DateTimeZone.getAvailableIDs();
            ALL_IDS = availableIDs;
            for (String length : availableIDs) {
                i11 = Math.max(i11, length.length());
            }
            MAX_LENGTH = i11;
        }

        public int estimateParsedLength() {
            return MAX_LENGTH;
        }

        public int estimatePrintedLength() {
            return MAX_LENGTH;
        }

        public int parseInto(d dVar, CharSequence charSequence, int i11) {
            String str = null;
            for (String next : ALL_IDS) {
                if (DateTimeFormatterBuilder.Y(charSequence, i11, next) && (str == null || next.length() > str.length())) {
                    str = next;
                }
            }
            if (str == null) {
                return ~i11;
            }
            dVar.z(DateTimeZone.forID(str));
            return i11 + str.length();
        }

        public void printTo(Appendable appendable, long j11, Chronology chronology, int i11, DateTimeZone dateTimeZone, Locale locale) throws IOException {
            appendable.append(dateTimeZone != null ? dateTimeZone.getID() : "");
        }

        public void printTo(Appendable appendable, org.joda.time.h hVar, Locale locale) throws IOException {
        }
    }

    public static class a implements m, k {

        /* renamed from: b  reason: collision with root package name */
        public final char f23132b;

        public a(char c11) {
            this.f23132b = c11;
        }

        public int estimateParsedLength() {
            return 1;
        }

        public int estimatePrintedLength() {
            return 1;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0010, code lost:
            r1 = java.lang.Character.toUpperCase(r1);
            r2 = java.lang.Character.toUpperCase(r2);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int parseInto(org.joda.time.format.d r1, java.lang.CharSequence r2, int r3) {
            /*
                r0 = this;
                int r1 = r2.length()
                if (r3 < r1) goto L_0x0008
                int r1 = ~r3
                return r1
            L_0x0008:
                char r1 = r2.charAt(r3)
                char r2 = r0.f23132b
                if (r1 == r2) goto L_0x0026
                char r1 = java.lang.Character.toUpperCase(r1)
                char r2 = java.lang.Character.toUpperCase(r2)
                if (r1 == r2) goto L_0x0026
                char r1 = java.lang.Character.toLowerCase(r1)
                char r2 = java.lang.Character.toLowerCase(r2)
                if (r1 == r2) goto L_0x0026
                int r1 = ~r3
                return r1
            L_0x0026:
                int r3 = r3 + 1
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: org.joda.time.format.DateTimeFormatterBuilder.a.parseInto(org.joda.time.format.d, java.lang.CharSequence, int):int");
        }

        public void printTo(Appendable appendable, long j11, Chronology chronology, int i11, DateTimeZone dateTimeZone, Locale locale) throws IOException {
            appendable.append(this.f23132b);
        }

        public void printTo(Appendable appendable, org.joda.time.h hVar, Locale locale) throws IOException {
            appendable.append(this.f23132b);
        }
    }

    public static class c extends g {
        public c(DateTimeFieldType dateTimeFieldType, int i11, boolean z11) {
            super(dateTimeFieldType, i11, z11, i11);
        }

        public int parseInto(d dVar, CharSequence charSequence, int i11) {
            int i12;
            char charAt;
            int parseInto = super.parseInto(dVar, charSequence, i11);
            if (parseInto < 0 || parseInto == (i12 = this.f23143c + i11)) {
                return parseInto;
            }
            if (this.f23144d && ((charAt = charSequence.charAt(i11)) == '-' || charAt == '+')) {
                i12++;
            }
            if (parseInto > i12) {
                return ~(i12 + 1);
            }
            return parseInto < i12 ? ~parseInto : parseInto;
        }
    }

    public static class d implements m, k {

        /* renamed from: b  reason: collision with root package name */
        public final DateTimeFieldType f23137b;

        /* renamed from: c  reason: collision with root package name */
        public int f23138c;

        /* renamed from: d  reason: collision with root package name */
        public int f23139d;

        public d(DateTimeFieldType dateTimeFieldType, int i11, int i12) {
            this.f23137b = dateTimeFieldType;
            i12 = i12 > 18 ? 18 : i12;
            this.f23138c = i11;
            this.f23139d = i12;
        }

        public final long[] a(long j11, DateTimeField dateTimeField) {
            long j12;
            long unitMillis = dateTimeField.getDurationField().getUnitMillis();
            int i11 = this.f23139d;
            while (true) {
                switch (i11) {
                    case 1:
                        j12 = 10;
                        break;
                    case 2:
                        j12 = 100;
                        break;
                    case 3:
                        j12 = 1000;
                        break;
                    case 4:
                        j12 = 10000;
                        break;
                    case 5:
                        j12 = IndexSeeker.MIN_TIME_BETWEEN_POINTS_US;
                        break;
                    case 6:
                        j12 = 1000000;
                        break;
                    case 7:
                        j12 = 10000000;
                        break;
                    case 8:
                        j12 = 100000000;
                        break;
                    case 9:
                        j12 = 1000000000;
                        break;
                    case 10:
                        j12 = RealConnection.IDLE_CONNECTION_HEALTHY_NS;
                        break;
                    case 11:
                        j12 = 100000000000L;
                        break;
                    case 12:
                        j12 = 1000000000000L;
                        break;
                    case 13:
                        j12 = 10000000000000L;
                        break;
                    case 14:
                        j12 = 100000000000000L;
                        break;
                    case 15:
                        j12 = 1000000000000000L;
                        break;
                    case 16:
                        j12 = 10000000000000000L;
                        break;
                    case 17:
                        j12 = 100000000000000000L;
                        break;
                    case 18:
                        j12 = 1000000000000000000L;
                        break;
                    default:
                        j12 = 1;
                        break;
                }
                if ((unitMillis * j12) / j12 == unitMillis) {
                    return new long[]{(j11 * j12) / unitMillis, (long) i11};
                }
                i11--;
            }
        }

        public void b(Appendable appendable, long j11, Chronology chronology) throws IOException {
            String str;
            DateTimeField field = this.f23137b.getField(chronology);
            int i11 = this.f23138c;
            try {
                long remainder = field.remainder(j11);
                if (remainder == 0) {
                    while (true) {
                        i11--;
                        if (i11 >= 0) {
                            appendable.append('0');
                        } else {
                            return;
                        }
                    }
                } else {
                    long[] a11 = a(remainder, field);
                    long j12 = a11[0];
                    int i12 = (int) a11[1];
                    if ((2147483647L & j12) == j12) {
                        str = Integer.toString((int) j12);
                    } else {
                        str = Long.toString(j12);
                    }
                    int length = str.length();
                    while (length < i12) {
                        appendable.append('0');
                        i11--;
                        i12--;
                    }
                    if (i11 < i12) {
                        while (i11 < i12 && length > 1 && str.charAt(length - 1) == '0') {
                            i12--;
                            length--;
                        }
                        if (length < str.length()) {
                            for (int i13 = 0; i13 < length; i13++) {
                                appendable.append(str.charAt(i13));
                            }
                            return;
                        }
                    }
                    appendable.append(str);
                }
            } catch (RuntimeException unused) {
                DateTimeFormatterBuilder.Q(appendable, i11);
            }
        }

        public int estimateParsedLength() {
            return this.f23139d;
        }

        public int estimatePrintedLength() {
            return this.f23139d;
        }

        public int parseInto(d dVar, CharSequence charSequence, int i11) {
            DateTimeField field = this.f23137b.getField(dVar.n());
            int min = Math.min(this.f23139d, charSequence.length() - i11);
            long unitMillis = field.getDurationField().getUnitMillis() * 10;
            long j11 = 0;
            int i12 = 0;
            while (i12 < min) {
                char charAt = charSequence.charAt(i11 + i12);
                if (charAt < '0' || charAt > '9') {
                    break;
                }
                i12++;
                unitMillis /= 10;
                j11 += ((long) (charAt - '0')) * unitMillis;
            }
            long j12 = j11 / 10;
            if (i12 == 0) {
                return ~i11;
            }
            if (j12 > 2147483647L) {
                return ~i11;
            }
            dVar.u(new org.joda.time.field.g(DateTimeFieldType.millisOfSecond(), MillisDurationField.INSTANCE, field.getDurationField()), (int) j12);
            return i11 + i12;
        }

        public void printTo(Appendable appendable, long j11, Chronology chronology, int i11, DateTimeZone dateTimeZone, Locale locale) throws IOException {
            b(appendable, j11, chronology);
        }

        public void printTo(Appendable appendable, org.joda.time.h hVar, Locale locale) throws IOException {
            b(appendable, hVar.getChronology().set(hVar, 0), hVar.getChronology());
        }
    }

    public static class e implements k {

        /* renamed from: b  reason: collision with root package name */
        public final k[] f23140b;

        /* renamed from: c  reason: collision with root package name */
        public final int f23141c;

        public e(k[] kVarArr) {
            int estimateParsedLength;
            this.f23140b = kVarArr;
            int length = kVarArr.length;
            int i11 = 0;
            while (true) {
                length--;
                if (length >= 0) {
                    k kVar = kVarArr[length];
                    if (kVar != null && (estimateParsedLength = kVar.estimateParsedLength()) > i11) {
                        i11 = estimateParsedLength;
                    }
                } else {
                    this.f23141c = i11;
                    return;
                }
            }
        }

        public int estimateParsedLength() {
            return this.f23141c;
        }

        public int parseInto(d dVar, CharSequence charSequence, int i11) {
            int i12;
            int i13;
            k[] kVarArr = this.f23140b;
            int length = kVarArr.length;
            Object x11 = dVar.x();
            boolean z11 = false;
            Object obj = null;
            int i14 = i11;
            int i15 = i14;
            int i16 = 0;
            while (true) {
                if (i16 >= length) {
                    break;
                }
                k kVar = kVarArr[i16];
                if (kVar != null) {
                    int parseInto = kVar.parseInto(dVar, charSequence, i11);
                    if (parseInto >= i11) {
                        if (parseInto <= i14) {
                            continue;
                        } else if (parseInto >= charSequence.length() || (i13 = i16 + 1) >= length || kVarArr[i13] == null) {
                            return parseInto;
                        } else {
                            obj = dVar.x();
                            i14 = parseInto;
                        }
                    } else if (parseInto < 0 && (i12 = ~parseInto) > i15) {
                        i15 = i12;
                    }
                    dVar.t(x11);
                    i16++;
                } else if (i14 <= i11) {
                    return i11;
                } else {
                    z11 = true;
                }
            }
            if (i14 <= i11 && (i14 != i11 || !z11)) {
                return ~i15;
            }
            if (obj != null) {
                dVar.t(obj);
            }
            return i14;
        }
    }

    public static abstract class f implements m, k {

        /* renamed from: b  reason: collision with root package name */
        public final DateTimeFieldType f23142b;

        /* renamed from: c  reason: collision with root package name */
        public final int f23143c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f23144d;

        public f(DateTimeFieldType dateTimeFieldType, int i11, boolean z11) {
            this.f23142b = dateTimeFieldType;
            this.f23143c = i11;
            this.f23144d = z11;
        }

        public int estimateParsedLength() {
            return this.f23143c;
        }

        public int parseInto(d dVar, CharSequence charSequence, int i11) {
            int i12;
            int i13;
            char charAt;
            int min = Math.min(this.f23143c, charSequence.length() - i11);
            int i14 = 0;
            boolean z11 = false;
            while (i14 < min) {
                int i15 = i11 + i14;
                char charAt2 = charSequence.charAt(i15);
                if (i14 != 0 || ((charAt2 != '-' && charAt2 != '+') || !this.f23144d)) {
                    if (charAt2 < '0' || charAt2 > '9') {
                        break;
                    }
                    i14++;
                } else {
                    z11 = charAt2 == '-';
                    int i16 = i14 + 1;
                    if (i16 >= min || (charAt = charSequence.charAt(i15 + 1)) < '0' || charAt > '9') {
                        break;
                    }
                    if (z11) {
                        i14 = i16;
                    } else {
                        i11++;
                    }
                    min = Math.min(min + 1, charSequence.length() - i11);
                }
            }
            if (i14 == 0) {
                return ~i11;
            }
            if (i14 >= 9) {
                i13 = i14 + i11;
                i12 = Integer.parseInt(charSequence.subSequence(i11, i13).toString());
            } else {
                int i17 = z11 ? i11 + 1 : i11;
                int i18 = i17 + 1;
                try {
                    int charAt3 = charSequence.charAt(i17) - '0';
                    i13 = i14 + i11;
                    while (i18 < i13) {
                        i18++;
                        charAt3 = (((charAt3 << 3) + (charAt3 << 1)) + charSequence.charAt(i18)) - 48;
                    }
                    i12 = z11 ? -charAt3 : charAt3;
                } catch (StringIndexOutOfBoundsException unused) {
                    return ~i11;
                }
            }
            dVar.v(this.f23142b, i12);
            return i13;
        }
    }

    public static class h implements m, k {

        /* renamed from: b  reason: collision with root package name */
        public final String f23146b;

        public h(String str) {
            this.f23146b = str;
        }

        public int estimateParsedLength() {
            return this.f23146b.length();
        }

        public int estimatePrintedLength() {
            return this.f23146b.length();
        }

        public int parseInto(d dVar, CharSequence charSequence, int i11) {
            return DateTimeFormatterBuilder.Z(charSequence, i11, this.f23146b) ? i11 + this.f23146b.length() : ~i11;
        }

        public void printTo(Appendable appendable, long j11, Chronology chronology, int i11, DateTimeZone dateTimeZone, Locale locale) throws IOException {
            appendable.append(this.f23146b);
        }

        public void printTo(Appendable appendable, org.joda.time.h hVar, Locale locale) throws IOException {
            appendable.append(this.f23146b);
        }
    }

    public static class j implements m, k {

        /* renamed from: b  reason: collision with root package name */
        public final Map<String, DateTimeZone> f23150b;

        /* renamed from: c  reason: collision with root package name */
        public final int f23151c;

        public j(int i11, Map<String, DateTimeZone> map) {
            this.f23151c = i11;
            this.f23150b = map;
        }

        public final String a(long j11, DateTimeZone dateTimeZone, Locale locale) {
            if (dateTimeZone == null) {
                return "";
            }
            int i11 = this.f23151c;
            if (i11 == 0) {
                return dateTimeZone.getName(j11, locale);
            }
            if (i11 != 1) {
                return "";
            }
            return dateTimeZone.getShortName(j11, locale);
        }

        public int estimateParsedLength() {
            return this.f23151c == 1 ? 4 : 20;
        }

        public int estimatePrintedLength() {
            return this.f23151c == 1 ? 4 : 20;
        }

        public int parseInto(d dVar, CharSequence charSequence, int i11) {
            Map<String, DateTimeZone> map = this.f23150b;
            if (map == null) {
                map = org.joda.time.a.e();
            }
            String str = null;
            for (String next : map.keySet()) {
                if (DateTimeFormatterBuilder.Y(charSequence, i11, next) && (str == null || next.length() > str.length())) {
                    str = next;
                }
            }
            if (str == null) {
                return ~i11;
            }
            dVar.z(map.get(str));
            return i11 + str.length();
        }

        public void printTo(Appendable appendable, long j11, Chronology chronology, int i11, DateTimeZone dateTimeZone, Locale locale) throws IOException {
            appendable.append(a(j11 - ((long) i11), dateTimeZone, locale));
        }

        public void printTo(Appendable appendable, org.joda.time.h hVar, Locale locale) throws IOException {
        }
    }

    public static class k implements m, k {

        /* renamed from: b  reason: collision with root package name */
        public final String f23152b;

        /* renamed from: c  reason: collision with root package name */
        public final String f23153c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f23154d;

        /* renamed from: e  reason: collision with root package name */
        public final int f23155e;

        /* renamed from: f  reason: collision with root package name */
        public final int f23156f;

        public k(String str, String str2, boolean z11, int i11, int i12) {
            this.f23152b = str;
            this.f23153c = str2;
            this.f23154d = z11;
            if (i11 <= 0 || i12 < i11) {
                throw new IllegalArgumentException();
            }
            if (i11 > 4) {
                i11 = 4;
                i12 = 4;
            }
            this.f23155e = i11;
            this.f23156f = i12;
        }

        public final int a(CharSequence charSequence, int i11, int i12) {
            int i13 = 0;
            for (int min = Math.min(charSequence.length() - i11, i12); min > 0; min--) {
                char charAt = charSequence.charAt(i11 + i13);
                if (charAt < '0' || charAt > '9') {
                    break;
                }
                i13++;
            }
            return i13;
        }

        public int estimateParsedLength() {
            return estimatePrintedLength();
        }

        public int estimatePrintedLength() {
            int i11 = this.f23155e;
            int i12 = (i11 + 1) << 1;
            if (this.f23154d) {
                i12 += i11 - 1;
            }
            String str = this.f23152b;
            return (str == null || str.length() <= i12) ? i12 : this.f23152b.length();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:38:0x007f, code lost:
            if (r6 <= '9') goto L_0x0081;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int parseInto(org.joda.time.format.d r12, java.lang.CharSequence r13, int r14) {
            /*
                r11 = this;
                int r0 = r13.length()
                int r0 = r0 - r14
                java.lang.String r1 = r11.f23153c
                r2 = 43
                r3 = 45
                r4 = 0
                java.lang.Integer r5 = java.lang.Integer.valueOf(r4)
                if (r1 == 0) goto L_0x003a
                int r1 = r1.length()
                if (r1 != 0) goto L_0x0027
                if (r0 <= 0) goto L_0x0023
                char r1 = r13.charAt(r14)
                if (r1 == r3) goto L_0x003a
                if (r1 != r2) goto L_0x0023
                goto L_0x003a
            L_0x0023:
                r12.y(r5)
                return r14
            L_0x0027:
                java.lang.String r1 = r11.f23153c
                boolean r1 = org.joda.time.format.DateTimeFormatterBuilder.Z(r13, r14, r1)
                if (r1 == 0) goto L_0x003a
                r12.y(r5)
                java.lang.String r12 = r11.f23153c
                int r12 = r12.length()
                int r14 = r14 + r12
                return r14
            L_0x003a:
                r1 = 1
                if (r0 > r1) goto L_0x003f
                int r12 = ~r14
                return r12
            L_0x003f:
                char r5 = r13.charAt(r14)
                if (r5 != r3) goto L_0x0047
                r2 = r1
                goto L_0x004a
            L_0x0047:
                if (r5 != r2) goto L_0x0124
                r2 = r4
            L_0x004a:
                int r0 = r0 + -1
                int r14 = r14 + r1
                r3 = 2
                int r5 = r11.a(r13, r14, r3)
                if (r5 >= r3) goto L_0x0056
                int r12 = ~r14
                return r12
            L_0x0056:
                int r5 = org.joda.time.format.h.i(r13, r14)
                r6 = 23
                if (r5 <= r6) goto L_0x0060
                int r12 = ~r14
                return r12
            L_0x0060:
                r6 = 3600000(0x36ee80, float:5.044674E-39)
                int r5 = r5 * r6
                int r0 = r0 + -2
                int r14 = r14 + r3
                if (r0 > 0) goto L_0x006b
                goto L_0x0119
            L_0x006b:
                char r6 = r13.charAt(r14)
                r7 = 58
                r8 = 48
                if (r6 != r7) goto L_0x007b
                int r0 = r0 + -1
                int r14 = r14 + 1
                r4 = r1
                goto L_0x0081
            L_0x007b:
                if (r6 < r8) goto L_0x0119
                r9 = 57
                if (r6 > r9) goto L_0x0119
            L_0x0081:
                int r6 = r11.a(r13, r14, r3)
                if (r6 != 0) goto L_0x008b
                if (r4 != 0) goto L_0x008b
                goto L_0x0119
            L_0x008b:
                if (r6 >= r3) goto L_0x008f
                int r12 = ~r14
                return r12
            L_0x008f:
                int r6 = org.joda.time.format.h.i(r13, r14)
                r9 = 59
                if (r6 <= r9) goto L_0x0099
                int r12 = ~r14
                return r12
            L_0x0099:
                r10 = 60000(0xea60, float:8.4078E-41)
                int r6 = r6 * r10
                int r5 = r5 + r6
                int r0 = r0 + -2
                int r14 = r14 + 2
                if (r0 > 0) goto L_0x00a6
                goto L_0x0119
            L_0x00a6:
                if (r4 == 0) goto L_0x00b4
                char r6 = r13.charAt(r14)
                if (r6 == r7) goto L_0x00b0
                goto L_0x0119
            L_0x00b0:
                int r0 = r0 + -1
                int r14 = r14 + 1
            L_0x00b4:
                int r6 = r11.a(r13, r14, r3)
                if (r6 != 0) goto L_0x00bd
                if (r4 != 0) goto L_0x00bd
                goto L_0x0119
            L_0x00bd:
                if (r6 >= r3) goto L_0x00c1
                int r12 = ~r14
                return r12
            L_0x00c1:
                int r6 = org.joda.time.format.h.i(r13, r14)
                if (r6 <= r9) goto L_0x00c9
                int r12 = ~r14
                return r12
            L_0x00c9:
                int r6 = r6 * 1000
                int r5 = r5 + r6
                int r0 = r0 + -2
                int r14 = r14 + 2
                if (r0 > 0) goto L_0x00d3
                goto L_0x0119
            L_0x00d3:
                if (r4 == 0) goto L_0x00e8
                char r0 = r13.charAt(r14)
                r6 = 46
                if (r0 == r6) goto L_0x00e6
                char r0 = r13.charAt(r14)
                r6 = 44
                if (r0 == r6) goto L_0x00e6
                goto L_0x0119
            L_0x00e6:
                int r14 = r14 + 1
            L_0x00e8:
                r0 = 3
                int r0 = r11.a(r13, r14, r0)
                if (r0 != 0) goto L_0x00f2
                if (r4 != 0) goto L_0x00f2
                goto L_0x0119
            L_0x00f2:
                if (r0 >= r1) goto L_0x00f6
                int r12 = ~r14
                return r12
            L_0x00f6:
                int r4 = r14 + 1
                char r14 = r13.charAt(r14)
                int r14 = r14 - r8
                int r14 = r14 * 100
                int r5 = r5 + r14
                if (r0 <= r1) goto L_0x0118
                int r14 = r4 + 1
                char r1 = r13.charAt(r4)
                int r1 = r1 - r8
                int r1 = r1 * 10
                int r5 = r5 + r1
                if (r0 <= r3) goto L_0x0119
                int r0 = r14 + 1
                char r13 = r13.charAt(r14)
                int r13 = r13 - r8
                int r5 = r5 + r13
                r14 = r0
                goto L_0x0119
            L_0x0118:
                r14 = r4
            L_0x0119:
                if (r2 == 0) goto L_0x011c
                int r5 = -r5
            L_0x011c:
                java.lang.Integer r13 = java.lang.Integer.valueOf(r5)
                r12.y(r13)
                return r14
            L_0x0124:
                int r12 = ~r14
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: org.joda.time.format.DateTimeFormatterBuilder.k.parseInto(org.joda.time.format.d, java.lang.CharSequence, int):int");
        }

        public void printTo(Appendable appendable, long j11, Chronology chronology, int i11, DateTimeZone dateTimeZone, Locale locale) throws IOException {
            String str;
            if (dateTimeZone != null) {
                if (i11 != 0 || (str = this.f23152b) == null) {
                    if (i11 >= 0) {
                        appendable.append('+');
                    } else {
                        appendable.append('-');
                        i11 = -i11;
                    }
                    int i12 = i11 / Constants.ONE_HOUR;
                    h.a(appendable, i12, 2);
                    if (this.f23156f != 1) {
                        int i13 = i11 - (i12 * Constants.ONE_HOUR);
                        if (i13 != 0 || this.f23155e > 1) {
                            int i14 = i13 / 60000;
                            if (this.f23154d) {
                                appendable.append(':');
                            }
                            h.a(appendable, i14, 2);
                            if (this.f23156f != 2) {
                                int i15 = i13 - (i14 * 60000);
                                if (i15 != 0 || this.f23155e > 2) {
                                    int i16 = i15 / 1000;
                                    if (this.f23154d) {
                                        appendable.append(':');
                                    }
                                    h.a(appendable, i16, 2);
                                    if (this.f23156f != 3) {
                                        int i17 = i15 - (i16 * 1000);
                                        if (i17 != 0 || this.f23155e > 3) {
                                            if (this.f23154d) {
                                                appendable.append('.');
                                            }
                                            h.a(appendable, i17, 3);
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                appendable.append(str);
            }
        }

        public void printTo(Appendable appendable, org.joda.time.h hVar, Locale locale) throws IOException {
        }
    }

    public static void Q(Appendable appendable, int i11) throws IOException {
        while (true) {
            i11--;
            if (i11 >= 0) {
                appendable.append(Utf8.REPLACEMENT_CHARACTER);
            } else {
                return;
            }
        }
    }

    public static boolean Y(CharSequence charSequence, int i11, String str) {
        int length = str.length();
        if (charSequence.length() - i11 < length) {
            return false;
        }
        for (int i12 = 0; i12 < length; i12++) {
            if (charSequence.charAt(i11 + i12) != str.charAt(i12)) {
                return false;
            }
        }
        return true;
    }

    public static boolean Z(CharSequence charSequence, int i11, String str) {
        char upperCase;
        char upperCase2;
        int length = str.length();
        if (charSequence.length() - i11 < length) {
            return false;
        }
        for (int i12 = 0; i12 < length; i12++) {
            char charAt = charSequence.charAt(i11 + i12);
            char charAt2 = str.charAt(i12);
            if (charAt != charAt2 && (upperCase = Character.toUpperCase(charAt)) != (upperCase2 = Character.toUpperCase(charAt2)) && Character.toLowerCase(upperCase) != Character.toLowerCase(upperCase2)) {
                return false;
            }
        }
        return true;
    }

    public DateTimeFormatterBuilder A(int i11) {
        return n(DateTimeFieldType.minuteOfHour(), i11, 2);
    }

    public DateTimeFormatterBuilder B(int i11) {
        return n(DateTimeFieldType.monthOfYear(), i11, 2);
    }

    public DateTimeFormatterBuilder C() {
        return G(DateTimeFieldType.monthOfYear());
    }

    public DateTimeFormatterBuilder D() {
        return I(DateTimeFieldType.monthOfYear());
    }

    public DateTimeFormatterBuilder E(c cVar) {
        W(cVar);
        return e((m) null, new e(new k[]{e.b(cVar), null}));
    }

    public DateTimeFormatterBuilder F(int i11) {
        return n(DateTimeFieldType.secondOfMinute(), i11, 2);
    }

    public DateTimeFormatterBuilder G(DateTimeFieldType dateTimeFieldType) {
        if (dateTimeFieldType != null) {
            return d(new i(dateTimeFieldType, true));
        }
        throw new IllegalArgumentException("Field type must not be null");
    }

    public DateTimeFormatterBuilder H(DateTimeFieldType dateTimeFieldType, int i11, int i12) {
        if (dateTimeFieldType != null) {
            if (i12 < i11) {
                i12 = i11;
            }
            if (i11 < 0 || i12 <= 0) {
                throw new IllegalArgumentException();
            } else if (i11 <= 1) {
                return d(new m(dateTimeFieldType, i12, true));
            } else {
                return d(new g(dateTimeFieldType, i12, true, i11));
            }
        } else {
            throw new IllegalArgumentException("Field type must not be null");
        }
    }

    public DateTimeFormatterBuilder I(DateTimeFieldType dateTimeFieldType) {
        if (dateTimeFieldType != null) {
            return d(new i(dateTimeFieldType, false));
        }
        throw new IllegalArgumentException("Field type must not be null");
    }

    public DateTimeFormatterBuilder J() {
        TimeZoneId timeZoneId = TimeZoneId.INSTANCE;
        return e(timeZoneId, timeZoneId);
    }

    public DateTimeFormatterBuilder K() {
        return e(new j(0, (Map<String, DateTimeZone>) null), (k) null);
    }

    public DateTimeFormatterBuilder L(String str, String str2, boolean z11, int i11, int i12) {
        return d(new k(str, str2, z11, i11, i12));
    }

    public DateTimeFormatterBuilder M(String str, boolean z11, int i11, int i12) {
        return d(new k(str, str, z11, i11, i12));
    }

    public DateTimeFormatterBuilder N(Map<String, DateTimeZone> map) {
        j jVar = new j(1, map);
        return e(jVar, jVar);
    }

    public DateTimeFormatterBuilder O(int i11, boolean z11) {
        return d(new l(DateTimeFieldType.weekyear(), i11, z11));
    }

    public DateTimeFormatterBuilder P(int i11, boolean z11) {
        return d(new l(DateTimeFieldType.year(), i11, z11));
    }

    public DateTimeFormatterBuilder R(int i11) {
        return n(DateTimeFieldType.weekOfWeekyear(), i11, 2);
    }

    public DateTimeFormatterBuilder S(int i11, int i12) {
        return H(DateTimeFieldType.weekyear(), i11, i12);
    }

    public DateTimeFormatterBuilder T(int i11, int i12) {
        return H(DateTimeFieldType.year(), i11, i12);
    }

    public DateTimeFormatterBuilder U(int i11, int i12) {
        return n(DateTimeFieldType.yearOfEra(), i11, i12);
    }

    public boolean V() {
        return b0(a0());
    }

    public final void W(c cVar) {
        if (cVar == null) {
            throw new IllegalArgumentException("No parser supplied");
        }
    }

    public final void X(f fVar) {
        if (fVar == null) {
            throw new IllegalArgumentException("No printer supplied");
        }
    }

    public DateTimeFormatterBuilder a(b bVar) {
        if (bVar != null) {
            return e(bVar.d(), bVar.c());
        }
        throw new IllegalArgumentException("No formatter supplied");
    }

    public final Object a0() {
        Object obj = this.f23131b;
        if (obj == null) {
            if (this.f23130a.size() == 2) {
                Object obj2 = this.f23130a.get(0);
                Object obj3 = this.f23130a.get(1);
                if (obj2 == null) {
                    obj = obj3;
                } else if (obj2 == obj3 || obj3 == null) {
                    obj = obj2;
                }
            }
            if (obj == null) {
                obj = new b(this.f23130a);
            }
            this.f23131b = obj;
        }
        return obj;
    }

    public DateTimeFormatterBuilder b(c cVar) {
        W(cVar);
        return e((m) null, e.b(cVar));
    }

    public final boolean b0(Object obj) {
        return d0(obj) || c0(obj);
    }

    public DateTimeFormatterBuilder c(f fVar, c[] cVarArr) {
        if (fVar != null) {
            X(fVar);
        }
        if (cVarArr != null) {
            int length = cVarArr.length;
            int i11 = 0;
            if (length != 1) {
                k[] kVarArr = new k[length];
                while (i11 < length - 1) {
                    k b11 = e.b(cVarArr[i11]);
                    kVarArr[i11] = b11;
                    if (b11 != null) {
                        i11++;
                    } else {
                        throw new IllegalArgumentException("Incomplete parser array");
                    }
                }
                kVarArr[i11] = e.b(cVarArr[i11]);
                return e(g.a(fVar), new e(kVarArr));
            } else if (cVarArr[0] != null) {
                return e(g.a(fVar), e.b(cVarArr[0]));
            } else {
                throw new IllegalArgumentException("No parser supplied");
            }
        } else {
            throw new IllegalArgumentException("No parsers supplied");
        }
    }

    public final boolean c0(Object obj) {
        if (!(obj instanceof k)) {
            return false;
        }
        if (obj instanceof b) {
            return ((b) obj).c();
        }
        return true;
    }

    public final DateTimeFormatterBuilder d(Object obj) {
        this.f23131b = null;
        this.f23130a.add(obj);
        this.f23130a.add(obj);
        return this;
    }

    public final boolean d0(Object obj) {
        if (!(obj instanceof m)) {
            return false;
        }
        if (obj instanceof b) {
            return ((b) obj).d();
        }
        return true;
    }

    public final DateTimeFormatterBuilder e(m mVar, k kVar) {
        this.f23131b = null;
        this.f23130a.add(mVar);
        this.f23130a.add(kVar);
        return this;
    }

    public b e0() {
        Object a02 = a0();
        k kVar = null;
        m mVar = d0(a02) ? (m) a02 : null;
        if (c0(a02)) {
            kVar = (k) a02;
        }
        if (mVar != null || kVar != null) {
            return new b(mVar, kVar);
        }
        throw new UnsupportedOperationException("Both printing and parsing not supported");
    }

    public DateTimeFormatterBuilder f(int i11, int i12) {
        return H(DateTimeFieldType.centuryOfEra(), i11, i12);
    }

    public c f0() {
        Object a02 = a0();
        if (c0(a02)) {
            return l.b((k) a02);
        }
        throw new UnsupportedOperationException("Parsing is not supported");
    }

    public DateTimeFormatterBuilder g(int i11) {
        return n(DateTimeFieldType.clockhourOfDay(), i11, 2);
    }

    public DateTimeFormatterBuilder h(int i11) {
        return n(DateTimeFieldType.clockhourOfHalfday(), i11, 2);
    }

    public DateTimeFormatterBuilder i(int i11) {
        return n(DateTimeFieldType.dayOfMonth(), i11, 2);
    }

    public DateTimeFormatterBuilder j(int i11) {
        return n(DateTimeFieldType.dayOfWeek(), i11, 1);
    }

    public DateTimeFormatterBuilder k() {
        return G(DateTimeFieldType.dayOfWeek());
    }

    public DateTimeFormatterBuilder l() {
        return I(DateTimeFieldType.dayOfWeek());
    }

    public DateTimeFormatterBuilder m(int i11) {
        return n(DateTimeFieldType.dayOfYear(), i11, 3);
    }

    public DateTimeFormatterBuilder n(DateTimeFieldType dateTimeFieldType, int i11, int i12) {
        if (dateTimeFieldType != null) {
            if (i12 < i11) {
                i12 = i11;
            }
            if (i11 < 0 || i12 <= 0) {
                throw new IllegalArgumentException();
            } else if (i11 <= 1) {
                return d(new m(dateTimeFieldType, i12, false));
            } else {
                return d(new g(dateTimeFieldType, i12, false, i11));
            }
        } else {
            throw new IllegalArgumentException("Field type must not be null");
        }
    }

    public DateTimeFormatterBuilder o() {
        return I(DateTimeFieldType.era());
    }

    public DateTimeFormatterBuilder p(DateTimeFieldType dateTimeFieldType, int i11) {
        if (dateTimeFieldType == null) {
            throw new IllegalArgumentException("Field type must not be null");
        } else if (i11 > 0) {
            return d(new c(dateTimeFieldType, i11, false));
        } else {
            throw new IllegalArgumentException("Illegal number of digits: " + i11);
        }
    }

    public DateTimeFormatterBuilder q(DateTimeFieldType dateTimeFieldType, int i11, int i12) {
        if (dateTimeFieldType != null) {
            if (i12 < i11) {
                i12 = i11;
            }
            if (i11 >= 0 && i12 > 0) {
                return d(new d(dateTimeFieldType, i11, i12));
            }
            throw new IllegalArgumentException();
        }
        throw new IllegalArgumentException("Field type must not be null");
    }

    public DateTimeFormatterBuilder r(int i11, int i12) {
        return q(DateTimeFieldType.hourOfDay(), i11, i12);
    }

    public DateTimeFormatterBuilder s(int i11, int i12) {
        return q(DateTimeFieldType.minuteOfDay(), i11, i12);
    }

    public DateTimeFormatterBuilder t(int i11, int i12) {
        return q(DateTimeFieldType.secondOfDay(), i11, i12);
    }

    public DateTimeFormatterBuilder u() {
        return I(DateTimeFieldType.halfdayOfDay());
    }

    public DateTimeFormatterBuilder v(int i11) {
        return n(DateTimeFieldType.hourOfDay(), i11, 2);
    }

    public DateTimeFormatterBuilder w(int i11) {
        return n(DateTimeFieldType.hourOfHalfday(), i11, 2);
    }

    public DateTimeFormatterBuilder x(char c11) {
        return d(new a(c11));
    }

    public DateTimeFormatterBuilder y(String str) {
        if (str != null) {
            int length = str.length();
            if (length == 0) {
                return this;
            }
            if (length != 1) {
                return d(new h(str));
            }
            return d(new a(str.charAt(0)));
        }
        throw new IllegalArgumentException("Literal must not be null");
    }

    public DateTimeFormatterBuilder z(int i11) {
        return n(DateTimeFieldType.millisOfSecond(), i11, 3);
    }

    public static class i implements m, k {

        /* renamed from: d  reason: collision with root package name */
        public static Map<Locale, Map<DateTimeFieldType, Object[]>> f23147d = new ConcurrentHashMap();

        /* renamed from: b  reason: collision with root package name */
        public final DateTimeFieldType f23148b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f23149c;

        public i(DateTimeFieldType dateTimeFieldType, boolean z11) {
            this.f23148b = dateTimeFieldType;
            this.f23149c = z11;
        }

        public final String a(long j11, Chronology chronology, Locale locale) {
            DateTimeField field = this.f23148b.getField(chronology);
            if (this.f23149c) {
                return field.getAsShortText(j11, locale);
            }
            return field.getAsText(j11, locale);
        }

        public final String b(org.joda.time.h hVar, Locale locale) {
            if (!hVar.isSupported(this.f23148b)) {
                return "�";
            }
            DateTimeField field = this.f23148b.getField(hVar.getChronology());
            if (this.f23149c) {
                return field.getAsShortText(hVar, locale);
            }
            return field.getAsText(hVar, locale);
        }

        public int estimateParsedLength() {
            return estimatePrintedLength();
        }

        public int estimatePrintedLength() {
            return this.f23149c ? 6 : 20;
        }

        public int parseInto(d dVar, CharSequence charSequence, int i11) {
            int i12;
            Map map;
            Locale o11 = dVar.o();
            Map map2 = f23147d.get(o11);
            if (map2 == null) {
                map2 = new ConcurrentHashMap();
                f23147d.put(o11, map2);
            }
            Object[] objArr = (Object[]) map2.get(this.f23148b);
            if (objArr == null) {
                map = new ConcurrentHashMap(32);
                MutableDateTime.Property property = new MutableDateTime(0, DateTimeZone.UTC).property(this.f23148b);
                int minimumValueOverall = property.getMinimumValueOverall();
                int maximumValueOverall = property.getMaximumValueOverall();
                if (maximumValueOverall - minimumValueOverall > 32) {
                    return ~i11;
                }
                i12 = property.getMaximumTextLength(o11);
                while (minimumValueOverall <= maximumValueOverall) {
                    property.set(minimumValueOverall);
                    String asShortText = property.getAsShortText(o11);
                    Boolean bool = Boolean.TRUE;
                    map.put(asShortText, bool);
                    map.put(property.getAsShortText(o11).toLowerCase(o11), bool);
                    map.put(property.getAsShortText(o11).toUpperCase(o11), bool);
                    map.put(property.getAsText(o11), bool);
                    map.put(property.getAsText(o11).toLowerCase(o11), bool);
                    map.put(property.getAsText(o11).toUpperCase(o11), bool);
                    minimumValueOverall++;
                }
                if (TUIThemeManager.LANGUAGE_EN.equals(o11.getLanguage()) && this.f23148b == DateTimeFieldType.era()) {
                    Boolean bool2 = Boolean.TRUE;
                    map.put("BCE", bool2);
                    map.put("bce", bool2);
                    map.put("CE", bool2);
                    map.put("ce", bool2);
                    i12 = 3;
                }
                map2.put(this.f23148b, new Object[]{map, Integer.valueOf(i12)});
            } else {
                i12 = ((Integer) objArr[1]).intValue();
                map = (Map) objArr[0];
            }
            for (int min = Math.min(charSequence.length(), i12 + i11); min > i11; min--) {
                String obj = charSequence.subSequence(i11, min).toString();
                if (map.containsKey(obj)) {
                    dVar.w(this.f23148b, obj, o11);
                    return min;
                }
            }
            return ~i11;
        }

        public void printTo(Appendable appendable, long j11, Chronology chronology, int i11, DateTimeZone dateTimeZone, Locale locale) throws IOException {
            try {
                appendable.append(a(j11, chronology, locale));
            } catch (RuntimeException unused) {
                appendable.append(Utf8.REPLACEMENT_CHARACTER);
            }
        }

        public void printTo(Appendable appendable, org.joda.time.h hVar, Locale locale) throws IOException {
            try {
                appendable.append(b(hVar, locale));
            } catch (RuntimeException unused) {
                appendable.append(Utf8.REPLACEMENT_CHARACTER);
            }
        }
    }

    public static class g extends f {

        /* renamed from: e  reason: collision with root package name */
        public final int f23145e;

        public g(DateTimeFieldType dateTimeFieldType, int i11, boolean z11, int i12) {
            super(dateTimeFieldType, i11, z11);
            this.f23145e = i12;
        }

        public int estimatePrintedLength() {
            return this.f23143c;
        }

        public void printTo(Appendable appendable, long j11, Chronology chronology, int i11, DateTimeZone dateTimeZone, Locale locale) throws IOException {
            try {
                h.a(appendable, this.f23142b.getField(chronology).get(j11), this.f23145e);
            } catch (RuntimeException unused) {
                DateTimeFormatterBuilder.Q(appendable, this.f23145e);
            }
        }

        public void printTo(Appendable appendable, org.joda.time.h hVar, Locale locale) throws IOException {
            if (hVar.isSupported(this.f23142b)) {
                try {
                    h.a(appendable, hVar.get(this.f23142b), this.f23145e);
                } catch (RuntimeException unused) {
                    DateTimeFormatterBuilder.Q(appendable, this.f23145e);
                }
            } else {
                DateTimeFormatterBuilder.Q(appendable, this.f23145e);
            }
        }
    }

    public static class m extends f {
        public m(DateTimeFieldType dateTimeFieldType, int i11, boolean z11) {
            super(dateTimeFieldType, i11, z11);
        }

        public int estimatePrintedLength() {
            return this.f23143c;
        }

        public void printTo(Appendable appendable, long j11, Chronology chronology, int i11, DateTimeZone dateTimeZone, Locale locale) throws IOException {
            try {
                h.c(appendable, this.f23142b.getField(chronology).get(j11));
            } catch (RuntimeException unused) {
                appendable.append(Utf8.REPLACEMENT_CHARACTER);
            }
        }

        public void printTo(Appendable appendable, org.joda.time.h hVar, Locale locale) throws IOException {
            if (hVar.isSupported(this.f23142b)) {
                try {
                    h.c(appendable, hVar.get(this.f23142b));
                } catch (RuntimeException unused) {
                    appendable.append(Utf8.REPLACEMENT_CHARACTER);
                }
            } else {
                appendable.append(Utf8.REPLACEMENT_CHARACTER);
            }
        }
    }

    public static class l implements m, k {

        /* renamed from: b  reason: collision with root package name */
        public final DateTimeFieldType f23157b;

        /* renamed from: c  reason: collision with root package name */
        public final int f23158c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f23159d;

        public l(DateTimeFieldType dateTimeFieldType, int i11, boolean z11) {
            this.f23157b = dateTimeFieldType;
            this.f23158c = i11;
            this.f23159d = z11;
        }

        public final int a(long j11, Chronology chronology) {
            try {
                int i11 = this.f23157b.getField(chronology).get(j11);
                if (i11 < 0) {
                    i11 = -i11;
                }
                return i11 % 100;
            } catch (RuntimeException unused) {
                return -1;
            }
        }

        public final int b(org.joda.time.h hVar) {
            if (!hVar.isSupported(this.f23157b)) {
                return -1;
            }
            try {
                int i11 = hVar.get(this.f23157b);
                if (i11 < 0) {
                    i11 = -i11;
                }
                return i11 % 100;
            } catch (RuntimeException unused) {
                return -1;
            }
        }

        public int estimateParsedLength() {
            return this.f23159d ? 4 : 2;
        }

        public int estimatePrintedLength() {
            return 2;
        }

        public int parseInto(d dVar, CharSequence charSequence, int i11) {
            int i12;
            int i13;
            int i14;
            int length = charSequence.length() - i11;
            int i15 = 0;
            if (this.f23159d) {
                int i16 = 0;
                boolean z11 = false;
                boolean z12 = false;
                while (i16 < length) {
                    char charAt = charSequence.charAt(i11 + i16);
                    if (i16 != 0 || (charAt != '-' && charAt != '+')) {
                        if (charAt < '0' || charAt > '9') {
                            break;
                        }
                        i16++;
                    } else {
                        z12 = charAt == '-';
                        if (z12) {
                            i16++;
                        } else {
                            i11++;
                            length--;
                        }
                        z11 = true;
                    }
                }
                if (i16 == 0) {
                    return ~i11;
                }
                if (z11 || i16 != 2) {
                    if (i16 >= 9) {
                        i14 = i16 + i11;
                        i13 = Integer.parseInt(charSequence.subSequence(i11, i14).toString());
                    } else {
                        int i17 = z12 ? i11 + 1 : i11;
                        int i18 = i17 + 1;
                        try {
                            int charAt2 = charSequence.charAt(i17) - '0';
                            i14 = i16 + i11;
                            while (i18 < i14) {
                                i18++;
                                charAt2 = (((charAt2 << 3) + (charAt2 << 1)) + charSequence.charAt(i18)) - 48;
                            }
                            i13 = z12 ? -charAt2 : charAt2;
                        } catch (StringIndexOutOfBoundsException unused) {
                            return ~i11;
                        }
                    }
                    dVar.v(this.f23157b, i13);
                    return i14;
                }
            } else if (Math.min(2, length) < 2) {
                return ~i11;
            }
            char charAt3 = charSequence.charAt(i11);
            if (charAt3 < '0' || charAt3 > '9') {
                return ~i11;
            }
            int i19 = charAt3 - '0';
            char charAt4 = charSequence.charAt(i11 + 1);
            if (charAt4 < '0' || charAt4 > '9') {
                return ~i11;
            }
            int i21 = (((i19 << 3) + (i19 << 1)) + charAt4) - 48;
            int i22 = this.f23158c;
            if (dVar.q() != null) {
                i22 = dVar.q().intValue();
            }
            int i23 = i22 - 50;
            if (i23 >= 0) {
                i12 = i23 % 100;
            } else {
                i12 = ((i23 + 1) % 100) + 99;
            }
            if (i21 < i12) {
                i15 = 100;
            }
            dVar.v(this.f23157b, i21 + ((i23 + i15) - i12));
            return i11 + 2;
        }

        public void printTo(Appendable appendable, long j11, Chronology chronology, int i11, DateTimeZone dateTimeZone, Locale locale) throws IOException {
            int a11 = a(j11, chronology);
            if (a11 < 0) {
                appendable.append(Utf8.REPLACEMENT_CHARACTER);
                appendable.append(Utf8.REPLACEMENT_CHARACTER);
                return;
            }
            h.a(appendable, a11, 2);
        }

        public void printTo(Appendable appendable, org.joda.time.h hVar, Locale locale) throws IOException {
            int b11 = b(hVar);
            if (b11 < 0) {
                appendable.append(Utf8.REPLACEMENT_CHARACTER);
                appendable.append(Utf8.REPLACEMENT_CHARACTER);
                return;
            }
            h.a(appendable, b11, 2);
        }
    }

    public static class b implements m, k {

        /* renamed from: b  reason: collision with root package name */
        public final m[] f23133b;

        /* renamed from: c  reason: collision with root package name */
        public final k[] f23134c;

        /* renamed from: d  reason: collision with root package name */
        public final int f23135d;

        /* renamed from: e  reason: collision with root package name */
        public final int f23136e;

        public b(List<Object> list) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            b(list, arrayList, arrayList2);
            if (arrayList.contains((Object) null) || arrayList.isEmpty()) {
                this.f23133b = null;
                this.f23135d = 0;
            } else {
                int size = arrayList.size();
                this.f23133b = new m[size];
                int i11 = 0;
                for (int i12 = 0; i12 < size; i12++) {
                    m mVar = (m) arrayList.get(i12);
                    i11 += mVar.estimatePrintedLength();
                    this.f23133b[i12] = mVar;
                }
                this.f23135d = i11;
            }
            if (arrayList2.contains((Object) null) || arrayList2.isEmpty()) {
                this.f23134c = null;
                this.f23136e = 0;
                return;
            }
            int size2 = arrayList2.size();
            this.f23134c = new k[size2];
            int i13 = 0;
            for (int i14 = 0; i14 < size2; i14++) {
                k kVar = (k) arrayList2.get(i14);
                i13 += kVar.estimateParsedLength();
                this.f23134c[i14] = kVar;
            }
            this.f23136e = i13;
        }

        public final void a(List<Object> list, Object[] objArr) {
            if (objArr != null) {
                for (Object add : objArr) {
                    list.add(add);
                }
            }
        }

        public final void b(List<Object> list, List<Object> list2, List<Object> list3) {
            int size = list.size();
            for (int i11 = 0; i11 < size; i11 += 2) {
                Object obj = list.get(i11);
                if (obj instanceof b) {
                    a(list2, ((b) obj).f23133b);
                } else {
                    list2.add(obj);
                }
                Object obj2 = list.get(i11 + 1);
                if (obj2 instanceof b) {
                    a(list3, ((b) obj2).f23134c);
                } else {
                    list3.add(obj2);
                }
            }
        }

        public boolean c() {
            return this.f23134c != null;
        }

        public boolean d() {
            return this.f23133b != null;
        }

        public int estimateParsedLength() {
            return this.f23136e;
        }

        public int estimatePrintedLength() {
            return this.f23135d;
        }

        public int parseInto(d dVar, CharSequence charSequence, int i11) {
            k[] kVarArr = this.f23134c;
            if (kVarArr != null) {
                int length = kVarArr.length;
                for (int i12 = 0; i12 < length && i11 >= 0; i12++) {
                    i11 = kVarArr[i12].parseInto(dVar, charSequence, i11);
                }
                return i11;
            }
            throw new UnsupportedOperationException();
        }

        public void printTo(Appendable appendable, long j11, Chronology chronology, int i11, DateTimeZone dateTimeZone, Locale locale) throws IOException {
            m[] mVarArr = this.f23133b;
            if (mVarArr != null) {
                Locale locale2 = locale == null ? Locale.getDefault() : locale;
                for (m printTo : mVarArr) {
                    printTo.printTo(appendable, j11, chronology, i11, dateTimeZone, locale2);
                }
                return;
            }
            throw new UnsupportedOperationException();
        }

        public void printTo(Appendable appendable, org.joda.time.h hVar, Locale locale) throws IOException {
            m[] mVarArr = this.f23133b;
            if (mVarArr != null) {
                if (locale == null) {
                    locale = Locale.getDefault();
                }
                for (m printTo : mVarArr) {
                    printTo.printTo(appendable, hVar, locale);
                }
                return;
            }
            throw new UnsupportedOperationException();
        }
    }
}
