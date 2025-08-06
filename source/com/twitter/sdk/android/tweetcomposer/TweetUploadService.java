package com.twitter.sdk.android.tweetcomposer;

import android.app.IntentService;
import android.content.Intent;
import android.net.Uri;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.core.TwitterApiClient;
import com.twitter.sdk.android.core.TwitterAuthToken;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.models.Media;
import com.twitter.sdk.android.core.models.Tweet;
import java.io.File;
import okhttp3.MediaType;
import okhttp3.RequestBody;

public class TweetUploadService extends IntentService {
    public static final String EXTRA_IMAGE_URI = "EXTRA_IMAGE_URI";
    public static final String EXTRA_RETRY_INTENT = "EXTRA_RETRY_INTENT";
    public static final String EXTRA_TWEET_ID = "EXTRA_TWEET_ID";
    public static final String EXTRA_TWEET_TEXT = "EXTRA_TWEET_TEXT";
    public static final String EXTRA_USER_TOKEN = "EXTRA_USER_TOKEN";
    private static final int PLACEHOLDER_ID = -1;
    private static final String PLACEHOLDER_SCREEN_NAME = "";
    public static final String TAG = "TweetUploadService";
    public static final String TWEET_COMPOSE_CANCEL = "com.twitter.sdk.android.tweetcomposer.TWEET_COMPOSE_CANCEL";
    public static final String UPLOAD_FAILURE = "com.twitter.sdk.android.tweetcomposer.UPLOAD_FAILURE";
    public static final String UPLOAD_SUCCESS = "com.twitter.sdk.android.tweetcomposer.UPLOAD_SUCCESS";
    public DependencyProvider dependencyProvider;
    public Intent intent;

    public static class DependencyProvider {
        public TwitterApiClient getTwitterApiClient(TwitterSession twitterSession) {
            return TwitterCore.getInstance().getApiClient(twitterSession);
        }
    }

    public TweetUploadService() {
        this(new DependencyProvider());
    }

    public void fail(TwitterException twitterException) {
        sendFailureBroadcast(this.intent);
        Twitter.getLogger().e(TAG, "Post Tweet failed", twitterException);
        stopSelf();
    }

    public void onHandleIntent(Intent intent2) {
        this.intent = intent2;
        uploadTweet(new TwitterSession((TwitterAuthToken) intent2.getParcelableExtra("EXTRA_USER_TOKEN"), -1, ""), intent2.getStringExtra(EXTRA_TWEET_TEXT), (Uri) intent2.getParcelableExtra("EXTRA_IMAGE_URI"));
    }

    public void sendFailureBroadcast(Intent intent2) {
        Intent intent3 = new Intent(UPLOAD_FAILURE);
        intent3.putExtra(EXTRA_RETRY_INTENT, intent2);
        intent3.setPackage(getApplicationContext().getPackageName());
        sendBroadcast(intent3);
    }

    public void sendSuccessBroadcast(long j11) {
        Intent intent2 = new Intent(UPLOAD_SUCCESS);
        intent2.putExtra(EXTRA_TWEET_ID, j11);
        intent2.setPackage(getApplicationContext().getPackageName());
        sendBroadcast(intent2);
    }

    public void uploadMedia(TwitterSession twitterSession, Uri uri, Callback<Media> callback) {
        TwitterApiClient twitterApiClient = this.dependencyProvider.getTwitterApiClient(twitterSession);
        String path = FileUtils.getPath(this, uri);
        if (path == null) {
            fail(new TwitterException("Uri file path resolved to null"));
            return;
        }
        File file = new File(path);
        twitterApiClient.getMediaService().upload(RequestBody.create(MediaType.parse(FileUtils.getMimeType(file)), file), (RequestBody) null, (RequestBody) null).enqueue(callback);
    }

    public void uploadTweet(final TwitterSession twitterSession, final String str, Uri uri) {
        if (uri != null) {
            uploadMedia(twitterSession, uri, new Callback<Media>() {
                public void failure(TwitterException twitterException) {
                    TweetUploadService.this.fail(twitterException);
                }

                public void success(Result<Media> result) {
                    TweetUploadService.this.uploadTweetWithMedia(twitterSession, str, ((Media) result.data).mediaIdString);
                }
            });
        } else {
            uploadTweetWithMedia(twitterSession, str, (String) null);
        }
    }

    public void uploadTweetWithMedia(TwitterSession twitterSession, String str, String str2) {
        this.dependencyProvider.getTwitterApiClient(twitterSession).getStatusesService().update(str, (Long) null, (Boolean) null, (Double) null, (Double) null, (String) null, (Boolean) null, Boolean.TRUE, str2).enqueue(new Callback<Tweet>() {
            public void failure(TwitterException twitterException) {
                TweetUploadService.this.fail(twitterException);
            }

            public void success(Result<Tweet> result) {
                TweetUploadService.this.sendSuccessBroadcast(((Tweet) result.data).getId());
                TweetUploadService.this.stopSelf();
            }
        });
    }

    public TweetUploadService(DependencyProvider dependencyProvider2) {
        super(TAG);
        this.dependencyProvider = dependencyProvider2;
    }
}
