package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;

public final class ByteArrayDataSource extends BaseDataSource {
    private int bytesRemaining;
    private final byte[] data;
    private boolean opened;
    private int readPosition;
    private Uri uri;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ByteArrayDataSource(byte[] bArr) {
        super(false);
        boolean z11 = false;
        Assertions.checkNotNull(bArr);
        Assertions.checkArgument(bArr.length > 0 ? true : z11);
        this.data = bArr;
    }

    public void close() {
        if (this.opened) {
            this.opened = false;
            transferEnded();
        }
        this.uri = null;
    }

    public Uri getUri() {
        return this.uri;
    }

    public long open(DataSpec dataSpec) throws IOException {
        this.uri = dataSpec.uri;
        transferInitializing(dataSpec);
        long j11 = dataSpec.position;
        byte[] bArr = this.data;
        if (j11 <= ((long) bArr.length)) {
            this.readPosition = (int) j11;
            int length = bArr.length - ((int) j11);
            this.bytesRemaining = length;
            long j12 = dataSpec.length;
            if (j12 != -1) {
                this.bytesRemaining = (int) Math.min((long) length, j12);
            }
            this.opened = true;
            transferStarted(dataSpec);
            long j13 = dataSpec.length;
            return j13 != -1 ? j13 : (long) this.bytesRemaining;
        }
        throw new DataSourceException(0);
    }

    public int read(byte[] bArr, int i11, int i12) {
        if (i12 == 0) {
            return 0;
        }
        int i13 = this.bytesRemaining;
        if (i13 == 0) {
            return -1;
        }
        int min = Math.min(i12, i13);
        System.arraycopy(this.data, this.readPosition, bArr, i11, min);
        this.readPosition += min;
        this.bytesRemaining -= min;
        bytesTransferred(min);
        return min;
    }
}
