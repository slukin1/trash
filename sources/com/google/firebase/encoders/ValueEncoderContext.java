package com.google.firebase.encoders;

import java.io.IOException;

public interface ValueEncoderContext {
    ValueEncoderContext add(double d11) throws IOException;

    ValueEncoderContext add(float f11) throws IOException;

    ValueEncoderContext add(int i11) throws IOException;

    ValueEncoderContext add(long j11) throws IOException;

    ValueEncoderContext add(String str) throws IOException;

    ValueEncoderContext add(boolean z11) throws IOException;

    ValueEncoderContext add(byte[] bArr) throws IOException;
}
