package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobParameters;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ JobInfoSchedulerService f65596b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ JobParameters f65597c;

    public /* synthetic */ b(JobInfoSchedulerService jobInfoSchedulerService, JobParameters jobParameters) {
        this.f65596b = jobInfoSchedulerService;
        this.f65597c = jobParameters;
    }

    public final void run() {
        this.f65596b.lambda$onStartJob$0(this.f65597c);
    }
}
