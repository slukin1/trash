package com.twitter.sdk.android.core.models;

import com.google.gson.annotations.SerializedName;

public class MentionEntity extends Entity {
    @SerializedName("id")

    /* renamed from: id  reason: collision with root package name */
    public final long f51196id;
    @SerializedName("id_str")
    public final String idStr;
    @SerializedName("name")
    public final String name;
    @SerializedName("screen_name")
    public final String screenName;

    public MentionEntity(long j11, String str, String str2, String str3, int i11, int i12) {
        super(i11, i12);
        this.f51196id = j11;
        this.idStr = str;
        this.name = str2;
        this.screenName = str3;
    }

    public /* bridge */ /* synthetic */ int getEnd() {
        return super.getEnd();
    }

    public /* bridge */ /* synthetic */ int getStart() {
        return super.getStart();
    }
}
