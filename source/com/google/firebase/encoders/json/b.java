package com.google.firebase.encoders.json;

import com.google.firebase.encoders.ValueEncoder;
import com.google.firebase.encoders.ValueEncoderContext;

public final /* synthetic */ class b implements ValueEncoder {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ b f67086a = new b();

    public final void encode(Object obj, Object obj2) {
        ((ValueEncoderContext) obj2).add(((Boolean) obj).booleanValue());
    }
}
