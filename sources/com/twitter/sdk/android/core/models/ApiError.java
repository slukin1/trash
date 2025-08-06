package com.twitter.sdk.android.core.models;

import com.google.gson.annotations.SerializedName;

public class ApiError {
    @SerializedName("code")
    public final int code;
    @SerializedName("message")
    public final String message;

    public ApiError(String str, int i11) {
        this.message = str;
        this.code = i11;
    }
}
