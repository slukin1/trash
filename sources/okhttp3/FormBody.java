package okhttp3;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.r;
import okhttp3.HttpUrl;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSink;

public final class FormBody extends RequestBody {
    private static final MediaType CONTENT_TYPE = MediaType.Companion.get("application/x-www-form-urlencoded");
    public static final Companion Companion = new Companion((r) null);
    private final List<String> encodedNames;
    private final List<String> encodedValues;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }
    }

    public FormBody(List<String> list, List<String> list2) {
        this.encodedNames = Util.toImmutableList(list);
        this.encodedValues = Util.toImmutableList(list2);
    }

    private final long writeOrCountBytes(BufferedSink bufferedSink, boolean z11) {
        Buffer buffer = z11 ? new Buffer() : bufferedSink.getBuffer();
        int size = this.encodedNames.size();
        for (int i11 = 0; i11 < size; i11++) {
            if (i11 > 0) {
                buffer.writeByte(38);
            }
            buffer.writeUtf8(this.encodedNames.get(i11));
            buffer.writeByte(61);
            buffer.writeUtf8(this.encodedValues.get(i11));
        }
        if (!z11) {
            return 0;
        }
        long size2 = buffer.size();
        buffer.clear();
        return size2;
    }

    /* renamed from: -deprecated_size  reason: not valid java name */
    public final int m3125deprecated_size() {
        return size();
    }

    public long contentLength() {
        return writeOrCountBytes((BufferedSink) null, true);
    }

    public MediaType contentType() {
        return CONTENT_TYPE;
    }

    public final String encodedName(int i11) {
        return this.encodedNames.get(i11);
    }

    public final String encodedValue(int i11) {
        return this.encodedValues.get(i11);
    }

    public final String name(int i11) {
        return HttpUrl.Companion.percentDecode$okhttp$default(HttpUrl.Companion, encodedName(i11), 0, 0, true, 3, (Object) null);
    }

    public final int size() {
        return this.encodedNames.size();
    }

    public final String value(int i11) {
        return HttpUrl.Companion.percentDecode$okhttp$default(HttpUrl.Companion, encodedValue(i11), 0, 0, true, 3, (Object) null);
    }

    public void writeTo(BufferedSink bufferedSink) throws IOException {
        writeOrCountBytes(bufferedSink, false);
    }

    public static final class Builder {
        private final Charset charset;
        private final List<String> names;
        private final List<String> values;

        public Builder() {
            this((Charset) null, 1, (r) null);
        }

        public Builder(Charset charset2) {
            this.charset = charset2;
            this.names = new ArrayList();
            this.values = new ArrayList();
        }

        public final Builder add(String str, String str2) {
            List<String> list = this.names;
            HttpUrl.Companion companion = HttpUrl.Companion;
            list.add(HttpUrl.Companion.canonicalize$okhttp$default(companion, str, 0, 0, HttpUrl.FORM_ENCODE_SET, false, false, true, false, this.charset, 91, (Object) null));
            this.values.add(HttpUrl.Companion.canonicalize$okhttp$default(companion, str2, 0, 0, HttpUrl.FORM_ENCODE_SET, false, false, true, false, this.charset, 91, (Object) null));
            return this;
        }

        public final Builder addEncoded(String str, String str2) {
            List<String> list = this.names;
            HttpUrl.Companion companion = HttpUrl.Companion;
            list.add(HttpUrl.Companion.canonicalize$okhttp$default(companion, str, 0, 0, HttpUrl.FORM_ENCODE_SET, true, false, true, false, this.charset, 83, (Object) null));
            this.values.add(HttpUrl.Companion.canonicalize$okhttp$default(companion, str2, 0, 0, HttpUrl.FORM_ENCODE_SET, true, false, true, false, this.charset, 83, (Object) null));
            return this;
        }

        public final FormBody build() {
            return new FormBody(this.names, this.values);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Builder(Charset charset2, int i11, r rVar) {
            this((i11 & 1) != 0 ? null : charset2);
        }
    }
}
