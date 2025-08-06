package com.twitter.sdk.android.core.models;

import com.google.gson.annotations.SerializedName;

public class SearchMetadata {
    @SerializedName("completed_in")
    public final double completedIn;
    @SerializedName("count")
    public final long count;
    @SerializedName("max_id")
    public final long maxId;
    @SerializedName("max_id_str")
    public final String maxIdStr;
    @SerializedName("next_results")
    public final String nextResults;
    @SerializedName("query")
    public final String query;
    @SerializedName("refresh_url")
    public final String refreshUrl;
    @SerializedName("since_id")
    public final long sinceId;
    @SerializedName("since_id_str")
    public final String sinceIdStr;

    public SearchMetadata(int i11, int i12, String str, String str2, int i13, double d11, String str3, String str4, String str5) {
        this.maxId = (long) i11;
        this.sinceId = (long) i12;
        this.refreshUrl = str;
        this.nextResults = str2;
        this.count = (long) i13;
        this.completedIn = d11;
        this.sinceIdStr = str3;
        this.query = str4;
        this.maxIdStr = str5;
    }
}
