package com.jumio.core.network;

import com.jumio.commons.log.Log;
import com.jumio.core.models.DataDogModel;
import com.jumio.core.plugins.AnalyticsPlugin;
import com.jumio.core.util.DataDogHelper;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import jumio.core.a1;
import jumio.core.b1;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.r;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.i;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.n1;
import kotlinx.coroutines.v0;

public abstract class DownloadTask<Result> {

    /* renamed from: a  reason: collision with root package name */
    public final String f39420a;

    /* renamed from: b  reason: collision with root package name */
    public final ExecutorService f39421b;

    /* renamed from: c  reason: collision with root package name */
    public Future<?> f39422c;

    /* renamed from: d  reason: collision with root package name */
    public final Timer f39423d;

    /* renamed from: e  reason: collision with root package name */
    public final int f39424e;

    /* renamed from: f  reason: collision with root package name */
    public ProgressListener<Result> f39425f;

    public interface ProgressListener<Result> {
        void onProgressDone(Result result);

        void onProgressException(Exception exc);

        void onProgressUpdate(float f11);
    }

    public final class a implements ProgressListener<Result> {

        /* renamed from: a  reason: collision with root package name */
        public final ProgressListener<Result> f39426a;

        /* renamed from: b  reason: collision with root package name */
        public final h0 f39427b = i0.a(v0.c().G());

        /* renamed from: com.jumio.core.network.DownloadTask$a$a  reason: collision with other inner class name */
        public static final class C0517a extends Lambda implements d10.a<Unit> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ DownloadTask<Result>.a f39428a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Result f39429b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0517a(DownloadTask<Result>.a aVar, Result result) {
                super(0);
                this.f39428a = aVar;
                this.f39429b = result;
            }

            public final Object invoke() {
                this.f39428a.f39426a.onProgressDone(this.f39429b);
                return Unit.f56620a;
            }
        }

        public static final class b extends Lambda implements d10.a<Unit> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ DownloadTask<Result>.a f39430a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Exception f39431b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b(DownloadTask<Result>.a aVar, Exception exc) {
                super(0);
                this.f39430a = aVar;
                this.f39431b = exc;
            }

            public final Object invoke() {
                this.f39430a.f39426a.onProgressException(this.f39431b);
                return Unit.f56620a;
            }
        }

        public static final class c extends Lambda implements d10.a<Unit> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ DownloadTask<Result>.a f39432a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ float f39433b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public c(DownloadTask<Result>.a aVar, float f11) {
                super(0);
                this.f39432a = aVar;
                this.f39433b = f11;
            }

            public final Object invoke() {
                this.f39432a.f39426a.onProgressUpdate(this.f39433b);
                return Unit.f56620a;
            }
        }

        public a(ProgressListener progressListener) {
            this.f39426a = progressListener;
        }

        public final void onProgressDone(Result result) {
            n1 unused = i.d(this.f39427b, (CoroutineContext) null, (CoroutineStart) null, new a(new C0517a(this, result), (kotlin.coroutines.c<? super a>) null), 3, (Object) null);
        }

        public final void onProgressException(Exception exc) {
            n1 unused = i.d(this.f39427b, (CoroutineContext) null, (CoroutineStart) null, new a(new b(this, exc), (kotlin.coroutines.c<? super a>) null), 3, (Object) null);
        }

        public final void onProgressUpdate(float f11) {
            n1 unused = i.d(this.f39427b, (CoroutineContext) null, (CoroutineStart) null, new a(new c(this, f11), (kotlin.coroutines.c<? super a>) null), 3, (Object) null);
        }
    }

    public final class b extends TimerTask {

        /* renamed from: a  reason: collision with root package name */
        public final Future<?> f39434a;

        public b(Future future) {
            this.f39434a = future;
        }

        public final void run() {
            try {
                if (!this.f39434a.isDone() && !this.f39434a.isCancelled()) {
                    this.f39434a.cancel(true);
                }
            } catch (Exception e11) {
                Log.printStackTrace(e11);
            }
        }
    }

    public DownloadTask(String str) {
        this(str, 0, 2, (r) null);
    }

    public DownloadTask(String str, int i11) {
        this.f39420a = str;
        this.f39421b = Executors.newSingleThreadExecutor();
        if (i11 != 0) {
            this.f39423d = new Timer("TimeoutTaskKiller");
            this.f39424e = i11;
        }
    }

    public static final void a(DownloadTask downloadTask) {
        downloadTask.a();
    }

    public final void close(HttpURLConnection httpURLConnection) {
        OutputStream outputStream;
        if (httpURLConnection != null) {
            try {
                InputStream inputStream = httpURLConnection.getInputStream();
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (Exception e11) {
                Log.printStackTrace(e11);
            }
            try {
                if (httpURLConnection.getDoOutput() && (outputStream = httpURLConnection.getOutputStream()) != null) {
                    outputStream.close();
                }
            } catch (Exception e12) {
                Log.printStackTrace(e12);
            }
            try {
                InputStream errorStream = httpURLConnection.getErrorStream();
                if (errorStream != null) {
                    errorStream.close();
                }
            } catch (Exception e13) {
                Log.printStackTrace(e13);
            }
            httpURLConnection.disconnect();
        }
    }

    public String getCallId() {
        return "DownloadTask";
    }

    public final ProgressListener<Result> getProgressListener() {
        return this.f39425f;
    }

    public abstract Result processInputStream(InputStream inputStream, int i11);

    public final void setListener(ProgressListener<Result> progressListener) {
        this.f39425f = progressListener != null ? new a(progressListener) : null;
    }

    public final void setProgressListener(ProgressListener<Result> progressListener) {
        this.f39425f = progressListener;
    }

    public final void start() {
        this.f39422c = this.f39421b.submit(new lw.a(this));
    }

    public final Result startSync() {
        return a();
    }

    public final Result a() {
        b1 b1Var;
        Result result;
        Timer timer;
        Future<?> future = this.f39422c;
        if (!(future == null || (timer = this.f39423d) == null)) {
            timer.schedule(new b(future), (long) this.f39424e);
        }
        String callId = getCallId();
        int i11 = 0;
        AnalyticsPlugin<DataDogModel> plugin = DataDogHelper.INSTANCE.getPlugin();
        Result result2 = null;
        try {
            b1Var = new b1();
            a1 a11 = b1Var.a(this.f39420a, this.f39424e, plugin, callId);
            i11 = a11.f56121a;
            if (i11 != 200) {
                result = null;
            } else {
                result = processInputStream(a11.f56123c, a11.f56122b);
            }
            b1Var.a();
            result2 = result;
        } catch (Exception e11) {
            int i12 = i11;
            if (plugin != null) {
                plugin.reportResponse(callId, this.f39420a, (Integer) null, i12, e11);
            }
            Log.e("DownloadTask", "", (Throwable) e11);
            ProgressListener<Result> progressListener = this.f39425f;
            if (progressListener != null) {
                progressListener.onProgressException(e11);
            }
        } catch (Throwable th2) {
            b1Var.a();
            throw th2;
        }
        ProgressListener<Result> progressListener2 = this.f39425f;
        if (progressListener2 != null) {
            progressListener2.onProgressDone(result2);
        }
        Timer timer2 = this.f39423d;
        if (timer2 != null) {
            timer2.cancel();
            timer2.purge();
        }
        return result2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DownloadTask(String str, int i11, int i12, r rVar) {
        this(str, (i12 & 2) != 0 ? 0 : i11);
    }
}
