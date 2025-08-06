package com.twitter.sdk.android.tweetcomposer;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;
import com.twitter.Regex;
import com.twitter.sdk.android.core.TwitterAuthToken;
import com.twitter.sdk.android.core.TwitterSession;

public class ComposerActivity extends Activity {
    public static final String EXTRA_HASHTAGS = "EXTRA_HASHTAGS";
    public static final String EXTRA_IMAGE_URI = "EXTRA_IMAGE_URI";
    public static final String EXTRA_TEXT = "EXTRA_TEXT";
    public static final String EXTRA_THEME = "EXTRA_THEME";
    public static final String EXTRA_USER_TOKEN = "EXTRA_USER_TOKEN";
    private static final int PLACEHOLDER_ID = -1;
    private static final String PLACEHOLDER_SCREEN_NAME = "";
    private ComposerController composerController;

    public static class Builder {
        private final Context context;
        private String hashtags;
        private Uri imageUri;
        private String text;
        private int themeResId = R.style.ComposerLight;
        private TwitterAuthToken token;

        public Builder(Context context2) {
            if (context2 != null) {
                this.context = context2;
                return;
            }
            throw new IllegalArgumentException("Context must not be null");
        }

        public Intent createIntent() {
            if (this.token != null) {
                Intent intent = new Intent(this.context, ComposerActivity.class);
                intent.putExtra("EXTRA_USER_TOKEN", this.token);
                intent.putExtra("EXTRA_IMAGE_URI", this.imageUri);
                intent.putExtra(ComposerActivity.EXTRA_THEME, this.themeResId);
                intent.putExtra(ComposerActivity.EXTRA_TEXT, this.text);
                intent.putExtra(ComposerActivity.EXTRA_HASHTAGS, this.hashtags);
                return intent;
            }
            throw new IllegalStateException("Must set a TwitterSession");
        }

        public Builder darkTheme() {
            this.themeResId = R.style.ComposerDark;
            return this;
        }

        public Builder hashtags(String... strArr) {
            if (strArr == null) {
                return this;
            }
            StringBuilder sb2 = new StringBuilder();
            for (String str : strArr) {
                if (Regex.f51164e.matcher(str).find()) {
                    if (sb2.length() > 0) {
                        sb2.append(" ");
                    }
                    sb2.append(str);
                }
            }
            this.hashtags = sb2.length() == 0 ? null : sb2.toString();
            return this;
        }

        public Builder image(Uri uri) {
            this.imageUri = uri;
            return this;
        }

        public Builder session(TwitterSession twitterSession) {
            if (twitterSession != null) {
                TwitterAuthToken twitterAuthToken = (TwitterAuthToken) twitterSession.getAuthToken();
                if (twitterAuthToken != null) {
                    this.token = twitterAuthToken;
                    return this;
                }
                throw new IllegalArgumentException("TwitterSession token must not be null");
            }
            throw new IllegalArgumentException("TwitterSession must not be null");
        }

        public Builder text(String str) {
            this.text = str;
            return this;
        }
    }

    public interface Finisher {
        void finish();
    }

    public class FinisherImpl implements Finisher {
        public FinisherImpl() {
        }

        public void finish() {
            ComposerActivity.this.finish();
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
        this.composerController.onClose();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra(EXTRA_TEXT);
        String stringExtra2 = intent.getStringExtra(EXTRA_HASHTAGS);
        setTheme(intent.getIntExtra(EXTRA_THEME, R.style.ComposerLight));
        setContentView(R.layout.tw__activity_composer);
        this.composerController = new ComposerController((ComposerView) findViewById(R.id.tw__composer_view), new TwitterSession((TwitterAuthToken) intent.getParcelableExtra("EXTRA_USER_TOKEN"), -1, ""), (Uri) intent.getParcelableExtra("EXTRA_IMAGE_URI"), stringExtra, stringExtra2, new FinisherImpl());
    }

    @SensorsDataInstrumented
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        PushAutoTrackHelper.onNewIntent(this, intent);
    }
}
