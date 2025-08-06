package com.twitter.sdk.android.tweetui;

import com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.TIMMentionEditText;
import com.twitter.sdk.android.core.models.HashtagEntity;
import com.twitter.sdk.android.core.models.MentionEntity;
import com.twitter.sdk.android.core.models.SymbolEntity;
import com.twitter.sdk.android.core.models.UrlEntity;

class FormattedUrlEntity {
    public final String displayUrl;
    public int end;
    public final String expandedUrl;
    public int start;
    public final String url;

    public FormattedUrlEntity(int i11, int i12, String str, String str2, String str3) {
        this.start = i11;
        this.end = i12;
        this.displayUrl = str;
        this.url = str2;
        this.expandedUrl = str3;
    }

    public static FormattedUrlEntity createFormattedUrlEntity(UrlEntity urlEntity) {
        return new FormattedUrlEntity(urlEntity.getStart(), urlEntity.getEnd(), urlEntity.displayUrl, urlEntity.url, urlEntity.expandedUrl);
    }

    public static FormattedUrlEntity createFormattedUrlEntity(HashtagEntity hashtagEntity) {
        String hashtagPermalink = TweetUtils.getHashtagPermalink(hashtagEntity.text);
        int start2 = hashtagEntity.getStart();
        int end2 = hashtagEntity.getEnd();
        return new FormattedUrlEntity(start2, end2, "#" + hashtagEntity.text, hashtagPermalink, hashtagPermalink);
    }

    public static FormattedUrlEntity createFormattedUrlEntity(MentionEntity mentionEntity) {
        String profilePermalink = TweetUtils.getProfilePermalink(mentionEntity.screenName);
        int start2 = mentionEntity.getStart();
        int end2 = mentionEntity.getEnd();
        return new FormattedUrlEntity(start2, end2, TIMMentionEditText.TIM_MENTION_TAG + mentionEntity.screenName, profilePermalink, profilePermalink);
    }

    public static FormattedUrlEntity createFormattedUrlEntity(SymbolEntity symbolEntity) {
        String symbolPermalink = TweetUtils.getSymbolPermalink(symbolEntity.text);
        int start2 = symbolEntity.getStart();
        int end2 = symbolEntity.getEnd();
        return new FormattedUrlEntity(start2, end2, "$" + symbolEntity.text, symbolPermalink, symbolPermalink);
    }
}
