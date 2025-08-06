package com.twitter.sdk.android.tweetui;

import com.twitter.sdk.android.core.Callback;

public interface Timeline<T> {
    void next(Long l11, Callback<TimelineResult<T>> callback);

    void previous(Long l11, Callback<TimelineResult<T>> callback);
}
