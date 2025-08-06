package com.twitter.sdk.android.tweetui;

import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.models.Tweet;
import retrofit2.Response;

public final /* synthetic */ class k implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Callback f51238b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Tweet f51239c;

    public /* synthetic */ k(Callback callback, Tweet tweet) {
        this.f51238b = callback;
        this.f51239c = tweet;
    }

    public final void run() {
        this.f51238b.success(new Result(this.f51239c, (Response) null));
    }
}
