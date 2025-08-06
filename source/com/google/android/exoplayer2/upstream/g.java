package com.google.android.exoplayer2.upstream;

import android.text.TextUtils;
import com.google.common.base.Ascii;
import com.google.common.base.Predicate;

public final /* synthetic */ class g {
    static {
        Predicate<String> predicate = HttpDataSource.REJECT_PAYWALL_TYPES;
    }

    public static /* synthetic */ boolean b(String str) {
        if (str == null) {
            return false;
        }
        String lowerCase = Ascii.toLowerCase(str);
        if (TextUtils.isEmpty(lowerCase)) {
            return false;
        }
        if ((!lowerCase.contains("text") || lowerCase.contains("text/vtt")) && !lowerCase.contains("html") && !lowerCase.contains("xml")) {
            return true;
        }
        return false;
    }
}
