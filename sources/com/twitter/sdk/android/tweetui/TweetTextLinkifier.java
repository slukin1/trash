package com.twitter.sdk.android.tweetui;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.twitter.sdk.android.core.models.ModelUtils;
import com.twitter.sdk.android.tweetui.internal.ClickableLinkSpan;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

final class TweetTextLinkifier {
    public static final Pattern QUOTED_STATUS_URL = Pattern.compile("^https?://twitter\\.com(/#!)?/\\w+/status/\\d+$");
    public static final Pattern VINE_URL = Pattern.compile("^https?://vine\\.co(/#!)?/v/\\w+$");

    private TweetTextLinkifier() {
    }

    private static void addUrlEntities(SpannableStringBuilder spannableStringBuilder, List<FormattedUrlEntity> list, FormattedUrlEntity formattedUrlEntity, LinkClickListener linkClickListener, int i11, int i12) {
        if (list != null && !list.isEmpty()) {
            int i13 = 0;
            for (final FormattedUrlEntity next : list) {
                int i14 = next.start - i13;
                int i15 = next.end - i13;
                if (i14 >= 0 && i15 <= spannableStringBuilder.length()) {
                    if (formattedUrlEntity != null && formattedUrlEntity.start == next.start) {
                        spannableStringBuilder.replace(i14, i15, "");
                        i13 += i15 - i14;
                    } else if (!TextUtils.isEmpty(next.displayUrl)) {
                        spannableStringBuilder.replace(i14, i15, next.displayUrl);
                        int length = i15 - (next.displayUrl.length() + i14);
                        i13 += length;
                        final LinkClickListener linkClickListener2 = linkClickListener;
                        spannableStringBuilder.setSpan(new ClickableLinkSpan(i12, i11, false) {
                            @SensorsDataInstrumented
                            public void onClick(View view) {
                                LinkClickListener linkClickListener = linkClickListener2;
                                if (linkClickListener == null) {
                                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                                    return;
                                }
                                linkClickListener.onUrlClicked(next.url);
                                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                            }
                        }, i14, i15 - length, 33);
                    }
                }
            }
        }
    }

    public static FormattedUrlEntity getEntityToStrip(String str, List<FormattedUrlEntity> list, boolean z11, boolean z12) {
        if (list.isEmpty()) {
            return null;
        }
        FormattedUrlEntity formattedUrlEntity = list.get(list.size() - 1);
        if (!stripLtrMarker(str).endsWith(formattedUrlEntity.url) || (!isPhotoEntity(formattedUrlEntity) && ((!z11 || !isQuotedStatus(formattedUrlEntity)) && (!z12 || !isVineCard(formattedUrlEntity))))) {
            return null;
        }
        return formattedUrlEntity;
    }

    public static boolean isPhotoEntity(FormattedUrlEntity formattedUrlEntity) {
        return (formattedUrlEntity instanceof FormattedMediaEntity) && "photo".equals(((FormattedMediaEntity) formattedUrlEntity).type);
    }

    public static boolean isQuotedStatus(FormattedUrlEntity formattedUrlEntity) {
        return QUOTED_STATUS_URL.matcher(formattedUrlEntity.expandedUrl).find();
    }

    public static boolean isVineCard(FormattedUrlEntity formattedUrlEntity) {
        return VINE_URL.matcher(formattedUrlEntity.expandedUrl).find();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ int lambda$mergeAndSortEntities$0(FormattedUrlEntity formattedUrlEntity, FormattedUrlEntity formattedUrlEntity2) {
        if (formattedUrlEntity == null && formattedUrlEntity2 != null) {
            return -1;
        }
        if (formattedUrlEntity != null && formattedUrlEntity2 == null) {
            return 1;
        }
        if (formattedUrlEntity == null && formattedUrlEntity2 == null) {
            return 0;
        }
        int i11 = formattedUrlEntity.start;
        int i12 = formattedUrlEntity2.start;
        if (i11 < i12) {
            return -1;
        }
        return i11 > i12 ? 1 : 0;
    }

    public static CharSequence linkifyUrls(FormattedTweetText formattedTweetText, LinkClickListener linkClickListener, int i11, int i12, boolean z11, boolean z12) {
        if (formattedTweetText == null) {
            return null;
        }
        if (TextUtils.isEmpty(formattedTweetText.text)) {
            return formattedTweetText.text;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(formattedTweetText.text);
        List<FormattedUrlEntity> mergeAndSortEntities = mergeAndSortEntities(ModelUtils.getSafeList(formattedTweetText.urlEntities), ModelUtils.getSafeList(formattedTweetText.mediaEntities), ModelUtils.getSafeList(formattedTweetText.hashtagEntities), ModelUtils.getSafeList(formattedTweetText.mentionEntities), ModelUtils.getSafeList(formattedTweetText.symbolEntities));
        addUrlEntities(spannableStringBuilder, mergeAndSortEntities, getEntityToStrip(formattedTweetText.text, mergeAndSortEntities, z11, z12), linkClickListener, i11, i12);
        return trimEnd(spannableStringBuilder);
    }

    public static List<FormattedUrlEntity> mergeAndSortEntities(List<FormattedUrlEntity> list, List<FormattedMediaEntity> list2, List<FormattedUrlEntity> list3, List<FormattedUrlEntity> list4, List<FormattedUrlEntity> list5) {
        ArrayList arrayList = new ArrayList(list);
        arrayList.addAll(list2);
        arrayList.addAll(list3);
        arrayList.addAll(list4);
        arrayList.addAll(list5);
        Collections.sort(arrayList, l.f51240b);
        return arrayList;
    }

    public static String stripLtrMarker(String str) {
        return str.endsWith(Character.toString(8206)) ? str.substring(0, str.length() - 1) : str;
    }

    public static CharSequence trimEnd(CharSequence charSequence) {
        int length = charSequence.length();
        while (length > 0 && charSequence.charAt(length - 1) <= ' ') {
            length--;
        }
        return length < charSequence.length() ? charSequence.subSequence(0, length) : charSequence;
    }
}
