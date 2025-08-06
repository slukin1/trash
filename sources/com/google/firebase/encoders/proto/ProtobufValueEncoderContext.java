package com.google.firebase.encoders.proto;

import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ValueEncoderContext;
import java.io.IOException;

class ProtobufValueEncoderContext implements ValueEncoderContext {
    private boolean encoded = false;
    private FieldDescriptor field;
    private final ProtobufDataEncoderContext objEncoderCtx;
    private boolean skipDefault = false;

    public ProtobufValueEncoderContext(ProtobufDataEncoderContext protobufDataEncoderContext) {
        this.objEncoderCtx = protobufDataEncoderContext;
    }

    private void checkNotUsed() {
        if (!this.encoded) {
            this.encoded = true;
            return;
        }
        throw new EncodingException("Cannot encode a second value in the ValueEncoderContext");
    }

    public ValueEncoderContext add(String str) throws IOException {
        checkNotUsed();
        this.objEncoderCtx.add(this.field, (Object) str, this.skipDefault);
        return this;
    }

    public void resetContext(FieldDescriptor fieldDescriptor, boolean z11) {
        this.encoded = false;
        this.field = fieldDescriptor;
        this.skipDefault = z11;
    }

    public ValueEncoderContext add(float f11) throws IOException {
        checkNotUsed();
        this.objEncoderCtx.add(this.field, f11, this.skipDefault);
        return this;
    }

    public ValueEncoderContext add(double d11) throws IOException {
        checkNotUsed();
        this.objEncoderCtx.add(this.field, d11, this.skipDefault);
        return this;
    }

    public ValueEncoderContext add(int i11) throws IOException {
        checkNotUsed();
        this.objEncoderCtx.add(this.field, i11, this.skipDefault);
        return this;
    }

    public ValueEncoderContext add(long j11) throws IOException {
        checkNotUsed();
        this.objEncoderCtx.add(this.field, j11, this.skipDefault);
        return this;
    }

    public ValueEncoderContext add(boolean z11) throws IOException {
        checkNotUsed();
        this.objEncoderCtx.add(this.field, z11, this.skipDefault);
        return this;
    }

    public ValueEncoderContext add(byte[] bArr) throws IOException {
        checkNotUsed();
        this.objEncoderCtx.add(this.field, (Object) bArr, this.skipDefault);
        return this;
    }
}
