package org.tensorflow.lite;

import java.io.File;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import org.tensorflow.lite.InterpreterApi;

class InterpreterImpl implements InterpreterApi {
    public NativeInterpreterWrapper wrapper;

    public static class Options extends InterpreterApi.Options {
        public Boolean allowBufferHandleOutput;
        public Boolean allowFp16PrecisionForFp32;

        public Options() {
        }

        public Options(InterpreterApi.Options options) {
            super(options);
        }

        public Options(Options options) {
            super(options);
            this.allowFp16PrecisionForFp32 = options.allowFp16PrecisionForFp32;
            this.allowBufferHandleOutput = options.allowBufferHandleOutput;
        }
    }

    public InterpreterImpl(File file, Options options) {
        this.wrapper = new NativeInterpreterWrapper(file.getAbsolutePath(), options);
    }

    public void allocateTensors() {
        checkNotClosed();
        this.wrapper.allocateTensors();
    }

    public void checkNotClosed() {
        if (this.wrapper == null) {
            throw new IllegalStateException("Internal error: The Interpreter has already been closed.");
        }
    }

    public void close() {
        NativeInterpreterWrapper nativeInterpreterWrapper = this.wrapper;
        if (nativeInterpreterWrapper != null) {
            nativeInterpreterWrapper.close();
            this.wrapper = null;
        }
    }

    public void finalize() throws Throwable {
        try {
            close();
        } finally {
            super.finalize();
        }
    }

    public int getExecutionPlanLength() {
        checkNotClosed();
        return this.wrapper.getExecutionPlanLength();
    }

    public int getInputIndex(String str) {
        checkNotClosed();
        return this.wrapper.getInputIndex(str);
    }

    public Tensor getInputTensor(int i11) {
        checkNotClosed();
        return this.wrapper.getInputTensor(i11);
    }

    public int getInputTensorCount() {
        checkNotClosed();
        return this.wrapper.getInputTensorCount();
    }

    public Long getLastNativeInferenceDurationNanoseconds() {
        checkNotClosed();
        return this.wrapper.getLastNativeInferenceDurationNanoseconds();
    }

    public int getOutputIndex(String str) {
        checkNotClosed();
        return this.wrapper.getOutputIndex(str);
    }

    public Tensor getOutputTensor(int i11) {
        checkNotClosed();
        return this.wrapper.getOutputTensor(i11);
    }

    public int getOutputTensorCount() {
        checkNotClosed();
        return this.wrapper.getOutputTensorCount();
    }

    public void resizeInput(int i11, int[] iArr) {
        checkNotClosed();
        this.wrapper.resizeInput(i11, iArr, false);
    }

    public void run(Object obj, Object obj2) {
        Object[] objArr = {obj};
        HashMap hashMap = new HashMap();
        hashMap.put(0, obj2);
        runForMultipleInputsOutputs(objArr, hashMap);
    }

    public void runForMultipleInputsOutputs(Object[] objArr, Map<Integer, Object> map) {
        checkNotClosed();
        this.wrapper.run(objArr, map);
    }

    public InterpreterImpl(ByteBuffer byteBuffer, Options options) {
        this.wrapper = new NativeInterpreterWrapper(byteBuffer, options);
    }

    public void resizeInput(int i11, int[] iArr, boolean z11) {
        checkNotClosed();
        this.wrapper.resizeInput(i11, iArr, z11);
    }

    public InterpreterImpl(NativeInterpreterWrapper nativeInterpreterWrapper) {
        this.wrapper = nativeInterpreterWrapper;
    }
}
