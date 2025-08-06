package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import com.google.android.exoplayer2.upstream.DataSource;
import java.io.IOException;
import java.util.Map;

public final class DummyDataSource implements DataSource {
    public static final DataSource.Factory FACTORY = e.f66081a;
    public static final DummyDataSource INSTANCE = new DummyDataSource();

    private DummyDataSource() {
    }

    public static /* synthetic */ DummyDataSource a() {
        return new DummyDataSource();
    }

    public void addTransferListener(TransferListener transferListener) {
    }

    public void close() {
    }

    public /* synthetic */ Map getResponseHeaders() {
        return c.a(this);
    }

    public Uri getUri() {
        return null;
    }

    public long open(DataSpec dataSpec) throws IOException {
        throw new IOException("DummyDataSource cannot be opened");
    }

    public int read(byte[] bArr, int i11, int i12) {
        throw new UnsupportedOperationException();
    }
}
