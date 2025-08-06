package com.twitter.sdk.android.tweetui;

import android.os.Handler;
import android.text.TextUtils;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.SessionManager;
import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.core.TwitterAuthException;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.models.Tweet;
import com.xiaomi.mipush.sdk.Constants;
import i0.b;
import java.util.List;
import retrofit2.Response;

class TweetRepository {
    private static final int DEFAULT_CACHE_SIZE = 20;
    public final b<Long, FormattedTweetText> formatCache;
    private final Handler mainHandler;
    public final b<Long, Tweet> tweetCache;
    /* access modifiers changed from: private */
    public final TwitterCore twitterCore;
    private final SessionManager<TwitterSession> userSessionManagers;

    public class MultiTweetsCallback extends Callback<List<Tweet>> {

        /* renamed from: cb  reason: collision with root package name */
        public final Callback<List<Tweet>> f51213cb;
        public final List<Long> tweetIds;

        public MultiTweetsCallback(List<Long> list, Callback<List<Tweet>> callback) {
            this.f51213cb = callback;
            this.tweetIds = list;
        }

        public void failure(TwitterException twitterException) {
            this.f51213cb.failure(twitterException);
        }

        public void success(Result<List<Tweet>> result) {
            if (this.f51213cb != null) {
                this.f51213cb.success(new Result(Utils.orderTweets(this.tweetIds, (List) result.data), result.response));
            }
        }
    }

    public class SingleTweetCallback extends Callback<Tweet> {

        /* renamed from: cb  reason: collision with root package name */
        public final Callback<Tweet> f51214cb;

        public SingleTweetCallback(Callback<Tweet> callback) {
            this.f51214cb = callback;
        }

        public void failure(TwitterException twitterException) {
            this.f51214cb.failure(twitterException);
        }

        public void success(Result<Tweet> result) {
            Tweet tweet = (Tweet) result.data;
            TweetRepository.this.updateCache(tweet);
            Callback<Tweet> callback = this.f51214cb;
            if (callback != null) {
                callback.success(new Result(tweet, result.response));
            }
        }
    }

    public TweetRepository(Handler handler, SessionManager<TwitterSession> sessionManager) {
        this(handler, sessionManager, TwitterCore.getInstance());
    }

    private void deliverTweet(Tweet tweet, Callback<Tweet> callback) {
        if (callback != null) {
            this.mainHandler.post(new k(callback, tweet));
        }
    }

    public void favorite(long j11, Callback<Tweet> callback) {
        final long j12 = j11;
        final Callback<Tweet> callback2 = callback;
        getUserSession(new LoggingCallback<TwitterSession>(callback, Twitter.getLogger()) {
            public void success(Result<TwitterSession> result) {
                TweetRepository.this.twitterCore.getApiClient((TwitterSession) result.data).getFavoriteService().create(Long.valueOf(j12), Boolean.FALSE).enqueue(callback2);
            }
        });
    }

    public FormattedTweetText formatTweetText(Tweet tweet) {
        if (tweet == null) {
            return null;
        }
        FormattedTweetText formattedTweetText = this.formatCache.get(Long.valueOf(tweet.f51198id));
        if (formattedTweetText != null) {
            return formattedTweetText;
        }
        FormattedTweetText formatTweetText = TweetTextUtils.formatTweetText(tweet);
        if (formatTweetText != null && !TextUtils.isEmpty(formatTweetText.text)) {
            this.formatCache.put(Long.valueOf(tweet.f51198id), formatTweetText);
        }
        return formatTweetText;
    }

    public void getUserSession(Callback<TwitterSession> callback) {
        TwitterSession activeSession = this.userSessionManagers.getActiveSession();
        if (activeSession == null) {
            callback.failure(new TwitterAuthException("User authorization required"));
        } else {
            callback.success(new Result(activeSession, (Response) null));
        }
    }

    public void loadTweet(long j11, Callback<Tweet> callback) {
        Tweet tweet = this.tweetCache.get(Long.valueOf(j11));
        if (tweet != null) {
            deliverTweet(tweet, callback);
        } else {
            this.twitterCore.getApiClient().getStatusesService().show(Long.valueOf(j11), (Boolean) null, (Boolean) null, (Boolean) null).enqueue(new SingleTweetCallback(callback));
        }
    }

    public void loadTweets(List<Long> list, Callback<List<Tweet>> callback) {
        this.twitterCore.getApiClient().getStatusesService().lookup(TextUtils.join(Constants.ACCEPT_TIME_SEPARATOR_SP, list), (Boolean) null, (Boolean) null, (Boolean) null).enqueue(new MultiTweetsCallback(list, callback));
    }

    public void retweet(long j11, Callback<Tweet> callback) {
        final long j12 = j11;
        final Callback<Tweet> callback2 = callback;
        getUserSession(new LoggingCallback<TwitterSession>(callback, Twitter.getLogger()) {
            public void success(Result<TwitterSession> result) {
                TweetRepository.this.twitterCore.getApiClient((TwitterSession) result.data).getStatusesService().retweet(Long.valueOf(j12), Boolean.FALSE).enqueue(callback2);
            }
        });
    }

    public void unfavorite(long j11, Callback<Tweet> callback) {
        final long j12 = j11;
        final Callback<Tweet> callback2 = callback;
        getUserSession(new LoggingCallback<TwitterSession>(callback, Twitter.getLogger()) {
            public void success(Result<TwitterSession> result) {
                TweetRepository.this.twitterCore.getApiClient((TwitterSession) result.data).getFavoriteService().destroy(Long.valueOf(j12), Boolean.FALSE).enqueue(callback2);
            }
        });
    }

    public void unretweet(long j11, Callback<Tweet> callback) {
        final long j12 = j11;
        final Callback<Tweet> callback2 = callback;
        getUserSession(new LoggingCallback<TwitterSession>(callback, Twitter.getLogger()) {
            public void success(Result<TwitterSession> result) {
                TweetRepository.this.twitterCore.getApiClient((TwitterSession) result.data).getStatusesService().unretweet(Long.valueOf(j12), Boolean.FALSE).enqueue(callback2);
            }
        });
    }

    public void updateCache(Tweet tweet) {
        this.tweetCache.put(Long.valueOf(tweet.f51198id), tweet);
    }

    public TweetRepository(Handler handler, SessionManager<TwitterSession> sessionManager, TwitterCore twitterCore2) {
        this.twitterCore = twitterCore2;
        this.mainHandler = handler;
        this.userSessionManagers = sessionManager;
        this.tweetCache = new b<>(20);
        this.formatCache = new b<>(20);
    }
}
