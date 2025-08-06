package com.twitter.sdk.android.tweetcomposer;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.twitter.sdk.android.core.GuestSessionProvider;
import com.twitter.sdk.android.core.SessionManager;
import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.internal.network.UrlUtils;
import java.net.URL;

public class TweetComposer {
    private static final String MIME_TYPE_JPEG = "image/jpeg";
    private static final String MIME_TYPE_PLAIN_TEXT = "text/plain";
    private static final String TWITTER_PACKAGE_NAME = "com.twitter.android";
    private static final String WEB_INTENT = "https://twitter.com/intent/tweet?text=%s&url=%s";
    @SuppressLint({"StaticFieldLeak"})
    public static volatile TweetComposer instance;
    public Context context = Twitter.getInstance().getContext(getIdentifier());
    public GuestSessionProvider guestSessionProvider = TwitterCore.getInstance().getGuestSessionProvider();
    public SessionManager<TwitterSession> sessionManager = TwitterCore.getInstance().getSessionManager();

    public static class Builder {
        private final Context context;
        private Uri imageUri;
        private String text;
        private URL url;

        public Builder(Context context2) {
            if (context2 != null) {
                this.context = context2;
                return;
            }
            throw new IllegalArgumentException("Context must not be null.");
        }

        public Intent createIntent() {
            Intent createTwitterIntent = createTwitterIntent();
            return createTwitterIntent == null ? createWebIntent() : createTwitterIntent;
        }

        public Intent createTwitterIntent() {
            Intent intent = new Intent("android.intent.action.SEND");
            StringBuilder sb2 = new StringBuilder();
            if (!TextUtils.isEmpty(this.text)) {
                sb2.append(this.text);
            }
            if (this.url != null) {
                if (sb2.length() > 0) {
                    sb2.append(' ');
                }
                sb2.append(this.url.toString());
            }
            intent.putExtra("android.intent.extra.TEXT", sb2.toString());
            intent.setType(TweetComposer.MIME_TYPE_PLAIN_TEXT);
            Uri uri = this.imageUri;
            if (uri != null) {
                intent.putExtra("android.intent.extra.STREAM", uri);
                intent.setType("image/jpeg");
            }
            for (ResolveInfo next : this.context.getPackageManager().queryIntentActivities(intent, 65536)) {
                if (next.activityInfo.packageName.startsWith("com.twitter.android")) {
                    ActivityInfo activityInfo = next.activityInfo;
                    intent.setClassName(activityInfo.packageName, activityInfo.name);
                    return intent;
                }
            }
            return null;
        }

        public Intent createWebIntent() {
            URL url2 = this.url;
            return new Intent("android.intent.action.VIEW", Uri.parse(String.format(TweetComposer.WEB_INTENT, new Object[]{UrlUtils.urlEncode(this.text), UrlUtils.urlEncode(url2 == null ? "" : url2.toString())})));
        }

        public Builder image(Uri uri) {
            if (uri == null) {
                throw new IllegalArgumentException("imageUri must not be null.");
            } else if (this.imageUri == null) {
                this.imageUri = uri;
                return this;
            } else {
                throw new IllegalStateException("imageUri already set.");
            }
        }

        public void show() {
            this.context.startActivity(createIntent());
        }

        public Builder text(String str) {
            if (str == null) {
                throw new IllegalArgumentException("text must not be null.");
            } else if (this.text == null) {
                this.text = str;
                return this;
            } else {
                throw new IllegalStateException("text already set.");
            }
        }

        public Builder url(URL url2) {
            if (url2 == null) {
                throw new IllegalArgumentException("url must not be null.");
            } else if (this.url == null) {
                this.url = url2;
                return this;
            } else {
                throw new IllegalStateException("url already set.");
            }
        }
    }

    public static TweetComposer getInstance() {
        if (instance == null) {
            synchronized (TweetComposer.class) {
                if (instance == null) {
                    instance = new TweetComposer();
                }
            }
        }
        return instance;
    }

    public String getIdentifier() {
        return "com.twitter.sdk.android:tweet-composer";
    }

    public String getVersion() {
        return "3.3.0.12";
    }
}
