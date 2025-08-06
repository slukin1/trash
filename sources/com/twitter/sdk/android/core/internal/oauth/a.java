package com.twitter.sdk.android.core.internal.oauth;

import okhttp3.Interceptor;
import okhttp3.Response;

public final /* synthetic */ class a implements Interceptor {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ OAuthService f51190a;

    public /* synthetic */ a(OAuthService oAuthService) {
        this.f51190a = oAuthService;
    }

    public final Response intercept(Interceptor.Chain chain) {
        return this.f51190a.lambda$new$0(chain);
    }
}
