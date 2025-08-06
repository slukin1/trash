package com.sumsub.sns.internal.core.common;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class r0 {
    public static final boolean a(InputStream inputStream, OutputStream outputStream) {
        try {
            byte[] bArr = new byte[RangesKt___RangesKt.g(inputStream.available(), 1048576)];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    outputStream.write(bArr, 0, read);
                } else {
                    inputStream.close();
                    outputStream.close();
                    return true;
                }
            }
        } catch (IOException unused) {
            return false;
        }
    }
}
