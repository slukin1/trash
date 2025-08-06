package com.amazonaws.internal;

import java.io.IOException;
import java.io.InputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;

public class SdkDigestInputStream extends DigestInputStream implements MetricAware {
    static {
        Class<SdkDigestInputStream> cls = SdkDigestInputStream.class;
    }

    public SdkDigestInputStream(InputStream inputStream, MessageDigest messageDigest) {
        super(inputStream, messageDigest);
    }

    @Deprecated
    public final boolean a() {
        if (this.in instanceof MetricAware) {
            return ((MetricAware) this.in).a();
        }
        return false;
    }

    public final long skip(long j11) throws IOException {
        if (j11 <= 0) {
            return j11;
        }
        int min = (int) Math.min(2048, j11);
        byte[] bArr = new byte[min];
        long j12 = j11;
        while (j12 > 0) {
            int read = read(bArr, 0, (int) Math.min(j12, (long) min));
            if (read != -1) {
                j12 -= (long) read;
            } else if (j12 == j11) {
                return -1;
            } else {
                return j11 - j12;
            }
        }
        return j11;
    }
}
