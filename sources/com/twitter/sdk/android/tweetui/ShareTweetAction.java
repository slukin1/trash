package com.twitter.sdk.android.tweetui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.twitter.sdk.android.core.IntentUtils;
import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.core.models.User;

class ShareTweetAction implements View.OnClickListener {
    public final Tweet tweet;
    public final TweetUi tweetUi;

    public ShareTweetAction(Tweet tweet2, TweetUi tweetUi2) {
        this.tweet = tweet2;
        this.tweetUi = tweetUi2;
    }

    public String getShareContent(Resources resources) {
        int i11 = R.string.tw__share_content_format;
        Tweet tweet2 = this.tweet;
        return resources.getString(i11, new Object[]{tweet2.user.screenName, Long.toString(tweet2.f51198id)});
    }

    public Intent getShareIntent(String str, String str2) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.SUBJECT", str);
        intent.putExtra("android.intent.extra.TEXT", str2);
        intent.setType("text/plain");
        return intent;
    }

    public String getShareSubject(Resources resources) {
        int i11 = R.string.tw__share_subject_format;
        User user = this.tweet.user;
        return resources.getString(i11, new Object[]{user.name, user.screenName});
    }

    public void launchShareIntent(Intent intent, Context context) {
        if (!IntentUtils.safeStartActivity(context, intent)) {
            Twitter.getLogger().e("TweetUi", "Activity cannot be found to handle share intent");
        }
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        onClick(view.getContext(), view.getResources());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void onClick(Context context, Resources resources) {
        Tweet tweet2 = this.tweet;
        if (tweet2 != null && tweet2.user != null) {
            launchShareIntent(Intent.createChooser(getShareIntent(getShareSubject(resources), getShareContent(resources)), resources.getString(R.string.tw__share_tweet)), context);
        }
    }
}
