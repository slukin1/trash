package com.google.android.exoplayer2.upstream;

public interface TransferListener {
    void onBytesTransferred(DataSource dataSource, DataSpec dataSpec, boolean z11, int i11);

    void onTransferEnd(DataSource dataSource, DataSpec dataSpec, boolean z11);

    void onTransferInitializing(DataSource dataSource, DataSpec dataSpec, boolean z11);

    void onTransferStart(DataSource dataSource, DataSpec dataSpec, boolean z11);
}
