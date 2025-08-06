package org.tensorflow.lite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.tensorflow.lite.acceleration.ValidatedAccelerationConfig;

public interface InterpreterApi extends AutoCloseable {
    void allocateTensors();

    void close();

    int getInputIndex(String str);

    Tensor getInputTensor(int i11);

    int getInputTensorCount();

    Long getLastNativeInferenceDurationNanoseconds();

    int getOutputIndex(String str);

    Tensor getOutputTensor(int i11);

    int getOutputTensorCount();

    void resizeInput(int i11, int[] iArr);

    void resizeInput(int i11, int[] iArr, boolean z11);

    void run(Object obj, Object obj2);

    void runForMultipleInputsOutputs(Object[] objArr, Map<Integer, Object> map);

    public static class Options {
        public Boolean allowCancellation;
        private final List<DelegateFactory> delegateFactories;
        public final List<Delegate> delegates;
        public int numThreads;
        public TfLiteRuntime runtime;
        public Boolean useNNAPI;
        public Boolean useXNNPACK;
        public ValidatedAccelerationConfig validatedAccelerationConfig;

        public enum TfLiteRuntime {
            FROM_APPLICATION_ONLY,
            FROM_SYSTEM_ONLY,
            PREFER_SYSTEM_OVER_APPLICATION
        }

        public Options() {
            this.runtime = TfLiteRuntime.FROM_APPLICATION_ONLY;
            this.numThreads = -1;
            this.delegates = new ArrayList();
            this.delegateFactories = new ArrayList();
        }

        public Options addDelegate(Delegate delegate) {
            this.delegates.add(delegate);
            return this;
        }

        public Options addDelegateFactory(DelegateFactory delegateFactory) {
            this.delegateFactories.add(delegateFactory);
            return this;
        }

        public ValidatedAccelerationConfig getAccelerationConfig() {
            return this.validatedAccelerationConfig;
        }

        public List<DelegateFactory> getDelegateFactories() {
            return Collections.unmodifiableList(this.delegateFactories);
        }

        public List<Delegate> getDelegates() {
            return Collections.unmodifiableList(this.delegates);
        }

        public int getNumThreads() {
            return this.numThreads;
        }

        public TfLiteRuntime getRuntime() {
            return this.runtime;
        }

        public boolean getUseNNAPI() {
            Boolean bool = this.useNNAPI;
            return bool != null && bool.booleanValue();
        }

        public boolean getUseXNNPACK() {
            Boolean bool = this.useXNNPACK;
            return bool == null || bool.booleanValue();
        }

        public boolean isCancellable() {
            Boolean bool = this.allowCancellation;
            return bool != null && bool.booleanValue();
        }

        public Options setAccelerationConfig(ValidatedAccelerationConfig validatedAccelerationConfig2) {
            this.validatedAccelerationConfig = validatedAccelerationConfig2;
            return this;
        }

        public Options setCancellable(boolean z11) {
            this.allowCancellation = Boolean.valueOf(z11);
            return this;
        }

        public Options setNumThreads(int i11) {
            this.numThreads = i11;
            return this;
        }

        public Options setRuntime(TfLiteRuntime tfLiteRuntime) {
            this.runtime = tfLiteRuntime;
            return this;
        }

        public Options setUseNNAPI(boolean z11) {
            this.useNNAPI = Boolean.valueOf(z11);
            return this;
        }

        public Options setUseXNNPACK(boolean z11) {
            this.useXNNPACK = Boolean.valueOf(z11);
            return this;
        }

        public Options(Options options) {
            this.runtime = TfLiteRuntime.FROM_APPLICATION_ONLY;
            this.numThreads = -1;
            this.numThreads = options.numThreads;
            this.useNNAPI = options.useNNAPI;
            this.allowCancellation = options.allowCancellation;
            this.delegates = new ArrayList(options.delegates);
            this.delegateFactories = new ArrayList(options.delegateFactories);
            this.runtime = options.runtime;
            this.validatedAccelerationConfig = options.validatedAccelerationConfig;
            this.useXNNPACK = options.useXNNPACK;
        }
    }
}
