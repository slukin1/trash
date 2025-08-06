package com.twitter.sdk.android.core.internal.network;

import com.twitter.sdk.android.core.GuestSession;
import com.twitter.sdk.android.core.GuestSessionProvider;
import com.twitter.sdk.android.core.internal.oauth.GuestAuthToken;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class GuestAuthInterceptor implements Interceptor {
    public final GuestSessionProvider guestSessionProvider;

    public GuestAuthInterceptor(GuestSessionProvider guestSessionProvider2) {
        this.guestSessionProvider = guestSessionProvider2;
    }

    public static void addAuthHeaders(Request.Builder builder, GuestAuthToken guestAuthToken) {
        builder.header("Authorization", guestAuthToken.getTokenType() + " " + guestAuthToken.getAccessToken());
        builder.header("x-guest-token", guestAuthToken.getGuestToken());
    }

    public Response intercept(Interceptor.Chain chain) throws IOException {
        GuestAuthToken guestAuthToken;
        Request request = chain.request();
        GuestSession currentSession = this.guestSessionProvider.getCurrentSession();
        if (currentSession == null) {
            guestAuthToken = null;
        } else {
            guestAuthToken = (GuestAuthToken) currentSession.getAuthToken();
        }
        if (guestAuthToken == null) {
            return chain.proceed(request);
        }
        Request.Builder newBuilder = request.newBuilder();
        addAuthHeaders(newBuilder, guestAuthToken);
        return chain.proceed(newBuilder.build());
    }
}
