package com.hbg.module.libkt.base.ext;

import androidx.lifecycle.MutableLiveData;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.request.callback.RequestCallback1;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.network.retrofit.rxjava.RxJavaHelper;
import com.hbg.module.libkt.base.ext.VmState;
import com.hbg.module.libkt.base.ext.g;
import d10.l;
import d10.p;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.f;
import kotlin.jvm.internal.r;
import kotlinx.coroutines.k;

public final class RequestExtKt {

    public static final class a extends BaseSubscriber<T> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ k<g<? extends T>> f24502b;

        public a(k<? super g<? extends T>> kVar) {
            this.f24502b = kVar;
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            if (th2 instanceof APIStatusErrorException) {
                k<g<? extends T>> kVar = this.f24502b;
                Result.a aVar = Result.Companion;
                kVar.resumeWith(Result.m3072constructorimpl(new g.a((APIStatusErrorException) th2, (Throwable) null)));
                return;
            }
            k<g<? extends T>> kVar2 = this.f24502b;
            Result.a aVar2 = Result.Companion;
            kVar2.resumeWith(Result.m3072constructorimpl(new g.a((APIStatusErrorException) null, th2)));
        }

        public void onNext(T t11) {
            super.onNext(t11);
            k<g<? extends T>> kVar = this.f24502b;
            Result.a aVar = Result.Companion;
            kVar.resumeWith(Result.m3072constructorimpl(new g.b(t11)));
        }
    }

    public static final class b extends BaseSubscriber<T> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ p<Throwable, APIStatusErrorException, Unit> f24503b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ MutableLiveData<VmState<T>> f24504c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ l<T, Unit> f24505d;

        public b(p<? super Throwable, ? super APIStatusErrorException, Unit> pVar, MutableLiveData<VmState<T>> mutableLiveData, l<? super T, Unit> lVar) {
            this.f24503b = pVar;
            this.f24504c = mutableLiveData;
            this.f24505d = lVar;
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            if (th2 instanceof APIStatusErrorException) {
                this.f24503b.invoke(null, th2);
                MutableLiveData<VmState<T>> mutableLiveData = this.f24504c;
                if (mutableLiveData != null) {
                    mutableLiveData.setValue(new VmState.a((APIStatusErrorException) th2, (Throwable) null));
                    return;
                }
                return;
            }
            this.f24503b.invoke(th2, null);
            MutableLiveData<VmState<T>> mutableLiveData2 = this.f24504c;
            if (mutableLiveData2 != null) {
                mutableLiveData2.setValue(new VmState.a((APIStatusErrorException) null, th2));
            }
        }

        public void onNext(T t11) {
            Object obj;
            super.onNext(t11);
            this.f24505d.invoke(t11);
            MutableLiveData<VmState<T>> mutableLiveData = this.f24504c;
            if (mutableLiveData != null) {
                if (t11 == null) {
                    obj = new VmState.Empty(0, 1, (r) null);
                } else {
                    obj = new VmState.b(t11);
                }
                mutableLiveData.setValue(obj);
            }
        }
    }

    public static final <T> Object a(d9.a<T> aVar, c<? super g<? extends T>> cVar) {
        kotlinx.coroutines.l lVar = new kotlinx.coroutines.l(IntrinsicsKt__IntrinsicsJvmKt.c(cVar), 1);
        lVar.A();
        lVar.x(new RequestExtKt$await$2$1(aVar));
        aVar.b().compose(RxJavaHelper.g((RequestCallback1) null)).subscribe(new a(lVar));
        Object v11 = lVar.v();
        if (v11 == IntrinsicsKt__IntrinsicsKt.d()) {
            f.c(cVar);
        }
        return v11;
    }

    public static final <T> void b(d9.a<T> aVar, MutableLiveData<VmState<T>> mutableLiveData) {
        c(aVar, RequestExtKt$sendRequest$1.INSTANCE, RequestExtKt$sendRequest$2.INSTANCE, mutableLiveData);
    }

    public static final <T> void c(d9.a<T> aVar, l<? super T, Unit> lVar, p<? super Throwable, ? super APIStatusErrorException, Unit> pVar, MutableLiveData<VmState<T>> mutableLiveData) {
        aVar.b().compose(RxJavaHelper.g((RequestCallback1) null)).subscribe(new b(pVar, mutableLiveData, lVar));
    }

    public static /* synthetic */ void d(d9.a aVar, l lVar, p pVar, MutableLiveData mutableLiveData, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            mutableLiveData = null;
        }
        c(aVar, lVar, pVar, mutableLiveData);
    }
}
