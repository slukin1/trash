package okhttp3;

import java.io.File;

public final class RequestBody$Companion$asRequestBody$1 extends RequestBody {
    public final /* synthetic */ MediaType $contentType;
    public final /* synthetic */ File $this_asRequestBody;

    public RequestBody$Companion$asRequestBody$1(MediaType mediaType, File file) {
        this.$contentType = mediaType;
        this.$this_asRequestBody = file;
    }

    public long contentLength() {
        return this.$this_asRequestBody.length();
    }

    public MediaType contentType() {
        return this.$contentType;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0014, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0010, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0011, code lost:
        kotlin.io.b.a(r0, r3);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void writeTo(okio.BufferedSink r3) {
        /*
            r2 = this;
            java.io.File r0 = r2.$this_asRequestBody
            okio.Source r0 = okio.Okio.source((java.io.File) r0)
            r3.writeAll(r0)     // Catch:{ all -> 0x000e }
            r3 = 0
            kotlin.io.b.a(r0, r3)
            return
        L_0x000e:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x0010 }
        L_0x0010:
            r1 = move-exception
            kotlin.io.b.a(r0, r3)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.RequestBody$Companion$asRequestBody$1.writeTo(okio.BufferedSink):void");
    }
}
