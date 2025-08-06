package com.twitter.sdk.android.tweetui;

import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.tweetui.BaseTimeline;
import java.util.List;
import retrofit2.Call;

public class UserTimeline extends BaseTimeline implements Timeline<Tweet> {
    public final Boolean includeReplies;
    public final Boolean includeRetweets;
    public final Integer maxItemsPerRequest;
    public final String screenName;
    public final TwitterCore twitterCore;
    public final Long userId;

    public UserTimeline(TwitterCore twitterCore2, Long l11, String str, Integer num, Boolean bool, Boolean bool2) {
        boolean z11;
        this.twitterCore = twitterCore2;
        this.userId = l11;
        this.screenName = str;
        this.maxItemsPerRequest = num;
        if (bool == null) {
            z11 = false;
        } else {
            z11 = bool.booleanValue();
        }
        this.includeReplies = Boolean.valueOf(z11);
        this.includeRetweets = bool2;
    }

    public Call<List<Tweet>> createUserTimelineRequest(Long l11, Long l12) {
        return this.twitterCore.getApiClient().getStatusesService().userTimeline(this.userId, this.screenName, this.maxItemsPerRequest, l11, l12, Boolean.FALSE, Boolean.valueOf(!this.includeReplies.booleanValue()), (Boolean) null, this.includeRetweets);
    }

    public void next(Long l11, Callback<TimelineResult<Tweet>> callback) {
        createUserTimelineRequest(l11, (Long) null).enqueue(new BaseTimeline.TweetsCallback(callback));
    }

    public void previous(Long l11, Callback<TimelineResult<Tweet>> callback) {
        createUserTimelineRequest((Long) null, BaseTimeline.decrementMaxId(l11)).enqueue(new BaseTimeline.TweetsCallback(callback));
    }

    public static class Builder {
        private Boolean includeReplies;
        private Boolean includeRetweets;
        private Integer maxItemsPerRequest;
        private String screenName;
        private final TwitterCore twitterCore;
        private Long userId;

        public Builder() {
            this.maxItemsPerRequest = 30;
            this.twitterCore = TwitterCore.getInstance();
        }

        public UserTimeline build() {
            return new UserTimeline(this.twitterCore, this.userId, this.screenName, this.maxItemsPerRequest, this.includeReplies, this.includeRetweets);
        }

        public Builder includeReplies(Boolean bool) {
            this.includeReplies = bool;
            return this;
        }

        public Builder includeRetweets(Boolean bool) {
            this.includeRetweets = bool;
            return this;
        }

        public Builder maxItemsPerRequest(Integer num) {
            this.maxItemsPerRequest = num;
            return this;
        }

        public Builder screenName(String str) {
            this.screenName = str;
            return this;
        }

        public Builder userId(Long l11) {
            this.userId = l11;
            return this;
        }

        public Builder(TwitterCore twitterCore2) {
            this.maxItemsPerRequest = 30;
            this.twitterCore = twitterCore2;
        }
    }
}
