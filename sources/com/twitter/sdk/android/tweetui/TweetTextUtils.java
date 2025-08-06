package com.twitter.sdk.android.tweetui;

import android.text.TextUtils;
import com.twitter.sdk.android.core.models.HashtagEntity;
import com.twitter.sdk.android.core.models.MediaEntity;
import com.twitter.sdk.android.core.models.MentionEntity;
import com.twitter.sdk.android.core.models.SymbolEntity;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.core.models.TweetEntities;
import com.twitter.sdk.android.core.models.UrlEntity;
import com.twitter.sdk.android.tweetui.internal.util.HtmlEntities;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class TweetTextUtils {
    private TweetTextUtils() {
    }

    public static void adjustEntitiesWithOffsets(List<? extends FormattedUrlEntity> list, List<Integer> list2) {
        if (list != null && list2 != null) {
            for (FormattedUrlEntity formattedUrlEntity : list) {
                int i11 = formattedUrlEntity.start;
                int i12 = 0;
                Iterator<Integer> it2 = list2.iterator();
                while (it2.hasNext() && it2.next().intValue() - i12 <= i11) {
                    i12++;
                }
                formattedUrlEntity.start += i12;
                formattedUrlEntity.end += i12;
            }
        }
    }

    public static void adjustIndicesForEscapedChars(List<? extends FormattedUrlEntity> list, List<int[]> list2) {
        if (list != null && list2 != null && !list2.isEmpty()) {
            int size = list2.size();
            int i11 = 0;
            int i12 = 0;
            for (FormattedUrlEntity formattedUrlEntity : list) {
                int i13 = 0;
                int i14 = i12;
                int i15 = i11;
                while (i11 < size) {
                    int[] iArr = list2.get(i11);
                    int i16 = iArr[0];
                    int i17 = iArr[1];
                    int i18 = i17 - i16;
                    if (i17 < formattedUrlEntity.start) {
                        i14 += i18;
                        i15++;
                    } else if (i17 < formattedUrlEntity.end) {
                        i13 += i18;
                    }
                    i11++;
                }
                int i19 = i13 + i14;
                formattedUrlEntity.start -= i19;
                formattedUrlEntity.end -= i19;
                i11 = i15;
                i12 = i14;
            }
        }
    }

    public static void adjustIndicesForSupplementaryChars(StringBuilder sb2, FormattedTweetText formattedTweetText) {
        ArrayList arrayList = new ArrayList();
        int length = sb2.length() - 1;
        for (int i11 = 0; i11 < length; i11++) {
            if (Character.isHighSurrogate(sb2.charAt(i11)) && Character.isLowSurrogate(sb2.charAt(i11 + 1))) {
                arrayList.add(Integer.valueOf(i11));
            }
        }
        adjustEntitiesWithOffsets(formattedTweetText.urlEntities, arrayList);
        adjustEntitiesWithOffsets(formattedTweetText.mediaEntities, arrayList);
        adjustEntitiesWithOffsets(formattedTweetText.hashtagEntities, arrayList);
        adjustEntitiesWithOffsets(formattedTweetText.mentionEntities, arrayList);
        adjustEntitiesWithOffsets(formattedTweetText.symbolEntities, arrayList);
    }

    public static void convertEntities(FormattedTweetText formattedTweetText, Tweet tweet) {
        TweetEntities tweetEntities = tweet.entities;
        if (tweetEntities != null) {
            List<UrlEntity> list = tweetEntities.urls;
            if (list != null) {
                for (UrlEntity createFormattedUrlEntity : list) {
                    formattedTweetText.urlEntities.add(FormattedUrlEntity.createFormattedUrlEntity(createFormattedUrlEntity));
                }
            }
            List<MediaEntity> list2 = tweet.entities.media;
            if (list2 != null) {
                for (MediaEntity formattedMediaEntity : list2) {
                    formattedTweetText.mediaEntities.add(new FormattedMediaEntity(formattedMediaEntity));
                }
            }
            List<HashtagEntity> list3 = tweet.entities.hashtags;
            if (list3 != null) {
                for (HashtagEntity createFormattedUrlEntity2 : list3) {
                    formattedTweetText.hashtagEntities.add(FormattedUrlEntity.createFormattedUrlEntity(createFormattedUrlEntity2));
                }
            }
            List<MentionEntity> list4 = tweet.entities.userMentions;
            if (list4 != null) {
                for (MentionEntity createFormattedUrlEntity3 : list4) {
                    formattedTweetText.mentionEntities.add(FormattedUrlEntity.createFormattedUrlEntity(createFormattedUrlEntity3));
                }
            }
            List<SymbolEntity> list5 = tweet.entities.symbols;
            if (list5 != null) {
                for (SymbolEntity createFormattedUrlEntity4 : list5) {
                    formattedTweetText.symbolEntities.add(FormattedUrlEntity.createFormattedUrlEntity(createFormattedUrlEntity4));
                }
            }
        }
    }

    public static void format(FormattedTweetText formattedTweetText, Tweet tweet) {
        if (!TextUtils.isEmpty(tweet.text)) {
            HtmlEntities.Unescaped unescape = HtmlEntities.HTML40.unescape(tweet.text);
            StringBuilder sb2 = new StringBuilder(unescape.unescaped);
            adjustIndicesForEscapedChars(formattedTweetText.urlEntities, unescape.indices);
            adjustIndicesForEscapedChars(formattedTweetText.mediaEntities, unescape.indices);
            adjustIndicesForEscapedChars(formattedTweetText.hashtagEntities, unescape.indices);
            adjustIndicesForEscapedChars(formattedTweetText.mentionEntities, unescape.indices);
            adjustIndicesForEscapedChars(formattedTweetText.symbolEntities, unescape.indices);
            adjustIndicesForSupplementaryChars(sb2, formattedTweetText);
            formattedTweetText.text = sb2.toString();
        }
    }

    public static FormattedTweetText formatTweetText(Tweet tweet) {
        if (tweet == null) {
            return null;
        }
        FormattedTweetText formattedTweetText = new FormattedTweetText();
        convertEntities(formattedTweetText, tweet);
        format(formattedTweetText, tweet);
        return formattedTweetText;
    }
}
