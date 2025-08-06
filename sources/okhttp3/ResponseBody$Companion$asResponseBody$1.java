package okhttp3;

import okio.BufferedSource;

public final class ResponseBody$Companion$asResponseBody$1 extends ResponseBody {
    public final /* synthetic */ long $contentLength;
    public final /* synthetic */ MediaType $contentType;
    public final /* synthetic */ BufferedSource $this_asResponseBody;

    public ResponseBody$Companion$asResponseBody$1(MediaType mediaType, long j11, BufferedSource bufferedSource) {
        this.$contentType = mediaType;
        this.$contentLength = j11;
        this.$this_asResponseBody = bufferedSource;
    }

    public long contentLength() {
        return this.$contentLength;
    }

    public MediaType contentType() {
        return this.$contentType;
    }

    public BufferedSource source() {
        return this.$this_asResponseBody;
    }
}
