package com.twitter.sdk.android.tweetui;

import android.os.Handler;
import android.os.Looper;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.tweetui.TimelineDelegate;
import java.util.List;
import java.util.concurrent.ExecutorService;

class FilterTimelineDelegate extends TimelineDelegate<Tweet> {
    public static final String TOTAL_APPLIED_FILTERS_JSON_PROP = "total_filters";
    public static final String TWEETS_COUNT_JSON_PROP = "tweet_count";
    public static final String TWEETS_FILTERED_JSON_PROP = "tweets_filtered";
    public final Gson gson = new Gson();
    public final TimelineFilter timelineFilter;
    public final TweetUi tweetUi;

    public class TimelineFilterCallback extends Callback<TimelineResult<Tweet>> {
        public final TimelineDelegate<Tweet>.DefaultCallback callback;
        public final ExecutorService executorService = Twitter.getInstance().getExecutorService();
        public final Handler handler = new Handler(Looper.getMainLooper());
        public final TimelineFilter timelineFilter;

        public TimelineFilterCallback(TimelineDelegate<Tweet>.DefaultCallback defaultCallback, TimelineFilter timelineFilter2) {
            this.callback = defaultCallback;
            this.timelineFilter = timelineFilter2;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$null$0(TimelineResult timelineResult, Result result) {
            this.callback.success(new Result(timelineResult, result.response));
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$success$1(Result result) {
            this.handler.post(new e(this, buildTimelineResult(((TimelineResult) result.data).timelineCursor, this.timelineFilter.filter(((TimelineResult) result.data).items)), result));
        }

        public TimelineResult<Tweet> buildTimelineResult(TimelineCursor timelineCursor, List<Tweet> list) {
            return new TimelineResult<>(timelineCursor, list);
        }

        public void failure(TwitterException twitterException) {
            TimelineDelegate<Tweet>.DefaultCallback defaultCallback = this.callback;
            if (defaultCallback != null) {
                defaultCallback.failure(twitterException);
            }
        }

        public void success(Result<TimelineResult<Tweet>> result) {
            this.executorService.execute(new d(this, result));
        }
    }

    public FilterTimelineDelegate(Timeline<Tweet> timeline, TimelineFilter timelineFilter2) {
        super(timeline);
        this.timelineFilter = timelineFilter2;
        this.tweetUi = TweetUi.getInstance();
    }

    private String getJsonMessage(int i11, int i12, int i13) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty(TWEETS_COUNT_JSON_PROP, (Number) Integer.valueOf(i11));
        jsonObject.addProperty(TWEETS_FILTERED_JSON_PROP, (Number) Integer.valueOf(i11 - i12));
        jsonObject.addProperty(TOTAL_APPLIED_FILTERS_JSON_PROP, (Number) Integer.valueOf(i13));
        return this.gson.toJson((JsonElement) jsonObject);
    }

    public void next(Callback<TimelineResult<Tweet>> callback) {
        loadNext(this.timelineStateHolder.positionForNext(), new TimelineFilterCallback(new TimelineDelegate.NextCallback(callback, this.timelineStateHolder), this.timelineFilter));
    }

    public void previous() {
        loadPrevious(this.timelineStateHolder.positionForPrevious(), new TimelineFilterCallback(new TimelineDelegate.PreviousCallback(this.timelineStateHolder), this.timelineFilter));
    }

    public void refresh(Callback<TimelineResult<Tweet>> callback) {
        this.timelineStateHolder.resetCursors();
        loadNext(this.timelineStateHolder.positionForNext(), new TimelineFilterCallback(new TimelineDelegate.RefreshCallback(callback, this.timelineStateHolder), this.timelineFilter));
    }
}
