package r1;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import androidx.core.os.OperationCanceledException;
import androidx.core.util.k;
import androidx.loader.content.ModernAsyncTask;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

public abstract class a<D> extends b<D> {
    public static final boolean DEBUG = false;
    public static final String TAG = "AsyncTaskLoader";
    public volatile a<D>.a mCancellingTask;
    private final Executor mExecutor;
    public Handler mHandler;
    public long mLastLoadCompleteTime;
    public volatile a<D>.a mTask;
    public long mUpdateThrottle;

    /* renamed from: r1.a$a  reason: collision with other inner class name */
    public final class C0096a extends ModernAsyncTask<Void, Void, D> implements Runnable {

        /* renamed from: l  reason: collision with root package name */
        public final CountDownLatch f16439l = new CountDownLatch(1);

        /* renamed from: m  reason: collision with root package name */
        public boolean f16440m;

        public C0096a() {
        }

        public void h(D d11) {
            try {
                a.this.dispatchOnCancelled(this, d11);
            } finally {
                this.f16439l.countDown();
            }
        }

        public void i(D d11) {
            try {
                a.this.dispatchOnLoadComplete(this, d11);
            } finally {
                this.f16439l.countDown();
            }
        }

        /* renamed from: n */
        public D b(Void... voidArr) {
            try {
                return a.this.onLoadInBackground();
            } catch (OperationCanceledException e11) {
                if (f()) {
                    return null;
                }
                throw e11;
            }
        }

        public void o() {
            try {
                this.f16439l.await();
            } catch (InterruptedException unused) {
            }
        }

        public void run() {
            this.f16440m = false;
            a.this.executePendingTask();
        }
    }

    public a(Context context) {
        this(context, ModernAsyncTask.f10062i);
    }

    public void cancelLoadInBackground() {
    }

    public void dispatchOnCancelled(a<D>.a aVar, D d11) {
        onCanceled(d11);
        if (this.mCancellingTask == aVar) {
            rollbackContentChanged();
            this.mLastLoadCompleteTime = SystemClock.uptimeMillis();
            this.mCancellingTask = null;
            deliverCancellation();
            executePendingTask();
        }
    }

    public void dispatchOnLoadComplete(a<D>.a aVar, D d11) {
        if (this.mTask != aVar) {
            dispatchOnCancelled(aVar, d11);
        } else if (isAbandoned()) {
            onCanceled(d11);
        } else {
            commitContentChanged();
            this.mLastLoadCompleteTime = SystemClock.uptimeMillis();
            this.mTask = null;
            deliverResult(d11);
        }
    }

    @Deprecated
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        if (this.mTask != null) {
            printWriter.print(str);
            printWriter.print("mTask=");
            printWriter.print(this.mTask);
            printWriter.print(" waiting=");
            printWriter.println(this.mTask.f16440m);
        }
        if (this.mCancellingTask != null) {
            printWriter.print(str);
            printWriter.print("mCancellingTask=");
            printWriter.print(this.mCancellingTask);
            printWriter.print(" waiting=");
            printWriter.println(this.mCancellingTask.f16440m);
        }
        if (this.mUpdateThrottle != 0) {
            printWriter.print(str);
            printWriter.print("mUpdateThrottle=");
            k.c(this.mUpdateThrottle, printWriter);
            printWriter.print(" mLastLoadCompleteTime=");
            k.b(this.mLastLoadCompleteTime, SystemClock.uptimeMillis(), printWriter);
            printWriter.println();
        }
    }

    public void executePendingTask() {
        if (this.mCancellingTask == null && this.mTask != null) {
            if (this.mTask.f16440m) {
                this.mTask.f16440m = false;
                this.mHandler.removeCallbacks(this.mTask);
            }
            if (this.mUpdateThrottle <= 0 || SystemClock.uptimeMillis() >= this.mLastLoadCompleteTime + this.mUpdateThrottle) {
                this.mTask.c(this.mExecutor, (Params[]) null);
                return;
            }
            this.mTask.f16440m = true;
            this.mHandler.postAtTime(this.mTask, this.mLastLoadCompleteTime + this.mUpdateThrottle);
        }
    }

    public boolean isLoadInBackgroundCanceled() {
        return this.mCancellingTask != null;
    }

    public abstract D loadInBackground();

    public boolean onCancelLoad() {
        if (this.mTask == null) {
            return false;
        }
        if (!this.mStarted) {
            this.mContentChanged = true;
        }
        if (this.mCancellingTask != null) {
            if (this.mTask.f16440m) {
                this.mTask.f16440m = false;
                this.mHandler.removeCallbacks(this.mTask);
            }
            this.mTask = null;
            return false;
        } else if (this.mTask.f16440m) {
            this.mTask.f16440m = false;
            this.mHandler.removeCallbacks(this.mTask);
            this.mTask = null;
            return false;
        } else {
            boolean a11 = this.mTask.a(false);
            if (a11) {
                this.mCancellingTask = this.mTask;
                cancelLoadInBackground();
            }
            this.mTask = null;
            return a11;
        }
    }

    public void onCanceled(D d11) {
    }

    public void onForceLoad() {
        super.onForceLoad();
        cancelLoad();
        this.mTask = new C0096a();
        executePendingTask();
    }

    public D onLoadInBackground() {
        return loadInBackground();
    }

    public void setUpdateThrottle(long j11) {
        this.mUpdateThrottle = j11;
        if (j11 != 0) {
            this.mHandler = new Handler();
        }
    }

    public void waitForLoader() {
        a<D>.a aVar = this.mTask;
        if (aVar != null) {
            aVar.o();
        }
    }

    private a(Context context, Executor executor) {
        super(context);
        this.mLastLoadCompleteTime = -10000;
        this.mExecutor = executor;
    }
}
