package com.twitter.sdk.android.tweetui;

import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.tweetui.FilterTimelineDelegate;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FilterTimelineDelegate.TimelineFilterCallback f51221b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Result f51222c;

    public /* synthetic */ d(FilterTimelineDelegate.TimelineFilterCallback timelineFilterCallback, Result result) {
        this.f51221b = timelineFilterCallback;
        this.f51222c = result;
    }

    public final void run() {
        this.f51221b.lambda$success$1(this.f51222c);
    }
}
