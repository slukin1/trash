package org.tensorflow.lite;

import java.io.File;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Map;
import org.tensorflow.lite.InterpreterApi;
import org.tensorflow.lite.InterpreterImpl;

public final class Interpreter extends InterpreterImpl {
    private final String[] signatureKeyList;
    private final NativeInterpreterWrapperExperimental wrapperExperimental;

    public static class Options extends InterpreterImpl.Options {
        public Options() {
        }

        public Options setAllowBufferHandleOutput(boolean z11) {
            this.allowBufferHandleOutput = Boolean.valueOf(z11);
            return this;
        }

        @Deprecated
        public Options setAllowFp16PrecisionForFp32(boolean z11) {
            this.allowFp16PrecisionForFp32 = Boolean.valueOf(z11);
            return this;
        }

        public Options(InterpreterApi.Options options) {
            super(options);
        }

        public Options addDelegate(Delegate delegate) {
            super.addDelegate(delegate);
            return this;
        }

        public Options addDelegateFactory(DelegateFactory delegateFactory) {
            super.addDelegateFactory(delegateFactory);
            return this;
        }

        public Options setCancellable(boolean z11) {
            super.setCancellable(z11);
            return this;
        }

        public Options setNumThreads(int i11) {
            super.setNumThreads(i11);
            return this;
        }

        public Options setRuntime(InterpreterApi.Options.TfLiteRuntime tfLiteRuntime) {
            super.setRuntime(tfLiteRuntime);
            return this;
        }

        public Options setUseNNAPI(boolean z11) {
            super.setUseNNAPI(z11);
            return this;
        }

        public Options setUseXNNPACK(boolean z11) {
            super.setUseXNNPACK(z11);
            return this;
        }

        public Options(InterpreterImpl.Options options) {
            super(options);
        }
    }

    public Interpreter(File file) {
        this(file, (Options) null);
    }

    public /* bridge */ /* synthetic */ void allocateTensors() {
        super.allocateTensors();
    }

    public /* bridge */ /* synthetic */ void close() {
        super.close();
    }

    public /* bridge */ /* synthetic */ int getInputIndex(String str) {
        return super.getInputIndex(str);
    }

    public /* bridge */ /* synthetic */ Tensor getInputTensor(int i11) {
        return super.getInputTensor(i11);
    }

    public /* bridge */ /* synthetic */ int getInputTensorCount() {
        return super.getInputTensorCount();
    }

    public Tensor getInputTensorFromSignature(String str, String str2) {
        checkNotClosed();
        if (str2 == null) {
            String[] strArr = this.signatureKeyList;
            if (strArr.length == 1) {
                str2 = strArr[0];
            }
        }
        if (str2 != null) {
            return this.wrapper.getInputTensor(str, str2);
        }
        throw new IllegalArgumentException("Input error: SignatureDef signatureKey should not be null. null is only allowed if the model has a single Signature. Available Signatures: " + Arrays.toString(this.signatureKeyList));
    }

    public /* bridge */ /* synthetic */ Long getLastNativeInferenceDurationNanoseconds() {
        return super.getLastNativeInferenceDurationNanoseconds();
    }

    public /* bridge */ /* synthetic */ int getOutputIndex(String str) {
        return super.getOutputIndex(str);
    }

    public /* bridge */ /* synthetic */ Tensor getOutputTensor(int i11) {
        return super.getOutputTensor(i11);
    }

    public /* bridge */ /* synthetic */ int getOutputTensorCount() {
        return super.getOutputTensorCount();
    }

    public Tensor getOutputTensorFromSignature(String str, String str2) {
        checkNotClosed();
        if (str2 == null) {
            String[] strArr = this.signatureKeyList;
            if (strArr.length == 1) {
                str2 = strArr[0];
            }
        }
        if (str2 != null) {
            return this.wrapper.getOutputTensor(str, str2);
        }
        throw new IllegalArgumentException("Input error: SignatureDef signatureKey should not be null. null is only allowed if the model has a single Signature. Available Signatures: " + Arrays.toString(this.signatureKeyList));
    }

    public String[] getSignatureInputs(String str) {
        checkNotClosed();
        return this.wrapper.getSignatureInputs(str);
    }

    public String[] getSignatureKeys() {
        checkNotClosed();
        return this.wrapper.getSignatureKeys();
    }

    public String[] getSignatureOutputs(String str) {
        checkNotClosed();
        return this.wrapper.getSignatureOutputs(str);
    }

    public void resetVariableTensors() {
        checkNotClosed();
        this.wrapperExperimental.resetVariableTensors();
    }

    public /* bridge */ /* synthetic */ void resizeInput(int i11, int[] iArr) {
        super.resizeInput(i11, iArr);
    }

    public /* bridge */ /* synthetic */ void run(Object obj, Object obj2) {
        super.run(obj, obj2);
    }

    public /* bridge */ /* synthetic */ void runForMultipleInputsOutputs(Object[] objArr, Map map) {
        super.runForMultipleInputsOutputs(objArr, map);
    }

    public void runSignature(Map<String, Object> map, Map<String, Object> map2, String str) {
        checkNotClosed();
        if (str == null) {
            String[] strArr = this.signatureKeyList;
            if (strArr.length == 1) {
                str = strArr[0];
            }
        }
        if (str != null) {
            this.wrapper.runSignature(map, map2, str);
            return;
        }
        throw new IllegalArgumentException("Input error: SignatureDef signatureKey should not be null. null is only allowed if the model has a single Signature. Available Signatures: " + Arrays.toString(this.signatureKeyList));
    }

    public void setCancelled(boolean z11) {
        this.wrapper.setCancelled(z11);
    }

    public Interpreter(File file, Options options) {
        this(new NativeInterpreterWrapperExperimental(file.getAbsolutePath(), (InterpreterImpl.Options) options));
    }

    public /* bridge */ /* synthetic */ void resizeInput(int i11, int[] iArr, boolean z11) {
        super.resizeInput(i11, iArr, z11);
    }

    public Interpreter(ByteBuffer byteBuffer) {
        this(byteBuffer, (Options) null);
    }

    public Interpreter(ByteBuffer byteBuffer, Options options) {
        this(new NativeInterpreterWrapperExperimental(byteBuffer, (InterpreterImpl.Options) options));
    }

    private Interpreter(NativeInterpreterWrapperExperimental nativeInterpreterWrapperExperimental) {
        super(nativeInterpreterWrapperExperimental);
        this.wrapperExperimental = nativeInterpreterWrapperExperimental;
        this.signatureKeyList = getSignatureKeys();
    }

    public void runSignature(Map<String, Object> map, Map<String, Object> map2) {
        checkNotClosed();
        runSignature(map, map2, (String) null);
    }
}
