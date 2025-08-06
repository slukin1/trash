package com.google.firebase.encoders.json;

import com.google.firebase.encoders.ValueEncoder;
import com.google.firebase.encoders.ValueEncoderContext;

public final /* synthetic */ class c implements ValueEncoder {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ c f67087a = new c();

    public final void encode(Object obj, Object obj2) {
        ((ValueEncoderContext) obj2).add((String) obj);
    }
}
