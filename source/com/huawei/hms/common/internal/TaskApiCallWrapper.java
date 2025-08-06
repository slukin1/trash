package com.huawei.hms.common.internal;

import com.huawei.hmf.tasks.TaskCompletionSource;

public class TaskApiCallWrapper<TResult> extends BaseContentWrapper {

    /* renamed from: a  reason: collision with root package name */
    private final TaskApiCall<? extends AnyClient, TResult> f37954a;

    /* renamed from: b  reason: collision with root package name */
    private final TaskCompletionSource<TResult> f37955b;

    public TaskApiCallWrapper(TaskApiCall<? extends AnyClient, TResult> taskApiCall, TaskCompletionSource<TResult> taskCompletionSource) {
        super(1);
        this.f37954a = taskApiCall;
        this.f37955b = taskCompletionSource;
    }

    public TaskApiCall<? extends AnyClient, TResult> getTaskApiCall() {
        return this.f37954a;
    }

    public TaskCompletionSource<TResult> getTaskCompletionSource() {
        return this.f37955b;
    }
}
