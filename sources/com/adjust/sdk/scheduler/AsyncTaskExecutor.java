package com.adjust.sdk.scheduler;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executors;

public abstract class AsyncTaskExecutor<Params, Result> {

    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Object[] f13959a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Handler f13960b;

        /* renamed from: com.adjust.sdk.scheduler.AsyncTaskExecutor$a$a  reason: collision with other inner class name */
        public class C0064a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Object f13962a;

            public C0064a(Object obj) {
                this.f13962a = obj;
            }

            public final void run() {
                AsyncTaskExecutor.this.onPostExecute(this.f13962a);
            }
        }

        public a(Object[] objArr, Handler handler) {
            this.f13959a = objArr;
            this.f13960b = handler;
        }

        public final void run() {
            this.f13960b.post(new C0064a(AsyncTaskExecutor.this.doInBackground(this.f13959a)));
        }
    }

    public abstract Result doInBackground(Params[] paramsArr);

    @SafeVarargs
    public final AsyncTaskExecutor<Params, Result> execute(Params... paramsArr) {
        onPreExecute();
        Executors.newSingleThreadExecutor().execute(new a(paramsArr, new Handler(Looper.getMainLooper())));
        return this;
    }

    public void onPostExecute(Result result) {
    }

    public void onPreExecute() {
    }
}
