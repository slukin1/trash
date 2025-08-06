package com.twitter.sdk.android.core.internal;

import com.twitter.sdk.android.core.TwitterApiClient;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.services.AccountService;
import java.io.IOException;

public class TwitterSessionVerifier implements SessionVerifier<TwitterSession> {
    private final AccountServiceProvider accountServiceProvider;

    public static class AccountServiceProvider {
        public AccountService getAccountService(TwitterSession twitterSession) {
            return new TwitterApiClient(twitterSession).getAccountService();
        }
    }

    public TwitterSessionVerifier() {
        this(new AccountServiceProvider());
    }

    public TwitterSessionVerifier(AccountServiceProvider accountServiceProvider2) {
        this.accountServiceProvider = accountServiceProvider2;
    }

    public void verifySession(TwitterSession twitterSession) {
        AccountService accountService = this.accountServiceProvider.getAccountService(twitterSession);
        try {
            Boolean bool = Boolean.TRUE;
            Boolean bool2 = Boolean.FALSE;
            accountService.verifyCredentials(bool, bool2, bool2).execute();
        } catch (IOException | RuntimeException unused) {
        }
    }
}
