package org.tensorflow.lite;

import java.io.File;
import java.nio.ByteBuffer;
import org.tensorflow.lite.InterpreterApi;

public final /* synthetic */ class b {
    public static InterpreterApi a(File file, InterpreterApi.Options options) {
        return TensorFlowLite.getFactory(options == null ? null : options.getRuntime()).create(file, options);
    }

    public static InterpreterApi b(ByteBuffer byteBuffer, InterpreterApi.Options options) {
        return TensorFlowLite.getFactory(options == null ? null : options.getRuntime()).create(byteBuffer, options);
    }
}
