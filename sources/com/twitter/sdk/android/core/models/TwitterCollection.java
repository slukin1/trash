package com.twitter.sdk.android.core.models;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;

public class TwitterCollection {
    @SerializedName("objects")
    public final Content contents;
    @SerializedName("response")
    public final Metadata metadata;

    public static final class Content {
        @SerializedName("tweets")
        public final Map<Long, Tweet> tweetMap;
        @SerializedName("users")
        public final Map<Long, User> userMap;

        public Content(Map<Long, Tweet> map, Map<Long, User> map2) {
            this.tweetMap = ModelUtils.getSafeMap(map);
            this.userMap = ModelUtils.getSafeMap(map2);
        }
    }

    public static final class Metadata {
        @SerializedName("position")
        public final Position position;
        @SerializedName("timeline_id")
        public final String timelineId;
        @SerializedName("timeline")
        public final List<TimelineItem> timelineItems;

        public static final class Position {
            @SerializedName("max_position")
            public final Long maxPosition;
            @SerializedName("min_position")
            public final Long minPosition;

            public Position(Long l11, Long l12) {
                this.maxPosition = l11;
                this.minPosition = l12;
            }
        }

        public Metadata(String str, Position position2, List<TimelineItem> list) {
            this.timelineId = str;
            this.position = position2;
            this.timelineItems = list;
        }
    }

    public static class TimelineItem {
        @SerializedName("tweet")
        public final TweetItem tweetItem;

        public static final class TweetItem {
            @SerializedName("id")

            /* renamed from: id  reason: collision with root package name */
            public final Long f51200id;

            public TweetItem(Long l11) {
                this.f51200id = l11;
            }
        }

        public TimelineItem(TweetItem tweetItem2) {
            this.tweetItem = tweetItem2;
        }
    }

    public TwitterCollection(Content content, Metadata metadata2) {
        this.contents = content;
        this.metadata = metadata2;
    }
}
