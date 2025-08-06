package com.google.android.exoplayer2.source;

import android.net.Uri;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.IOException;
import java.util.List;
import java.util.Map;

final class IcyDataSource implements DataSource {
    private int bytesUntilMetadata;
    private final Listener listener;
    private final int metadataIntervalBytes;
    private final byte[] metadataLengthByteHolder;
    private final DataSource upstream;

    public interface Listener {
        void onIcyMetadata(ParsableByteArray parsableByteArray);
    }

    public IcyDataSource(DataSource dataSource, int i11, Listener listener2) {
        Assertions.checkArgument(i11 > 0);
        this.upstream = dataSource;
        this.metadataIntervalBytes = i11;
        this.listener = listener2;
        this.metadataLengthByteHolder = new byte[1];
        this.bytesUntilMetadata = i11;
    }

    private boolean readMetadata() throws IOException {
        if (this.upstream.read(this.metadataLengthByteHolder, 0, 1) == -1) {
            return false;
        }
        int i11 = (this.metadataLengthByteHolder[0] & 255) << 4;
        if (i11 == 0) {
            return true;
        }
        byte[] bArr = new byte[i11];
        int i12 = i11;
        int i13 = 0;
        while (i12 > 0) {
            int read = this.upstream.read(bArr, i13, i12);
            if (read == -1) {
                return false;
            }
            i13 += read;
            i12 -= read;
        }
        while (i11 > 0 && bArr[i11 - 1] == 0) {
            i11--;
        }
        if (i11 > 0) {
            this.listener.onIcyMetadata(new ParsableByteArray(bArr, i11));
        }
        return true;
    }

    public void addTransferListener(TransferListener transferListener) {
        Assertions.checkNotNull(transferListener);
        this.upstream.addTransferListener(transferListener);
    }

    public void close() {
        throw new UnsupportedOperationException();
    }

    public Map<String, List<String>> getResponseHeaders() {
        return this.upstream.getResponseHeaders();
    }

    public Uri getUri() {
        return this.upstream.getUri();
    }

    public long open(DataSpec dataSpec) {
        throw new UnsupportedOperationException();
    }

    public int read(byte[] bArr, int i11, int i12) throws IOException {
        if (this.bytesUntilMetadata == 0) {
            if (!readMetadata()) {
                return -1;
            }
            this.bytesUntilMetadata = this.metadataIntervalBytes;
        }
        int read = this.upstream.read(bArr, i11, Math.min(this.bytesUntilMetadata, i12));
        if (read != -1) {
            this.bytesUntilMetadata -= read;
        }
        return read;
    }
}
