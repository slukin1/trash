package okhttp3;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.jvm.internal.x;

public final class Challenge {
    private final Map<String, String> authParams;
    private final String scheme;

    public Challenge(String str, Map<String, String> map) {
        this.scheme = str;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry next : map.entrySet()) {
            String str2 = (String) next.getKey();
            linkedHashMap.put(str2 != null ? str2.toLowerCase(Locale.US) : null, (String) next.getValue());
        }
        this.authParams = Collections.unmodifiableMap(linkedHashMap);
    }

    /* renamed from: -deprecated_authParams  reason: not valid java name */
    public final Map<String, String> m3107deprecated_authParams() {
        return this.authParams;
    }

    /* renamed from: -deprecated_charset  reason: not valid java name */
    public final Charset m3108deprecated_charset() {
        return charset();
    }

    /* renamed from: -deprecated_realm  reason: not valid java name */
    public final String m3109deprecated_realm() {
        return realm();
    }

    /* renamed from: -deprecated_scheme  reason: not valid java name */
    public final String m3110deprecated_scheme() {
        return this.scheme;
    }

    public final Map<String, String> authParams() {
        return this.authParams;
    }

    public final Charset charset() {
        String str = this.authParams.get("charset");
        if (str != null) {
            try {
                return Charset.forName(str);
            } catch (Exception unused) {
            }
        }
        return StandardCharsets.ISO_8859_1;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Challenge) {
            Challenge challenge = (Challenge) obj;
            return x.b(challenge.scheme, this.scheme) && x.b(challenge.authParams, this.authParams);
        }
    }

    public int hashCode() {
        return ((899 + this.scheme.hashCode()) * 31) + this.authParams.hashCode();
    }

    public final String realm() {
        return this.authParams.get("realm");
    }

    public final String scheme() {
        return this.scheme;
    }

    public String toString() {
        return this.scheme + " authParams=" + this.authParams;
    }

    public final Challenge withCharset(Charset charset) {
        Map y11 = MapsKt__MapsKt.y(this.authParams);
        y11.put("charset", charset.name());
        return new Challenge(this.scheme, (Map<String, String>) y11);
    }

    public Challenge(String str, String str2) {
        this(str, (Map<String, String>) Collections.singletonMap("realm", str2));
    }
}
