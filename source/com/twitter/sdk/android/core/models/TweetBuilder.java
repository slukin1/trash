package com.twitter.sdk.android.core.models;

import java.util.List;

public class TweetBuilder {
    private Card card;
    private Coordinates coordinates;
    private String createdAt;
    private Object currentUserRetweet;
    private List<Integer> displayTextRange;
    private TweetEntities entities;
    private TweetEntities extendedEntities;
    private Integer favoriteCount;
    private boolean favorited;
    private String filterLevel;

    /* renamed from: id  reason: collision with root package name */
    private long f51199id = -1;
    private String idStr;
    private String inReplyToScreenName;
    private long inReplyToStatusId;
    private String inReplyToStatusIdStr;
    private long inReplyToUserId;
    private String inReplyToUserIdStr;
    private String lang;
    private Place place;
    private boolean possiblySensitive;
    private Tweet quotedStatus;
    private long quotedStatusId;
    private String quotedStatusIdStr;
    private int retweetCount;
    private boolean retweeted;
    private Tweet retweetedStatus;
    private Object scopes;
    private String source;
    private String text;
    private boolean truncated;
    private User user;
    private boolean withheldCopyright;
    private List<String> withheldInCountries;
    private String withheldScope;

    public Tweet build() {
        return new Tweet(this.coordinates, this.createdAt, this.currentUserRetweet, this.entities, this.extendedEntities, this.favoriteCount, this.favorited, this.filterLevel, this.f51199id, this.idStr, this.inReplyToScreenName, this.inReplyToStatusId, this.inReplyToStatusIdStr, this.inReplyToUserId, this.inReplyToUserIdStr, this.lang, this.place, this.possiblySensitive, this.scopes, this.quotedStatusId, this.quotedStatusIdStr, this.quotedStatus, this.retweetCount, this.retweeted, this.retweetedStatus, this.source, this.text, this.displayTextRange, this.truncated, this.user, this.withheldCopyright, this.withheldInCountries, this.withheldScope, this.card);
    }

    public TweetBuilder copy(Tweet tweet) {
        this.coordinates = tweet.coordinates;
        this.createdAt = tweet.createdAt;
        this.currentUserRetweet = tweet.currentUserRetweet;
        this.entities = tweet.entities;
        this.extendedEntities = tweet.extendedEntities;
        this.favoriteCount = tweet.favoriteCount;
        this.favorited = tweet.favorited;
        this.filterLevel = tweet.filterLevel;
        this.f51199id = tweet.f51198id;
        this.idStr = tweet.idStr;
        this.inReplyToScreenName = tweet.inReplyToScreenName;
        this.inReplyToStatusId = tweet.inReplyToStatusId;
        String str = tweet.inReplyToStatusIdStr;
        this.inReplyToStatusIdStr = str;
        this.inReplyToUserId = tweet.inReplyToUserId;
        this.inReplyToUserIdStr = str;
        this.lang = tweet.lang;
        this.place = tweet.place;
        this.possiblySensitive = tweet.possiblySensitive;
        this.scopes = tweet.scopes;
        this.quotedStatusId = tweet.quotedStatusId;
        this.quotedStatusIdStr = tweet.quotedStatusIdStr;
        this.quotedStatus = tweet.quotedStatus;
        this.retweetCount = tweet.retweetCount;
        this.retweeted = tweet.retweeted;
        this.retweetedStatus = tweet.retweetedStatus;
        this.source = tweet.source;
        this.text = tweet.text;
        this.displayTextRange = tweet.displayTextRange;
        this.truncated = tweet.truncated;
        this.user = tweet.user;
        this.withheldCopyright = tweet.withheldCopyright;
        this.withheldInCountries = tweet.withheldInCountries;
        this.withheldScope = tweet.withheldScope;
        this.card = tweet.card;
        return this;
    }

    public TweetBuilder setCard(Card card2) {
        this.card = card2;
        return this;
    }

    public TweetBuilder setCoordinates(Coordinates coordinates2) {
        this.coordinates = coordinates2;
        return this;
    }

    public TweetBuilder setCreatedAt(String str) {
        this.createdAt = str;
        return this;
    }

    public TweetBuilder setCurrentUserRetweet(Object obj) {
        this.currentUserRetweet = obj;
        return this;
    }

    public TweetBuilder setDisplayTextRange(List<Integer> list) {
        this.displayTextRange = list;
        return this;
    }

    public TweetBuilder setEntities(TweetEntities tweetEntities) {
        this.entities = tweetEntities;
        return this;
    }

    public TweetBuilder setExtendedEntities(TweetEntities tweetEntities) {
        this.extendedEntities = tweetEntities;
        return this;
    }

    public TweetBuilder setFavoriteCount(Integer num) {
        this.favoriteCount = num;
        return this;
    }

    public TweetBuilder setFavorited(boolean z11) {
        this.favorited = z11;
        return this;
    }

    public TweetBuilder setFilterLevel(String str) {
        this.filterLevel = str;
        return this;
    }

    public TweetBuilder setId(long j11) {
        this.f51199id = j11;
        return this;
    }

    public TweetBuilder setIdStr(String str) {
        this.idStr = str;
        return this;
    }

    public TweetBuilder setInReplyToScreenName(String str) {
        this.inReplyToScreenName = str;
        return this;
    }

    public TweetBuilder setInReplyToStatusId(long j11) {
        this.inReplyToStatusId = j11;
        return this;
    }

    public TweetBuilder setInReplyToStatusIdStr(String str) {
        this.inReplyToStatusIdStr = str;
        return this;
    }

    public TweetBuilder setInReplyToUserId(long j11) {
        this.inReplyToUserId = j11;
        return this;
    }

    public TweetBuilder setInReplyToUserIdStr(String str) {
        this.inReplyToUserIdStr = str;
        return this;
    }

    public TweetBuilder setLang(String str) {
        this.lang = str;
        return this;
    }

    public TweetBuilder setPlace(Place place2) {
        this.place = place2;
        return this;
    }

    public TweetBuilder setPossiblySensitive(boolean z11) {
        this.possiblySensitive = z11;
        return this;
    }

    public TweetBuilder setQuotedStatus(Tweet tweet) {
        this.quotedStatus = tweet;
        return this;
    }

    public TweetBuilder setQuotedStatusId(long j11) {
        this.quotedStatusId = j11;
        return this;
    }

    public TweetBuilder setQuotedStatusIdStr(String str) {
        this.quotedStatusIdStr = str;
        return this;
    }

    public TweetBuilder setRetweetCount(int i11) {
        this.retweetCount = i11;
        return this;
    }

    public TweetBuilder setRetweeted(boolean z11) {
        this.retweeted = z11;
        return this;
    }

    public TweetBuilder setRetweetedStatus(Tweet tweet) {
        this.retweetedStatus = tweet;
        return this;
    }

    public TweetBuilder setScopes(Object obj) {
        this.scopes = obj;
        return this;
    }

    public TweetBuilder setSource(String str) {
        this.source = str;
        return this;
    }

    public TweetBuilder setText(String str) {
        this.text = str;
        return this;
    }

    public TweetBuilder setTruncated(boolean z11) {
        this.truncated = z11;
        return this;
    }

    public TweetBuilder setUser(User user2) {
        this.user = user2;
        return this;
    }

    public TweetBuilder setWithheldCopyright(boolean z11) {
        this.withheldCopyright = z11;
        return this;
    }

    public TweetBuilder setWithheldInCountries(List<String> list) {
        this.withheldInCountries = list;
        return this;
    }

    public TweetBuilder setWithheldScope(String str) {
        this.withheldScope = str;
        return this;
    }
}
