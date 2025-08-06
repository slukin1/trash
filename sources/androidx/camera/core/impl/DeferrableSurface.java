package androidx.camera.core.impl;

import android.util.Log;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class DeferrableSurface {
    private static final boolean DEBUG = Logger.isDebugEnabled(TAG);
    public static final Size SIZE_UNDEFINED = new Size(0, 0);
    private static final String TAG = "DeferrableSurface";
    private static final AtomicInteger TOTAL_COUNT = new AtomicInteger(0);
    private static final AtomicInteger USED_COUNT = new AtomicInteger(0);
    private CallbackToFutureAdapter.a<Void> mCloseCompleter;
    private final ListenableFuture<Void> mCloseFuture;
    private boolean mClosed;
    public Class<?> mContainerClass;
    private final Object mLock;
    private final Size mPrescribedSize;
    private final int mPrescribedStreamFormat;
    private CallbackToFutureAdapter.a<Void> mTerminationCompleter;
    private final ListenableFuture<Void> mTerminationFuture;
    private int mUseCount;

    public static final class SurfaceClosedException extends Exception {
        public DeferrableSurface mDeferrableSurface;

        public SurfaceClosedException(String str, DeferrableSurface deferrableSurface) {
            super(str);
            this.mDeferrableSurface = deferrableSurface;
        }

        public DeferrableSurface getDeferrableSurface() {
            return this.mDeferrableSurface;
        }
    }

    public static final class SurfaceUnavailableException extends Exception {
        public SurfaceUnavailableException(String str) {
            super(str);
        }
    }

    public DeferrableSurface() {
        this(SIZE_UNDEFINED, 0);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object lambda$new$0(CallbackToFutureAdapter.a aVar) throws Exception {
        synchronized (this.mLock) {
            this.mTerminationCompleter = aVar;
        }
        return "DeferrableSurface-termination(" + this + ")";
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object lambda$new$1(CallbackToFutureAdapter.a aVar) throws Exception {
        synchronized (this.mLock) {
            this.mCloseCompleter = aVar;
        }
        return "DeferrableSurface-close(" + this + ")";
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$new$2(String str) {
        try {
            this.mTerminationFuture.get();
            printGlobalDebugCounts("Surface terminated", TOTAL_COUNT.decrementAndGet(), USED_COUNT.get());
        } catch (Exception e11) {
            Logger.e(TAG, "Unexpected surface termination for " + this + "\nStack Trace:\n" + str);
            synchronized (this.mLock) {
                throw new IllegalArgumentException(String.format("DeferrableSurface %s [closed: %b, use_count: %s] terminated with unexpected exception.", new Object[]{this, Boolean.valueOf(this.mClosed), Integer.valueOf(this.mUseCount)}), e11);
            }
        }
    }

    private void printGlobalDebugCounts(String str, int i11, int i12) {
        if (!DEBUG && Logger.isDebugEnabled(TAG)) {
            Logger.d(TAG, "DeferrableSurface usage statistics may be inaccurate since debug logging was not enabled at static initialization time. App restart may be required to enable accurate usage statistics.");
        }
        Logger.d(TAG, str + "[total_surfaces=" + i11 + ", used_surfaces=" + i12 + "](" + this + "}");
    }

    public void close() {
        CallbackToFutureAdapter.a<Void> aVar;
        synchronized (this.mLock) {
            if (!this.mClosed) {
                this.mClosed = true;
                this.mCloseCompleter.c(null);
                if (this.mUseCount == 0) {
                    aVar = this.mTerminationCompleter;
                    this.mTerminationCompleter = null;
                } else {
                    aVar = null;
                }
                if (Logger.isDebugEnabled(TAG)) {
                    Logger.d(TAG, "surface closed,  useCount=" + this.mUseCount + " closed=true " + this);
                }
            } else {
                aVar = null;
            }
        }
        if (aVar != null) {
            aVar.c(null);
        }
    }

    public void decrementUseCount() {
        CallbackToFutureAdapter.a<Void> aVar;
        synchronized (this.mLock) {
            int i11 = this.mUseCount;
            if (i11 != 0) {
                int i12 = i11 - 1;
                this.mUseCount = i12;
                if (i12 != 0 || !this.mClosed) {
                    aVar = null;
                } else {
                    aVar = this.mTerminationCompleter;
                    this.mTerminationCompleter = null;
                }
                if (Logger.isDebugEnabled(TAG)) {
                    Logger.d(TAG, "use count-1,  useCount=" + this.mUseCount + " closed=" + this.mClosed + " " + this);
                    if (this.mUseCount == 0) {
                        printGlobalDebugCounts("Surface no longer in use", TOTAL_COUNT.get(), USED_COUNT.decrementAndGet());
                    }
                }
            } else {
                throw new IllegalStateException("Decrementing use count occurs more times than incrementing");
            }
        }
        if (aVar != null) {
            aVar.c(null);
        }
    }

    public ListenableFuture<Void> getCloseFuture() {
        return Futures.nonCancellationPropagating(this.mCloseFuture);
    }

    public Class<?> getContainerClass() {
        return this.mContainerClass;
    }

    public Size getPrescribedSize() {
        return this.mPrescribedSize;
    }

    public int getPrescribedStreamFormat() {
        return this.mPrescribedStreamFormat;
    }

    public final ListenableFuture<Surface> getSurface() {
        synchronized (this.mLock) {
            if (this.mClosed) {
                ListenableFuture<Surface> immediateFailedFuture = Futures.immediateFailedFuture(new SurfaceClosedException("DeferrableSurface already closed.", this));
                return immediateFailedFuture;
            }
            ListenableFuture<Surface> provideSurface = provideSurface();
            return provideSurface;
        }
    }

    public ListenableFuture<Void> getTerminationFuture() {
        return Futures.nonCancellationPropagating(this.mTerminationFuture);
    }

    public int getUseCount() {
        int i11;
        synchronized (this.mLock) {
            i11 = this.mUseCount;
        }
        return i11;
    }

    public void incrementUseCount() throws SurfaceClosedException {
        synchronized (this.mLock) {
            int i11 = this.mUseCount;
            if (i11 == 0) {
                if (this.mClosed) {
                    throw new SurfaceClosedException("Cannot begin use on a closed surface.", this);
                }
            }
            this.mUseCount = i11 + 1;
            if (Logger.isDebugEnabled(TAG)) {
                if (this.mUseCount == 1) {
                    printGlobalDebugCounts("New surface in use", TOTAL_COUNT.get(), USED_COUNT.incrementAndGet());
                }
                Logger.d(TAG, "use count+1, useCount=" + this.mUseCount + " " + this);
            }
        }
    }

    public boolean isClosed() {
        boolean z11;
        synchronized (this.mLock) {
            z11 = this.mClosed;
        }
        return z11;
    }

    public abstract ListenableFuture<Surface> provideSurface();

    public void setContainerClass(Class<?> cls) {
        this.mContainerClass = cls;
    }

    public DeferrableSurface(Size size, int i11) {
        this.mLock = new Object();
        this.mUseCount = 0;
        this.mClosed = false;
        this.mPrescribedSize = size;
        this.mPrescribedStreamFormat = i11;
        ListenableFuture<Void> a11 = CallbackToFutureAdapter.a(new r(this));
        this.mTerminationFuture = a11;
        this.mCloseFuture = CallbackToFutureAdapter.a(new q(this));
        if (Logger.isDebugEnabled(TAG)) {
            printGlobalDebugCounts("Surface created", TOTAL_COUNT.incrementAndGet(), USED_COUNT.get());
            a11.addListener(new s(this, Log.getStackTraceString(new Exception())), CameraXExecutors.directExecutor());
        }
    }
}
