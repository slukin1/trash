package com.google.firebase.crashlytics.internal.send;

import com.google.android.datatransport.TransportScheduleCallback;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.crashlytics.internal.common.CrashlyticsReportWithSessionId;

public final /* synthetic */ class b implements TransportScheduleCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ReportQueue f67077a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f67078b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f67079c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ CrashlyticsReportWithSessionId f67080d;

    public /* synthetic */ b(ReportQueue reportQueue, TaskCompletionSource taskCompletionSource, boolean z11, CrashlyticsReportWithSessionId crashlyticsReportWithSessionId) {
        this.f67077a = reportQueue;
        this.f67078b = taskCompletionSource;
        this.f67079c = z11;
        this.f67080d = crashlyticsReportWithSessionId;
    }

    public final void onSchedule(Exception exc) {
        this.f67077a.lambda$sendReport$1(this.f67078b, this.f67079c, this.f67080d, exc);
    }
}
