package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Map;

public abstract class BaseDataSource implements DataSource {
    private DataSpec dataSpec;
    private final boolean isNetwork;
    private int listenerCount;
    private final ArrayList<TransferListener> listeners = new ArrayList<>(1);

    public BaseDataSource(boolean z11) {
        this.isNetwork = z11;
    }

    public final void addTransferListener(TransferListener transferListener) {
        Assertions.checkNotNull(transferListener);
        if (!this.listeners.contains(transferListener)) {
            this.listeners.add(transferListener);
            this.listenerCount++;
        }
    }

    public final void bytesTransferred(int i11) {
        DataSpec dataSpec2 = (DataSpec) Util.castNonNull(this.dataSpec);
        for (int i12 = 0; i12 < this.listenerCount; i12++) {
            this.listeners.get(i12).onBytesTransferred(this, dataSpec2, this.isNetwork, i11);
        }
    }

    public /* synthetic */ Map getResponseHeaders() {
        return c.a(this);
    }

    public final void transferEnded() {
        DataSpec dataSpec2 = (DataSpec) Util.castNonNull(this.dataSpec);
        for (int i11 = 0; i11 < this.listenerCount; i11++) {
            this.listeners.get(i11).onTransferEnd(this, dataSpec2, this.isNetwork);
        }
        this.dataSpec = null;
    }

    public final void transferInitializing(DataSpec dataSpec2) {
        for (int i11 = 0; i11 < this.listenerCount; i11++) {
            this.listeners.get(i11).onTransferInitializing(this, dataSpec2, this.isNetwork);
        }
    }

    public final void transferStarted(DataSpec dataSpec2) {
        this.dataSpec = dataSpec2;
        for (int i11 = 0; i11 < this.listenerCount; i11++) {
            this.listeners.get(i11).onTransferStart(this, dataSpec2, this.isNetwork);
        }
    }
}
