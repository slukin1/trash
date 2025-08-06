package com.twitter.sdk.android.tweetui;

import com.twitter.sdk.android.core.models.MediaEntity;

class FormattedMediaEntity extends FormattedUrlEntity {
    public final String mediaUrlHttps;
    public final String type;

    public FormattedMediaEntity(MediaEntity mediaEntity) {
        super(mediaEntity.getStart(), mediaEntity.getEnd(), mediaEntity.displayUrl, mediaEntity.url, mediaEntity.expandedUrl);
        this.type = mediaEntity.type;
        this.mediaUrlHttps = mediaEntity.mediaUrlHttps;
    }
}
