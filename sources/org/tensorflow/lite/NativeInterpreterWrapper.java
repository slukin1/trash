package org.tensorflow.lite;

import java.lang.reflect.InvocationTargetException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.tensorflow.lite.InterpreterApi;
import org.tensorflow.lite.InterpreterImpl;
import org.tensorflow.lite.annotations.UsedByReflection;
import org.tensorflow.lite.nnapi.NnApiDelegate;

class NativeInterpreterWrapper implements AutoCloseable {
    private static final int ERROR_BUFFER_SIZE = 512;
    private static final RuntimeFlavor RUNTIME_FLAVOR = RuntimeFlavor.APPLICATION;
    private long cancellationFlagHandle;
    private final List<Delegate> delegates;
    public long errorHandle;
    @UsedByReflection("nativeinterpreterwrapper_jni.cc")
    private long inferenceDurationNanoseconds;
    private TensorImpl[] inputTensors;
    private Map<String, Integer> inputsIndexes;
    public long interpreterHandle;
    private boolean isMemoryAllocated;
    private ByteBuffer modelByteBuffer;
    private long modelHandle;
    private boolean originalGraphHasUnresolvedFlexOp;
    private TensorImpl[] outputTensors;
    private Map<String, Integer> outputsIndexes;
    private final List<Delegate> ownedDelegates;
    private Map<String, NativeSignatureRunnerWrapper> signatureRunnerMap;

    public NativeInterpreterWrapper(String str) {
        this(str, (InterpreterImpl.Options) null);
    }

    private void addDelegates(InterpreterImpl.Options options) {
        Delegate maybeCreateFlexDelegate;
        if (this.originalGraphHasUnresolvedFlexOp && (maybeCreateFlexDelegate = maybeCreateFlexDelegate(options.getDelegates())) != null) {
            this.ownedDelegates.add(maybeCreateFlexDelegate);
            this.delegates.add(maybeCreateFlexDelegate);
        }
        addUserProvidedDelegates(options);
        for (DelegateFactory create : options.getDelegateFactories()) {
            Delegate create2 = create.create(RUNTIME_FLAVOR);
            this.ownedDelegates.add(create2);
            this.delegates.add(create2);
        }
        if (options.getUseNNAPI()) {
            NnApiDelegate nnApiDelegate = new NnApiDelegate();
            this.ownedDelegates.add(nnApiDelegate);
            this.delegates.add(nnApiDelegate);
        }
    }

    private void addUserProvidedDelegates(InterpreterImpl.Options options) {
        for (Delegate next : options.getDelegates()) {
            if (options.getRuntime() == InterpreterApi.Options.TfLiteRuntime.FROM_APPLICATION_ONLY || (next instanceof NnApiDelegate)) {
                this.delegates.add(next);
            } else {
                throw new IllegalArgumentException("Instantiated delegates (other than NnApiDelegate) are not allowed when using TF Lite from Google Play Services. Please use InterpreterApi.Options.addDelegateFactory() with an appropriate DelegateFactory instead.");
            }
        }
    }

    private static native long allocateTensors(long j11, long j12);

    private boolean allocateTensorsIfNeeded() {
        if (this.isMemoryAllocated) {
            return false;
        }
        this.isMemoryAllocated = true;
        allocateTensors(this.interpreterHandle, this.errorHandle);
        for (TensorImpl tensorImpl : this.outputTensors) {
            if (tensorImpl != null) {
                tensorImpl.refreshShape();
            }
        }
        return true;
    }

    private static native void allowBufferHandleOutput(long j11, boolean z11);

    private static native void allowFp16PrecisionForFp32(long j11, boolean z11);

    private static native long createCancellationFlag(long j11);

    private static native long createErrorReporter(int i11);

    private static native long createInterpreter(long j11, long j12, int i11, boolean z11, List<Long> list);

    private static native long createModel(String str, long j11);

    private static native long createModelWithBuffer(ByteBuffer byteBuffer, long j11);

    private static native void delete(long j11, long j12, long j13);

    private static native long deleteCancellationFlag(long j11);

    private static native int getExecutionPlanLength(long j11);

    private static native int getInputCount(long j11);

    private static native String[] getInputNames(long j11);

    private static native int getInputTensorIndex(long j11, int i11);

    private static native int getOutputCount(long j11);

    private static native String[] getOutputNames(long j11);

    private static native int getOutputTensorIndex(long j11, int i11);

    private static native String[] getSignatureKeys(long j11);

    private NativeSignatureRunnerWrapper getSignatureRunnerWrapper(String str) {
        if (this.signatureRunnerMap == null) {
            this.signatureRunnerMap = new HashMap();
        }
        if (!this.signatureRunnerMap.containsKey(str)) {
            this.signatureRunnerMap.put(str, new NativeSignatureRunnerWrapper(this.interpreterHandle, this.errorHandle, str));
        }
        return this.signatureRunnerMap.get(str);
    }

    private static native boolean hasUnresolvedFlexOp(long j11);

    private void init(long j11, long j12, InterpreterImpl.Options options) {
        if (options == null) {
            options = new InterpreterImpl.Options();
        }
        if (options.getAccelerationConfig() != null) {
            options.getAccelerationConfig().apply(options);
        }
        this.errorHandle = j11;
        this.modelHandle = j12;
        ArrayList arrayList = new ArrayList();
        long createInterpreter = createInterpreter(j12, j11, options.getNumThreads(), options.getUseXNNPACK(), arrayList);
        this.interpreterHandle = createInterpreter;
        this.originalGraphHasUnresolvedFlexOp = hasUnresolvedFlexOp(createInterpreter);
        addDelegates(options);
        initDelegatesWithInterpreterFactory();
        arrayList.ensureCapacity(this.delegates.size());
        for (Delegate nativeHandle : this.delegates) {
            arrayList.add(Long.valueOf(nativeHandle.getNativeHandle()));
        }
        if (!arrayList.isEmpty()) {
            delete(0, 0, this.interpreterHandle);
            this.interpreterHandle = createInterpreter(j12, j11, options.getNumThreads(), options.getUseXNNPACK(), arrayList);
        }
        Boolean bool = options.allowFp16PrecisionForFp32;
        if (bool != null) {
            allowFp16PrecisionForFp32(this.interpreterHandle, bool.booleanValue());
        }
        Boolean bool2 = options.allowBufferHandleOutput;
        if (bool2 != null) {
            allowBufferHandleOutput(this.interpreterHandle, bool2.booleanValue());
        }
        if (options.isCancellable()) {
            this.cancellationFlagHandle = createCancellationFlag(this.interpreterHandle);
        }
        this.inputTensors = new TensorImpl[getInputCount(this.interpreterHandle)];
        this.outputTensors = new TensorImpl[getOutputCount(this.interpreterHandle)];
        Boolean bool3 = options.allowFp16PrecisionForFp32;
        if (bool3 != null) {
            allowFp16PrecisionForFp32(this.interpreterHandle, bool3.booleanValue());
        }
        Boolean bool4 = options.allowBufferHandleOutput;
        if (bool4 != null) {
            allowBufferHandleOutput(this.interpreterHandle, bool4.booleanValue());
        }
        allocateTensors(this.interpreterHandle, j11);
        this.isMemoryAllocated = true;
    }

    private void initDelegatesWithInterpreterFactory() {
        InterpreterFactoryImpl interpreterFactoryImpl = new InterpreterFactoryImpl();
        for (Delegate next : this.delegates) {
            if (next instanceof NnApiDelegate) {
                ((NnApiDelegate) next).initWithInterpreterFactoryApi(interpreterFactoryImpl);
            }
        }
    }

    private static Delegate maybeCreateFlexDelegate(List<Delegate> list) {
        try {
            Class<?> cls = Class.forName("org.tensorflow.lite.flex.FlexDelegate");
            for (Delegate isInstance : list) {
                if (cls.isInstance(isInstance)) {
                    return null;
                }
            }
            return (Delegate) cls.getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | SecurityException | InvocationTargetException unused) {
            return null;
        }
    }

    private static native boolean resizeInput(long j11, long j12, int i11, int[] iArr, boolean z11);

    private static native void run(long j11, long j12);

    private static native void setCancelled(long j11, long j12, boolean z11);

    public void allocateTensors() {
        allocateTensorsIfNeeded();
    }

    public void close() {
        int i11 = 0;
        while (true) {
            TensorImpl[] tensorImplArr = this.inputTensors;
            if (i11 >= tensorImplArr.length) {
                break;
            }
            if (tensorImplArr[i11] != null) {
                tensorImplArr[i11].close();
                this.inputTensors[i11] = null;
            }
            i11++;
        }
        int i12 = 0;
        while (true) {
            TensorImpl[] tensorImplArr2 = this.outputTensors;
            if (i12 >= tensorImplArr2.length) {
                break;
            }
            if (tensorImplArr2[i12] != null) {
                tensorImplArr2[i12].close();
                this.outputTensors[i12] = null;
            }
            i12++;
        }
        delete(this.errorHandle, this.modelHandle, this.interpreterHandle);
        deleteCancellationFlag(this.cancellationFlagHandle);
        this.errorHandle = 0;
        this.modelHandle = 0;
        this.interpreterHandle = 0;
        this.cancellationFlagHandle = 0;
        this.modelByteBuffer = null;
        this.inputsIndexes = null;
        this.outputsIndexes = null;
        this.isMemoryAllocated = false;
        this.delegates.clear();
        for (Delegate close : this.ownedDelegates) {
            close.close();
        }
        this.ownedDelegates.clear();
    }

    public int getExecutionPlanLength() {
        return getExecutionPlanLength(this.interpreterHandle);
    }

    public int getInputIndex(String str) {
        if (this.inputsIndexes == null) {
            String[] inputNames = getInputNames(this.interpreterHandle);
            this.inputsIndexes = new HashMap();
            if (inputNames != null) {
                for (int i11 = 0; i11 < inputNames.length; i11++) {
                    this.inputsIndexes.put(inputNames[i11], Integer.valueOf(i11));
                }
            }
        }
        if (this.inputsIndexes.containsKey(str)) {
            return this.inputsIndexes.get(str).intValue();
        }
        throw new IllegalArgumentException(String.format("Input error: '%s' is not a valid name for any input. Names of inputs and their indexes are %s", new Object[]{str, this.inputsIndexes}));
    }

    public TensorImpl getInputTensor(int i11) {
        if (i11 >= 0) {
            TensorImpl[] tensorImplArr = this.inputTensors;
            if (i11 < tensorImplArr.length) {
                TensorImpl tensorImpl = tensorImplArr[i11];
                if (tensorImpl != null) {
                    return tensorImpl;
                }
                long j11 = this.interpreterHandle;
                TensorImpl fromIndex = TensorImpl.fromIndex(j11, getInputTensorIndex(j11, i11));
                tensorImplArr[i11] = fromIndex;
                return fromIndex;
            }
        }
        throw new IllegalArgumentException("Invalid input Tensor index: " + i11);
    }

    public int getInputTensorCount() {
        return this.inputTensors.length;
    }

    public Long getLastNativeInferenceDurationNanoseconds() {
        long j11 = this.inferenceDurationNanoseconds;
        if (j11 < 0) {
            return null;
        }
        return Long.valueOf(j11);
    }

    public int getOutputIndex(String str) {
        if (this.outputsIndexes == null) {
            String[] outputNames = getOutputNames(this.interpreterHandle);
            this.outputsIndexes = new HashMap();
            if (outputNames != null) {
                for (int i11 = 0; i11 < outputNames.length; i11++) {
                    this.outputsIndexes.put(outputNames[i11], Integer.valueOf(i11));
                }
            }
        }
        if (this.outputsIndexes.containsKey(str)) {
            return this.outputsIndexes.get(str).intValue();
        }
        throw new IllegalArgumentException(String.format("Input error: '%s' is not a valid name for any output. Names of outputs and their indexes are %s", new Object[]{str, this.outputsIndexes}));
    }

    public TensorImpl getOutputTensor(int i11) {
        if (i11 >= 0) {
            TensorImpl[] tensorImplArr = this.outputTensors;
            if (i11 < tensorImplArr.length) {
                TensorImpl tensorImpl = tensorImplArr[i11];
                if (tensorImpl != null) {
                    return tensorImpl;
                }
                long j11 = this.interpreterHandle;
                TensorImpl fromIndex = TensorImpl.fromIndex(j11, getOutputTensorIndex(j11, i11));
                tensorImplArr[i11] = fromIndex;
                return fromIndex;
            }
        }
        throw new IllegalArgumentException("Invalid output Tensor index: " + i11);
    }

    public int getOutputTensorCount() {
        return this.outputTensors.length;
    }

    public String[] getSignatureInputs(String str) {
        return getSignatureRunnerWrapper(str).inputNames();
    }

    public String[] getSignatureKeys() {
        return getSignatureKeys(this.interpreterHandle);
    }

    public String[] getSignatureOutputs(String str) {
        return getSignatureRunnerWrapper(str).outputNames();
    }

    public void resizeInput(int i11, int[] iArr) {
        resizeInput(i11, iArr, false);
    }

    public void run(Object[] objArr, Map<Integer, Object> map) {
        this.inferenceDurationNanoseconds = -1;
        if (objArr == null || objArr.length == 0) {
            throw new IllegalArgumentException("Input error: Inputs should not be null or empty.");
        } else if (map != null) {
            for (int i11 = 0; i11 < objArr.length; i11++) {
                int[] inputShapeIfDifferent = getInputTensor(i11).getInputShapeIfDifferent(objArr[i11]);
                if (inputShapeIfDifferent != null) {
                    resizeInput(i11, inputShapeIfDifferent);
                }
            }
            boolean allocateTensorsIfNeeded = allocateTensorsIfNeeded();
            for (int i12 = 0; i12 < objArr.length; i12++) {
                getInputTensor(i12).setTo(objArr[i12]);
            }
            long nanoTime = System.nanoTime();
            run(this.interpreterHandle, this.errorHandle);
            long nanoTime2 = System.nanoTime() - nanoTime;
            if (allocateTensorsIfNeeded) {
                for (TensorImpl tensorImpl : this.outputTensors) {
                    if (tensorImpl != null) {
                        tensorImpl.refreshShape();
                    }
                }
            }
            for (Map.Entry next : map.entrySet()) {
                if (next.getValue() != null) {
                    getOutputTensor(((Integer) next.getKey()).intValue()).copyTo(next.getValue());
                }
            }
            this.inferenceDurationNanoseconds = nanoTime2;
        } else {
            throw new IllegalArgumentException("Input error: Outputs should not be null.");
        }
    }

    public void runSignature(Map<String, Object> map, Map<String, Object> map2, String str) {
        this.inferenceDurationNanoseconds = -1;
        if (map == null || map.isEmpty()) {
            throw new IllegalArgumentException("Input error: Inputs should not be null or empty.");
        } else if (map2 != null) {
            NativeSignatureRunnerWrapper signatureRunnerWrapper = getSignatureRunnerWrapper(str);
            if (signatureRunnerWrapper.getSubgraphIndex() == 0) {
                Object[] objArr = new Object[map.size()];
                for (Map.Entry next : map.entrySet()) {
                    objArr[signatureRunnerWrapper.getInputIndex((String) next.getKey())] = next.getValue();
                }
                TreeMap treeMap = new TreeMap();
                for (Map.Entry next2 : map2.entrySet()) {
                    treeMap.put(Integer.valueOf(signatureRunnerWrapper.getOutputIndex((String) next2.getKey())), next2.getValue());
                }
                run(objArr, (Map<Integer, Object>) treeMap);
                return;
            }
            for (Map.Entry next3 : map.entrySet()) {
                int[] inputShapeIfDifferent = getInputTensor((String) next3.getKey(), str).getInputShapeIfDifferent(next3.getValue());
                if (inputShapeIfDifferent != null) {
                    signatureRunnerWrapper.resizeInput((String) next3.getKey(), inputShapeIfDifferent);
                }
            }
            signatureRunnerWrapper.allocateTensorsIfNeeded();
            for (Map.Entry next4 : map.entrySet()) {
                signatureRunnerWrapper.getInputTensor((String) next4.getKey()).setTo(next4.getValue());
            }
            long nanoTime = System.nanoTime();
            signatureRunnerWrapper.invoke();
            long nanoTime2 = System.nanoTime() - nanoTime;
            for (Map.Entry next5 : map2.entrySet()) {
                if (next5.getValue() != null) {
                    signatureRunnerWrapper.getOutputTensor((String) next5.getKey()).copyTo(next5.getValue());
                }
            }
            this.inferenceDurationNanoseconds = nanoTime2;
        } else {
            throw new IllegalArgumentException("Input error: Outputs should not be null.");
        }
    }

    public void setCancelled(boolean z11) {
        long j11 = this.cancellationFlagHandle;
        if (j11 != 0) {
            setCancelled(this.interpreterHandle, j11, z11);
            return;
        }
        throw new IllegalStateException("Cannot cancel the inference. Have you called InterpreterApi.Options.setCancellable?");
    }

    public NativeInterpreterWrapper(ByteBuffer byteBuffer) {
        this(byteBuffer, (InterpreterImpl.Options) null);
    }

    public void resizeInput(int i11, int[] iArr, boolean z11) {
        if (resizeInput(this.interpreterHandle, this.errorHandle, i11, iArr, z11)) {
            this.isMemoryAllocated = false;
            TensorImpl[] tensorImplArr = this.inputTensors;
            if (tensorImplArr[i11] != null) {
                tensorImplArr[i11].refreshShape();
            }
        }
    }

    public NativeInterpreterWrapper(String str, InterpreterImpl.Options options) {
        this.cancellationFlagHandle = 0;
        this.inferenceDurationNanoseconds = -1;
        this.isMemoryAllocated = false;
        this.originalGraphHasUnresolvedFlexOp = false;
        this.delegates = new ArrayList();
        this.ownedDelegates = new ArrayList();
        TensorFlowLite.init();
        long createErrorReporter = createErrorReporter(512);
        init(createErrorReporter, createModel(str, createErrorReporter), options);
    }

    public TensorImpl getInputTensor(String str, String str2) {
        if (str != null) {
            NativeSignatureRunnerWrapper signatureRunnerWrapper = getSignatureRunnerWrapper(str2);
            if (signatureRunnerWrapper.getSubgraphIndex() > 0) {
                return signatureRunnerWrapper.getInputTensor(str);
            }
            return getInputTensor(signatureRunnerWrapper.getInputIndex(str));
        }
        throw new IllegalArgumentException("Invalid input tensor name provided (null)");
    }

    public TensorImpl getOutputTensor(String str, String str2) {
        if (str != null) {
            NativeSignatureRunnerWrapper signatureRunnerWrapper = getSignatureRunnerWrapper(str2);
            if (signatureRunnerWrapper.getSubgraphIndex() > 0) {
                return signatureRunnerWrapper.getOutputTensor(str);
            }
            return getOutputTensor(signatureRunnerWrapper.getOutputIndex(str));
        }
        throw new IllegalArgumentException("Invalid output tensor name provided (null)");
    }

    public NativeInterpreterWrapper(ByteBuffer byteBuffer, InterpreterImpl.Options options) {
        this.cancellationFlagHandle = 0;
        this.inferenceDurationNanoseconds = -1;
        this.isMemoryAllocated = false;
        this.originalGraphHasUnresolvedFlexOp = false;
        this.delegates = new ArrayList();
        this.ownedDelegates = new ArrayList();
        TensorFlowLite.init();
        if (byteBuffer == null || (!(byteBuffer instanceof MappedByteBuffer) && (!byteBuffer.isDirect() || byteBuffer.order() != ByteOrder.nativeOrder()))) {
            throw new IllegalArgumentException("Model ByteBuffer should be either a MappedByteBuffer of the model file, or a direct ByteBuffer using ByteOrder.nativeOrder() which contains bytes of model content.");
        }
        this.modelByteBuffer = byteBuffer;
        long createErrorReporter = createErrorReporter(512);
        init(createErrorReporter, createModelWithBuffer(this.modelByteBuffer, createErrorReporter), options);
    }
}
