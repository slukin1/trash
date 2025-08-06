package com.twitter.sdk.android.tweetui;

import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.models.Tweet;
import java.util.List;

abstract class BaseTimeline {

    public static class TweetsCallback extends Callback<List<Tweet>> {

        /* renamed from: cb  reason: collision with root package name */
        public final Callback<TimelineResult<Tweet>> f51207cb;

        public TweetsCallback(Callback<TimelineResult<Tweet>> callback) {
            this.f51207cb = callback;
        }

        public void failure(TwitterException twitterException) {
            Callback<TimelineResult<Tweet>> callback = this.f51207cb;
            if (callback != null) {
                callback.failure(twitterException);
            }
        }

        public void success(Result<List<Tweet>> result) {
            List list = (List) result.data;
            TimelineResult timelineResult = new TimelineResult(new TimelineCursor(list), list);
            Callback<TimelineResult<Tweet>> callback = this.f51207cb;
            if (callback != null) {
                callback.success(new Result(timelineResult, result.response));
            }
        }
    }

    public static Long decrementMaxId(Long l11) {
        if (l11 == null) {
            return null;
        }
        return Long.valueOf(l11.longValue() - 1);
    }
}
