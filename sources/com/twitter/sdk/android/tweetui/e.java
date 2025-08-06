package com.twitter.sdk.android.tweetui;

import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.tweetui.FilterTimelineDelegate;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FilterTimelineDelegate.TimelineFilterCallback f51223b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TimelineResult f51224c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Result f51225d;

    public /* synthetic */ e(FilterTimelineDelegate.TimelineFilterCallback timelineFilterCallback, TimelineResult timelineResult, Result result) {
        this.f51223b = timelineFilterCallback;
        this.f51224c = timelineResult;
        this.f51225d = result;
    }

    public final void run() {
        this.f51223b.lambda$null$0(this.f51224c, this.f51225d);
    }
}
