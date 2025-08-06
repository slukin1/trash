package org.bouncycastle.crypto;

public interface SkippingCipher {
    long getPosition();

    long seekTo(long j11);

    long skip(long j11);
}
