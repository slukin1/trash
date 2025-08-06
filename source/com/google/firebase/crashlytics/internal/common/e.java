package com.google.firebase.crashlytics.internal.common;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

public final /* synthetic */ class e implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SessionReportingCoordinator f67054a;

    public /* synthetic */ e(SessionReportingCoordinator sessionReportingCoordinator) {
        this.f67054a = sessionReportingCoordinator;
    }

    public final Object then(Task task) {
        return Boolean.valueOf(this.f67054a.onReportSendComplete(task));
    }
}
