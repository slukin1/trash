package com.huawei.hmf.tasks;

import com.huawei.hmf.tasks.a.i;

public class TaskCompletionSource<TResult> {

    /* renamed from: a  reason: collision with root package name */
    public final i<TResult> f37631a = new i<>();

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            TaskCompletionSource.this.f37631a.l();
        }
    }

    public TaskCompletionSource() {
    }

    public TaskCompletionSource(CancellationToken cancellationToken) {
        cancellationToken.b(new a());
    }

    public Task<TResult> b() {
        return this.f37631a;
    }

    public void c(Exception exc) {
        this.f37631a.j(exc);
    }

    public void d(TResult tresult) {
        this.f37631a.k(tresult);
    }
}
