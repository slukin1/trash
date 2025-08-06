package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public final class TeeDataSource implements DataSource {
    private long bytesRemaining;
    private final DataSink dataSink;
    private boolean dataSinkNeedsClosing;
    private final DataSource upstream;

    public TeeDataSource(DataSource dataSource, DataSink dataSink2) {
        this.upstream = (DataSource) Assertions.checkNotNull(dataSource);
        this.dataSink = (DataSink) Assertions.checkNotNull(dataSink2);
    }

    public void addTransferListener(TransferListener transferListener) {
        Assertions.checkNotNull(transferListener);
        this.upstream.addTransferListener(transferListener);
    }

    public void close() throws IOException {
        try {
            this.upstream.close();
        } finally {
            if (this.dataSinkNeedsClosing) {
                this.dataSinkNeedsClosing = false;
                this.dataSink.close();
            }
        }
    }

    public Map<String, List<String>> getResponseHeaders() {
        return this.upstream.getResponseHeaders();
    }

    public Uri getUri() {
        return this.upstream.getUri();
    }

    public long open(DataSpec dataSpec) throws IOException {
        long open = this.upstream.open(dataSpec);
        this.bytesRemaining = open;
        if (open == 0) {
            return 0;
        }
        if (dataSpec.length == -1 && open != -1) {
            dataSpec = dataSpec.subrange(0, open);
        }
        this.dataSinkNeedsClosing = true;
        this.dataSink.open(dataSpec);
        return this.bytesRemaining;
    }

    public int read(byte[] bArr, int i11, int i12) throws IOException {
        if (this.bytesRemaining == 0) {
            return -1;
        }
        int read = this.upstream.read(bArr, i11, i12);
        if (read > 0) {
            this.dataSink.write(bArr, i11, read);
            long j11 = this.bytesRemaining;
            if (j11 != -1) {
                this.bytesRemaining = j11 - ((long) read);
            }
        }
        return read;
    }
}
