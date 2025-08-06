package com.twitter.sdk.android.core;

import com.twitter.sdk.android.core.internal.oauth.GuestAuthToken;
import com.twitter.sdk.android.core.internal.oauth.OAuth2Service;
import java.util.concurrent.CountDownLatch;

public class GuestSessionProvider {
    private final OAuth2Service oAuth2Service;
    /* access modifiers changed from: private */
    public final SessionManager<GuestSession> sessionManager;

    public GuestSessionProvider(OAuth2Service oAuth2Service2, SessionManager<GuestSession> sessionManager2) {
        this.oAuth2Service = oAuth2Service2;
        this.sessionManager = sessionManager2;
    }

    public synchronized GuestSession getCurrentSession() {
        GuestSession activeSession = this.sessionManager.getActiveSession();
        if (isSessionValid(activeSession)) {
            return activeSession;
        }
        refreshToken();
        return this.sessionManager.getActiveSession();
    }

    public boolean isSessionValid(GuestSession guestSession) {
        return (guestSession == null || guestSession.getAuthToken() == null || ((GuestAuthToken) guestSession.getAuthToken()).isExpired()) ? false : true;
    }

    public synchronized GuestSession refreshCurrentSession(GuestSession guestSession) {
        GuestSession activeSession = this.sessionManager.getActiveSession();
        if (guestSession != null && guestSession.equals(activeSession)) {
            refreshToken();
        }
        return this.sessionManager.getActiveSession();
    }

    public void refreshToken() {
        Twitter.getLogger().d("GuestSessionProvider", "Refreshing expired guest session.");
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        this.oAuth2Service.requestGuestAuthToken(new Callback<GuestAuthToken>() {
            public void failure(TwitterException twitterException) {
                GuestSessionProvider.this.sessionManager.clearSession(0);
                countDownLatch.countDown();
            }

            public void success(Result<GuestAuthToken> result) {
                GuestSessionProvider.this.sessionManager.setActiveSession(new GuestSession((GuestAuthToken) result.data));
                countDownLatch.countDown();
            }
        });
        try {
            countDownLatch.await();
        } catch (InterruptedException unused) {
            this.sessionManager.clearSession(0);
        }
    }
}
