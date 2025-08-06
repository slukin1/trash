package com.google.android.exoplayer2.extractor;

import java.io.IOException;

final class ExtractorUtil {
    private ExtractorUtil() {
    }

    public static int peekToLength(ExtractorInput extractorInput, byte[] bArr, int i11, int i12) throws IOException {
        int i13 = 0;
        while (i13 < i12) {
            int peek = extractorInput.peek(bArr, i11 + i13, i12 - i13);
            if (peek == -1) {
                break;
            }
            i13 += peek;
        }
        return i13;
    }
}
