package com.twitter.sdk.android.tweetui;

import android.net.Uri;
import android.text.TextUtils;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.core.models.Tweet;
import java.util.List;
import java.util.Locale;

public final class TweetUtils {
    private static final String HASHTAG_URL = "https://twitter.com/hashtag/%s?ref_src=twsrc%%5Etwitterkit";
    public static final String LOAD_TWEET_DEBUG = "loadTweet failure for Tweet Id %d.";
    private static final String PROFILE_URL = "https://twitter.com/%s?ref_src=twsrc%%5Etwitterkit";
    private static final String SYMBOL_URL = "https://twitter.com/search?q=%%24%s&ref_src=twsrc%%5Etwitterkit";
    private static final String TWEET_URL = "https://twitter.com/%s/status/%d?ref_src=twsrc%%5Etwitterkit";
    private static final String TWITTER_KIT_REF = "ref_src=twsrc%%5Etwitterkit";
    private static final String TWITTER_URL = "https://twitter.com/";
    private static final String UNKNOWN_SCREEN_NAME = "twitter_unknown";

    private TweetUtils() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r0 = r1.retweetedStatus;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.twitter.sdk.android.core.models.Tweet getDisplayTweet(com.twitter.sdk.android.core.models.Tweet r1) {
        /*
            if (r1 == 0) goto L_0x0008
            com.twitter.sdk.android.core.models.Tweet r0 = r1.retweetedStatus
            if (r0 != 0) goto L_0x0007
            goto L_0x0008
        L_0x0007:
            return r0
        L_0x0008:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.twitter.sdk.android.tweetui.TweetUtils.getDisplayTweet(com.twitter.sdk.android.core.models.Tweet):com.twitter.sdk.android.core.models.Tweet");
    }

    public static String getHashtagPermalink(String str) {
        return String.format(Locale.US, HASHTAG_URL, new Object[]{str});
    }

    public static Uri getPermalink(String str, long j11) {
        String str2;
        if (j11 <= 0) {
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            str2 = String.format(Locale.US, TWEET_URL, new Object[]{UNKNOWN_SCREEN_NAME, Long.valueOf(j11)});
        } else {
            str2 = String.format(Locale.US, TWEET_URL, new Object[]{str, Long.valueOf(j11)});
        }
        return Uri.parse(str2);
    }

    public static String getProfilePermalink(String str) {
        if (TextUtils.isEmpty(str)) {
            return String.format(Locale.US, PROFILE_URL, new Object[]{UNKNOWN_SCREEN_NAME});
        }
        return String.format(Locale.US, PROFILE_URL, new Object[]{str});
    }

    public static String getSymbolPermalink(String str) {
        return String.format(Locale.US, SYMBOL_URL, new Object[]{str});
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000a, code lost:
        r4 = r4.user;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isTweetResolvable(com.twitter.sdk.android.core.models.Tweet r4) {
        /*
            if (r4 == 0) goto L_0x0018
            long r0 = r4.f51198id
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 <= 0) goto L_0x0018
            com.twitter.sdk.android.core.models.User r4 = r4.user
            if (r4 == 0) goto L_0x0018
            java.lang.String r4 = r4.screenName
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x0018
            r4 = 1
            goto L_0x0019
        L_0x0018:
            r4 = 0
        L_0x0019:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.twitter.sdk.android.tweetui.TweetUtils.isTweetResolvable(com.twitter.sdk.android.core.models.Tweet):boolean");
    }

    public static void loadTweet(long j11, final Callback<Tweet> callback) {
        TweetUi.getInstance().getTweetRepository().loadTweet(j11, new LoggingCallback<Tweet>(Twitter.getLogger(), callback) {
            public void success(Result<Tweet> result) {
                Callback callback = callback;
                if (callback != null) {
                    callback.success(result);
                }
            }
        });
    }

    public static void loadTweets(List<Long> list, final Callback<List<Tweet>> callback) {
        TweetUi.getInstance().getTweetRepository().loadTweets(list, new LoggingCallback<List<Tweet>>(Twitter.getLogger(), callback) {
            public void success(Result<List<Tweet>> result) {
                Callback callback = callback;
                if (callback != null) {
                    callback.success(result);
                }
            }
        });
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000c, code lost:
        r1 = (r1 = r1.entities).media;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean showQuoteTweet(com.twitter.sdk.android.core.models.Tweet r1) {
        /*
            com.twitter.sdk.android.core.models.Tweet r0 = r1.quotedStatus
            if (r0 == 0) goto L_0x0018
            com.twitter.sdk.android.core.models.Card r0 = r1.card
            if (r0 != 0) goto L_0x0018
            com.twitter.sdk.android.core.models.TweetEntities r1 = r1.entities
            if (r1 == 0) goto L_0x0016
            java.util.List<com.twitter.sdk.android.core.models.MediaEntity> r1 = r1.media
            if (r1 == 0) goto L_0x0016
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x0018
        L_0x0016:
            r1 = 1
            goto L_0x0019
        L_0x0018:
            r1 = 0
        L_0x0019:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.twitter.sdk.android.tweetui.TweetUtils.showQuoteTweet(com.twitter.sdk.android.core.models.Tweet):boolean");
    }
}
