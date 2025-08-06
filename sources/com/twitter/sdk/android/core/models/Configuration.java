package com.twitter.sdk.android.core.models;

import com.google.gson.annotations.SerializedName;
import com.twitter.sdk.android.core.models.MediaEntity;
import java.util.List;

public class Configuration {
    @SerializedName("dm_text_character_limit")
    public final int dmTextCharacterLimit;
    @SerializedName("non_username_paths")
    public final List<String> nonUsernamePaths;
    @SerializedName("photo_size_limit")
    public final long photoSizeLimit;
    @SerializedName("photo_sizes")
    public final MediaEntity.Sizes photoSizes;
    @SerializedName("short_url_length_https")
    public final int shortUrlLengthHttps;

    private Configuration() {
        this(0, (List<String>) null, 0, (MediaEntity.Sizes) null, 0);
    }

    public Configuration(int i11, List<String> list, long j11, MediaEntity.Sizes sizes, int i12) {
        this.dmTextCharacterLimit = i11;
        this.nonUsernamePaths = ModelUtils.getSafeList(list);
        this.photoSizeLimit = j11;
        this.photoSizes = sizes;
        this.shortUrlLengthHttps = i12;
    }
}
