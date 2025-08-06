package com.twitter.sdk.android.core.identity;

import android.app.Activity;
import com.twitter.sdk.android.core.Twitter;
import java.util.concurrent.atomic.AtomicReference;

class AuthState {
    public final AtomicReference<AuthHandler> authHandlerRef = new AtomicReference<>((Object) null);

    public boolean beginAuthorize(Activity activity, AuthHandler authHandler) {
        if (isAuthorizeInProgress()) {
            Twitter.getLogger().w("Twitter", "Authorize already in progress");
        } else if (authHandler.authorize(activity)) {
            boolean compareAndSet = this.authHandlerRef.compareAndSet((Object) null, authHandler);
            if (compareAndSet) {
                return compareAndSet;
            }
            Twitter.getLogger().w("Twitter", "Failed to update authHandler, authorize already in progress.");
            return compareAndSet;
        }
        return false;
    }

    public void endAuthorize() {
        this.authHandlerRef.set((Object) null);
    }

    public AuthHandler getAuthHandler() {
        return this.authHandlerRef.get();
    }

    public boolean isAuthorizeInProgress() {
        return this.authHandlerRef.get() != null;
    }
}
