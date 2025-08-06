package com.twitter.sdk.android.tweetui;

import com.twitter.sdk.android.core.models.Tweet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

final class Utils {
    private Utils() {
    }

    public static CharSequence charSeqOrDefault(CharSequence charSequence, CharSequence charSequence2) {
        return charSequence != null ? charSequence : charSequence2;
    }

    public static CharSequence charSeqOrEmpty(CharSequence charSequence) {
        return charSeqOrDefault(charSequence, "");
    }

    public static Long numberOrDefault(String str, long j11) {
        try {
            return Long.valueOf(Long.parseLong(str));
        } catch (NumberFormatException unused) {
            return Long.valueOf(j11);
        }
    }

    public static List<Tweet> orderTweets(List<Long> list, List<Tweet> list2) {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        for (Tweet next : list2) {
            hashMap.put(Long.valueOf(next.f51198id), next);
        }
        for (Long next2 : list) {
            if (hashMap.containsKey(next2)) {
                arrayList.add(hashMap.get(next2));
            }
        }
        return arrayList;
    }

    public static String stringOrDefault(String str, String str2) {
        return str != null ? str : str2;
    }

    public static String stringOrEmpty(String str) {
        return stringOrDefault(str, "");
    }
}
