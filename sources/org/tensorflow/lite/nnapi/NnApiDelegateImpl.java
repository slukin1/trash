package org.tensorflow.lite.nnapi;

import org.tensorflow.lite.Delegate;
import org.tensorflow.lite.TensorFlowLite;
import org.tensorflow.lite.nnapi.NnApiDelegate;

public class NnApiDelegateImpl implements NnApiDelegate.PrivateInterface, Delegate, AutoCloseable {
    private static final long INVALID_DELEGATE_HANDLE = 0;
    private long delegateHandle;

    public NnApiDelegateImpl(NnApiDelegate.Options options) {
        TensorFlowLite.init();
        boolean z11 = false;
        this.delegateHandle = createDelegate(options.getExecutionPreference(), options.getAcceleratorName(), options.getCacheDir(), options.getModelToken(), options.getMaxNumberOfDelegatedPartitions(), options.getUseNnapiCpu() != null, (options.getUseNnapiCpu() == null || !options.getUseNnapiCpu().booleanValue()) ? true : z11, options.getAllowFp16(), options.getNnApiSupportLibraryHandle());
    }

    private void checkNotClosed() {
        if (this.delegateHandle == 0) {
            throw new IllegalStateException("Should not access delegate after it has been closed.");
        }
    }

    private static native long createDelegate(int i11, String str, String str2, String str3, int i12, boolean z11, boolean z12, boolean z13, long j11);

    private static native void deleteDelegate(long j11);

    private static native int getNnapiErrno(long j11);

    public void close() {
        long j11 = this.delegateHandle;
        if (j11 != 0) {
            deleteDelegate(j11);
            this.delegateHandle = 0;
        }
    }

    public long getNativeHandle() {
        return this.delegateHandle;
    }

    public int getNnapiErrno() {
        checkNotClosed();
        return getNnapiErrno(this.delegateHandle);
    }
}
