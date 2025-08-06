package com.twitter.sdk.android.tweetui;

import java.util.ArrayList;
import java.util.List;

class FormattedTweetText {
    public final List<FormattedUrlEntity> hashtagEntities = new ArrayList();
    public final List<FormattedMediaEntity> mediaEntities = new ArrayList();
    public final List<FormattedUrlEntity> mentionEntities = new ArrayList();
    public final List<FormattedUrlEntity> symbolEntities = new ArrayList();
    public String text;
    public final List<FormattedUrlEntity> urlEntities = new ArrayList();
}
