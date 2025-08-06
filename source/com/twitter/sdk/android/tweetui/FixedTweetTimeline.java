package com.twitter.sdk.android.tweetui;

import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.models.Tweet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import retrofit2.Response;

public class FixedTweetTimeline extends BaseTimeline implements Timeline<Tweet> {
    public final List<Tweet> tweets;

    public static class Builder {
        private List<Tweet> tweets;

        public FixedTweetTimeline build() {
            return new FixedTweetTimeline(this.tweets);
        }

        public Builder setTweets(List<Tweet> list) {
            this.tweets = list;
            return this;
        }
    }

    public FixedTweetTimeline(List<Tweet> list) {
        this.tweets = list == null ? new ArrayList<>() : list;
    }

    public void next(Long l11, Callback<TimelineResult<Tweet>> callback) {
        callback.success(new Result(new TimelineResult(new TimelineCursor(this.tweets), this.tweets), (Response) null));
    }

    public void previous(Long l11, Callback<TimelineResult<Tweet>> callback) {
        List emptyList = Collections.emptyList();
        callback.success(new Result(new TimelineResult(new TimelineCursor(emptyList), emptyList), (Response) null));
    }
}
