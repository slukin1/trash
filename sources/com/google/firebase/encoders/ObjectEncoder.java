package com.google.firebase.encoders;

import java.io.IOException;

public interface ObjectEncoder<T> extends Encoder<T, ObjectEncoderContext> {
    /* synthetic */ void encode(Object obj, Object obj2) throws IOException;
}
