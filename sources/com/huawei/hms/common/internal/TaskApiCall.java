package com.huawei.hms.common.internal;

import android.os.Parcelable;
import com.huawei.hmf.tasks.CancellationToken;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.support.log.HMSLog;

public abstract class TaskApiCall<ClientT extends AnyClient, ResultT> {

    /* renamed from: a  reason: collision with root package name */
    private final String f37948a;

    /* renamed from: b  reason: collision with root package name */
    private final String f37949b;

    /* renamed from: c  reason: collision with root package name */
    private Parcelable f37950c;

    /* renamed from: d  reason: collision with root package name */
    private String f37951d;

    /* renamed from: e  reason: collision with root package name */
    private CancellationToken f37952e;

    /* renamed from: f  reason: collision with root package name */
    private int f37953f;

    @Deprecated
    public TaskApiCall(String str, String str2) {
        this.f37953f = 1;
        this.f37948a = str;
        this.f37949b = str2;
        this.f37950c = null;
        this.f37951d = null;
    }

    public abstract void doExecute(ClientT clientt, ResponseErrorCode responseErrorCode, String str, TaskCompletionSource<ResultT> taskCompletionSource);

    public int getApiLevel() {
        return this.f37953f;
    }

    @Deprecated
    public int getMinApkVersion() {
        return 30000000;
    }

    public Parcelable getParcelable() {
        return this.f37950c;
    }

    public String getRequestJson() {
        return this.f37949b;
    }

    public CancellationToken getToken() {
        return this.f37952e;
    }

    public String getTransactionId() {
        return this.f37951d;
    }

    public String getUri() {
        return this.f37948a;
    }

    public final void onResponse(ClientT clientt, ResponseErrorCode responseErrorCode, String str, TaskCompletionSource<ResultT> taskCompletionSource) {
        CancellationToken cancellationToken = this.f37952e;
        if (cancellationToken == null || !cancellationToken.a()) {
            HMSLog.i("TaskApiCall", "doExecute, uri:" + this.f37948a + ", errorCode:" + responseErrorCode.getErrorCode() + ", transactionId:" + this.f37951d);
            doExecute(clientt, responseErrorCode, str, taskCompletionSource);
            return;
        }
        HMSLog.i("TaskApiCall", "This Task has been canceled, uri:" + this.f37948a + ", transactionId:" + this.f37951d);
    }

    public void setApiLevel(int i11) {
        this.f37953f = i11;
    }

    public void setParcelable(Parcelable parcelable) {
        this.f37950c = parcelable;
    }

    public void setToken(CancellationToken cancellationToken) {
        this.f37952e = cancellationToken;
    }

    public void setTransactionId(String str) {
        this.f37951d = str;
    }

    public TaskApiCall(String str, String str2, String str3) {
        this.f37953f = 1;
        this.f37948a = str;
        this.f37949b = str2;
        this.f37950c = null;
        this.f37951d = str3;
    }

    public TaskApiCall(String str, String str2, String str3, int i11) {
        this.f37948a = str;
        this.f37949b = str2;
        this.f37950c = null;
        this.f37951d = str3;
        this.f37953f = i11;
    }
}
