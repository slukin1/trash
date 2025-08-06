package okhttp3.internal.cache;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Source;
import okio.Timeout;

public final class CacheInterceptor$cacheWritingResponse$cacheWritingSource$1 implements Source {
    public final /* synthetic */ BufferedSink $cacheBody;
    public final /* synthetic */ CacheRequest $cacheRequest;
    public final /* synthetic */ BufferedSource $source;
    private boolean cacheRequestClosed;

    public CacheInterceptor$cacheWritingResponse$cacheWritingSource$1(BufferedSource bufferedSource, CacheRequest cacheRequest, BufferedSink bufferedSink) {
        this.$source = bufferedSource;
        this.$cacheRequest = cacheRequest;
        this.$cacheBody = bufferedSink;
    }

    public void close() throws IOException {
        if (!this.cacheRequestClosed && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
            this.cacheRequestClosed = true;
            this.$cacheRequest.abort();
        }
        this.$source.close();
    }

    public long read(Buffer buffer, long j11) throws IOException {
        try {
            long read = this.$source.read(buffer, j11);
            if (read == -1) {
                if (!this.cacheRequestClosed) {
                    this.cacheRequestClosed = true;
                    this.$cacheBody.close();
                }
                return -1;
            }
            buffer.copyTo(this.$cacheBody.getBuffer(), buffer.size() - read, read);
            this.$cacheBody.emitCompleteSegments();
            return read;
        } catch (IOException e11) {
            if (!this.cacheRequestClosed) {
                this.cacheRequestClosed = true;
                this.$cacheRequest.abort();
            }
            throw e11;
        }
    }

    public Timeout timeout() {
        return this.$source.timeout();
    }
}
