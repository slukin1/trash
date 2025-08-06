package com.twitter.sdk.android.core;

import android.text.TextUtils;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.twitter.sdk.android.core.models.ApiError;
import com.twitter.sdk.android.core.models.ApiErrors;
import com.twitter.sdk.android.core.models.SafeListAdapter;
import com.twitter.sdk.android.core.models.SafeMapAdapter;
import retrofit2.Response;

public class TwitterApiException extends TwitterException {
    public static final int DEFAULT_ERROR_CODE = 0;
    private final ApiError apiError;
    private final int code;
    private final Response response;
    private final TwitterRateLimit twitterRateLimit;

    public TwitterApiException(Response response2) {
        this(response2, readApiError(response2), readApiRateLimit(response2), response2.code());
    }

    public static String createExceptionMessage(int i11) {
        return "HTTP request failed, Status: " + i11;
    }

    public static ApiError parseApiError(String str) {
        try {
            ApiErrors apiErrors = (ApiErrors) new GsonBuilder().registerTypeAdapterFactory(new SafeListAdapter()).registerTypeAdapterFactory(new SafeMapAdapter()).create().fromJson(str, ApiErrors.class);
            if (!apiErrors.errors.isEmpty()) {
                return apiErrors.errors.get(0);
            }
            return null;
        } catch (JsonSyntaxException e11) {
            Logger logger = Twitter.getLogger();
            logger.e("Twitter", "Invalid json: " + str, e11);
            return null;
        }
    }

    public static ApiError readApiError(Response response2) {
        try {
            String readUtf8 = response2.errorBody().source().buffer().clone().readUtf8();
            if (!TextUtils.isEmpty(readUtf8)) {
                return parseApiError(readUtf8);
            }
            return null;
        } catch (Exception e11) {
            Twitter.getLogger().e("Twitter", "Unexpected response", e11);
            return null;
        }
    }

    public static TwitterRateLimit readApiRateLimit(Response response2) {
        return new TwitterRateLimit(response2.headers());
    }

    public int getErrorCode() {
        ApiError apiError2 = this.apiError;
        if (apiError2 == null) {
            return 0;
        }
        return apiError2.code;
    }

    public String getErrorMessage() {
        ApiError apiError2 = this.apiError;
        if (apiError2 == null) {
            return null;
        }
        return apiError2.message;
    }

    public Response getResponse() {
        return this.response;
    }

    public int getStatusCode() {
        return this.code;
    }

    public TwitterRateLimit getTwitterRateLimit() {
        return this.twitterRateLimit;
    }

    public TwitterApiException(Response response2, ApiError apiError2, TwitterRateLimit twitterRateLimit2, int i11) {
        super(createExceptionMessage(i11));
        this.apiError = apiError2;
        this.twitterRateLimit = twitterRateLimit2;
        this.code = i11;
        this.response = response2;
    }
}
