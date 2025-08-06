package com.huobi.social.share.twitterapi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;
import com.twitter.sdk.android.tweetcomposer.TweetUploadService;

public class TwitterResultReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
        if (TweetUploadService.UPLOAD_SUCCESS.equals(intent.getAction())) {
            intent.getExtras().getLong(TweetUploadService.EXTRA_TWEET_ID);
        } else {
            Intent intent2 = (Intent) intent.getExtras().getParcelable(TweetUploadService.EXTRA_RETRY_INTENT);
        }
    }
}
