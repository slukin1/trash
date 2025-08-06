package com.twitter.sdk.android.core.models;

import com.google.gson.annotations.SerializedName;

public class HashtagEntity extends Entity {
    @SerializedName("text")
    public final String text;

    public HashtagEntity(String str, int i11, int i12) {
        super(i11, i12);
        this.text = str;
    }

    public /* bridge */ /* synthetic */ int getEnd() {
        return super.getEnd();
    }

    public /* bridge */ /* synthetic */ int getStart() {
        return super.getStart();
    }
}
