package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import com.google.android.exoplayer2.util.Assertions;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class DataSpec {
    public static final int FLAG_ALLOW_CACHE_FRAGMENTATION = 4;
    public static final int FLAG_ALLOW_GZIP = 1;
    public static final int FLAG_DONT_CACHE_IF_LENGTH_UNKNOWN = 2;
    public static final int FLAG_MIGHT_NOT_USE_FULL_NETWORK_SPEED = 8;
    public static final int HTTP_METHOD_GET = 1;
    public static final int HTTP_METHOD_HEAD = 3;
    public static final int HTTP_METHOD_POST = 2;
    @Deprecated
    public final long absoluteStreamPosition;
    public final Object customData;
    public final int flags;
    public final byte[] httpBody;
    public final int httpMethod;
    public final Map<String, String> httpRequestHeaders;
    public final String key;
    public final long length;
    public final long position;
    public final Uri uri;
    public final long uriPositionOffset;

    public static final class Builder {
        private Object customData;
        private int flags;
        private byte[] httpBody;
        private int httpMethod;
        private Map<String, String> httpRequestHeaders;
        private String key;
        private long length;
        private long position;
        private Uri uri;
        private long uriPositionOffset;

        public DataSpec build() {
            Assertions.checkStateNotNull(this.uri, "The uri must be set.");
            return new DataSpec(this.uri, this.uriPositionOffset, this.httpMethod, this.httpBody, this.httpRequestHeaders, this.position, this.length, this.key, this.flags, this.customData);
        }

        public Builder setCustomData(Object obj) {
            this.customData = obj;
            return this;
        }

        public Builder setFlags(int i11) {
            this.flags = i11;
            return this;
        }

        public Builder setHttpBody(byte[] bArr) {
            this.httpBody = bArr;
            return this;
        }

        public Builder setHttpMethod(int i11) {
            this.httpMethod = i11;
            return this;
        }

        public Builder setHttpRequestHeaders(Map<String, String> map) {
            this.httpRequestHeaders = map;
            return this;
        }

        public Builder setKey(String str) {
            this.key = str;
            return this;
        }

        public Builder setLength(long j11) {
            this.length = j11;
            return this;
        }

        public Builder setPosition(long j11) {
            this.position = j11;
            return this;
        }

        public Builder setUri(String str) {
            this.uri = Uri.parse(str);
            return this;
        }

        public Builder setUriPositionOffset(long j11) {
            this.uriPositionOffset = j11;
            return this;
        }

        public Builder() {
            this.httpMethod = 1;
            this.httpRequestHeaders = Collections.emptyMap();
            this.length = -1;
        }

        public Builder setUri(Uri uri2) {
            this.uri = uri2;
            return this;
        }

        private Builder(DataSpec dataSpec) {
            this.uri = dataSpec.uri;
            this.uriPositionOffset = dataSpec.uriPositionOffset;
            this.httpMethod = dataSpec.httpMethod;
            this.httpBody = dataSpec.httpBody;
            this.httpRequestHeaders = dataSpec.httpRequestHeaders;
            this.position = dataSpec.position;
            this.length = dataSpec.length;
            this.key = dataSpec.key;
            this.flags = dataSpec.flags;
            this.customData = dataSpec.customData;
        }
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface HttpMethod {
    }

    public static String getStringForHttpMethod(int i11) {
        if (i11 == 1) {
            return "GET";
        }
        if (i11 == 2) {
            return "POST";
        }
        if (i11 == 3) {
            return "HEAD";
        }
        throw new IllegalStateException();
    }

    public Builder buildUpon() {
        return new Builder();
    }

    public final String getHttpMethodString() {
        return getStringForHttpMethod(this.httpMethod);
    }

    public boolean isFlagSet(int i11) {
        return (this.flags & i11) == i11;
    }

    public DataSpec subrange(long j11) {
        long j12 = this.length;
        long j13 = -1;
        if (j12 != -1) {
            j13 = j12 - j11;
        }
        return subrange(j11, j13);
    }

    public String toString() {
        String httpMethodString = getHttpMethodString();
        String valueOf = String.valueOf(this.uri);
        long j11 = this.position;
        long j12 = this.length;
        String str = this.key;
        int i11 = this.flags;
        StringBuilder sb2 = new StringBuilder(String.valueOf(httpMethodString).length() + 70 + valueOf.length() + String.valueOf(str).length());
        sb2.append("DataSpec[");
        sb2.append(httpMethodString);
        sb2.append(" ");
        sb2.append(valueOf);
        sb2.append(", ");
        sb2.append(j11);
        sb2.append(", ");
        sb2.append(j12);
        sb2.append(", ");
        sb2.append(str);
        sb2.append(", ");
        sb2.append(i11);
        sb2.append("]");
        return sb2.toString();
    }

    public DataSpec withAdditionalHeaders(Map<String, String> map) {
        HashMap hashMap = new HashMap(this.httpRequestHeaders);
        hashMap.putAll(map);
        return new DataSpec(this.uri, this.uriPositionOffset, this.httpMethod, this.httpBody, hashMap, this.position, this.length, this.key, this.flags, this.customData);
    }

    public DataSpec withRequestHeaders(Map<String, String> map) {
        return new DataSpec(this.uri, this.uriPositionOffset, this.httpMethod, this.httpBody, map, this.position, this.length, this.key, this.flags, this.customData);
    }

    public DataSpec withUri(Uri uri2) {
        return new DataSpec(uri2, this.uriPositionOffset, this.httpMethod, this.httpBody, this.httpRequestHeaders, this.position, this.length, this.key, this.flags, this.customData);
    }

    public DataSpec(Uri uri2) {
        this(uri2, 0, -1);
    }

    public DataSpec subrange(long j11, long j12) {
        if (j11 == 0 && this.length == j12) {
            return this;
        }
        return new DataSpec(this.uri, this.uriPositionOffset, this.httpMethod, this.httpBody, this.httpRequestHeaders, this.position + j11, j12, this.key, this.flags, this.customData);
    }

    public DataSpec(Uri uri2, long j11, long j12) {
        this(uri2, 0, 1, (byte[]) null, Collections.emptyMap(), j11, j12, (String) null, 0, (Object) null);
    }

    @Deprecated
    public DataSpec(Uri uri2, int i11) {
        this(uri2, 0, -1, (String) null, i11);
    }

    @Deprecated
    public DataSpec(Uri uri2, long j11, long j12, String str) {
        this(uri2, j11, j11, j12, str, 0);
    }

    @Deprecated
    public DataSpec(Uri uri2, long j11, long j12, String str, int i11) {
        this(uri2, j11, j11, j12, str, i11);
    }

    @Deprecated
    public DataSpec(Uri uri2, long j11, long j12, String str, int i11, Map<String, String> map) {
        this(uri2, 1, (byte[]) null, j11, j11, j12, str, i11, map);
    }

    @Deprecated
    public DataSpec(Uri uri2, long j11, long j12, long j13, String str, int i11) {
        this(uri2, (byte[]) null, j11, j12, j13, str, i11);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @Deprecated
    public DataSpec(Uri uri2, byte[] bArr, long j11, long j12, long j13, String str, int i11) {
        this(uri2, bArr != null ? 2 : 1, bArr, j11, j12, j13, str, i11);
    }

    @Deprecated
    public DataSpec(Uri uri2, int i11, byte[] bArr, long j11, long j12, long j13, String str, int i12) {
        this(uri2, i11, bArr, j11, j12, j13, str, i12, Collections.emptyMap());
    }

    @Deprecated
    public DataSpec(Uri uri2, int i11, byte[] bArr, long j11, long j12, long j13, String str, int i12, Map<String, String> map) {
        this(uri2, j11 - j12, i11, bArr, map, j12, j13, str, i12, (Object) null);
    }

    private DataSpec(Uri uri2, long j11, int i11, byte[] bArr, Map<String, String> map, long j12, long j13, String str, int i12, Object obj) {
        long j14 = j11;
        byte[] bArr2 = bArr;
        long j15 = j12;
        long j16 = j13;
        long j17 = j14 + j15;
        boolean z11 = true;
        Assertions.checkArgument(j17 >= 0);
        Assertions.checkArgument(j15 >= 0);
        if (j16 <= 0 && j16 != -1) {
            z11 = false;
        }
        Assertions.checkArgument(z11);
        this.uri = uri2;
        this.uriPositionOffset = j14;
        this.httpMethod = i11;
        this.httpBody = (bArr2 == null || bArr2.length == 0) ? null : bArr2;
        this.httpRequestHeaders = Collections.unmodifiableMap(new HashMap(map));
        this.position = j15;
        this.absoluteStreamPosition = j17;
        this.length = j16;
        this.key = str;
        this.flags = i12;
        this.customData = obj;
    }
}
