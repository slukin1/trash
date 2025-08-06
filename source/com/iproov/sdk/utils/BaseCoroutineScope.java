package com.iproov.sdk.utils;

import androidx.annotation.Keep;
import com.iproov.sdk.logging.IPLog;
import com.iproov.sdk.p017implements.Ccase;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.a;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.d0;
import kotlinx.coroutines.g0;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.n1;
import kotlinx.coroutines.r1;
import kotlinx.coroutines.v0;
import kotlinx.coroutines.w;

@Metadata(bv = {}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b'\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\u0006\u0010\n\u001a\u00020\u0007R\u001a\u0010\f\u001a\u00020\u000b8\u0004X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001a"}, d2 = {"Lcom/iproov/sdk/utils/BaseCoroutineScope;", "Lkotlinx/coroutines/h0;", "Lcom/iproov/sdk/utils/StoppableCoroutineScope;", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "", "throwable", "", "handleCoroutineException", "doStop", "stop", "Lkotlinx/coroutines/w;", "job", "Lkotlinx/coroutines/w;", "getJob", "()Lkotlinx/coroutines/w;", "Lkotlinx/coroutines/d0;", "coroutineExceptionHandler", "Lkotlinx/coroutines/d0;", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "Lkotlinx/coroutines/CoroutineDispatcher;", "defaultDispatcher", "<init>", "(Lkotlinx/coroutines/CoroutineDispatcher;)V", "iproov_release"}, k = 1, mv = {1, 5, 1})
@Keep
public abstract class BaseCoroutineScope implements h0, StoppableCoroutineScope {
    private final CoroutineContext coroutineContext;
    private final d0 coroutineExceptionHandler;
    private final w job;

    /* renamed from: com.iproov.sdk.utils.BaseCoroutineScope$do  reason: invalid class name */
    public static final class Cdo extends a implements d0 {

        /* renamed from: do  reason: not valid java name */
        public final /* synthetic */ BaseCoroutineScope f2376do;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Cdo(d0.a aVar, BaseCoroutineScope baseCoroutineScope) {
            super(aVar);
            this.f2376do = baseCoroutineScope;
        }

        public void handleException(CoroutineContext coroutineContext, Throwable th2) {
            this.f2376do.handleCoroutineException(coroutineContext, th2);
        }
    }

    public BaseCoroutineScope() {
        this((CoroutineDispatcher) null, 1, (r) null);
    }

    public BaseCoroutineScope(CoroutineDispatcher coroutineDispatcher) {
        w b11 = r1.b((n1) null, 1, (Object) null);
        this.job = b11;
        Cdo doVar = new Cdo(d0.f57063q0, this);
        this.coroutineExceptionHandler = doVar;
        this.coroutineContext = b11.plus(coroutineDispatcher).plus(new g0(Ccase.m977do(this))).plus(doVar);
        Ccase.m977do(this);
    }

    public void doStop() {
    }

    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    public final w getJob() {
        return this.job;
    }

    public void handleCoroutineException(CoroutineContext coroutineContext2, Throwable th2) {
        IPLog.w(Ccase.m977do(this), x.i("Uncaught coroutine exception ", th2));
        stop();
    }

    public final void stop() {
        if (!this.job.isCancelled()) {
            Ccase.m977do(this);
            doStop();
            n1.a.a(this.job, (CancellationException) null, 1, (Object) null);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BaseCoroutineScope(CoroutineDispatcher coroutineDispatcher, int i11, r rVar) {
        this((i11 & 1) != 0 ? v0.a() : coroutineDispatcher);
    }
}
