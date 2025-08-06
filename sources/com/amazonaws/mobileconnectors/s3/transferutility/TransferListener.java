package com.amazonaws.mobileconnectors.s3.transferutility;

public interface TransferListener {
    void a(int i11, long j11, long j12);

    void b(int i11, Exception exc);

    void c(int i11, TransferState transferState);
}
