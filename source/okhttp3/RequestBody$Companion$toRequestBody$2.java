package okhttp3;

import okio.BufferedSink;

public final class RequestBody$Companion$toRequestBody$2 extends RequestBody {
    public final /* synthetic */ int $byteCount;
    public final /* synthetic */ MediaType $contentType;
    public final /* synthetic */ int $offset;
    public final /* synthetic */ byte[] $this_toRequestBody;

    public RequestBody$Companion$toRequestBody$2(MediaType mediaType, int i11, byte[] bArr, int i12) {
        this.$contentType = mediaType;
        this.$byteCount = i11;
        this.$this_toRequestBody = bArr;
        this.$offset = i12;
    }

    public long contentLength() {
        return (long) this.$byteCount;
    }

    public MediaType contentType() {
        return this.$contentType;
    }

    public void writeTo(BufferedSink bufferedSink) {
        bufferedSink.write(this.$this_toRequestBody, this.$offset, this.$byteCount);
    }
}
