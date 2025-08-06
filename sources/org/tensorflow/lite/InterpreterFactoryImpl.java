package org.tensorflow.lite;

import java.io.File;
import java.nio.ByteBuffer;
import org.tensorflow.lite.InterpreterApi;
import org.tensorflow.lite.InterpreterImpl;
import org.tensorflow.lite.annotations.UsedByReflection;
import org.tensorflow.lite.nnapi.NnApiDelegate;
import org.tensorflow.lite.nnapi.NnApiDelegateImpl;

@UsedByReflection("InterpreterFactory.java")
class InterpreterFactoryImpl implements InterpreterFactoryApi {
    private static native String nativeRuntimeVersion();

    private static native String nativeSchemaVersion();

    public InterpreterApi create(File file, InterpreterApi.Options options) {
        InterpreterImpl.Options options2;
        if (options == null) {
            options2 = null;
        } else {
            options2 = new InterpreterImpl.Options(options);
        }
        return new InterpreterImpl(file, options2);
    }

    public NnApiDelegate.PrivateInterface createNnApiDelegateImpl(NnApiDelegate.Options options) {
        return new NnApiDelegateImpl(options);
    }

    public String runtimeVersion() {
        TensorFlowLite.init();
        return nativeRuntimeVersion();
    }

    public String schemaVersion() {
        TensorFlowLite.init();
        return nativeSchemaVersion();
    }

    public InterpreterApi create(ByteBuffer byteBuffer, InterpreterApi.Options options) {
        InterpreterImpl.Options options2;
        if (options == null) {
            options2 = null;
        } else {
            options2 = new InterpreterImpl.Options(options);
        }
        return new InterpreterImpl(byteBuffer, options2);
    }
}
