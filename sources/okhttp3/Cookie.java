package okhttp3;

import com.amazonaws.services.s3.model.InstructionFileId;
import com.fluttercandies.photo_manager.core.entity.a;
import com.google.common.net.HttpHeaders;
import com.xiaomi.mipush.sdk.Constants;
import gw.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlin.text.Regex;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.Util;
import okhttp3.internal.http.DatesKt;

public final class Cookie {
    public static final Companion Companion = new Companion((r) null);
    /* access modifiers changed from: private */
    public static final Pattern DAY_OF_MONTH_PATTERN = Pattern.compile("(\\d{1,2})[^\\d]*");
    /* access modifiers changed from: private */
    public static final Pattern MONTH_PATTERN = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
    /* access modifiers changed from: private */
    public static final Pattern TIME_PATTERN = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");
    /* access modifiers changed from: private */
    public static final Pattern YEAR_PATTERN = Pattern.compile("(\\d{2,4})[^\\d]*");
    private final String domain;
    private final long expiresAt;
    private final boolean hostOnly;
    private final boolean httpOnly;
    private final String name;
    private final String path;
    private final boolean persistent;
    private final boolean secure;
    private final String value;

    public static final class Builder {
        private String domain;
        private long expiresAt = DatesKt.MAX_DATE;
        private boolean hostOnly;
        private boolean httpOnly;
        private String name;
        private String path = "/";
        private boolean persistent;
        private boolean secure;
        private String value;

        public final Cookie build() {
            String str = this.name;
            Objects.requireNonNull(str, "builder.name == null");
            String str2 = this.value;
            Objects.requireNonNull(str2, "builder.value == null");
            long j11 = this.expiresAt;
            String str3 = this.domain;
            Objects.requireNonNull(str3, "builder.domain == null");
            return new Cookie(str, str2, j11, str3, this.path, this.secure, this.httpOnly, this.persistent, this.hostOnly, (r) null);
        }

        public final Builder domain(String str) {
            return domain(str, false);
        }

        public final Builder expiresAt(long j11) {
            if (j11 <= 0) {
                j11 = Long.MIN_VALUE;
            }
            if (j11 > DatesKt.MAX_DATE) {
                j11 = 253402300799999L;
            }
            this.expiresAt = j11;
            this.persistent = true;
            return this;
        }

        public final Builder hostOnlyDomain(String str) {
            return domain(str, true);
        }

        public final Builder httpOnly() {
            this.httpOnly = true;
            return this;
        }

        public final Builder name(String str) {
            if (x.b(StringsKt__StringsKt.i1(str).toString(), str)) {
                this.name = str;
                return this;
            }
            throw new IllegalArgumentException("name is not trimmed".toString());
        }

        public final Builder path(String str) {
            if (StringsKt__StringsJVMKt.M(str, "/", false, 2, (Object) null)) {
                this.path = str;
                return this;
            }
            throw new IllegalArgumentException("path must start with '/'".toString());
        }

        public final Builder secure() {
            this.secure = true;
            return this;
        }

        public final Builder value(String str) {
            if (x.b(StringsKt__StringsKt.i1(str).toString(), str)) {
                this.value = str;
                return this;
            }
            throw new IllegalArgumentException("value is not trimmed".toString());
        }

        private final Builder domain(String str, boolean z11) {
            String canonicalHost = HostnamesKt.toCanonicalHost(str);
            if (canonicalHost != null) {
                this.domain = canonicalHost;
                this.hostOnly = z11;
                return this;
            }
            throw new IllegalArgumentException("unexpected domain: " + str);
        }
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:27:0x003b, code lost:
            if (r0 != ':') goto L_0x003e;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private final int dateCharacterOffset(java.lang.String r6, int r7, int r8, boolean r9) {
            /*
                r5 = this;
            L_0x0000:
                if (r7 >= r8) goto L_0x0046
                char r0 = r6.charAt(r7)
                r1 = 32
                r2 = 1
                r3 = 0
                if (r0 >= r1) goto L_0x0010
                r1 = 9
                if (r0 != r1) goto L_0x003d
            L_0x0010:
                r1 = 127(0x7f, float:1.78E-43)
                if (r0 >= r1) goto L_0x003d
                r1 = 48
                r4 = 58
                if (r1 > r0) goto L_0x001e
                if (r0 >= r4) goto L_0x001e
                r1 = r2
                goto L_0x001f
            L_0x001e:
                r1 = r3
            L_0x001f:
                if (r1 != 0) goto L_0x003d
                r1 = 97
                if (r1 > r0) goto L_0x002b
                r1 = 123(0x7b, float:1.72E-43)
                if (r0 >= r1) goto L_0x002b
                r1 = r2
                goto L_0x002c
            L_0x002b:
                r1 = r3
            L_0x002c:
                if (r1 != 0) goto L_0x003d
                r1 = 65
                if (r1 > r0) goto L_0x0038
                r1 = 91
                if (r0 >= r1) goto L_0x0038
                r1 = r2
                goto L_0x0039
            L_0x0038:
                r1 = r3
            L_0x0039:
                if (r1 != 0) goto L_0x003d
                if (r0 != r4) goto L_0x003e
            L_0x003d:
                r3 = r2
            L_0x003e:
                r0 = r9 ^ 1
                if (r3 != r0) goto L_0x0043
                return r7
            L_0x0043:
                int r7 = r7 + 1
                goto L_0x0000
            L_0x0046:
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.Cookie.Companion.dateCharacterOffset(java.lang.String, int, int, boolean):int");
        }

        /* access modifiers changed from: private */
        public final boolean domainMatch(String str, String str2) {
            if (x.b(str, str2)) {
                return true;
            }
            if (!StringsKt__StringsJVMKt.v(str, str2, false, 2, (Object) null) || str.charAt((str.length() - str2.length()) - 1) != '.' || Util.canParseAsIpAddress(str)) {
                return false;
            }
            return true;
        }

        private final String parseDomain(String str) {
            if (!StringsKt__StringsJVMKt.v(str, InstructionFileId.DOT, false, 2, (Object) null)) {
                String canonicalHost = HostnamesKt.toCanonicalHost(StringsKt__StringsKt.A0(str, InstructionFileId.DOT));
                if (canonicalHost != null) {
                    return canonicalHost;
                }
                throw new IllegalArgumentException();
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }

        private final long parseExpires(String str, int i11, int i12) {
            String str2 = str;
            int i13 = i12;
            int dateCharacterOffset = dateCharacterOffset(str2, i11, i13, false);
            Matcher matcher = Cookie.TIME_PATTERN.matcher(str2);
            int i14 = -1;
            int i15 = -1;
            int i16 = -1;
            int i17 = -1;
            int i18 = -1;
            int i19 = -1;
            while (dateCharacterOffset < i13) {
                int dateCharacterOffset2 = dateCharacterOffset(str2, dateCharacterOffset + 1, i13, true);
                matcher.region(dateCharacterOffset, dateCharacterOffset2);
                if (i15 == -1 && matcher.usePattern(Cookie.TIME_PATTERN).matches()) {
                    i15 = Integer.parseInt(matcher.group(1));
                    i18 = Integer.parseInt(matcher.group(2));
                    i19 = Integer.parseInt(matcher.group(3));
                } else if (i16 == -1 && matcher.usePattern(Cookie.DAY_OF_MONTH_PATTERN).matches()) {
                    i16 = Integer.parseInt(matcher.group(1));
                } else if (i17 == -1 && matcher.usePattern(Cookie.MONTH_PATTERN).matches()) {
                    i17 = StringsKt__StringsKt.g0(Cookie.MONTH_PATTERN.pattern(), matcher.group(1).toLowerCase(Locale.US), 0, false, 6, (Object) null) / 4;
                } else if (i14 == -1 && matcher.usePattern(Cookie.YEAR_PATTERN).matches()) {
                    i14 = Integer.parseInt(matcher.group(1));
                }
                dateCharacterOffset = dateCharacterOffset(str2, dateCharacterOffset2 + 1, i13, false);
            }
            if (70 <= i14 && i14 < 100) {
                i14 += 1900;
            }
            if (i14 >= 0 && i14 < 70) {
                i14 += 2000;
            }
            if (i14 >= 1601) {
                if (i17 != -1) {
                    if (1 <= i16 && i16 < 32) {
                        if (i15 >= 0 && i15 < 24) {
                            if (i18 >= 0 && i18 < 60) {
                                if (i19 >= 0 && i19 < 60) {
                                    GregorianCalendar gregorianCalendar = new GregorianCalendar(Util.UTC);
                                    gregorianCalendar.setLenient(false);
                                    gregorianCalendar.set(1, i14);
                                    gregorianCalendar.set(2, i17 - 1);
                                    gregorianCalendar.set(5, i16);
                                    gregorianCalendar.set(11, i15);
                                    gregorianCalendar.set(12, i18);
                                    gregorianCalendar.set(13, i19);
                                    gregorianCalendar.set(14, 0);
                                    return gregorianCalendar.getTimeInMillis();
                                }
                                throw new IllegalArgumentException("Failed requirement.".toString());
                            }
                            throw new IllegalArgumentException("Failed requirement.".toString());
                        }
                        throw new IllegalArgumentException("Failed requirement.".toString());
                    }
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }

        private final long parseMaxAge(String str) {
            try {
                long parseLong = Long.parseLong(str);
                if (parseLong <= 0) {
                    return Long.MIN_VALUE;
                }
                return parseLong;
            } catch (NumberFormatException e11) {
                if (!new Regex("-?\\d+").matches(str)) {
                    throw e11;
                } else if (StringsKt__StringsJVMKt.M(str, Constants.ACCEPT_TIME_SEPARATOR_SERVER, false, 2, (Object) null)) {
                    return Long.MIN_VALUE;
                } else {
                    return Long.MAX_VALUE;
                }
            }
        }

        /* access modifiers changed from: private */
        public final boolean pathMatch(HttpUrl httpUrl, String str) {
            String encodedPath = httpUrl.encodedPath();
            if (x.b(encodedPath, str)) {
                return true;
            }
            return StringsKt__StringsJVMKt.M(encodedPath, str, false, 2, (Object) null) && (StringsKt__StringsJVMKt.v(str, "/", false, 2, (Object) null) || encodedPath.charAt(str.length()) == '/');
        }

        public final Cookie parse(HttpUrl httpUrl, String str) {
            return parse$okhttp(System.currentTimeMillis(), httpUrl, str);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:56:0x00f6, code lost:
            if (r1 > okhttp3.internal.http.DatesKt.MAX_DATE) goto L_0x00fe;
         */
        /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
        /* JADX WARNING: Removed duplicated region for block: B:62:0x0108  */
        /* JADX WARNING: Removed duplicated region for block: B:63:0x010b  */
        /* JADX WARNING: Removed duplicated region for block: B:71:0x012b A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:72:0x012c  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final okhttp3.Cookie parse$okhttp(long r27, okhttp3.HttpUrl r29, java.lang.String r30) {
            /*
                r26 = this;
                r0 = r26
                r7 = r30
                r2 = 59
                r3 = 0
                r4 = 0
                r5 = 6
                r6 = 0
                r1 = r30
                int r8 = okhttp3.internal.Util.delimiterOffset$default((java.lang.String) r1, (char) r2, (int) r3, (int) r4, (int) r5, (java.lang.Object) r6)
                r2 = 61
                r5 = 2
                r4 = r8
                int r1 = okhttp3.internal.Util.delimiterOffset$default((java.lang.String) r1, (char) r2, (int) r3, (int) r4, (int) r5, (java.lang.Object) r6)
                r2 = 0
                if (r1 != r8) goto L_0x001c
                return r2
            L_0x001c:
                r3 = 0
                r4 = 1
                java.lang.String r10 = okhttp3.internal.Util.trimSubstring$default(r7, r3, r1, r4, r2)
                int r5 = r10.length()
                if (r5 != 0) goto L_0x002a
                r5 = r4
                goto L_0x002b
            L_0x002a:
                r5 = r3
            L_0x002b:
                if (r5 != 0) goto L_0x0160
                int r5 = okhttp3.internal.Util.indexOfControlOrNonAscii(r10)
                r6 = -1
                if (r5 == r6) goto L_0x0036
                goto L_0x0160
            L_0x0036:
                int r1 = r1 + r4
                java.lang.String r11 = okhttp3.internal.Util.trimSubstring(r7, r1, r8)
                int r1 = okhttp3.internal.Util.indexOfControlOrNonAscii(r11)
                if (r1 == r6) goto L_0x0042
                return r2
            L_0x0042:
                int r8 = r8 + r4
                int r1 = r30.length()
                r5 = -1
                r9 = r2
                r21 = r9
                r16 = r3
                r17 = r16
                r18 = r17
                r19 = r4
                r14 = r5
                r22 = 253402300799999(0xe677d21fdbff, double:1.251973714024093E-309)
            L_0x005a:
                if (r8 >= r1) goto L_0x00ca
                r2 = 59
                int r2 = okhttp3.internal.Util.delimiterOffset((java.lang.String) r7, (char) r2, (int) r8, (int) r1)
                r12 = 61
                int r12 = okhttp3.internal.Util.delimiterOffset((java.lang.String) r7, (char) r12, (int) r8, (int) r2)
                java.lang.String r8 = okhttp3.internal.Util.trimSubstring(r7, r8, r12)
                if (r12 >= r2) goto L_0x0075
                int r12 = r12 + 1
                java.lang.String r12 = okhttp3.internal.Util.trimSubstring(r7, r12, r2)
                goto L_0x0077
            L_0x0075:
                java.lang.String r12 = ""
            L_0x0077:
                java.lang.String r13 = "expires"
                boolean r13 = kotlin.text.StringsKt__StringsJVMKt.w(r8, r13, r4)
                if (r13 == 0) goto L_0x0088
                int r8 = r12.length()     // Catch:{ IllegalArgumentException -> 0x00c6 }
                long r22 = r0.parseExpires(r12, r3, r8)     // Catch:{ IllegalArgumentException -> 0x00c6 }
                goto L_0x0094
            L_0x0088:
                java.lang.String r13 = "max-age"
                boolean r13 = kotlin.text.StringsKt__StringsJVMKt.w(r8, r13, r4)
                if (r13 == 0) goto L_0x0097
                long r14 = r0.parseMaxAge(r12)     // Catch:{  }
            L_0x0094:
                r18 = r4
                goto L_0x00c6
            L_0x0097:
                java.lang.String r13 = "domain"
                boolean r13 = kotlin.text.StringsKt__StringsJVMKt.w(r8, r13, r4)
                if (r13 == 0) goto L_0x00a6
                java.lang.String r9 = r0.parseDomain(r12)     // Catch:{ IllegalArgumentException -> 0x00c6 }
                r19 = r3
                goto L_0x00c6
            L_0x00a6:
                java.lang.String r13 = "path"
                boolean r13 = kotlin.text.StringsKt__StringsJVMKt.w(r8, r13, r4)
                if (r13 == 0) goto L_0x00b1
                r21 = r12
                goto L_0x00c6
            L_0x00b1:
                java.lang.String r12 = "secure"
                boolean r12 = kotlin.text.StringsKt__StringsJVMKt.w(r8, r12, r4)
                if (r12 == 0) goto L_0x00bc
                r16 = r4
                goto L_0x00c6
            L_0x00bc:
                java.lang.String r12 = "httponly"
                boolean r8 = kotlin.text.StringsKt__StringsJVMKt.w(r8, r12, r4)
                if (r8 == 0) goto L_0x00c6
                r17 = r4
            L_0x00c6:
                int r8 = r2 + 1
                r2 = 0
                goto L_0x005a
            L_0x00ca:
                r1 = -9223372036854775808
                int r4 = (r14 > r1 ? 1 : (r14 == r1 ? 0 : -1))
                if (r4 != 0) goto L_0x00d2
            L_0x00d0:
                r12 = r1
                goto L_0x0102
            L_0x00d2:
                int r1 = (r14 > r5 ? 1 : (r14 == r5 ? 0 : -1))
                if (r1 == 0) goto L_0x0100
                r1 = 9223372036854775(0x20c49ba5e353f7, double:4.663754807431093E-308)
                int r1 = (r14 > r1 ? 1 : (r14 == r1 ? 0 : -1))
                if (r1 > 0) goto L_0x00e4
                r1 = 1000(0x3e8, float:1.401E-42)
                long r1 = (long) r1
                long r14 = r14 * r1
                goto L_0x00e9
            L_0x00e4:
                r14 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            L_0x00e9:
                long r1 = r27 + r14
                int r4 = (r1 > r27 ? 1 : (r1 == r27 ? 0 : -1))
                if (r4 < 0) goto L_0x00f9
                r4 = 253402300799999(0xe677d21fdbff, double:1.251973714024093E-309)
                int r6 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
                if (r6 <= 0) goto L_0x00d0
                goto L_0x00fe
            L_0x00f9:
                r4 = 253402300799999(0xe677d21fdbff, double:1.251973714024093E-309)
            L_0x00fe:
                r12 = r4
                goto L_0x0102
            L_0x0100:
                r12 = r22
            L_0x0102:
                java.lang.String r1 = r29.host()
                if (r9 != 0) goto L_0x010b
                r14 = r1
                r2 = 0
                goto L_0x0115
            L_0x010b:
                boolean r2 = r0.domainMatch(r1, r9)
                if (r2 != 0) goto L_0x0113
                r2 = 0
                return r2
            L_0x0113:
                r2 = 0
                r14 = r9
            L_0x0115:
                int r1 = r1.length()
                int r4 = r14.length()
                if (r1 == r4) goto L_0x012c
                okhttp3.internal.publicsuffix.PublicSuffixDatabase$Companion r1 = okhttp3.internal.publicsuffix.PublicSuffixDatabase.Companion
                okhttp3.internal.publicsuffix.PublicSuffixDatabase r1 = r1.get()
                java.lang.String r1 = r1.getEffectiveTldPlusOne(r14)
                if (r1 != 0) goto L_0x012c
                return r2
            L_0x012c:
                java.lang.String r1 = "/"
                r4 = r21
                if (r4 == 0) goto L_0x013c
                r5 = 2
                boolean r2 = kotlin.text.StringsKt__StringsJVMKt.M(r4, r1, r3, r5, r2)
                if (r2 != 0) goto L_0x013a
                goto L_0x013c
            L_0x013a:
                r15 = r4
                goto L_0x0157
            L_0x013c:
                java.lang.String r2 = r29.encodedPath()
                r21 = 47
                r22 = 0
                r23 = 0
                r24 = 6
                r25 = 0
                r20 = r2
                int r4 = kotlin.text.StringsKt__StringsKt.l0(r20, r21, r22, r23, r24, r25)
                if (r4 == 0) goto L_0x0156
                java.lang.String r1 = r2.substring(r3, r4)
            L_0x0156:
                r15 = r1
            L_0x0157:
                okhttp3.Cookie r1 = new okhttp3.Cookie
                r20 = 0
                r9 = r1
                r9.<init>(r10, r11, r12, r14, r15, r16, r17, r18, r19, r20)
                return r1
            L_0x0160:
                r1 = r2
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.Cookie.Companion.parse$okhttp(long, okhttp3.HttpUrl, java.lang.String):okhttp3.Cookie");
        }

        public final List<Cookie> parseAll(HttpUrl httpUrl, Headers headers) {
            List<String> values = headers.values(HttpHeaders.SET_COOKIE);
            int size = values.size();
            ArrayList arrayList = null;
            for (int i11 = 0; i11 < size; i11++) {
                Cookie parse = parse(httpUrl, values.get(i11));
                if (parse != null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(parse);
                }
            }
            if (arrayList != null) {
                return Collections.unmodifiableList(arrayList);
            }
            return CollectionsKt__CollectionsKt.k();
        }
    }

    private Cookie(String str, String str2, long j11, String str3, String str4, boolean z11, boolean z12, boolean z13, boolean z14) {
        this.name = str;
        this.value = str2;
        this.expiresAt = j11;
        this.domain = str3;
        this.path = str4;
        this.secure = z11;
        this.httpOnly = z12;
        this.persistent = z13;
        this.hostOnly = z14;
    }

    public /* synthetic */ Cookie(String str, String str2, long j11, String str3, String str4, boolean z11, boolean z12, boolean z13, boolean z14, r rVar) {
        this(str, str2, j11, str3, str4, z11, z12, z13, z14);
    }

    public static final Cookie parse(HttpUrl httpUrl, String str) {
        return Companion.parse(httpUrl, str);
    }

    public static final List<Cookie> parseAll(HttpUrl httpUrl, Headers headers) {
        return Companion.parseAll(httpUrl, headers);
    }

    /* renamed from: -deprecated_domain  reason: not valid java name */
    public final String m3115deprecated_domain() {
        return this.domain;
    }

    /* renamed from: -deprecated_expiresAt  reason: not valid java name */
    public final long m3116deprecated_expiresAt() {
        return this.expiresAt;
    }

    /* renamed from: -deprecated_hostOnly  reason: not valid java name */
    public final boolean m3117deprecated_hostOnly() {
        return this.hostOnly;
    }

    /* renamed from: -deprecated_httpOnly  reason: not valid java name */
    public final boolean m3118deprecated_httpOnly() {
        return this.httpOnly;
    }

    /* renamed from: -deprecated_name  reason: not valid java name */
    public final String m3119deprecated_name() {
        return this.name;
    }

    /* renamed from: -deprecated_path  reason: not valid java name */
    public final String m3120deprecated_path() {
        return this.path;
    }

    /* renamed from: -deprecated_persistent  reason: not valid java name */
    public final boolean m3121deprecated_persistent() {
        return this.persistent;
    }

    /* renamed from: -deprecated_secure  reason: not valid java name */
    public final boolean m3122deprecated_secure() {
        return this.secure;
    }

    /* renamed from: -deprecated_value  reason: not valid java name */
    public final String m3123deprecated_value() {
        return this.value;
    }

    public final String domain() {
        return this.domain;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Cookie) {
            Cookie cookie = (Cookie) obj;
            return x.b(cookie.name, this.name) && x.b(cookie.value, this.value) && cookie.expiresAt == this.expiresAt && x.b(cookie.domain, this.domain) && x.b(cookie.path, this.path) && cookie.secure == this.secure && cookie.httpOnly == this.httpOnly && cookie.persistent == this.persistent && cookie.hostOnly == this.hostOnly;
        }
    }

    public final long expiresAt() {
        return this.expiresAt;
    }

    public int hashCode() {
        return ((((((((((((((((527 + this.name.hashCode()) * 31) + this.value.hashCode()) * 31) + a.a(this.expiresAt)) * 31) + this.domain.hashCode()) * 31) + this.path.hashCode()) * 31) + e.a(this.secure)) * 31) + e.a(this.httpOnly)) * 31) + e.a(this.persistent)) * 31) + e.a(this.hostOnly);
    }

    public final boolean hostOnly() {
        return this.hostOnly;
    }

    public final boolean httpOnly() {
        return this.httpOnly;
    }

    public final boolean matches(HttpUrl httpUrl) {
        boolean z11;
        if (this.hostOnly) {
            z11 = x.b(httpUrl.host(), this.domain);
        } else {
            z11 = Companion.domainMatch(httpUrl.host(), this.domain);
        }
        if (!z11 || !Companion.pathMatch(httpUrl, this.path)) {
            return false;
        }
        if (!this.secure || httpUrl.isHttps()) {
            return true;
        }
        return false;
    }

    public final String name() {
        return this.name;
    }

    public final String path() {
        return this.path;
    }

    public final boolean persistent() {
        return this.persistent;
    }

    public final boolean secure() {
        return this.secure;
    }

    public String toString() {
        return toString$okhttp(false);
    }

    public final String toString$okhttp(boolean z11) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.name);
        sb2.append('=');
        sb2.append(this.value);
        if (this.persistent) {
            if (this.expiresAt == Long.MIN_VALUE) {
                sb2.append("; max-age=0");
            } else {
                sb2.append("; expires=");
                sb2.append(DatesKt.toHttpDateString(new Date(this.expiresAt)));
            }
        }
        if (!this.hostOnly) {
            sb2.append("; domain=");
            if (z11) {
                sb2.append(InstructionFileId.DOT);
            }
            sb2.append(this.domain);
        }
        sb2.append("; path=");
        sb2.append(this.path);
        if (this.secure) {
            sb2.append("; secure");
        }
        if (this.httpOnly) {
            sb2.append("; httponly");
        }
        return sb2.toString();
    }

    public final String value() {
        return this.value;
    }
}
