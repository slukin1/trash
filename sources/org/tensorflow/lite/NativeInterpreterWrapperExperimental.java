package org.tensorflow.lite;

import java.nio.ByteBuffer;
import org.tensorflow.lite.InterpreterImpl;

final class NativeInterpreterWrapperExperimental extends NativeInterpreterWrapper {
    public NativeInterpreterWrapperExperimental(String str, InterpreterImpl.Options options) {
        super(str, options);
    }

    private static native void resetVariableTensors(long j11, long j12);

    public void resetVariableTensors() {
        resetVariableTensors(this.interpreterHandle, this.errorHandle);
    }

    public NativeInterpreterWrapperExperimental(ByteBuffer byteBuffer, InterpreterImpl.Options options) {
        super(byteBuffer, options);
    }
}
