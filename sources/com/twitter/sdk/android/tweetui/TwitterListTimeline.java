package com.twitter.sdk.android.tweetui;

import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.tweetui.BaseTimeline;
import java.util.List;
import retrofit2.Call;

public class TwitterListTimeline extends BaseTimeline implements Timeline<Tweet> {
    public final Boolean includeRetweets;
    public final Long listId;
    public final Integer maxItemsPerRequest;
    public final Long ownerId;
    public final String ownerScreenName;
    public final String slug;
    public final TwitterCore twitterCore;

    public TwitterListTimeline(TwitterCore twitterCore2, Long l11, String str, Long l12, String str2, Integer num, Boolean bool) {
        this.twitterCore = twitterCore2;
        this.listId = l11;
        this.slug = str;
        this.ownerId = l12;
        this.ownerScreenName = str2;
        this.maxItemsPerRequest = num;
        this.includeRetweets = bool;
    }

    public Call<List<Tweet>> createListTimelineRequest(Long l11, Long l12) {
        return this.twitterCore.getApiClient().getListService().statuses(this.listId, this.slug, this.ownerScreenName, this.ownerId, l11, l12, this.maxItemsPerRequest, Boolean.TRUE, this.includeRetweets);
    }

    public void next(Long l11, Callback<TimelineResult<Tweet>> callback) {
        createListTimelineRequest(l11, (Long) null).enqueue(new BaseTimeline.TweetsCallback(callback));
    }

    public void previous(Long l11, Callback<TimelineResult<Tweet>> callback) {
        createListTimelineRequest((Long) null, BaseTimeline.decrementMaxId(l11)).enqueue(new BaseTimeline.TweetsCallback(callback));
    }

    public static class Builder {
        private Boolean includeRetweets;
        private Long listId;
        private Integer maxItemsPerRequest;
        private Long ownerId;
        private String ownerScreenName;
        private String slug;
        private final TwitterCore twitterCore;

        public Builder() {
            this.maxItemsPerRequest = 30;
            this.twitterCore = TwitterCore.getInstance();
        }

        public TwitterListTimeline build() {
            Long l11 = this.listId;
            boolean z11 = true;
            boolean z12 = l11 == null;
            String str = this.slug;
            if (str != null) {
                z11 = false;
            }
            if (!(z11 ^ z12)) {
                throw new IllegalStateException("must specify either a list id or slug/owner pair");
            } else if (str != null && this.ownerId == null && this.ownerScreenName == null) {
                throw new IllegalStateException("slug/owner pair must set owner via ownerId or ownerScreenName");
            } else {
                return new TwitterListTimeline(this.twitterCore, l11, str, this.ownerId, this.ownerScreenName, this.maxItemsPerRequest, this.includeRetweets);
            }
        }

        public Builder id(Long l11) {
            this.listId = l11;
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

        public Builder slugWithOwnerId(String str, Long l11) {
            this.slug = str;
            this.ownerId = l11;
            return this;
        }

        public Builder slugWithOwnerScreenName(String str, String str2) {
            this.slug = str;
            this.ownerScreenName = str2;
            return this;
        }

        public Builder(TwitterCore twitterCore2) {
            this.maxItemsPerRequest = 30;
            this.twitterCore = twitterCore2;
        }
    }
}
