package com.twitter.sdk.android.tweetui;

import android.text.TextUtils;
import com.twitter.sdk.android.core.models.HashtagEntity;
import com.twitter.sdk.android.core.models.MentionEntity;
import com.twitter.sdk.android.core.models.SymbolEntity;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.core.models.TweetEntities;
import com.twitter.sdk.android.core.models.UrlEntity;
import com.twitter.sdk.android.core.models.User;
import java.net.IDN;
import java.text.BreakIterator;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;
import okhttp3.HttpUrl;

public class BasicTimelineFilter implements TimelineFilter {
    private final Set<String> handleConstraints;
    private final Set<String> hashTagConstraints;
    private final Set<String> keywordConstraints;
    private final Set<String> urlConstraints;
    private final BreakIterator wordIterator;

    public static class IgnoreCaseComparator implements Comparator<String> {
        private final Collator collator;

        public IgnoreCaseComparator(Locale locale) {
            Collator instance = Collator.getInstance(locale);
            this.collator = instance;
            instance.setStrength(0);
        }

        public int compare(String str, String str2) {
            return this.collator.compare(str, str2);
        }
    }

    public BasicTimelineFilter(FilterValues filterValues) {
        this(filterValues, Locale.getDefault());
    }

    public static String normalizeHandle(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        char charAt = str.charAt(0);
        if (charAt == '@' || charAt == 65312) {
            str = str.substring(1, str.length());
        }
        return str.toLowerCase(Locale.US);
    }

    public static String normalizeHashtag(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        char charAt = str.charAt(0);
        return (charAt == '#' || charAt == 65283 || charAt == '$') ? str.substring(1, str.length()) : str;
    }

    public static String normalizeUrl(String str) {
        try {
            HttpUrl parse = HttpUrl.parse(str);
            if (parse != null) {
                if (parse.host() != null) {
                    return parse.host().toLowerCase(Locale.US);
                }
            }
            return IDN.toASCII(str).toLowerCase(Locale.US);
        } catch (IllegalArgumentException unused) {
            return str;
        }
    }

    public boolean containsMatchingHashtag(List<HashtagEntity> list) {
        for (HashtagEntity hashtagEntity : list) {
            if (this.hashTagConstraints.contains(hashtagEntity.text)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsMatchingMention(List<MentionEntity> list) {
        for (MentionEntity mentionEntity : list) {
            if (this.handleConstraints.contains(normalizeHandle(mentionEntity.screenName))) {
                return true;
            }
        }
        return false;
    }

    public boolean containsMatchingScreenName(String str) {
        return this.handleConstraints.contains(normalizeHandle(str));
    }

    public boolean containsMatchingSymbol(List<SymbolEntity> list) {
        for (SymbolEntity symbolEntity : list) {
            if (this.hashTagConstraints.contains(symbolEntity.text)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsMatchingText(Tweet tweet) {
        this.wordIterator.setText(tweet.text);
        int first = this.wordIterator.first();
        int next = this.wordIterator.next();
        while (true) {
            int i11 = next;
            int i12 = first;
            first = i11;
            if (first == -1) {
                return false;
            }
            if (this.keywordConstraints.contains(tweet.text.substring(i12, first))) {
                return true;
            }
            next = this.wordIterator.next();
        }
    }

    public boolean containsMatchingUrl(List<UrlEntity> list) {
        for (UrlEntity urlEntity : list) {
            if (this.urlConstraints.contains(normalizeUrl(urlEntity.expandedUrl))) {
                return true;
            }
        }
        return false;
    }

    public List<Tweet> filter(List<Tweet> list) {
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < list.size(); i11++) {
            Tweet tweet = list.get(i11);
            if (!shouldFilterTweet(tweet)) {
                arrayList.add(tweet);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public boolean shouldFilterTweet(Tweet tweet) {
        User user = tweet.user;
        if (user != null && containsMatchingScreenName(user.screenName)) {
            return true;
        }
        TweetEntities tweetEntities = tweet.entities;
        if (tweetEntities == null || (!containsMatchingHashtag(tweetEntities.hashtags) && !containsMatchingSymbol(tweet.entities.symbols) && !containsMatchingUrl(tweet.entities.urls) && !containsMatchingMention(tweet.entities.userMentions))) {
            return containsMatchingText(tweet);
        }
        return true;
    }

    public int totalFilters() {
        return this.keywordConstraints.size() + this.hashTagConstraints.size() + this.urlConstraints.size() + this.handleConstraints.size();
    }

    public BasicTimelineFilter(FilterValues filterValues, Locale locale) {
        IgnoreCaseComparator ignoreCaseComparator = new IgnoreCaseComparator(locale);
        this.wordIterator = BreakIterator.getWordInstance(locale);
        TreeSet treeSet = new TreeSet(ignoreCaseComparator);
        this.keywordConstraints = treeSet;
        treeSet.addAll(filterValues.keywords);
        this.hashTagConstraints = new TreeSet(ignoreCaseComparator);
        for (String normalizeHashtag : filterValues.hashtags) {
            this.hashTagConstraints.add(normalizeHashtag(normalizeHashtag));
        }
        this.handleConstraints = new HashSet(filterValues.handles.size());
        for (String normalizeHandle : filterValues.handles) {
            this.handleConstraints.add(normalizeHandle(normalizeHandle));
        }
        this.urlConstraints = new HashSet(filterValues.urls.size());
        for (String normalizeUrl : filterValues.urls) {
            this.urlConstraints.add(normalizeUrl(normalizeUrl));
        }
    }
}
