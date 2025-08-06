package com.twitter.sdk.android.core.models;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class TweetEntities {
    public static final TweetEntities EMPTY = new TweetEntities((List<UrlEntity>) null, (List<MentionEntity>) null, (List<MediaEntity>) null, (List<HashtagEntity>) null, (List<SymbolEntity>) null);
    @SerializedName("hashtags")
    public final List<HashtagEntity> hashtags;
    @SerializedName("media")
    public final List<MediaEntity> media;
    @SerializedName("symbols")
    public final List<SymbolEntity> symbols;
    @SerializedName("urls")
    public final List<UrlEntity> urls;
    @SerializedName("user_mentions")
    public final List<MentionEntity> userMentions;

    private TweetEntities() {
        this((List<UrlEntity>) null, (List<MentionEntity>) null, (List<MediaEntity>) null, (List<HashtagEntity>) null, (List<SymbolEntity>) null);
    }

    public TweetEntities(List<UrlEntity> list, List<MentionEntity> list2, List<MediaEntity> list3, List<HashtagEntity> list4, List<SymbolEntity> list5) {
        this.urls = ModelUtils.getSafeList(list);
        this.userMentions = ModelUtils.getSafeList(list2);
        this.media = ModelUtils.getSafeList(list3);
        this.hashtags = ModelUtils.getSafeList(list4);
        this.symbols = ModelUtils.getSafeList(list5);
    }
}
