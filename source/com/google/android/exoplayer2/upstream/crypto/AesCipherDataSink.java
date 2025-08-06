package com.google.android.exoplayer2.upstream.crypto;

import com.google.android.exoplayer2.upstream.DataSink;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;

public final class AesCipherDataSink implements DataSink {
    private AesFlushingCipher cipher;
    private final byte[] scratch;
    private final byte[] secretKey;
    private final DataSink wrappedDataSink;

    public AesCipherDataSink(byte[] bArr, DataSink dataSink) {
        this(bArr, dataSink, (byte[]) null);
    }

    public void close() throws IOException {
        this.cipher = null;
        this.wrappedDataSink.close();
    }

    public void open(DataSpec dataSpec) throws IOException {
        this.wrappedDataSink.open(dataSpec);
        long fNV64Hash = CryptoUtil.getFNV64Hash(dataSpec.key);
        this.cipher = new AesFlushingCipher(1, this.secretKey, fNV64Hash, dataSpec.position + dataSpec.uriPositionOffset);
    }

    public void write(byte[] bArr, int i11, int i12) throws IOException {
        if (this.scratch == null) {
            ((AesFlushingCipher) Util.castNonNull(this.cipher)).updateInPlace(bArr, i11, i12);
            this.wrappedDataSink.write(bArr, i11, i12);
            return;
        }
        int i13 = 0;
        while (i13 < i12) {
            int min = Math.min(i12 - i13, this.scratch.length);
            ((AesFlushingCipher) Util.castNonNull(this.cipher)).update(bArr, i11 + i13, min, this.scratch, 0);
            this.wrappedDataSink.write(this.scratch, 0, min);
            i13 += min;
        }
    }

    public AesCipherDataSink(byte[] bArr, DataSink dataSink, byte[] bArr2) {
        this.wrappedDataSink = dataSink;
        this.secretKey = bArr;
        this.scratch = bArr2;
    }
}
