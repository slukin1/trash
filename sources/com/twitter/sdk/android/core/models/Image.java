package com.twitter.sdk.android.core.models;

import com.google.gson.annotations.SerializedName;

public class Image {
    @SerializedName("h")

    /* renamed from: h  reason: collision with root package name */
    public final int f51191h;
    @SerializedName("image_type")
    public final String imageType;
    @SerializedName("w")

    /* renamed from: w  reason: collision with root package name */
    public final int f51192w;

    public Image(int i11, int i12, String str) {
        this.f51192w = i11;
        this.f51191h = i12;
        this.imageType = str;
    }
}
