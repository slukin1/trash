package com.twitter.sdk.android.core.models;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class MediaEntity extends UrlEntity {
    @SerializedName("ext_alt_text")
    public final String altText;
    @SerializedName("id")

    /* renamed from: id  reason: collision with root package name */
    public final long f51193id;
    @SerializedName("id_str")
    public final String idStr;
    @SerializedName("media_url")
    public final String mediaUrl;
    @SerializedName("media_url_https")
    public final String mediaUrlHttps;
    @SerializedName("sizes")
    public final Sizes sizes;
    @SerializedName("source_status_id")
    public final long sourceStatusId;
    @SerializedName("source_status_id_str")
    public final String sourceStatusIdStr;
    @SerializedName("type")
    public final String type;
    @SerializedName("video_info")
    public final VideoInfo videoInfo;

    public static class Size implements Serializable {
        @SerializedName("h")

        /* renamed from: h  reason: collision with root package name */
        public final int f51194h;
        @SerializedName("resize")
        public final String resize;
        @SerializedName("w")

        /* renamed from: w  reason: collision with root package name */
        public final int f51195w;

        public Size(int i11, int i12, String str) {
            this.f51195w = i11;
            this.f51194h = i12;
            this.resize = str;
        }
    }

    public static class Sizes implements Serializable {
        @SerializedName("large")
        public final Size large;
        @SerializedName("medium")
        public final Size medium;
        @SerializedName("small")
        public final Size small;
        @SerializedName("thumb")
        public final Size thumb;

        public Sizes(Size size, Size size2, Size size3, Size size4) {
            this.thumb = size;
            this.small = size2;
            this.medium = size3;
            this.large = size4;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MediaEntity(String str, String str2, String str3, int i11, int i12, long j11, String str4, String str5, String str6, Sizes sizes2, long j12, String str7, String str8, VideoInfo videoInfo2, String str9) {
        super(str, str2, str3, i11, i12);
        this.f51193id = j11;
        this.idStr = str4;
        this.mediaUrl = str5;
        this.mediaUrlHttps = str6;
        this.sizes = sizes2;
        this.sourceStatusId = j12;
        this.sourceStatusIdStr = str7;
        this.type = str8;
        this.videoInfo = videoInfo2;
        this.altText = str9;
    }
}
