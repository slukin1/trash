package retrofit2.adapter.rxjava;

import java.lang.reflect.Type;
import retrofit2.CallAdapter;
import rx.Scheduler;

final class RxJavaCallAdapter<R> implements CallAdapter<R, Object> {
    private final boolean isAsync;
    private final boolean isBody;
    private final boolean isCompletable;
    private final boolean isResult;
    private final boolean isSingle;
    private final Type responseType;
    private final Scheduler scheduler;

    public RxJavaCallAdapter(Type type, Scheduler scheduler2, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15) {
        this.responseType = type;
        this.scheduler = scheduler2;
        this.isAsync = z11;
        this.isResult = z12;
        this.isBody = z13;
        this.isSingle = z14;
        this.isCompletable = z15;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x002c  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0039  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object adapt(retrofit2.Call<R> r2) {
        /*
            r1 = this;
            boolean r0 = r1.isAsync
            if (r0 == 0) goto L_0x000a
            retrofit2.adapter.rxjava.CallEnqueueOnSubscribe r0 = new retrofit2.adapter.rxjava.CallEnqueueOnSubscribe
            r0.<init>(r2)
            goto L_0x000f
        L_0x000a:
            retrofit2.adapter.rxjava.CallExecuteOnSubscribe r0 = new retrofit2.adapter.rxjava.CallExecuteOnSubscribe
            r0.<init>(r2)
        L_0x000f:
            boolean r2 = r1.isResult
            if (r2 == 0) goto L_0x001a
            retrofit2.adapter.rxjava.ResultOnSubscribe r2 = new retrofit2.adapter.rxjava.ResultOnSubscribe
            r2.<init>(r0)
        L_0x0018:
            r0 = r2
            goto L_0x0024
        L_0x001a:
            boolean r2 = r1.isBody
            if (r2 == 0) goto L_0x0024
            retrofit2.adapter.rxjava.BodyOnSubscribe r2 = new retrofit2.adapter.rxjava.BodyOnSubscribe
            r2.<init>(r0)
            goto L_0x0018
        L_0x0024:
            rx.Observable r2 = rx.Observable.create(r0)
            rx.Scheduler r0 = r1.scheduler
            if (r0 == 0) goto L_0x0030
            rx.Observable r2 = r2.subscribeOn(r0)
        L_0x0030:
            boolean r0 = r1.isSingle
            if (r0 == 0) goto L_0x0039
            rx.Single r2 = r2.toSingle()
            return r2
        L_0x0039:
            boolean r0 = r1.isCompletable
            if (r0 == 0) goto L_0x0041
            rx.Completable r2 = r2.toCompletable()
        L_0x0041:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: retrofit2.adapter.rxjava.RxJavaCallAdapter.adapt(retrofit2.Call):java.lang.Object");
    }

    public Type responseType() {
        return this.responseType;
    }
}
