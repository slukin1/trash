package com.twitter.sdk.android.core.internal.oauth;

import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.internal.TwitterApi;
import com.twitter.sdk.android.core.internal.network.OkHttpClientHelper;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

abstract class OAuthService {
    private static final String CLIENT_NAME = "TwitterAndroidSDK";
    private final TwitterApi api;
    private final Retrofit retrofit = new Retrofit.Builder().baseUrl(getApi().getBaseHostUrl()).client(new OkHttpClient.Builder().addInterceptor(new a(this)).certificatePinner(OkHttpClientHelper.getCertificatePinner()).build()).addConverterFactory(GsonConverterFactory.create()).build();
    private final TwitterCore twitterCore;
    private final String userAgent;

    public OAuthService(TwitterCore twitterCore2, TwitterApi twitterApi) {
        this.twitterCore = twitterCore2;
        this.api = twitterApi;
        this.userAgent = TwitterApi.buildUserAgent(CLIENT_NAME, twitterCore2.getVersion());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Response lambda$new$0(Interceptor.Chain chain) throws IOException {
        return chain.proceed(chain.request().newBuilder().header("User-Agent", getUserAgent()).build());
    }

    public TwitterApi getApi() {
        return this.api;
    }

    public Retrofit getRetrofit() {
        return this.retrofit;
    }

    public TwitterCore getTwitterCore() {
        return this.twitterCore;
    }

    public String getUserAgent() {
        return this.userAgent;
    }
}
