package com.twitter.sdk.android.tweetui;

import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.models.Search;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.core.services.params.Geocode;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import retrofit2.Call;

public class SearchTimeline extends BaseTimeline implements Timeline<Tweet> {
    public static final String FILTER_RETWEETS = " -filter:retweets";
    /* access modifiers changed from: private */
    public static final SimpleDateFormat QUERY_DATE = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
    public final Geocode geocode;
    public final String languageCode;
    public final Integer maxItemsPerRequest;
    public final String query;
    public final String resultType;
    public final TwitterCore twitterCore;
    public final String untilDate;

    public enum ResultType {
        RECENT("recent"),
        POPULAR("popular"),
        MIXED("mixed"),
        FILTERED("filtered");
        
        public final String type;

        private ResultType(String str) {
            this.type = str;
        }
    }

    public class SearchCallback extends Callback<Search> {

        /* renamed from: cb  reason: collision with root package name */
        public final Callback<TimelineResult<Tweet>> f51212cb;

        public SearchCallback(Callback<TimelineResult<Tweet>> callback) {
            this.f51212cb = callback;
        }

        public void failure(TwitterException twitterException) {
            Callback<TimelineResult<Tweet>> callback = this.f51212cb;
            if (callback != null) {
                callback.failure(twitterException);
            }
        }

        public void success(Result<Search> result) {
            List<Tweet> list = ((Search) result.data).tweets;
            TimelineResult timelineResult = new TimelineResult(new TimelineCursor(list), list);
            Callback<TimelineResult<Tweet>> callback = this.f51212cb;
            if (callback != null) {
                callback.success(new Result(timelineResult, result.response));
            }
        }
    }

    public SearchTimeline(TwitterCore twitterCore2, String str, Geocode geocode2, String str2, String str3, Integer num, String str4) {
        String str5;
        this.twitterCore = twitterCore2;
        this.languageCode = str3;
        this.maxItemsPerRequest = num;
        this.untilDate = str4;
        this.resultType = str2;
        if (str == null) {
            str5 = null;
        } else {
            str5 = str + FILTER_RETWEETS;
        }
        this.query = str5;
        this.geocode = geocode2;
    }

    public Call<Search> createSearchRequest(Long l11, Long l12) {
        return this.twitterCore.getApiClient().getSearchService().tweets(this.query, this.geocode, this.languageCode, (String) null, this.resultType, this.maxItemsPerRequest, this.untilDate, l11, l12, Boolean.TRUE);
    }

    public void next(Long l11, Callback<TimelineResult<Tweet>> callback) {
        createSearchRequest(l11, (Long) null).enqueue(new SearchCallback(callback));
    }

    public void previous(Long l11, Callback<TimelineResult<Tweet>> callback) {
        createSearchRequest((Long) null, BaseTimeline.decrementMaxId(l11)).enqueue(new SearchCallback(callback));
    }

    public static class Builder {
        private Geocode geocode;
        private String lang;
        private Integer maxItemsPerRequest;
        private String query;
        private String resultType;
        private final TwitterCore twitterCore;
        private String untilDate;

        public Builder() {
            this.resultType = ResultType.FILTERED.type;
            this.maxItemsPerRequest = 30;
            this.twitterCore = TwitterCore.getInstance();
        }

        public SearchTimeline build() {
            if (this.query != null) {
                return new SearchTimeline(this.twitterCore, this.query, this.geocode, this.resultType, this.lang, this.maxItemsPerRequest, this.untilDate);
            }
            throw new IllegalStateException("query must not be null");
        }

        public Builder geocode(Geocode geocode2) {
            this.geocode = geocode2;
            return this;
        }

        public Builder languageCode(String str) {
            this.lang = str;
            return this;
        }

        public Builder maxItemsPerRequest(Integer num) {
            this.maxItemsPerRequest = num;
            return this;
        }

        public Builder query(String str) {
            this.query = str;
            return this;
        }

        public Builder resultType(ResultType resultType2) {
            this.resultType = resultType2.type;
            return this;
        }

        public Builder untilDate(Date date) {
            this.untilDate = SearchTimeline.QUERY_DATE.format(date);
            return this;
        }

        public Builder(TwitterCore twitterCore2) {
            this.resultType = ResultType.FILTERED.type;
            this.maxItemsPerRequest = 30;
            this.twitterCore = twitterCore2;
        }
    }
}
