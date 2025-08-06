package okhttp3;

import okio.BufferedSink;
import okio.ByteString;

public final class RequestBody$Companion$toRequestBody$1 extends RequestBody {
    public final /* synthetic */ MediaType $contentType;
    public final /* synthetic */ ByteString $this_toRequestBody;

    public RequestBody$Companion$toRequestBody$1(MediaType mediaType, ByteString byteString) {
        this.$contentType = mediaType;
        this.$this_toRequestBody = byteString;
    }

    public long contentLength() {
        return (long) this.$this_toRequestBody.size();
    }

    public MediaType contentType() {
        return this.$contentType;
    }

    public void writeTo(BufferedSink bufferedSink) {
        bufferedSink.write(this.$this_toRequestBody);
    }
}
