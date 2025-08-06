package com.zopim.android.sdk.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Agent {
    @SerializedName("avatar_path$string")
    @Expose
    private String avatarUri;
    @SerializedName("display_name$string")
    @Expose
    private String displayName;
    @SerializedName("typing$bool")
    @Expose
    private Boolean isTyping;

    public String getAvatarUri() {
        return this.avatarUri;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public Boolean isTyping() {
        return this.isTyping;
    }

    public String toString() {
        return this.displayName + ", typing: " + this.isTyping;
    }
}
