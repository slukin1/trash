package com.twitter.sdk.android.tweetcomposer;

import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import android.text.TextUtils;
import com.twitter.Validator;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterApiClient;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.models.User;
import com.twitter.sdk.android.core.services.AccountService;
import com.twitter.sdk.android.tweetcomposer.ComposerActivity;

class ComposerController {
    public final ComposerView composerView;
    public final DependencyProvider dependencyProvider;
    public final ComposerActivity.Finisher finisher;
    public final Uri imageUri;
    public final TwitterSession session;

    public interface ComposerCallbacks {
        void onCloseClick();

        void onTextChanged(String str);

        void onTweetPost(String str);
    }

    public class ComposerCallbacksImpl implements ComposerCallbacks {
        public ComposerCallbacksImpl() {
        }

        public void onCloseClick() {
            ComposerController.this.onClose();
        }

        public void onTextChanged(String str) {
            int tweetTextLength = ComposerController.this.tweetTextLength(str);
            ComposerController.this.composerView.setCharCount(ComposerController.remainingCharCount(tweetTextLength));
            if (ComposerController.isTweetTextOverflow(tweetTextLength)) {
                ComposerController.this.composerView.setCharCountTextStyle(R.style.tw__ComposerCharCountOverflow);
            } else {
                ComposerController.this.composerView.setCharCountTextStyle(R.style.tw__ComposerCharCount);
            }
            ComposerController.this.composerView.postTweetEnabled(ComposerController.isPostEnabled(tweetTextLength));
        }

        public void onTweetPost(String str) {
            Intent intent = new Intent(ComposerController.this.composerView.getContext(), TweetUploadService.class);
            intent.putExtra("EXTRA_USER_TOKEN", (Parcelable) ComposerController.this.session.getAuthToken());
            intent.putExtra(TweetUploadService.EXTRA_TWEET_TEXT, str);
            intent.putExtra("EXTRA_IMAGE_URI", ComposerController.this.imageUri);
            ComposerController.this.composerView.getContext().startService(intent);
            ComposerController.this.finisher.finish();
        }
    }

    public static class DependencyProvider {
        public final Validator tweetValidator = new Validator();

        public TwitterApiClient getApiClient(TwitterSession twitterSession) {
            return TwitterCore.getInstance().getApiClient(twitterSession);
        }

        public Validator getTweetValidator() {
            return this.tweetValidator;
        }
    }

    public ComposerController(ComposerView composerView2, TwitterSession twitterSession, Uri uri, String str, String str2, ComposerActivity.Finisher finisher2) {
        this(composerView2, twitterSession, uri, str, str2, finisher2, new DependencyProvider());
    }

    public static boolean isPostEnabled(int i11) {
        return i11 > 0 && i11 <= 140;
    }

    public static boolean isTweetTextOverflow(int i11) {
        return i11 > 140;
    }

    public static int remainingCharCount(int i11) {
        return 140 - i11;
    }

    public String generateText(String str, String str2) {
        StringBuilder sb2 = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb2.append(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            if (sb2.length() > 0) {
                sb2.append(" ");
            }
            sb2.append(str2);
        }
        return sb2.toString();
    }

    public void onClose() {
        sendCancelBroadcast();
        this.finisher.finish();
    }

    public void sendCancelBroadcast() {
        Intent intent = new Intent(TweetUploadService.TWEET_COMPOSE_CANCEL);
        intent.setPackage(this.composerView.getContext().getPackageName());
        this.composerView.getContext().sendBroadcast(intent);
    }

    public void setImageView(Uri uri) {
        if (uri != null) {
            this.composerView.setImageView(uri);
        }
    }

    public void setProfilePhoto() {
        AccountService accountService = this.dependencyProvider.getApiClient(this.session).getAccountService();
        Boolean bool = Boolean.FALSE;
        accountService.verifyCredentials(bool, Boolean.TRUE, bool).enqueue(new Callback<User>() {
            public void failure(TwitterException twitterException) {
                ComposerController.this.composerView.setProfilePhotoView((User) null);
            }

            public void success(Result<User> result) {
                ComposerController.this.composerView.setProfilePhotoView((User) result.data);
            }
        });
    }

    public int tweetTextLength(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        return this.dependencyProvider.getTweetValidator().a(str);
    }

    public ComposerController(ComposerView composerView2, TwitterSession twitterSession, Uri uri, String str, String str2, ComposerActivity.Finisher finisher2, DependencyProvider dependencyProvider2) {
        this.composerView = composerView2;
        this.session = twitterSession;
        this.imageUri = uri;
        this.finisher = finisher2;
        this.dependencyProvider = dependencyProvider2;
        composerView2.setCallbacks(new ComposerCallbacksImpl());
        composerView2.setTweetText(generateText(str, str2));
        setProfilePhoto();
        setImageView(uri);
    }
}
