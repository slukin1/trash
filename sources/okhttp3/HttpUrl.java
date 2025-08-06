package okhttp3;

import a10.b;
import com.adjust.sdk.Constants;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import com.sumsub.sns.internal.core.common.n0;
import com.tencent.thumbplayer.tcmedia.core.common.TPCodecParamers;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlin.ranges.f;
import kotlin.text.Regex;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.Util;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import okio.Buffer;

public final class HttpUrl {
    public static final Companion Companion = new Companion((r) null);
    public static final String FORM_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#&!$(),~";
    public static final String FRAGMENT_ENCODE_SET = "";
    public static final String FRAGMENT_ENCODE_SET_URI = " \"#<>\\^`{|}";
    /* access modifiers changed from: private */
    public static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    public static final String PASSWORD_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";
    public static final String PATH_SEGMENT_ENCODE_SET = " \"<>^`{}|/\\?#";
    public static final String PATH_SEGMENT_ENCODE_SET_URI = "[]";
    public static final String QUERY_COMPONENT_ENCODE_SET = " !\"#$&'(),/:;<=>?@[]\\^`{|}~";
    public static final String QUERY_COMPONENT_ENCODE_SET_URI = "\\^`{|}";
    public static final String QUERY_COMPONENT_REENCODE_SET = " \"'<>#&=";
    public static final String QUERY_ENCODE_SET = " \"'<>#";
    public static final String USERNAME_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";
    private final String fragment;
    private final String host;
    private final boolean isHttps;
    private final String password;
    private final List<String> pathSegments;
    private final int port;
    private final List<String> queryNamesAndValues;
    private final String scheme;
    private final String url;
    private final String username;

    public static final class Builder {
        public static final Companion Companion = new Companion((r) null);
        public static final String INVALID_HOST = "Invalid URL host";
        private String encodedFragment;
        private String encodedPassword = "";
        private final List<String> encodedPathSegments;
        private List<String> encodedQueryNamesAndValues;
        private String encodedUsername = "";
        private String host;
        private int port = -1;
        private String scheme;

        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(r rVar) {
                this();
            }

            /* access modifiers changed from: private */
            public final int parsePort(String str, int i11, int i12) {
                try {
                    int parseInt = Integer.parseInt(Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, i11, i12, "", false, false, false, false, (Charset) null, 248, (Object) null));
                    boolean z11 = false;
                    if (1 <= parseInt && parseInt < 65536) {
                        z11 = true;
                    }
                    if (z11) {
                        return parseInt;
                    }
                    return -1;
                } catch (NumberFormatException unused) {
                    return -1;
                }
            }

            /* access modifiers changed from: private */
            public final int portColonOffset(String str, int i11, int i12) {
                while (i11 < i12) {
                    char charAt = str.charAt(i11);
                    if (charAt == '[') {
                        do {
                            i11++;
                            if (i11 >= i12) {
                                break;
                            }
                        } while (str.charAt(i11) == ']');
                    } else if (charAt == ':') {
                        return i11;
                    }
                    i11++;
                }
                return i12;
            }

            /* access modifiers changed from: private */
            public final int schemeDelimiterOffset(String str, int i11, int i12) {
                if (i12 - i11 < 2) {
                    return -1;
                }
                char charAt = str.charAt(i11);
                if ((x.c(charAt, 97) >= 0 && x.c(charAt, 122) <= 0) || (x.c(charAt, 65) >= 0 && x.c(charAt, 90) <= 0)) {
                    int i13 = i11 + 1;
                    while (i13 < i12) {
                        char charAt2 = str.charAt(i13);
                        boolean z11 = false;
                        if (((((('a' <= charAt2 && charAt2 < '{') || ('A' <= charAt2 && charAt2 < '[')) || ('0' <= charAt2 && charAt2 < ':')) || charAt2 == '+') || charAt2 == '-') || charAt2 == '.') {
                            z11 = true;
                        }
                        if (z11) {
                            i13++;
                        } else if (charAt2 == ':') {
                            return i13;
                        } else {
                            return -1;
                        }
                    }
                }
                return -1;
            }

            /* access modifiers changed from: private */
            public final int slashCount(String str, int i11, int i12) {
                int i13 = 0;
                while (i11 < i12) {
                    char charAt = str.charAt(i11);
                    if (charAt != '\\' && charAt != '/') {
                        break;
                    }
                    i13++;
                    i11++;
                }
                return i13;
            }
        }

        public Builder() {
            ArrayList arrayList = new ArrayList();
            this.encodedPathSegments = arrayList;
            arrayList.add("");
        }

        private final int effectivePort() {
            int i11 = this.port;
            return i11 != -1 ? i11 : HttpUrl.Companion.defaultPort(this.scheme);
        }

        private final boolean isDot(String str) {
            return x.b(str, InstructionFileId.DOT) || StringsKt__StringsJVMKt.w(str, "%2e", true);
        }

        private final boolean isDotDot(String str) {
            if (x.b(str, "..") || StringsKt__StringsJVMKt.w(str, "%2e.", true) || StringsKt__StringsJVMKt.w(str, ".%2e", true) || StringsKt__StringsJVMKt.w(str, "%2e%2e", true)) {
                return true;
            }
            return false;
        }

        private final void pop() {
            List<String> list = this.encodedPathSegments;
            if (!(list.remove(list.size() - 1).length() == 0) || !(!this.encodedPathSegments.isEmpty())) {
                this.encodedPathSegments.add("");
                return;
            }
            List<String> list2 = this.encodedPathSegments;
            list2.set(list2.size() - 1, "");
        }

        private final void push(String str, int i11, int i12, boolean z11, boolean z12) {
            String canonicalize$okhttp$default = Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, i11, i12, HttpUrl.PATH_SEGMENT_ENCODE_SET, z12, false, false, false, (Charset) null, 240, (Object) null);
            if (!isDot(canonicalize$okhttp$default)) {
                if (isDotDot(canonicalize$okhttp$default)) {
                    pop();
                    return;
                }
                List<String> list = this.encodedPathSegments;
                if (list.get(list.size() - 1).length() == 0) {
                    List<String> list2 = this.encodedPathSegments;
                    list2.set(list2.size() - 1, canonicalize$okhttp$default);
                } else {
                    this.encodedPathSegments.add(canonicalize$okhttp$default);
                }
                if (z11) {
                    this.encodedPathSegments.add("");
                }
            }
        }

        private final void removeAllCanonicalQueryParameters(String str) {
            int size = this.encodedQueryNamesAndValues.size() - 2;
            int c11 = b.c(size, 0, -2);
            if (c11 <= size) {
                while (true) {
                    if (x.b(str, this.encodedQueryNamesAndValues.get(size))) {
                        this.encodedQueryNamesAndValues.remove(size + 1);
                        this.encodedQueryNamesAndValues.remove(size);
                        if (this.encodedQueryNamesAndValues.isEmpty()) {
                            this.encodedQueryNamesAndValues = null;
                            return;
                        }
                    }
                    if (size != c11) {
                        size -= 2;
                    } else {
                        return;
                    }
                }
            }
        }

        private final void resolvePath(String str, int i11, int i12) {
            if (i11 != i12) {
                char charAt = str.charAt(i11);
                if (charAt == '/' || charAt == '\\') {
                    this.encodedPathSegments.clear();
                    this.encodedPathSegments.add("");
                    i11++;
                } else {
                    List<String> list = this.encodedPathSegments;
                    list.set(list.size() - 1, "");
                }
                while (true) {
                    int i13 = i11;
                    while (true) {
                        if (i13 < i12) {
                            i11 = Util.delimiterOffset(str, "/\\", i13, i12);
                            boolean z11 = i11 < i12;
                            push(str, i13, i11, z11, true);
                            if (z11) {
                                i13 = i11 + 1;
                            }
                        } else {
                            return;
                        }
                    }
                }
            }
        }

        public final Builder addEncodedPathSegment(String str) {
            push(str, 0, str.length(), false, true);
            return this;
        }

        public final Builder addEncodedPathSegments(String str) {
            return addPathSegments(str, true);
        }

        public final Builder addEncodedQueryParameter(String str, String str2) {
            if (this.encodedQueryNamesAndValues == null) {
                this.encodedQueryNamesAndValues = new ArrayList();
            }
            List<String> list = this.encodedQueryNamesAndValues;
            Companion companion = HttpUrl.Companion;
            list.add(Companion.canonicalize$okhttp$default(companion, str, 0, 0, HttpUrl.QUERY_COMPONENT_REENCODE_SET, true, false, true, false, (Charset) null, 211, (Object) null));
            this.encodedQueryNamesAndValues.add(str2 != null ? Companion.canonicalize$okhttp$default(companion, str2, 0, 0, HttpUrl.QUERY_COMPONENT_REENCODE_SET, true, false, true, false, (Charset) null, 211, (Object) null) : null);
            return this;
        }

        public final Builder addPathSegment(String str) {
            push(str, 0, str.length(), false, false);
            return this;
        }

        public final Builder addPathSegments(String str) {
            return addPathSegments(str, false);
        }

        public final Builder addQueryParameter(String str, String str2) {
            if (this.encodedQueryNamesAndValues == null) {
                this.encodedQueryNamesAndValues = new ArrayList();
            }
            List<String> list = this.encodedQueryNamesAndValues;
            Companion companion = HttpUrl.Companion;
            list.add(Companion.canonicalize$okhttp$default(companion, str, 0, 0, HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, false, true, false, (Charset) null, 219, (Object) null));
            this.encodedQueryNamesAndValues.add(str2 != null ? Companion.canonicalize$okhttp$default(companion, str2, 0, 0, HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, false, true, false, (Charset) null, 219, (Object) null) : null);
            return this;
        }

        public final HttpUrl build() {
            ArrayList arrayList;
            String str = this.scheme;
            if (str != null) {
                Companion companion = HttpUrl.Companion;
                String percentDecode$okhttp$default = Companion.percentDecode$okhttp$default(companion, this.encodedUsername, 0, 0, false, 7, (Object) null);
                String percentDecode$okhttp$default2 = Companion.percentDecode$okhttp$default(companion, this.encodedPassword, 0, 0, false, 7, (Object) null);
                String str2 = this.host;
                if (str2 != null) {
                    int effectivePort = effectivePort();
                    List<String> list = this.encodedPathSegments;
                    ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.u(list, 10));
                    for (String percentDecode$okhttp$default3 : list) {
                        arrayList2.add(Companion.percentDecode$okhttp$default(HttpUrl.Companion, percentDecode$okhttp$default3, 0, 0, false, 7, (Object) null));
                    }
                    List<String> list2 = this.encodedQueryNamesAndValues;
                    if (list2 != null) {
                        arrayList = new ArrayList(CollectionsKt__IterablesKt.u(list2, 10));
                        for (String str3 : list2) {
                            arrayList.add(str3 != null ? Companion.percentDecode$okhttp$default(HttpUrl.Companion, str3, 0, 0, true, 3, (Object) null) : null);
                        }
                    } else {
                        arrayList = null;
                    }
                    String str4 = this.encodedFragment;
                    return new HttpUrl(str, percentDecode$okhttp$default, percentDecode$okhttp$default2, str2, effectivePort, arrayList2, arrayList, str4 != null ? Companion.percentDecode$okhttp$default(HttpUrl.Companion, str4, 0, 0, false, 7, (Object) null) : null, toString());
                }
                throw new IllegalStateException("host == null");
            }
            throw new IllegalStateException("scheme == null");
        }

        public final Builder encodedFragment(String str) {
            this.encodedFragment = str != null ? Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0, "", true, false, false, true, (Charset) null, 179, (Object) null) : null;
            return this;
        }

        public final Builder encodedPassword(String str) {
            this.encodedPassword = Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, (Charset) null, 243, (Object) null);
            return this;
        }

        public final Builder encodedPath(String str) {
            if (StringsKt__StringsJVMKt.M(str, "/", false, 2, (Object) null)) {
                resolvePath(str, 0, str.length());
                return this;
            }
            throw new IllegalArgumentException(("unexpected encodedPath: " + str).toString());
        }

        public final Builder encodedQuery(String str) {
            List<String> list;
            if (str != null) {
                Companion companion = HttpUrl.Companion;
                String canonicalize$okhttp$default = Companion.canonicalize$okhttp$default(companion, str, 0, 0, HttpUrl.QUERY_ENCODE_SET, true, false, true, false, (Charset) null, 211, (Object) null);
                if (canonicalize$okhttp$default != null) {
                    list = companion.toQueryNamesAndValues$okhttp(canonicalize$okhttp$default);
                    this.encodedQueryNamesAndValues = list;
                    return this;
                }
            }
            list = null;
            this.encodedQueryNamesAndValues = list;
            return this;
        }

        public final Builder encodedUsername(String str) {
            this.encodedUsername = Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, (Charset) null, 243, (Object) null);
            return this;
        }

        public final Builder fragment(String str) {
            this.encodedFragment = str != null ? Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0, "", false, false, false, true, (Charset) null, 187, (Object) null) : null;
            return this;
        }

        public final String getEncodedFragment$okhttp() {
            return this.encodedFragment;
        }

        public final String getEncodedPassword$okhttp() {
            return this.encodedPassword;
        }

        public final List<String> getEncodedPathSegments$okhttp() {
            return this.encodedPathSegments;
        }

        public final List<String> getEncodedQueryNamesAndValues$okhttp() {
            return this.encodedQueryNamesAndValues;
        }

        public final String getEncodedUsername$okhttp() {
            return this.encodedUsername;
        }

        public final String getHost$okhttp() {
            return this.host;
        }

        public final int getPort$okhttp() {
            return this.port;
        }

        public final String getScheme$okhttp() {
            return this.scheme;
        }

        public final Builder host(String str) {
            String canonicalHost = HostnamesKt.toCanonicalHost(Companion.percentDecode$okhttp$default(HttpUrl.Companion, str, 0, 0, false, 7, (Object) null));
            if (canonicalHost != null) {
                this.host = canonicalHost;
                return this;
            }
            throw new IllegalArgumentException("unexpected host: " + str);
        }

        public final Builder parse$okhttp(HttpUrl httpUrl, String str) {
            int i11;
            int delimiterOffset;
            int i12;
            boolean z11;
            int i13;
            boolean z12;
            String str2 = str;
            int indexOfFirstNonAsciiWhitespace$default = Util.indexOfFirstNonAsciiWhitespace$default(str2, 0, 0, 3, (Object) null);
            int indexOfLastNonAsciiWhitespace$default = Util.indexOfLastNonAsciiWhitespace$default(str2, indexOfFirstNonAsciiWhitespace$default, 0, 2, (Object) null);
            Companion companion = Companion;
            int access$schemeDelimiterOffset = companion.schemeDelimiterOffset(str2, indexOfFirstNonAsciiWhitespace$default, indexOfLastNonAsciiWhitespace$default);
            char c11 = 65535;
            boolean z13 = true;
            if (access$schemeDelimiterOffset != -1) {
                if (StringsKt__StringsJVMKt.J(str2, "https:", indexOfFirstNonAsciiWhitespace$default, true)) {
                    this.scheme = Constants.SCHEME;
                    indexOfFirstNonAsciiWhitespace$default += 6;
                } else if (StringsKt__StringsJVMKt.J(str2, "http:", indexOfFirstNonAsciiWhitespace$default, true)) {
                    this.scheme = "http";
                    indexOfFirstNonAsciiWhitespace$default += 5;
                } else {
                    throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but was '" + str2.substring(0, access$schemeDelimiterOffset) + '\'');
                }
            } else if (httpUrl != null) {
                this.scheme = httpUrl.scheme();
            } else {
                if (str.length() > 6) {
                    str2 = StringsKt___StringsKt.q1(str2, 6) + "...";
                }
                throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no scheme was found for " + str2);
            }
            int access$slashCount = companion.slashCount(str2, indexOfFirstNonAsciiWhitespace$default, indexOfLastNonAsciiWhitespace$default);
            char c12 = '?';
            char c13 = n0.h.f32179b;
            if (access$slashCount >= 2 || httpUrl == null || !x.b(httpUrl.scheme(), this.scheme)) {
                int i14 = indexOfFirstNonAsciiWhitespace$default + access$slashCount;
                boolean z14 = false;
                boolean z15 = false;
                while (true) {
                    delimiterOffset = Util.delimiterOffset(str2, "@/\\?#", i14, indexOfLastNonAsciiWhitespace$default);
                    char charAt = delimiterOffset != indexOfLastNonAsciiWhitespace$default ? str2.charAt(delimiterOffset) : c11;
                    if (charAt == c11 || charAt == c13 || charAt == '/' || charAt == '\\' || charAt == c12) {
                        boolean z16 = z13;
                        i11 = indexOfLastNonAsciiWhitespace$default;
                        int i15 = delimiterOffset;
                        Companion companion2 = Companion;
                        int access$portColonOffset = companion2.portColonOffset(str2, i14, i15);
                        int i16 = access$portColonOffset + 1;
                    } else if (charAt == '@') {
                        if (!z14) {
                            int delimiterOffset2 = Util.delimiterOffset(str2, ':', i14, delimiterOffset);
                            Companion companion3 = HttpUrl.Companion;
                            String str3 = "%40";
                            int i17 = delimiterOffset;
                            int i18 = delimiterOffset2;
                            z11 = z13;
                            i12 = indexOfLastNonAsciiWhitespace$default;
                            char c14 = c11;
                            String canonicalize$okhttp$default = Companion.canonicalize$okhttp$default(companion3, str, i14, delimiterOffset2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, (Charset) null, 240, (Object) null);
                            if (z15) {
                                canonicalize$okhttp$default = this.encodedUsername + str3 + canonicalize$okhttp$default;
                            }
                            this.encodedUsername = canonicalize$okhttp$default;
                            int i19 = i17;
                            int i21 = i18;
                            if (i21 != i19) {
                                this.encodedPassword = Companion.canonicalize$okhttp$default(companion3, str, i21 + 1, i19, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, (Charset) null, 240, (Object) null);
                                z12 = z11;
                            } else {
                                z12 = z14;
                            }
                            z14 = z12;
                            i13 = i19;
                            z15 = z11;
                        } else {
                            z11 = z13;
                            i12 = indexOfLastNonAsciiWhitespace$default;
                            char c15 = c11;
                            int i22 = delimiterOffset;
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(this.encodedPassword);
                            sb2.append("%40");
                            StringBuilder sb3 = sb2;
                            i13 = i22;
                            sb3.append(Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, i14, i22, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, (Charset) null, 240, (Object) null));
                            this.encodedPassword = sb3.toString();
                        }
                        i14 = i13 + 1;
                        z13 = z11;
                        indexOfLastNonAsciiWhitespace$default = i12;
                        c13 = n0.h.f32179b;
                        c12 = '?';
                        c11 = 65535;
                    }
                }
                boolean z162 = z13;
                i11 = indexOfLastNonAsciiWhitespace$default;
                int i152 = delimiterOffset;
                Companion companion22 = Companion;
                int access$portColonOffset2 = companion22.portColonOffset(str2, i14, i152);
                int i162 = access$portColonOffset2 + 1;
                if (i162 < i152) {
                    this.host = HostnamesKt.toCanonicalHost(Companion.percentDecode$okhttp$default(HttpUrl.Companion, str, i14, access$portColonOffset2, false, 4, (Object) null));
                    int access$parsePort = companion22.parsePort(str2, i162, i152);
                    this.port = access$parsePort;
                    if (!(access$parsePort != -1 ? z162 : false)) {
                        throw new IllegalArgumentException(("Invalid URL port: \"" + str2.substring(i162, i152) + '\"').toString());
                    }
                } else {
                    Companion companion4 = HttpUrl.Companion;
                    this.host = HostnamesKt.toCanonicalHost(Companion.percentDecode$okhttp$default(companion4, str, i14, access$portColonOffset2, false, 4, (Object) null));
                    this.port = companion4.defaultPort(this.scheme);
                }
                if (this.host != null ? z162 : false) {
                    indexOfFirstNonAsciiWhitespace$default = i152;
                } else {
                    throw new IllegalArgumentException(("Invalid URL host: \"" + str2.substring(i14, access$portColonOffset2) + '\"').toString());
                }
            } else {
                this.encodedUsername = httpUrl.encodedUsername();
                this.encodedPassword = httpUrl.encodedPassword();
                this.host = httpUrl.host();
                this.port = httpUrl.port();
                this.encodedPathSegments.clear();
                this.encodedPathSegments.addAll(httpUrl.encodedPathSegments());
                if (indexOfFirstNonAsciiWhitespace$default == indexOfLastNonAsciiWhitespace$default || str2.charAt(indexOfFirstNonAsciiWhitespace$default) == '#') {
                    encodedQuery(httpUrl.encodedQuery());
                }
                i11 = indexOfLastNonAsciiWhitespace$default;
            }
            int i23 = i11;
            int delimiterOffset3 = Util.delimiterOffset(str2, "?#", indexOfFirstNonAsciiWhitespace$default, i23);
            resolvePath(str2, indexOfFirstNonAsciiWhitespace$default, delimiterOffset3);
            if (delimiterOffset3 < i23 && str2.charAt(delimiterOffset3) == '?') {
                int delimiterOffset4 = Util.delimiterOffset(str2, (char) n0.h.f32179b, delimiterOffset3, i23);
                Companion companion5 = HttpUrl.Companion;
                this.encodedQueryNamesAndValues = companion5.toQueryNamesAndValues$okhttp(Companion.canonicalize$okhttp$default(companion5, str, delimiterOffset3 + 1, delimiterOffset4, HttpUrl.QUERY_ENCODE_SET, true, false, true, false, (Charset) null, 208, (Object) null));
                delimiterOffset3 = delimiterOffset4;
            }
            if (delimiterOffset3 < i23 && str2.charAt(delimiterOffset3) == '#') {
                this.encodedFragment = Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, delimiterOffset3 + 1, i23, "", true, false, false, true, (Charset) null, 176, (Object) null);
            }
            return this;
        }

        public final Builder password(String str) {
            this.encodedPassword = Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, (Charset) null, 251, (Object) null);
            return this;
        }

        public final Builder port(int i11) {
            boolean z11 = false;
            if (1 <= i11 && i11 < 65536) {
                z11 = true;
            }
            if (z11) {
                this.port = i11;
                return this;
            }
            throw new IllegalArgumentException(("unexpected port: " + i11).toString());
        }

        public final Builder query(String str) {
            List<String> list;
            if (str != null) {
                Companion companion = HttpUrl.Companion;
                String canonicalize$okhttp$default = Companion.canonicalize$okhttp$default(companion, str, 0, 0, HttpUrl.QUERY_ENCODE_SET, false, false, true, false, (Charset) null, 219, (Object) null);
                if (canonicalize$okhttp$default != null) {
                    list = companion.toQueryNamesAndValues$okhttp(canonicalize$okhttp$default);
                    this.encodedQueryNamesAndValues = list;
                    return this;
                }
            }
            list = null;
            this.encodedQueryNamesAndValues = list;
            return this;
        }

        public final Builder reencodeForUri$okhttp() {
            String str = this.host;
            String str2 = null;
            this.host = str != null ? new Regex("[\"<>^`{|}]").replace((CharSequence) str, "") : null;
            int size = this.encodedPathSegments.size();
            for (int i11 = 0; i11 < size; i11++) {
                List<String> list = this.encodedPathSegments;
                list.set(i11, Companion.canonicalize$okhttp$default(HttpUrl.Companion, list.get(i11), 0, 0, HttpUrl.PATH_SEGMENT_ENCODE_SET_URI, true, true, false, false, (Charset) null, 227, (Object) null));
            }
            List<String> list2 = this.encodedQueryNamesAndValues;
            if (list2 != null) {
                int size2 = list2.size();
                for (int i12 = 0; i12 < size2; i12++) {
                    String str3 = list2.get(i12);
                    list2.set(i12, str3 != null ? Companion.canonicalize$okhttp$default(HttpUrl.Companion, str3, 0, 0, HttpUrl.QUERY_COMPONENT_ENCODE_SET_URI, true, true, true, false, (Charset) null, TPCodecParamers.TP_PROFILE_MJPEG_HUFFMAN_LOSSLESS, (Object) null) : null);
                }
            }
            String str4 = this.encodedFragment;
            if (str4 != null) {
                str2 = Companion.canonicalize$okhttp$default(HttpUrl.Companion, str4, 0, 0, HttpUrl.FRAGMENT_ENCODE_SET_URI, true, true, false, true, (Charset) null, 163, (Object) null);
            }
            this.encodedFragment = str2;
            return this;
        }

        public final Builder removeAllEncodedQueryParameters(String str) {
            if (this.encodedQueryNamesAndValues == null) {
                return this;
            }
            removeAllCanonicalQueryParameters(Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0, HttpUrl.QUERY_COMPONENT_REENCODE_SET, true, false, true, false, (Charset) null, 211, (Object) null));
            return this;
        }

        public final Builder removeAllQueryParameters(String str) {
            if (this.encodedQueryNamesAndValues == null) {
                return this;
            }
            removeAllCanonicalQueryParameters(Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0, HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, false, true, false, (Charset) null, 219, (Object) null));
            return this;
        }

        public final Builder removePathSegment(int i11) {
            this.encodedPathSegments.remove(i11);
            if (this.encodedPathSegments.isEmpty()) {
                this.encodedPathSegments.add("");
            }
            return this;
        }

        public final Builder scheme(String str) {
            if (StringsKt__StringsJVMKt.w(str, "http", true)) {
                this.scheme = "http";
            } else if (StringsKt__StringsJVMKt.w(str, Constants.SCHEME, true)) {
                this.scheme = Constants.SCHEME;
            } else {
                throw new IllegalArgumentException("unexpected scheme: " + str);
            }
            return this;
        }

        public final void setEncodedFragment$okhttp(String str) {
            this.encodedFragment = str;
        }

        public final void setEncodedPassword$okhttp(String str) {
            this.encodedPassword = str;
        }

        public final Builder setEncodedPathSegment(int i11, String str) {
            String canonicalize$okhttp$default = Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0, HttpUrl.PATH_SEGMENT_ENCODE_SET, true, false, false, false, (Charset) null, 243, (Object) null);
            this.encodedPathSegments.set(i11, canonicalize$okhttp$default);
            if (!isDot(canonicalize$okhttp$default) && !isDotDot(canonicalize$okhttp$default)) {
                return this;
            }
            throw new IllegalArgumentException(("unexpected path segment: " + str).toString());
        }

        public final void setEncodedQueryNamesAndValues$okhttp(List<String> list) {
            this.encodedQueryNamesAndValues = list;
        }

        public final Builder setEncodedQueryParameter(String str, String str2) {
            removeAllEncodedQueryParameters(str);
            addEncodedQueryParameter(str, str2);
            return this;
        }

        public final void setEncodedUsername$okhttp(String str) {
            this.encodedUsername = str;
        }

        public final void setHost$okhttp(String str) {
            this.host = str;
        }

        public final Builder setPathSegment(int i11, String str) {
            String canonicalize$okhttp$default = Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0, HttpUrl.PATH_SEGMENT_ENCODE_SET, false, false, false, false, (Charset) null, 251, (Object) null);
            if (!isDot(canonicalize$okhttp$default) && !isDotDot(canonicalize$okhttp$default)) {
                this.encodedPathSegments.set(i11, canonicalize$okhttp$default);
                return this;
            }
            throw new IllegalArgumentException(("unexpected path segment: " + str).toString());
        }

        public final void setPort$okhttp(int i11) {
            this.port = i11;
        }

        public final Builder setQueryParameter(String str, String str2) {
            removeAllQueryParameters(str);
            addQueryParameter(str, str2);
            return this;
        }

        public final void setScheme$okhttp(String str) {
            this.scheme = str;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0033, code lost:
            if ((r6.encodedPassword.length() > 0) != false) goto L_0x0035;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String toString() {
            /*
                r6 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = r6.scheme
                if (r1 == 0) goto L_0x0012
                r0.append(r1)
                java.lang.String r1 = "://"
                r0.append(r1)
                goto L_0x0017
            L_0x0012:
                java.lang.String r1 = "//"
                r0.append(r1)
            L_0x0017:
                java.lang.String r1 = r6.encodedUsername
                int r1 = r1.length()
                r2 = 1
                r3 = 0
                if (r1 <= 0) goto L_0x0023
                r1 = r2
                goto L_0x0024
            L_0x0023:
                r1 = r3
            L_0x0024:
                r4 = 58
                if (r1 != 0) goto L_0x0035
                java.lang.String r1 = r6.encodedPassword
                int r1 = r1.length()
                if (r1 <= 0) goto L_0x0032
                r1 = r2
                goto L_0x0033
            L_0x0032:
                r1 = r3
            L_0x0033:
                if (r1 == 0) goto L_0x0053
            L_0x0035:
                java.lang.String r1 = r6.encodedUsername
                r0.append(r1)
                java.lang.String r1 = r6.encodedPassword
                int r1 = r1.length()
                if (r1 <= 0) goto L_0x0043
                goto L_0x0044
            L_0x0043:
                r2 = r3
            L_0x0044:
                if (r2 == 0) goto L_0x004e
                r0.append(r4)
                java.lang.String r1 = r6.encodedPassword
                r0.append(r1)
            L_0x004e:
                r1 = 64
                r0.append(r1)
            L_0x0053:
                java.lang.String r1 = r6.host
                if (r1 == 0) goto L_0x0074
                r2 = 2
                r5 = 0
                boolean r1 = kotlin.text.StringsKt__StringsKt.Q(r1, r4, r3, r2, r5)
                if (r1 == 0) goto L_0x006f
                r1 = 91
                r0.append(r1)
                java.lang.String r1 = r6.host
                r0.append(r1)
                r1 = 93
                r0.append(r1)
                goto L_0x0074
            L_0x006f:
                java.lang.String r1 = r6.host
                r0.append(r1)
            L_0x0074:
                int r1 = r6.port
                r2 = -1
                if (r1 != r2) goto L_0x007d
                java.lang.String r1 = r6.scheme
                if (r1 == 0) goto L_0x0093
            L_0x007d:
                int r1 = r6.effectivePort()
                java.lang.String r2 = r6.scheme
                if (r2 == 0) goto L_0x008d
                okhttp3.HttpUrl$Companion r3 = okhttp3.HttpUrl.Companion
                int r2 = r3.defaultPort(r2)
                if (r1 == r2) goto L_0x0093
            L_0x008d:
                r0.append(r4)
                r0.append(r1)
            L_0x0093:
                okhttp3.HttpUrl$Companion r1 = okhttp3.HttpUrl.Companion
                java.util.List<java.lang.String> r2 = r6.encodedPathSegments
                r1.toPathString$okhttp(r2, r0)
                java.util.List<java.lang.String> r2 = r6.encodedQueryNamesAndValues
                if (r2 == 0) goto L_0x00a8
                r2 = 63
                r0.append(r2)
                java.util.List<java.lang.String> r2 = r6.encodedQueryNamesAndValues
                r1.toQueryString$okhttp(r2, r0)
            L_0x00a8:
                java.lang.String r1 = r6.encodedFragment
                if (r1 == 0) goto L_0x00b6
                r1 = 35
                r0.append(r1)
                java.lang.String r1 = r6.encodedFragment
                r0.append(r1)
            L_0x00b6:
                java.lang.String r0 = r0.toString()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.HttpUrl.Builder.toString():java.lang.String");
        }

        public final Builder username(String str) {
            this.encodedUsername = Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, (Charset) null, 251, (Object) null);
            return this;
        }

        private final Builder addPathSegments(String str, boolean z11) {
            int i11 = 0;
            do {
                int delimiterOffset = Util.delimiterOffset(str, "/\\", i11, str.length());
                push(str, i11, delimiterOffset, delimiterOffset < str.length(), z11);
                i11 = delimiterOffset + 1;
            } while (i11 <= str.length());
            return this;
        }
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }

        public static /* synthetic */ String canonicalize$okhttp$default(Companion companion, String str, int i11, int i12, String str2, boolean z11, boolean z12, boolean z13, boolean z14, Charset charset, int i13, Object obj) {
            int i14 = i13;
            return companion.canonicalize$okhttp(str, (i14 & 1) != 0 ? 0 : i11, (i14 & 2) != 0 ? str.length() : i12, str2, (i14 & 8) != 0 ? false : z11, (i14 & 16) != 0 ? false : z12, (i14 & 32) != 0 ? false : z13, (i14 & 64) != 0 ? false : z14, (i14 & 128) != 0 ? null : charset);
        }

        private final boolean isPercentEncoded(String str, int i11, int i12) {
            int i13 = i11 + 2;
            if (i13 >= i12 || str.charAt(i11) != '%' || Util.parseHexDigit(str.charAt(i11 + 1)) == -1 || Util.parseHexDigit(str.charAt(i13)) == -1) {
                return false;
            }
            return true;
        }

        public static /* synthetic */ String percentDecode$okhttp$default(Companion companion, String str, int i11, int i12, boolean z11, int i13, Object obj) {
            if ((i13 & 1) != 0) {
                i11 = 0;
            }
            if ((i13 & 2) != 0) {
                i12 = str.length();
            }
            if ((i13 & 4) != 0) {
                z11 = false;
            }
            return companion.percentDecode$okhttp(str, i11, i12, z11);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:33:0x005f, code lost:
            if (isPercentEncoded(r1, r5, r2) == false) goto L_0x006c;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private final void writeCanonicalized(okio.Buffer r15, java.lang.String r16, int r17, int r18, java.lang.String r19, boolean r20, boolean r21, boolean r22, boolean r23, java.nio.charset.Charset r24) {
            /*
                r14 = this;
                r0 = r15
                r1 = r16
                r2 = r18
                r3 = r24
                r4 = 0
                r5 = r17
                r6 = r4
            L_0x000b:
                if (r5 >= r2) goto L_0x00b9
                int r7 = r1.codePointAt(r5)
                if (r20 == 0) goto L_0x0028
                r8 = 9
                if (r7 == r8) goto L_0x0023
                r8 = 10
                if (r7 == r8) goto L_0x0023
                r8 = 12
                if (r7 == r8) goto L_0x0023
                r8 = 13
                if (r7 != r8) goto L_0x0028
            L_0x0023:
                r8 = r14
                r12 = r19
                goto L_0x00b2
            L_0x0028:
                r8 = 43
                if (r7 != r8) goto L_0x0039
                if (r22 == 0) goto L_0x0039
                if (r20 == 0) goto L_0x0033
                java.lang.String r8 = "+"
                goto L_0x0035
            L_0x0033:
                java.lang.String r8 = "%2B"
            L_0x0035:
                r15.writeUtf8((java.lang.String) r8)
                goto L_0x0023
            L_0x0039:
                r8 = 32
                r9 = 37
                if (r7 < r8) goto L_0x0069
                r8 = 127(0x7f, float:1.78E-43)
                if (r7 == r8) goto L_0x0069
                r8 = 128(0x80, float:1.794E-43)
                if (r7 < r8) goto L_0x0049
                if (r23 == 0) goto L_0x0069
            L_0x0049:
                char r8 = (char) r7
                r10 = 0
                r11 = 2
                r12 = r19
                boolean r8 = kotlin.text.StringsKt__StringsKt.Q(r12, r8, r10, r11, r4)
                if (r8 != 0) goto L_0x0067
                if (r7 != r9) goto L_0x0062
                if (r20 == 0) goto L_0x0067
                if (r21 == 0) goto L_0x0062
                r8 = r14
                boolean r10 = r14.isPercentEncoded(r1, r5, r2)
                if (r10 != 0) goto L_0x0063
                goto L_0x006c
            L_0x0062:
                r8 = r14
            L_0x0063:
                r15.writeUtf8CodePoint((int) r7)
                goto L_0x00b2
            L_0x0067:
                r8 = r14
                goto L_0x006c
            L_0x0069:
                r8 = r14
                r12 = r19
            L_0x006c:
                if (r6 != 0) goto L_0x0073
                okio.Buffer r6 = new okio.Buffer
                r6.<init>()
            L_0x0073:
                if (r3 == 0) goto L_0x0087
                java.nio.charset.Charset r10 = java.nio.charset.StandardCharsets.UTF_8
                boolean r10 = kotlin.jvm.internal.x.b(r3, r10)
                if (r10 == 0) goto L_0x007e
                goto L_0x0087
            L_0x007e:
                int r10 = java.lang.Character.charCount(r7)
                int r10 = r10 + r5
                r6.writeString((java.lang.String) r1, (int) r5, (int) r10, (java.nio.charset.Charset) r3)
                goto L_0x008a
            L_0x0087:
                r6.writeUtf8CodePoint((int) r7)
            L_0x008a:
                boolean r10 = r6.exhausted()
                if (r10 != 0) goto L_0x00b2
                byte r10 = r6.readByte()
                r10 = r10 & 255(0xff, float:3.57E-43)
                r15.writeByte((int) r9)
                char[] r11 = okhttp3.HttpUrl.HEX_DIGITS
                int r13 = r10 >> 4
                r13 = r13 & 15
                char r11 = r11[r13]
                r15.writeByte((int) r11)
                char[] r11 = okhttp3.HttpUrl.HEX_DIGITS
                r10 = r10 & 15
                char r10 = r11[r10]
                r15.writeByte((int) r10)
                goto L_0x008a
            L_0x00b2:
                int r7 = java.lang.Character.charCount(r7)
                int r5 = r5 + r7
                goto L_0x000b
            L_0x00b9:
                r8 = r14
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.HttpUrl.Companion.writeCanonicalized(okio.Buffer, java.lang.String, int, int, java.lang.String, boolean, boolean, boolean, boolean, java.nio.charset.Charset):void");
        }

        private final void writePercentDecoded(Buffer buffer, String str, int i11, int i12, boolean z11) {
            int i13;
            while (i11 < i12) {
                int codePointAt = str.codePointAt(i11);
                if (codePointAt == 37 && (i13 = i11 + 2) < i12) {
                    int parseHexDigit = Util.parseHexDigit(str.charAt(i11 + 1));
                    int parseHexDigit2 = Util.parseHexDigit(str.charAt(i13));
                    if (!(parseHexDigit == -1 || parseHexDigit2 == -1)) {
                        buffer.writeByte((parseHexDigit << 4) + parseHexDigit2);
                        i11 = Character.charCount(codePointAt) + i13;
                    }
                } else if (codePointAt == 43 && z11) {
                    buffer.writeByte(32);
                    i11++;
                }
                buffer.writeUtf8CodePoint(codePointAt);
                i11 += Character.charCount(codePointAt);
            }
        }

        /* renamed from: -deprecated_get  reason: not valid java name */
        public final HttpUrl m3155deprecated_get(String str) {
            return get(str);
        }

        /* renamed from: -deprecated_parse  reason: not valid java name */
        public final HttpUrl m3158deprecated_parse(String str) {
            return parse(str);
        }

        public final String canonicalize$okhttp(String str, int i11, int i12, String str2, boolean z11, boolean z12, boolean z13, boolean z14, Charset charset) {
            String str3 = str;
            int i13 = i12;
            int i14 = i11;
            while (i14 < i13) {
                int codePointAt = str.codePointAt(i14);
                if (codePointAt < 32 || codePointAt == 127 || (codePointAt >= 128 && !z14)) {
                    String str4 = str2;
                } else {
                    if (!StringsKt__StringsKt.Q(str2, (char) codePointAt, false, 2, (Object) null)) {
                        if (codePointAt == 37) {
                            if (z11) {
                                if (z12) {
                                    if (!isPercentEncoded(str, i14, i13)) {
                                    }
                                    if (codePointAt == 43 || !z13) {
                                        i14 += Character.charCount(codePointAt);
                                    }
                                }
                            }
                        }
                        if (codePointAt == 43) {
                        }
                        i14 += Character.charCount(codePointAt);
                    }
                }
                Buffer buffer = new Buffer();
                int i15 = i11;
                buffer.writeUtf8(str, i11, i14);
                writeCanonicalized(buffer, str, i14, i12, str2, z11, z12, z13, z14, charset);
                return buffer.readUtf8();
            }
            int i16 = i11;
            return str.substring(i11, i12);
        }

        public final int defaultPort(String str) {
            if (x.b(str, "http")) {
                return 80;
            }
            if (x.b(str, Constants.SCHEME)) {
                return PsExtractor.SYSTEM_HEADER_START_CODE;
            }
            return -1;
        }

        public final HttpUrl get(String str) {
            return new Builder().parse$okhttp((HttpUrl) null, str).build();
        }

        public final HttpUrl parse(String str) {
            try {
                return get(str);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        public final String percentDecode$okhttp(String str, int i11, int i12, boolean z11) {
            for (int i13 = i11; i13 < i12; i13++) {
                char charAt = str.charAt(i13);
                if (charAt == '%' || (charAt == '+' && z11)) {
                    Buffer buffer = new Buffer();
                    buffer.writeUtf8(str, i11, i13);
                    writePercentDecoded(buffer, str, i13, i12, z11);
                    return buffer.readUtf8();
                }
            }
            return str.substring(i11, i12);
        }

        public final void toPathString$okhttp(List<String> list, StringBuilder sb2) {
            int size = list.size();
            for (int i11 = 0; i11 < size; i11++) {
                sb2.append('/');
                sb2.append(list.get(i11));
            }
        }

        public final List<String> toQueryNamesAndValues$okhttp(String str) {
            ArrayList arrayList = new ArrayList();
            int i11 = 0;
            while (i11 <= str.length()) {
                int f02 = StringsKt__StringsKt.f0(str, '&', i11, false, 4, (Object) null);
                if (f02 == -1) {
                    f02 = str.length();
                }
                int i12 = f02;
                int f03 = StringsKt__StringsKt.f0(str, '=', i11, false, 4, (Object) null);
                if (f03 == -1 || f03 > i12) {
                    arrayList.add(str.substring(i11, i12));
                    arrayList.add((Object) null);
                } else {
                    arrayList.add(str.substring(i11, f03));
                    arrayList.add(str.substring(f03 + 1, i12));
                }
                i11 = i12 + 1;
            }
            return arrayList;
        }

        public final void toQueryString$okhttp(List<String> list, StringBuilder sb2) {
            f n11 = RangesKt___RangesKt.n(RangesKt___RangesKt.o(0, list.size()), 2);
            int a11 = n11.a();
            int b11 = n11.b();
            int c11 = n11.c();
            if ((c11 > 0 && a11 <= b11) || (c11 < 0 && b11 <= a11)) {
                while (true) {
                    String str = list.get(a11);
                    String str2 = list.get(a11 + 1);
                    if (a11 > 0) {
                        sb2.append('&');
                    }
                    sb2.append(str);
                    if (str2 != null) {
                        sb2.append('=');
                        sb2.append(str2);
                    }
                    if (a11 != b11) {
                        a11 += c11;
                    } else {
                        return;
                    }
                }
            }
        }

        /* renamed from: -deprecated_get  reason: not valid java name */
        public final HttpUrl m3157deprecated_get(URL url) {
            return get(url);
        }

        public final HttpUrl get(URL url) {
            return parse(url.toString());
        }

        /* renamed from: -deprecated_get  reason: not valid java name */
        public final HttpUrl m3156deprecated_get(URI uri) {
            return get(uri);
        }

        public final HttpUrl get(URI uri) {
            return parse(uri.toString());
        }
    }

    public HttpUrl(String str, String str2, String str3, String str4, int i11, List<String> list, List<String> list2, String str5, String str6) {
        this.scheme = str;
        this.username = str2;
        this.password = str3;
        this.host = str4;
        this.port = i11;
        this.pathSegments = list;
        this.queryNamesAndValues = list2;
        this.fragment = str5;
        this.url = str6;
        this.isHttps = x.b(str, Constants.SCHEME);
    }

    public static final int defaultPort(String str) {
        return Companion.defaultPort(str);
    }

    public static final HttpUrl get(String str) {
        return Companion.get(str);
    }

    public static final HttpUrl get(URI uri) {
        return Companion.get(uri);
    }

    public static final HttpUrl get(URL url2) {
        return Companion.get(url2);
    }

    public static final HttpUrl parse(String str) {
        return Companion.parse(str);
    }

    /* renamed from: -deprecated_encodedFragment  reason: not valid java name */
    public final String m3136deprecated_encodedFragment() {
        return encodedFragment();
    }

    /* renamed from: -deprecated_encodedPassword  reason: not valid java name */
    public final String m3137deprecated_encodedPassword() {
        return encodedPassword();
    }

    /* renamed from: -deprecated_encodedPath  reason: not valid java name */
    public final String m3138deprecated_encodedPath() {
        return encodedPath();
    }

    /* renamed from: -deprecated_encodedPathSegments  reason: not valid java name */
    public final List<String> m3139deprecated_encodedPathSegments() {
        return encodedPathSegments();
    }

    /* renamed from: -deprecated_encodedQuery  reason: not valid java name */
    public final String m3140deprecated_encodedQuery() {
        return encodedQuery();
    }

    /* renamed from: -deprecated_encodedUsername  reason: not valid java name */
    public final String m3141deprecated_encodedUsername() {
        return encodedUsername();
    }

    /* renamed from: -deprecated_fragment  reason: not valid java name */
    public final String m3142deprecated_fragment() {
        return this.fragment;
    }

    /* renamed from: -deprecated_host  reason: not valid java name */
    public final String m3143deprecated_host() {
        return this.host;
    }

    /* renamed from: -deprecated_password  reason: not valid java name */
    public final String m3144deprecated_password() {
        return this.password;
    }

    /* renamed from: -deprecated_pathSegments  reason: not valid java name */
    public final List<String> m3145deprecated_pathSegments() {
        return this.pathSegments;
    }

    /* renamed from: -deprecated_pathSize  reason: not valid java name */
    public final int m3146deprecated_pathSize() {
        return pathSize();
    }

    /* renamed from: -deprecated_port  reason: not valid java name */
    public final int m3147deprecated_port() {
        return this.port;
    }

    /* renamed from: -deprecated_query  reason: not valid java name */
    public final String m3148deprecated_query() {
        return query();
    }

    /* renamed from: -deprecated_queryParameterNames  reason: not valid java name */
    public final Set<String> m3149deprecated_queryParameterNames() {
        return queryParameterNames();
    }

    /* renamed from: -deprecated_querySize  reason: not valid java name */
    public final int m3150deprecated_querySize() {
        return querySize();
    }

    /* renamed from: -deprecated_scheme  reason: not valid java name */
    public final String m3151deprecated_scheme() {
        return this.scheme;
    }

    /* renamed from: -deprecated_uri  reason: not valid java name */
    public final URI m3152deprecated_uri() {
        return uri();
    }

    /* renamed from: -deprecated_url  reason: not valid java name */
    public final URL m3153deprecated_url() {
        return url();
    }

    /* renamed from: -deprecated_username  reason: not valid java name */
    public final String m3154deprecated_username() {
        return this.username;
    }

    public final String encodedFragment() {
        if (this.fragment == null) {
            return null;
        }
        return this.url.substring(StringsKt__StringsKt.f0(this.url, n0.h.f32179b, 0, false, 6, (Object) null) + 1);
    }

    public final String encodedPassword() {
        if (this.password.length() == 0) {
            return "";
        }
        return this.url.substring(StringsKt__StringsKt.f0(this.url, ':', this.scheme.length() + 3, false, 4, (Object) null) + 1, StringsKt__StringsKt.f0(this.url, '@', 0, false, 6, (Object) null));
    }

    public final String encodedPath() {
        int f02 = StringsKt__StringsKt.f0(this.url, '/', this.scheme.length() + 3, false, 4, (Object) null);
        String str = this.url;
        return this.url.substring(f02, Util.delimiterOffset(str, "?#", f02, str.length()));
    }

    public final List<String> encodedPathSegments() {
        int f02 = StringsKt__StringsKt.f0(this.url, '/', this.scheme.length() + 3, false, 4, (Object) null);
        String str = this.url;
        int delimiterOffset = Util.delimiterOffset(str, "?#", f02, str.length());
        ArrayList arrayList = new ArrayList();
        while (f02 < delimiterOffset) {
            int i11 = f02 + 1;
            int delimiterOffset2 = Util.delimiterOffset(this.url, '/', i11, delimiterOffset);
            arrayList.add(this.url.substring(i11, delimiterOffset2));
            f02 = delimiterOffset2;
        }
        return arrayList;
    }

    public final String encodedQuery() {
        if (this.queryNamesAndValues == null) {
            return null;
        }
        int f02 = StringsKt__StringsKt.f0(this.url, '?', 0, false, 6, (Object) null) + 1;
        String str = this.url;
        return this.url.substring(f02, Util.delimiterOffset(str, (char) n0.h.f32179b, f02, str.length()));
    }

    public final String encodedUsername() {
        if (this.username.length() == 0) {
            return "";
        }
        int length = this.scheme.length() + 3;
        String str = this.url;
        return this.url.substring(length, Util.delimiterOffset(str, ":@", length, str.length()));
    }

    public boolean equals(Object obj) {
        return (obj instanceof HttpUrl) && x.b(((HttpUrl) obj).url, this.url);
    }

    public final String fragment() {
        return this.fragment;
    }

    public int hashCode() {
        return this.url.hashCode();
    }

    public final String host() {
        return this.host;
    }

    public final boolean isHttps() {
        return this.isHttps;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.setScheme$okhttp(this.scheme);
        builder.setEncodedUsername$okhttp(encodedUsername());
        builder.setEncodedPassword$okhttp(encodedPassword());
        builder.setHost$okhttp(this.host);
        builder.setPort$okhttp(this.port != Companion.defaultPort(this.scheme) ? this.port : -1);
        builder.getEncodedPathSegments$okhttp().clear();
        builder.getEncodedPathSegments$okhttp().addAll(encodedPathSegments());
        builder.encodedQuery(encodedQuery());
        builder.setEncodedFragment$okhttp(encodedFragment());
        return builder;
    }

    public final String password() {
        return this.password;
    }

    public final List<String> pathSegments() {
        return this.pathSegments;
    }

    public final int pathSize() {
        return this.pathSegments.size();
    }

    public final int port() {
        return this.port;
    }

    public final String query() {
        if (this.queryNamesAndValues == null) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        Companion.toQueryString$okhttp(this.queryNamesAndValues, sb2);
        return sb2.toString();
    }

    public final String queryParameter(String str) {
        List<String> list = this.queryNamesAndValues;
        if (list == null) {
            return null;
        }
        f n11 = RangesKt___RangesKt.n(RangesKt___RangesKt.o(0, list.size()), 2);
        int a11 = n11.a();
        int b11 = n11.b();
        int c11 = n11.c();
        if ((c11 > 0 && a11 <= b11) || (c11 < 0 && b11 <= a11)) {
            while (!x.b(str, this.queryNamesAndValues.get(a11))) {
                if (a11 != b11) {
                    a11 += c11;
                }
            }
            return this.queryNamesAndValues.get(a11 + 1);
        }
        return null;
    }

    public final String queryParameterName(int i11) {
        List<String> list = this.queryNamesAndValues;
        if (list != null) {
            return list.get(i11 * 2);
        }
        throw new IndexOutOfBoundsException();
    }

    public final Set<String> queryParameterNames() {
        if (this.queryNamesAndValues == null) {
            return SetsKt__SetsKt.d();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        f n11 = RangesKt___RangesKt.n(RangesKt___RangesKt.o(0, this.queryNamesAndValues.size()), 2);
        int a11 = n11.a();
        int b11 = n11.b();
        int c11 = n11.c();
        if ((c11 > 0 && a11 <= b11) || (c11 < 0 && b11 <= a11)) {
            while (true) {
                linkedHashSet.add(this.queryNamesAndValues.get(a11));
                if (a11 == b11) {
                    break;
                }
                a11 += c11;
            }
        }
        return Collections.unmodifiableSet(linkedHashSet);
    }

    public final String queryParameterValue(int i11) {
        List<String> list = this.queryNamesAndValues;
        if (list != null) {
            return list.get((i11 * 2) + 1);
        }
        throw new IndexOutOfBoundsException();
    }

    public final List<String> queryParameterValues(String str) {
        if (this.queryNamesAndValues == null) {
            return CollectionsKt__CollectionsKt.k();
        }
        ArrayList arrayList = new ArrayList();
        f n11 = RangesKt___RangesKt.n(RangesKt___RangesKt.o(0, this.queryNamesAndValues.size()), 2);
        int a11 = n11.a();
        int b11 = n11.b();
        int c11 = n11.c();
        if ((c11 > 0 && a11 <= b11) || (c11 < 0 && b11 <= a11)) {
            while (true) {
                if (x.b(str, this.queryNamesAndValues.get(a11))) {
                    arrayList.add(this.queryNamesAndValues.get(a11 + 1));
                }
                if (a11 == b11) {
                    break;
                }
                a11 += c11;
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public final int querySize() {
        List<String> list = this.queryNamesAndValues;
        if (list != null) {
            return list.size() / 2;
        }
        return 0;
    }

    public final String redact() {
        return newBuilder("/...").username("").password("").build().toString();
    }

    public final HttpUrl resolve(String str) {
        Builder newBuilder = newBuilder(str);
        if (newBuilder != null) {
            return newBuilder.build();
        }
        return null;
    }

    public final String scheme() {
        return this.scheme;
    }

    public String toString() {
        return this.url;
    }

    public final String topPrivateDomain() {
        if (Util.canParseAsIpAddress(this.host)) {
            return null;
        }
        return PublicSuffixDatabase.Companion.get().getEffectiveTldPlusOne(this.host);
    }

    public final URI uri() {
        String builder = newBuilder().reencodeForUri$okhttp().toString();
        try {
            return new URI(builder);
        } catch (URISyntaxException e11) {
            try {
                return URI.create(new Regex("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]").replace((CharSequence) builder, ""));
            } catch (Exception unused) {
                throw new RuntimeException(e11);
            }
        }
    }

    public final URL url() {
        try {
            return new URL(this.url);
        } catch (MalformedURLException e11) {
            throw new RuntimeException(e11);
        }
    }

    public final String username() {
        return this.username;
    }

    public final Builder newBuilder(String str) {
        try {
            return new Builder().parse$okhttp(this, str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }
}
