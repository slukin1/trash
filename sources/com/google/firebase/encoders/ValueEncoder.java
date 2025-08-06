package com.google.firebase.encoders;

import java.io.IOException;

public interface ValueEncoder<T> extends Encoder<T, ValueEncoderContext> {
    /* synthetic */ void encode(Object obj, Object obj2) throws IOException;
}
