package org.tensorflow.lite;

import java.io.File;
import java.nio.ByteBuffer;
import org.tensorflow.lite.InterpreterApi;

@Deprecated
public class InterpreterFactory {
    public InterpreterApi create(File file, InterpreterApi.Options options) {
        return b.a(file, options);
    }

    public InterpreterApi create(ByteBuffer byteBuffer, InterpreterApi.Options options) {
        return b.b(byteBuffer, options);
    }
}
