package com.twitter.sdk.android.tweetui;

import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.core.models.TweetBuilder;
import com.twitter.sdk.android.core.models.TwitterCollection;
import com.twitter.sdk.android.core.models.User;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import retrofit2.Call;

public class CollectionTimeline extends BaseTimeline implements Timeline<Tweet> {
    public static final String COLLECTION_PREFIX = "custom-";
    public final String collectionIdentifier;
    public final Integer maxItemsPerRequest;
    public final TwitterCore twitterCore;

    public class CollectionCallback extends Callback<TwitterCollection> {

        /* renamed from: cb  reason: collision with root package name */
        public final Callback<TimelineResult<Tweet>> f51208cb;

        public CollectionCallback(Callback<TimelineResult<Tweet>> callback) {
            this.f51208cb = callback;
        }

        public void failure(TwitterException twitterException) {
            Callback<TimelineResult<Tweet>> callback = this.f51208cb;
            if (callback != null) {
                callback.failure(twitterException);
            }
        }

        public void success(Result<TwitterCollection> result) {
            TimelineResult timelineResult;
            TimelineCursor timelineCursor = CollectionTimeline.getTimelineCursor((TwitterCollection) result.data);
            List<Tweet> orderedTweets = CollectionTimeline.getOrderedTweets((TwitterCollection) result.data);
            if (timelineCursor != null) {
                timelineResult = new TimelineResult(timelineCursor, orderedTweets);
            } else {
                timelineResult = new TimelineResult((TimelineCursor) null, Collections.emptyList());
            }
            Callback<TimelineResult<Tweet>> callback = this.f51208cb;
            if (callback != null) {
                callback.success(new Result(timelineResult, result.response));
            }
        }
    }

    public CollectionTimeline(TwitterCore twitterCore2, Long l11, Integer num) {
        if (l11 == null) {
            this.collectionIdentifier = null;
        } else {
            this.collectionIdentifier = COLLECTION_PREFIX + Long.toString(l11.longValue());
        }
        this.twitterCore = twitterCore2;
        this.maxItemsPerRequest = num;
    }

    public static List<Tweet> getOrderedTweets(TwitterCollection twitterCollection) {
        TwitterCollection.Content content;
        Map<Long, Tweet> map;
        TwitterCollection.Metadata metadata;
        if (twitterCollection == null || (content = twitterCollection.contents) == null || (map = content.tweetMap) == null || content.userMap == null || map.isEmpty() || twitterCollection.contents.userMap.isEmpty() || (metadata = twitterCollection.metadata) == null || metadata.timelineItems == null || metadata.position == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (TwitterCollection.TimelineItem timelineItem : twitterCollection.metadata.timelineItems) {
            arrayList.add(mapTweetToUsers(twitterCollection.contents.tweetMap.get(timelineItem.tweetItem.f51200id), twitterCollection.contents.userMap));
        }
        return arrayList;
    }

    public static TimelineCursor getTimelineCursor(TwitterCollection twitterCollection) {
        TwitterCollection.Metadata metadata;
        TwitterCollection.Metadata.Position position;
        if (twitterCollection == null || (metadata = twitterCollection.metadata) == null || (position = metadata.position) == null) {
            return null;
        }
        return new TimelineCursor(position.minPosition, position.maxPosition);
    }

    public static Tweet mapTweetToUsers(Tweet tweet, Map<Long, User> map) {
        TweetBuilder user = new TweetBuilder().copy(tweet).setUser(map.get(Long.valueOf(tweet.user.f51201id)));
        Tweet tweet2 = tweet.quotedStatus;
        if (tweet2 != null) {
            user.setQuotedStatus(mapTweetToUsers(tweet2, map));
        }
        return user.build();
    }

    public Call<TwitterCollection> createCollectionRequest(Long l11, Long l12) {
        return this.twitterCore.getApiClient().getCollectionService().collection(this.collectionIdentifier, this.maxItemsPerRequest, l12, l11);
    }

    public void next(Long l11, Callback<TimelineResult<Tweet>> callback) {
        createCollectionRequest(l11, (Long) null).enqueue(new CollectionCallback(callback));
    }

    public void previous(Long l11, Callback<TimelineResult<Tweet>> callback) {
        createCollectionRequest((Long) null, l11).enqueue(new CollectionCallback(callback));
    }

    public static class Builder {
        private Long collectionId;
        private Integer maxItemsPerRequest;
        private final TwitterCore twitterCore;

        public Builder() {
            this.maxItemsPerRequest = 30;
            this.twitterCore = TwitterCore.getInstance();
        }

        public CollectionTimeline build() {
            Long l11 = this.collectionId;
            if (l11 != null) {
                return new CollectionTimeline(this.twitterCore, l11, this.maxItemsPerRequest);
            }
            throw new IllegalStateException("collection id must not be null");
        }

        public Builder id(Long l11) {
            this.collectionId = l11;
            return this;
        }

        public Builder maxItemsPerRequest(Integer num) {
            this.maxItemsPerRequest = num;
            return this;
        }

        public Builder(TwitterCore twitterCore2) {
            this.maxItemsPerRequest = 30;
            this.twitterCore = twitterCore2;
        }
    }
}
