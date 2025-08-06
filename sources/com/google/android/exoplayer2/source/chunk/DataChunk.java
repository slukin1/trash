package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.Arrays;

public abstract class DataChunk extends Chunk {
    private static final int READ_GRANULARITY = 16384;
    private byte[] data;
    private volatile boolean loadCanceled;

    public DataChunk(DataSource dataSource, DataSpec dataSpec, int i11, Format format, int i12, Object obj, byte[] bArr) {
        super(dataSource, dataSpec, i11, format, i12, obj, -9223372036854775807L, -9223372036854775807L);
        DataChunk dataChunk;
        byte[] bArr2;
        if (bArr == null) {
            bArr2 = Util.EMPTY_BYTE_ARRAY;
            dataChunk = this;
        } else {
            dataChunk = this;
            bArr2 = bArr;
        }
        dataChunk.data = bArr2;
    }

    private void maybeExpandData(int i11) {
        byte[] bArr = this.data;
        if (bArr.length < i11 + 16384) {
            this.data = Arrays.copyOf(bArr, bArr.length + 16384);
        }
    }

    public final void cancelLoad() {
        this.loadCanceled = true;
    }

    public abstract void consume(byte[] bArr, int i11) throws IOException;

    public byte[] getDataHolder() {
        return this.data;
    }

    public final void load() throws IOException {
        try {
            this.dataSource.open(this.dataSpec);
            int i11 = 0;
            int i12 = 0;
            while (i11 != -1 && !this.loadCanceled) {
                maybeExpandData(i12);
                i11 = this.dataSource.read(this.data, i12, 16384);
                if (i11 != -1) {
                    i12 += i11;
                }
            }
            if (!this.loadCanceled) {
                consume(this.data, i12);
            }
        } finally {
            Util.closeQuietly((DataSource) this.dataSource);
        }
    }
}
