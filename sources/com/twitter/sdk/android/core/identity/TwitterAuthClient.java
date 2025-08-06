package com.twitter.sdk.android.core.identity;

import android.app.Activity;
import android.content.Intent;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Logger;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.Session;
import com.twitter.sdk.android.core.SessionManager;
import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterAuthException;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.models.User;
import com.twitter.sdk.android.core.services.AccountService;
import retrofit2.Response;

public class TwitterAuthClient {
    public final TwitterAuthConfig authConfig;
    public final AuthState authState;
    public final SessionManager<TwitterSession> sessionManager;
    public final TwitterCore twitterCore;

    public static class AuthStateLazyHolder {
        /* access modifiers changed from: private */
        public static final AuthState INSTANCE = new AuthState();

        private AuthStateLazyHolder() {
        }
    }

    public static class CallbackWrapper extends Callback<TwitterSession> {
        private final Callback<TwitterSession> callback;
        private final SessionManager<TwitterSession> sessionManager;

        public CallbackWrapper(SessionManager<TwitterSession> sessionManager2, Callback<TwitterSession> callback2) {
            this.sessionManager = sessionManager2;
            this.callback = callback2;
        }

        public void failure(TwitterException twitterException) {
            Twitter.getLogger().e("Twitter", "Authorization completed with an error", twitterException);
            this.callback.failure(twitterException);
        }

        public void success(Result<TwitterSession> result) {
            Twitter.getLogger().d("Twitter", "Authorization completed successfully");
            this.sessionManager.setActiveSession((Session) result.data);
            this.callback.success(result);
        }
    }

    public TwitterAuthClient() {
        this(TwitterCore.getInstance(), TwitterCore.getInstance().getAuthConfig(), TwitterCore.getInstance().getSessionManager(), AuthStateLazyHolder.INSTANCE);
    }

    private boolean authorizeUsingOAuth(Activity activity, CallbackWrapper callbackWrapper) {
        Twitter.getLogger().d("Twitter", "Using OAuth");
        AuthState authState2 = this.authState;
        TwitterAuthConfig twitterAuthConfig = this.authConfig;
        return authState2.beginAuthorize(activity, new OAuthHandler(twitterAuthConfig, callbackWrapper, twitterAuthConfig.getRequestCode()));
    }

    private boolean authorizeUsingSSO(Activity activity, CallbackWrapper callbackWrapper) {
        if (!SSOAuthHandler.isAvailable(activity)) {
            return false;
        }
        Twitter.getLogger().d("Twitter", "Using SSO");
        AuthState authState2 = this.authState;
        TwitterAuthConfig twitterAuthConfig = this.authConfig;
        return authState2.beginAuthorize(activity, new SSOAuthHandler(twitterAuthConfig, callbackWrapper, twitterAuthConfig.getRequestCode()));
    }

    private void handleAuthorize(Activity activity, Callback<TwitterSession> callback) {
        CallbackWrapper callbackWrapper = new CallbackWrapper(this.sessionManager, callback);
        if (!authorizeUsingSSO(activity, callbackWrapper) && !authorizeUsingOAuth(activity, callbackWrapper)) {
            callbackWrapper.failure(new TwitterAuthException("Authorize failed."));
        }
    }

    public void authorize(Activity activity, Callback<TwitterSession> callback) {
        if (activity == null) {
            throw new IllegalArgumentException("Activity must not be null.");
        } else if (callback == null) {
            throw new IllegalArgumentException("Callback must not be null.");
        } else if (activity.isFinishing()) {
            Twitter.getLogger().e("Twitter", "Cannot authorize, activity is finishing.", (Throwable) null);
        } else {
            handleAuthorize(activity, callback);
        }
    }

    public void cancelAuthorize() {
        this.authState.endAuthorize();
    }

    public int getRequestCode() {
        return this.authConfig.getRequestCode();
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        Logger logger = Twitter.getLogger();
        logger.d("Twitter", "onActivityResult called with " + i11 + " " + i12);
        if (!this.authState.isAuthorizeInProgress()) {
            Twitter.getLogger().e("Twitter", "Authorize not in progress", (Throwable) null);
            return;
        }
        AuthHandler authHandler = this.authState.getAuthHandler();
        if (authHandler != null && authHandler.handleOnActivityResult(i11, i12, intent)) {
            this.authState.endAuthorize();
        }
    }

    public void requestEmail(TwitterSession twitterSession, final Callback<String> callback) {
        AccountService accountService = this.twitterCore.getApiClient(twitterSession).getAccountService();
        Boolean bool = Boolean.FALSE;
        accountService.verifyCredentials(bool, bool, Boolean.TRUE).enqueue(new Callback<User>() {
            public void failure(TwitterException twitterException) {
                callback.failure(twitterException);
            }

            public void success(Result<User> result) {
                callback.success(new Result(((User) result.data).email, (Response) null));
            }
        });
    }

    public TwitterAuthClient(TwitterCore twitterCore2, TwitterAuthConfig twitterAuthConfig, SessionManager<TwitterSession> sessionManager2, AuthState authState2) {
        this.twitterCore = twitterCore2;
        this.authState = authState2;
        this.authConfig = twitterAuthConfig;
        this.sessionManager = sessionManager2;
    }
}
