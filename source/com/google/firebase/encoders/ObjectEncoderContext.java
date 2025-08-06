package com.google.firebase.encoders;

import java.io.IOException;

public interface ObjectEncoderContext {
    ObjectEncoderContext add(FieldDescriptor fieldDescriptor, double d11) throws IOException;

    ObjectEncoderContext add(FieldDescriptor fieldDescriptor, float f11) throws IOException;

    ObjectEncoderContext add(FieldDescriptor fieldDescriptor, int i11) throws IOException;

    ObjectEncoderContext add(FieldDescriptor fieldDescriptor, long j11) throws IOException;

    ObjectEncoderContext add(FieldDescriptor fieldDescriptor, Object obj) throws IOException;

    ObjectEncoderContext add(FieldDescriptor fieldDescriptor, boolean z11) throws IOException;

    @Deprecated
    ObjectEncoderContext add(String str, double d11) throws IOException;

    @Deprecated
    ObjectEncoderContext add(String str, int i11) throws IOException;

    @Deprecated
    ObjectEncoderContext add(String str, long j11) throws IOException;

    @Deprecated
    ObjectEncoderContext add(String str, Object obj) throws IOException;

    @Deprecated
    ObjectEncoderContext add(String str, boolean z11) throws IOException;

    ObjectEncoderContext inline(Object obj) throws IOException;

    ObjectEncoderContext nested(FieldDescriptor fieldDescriptor) throws IOException;

    ObjectEncoderContext nested(String str) throws IOException;
}
